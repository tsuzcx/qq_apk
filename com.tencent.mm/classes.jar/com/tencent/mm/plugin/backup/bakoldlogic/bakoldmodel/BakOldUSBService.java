package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakOldUSBService
  extends MMService
  implements com.tencent.mm.al.f
{
  private int nAJ = -1;
  private boolean nyu = false;
  
  private boolean bJg()
  {
    return (this.nAJ == 0) || (this.nAJ == 1);
  }
  
  public final IBinder WQ()
  {
    AppMethodBeat.i(21812);
    ad.i("MicroMsg.BakOldUSBService", "onBind()");
    AppMethodBeat.o(21812);
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.BakOldUSBService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(21813);
    ad.i("MicroMsg.BakOldUSBService", "onCreate()");
    super.onCreate();
    ba.aiU().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(21813);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21815);
    ba.aiU().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    ad.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
    AppMethodBeat.o(21815);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(21816);
    String str;
    if (paramn == null)
    {
      str = "";
      ad.i("MicroMsg.BakOldUSBService", "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str, Integer.valueOf(this.nAJ) });
      if (!(paramn instanceof com.tencent.mm.plugin.backup.g.b)) {
        break label257;
      }
      ad.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(this.nAJ) });
      if ((paramn.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        if (bJg()) {
          break label251;
        }
      }
    }
    label251:
    for (boolean bool = true;; bool = false)
    {
      paramString.putExtra("newPCBackup", bool);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      stopSelf();
      AppMethodBeat.o(21816);
      return;
      str = paramn.getClass().getSimpleName();
      break;
    }
    label257:
    if ((paramn instanceof com.tencent.mm.plugin.backup.bakoldlogic.c.f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.backup.bakoldlogic.c.f)paramn).bJB();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().nsB = paramString.ID;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().nsC = paramString.FAG;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().nsD = paramString.FAH;
        this.nAJ = paramString.Scene;
        ad.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", new Object[] { Integer.valueOf(paramString.nEf), Integer.valueOf(paramString.Scene), Boolean.valueOf(this.nyu) });
        if ((!this.nyu) && (paramString.nEf == 1))
        {
          ad.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(21816);
          return;
        }
        if (bJg())
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().ex(paramString.FAz, paramString.FAA);
          com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj());
          com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJl());
          com.tencent.mm.plugin.backup.g.b.xq(1);
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJl().f(paramString.nEf, paramString.FAy);
          AppMethodBeat.o(21816);
          return;
        }
        ad.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", new Object[] { Integer.valueOf(this.nAJ) });
        AppMethodBeat.o(21816);
        return;
      }
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJk().nBa = 2;
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJk().aCy();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label554;
      }
      ad.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
    }
    for (;;)
    {
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj();
      e.bJs();
      stopSelf();
      AppMethodBeat.o(21816);
      return;
      label554:
      ad.i("MicroMsg.BakOldUSBService", "getConnect info other error");
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(21814);
    ad.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", new Object[] { Integer.valueOf(this.nAJ) });
    if (paramIntent == null)
    {
      ad.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
      AppMethodBeat.o(21814);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(21814);
      return 2;
    }
    this.nyu = paramIntent.getBooleanExtra("isFromWifi", false);
    ad.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.nyu) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJk().aCy();
    paramIntent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJk();
    if (this.nyu) {
      paramInt1 = 2;
    }
    paramIntent.nAZ = paramInt1;
    if (!ba.aBR())
    {
      ad.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahp(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21814);
      return 2;
    }
    paramIntent = new com.tencent.mm.plugin.backup.bakoldlogic.c.f(str);
    ba.aiU().a(paramIntent, 0);
    AppMethodBeat.o(21814);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakOldUSBService
  extends MMService
  implements com.tencent.mm.ak.f
{
  private boolean nDP = false;
  private int nGe = -1;
  
  private boolean bKe()
  {
    return (this.nGe == 0) || (this.nGe == 1);
  }
  
  public final IBinder WY()
  {
    AppMethodBeat.i(21812);
    ae.i("MicroMsg.BakOldUSBService", "onBind()");
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
    ae.i("MicroMsg.BakOldUSBService", "onCreate()");
    super.onCreate();
    bc.ajj().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(21813);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21815);
    bc.ajj().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    ae.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
    AppMethodBeat.o(21815);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(21816);
    String str;
    if (paramn == null)
    {
      str = "";
      ae.i("MicroMsg.BakOldUSBService", "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str, Integer.valueOf(this.nGe) });
      if (!(paramn instanceof com.tencent.mm.plugin.backup.g.b)) {
        break label257;
      }
      ae.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(this.nGe) });
      if ((paramn.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(ak.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        if (bKe()) {
          break label251;
        }
      }
    }
    label251:
    for (boolean bool = true;; bool = false)
    {
      paramString.putExtra("newPCBackup", bool);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.mt(0));
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
        paramString = ((com.tencent.mm.plugin.backup.bakoldlogic.c.f)paramn).bKz();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().nxW = paramString.ID;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().nxX = paramString.FTc;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().nxY = paramString.FTd;
        this.nGe = paramString.Scene;
        ae.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", new Object[] { Integer.valueOf(paramString.nJA), Integer.valueOf(paramString.Scene), Boolean.valueOf(this.nDP) });
        if ((!this.nDP) && (paramString.nJA == 1))
        {
          ae.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(21816);
          return;
        }
        if (bKe())
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKh().eA(paramString.FSV, paramString.FSW);
          com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKh());
          com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKj());
          com.tencent.mm.plugin.backup.g.b.xv(1);
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKj().f(paramString.nJA, paramString.FSU);
          AppMethodBeat.o(21816);
          return;
        }
        ae.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", new Object[] { Integer.valueOf(this.nGe) });
        AppMethodBeat.o(21816);
        return;
      }
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKi().nGv = 2;
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKi().aCO();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label554;
      }
      ae.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
    }
    for (;;)
    {
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKh();
      e.bKq();
      stopSelf();
      AppMethodBeat.o(21816);
      return;
      label554:
      ae.i("MicroMsg.BakOldUSBService", "getConnect info other error");
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(21814);
    ae.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", new Object[] { Integer.valueOf(this.nGe) });
    if (paramIntent == null)
    {
      ae.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
      AppMethodBeat.o(21814);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(21814);
      return 2;
    }
    this.nDP = paramIntent.getBooleanExtra("isFromWifi", false);
    ae.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.nDP) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKi().aCO();
    paramIntent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKi();
    if (this.nDP) {
      paramInt1 = 2;
    }
    paramIntent.nGu = paramInt1;
    if (!bc.aCh())
    {
      ae.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(ak.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahE(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21814);
      return 2;
    }
    paramIntent = new com.tencent.mm.plugin.backup.bakoldlogic.c.f(str);
    bc.ajj().a(paramIntent, 0);
    AppMethodBeat.o(21814);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService
 * JD-Core Version:    0.7.0.1
 */
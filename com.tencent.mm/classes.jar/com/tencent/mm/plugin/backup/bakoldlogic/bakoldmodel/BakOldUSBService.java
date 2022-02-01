package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakOldUSBService
  extends MMService
  implements g
{
  private boolean mXX = false;
  private int nam = -1;
  
  private boolean bEX()
  {
    return (this.nam == 0) || (this.nam == 1);
  }
  
  public final IBinder Uz()
  {
    AppMethodBeat.i(21812);
    ac.i("MicroMsg.BakOldUSBService", "onBind()");
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
    ac.i("MicroMsg.BakOldUSBService", "onCreate()");
    super.onCreate();
    az.agi().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(21813);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21815);
    az.agi().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    ac.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
    AppMethodBeat.o(21815);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(21816);
    String str;
    if (paramn == null)
    {
      str = "";
      ac.i("MicroMsg.BakOldUSBService", "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str, Integer.valueOf(this.nam) });
      if (!(paramn instanceof com.tencent.mm.plugin.backup.g.b)) {
        break label257;
      }
      ac.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(this.nam) });
      if ((paramn.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(ai.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        if (bEX()) {
          break label251;
        }
      }
    }
    label251:
    for (boolean bool = true;; bool = false)
    {
      paramString.putExtra("newPCBackup", bool);
      paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      stopSelf();
      AppMethodBeat.o(21816);
      return;
      str = paramn.getClass().getSimpleName();
      break;
    }
    label257:
    if ((paramn instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((f)paramn).bFs();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().mSc = paramString.ID;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().mSd = paramString.DVl;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().mSe = paramString.DVm;
        this.nam = paramString.Scene;
        ac.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", new Object[] { Integer.valueOf(paramString.ndI), Integer.valueOf(paramString.Scene), Boolean.valueOf(this.mXX) });
        if ((!this.mXX) && (paramString.ndI == 1))
        {
          ac.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(21816);
          return;
        }
        if (bEX())
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().eo(paramString.DVe, paramString.DVf);
          com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa());
          com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFc());
          com.tencent.mm.plugin.backup.g.b.wK(1);
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFc().f(paramString.ndI, paramString.DVd);
          AppMethodBeat.o(21816);
          return;
        }
        ac.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", new Object[] { Integer.valueOf(this.nam) });
        AppMethodBeat.o(21816);
        return;
      }
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFb().naD = 2;
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFb().azv();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label554;
      }
      ac.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
    }
    for (;;)
    {
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa();
      e.bFj();
      stopSelf();
      AppMethodBeat.o(21816);
      return;
      label554:
      ac.i("MicroMsg.BakOldUSBService", "getConnect info other error");
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(21814);
    ac.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", new Object[] { Integer.valueOf(this.nam) });
    if (paramIntent == null)
    {
      ac.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
      AppMethodBeat.o(21814);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bs.isNullOrNil(str))
    {
      ac.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(21814);
      return 2;
    }
    this.mXX = paramIntent.getBooleanExtra("isFromWifi", false);
    ac.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.mXX) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFb().azv();
    paramIntent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFb();
    if (this.mXX) {
      paramInt1 = 2;
    }
    paramIntent.naC = paramInt1;
    if (!az.ayN())
    {
      ac.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(ai.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21814);
      return 2;
    }
    paramIntent = new f(str);
    az.agi().a(paramIntent, 0);
    AppMethodBeat.o(21814);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakOldUSBService
  extends MMService
  implements i
{
  private boolean oOM = false;
  private int oRb = -1;
  
  private boolean cgX()
  {
    return (this.oRb == 0) || (this.oRb == 1);
  }
  
  public final IBinder akL()
  {
    AppMethodBeat.i(21812);
    Log.i("MicroMsg.BakOldUSBService", "onBind()");
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
    Log.i("MicroMsg.BakOldUSBService", "onCreate()");
    super.onCreate();
    bg.azz().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(21813);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21815);
    bg.azz().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    Log.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
    AppMethodBeat.o(21815);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(21816);
    String str;
    if (paramq == null)
    {
      str = "";
      Log.i("MicroMsg.BakOldUSBService", "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str, Integer.valueOf(this.oRb) });
      if (!(paramq instanceof com.tencent.mm.plugin.backup.g.b)) {
        break label257;
      }
      Log.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(this.oRb) });
      if ((paramq.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        if (cgX()) {
          break label251;
        }
      }
    }
    label251:
    for (boolean bool = true;; bool = false)
    {
      paramString.putExtra("newPCBackup", bool);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      stopSelf();
      AppMethodBeat.o(21816);
      return;
      str = paramq.getClass().getSimpleName();
      break;
    }
    label257:
    if ((paramq instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((f)paramq).chs();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().oIU = paramString.ID;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().oIV = paramString.KML;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().oIW = paramString.KMM;
        this.oRb = paramString.Scene;
        Log.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", new Object[] { Integer.valueOf(paramString.oUv), Integer.valueOf(paramString.Scene), Boolean.valueOf(this.oOM) });
        if ((!this.oOM) && (paramString.oUv == 1))
        {
          Log.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(21816);
          return;
        }
        if (cgX())
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().eR(paramString.KME, paramString.KMF);
          com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha());
          com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().chc());
          com.tencent.mm.plugin.backup.g.b.Bb(1);
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().chc().f(paramString.oUv, paramString.KMD);
          AppMethodBeat.o(21816);
          return;
        }
        Log.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", new Object[] { Integer.valueOf(this.oRb) });
        AppMethodBeat.o(21816);
        return;
      }
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().chb().oRs = 2;
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().chb().aWm();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label554;
      }
      Log.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
    }
    for (;;)
    {
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha();
      e.chj();
      stopSelf();
      AppMethodBeat.o(21816);
      return;
      label554:
      Log.i("MicroMsg.BakOldUSBService", "getConnect info other error");
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(21814);
    Log.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", new Object[] { Integer.valueOf(this.oRb) });
    if (paramIntent == null)
    {
      Log.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
      AppMethodBeat.o(21814);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(21814);
      return 2;
    }
    this.oOM = paramIntent.getBooleanExtra("isFromWifi", false);
    Log.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.oOM) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().chb().aWm();
    paramIntent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().chb();
    if (this.oOM) {
      paramInt1 = 2;
    }
    paramIntent.oRr = paramInt1;
    if (!bg.aVG())
    {
      Log.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21814);
      return 2;
    }
    paramIntent = new f(str);
    bg.azz().a(paramIntent, 0);
    AppMethodBeat.o(21814);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService
 * JD-Core Version:    0.7.0.1
 */
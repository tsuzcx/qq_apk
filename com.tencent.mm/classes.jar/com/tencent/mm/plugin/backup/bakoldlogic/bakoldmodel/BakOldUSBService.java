package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMService;

public class BakOldUSBService
  extends MMService
  implements h
{
  private boolean vbY = false;
  private int vep = -1;
  
  private boolean cWS()
  {
    return (this.vep == 0) || (this.vep == 1);
  }
  
  public final IBinder aKF()
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
    bh.aZW().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(21813);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21815);
    bh.aZW().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    Log.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
    AppMethodBeat.o(21815);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(21816);
    String str;
    if (paramp == null)
    {
      str = "";
      Log.i("MicroMsg.BakOldUSBService", "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str, Integer.valueOf(this.vep) });
      if (!(paramp instanceof com.tencent.mm.plugin.backup.g.b)) {
        break label257;
      }
      Log.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(this.vep) });
      if ((paramp.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        if (cWS()) {
          break label251;
        }
      }
    }
    label251:
    for (boolean bool = true;; bool = false)
    {
      paramString.putExtra("newPCBackup", bool);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      stopSelf();
      AppMethodBeat.o(21816);
      return;
      str = paramp.getClass().getSimpleName();
      break;
    }
    label257:
    if ((paramp instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((f)paramp).cXn();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().uVY = paramString.vgy;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().uVZ = paramString.YKT;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().uWa = paramString.YKU;
        this.vep = paramString.IJG;
        Log.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", new Object[] { Integer.valueOf(paramString.vhJ), Integer.valueOf(paramString.IJG), Boolean.valueOf(this.vbY) });
        if ((!this.vbY) && (paramString.vhJ == 1))
        {
          Log.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(21816);
          return;
        }
        if (cWS())
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().fw(paramString.YKM, paramString.YKN);
          com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV());
          com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWX());
          com.tencent.mm.plugin.backup.g.b.Fd(1);
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWX().u(paramString.vhJ, paramString.YKL);
          AppMethodBeat.o(21816);
          return;
        }
        Log.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", new Object[] { Integer.valueOf(this.vep) });
        AppMethodBeat.o(21816);
        return;
      }
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWW().veH = 2;
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWW().bDh();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label553;
      }
      Log.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
    }
    for (;;)
    {
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV();
      e.cXe();
      stopSelf();
      AppMethodBeat.o(21816);
      return;
      label553:
      Log.i("MicroMsg.BakOldUSBService", "getConnect info other error");
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(21814);
    Log.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", new Object[] { Integer.valueOf(this.vep) });
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
    this.vbY = paramIntent.getBooleanExtra("isFromWifi", false);
    Log.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.vbY) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWW().bDh();
    paramIntent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWW();
    if (this.vbY) {
      paramInt1 = 2;
    }
    paramIntent.veG = paramInt1;
    if (!bh.bCA())
    {
      Log.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21814);
      return 2;
    }
    paramIntent = new f(str);
    bh.aZW().a(paramIntent, 0);
    AppMethodBeat.o(21814);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService
 * JD-Core Version:    0.7.0.1
 */
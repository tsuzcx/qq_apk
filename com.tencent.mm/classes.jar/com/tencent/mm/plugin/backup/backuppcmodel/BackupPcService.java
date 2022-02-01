package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMService;

public class BackupPcService
  extends MMService
{
  private boolean seH = false;
  private boolean vbY = false;
  
  public final IBinder aKF()
  {
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.BackupPcService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(21623);
    Log.i("MicroMsg.BackupPcService", "onCreate.");
    super.onCreate();
    AppMethodBeat.o(21623);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21625);
    super.onDestroy();
    Log.i("MicroMsg.BackupPcService", "onDestroy thread:" + Thread.currentThread().getName());
    AppMethodBeat.o(21625);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21624);
    Log.i("MicroMsg.BackupPcService", "onStartCommand.");
    if (paramIntent == null)
    {
      Log.w("MicroMsg.BackupPcService", "onStartCommand intent is null");
      AppMethodBeat.o(21624);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.BackupPcService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(21624);
      return 2;
    }
    if (str.contains("mm.gj.qq.com"))
    {
      Log.i("MicroMsg.BackupPcService", "onStartCommand url from gj stop and start BakOldUSBService");
      c.startService(new Intent(MMApplicationContext.getContext(), BakOldUSBService.class).putExtra("url", paramIntent.getStringExtra("url")).putExtra("isFromWifi", true));
      stopSelf();
      AppMethodBeat.o(21624);
      return 2;
    }
    this.vbY = paramIntent.getBooleanExtra("isFromWifi", false);
    this.seH = paramIntent.getBooleanExtra("isMove", false);
    Log.i("MicroMsg.BackupPcService", "onStartCommand Broadcast url:%s, isFromWifi:%b, isMove:%b", new Object[] { str, Boolean.valueOf(this.vbY), Boolean.valueOf(this.seH) });
    if ((!this.seH) && (!bh.bCA()))
    {
      Log.e("MicroMsg.BackupPcService", "onStartCommand onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21624);
      return 2;
    }
    MMHandlerThread.postToMainThread(new BackupPcService.1(this, str));
    AppMethodBeat.o(21624);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService
 * JD-Core Version:    0.7.0.1
 */
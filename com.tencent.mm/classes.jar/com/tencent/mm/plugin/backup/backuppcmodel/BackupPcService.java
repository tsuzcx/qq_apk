package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BackupPcService
  extends MMService
{
  private boolean kwq = false;
  private boolean mXX = false;
  
  public final IBinder Uz()
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
    ac.i("MicroMsg.BackupPcService", "onCreate.");
    super.onCreate();
    AppMethodBeat.o(21623);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21625);
    super.onDestroy();
    ac.i("MicroMsg.BackupPcService", "onDestroy thread:" + Thread.currentThread().getName());
    AppMethodBeat.o(21625);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21624);
    ac.i("MicroMsg.BackupPcService", "onStartCommand.");
    if (paramIntent == null)
    {
      ac.w("MicroMsg.BackupPcService", "onStartCommand intent is null");
      AppMethodBeat.o(21624);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bs.isNullOrNil(str))
    {
      ac.e("MicroMsg.BackupPcService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(21624);
      return 2;
    }
    if (str.contains("mm.gj.qq.com"))
    {
      ac.i("MicroMsg.BackupPcService", "onStartCommand url from gj stop and start BakOldUSBService");
      d.aZ(new Intent(ai.getContext(), BakOldUSBService.class).putExtra("url", paramIntent.getStringExtra("url")).putExtra("isFromWifi", true));
      stopSelf();
      AppMethodBeat.o(21624);
      return 2;
    }
    this.mXX = paramIntent.getBooleanExtra("isFromWifi", false);
    this.kwq = paramIntent.getBooleanExtra("isMove", false);
    ac.i("MicroMsg.BackupPcService", "onStartCommand Broadcast url:%s, isFromWifi:%b, isMove:%b", new Object[] { str, Boolean.valueOf(this.mXX), Boolean.valueOf(this.kwq) });
    if ((!this.kwq) && (!az.ayN()))
    {
      ac.e("MicroMsg.BackupPcService", "onStartCommand onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(ai.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21624);
      return 2;
    }
    ap.f(new BackupPcService.1(this, str));
    AppMethodBeat.o(21624);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService
 * JD-Core Version:    0.7.0.1
 */
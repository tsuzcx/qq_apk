package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BackupPcService
  extends MMService
{
  private boolean kSw = false;
  private boolean nyu = false;
  
  public final IBinder WQ()
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
    ad.i("MicroMsg.BackupPcService", "onCreate.");
    super.onCreate();
    AppMethodBeat.o(21623);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21625);
    super.onDestroy();
    ad.i("MicroMsg.BackupPcService", "onDestroy thread:" + Thread.currentThread().getName());
    AppMethodBeat.o(21625);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21624);
    ad.i("MicroMsg.BackupPcService", "onStartCommand.");
    if (paramIntent == null)
    {
      ad.w("MicroMsg.BackupPcService", "onStartCommand intent is null");
      AppMethodBeat.o(21624);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.BackupPcService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(21624);
      return 2;
    }
    if (str.contains("mm.gj.qq.com"))
    {
      ad.i("MicroMsg.BackupPcService", "onStartCommand url from gj stop and start BakOldUSBService");
      d.be(new Intent(aj.getContext(), BakOldUSBService.class).putExtra("url", paramIntent.getStringExtra("url")).putExtra("isFromWifi", true));
      stopSelf();
      AppMethodBeat.o(21624);
      return 2;
    }
    this.nyu = paramIntent.getBooleanExtra("isFromWifi", false);
    this.kSw = paramIntent.getBooleanExtra("isMove", false);
    ad.i("MicroMsg.BackupPcService", "onStartCommand Broadcast url:%s, isFromWifi:%b, isMove:%b", new Object[] { str, Boolean.valueOf(this.nyu), Boolean.valueOf(this.kSw) });
    if ((!this.kSw) && (!ba.aBR()))
    {
      ad.e("MicroMsg.BackupPcService", "onStartCommand onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahp(), "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21624);
      return 2;
    }
    aq.f(new BackupPcService.1(this, str));
    AppMethodBeat.o(21624);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService
 * JD-Core Version:    0.7.0.1
 */
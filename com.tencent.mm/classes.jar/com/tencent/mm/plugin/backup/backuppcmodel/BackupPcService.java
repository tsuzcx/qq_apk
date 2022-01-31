package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMService;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BackupPcService
  extends MMService
{
  private boolean hPP = false;
  private boolean jEC = false;
  
  public final IBinder It()
  {
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.BackupPcService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(17564);
    ab.i("MicroMsg.BackupPcService", "onCreate.");
    super.onCreate();
    AppMethodBeat.o(17564);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(17566);
    super.onDestroy();
    ab.i("MicroMsg.BackupPcService", "onDestroy thread:" + Thread.currentThread().getName());
    AppMethodBeat.o(17566);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(17565);
    ab.i("MicroMsg.BackupPcService", "onStartCommand.");
    if (paramIntent == null)
    {
      ab.w("MicroMsg.BackupPcService", "onStartCommand intent is null");
      AppMethodBeat.o(17565);
      return 2;
    }
    final String str = paramIntent.getStringExtra("url");
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.BackupPcService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(17565);
      return 2;
    }
    if (str.contains("mm.gj.qq.com"))
    {
      ab.i("MicroMsg.BackupPcService", "onStartCommand url from gj stop and start BakOldUSBService");
      com.tencent.mm.bq.d.aG(new Intent(ah.getContext(), BakOldUSBService.class).putExtra("url", paramIntent.getStringExtra("url")).putExtra("isFromWifi", true));
      stopSelf();
      AppMethodBeat.o(17565);
      return 2;
    }
    this.jEC = paramIntent.getBooleanExtra("isFromWifi", false);
    this.hPP = paramIntent.getBooleanExtra("isMove", false);
    ab.i("MicroMsg.BackupPcService", "onStartCommand Broadcast url:%s, isFromWifi:%b, isMove:%b", new Object[] { str, Boolean.valueOf(this.jEC), Boolean.valueOf(this.hPP) });
    if ((!this.hPP) && (!aw.aaB()))
    {
      ab.e("MicroMsg.BackupPcService", "onStartCommand onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      startActivity(paramIntent);
      AppMethodBeat.o(17565);
      return 2;
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17563);
        Object localObject = b.aTX().aTY();
        String str = str;
        ab.w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
        com.tencent.mm.plugin.backup.b.d.rg(1);
        com.tencent.mm.plugin.backup.g.b.aUs();
        aw.aaz();
        ((c)localObject).jEg = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yEo, Integer.valueOf(0))).intValue();
        b.aTX();
        SharedPreferences.Editor localEditor = b.aSQ().edit();
        localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
        localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
        localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
        localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
        localEditor.commit();
        ((c)localObject).jEh = true;
        aw.Rc().a(595, ((c)localObject).jBE);
        localObject = new e(str);
        aw.Rc().a((m)localObject, 0);
        AppMethodBeat.o(17563);
      }
    });
    AppMethodBeat.o(17565);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService
 * JD-Core Version:    0.7.0.1
 */
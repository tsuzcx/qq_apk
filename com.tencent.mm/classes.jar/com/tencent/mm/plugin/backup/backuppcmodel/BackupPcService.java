package com.tencent.mm.plugin.backup.backuppcmodel;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BackupPcService
  extends Service
{
  private boolean guU = false;
  private boolean hKZ = false;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    y.i("MicroMsg.BackupPcService", "onCreate.");
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.BackupPcService", "onDestroy thread:" + Thread.currentThread().getName());
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.BackupPcService", "onStartCommand.");
    if (paramIntent == null)
    {
      y.w("MicroMsg.BackupPcService", "onStartCommand intent is null");
      return 2;
    }
    final String str = paramIntent.getStringExtra("url");
    if (bk.bl(str))
    {
      y.e("MicroMsg.BackupPcService", "onStartCommand url is null");
      stopSelf();
      return 2;
    }
    if (str.contains("mm.gj.qq.com"))
    {
      y.i("MicroMsg.BackupPcService", "onStartCommand url from gj stop and start BakOldUSBService");
      startService(new Intent(this, BakOldUSBService.class).putExtra("url", paramIntent.getStringExtra("url")).putExtra("isFromWifi", true));
      stopSelf();
      return 2;
    }
    this.hKZ = paramIntent.getBooleanExtra("isFromWifi", false);
    this.guU = paramIntent.getBooleanExtra("isMove", false);
    y.i("MicroMsg.BackupPcService", "onStartCommand Broadcast url:%s, isFromWifi:%b, isMove:%b", new Object[] { str, Boolean.valueOf(this.hKZ), Boolean.valueOf(this.guU) });
    if ((!this.guU) && (!au.Hz()))
    {
      y.e("MicroMsg.BackupPcService", "onStartCommand onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      startActivity(paramIntent);
      return 2;
    }
    ai.d(new Runnable()
    {
      public final void run()
      {
        Object localObject = b.auw().aux();
        String str = str;
        y.w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
        d.nu(1);
        com.tencent.mm.plugin.backup.g.b.auQ();
        au.Hx();
        ((c)localObject).hKD = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uul, Integer.valueOf(0))).intValue();
        b.auw();
        SharedPreferences.Editor localEditor = b.ats().edit();
        localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
        localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
        localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
        localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
        localEditor.commit();
        ((c)localObject).hKE = true;
        au.Dk().a(595, ((c)localObject).hIg);
        localObject = new e(str);
        au.Dk().a((m)localObject, 0);
      }
    });
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService
 * JD-Core Version:    0.7.0.1
 */
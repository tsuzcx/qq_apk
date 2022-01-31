package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.protocal.c.aei;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakOldUSBService
  extends Service
  implements com.tencent.mm.ah.f
{
  private boolean hKZ = false;
  private int hNp = -1;
  
  private boolean avp()
  {
    return (this.hNp == 0) || (this.hNp == 1);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    y.i("MicroMsg.BakOldUSBService", "onBind()");
    return null;
  }
  
  public void onCreate()
  {
    y.i("MicroMsg.BakOldUSBService", "onCreate()");
    super.onCreate();
    au.Dk().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
  }
  
  public void onDestroy()
  {
    au.Dk().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    y.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    String str;
    if (paramm == null)
    {
      str = "";
      y.i("MicroMsg.BakOldUSBService", "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str, Integer.valueOf(this.hNp) });
      if (!(paramm instanceof com.tencent.mm.plugin.backup.g.b)) {
        break label188;
      }
      y.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(this.hNp) });
      if ((paramm.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        if (avp()) {
          break label182;
        }
        bool = true;
        paramString.putExtra("newPCBackup", bool);
        startActivity(paramString);
      }
      stopSelf();
    }
    label182:
    label188:
    while (!(paramm instanceof com.tencent.mm.plugin.backup.bakoldlogic.c.f)) {
      for (;;)
      {
        return;
        str = paramm.getClass().getSimpleName();
        break;
        boolean bool = false;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.backup.bakoldlogic.c.f)paramm).avK();
      a.avr().hFm = paramString.ID;
      a.avr().hFn = paramString.szi;
      a.avr().hFo = paramString.szj;
      this.hNp = paramString.pyo;
      y.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", new Object[] { Integer.valueOf(paramString.hQR), Integer.valueOf(paramString.pyo), Boolean.valueOf(this.hKZ) });
      if ((!this.hKZ) && (paramString.hQR == 1))
      {
        y.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
        stopSelf();
        return;
      }
      if (avp())
      {
        a.avr().avs().ck(paramString.sza, paramString.szb);
        com.tencent.mm.plugin.backup.g.b.a(a.avr().avs());
        com.tencent.mm.plugin.backup.g.b.a(a.avr().avu());
        com.tencent.mm.plugin.backup.g.b.nu(1);
        a.avr().avu().d(paramString.hQR, paramString.syZ);
        return;
      }
      y.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", new Object[] { Integer.valueOf(this.hNp) });
      return;
    }
    a.avr().avt().hNI = 2;
    a.avr().avt().Ig();
    if ((paramInt1 == 4) && (paramInt2 == -2011)) {
      y.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
    }
    for (;;)
    {
      a.avr().avs();
      e.avB();
      stopSelf();
      return;
      y.i("MicroMsg.BakOldUSBService", "getConnect info other error");
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    y.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", new Object[] { Integer.valueOf(this.hNp) });
    if (paramIntent == null)
    {
      y.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bk.bl(str))
    {
      y.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
      stopSelf();
      return 2;
    }
    this.hKZ = paramIntent.getBooleanExtra("isFromWifi", false);
    y.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.hKZ) });
    a.avr().avt().Ig();
    paramIntent = a.avr().avt();
    if (this.hKZ) {
      paramInt1 = 2;
    }
    paramIntent.hNH = paramInt1;
    if (!au.Hz())
    {
      y.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      startActivity(paramIntent);
      return 2;
    }
    paramIntent = new com.tencent.mm.plugin.backup.bakoldlogic.c.f(str);
    au.Dk().a(paramIntent, 0);
    return 2;
  }
  
  public boolean stopService(Intent paramIntent)
  {
    y.i("MicroMsg.BakOldUSBService", "stopService.");
    return super.stopService(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService
 * JD-Core Version:    0.7.0.1
 */
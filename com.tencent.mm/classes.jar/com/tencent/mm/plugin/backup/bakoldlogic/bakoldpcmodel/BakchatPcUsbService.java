package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.aei;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakchatPcUsbService
  extends Service
  implements com.tencent.mm.ah.f
{
  private boolean hKZ = false;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    y.i("MicroMsg.BakchatPcUsbService", "onCreate()");
    super.onCreate();
    au.Dk().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
  }
  
  public void onDestroy()
  {
    au.Dk().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    y.i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.backup.g.b))
    {
      if ((paramm.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        startActivity(paramString);
      }
      stopSelf();
    }
    while (!(paramm instanceof com.tencent.mm.plugin.backup.bakoldlogic.c.f)) {
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.backup.bakoldlogic.c.f)paramm).avK();
      if (this.hKZ)
      {
        y.i("MicroMsg.BakchatPcUsbService", "from wifi, reconnect");
        a.avr().avu().avv();
      }
      if ((!this.hKZ) && (paramString.hQR == 1))
      {
        y.e("MicroMsg.BakchatPcUsbService", "broast from usb but type is wifi, url may be fake!!!!");
        stopSelf();
        return;
      }
      a.avr().hFm = paramString.ID;
      a.avr().hFn = paramString.szi;
      a.avr().hFo = paramString.szj;
      a.avr().avs().ck(paramString.sza, paramString.szb);
      com.tencent.mm.plugin.backup.g.b.a(a.avr().avs());
      com.tencent.mm.plugin.backup.g.b.a(a.avr().avu());
      com.tencent.mm.plugin.backup.g.b.nu(1);
      a.avr().avu().d(paramString.hQR, paramString.syZ);
      return;
    }
    a.avr().avt().hNI = 2;
    a.avr().avt().Ig();
    if ((paramInt1 == 4) && (paramInt2 == -2011))
    {
      y.i("MicroMsg.BakchatPcUsbService", "getConnect info: INVALID URL");
      if (!this.hKZ) {}
    }
    for (;;)
    {
      a.avr().avs();
      e.avB();
      stopSelf();
      return;
      y.i("MicroMsg.BakchatPcUsbService", "getConnect info other error");
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    y.i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
    if (paramIntent == null)
    {
      y.w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bk.bl(str))
    {
      y.e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
      stopSelf();
      return 2;
    }
    this.hKZ = paramIntent.getBooleanExtra("isFromWifi", false);
    y.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.hKZ) });
    a.avr().avt().Ig();
    paramIntent = a.avr().avt();
    if (this.hKZ) {
      paramInt1 = 2;
    }
    paramIntent.hNH = paramInt1;
    if (!au.Hz())
    {
      y.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService
 * JD-Core Version:    0.7.0.1
 */
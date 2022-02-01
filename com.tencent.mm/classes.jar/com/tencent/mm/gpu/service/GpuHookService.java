package com.tencent.mm.gpu.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.rubbishbin.JNIExceptionHandler;
import com.tencent.mm.plugin.rubbishbin.JNIExceptionHandlerImpl;
import com.tencent.mm.sdk.platformtools.ac;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public abstract class GpuHookService
  extends Service
  implements Runnable
{
  private int gaC = 1000;
  private int gaD = 0;
  private Thread gaE;
  private a gaF;
  private String gaG = "default";
  private int repeatMode = 1;
  
  public static void G(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = new Intent(paramContext, GpuHookServiceImpl.class);
      localIntent.putExtra("exec_time", 1);
      localIntent.putExtra("interval", 120000);
      localIntent.putExtra("exec_tag", paramString);
      paramContext.startService(localIntent);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public abstract void ael();
  
  public IBinder onBind(Intent paramIntent)
  {
    ac.e("Gpu.GpuHookService", "start GpuHookService of bindService");
    return null;
  }
  
  public void onCreate()
  {
    ac.e("Gpu.GpuHookService", "GpuHookService create start");
    if (this.gaF == null)
    {
      ac.e("Gpu.GpuHookService", "exceptionHandler init");
      this.gaF = new a(this);
    }
    Thread.setDefaultUncaughtExceptionHandler(this.gaF);
    this.gaE = new Thread(this);
    JNIExceptionHandlerImpl.initJNIExceptionHandler(this, "Gpu.GpuHookService");
    JNIExceptionHandler.init();
    ac.e("Gpu.GpuHookService", "GpuHookService create finish");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    ac.e("Gpu.GpuHookService", "GpuHookService startCommand start");
    if (paramIntent != null)
    {
      this.gaD = paramIntent.getIntExtra("exec_time", 0);
      this.gaC = paramIntent.getIntExtra("interval", -1);
      this.gaG = paramIntent.getStringExtra("exec_tag");
    }
    this.gaE.setName(this.gaG);
    JNIExceptionHandler.INSTANCE.setReportExecutionTag(this.gaG);
    switch (this.gaD)
    {
    }
    for (this.repeatMode = 1; this.gaC == -1; this.repeatMode = this.gaD)
    {
      stopSelf();
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (!this.gaE.isAlive()) {
      h.JZN.aV(this);
    }
    ac.e("Gpu.GpuHookService", "GpuHookService startCommand finish");
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("sp_gpuhook_service", g.YK());
    Object localObject = Calendar.getInstance().getTime();
    String str1 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject);
    String str2 = localSharedPreferences.getString("LastExecDate", "00000000");
    localObject = localSharedPreferences.getString("GpuHookTag", "N/A");
    if (!Objects.equals(str2, str1))
    {
      localSharedPreferences.edit().putString("GpuHookTag", "N/A").putString("LastExecDate", str1).apply();
      localObject = "N/A";
    }
    if ((Objects.equals(localObject, this.gaG)) && (this.repeatMode != -1))
    {
      if (localSharedPreferences.getInt("GpuHookCount", this.gaD) <= 0)
      {
        this.repeatMode = 0;
        stopSelf();
      }
    }
    else {
      localSharedPreferences.edit().putInt("GpuHookCount", this.gaD).apply();
    }
    localSharedPreferences.edit().putString("GpuHookTag", this.gaG).apply();
    this.gaD = localSharedPreferences.getInt("GpuHookCount", this.gaD);
    ac.i("Gpu.GpuHookService", "[sunny]dt:%s,cnt:%d,t:%s", new Object[] { str1, Integer.valueOf(this.gaD), this.gaG });
    for (;;)
    {
      if (this.repeatMode == 0) {
        stopSelf();
      }
      do
      {
        stopSelf();
        return;
        this.gaD -= 1;
        localSharedPreferences.edit().putInt("GpuHookCount", this.gaD).apply();
        ac.i("Gpu.GpuHookService", "e!");
        ael();
      } while ((this.gaD == 0) && (this.repeatMode != -1));
      try
      {
        Thread.sleep(this.gaC);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.service.GpuHookService
 * JD-Core Version:    0.7.0.1
 */
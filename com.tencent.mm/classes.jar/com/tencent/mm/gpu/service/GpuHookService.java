package com.tencent.mm.gpu.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.rubbishbin.JNIExceptionHandler;
import com.tencent.mm.plugin.rubbishbin.JNIExceptionHandlerImpl;
import com.tencent.mm.sdk.platformtools.ad;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public abstract class GpuHookService
  extends Service
  implements Runnable
{
  private int gub = 1000;
  private int guc = 0;
  private Thread gud;
  private a gue;
  private String guf = "default";
  private int repeatMode = 1;
  
  public static void F(Context paramContext, String paramString)
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
  
  public abstract void agS();
  
  public IBinder onBind(Intent paramIntent)
  {
    ad.e("Gpu.GpuHookService", "start GpuHookService of bindService");
    new Handler(Looper.myLooper()).postDelayed(new GpuHookService.1(this), 120000L);
    return null;
  }
  
  public void onCreate()
  {
    ad.e("Gpu.GpuHookService", "GpuHookService create start");
    if (this.gue == null)
    {
      ad.e("Gpu.GpuHookService", "exceptionHandler init");
      this.gue = new a(this);
    }
    Thread.setDefaultUncaughtExceptionHandler(this.gue);
    this.gud = new Thread(this);
    JNIExceptionHandlerImpl.initJNIExceptionHandler(this, "Gpu.GpuHookService");
    JNIExceptionHandler.init();
    ad.e("Gpu.GpuHookService", "GpuHookService create finish");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    ad.e("Gpu.GpuHookService", "GpuHookService startCommand start");
    if (paramIntent != null)
    {
      this.guc = paramIntent.getIntExtra("exec_time", 0);
      this.gub = paramIntent.getIntExtra("interval", -1);
      this.guf = paramIntent.getStringExtra("exec_tag");
    }
    this.gud.setName(this.guf);
    JNIExceptionHandler.INSTANCE.setReportExecutionTag(this.guf);
    switch (this.guc)
    {
    }
    for (this.repeatMode = 1; this.gub == -1; this.repeatMode = this.guc)
    {
      stopSelf();
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (!this.gud.isAlive()) {
      h.LTJ.aU(this);
    }
    ad.e("Gpu.GpuHookService", "GpuHookService startCommand finish");
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("sp_gpuhook_service", g.abm());
    Object localObject = Calendar.getInstance().getTime();
    String str1 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject);
    String str2 = localSharedPreferences.getString("LastExecDate", "00000000");
    localObject = localSharedPreferences.getString("GpuHookTag", "N/A");
    if (!Objects.equals(str2, str1))
    {
      localSharedPreferences.edit().putString("GpuHookTag", "N/A").putString("LastExecDate", str1).apply();
      localObject = "N/A";
    }
    if ((Objects.equals(localObject, this.guf)) && (this.repeatMode != -1))
    {
      if (localSharedPreferences.getInt("GpuHookCount", this.guc) <= 0)
      {
        this.repeatMode = 0;
        stopSelf();
      }
    }
    else {
      localSharedPreferences.edit().putInt("GpuHookCount", this.guc).apply();
    }
    localSharedPreferences.edit().putString("GpuHookTag", this.guf).apply();
    this.guc = localSharedPreferences.getInt("GpuHookCount", this.guc);
    ad.i("Gpu.GpuHookService", "[sunny]dt:%s,cnt:%d,t:%s", new Object[] { str1, Integer.valueOf(this.guc), this.guf });
    for (;;)
    {
      if (this.repeatMode == 0) {
        stopSelf();
      }
      do
      {
        stopSelf();
        return;
        this.guc -= 1;
        localSharedPreferences.edit().putInt("GpuHookCount", this.guc).apply();
        ad.i("Gpu.GpuHookService", "e!");
        agS();
      } while ((this.guc == 0) && (this.repeatMode != -1));
      try
      {
        Thread.sleep(this.gub);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.service.GpuHookService
 * JD-Core Version:    0.7.0.1
 */
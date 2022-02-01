package com.tencent.mm.gpu.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.rubbishbin.JNIExceptionHandler;
import com.tencent.mm.plugin.rubbishbin.JNIExceptionHandlerImpl;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public abstract class GpuHookService
  extends Service
  implements Runnable
{
  private String hjA = "default";
  private int hjw = 1000;
  private int hjx = 0;
  private Thread hjy;
  private a hjz;
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
  
  public abstract void axt();
  
  public IBinder onBind(Intent paramIntent)
  {
    Log.e("Gpu.GpuHookService", "start GpuHookService of bindService");
    new Handler(Looper.myLooper()).postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186206);
        Log.e("Gpu.GpuHookService", "kill self in 120s！");
        com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/gpu/service/GpuHookService$1", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/gpu/service/GpuHookService$1", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
        AppMethodBeat.o(186206);
      }
    }, 120000L);
    return null;
  }
  
  public void onCreate()
  {
    Log.e("Gpu.GpuHookService", "GpuHookService create start");
    if (this.hjz == null)
    {
      Log.e("Gpu.GpuHookService", "exceptionHandler init");
      this.hjz = new a(this);
    }
    Thread.setDefaultUncaughtExceptionHandler(this.hjz);
    this.hjy = new Thread(this);
    JNIExceptionHandlerImpl.initJNIExceptionHandler(this, "Gpu.GpuHookService");
    JNIExceptionHandler.init();
    Log.e("Gpu.GpuHookService", "GpuHookService create finish");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Log.e("Gpu.GpuHookService", "GpuHookService startCommand start");
    if (paramIntent != null)
    {
      this.hjx = paramIntent.getIntExtra("exec_time", 0);
      this.hjw = paramIntent.getIntExtra("interval", -1);
      this.hjA = paramIntent.getStringExtra("exec_tag");
    }
    this.hjy.setName(this.hjA);
    JNIExceptionHandler.INSTANCE.setReportExecutionTag(this.hjA);
    switch (this.hjx)
    {
    }
    for (this.repeatMode = 1; this.hjw == -1; this.repeatMode = this.hjx)
    {
      stopSelf();
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (!this.hjy.isAlive()) {
      h.RTc.ba(this);
    }
    Log.e("Gpu.GpuHookService", "GpuHookService startCommand finish");
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("sp_gpuhook_service", g.aps());
    Object localObject = Calendar.getInstance().getTime();
    String str1 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject);
    String str2 = localSharedPreferences.getString("LastExecDate", "00000000");
    localObject = localSharedPreferences.getString("GpuHookTag", "N/A");
    if (!Objects.equals(str2, str1))
    {
      localSharedPreferences.edit().putString("GpuHookTag", "N/A").putString("LastExecDate", str1).apply();
      localObject = "N/A";
    }
    if ((Objects.equals(localObject, this.hjA)) && (this.repeatMode != -1))
    {
      if (localSharedPreferences.getInt("GpuHookCount", this.hjx) <= 0)
      {
        this.repeatMode = 0;
        stopSelf();
      }
    }
    else {
      localSharedPreferences.edit().putInt("GpuHookCount", this.hjx).apply();
    }
    localSharedPreferences.edit().putString("GpuHookTag", this.hjA).apply();
    this.hjx = localSharedPreferences.getInt("GpuHookCount", this.hjx);
    Log.i("Gpu.GpuHookService", "[sunny]dt:%s,cnt:%d,t:%s", new Object[] { str1, Integer.valueOf(this.hjx), this.hjA });
    for (;;)
    {
      if (this.repeatMode == 0) {
        stopSelf();
      }
      do
      {
        stopSelf();
        return;
        this.hjx -= 1;
        localSharedPreferences.edit().putInt("GpuHookCount", this.hjx).apply();
        Log.i("Gpu.GpuHookService", "e!");
        axt();
      } while ((this.hjx == 0) && (this.repeatMode != -1));
      try
      {
        Thread.sleep(this.hjw);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.gpu.service.GpuHookService
 * JD-Core Version:    0.7.0.1
 */
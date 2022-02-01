package com.tencent.mm.gpu.service;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class a
  implements Thread.UncaughtExceptionHandler
{
  private Context context;
  
  a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    AppMethodBeat.i(219551);
    ad.i("Gpu.GpuExceptionHandler", "threadName = ".concat(String.valueOf(paramThread.getName())));
    paramThread = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(paramThread));
    paramThrowable = paramThread.toString() + "\n";
    int j = paramThrowable.length() / 512;
    ad.e("Gpu.GpuExceptionHandler", "crashTime = ".concat(String.valueOf(System.nanoTime())));
    int i = 0;
    if (i < j + 1)
    {
      if ((i + 1) * 512 < paramThrowable.length()) {}
      for (paramThread = paramThrowable.substring(i * 512, (i + 1) * 512);; paramThread = paramThrowable.substring(i * 512))
      {
        ad.e("Gpu.GpuExceptionHandler", "segToReport = ".concat(String.valueOf(paramThread)));
        i += 1;
        break;
      }
    }
    ad.e("Gpu.GpuExceptionHandler", paramThrowable);
    this.context.stopService(new Intent(this.context, GpuHookService.class));
    try
    {
      for (;;)
      {
        Looper.loop();
      }
    }
    catch (Exception paramThread) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.service.a
 * JD-Core Version:    0.7.0.1
 */
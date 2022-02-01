package com.tencent.map.tools.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.tools.sheet.SheetManager.Options;
import com.tencent.map.tools.sheet.SheetManager.UncaughtListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class e
  implements c
{
  private Thread.UncaughtExceptionHandler a;
  private b b;
  private f c;
  private boolean d;
  
  public e(final Context paramContext, SheetManager.Options paramOptions)
  {
    AppMethodBeat.i(180779);
    a.a = paramOptions.getPluginName();
    a.b = paramOptions.getSdkVersion();
    a.c = paramOptions.getSdkVersionCode();
    a.d = paramOptions.getSdkRepo();
    a.e = paramOptions.getSdkFlavor();
    a.f = paramOptions.getSdkMapKey();
    a.g = paramOptions.getSoLibName();
    a.i = paramOptions.isCoreLogOn();
    this.d = paramOptions.isSheetEnable();
    if (!this.d)
    {
      paramContext = paramOptions.getUncaughtListener();
      if ((paramContext != null) && (this.a == null))
      {
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(209787);
            CountDownLatch localCountDownLatch = new CountDownLatch(1);
            paramContext.onModuleSDKCrashed(paramAnonymousThrowable);
            try
            {
              localCountDownLatch.await(400L, TimeUnit.MILLISECONDS);
              label34:
              if (e.a(e.this) != null) {
                e.a(e.this).uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
              }
              AppMethodBeat.o(209787);
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              break label34;
            }
          }
        });
      }
      AppMethodBeat.o(180779);
      return;
    }
    if (a.i)
    {
      String str = paramOptions.getCoreLogReportUrl();
      if (!TextUtils.isEmpty(str)) {
        a.k = str;
      }
      this.b = b.a(paramContext);
      paramContext = paramOptions.getUncaughtListener();
      if (paramContext != null) {
        this.b.a(paramContext);
      }
      paramContext = paramOptions.getCoreLogDir();
      if (paramContext != null)
      {
        if (!paramContext.exists()) {
          paramContext.mkdirs();
        }
        this.b.a(paramContext);
      }
    }
    this.b.a();
    AppMethodBeat.o(180779);
  }
  
  public final boolean a()
  {
    return this.d;
  }
  
  public final File b()
  {
    AppMethodBeat.i(180780);
    if (this.b != null)
    {
      File localFile = this.b.d();
      AppMethodBeat.o(180780);
      return localFile;
    }
    AppMethodBeat.o(180780);
    return null;
  }
  
  public final d c()
  {
    AppMethodBeat.i(180781);
    if ((this.c == null) && (this.b != null)) {
      this.c = new f(this.b);
    }
    f localf = this.c;
    AppMethodBeat.o(180781);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.map.tools.internal;

import android.content.Context;
import android.os.HandlerThread;
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
  Thread.UncaughtExceptionHandler a;
  private b b;
  private f c;
  private boolean d;
  
  public e(final Context paramContext, SheetManager.Options paramOptions)
  {
    AppMethodBeat.i(180779);
    a.a = paramOptions.getPluginName();
    a.b = paramOptions.getSdkVersion();
    a.c = paramOptions.getSdkVersionCode();
    a.d = paramOptions.getSdkFlavor();
    a.e = paramOptions.getSdkMapKey();
    a.f = paramOptions.getSoLibName();
    a.h = paramOptions.isCoreLogOn();
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
            AppMethodBeat.i(195076);
            CountDownLatch localCountDownLatch = new CountDownLatch(1);
            paramContext.onModuleSDKCrashed(paramAnonymousThrowable);
            try
            {
              localCountDownLatch.await(400L, TimeUnit.MILLISECONDS);
              label34:
              if (e.this.a != null) {
                e.this.a.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
              }
              AppMethodBeat.o(195076);
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
    if (a.h)
    {
      Object localObject = paramOptions.getCoreLogReportUrl();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        a.j = (String)localObject;
      }
      this.b = b.a(paramContext);
      paramContext = paramOptions.getUncaughtListener();
      if (paramContext != null)
      {
        localObject = this.b.a;
        if (paramContext != null)
        {
          ((m)localObject).b = paramContext;
          ((m)localObject).d = new n(((m)localObject).a);
          localObject = ((m)localObject).d;
          if (!((n)localObject).a)
          {
            ((n)localObject).b = paramContext;
            Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)localObject);
            ((n)localObject).a = true;
          }
        }
      }
      paramContext = paramOptions.getCoreLogDir();
      if (paramContext != null)
      {
        if (!paramContext.exists()) {
          paramContext.mkdirs();
        }
        paramOptions = this.b.a;
        paramOptions.c = paramContext;
        if (a.h) {
          g.a(paramOptions.a).g = paramOptions.c;
        }
      }
    }
    paramContext = g.a(this.b.a.a);
    if (!paramContext.c)
    {
      if (a.h) {
        paramContext.e = new k(paramContext.d, paramContext.a.getLooper(), paramContext.g, paramContext.f);
      }
      paramContext.c = true;
    }
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
      Object localObject = g.a(this.b.a.a);
      if (((g)localObject).e != null)
      {
        localObject = ((g)localObject).e.c;
        AppMethodBeat.o(180780);
        return localObject;
      }
      AppMethodBeat.o(180780);
      return null;
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
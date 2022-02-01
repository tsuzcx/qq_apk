package com.tencent.map.tools.internal;

import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.map.tools.sheet.SheetManager.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class e
  implements c
{
  private b a;
  private f b;
  private boolean c;
  
  public e(Context paramContext, SheetManager.Options paramOptions)
  {
    AppMethodBeat.i(180779);
    a.a = paramOptions.getPluginName();
    a.b = paramOptions.getSdkVersion();
    a.c = paramOptions.getSdkVersionCode();
    a.d = paramOptions.getSdkFlavor();
    a.e = paramOptions.getSdkMapKey();
    a.f = paramOptions.getSoLibName();
    a.h = paramOptions.isCoreLogOn();
    this.c = paramOptions.isSheetEnable();
    if (!this.c)
    {
      AppMethodBeat.o(180779);
      return;
    }
    if (a.h)
    {
      Object localObject = paramOptions.getCoreLogReportUrl();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        a.j = (String)localObject;
      }
      this.a = b.a(paramContext);
      paramContext = paramOptions.getUncaughtListener();
      if (paramContext != null)
      {
        localObject = this.a.a;
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
        paramOptions = this.a.a;
        paramOptions.c = paramContext;
        if (a.h) {
          g.a(paramOptions.a).g = paramOptions.c;
        }
      }
    }
    paramContext = g.a(this.a.a.a);
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
    return this.c;
  }
  
  public final File b()
  {
    AppMethodBeat.i(180780);
    if (this.a != null)
    {
      Object localObject = g.a(this.a.a.a);
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
    if ((this.b == null) && (this.a != null)) {
      this.b = new f(this.a);
    }
    f localf = this.b;
    AppMethodBeat.o(180781);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.e
 * JD-Core Version:    0.7.0.1
 */
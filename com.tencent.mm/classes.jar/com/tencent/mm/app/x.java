package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class x
{
  private static final List<a> fdE;
  private static final boolean[] fdF;
  
  static
  {
    AppMethodBeat.i(249301);
    fdE = new ArrayList();
    fdF = new boolean[] { false };
    AppMethodBeat.o(249301);
  }
  
  public static void a(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249296);
    synchronized (fdF)
    {
      if (fdF[0] != 0) {
        f.Iyx.a(paramInt, paramVarArgs);
      }
      for (;;)
      {
        AppMethodBeat.o(249296);
        return;
        synchronized (fdE)
        {
          fdE.add(new c(paramInt, paramVarArgs));
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(249291);
    synchronized (fdF)
    {
      if (fdF[0] != 0) {
        com.tencent.mm.sdk.platformtools.Log.i(paramString1, paramString2, paramVarArgs);
      }
      for (;;)
      {
        AppMethodBeat.o(249291);
        return;
        List localList = fdE;
        String str = paramString2;
        try
        {
          if (paramVarArgs.length > 0) {
            str = String.format(paramString2, paramVarArgs);
          }
          fdE.add(new d(4, paramString1, str));
        }
        finally
        {
          AppMethodBeat.o(249291);
        }
      }
    }
  }
  
  public static void a(String paramString1, Throwable arg1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(249295);
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (fdF)
      {
        if (fdF[0] != 0)
        {
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(paramString1, ???, paramString2, paramVarArgs);
          AppMethodBeat.o(249295);
          return;
        }
        localStringBuilder = new StringBuilder();
        if (paramVarArgs.length > 0)
        {
          localStringBuilder.append(String.format(paramString2, paramVarArgs));
          localStringBuilder.append("  ").append(android.util.Log.getStackTraceString(???));
          synchronized (fdE)
          {
            fdE.add(new d(6, paramString1, localStringBuilder.toString()));
          }
        }
      }
      localStringBuilder.append(paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(249293);
    synchronized (fdF)
    {
      if (fdF[0] != 0) {
        com.tencent.mm.sdk.platformtools.Log.w(paramString1, paramString2, paramVarArgs);
      }
      for (;;)
      {
        AppMethodBeat.o(249293);
        return;
        List localList = fdE;
        String str = paramString2;
        try
        {
          if (paramVarArgs.length > 0) {
            str = String.format(paramString2, paramVarArgs);
          }
          fdE.add(new d(5, paramString1, str));
        }
        finally
        {
          AppMethodBeat.o(249293);
        }
      }
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... arg2)
  {
    AppMethodBeat.i(249294);
    synchronized (fdF)
    {
      if (fdF[0] != 0) {
        com.tencent.mm.sdk.platformtools.Log.e(paramString1, paramString2, ???);
      }
      for (;;)
      {
        AppMethodBeat.o(249294);
        return;
        synchronized (fdE)
        {
          fdE.add(new d(6, paramString1, paramString2));
        }
      }
    }
  }
  
  public static void execute()
  {
    AppMethodBeat.i(249300);
    synchronized (fdF)
    {
      synchronized (fdE)
      {
        Iterator localIterator = fdE.iterator();
        if (localIterator.hasNext()) {
          ((a)localIterator.next()).execute();
        }
      }
    }
    fdF[0] = true;
    AppMethodBeat.o(249300);
  }
  
  public static void ff(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293015);
    synchronized (fdF)
    {
      if (fdF[0] != 0) {
        f.Iyx.idkeyStat(paramInt1, paramInt2, 1L, true);
      }
      for (;;)
      {
        AppMethodBeat.o(293015);
        return;
        synchronized (fdE)
        {
          fdE.add(new b(paramInt1, paramInt2));
        }
      }
    }
  }
  
  static abstract class a
  {
    final SimpleDateFormat fdG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
    final String fdH = this.fdG.format(new Date());
    
    abstract void execute();
  }
  
  static final class b
    extends x.a
  {
    final int id;
    final int key;
    final int value;
    
    b(int paramInt1, int paramInt2)
    {
      super();
      this.id = paramInt1;
      this.key = paramInt2;
      this.value = 1;
    }
    
    final void execute()
    {
      AppMethodBeat.i(248792);
      f.Iyx.idkeyStat(this.id, this.key, this.value, true);
      AppMethodBeat.o(248792);
    }
  }
  
  static final class c
    extends x.a
  {
    final Object[] Zo;
    final int id;
    
    c(int paramInt, Object... paramVarArgs)
    {
      super();
      this.id = paramInt;
      this.Zo = paramVarArgs;
    }
    
    final void execute()
    {
      AppMethodBeat.i(248919);
      f.Iyx.a(this.id, true, true, false, this.Zo);
      AppMethodBeat.o(248919);
    }
  }
  
  static final class d
    extends x.a
  {
    final int level;
    final String msg;
    final String tag;
    
    d(int paramInt, String paramString1, String paramString2)
    {
      super();
      this.level = paramInt;
      this.tag = paramString1;
      this.msg = paramString2;
    }
    
    final void execute()
    {
      AppMethodBeat.i(249515);
      switch (this.level)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(249515);
        return;
        com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.fdH, this.msg });
        AppMethodBeat.o(249515);
        return;
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.fdH, this.msg });
        AppMethodBeat.o(249515);
        return;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.fdH, this.msg });
        AppMethodBeat.o(249515);
        return;
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.fdH, this.msg });
        AppMethodBeat.o(249515);
        return;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.fdH, this.msg });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.x
 * JD-Core Version:    0.7.0.1
 */
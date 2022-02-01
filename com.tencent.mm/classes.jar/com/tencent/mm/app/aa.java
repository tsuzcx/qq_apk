package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aa
{
  private static final List<aa.a> hhu;
  private static final boolean[] hhv;
  
  static
  {
    AppMethodBeat.i(239180);
    hhu = new ArrayList();
    hhv = new boolean[] { false };
    AppMethodBeat.o(239180);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(239158);
    synchronized (hhv)
    {
      if (hhv[0] != 0) {
        com.tencent.mm.sdk.platformtools.Log.i(paramString1, paramString2, paramVarArgs);
      }
      for (;;)
      {
        AppMethodBeat.o(239158);
        return;
        List localList = hhu;
        String str = paramString2;
        try
        {
          if (paramVarArgs.length > 0) {
            str = String.format(paramString2, paramVarArgs);
          }
          hhu.add(new d(4, paramString1, str));
        }
        finally
        {
          AppMethodBeat.o(239158);
        }
      }
    }
  }
  
  public static void a(String paramString1, Throwable arg1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(239166);
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (hhv)
      {
        if (hhv[0] != 0)
        {
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(paramString1, ???, paramString2, paramVarArgs);
          AppMethodBeat.o(239166);
          return;
        }
        localStringBuilder = new StringBuilder();
        if (paramVarArgs.length > 0)
        {
          localStringBuilder.append(String.format(paramString2, paramVarArgs));
          localStringBuilder.append("  ").append(android.util.Log.getStackTraceString(???));
          synchronized (hhu)
          {
            hhu.add(new d(6, paramString1, localStringBuilder.toString()));
          }
        }
      }
      localStringBuilder.append(paramString2);
    }
  }
  
  public static void aCL()
  {
    AppMethodBeat.i(239171);
    synchronized (hhv)
    {
      if (hhv[0] != 0) {
        f.Ozc.idkeyStat(1141L, 0L, 1L, true);
      }
      for (;;)
      {
        AppMethodBeat.o(239171);
        return;
        synchronized (hhu)
        {
          hhu.add(new b());
        }
      }
    }
  }
  
  public static void b(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(239168);
    synchronized (hhv)
    {
      if (hhv[0] != 0) {
        f.Ozc.b(paramInt, paramVarArgs);
      }
      for (;;)
      {
        AppMethodBeat.o(239168);
        return;
        synchronized (hhu)
        {
          hhu.add(new c(paramInt, paramVarArgs));
        }
      }
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(239161);
    synchronized (hhv)
    {
      if (hhv[0] != 0) {
        com.tencent.mm.sdk.platformtools.Log.w(paramString1, paramString2, paramVarArgs);
      }
      for (;;)
      {
        AppMethodBeat.o(239161);
        return;
        List localList = hhu;
        String str = paramString2;
        try
        {
          if (paramVarArgs.length > 0) {
            str = String.format(paramString2, paramVarArgs);
          }
          hhu.add(new d(5, paramString1, str));
        }
        finally
        {
          AppMethodBeat.o(239161);
        }
      }
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... arg2)
  {
    AppMethodBeat.i(239162);
    synchronized (hhv)
    {
      if (hhv[0] != 0) {
        com.tencent.mm.sdk.platformtools.Log.e(paramString1, paramString2, ???);
      }
      for (;;)
      {
        AppMethodBeat.o(239162);
        return;
        synchronized (hhu)
        {
          hhu.add(new d(6, paramString1, paramString2));
        }
      }
    }
  }
  
  public static void execute()
  {
    AppMethodBeat.i(239176);
    synchronized (hhv)
    {
      synchronized (hhu)
      {
        Iterator localIterator = hhu.iterator();
        if (localIterator.hasNext()) {
          ((aa.a)localIterator.next()).execute();
        }
      }
    }
    hhv[0] = true;
    AppMethodBeat.o(239176);
  }
  
  static final class b
    extends aa.a
  {
    final int id = 1141;
    final int key = 0;
    final int value = 1;
    
    b()
    {
      super();
    }
    
    final void execute()
    {
      AppMethodBeat.i(239244);
      f.Ozc.idkeyStat(this.id, this.key, this.value, true);
      AppMethodBeat.o(239244);
    }
  }
  
  static final class c
    extends aa.a
  {
    final Object[] aqm;
    final int id;
    
    c(int paramInt, Object... paramVarArgs)
    {
      super();
      this.id = paramInt;
      this.aqm = paramVarArgs;
    }
    
    final void execute()
    {
      AppMethodBeat.i(239253);
      f.Ozc.a(this.id, true, true, false, this.aqm);
      AppMethodBeat.o(239253);
    }
  }
  
  static final class d
    extends aa.a
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
      AppMethodBeat.i(239256);
      switch (this.level)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(239256);
        return;
        com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.hhx, this.msg });
        AppMethodBeat.o(239256);
        return;
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.hhx, this.msg });
        AppMethodBeat.o(239256);
        return;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.hhx, this.msg });
        AppMethodBeat.o(239256);
        return;
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.hhx, this.msg });
        AppMethodBeat.o(239256);
        return;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.hhx, this.msg });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.aa
 * JD-Core Version:    0.7.0.1
 */
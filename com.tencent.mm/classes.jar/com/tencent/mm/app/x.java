package com.tencent.mm.app;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class x
{
  private static final List<a> dlZ;
  private static final boolean[] dma;
  
  static
  {
    AppMethodBeat.i(200817);
    dlZ = new ArrayList();
    dma = new boolean[] { false };
    AppMethodBeat.o(200817);
  }
  
  public static void WF()
  {
    AppMethodBeat.i(200814);
    synchronized (dma)
    {
      if (dma[0] != 0) {
        e.Cxv.idkeyStat(1557L, 40L, 1L, true);
      }
      for (;;)
      {
        AppMethodBeat.o(200814);
        return;
        synchronized (dlZ)
        {
          dlZ.add(new c());
        }
      }
    }
  }
  
  public static void a(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200813);
    synchronized (dma)
    {
      if (dma[0] != 0) {
        e.Cxv.a(paramInt, paramVarArgs);
      }
      for (;;)
      {
        AppMethodBeat.o(200813);
        return;
        synchronized (dlZ)
        {
          dlZ.add(new d(paramInt, paramVarArgs));
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(200810);
    synchronized (dma)
    {
      if (dma[0] != 0) {
        com.tencent.mm.sdk.platformtools.Log.i(paramString1, paramString2, paramVarArgs);
      }
      for (;;)
      {
        AppMethodBeat.o(200810);
        return;
        List localList = dlZ;
        String str = paramString2;
        try
        {
          if (paramVarArgs.length > 0) {
            str = String.format(paramString2, paramVarArgs);
          }
          dlZ.add(new e(4, paramString1, str));
        }
        finally
        {
          AppMethodBeat.o(200810);
        }
      }
    }
  }
  
  public static void a(String paramString1, Throwable arg1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(200812);
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (dma)
      {
        if (dma[0] != 0)
        {
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(paramString1, ???, paramString2, paramVarArgs);
          AppMethodBeat.o(200812);
          return;
        }
        localStringBuilder = new StringBuilder();
        if (paramVarArgs.length > 0)
        {
          localStringBuilder.append(String.format(paramString2, paramVarArgs));
          localStringBuilder.append("  ").append(android.util.Log.getStackTraceString(???));
          synchronized (dlZ)
          {
            dlZ.add(new e(6, paramString1, localStringBuilder.toString()));
          }
        }
      }
      localStringBuilder.append(paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(200811);
    synchronized (dma)
    {
      if (dma[0] != 0) {
        com.tencent.mm.sdk.platformtools.Log.w(paramString1, paramString2, paramVarArgs);
      }
      for (;;)
      {
        AppMethodBeat.o(200811);
        return;
        List localList = dlZ;
        String str = paramString2;
        try
        {
          if (paramVarArgs.length > 0) {
            str = String.format(paramString2, paramVarArgs);
          }
          dlZ.add(new e(5, paramString1, str));
        }
        finally
        {
          AppMethodBeat.o(200811);
        }
      }
    }
  }
  
  public static void execute()
  {
    AppMethodBeat.i(200816);
    synchronized (dma)
    {
      synchronized (dlZ)
      {
        Iterator localIterator = dlZ.iterator();
        if (localIterator.hasNext()) {
          ((a)localIterator.next()).execute();
        }
      }
    }
    dma[0] = true;
    AppMethodBeat.o(200816);
  }
  
  public static void f(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(200815);
    synchronized (dma)
    {
      if (dma[0] != 0) {
        e.Cxv.b(paramArrayList, true);
      }
      for (;;)
      {
        AppMethodBeat.o(200815);
        return;
        synchronized (dlZ)
        {
          dlZ.add(new b(paramArrayList));
        }
      }
    }
  }
  
  static abstract class a
  {
    final SimpleDateFormat dmb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
    final String dmc = this.dmb.format(new Date());
    
    abstract void execute();
  }
  
  static final class b
    extends x.a
  {
    final ArrayList<IDKey> dmd;
    
    b(ArrayList<IDKey> paramArrayList)
    {
      super();
      this.dmd = paramArrayList;
    }
    
    final void execute()
    {
      AppMethodBeat.i(200806);
      e.Cxv.b(this.dmd, true);
      AppMethodBeat.o(200806);
    }
  }
  
  static final class c
    extends x.a
  {
    final int id = 1557;
    final int key = 40;
    final int value = 1;
    
    c()
    {
      super();
    }
    
    final void execute()
    {
      AppMethodBeat.i(200807);
      e.Cxv.idkeyStat(this.id, this.key, this.value, true);
      AppMethodBeat.o(200807);
    }
  }
  
  static final class d
    extends x.a
  {
    final Object[] apH;
    final int id;
    
    d(int paramInt, Object... paramVarArgs)
    {
      super();
      this.id = paramInt;
      this.apH = paramVarArgs;
    }
    
    final void execute()
    {
      AppMethodBeat.i(200808);
      e.Cxv.a(this.id, true, true, false, this.apH);
      AppMethodBeat.o(200808);
    }
  }
  
  static final class e
    extends x.a
  {
    final int level;
    final String msg;
    final String tag;
    
    e(int paramInt, String paramString1, String paramString2)
    {
      super();
      this.level = paramInt;
      this.tag = paramString1;
      this.msg = paramString2;
    }
    
    final void execute()
    {
      AppMethodBeat.i(200809);
      switch (this.level)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(200809);
        return;
        com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.dmc, this.msg });
        AppMethodBeat.o(200809);
        return;
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.dmc, this.msg });
        AppMethodBeat.o(200809);
        return;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.dmc, this.msg });
        AppMethodBeat.o(200809);
        return;
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.dmc, this.msg });
        AppMethodBeat.o(200809);
        return;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", new Object[] { this.tag, this.dmc, this.msg });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.x
 * JD-Core Version:    0.7.0.1
 */
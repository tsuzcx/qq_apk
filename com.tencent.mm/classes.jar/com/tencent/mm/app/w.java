package com.tencent.mm.app;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class w
{
  private static final List<c> cMk;
  private static final List<b> cMl;
  private static final List<Object> cMm;
  
  static
  {
    AppMethodBeat.i(189185);
    cMk = new ArrayList();
    cMl = new ArrayList();
    cMm = new ArrayList();
    AppMethodBeat.o(189185);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(189181);
    List localList = cMk;
    String str = paramString2;
    try
    {
      if (paramVarArgs.length > 0) {
        str = String.format(paramString2, paramVarArgs);
      }
      cMk.add(new c(4, paramString1, str));
      return;
    }
    finally
    {
      AppMethodBeat.o(189181);
    }
  }
  
  public static void a(String paramString1, Throwable arg1, String paramVarArgs)
  {
    AppMethodBeat.i(189182);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVarArgs);
    localStringBuilder.append("  ").append(Log.getStackTraceString(???));
    synchronized (cMk)
    {
      cMk.add(new c(6, paramString1, localStringBuilder.toString()));
      AppMethodBeat.o(189182);
      return;
    }
  }
  
  public static void execute()
  {
    AppMethodBeat.i(189184);
    synchronized (cMk)
    {
      Iterator localIterator1 = cMk.iterator();
      if (localIterator1.hasNext()) {
        ((a)localIterator1.next()).execute();
      }
    }
    synchronized (cMm)
    {
      Iterator localIterator2 = cMm.iterator();
      if (localIterator2.hasNext()) {
        ((a)localIterator2.next()).execute();
      }
    }
    synchronized (cMl)
    {
      Iterator localIterator3 = cMl.iterator();
      if (localIterator3.hasNext()) {
        ((a)localIterator3.next()).execute();
      }
    }
    AppMethodBeat.o(189184);
  }
  
  public static void f(Object... paramVarArgs)
  {
    AppMethodBeat.i(189183);
    synchronized (cMl)
    {
      cMl.add(new b(paramVarArgs));
      AppMethodBeat.o(189183);
      return;
    }
  }
  
  static abstract class a
  {
    final SimpleDateFormat cMn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
    final String cMo = this.cMn.format(new Date());
    
    abstract void execute();
  }
  
  static final class b
    extends w.a
  {
    final Object[] amI;
    final int id = 19725;
    
    b(Object... paramVarArgs)
    {
      super();
      this.amI = paramVarArgs;
    }
    
    final void execute()
    {
      AppMethodBeat.i(189179);
      e.vIY.a(this.id, true, true, false, this.amI);
      AppMethodBeat.o(189179);
    }
  }
  
  static final class c
    extends w.a
  {
    final String bLg;
    final int level;
    final String tag;
    
    c(int paramInt, String paramString1, String paramString2)
    {
      super();
      this.level = paramInt;
      this.tag = paramString1;
      this.bLg = paramString2;
    }
    
    final void execute()
    {
      AppMethodBeat.i(189180);
      switch (this.level)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(189180);
        return;
        ad.v("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cMo, this.bLg });
        AppMethodBeat.o(189180);
        return;
        ad.d("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cMo, this.bLg });
        AppMethodBeat.o(189180);
        return;
        ad.i("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cMo, this.bLg });
        AppMethodBeat.o(189180);
        return;
        ad.w("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cMo, this.bLg });
        AppMethodBeat.o(189180);
        return;
        ad.e("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cMo, this.bLg });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.w
 * JD-Core Version:    0.7.0.1
 */
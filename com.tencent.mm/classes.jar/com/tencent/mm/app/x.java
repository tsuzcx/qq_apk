package com.tencent.mm.app;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class x
{
  private static final List<c> cVF;
  private static final List<b> cVG;
  private static final List<Object> cVH;
  
  static
  {
    AppMethodBeat.i(210663);
    cVF = new ArrayList();
    cVG = new ArrayList();
    cVH = new ArrayList();
    AppMethodBeat.o(210663);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(210659);
    List localList = cVF;
    String str = paramString2;
    try
    {
      if (paramVarArgs.length > 0) {
        str = String.format(paramString2, paramVarArgs);
      }
      cVF.add(new c(4, paramString1, str));
      return;
    }
    finally
    {
      AppMethodBeat.o(210659);
    }
  }
  
  public static void a(String paramString1, Throwable arg1, String paramVarArgs)
  {
    AppMethodBeat.i(210660);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVarArgs);
    localStringBuilder.append("  ").append(Log.getStackTraceString(???));
    synchronized (cVF)
    {
      cVF.add(new c(6, paramString1, localStringBuilder.toString()));
      AppMethodBeat.o(210660);
      return;
    }
  }
  
  public static void execute()
  {
    AppMethodBeat.i(210662);
    synchronized (cVF)
    {
      Iterator localIterator1 = cVF.iterator();
      if (localIterator1.hasNext()) {
        ((a)localIterator1.next()).execute();
      }
    }
    synchronized (cVH)
    {
      Iterator localIterator2 = cVH.iterator();
      if (localIterator2.hasNext()) {
        ((a)localIterator2.next()).execute();
      }
    }
    synchronized (cVG)
    {
      Iterator localIterator3 = cVG.iterator();
      if (localIterator3.hasNext()) {
        ((a)localIterator3.next()).execute();
      }
    }
    AppMethodBeat.o(210662);
  }
  
  public static void f(Object... paramVarArgs)
  {
    AppMethodBeat.i(210661);
    synchronized (cVG)
    {
      cVG.add(new b(paramVarArgs));
      AppMethodBeat.o(210661);
      return;
    }
  }
  
  static abstract class a
  {
    final SimpleDateFormat cVI = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
    final String cVJ = this.cVI.format(new Date());
    
    abstract void execute();
  }
  
  static final class b
    extends x.a
  {
    final Object[] apv;
    final int id = 19725;
    
    b(Object... paramVarArgs)
    {
      super();
      this.apv = paramVarArgs;
    }
    
    final void execute()
    {
      AppMethodBeat.i(210657);
      e.ywz.a(this.id, true, true, false, this.apv);
      AppMethodBeat.o(210657);
    }
  }
  
  static final class c
    extends x.a
  {
    final int level;
    final String msg;
    final String tag;
    
    c(int paramInt, String paramString1, String paramString2)
    {
      super();
      this.level = paramInt;
      this.tag = paramString1;
      this.msg = paramString2;
    }
    
    final void execute()
    {
      AppMethodBeat.i(210658);
      switch (this.level)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(210658);
        return;
        ae.v("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cVJ, this.msg });
        AppMethodBeat.o(210658);
        return;
        ae.d("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cVJ, this.msg });
        AppMethodBeat.o(210658);
        return;
        ae.i("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cVJ, this.msg });
        AppMethodBeat.o(210658);
        return;
        ae.w("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cVJ, this.msg });
        AppMethodBeat.o(210658);
        return;
        ae.e("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cVJ, this.msg });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.x
 * JD-Core Version:    0.7.0.1
 */
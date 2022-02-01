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

public final class x
{
  private static final List<c> cUI;
  private static final List<b> cUJ;
  private static final List<Object> cUK;
  
  static
  {
    AppMethodBeat.i(199823);
    cUI = new ArrayList();
    cUJ = new ArrayList();
    cUK = new ArrayList();
    AppMethodBeat.o(199823);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(199819);
    List localList = cUI;
    String str = paramString2;
    try
    {
      if (paramVarArgs.length > 0) {
        str = String.format(paramString2, paramVarArgs);
      }
      cUI.add(new c(4, paramString1, str));
      return;
    }
    finally
    {
      AppMethodBeat.o(199819);
    }
  }
  
  public static void a(String paramString1, Throwable arg1, String paramVarArgs)
  {
    AppMethodBeat.i(199820);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVarArgs);
    localStringBuilder.append("  ").append(Log.getStackTraceString(???));
    synchronized (cUI)
    {
      cUI.add(new c(6, paramString1, localStringBuilder.toString()));
      AppMethodBeat.o(199820);
      return;
    }
  }
  
  public static void execute()
  {
    AppMethodBeat.i(199822);
    synchronized (cUI)
    {
      Iterator localIterator1 = cUI.iterator();
      if (localIterator1.hasNext()) {
        ((a)localIterator1.next()).execute();
      }
    }
    synchronized (cUK)
    {
      Iterator localIterator2 = cUK.iterator();
      if (localIterator2.hasNext()) {
        ((a)localIterator2.next()).execute();
      }
    }
    synchronized (cUJ)
    {
      Iterator localIterator3 = cUJ.iterator();
      if (localIterator3.hasNext()) {
        ((a)localIterator3.next()).execute();
      }
    }
    AppMethodBeat.o(199822);
  }
  
  public static void g(Object... paramVarArgs)
  {
    AppMethodBeat.i(199821);
    synchronized (cUJ)
    {
      cUJ.add(new b(paramVarArgs));
      AppMethodBeat.o(199821);
      return;
    }
  }
  
  static abstract class a
  {
    final SimpleDateFormat cUL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
    final String cUM = this.cUL.format(new Date());
    
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
      AppMethodBeat.i(199817);
      e.ygI.a(this.id, true, true, false, this.apv);
      AppMethodBeat.o(199817);
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
      AppMethodBeat.i(199818);
      switch (this.level)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(199818);
        return;
        ad.v("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cUM, this.msg });
        AppMethodBeat.o(199818);
        return;
        ad.d("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cUM, this.msg });
        AppMethodBeat.o(199818);
        return;
        ad.i("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cUM, this.msg });
        AppMethodBeat.o(199818);
        return;
        ad.w("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cUM, this.msg });
        AppMethodBeat.o(199818);
        return;
        ad.e("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cUM, this.msg });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.x
 * JD-Core Version:    0.7.0.1
 */
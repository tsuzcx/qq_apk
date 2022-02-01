package com.tencent.mm.app;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class x
{
  private static final List<c> cJv;
  private static final List<b> cJw;
  private static final List<Object> cJx;
  
  static
  {
    AppMethodBeat.i(192570);
    cJv = new ArrayList();
    cJw = new ArrayList();
    cJx = new ArrayList();
    AppMethodBeat.o(192570);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(192566);
    List localList = cJv;
    String str = paramString2;
    try
    {
      if (paramVarArgs.length > 0) {
        str = String.format(paramString2, paramVarArgs);
      }
      cJv.add(new c(4, paramString1, str));
      return;
    }
    finally
    {
      AppMethodBeat.o(192566);
    }
  }
  
  public static void a(String paramString1, Throwable arg1, String paramVarArgs)
  {
    AppMethodBeat.i(192567);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVarArgs);
    localStringBuilder.append("  ").append(Log.getStackTraceString(???));
    synchronized (cJv)
    {
      cJv.add(new c(6, paramString1, localStringBuilder.toString()));
      AppMethodBeat.o(192567);
      return;
    }
  }
  
  public static void execute()
  {
    AppMethodBeat.i(192569);
    synchronized (cJv)
    {
      Iterator localIterator1 = cJv.iterator();
      if (localIterator1.hasNext()) {
        ((a)localIterator1.next()).execute();
      }
    }
    synchronized (cJx)
    {
      Iterator localIterator2 = cJx.iterator();
      if (localIterator2.hasNext()) {
        ((a)localIterator2.next()).execute();
      }
    }
    synchronized (cJw)
    {
      Iterator localIterator3 = cJw.iterator();
      if (localIterator3.hasNext()) {
        ((a)localIterator3.next()).execute();
      }
    }
    AppMethodBeat.o(192569);
  }
  
  public static void g(Object... paramVarArgs)
  {
    AppMethodBeat.i(192568);
    synchronized (cJw)
    {
      cJw.add(new b(paramVarArgs));
      AppMethodBeat.o(192568);
      return;
    }
  }
  
  static abstract class a
  {
    final SimpleDateFormat cJy = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
    final String cJz = this.cJy.format(new Date());
    
    abstract void execute();
  }
  
  static final class b
    extends x.a
  {
    final Object[] anD;
    final int id = 19725;
    
    b(Object... paramVarArgs)
    {
      super();
      this.anD = paramVarArgs;
    }
    
    final void execute()
    {
      AppMethodBeat.i(192564);
      e.wTc.a(this.id, true, true, false, this.anD);
      AppMethodBeat.o(192564);
    }
  }
  
  static final class c
    extends x.a
  {
    final String bIO;
    final int level;
    final String tag;
    
    c(int paramInt, String paramString1, String paramString2)
    {
      super();
      this.level = paramInt;
      this.tag = paramString1;
      this.bIO = paramString2;
    }
    
    final void execute()
    {
      AppMethodBeat.i(192565);
      switch (this.level)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(192565);
        return;
        ac.v("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cJz, this.bIO });
        AppMethodBeat.o(192565);
        return;
        ac.d("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cJz, this.bIO });
        AppMethodBeat.o(192565);
        return;
        ac.i("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cJz, this.bIO });
        AppMethodBeat.o(192565);
        return;
        ac.w("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cJz, this.bIO });
        AppMethodBeat.o(192565);
        return;
        ac.e("MicroMsg.PendingOps", "[%s @ %s] %s", new Object[] { this.tag, this.cJz, this.bIO });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.x
 * JD-Core Version:    0.7.0.1
 */
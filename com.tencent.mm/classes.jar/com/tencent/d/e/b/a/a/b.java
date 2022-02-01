package com.tencent.d.e.b.a.a;

import android.content.Context;
import android.os.Build;
import com.tencent.d.e.b.a.a.a.d;
import com.tencent.d.e.b.a.a.a.e;
import com.tencent.d.e.b.a.a.a.f;
import com.tencent.d.e.b.a.a.a.g;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static Map<String, a> JUq;
  private static c JUr;
  private static String JUs;
  
  static
  {
    AppMethodBeat.i(138431);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    JUq = localConcurrentHashMap;
    localConcurrentHashMap.put("FF5E66B", new a(new g()));
    JUq.put("C1AAFC7", new a(new com.tencent.d.e.b.a.a.a.c()));
    JUq.put("E389A21", new a(new d()));
    JUq.put("750379B", new a(new d()));
    JUq.put("C892BA2", new a(new e()));
    JUq.put("C1F2239", new a(new com.tencent.d.e.b.a.a.a.a()));
    JUq.put("B09207F", new a(new f()));
    JUs = "";
    try
    {
      JUs = com.tencent.d.e.b.a.a.b.b.cG(com.tencent.d.e.b.a.a.b.a.cF(Build.MANUFACTURER.toLowerCase().getBytes())).substring(0, 7);
      AppMethodBeat.o(138431);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(138431);
    }
  }
  
  public static c kG(final Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(138430);
        if ((JUr != null) && (JUr.errorCode == 0))
        {
          paramContext = JUr;
          AppMethodBeat.o(138430);
          return paramContext;
        }
        if (!JUq.containsKey(JUs))
        {
          paramContext = c.aeg(-10);
          AppMethodBeat.o(138430);
          continue;
        }
        if (!"main".equals(Thread.currentThread().getName())) {
          break label99;
        }
      }
      finally {}
      paramContext = c.aeg(-11);
      AppMethodBeat.o(138430);
      continue;
      label99:
      a locala = (a)JUq.get(JUs);
      if ((locala != null) && (locala.gLY <= 5))
      {
        locala.gLY += 1;
        JUr = locala.JUu.kG(paramContext);
      }
      if ((locala != null) && (JUr.errorCode != 0)) {
        com.tencent.e.h.JZN.aV(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "msa-internal-init";
          }
          
          public final void run()
          {
            AppMethodBeat.i(138429);
            try
            {
              b.a(this.JUt.JUu.kG(paramContext));
              return;
            }
            finally
            {
              AppMethodBeat.o(138429);
            }
          }
        });
      }
      paramContext = JUr;
      AppMethodBeat.o(138430);
    }
  }
  
  static final class a
  {
    a JUu;
    int gLY = 0;
    
    public a(a parama)
    {
      this.JUu = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */
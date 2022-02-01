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
  private static Map<String, a> IsG;
  private static c IsH;
  private static String IsI;
  
  static
  {
    AppMethodBeat.i(138431);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    IsG = localConcurrentHashMap;
    localConcurrentHashMap.put("FF5E66B", new a(new g()));
    IsG.put("C1AAFC7", new a(new com.tencent.d.e.b.a.a.a.c()));
    IsG.put("E389A21", new a(new d()));
    IsG.put("750379B", new a(new d()));
    IsG.put("C892BA2", new a(new e()));
    IsG.put("C1F2239", new a(new com.tencent.d.e.b.a.a.a.a()));
    IsG.put("B09207F", new a(new f()));
    IsI = "";
    try
    {
      IsI = com.tencent.d.e.b.a.a.b.b.cH(com.tencent.d.e.b.a.a.b.a.cG(Build.MANUFACTURER.toLowerCase().getBytes())).substring(0, 7);
      AppMethodBeat.o(138431);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(138431);
    }
  }
  
  public static c ku(final Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(138430);
        if ((IsH != null) && (IsH.errorCode == 0))
        {
          paramContext = IsH;
          AppMethodBeat.o(138430);
          return paramContext;
        }
        if (!IsG.containsKey(IsI))
        {
          paramContext = c.abN(-10);
          AppMethodBeat.o(138430);
          continue;
        }
        if (!"main".equals(Thread.currentThread().getName())) {
          break label99;
        }
      }
      finally {}
      paramContext = c.abN(-11);
      AppMethodBeat.o(138430);
      continue;
      label99:
      a locala = (a)IsG.get(IsI);
      if ((locala != null) && (locala.gll <= 5))
      {
        locala.gll += 1;
        IsH = locala.IsK.ku(paramContext);
      }
      if ((locala != null) && (IsH.errorCode != 0)) {
        com.tencent.e.h.Iye.aS(new com.tencent.e.i.h()
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
              b.a(this.IsJ.IsK.ku(paramContext));
              return;
            }
            finally
            {
              AppMethodBeat.o(138429);
            }
          }
        });
      }
      paramContext = IsH;
      AppMethodBeat.o(138430);
    }
  }
  
  static final class a
  {
    a IsK;
    int gll = 0;
    
    public a(a parama)
    {
      this.IsK = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.e.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */
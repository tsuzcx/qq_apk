package com.tencent.mm.plugin.expansions;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.cr.d;
import com.tencent.mm.cr.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.toolkit.frontia.a.c.a;
import com.tencent.mm.toolkit.frontia.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final byte[] pih;
  private static final byte[] pii;
  private static final byte[] pij;
  private static final Object pik;
  private static volatile boolean pil;
  private static volatile boolean pim;
  private static volatile c.a pio;
  private static volatile com.tencent.mm.toolkit.frontia.a.a pip;
  private static final List<String> piq;
  
  static
  {
    AppMethodBeat.i(152964);
    pih = new byte[] { 7, 2, -1, -1, -4, 8, -10, -3, 4, 2, -8, -4, 9, 5, -6, -17, 3, 4, 3, 1 };
    pii = new byte[0];
    pij = new byte[0];
    pik = j.class;
    pil = true;
    pim = true;
    piq = new ArrayList();
    pio = new c.a()
    {
      public final File cbf()
      {
        AppMethodBeat.i(190363);
        File localFile = new File(aj.getContext().getApplicationInfo().nativeLibraryDir);
        AppMethodBeat.o(190363);
        return localFile;
      }
      
      public final AssetManager getAssets()
      {
        AppMethodBeat.i(152955);
        AssetManager localAssetManager = aj.getContext().getAssets();
        AppMethodBeat.o(152955);
        return localAssetManager;
      }
    };
    d locald = d.cbg();
    pip = new com.tencent.mm.toolkit.frontia.a.a(locald, new c(locald));
    AppMethodBeat.o(152964);
  }
  
  public static boolean GE()
  {
    return true;
  }
  
  public static boolean Vi(String paramString)
  {
    AppMethodBeat.i(152962);
    if (piq.contains(paramString))
    {
      AppMethodBeat.o(152962);
      return true;
    }
    try
    {
      a.class.getClassLoader();
      j.pq(paramString);
      piq.add(paramString);
      AppMethodBeat.o(152962);
      return true;
    }
    catch (Throwable paramString)
    {
      ad.w("MicroMsg.exp.Expansions", "tryLoadLibrary fail, error = " + paramString.getMessage());
      AppMethodBeat.o(152962);
    }
    return false;
  }
  
  public static Future<?> a(a.a parama)
  {
    AppMethodBeat.i(152961);
    parama.a(pio.getAssets());
    parama = pip.BHE;
    AppMethodBeat.o(152961);
    return parama;
  }
  
  public static Future<?> a(a.b paramb)
  {
    AppMethodBeat.i(152960);
    paramb.a(pio);
    paramb = pip.BHE;
    AppMethodBeat.o(152960);
    return paramb;
  }
  
  static boolean caV()
  {
    for (;;)
    {
      synchronized (pij)
      {
        if (pip != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  static boolean caW()
  {
    return true;
  }
  
  static void caX() {}
  
  static void caY() {}
  
  public static boolean caZ()
  {
    return true;
  }
  
  public static boolean cba()
  {
    return true;
  }
  
  public static boolean cbb()
  {
    return false;
  }
  
  public static boolean cbc()
  {
    return true;
  }
  
  public static String cbd()
  {
    AppMethodBeat.i(190367);
    if (pio == null)
    {
      AppMethodBeat.o(190367);
      return null;
    }
    String str = pio.cbf().getAbsolutePath() + File.separator;
    AppMethodBeat.o(190367);
    return str;
  }
  
  static boolean cbe()
  {
    AppMethodBeat.i(152963);
    boolean bool = aj.cbe();
    AppMethodBeat.o(152963);
    return bool;
  }
  
  public static boolean isEnabled()
  {
    return false;
  }
  
  static void prepare()
  {
    AppMethodBeat.i(190366);
    d.a(new d.a()
    {
      public final boolean GE()
      {
        AppMethodBeat.i(190364);
        boolean bool = a.GE();
        AppMethodBeat.o(190364);
        return bool;
      }
      
      public final String cbd()
      {
        AppMethodBeat.i(190365);
        String str = a.cbd();
        AppMethodBeat.o(190365);
        return str;
      }
    });
    AppMethodBeat.o(190366);
  }
  
  static final class c<T>
    implements Future<T>
  {
    private final T result;
    
    public c(T paramT)
    {
      this.result = paramT;
    }
    
    public final boolean cancel(boolean paramBoolean)
    {
      return false;
    }
    
    public final T get()
    {
      return this.result;
    }
    
    public final T get(long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(152956);
      paramTimeUnit = get();
      AppMethodBeat.o(152956);
      return paramTimeUnit;
    }
    
    public final boolean isCancelled()
    {
      return false;
    }
    
    public final boolean isDone()
    {
      return true;
    }
  }
  
  static final class d
    extends com.tencent.mm.toolkit.frontia.a.a<Object>
  {
    public static final String pir;
    public boolean pis;
    
    static
    {
      AppMethodBeat.i(152959);
      StringBuilder localStringBuilder = new StringBuilder("expansions-");
      String str = Build.CPU_ABI;
      "Capable cpu abi = ".concat(String.valueOf(str));
      b.eOF();
      pir = str + ".obb";
      AppMethodBeat.o(152959);
    }
    
    private d()
    {
      AppMethodBeat.i(152957);
      this.pis = true;
      eOH();
      AppMethodBeat.o(152957);
    }
    
    public static d cbg()
    {
      AppMethodBeat.i(152958);
      d locald = new d();
      locald.eOG();
      locald.aJO("use builtin impl");
      AppMethodBeat.o(152958);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.a
 * JD-Core Version:    0.7.0.1
 */
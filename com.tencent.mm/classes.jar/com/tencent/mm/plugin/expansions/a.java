package com.tencent.mm.plugin.expansions;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.cq.d;
import com.tencent.mm.cq.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.toolkit.frontia.a.c.a;
import com.tencent.mm.toolkit.frontia.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final byte[] pLq;
  private static final byte[] pLr;
  private static final byte[] pLs;
  private static final Object pLt;
  private static volatile boolean pLu;
  private static volatile boolean pLv;
  private static volatile c.a pLw;
  private static volatile com.tencent.mm.toolkit.frontia.a.a pLx;
  private static final List<String> pLy;
  
  static
  {
    AppMethodBeat.i(152964);
    pLq = new byte[] { 7, 2, -1, -1, -4, 8, -10, -3, 4, 2, -8, -4, 9, 5, -6, -17, 3, 4, 3, 1 };
    pLr = new byte[0];
    pLs = new byte[0];
    pLt = j.class;
    pLu = true;
    pLv = true;
    pLy = new ArrayList();
    pLw = new c.a()
    {
      public final File cio()
      {
        AppMethodBeat.i(197372);
        File localFile = new File(ai.getContext().getApplicationInfo().nativeLibraryDir);
        AppMethodBeat.o(197372);
        return localFile;
      }
      
      public final AssetManager getAssets()
      {
        AppMethodBeat.i(152955);
        AssetManager localAssetManager = ai.getContext().getAssets();
        AppMethodBeat.o(152955);
        return localAssetManager;
      }
    };
    d locald = d.cip();
    pLx = new com.tencent.mm.toolkit.frontia.a.a(locald, new c(locald));
    AppMethodBeat.o(152964);
  }
  
  public static boolean Gp()
  {
    return true;
  }
  
  public static boolean Zu(String paramString)
  {
    AppMethodBeat.i(152962);
    if (pLy.contains(paramString))
    {
      AppMethodBeat.o(152962);
      return true;
    }
    try
    {
      a.class.getClassLoader();
      j.sC(paramString);
      pLy.add(paramString);
      AppMethodBeat.o(152962);
      return true;
    }
    catch (Throwable paramString)
    {
      ac.w("MicroMsg.exp.Expansions", "tryLoadLibrary fail, error = " + paramString.getMessage());
      AppMethodBeat.o(152962);
    }
    return false;
  }
  
  public static Future<?> a(a parama)
  {
    AppMethodBeat.i(152961);
    parama.a(pLw.getAssets());
    parama = pLx.CZM;
    AppMethodBeat.o(152961);
    return parama;
  }
  
  public static Future<?> a(b paramb)
  {
    AppMethodBeat.i(152960);
    paramb.a(pLw);
    paramb = pLx.CZM;
    AppMethodBeat.o(152960);
    return paramb;
  }
  
  static boolean cie()
  {
    for (;;)
    {
      synchronized (pLs)
      {
        if (pLx != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  static boolean cif()
  {
    return true;
  }
  
  static void cig() {}
  
  static void cih() {}
  
  public static boolean cii()
  {
    return true;
  }
  
  public static boolean cij()
  {
    return true;
  }
  
  public static boolean cik()
  {
    return false;
  }
  
  public static boolean cil()
  {
    return true;
  }
  
  public static String cim()
  {
    AppMethodBeat.i(197376);
    if (pLw == null)
    {
      AppMethodBeat.o(197376);
      return null;
    }
    String str = pLw.cio().getAbsolutePath() + File.separator;
    AppMethodBeat.o(197376);
    return str;
  }
  
  static boolean cin()
  {
    AppMethodBeat.i(152963);
    boolean bool = ai.cin();
    AppMethodBeat.o(152963);
    return bool;
  }
  
  public static boolean isEnabled()
  {
    return false;
  }
  
  static void prepare()
  {
    AppMethodBeat.i(197375);
    d.a(new d.a()
    {
      public final boolean Gp()
      {
        AppMethodBeat.i(197373);
        boolean bool = a.Gp();
        AppMethodBeat.o(197373);
        return bool;
      }
      
      public final String cim()
      {
        AppMethodBeat.i(197374);
        String str = a.cim();
        AppMethodBeat.o(197374);
        return str;
      }
    });
    AppMethodBeat.o(197375);
  }
  
  public static abstract interface a
  {
    public abstract void a(AssetManager paramAssetManager);
  }
  
  public static abstract interface b
  {
    public abstract void a(c.a parama);
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
    public static final String pLz;
    public boolean pLA;
    
    static
    {
      AppMethodBeat.i(152959);
      StringBuilder localStringBuilder = new StringBuilder("expansions-");
      String str = Build.CPU_ABI;
      "Capable cpu abi = ".concat(String.valueOf(str));
      b.fej();
      pLz = str + ".obb";
      AppMethodBeat.o(152959);
    }
    
    private d()
    {
      AppMethodBeat.i(152957);
      this.pLA = true;
      fel();
      AppMethodBeat.o(152957);
    }
    
    public static d cip()
    {
      AppMethodBeat.i(152958);
      d locald = new d();
      locald.fek();
      locald.aPm("use builtin impl");
      AppMethodBeat.o(152958);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.a
 * JD-Core Version:    0.7.0.1
 */
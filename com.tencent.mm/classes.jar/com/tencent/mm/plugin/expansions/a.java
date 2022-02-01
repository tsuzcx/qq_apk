package com.tencent.mm.plugin.expansions;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.cr.d;
import com.tencent.mm.cr.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.toolkit.frontia.a.c.a;
import com.tencent.mm.toolkit.frontia.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static volatile boolean dmI;
  private static final byte[] rNj;
  private static final byte[] rNk;
  private static final byte[] rNl;
  private static final Object rNm;
  private static volatile boolean rNn;
  private static volatile c.a rNo;
  private static volatile com.tencent.mm.toolkit.frontia.a.a rNp;
  private static final List<String> rNq;
  
  static
  {
    AppMethodBeat.i(152964);
    rNj = new byte[] { 7, 2, -1, -1, -4, 8, -10, -3, 4, 2, -8, -4, 9, 5, -6, -17, 3, 4, 3, 1 };
    rNk = new byte[0];
    rNl = new byte[0];
    rNm = j.class;
    dmI = true;
    rNn = true;
    rNq = new ArrayList();
    rNo = new c.a()
    {
      public final File cMt()
      {
        AppMethodBeat.i(201274);
        File localFile = new File(MMApplicationContext.getContext().getApplicationInfo().nativeLibraryDir);
        AppMethodBeat.o(201274);
        return localFile;
      }
      
      public final AssetManager getAssets()
      {
        AppMethodBeat.i(152955);
        AssetManager localAssetManager = MMApplicationContext.getContext().getAssets();
        AppMethodBeat.o(152955);
        return localAssetManager;
      }
    };
    d locald = d.cMu();
    rNp = new com.tencent.mm.toolkit.frontia.a.a(locald, new c(locald));
    AppMethodBeat.o(152964);
  }
  
  public static Future<?> a(a parama)
  {
    AppMethodBeat.i(152961);
    parama.a(rNo.getAssets());
    parama = rNp.jKp;
    AppMethodBeat.o(152961);
    return parama;
  }
  
  public static Future<?> a(b paramb)
  {
    AppMethodBeat.i(152960);
    paramb.a(rNo);
    paramb = rNp.jKp;
    AppMethodBeat.o(152960);
    return paramb;
  }
  
  public static boolean aoa(String paramString)
  {
    AppMethodBeat.i(152962);
    if (rNq.contains(paramString))
    {
      AppMethodBeat.o(152962);
      return true;
    }
    try
    {
      a.class.getClassLoader();
      j.Ed(paramString);
      rNq.add(paramString);
      AppMethodBeat.o(152962);
      return true;
    }
    catch (Throwable paramString)
    {
      Log.w("MicroMsg.exp.Expansions", "tryLoadLibrary fail, error = " + paramString.getMessage());
      AppMethodBeat.o(152962);
    }
    return false;
  }
  
  static boolean cMk()
  {
    for (;;)
    {
      synchronized (rNl)
      {
        if (rNp != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  static boolean cMl()
  {
    return true;
  }
  
  static void cMm() {}
  
  static void cMn() {}
  
  public static boolean cMo()
  {
    return true;
  }
  
  public static boolean cMp()
  {
    return true;
  }
  
  public static boolean cMq()
  {
    return false;
  }
  
  public static boolean cMr()
  {
    return true;
  }
  
  public static String cMs()
  {
    AppMethodBeat.i(201278);
    if (rNo == null)
    {
      AppMethodBeat.o(201278);
      return null;
    }
    String str = rNo.cMt().getAbsolutePath() + File.separator;
    AppMethodBeat.o(201278);
    return str;
  }
  
  public static boolean isEnabled()
  {
    return false;
  }
  
  public static boolean isInstalled()
  {
    return true;
  }
  
  static boolean isMainProcess()
  {
    AppMethodBeat.i(152963);
    boolean bool = MMApplicationContext.isMainProcess();
    AppMethodBeat.o(152963);
    return bool;
  }
  
  static void prepare()
  {
    AppMethodBeat.i(201277);
    d.a(new d.a()
    {
      public final String cMs()
      {
        AppMethodBeat.i(201276);
        String str = a.cMs();
        AppMethodBeat.o(201276);
        return str;
      }
      
      public final boolean isInstalled()
      {
        AppMethodBeat.i(201275);
        boolean bool = a.isInstalled();
        AppMethodBeat.o(201275);
        return bool;
      }
    });
    AppMethodBeat.o(201277);
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
    public static final String rNr;
    public boolean rNs;
    
    static
    {
      AppMethodBeat.i(152959);
      StringBuilder localStringBuilder = new StringBuilder("expansions-");
      String str = Build.CPU_ABI;
      "Capable cpu abi = ".concat(String.valueOf(str));
      b.gGg();
      rNr = str + ".obb";
      AppMethodBeat.o(152959);
    }
    
    private d()
    {
      AppMethodBeat.i(152957);
      this.rNs = true;
      gGi();
      AppMethodBeat.o(152957);
    }
    
    public static d cMu()
    {
      AppMethodBeat.i(152958);
      d locald = new d();
      locald.gGh();
      locald.blD("use builtin impl");
      AppMethodBeat.o(152958);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expansions;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.cp.d;
import com.tencent.mm.cp.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.toolkit.frontia.a.c.a;
import com.tencent.mm.toolkit.frontia.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public final class a
{
  private static final byte[] qvB;
  private static final byte[] qvC;
  private static final byte[] qvD;
  private static final Object qvE;
  private static volatile boolean qvF;
  private static volatile boolean qvG;
  private static volatile c.a qvH;
  private static volatile com.tencent.mm.toolkit.frontia.a.a qvI;
  private static final List<String> qvJ;
  
  static
  {
    AppMethodBeat.i(152964);
    qvB = new byte[] { 7, 2, -1, -1, -4, 8, -10, -3, 4, 2, -8, -4, 9, 5, -6, -17, 3, 4, 3, 1 };
    qvC = new byte[0];
    qvD = new byte[0];
    qvE = j.class;
    qvF = true;
    qvG = true;
    qvJ = new ArrayList();
    qvH = new c.a()
    {
      public final File coi()
      {
        AppMethodBeat.i(194213);
        File localFile = new File(ak.getContext().getApplicationInfo().nativeLibraryDir);
        AppMethodBeat.o(194213);
        return localFile;
      }
      
      public final AssetManager getAssets()
      {
        AppMethodBeat.i(152955);
        AssetManager localAssetManager = ak.getContext().getAssets();
        AppMethodBeat.o(152955);
        return localAssetManager;
      }
    };
    d locald = d.coj();
    qvI = new com.tencent.mm.toolkit.frontia.a.a(locald, new a.c(locald));
    AppMethodBeat.o(152964);
  }
  
  public static boolean HS()
  {
    return true;
  }
  
  public static Future<?> a(a parama)
  {
    AppMethodBeat.i(152961);
    parama.a(qvH.getAssets());
    parama = qvI.EWh;
    AppMethodBeat.o(152961);
    return parama;
  }
  
  public static Future<?> a(a.b paramb)
  {
    AppMethodBeat.i(152960);
    paramb.a(qvH);
    paramb = qvI.EWh;
    AppMethodBeat.o(152960);
    return paramb;
  }
  
  public static boolean adR(String paramString)
  {
    AppMethodBeat.i(152962);
    if (qvJ.contains(paramString))
    {
      AppMethodBeat.o(152962);
      return true;
    }
    try
    {
      a.class.getClassLoader();
      j.vN(paramString);
      qvJ.add(paramString);
      AppMethodBeat.o(152962);
      return true;
    }
    catch (Throwable paramString)
    {
      ae.w("MicroMsg.exp.Expansions", "tryLoadLibrary fail, error = " + paramString.getMessage());
      AppMethodBeat.o(152962);
    }
    return false;
  }
  
  static boolean cnY()
  {
    for (;;)
    {
      synchronized (qvD)
      {
        if (qvI != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  static boolean cnZ()
  {
    return true;
  }
  
  static void coa() {}
  
  static void cob() {}
  
  public static boolean coc()
  {
    return true;
  }
  
  public static boolean cod()
  {
    return true;
  }
  
  public static boolean coe()
  {
    return false;
  }
  
  public static boolean cof()
  {
    return true;
  }
  
  public static String cog()
  {
    AppMethodBeat.i(194217);
    if (qvH == null)
    {
      AppMethodBeat.o(194217);
      return null;
    }
    String str = qvH.coi().getAbsolutePath() + File.separator;
    AppMethodBeat.o(194217);
    return str;
  }
  
  static boolean coh()
  {
    AppMethodBeat.i(152963);
    boolean bool = ak.coh();
    AppMethodBeat.o(152963);
    return bool;
  }
  
  public static boolean isEnabled()
  {
    return false;
  }
  
  static void prepare()
  {
    AppMethodBeat.i(194216);
    d.a(new d.a()
    {
      public final boolean HS()
      {
        AppMethodBeat.i(194214);
        boolean bool = a.HS();
        AppMethodBeat.o(194214);
        return bool;
      }
      
      public final String cog()
      {
        AppMethodBeat.i(194215);
        String str = a.cog();
        AppMethodBeat.o(194215);
        return str;
      }
    });
    AppMethodBeat.o(194216);
  }
  
  public static abstract interface a
  {
    public abstract void a(AssetManager paramAssetManager);
  }
  
  static final class d
    extends com.tencent.mm.toolkit.frontia.a.a<Object>
  {
    public static final String qvK;
    public boolean qvL;
    
    static
    {
      AppMethodBeat.i(152959);
      StringBuilder localStringBuilder = new StringBuilder("expansions-");
      String str = Build.CPU_ABI;
      "Capable cpu abi = ".concat(String.valueOf(str));
      b.fys();
      qvK = str + ".obb";
      AppMethodBeat.o(152959);
    }
    
    private d()
    {
      AppMethodBeat.i(152957);
      this.qvL = true;
      fyu();
      AppMethodBeat.o(152957);
    }
    
    public static d coj()
    {
      AppMethodBeat.i(152958);
      d locald = new d();
      locald.fyt();
      locald.aWE("use builtin impl");
      AppMethodBeat.o(152958);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expansions;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.toolkit.frontia.b;
import com.tencent.mm.xwebutil.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public final class a
{
  private static volatile boolean feW;
  private static final byte[] vsT;
  private static final byte[] vsU;
  private static final byte[] vsV;
  private static final Object vsW;
  private static volatile boolean vsX;
  private static volatile com.tencent.mm.toolkit.frontia.a.c.a vsY;
  private static volatile com.tencent.mm.toolkit.frontia.a.a vsZ;
  private static final List<String> vta;
  
  static
  {
    AppMethodBeat.i(152964);
    vsT = new byte[] { 7, 2, -1, -1, -4, 8, -10, -3, 4, 2, -8, -4, 9, 5, -6, -17, 3, 4, 3, 1 };
    vsU = new byte[0];
    vsV = new byte[0];
    vsW = j.class;
    feW = true;
    vsX = true;
    vta = new ArrayList();
    vsY = new com.tencent.mm.toolkit.frontia.a.c.a()
    {
      public final File dbh()
      {
        AppMethodBeat.i(202776);
        File localFile = new File(MMApplicationContext.getContext().getApplicationInfo().nativeLibraryDir);
        AppMethodBeat.o(202776);
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
    d locald = d.dbi();
    vsZ = new com.tencent.mm.toolkit.frontia.a.a(locald, new a.c(locald));
    AppMethodBeat.o(152964);
  }
  
  public static boolean Vt()
  {
    return true;
  }
  
  public static Future<?> a(a.a parama)
  {
    AppMethodBeat.i(152961);
    parama.a(vsY.getAssets());
    parama = vsZ.mBs;
    AppMethodBeat.o(152961);
    return parama;
  }
  
  public static Future<?> a(a.b paramb)
  {
    AppMethodBeat.i(152960);
    paramb.a(vsY);
    paramb = vsZ.mBs;
    AppMethodBeat.o(152960);
    return paramb;
  }
  
  public static boolean avY(String paramString)
  {
    AppMethodBeat.i(152962);
    if (vta.contains(paramString))
    {
      AppMethodBeat.o(152962);
      return true;
    }
    try
    {
      a.class.getClassLoader();
      j.KW(paramString);
      vta.add(paramString);
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
  
  static boolean daY()
  {
    synchronized (vsV)
    {
      if (vsZ != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  static boolean daZ()
  {
    return true;
  }
  
  static void dba() {}
  
  static void dbb() {}
  
  public static boolean dbc()
  {
    return true;
  }
  
  public static boolean dbd()
  {
    return true;
  }
  
  public static boolean dbe()
  {
    return false;
  }
  
  public static boolean dbf()
  {
    return true;
  }
  
  public static String dbg()
  {
    AppMethodBeat.i(202801);
    if (vsY == null)
    {
      AppMethodBeat.o(202801);
      return null;
    }
    String str = vsY.dbh().getAbsolutePath() + File.separator;
    AppMethodBeat.o(202801);
    return str;
  }
  
  public static boolean isEnabled()
  {
    return false;
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
    AppMethodBeat.i(202791);
    c.a(new com.tencent.mm.xwebutil.c.a()
    {
      public final boolean Vt()
      {
        AppMethodBeat.i(202762);
        boolean bool = a.Vt();
        AppMethodBeat.o(202762);
        return bool;
      }
      
      public final String dbg()
      {
        AppMethodBeat.i(202763);
        String str = a.dbg();
        AppMethodBeat.o(202763);
        return str;
      }
    });
    AppMethodBeat.o(202791);
  }
  
  static final class d
    extends com.tencent.mm.toolkit.frontia.a.a<Object>
  {
    public static final String vtb;
    public boolean vtc;
    
    static
    {
      AppMethodBeat.i(152959);
      StringBuilder localStringBuilder = new StringBuilder("expansions-");
      String str = Build.CPU_ABI;
      "Capable cpu abi = ".concat(String.valueOf(str));
      b.hET();
      vtb = str + ".obb";
      AppMethodBeat.o(152959);
    }
    
    private d()
    {
      AppMethodBeat.i(152957);
      this.vtc = true;
      hEV();
      AppMethodBeat.o(152957);
    }
    
    public static d dbi()
    {
      AppMethodBeat.i(152958);
      d locald = new d();
      locald.hEU();
      locald.bye("use builtin impl");
      AppMethodBeat.o(152958);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.a
 * JD-Core Version:    0.7.0.1
 */
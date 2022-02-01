package com.tencent.mm.plugin.expansions;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.cq.d;
import com.tencent.mm.cq.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.toolkit.frontia.a.c.a;
import com.tencent.mm.toolkit.frontia.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public final class a
{
  private static final byte[] qoV;
  private static final byte[] qoW;
  private static final byte[] qoX;
  private static final Object qoY;
  private static volatile boolean qoZ;
  private static volatile boolean qpa;
  private static volatile c.a qpb;
  private static volatile com.tencent.mm.toolkit.frontia.a.a qpc;
  private static final List<String> qpd;
  
  static
  {
    AppMethodBeat.i(152964);
    qoV = new byte[] { 7, 2, -1, -1, -4, 8, -10, -3, 4, 2, -8, -4, 9, 5, -6, -17, 3, 4, 3, 1 };
    qoW = new byte[0];
    qoX = new byte[0];
    qoY = j.class;
    qoZ = true;
    qpa = true;
    qpd = new ArrayList();
    qpb = new c.a()
    {
      public final File cmS()
      {
        AppMethodBeat.i(194963);
        File localFile = new File(aj.getContext().getApplicationInfo().nativeLibraryDir);
        AppMethodBeat.o(194963);
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
    d locald = d.cmT();
    qpc = new com.tencent.mm.toolkit.frontia.a.a(locald, new a.c(locald));
    AppMethodBeat.o(152964);
  }
  
  public static boolean HK()
  {
    return true;
  }
  
  public static Future<?> a(a parama)
  {
    AppMethodBeat.i(152961);
    parama.a(qpb.getAssets());
    parama = qpc.EDL;
    AppMethodBeat.o(152961);
    return parama;
  }
  
  public static Future<?> a(b paramb)
  {
    AppMethodBeat.i(152960);
    paramb.a(qpb);
    paramb = qpc.EDL;
    AppMethodBeat.o(152960);
    return paramb;
  }
  
  public static boolean ada(String paramString)
  {
    AppMethodBeat.i(152962);
    if (qpd.contains(paramString))
    {
      AppMethodBeat.o(152962);
      return true;
    }
    try
    {
      a.class.getClassLoader();
      j.vr(paramString);
      qpd.add(paramString);
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
  
  static boolean cmI()
  {
    for (;;)
    {
      synchronized (qoX)
      {
        if (qpc != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  static boolean cmJ()
  {
    return true;
  }
  
  static void cmK() {}
  
  static void cmL() {}
  
  public static boolean cmM()
  {
    return true;
  }
  
  public static boolean cmN()
  {
    return true;
  }
  
  public static boolean cmO()
  {
    return false;
  }
  
  public static boolean cmP()
  {
    return true;
  }
  
  public static String cmQ()
  {
    AppMethodBeat.i(194967);
    if (qpb == null)
    {
      AppMethodBeat.o(194967);
      return null;
    }
    String str = qpb.cmS().getAbsolutePath() + File.separator;
    AppMethodBeat.o(194967);
    return str;
  }
  
  static boolean cmR()
  {
    AppMethodBeat.i(152963);
    boolean bool = aj.cmR();
    AppMethodBeat.o(152963);
    return bool;
  }
  
  public static boolean isEnabled()
  {
    return false;
  }
  
  static void prepare()
  {
    AppMethodBeat.i(194966);
    d.a(new d.a()
    {
      public final boolean HK()
      {
        AppMethodBeat.i(194964);
        boolean bool = a.HK();
        AppMethodBeat.o(194964);
        return bool;
      }
      
      public final String cmQ()
      {
        AppMethodBeat.i(194965);
        String str = a.cmQ();
        AppMethodBeat.o(194965);
        return str;
      }
    });
    AppMethodBeat.o(194966);
  }
  
  public static abstract interface a
  {
    public abstract void a(AssetManager paramAssetManager);
  }
  
  public static abstract interface b
  {
    public abstract void a(c.a parama);
  }
  
  static final class d
    extends com.tencent.mm.toolkit.frontia.a.a<Object>
  {
    public static final String qpe;
    public boolean qpf;
    
    static
    {
      AppMethodBeat.i(152959);
      StringBuilder localStringBuilder = new StringBuilder("expansions-");
      String str = Build.CPU_ABI;
      "Capable cpu abi = ".concat(String.valueOf(str));
      b.fur();
      qpe = str + ".obb";
      AppMethodBeat.o(152959);
    }
    
    private d()
    {
      AppMethodBeat.i(152957);
      this.qpf = true;
      fut();
      AppMethodBeat.o(152957);
    }
    
    public static d cmT()
    {
      AppMethodBeat.i(152958);
      d locald = new d();
      locald.fus();
      locald.aVd("use builtin impl");
      AppMethodBeat.o(152958);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.a
 * JD-Core Version:    0.7.0.1
 */
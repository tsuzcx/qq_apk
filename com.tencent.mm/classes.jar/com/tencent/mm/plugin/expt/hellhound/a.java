package com.tencent.mm.plugin.expt.hellhound;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.expt.f.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static PBool zAA;
  private static PBool zAB;
  private static PInt zAC;
  private static String zAD;
  private static final List<String> zAE;
  private static boolean zAF;
  private static boolean zAG;
  private static int zAH;
  private static String zAI;
  public static boolean zAJ;
  private static PBool zAv;
  private static PBool zAw;
  private static PBool zAx;
  private static PBool zAy;
  private static PBool zAz;
  
  static
  {
    AppMethodBeat.i(300676);
    zAv = null;
    zAw = null;
    zAx = null;
    zAy = null;
    zAz = null;
    zAA = null;
    zAB = null;
    zAC = null;
    zAD = null;
    zAE = new ArrayList();
    zAF = false;
    zAG = false;
    zAH = 0;
    zAI = "";
    zAJ = false;
    AppMethodBeat.o(300676);
  }
  
  public static void aqx(String paramString)
  {
    zAD = paramString;
  }
  
  public static boolean aqy(String paramString)
  {
    AppMethodBeat.i(300635);
    if (!zAF)
    {
      zAE.clear();
      AppMethodBeat.o(300635);
      return false;
    }
    if (zAE.contains(paramString))
    {
      AppMethodBeat.o(300635);
      return true;
    }
    zAE.add(paramString);
    AppMethodBeat.o(300635);
    return false;
  }
  
  public static void aqz(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    zAI = str;
  }
  
  public static String dIE()
  {
    return zAD;
  }
  
  public static boolean dIF()
  {
    return zAG;
  }
  
  public static void dIG()
  {
    zAH += 1;
  }
  
  public static boolean dIH()
  {
    return zAH > 0;
  }
  
  public static void dII()
  {
    zAH = 0;
  }
  
  public static String dIJ()
  {
    return zAI;
  }
  
  public static boolean dIK()
  {
    boolean bool = false;
    AppMethodBeat.i(121797);
    if (zAv == null)
    {
      c.dNK();
      String str = c.c(c.a.yMu, "1");
      PBool localPBool = new PBool();
      zAv = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!zAv.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, hellhoundSwitch: [false]");
    }
    bool = zAv.value;
    AppMethodBeat.o(121797);
    return bool;
  }
  
  public static boolean dIL()
  {
    boolean bool = false;
    AppMethodBeat.i(121798);
    if (zAw == null)
    {
      c.dNK();
      String str = c.c(c.a.yMv, "1");
      PBool localPBool = new PBool();
      zAw = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!zAw.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, frontbackSwitch: [false]");
    }
    bool = zAw.value;
    AppMethodBeat.o(121798);
    return bool;
  }
  
  public static boolean dIM()
  {
    boolean bool = false;
    AppMethodBeat.i(121799);
    if (zAx == null)
    {
      c.dNK();
      String str = c.c(c.a.yMv, "1");
      PBool localPBool = new PBool();
      zAx = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!zAx.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, sessionSwitch: [false]");
    }
    bool = zAx.value;
    AppMethodBeat.o(121799);
    return bool;
  }
  
  public static boolean dIN()
  {
    boolean bool = false;
    AppMethodBeat.i(169255);
    if (zAz == null)
    {
      c.dNK();
      String str = c.c(c.a.yMy, "1");
      PBool localPBool = new PBool();
      zAz = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!zAz.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchFinderSwitch: [false]");
    }
    bool = zAz.value;
    AppMethodBeat.o(169255);
    return bool;
  }
  
  public static boolean dIO()
  {
    AppMethodBeat.i(121800);
    PBool localPBool;
    if (zAy == null)
    {
      c.dNK();
      String str = c.c(c.a.yMx, "1");
      localPBool = new PBool();
      zAy = localPBool;
      if (Util.getInt(str, 0) <= 0) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      localPBool.value = bool;
      if (Build.BRAND.equalsIgnoreCase("meizu")) {
        zAy.value = false;
      }
      bool = zAy.value;
      AppMethodBeat.o(121800);
      return bool;
    }
  }
  
  public static boolean dIP()
  {
    boolean bool = false;
    AppMethodBeat.i(121801);
    if (zAA == null)
    {
      c.dNK();
      String str = c.c(c.a.yMz, "1");
      PBool localPBool = new PBool();
      zAA = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!zAA.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchAsyncEventSwitch: [false]");
    }
    bool = zAA.value;
    AppMethodBeat.o(121801);
    return bool;
  }
  
  public static int dIQ()
  {
    AppMethodBeat.i(300670);
    if (zAC == null)
    {
      c.dNK();
      String str = c.c(c.a.yMB, "50");
      PInt localPInt = new PInt();
      zAC = localPInt;
      localPInt.value = Util.getInt(str, 50);
    }
    int i = zAC.value;
    AppMethodBeat.o(300670);
    return i;
  }
  
  public static void oI(boolean paramBoolean)
  {
    AppMethodBeat.i(300632);
    zAF = paramBoolean;
    if (!paramBoolean) {
      zAE.clear();
    }
    AppMethodBeat.o(300632);
  }
  
  public static void oJ(boolean paramBoolean)
  {
    zAG = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expt.hellhound;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.i.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static PBool syC;
  private static PBool syD;
  private static PBool syE;
  private static PBool syF;
  private static PBool syG;
  private static PBool syH;
  private static PBool syI;
  private static PInt syJ;
  private static String syK;
  private static final List<String> syL;
  private static boolean syM;
  private static boolean syN;
  private static int syO;
  private static String syP;
  public static boolean syQ;
  
  static
  {
    AppMethodBeat.i(220382);
    syC = null;
    syD = null;
    syE = null;
    syF = null;
    syG = null;
    syH = null;
    syI = null;
    syJ = null;
    syK = null;
    syL = new ArrayList();
    syM = false;
    syN = false;
    syO = 0;
    syP = "";
    syQ = false;
    AppMethodBeat.o(220382);
  }
  
  public static void aov(String paramString)
  {
    syK = paramString;
  }
  
  public static boolean aow(String paramString)
  {
    AppMethodBeat.i(220379);
    if (!syM)
    {
      syL.clear();
      AppMethodBeat.o(220379);
      return false;
    }
    if (syL.contains(paramString))
    {
      AppMethodBeat.o(220379);
      return true;
    }
    syL.add(paramString);
    AppMethodBeat.o(220379);
    return false;
  }
  
  public static void aox(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    syP = str;
  }
  
  public static String cNi()
  {
    return syK;
  }
  
  public static boolean cNj()
  {
    return syN;
  }
  
  public static void cNk()
  {
    syO += 1;
  }
  
  public static boolean cNl()
  {
    return syO > 0;
  }
  
  public static void cNm()
  {
    syO = 0;
  }
  
  public static String cNn()
  {
    return syP;
  }
  
  public static boolean cNo()
  {
    boolean bool = false;
    AppMethodBeat.i(121797);
    if (syC == null)
    {
      c.cSa();
      String str = c.c(b.a.rSo, "1");
      PBool localPBool = new PBool();
      syC = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!syC.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, hellhoundSwitch: [false]");
    }
    bool = syC.value;
    AppMethodBeat.o(121797);
    return bool;
  }
  
  public static boolean cNp()
  {
    boolean bool = false;
    AppMethodBeat.i(121798);
    if (syD == null)
    {
      c.cSa();
      String str = c.c(b.a.rSp, "1");
      PBool localPBool = new PBool();
      syD = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!syD.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, frontbackSwitch: [false]");
    }
    bool = syD.value;
    AppMethodBeat.o(121798);
    return bool;
  }
  
  public static boolean cNq()
  {
    boolean bool = false;
    AppMethodBeat.i(121799);
    if (syE == null)
    {
      c.cSa();
      String str = c.c(b.a.rSp, "1");
      PBool localPBool = new PBool();
      syE = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!syE.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, sessionSwitch: [false]");
    }
    bool = syE.value;
    AppMethodBeat.o(121799);
    return bool;
  }
  
  public static boolean cNr()
  {
    boolean bool = false;
    AppMethodBeat.i(169255);
    if (syG == null)
    {
      c.cSa();
      String str = c.c(b.a.rSs, "1");
      PBool localPBool = new PBool();
      syG = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!syG.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchFinderSwitch: [false]");
    }
    bool = syG.value;
    AppMethodBeat.o(169255);
    return bool;
  }
  
  public static boolean cNs()
  {
    AppMethodBeat.i(121800);
    PBool localPBool;
    if (syF == null)
    {
      c.cSa();
      String str = c.c(b.a.rSr, "1");
      localPBool = new PBool();
      syF = localPBool;
      if (Util.getInt(str, 0) <= 0) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      localPBool.value = bool;
      if (Build.BRAND.equalsIgnoreCase("meizu")) {
        syF.value = false;
      }
      bool = syF.value;
      AppMethodBeat.o(121800);
      return bool;
    }
  }
  
  public static boolean cNt()
  {
    boolean bool = false;
    AppMethodBeat.i(121801);
    if (syH == null)
    {
      c.cSa();
      String str = c.c(b.a.rSt, "1");
      PBool localPBool = new PBool();
      syH = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!syH.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchAsyncEventSwitch: [false]");
    }
    bool = syH.value;
    AppMethodBeat.o(121801);
    return bool;
  }
  
  public static boolean cNu()
  {
    boolean bool = false;
    AppMethodBeat.i(220380);
    if (syI == null)
    {
      c.cSa();
      String str = c.c(b.a.rSu, "1");
      PBool localPBool = new PBool();
      syI = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!syI.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchHellCgiSwitch: [false]");
    }
    bool = syI.value;
    AppMethodBeat.o(220380);
    return bool;
  }
  
  public static int cNv()
  {
    AppMethodBeat.i(220381);
    if (syJ == null)
    {
      c.cSa();
      String str = c.c(b.a.rSv, "50");
      PInt localPInt = new PInt();
      syJ = localPInt;
      localPInt.value = Util.getInt(str, 50);
    }
    int i = syJ.value;
    AppMethodBeat.o(220381);
    return i;
  }
  
  public static void lW(boolean paramBoolean)
  {
    AppMethodBeat.i(220378);
    syM = paramBoolean;
    if (!paramBoolean) {
      syL.clear();
    }
    AppMethodBeat.o(220378);
  }
  
  public static void lX(boolean paramBoolean)
  {
    syN = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a
 * JD-Core Version:    0.7.0.1
 */
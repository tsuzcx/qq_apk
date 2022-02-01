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
  private static PBool weA;
  private static PBool weB;
  private static PBool weC;
  private static PBool weD;
  private static PBool weE;
  private static PInt weF;
  private static String weG;
  private static final List<String> weH;
  private static boolean weI;
  private static boolean weJ;
  private static int weK;
  private static String weL;
  public static boolean weM;
  private static PBool wey;
  private static PBool wez;
  
  static
  {
    AppMethodBeat.i(252374);
    wey = null;
    wez = null;
    weA = null;
    weB = null;
    weC = null;
    weD = null;
    weE = null;
    weF = null;
    weG = null;
    weH = new ArrayList();
    weI = false;
    weJ = false;
    weK = 0;
    weL = "";
    weM = false;
    AppMethodBeat.o(252374);
  }
  
  public static void awu(String paramString)
  {
    weG = paramString;
  }
  
  public static boolean awv(String paramString)
  {
    AppMethodBeat.i(252362);
    if (!weI)
    {
      weH.clear();
      AppMethodBeat.o(252362);
      return false;
    }
    if (weH.contains(paramString))
    {
      AppMethodBeat.o(252362);
      return true;
    }
    weH.add(paramString);
    AppMethodBeat.o(252362);
    return false;
  }
  
  public static void aww(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    weL = str;
  }
  
  public static String dca()
  {
    return weG;
  }
  
  public static boolean dcb()
  {
    return weJ;
  }
  
  public static void dcc()
  {
    weK += 1;
  }
  
  public static boolean dcd()
  {
    return weK > 0;
  }
  
  public static void dce()
  {
    weK = 0;
  }
  
  public static String dcf()
  {
    return weL;
  }
  
  public static boolean dcg()
  {
    boolean bool = false;
    AppMethodBeat.i(121797);
    if (wey == null)
    {
      c.dgZ();
      String str = c.c(b.a.vyN, "1");
      PBool localPBool = new PBool();
      wey = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!wey.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, hellhoundSwitch: [false]");
    }
    bool = wey.value;
    AppMethodBeat.o(121797);
    return bool;
  }
  
  public static boolean dch()
  {
    boolean bool = false;
    AppMethodBeat.i(121798);
    if (wez == null)
    {
      c.dgZ();
      String str = c.c(b.a.vyO, "1");
      PBool localPBool = new PBool();
      wez = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!wez.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, frontbackSwitch: [false]");
    }
    bool = wez.value;
    AppMethodBeat.o(121798);
    return bool;
  }
  
  public static boolean dci()
  {
    boolean bool = false;
    AppMethodBeat.i(121799);
    if (weA == null)
    {
      c.dgZ();
      String str = c.c(b.a.vyO, "1");
      PBool localPBool = new PBool();
      weA = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!weA.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, sessionSwitch: [false]");
    }
    bool = weA.value;
    AppMethodBeat.o(121799);
    return bool;
  }
  
  public static boolean dcj()
  {
    boolean bool = false;
    AppMethodBeat.i(169255);
    if (weC == null)
    {
      c.dgZ();
      String str = c.c(b.a.vyR, "1");
      PBool localPBool = new PBool();
      weC = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!weC.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchFinderSwitch: [false]");
    }
    bool = weC.value;
    AppMethodBeat.o(169255);
    return bool;
  }
  
  public static boolean dck()
  {
    AppMethodBeat.i(121800);
    PBool localPBool;
    if (weB == null)
    {
      c.dgZ();
      String str = c.c(b.a.vyQ, "1");
      localPBool = new PBool();
      weB = localPBool;
      if (Util.getInt(str, 0) <= 0) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      localPBool.value = bool;
      if (Build.BRAND.equalsIgnoreCase("meizu")) {
        weB.value = false;
      }
      bool = weB.value;
      AppMethodBeat.o(121800);
      return bool;
    }
  }
  
  public static boolean dcl()
  {
    boolean bool = false;
    AppMethodBeat.i(121801);
    if (weD == null)
    {
      c.dgZ();
      String str = c.c(b.a.vyS, "1");
      PBool localPBool = new PBool();
      weD = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!weD.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchAsyncEventSwitch: [false]");
    }
    bool = weD.value;
    AppMethodBeat.o(121801);
    return bool;
  }
  
  public static boolean dcm()
  {
    boolean bool = false;
    AppMethodBeat.i(252370);
    if (weE == null)
    {
      c.dgZ();
      String str = c.c(b.a.vyT, "1");
      PBool localPBool = new PBool();
      weE = localPBool;
      if (Util.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!weE.value) {
      Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchHellCgiSwitch: [false]");
    }
    bool = weE.value;
    AppMethodBeat.o(252370);
    return bool;
  }
  
  public static int dcn()
  {
    AppMethodBeat.i(252372);
    if (weF == null)
    {
      c.dgZ();
      String str = c.c(b.a.vyU, "50");
      PInt localPInt = new PInt();
      weF = localPInt;
      localPInt.value = Util.getInt(str, 50);
    }
    int i = weF.value;
    AppMethodBeat.o(252372);
    return i;
  }
  
  public static void ni(boolean paramBoolean)
  {
    AppMethodBeat.i(252361);
    weI = paramBoolean;
    if (!paramBoolean) {
      weH.clear();
    }
    AppMethodBeat.o(252361);
  }
  
  public static void nj(boolean paramBoolean)
  {
    weJ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a
 * JD-Core Version:    0.7.0.1
 */
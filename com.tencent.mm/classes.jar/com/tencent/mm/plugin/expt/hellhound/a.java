package com.tencent.mm.plugin.expt.hellhound;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.i.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  private static PBool qYt = null;
  private static PBool qYu = null;
  private static PBool qYv = null;
  private static PBool qYw = null;
  private static PBool qYx = null;
  private static PBool qYy = null;
  private static PBool qYz = null;
  
  public static boolean coV()
  {
    boolean bool = false;
    AppMethodBeat.i(121797);
    if (qYt == null)
    {
      c.ctt();
      String str = c.b(b.a.qAd, "1");
      PBool localPBool = new PBool();
      qYt = localPBool;
      if (bu.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qYt.value) {
      ae.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, hellhoundSwitch: [false]");
    }
    bool = qYt.value;
    AppMethodBeat.o(121797);
    return bool;
  }
  
  public static boolean coW()
  {
    boolean bool = false;
    AppMethodBeat.i(121798);
    if (qYu == null)
    {
      c.ctt();
      String str = c.b(b.a.qAe, "1");
      PBool localPBool = new PBool();
      qYu = localPBool;
      if (bu.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qYu.value) {
      ae.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, frontbackSwitch: [false]");
    }
    bool = qYu.value;
    AppMethodBeat.o(121798);
    return bool;
  }
  
  public static boolean coX()
  {
    boolean bool = false;
    AppMethodBeat.i(121799);
    if (qYv == null)
    {
      c.ctt();
      String str = c.b(b.a.qAe, "1");
      PBool localPBool = new PBool();
      qYv = localPBool;
      if (bu.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qYv.value) {
      ae.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, sessionSwitch: [false]");
    }
    bool = qYv.value;
    AppMethodBeat.o(121799);
    return bool;
  }
  
  public static boolean coY()
  {
    boolean bool = false;
    AppMethodBeat.i(169255);
    if (qYx == null)
    {
      c.ctt();
      String str = c.b(b.a.qAh, "1");
      PBool localPBool = new PBool();
      qYx = localPBool;
      if (bu.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qYx.value) {
      ae.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchFinderSwitch: [false]");
    }
    bool = qYx.value;
    AppMethodBeat.o(169255);
    return bool;
  }
  
  public static boolean coZ()
  {
    AppMethodBeat.i(121800);
    PBool localPBool;
    if (qYw == null)
    {
      c.ctt();
      String str = c.b(b.a.qAg, "1");
      localPBool = new PBool();
      qYw = localPBool;
      if (bu.getInt(str, 0) <= 0) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      localPBool.value = bool;
      if (Build.BRAND.equalsIgnoreCase("meizu")) {
        qYw.value = false;
      }
      bool = qYw.value;
      AppMethodBeat.o(121800);
      return bool;
    }
  }
  
  public static boolean cpa()
  {
    boolean bool = false;
    AppMethodBeat.i(121801);
    if (qYy == null)
    {
      c.ctt();
      String str = c.b(b.a.qAi, "1");
      PBool localPBool = new PBool();
      qYy = localPBool;
      if (bu.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qYy.value) {
      ae.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchAsyncEventSwitch: [false]");
    }
    bool = qYy.value;
    AppMethodBeat.o(121801);
    return bool;
  }
  
  public static boolean cpb()
  {
    boolean bool = false;
    AppMethodBeat.i(195955);
    if (qYz == null)
    {
      c.ctt();
      String str = c.b(b.a.qAj, "1");
      PBool localPBool = new PBool();
      qYz = localPBool;
      if (bu.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qYz.value) {
      ae.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchHellCgiSwitch: [false]");
    }
    bool = qYz.value;
    AppMethodBeat.o(195955);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a
 * JD-Core Version:    0.7.0.1
 */
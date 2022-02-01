package com.tencent.mm.plugin.expt.hellhound;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.i.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  private static PBool qQA = null;
  private static PBool qQB = null;
  private static PBool qQv = null;
  private static PBool qQw = null;
  private static PBool qQx = null;
  private static PBool qQy = null;
  private static PBool qQz = null;
  
  public static boolean cnt()
  {
    boolean bool = false;
    AppMethodBeat.i(121797);
    if (qQv == null)
    {
      c.crR();
      String str = c.b(b.a.qto, "1");
      PBool localPBool = new PBool();
      qQv = localPBool;
      if (bt.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qQv.value) {
      ad.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, hellhoundSwitch: [false]");
    }
    bool = qQv.value;
    AppMethodBeat.o(121797);
    return bool;
  }
  
  public static boolean cnu()
  {
    boolean bool = false;
    AppMethodBeat.i(121798);
    if (qQw == null)
    {
      c.crR();
      String str = c.b(b.a.qtp, "1");
      PBool localPBool = new PBool();
      qQw = localPBool;
      if (bt.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qQw.value) {
      ad.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, frontbackSwitch: [false]");
    }
    bool = qQw.value;
    AppMethodBeat.o(121798);
    return bool;
  }
  
  public static boolean cnv()
  {
    boolean bool = false;
    AppMethodBeat.i(121799);
    if (qQx == null)
    {
      c.crR();
      String str = c.b(b.a.qtp, "1");
      PBool localPBool = new PBool();
      qQx = localPBool;
      if (bt.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qQx.value) {
      ad.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, sessionSwitch: [false]");
    }
    bool = qQx.value;
    AppMethodBeat.o(121799);
    return bool;
  }
  
  public static boolean cnw()
  {
    boolean bool = false;
    AppMethodBeat.i(169255);
    if (qQz == null)
    {
      c.crR();
      String str = c.b(b.a.qts, "1");
      PBool localPBool = new PBool();
      qQz = localPBool;
      if (bt.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qQz.value) {
      ad.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchFinderSwitch: [false]");
    }
    bool = qQz.value;
    AppMethodBeat.o(169255);
    return bool;
  }
  
  public static boolean cnx()
  {
    AppMethodBeat.i(121800);
    PBool localPBool;
    if (qQy == null)
    {
      c.crR();
      String str = c.b(b.a.qtr, "1");
      localPBool = new PBool();
      qQy = localPBool;
      if (bt.getInt(str, 0) <= 0) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      localPBool.value = bool;
      if (Build.BRAND.equalsIgnoreCase("meizu")) {
        qQy.value = false;
      }
      bool = qQy.value;
      AppMethodBeat.o(121800);
      return bool;
    }
  }
  
  public static boolean cny()
  {
    boolean bool = false;
    AppMethodBeat.i(121801);
    if (qQA == null)
    {
      c.crR();
      String str = c.b(b.a.qtt, "1");
      PBool localPBool = new PBool();
      qQA = localPBool;
      if (bt.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qQA.value) {
      ad.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchAsyncEventSwitch: [false]");
    }
    bool = qQA.value;
    AppMethodBeat.o(121801);
    return bool;
  }
  
  public static boolean cnz()
  {
    boolean bool = false;
    AppMethodBeat.i(210295);
    if (qQB == null)
    {
      c.crR();
      String str = c.b(b.a.qtu, "1");
      PBool localPBool = new PBool();
      qQB = localPBool;
      if (bt.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qQB.value) {
      ad.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchHellCgiSwitch: [false]");
    }
    bool = qQB.value;
    AppMethodBeat.o(210295);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a
 * JD-Core Version:    0.7.0.1
 */
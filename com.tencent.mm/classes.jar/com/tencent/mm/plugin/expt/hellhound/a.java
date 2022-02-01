package com.tencent.mm.plugin.expt.hellhound;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.f.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  private static PBool qiA = null;
  private static PBool qiB = null;
  private static PBool qiC = null;
  private static PBool qix = null;
  private static PBool qiy = null;
  private static PBool qiz = null;
  
  public static boolean ciA()
  {
    AppMethodBeat.i(121800);
    PBool localPBool;
    if (qiA == null)
    {
      c.cmm();
      String str = c.b(b.a.pPs, "1");
      localPBool = new PBool();
      qiA = localPBool;
      if (bs.getInt(str, 0) <= 0) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      localPBool.value = bool;
      if (Build.BRAND.equalsIgnoreCase("meizu")) {
        qiA.value = false;
      }
      bool = qiA.value;
      AppMethodBeat.o(121800);
      return bool;
    }
  }
  
  public static boolean ciB()
  {
    boolean bool = false;
    AppMethodBeat.i(121801);
    if (qiC == null)
    {
      c.cmm();
      String str = c.b(b.a.pPu, "1");
      PBool localPBool = new PBool();
      qiC = localPBool;
      if (bs.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qiC.value) {
      ac.i("HellhoundConfig", "HABBYGE-MALI, HellhoundConfig, fetchAsyncEventSwitch: [false]");
    }
    bool = qiC.value;
    AppMethodBeat.o(121801);
    return bool;
  }
  
  public static boolean ciw()
  {
    boolean bool = false;
    AppMethodBeat.i(121797);
    if (qix == null)
    {
      c.cmm();
      String str = c.b(b.a.pPp, "1");
      PBool localPBool = new PBool();
      qix = localPBool;
      if (bs.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qix.value) {
      ac.i("HellhoundConfig", "HABBYGE-MALI, HellhoundConfig, hellhoundSwitch: [false]");
    }
    bool = qix.value;
    AppMethodBeat.o(121797);
    return bool;
  }
  
  public static boolean cix()
  {
    boolean bool = false;
    AppMethodBeat.i(121798);
    if (qiy == null)
    {
      c.cmm();
      String str = c.b(b.a.pPq, "1");
      PBool localPBool = new PBool();
      qiy = localPBool;
      if (bs.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qiy.value) {
      ac.i("HellhoundConfig", "HABBYGE-MALI, HellhoundConfig, frontbackSwitch: [false]");
    }
    bool = qiy.value;
    AppMethodBeat.o(121798);
    return bool;
  }
  
  public static boolean ciy()
  {
    boolean bool = false;
    AppMethodBeat.i(121799);
    if (qiz == null)
    {
      c.cmm();
      String str = c.b(b.a.pPq, "1");
      PBool localPBool = new PBool();
      qiz = localPBool;
      if (bs.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qiz.value) {
      ac.i("HellhoundConfig", "HABBYGE-MALI, HellhoundConfig, sessionSwitch: [false]");
    }
    bool = qiz.value;
    AppMethodBeat.o(121799);
    return bool;
  }
  
  public static boolean ciz()
  {
    boolean bool = false;
    AppMethodBeat.i(169255);
    if (qiB == null)
    {
      c.cmm();
      String str = c.b(b.a.pPt, "1");
      PBool localPBool = new PBool();
      qiB = localPBool;
      if (bs.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!qiB.value) {
      ac.i("HellhoundConfig", "HABBYGE-MALI, HellhoundConfig, fetchFinderSwitch: [false]");
    }
    bool = qiB.value;
    AppMethodBeat.o(169255);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expt.hellhound;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.f.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  private static PBool pDK = null;
  private static PBool pDL = null;
  private static PBool pDM = null;
  private static PBool pDN = null;
  private static PBool pDO = null;
  private static PBool pDP = null;
  
  public static boolean cbn()
  {
    boolean bool = false;
    AppMethodBeat.i(121797);
    if (pDK == null)
    {
      c.ceF();
      String str = c.b(b.a.plT, "1");
      PBool localPBool = new PBool();
      pDK = localPBool;
      if (bt.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!pDK.value) {
      ad.i("HellhoundConfig", "HABBYGE-MALI, HellhoundConfig, hellhoundSwitch: [false]");
    }
    bool = pDK.value;
    AppMethodBeat.o(121797);
    return bool;
  }
  
  public static boolean cbo()
  {
    boolean bool = false;
    AppMethodBeat.i(121798);
    if (pDL == null)
    {
      c.ceF();
      String str = c.b(b.a.plU, "1");
      PBool localPBool = new PBool();
      pDL = localPBool;
      if (bt.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!pDL.value) {
      ad.i("HellhoundConfig", "HABBYGE-MALI, HellhoundConfig, frontbackSwitch: [false]");
    }
    bool = pDL.value;
    AppMethodBeat.o(121798);
    return bool;
  }
  
  public static boolean cbp()
  {
    boolean bool = false;
    AppMethodBeat.i(121799);
    if (pDM == null)
    {
      c.ceF();
      String str = c.b(b.a.plU, "1");
      PBool localPBool = new PBool();
      pDM = localPBool;
      if (bt.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!pDM.value) {
      ad.i("HellhoundConfig", "HABBYGE-MALI, HellhoundConfig, sessionSwitch: [false]");
    }
    bool = pDM.value;
    AppMethodBeat.o(121799);
    return bool;
  }
  
  public static boolean cbq()
  {
    boolean bool = false;
    AppMethodBeat.i(169255);
    if (pDO == null)
    {
      c.ceF();
      String str = c.b(b.a.plX, "1");
      PBool localPBool = new PBool();
      pDO = localPBool;
      if (bt.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!pDO.value) {
      ad.i("HellhoundConfig", "HABBYGE-MALI, HellhoundConfig, fetchFinderSwitch: [false]");
    }
    bool = pDO.value;
    AppMethodBeat.o(169255);
    return bool;
  }
  
  public static boolean cbr()
  {
    AppMethodBeat.i(121800);
    PBool localPBool;
    if (pDN == null)
    {
      c.ceF();
      String str = c.b(b.a.plW, "1");
      localPBool = new PBool();
      pDN = localPBool;
      if (bt.getInt(str, 0) <= 0) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      localPBool.value = bool;
      if (Build.BRAND.equalsIgnoreCase("meizu")) {
        pDN.value = false;
      }
      bool = pDN.value;
      AppMethodBeat.o(121800);
      return bool;
    }
  }
  
  public static boolean cbs()
  {
    boolean bool = false;
    AppMethodBeat.i(121801);
    if (pDP == null)
    {
      c.ceF();
      String str = c.b(b.a.plY, "1");
      PBool localPBool = new PBool();
      pDP = localPBool;
      if (bt.getInt(str, 0) > 0) {
        bool = true;
      }
      localPBool.value = bool;
    }
    if (!pDP.value) {
      ad.i("HellhoundConfig", "HABBYGE-MALI, HellhoundConfig, fetchAsyncEventSwitch: [false]");
    }
    bool = pDP.value;
    AppMethodBeat.o(121801);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expt.hellhound;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.expt.e.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  private static PBool lZw = null;
  private static PBool lZx = null;
  private static PBool lZy = null;
  private static PBool lZz = null;
  
  public static boolean brn()
  {
    AppMethodBeat.i(73323);
    PBool localPBool;
    if (lZw == null)
    {
      c.btm();
      String str = c.a(a.a.lUk, "", false);
      localPBool = new PBool();
      lZw = localPBool;
      if (bo.getInt(str, 0) <= 0) {
        break label89;
      }
    }
    label89:
    for (boolean bool = true;; bool = false)
    {
      localPBool.value = bool;
      ab.i("HellhoundConfig", "habbyge-mali, HellhoundConfig, hellhoundSwitch: [%b]", new Object[] { Boolean.valueOf(lZw.value) });
      bool = lZw.value;
      AppMethodBeat.o(73323);
      return bool;
    }
  }
  
  public static boolean bro()
  {
    AppMethodBeat.i(73324);
    PBool localPBool;
    if (lZx == null)
    {
      c.btm();
      String str = c.a(a.a.lUl, "", false);
      localPBool = new PBool();
      lZx = localPBool;
      if (bo.getInt(str, 0) <= 0) {
        break label89;
      }
    }
    label89:
    for (boolean bool = true;; bool = false)
    {
      localPBool.value = bool;
      ab.i("HellhoundConfig", "habbyge-mali, HellhoundConfig, frontbackSwitch: [%b]", new Object[] { Boolean.valueOf(lZx.value) });
      bool = lZx.value;
      AppMethodBeat.o(73324);
      return bool;
    }
  }
  
  public static boolean brp()
  {
    AppMethodBeat.i(152226);
    PBool localPBool;
    if (lZy == null)
    {
      c.btm();
      String str = c.a(a.a.lUl, "", false);
      localPBool = new PBool();
      lZy = localPBool;
      if (bo.getInt(str, 0) <= 0) {
        break label89;
      }
    }
    label89:
    for (boolean bool = true;; bool = false)
    {
      localPBool.value = bool;
      ab.i("HellhoundConfig", "habbyge-mali, HellhoundConfig, sessionSwitch: [%b]", new Object[] { Boolean.valueOf(lZy.value) });
      bool = lZy.value;
      AppMethodBeat.o(152226);
      return bool;
    }
  }
  
  public static boolean brq()
  {
    AppMethodBeat.i(73325);
    PBool localPBool;
    if (lZz == null)
    {
      c.btm();
      String str = c.a(a.a.lUn, "", false);
      localPBool = new PBool();
      lZz = localPBool;
      if (bo.getInt(str, 0) <= 0) {
        break label84;
      }
    }
    label84:
    for (boolean bool = true;; bool = false)
    {
      localPBool.value = bool;
      if (Build.BRAND.equalsIgnoreCase("meizu")) {
        lZz.value = false;
      }
      bool = lZz.value;
      AppMethodBeat.o(73325);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public enum i
{
  public static final c<ss> iUk;
  
  static
  {
    AppMethodBeat.i(44477);
    iUl = new i[0];
    iUk = new c() {};
    AppMethodBeat.o(44477);
  }
  
  static void Fi(String paramString)
  {
    AppMethodBeat.i(44473);
    j(true, paramString);
    AppMethodBeat.o(44473);
  }
  
  static boolean aRA()
  {
    AppMethodBeat.i(44470);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(44470);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Flu, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44470);
    return bool;
  }
  
  public static boolean aRB()
  {
    AppMethodBeat.i(44474);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(44474);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Flj, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44474);
    return bool;
  }
  
  public static boolean aRC()
  {
    AppMethodBeat.i(44475);
    v.aRZ();
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(44475);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fli, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44475);
    return bool;
  }
  
  public static boolean aRD()
  {
    AppMethodBeat.i(44476);
    if ((aRC()) || (aRB()))
    {
      AppMethodBeat.o(44476);
      return true;
    }
    AppMethodBeat.o(44476);
    return false;
  }
  
  public static boolean aRy()
  {
    AppMethodBeat.i(44468);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(44468);
      return false;
    }
    if (com.tencent.mm.m.g.Zd().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      ad.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
      AppMethodBeat.o(44468);
      return false;
    }
    if ((aRD()) || (t.aRO()))
    {
      AppMethodBeat.o(44468);
      return true;
    }
    AppMethodBeat.o(44468);
    return false;
  }
  
  public static void aRz()
  {
    AppMethodBeat.i(44469);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(44469);
      return;
    }
    if (aRA())
    {
      t.e locale = t.e.iVc;
      t.e.a("", 0L, 2, 1);
    }
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Flu, Boolean.FALSE);
    AppMethodBeat.o(44469);
  }
  
  private static void j(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(44472);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(44472);
      return;
    }
    Object localObject = (Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Flj, null);
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()) && (paramBoolean))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Flu, Boolean.TRUE);
      localObject = t.e.iVc;
      t.e.aRV();
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Flj, Boolean.valueOf(paramBoolean));
      if (i != 0)
      {
        localObject = j.aOB();
        if (localObject != null) {
          ((AppBrandGuideUI.a)localObject).MW(paramString);
        }
      }
      AppMethodBeat.o(44472);
      return;
    }
  }
  
  static void qJ(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(44471);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(44471);
      return;
    }
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    ae.a locala;
    if ((paramInt & 0x2) > 0)
    {
      bool1 = true;
      j(bool1, "");
      locala = ae.a.Fli;
      if ((paramInt & 0x1) <= 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localab.set(locala, Boolean.valueOf(bool1));
      AppMethodBeat.o(44471);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.i
 * JD-Core Version:    0.7.0.1
 */
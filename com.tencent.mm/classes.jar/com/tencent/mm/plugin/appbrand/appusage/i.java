package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public enum i
{
  public static final c<tu> jRH;
  
  static
  {
    AppMethodBeat.i(44477);
    jRI = new i[0];
    jRH = new c() {};
    AppMethodBeat.o(44477);
  }
  
  static void Nj(String paramString)
  {
    AppMethodBeat.i(44473);
    m(true, paramString);
    AppMethodBeat.o(44473);
  }
  
  public static boolean bcA()
  {
    AppMethodBeat.i(44476);
    if ((bcz()) || (bcy()))
    {
      AppMethodBeat.o(44476);
      return true;
    }
    AppMethodBeat.o(44476);
    return false;
  }
  
  public static boolean bcv()
  {
    AppMethodBeat.i(44468);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(44468);
      return false;
    }
    if (com.tencent.mm.n.g.acL().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      ae.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
      AppMethodBeat.o(44468);
      return false;
    }
    if ((bcA()) || (t.bcM()))
    {
      AppMethodBeat.o(44468);
      return true;
    }
    AppMethodBeat.o(44468);
    return false;
  }
  
  public static void bcw()
  {
    AppMethodBeat.i(44469);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(44469);
      return;
    }
    if (bcx())
    {
      t.e locale = t.e.jSD;
      t.e.a("", 0L, 2, 1);
    }
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPZ, Boolean.FALSE);
    AppMethodBeat.o(44469);
  }
  
  static boolean bcx()
  {
    AppMethodBeat.i(44470);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(44470);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPZ, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44470);
    return bool;
  }
  
  public static boolean bcy()
  {
    AppMethodBeat.i(44474);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(44474);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPO, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44474);
    return bool;
  }
  
  public static boolean bcz()
  {
    AppMethodBeat.i(44475);
    v.bcX();
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(44475);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPN, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44475);
    return bool;
  }
  
  private static void m(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(44472);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(44472);
      return;
    }
    Object localObject = (Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPO, null);
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()) && (paramBoolean))
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPZ, Boolean.TRUE);
      localObject = t.e.jSD;
      t.e.bcT();
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPO, Boolean.valueOf(paramBoolean));
      if (i != 0)
      {
        localObject = j.aZk();
        if (localObject != null) {
          ((AppBrandGuideUI.a)localObject).Vw(paramString);
        }
      }
      AppMethodBeat.o(44472);
      return;
    }
  }
  
  static void rZ(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(44471);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(44471);
      return;
    }
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    am.a locala;
    if ((paramInt & 0x2) > 0)
    {
      bool1 = true;
      m(bool1, "");
      locala = am.a.IPN;
      if ((paramInt & 0x1) <= 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localaj.set(locala, Boolean.valueOf(bool1));
      AppMethodBeat.o(44471);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.i
 * JD-Core Version:    0.7.0.1
 */
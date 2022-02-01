package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.us;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public enum i
{
  public static final IListener<us> kUr;
  
  static
  {
    AppMethodBeat.i(44477);
    kUs = new i[0];
    kUr = new IListener() {};
    AppMethodBeat.o(44477);
  }
  
  static void b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(226383);
    if (!g.aAc())
    {
      AppMethodBeat.o(226383);
      return;
    }
    Object localObject = (Boolean)g.aAh().azQ().get(ar.a.NXP, null);
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()) && (paramBoolean1))
    {
      g.aAh().azQ().set(ar.a.NYa, Boolean.TRUE);
      localObject = t.e.kVn;
      t.e.byi();
    }
    for (int i = 1;; i = 0)
    {
      g.aAh().azQ().set(ar.a.NXP, Boolean.valueOf(paramBoolean1));
      if (!paramBoolean2)
      {
        AppMethodBeat.o(226383);
        return;
      }
      if (i != 0)
      {
        localObject = n.buB();
        if (localObject != null) {
          ((AppBrandGuideUI.a)localObject).afr(paramString);
        }
      }
      AppMethodBeat.o(226383);
      return;
    }
  }
  
  public static boolean bxK()
  {
    AppMethodBeat.i(44468);
    if (!g.aAc())
    {
      AppMethodBeat.o(44468);
      return false;
    }
    if (h.aqJ().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      Log.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
      AppMethodBeat.o(44468);
      return false;
    }
    if ((bxP()) || (t.byb()))
    {
      AppMethodBeat.o(44468);
      return true;
    }
    AppMethodBeat.o(44468);
    return false;
  }
  
  public static void bxL()
  {
    AppMethodBeat.i(44469);
    if (!g.aAc())
    {
      AppMethodBeat.o(44469);
      return;
    }
    if (bxM())
    {
      t.e locale = t.e.kVn;
      t.e.a("", 0L, 2, 1);
    }
    g.aAh().azQ().set(ar.a.NYa, Boolean.FALSE);
    AppMethodBeat.o(44469);
  }
  
  static boolean bxM()
  {
    AppMethodBeat.i(44470);
    if (!g.aAc())
    {
      AppMethodBeat.o(44470);
      return false;
    }
    boolean bool = ((Boolean)g.aAh().azQ().get(ar.a.NYa, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44470);
    return bool;
  }
  
  public static boolean bxN()
  {
    AppMethodBeat.i(44474);
    if (!g.aAc())
    {
      AppMethodBeat.o(44474);
      return false;
    }
    boolean bool = ((Boolean)g.aAh().azQ().get(ar.a.NXP, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44474);
    return bool;
  }
  
  public static boolean bxO()
  {
    AppMethodBeat.i(44475);
    v.bym();
    if (!g.aAc())
    {
      AppMethodBeat.o(44475);
      return false;
    }
    boolean bool = ((Boolean)g.aAh().azQ().get(ar.a.NXO, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44475);
    return bool;
  }
  
  public static boolean bxP()
  {
    AppMethodBeat.i(44476);
    if ((bxO()) || (bxN()))
    {
      AppMethodBeat.o(44476);
      return true;
    }
    AppMethodBeat.o(44476);
    return false;
  }
  
  static void dO(int paramInt1, int paramInt2)
  {
    boolean bool3 = true;
    AppMethodBeat.i(226382);
    if (!g.aAc())
    {
      AppMethodBeat.o(226382);
      return;
    }
    ao localao = g.aAh().azQ();
    boolean bool2;
    label43:
    ar.a locala;
    if ((paramInt1 & 0x2) > 0)
    {
      bool1 = true;
      if (paramInt2 == 4) {
        break label86;
      }
      bool2 = true;
      b(bool1, bool2, "");
      locala = ar.a.NXO;
      if ((paramInt1 & 0x1) <= 0) {
        break label91;
      }
    }
    label86:
    label91:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      localao.set(locala, Boolean.valueOf(bool1));
      AppMethodBeat.o(226382);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.i
 * JD-Core Version:    0.7.0.1
 */
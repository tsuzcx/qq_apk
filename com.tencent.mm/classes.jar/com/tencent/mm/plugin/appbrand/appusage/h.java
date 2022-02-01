package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xl;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public enum h
{
  public static final IListener<xl> qOw;
  
  static
  {
    AppMethodBeat.i(44477);
    qOx = new h[0];
    qOw = new AppBrandEntranceLogic.1(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(44477);
  }
  
  static void b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(319321);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(319321);
      return;
    }
    Object localObject = (Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNk, null);
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()) && (paramBoolean1))
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acNv, Boolean.TRUE);
      localObject = s.e.qPs;
      s.e.cjb();
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acNk, Boolean.valueOf(paramBoolean1));
      if (!paramBoolean2)
      {
        AppMethodBeat.o(319321);
        return;
      }
      if (i != 0)
      {
        localObject = n.cfb();
        if (localObject != null) {
          ((AppBrandGuideUI.a)localObject).agf(paramString);
        }
      }
      AppMethodBeat.o(319321);
      return;
    }
  }
  
  public static boolean ciD()
  {
    AppMethodBeat.i(44468);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(44468);
      return false;
    }
    if (i.aRC().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      Log.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
      AppMethodBeat.o(44468);
      return false;
    }
    if ((ciI()) || (s.ciU()))
    {
      AppMethodBeat.o(44468);
      return true;
    }
    AppMethodBeat.o(44468);
    return false;
  }
  
  public static void ciE()
  {
    AppMethodBeat.i(44469);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(44469);
      return;
    }
    if (ciF())
    {
      s.e locale = s.e.qPs;
      s.e.a("", 0L, 2, 1);
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acNv, Boolean.FALSE);
    AppMethodBeat.o(44469);
  }
  
  static boolean ciF()
  {
    AppMethodBeat.i(44470);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(44470);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNv, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44470);
    return bool;
  }
  
  public static boolean ciG()
  {
    AppMethodBeat.i(44474);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(44474);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNk, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44474);
    return bool;
  }
  
  public static boolean ciH()
  {
    AppMethodBeat.i(44475);
    if (!u.cjf())
    {
      AppMethodBeat.o(44475);
      return false;
    }
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(44475);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNj, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44475);
    return bool;
  }
  
  public static boolean ciI()
  {
    AppMethodBeat.i(44476);
    if ((ciH()) || (ciG()))
    {
      AppMethodBeat.o(44476);
      return true;
    }
    AppMethodBeat.o(44476);
    return false;
  }
  
  static void ff(int paramInt1, int paramInt2)
  {
    boolean bool3 = true;
    AppMethodBeat.i(319318);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(319318);
      return;
    }
    aq localaq = com.tencent.mm.kernel.h.baE().ban();
    boolean bool2;
    label43:
    at.a locala;
    if ((paramInt1 & 0x2) > 0)
    {
      bool1 = true;
      if (paramInt2 == 4) {
        break label86;
      }
      bool2 = true;
      b(bool1, bool2, "");
      locala = at.a.acNj;
      if ((paramInt1 & 0x1) <= 0) {
        break label91;
      }
    }
    label86:
    label91:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      localaq.set(locala, Boolean.valueOf(bool1));
      AppMethodBeat.o(319318);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.h
 * JD-Core Version:    0.7.0.1
 */
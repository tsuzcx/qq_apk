package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public enum i
{
  public static final c<tb> juw;
  
  static
  {
    AppMethodBeat.i(44477);
    jux = new i[0];
    juw = new c() {};
    AppMethodBeat.o(44477);
  }
  
  static void Jl(String paramString)
  {
    AppMethodBeat.i(44473);
    k(true, paramString);
    AppMethodBeat.o(44473);
  }
  
  public static boolean aYt()
  {
    AppMethodBeat.i(44468);
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(44468);
      return false;
    }
    if (com.tencent.mm.m.g.ZY().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      ac.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
      AppMethodBeat.o(44468);
      return false;
    }
    if ((aYy()) || (t.aYJ()))
    {
      AppMethodBeat.o(44468);
      return true;
    }
    AppMethodBeat.o(44468);
    return false;
  }
  
  public static void aYu()
  {
    AppMethodBeat.i(44469);
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(44469);
      return;
    }
    if (aYv())
    {
      t.e locale = t.e.jvs;
      t.e.a("", 0L, 2, 1);
    }
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJj, Boolean.FALSE);
    AppMethodBeat.o(44469);
  }
  
  static boolean aYv()
  {
    AppMethodBeat.i(44470);
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(44470);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GJj, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44470);
    return bool;
  }
  
  public static boolean aYw()
  {
    AppMethodBeat.i(44474);
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(44474);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIY, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44474);
    return bool;
  }
  
  public static boolean aYx()
  {
    AppMethodBeat.i(44475);
    v.aYU();
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(44475);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIX, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44475);
    return bool;
  }
  
  public static boolean aYy()
  {
    AppMethodBeat.i(44476);
    if ((aYx()) || (aYw()))
    {
      AppMethodBeat.o(44476);
      return true;
    }
    AppMethodBeat.o(44476);
    return false;
  }
  
  private static void k(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(44472);
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(44472);
      return;
    }
    Object localObject = (Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIY, null);
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()) && (paramBoolean))
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJj, Boolean.TRUE);
      localObject = t.e.jvs;
      t.e.aYQ();
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIY, Boolean.valueOf(paramBoolean));
      if (i != 0)
      {
        localObject = j.aVt();
        if (localObject != null) {
          ((AppBrandGuideUI.a)localObject).Rf(paramString);
        }
      }
      AppMethodBeat.o(44472);
      return;
    }
  }
  
  static void rw(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(44471);
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(44471);
      return;
    }
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    ah.a locala;
    if ((paramInt & 0x2) > 0)
    {
      bool1 = true;
      k(bool1, "");
      locala = ah.a.GIX;
      if ((paramInt & 0x1) <= 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localae.set(locala, Boolean.valueOf(bool1));
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
package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public enum i
{
  public static final c<tt> jOp;
  
  static
  {
    AppMethodBeat.i(44477);
    jOq = new i[0];
    jOp = new c() {};
    AppMethodBeat.o(44477);
  }
  
  static void MC(String paramString)
  {
    AppMethodBeat.i(44473);
    m(true, paramString);
    AppMethodBeat.o(44473);
  }
  
  public static boolean bbR()
  {
    AppMethodBeat.i(44468);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(44468);
      return false;
    }
    if (com.tencent.mm.n.g.acA().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      ad.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
      AppMethodBeat.o(44468);
      return false;
    }
    if ((bbW()) || (t.bch()))
    {
      AppMethodBeat.o(44468);
      return true;
    }
    AppMethodBeat.o(44468);
    return false;
  }
  
  public static void bbS()
  {
    AppMethodBeat.i(44469);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(44469);
      return;
    }
    if (bbT())
    {
      t.e locale = t.e.jPl;
      t.e.a("", 0L, 2, 1);
    }
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IvB, Boolean.FALSE);
    AppMethodBeat.o(44469);
  }
  
  static boolean bbT()
  {
    AppMethodBeat.i(44470);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(44470);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IvB, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44470);
    return bool;
  }
  
  public static boolean bbU()
  {
    AppMethodBeat.i(44474);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(44474);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivq, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44474);
    return bool;
  }
  
  public static boolean bbV()
  {
    AppMethodBeat.i(44475);
    v.bcs();
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(44475);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivp, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44475);
    return bool;
  }
  
  public static boolean bbW()
  {
    AppMethodBeat.i(44476);
    if ((bbV()) || (bbU()))
    {
      AppMethodBeat.o(44476);
      return true;
    }
    AppMethodBeat.o(44476);
    return false;
  }
  
  private static void m(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(44472);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(44472);
      return;
    }
    Object localObject = (Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivq, null);
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()) && (paramBoolean))
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IvB, Boolean.TRUE);
      localObject = t.e.jPl;
      t.e.bco();
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ivq, Boolean.valueOf(paramBoolean));
      if (i != 0)
      {
        localObject = j.aYO();
        if (localObject != null) {
          ((AppBrandGuideUI.a)localObject).UL(paramString);
        }
      }
      AppMethodBeat.o(44472);
      return;
    }
  }
  
  static void rW(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(44471);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(44471);
      return;
    }
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    al.a locala;
    if ((paramInt & 0x2) > 0)
    {
      bool1 = true;
      m(bool1, "");
      locala = al.a.Ivp;
      if ((paramInt & 0x1) <= 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localai.set(locala, Boolean.valueOf(bool1));
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
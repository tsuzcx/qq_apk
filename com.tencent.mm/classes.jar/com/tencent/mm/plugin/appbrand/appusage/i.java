package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public enum i
{
  public static final c<qz> hba;
  
  static
  {
    AppMethodBeat.i(129546);
    hbb = new i[0];
    hba = new i.1();
    AppMethodBeat.o(129546);
  }
  
  public static boolean awU()
  {
    AppMethodBeat.i(129537);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(129537);
      return false;
    }
    if (com.tencent.mm.m.g.Nq().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      ab.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
      AppMethodBeat.o(129537);
      return false;
    }
    if ((awZ()) || (r.axm()))
    {
      AppMethodBeat.o(129537);
      return true;
    }
    AppMethodBeat.o(129537);
    return false;
  }
  
  public static void awV()
  {
    AppMethodBeat.i(129538);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(129538);
      return;
    }
    if (awW())
    {
      r.e locale = r.e.hcb;
      r.e.a("", 0L, 2, 1);
    }
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCY, Boolean.FALSE);
    AppMethodBeat.o(129538);
  }
  
  static boolean awW()
  {
    AppMethodBeat.i(129539);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(129539);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCY, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129539);
    return bool;
  }
  
  public static boolean awX()
  {
    AppMethodBeat.i(129543);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(129543);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCN, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129543);
    return bool;
  }
  
  public static boolean awY()
  {
    AppMethodBeat.i(129544);
    t.axy();
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(129544);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCM, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129544);
    return bool;
  }
  
  public static boolean awZ()
  {
    AppMethodBeat.i(129545);
    if ((awY()) || (awX()))
    {
      AppMethodBeat.o(129545);
      return true;
    }
    AppMethodBeat.o(129545);
    return false;
  }
  
  private static void h(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(129541);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(129541);
      return;
    }
    Object localObject = (Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCN, null);
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()) && (paramBoolean))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCY, Boolean.TRUE);
      localObject = r.e.hcb;
      r.e.axv();
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCN, Boolean.valueOf(paramBoolean));
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.appbrand.app.g.auE();
        if (localObject != null) {
          ((AppBrandGuideUI.a)localObject).Fd(paramString);
        }
      }
      AppMethodBeat.o(129541);
      return;
    }
  }
  
  static void nr(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(129540);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(129540);
      return;
    }
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    ac.a locala;
    if ((paramInt & 0x2) > 0)
    {
      bool1 = true;
      h(bool1, "");
      locala = ac.a.yCM;
      if ((paramInt & 0x1) <= 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localz.set(locala, Boolean.valueOf(bool1));
      AppMethodBeat.o(129540);
      return;
      bool1 = false;
      break;
    }
  }
  
  static void zu(String paramString)
  {
    AppMethodBeat.i(129542);
    h(true, paramString);
    AppMethodBeat.o(129542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.i
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.vv;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public enum i
{
  public static final IListener<vv> nOE;
  
  static
  {
    AppMethodBeat.i(44477);
    nOF = new i[0];
    nOE = new IListener() {};
    AppMethodBeat.o(44477);
  }
  
  static void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(279062);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(279062);
      return;
    }
    Object localObject = (Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlP, null);
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()) && (paramBoolean1))
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vma, Boolean.TRUE);
      localObject = t.e.nPA;
      t.e.bJx();
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VlP, Boolean.valueOf(paramBoolean1));
      if (!paramBoolean2)
      {
        AppMethodBeat.o(279062);
        return;
      }
      if (i != 0)
      {
        localObject = m.bFE();
        if (localObject != null) {
          ((AppBrandGuideUI.a)localObject).amT(paramString);
        }
      }
      AppMethodBeat.o(279062);
      return;
    }
  }
  
  public static boolean bIZ()
  {
    AppMethodBeat.i(44468);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(44468);
      return false;
    }
    if (com.tencent.mm.n.h.axc().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      Log.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
      AppMethodBeat.o(44468);
      return false;
    }
    if ((bJe()) || (t.bJq()))
    {
      AppMethodBeat.o(44468);
      return true;
    }
    AppMethodBeat.o(44468);
    return false;
  }
  
  public static void bJa()
  {
    AppMethodBeat.i(44469);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(44469);
      return;
    }
    if (bJb())
    {
      t.e locale = t.e.nPA;
      t.e.a("", 0L, 2, 1);
    }
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vma, Boolean.FALSE);
    AppMethodBeat.o(44469);
  }
  
  static boolean bJb()
  {
    AppMethodBeat.i(44470);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(44470);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vma, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44470);
    return bool;
  }
  
  public static boolean bJc()
  {
    AppMethodBeat.i(44474);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(44474);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlP, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44474);
    return bool;
  }
  
  public static boolean bJd()
  {
    AppMethodBeat.i(44475);
    v.bJA();
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(44475);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlO, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44475);
    return bool;
  }
  
  public static boolean bJe()
  {
    AppMethodBeat.i(44476);
    if ((bJd()) || (bJc()))
    {
      AppMethodBeat.o(44476);
      return true;
    }
    AppMethodBeat.o(44476);
    return false;
  }
  
  static void em(int paramInt1, int paramInt2)
  {
    boolean bool3 = true;
    AppMethodBeat.i(279061);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(279061);
      return;
    }
    ao localao = com.tencent.mm.kernel.h.aHG().aHp();
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
      a(bool1, bool2, "");
      locala = ar.a.VlO;
      if ((paramInt1 & 0x1) <= 0) {
        break label91;
      }
    }
    label86:
    label91:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      localao.set(locala, Boolean.valueOf(bool1));
      AppMethodBeat.o(279061);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.i
 * JD-Core Version:    0.7.0.1
 */
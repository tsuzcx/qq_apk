package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.h.a.ps;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public enum i
{
  public static final c<ps> fIi = new i.1();
  
  public static boolean acO()
  {
    if (!com.tencent.mm.kernel.g.DK()) {}
    do
    {
      return false;
      if (com.tencent.mm.m.g.AA().getInt("WeAppForbiddenSwitch", 0) == 1)
      {
        y.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
        return false;
      }
    } while ((!acT()) && (!r.adi()));
    return true;
  }
  
  public static void acP()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      return;
    }
    if (acQ())
    {
      r.e locale = r.e.fJj;
      r.e.a("", 0L, 2, 1);
    }
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.usY, Boolean.valueOf(false));
  }
  
  static boolean acQ()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      return false;
    }
    return ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usY, Boolean.valueOf(false))).booleanValue();
  }
  
  public static boolean acR()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      return false;
    }
    return ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usN, Boolean.valueOf(false))).booleanValue();
  }
  
  public static boolean acS()
  {
    t.adq();
    if (!com.tencent.mm.kernel.g.DK()) {
      return false;
    }
    return ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usM, Boolean.valueOf(false))).booleanValue();
  }
  
  public static boolean acT()
  {
    return (acS()) || (acR());
  }
  
  private static void e(boolean paramBoolean, String paramString)
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      return;
    }
    Object localObject = (Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usN, null);
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()) && (paramBoolean))
    {
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.usY, Boolean.valueOf(true));
      localObject = r.e.fJj;
      r.e.a("", 0L, 1, 1);
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.usN, Boolean.valueOf(paramBoolean));
      if (i == 0) {
        break;
      }
      localObject = com.tencent.mm.plugin.appbrand.app.e.aaR();
      if (localObject == null) {
        break;
      }
      ((AppBrandGuideUI.a)localObject).hcN = true;
      ((AppBrandGuideUI.a)localObject).hcO = paramString;
      return;
    }
  }
  
  static void kw(int paramInt)
  {
    boolean bool2 = true;
    if (!com.tencent.mm.kernel.g.DK()) {
      return;
    }
    z localz = com.tencent.mm.kernel.g.DP().Dz();
    ac.a locala;
    if ((paramInt & 0x2) > 0)
    {
      bool1 = true;
      e(bool1, "");
      locala = ac.a.usM;
      if ((paramInt & 0x1) <= 0) {
        break label59;
      }
    }
    label59:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localz.c(locala, Boolean.valueOf(bool1));
      return;
      bool1 = false;
      break;
    }
  }
  
  static void rF(String paramString)
  {
    e(true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.i
 * JD-Core Version:    0.7.0.1
 */
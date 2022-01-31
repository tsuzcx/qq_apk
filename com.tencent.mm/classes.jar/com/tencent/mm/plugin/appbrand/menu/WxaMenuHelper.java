package com.tencent.mm.plugin.appbrand.menu;

import android.util.SparseArray;
import java.util.List;

public final class WxaMenuHelper
{
  private final SparseArray<com.tencent.mm.plugin.appbrand.menu.a.a> gPB = new SparseArray();
  
  private WxaMenuHelper()
  {
    a(new c());
    a(new b());
    a(new i());
    a(new a());
    a(new h());
    a(new d());
    a(new g());
    a(new MenuDelegate_SendToDesktop());
    a(new j());
    a(new l());
    a(new m());
    a(new MenuDelegate_EnableDebug());
    a(new k());
    a(new f());
    a(new e());
  }
  
  private void a(com.tencent.mm.plugin.appbrand.menu.a.a parama)
  {
    this.gPB.put(parama.gPE, parama);
  }
  
  public static void c(List<n> paramList, int paramInt, boolean paramBoolean)
  {
    n localn = new n(paramInt, (com.tencent.mm.plugin.appbrand.menu.a.a)WxaMenuHelper.a.gPD.gPB.get(paramInt));
    localn.gPg = paramBoolean;
    paramList.add(localn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper
 * JD-Core Version:    0.7.0.1
 */
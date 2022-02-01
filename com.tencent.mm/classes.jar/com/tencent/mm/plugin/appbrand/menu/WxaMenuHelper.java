package com.tencent.mm.plugin.appbrand.menu;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class WxaMenuHelper
{
  private final SparseArray<com.tencent.mm.plugin.appbrand.menu.a.a> kSL;
  
  private WxaMenuHelper()
  {
    AppMethodBeat.i(47672);
    this.kSL = new SparseArray();
    a(new d());
    a(new i());
    a(new k());
    a(new m());
    a(new o());
    a(new n());
    a(new h());
    a(new l());
    a(new c());
    a(new j());
    a(new g());
    a(new e());
    a(new f());
    a(new a());
    AppMethodBeat.o(47672);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.menu.a.a parama)
  {
    AppMethodBeat.i(47674);
    this.kSL.put(parama.kSO, parama);
    AppMethodBeat.o(47674);
  }
  
  public static void a(List<p> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(47673);
    p localp = new p(paramInt, paramBoolean1, (com.tencent.mm.plugin.appbrand.menu.a.a)a.kSN.kSL.get(paramInt));
    localp.kRX = paramBoolean2;
    paramList.add(localp);
    AppMethodBeat.o(47673);
  }
  
  static final class a
  {
    static WxaMenuHelper kSN;
    
    static
    {
      AppMethodBeat.i(47671);
      kSN = new WxaMenuHelper((byte)0);
      AppMethodBeat.o(47671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper
 * JD-Core Version:    0.7.0.1
 */
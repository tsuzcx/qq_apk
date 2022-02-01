package com.tencent.mm.plugin.appbrand.menu;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class WxaMenuHelper
{
  private final SparseArray<com.tencent.mm.plugin.appbrand.menu.a.a> lTv;
  
  private WxaMenuHelper()
  {
    AppMethodBeat.i(47672);
    this.lTv = new SparseArray();
    a(new d());
    a(new i());
    a(new k());
    a(new m());
    a(new p());
    a(new n());
    a(new h());
    a(new l());
    a(new c());
    a(new j());
    a(new g());
    a(new e());
    a(new f());
    a(new a());
    a(new o());
    AppMethodBeat.o(47672);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.menu.a.a parama)
  {
    AppMethodBeat.i(47674);
    this.lTv.put(parama.lTy, parama);
    AppMethodBeat.o(47674);
  }
  
  public static void a(List<q> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(47673);
    q localq = new q(paramInt, paramBoolean1, (com.tencent.mm.plugin.appbrand.menu.a.a)a.lTx.lTv.get(paramInt));
    localq.lSG = paramBoolean2;
    paramList.add(localq);
    AppMethodBeat.o(47673);
  }
  
  static final class a
  {
    static WxaMenuHelper lTx;
    
    static
    {
      AppMethodBeat.i(47671);
      lTx = new WxaMenuHelper((byte)0);
      AppMethodBeat.o(47671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper
 * JD-Core Version:    0.7.0.1
 */
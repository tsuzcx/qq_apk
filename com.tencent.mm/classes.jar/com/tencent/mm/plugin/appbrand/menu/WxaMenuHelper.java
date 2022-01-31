package com.tencent.mm.plugin.appbrand.menu;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class WxaMenuHelper
{
  private final SparseArray<com.tencent.mm.plugin.appbrand.menu.a.a> irm;
  
  private WxaMenuHelper()
  {
    AppMethodBeat.i(132261);
    this.irm = new SparseArray();
    a(new c());
    a(new b());
    a(new l());
    a(new a());
    a(new k());
    a(new d());
    a(new h());
    a(new MenuDelegate_SendToDesktop());
    a(new m());
    a(new o());
    a(new p());
    a(new f());
    a(new n());
    a(new g());
    a(new e());
    a(new i());
    a(new j());
    AppMethodBeat.o(132261);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.menu.a.a parama)
  {
    AppMethodBeat.i(132263);
    this.irm.put(parama.irp, parama);
    AppMethodBeat.o(132263);
  }
  
  public static void c(List<q> paramList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(132262);
    q localq = new q(paramInt, (com.tencent.mm.plugin.appbrand.menu.a.a)WxaMenuHelper.a.iro.irm.get(paramInt));
    localq.iqO = paramBoolean;
    paramList.add(localq);
    AppMethodBeat.o(132262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper
 * JD-Core Version:    0.7.0.1
 */
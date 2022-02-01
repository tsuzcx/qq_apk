package com.tencent.mm.plugin.appbrand.menu;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class WxaMenuHelper
{
  private final SparseArray<com.tencent.mm.plugin.appbrand.menu.a.a> tkY;
  
  private WxaMenuHelper()
  {
    AppMethodBeat.i(47672);
    this.tkY = new SparseArray();
    a(new v());
    a(new k());
    a(new o());
    a(new q());
    a(new t());
    a(new r());
    a(new j());
    a(new p());
    a(new c());
    a(new u());
    a(new l());
    a(new e());
    a(new d());
    a(new i());
    a(new f());
    a(new g());
    a(new a());
    a(new s());
    a(new n());
    a(new m());
    a(new h());
    AppMethodBeat.o(47672);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.menu.a.a parama)
  {
    AppMethodBeat.i(47674);
    this.tkY.put(parama.tlb, parama);
    AppMethodBeat.o(47674);
  }
  
  public static void a(List<w> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(47673);
    w localw = new w(paramInt, paramBoolean1, (com.tencent.mm.plugin.appbrand.menu.a.a)a.tla.tkY.get(paramInt));
    localw.disable = paramBoolean2;
    paramList.add(localw);
    AppMethodBeat.o(47673);
  }
  
  public static boolean a(w paramw, String paramString)
  {
    AppMethodBeat.i(323895);
    if (paramw != null)
    {
      boolean bool = paramw.rDC.Jp(paramString);
      AppMethodBeat.o(323895);
      return bool;
    }
    Log.w("MicroMsg.AppBrand.WxaMenuHelper", "safeGetBoolean, menuInfo is null, key: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(323895);
    return false;
  }
  
  public static void b(w paramw, String paramString)
  {
    AppMethodBeat.i(323898);
    if (paramw != null)
    {
      paramw.rDC.N(paramString, true);
      AppMethodBeat.o(323898);
      return;
    }
    Log.w("MicroMsg.AppBrand.WxaMenuHelper", "safeSetBoolean, menuInfo is null, key: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(323898);
  }
  
  static final class a
  {
    static WxaMenuHelper tla;
    
    static
    {
      AppMethodBeat.i(47671);
      tla = new WxaMenuHelper((byte)0);
      AppMethodBeat.o(47671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibCodeCacheHelper;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibPreloadSessionInMM$ICommLibSessionDelegate;", "()V", "LAST_DEV_LIB_VERSION_CODE_KEY", "", "LAST_DEV_LIB_VERSION_NAME_KEY", "SP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSP", "()Landroid/content/SharedPreferences;", "TAG", "onUpdateUsingVersion", "", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "plugin-appbrand-integration_release"})
public final class aq
  implements as.a
{
  public static final aq jHb;
  
  static
  {
    AppMethodBeat.i(50179);
    jHb = new aq();
    AppMethodBeat.o(50179);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public final void b(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(50178);
    p.h(paramICommLibReader, "reader");
    c.b(null, (a)new a(paramICommLibReader));
    AppMethodBeat.o(50178);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    a(ICommLibReader paramICommLibReader)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aq
 * JD-Core Version:    0.7.0.1
 */
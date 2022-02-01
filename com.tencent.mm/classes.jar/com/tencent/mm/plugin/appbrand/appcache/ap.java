package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibCodeCacheHelper;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibPreloadSessionInMM$ICommLibSessionDelegate;", "()V", "LAST_DEV_LIB_VERSION_CODE_KEY", "", "LAST_DEV_LIB_VERSION_NAME_KEY", "SP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSP", "()Landroid/content/SharedPreferences;", "TAG", "onUpdateUsingVersion", "", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "plugin-appbrand-integration_release"})
public final class ap
  implements ar.a
{
  public static final ap jnd;
  
  static
  {
    AppMethodBeat.i(50179);
    jnd = new ap();
    AppMethodBeat.o(50179);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public final void b(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(50178);
    k.h(paramICommLibReader, "reader");
    c.b(null, (a)new a(paramICommLibReader));
    AppMethodBeat.o(50178);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(ICommLibReader paramICommLibReader)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap
 * JD-Core Version:    0.7.0.1
 */
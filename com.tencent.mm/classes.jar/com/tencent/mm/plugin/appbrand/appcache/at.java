package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibCodeCacheHelper;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibPreloadSessionInMM$ICommLibSessionDelegate;", "()V", "LAST_DEV_LIB_VERSION_CODE_KEY", "", "LAST_DEV_LIB_VERSION_NAME_KEY", "SP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSP", "()Landroid/content/SharedPreferences;", "TAG", "onUpdateUsingVersion", "", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
  implements av.a
{
  public static final at qFK;
  
  static
  {
    AppMethodBeat.i(50179);
    qFK = new at();
    AppMethodBeat.o(50179);
  }
  
  public final void d(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(50178);
    s.u(paramICommLibReader, "reader");
    d.B((a)new a(paramICommLibReader));
    AppMethodBeat.o(50178);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(ICommLibReader paramICommLibReader)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.at
 * JD-Core Version:    0.7.0.1
 */
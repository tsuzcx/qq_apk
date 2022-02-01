package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import androidx.lifecycle.af;
import androidx.lifecycle.ah.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoRevokeViewModel$Providers$of$1", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$a$a
  extends ah.d
{
  l$a$a(AppBrandUserInfoRevokePage paramAppBrandUserInfoRevokePage, String paramString) {}
  
  public final <T extends af> T create(Class<T> paramClass)
  {
    AppMethodBeat.i(322929);
    s.u(paramClass, "modelClass");
    if (s.p(l.class, paramClass))
    {
      paramClass = (af)new l(this.ukG, this.eug, null);
      AppMethodBeat.o(322929);
      return paramClass;
    }
    paramClass = super.create(paramClass);
    AppMethodBeat.o(322929);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.l.a.a
 * JD-Core Version:    0.7.0.1
 */
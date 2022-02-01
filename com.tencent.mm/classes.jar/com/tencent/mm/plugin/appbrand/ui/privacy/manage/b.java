package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandAuthorizeScopeModifyObserver;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "onAuthorizeScopeModify", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppAuthorizeScopeInfo;", "", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lkotlin/jvm/functions/Function1;)V", "listener", "com/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandAuthorizeScopeModifyObserver$listener$1", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandAuthorizeScopeModifyObserver$listener$1;", "dead", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  public static final a uiK;
  private final kotlin.g.a.b<i, ah> uiL;
  private final AppBrandAuthorizeScopeModifyObserver.listener.1 uiM;
  
  static
  {
    AppMethodBeat.i(322989);
    uiK = new a((byte)0);
    AppMethodBeat.o(322989);
  }
  
  public b(com.tencent.mm.vending.e.b<a> paramb, kotlin.g.a.b<? super i, ah> paramb1)
  {
    AppMethodBeat.i(322979);
    this.uiL = paramb1;
    this.uiM = new AppBrandAuthorizeScopeModifyObserver.listener.1(this, f.hfK);
    paramb.keep((a)this);
    this.uiM.alive();
    AppMethodBeat.o(322979);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(322995);
    Log.i("MicroMsg.AppBrandAuthorizeScopeModifyObserver", "dead");
    this.uiM.dead();
    AppMethodBeat.o(322995);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandAuthorizeScopeModifyObserver$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.b
 * JD-Core Version:    0.7.0.1
 */
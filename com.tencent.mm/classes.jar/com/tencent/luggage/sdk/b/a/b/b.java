package com.tencent.luggage.sdk.b.a.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "mEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mSavedKeyboardHeight", "", "getHeight", "onBackground", "", "onDestroy", "onForeground", "onKeyboardStateChanged", "shown", "", "refreshHeight", "height", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
  implements f.b, f.c, f.d, u.c
{
  public static final a coh;
  private final z ckP;
  private final ab coe;
  private int cof;
  private u cog;
  
  static
  {
    AppMethodBeat.i(147831);
    coh = new a((byte)0);
    AppMethodBeat.o(147831);
  }
  
  private b(z paramz)
  {
    AppMethodBeat.i(147830);
    this.ckP = paramz;
    this.coe = new ab();
    AppMethodBeat.o(147830);
  }
  
  public static final void a(z paramz)
  {
    AppMethodBeat.i(147832);
    p.h(paramz, "pv");
    b localb = new b(paramz, (byte)0);
    paramz.a((f.d)localb);
    paramz.a((f.b)localb);
    paramz.a((f.c)localb);
    AppMethodBeat.o(147832);
  }
  
  public final void bu(boolean paramBoolean)
  {
    AppMethodBeat.i(147826);
    ab localab = this.coe;
    if (paramBoolean) {}
    for (int i = this.cof;; i = 0)
    {
      r localr = this.ckP.Ey();
      p.g(localr, "mPageView.service");
      ab.a(localab, i, localr, this.ckP);
      AppMethodBeat.o(147826);
      return;
    }
  }
  
  public final void gB(int paramInt)
  {
    this.cof = paramInt;
  }
  
  public final int getHeight()
  {
    return this.cof;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(147828);
    u localu = this.cog;
    if (localu != null)
    {
      localu.b((u.c)this);
      AppMethodBeat.o(147828);
      return;
    }
    AppMethodBeat.o(147828);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(147827);
    u localu = this.cog;
    if (localu != null)
    {
      localu.b((u.c)this);
      AppMethodBeat.o(147827);
      return;
    }
    AppMethodBeat.o(147827);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(147829);
    if (this.ckP.getContentView() == null)
    {
      AppMethodBeat.o(147829);
      return;
    }
    Object localObject = this.ckP.getContentView();
    if (localObject == null) {
      p.gkB();
    }
    this.cog = n.df((View)localObject);
    localObject = this.cog;
    if (localObject != null)
    {
      ((u)localObject).a((u.c)this);
      AppMethodBeat.o(147829);
      return;
    }
    AppMethodBeat.o(147829);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter$Companion;", "", "()V", "install", "", "pv", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */
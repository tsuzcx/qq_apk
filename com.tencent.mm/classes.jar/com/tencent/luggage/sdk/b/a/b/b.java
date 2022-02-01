package com.tencent.luggage.sdk.b.a.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "mEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mSavedKeyboardHeight", "", "getHeight", "onBackground", "", "onDestroy", "onForeground", "onKeyboardStateChanged", "shown", "", "refreshHeight", "height", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
  implements f.b, f.c, f.d, u.c
{
  public static final b.a cof;
  private final aa ckN;
  private final ab coc;
  private int cod;
  private u coe;
  
  static
  {
    AppMethodBeat.i(147831);
    cof = new b.a((byte)0);
    AppMethodBeat.o(147831);
  }
  
  private b(aa paramaa)
  {
    AppMethodBeat.i(147830);
    this.ckN = paramaa;
    this.coc = new ab();
    AppMethodBeat.o(147830);
  }
  
  public static final void a(aa paramaa)
  {
    AppMethodBeat.i(147832);
    p.h(paramaa, "pv");
    b localb = new b(paramaa, (byte)0);
    paramaa.a((f.d)localb);
    paramaa.a((f.b)localb);
    paramaa.a((f.c)localb);
    AppMethodBeat.o(147832);
  }
  
  public final void bu(boolean paramBoolean)
  {
    AppMethodBeat.i(147826);
    ab localab = this.coc;
    if (paramBoolean) {}
    for (int i = this.cod;; i = 0)
    {
      q localq = this.ckN.Ew();
      p.g(localq, "mPageView.service");
      ab.a(localab, i, localq, this.ckN);
      AppMethodBeat.o(147826);
      return;
    }
  }
  
  public final void gB(int paramInt)
  {
    this.cod = paramInt;
  }
  
  public final int getHeight()
  {
    return this.cod;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(147828);
    u localu = this.coe;
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
    u localu = this.coe;
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
    if (this.ckN.getContentView() == null)
    {
      AppMethodBeat.o(147829);
      return;
    }
    Object localObject = this.ckN.getContentView();
    if (localObject == null) {
      p.gfZ();
    }
    this.coe = n.df((View)localObject);
    localObject = this.coe;
    if (localObject != null)
    {
      ((u)localObject).a((u.c)this);
      AppMethodBeat.o(147829);
      return;
    }
    AppMethodBeat.o(147829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */
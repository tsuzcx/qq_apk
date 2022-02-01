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
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "mEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mSavedKeyboardHeight", "", "getHeight", "onBackground", "", "onDestroy", "onForeground", "onKeyboardStateChanged", "shown", "", "refreshHeight", "height", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
  implements f.b, f.c, f.d, u.c
{
  public static final b.a cgT;
  private final aa cdz;
  private final ab cgQ;
  private int cgR;
  private u cgS;
  
  static
  {
    AppMethodBeat.i(147831);
    cgT = new b.a((byte)0);
    AppMethodBeat.o(147831);
  }
  
  private b(aa paramaa)
  {
    AppMethodBeat.i(147830);
    this.cdz = paramaa;
    this.cgQ = new ab();
    AppMethodBeat.o(147830);
  }
  
  public static final void a(aa paramaa)
  {
    AppMethodBeat.i(147832);
    k.h(paramaa, "pv");
    b localb = new b(paramaa, (byte)0);
    paramaa.a((f.d)localb);
    paramaa.a((f.b)localb);
    paramaa.a((f.c)localb);
    AppMethodBeat.o(147832);
  }
  
  public final void bu(boolean paramBoolean)
  {
    AppMethodBeat.i(147826);
    ab localab = this.cgQ;
    if (paramBoolean) {}
    for (int i = this.cgR;; i = 0)
    {
      q localq = this.cdz.Du();
      k.g(localq, "mPageView.service");
      ab.a(localab, i, localq, this.cdz);
      AppMethodBeat.o(147826);
      return;
    }
  }
  
  public final void gM(int paramInt)
  {
    this.cgR = paramInt;
  }
  
  public final int getHeight()
  {
    return this.cgR;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(147828);
    u localu = this.cgS;
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
    u localu = this.cgS;
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
    if (this.cdz.getContentView() == null)
    {
      AppMethodBeat.o(147829);
      return;
    }
    Object localObject = this.cdz.getContentView();
    if (localObject == null) {
      k.fvU();
    }
    this.cgS = n.db((View)localObject);
    localObject = this.cgS;
    if (localObject != null)
    {
      ((u)localObject).a((u.c)this);
      AppMethodBeat.o(147829);
      return;
    }
    AppMethodBeat.o(147829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "mEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mSavedKeyboardHeight", "", "getHeight", "onBackground", "", "onDestroy", "onForeground", "onKeyboardStateChanged", "shown", "", "refreshHeight", "height", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
  implements f.b, f.c, f.d, u.c
{
  public static final a cdP;
  private final aa caw;
  private final ab cdM;
  private int cdN;
  private u cdO;
  
  static
  {
    AppMethodBeat.i(147831);
    cdP = new a((byte)0);
    AppMethodBeat.o(147831);
  }
  
  private b(aa paramaa)
  {
    AppMethodBeat.i(147830);
    this.caw = paramaa;
    this.cdM = new ab();
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
  
  public final void bt(boolean paramBoolean)
  {
    AppMethodBeat.i(147826);
    ab localab = this.cdM;
    if (paramBoolean) {}
    for (int i = this.cdN;; i = 0)
    {
      q localq = this.caw.CX();
      k.g(localq, "mPageView.service");
      ab.a(localab, i, localq, this.caw);
      AppMethodBeat.o(147826);
      return;
    }
  }
  
  public final int getHeight()
  {
    return this.cdN;
  }
  
  public final void gw(int paramInt)
  {
    this.cdN = paramInt;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(147828);
    u localu = this.cdO;
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
    u localu = this.cdO;
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
    if (this.caw.getContentView() == null)
    {
      AppMethodBeat.o(147829);
      return;
    }
    Object localObject = this.caw.getContentView();
    if (localObject == null) {
      k.fOy();
    }
    this.cdO = n.dd((View)localObject);
    localObject = this.cdO;
    if (localObject != null)
    {
      ((u)localObject).a((u.c)this);
      AppMethodBeat.o(147829);
      return;
    }
    AppMethodBeat.o(147829);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter$Companion;", "", "()V", "install", "", "pv", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */
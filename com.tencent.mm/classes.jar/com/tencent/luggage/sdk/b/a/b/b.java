package com.tencent.luggage.sdk.b.a.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "mEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "mIsKeyboardShowing", "", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mSavedKeyboardHeight", "", "getHeight", "onBackground", "", "onDestroy", "onForeground", "onKeyboardStateChanged", "shown", "refreshHeight", "height", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
  implements i.b, i.c, i.d, u.c
{
  public static final a cAm;
  private final af cAj;
  private u cAk;
  private boolean cAl;
  private int crC;
  private final ac cwK;
  
  static
  {
    AppMethodBeat.i(147831);
    cAm = new a((byte)0);
    AppMethodBeat.o(147831);
  }
  
  private b(ac paramac)
  {
    AppMethodBeat.i(147830);
    this.cwK = paramac;
    this.cAj = new af();
    AppMethodBeat.o(147830);
  }
  
  public static final void a(ac paramac)
  {
    AppMethodBeat.i(147832);
    p.h(paramac, "pv");
    b localb = new b(paramac, (byte)0);
    paramac.a((i.d)localb);
    paramac.a((i.b)localb);
    paramac.a((i.c)localb);
    AppMethodBeat.o(147832);
  }
  
  public final void bQ(boolean paramBoolean)
  {
    AppMethodBeat.i(147826);
    this.cAl = paramBoolean;
    af localaf = this.cAj;
    if (paramBoolean) {}
    for (int i = this.crC;; i = 0)
    {
      s locals = this.cwK.NY();
      p.g(locals, "mPageView.service");
      af.a(localaf, i, locals, this.cwK);
      AppMethodBeat.o(147826);
      return;
    }
  }
  
  public final int getHeight()
  {
    return this.crC;
  }
  
  public final void hF(int paramInt)
  {
    this.crC = paramInt;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(147828);
    if ((this.cAl) && (this.cwK.NY() != null))
    {
      localObject = this.cAj;
      s locals = this.cwK.NY();
      p.g(locals, "mPageView.service");
      af.a((af)localObject, 0, locals, this.cwK);
    }
    Object localObject = this.cAk;
    if (localObject != null)
    {
      ((u)localObject).b((u.c)this);
      AppMethodBeat.o(147828);
      return;
    }
    AppMethodBeat.o(147828);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(147827);
    u localu = this.cAk;
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
    if (this.cwK.getContentView() == null)
    {
      AppMethodBeat.o(147829);
      return;
    }
    Object localObject = this.cwK.getContentView();
    if (localObject == null) {
      p.hyc();
    }
    this.cAk = n.cY((View)localObject);
    localObject = this.cAk;
    if (localObject != null)
    {
      ((u)localObject).a((u.c)this);
      AppMethodBeat.o(147829);
      return;
    }
    AppMethodBeat.o(147829);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter$Companion;", "", "()V", "install", "", "pv", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */
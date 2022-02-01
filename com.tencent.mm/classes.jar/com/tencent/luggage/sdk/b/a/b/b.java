package com.tencent.luggage.sdk.b.a.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "mEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "mIsKeyboardShowing", "", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mSavedKeyboardHeight", "", "getHeight", "onBackground", "", "onDestroy", "onForeground", "onKeyboardStateChanged", "shown", "refreshHeight", "height", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
  implements h.b, h.c, h.d, u.c
{
  public static final b.a czs;
  private int cpD;
  private final ad cvo;
  private final af czp;
  private u czq;
  private boolean czr;
  
  static
  {
    AppMethodBeat.i(147831);
    czs = new b.a((byte)0);
    AppMethodBeat.o(147831);
  }
  
  private b(ad paramad)
  {
    AppMethodBeat.i(147830);
    this.cvo = paramad;
    this.czp = new af();
    AppMethodBeat.o(147830);
  }
  
  public static final void a(ad paramad)
  {
    AppMethodBeat.i(147832);
    p.k(paramad, "pv");
    b localb = new b(paramad, (byte)0);
    paramad.a((h.d)localb);
    paramad.a((h.b)localb);
    paramad.a((h.c)localb);
    AppMethodBeat.o(147832);
  }
  
  public final void ca(boolean paramBoolean)
  {
    AppMethodBeat.i(147826);
    this.czr = paramBoolean;
    af localaf = this.czp;
    if (paramBoolean) {}
    for (int i = this.cpD;; i = 0)
    {
      v localv = this.cvo.QW();
      p.j(localv, "mPageView.service");
      af.a(localaf, i, localv, this.cvo);
      AppMethodBeat.o(147826);
      return;
    }
  }
  
  public final int getHeight()
  {
    return this.cpD;
  }
  
  public final void iF(int paramInt)
  {
    this.cpD = paramInt;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(147828);
    if ((this.czr) && (this.cvo.QW() != null))
    {
      localObject = this.czp;
      v localv = this.cvo.QW();
      p.j(localv, "mPageView.service");
      af.a((af)localObject, 0, localv, this.cvo);
    }
    Object localObject = this.czq;
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
    u localu = this.czq;
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
    if (this.cvo.getContentView() == null)
    {
      AppMethodBeat.o(147829);
      return;
    }
    Object localObject = this.cvo.getContentView();
    if (localObject == null) {
      p.iCn();
    }
    this.czq = n.dr((View)localObject);
    localObject = this.czq;
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
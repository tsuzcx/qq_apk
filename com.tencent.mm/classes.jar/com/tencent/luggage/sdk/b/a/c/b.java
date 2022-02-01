package com.tencent.luggage.sdk.b.a.c;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.appbrand.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "mEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "mIsKeyboardShowing", "", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mSavedKeyboardHeight", "", "getHeight", "onBackground", "", "onDestroy", "onForeground", "onKeyboardStateChanged", "shown", "refreshHeight", "height", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements i.b, i.c, i.d, u.c
{
  public static final b.a erN;
  private int ehr;
  private final ad enm;
  private final ai erO;
  private u erP;
  private boolean erQ;
  
  static
  {
    AppMethodBeat.i(147831);
    erN = new b.a((byte)0);
    AppMethodBeat.o(147831);
  }
  
  private b(ad paramad)
  {
    AppMethodBeat.i(147830);
    this.enm = paramad;
    this.erO = new ai();
    AppMethodBeat.o(147830);
  }
  
  public static final void a(ad paramad)
  {
    AppMethodBeat.i(147832);
    s.u(paramad, "pv");
    b localb = new b(paramad, (byte)0);
    paramad.a((i.d)localb);
    paramad.a((i.b)localb);
    paramad.a((i.c)localb);
    AppMethodBeat.o(147832);
  }
  
  public final void cK(boolean paramBoolean)
  {
    AppMethodBeat.i(147826);
    this.erQ = paramBoolean;
    ai localai = this.erO;
    if (paramBoolean) {}
    for (int i = this.ehr;; i = 0)
    {
      y localy = this.enm.ari();
      s.s(localy, "mPageView.service");
      ai.a(localai, i, localy, this.enm);
      AppMethodBeat.o(147826);
      return;
    }
  }
  
  public final int getHeight()
  {
    return this.ehr;
  }
  
  public final void mo(int paramInt)
  {
    this.ehr = paramInt;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(147828);
    if ((this.erQ) && (this.enm.ari() != null))
    {
      localObject = this.erO;
      y localy = this.enm.ari();
      s.s(localy, "mPageView.service");
      ai.a((ai)localObject, 0, localy, this.enm);
    }
    Object localObject = this.erP;
    if (localObject != null) {
      ((u)localObject).b((u.c)this);
    }
    this.erP = null;
    AppMethodBeat.o(147828);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(147827);
    u localu = this.erP;
    if (localu != null) {
      localu.b((u.c)this);
    }
    AppMethodBeat.o(147827);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(147829);
    if (this.enm.getContentView() == null)
    {
      AppMethodBeat.o(147829);
      return;
    }
    Object localObject = this.enm.getContentView();
    s.checkNotNull(localObject);
    this.erP = n.ef((View)localObject);
    localObject = this.erP;
    if (localObject != null) {
      ((u)localObject).a((u.c)this);
    }
    AppMethodBeat.o(147829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.sdk.b.a.b;

import a.f.b.j;
import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "mEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mSavedKeyboardHeight", "", "getHeight", "onBackground", "", "onDestroy", "onForeground", "onKeyboardStateChanged", "shown", "", "refreshHeight", "height", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
  implements f.b, f.c, f.d, u.c
{
  public static final a bEo;
  private final v bBK;
  private final w bEl;
  private int bEm;
  private u bEn;
  
  static
  {
    AppMethodBeat.i(140997);
    bEo = new a((byte)0);
    AppMethodBeat.o(140997);
  }
  
  private b(v paramv)
  {
    AppMethodBeat.i(140996);
    this.bBK = paramv;
    this.bEl = new w();
    AppMethodBeat.o(140996);
  }
  
  public static final void a(v paramv)
  {
    AppMethodBeat.i(140998);
    j.q(paramv, "pv");
    b localb = new b(paramv, (byte)0);
    paramv.a((f.d)localb);
    paramv.a((f.b)localb);
    paramv.a((f.c)localb);
    AppMethodBeat.o(140998);
  }
  
  public final void bc(boolean paramBoolean)
  {
    AppMethodBeat.i(140992);
    w localw = this.bEl;
    if (paramBoolean) {}
    for (int i = this.bEm;; i = 0)
    {
      r localr = this.bBK.ws();
      j.p(localr, "mPageView.service");
      w.a(localw, i, localr, this.bBK);
      AppMethodBeat.o(140992);
      return;
    }
  }
  
  public final void fu(int paramInt)
  {
    this.bEm = paramInt;
  }
  
  public final int getHeight()
  {
    return this.bEm;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(140994);
    u localu = this.bEn;
    if (localu != null)
    {
      localu.b((u.c)this);
      AppMethodBeat.o(140994);
      return;
    }
    AppMethodBeat.o(140994);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(140993);
    u localu = this.bEn;
    if (localu != null)
    {
      localu.b((u.c)this);
      AppMethodBeat.o(140993);
      return;
    }
    AppMethodBeat.o(140993);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(140995);
    if (this.bBK.getContentView() == null)
    {
      AppMethodBeat.o(140995);
      return;
    }
    Object localObject = this.bBK.getContentView();
    if (localObject == null) {
      j.ebi();
    }
    this.bEn = n.cL((View)localObject);
    localObject = this.bEn;
    if (localObject != null)
    {
      ((u)localObject).a((u.c)this);
      AppMethodBeat.o(140995);
      return;
    }
    AppMethodBeat.o(140995);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter$Companion;", "", "()V", "install", "", "pv", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */
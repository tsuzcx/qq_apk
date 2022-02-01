package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.page.br;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "blinkHelperExport", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;", "getBlinkHelperExport$luggage_wxa_app_release", "()Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;", "setBlinkHelperExport$luggage_wxa_app_release", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;)V", "blinkWrapper", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper;", "capsuleBarContainerLayout", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarContainerLayout;", "capsuleBarView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarImplView;", "currentActivePage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "pageContexts", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContextMapImpl;", "applyFixedWidthToPlaceHolderView", "", "placeHolderView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarPlaceHolderView;", "destroy", "getOptionButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "installCapsuleBar", "onEnterFullscreen", "onExitFullscreen", "onPageDestroyed", "page", "onPageSwitchedIn", "type", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "registerPage", "setCapsuleHomeButtonLongClickListener", "listener", "Landroid/view/View$OnLongClickListener;", "toFrameLayout_LayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "gravity", "", "PageContext", "PageContextMapImpl", "luggage-wxa-app_release"})
public final class e
{
  public final AppBrandRuntime jFc;
  public c mkK;
  public d mkL;
  public h mkM;
  public a mkN;
  public final b mkO;
  private z mkP;
  
  public e(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(208098);
    this.jFc = paramAppBrandRuntime;
    this.mkO = new b();
    AppMethodBeat.o(208098);
  }
  
  public final void a(z paramz, br parambr)
  {
    AppMethodBeat.i(208097);
    p.h(paramz, "page");
    p.h(parambr, "type");
    if (this.mkP != null)
    {
      parambr = this.mkO;
      z localz = this.mkP;
      if (localz == null) {
        p.gkB();
      }
      parambr = parambr.r(localz);
      if (parambr != null) {
        parambr.onDetached();
      }
    }
    this.mkP = paramz;
    this.mkO.s(paramz).bwp();
    AppMethodBeat.o(208097);
  }
  
  public final AppBrandOptionButton aYp()
  {
    AppMethodBeat.i(208096);
    Object localObject = this.mkL;
    if (localObject == null) {
      p.bdF("capsuleBarView");
    }
    localObject = ((d)localObject).getOptionBtn();
    p.g(localObject, "capsuleBarView.optionBtn");
    AppMethodBeat.o(208096);
    return localObject;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContext;", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$CapsuleBarInteractionDelegate;", "Landroid/view/View$OnLayoutChangeListener;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "homeButtonOnClickListener", "Landroid/view/View$OnClickListener;", "isAttached", "", "optionButtonOnClickListener", "getPage", "()Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "styleColor", "", "adjustCapsuleBarViewProperties", "", "dispatchCapsuleViewVisibilityChanged", "visibility", "onAttached", "onDetached", "onEnterFullscreen", "onExitFullscreen", "onLayoutChange", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "setHomeButtonOnClickListener", "l", "setOptionButtonOnClickListener", "setStyleColor", "color", "luggage-wxa-app_release"})
  public final class a
    extends com.tencent.mm.plugin.appbrand.platform.window.b
    implements View.OnLayoutChangeListener, b.a
  {
    final z clw;
    private boolean hAF;
    private int mkQ;
    private View.OnClickListener mkR;
    private View.OnClickListener mkS;
    
    public a()
    {
      AppMethodBeat.i(208088);
      this.clw = localObject;
      this.mkQ = -1;
      this.clw.a((f.c)new f.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(208077);
          Object localObject2 = this.mkU.mkT;
          Object localObject1 = this.mkU.clw;
          localObject2 = ((e)localObject2).mkO;
          p.h(localObject1, "page");
          int i = ((e.b)localObject2).mkV.indexOfKey(((z)localObject1).hashCode());
          if (i >= 0)
          {
            localObject1 = (e.a)((e.b)localObject2).mkV.valueAt(i);
            ((e.b)localObject2).mkV.removeAt(i);
          }
          while (localObject1 != null)
          {
            ((e.a)localObject1).onDetached();
            AppMethodBeat.o(208077);
            return;
            localObject1 = null;
          }
          AppMethodBeat.o(208077);
        }
      });
      this.clw.bvi().setCapsuleBarInteractionDelegate((b.a)this);
      AppMethodBeat.o(208088);
    }
    
    private final void bwq()
    {
      AppMethodBeat.i(208087);
      d locald = e.a(e.this);
      Object localObject1 = locald.getCapsuleContentAreaView();
      p.g(localObject1, "capsuleBarImplView.capsuleContentAreaView");
      Object localObject2;
      if (((View)localObject1).isLaidOut())
      {
        localObject1 = this.clw.bvi();
        p.g(localObject1, "page.actionBar");
        localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
        if (localObject1 != null)
        {
          localObject2 = locald.getCapsuleContentAreaView();
          p.g(localObject2, "capsuleBarImplView.capsuleContentAreaView");
          ((AppBrandCapsuleBarPlaceHolderView)localObject1).setFixedWidth(((View)localObject2).getMeasuredWidth());
        }
      }
      localObject1 = this.clw.bvi();
      p.g(localObject1, "page.actionBar");
      localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
      if (localObject1 != null)
      {
        localObject2 = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          localObject1 = locald.getCapsuleContentAreaView();
          p.g(localObject1, "capsuleBarImplView.capsuleContentAreaView");
          localObject2 = e.f((ViewGroup.LayoutParams)localObject2);
          ((FrameLayout.LayoutParams)localObject2).width = -2;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = locald.getLayoutParams();
      int i;
      if (localObject1 != null)
      {
        i = ((ViewGroup.LayoutParams)localObject1).height;
        localObject2 = this.clw.bvi();
        p.g(localObject2, "page.actionBar");
        if (i != ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject2).getMeasuredHeight())
        {
          localObject2 = this.clw.bvi();
          p.g(localObject2, "page.actionBar");
          ((ViewGroup.LayoutParams)localObject1).height = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject2).getMeasuredHeight();
          locald.requestLayout();
        }
      }
      localObject1 = this.clw.bvi();
      p.g(localObject1, "page.actionBar");
      localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
      if (localObject1 != null)
      {
        i = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getVisibility();
        if (locald.getVisibility() != i) {
          locald.setVisibility(i);
        }
        AppMethodBeat.o(208087);
        return;
      }
      AppMethodBeat.o(208087);
    }
    
    public final void DD()
    {
      AppMethodBeat.i(224489);
      e.c(e.this);
      AppMethodBeat.o(224489);
    }
    
    public final void bib()
    {
      AppMethodBeat.i(224488);
      e.b(e.this);
      AppMethodBeat.o(224488);
    }
    
    public final void bwp()
    {
      AppMethodBeat.i(208078);
      this.hAF = true;
      Object localObject1 = this.clw.getFullscreenImpl();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.platform.window.d)localObject1).bxz() == true))
      {
        e.b(e.this);
        localObject1 = this.clw.getFullscreenImpl();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.appbrand.platform.window.d)localObject1).a((com.tencent.mm.plugin.appbrand.platform.window.b)this);
        }
        e.a(e.this).addOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        localObject1 = this.clw.bvi();
        p.g(localObject1, "page.actionBar");
        localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
        if (localObject1 == null) {
          break label175;
        }
      }
      label175:
      for (localObject1 = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getParent();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof View)) {
          localObject2 = null;
        }
        localObject1 = (View)localObject2;
        if (localObject1 != null) {
          ((View)localObject1).addOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        }
        setHomeButtonOnClickListener(this.mkR);
        setOptionButtonOnClickListener(this.mkS);
        setStyleColor(this.mkQ);
        bwq();
        AppMethodBeat.o(208078);
        return;
        e.c(e.this);
        break;
      }
    }
    
    public final void onDetached()
    {
      AppMethodBeat.i(208079);
      this.hAF = false;
      Object localObject1 = this.clw.getFullscreenImpl();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.appbrand.platform.window.d)localObject1).b((com.tencent.mm.plugin.appbrand.platform.window.b)this);
      }
      e.a(e.this).removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      localObject1 = this.clw.bvi();
      p.g(localObject1, "page.actionBar");
      localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
      if (localObject1 != null) {}
      for (localObject1 = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getParent();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof View)) {
          localObject2 = null;
        }
        localObject1 = (View)localObject2;
        if (localObject1 == null) {
          break;
        }
        ((View)localObject1).removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(208079);
        return;
      }
      AppMethodBeat.o(208079);
    }
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(208085);
      if ((this.hAF) && ((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8))) {
        bwq();
      }
      AppMethodBeat.o(208085);
    }
    
    public final void rN(int paramInt)
    {
      AppMethodBeat.i(208086);
      bwq();
      AppMethodBeat.o(208086);
    }
    
    public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(208083);
      this.mkR = paramOnClickListener;
      if (this.hAF) {
        e.a(e.this).setHomeButtonOnClickListener(this.mkR);
      }
      AppMethodBeat.o(208083);
    }
    
    public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(208084);
      this.mkS = paramOnClickListener;
      if (this.hAF) {
        e.a(e.this).setOptionButtonOnClickListener(this.mkS);
      }
      AppMethodBeat.o(208084);
    }
    
    public final void setStyleColor(int paramInt)
    {
      AppMethodBeat.i(208082);
      this.mkQ = paramInt;
      if (this.hAF) {
        e.a(e.this).setStyleColor(this.mkQ);
      }
      AppMethodBeat.o(208082);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContextMapImpl;", "", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;)V", "sparseArray", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContext;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "get", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "getOrCreate", "remove", "set", "", "context", "luggage-wxa-app_release"})
  public final class b
  {
    final SparseArray<e.a> mkV;
    
    public b()
    {
      AppMethodBeat.i(208092);
      this.mkV = new SparseArray();
      AppMethodBeat.o(208092);
    }
    
    public final void a(z paramz, e.a parama)
    {
      AppMethodBeat.i(208089);
      p.h(paramz, "page");
      p.h(parama, "context");
      this.mkV.put(paramz.hashCode(), parama);
      AppMethodBeat.o(208089);
    }
    
    public final e.a r(z paramz)
    {
      AppMethodBeat.i(208090);
      p.h(paramz, "page");
      paramz = (e.a)this.mkV.get(paramz.hashCode(), null);
      AppMethodBeat.o(208090);
      return paramz;
    }
    
    public final e.a s(z paramz)
    {
      AppMethodBeat.i(208091);
      p.h(paramz, "page");
      e.a locala2 = (e.a)this.mkV.get(paramz.hashCode(), null);
      e.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new e.a(this.mkT, paramz);
        a(paramz, locala1);
      }
      AppMethodBeat.o(208091);
      return locala1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.e
 * JD-Core Version:    0.7.0.1
 */
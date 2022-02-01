package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "blinkHelperExport", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;", "getBlinkHelperExport$luggage_wxa_app_release", "()Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;", "setBlinkHelperExport$luggage_wxa_app_release", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;)V", "blinkWrapper", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper;", "capsuleBarContainerLayout", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarContainerLayout;", "capsuleBarView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarImplView;", "currentActivePage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "pageContexts", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContextMapImpl;", "savedCapsuleBarContainerLayoutVisibility", "", "addView", "", "view", "Landroid/view/View;", "applyFixedWidthToPlaceHolderView", "placeHolderView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarPlaceHolderView;", "destroy", "findViewById", "id", "getOptionButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "hideCapsuleBar", "installCapsuleBar", "onEnterFullscreen", "onExitFullscreen", "onPageDestroyed", "page", "onPageSwitchedIn", "type", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "registerPage", "removeViewById", "resetCapsuleBarContext", "newBase", "Landroid/content/Context;", "restoreCapsuleBarVisibility", "saveCapsuleBarVisibility", "setCapsuleHomeButtonLongClickListener", "listener", "Landroid/view/View$OnLongClickListener;", "toFrameLayout_LayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "gravity", "PageContext", "PageContextMapImpl", "luggage-wxa-app_release"})
public final class e
{
  public final AppBrandRuntime nAt;
  public c qxd;
  public d qxe;
  public int qxf;
  public h qxg;
  public a qxh;
  public final b qxi;
  ad qxj;
  
  public e(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(245327);
    this.nAt = paramAppBrandRuntime;
    this.qxi = new b();
    AppMethodBeat.o(245327);
  }
  
  public final void Cx(int paramInt)
  {
    AppMethodBeat.i(245324);
    Object localObject = this.qxd;
    if (localObject == null) {
      p.bGy("capsuleBarContainerLayout");
    }
    int j = ((c)localObject).getChildCount();
    int i = 0;
    if (i < j)
    {
      localObject = this.qxd;
      if (localObject == null) {
        p.bGy("capsuleBarContainerLayout");
      }
      localObject = ((c)localObject).getChildAt(i);
      p.j(localObject, "child");
      if (((View)localObject).getId() != paramInt) {}
    }
    for (;;)
    {
      c localc = this.qxd;
      if (localc == null) {
        p.bGy("capsuleBarContainerLayout");
      }
      localc.removeView((View)localObject);
      AppMethodBeat.o(245324);
      return;
      i += 1;
      break;
      localObject = null;
    }
  }
  
  public final void a(ad paramad, ca paramca)
  {
    AppMethodBeat.i(245326);
    p.k(paramad, "page");
    p.k(paramca, "type");
    if (this.qxj != null)
    {
      paramca = this.qxi;
      ad localad = this.qxj;
      if (localad == null) {
        p.iCn();
      }
      paramca = paramca.w(localad);
      if (paramca != null) {
        paramca.cfy();
      }
    }
    this.qxj = paramad;
    this.qxi.x(paramad).cfx();
    AppMethodBeat.o(245326);
  }
  
  public final AppBrandOptionButton bEB()
  {
    AppMethodBeat.i(245320);
    Object localObject = this.qxe;
    if (localObject == null) {
      p.bGy("capsuleBarView");
    }
    localObject = ((d)localObject).getOptionBtn();
    p.j(localObject, "capsuleBarView.optionBtn");
    AppMethodBeat.o(245320);
    return localObject;
  }
  
  public final void ej(Context paramContext)
  {
    AppMethodBeat.i(245316);
    p.k(paramContext, "newBase");
    c localc = this.qxd;
    if (localc == null) {
      p.bGy("capsuleBarContainerLayout");
    }
    localc.aD(paramContext);
    AppMethodBeat.o(245316);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(245323);
    Object localObject = this.qxd;
    if (localObject == null) {
      p.bGy("capsuleBarContainerLayout");
    }
    localObject = ((c)localObject).findViewById(paramInt);
    AppMethodBeat.o(245323);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContext;", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$CapsuleBarInteractionDelegate;", "Landroid/view/View$OnLayoutChangeListener;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "homeButtonOnClickListener", "Landroid/view/View$OnClickListener;", "isAttached", "", "optionButtonOnClickListener", "getPage", "()Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "styleColor", "", "adjustCapsuleBarViewProperties", "", "dispatchCapsuleViewVisibilityChanged", "visibility", "onAttached", "onDetached", "onEnterFullscreen", "onExitFullscreen", "onLayoutChange", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "setHomeButtonOnClickListener", "l", "setOptionButtonOnClickListener", "setStyleColor", "color", "luggage-wxa-app_release"})
  public final class a
    extends com.tencent.mm.plugin.appbrand.platform.window.b
    implements View.OnLayoutChangeListener, b.b
  {
    final ad cvZ;
    private boolean ljV;
    private int qxk;
    private View.OnClickListener qxl;
    private View.OnClickListener qxm;
    
    public a()
    {
      AppMethodBeat.i(243730);
      this.cvZ = localObject;
      this.qxk = -1;
      this.cvZ.a((h.c)new h.c()
      {
        public final void onDestroy()
        {
          e.a locala = null;
          AppMethodBeat.i(245513);
          Object localObject = this.qxo.qxn;
          ad localad = this.qxo.cvZ;
          if (p.h(localad, ((e)localObject).qxj)) {
            ((e)localObject).qxj = null;
          }
          localObject = ((e)localObject).qxi;
          p.k(localad, "page");
          int i = ((e.b)localObject).qxp.indexOfKey(localad.hashCode());
          if (i >= 0)
          {
            locala = (e.a)((e.b)localObject).qxp.valueAt(i);
            ((e.b)localObject).qxp.removeAt(i);
          }
          if (locala != null)
          {
            locala.cfy();
            AppMethodBeat.o(245513);
            return;
          }
          AppMethodBeat.o(245513);
        }
      });
      this.cvZ.cdY().setCapsuleBarInteractionDelegate((b.b)this);
      AppMethodBeat.o(243730);
    }
    
    private final void cfz()
    {
      AppMethodBeat.i(243726);
      d locald = e.a(e.this);
      Object localObject1 = locald.getCapsuleContentAreaView();
      p.j(localObject1, "capsuleBarImplView.capsuleContentAreaView");
      Object localObject2;
      if (((View)localObject1).isLaidOut())
      {
        localObject1 = this.cvZ.cdY();
        p.j(localObject1, "page.actionBar");
        localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
        if (localObject1 != null)
        {
          localObject2 = locald.getCapsuleContentAreaView();
          p.j(localObject2, "capsuleBarImplView.capsuleContentAreaView");
          ((AppBrandCapsuleBarPlaceHolderView)localObject1).setFixedWidth(((View)localObject2).getMeasuredWidth());
        }
      }
      localObject1 = this.cvZ.cdY();
      p.j(localObject1, "page.actionBar");
      localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
      if (localObject1 != null)
      {
        localObject2 = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          localObject1 = locald.getCapsuleContentAreaView();
          p.j(localObject1, "capsuleBarImplView.capsuleContentAreaView");
          localObject2 = e.e((ViewGroup.LayoutParams)localObject2);
          ((FrameLayout.LayoutParams)localObject2).width = -2;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = locald.getLayoutParams();
      int i;
      if (localObject1 != null)
      {
        i = ((ViewGroup.LayoutParams)localObject1).height;
        localObject2 = this.cvZ.cdY();
        p.j(localObject2, "page.actionBar");
        if ((i != ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject2).getMeasuredHeight()) && (w.ah((View)this.cvZ.cdY())))
        {
          localObject2 = this.cvZ.cdY();
          p.j(localObject2, "page.actionBar");
          ((ViewGroup.LayoutParams)localObject1).height = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject2).getMeasuredHeight();
          locald.requestLayout();
        }
      }
      localObject1 = this.cvZ.cdY();
      p.j(localObject1, "page.actionBar");
      localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((AppBrandCapsuleBarPlaceHolderView)localObject1).getVisibility());; localObject1 = null)
      {
        i = ((Integer)localObject1).intValue();
        if (locald.getVisibility() != i) {
          locald.setVisibility(i);
        }
        AppMethodBeat.o(243726);
        return;
      }
    }
    
    public final void PS()
    {
      AppMethodBeat.i(292942);
      e.c(e.this);
      AppMethodBeat.o(292942);
    }
    
    public final void bOO()
    {
      AppMethodBeat.i(292941);
      e.b(e.this);
      AppMethodBeat.o(292941);
    }
    
    public final void cfx()
    {
      AppMethodBeat.i(243710);
      this.ljV = true;
      Object localObject1 = this.cvZ.getFullscreenImpl();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.platform.window.d)localObject1).cgP() == true))
      {
        e.b(e.this);
        localObject1 = this.cvZ.getFullscreenImpl();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.appbrand.platform.window.d)localObject1).a((com.tencent.mm.plugin.appbrand.platform.window.b)this);
        }
        e.a(e.this).addOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        localObject1 = this.cvZ.cdY();
        p.j(localObject1, "page.actionBar");
        localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
        if (localObject1 == null) {
          break label189;
        }
      }
      label189:
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
        this.cvZ.cdY().addOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        setHomeButtonOnClickListener(this.qxl);
        setOptionButtonOnClickListener(this.qxm);
        setStyleColor(this.qxk);
        cfz();
        AppMethodBeat.o(243710);
        return;
        e.c(e.this);
        break;
      }
    }
    
    public final void cfy()
    {
      AppMethodBeat.i(243712);
      this.ljV = false;
      Object localObject1 = this.cvZ.getFullscreenImpl();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.appbrand.platform.window.d)localObject1).b((com.tencent.mm.plugin.appbrand.platform.window.b)this);
      }
      e.a(e.this).removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      localObject1 = this.cvZ.cdY();
      p.j(localObject1, "page.actionBar");
      localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
      if (localObject1 != null) {}
      for (localObject1 = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getParent();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof View)) {
          localObject2 = null;
        }
        localObject1 = (View)localObject2;
        if (localObject1 != null) {
          ((View)localObject1).removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        }
        this.cvZ.cdY().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(243712);
        return;
      }
    }
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(243723);
      if ((this.ljV) && ((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8))) {
        cfz();
      }
      AppMethodBeat.o(243723);
    }
    
    public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(243719);
      this.qxl = paramOnClickListener;
      if (this.ljV) {
        e.a(e.this).setHomeButtonOnClickListener(this.qxl);
      }
      AppMethodBeat.o(243719);
    }
    
    public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(243721);
      this.qxm = paramOnClickListener;
      if (this.ljV) {
        e.a(e.this).setOptionButtonOnClickListener(this.qxm);
      }
      AppMethodBeat.o(243721);
    }
    
    public final void setStyleColor(int paramInt)
    {
      AppMethodBeat.i(243718);
      this.qxk = paramInt;
      if (this.ljV) {
        e.a(e.this).setStyleColor(this.qxk);
      }
      AppMethodBeat.o(243718);
    }
    
    public final void yT(int paramInt)
    {
      AppMethodBeat.i(243724);
      cfz();
      AppMethodBeat.o(243724);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContextMapImpl;", "", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;)V", "sparseArray", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContext;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "get", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "getOrCreate", "remove", "set", "", "context", "luggage-wxa-app_release"})
  public final class b
  {
    final SparseArray<e.a> qxp;
    
    public b()
    {
      AppMethodBeat.i(245601);
      this.qxp = new SparseArray();
      AppMethodBeat.o(245601);
    }
    
    public final void a(ad paramad, e.a parama)
    {
      AppMethodBeat.i(245597);
      p.k(paramad, "page");
      p.k(parama, "context");
      this.qxp.put(paramad.hashCode(), parama);
      AppMethodBeat.o(245597);
    }
    
    public final e.a w(ad paramad)
    {
      AppMethodBeat.i(245598);
      p.k(paramad, "page");
      paramad = (e.a)this.qxp.get(paramad.hashCode(), null);
      AppMethodBeat.o(245598);
      return paramad;
    }
    
    public final e.a x(ad paramad)
    {
      AppMethodBeat.i(245599);
      p.k(paramad, "page");
      e.a locala2 = (e.a)this.qxp.get(paramad.hashCode(), null);
      e.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new e.a(this.qxn, paramad);
        a(paramad, locala1);
      }
      AppMethodBeat.o(245599);
      return locala1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke", "com/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$installCapsuleBar$1$1"})
  public static final class c
    extends q
    implements kotlin.g.a.b<com.tencent.luggage.sdk.h.e, x>
  {
    public c(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.e
 * JD-Core Version:    0.7.0.1
 */
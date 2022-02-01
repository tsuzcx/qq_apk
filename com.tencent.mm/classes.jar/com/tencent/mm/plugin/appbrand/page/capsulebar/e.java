package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "blinkHelperExport", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;", "getBlinkHelperExport$luggage_wxa_app_release", "()Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;", "setBlinkHelperExport$luggage_wxa_app_release", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;)V", "blinkWrapper", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper;", "capsuleBarContainerLayout", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarContainerLayout;", "capsuleBarView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarImplView;", "currentActivePage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "pageContexts", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContextMapImpl;", "savedCapsuleBarContainerLayoutVisibility", "", "applyFixedWidthToPlaceHolderView", "", "placeHolderView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarPlaceHolderView;", "destroy", "getOptionButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "hideCapsuleBar", "installCapsuleBar", "onEnterFullscreen", "onExitFullscreen", "onPageDestroyed", "page", "onPageSwitchedIn", "type", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "registerPage", "resetCapsuleBarContext", "newBase", "Landroid/content/Context;", "restoreCapsureBarVisibility", "saveCapsuleBarVisibility", "setCapsuleHomeButtonLongClickListener", "listener", "Landroid/view/View$OnLongClickListener;", "toFrameLayout_LayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "gravity", "PageContext", "PageContextMapImpl", "luggage-wxa-app_release"})
public final class e
{
  public final AppBrandRuntime kGM;
  public c nvh;
  public d nvi;
  public int nvj;
  public h nvk;
  public a nvl;
  public final b nvm;
  ac nvn;
  
  public e(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219714);
    this.kGM = paramAppBrandRuntime;
    this.nvm = new b();
    AppMethodBeat.o(219714);
  }
  
  public final void a(ac paramac, bx parambx)
  {
    AppMethodBeat.i(219713);
    p.h(paramac, "page");
    p.h(parambx, "type");
    if (this.nvn != null)
    {
      parambx = this.nvm;
      ac localac = this.nvn;
      if (localac == null) {
        p.hyc();
      }
      parambx = parambx.w(localac);
      if (parambx != null) {
        parambx.onDetached();
      }
    }
    this.nvn = paramac;
    this.nvm.x(paramac).bSx();
    AppMethodBeat.o(219713);
  }
  
  public final AppBrandOptionButton btD()
  {
    AppMethodBeat.i(219712);
    Object localObject = this.nvi;
    if (localObject == null) {
      p.btv("capsuleBarView");
    }
    localObject = ((d)localObject).getOptionBtn();
    p.g(localObject, "capsuleBarView.optionBtn");
    AppMethodBeat.o(219712);
    return localObject;
  }
  
  public final void ek(Context paramContext)
  {
    AppMethodBeat.i(219711);
    p.h(paramContext, "newBase");
    c localc = this.nvh;
    if (localc == null) {
      p.btv("capsuleBarContainerLayout");
    }
    localc.aG(paramContext);
    AppMethodBeat.o(219711);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContext;", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$CapsuleBarInteractionDelegate;", "Landroid/view/View$OnLayoutChangeListener;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "homeButtonOnClickListener", "Landroid/view/View$OnClickListener;", "isAttached", "", "optionButtonOnClickListener", "getPage", "()Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "styleColor", "", "adjustCapsuleBarViewProperties", "", "dispatchCapsuleViewVisibilityChanged", "visibility", "onAttached", "onDetached", "onEnterFullscreen", "onExitFullscreen", "onLayoutChange", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "setHomeButtonOnClickListener", "l", "setOptionButtonOnClickListener", "setStyleColor", "color", "luggage-wxa-app_release"})
  public final class a
    extends com.tencent.mm.plugin.appbrand.platform.window.b
    implements View.OnLayoutChangeListener, b.b
  {
    final ac cxr;
    private boolean iuM;
    private int nvo;
    private View.OnClickListener nvp;
    private View.OnClickListener nvq;
    
    public a()
    {
      AppMethodBeat.i(219703);
      this.cxr = localObject;
      this.nvo = -1;
      this.cxr.a((i.c)new i.c()
      {
        public final void onDestroy()
        {
          e.a locala = null;
          AppMethodBeat.i(219692);
          Object localObject = this.nvs.nvr;
          ac localac = this.nvs.cxr;
          if (p.j(localac, ((e)localObject).nvn)) {
            ((e)localObject).nvn = null;
          }
          localObject = ((e)localObject).nvm;
          p.h(localac, "page");
          int i = ((e.b)localObject).nvt.indexOfKey(localac.hashCode());
          if (i >= 0)
          {
            locala = (e.a)((e.b)localObject).nvt.valueAt(i);
            ((e.b)localObject).nvt.removeAt(i);
          }
          if (locala != null)
          {
            locala.onDetached();
            AppMethodBeat.o(219692);
            return;
          }
          AppMethodBeat.o(219692);
        }
      });
      this.cxr.bRi().setCapsuleBarInteractionDelegate((b.b)this);
      AppMethodBeat.o(219703);
    }
    
    private final void bSy()
    {
      AppMethodBeat.i(219702);
      d locald = e.a(e.this);
      Object localObject1 = locald.getCapsuleContentAreaView();
      p.g(localObject1, "capsuleBarImplView.capsuleContentAreaView");
      Object localObject2;
      if (((View)localObject1).isLaidOut())
      {
        localObject1 = this.cxr.bRi();
        p.g(localObject1, "page.actionBar");
        localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
        if (localObject1 != null)
        {
          localObject2 = locald.getCapsuleContentAreaView();
          p.g(localObject2, "capsuleBarImplView.capsuleContentAreaView");
          ((AppBrandCapsuleBarPlaceHolderView)localObject1).setFixedWidth(((View)localObject2).getMeasuredWidth());
        }
      }
      localObject1 = this.cxr.bRi();
      p.g(localObject1, "page.actionBar");
      localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
      if (localObject1 != null)
      {
        localObject2 = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          localObject1 = locald.getCapsuleContentAreaView();
          p.g(localObject1, "capsuleBarImplView.capsuleContentAreaView");
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
        localObject2 = this.cxr.bRi();
        p.g(localObject2, "page.actionBar");
        if ((i != ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject2).getMeasuredHeight()) && (u.az((View)this.cxr.bRi())))
        {
          localObject2 = this.cxr.bRi();
          p.g(localObject2, "page.actionBar");
          ((ViewGroup.LayoutParams)localObject1).height = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject2).getMeasuredHeight();
          locald.requestLayout();
        }
      }
      localObject1 = this.cxr.bRi();
      p.g(localObject1, "page.actionBar");
      localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
      if (localObject1 != null)
      {
        i = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getVisibility();
        if (locald.getVisibility() != i) {
          locald.setVisibility(i);
        }
        AppMethodBeat.o(219702);
        return;
      }
      AppMethodBeat.o(219702);
    }
    
    public final void Na()
    {
      AppMethodBeat.i(258645);
      e.c(e.this);
      AppMethodBeat.o(258645);
    }
    
    public final void bDq()
    {
      AppMethodBeat.i(258644);
      e.b(e.this);
      AppMethodBeat.o(258644);
    }
    
    public final void bSx()
    {
      AppMethodBeat.i(219693);
      this.iuM = true;
      Object localObject1 = this.cxr.getFullscreenImpl();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.platform.window.d)localObject1).bTK() == true))
      {
        e.b(e.this);
        localObject1 = this.cxr.getFullscreenImpl();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.appbrand.platform.window.d)localObject1).a((com.tencent.mm.plugin.appbrand.platform.window.b)this);
        }
        e.a(e.this).addOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        localObject1 = this.cxr.bRi();
        p.g(localObject1, "page.actionBar");
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
        this.cxr.bRi().addOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        setHomeButtonOnClickListener(this.nvp);
        setOptionButtonOnClickListener(this.nvq);
        setStyleColor(this.nvo);
        bSy();
        AppMethodBeat.o(219693);
        return;
        e.c(e.this);
        break;
      }
    }
    
    public final void onDetached()
    {
      AppMethodBeat.i(219694);
      this.iuM = false;
      Object localObject1 = this.cxr.getFullscreenImpl();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.appbrand.platform.window.d)localObject1).b((com.tencent.mm.plugin.appbrand.platform.window.b)this);
      }
      e.a(e.this).removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      localObject1 = this.cxr.bRi();
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
        if (localObject1 != null) {
          ((View)localObject1).removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        }
        this.cxr.bRi().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(219694);
        return;
      }
    }
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(219700);
      if ((this.iuM) && ((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8))) {
        bSy();
      }
      AppMethodBeat.o(219700);
    }
    
    public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(219698);
      this.nvp = paramOnClickListener;
      if (this.iuM) {
        e.a(e.this).setHomeButtonOnClickListener(this.nvp);
      }
      AppMethodBeat.o(219698);
    }
    
    public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(219699);
      this.nvq = paramOnClickListener;
      if (this.iuM) {
        e.a(e.this).setOptionButtonOnClickListener(this.nvq);
      }
      AppMethodBeat.o(219699);
    }
    
    public final void setStyleColor(int paramInt)
    {
      AppMethodBeat.i(219697);
      this.nvo = paramInt;
      if (this.iuM) {
        e.a(e.this).setStyleColor(this.nvo);
      }
      AppMethodBeat.o(219697);
    }
    
    public final void vI(int paramInt)
    {
      AppMethodBeat.i(219701);
      bSy();
      AppMethodBeat.o(219701);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContextMapImpl;", "", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;)V", "sparseArray", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContext;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "get", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "getOrCreate", "remove", "set", "", "context", "luggage-wxa-app_release"})
  public final class b
  {
    final SparseArray<e.a> nvt;
    
    public b()
    {
      AppMethodBeat.i(219707);
      this.nvt = new SparseArray();
      AppMethodBeat.o(219707);
    }
    
    public final void a(ac paramac, e.a parama)
    {
      AppMethodBeat.i(219704);
      p.h(paramac, "page");
      p.h(parama, "context");
      this.nvt.put(paramac.hashCode(), parama);
      AppMethodBeat.o(219704);
    }
    
    public final e.a w(ac paramac)
    {
      AppMethodBeat.i(219705);
      p.h(paramac, "page");
      paramac = (e.a)this.nvt.get(paramac.hashCode(), null);
      AppMethodBeat.o(219705);
      return paramac;
    }
    
    public final e.a x(ac paramac)
    {
      AppMethodBeat.i(219706);
      p.h(paramac, "page");
      e.a locala2 = (e.a)this.nvt.get(paramac.hashCode(), null);
      e.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new e.a(this.nvr, paramac);
        a(paramac, locala1);
      }
      AppMethodBeat.o(219706);
      return locala1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke", "com/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$installCapsuleBar$1$1"})
  public static final class c
    extends q
    implements kotlin.g.a.b<com.tencent.luggage.sdk.g.d, x>
  {
    public c(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.e
 * JD-Core Version:    0.7.0.1
 */
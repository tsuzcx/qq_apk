package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.cb;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "blinkHelperExport", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;", "blinkHelperExportHooker", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BlinkHelperExportHooker;", "blinkWrapper", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper;", "<set-?>", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarContainerLayout;", "capsuleBarContainerLayout", "getCapsuleBarContainerLayout", "()Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarContainerLayout;", "capsuleBarView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarImplView;", "currentActivePage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "pageContexts", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContextMapImpl;", "savedCapsuleBarContainerLayoutVisibility", "", "addView", "", "view", "Landroid/view/View;", "applyFixedWidthToPlaceHolderView", "placeHolderView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarPlaceHolderView;", "destroy", "findViewById", "id", "getBlinkHelperExport", "getCapsuleBarHitRect", "Landroid/graphics/Rect;", "getOptionButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "hideCapsuleBar", "installCapsuleBar", "onEnterFullscreen", "onExitFullscreen", "onPageDestroyed", "page", "onPageSwitchedIn", "type", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "registerPage", "removeViewById", "resetCapsuleBarContext", "newBase", "Landroid/content/Context;", "restoreCapsuleBarVisibility", "saveCapsuleBarVisibility", "setBackgroundColor", "color", "setBlinkHelperExportHooker", "hooker", "setCapsuleHomeButtonLongClickListener", "listener", "Landroid/view/View$OnLongClickListener;", "toFrameLayout_LayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "gravity", "PageContext", "PageContextMapImpl", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public final AppBrandRuntime qzz;
  public c tCc;
  public d tCd;
  public i tCe;
  private int tCf;
  public l tCg;
  public a tCh;
  public final b tCi;
  ad tCj;
  
  public e(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(325269);
    this.qzz = paramAppBrandRuntime;
    this.tCi = new b();
    AppMethodBeat.o(325269);
  }
  
  public final void CN(int paramInt)
  {
    AppMethodBeat.i(325349);
    int i = 0;
    int k = cGi().getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = cGi().getChildAt(i);
      if (localView.getId() == paramInt) {}
      for (;;)
      {
        cGi().removeView(localView);
        AppMethodBeat.o(325349);
        return;
        if (j < k) {
          break;
        }
        localView = null;
      }
      i = j;
    }
  }
  
  public final void a(ad paramad, cb paramcb)
  {
    AppMethodBeat.i(325353);
    s.u(paramad, "page");
    s.u(paramcb, "type");
    if (this.tCj != null)
    {
      paramcb = this.tCi;
      ad localad = this.tCj;
      s.checkNotNull(localad);
      paramcb = paramcb.x(localad);
      if (paramcb != null) {
        paramcb.iQ();
      }
    }
    this.tCj = paramad;
    this.tCi.y(paramad).iR();
    AppMethodBeat.o(325353);
  }
  
  public final c cGi()
  {
    AppMethodBeat.i(325295);
    c localc = this.tCc;
    if (localc != null)
    {
      AppMethodBeat.o(325295);
      return localc;
    }
    s.bIx("capsuleBarContainerLayout");
    AppMethodBeat.o(325295);
    return null;
  }
  
  public final void cGj()
  {
    AppMethodBeat.i(325301);
    if (this.tCc != null) {
      this.tCf = cGi().getVisibility();
    }
    AppMethodBeat.o(325301);
  }
  
  public final void cGk()
  {
    AppMethodBeat.i(325308);
    if (this.tCc != null) {
      cGi().setVisibility(this.tCf);
    }
    AppMethodBeat.o(325308);
  }
  
  public final void cGl()
  {
    AppMethodBeat.i(325313);
    if (this.tCc != null) {
      cGi().setVisibility(4);
    }
    AppMethodBeat.o(325313);
  }
  
  public final a cGm()
  {
    Object localObject = null;
    AppMethodBeat.i(325322);
    if (this.tCe != null)
    {
      i locali = this.tCe;
      s.checkNotNull(locali);
      a locala = this.tCh;
      if (locala == null) {
        s.bIx("blinkHelperExport");
      }
      for (;;)
      {
        localObject = locali.a((a)localObject);
        AppMethodBeat.o(325322);
        return localObject;
        localObject = locala;
      }
    }
    localObject = this.tCh;
    if (localObject == null)
    {
      s.bIx("blinkHelperExport");
      AppMethodBeat.o(325322);
      return null;
    }
    AppMethodBeat.o(325322);
    return localObject;
  }
  
  public final AppBrandOptionButton cdM()
  {
    AppMethodBeat.i(325340);
    d locald = this.tCd;
    Object localObject = locald;
    if (locald == null)
    {
      s.bIx("capsuleBarView");
      localObject = null;
    }
    localObject = ((d)localObject).getOptionBtn();
    s.s(localObject, "capsuleBarView.optionBtn");
    AppMethodBeat.o(325340);
    return localObject;
  }
  
  public final void ff(Context paramContext)
  {
    AppMethodBeat.i(325331);
    s.u(paramContext, "newBase");
    cGi().bm(paramContext);
    AppMethodBeat.o(325331);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(325345);
    View localView = cGi().findViewById(paramInt);
    AppMethodBeat.o(325345);
    return localView;
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(325317);
    if (this.tCc != null) {
      cGi().setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(325317);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContext;", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$CapsuleBarInteractionDelegate;", "Landroid/view/View$OnLayoutChangeListener;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "homeButtonOnClickListener", "Landroid/view/View$OnClickListener;", "isAttached", "", "optionButtonOnClickListener", "getPage", "()Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "styleColor", "", "adjustCapsuleBarViewProperties", "", "dispatchCapsuleViewVisibilityChanged", "visibility", "onAttached", "onDetached", "onEnterFullscreen", "onExitFullscreen", "onLayoutChange", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "setHomeButtonOnClickListener", "l", "setOptionButtonOnClickListener", "setStyleColor", "color", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends com.tencent.mm.plugin.appbrand.platform.window.b
    implements View.OnLayoutChangeListener, b.b
  {
    private final ad enX;
    private boolean nOG;
    private int tCk;
    private View.OnClickListener tCl;
    private View.OnClickListener tCm;
    
    public a()
    {
      AppMethodBeat.i(325375);
      this.enX = localObject;
      this.tCk = -1;
      this.enX.a(new e.a..ExternalSyntheticLambda0(e.this, this));
      this.enX.cEC().setCapsuleBarInteractionDelegate((b.b)this);
      AppMethodBeat.o(325375);
    }
    
    private static final void a(e parame, a parama)
    {
      Object localObject = null;
      AppMethodBeat.i(325390);
      s.u(parame, "this$0");
      s.u(parama, "this$1");
      ad localad = parama.enX;
      if (s.p(localad, parame.tCj)) {
        parame.tCj = null;
      }
      parama = parame.tCi;
      s.u(localad, "page");
      int i = parama.tCo.indexOfKey(localad.hashCode());
      parame = localObject;
      if (i >= 0)
      {
        parame = (a)parama.tCo.valueAt(i);
        parama.tCo.removeAt(i);
      }
      if (parame != null) {
        parame.iQ();
      }
      AppMethodBeat.o(325390);
    }
    
    private final void cGn()
    {
      AppMethodBeat.i(325387);
      Object localObject1 = e.this.tCd;
      if (localObject1 == null)
      {
        s.bIx("capsuleBarView");
        localObject1 = null;
        if (((d)localObject1).getCapsuleContentAreaView().isLaidOut())
        {
          localObject2 = this.enX.cEC().getCapsuleView();
          if (localObject2 != null) {
            ((AppBrandCapsuleBarPlaceHolderView)localObject2).setFixedWidth(((d)localObject1).getCapsuleContentAreaView().getMeasuredWidth());
          }
        }
        localObject2 = this.enX.cEC().getCapsuleView();
        if (localObject2 != null)
        {
          Object localObject3 = ((AppBrandCapsuleBarPlaceHolderView)localObject2).getLayoutParams();
          if (localObject3 != null)
          {
            localObject2 = ((d)localObject1).getCapsuleContentAreaView();
            localObject3 = e.e((ViewGroup.LayoutParams)localObject3);
            ((FrameLayout.LayoutParams)localObject3).width = -2;
            ah localah = ah.aiuX;
            ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          }
        }
        localObject2 = this.enX.cEC().getLayoutParams();
        if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
          break label177;
        }
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        label142:
        if (localObject2 != null) {
          break label182;
        }
      }
      label177:
      label182:
      for (int i = 0;; i = ((ViewGroup.MarginLayoutParams)localObject2).topMargin)
      {
        localObject2 = ((d)localObject1).getLayoutParams();
        if (localObject2 != null) {
          break label190;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(325387);
        throw ((Throwable)localObject1);
        break;
        localObject2 = null;
        break label142;
      }
      label190:
      Object localObject2 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject2).topMargin = i;
      ((FrameLayout.LayoutParams)localObject2).gravity = 5;
      localObject2 = ((d)localObject1).getLayoutParams();
      if ((localObject2 != null) && (((ViewGroup.LayoutParams)localObject2).height != this.enX.cEC().getMeasuredHeight()) && (z.au((View)this.enX.cEC()))) {
        ((ViewGroup.LayoutParams)localObject2).height = this.enX.cEC().getMeasuredHeight();
      }
      ((d)localObject1).requestLayout();
      localObject2 = this.enX.cEC().getCapsuleView();
      if (localObject2 != null)
      {
        i = ((AppBrandCapsuleBarPlaceHolderView)localObject2).getVisibility();
        if (((d)localObject1).getVisibility() != i) {
          ((d)localObject1).setVisibility(i);
        }
      }
      AppMethodBeat.o(325387);
    }
    
    public final void aqb()
    {
      AppMethodBeat.i(370025);
      e.b(e.this);
      AppMethodBeat.o(370025);
    }
    
    public final void cpc()
    {
      AppMethodBeat.i(370024);
      e.a(e.this);
      AppMethodBeat.o(370024);
    }
    
    public final void iQ()
    {
      View localView = null;
      AppMethodBeat.i(325396);
      this.nOG = false;
      Object localObject = this.enX.getFullscreenImpl();
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.platform.window.d)localObject).b((com.tencent.mm.plugin.appbrand.platform.window.b)this);
      }
      localObject = e.this.tCd;
      if (localObject == null)
      {
        s.bIx("capsuleBarView");
        localObject = null;
        ((d)localObject).removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        localObject = this.enX.cEC().getCapsuleView();
        if (localObject != null) {
          break label127;
        }
      }
      label127:
      for (localObject = null;; localObject = ((AppBrandCapsuleBarPlaceHolderView)localObject).getParent())
      {
        if ((localObject instanceof View)) {
          localView = (View)localObject;
        }
        if (localView != null) {
          localView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        }
        this.enX.cEC().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(325396);
        return;
        break;
      }
    }
    
    public final void iR()
    {
      View localView = null;
      int i = 1;
      AppMethodBeat.i(325394);
      this.nOG = true;
      Object localObject = this.enX.getFullscreenImpl();
      if ((localObject != null) && (((com.tencent.mm.plugin.appbrand.platform.window.d)localObject).cHN() == true))
      {
        if (i == 0) {
          break label192;
        }
        e.a(e.this);
        label48:
        localObject = this.enX.getFullscreenImpl();
        if (localObject != null) {
          ((com.tencent.mm.plugin.appbrand.platform.window.d)localObject).a((com.tencent.mm.plugin.appbrand.platform.window.b)this);
        }
        localObject = e.this.tCd;
        if (localObject != null) {
          break label202;
        }
        s.bIx("capsuleBarView");
        localObject = null;
        label89:
        ((d)localObject).addOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        localObject = this.enX.cEC().getCapsuleView();
        if (localObject != null) {
          break label205;
        }
      }
      label192:
      label202:
      label205:
      for (localObject = null;; localObject = ((AppBrandCapsuleBarPlaceHolderView)localObject).getParent())
      {
        if ((localObject instanceof View)) {
          localView = (View)localObject;
        }
        if (localView != null) {
          localView.addOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        }
        this.enX.cEC().addOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        setHomeButtonOnClickListener(this.tCl);
        setOptionButtonOnClickListener(this.tCm);
        setStyleColor(this.tCk);
        cGn();
        AppMethodBeat.o(325394);
        return;
        i = 0;
        break;
        e.b(e.this);
        break label48;
        break label89;
      }
    }
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(325411);
      if ((this.nOG) && ((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8))) {
        cGn();
      }
      AppMethodBeat.o(325411);
    }
    
    public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(325406);
      this.tCl = paramOnClickListener;
      if (this.nOG)
      {
        d locald = e.this.tCd;
        paramOnClickListener = locald;
        if (locald == null)
        {
          s.bIx("capsuleBarView");
          paramOnClickListener = null;
        }
        paramOnClickListener.setHomeButtonOnClickListener(this.tCl);
      }
      AppMethodBeat.o(325406);
    }
    
    public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(325409);
      this.tCm = paramOnClickListener;
      if (this.nOG)
      {
        d locald = e.this.tCd;
        paramOnClickListener = locald;
        if (locald == null)
        {
          s.bIx("capsuleBarView");
          paramOnClickListener = null;
        }
        paramOnClickListener.setOptionButtonOnClickListener(this.tCm);
      }
      AppMethodBeat.o(325409);
    }
    
    public final void setStyleColor(int paramInt)
    {
      AppMethodBeat.i(325404);
      this.tCk = paramInt;
      if (this.nOG)
      {
        d locald2 = e.this.tCd;
        d locald1 = locald2;
        if (locald2 == null)
        {
          s.bIx("capsuleBarView");
          locald1 = null;
        }
        locald1.setStyleColor(this.tCk);
      }
      AppMethodBeat.o(325404);
    }
    
    public final void zc(int paramInt)
    {
      AppMethodBeat.i(325412);
      cGn();
      AppMethodBeat.o(325412);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContextMapImpl;", "", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;)V", "sparseArray", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContext;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "get", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "getOrCreate", "remove", "set", "", "context", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
  {
    final SparseArray<e.a> tCo;
    
    public b()
    {
      AppMethodBeat.i(325370);
      this.tCo = new SparseArray();
      AppMethodBeat.o(325370);
    }
    
    public final void a(ad paramad, e.a parama)
    {
      AppMethodBeat.i(325374);
      s.u(paramad, "page");
      s.u(parama, "context");
      this.tCo.put(paramad.hashCode(), parama);
      AppMethodBeat.o(325374);
    }
    
    public final e.a x(ad paramad)
    {
      AppMethodBeat.i(325378);
      s.u(paramad, "page");
      paramad = (e.a)this.tCo.get(paramad.hashCode(), null);
      AppMethodBeat.o(325378);
      return paramad;
    }
    
    public final e.a y(ad paramad)
    {
      AppMethodBeat.i(325385);
      s.u(paramad, "page");
      e.a locala = (e.a)this.tCo.get(paramad.hashCode(), null);
      if (locala == null)
      {
        locala = new e.a(this.tCn, paramad);
        a(paramad, locala);
        AppMethodBeat.o(325385);
        return locala;
      }
      AppMethodBeat.o(325385);
      return locala;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.b<com.tencent.luggage.sdk.h.e, ah>
  {
    public c(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.e
 * JD-Core Version:    0.7.0.1
 */
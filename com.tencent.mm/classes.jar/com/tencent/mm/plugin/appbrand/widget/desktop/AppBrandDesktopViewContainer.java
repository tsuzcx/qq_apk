package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "getAnimation", "()Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "setAnimation", "(Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;)V", "callback", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$Callback;)V", "contentView", "Landroid/view/ViewGroup;", "getContentView", "()Landroid/view/ViewGroup;", "desktopView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView;", "getDesktopView", "()Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView;", "spreadPoint", "Landroid/graphics/Point;", "getSpreadPoint", "()Landroid/graphics/Point;", "setSpreadPoint", "(Landroid/graphics/Point;)V", "animateShowDesktopView", "", "hideDesktopView", "reason", "immediately", "", "isDesktopViewShowing", "showDesktopView", "point", "Callback", "plugin-appbrand-integration_release"})
public final class AppBrandDesktopViewContainer
  extends FrameLayout
{
  public final ViewGroup oot;
  public final AppBrandDesktopView oou;
  public Point oov;
  private a oow;
  public e oox;
  
  public AppBrandDesktopViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public AppBrandDesktopViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(229623);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131493022, (ViewGroup)this, false);
    if (paramAttributeSet == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(229623);
      throw paramContext;
    }
    this.oot = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = this.oot.findViewById(2131296793);
    p.g(paramAttributeSet, "contentView.findViewById…d.app_brand_desktop_view)");
    this.oou = ((AppBrandDesktopView)paramAttributeSet);
    ((WeImageView)this.oot.findViewById(2131296449)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(229618);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.ooy.getCallback();
        if (paramAnonymousView != null) {
          paramAnonymousView.caG();
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(229618);
      }
    });
    addView((View)this.oot, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramAttributeSet = this.oot.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(229623);
      throw paramContext;
    }
    ((FrameLayout.LayoutParams)paramAttributeSet).topMargin = ao.getStatusBarHeight(paramContext);
    this.oot.setVisibility(8);
    AppMethodBeat.o(229623);
  }
  
  public final void T(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(229621);
    if (paramBoolean)
    {
      this.oot.clearAnimation();
      this.oot.setClipBounds(null);
      this.oot.setVisibility(8);
      this.oou.eG(paramInt, 0);
      AppMethodBeat.o(229621);
      return;
    }
    e locale = this.oox;
    if (locale != null)
    {
      locale.a((View)this.oot, null, (e.c)new c(this, paramInt), null);
      AppMethodBeat.o(229621);
      return;
    }
    AppMethodBeat.o(229621);
  }
  
  public final boolean caF()
  {
    AppMethodBeat.i(229622);
    if (this.oot.getVisibility() == 0)
    {
      AppMethodBeat.o(229622);
      return true;
    }
    AppMethodBeat.o(229622);
    return false;
  }
  
  public final e getAnimation()
  {
    return this.oox;
  }
  
  public final a getCallback()
  {
    return this.oow;
  }
  
  public final ViewGroup getContentView()
  {
    return this.oot;
  }
  
  public final AppBrandDesktopView getDesktopView()
  {
    return this.oou;
  }
  
  public final Point getSpreadPoint()
  {
    return this.oov;
  }
  
  public final void setAnimation(e parame)
  {
    this.oox = parame;
  }
  
  public final void setCallback(a parama)
  {
    this.oow = parama;
  }
  
  public final void setSpreadPoint(Point paramPoint)
  {
    this.oov = paramPoint;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$Callback;", "", "requestClose", "", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public abstract void caG();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$animateShowDesktopView$1$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-appbrand-integration_release"})
  public static final class b
    implements e.c
  {
    public b(AppBrandDesktopViewContainer paramAppBrandDesktopViewContainer, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationEnd() {}
    
    public final void onAnimationStart()
    {
      AppMethodBeat.i(229619);
      this.ooy.getContentView().setVisibility(0);
      AppMethodBeat.o(229619);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$hideDesktopView$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-appbrand-integration_release"})
  public static final class c
    implements e.c
  {
    c(int paramInt) {}
    
    public final void onAnimationEnd()
    {
      AppMethodBeat.i(229620);
      this.ooy.getContentView().clearAnimation();
      this.ooy.getContentView().setClipBounds(null);
      this.ooy.getContentView().setVisibility(8);
      this.ooy.getDesktopView().eG(paramInt, 0);
      AppMethodBeat.o(229620);
    }
    
    public final void onAnimationStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopViewContainer
 * JD-Core Version:    0.7.0.1
 */
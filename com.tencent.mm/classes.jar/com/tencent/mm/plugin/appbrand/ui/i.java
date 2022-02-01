package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import com.tencent.luggage.l.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.z;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLoadingSplashUtils;", "", "()V", "TAG", "", "<set-?>", "", "isBlockSplashHideForDebug", "()Z", "setBlockSplashHideForDebug", "(Z)V", "isBlockSplashHideForDebug$delegate", "Lcom/tencent/luggage/util/LuggageMMKVProperty;", "setupSplashAccessibilityTraversalOrder", "", "order", "", "", "splashView", "Landroid/view/View;", "fromDPToPix", "Landroid/content/Context;", "dp", "hideImmediately", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "safeDetachFromWindow", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i ubj;
  static final g ubk;
  
  static
  {
    AppMethodBeat.i(160939);
    aYe = new o[] { (o)ai.a((z)new aa(i.class, "isBlockSplashHideForDebug", "isBlockSplashHideForDebug()Z", 0)) };
    ubj = new i();
    ubk = new g(Boolean.FALSE);
    AppMethodBeat.o(160939);
  }
  
  public static final void a(ah paramah)
  {
    int i = 1;
    AppMethodBeat.i(160938);
    Object localObject;
    if (paramah != null)
    {
      localObject = paramah.getView();
      if ((localObject == null) || (((View)localObject).isAttachedToWindow() != true)) {}
    }
    while (i != 0)
    {
      localObject = paramah.getView().getAnimation();
      if (localObject != null) {
        ((Animation)localObject).cancel();
      }
      paramah.getView().animate().cancel();
      paramah.getView().setVisibility(8);
      localObject = paramah.getView().getParent();
      if (localObject == null)
      {
        paramah = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(160938);
        throw paramah;
        i = 0;
      }
      else
      {
        ((ViewGroup)localObject).removeView(paramah.getView());
      }
    }
    AppMethodBeat.o(160938);
  }
  
  public static final void b(List<Integer> paramList, View paramView)
  {
    int i = 0;
    AppMethodBeat.i(322087);
    s.u(paramList, "order");
    s.u(paramView, "splashView");
    Object localObject = (AccessibilityManager)MMApplicationContext.getContext().getSystemService("accessibility");
    if (localObject == null) {}
    for (boolean bool = false; (!bool) || (Build.VERSION.SDK_INT < 22); bool = ((AccessibilityManager)localObject).isEnabled())
    {
      AppMethodBeat.o(322087);
      return;
    }
    localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      View localView = paramView.findViewById(((Number)((Iterator)localObject).next()).intValue());
      if (localView != null) {
        paramList.add(localView);
      }
    }
    paramList = (List)paramList;
    paramView = ((Iterable)paramList).iterator();
    for (;;)
    {
      int j;
      if (paramView.hasNext())
      {
        localObject = paramView.next();
        j = i + 1;
        if (i < 0) {
          p.kkW();
        }
        localObject = (View)localObject;
        ((View)localObject).setAccessibilityTraversalAfter(-1);
        ((View)localObject).setAccessibilityTraversalBefore(-1);
        if (i > 0)
        {
          ((View)localObject).setAccessibilityDelegate((View.AccessibilityDelegate)new a((View)paramList.get(i - 1)));
          i = j;
        }
      }
      else
      {
        AppMethodBeat.o(322087);
        return;
      }
      i = j;
    }
  }
  
  public static final void dI(View paramView)
  {
    AppMethodBeat.i(322082);
    if (paramView == null)
    {
      AppMethodBeat.o(322082);
      return;
    }
    paramView.setVisibility(8);
    Object localObject = paramView.getParent();
    if ((localObject instanceof ViewGroup)) {}
    for (localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(paramView);
      }
      AppMethodBeat.o(322082);
      return;
    }
  }
  
  public final boolean cKW()
  {
    AppMethodBeat.i(322094);
    boolean bool = ((Boolean)ubk.a(this, aYe[0])).booleanValue();
    AppMethodBeat.o(322094);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/AppBrandLoadingSplashUtils$setupSplashAccessibilityTraversalOrder$1$1", "Landroid/view/View$AccessibilityDelegate;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends View.AccessibilityDelegate
  {
    a(View paramView) {}
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      AppMethodBeat.i(322107);
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
      if ((paramAccessibilityNodeInfo == null) || (paramAccessibilityNodeInfo.isSelected()))
      {
        AppMethodBeat.o(322107);
        return;
      }
      paramAccessibilityNodeInfo.setTraversalAfter(this.ubl);
      paramAccessibilityNodeInfo.setTraversalBefore(null);
      AppMethodBeat.o(322107);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.i
 * JD-Core Version:    0.7.0.1
 */
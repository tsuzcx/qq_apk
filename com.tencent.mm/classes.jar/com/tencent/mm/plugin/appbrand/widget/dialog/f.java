package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogAccessibilityFixer;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IShareContextElement;", "()V", "container2ListenerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogAccessibilityFixer$Companion$Listener;", "Lkotlin/collections/HashMap;", "myTag", "", "attach", "", "dialogContainer", "onDialogDismissed", "isLastDialog", "", "dismissedDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "previousDialog", "onDialogDismissed$luggage_commons_widget_release", "onDialogShown", "isFirstDialog", "shownDialog", "onDialogShown$luggage_commons_widget_release", "findSiblingsBelow", "", "Landroid/view/View;", "isSiblingBelowCoveredCompletely", "siblingsToRecover", "Companion", "luggage-commons-widget_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f.a uCa;
  final String djQ;
  final HashMap<g, a.a> uCb;
  
  static
  {
    AppMethodBeat.i(324686);
    uCa = new f.a((byte)0);
    AppMethodBeat.o(324686);
  }
  
  public f()
  {
    AppMethodBeat.i(324683);
    this.djQ = kotlin.g.b.s.X("MicroMsg.AppBrandDialogAccessibilityFixer#", Integer.valueOf(hashCode()));
    this.uCb = new HashMap();
    AppMethodBeat.o(324683);
  }
  
  final void a(View paramView, boolean paramBoolean, n paramn, List<? extends View> paramList)
  {
    AppMethodBeat.i(324689);
    if (paramBoolean)
    {
      Log.i(this.djQ, "onDialogDismissed[" + paramView + "], isLastDialog, recover siblings's importantForAccessibility");
      Object localObject = paramList;
      if (paramList == null) {
        localObject = dX(paramView);
      }
      paramView = ((List)localObject).iterator();
      while (paramView.hasNext()) {
        ((View)paramView.next()).setImportantForAccessibility(0);
      }
    }
    if (paramn != null)
    {
      paramView = paramn.getContentView();
      if (paramView != null) {
        paramView.setImportantForAccessibility(0);
      }
    }
    AppMethodBeat.o(324689);
  }
  
  final List<View> dX(View paramView)
  {
    AppMethodBeat.i(324697);
    ViewParent localViewParent = paramView.getParent();
    kotlin.g.b.s.s(localViewParent, "parent");
    if (!(localViewParent instanceof ViewGroup))
    {
      Log.w(this.djQ, "findSiblingsBelow[" + paramView + "], parent is not ViewGroup");
      paramView = (List)ab.aivy;
      AppMethodBeat.o(324697);
      return paramView;
    }
    int k = ((ViewGroup)localViewParent).indexOfChild(paramView);
    Log.i(this.djQ, "findSiblingsBelow[" + paramView + "], myIndex: " + k);
    if (k == 0)
    {
      paramView = (List)ab.aivy;
      AppMethodBeat.o(324697);
      return paramView;
    }
    paramView = (List)new ArrayList(k);
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      View localView = ((ViewGroup)localViewParent).getChildAt(i);
      if (localView != null) {
        paramView.add(localView);
      }
      if (j >= k)
      {
        AppMethodBeat.o(324697);
        return paramView;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogAccessibilityFixer$Companion$Listener;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainerListener;", "accessibilityFixer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogAccessibilityFixer;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogAccessibilityFixer;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;)V", "_isAnyDialogShown", "", "isAnyDialogShown", "()Z", "onDialogDismissed", "", "isLastDialog", "dismissedDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "previousDialog", "onDialogShown", "isFirstDialog", "shownDialog", "luggage-commons-widget_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a$a
    implements s
  {
    private final f uCc;
    private final g uCd;
    boolean uCe;
    
    public a$a(f paramf, g paramg)
    {
      AppMethodBeat.i(324756);
      this.uCc = paramf;
      this.uCd = paramg;
      this.uCd.setListener((s)this);
      AppMethodBeat.o(324756);
    }
    
    public final void a(boolean paramBoolean, n paramn)
    {
      int i = 1;
      AppMethodBeat.i(324761);
      this.uCe = true;
      Object localObject1 = this.uCc;
      Object localObject2 = this.uCd;
      kotlin.g.b.s.u(localObject2, "dialogContainer");
      localObject2 = (View)localObject2;
      if (paramBoolean)
      {
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
        if ((localLayoutParams != null) && (-1 == localLayoutParams.width) && (-1 == localLayoutParams.height)) {}
        while (i != 0)
        {
          Log.i(((f)localObject1).djQ, "onDialogShown#[" + localObject2 + "], isFirstDialog, clear siblings's importantForAccessibility");
          localObject1 = ((f)localObject1).dX((View)localObject2).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((View)((Iterator)localObject1).next()).setImportantForAccessibility(4);
          }
          i = 0;
        }
      }
      if (paramn != null)
      {
        paramn = paramn.getContentView();
        if (paramn != null) {
          paramn.setImportantForAccessibility(4);
        }
      }
      AppMethodBeat.o(324761);
    }
    
    public final void b(boolean paramBoolean, n paramn)
    {
      AppMethodBeat.i(324768);
      f localf = this.uCc;
      g localg = this.uCd;
      kotlin.g.b.s.u(localg, "dialogContainer");
      Object localObject2 = (Map)localf.uCb;
      Object localObject1 = (Map)new LinkedHashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      Object localObject3;
      label146:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (kotlin.g.b.s.p(localg, ((Map.Entry)localObject3).getKey())) {}
        for (boolean bool = false;; bool = ((a)((Map.Entry)localObject3).getValue()).uCe)
        {
          if (!bool) {
            break label146;
          }
          ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
          break;
        }
      }
      localObject1 = ((Map)localObject1).keySet();
      if (((Set)localObject1).isEmpty())
      {
        Log.i(localf.djQ, "onDialogDismissed, othersShownContainer is empty");
        localf.a((View)localg, paramBoolean, paramn, null);
      }
      for (;;)
      {
        if (paramBoolean) {
          this.uCe = false;
        }
        AppMethodBeat.o(324768);
        return;
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label308;
          }
          localObject3 = localf.dX((View)((Iterator)localObject2).next());
          if (((List)localObject3).contains(localg))
          {
            Log.i(localf.djQ, "onDialogDismissed, otherShownContainer cover me");
            break;
          }
          ((Collection)localObject1).add(localObject3);
        }
        label308:
        localObject2 = (Iterable)localObject1;
        localObject1 = new HashSet();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((HashSet)localObject1).addAll((Collection)((Iterator)localObject2).next());
        }
        localObject3 = (Iterable)localf.dX((View)localg);
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        label458:
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (!((HashSet)localObject1).contains((View)localObject4)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label458;
            }
            ((Collection)localObject2).add(localObject4);
            break;
          }
        }
        localObject1 = (List)localObject2;
        localf.a((View)localg, paramBoolean, paramn, (List)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f
 * JD-Core Version:    0.7.0.1
 */
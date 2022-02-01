package com.tencent.mm.plugin.finder.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.u;
import androidx.recyclerview.widget.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "()V", "endRect", "", "firstRect", "forwardDirection", "", "horizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "kotlin.jvm.PlatformType", "getHorizontalHelper", "()Landroidx/recyclerview/widget/OrientationHelper;", "horizontalHelper$delegate", "Lkotlin/Lazy;", "ignoreIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "rect", "Landroid/graphics/Rect;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "specialIds", "verticalHelper", "getVerticalHelper", "verticalHelper$delegate", "attachToRecyclerView", "", "view", "calculateDistanceToFinalSnap", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "checkMask", "isHardAlpha", "source", "", "distanceToTop", "helper", "findCenterView", "canScrollVertically", "findSnapView", "findTargetSnapPosition", "velocityX", "velocityY", "findVisiblePos", "findVisibleView", "isIgnoreView", "isSpecialView", "print", "msg", "Companion", "plugin-finder_release"})
public final class e
  extends v
{
  public static final a Ark;
  private static final boolean dal;
  private boolean AaR;
  private final HashSet<Integer> AaU;
  private final int[] Are;
  private final int[] Arf;
  private final HashSet<Integer> Arg;
  private LinearLayoutManager Arh;
  private final f Ari;
  private final f Arj;
  private final Rect byG;
  private RecyclerView jLl;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(286863);
    Ark = new a((byte)0);
    if (BuildInfo.DEBUG) {
      bool = true;
    }
    dal = bool;
    AppMethodBeat.o(286863);
  }
  
  public e()
  {
    AppMethodBeat.i(286862);
    this.Are = new int[2];
    this.Arf = new int[2];
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(b.f.guide_layout_parent));
    this.Arg = localHashSet;
    localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(b.f.search_scroll_tips_root));
    this.AaU = localHashSet;
    this.Ari = g.ar((kotlin.g.a.a)new e(this));
    this.Arj = g.ar((kotlin.g.a.a)new d(this));
    this.byG = new Rect();
    AppMethodBeat.o(286862);
  }
  
  private static int a(View paramView, u paramu)
  {
    AppMethodBeat.i(286860);
    int i = paramu.aZ(paramView);
    int j = paramu.kT();
    aex("distanceToTop childTop:" + i + " containerTop:" + j + " targetViewHeight:" + paramView.getHeight() + " view:" + paramView);
    AppMethodBeat.o(286860);
    return i - j;
  }
  
  private static void aex(String paramString)
  {
    AppMethodBeat.i(286861);
    if (dal) {
      Log.i("Finder.FullPagerSnapHelper", paramString);
    }
    AppMethodBeat.o(286861);
  }
  
  private final boolean eG(View paramView)
  {
    AppMethodBeat.i(286857);
    if (paramView == null)
    {
      AppMethodBeat.o(286857);
      return false;
    }
    Iterator localIterator = ((Iterable)this.Arg).iterator();
    while (localIterator.hasNext())
    {
      View localView = paramView.findViewById(((Number)localIterator.next()).intValue());
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        AppMethodBeat.o(286857);
        return true;
      }
    }
    AppMethodBeat.o(286857);
    return false;
  }
  
  private final boolean eH(View paramView)
  {
    AppMethodBeat.i(286858);
    if (paramView == null)
    {
      AppMethodBeat.o(286858);
      return false;
    }
    Iterator localIterator = ((Iterable)this.AaU).iterator();
    while (localIterator.hasNext())
    {
      View localView = paramView.findViewById(((Number)localIterator.next()).intValue());
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        AppMethodBeat.o(286858);
        return true;
      }
    }
    AppMethodBeat.o(286858);
    return false;
  }
  
  private final u eat()
  {
    AppMethodBeat.i(286853);
    u localu = (u)this.Ari.getValue();
    AppMethodBeat.o(286853);
    return localu;
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int j = 0;
    AppMethodBeat.i(286855);
    p.k(paramLayoutManager, "layoutManager");
    int i = super.a(paramLayoutManager, paramInt1, paramInt2);
    View localView;
    if (paramLayoutManager.canScrollHorizontally()) {
      if (paramInt1 > 0)
      {
        this.AaR = bool;
        localView = paramLayoutManager.findViewByPosition(i);
        if (eH(localView)) {
          break label415;
        }
        if ((localView != null) && (localView.getHeight() > 0)) {
          break label399;
        }
        paramLayoutManager = this.Arh;
        if (paramLayoutManager == null) {
          p.bGy("layoutManager");
        }
        j = paramLayoutManager.getChildCount();
        paramInt1 = 0;
        label96:
        if (paramInt1 >= j) {
          break label534;
        }
        paramLayoutManager = this.Arh;
        if (paramLayoutManager == null) {
          p.bGy("layoutManager");
        }
        paramLayoutManager = paramLayoutManager.getChildAt(paramInt1);
        if (paramLayoutManager != null) {
          break label149;
        }
      }
    }
    label149:
    do
    {
      paramInt1 += 1;
      break label96;
      bool = false;
      break;
      if (paramInt2 > 0) {
        break;
      }
      bool = false;
      break;
      p.j(paramLayoutManager, "layoutManager.getChildAt(i) ?: continue");
    } while (!p.h(paramLayoutManager, localView));
    for (;;)
    {
      if ((paramInt2 > 0) && (paramInt1 + 1 < j))
      {
        paramInt1 += 1;
        if (paramInt1 >= j) {
          break label399;
        }
        paramLayoutManager = this.Arh;
        if (paramLayoutManager == null) {
          p.bGy("layoutManager");
        }
        paramLayoutManager = paramLayoutManager.getChildAt(paramInt1);
        if (paramLayoutManager == null) {}
        do
        {
          paramInt1 += 1;
          break;
          p.j(paramLayoutManager, "layoutManager.getChildAt(i) ?: continue");
        } while (paramLayoutManager.getHeight() <= 0);
        if (paramLayoutManager == null) {
          break label410;
        }
        RecyclerView localRecyclerView = this.jLl;
        if (localRecyclerView == null) {
          p.bGy("recyclerView");
        }
        paramLayoutManager = localRecyclerView.bf(paramLayoutManager);
        if (paramLayoutManager == null) {
          break label405;
        }
        paramInt1 = paramLayoutManager.md();
      }
      for (;;)
      {
        aex("[findTargetSnapPosition] pos=" + i + " -> " + paramInt1);
        if ((localView != null) && (eG(localView))) {
          localView.setTag(b.f.finder_full_snap_ignore, Boolean.FALSE);
        }
        AppMethodBeat.o(286855);
        return paramInt1;
        if ((paramInt2 < 0) && (paramInt1 - 1 >= 0))
        {
          paramInt1 -= 1;
          if (paramInt1 >= 0)
          {
            paramLayoutManager = this.Arh;
            if (paramLayoutManager == null) {
              p.bGy("layoutManager");
            }
            paramLayoutManager = paramLayoutManager.getChildAt(paramInt1);
            if (paramLayoutManager == null) {}
            do
            {
              paramInt1 -= 1;
              break;
              p.j(paramLayoutManager, "layoutManager.getChildAt(i) ?: continue");
            } while (paramLayoutManager.getHeight() <= 0);
            break;
          }
        }
        label399:
        paramLayoutManager = localView;
        break;
        label405:
        paramInt1 = -1;
        continue;
        label410:
        paramInt1 = -1;
      }
      label415:
      paramLayoutManager = this.jLl;
      if (paramLayoutManager == null) {
        p.bGy("recyclerView");
      }
      paramLayoutManager = paramLayoutManager.getAdapter();
      paramInt1 = j;
      if (paramLayoutManager != null) {
        paramInt1 = paramLayoutManager.getItemCount();
      }
      if ((this.AaR) && (i + 1 < paramInt1)) {
        paramInt1 = i + 1;
      }
      for (;;)
      {
        aex("[findTargetSnapPosition] isIgnoreView pos=" + i + " -> " + paramInt1);
        AppMethodBeat.o(286855);
        return paramInt1;
        if ((!this.AaR) && (i - 1 >= 0)) {
          paramInt1 = i - 1;
        } else {
          paramInt1 = i;
        }
      }
      label534:
      paramInt1 = -1;
    }
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(286856);
    p.k(paramLayoutManager, "layoutManager");
    boolean bool = paramLayoutManager.canScrollVertically();
    int n = paramLayoutManager.getChildCount();
    Object localObject1;
    if (n == 0) {
      localObject1 = null;
    }
    float f1;
    int m;
    Object localObject2;
    View localView;
    Object localObject3;
    float f2;
    for (;;)
    {
      aex("findSnapView() snapView:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(286856);
      return localObject1;
      f1 = 0.0F;
      m = 0;
      localObject2 = null;
      localObject1 = localObject2;
      if (m < n)
      {
        localView = paramLayoutManager.getChildAt(m);
        if (localView == null)
        {
          localObject3 = localObject2;
          f2 = f1;
        }
        label135:
        do
        {
          do
          {
            m += 1;
            f1 = f2;
            localObject2 = localObject3;
            break;
            p.j(localView, "layoutManager.getChildAt(i) ?: continue");
            if (!bool) {
              break label135;
            }
            f2 = f1;
            localObject3 = localObject2;
          } while (localView.getHeight() <= 0);
          if (bool) {
            break label154;
          }
          f2 = f1;
          localObject3 = localObject2;
        } while (localView.getWidth() <= 0);
        label154:
        if ((!eG(localView)) || (!localView.getGlobalVisibleRect(this.byG)) || (this.byG.height() <= 0)) {
          break;
        }
        paramLayoutManager = localView.getTag(b.f.finder_full_snap_ignore);
        aex("[findSnapView] isSpecialView child=" + localView + " rect=" + this.byG + " tag=" + paramLayoutManager);
        if ((paramLayoutManager == null) || (p.h(paramLayoutManager, Boolean.TRUE)))
        {
          localObject1 = localView;
        }
        else
        {
          localView.setTag(b.f.finder_full_snap_ignore, Boolean.FALSE);
          localObject1 = null;
        }
      }
    }
    int i;
    label302:
    int j;
    label314:
    label371:
    int k;
    if (localView.getGlobalVisibleRect(this.byG)) {
      if (bool)
      {
        i = this.byG.height();
        if (!bool) {
          break label516;
        }
        j = localView.getHeight();
        if ((!eH(localView)) || (!localView.getGlobalVisibleRect(this.byG)) || (this.byG.height() <= 0)) {
          break label587;
        }
        if ((!this.AaR) || (m + 1 >= n)) {
          break label526;
        }
        localObject1 = paramLayoutManager.getChildAt(m + 1);
        if (localObject1 == null) {
          break label587;
        }
        if (!((View)localObject1).getGlobalVisibleRect(this.byG)) {
          break label571;
        }
        if (!bool) {
          break label559;
        }
        k = this.byG.height();
        label402:
        k = i + k;
        if (!bool) {
          break label577;
        }
        i = ((View)localObject1).getHeight();
        label421:
        j += i;
        aex("findSnapView ignoreChild:" + localView + " jumpIgnoreChild:" + localObject1);
        i = k;
      }
    }
    for (;;)
    {
      float f3 = 1.0F * i / j;
      f2 = f1;
      localObject3 = localObject2;
      if (f1 >= f3) {
        break;
      }
      f2 = f3;
      localObject3 = localObject1;
      break;
      i = this.byG.width();
      break label302;
      i = 0;
      break label302;
      label516:
      j = localView.getWidth();
      break label314;
      label526:
      if ((!this.AaR) && (m - 1 >= 0))
      {
        localObject1 = paramLayoutManager.getChildAt(m - 1);
        break label371;
      }
      localObject1 = null;
      break label371;
      label559:
      k = this.byG.width();
      break label402;
      label571:
      k = 0;
      break label402;
      label577:
      i = ((View)localObject1).getWidth();
      break label421;
      label587:
      localObject1 = localView;
    }
  }
  
  public final void a(final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(286854);
    if (paramRecyclerView != null)
    {
      Object localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(286854);
        throw paramRecyclerView;
      }
      localObject = (LinearLayoutManager)localObject;
      this.jLl = paramRecyclerView;
      this.Arh = ((LinearLayoutManager)localObject);
      paramRecyclerView.a((RecyclerView.l)new b((LinearLayoutManager)localObject, this, paramRecyclerView));
      RecyclerView.a locala = paramRecyclerView.getAdapter();
      if (locala != null) {
        locala.a((RecyclerView.c)new e.c(paramRecyclerView, (LinearLayoutManager)localObject, this, paramRecyclerView));
      }
    }
    super.a(paramRecyclerView);
    AppMethodBeat.o(286854);
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(286859);
    p.k(paramLayoutManager, "layoutManager");
    p.k(paramView, "targetView");
    int[] arrayOfInt = new int[2];
    u localu;
    if (eG(paramView))
    {
      paramLayoutManager = paramView.getTag(b.f.finder_full_snap_ignore);
      localu = eat();
      p.j(localu, "verticalHelper");
      arrayOfInt[1] = a(paramView, localu);
      if ((paramLayoutManager == null) || (p.h(paramLayoutManager, Boolean.TRUE))) {
        arrayOfInt[1] = 0;
      }
      paramView.setTag(b.f.finder_full_snap_ignore, Boolean.FALSE);
    }
    for (;;)
    {
      aex("calculateDistanceToFinalSnap x:" + arrayOfInt[0] + " y:" + arrayOfInt[1]);
      AppMethodBeat.o(286859);
      return arrayOfInt;
      if (paramLayoutManager.canScrollHorizontally())
      {
        localu = (u)this.Arj.getValue();
        p.j(localu, "horizontalHelper");
        arrayOfInt[0] = a(paramView, localu);
      }
      for (;;)
      {
        if (!paramLayoutManager.canScrollVertically()) {
          break label207;
        }
        paramLayoutManager = eat();
        p.j(paramLayoutManager, "verticalHelper");
        arrayOfInt[1] = a(paramView, paramLayoutManager);
        break;
        arrayOfInt[0] = 0;
      }
      label207:
      arrayOfInt[1] = 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$Companion;", "", "()V", "TAG", "", "isDebug", "", "()Z", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.l
  {
    b(LinearLayoutManager paramLinearLayoutManager, e parame, RecyclerView paramRecyclerView) {}
    
    public final void onScrollStateChanged(final RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(285365);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(279025);
            e.a(this.Arn.Arl, paramRecyclerView, this.Arn.xDp, false);
            AppMethodBeat.o(279025);
          }
        });
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(285365);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(285366);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      e.a(jdField_this, paramRecyclerView, this.xDp, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(285366);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/OrientationHelper;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<u>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/OrientationHelper;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<u>
  {
    e(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.e
 * JD-Core Version:    0.7.0.1
 */
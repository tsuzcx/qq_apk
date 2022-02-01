package com.tencent.mm.plugin.finder.ui;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "endRect", "", "firstRect", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "kotlin.jvm.PlatformType", "getHorizontalHelper", "()Landroid/support/v7/widget/OrientationHelper;", "horizontalHelper$delegate", "Lkotlin/Lazy;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "rect", "Landroid/graphics/Rect;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "specialIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "verticalHelper", "getVerticalHelper", "verticalHelper$delegate", "attachToRecyclerView", "", "view", "calculateDistanceToFinalSnap", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "checkMask", "isHardAlpha", "", "source", "", "distanceToTop", "helper", "findCenterView", "canScrollVertically", "findSnapView", "findTargetSnapPosition", "velocityX", "velocityY", "findVisiblePos", "findVisibleView", "isSpecialView", "print", "msg", "Companion", "plugin-finder_release"})
public final class e
  extends ak
{
  private static final boolean cWq;
  public static final e.a vKs;
  private RecyclerView hak;
  private final Rect rect;
  private final int[] vKm;
  private final int[] vKn;
  private final HashSet<Integer> vKo;
  private LinearLayoutManager vKp;
  private final f vKq;
  private final f vKr;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(252419);
    vKs = new e.a((byte)0);
    if (BuildInfo.DEBUG) {
      bool = true;
    }
    cWq = bool;
    AppMethodBeat.o(252419);
  }
  
  public e()
  {
    AppMethodBeat.i(252418);
    this.vKm = new int[2];
    this.vKn = new int[2];
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(2131302228));
    this.vKo = localHashSet;
    this.vKq = g.ah((kotlin.g.a.a)new e(this));
    this.vKr = g.ah((kotlin.g.a.a)new d(this));
    this.rect = new Rect();
    AppMethodBeat.o(252418);
  }
  
  private static int a(View paramView, aj paramaj)
  {
    AppMethodBeat.i(252416);
    int i = paramaj.bo(paramView);
    int j = paramaj.kH();
    AppMethodBeat.o(252416);
    return i - j;
  }
  
  private final aj dzz()
  {
    AppMethodBeat.i(252410);
    aj localaj = (aj)this.vKq.getValue();
    AppMethodBeat.o(252410);
    return localaj;
  }
  
  private final boolean eb(View paramView)
  {
    AppMethodBeat.i(252414);
    if (paramView == null)
    {
      AppMethodBeat.o(252414);
      return false;
    }
    Iterator localIterator = ((Iterable)this.vKo).iterator();
    while (localIterator.hasNext())
    {
      View localView = paramView.findViewById(((Number)localIterator.next()).intValue());
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        AppMethodBeat.o(252414);
        return true;
      }
    }
    AppMethodBeat.o(252414);
    return false;
  }
  
  private static void print(String paramString)
  {
    AppMethodBeat.i(252417);
    if (cWq) {
      Log.i("Finder.FullPagerSnapHelper", paramString);
    }
    AppMethodBeat.o(252417);
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int i = -1;
    AppMethodBeat.i(252412);
    p.h(paramLayoutManager, "layoutManager");
    int j = super.a(paramLayoutManager, paramInt1, paramInt2);
    View localView = paramLayoutManager.findViewByPosition(j);
    int k;
    if ((localView == null) || (localView.getHeight() <= 0))
    {
      paramLayoutManager = this.vKp;
      if (paramLayoutManager == null) {
        p.btv("layoutManager");
      }
      k = paramLayoutManager.getChildCount();
      paramInt1 = 0;
      if (paramInt1 >= k) {
        break label376;
      }
      paramLayoutManager = this.vKp;
      if (paramLayoutManager == null) {
        p.btv("layoutManager");
      }
      paramLayoutManager = paramLayoutManager.getChildAt(paramInt1);
      if (paramLayoutManager == null) {}
      do
      {
        paramInt1 += 1;
        break;
        p.g(paramLayoutManager, "layoutManager.getChildAt(i) ?: continue");
      } while (!p.j(paramLayoutManager, localView));
    }
    for (;;)
    {
      if ((paramInt2 > 0) && (paramInt1 + 1 < k))
      {
        paramInt1 += 1;
        if (paramInt1 >= k) {
          break label370;
        }
        paramLayoutManager = this.vKp;
        if (paramLayoutManager == null) {
          p.btv("layoutManager");
        }
        paramLayoutManager = paramLayoutManager.getChildAt(paramInt1);
        if (paramLayoutManager == null) {}
        do
        {
          paramInt1 += 1;
          break;
          p.g(paramLayoutManager, "layoutManager.getChildAt(i) ?: continue");
        } while (paramLayoutManager.getHeight() <= 0);
      }
      for (;;)
      {
        paramInt1 = i;
        if (paramLayoutManager != null)
        {
          RecyclerView localRecyclerView = this.hak;
          if (localRecyclerView == null) {
            p.btv("recyclerView");
          }
          paramLayoutManager = localRecyclerView.bu(paramLayoutManager);
          paramInt1 = i;
          if (paramLayoutManager != null) {
            paramInt1 = paramLayoutManager.lR();
          }
        }
        print("[findTargetSnapPosition] pos=" + j + " -> " + paramInt1 + ", velocityY=" + paramInt2);
        if ((localView != null) && (eb(localView))) {
          localView.setTag(2131300846, Boolean.FALSE);
        }
        AppMethodBeat.o(252412);
        return paramInt1;
        if ((paramInt2 < 0) && (paramInt1 - 1 >= 0))
        {
          paramInt1 -= 1;
          if (paramInt1 >= 0)
          {
            paramLayoutManager = this.vKp;
            if (paramLayoutManager == null) {
              p.btv("layoutManager");
            }
            paramLayoutManager = paramLayoutManager.getChildAt(paramInt1);
            if (paramLayoutManager == null) {}
            do
            {
              paramInt1 -= 1;
              break;
              p.g(paramLayoutManager, "layoutManager.getChildAt(i) ?: continue");
            } while (paramLayoutManager.getHeight() <= 0);
            continue;
          }
        }
        label370:
        paramLayoutManager = localView;
      }
      label376:
      paramInt1 = -1;
    }
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(252413);
    p.h(paramLayoutManager, "layoutManager");
    boolean bool = paramLayoutManager.canScrollVertically();
    int k = paramLayoutManager.getChildCount();
    if (k == 0)
    {
      AppMethodBeat.o(252413);
      return null;
    }
    float f1 = 0.0F;
    int j = 0;
    Object localObject1 = null;
    if (j < k)
    {
      View localView = paramLayoutManager.getChildAt(j);
      Object localObject2;
      float f2;
      if (localView == null)
      {
        localObject2 = localObject1;
        f2 = f1;
      }
      label113:
      do
      {
        do
        {
          j += 1;
          f1 = f2;
          localObject1 = localObject2;
          break;
          p.g(localView, "layoutManager.getChildAt(i) ?: continue");
          if (!bool) {
            break label113;
          }
          f2 = f1;
          localObject2 = localObject1;
        } while (localView.getHeight() <= 0);
        if (bool) {
          break label132;
        }
        f2 = f1;
        localObject2 = localObject1;
      } while (localView.getWidth() <= 0);
      label132:
      if ((eb(localView)) && (localView.getGlobalVisibleRect(this.rect)) && (this.rect.height() > 0))
      {
        paramLayoutManager = localView.getTag(2131300846);
        print("[findSnapView] isSpecialView child=" + localView + " rect=" + this.rect + " tag=" + paramLayoutManager);
        if ((paramLayoutManager == null) || (p.j(paramLayoutManager, Boolean.TRUE)))
        {
          AppMethodBeat.o(252413);
          return localView;
        }
        localView.setTag(2131300846, Boolean.FALSE);
        AppMethodBeat.o(252413);
        return null;
      }
      if (localView.getGlobalVisibleRect(this.rect)) {
        if (bool)
        {
          i = this.rect.height();
          label284:
          f2 = i;
          if (!bool) {
            break label350;
          }
        }
      }
      label350:
      for (int i = localView.getHeight();; i = localView.getWidth())
      {
        float f3 = 1.0F * f2 / i;
        f2 = f1;
        localObject2 = localObject1;
        if (f1 >= f3) {
          break;
        }
        f2 = f3;
        localObject2 = localView;
        break;
        i = this.rect.width();
        break label284;
        i = 0;
        break label284;
      }
    }
    AppMethodBeat.o(252413);
    return localObject1;
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(252415);
    p.h(paramLayoutManager, "layoutManager");
    p.h(paramView, "targetView");
    int[] arrayOfInt = new int[2];
    aj localaj;
    if (eb(paramView))
    {
      paramLayoutManager = paramView.getTag(2131300846);
      localaj = dzz();
      p.g(localaj, "verticalHelper");
      arrayOfInt[1] = a(paramView, localaj);
      if ((paramLayoutManager == null) || (p.j(paramLayoutManager, Boolean.TRUE))) {
        arrayOfInt[1] = 0;
      }
      paramView.setTag(2131300846, Boolean.FALSE);
    }
    for (;;)
    {
      AppMethodBeat.o(252415);
      return arrayOfInt;
      if (paramLayoutManager.canScrollHorizontally())
      {
        localaj = (aj)this.vKr.getValue();
        p.g(localaj, "horizontalHelper");
        arrayOfInt[0] = a(paramView, localaj);
      }
      for (;;)
      {
        if (!paramLayoutManager.canScrollVertically()) {
          break label173;
        }
        paramLayoutManager = dzz();
        p.g(paramLayoutManager, "verticalHelper");
        arrayOfInt[1] = a(paramView, paramLayoutManager);
        break;
        arrayOfInt[0] = 0;
      }
      label173:
      arrayOfInt[1] = 0;
    }
  }
  
  public final void f(final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(252411);
    if (paramRecyclerView != null)
    {
      Object localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(252411);
        throw paramRecyclerView;
      }
      localObject = (LinearLayoutManager)localObject;
      this.hak = paramRecyclerView;
      this.vKp = ((LinearLayoutManager)localObject);
      paramRecyclerView.a((RecyclerView.l)new b((LinearLayoutManager)localObject, this, paramRecyclerView));
      RecyclerView.a locala = paramRecyclerView.getAdapter();
      if (locala != null) {
        locala.a((RecyclerView.c)new e.c(paramRecyclerView, (LinearLayoutManager)localObject, this, paramRecyclerView));
      }
    }
    super.f(paramRecyclerView);
    AppMethodBeat.o(252411);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$1$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.l
  {
    b(LinearLayoutManager paramLinearLayoutManager, e parame, RecyclerView paramRecyclerView) {}
    
    public final void onScrollStateChanged(final RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(252398);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(252397);
            e.a(this.vKv.vKt, paramRecyclerView, this.vKv.tSy, false);
            AppMethodBeat.o(252397);
          }
        });
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(252398);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(252399);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      e.a(jdField_this, paramRecyclerView, this.tSy, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(252399);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/OrientationHelper;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<aj>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/OrientationHelper;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<aj>
  {
    e(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.e
 * JD-Core Version:    0.7.0.1
 */
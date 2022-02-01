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
import androidx.recyclerview.widget.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.w.a.a.a.e;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "()V", "endRect", "", "firstRect", "forwardDirection", "", "horizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "kotlin.jvm.PlatformType", "getHorizontalHelper", "()Landroidx/recyclerview/widget/OrientationHelper;", "horizontalHelper$delegate", "Lkotlin/Lazy;", "ignoreIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "isCheckMask", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "rect", "Landroid/graphics/Rect;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "specialIds", "verticalHelper", "getVerticalHelper", "verticalHelper$delegate", "attachToRecyclerView", "", "view", "calculateDistanceToFinalSnap", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "checkMask", "isHardAlpha", "source", "", "distanceToTop", "helper", "findCenterView", "canScrollVertically", "findSnapView", "findTargetSnapPosition", "velocityX", "velocityY", "findVisiblePos", "findVisibleView", "isIgnoreView", "isSpecialView", "print", "msg", "setCheckMask", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends t
{
  public static final e.a FQG;
  private static final boolean eYL;
  private LinearLayoutManager AJH;
  private final int[] FQH;
  private final int[] FQI;
  private final HashSet<Integer> FQJ;
  private final j FQK;
  private final j FQL;
  public boolean FQM;
  private final HashSet<Integer> FwB;
  private boolean Fwx;
  private RecyclerView mkw;
  private final Rect rect;
  
  static
  {
    AppMethodBeat.i(346560);
    FQG = new e.a((byte)0);
    eYL = BuildInfo.DEBUG;
    AppMethodBeat.o(346560);
  }
  
  public e()
  {
    AppMethodBeat.i(346519);
    this.FQH = new int[2];
    this.FQI = new int[2];
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(a.e.guide_layout_parent));
    ah localah = ah.aiuX;
    this.FQJ = localHashSet;
    localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(a.e.search_scroll_tips_root));
    localah = ah.aiuX;
    this.FwB = localHashSet;
    this.FQK = k.cm((kotlin.g.a.a)new e(this));
    this.FQL = k.cm((kotlin.g.a.a)new d(this));
    this.FQM = true;
    this.rect = new Rect();
    AppMethodBeat.o(346519);
  }
  
  private static void Xa(String paramString)
  {
    AppMethodBeat.i(346547);
    if (eYL) {
      Log.i("Finder.FullPagerSnapHelper", paramString);
    }
    AppMethodBeat.o(346547);
  }
  
  private static int b(View paramView, androidx.recyclerview.widget.s params)
  {
    AppMethodBeat.i(346543);
    int i = params.bs(paramView);
    int j = params.JE();
    Xa("distanceToTop childTop:" + i + " containerTop:" + j + " targetViewHeight:" + paramView.getHeight() + " view:" + paramView);
    AppMethodBeat.o(346543);
    return i - j;
  }
  
  private final androidx.recyclerview.widget.s fbh()
  {
    AppMethodBeat.i(346523);
    androidx.recyclerview.widget.s locals = (androidx.recyclerview.widget.s)this.FQK.getValue();
    AppMethodBeat.o(346523);
    return locals;
  }
  
  private final boolean gG(View paramView)
  {
    AppMethodBeat.i(346536);
    if (paramView == null)
    {
      AppMethodBeat.o(346536);
      return false;
    }
    Iterator localIterator = ((Iterable)this.FwB).iterator();
    while (localIterator.hasNext())
    {
      View localView = paramView.findViewById(((Number)localIterator.next()).intValue());
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        AppMethodBeat.o(346536);
        return true;
      }
    }
    AppMethodBeat.o(346536);
    return false;
  }
  
  private final boolean gI(View paramView)
  {
    AppMethodBeat.i(346531);
    if (paramView == null)
    {
      AppMethodBeat.o(346531);
      return false;
    }
    Iterator localIterator = ((Iterable)this.FQJ).iterator();
    while (localIterator.hasNext())
    {
      View localView = paramView.findViewById(((Number)localIterator.next()).intValue());
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        AppMethodBeat.o(346531);
        return true;
      }
    }
    AppMethodBeat.o(346531);
    return false;
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int k = 0;
    int j = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(346573);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    int i = super.a(paramLayoutManager, paramInt1, paramInt2);
    View localView;
    if (paramLayoutManager.canScrollHorizontally()) {
      if (paramInt1 > 0)
      {
        this.Fwx = bool;
        localView = paramLayoutManager.findViewByPosition(i);
        if (gG(localView)) {
          break label457;
        }
        if ((localView != null) && (localView.getHeight() > 0)) {
          break label366;
        }
        localObject2 = this.AJH;
        paramLayoutManager = (RecyclerView.LayoutManager)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("layoutManager");
          paramLayoutManager = null;
        }
        k = paramLayoutManager.getChildCount();
        if (k <= 0) {
          break label355;
        }
      }
    }
    label166:
    label445:
    label452:
    label457:
    label585:
    label590:
    for (paramInt1 = j;; paramInt1 = j)
    {
      j = paramInt1 + 1;
      localObject2 = this.AJH;
      paramLayoutManager = (RecyclerView.LayoutManager)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("layoutManager");
        paramLayoutManager = null;
      }
      paramLayoutManager = paramLayoutManager.getChildAt(paramInt1);
      if ((paramLayoutManager != null) && (kotlin.g.b.s.p(paramLayoutManager, localView)))
      {
        if ((paramInt2 <= 0) || (paramInt1 + 1 >= k)) {
          break label372;
        }
        paramInt1 += 1;
        if (paramInt1 >= k) {
          break label366;
        }
      }
      for (;;)
      {
        paramInt2 = paramInt1 + 1;
        localObject2 = this.AJH;
        paramLayoutManager = (RecyclerView.LayoutManager)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("layoutManager");
          paramLayoutManager = null;
        }
        paramLayoutManager = paramLayoutManager.getChildAt(paramInt1);
        if ((paramLayoutManager != null) && (paramLayoutManager.getHeight() > 0))
        {
          if (paramLayoutManager == null) {
            break label452;
          }
          localObject2 = this.mkw;
          if (localObject2 != null) {
            break label445;
          }
          kotlin.g.b.s.bIx("recyclerView");
          label252:
          paramLayoutManager = localObject1.by(paramLayoutManager);
          if (paramLayoutManager == null) {
            break label452;
          }
        }
        for (paramInt1 = paramLayoutManager.KJ();; paramInt1 = -1)
        {
          Xa("[findTargetSnapPosition] pos=" + i + " -> " + paramInt1);
          if ((localView != null) && (gI(localView))) {
            localView.setTag(a.e.finder_full_snap_ignore, Boolean.FALSE);
          }
          AppMethodBeat.o(346573);
          return paramInt1;
          bool = false;
          break;
          if (paramInt2 > 0) {
            break;
          }
          bool = false;
          break;
          if (j < k) {
            break label590;
          }
          label355:
          paramInt1 = -1;
          break label166;
          if (paramInt2 < k) {
            break label585;
          }
          label366:
          label372:
          do
          {
            do
            {
              paramLayoutManager = localView;
              break;
            } while ((paramInt2 >= 0) || (paramInt1 - 1 < 0));
            paramInt1 -= 1;
          } while (paramInt1 < 0);
          for (;;)
          {
            paramInt2 = paramInt1 - 1;
            localObject2 = this.AJH;
            paramLayoutManager = (RecyclerView.LayoutManager)localObject2;
            if (localObject2 == null)
            {
              kotlin.g.b.s.bIx("layoutManager");
              paramLayoutManager = null;
            }
            paramLayoutManager = paramLayoutManager.getChildAt(paramInt1);
            if ((paramLayoutManager != null) && (paramLayoutManager.getHeight() > 0)) {
              break;
            }
            if (paramInt2 < 0) {
              break label366;
            }
            paramInt1 = paramInt2;
          }
          localObject1 = localObject2;
          break label252;
        }
        paramLayoutManager = this.mkw;
        if (paramLayoutManager == null)
        {
          kotlin.g.b.s.bIx("recyclerView");
          paramLayoutManager = (RecyclerView.LayoutManager)localObject2;
          paramLayoutManager = paramLayoutManager.getAdapter();
          if (paramLayoutManager != null) {
            break label549;
          }
          paramInt1 = k;
          label487:
          if ((!this.Fwx) || (i + 1 >= paramInt1)) {
            break label557;
          }
          paramInt1 = i + 1;
        }
        for (;;)
        {
          Xa("[findTargetSnapPosition] isIgnoreView pos=" + i + " -> " + paramInt1);
          AppMethodBeat.o(346573);
          return paramInt1;
          break;
          paramInt1 = paramLayoutManager.getItemCount();
          break label487;
          if ((!this.Fwx) && (i - 1 >= 0)) {
            paramInt1 = i - 1;
          } else {
            paramInt1 = i;
          }
        }
        paramInt1 = paramInt2;
      }
    }
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    Object localObject4 = null;
    AppMethodBeat.i(346590);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    boolean bool = paramLayoutManager.canScrollVertically();
    int i1 = paramLayoutManager.getChildCount();
    if (i1 == 0) {
      paramLayoutManager = localObject4;
    }
    int k;
    float f1;
    Object localObject3;
    label67:
    int n;
    Object localObject2;
    float f2;
    Object localObject1;
    for (;;)
    {
      Xa(kotlin.g.b.s.X("findSnapView() snapView:", paramLayoutManager));
      AppMethodBeat.o(346590);
      return paramLayoutManager;
      if (i1 <= 0) {
        break label588;
      }
      k = 0;
      f1 = 0.0F;
      localObject3 = null;
      n = k + 1;
      localObject2 = paramLayoutManager.getChildAt(k);
      f2 = f1;
      localObject1 = localObject3;
      if (localObject2 == null) {
        break label470;
      }
      if (bool)
      {
        f2 = f1;
        localObject1 = localObject3;
        if (((View)localObject2).getHeight() <= 0) {
          break label470;
        }
      }
      if (!bool)
      {
        f2 = f1;
        localObject1 = localObject3;
        if (((View)localObject2).getWidth() <= 0) {
          break label470;
        }
      }
      if ((!gI((View)localObject2)) || (!((View)localObject2).getGlobalVisibleRect(this.rect)) || (this.rect.height() <= 0)) {
        break;
      }
      paramLayoutManager = ((View)localObject2).getTag(a.e.finder_full_snap_ignore);
      Xa("[findSnapView] isSpecialView child=" + localObject2 + " rect=" + this.rect + " tag=" + paramLayoutManager);
      if ((paramLayoutManager == null) || (kotlin.g.b.s.p(paramLayoutManager, Boolean.TRUE)))
      {
        paramLayoutManager = (RecyclerView.LayoutManager)localObject2;
      }
      else
      {
        ((View)localObject2).setTag(a.e.finder_full_snap_ignore, Boolean.FALSE);
        paramLayoutManager = localObject4;
      }
    }
    int i;
    label277:
    int j;
    label289:
    label346:
    label377:
    int m;
    if (((View)localObject2).getGlobalVisibleRect(this.rect)) {
      if (bool)
      {
        i = this.rect.height();
        if (!bool) {
          break label501;
        }
        j = ((View)localObject2).getHeight();
        if ((!gG((View)localObject2)) || (!((View)localObject2).getGlobalVisibleRect(this.rect)) || (this.rect.height() <= 0)) {
          break label572;
        }
        if ((!this.Fwx) || (k + 1 >= i1)) {
          break label511;
        }
        localObject1 = paramLayoutManager.getChildAt(k + 1);
        if (localObject1 == null) {
          break label572;
        }
        if (!((View)localObject1).getGlobalVisibleRect(this.rect)) {
          break label556;
        }
        if (!bool) {
          break label544;
        }
        k = this.rect.height();
        if (!bool) {
          break label562;
        }
        m = ((View)localObject1).getHeight();
        label389:
        j += m;
        Xa("findSnapView ignoreChild:" + localObject2 + " jumpIgnoreChild:" + localObject1);
        i += k;
        localObject2 = localObject1;
        label439:
        float f3 = i * 1.0F / j;
        f2 = f1;
        localObject1 = localObject3;
        if (f1 < f3)
        {
          f2 = f3;
          localObject1 = localObject2;
        }
        label470:
        if (n < i1) {
          break label575;
        }
      }
    }
    for (;;)
    {
      paramLayoutManager = (RecyclerView.LayoutManager)localObject1;
      break;
      i = this.rect.width();
      break label277;
      i = 0;
      break label277;
      label501:
      j = ((View)localObject2).getWidth();
      break label289;
      label511:
      if ((!this.Fwx) && (k - 1 >= 0))
      {
        localObject1 = paramLayoutManager.getChildAt(k - 1);
        break label346;
      }
      localObject1 = null;
      break label346;
      label544:
      k = this.rect.width();
      break label377;
      label556:
      k = 0;
      break label377;
      label562:
      m = ((View)localObject1).getWidth();
      break label389;
      label572:
      break label439;
      label575:
      k = n;
      f1 = f2;
      localObject3 = localObject1;
      break label67;
      label588:
      localObject1 = null;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(346566);
    if (paramRecyclerView != null)
    {
      Object localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(346566);
        throw paramRecyclerView;
      }
      localObject = (LinearLayoutManager)localObject;
      this.mkw = paramRecyclerView;
      this.AJH = ((LinearLayoutManager)localObject);
      paramRecyclerView.a((RecyclerView.l)new b(this, (LinearLayoutManager)localObject));
      RecyclerView.a locala = paramRecyclerView.getAdapter();
      if (locala != null) {
        locala.a((RecyclerView.c)new c(paramRecyclerView, this, (LinearLayoutManager)localObject));
      }
    }
    super.a(paramRecyclerView);
    AppMethodBeat.o(346566);
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(346603);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    kotlin.g.b.s.u(paramView, "targetView");
    int[] arrayOfInt = new int[2];
    androidx.recyclerview.widget.s locals;
    if (gI(paramView))
    {
      paramLayoutManager = paramView.getTag(a.e.finder_full_snap_ignore);
      locals = fbh();
      kotlin.g.b.s.s(locals, "verticalHelper");
      arrayOfInt[1] = b(paramView, locals);
      if ((paramLayoutManager == null) || (kotlin.g.b.s.p(paramLayoutManager, Boolean.TRUE))) {
        arrayOfInt[1] = 0;
      }
      paramView.setTag(a.e.finder_full_snap_ignore, Boolean.FALSE);
    }
    for (;;)
    {
      Xa("calculateDistanceToFinalSnap x:" + arrayOfInt[0] + " y:" + arrayOfInt[1]);
      AppMethodBeat.o(346603);
      return arrayOfInt;
      if (paramLayoutManager.canScrollHorizontally())
      {
        locals = (androidx.recyclerview.widget.s)this.FQL.getValue();
        kotlin.g.b.s.s(locals, "horizontalHelper");
        arrayOfInt[0] = b(paramView, locals);
      }
      for (;;)
      {
        if (!paramLayoutManager.canScrollVertically()) {
          break label208;
        }
        paramLayoutManager = fbh();
        kotlin.g.b.s.s(paramLayoutManager, "verticalHelper");
        arrayOfInt[1] = b(paramView, paramLayoutManager);
        break;
        arrayOfInt[0] = 0;
      }
      label208:
      arrayOfInt[1] = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.l
  {
    b(e parame, LinearLayoutManager paramLinearLayoutManager) {}
    
    private static final void a(e parame, RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(347594);
      kotlin.g.b.s.u(parame, "this$0");
      kotlin.g.b.s.u(paramRecyclerView, "$recyclerView");
      kotlin.g.b.s.u(paramLinearLayoutManager, "$layoutManager");
      e.a(parame, paramRecyclerView, paramLinearLayoutManager, false);
      AppMethodBeat.o(347594);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(347610);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.post(new e.b..ExternalSyntheticLambda0(this.FQN, paramRecyclerView, this.FQO));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(347610);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(347617);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      e.a(this.FQN, paramRecyclerView, this.FQO, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(347617);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$1$2", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.c
  {
    c(RecyclerView paramRecyclerView, e parame, LinearLayoutManager paramLinearLayoutManager) {}
    
    private static final void b(e parame, RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(347627);
      kotlin.g.b.s.u(parame, "this$0");
      kotlin.g.b.s.u(paramRecyclerView, "$it");
      kotlin.g.b.s.u(paramLinearLayoutManager, "$layoutManager");
      e.a(parame, paramRecyclerView, paramLinearLayoutManager, true);
      AppMethodBeat.o(347627);
    }
    
    private static final void c(e parame, RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(347633);
      kotlin.g.b.s.u(parame, "this$0");
      kotlin.g.b.s.u(paramRecyclerView, "$it");
      kotlin.g.b.s.u(paramLinearLayoutManager, "$layoutManager");
      e.a(parame, paramRecyclerView, paramLinearLayoutManager, true);
      AppMethodBeat.o(347633);
    }
    
    private static final void d(e parame, RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(347636);
      kotlin.g.b.s.u(parame, "this$0");
      kotlin.g.b.s.u(paramRecyclerView, "$it");
      kotlin.g.b.s.u(paramLinearLayoutManager, "$layoutManager");
      e.a(parame, paramRecyclerView, paramLinearLayoutManager, true);
      AppMethodBeat.o(347636);
    }
    
    private static final void e(e parame, RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(347639);
      kotlin.g.b.s.u(parame, "this$0");
      kotlin.g.b.s.u(paramRecyclerView, "$it");
      kotlin.g.b.s.u(paramLinearLayoutManager, "$layoutManager");
      e.a(parame, paramRecyclerView, paramLinearLayoutManager, true);
      AppMethodBeat.o(347639);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(347664);
      super.onChanged();
      this.BmL.postDelayed(new e.c..ExternalSyntheticLambda3(jdField_this, this.BmL, this.FQO), 600L);
      AppMethodBeat.o(347664);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(347670);
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      this.BmL.postDelayed(new e.c..ExternalSyntheticLambda0(jdField_this, this.BmL, this.FQO), 600L);
      AppMethodBeat.o(347670);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(347677);
      super.onItemRangeInserted(paramInt1, paramInt2);
      this.BmL.postDelayed(new e.c..ExternalSyntheticLambda1(jdField_this, this.BmL, this.FQO), 600L);
      AppMethodBeat.o(347677);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(347681);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      this.BmL.postDelayed(new e.c..ExternalSyntheticLambda2(jdField_this, this.BmL, this.FQO), 600L);
      AppMethodBeat.o(347681);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/OrientationHelper;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<androidx.recyclerview.widget.s>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/OrientationHelper;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<androidx.recyclerview.widget.s>
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
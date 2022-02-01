package com.tencent.mm.plugin.finder.record.plugin;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.r.a;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/record/plugin/PagerSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "context", "Landroid/content/Context;", "alignPoint", "", "(Landroid/content/Context;I)V", "getAlignPoint", "()I", "setAlignPoint", "(I)V", "getContext", "()Landroid/content/Context;", "mHorizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "selectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "createSnapScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "distanceToCenter", "helper", "findSelectView", "findSnapView", "getChildCenter", "getHorizontalHelper", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends p
{
  private int Fjk;
  b<? super Integer, ah> Fjl;
  private androidx.recyclerview.widget.s bYe;
  private final Context context;
  
  public d(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(337059);
    this.context = paramContext;
    this.Fjk = paramInt;
    AppMethodBeat.o(337059);
  }
  
  private final androidx.recyclerview.widget.s c(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(337066);
    if (this.bYe == null) {
      this.bYe = androidx.recyclerview.widget.s.d(paramLayoutManager);
    }
    paramLayoutManager = this.bYe;
    kotlin.g.b.s.checkNotNull(paramLayoutManager);
    AppMethodBeat.o(337066);
    return paramLayoutManager;
  }
  
  private static int gD(View paramView)
  {
    AppMethodBeat.i(337075);
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
      AppMethodBeat.o(337075);
      throw paramView;
    }
    localObject = (RecyclerView.LayoutParams)localObject;
    int i = paramView.getLeft();
    int j = ((RecyclerView.LayoutParams)localObject).leftMargin;
    int k = paramView.getRight();
    i = (((RecyclerView.LayoutParams)localObject).rightMargin + k + (i - j)) / 2;
    AppMethodBeat.o(337075);
    return i;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    View localView2 = null;
    View localView1 = null;
    AppMethodBeat.i(337093);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    c(paramLayoutManager);
    int i2 = paramLayoutManager.getChildCount();
    if (i2 == 0)
    {
      AppMethodBeat.o(337093);
      return null;
    }
    int m = 2147483647;
    int k;
    int j;
    int n;
    int i;
    if (i2 > 0)
    {
      k = 0;
      j = 0;
      n = k + 1;
      localView2 = paramLayoutManager.getChildAt(k);
      kotlin.g.b.s.checkNotNull(localView2);
      kotlin.g.b.s.s(localView2, "layoutManager.getChildAt(i)!!");
      int i1 = Math.abs(gD(localView2) - this.Fjk);
      i = m;
      if (i1 < m)
      {
        j = k;
        i = i1;
        localView1 = localView2;
      }
      if (n < i2) {}
    }
    for (;;)
    {
      Log.d("MicroMsg.FinderTemplateListPlugin", "findSelectView:" + j + " absClosest:" + i);
      AppMethodBeat.o(337093);
      return localView1;
      k = n;
      m = i;
      break;
      j = 0;
      i = m;
      localView1 = localView2;
    }
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(337085);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    kotlin.g.b.s.u(paramView, "targetView");
    int[] arrayOfInt = new int[2];
    c(paramLayoutManager);
    arrayOfInt[0] = (gD(paramView) - this.Fjk);
    arrayOfInt[1] = 0;
    Log.d("MicroMsg.FinderTemplateListPlugin", kotlin.g.b.s.X("calculateDistanceToFinalSnap :", Integer.valueOf(arrayOfInt[0])));
    if (arrayOfInt[0] == 0)
    {
      b localb = this.Fjl;
      if (localb != null) {
        localb.invoke(Integer.valueOf(paramLayoutManager.getPosition(paramView)));
      }
    }
    AppMethodBeat.o(337085);
    return arrayOfInt;
  }
  
  public final o f(final RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(337102);
    if (paramLayoutManager == null)
    {
      AppMethodBeat.o(337102);
      return null;
    }
    paramLayoutManager = (o)new a(this, paramLayoutManager, this.context);
    AppMethodBeat.o(337102);
    return paramLayoutManager;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/record/plugin/PagerSnapHelper$createSnapScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "calculateTimeForScrolling", "", "dx", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends o
  {
    a(d paramd, RecyclerView.LayoutManager paramLayoutManager, Context paramContext)
    {
      super();
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(336986);
      kotlin.g.b.s.u(paramView, "targetView");
      kotlin.g.b.s.u(params, "state");
      kotlin.g.b.s.u(parama, "action");
      paramView = this.Fjm.a(paramLayoutManager, paramView);
      int i = paramView[0];
      int j = paramView[1];
      int k = fO(Math.max(Math.abs(i), Math.abs(j)));
      if (k > 0) {
        parama.a(i, j, k, (Interpolator)this.bXY);
      }
      AppMethodBeat.o(336986);
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(336994);
      kotlin.g.b.s.u(paramDisplayMetrics, "displayMetrics");
      float f = 100.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(336994);
      return f;
    }
    
    public final int fP(int paramInt)
    {
      AppMethodBeat.i(337002);
      paramInt = k.qv(100, super.fP(paramInt));
      AppMethodBeat.o(337002);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.plugin.d
 * JD-Core Version:    0.7.0.1
 */
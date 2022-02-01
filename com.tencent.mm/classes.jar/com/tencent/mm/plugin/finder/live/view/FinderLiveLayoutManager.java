package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "getContext", "()Landroid/content/Context;", "enableExtraLayoutSpace", "getEnableExtraLayoutSpace", "()Z", "setEnableExtraLayoutSpace", "(Z)V", "extraLayoutSpace", "getExtraLayoutSpace", "()I", "setExtraLayoutSpace", "(I)V", "forceUpdateOnNextLayout", "onItemChecked", "Lkotlin/Function0;", "getOnItemChecked", "()Lkotlin/jvm/functions/Function0;", "setOnItemChecked", "(Lkotlin/jvm/functions/Function0;)V", "onItemSelected", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "reSelect", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function3;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function3;)V", "scrollState", "getScrollState", "setScrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "canScrollHorizontally", "canScrollVertically", "findSelectedChildIndex", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "isMeasurementUpToDate2", "childSize", "spec", "dimension", "measureChild", "widthUsed", "heightUsed", "measureChildWithMargins", "onLayoutCompleted", "onScrollStateChanged", "shouldMeasureChild2", "widthSpec", "heightSpec", "lp", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "supportsPredictiveItemAnimations", "updateSelectedChild", "force", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveLayoutManager
  extends LinearLayoutManager
{
  public static final FinderLiveLayoutManager.a DNR;
  private static final int DNW;
  private static final String TAG;
  private boolean DNS;
  public q<? super Integer, ? super View, ? super Boolean, ah> DNT;
  public kotlin.g.a.a<Boolean> DNU;
  private boolean DNV;
  public final Context context;
  public int dyP;
  private int dyx;
  private int xwJ;
  
  static
  {
    AppMethodBeat.i(357548);
    DNR = new FinderLiveLayoutManager.a((byte)0);
    TAG = "MicroMsg.FinderLiveLayoutManager";
    DNW = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_2A);
    AppMethodBeat.o(357548);
  }
  
  public FinderLiveLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt, false);
    AppMethodBeat.i(357499);
    this.context = paramContext;
    this.dyx = -1;
    paramContext = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jTm().bmg()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.DNV = bool;
      this.xwJ = (DNW + com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 1.0F));
      AppMethodBeat.o(357499);
      return;
    }
  }
  
  private final boolean a(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(357518);
    if ((paramView.isLayoutRequested()) || (!isMeasurementCacheEnabled()) || (!aC(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!aC(paramView.getHeight(), paramInt2, paramLayoutParams.height)))
    {
      AppMethodBeat.o(357518);
      return true;
    }
    AppMethodBeat.o(357518);
    return false;
  }
  
  private static boolean aC(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(357525);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((paramInt3 > 0) && (paramInt1 != paramInt3))
    {
      AppMethodBeat.o(357525);
      return false;
    }
    switch (i)
    {
    default: 
      AppMethodBeat.o(357525);
      return false;
    case 0: 
      AppMethodBeat.o(357525);
      return true;
    case -2147483648: 
      if (paramInt2 >= paramInt1)
      {
        AppMethodBeat.o(357525);
        return true;
      }
      AppMethodBeat.o(357525);
      return false;
    }
    if (paramInt2 == paramInt1)
    {
      AppMethodBeat.o(357525);
      return true;
    }
    AppMethodBeat.o(357525);
    return false;
  }
  
  private void ae(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(357504);
    View localView;
    if (getChildCount() == 1)
    {
      i = k;
      if (i >= 0)
      {
        localView = getChildAt(i);
        s.checkNotNull(localView);
        s.s(localView, "getChildAt(selectedChildIndex)!!");
        i = getPosition(localView);
        if ((i != this.dyx) || (paramBoolean1) || (paramBoolean2))
        {
          this.dyx = i;
          Log.i(TAG, s.X("selectedPosition:", Integer.valueOf(this.dyx)));
          q localq = this.DNT;
          if (localq != null) {
            localq.invoke(Integer.valueOf(this.dyx), localView, Boolean.valueOf(paramBoolean2));
          }
        }
      }
      AppMethodBeat.o(357504);
      return;
    }
    int m;
    if (super.canScrollHorizontally())
    {
      k = getWidth() / 2;
      m = getChildCount();
      if (m <= 0) {
        break label302;
      }
    }
    for (;;)
    {
      j = i + 1;
      localView = getChildAt(i);
      s.checkNotNull(localView);
      int n = localView.getLeft();
      localView = getChildAt(i);
      s.checkNotNull(localView);
      if ((n + localView.getRight()) / 2 == k) {
        break;
      }
      if (j >= m)
      {
        i = -1;
        break;
        k = getHeight() / 2;
        m = getChildCount();
        if (m > 0) {}
        for (i = j;; i = j)
        {
          j = i + 1;
          localView = getChildAt(i);
          s.checkNotNull(localView);
          n = localView.getTop();
          localView = getChildAt(i);
          s.checkNotNull(localView);
          if ((n + localView.getBottom()) / 2 == k) {
            break;
          }
          if (j >= m)
          {
            label302:
            i = -1;
            break;
          }
        }
      }
      i = j;
    }
  }
  
  public final int b(RecyclerView.s params)
  {
    AppMethodBeat.i(357590);
    if (this.DNV)
    {
      if (this.xwJ == -1)
      {
        i = super.b(params);
        AppMethodBeat.o(357590);
        return i;
      }
      i = this.xwJ;
      AppMethodBeat.o(357590);
      return i;
    }
    int i = super.b(params);
    AppMethodBeat.o(357590);
    return i;
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(357581);
    boolean bool = super.canScrollHorizontally();
    AppMethodBeat.o(357581);
    return bool;
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(357576);
    if ((getOrientation() == 1) && (this.context.getResources().getConfiguration().orientation == 1))
    {
      AppMethodBeat.o(357576);
      return true;
    }
    AppMethodBeat.o(357576);
    return false;
  }
  
  public final void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(357596);
    s.u(paramView, "child");
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
      AppMethodBeat.o(357596);
      throw paramView;
    }
    localObject = (RecyclerView.LayoutParams)localObject;
    calculateItemDecorationsForChild(paramView, new Rect());
    paramInt1 = LinearLayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + paramInt1, ((RecyclerView.LayoutParams)localObject).width, canScrollHorizontally());
    paramInt2 = LinearLayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + paramInt2, ((RecyclerView.LayoutParams)localObject).height, canScrollVertically());
    if (a(paramView, paramInt1, paramInt2, (RecyclerView.LayoutParams)localObject)) {
      paramView.measure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(357596);
  }
  
  public final void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(357604);
    s.u(paramView, "child");
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
      AppMethodBeat.o(357604);
      throw paramView;
    }
    localObject = (RecyclerView.LayoutParams)localObject;
    calculateItemDecorationsForChild(paramView, new Rect());
    paramInt1 = LinearLayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((RecyclerView.LayoutParams)localObject).leftMargin + ((RecyclerView.LayoutParams)localObject).rightMargin + paramInt1, ((RecyclerView.LayoutParams)localObject).width, canScrollHorizontally());
    paramInt2 = LinearLayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((RecyclerView.LayoutParams)localObject).topMargin + ((RecyclerView.LayoutParams)localObject).bottomMargin + paramInt2, ((RecyclerView.LayoutParams)localObject).height, canScrollVertically());
    if (a(paramView, paramInt1, paramInt2, (RecyclerView.LayoutParams)localObject)) {
      paramView.measure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(357604);
  }
  
  public final void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(357553);
    super.onLayoutCompleted(params);
    com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(357553);
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(357564);
    super.onScrollStateChanged(paramInt);
    this.dyP = paramInt;
    if (this.dyP == 0)
    {
      kotlin.g.a.a locala = this.DNU;
      if (locala != null)
      {
        boolean bool = ((Boolean)locala.invoke()).booleanValue();
        Log.i(TAG, s.X("isNeedCheck = ", Boolean.valueOf(bool)));
        if (!bool) {
          break label93;
        }
        a(this, true, false, 2);
      }
    }
    for (;;)
    {
      if (this.DNU == null) {
        a(this, false, false, 3);
      }
      AppMethodBeat.o(357564);
      return;
      label93:
      a(this, false, false, 3);
    }
  }
  
  public final boolean supportsPredictiveItemAnimations()
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(FinderLiveLayoutManager paramFinderLiveLayoutManager)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveLayoutManager
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.event.recyclerview;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "isDragging", "", "()Z", "isFakeDragging", "isIdle", "isInAnyDraggingState", "isRtl", "mAdapterState", "", "getMAdapterState$annotations", "()V", "mDataSetChangeHappened", "mDispatchSelected", "mDragStartPosition", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mOnPageChangeCallback", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$OnPageChangeCallback;", "mScrollHappened", "mScrollState", "mScrollValues", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter$ScrollEventValues;", "mTarget", "position", "getPosition", "()I", "relativeScrollPosition", "", "getRelativeScrollPosition", "()D", "dispatchScrolled", "", "offset", "", "offsetPx", "dispatchSelected", "target", "dispatchStateChanged", "state", "getScrollState", "notifyBeginFakeDrag", "notifyDataSetChangeHappened", "notifyEndFakeDrag", "notifyProgrammaticScroll", "smooth", "onScrollStateChanged", "recyclerView", "newState", "onScrolled", "dx", "dy", "resetState", "setOnPageChangeCallback", "callback", "startDrag", "isFakeDrag", "updateScrollEventValues", "AdapterState", "Companion", "ScrollEventValues", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.l
{
  public static final b.a AOL;
  FinderRecyclerView.b AOM;
  private int AON;
  private final b AOO;
  private int AOP;
  private int AOQ;
  private boolean AOR;
  private boolean AOS;
  private boolean AOT;
  private boolean AOU;
  private final RecyclerView mRecyclerView;
  int mScrollState;
  private final LinearLayoutManager uQP;
  
  static
  {
    AppMethodBeat.i(330445);
    AOL = new b.a((byte)0);
    AppMethodBeat.o(330445);
  }
  
  public b(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(330397);
    this.mRecyclerView = paramRecyclerView;
    paramRecyclerView = (LinearLayoutManager)this.mRecyclerView.getLayoutManager();
    s.checkNotNull(paramRecyclerView);
    this.uQP = paramRecyclerView;
    this.AOO = new b();
    Oi();
    AppMethodBeat.o(330397);
  }
  
  private final void No(int paramInt)
  {
    AppMethodBeat.i(330420);
    if ((this.AON == 3) && (this.mScrollState == 0))
    {
      AppMethodBeat.o(330420);
      return;
    }
    if (this.mScrollState == paramInt)
    {
      AppMethodBeat.o(330420);
      return;
    }
    this.mScrollState = paramInt;
    if (this.AOM != null)
    {
      FinderRecyclerView.b localb = this.AOM;
      s.checkNotNull(localb);
      localb.k(this.mRecyclerView, paramInt);
    }
    AppMethodBeat.o(330420);
  }
  
  private final void Np(int paramInt)
  {
    AppMethodBeat.i(330428);
    if (this.AOM != null)
    {
      FinderRecyclerView.b localb = this.AOM;
      s.checkNotNull(localb);
      localb.j(this.mRecyclerView, paramInt);
    }
    AppMethodBeat.o(330428);
  }
  
  private final void Oi()
  {
    AppMethodBeat.i(330402);
    this.AON = 0;
    this.mScrollState = 0;
    this.AOO.reset();
    this.AOP = -1;
    this.AOQ = -1;
    this.AOR = false;
    this.AOS = false;
    this.AOU = false;
    this.AOT = false;
    AppMethodBeat.o(330402);
  }
  
  private final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(330438);
    if (this.AOM != null)
    {
      FinderRecyclerView.b localb = this.AOM;
      s.checkNotNull(localb);
      localb.a(this.mRecyclerView, paramInt1, paramFloat, paramInt2);
    }
    AppMethodBeat.o(330438);
  }
  
  private final void dYT()
  {
    AppMethodBeat.i(330413);
    Object localObject1 = this.AOO;
    ((b)localObject1).mPosition = this.uQP.Ju();
    if (((b)localObject1).mPosition == -1)
    {
      ((b)localObject1).reset();
      AppMethodBeat.o(330413);
      return;
    }
    Object localObject2 = this.uQP.findViewByPosition(((b)localObject1).mPosition);
    if (localObject2 == null)
    {
      ((b)localObject1).reset();
      AppMethodBeat.o(330413);
      return;
    }
    int k = this.uQP.getLeftDecorationWidth((View)localObject2);
    int m = this.uQP.getRightDecorationWidth((View)localObject2);
    int j = this.uQP.getTopDecorationHeight((View)localObject2);
    int i = this.uQP.getBottomDecorationHeight((View)localObject2);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
    int n;
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      k += ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin;
      m += ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin;
      n = ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin;
      i = ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin + i;
      j += n;
    }
    for (;;)
    {
      int i1 = ((View)localObject2).getHeight();
      n = ((View)localObject2).getWidth() + k + m;
      if (this.uQP.getOrientation() == 0)
      {
        m = 1;
        if (m == 0) {
          break label335;
        }
        j = ((View)localObject2).getLeft() - k - this.mRecyclerView.getPaddingLeft();
        i = n;
        label240:
        ((b)localObject1).AOW = (-j);
        if (((b)localObject1).AOW < 0) {
          break label365;
        }
      }
      label335:
      label365:
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label370;
        }
        localObject2 = am.aixg;
        localObject1 = String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Arrays.copyOf(new Object[] { Integer.valueOf(((b)localObject1).AOW) }, 1));
        s.s(localObject1, "java.lang.String.format(locale, format, *args)");
        localObject1 = (Throwable)new IllegalStateException(localObject1.toString());
        AppMethodBeat.o(330413);
        throw ((Throwable)localObject1);
        m = 0;
        break;
        k = ((View)localObject2).getTop() - j - this.mRecyclerView.getPaddingTop();
        i = i1 + j + i;
        j = k;
        break label240;
      }
      label370:
      if (i == 0) {}
      for (float f = 0.0F;; f = ((b)localObject1).AOW / i)
      {
        ((b)localObject1).AOV = f;
        AppMethodBeat.o(330413);
        return;
      }
    }
  }
  
  private final boolean dYU()
  {
    return (this.AON == 1) || (this.AON == 4);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(330456);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt);
    a.c("com/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
    s.u(paramRecyclerView, "recyclerView");
    if (((this.AON != 1) || (this.mScrollState != 1)) && (paramInt == 1))
    {
      this.AOU = false;
      this.AON = 1;
      if (this.AOQ != -1)
      {
        this.AOP = this.AOQ;
        this.AOQ = -1;
      }
      for (;;)
      {
        No(1);
        a.a(this, "com/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(330456);
        return;
        if (this.AOP == -1) {
          this.AOP = this.uQP.Ju();
        }
      }
    }
    if ((dYU()) && (paramInt == 2))
    {
      if (this.AOS)
      {
        No(2);
        this.AOR = true;
      }
      a.a(this, "com/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(330456);
      return;
    }
    int i;
    if ((dYU()) && (paramInt == 0))
    {
      dYT();
      if (this.AOS) {
        break label367;
      }
      if (this.AOO.mPosition != -1) {
        a(this.AOO.mPosition, 0.0F, 0);
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        No(0);
        Oi();
      }
      if ((this.AON == 2) && (paramInt == 0) && (this.AOT))
      {
        dYT();
        if (this.AOO.AOW == 0) {
          if (this.AOQ != this.AOO.mPosition) {
            if (this.AOO.mPosition != -1) {
              break label407;
            }
          }
        }
      }
      label407:
      for (paramInt = 0;; paramInt = this.AOO.mPosition)
      {
        Np(paramInt);
        No(0);
        Oi();
        a.a(this, "com/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(330456);
        return;
        label367:
        if (this.AOO.AOW != 0) {
          break label418;
        }
        if (this.AOP != this.AOO.mPosition) {
          Np(this.AOO.mPosition);
        }
        i = 1;
        break;
      }
      label418:
      i = 0;
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(330466);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    a.c("com/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    s.u(paramRecyclerView, "recyclerView");
    this.AOS = true;
    dYT();
    if (this.AOR)
    {
      this.AOR = false;
      if (paramInt2 <= 0)
      {
        if (paramInt2 != 0) {
          break label261;
        }
        if (paramInt1 < 0)
        {
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label261;
          }
        }
      }
      else
      {
        paramInt1 = 1;
        label102:
        if ((paramInt1 == 0) || (this.AOO.AOW == 0)) {
          break label266;
        }
        paramInt1 = this.AOO.mPosition + 1;
        label126:
        this.AOQ = paramInt1;
        if (this.AOP != this.AOQ)
        {
          paramInt1 = this.AOQ;
          label147:
          Np(paramInt1);
        }
        label152:
        if (this.AOO.mPosition != -1) {
          break label305;
        }
      }
    }
    label261:
    label266:
    label305:
    for (paramInt1 = 0;; paramInt1 = this.AOO.mPosition)
    {
      a(paramInt1, this.AOO.AOV, this.AOO.AOW);
      if (((this.AOO.mPosition == this.AOQ) || (this.AOQ == -1)) && (this.AOO.AOW == 0) && (this.mScrollState != 1))
      {
        No(0);
        Oi();
      }
      a.a(this, "com/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(330466);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = 0;
      break label102;
      paramInt1 = this.AOO.mPosition;
      break label126;
      if (this.AON != 0) {
        break label152;
      }
      paramInt1 = this.AOO.mPosition;
      if (paramInt1 == -1)
      {
        paramInt1 = 0;
        break label147;
      }
      break label147;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter$ScrollEventValues;", "", "()V", "mOffset", "", "getMOffset", "()F", "setMOffset", "(F)V", "mOffsetPx", "", "getMOffsetPx", "()I", "setMOffsetPx", "(I)V", "mPosition", "getMPosition", "setMPosition", "reset", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    float AOV;
    int AOW;
    int mPosition;
    
    public final void reset()
    {
      this.mPosition = -1;
      this.AOV = 0.0F;
      this.AOW = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.recyclerview.b
 * JD-Core Version:    0.7.0.1
 */
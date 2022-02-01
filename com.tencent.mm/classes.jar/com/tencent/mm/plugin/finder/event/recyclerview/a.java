package com.tencent.mm.plugin.finder.event.recyclerview;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.Arrays;
import java.util.Locale;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "isDragging", "", "()Z", "isFakeDragging", "isIdle", "isInAnyDraggingState", "isRtl", "mAdapterState", "", "mAdapterState$annotations", "()V", "mDataSetChangeHappened", "mDispatchSelected", "mDragStartPosition", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mOnPageChangeCallback", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$OnPageChangeCallback;", "mScrollHappened", "mScrollState", "mScrollValues", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter$ScrollEventValues;", "mTarget", "position", "getPosition", "()I", "relativeScrollPosition", "", "getRelativeScrollPosition", "()D", "dispatchScrolled", "", "offset", "", "offsetPx", "dispatchSelected", "target", "dispatchStateChanged", "state", "getScrollState", "notifyBeginFakeDrag", "notifyDataSetChangeHappened", "notifyEndFakeDrag", "notifyProgrammaticScroll", "smooth", "onScrollStateChanged", "recyclerView", "newState", "onScrolled", "dx", "dy", "resetState", "setOnPageChangeCallback", "callback", "startDrag", "isFakeDrag", "updateScrollEventValues", "AdapterState", "Companion", "ScrollEventValues", "plugin-finder-base_release"})
public final class a
  extends RecyclerView.l
{
  public static final a xrK;
  private final RecyclerView mRecyclerView;
  int mScrollState;
  private final LinearLayoutManager rFD;
  FinderRecyclerView.b xrB;
  private int xrC;
  private final b xrD;
  private int xrE;
  private int xrF;
  private boolean xrG;
  private boolean xrH;
  private boolean xrI;
  private boolean xrJ;
  
  static
  {
    AppMethodBeat.i(263809);
    xrK = new a((byte)0);
    AppMethodBeat.o(263809);
  }
  
  public a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(263808);
    this.mRecyclerView = paramRecyclerView;
    paramRecyclerView = (LinearLayoutManager)this.mRecyclerView.getLayoutManager();
    if (paramRecyclerView == null) {
      p.iCn();
    }
    this.rFD = paramRecyclerView;
    this.xrD = new b();
    oA();
    AppMethodBeat.o(263808);
  }
  
  private final void Mj(int paramInt)
  {
    AppMethodBeat.i(263804);
    if ((this.xrC == 3) && (this.mScrollState == 0))
    {
      AppMethodBeat.o(263804);
      return;
    }
    if (this.mScrollState == paramInt)
    {
      AppMethodBeat.o(263804);
      return;
    }
    this.mScrollState = paramInt;
    if (this.xrB != null)
    {
      FinderRecyclerView.b localb = this.xrB;
      if (localb == null) {
        p.iCn();
      }
      localb.i(this.mRecyclerView, paramInt);
    }
    AppMethodBeat.o(263804);
  }
  
  private final void Mk(int paramInt)
  {
    AppMethodBeat.i(263805);
    if (this.xrB != null)
    {
      FinderRecyclerView.b localb = this.xrB;
      if (localb == null) {
        p.iCn();
      }
      localb.h(this.mRecyclerView, paramInt);
    }
    AppMethodBeat.o(263805);
  }
  
  private final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(263807);
    if (this.xrB != null)
    {
      FinderRecyclerView.b localb = this.xrB;
      if (localb == null) {
        p.iCn();
      }
      localb.a(this.mRecyclerView, paramInt1, paramFloat, paramInt2);
    }
    AppMethodBeat.o(263807);
  }
  
  private final void dqo()
  {
    AppMethodBeat.i(263802);
    Object localObject1 = this.xrD;
    ((b)localObject1).mPosition = this.rFD.kJ();
    if (((b)localObject1).mPosition == -1)
    {
      ((b)localObject1).reset();
      AppMethodBeat.o(263802);
      return;
    }
    Object localObject2 = this.rFD.findViewByPosition(((b)localObject1).mPosition);
    if (localObject2 == null)
    {
      ((b)localObject1).reset();
      AppMethodBeat.o(263802);
      return;
    }
    int k = this.rFD.getLeftDecorationWidth((View)localObject2);
    int m = this.rFD.getRightDecorationWidth((View)localObject2);
    int j = this.rFD.getTopDecorationHeight((View)localObject2);
    int i = this.rFD.getBottomDecorationHeight((View)localObject2);
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
      if (this.rFD.getOrientation() == 0)
      {
        m = 1;
        if (m == 0) {
          break label345;
        }
        j = ((View)localObject2).getLeft() - k - this.mRecyclerView.getPaddingLeft();
        i = n;
        label240:
        ((b)localObject1).xrM = (-j);
        if (((b)localObject1).xrM < 0) {
          break label375;
        }
      }
      label345:
      label375:
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label380;
        }
        localObject2 = af.aaBG;
        localObject2 = Locale.US;
        p.j(localObject2, "Locale.US");
        localObject1 = String.format((Locale)localObject2, "Page can only be offset by a positive amount, not by %d", Arrays.copyOf(new Object[] { Integer.valueOf(((b)localObject1).xrM) }, 1));
        p.j(localObject1, "java.lang.String.format(locale, format, *args)");
        localObject1 = (Throwable)new IllegalStateException(localObject1.toString());
        AppMethodBeat.o(263802);
        throw ((Throwable)localObject1);
        m = 0;
        break;
        k = ((View)localObject2).getTop() - j - this.mRecyclerView.getPaddingTop();
        i = i1 + j + i;
        j = k;
        break label240;
      }
      label380:
      if (i == 0) {}
      for (float f = 0.0F;; f = ((b)localObject1).xrM / i)
      {
        ((b)localObject1).xrL = f;
        AppMethodBeat.o(263802);
        return;
      }
    }
  }
  
  private final boolean dqp()
  {
    return (this.xrC == 1) || (this.xrC == 4);
  }
  
  private final void oA()
  {
    AppMethodBeat.i(263796);
    this.xrC = 0;
    this.mScrollState = 0;
    this.xrD.reset();
    this.xrE = -1;
    this.xrF = -1;
    this.xrG = false;
    this.xrH = false;
    this.xrJ = false;
    this.xrI = false;
    AppMethodBeat.o(263796);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(263800);
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
    p.k(paramRecyclerView, "recyclerView");
    if (((this.xrC != 1) || (this.mScrollState != 1)) && (paramInt == 1))
    {
      this.xrJ = false;
      this.xrC = 1;
      if (this.xrF != -1)
      {
        this.xrE = this.xrF;
        this.xrF = -1;
      }
      for (;;)
      {
        Mj(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(263800);
        return;
        if (this.xrE == -1) {
          this.xrE = this.rFD.kJ();
        }
      }
    }
    if ((dqp()) && (paramInt == 2))
    {
      if (this.xrH)
      {
        Mj(2);
        this.xrG = true;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(263800);
      return;
    }
    int i;
    if ((dqp()) && (paramInt == 0))
    {
      dqo();
      if (this.xrH) {
        break label367;
      }
      if (this.xrD.mPosition != -1) {
        a(this.xrD.mPosition, 0.0F, 0);
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        Mj(0);
        oA();
      }
      if ((this.xrC == 2) && (paramInt == 0) && (this.xrI))
      {
        dqo();
        if (this.xrD.xrM == 0) {
          if (this.xrF != this.xrD.mPosition) {
            if (this.xrD.mPosition != -1) {
              break label407;
            }
          }
        }
      }
      label407:
      for (paramInt = 0;; paramInt = this.xrD.mPosition)
      {
        Mk(paramInt);
        Mj(0);
        oA();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(263800);
        return;
        label367:
        if (this.xrD.xrM != 0) {
          break label418;
        }
        if (this.xrE != this.xrD.mPosition) {
          Mk(this.xrD.mPosition);
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
    AppMethodBeat.i(263801);
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt1);
    localb.sg(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
    p.k(paramRecyclerView, "recyclerView");
    this.xrH = true;
    dqo();
    if (this.xrG)
    {
      this.xrG = false;
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
        if ((paramInt1 == 0) || (this.xrD.xrM == 0)) {
          break label266;
        }
        paramInt1 = this.xrD.mPosition + 1;
        label126:
        this.xrF = paramInt1;
        if (this.xrE != this.xrF)
        {
          paramInt1 = this.xrF;
          label147:
          Mk(paramInt1);
        }
        label152:
        if (this.xrD.mPosition != -1) {
          break label305;
        }
      }
    }
    label261:
    label266:
    label305:
    for (paramInt1 = 0;; paramInt1 = this.xrD.mPosition)
    {
      a(paramInt1, this.xrD.xrL, this.xrD.xrM);
      if (((this.xrD.mPosition == this.xrF) || (this.xrF == -1)) && (this.xrD.xrM == 0) && (this.mScrollState != 1))
      {
        Mj(0);
        oA();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(263801);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = 0;
      break label102;
      paramInt1 = this.xrD.mPosition;
      break label126;
      if (this.xrC != 0) {
        break label152;
      }
      paramInt1 = this.xrD.mPosition;
      if (paramInt1 == -1)
      {
        paramInt1 = 0;
        break label147;
      }
      break label147;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter$Companion;", "", "()V", "NO_POSITION", "", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_IDLE", "SCROLL_STATE_SETTLING", "STATE_IDLE", "STATE_IN_PROGRESS_FAKE_DRAG", "STATE_IN_PROGRESS_IMMEDIATE_SCROLL", "STATE_IN_PROGRESS_MANUAL_DRAG", "STATE_IN_PROGRESS_SMOOTH_SCROLL", "plugin-finder-base_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter$ScrollEventValues;", "", "()V", "mOffset", "", "getMOffset", "()F", "setMOffset", "(F)V", "mOffsetPx", "", "getMOffsetPx", "()I", "setMOffsetPx", "(I)V", "mPosition", "getMPosition", "setMPosition", "reset", "", "plugin-finder-base_release"})
  static final class b
  {
    int mPosition;
    float xrL;
    int xrM;
    
    public final void reset()
    {
      this.mPosition = -1;
      this.xrL = 0.0F;
      this.xrM = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.recyclerview.a
 * JD-Core Version:    0.7.0.1
 */
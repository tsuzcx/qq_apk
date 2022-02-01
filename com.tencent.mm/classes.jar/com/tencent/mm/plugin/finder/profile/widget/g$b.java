package com.tencent.mm.plugin.finder.profile.widget;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.q;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$CustomOnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "(Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget;)V", "MAX_SCROLL_DISTANCE", "", "isCheck", "", "()Z", "setCheck", "(Z)V", "isNeedIntercept", "setNeedIntercept", "mDownX", "getMDownX", "()F", "setMDownX", "(F)V", "mDownY", "getMDownY", "setMDownY", "clearStatus", "", "flingLidView", "distance", "h", "Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter$ItemHolder;", "Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget;", "makeAllLidViewToDefault", "onInterceptTouchEvent", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "scrollLidView", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$b
  extends RecyclerView.q
{
  private boolean FhA;
  private final float Fhz;
  private float puO;
  private float puP;
  private boolean tGP;
  
  public g$b()
  {
    AppMethodBeat.i(349188);
    this.Fhz = d.e(this.FhB.context, -138.0F);
    AppMethodBeat.o(349188);
  }
  
  private final void a(float paramFloat, g.c.a parama)
  {
    AppMethodBeat.i(349195);
    paramFloat = Math.max(Math.min(paramFloat, 0.0F), this.Fhz);
    parama.FhC.setTranslationX(paramFloat);
    AppMethodBeat.o(349195);
  }
  
  private static final void a(b paramb, RecyclerView.v paramv, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(349216);
    s.u(paramb, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(349216);
      throw paramb;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    s.s(paramv, "viewHolder");
    paramb.a(f, (g.c.a)paramv);
    AppMethodBeat.o(349216);
  }
  
  private static final void a(b paramb, g.c.a parama, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(349210);
    s.u(paramb, "this$0");
    s.u(parama, "$h");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(349210);
      throw paramb;
    }
    paramb.a(((Float)paramValueAnimator).floatValue(), parama);
    AppMethodBeat.o(349210);
  }
  
  private final void eKT()
  {
    this.puO = 0.0F;
    this.puP = 0.0F;
    this.tGP = false;
    this.FhA = false;
  }
  
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(349255);
    s.u(paramRecyclerView, "rv");
    s.u(paramMotionEvent, "e");
    super.a(paramRecyclerView, paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.FhA;
      AppMethodBeat.o(349255);
      return bool;
      this.puO = paramMotionEvent.getX();
      this.puP = paramMotionEvent.getY();
      continue;
      if (!this.tGP)
      {
        this.tGP = true;
        if (Math.abs(paramMotionEvent.getX() - this.puO) > Math.abs(paramMotionEvent.getY() - this.puP))
        {
          this.FhA = true;
        }
        else
        {
          eKS();
          continue;
          eKT();
        }
      }
    }
  }
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(349245);
    s.u(paramRecyclerView, "rv");
    s.u(paramMotionEvent, "e");
    super.b(paramRecyclerView, paramMotionEvent);
    paramRecyclerView = g.c(this.FhB);
    RecyclerView localRecyclerView;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.Q(this.puO, this.puP);
      if (paramRecyclerView != null)
      {
        localRecyclerView = g.c(this.FhB);
        if (localRecyclerView != null) {
          break label114;
        }
        paramRecyclerView = null;
        if (!(paramRecyclerView instanceof g.c.a)) {}
      }
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 2: 
      label114:
      do
      {
        AppMethodBeat.o(349245);
        return;
        paramRecyclerView = localRecyclerView.bj(paramRecyclerView);
        break;
      } while ((!this.tGP) || (!this.FhA));
      a(paramMotionEvent.getX() - this.puO, (g.c.a)paramRecyclerView);
      AppMethodBeat.o(349245);
      return;
    }
    float f2 = paramMotionEvent.getX();
    float f3 = this.puO;
    paramRecyclerView = (g.c.a)paramRecyclerView;
    f2 = Math.max(Math.min(f2 - f3, 0.0F), this.Fhz);
    if (f2 < this.Fhz / 2.0F) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        f1 = this.Fhz;
      }
      paramMotionEvent = ValueAnimator.ofFloat(new float[] { f2, f1 });
      s.s(paramMotionEvent, "ofFloat(from, to)");
      paramMotionEvent.setDuration(400L);
      paramMotionEvent.addUpdateListener(new g.b..ExternalSyntheticLambda1(this, paramRecyclerView));
      paramMotionEvent.start();
      eKT();
      break;
    }
  }
  
  public final void eKS()
  {
    AppMethodBeat.i(349267);
    RecyclerView localRecyclerView = g.c(this.FhB);
    int k;
    if (localRecyclerView != null)
    {
      k = localRecyclerView.getChildCount();
      if (k <= 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      RecyclerView.v localv = localRecyclerView.bj(localRecyclerView.getChildAt(i));
      if ((localv instanceof g.c.a))
      {
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { ((g.c.a)localv).FhC.getTranslationX(), 0.0F });
        s.s(localValueAnimator, "ofFloat(viewHolder.parentLid.translationX, 0f)");
        localValueAnimator.setDuration(400L);
        localValueAnimator.addUpdateListener(new g.b..ExternalSyntheticLambda0(this, localv));
        localValueAnimator.start();
      }
      if (j >= k)
      {
        AppMethodBeat.o(349267);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.widget.g.b
 * JD-Core Version:    0.7.0.1
 */
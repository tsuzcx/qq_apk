package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.List;

public final class d<T extends RecyclerView.v>
  extends b<T>
{
  private int bPt = 0;
  FrameLayout cJp;
  private int endPos = 0;
  private List rbc;
  public g rqJ = null;
  public a rqV;
  private Object rqW;
  private e rqX;
  private View rqz;
  
  public d(FrameLayout paramFrameLayout, List paramList, e parame)
  {
    this.cJp = paramFrameLayout;
    this.rbc = paramList;
    this.rqX = parame;
  }
  
  public final boolean Q(T paramT)
  {
    AppMethodBeat.i(242484);
    if (this.rqV != null)
    {
      boolean bool = this.rqV.Q(paramT);
      AppMethodBeat.o(242484);
      return bool;
    }
    if (paramT == null)
    {
      AppMethodBeat.o(242484);
      return false;
    }
    AppMethodBeat.o(242484);
    return true;
  }
  
  public final boolean S(T paramT)
  {
    AppMethodBeat.i(242492);
    if (this.rqV != null)
    {
      boolean bool = this.rqV.R(paramT);
      AppMethodBeat.o(242492);
      return bool;
    }
    AppMethodBeat.o(242492);
    return true;
  }
  
  public final void T(T paramT)
  {
    AppMethodBeat.i(242497);
    Log.i("MicroMsg.ItemMoveHelper", "alvinluo onStar adapter position: %d", new Object[] { Integer.valueOf(paramT.md()) });
    if ((paramT instanceof com.tencent.mm.plugin.appbrand.widget.desktop.d)) {
      Log.i("MicroMsg.ItemMoveHelper", "alvinluo onStar holder: %s", new Object[] { ((com.tencent.mm.plugin.appbrand.widget.desktop.d)paramT).titleTv.getText() });
    }
    if (this.rqV != null) {
      this.rqV.cS(this.rqW);
    }
    AppMethodBeat.o(242497);
  }
  
  public final void a(RecyclerView paramRecyclerView, T paramT, int paramInt, boolean paramBoolean1, boolean paramBoolean2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(242495);
    if (this.rqV != null) {
      this.rqV.U(paramInt, paramBoolean1);
    }
    final RecyclerView.v localv;
    float f2;
    float f1;
    if (paramBoolean2)
    {
      paramRunnable = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49838);
          if (d.a(d.this) != null)
          {
            a locala = d.a(d.this);
            d.b(d.this);
            locala.f(d.c(d.this), d.d(d.this), d.e(d.this));
          }
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(49838);
        }
      };
      if ((paramT != null) && (this.rqz != null))
      {
        Log.i("ItemMoveHelper", "[finishMove] position" + paramT.md() + " dragViewPosition:" + paramInt);
        localv = paramRecyclerView.cK(paramInt);
        f2 = this.rqz.getTranslationX();
        f1 = this.rqz.getTranslationY();
        if ((paramInt == paramT.md()) || (localv != null)) {
          break label257;
        }
        if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).kJ() <= paramInt) {
          break label244;
        }
        f1 -= paramRecyclerView.getHeight();
      }
    }
    for (;;)
    {
      paramT = this.rqX.dk(this.rqz);
      paramRecyclerView = paramT;
      if (paramT == null) {
        paramRecyclerView = this.rqz;
      }
      paramRecyclerView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
      this.rqz.animate().translationX(f2).translationY(f1).setDuration(300L).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49839);
          d.this.cJp.removeView(d.b(d.this));
          d.b(d.this).setVisibility(8);
          if (localv != null) {
            localv.amk.setVisibility(0);
          }
          paramRunnable.run();
          AppMethodBeat.o(49839);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      AppMethodBeat.o(242495);
      return;
      label244:
      f1 = paramRecyclerView.getHeight() + f1;
      continue;
      label257:
      if (localv != null)
      {
        label273:
        float f3;
        if (!(localv instanceof com.tencent.mm.plugin.appbrand.widget.desktop.d))
        {
          f1 = 0.0F;
          f3 = this.rqX.cno();
          if ((localv instanceof com.tencent.mm.plugin.appbrand.widget.desktop.d)) {
            break label367;
          }
        }
        int[] arrayOfInt;
        for (f2 = 0.0F;; f2 = arrayOfInt[1] + com.tencent.mm.plugin.appbrand.widget.desktop.b.ey(paramRecyclerView.getContext()) / 2.0F)
        {
          f2 += this.rqX.cnp();
          f3 += f1;
          f1 = f2;
          f2 = f3;
          break;
          paramT = ((com.tencent.mm.plugin.appbrand.widget.desktop.d)localv).qps;
          arrayOfInt = new int[2];
          paramT.getLocationOnScreen(arrayOfInt);
          f1 = arrayOfInt[0] + com.tencent.mm.plugin.appbrand.widget.desktop.b.ey(paramRecyclerView.getContext()) / 2.0F;
          break label273;
          label367:
          paramT = ((com.tencent.mm.plugin.appbrand.widget.desktop.d)localv).qps;
          arrayOfInt = new int[2];
          paramT.getLocationOnScreen(arrayOfInt);
        }
      }
    }
  }
  
  public final boolean a(RecyclerView paramRecyclerView, T paramT1, T paramT2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242494);
    Log.i("MicroMsg.ItemMoveHelper", "[onMoved] position:" + paramT1.md() + " target:" + paramT2.md());
    Log.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved mList: %d", new Object[] { Integer.valueOf(this.rbc.hashCode()) });
    if ((paramInt1 < 0) || (paramInt1 >= this.rbc.size()) || (paramInt2 < 0) || (paramInt2 >= this.rbc.size()))
    {
      AppMethodBeat.o(242494);
      return false;
    }
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      while (i < paramInt2)
      {
        Collections.swap(this.rbc, i, i + 1);
        i += 1;
      }
    }
    int i = paramInt1;
    while (i > paramInt2)
    {
      Collections.swap(this.rbc, i, i - 1);
      i -= 1;
    }
    Log.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved end mList: %d", new Object[] { Integer.valueOf(this.rbc.hashCode()) });
    paramRecyclerView.getAdapter().aF(paramInt1, paramInt2);
    if (this.rqX != null) {
      this.endPos = paramInt2;
    }
    paramRecyclerView.getAdapter().e(0, paramRecyclerView.getAdapter().getItemCount(), Boolean.TRUE);
    AppMethodBeat.o(242494);
    return true;
  }
  
  public final void b(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(242496);
    if (paramView == null)
    {
      AppMethodBeat.o(242496);
      return;
    }
    paramView.setTranslationX(paramView.getTranslationX() - paramFloat1);
    paramView.setTranslationY(paramView.getTranslationY() - paramFloat2);
    if (this.rqV != null) {
      this.rqV.e(paramView, paramFloat3, paramFloat4);
    }
    AppMethodBeat.o(242496);
  }
  
  public final View e(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(242487);
    paramRecyclerView = this.cJp;
    paramT.amk.setVisibility(4);
    View localView = this.rqV.P(paramT);
    localView.setAlpha(1.0F);
    localView.setScaleX(1.0F);
    localView.setScaleY(1.0F);
    localView.setVisibility(0);
    this.rqz = localView;
    paramRecyclerView.addView(localView);
    Log.i("MicroMsg.ItemMoveHelper", "[onDragBegin] position:" + paramT.md());
    if ((paramT.md() < 0) && (this.rqz != null))
    {
      this.cJp.removeView(this.rqz);
      this.rqz = null;
      AppMethodBeat.o(242487);
      return null;
    }
    if ((this.rqX != null) && (this.rbc.size() > paramT.md()))
    {
      this.rqW = this.rqX.j(this.rbc.get(paramT.md()), paramT.md());
      this.bPt = paramT.md();
      this.endPos = this.bPt;
    }
    paramRecyclerView = this.rqz;
    AppMethodBeat.o(242487);
    return paramRecyclerView;
  }
  
  public final void f(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(242498);
    Log.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete adapter position: %d", new Object[] { Integer.valueOf(paramT.md()) });
    if ((paramT instanceof com.tencent.mm.plugin.appbrand.widget.desktop.d)) {
      Log.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete holder: %s", new Object[] { ((com.tencent.mm.plugin.appbrand.widget.desktop.d)paramT).titleTv.getText() });
    }
    if (this.rqX.cnq())
    {
      this.rbc.remove(paramT.md());
      Log.i("MicroMsg.ItemMoveHelper", "alvinluo mList hashCode: %d", new Object[] { Integer.valueOf(this.rbc.hashCode()) });
      paramRecyclerView.getAdapter().cN(paramT.md());
    }
    if (this.rqV != null) {
      this.rqV.k(this.rqW, paramT.md());
    }
    AppMethodBeat.o(242498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.d
 * JD-Core Version:    0.7.0.1
 */
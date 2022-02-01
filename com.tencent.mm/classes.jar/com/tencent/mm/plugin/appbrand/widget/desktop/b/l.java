package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.e;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Collections;
import java.util.List;

public final class l<T extends RecyclerView.w>
  extends i<T>
{
  int cUq = 0;
  int endPos = 0;
  private m mAa;
  private List mgF;
  FrameLayout mqR;
  View mxK;
  public com.tencent.mm.plugin.appbrand.widget.desktop.g mxS = null;
  public g mzQ;
  Object mzZ;
  public int paddingLeft = 0;
  public int paddingTop = 0;
  
  public l(FrameLayout paramFrameLayout, List paramList, m paramm)
  {
    this.mqR = paramFrameLayout;
    this.mgF = paramList;
    this.mAa = paramm;
  }
  
  public final boolean O(T paramT)
  {
    AppMethodBeat.i(49840);
    if (this.mzQ != null)
    {
      boolean bool = this.mzQ.O(paramT);
      AppMethodBeat.o(49840);
      return bool;
    }
    if (paramT == null)
    {
      AppMethodBeat.o(49840);
      return false;
    }
    AppMethodBeat.o(49840);
    return true;
  }
  
  public final boolean P(T paramT)
  {
    AppMethodBeat.i(49846);
    if (this.mzQ != null)
    {
      boolean bool = this.mzQ.P(paramT);
      AppMethodBeat.o(49846);
      return bool;
    }
    AppMethodBeat.o(49846);
    return false;
  }
  
  public final boolean R(T paramT)
  {
    AppMethodBeat.i(49842);
    if (this.mzQ != null)
    {
      boolean bool = this.mzQ.a(paramT, null);
      AppMethodBeat.o(49842);
      return bool;
    }
    AppMethodBeat.o(49842);
    return true;
  }
  
  public final void a(RecyclerView paramRecyclerView, T paramT, int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49844);
    if (this.mzQ != null) {
      this.mzQ.cN(this.mxK);
    }
    paramRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49838);
        if (l.this.mzQ != null) {
          l.this.mzQ.b(l.this.cUq, l.this.endPos, l.this.mzZ, true);
        }
        paramRunnable.run();
        AppMethodBeat.o(49838);
      }
    };
    final RecyclerView.w localw;
    float f2;
    float f1;
    if ((paramT != null) && (this.mxK != null))
    {
      ac.i("ItemMoveHelper", "[finishMove] position" + paramT.lv() + " dragViewPosition:" + paramInt);
      localw = paramRecyclerView.ci(paramInt);
      f2 = this.mxK.getTranslationX();
      f1 = this.mxK.getTranslationY();
      if ((paramInt == paramT.lv()) || (localw != null)) {
        break label253;
      }
      if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).jW() <= paramInt) {
        break label240;
      }
      f1 -= paramRecyclerView.getHeight();
    }
    for (;;)
    {
      paramT = this.mAa.cO(this.mxK);
      paramRecyclerView = paramT;
      if (paramT == null) {
        paramRecyclerView = this.mxK;
      }
      paramRecyclerView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
      this.mxK.animate().translationX(f2).translationY(f1).setDuration(300L).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49839);
          l.this.mqR.removeView(l.this.mxK);
          l.this.mxK.setVisibility(8);
          if (localw != null) {
            localw.asD.setVisibility(0);
          }
          paramRunnable.run();
          AppMethodBeat.o(49839);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      AppMethodBeat.o(49844);
      return;
      label240:
      f1 = paramRecyclerView.getHeight() + f1;
      continue;
      label253:
      if (localw != null)
      {
        f2 = f(paramRecyclerView, localw);
        float f3 = this.mAa.bwh();
        float f4 = Q(localw);
        float f5 = this.mAa.bwi();
        if (this.mxS == null) {
          f1 = 0.0F;
        }
        for (;;)
        {
          ac.i("MicroMsg.ItemMoveHelper", "alvinluo finishMove computeMoveExtraY %f", new Object[] { Float.valueOf(f1) });
          f1 += f5 + f4;
          f2 = f3 + f2;
          break;
          paramInt = this.mxS.computeVerticalScrollOffset();
          int i = paramRecyclerView.computeVerticalScrollExtent();
          int j = this.mxS.computeVerticalScrollRange();
          int k = j - paramRecyclerView.getMeasuredHeight() - paramInt;
          ac.i("MicroMsg.ItemMoveHelper", "alvinluo computeMoveExtraY scrollOffset: %d, scrollExtent: %d, scrollRange: %d, height: %d, extra: %d, diff: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramRecyclerView.getMeasuredHeight()), Integer.valueOf((int)(paramRecyclerView.getResources().getDimension(2131166753) * 1.0F)), Integer.valueOf(k) });
          if (k > paramRecyclerView.getResources().getDimension(2131166753) * 1.0F) {
            f1 = 0.0F;
          } else {
            f1 = paramRecyclerView.getResources().getDimension(2131166753) * 1.0F - k;
          }
        }
      }
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2, RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(49845);
    if (paramView == null)
    {
      AppMethodBeat.o(49845);
      return;
    }
    paramView.setTranslationX(paramView.getTranslationX() - paramFloat1);
    paramView.setTranslationY(paramView.getTranslationY() - paramFloat2);
    AppMethodBeat.o(49845);
  }
  
  public final void a(g paramg)
  {
    this.mzQ = paramg;
  }
  
  public final boolean a(RecyclerView paramRecyclerView, T paramT1, T paramT2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49843);
    ac.i("MicroMsg.ItemMoveHelper", "[onMoved] position:" + paramT1.lv() + " target:" + paramT2.lv());
    ac.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved mList: %d", new Object[] { Integer.valueOf(this.mgF.hashCode()) });
    if ((paramInt1 < 0) || (paramInt1 >= this.mgF.size()) || (paramInt2 < 0) || (paramInt2 >= this.mgF.size()))
    {
      AppMethodBeat.o(49843);
      return false;
    }
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      while (i < paramInt2)
      {
        Collections.swap(this.mgF, i, i + 1);
        i += 1;
      }
    }
    int i = paramInt1;
    while (i > paramInt2)
    {
      Collections.swap(this.mgF, i, i - 1);
      i -= 1;
    }
    ac.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved end mList: %d", new Object[] { Integer.valueOf(this.mgF.hashCode()) });
    paramRecyclerView.getAdapter().ap(paramInt1, paramInt2);
    if (this.mAa != null)
    {
      this.endPos = paramInt2;
      this.mAa.g(this.mzZ, paramInt2);
    }
    AppMethodBeat.o(49843);
    return true;
  }
  
  public final View g(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49841);
    FrameLayout localFrameLayout = this.mqR;
    paramT.asD.setVisibility(4);
    paramRecyclerView = this.mzQ.e(paramRecyclerView, paramT);
    paramRecyclerView.setAlpha(1.0F);
    paramRecyclerView.setScaleX(1.0F);
    paramRecyclerView.setScaleY(1.0F);
    paramRecyclerView.setVisibility(0);
    this.mxK = paramRecyclerView;
    localFrameLayout.addView(paramRecyclerView);
    ac.i("MicroMsg.ItemMoveHelper", "[onDragBegin] position:" + paramT.lv());
    if ((paramT.lv() < 0) && (this.mxK != null))
    {
      this.mqR.removeView(this.mxK);
      this.mxK = null;
      AppMethodBeat.o(49841);
      return null;
    }
    if ((this.mAa != null) && (this.mgF.size() > paramT.lv()))
    {
      this.mzZ = this.mAa.cA(this.mgF.get(paramT.lv()));
      this.cUq = paramT.lv();
      this.endPos = this.cUq;
    }
    paramRecyclerView = this.mxK;
    AppMethodBeat.o(49841);
    return paramRecyclerView;
  }
  
  public final void h(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49847);
    ac.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete adapter position: %d", new Object[] { Integer.valueOf(paramT.lv()) });
    if ((paramT instanceof e)) {
      ac.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete holder: %s", new Object[] { ((e)paramT).titleTv.getText() });
    }
    this.mgF.remove(paramT.lv());
    ac.i("MicroMsg.ItemMoveHelper", "alvinluo mList hashCode: %d", new Object[] { Integer.valueOf(this.mgF.hashCode()) });
    paramRecyclerView.getAdapter().cl(paramT.lv());
    if (this.mzQ != null) {
      this.mzQ.cz(this.mzZ);
    }
    AppMethodBeat.o(49847);
  }
  
  public final void m(RecyclerView paramRecyclerView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.l
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.plugin.appbrand.widget.desktop.f;
import com.tencent.mm.plugin.appbrand.widget.desktop.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collections;
import java.util.List;

public final class l<T extends RecyclerView.w>
  extends i<T>
{
  FrameLayout cuk;
  int dfG = 0;
  int endPos = 0;
  private List mHf;
  public h mYA = null;
  View mYs;
  Object naH;
  private m naI;
  public g nay;
  public int paddingLeft = 0;
  public int paddingTop = 0;
  
  public l(FrameLayout paramFrameLayout, List paramList, m paramm)
  {
    this.cuk = paramFrameLayout;
    this.mHf = paramList;
    this.naI = paramm;
  }
  
  public final boolean O(T paramT)
  {
    AppMethodBeat.i(49840);
    if (this.nay != null)
    {
      boolean bool = this.nay.O(paramT);
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
    if (this.nay != null)
    {
      boolean bool = this.nay.P(paramT);
      AppMethodBeat.o(49846);
      return bool;
    }
    AppMethodBeat.o(49846);
    return false;
  }
  
  public final boolean R(T paramT)
  {
    AppMethodBeat.i(49842);
    if (this.nay != null)
    {
      boolean bool = this.nay.a(paramT, null);
      AppMethodBeat.o(49842);
      return bool;
    }
    AppMethodBeat.o(49842);
    return true;
  }
  
  public final void a(RecyclerView paramRecyclerView, T paramT, int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49844);
    if (this.nay != null) {
      this.nay.cP(this.mYs);
    }
    paramRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49838);
        if (l.this.nay != null) {
          l.this.nay.b(l.this.dfG, l.this.endPos, l.this.naH, true);
        }
        paramRunnable.run();
        AppMethodBeat.o(49838);
      }
    };
    final RecyclerView.w localw;
    float f2;
    float f1;
    if ((paramT != null) && (this.mYs != null))
    {
      ad.i("ItemMoveHelper", "[finishMove] position" + paramT.lN() + " dragViewPosition:" + paramInt);
      localw = paramRecyclerView.ci(paramInt);
      f2 = this.mYs.getTranslationX();
      f1 = this.mYs.getTranslationY();
      if ((paramInt == paramT.lN()) || (localw != null)) {
        break label253;
      }
      if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).km() <= paramInt) {
        break label240;
      }
      f1 -= paramRecyclerView.getHeight();
    }
    for (;;)
    {
      paramT = this.naI.cQ(this.mYs);
      paramRecyclerView = paramT;
      if (paramT == null) {
        paramRecyclerView = this.mYs;
      }
      paramRecyclerView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
      this.mYs.animate().translationX(f2).translationY(f1).setDuration(300L).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49839);
          l.this.cuk.removeView(l.this.mYs);
          l.this.mYs.setVisibility(8);
          if (localw != null) {
            localw.auu.setVisibility(0);
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
        float f3 = this.naI.bAn();
        float f4 = Q(localw);
        float f5 = this.naI.bAo();
        if (this.mYA == null) {
          f1 = 0.0F;
        }
        for (;;)
        {
          ad.i("MicroMsg.ItemMoveHelper", "alvinluo finishMove computeMoveExtraY %f", new Object[] { Float.valueOf(f1) });
          f1 += f5 + f4;
          f2 = f3 + f2;
          break;
          paramInt = this.mYA.computeVerticalScrollOffset();
          int i = paramRecyclerView.computeVerticalScrollExtent();
          int j = this.mYA.computeVerticalScrollRange();
          int k = j - paramRecyclerView.getMeasuredHeight() - paramInt;
          ad.i("MicroMsg.ItemMoveHelper", "alvinluo computeMoveExtraY scrollOffset: %d, scrollExtent: %d, scrollRange: %d, height: %d, extra: %d, diff: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramRecyclerView.getMeasuredHeight()), Integer.valueOf((int)(paramRecyclerView.getResources().getDimension(2131166753) * 1.0F)), Integer.valueOf(k) });
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
    this.nay = paramg;
  }
  
  public final boolean a(RecyclerView paramRecyclerView, T paramT1, T paramT2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49843);
    ad.i("MicroMsg.ItemMoveHelper", "[onMoved] position:" + paramT1.lN() + " target:" + paramT2.lN());
    ad.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved mList: %d", new Object[] { Integer.valueOf(this.mHf.hashCode()) });
    if ((paramInt1 < 0) || (paramInt1 >= this.mHf.size()) || (paramInt2 < 0) || (paramInt2 >= this.mHf.size()))
    {
      AppMethodBeat.o(49843);
      return false;
    }
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      while (i < paramInt2)
      {
        Collections.swap(this.mHf, i, i + 1);
        i += 1;
      }
    }
    int i = paramInt1;
    while (i > paramInt2)
    {
      Collections.swap(this.mHf, i, i - 1);
      i -= 1;
    }
    ad.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved end mList: %d", new Object[] { Integer.valueOf(this.mHf.hashCode()) });
    paramRecyclerView.getAdapter().aq(paramInt1, paramInt2);
    if (this.naI != null)
    {
      this.endPos = paramInt2;
      this.naI.h(this.naH, paramInt2);
    }
    AppMethodBeat.o(49843);
    return true;
  }
  
  public final View g(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49841);
    FrameLayout localFrameLayout = this.cuk;
    paramT.auu.setVisibility(4);
    paramRecyclerView = this.nay.e(paramRecyclerView, paramT);
    paramRecyclerView.setAlpha(1.0F);
    paramRecyclerView.setScaleX(1.0F);
    paramRecyclerView.setScaleY(1.0F);
    paramRecyclerView.setVisibility(0);
    this.mYs = paramRecyclerView;
    localFrameLayout.addView(paramRecyclerView);
    ad.i("MicroMsg.ItemMoveHelper", "[onDragBegin] position:" + paramT.lN());
    if ((paramT.lN() < 0) && (this.mYs != null))
    {
      this.cuk.removeView(this.mYs);
      this.mYs = null;
      AppMethodBeat.o(49841);
      return null;
    }
    if ((this.naI != null) && (this.mHf.size() > paramT.lN()))
    {
      this.naH = this.naI.cC(this.mHf.get(paramT.lN()));
      this.dfG = paramT.lN();
      this.endPos = this.dfG;
    }
    paramRecyclerView = this.mYs;
    AppMethodBeat.o(49841);
    return paramRecyclerView;
  }
  
  public final void h(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49847);
    ad.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete adapter position: %d", new Object[] { Integer.valueOf(paramT.lN()) });
    if ((paramT instanceof f)) {
      ad.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete holder: %s", new Object[] { ((f)paramT).titleTv.getText() });
    }
    this.mHf.remove(paramT.lN());
    ad.i("MicroMsg.ItemMoveHelper", "alvinluo mList hashCode: %d", new Object[] { Integer.valueOf(this.mHf.hashCode()) });
    paramRecyclerView.getAdapter().cl(paramT.lN());
    if (this.nay != null) {
      this.nay.cB(this.naH);
    }
    AppMethodBeat.o(49847);
  }
  
  public final void m(RecyclerView paramRecyclerView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.l
 * JD-Core Version:    0.7.0.1
 */
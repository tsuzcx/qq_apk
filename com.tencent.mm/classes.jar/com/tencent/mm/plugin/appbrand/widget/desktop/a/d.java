package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
  private int dIY = 0;
  FrameLayout eCZ;
  private List eXW;
  private int endPos = 0;
  private View uAI;
  public g uAT = null;
  public a uBf;
  private Object uBg;
  private e uBh;
  
  public d(FrameLayout paramFrameLayout, List paramList, e parame)
  {
    this.eCZ = paramFrameLayout;
    this.eXW = paramList;
    this.uBh = parame;
  }
  
  public final boolean N(T paramT)
  {
    AppMethodBeat.i(324241);
    if (this.uBf != null)
    {
      boolean bool = this.uBf.N(paramT);
      AppMethodBeat.o(324241);
      return bool;
    }
    if (paramT == null)
    {
      AppMethodBeat.o(324241);
      return false;
    }
    AppMethodBeat.o(324241);
    return true;
  }
  
  public final void O(T paramT)
  {
    AppMethodBeat.i(324283);
    Log.i("MicroMsg.ItemMoveHelper", "alvinluo onStar adapter position: %d", new Object[] { Integer.valueOf(paramT.KJ()) });
    if ((paramT instanceof com.tencent.mm.plugin.appbrand.widget.desktop.d)) {
      Log.i("MicroMsg.ItemMoveHelper", "alvinluo onStar holder: %s", new Object[] { ((com.tencent.mm.plugin.appbrand.widget.desktop.d)paramT).titleTv.getText() });
    }
    if (this.uBf != null) {
      this.uBf.eo(this.uBg);
    }
    AppMethodBeat.o(324283);
  }
  
  public final void a(final RecyclerView paramRecyclerView, T paramT, int paramInt, boolean paramBoolean1, boolean paramBoolean2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(324266);
    if (this.uBf != null) {
      this.uBf.ak(paramInt, paramBoolean1);
    }
    final Runnable local1;
    final RecyclerView.v localv;
    float f4;
    float f6;
    float f5;
    float f2;
    float f3;
    if (paramBoolean2)
    {
      local1 = new Runnable()
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
      if ((paramT != null) && (this.uAI != null))
      {
        Log.i("ItemMoveHelper", "[finishMove] position" + paramT.KJ() + " dragViewPosition:" + paramInt);
        localv = paramRecyclerView.fU(paramInt);
        f4 = this.uAI.getTranslationX();
        f6 = this.uAI.getTranslationY();
        f5 = 1.0F;
        paramRunnable = Boolean.TRUE;
        if ((paramInt == paramT.KJ()) || (localv != null)) {
          break label392;
        }
        if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).Ju() <= paramInt) {
          break label368;
        }
        f1 = f6 - paramRecyclerView.getHeight();
        f2 = f4;
        paramT = paramRunnable;
        f3 = f5;
      }
    }
    label192:
    long l;
    label204:
    label246:
    do
    {
      for (;;)
      {
        paramRunnable = this.uBh.dV(this.uAI);
        if (paramRunnable != null) {
          break label680;
        }
        paramRunnable = this.uAI;
        if (!paramT.booleanValue()) {
          break;
        }
        l = 300L;
        f5 = f1;
        f4 = f2;
        if (l > 0L)
        {
          f5 = f1;
          f4 = f2;
          if (f3 >= 0.99999F)
          {
            if ((localv instanceof com.tencent.mm.plugin.appbrand.widget.desktop.d)) {
              break label600;
            }
            f1 = 0.0F;
            f4 = f1 + this.uBh.cPk();
            if ((localv instanceof com.tencent.mm.plugin.appbrand.widget.desktop.d)) {
              break label640;
            }
            f1 = 0.0F;
            f5 = f1 + this.uBh.cPl();
          }
        }
        paramRunnable.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
        this.uAI.animate().scaleX(f3).scaleY(f3).translationX(f4).translationY(f5).setDuration(l).setListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(49839);
            d.this.eCZ.removeView(d.b(d.this));
            d.b(d.this).setVisibility(8);
            paramAnonymousAnimator = d.a(d.this).cPp();
            if ((paramAnonymousAnimator != null) && (d.a(d.this).i(paramRecyclerView)) && (d.a(d.this).cPq() > 8)) {
              paramAnonymousAnimator.setImageDrawable(((ImageView)d.f(d.this).dW(d.b(d.this))).getDrawable());
            }
            if (localv != null) {
              localv.caK.setVisibility(0);
            }
            local1.run();
            AppMethodBeat.o(49839);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        }).start();
        AppMethodBeat.o(324266);
        return;
        f1 = paramRecyclerView.getHeight() + f6;
        f3 = f5;
        paramT = paramRunnable;
        f2 = f4;
      }
      f3 = f5;
      paramT = paramRunnable;
      f1 = f6;
      f2 = f4;
    } while (localv == null);
    label271:
    label368:
    paramT = this.uBf.cPo();
    label392:
    Object localObject;
    if ((paramT != null) && (this.uBf.cPq() > 8) && (this.uBf.i(paramRecyclerView)))
    {
      f2 = paramT[0] - this.uAI.getWidth() / 2.0F;
      f4 = paramT[1] - this.uAI.getHeight() / 2.0F;
      paramT = this.uBh.dW(this.uAI);
      localObject = this.uBf.cPp();
      if ((paramT == null) || (localObject == null)) {
        break label683;
      }
    }
    label640:
    label680:
    label683:
    for (float f1 = ((ImageView)localObject).getHeight() * 1.0F / paramT.getHeight();; f1 = 1.0F)
    {
      f3 = f1;
      paramT = paramRunnable;
      f1 = f4;
      break;
      if (!this.uBf.i(paramRecyclerView)) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        paramT = Boolean.valueOf(paramBoolean1);
        f3 = f5;
        f1 = f6;
        f2 = f4;
        break;
      }
      l = 0L;
      break label204;
      label600:
      paramT = ((com.tencent.mm.plugin.appbrand.widget.desktop.d)localv).ttT;
      localObject = new int[2];
      paramT.getLocationOnScreen((int[])localObject);
      f1 = localObject[0] + com.tencent.mm.plugin.appbrand.widget.desktop.b.fu(paramRecyclerView.getContext()) / 2.0F;
      break label246;
      paramT = ((com.tencent.mm.plugin.appbrand.widget.desktop.d)localv).ttT;
      localObject = new int[2];
      paramT.getLocationOnScreen((int[])localObject);
      f1 = localObject[1] + com.tencent.mm.plugin.appbrand.widget.desktop.b.fu(paramRecyclerView.getContext()) / 2.0F;
      break label271;
      break label192;
    }
  }
  
  public final boolean a(RecyclerView paramRecyclerView, T paramT1, T paramT2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(324258);
    Log.i("MicroMsg.ItemMoveHelper", "[onMoved] position:" + paramT1.KJ() + " target:" + paramT2.KJ());
    Log.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved mList: %d", new Object[] { Integer.valueOf(this.eXW.hashCode()) });
    if ((paramInt1 < 0) || (paramInt1 >= this.eXW.size()) || (paramInt2 < 0) || (paramInt2 >= this.eXW.size()))
    {
      AppMethodBeat.o(324258);
      return false;
    }
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      while (i < paramInt2)
      {
        Collections.swap(this.eXW, i, i + 1);
        i += 1;
      }
    }
    int i = paramInt1;
    while (i > paramInt2)
    {
      Collections.swap(this.eXW, i, i - 1);
      i -= 1;
    }
    Log.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved end mList: %d", new Object[] { Integer.valueOf(this.eXW.hashCode()) });
    paramRecyclerView.getAdapter().bz(paramInt1, paramInt2);
    if (this.uBh != null) {
      this.endPos = paramInt2;
    }
    paramRecyclerView.getAdapter().e(0, paramRecyclerView.getAdapter().getItemCount(), Boolean.TRUE);
    AppMethodBeat.o(324258);
    return true;
  }
  
  public final void b(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(324272);
    if (paramView == null)
    {
      AppMethodBeat.o(324272);
      return;
    }
    paramView.setTranslationX(paramView.getTranslationX() - paramFloat1);
    paramView.setTranslationY(paramView.getTranslationY() - paramFloat2);
    if (this.uBf != null) {
      this.uBf.e(paramView, paramFloat3, paramFloat4);
    }
    AppMethodBeat.o(324272);
  }
  
  public final boolean cPn()
  {
    AppMethodBeat.i(324276);
    if (this.uBf != null)
    {
      boolean bool = this.uBf.cPn();
      AppMethodBeat.o(324276);
      return bool;
    }
    AppMethodBeat.o(324276);
    return false;
  }
  
  public final View f(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(324245);
    paramRecyclerView = this.eCZ;
    paramT.caK.setVisibility(4);
    View localView = this.uBf.M(paramT);
    localView.setAlpha(1.0F);
    localView.setScaleX(1.0F);
    localView.setScaleY(1.0F);
    localView.setVisibility(0);
    this.uAI = localView;
    paramRecyclerView.addView(localView);
    Log.i("MicroMsg.ItemMoveHelper", "[onDragBegin] position:" + paramT.KJ());
    if ((paramT.KJ() < 0) && (this.uAI != null))
    {
      this.eCZ.removeView(this.uAI);
      this.uAI = null;
      AppMethodBeat.o(324245);
      return null;
    }
    if ((this.uBh != null) && (this.eXW.size() > paramT.KJ()))
    {
      this.uBg = this.uBh.l(this.eXW.get(paramT.KJ()), paramT.KJ());
      this.dIY = paramT.KJ();
      this.endPos = this.dIY;
    }
    paramRecyclerView = this.uAI;
    AppMethodBeat.o(324245);
    return paramRecyclerView;
  }
  
  public final boolean g(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(324250);
    if (this.uBf != null)
    {
      boolean bool = this.uBf.e(paramRecyclerView, paramT);
      AppMethodBeat.o(324250);
      return bool;
    }
    AppMethodBeat.o(324250);
    return true;
  }
  
  public final void h(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(324287);
    Log.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete adapter position: %d", new Object[] { Integer.valueOf(paramT.KJ()) });
    if ((paramT instanceof com.tencent.mm.plugin.appbrand.widget.desktop.d)) {
      Log.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete holder: %s", new Object[] { ((com.tencent.mm.plugin.appbrand.widget.desktop.d)paramT).titleTv.getText() });
    }
    if (this.uBh.cPm())
    {
      this.eXW.remove(paramT.KJ());
      Log.i("MicroMsg.ItemMoveHelper", "alvinluo mList hashCode: %d", new Object[] { Integer.valueOf(this.eXW.hashCode()) });
      paramRecyclerView.getAdapter().fX(paramT.KJ());
    }
    if (this.uBf != null) {
      this.uBf.m(this.uBg, paramT.KJ());
    }
    AppMethodBeat.o(324287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.d
 * JD-Core Version:    0.7.0.1
 */
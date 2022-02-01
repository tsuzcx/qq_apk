package com.tencent.mm.plugin.appbrand.widget.desktop.b;

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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Collections;
import java.util.List;

public final class l<T extends RecyclerView.w>
  extends i<T>
{
  FrameLayout cuN;
  int dgI = 0;
  int endPos = 0;
  private List mMj;
  public h ndH = null;
  View ndz;
  public g nfG;
  Object nfP;
  private m nfQ;
  public int paddingLeft = 0;
  public int paddingTop = 0;
  
  public l(FrameLayout paramFrameLayout, List paramList, m paramm)
  {
    this.cuN = paramFrameLayout;
    this.mMj = paramList;
    this.nfQ = paramm;
  }
  
  public final boolean O(T paramT)
  {
    AppMethodBeat.i(49840);
    if (this.nfG != null)
    {
      boolean bool = this.nfG.O(paramT);
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
    if (this.nfG != null)
    {
      boolean bool = this.nfG.P(paramT);
      AppMethodBeat.o(49846);
      return bool;
    }
    AppMethodBeat.o(49846);
    return false;
  }
  
  public final boolean R(T paramT)
  {
    AppMethodBeat.i(49842);
    if (this.nfG != null)
    {
      boolean bool = this.nfG.a(paramT, null);
      AppMethodBeat.o(49842);
      return bool;
    }
    AppMethodBeat.o(49842);
    return true;
  }
  
  public final void a(RecyclerView paramRecyclerView, T paramT, int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49844);
    if (this.nfG != null) {
      this.nfG.cQ(this.ndz);
    }
    paramRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49838);
        if (l.this.nfG != null) {
          l.this.nfG.b(l.this.dgI, l.this.endPos, l.this.nfP, true);
        }
        paramRunnable.run();
        AppMethodBeat.o(49838);
      }
    };
    RecyclerView.w localw;
    float f2;
    float f1;
    if ((paramT != null) && (this.ndz != null))
    {
      ae.i("ItemMoveHelper", "[finishMove] position" + paramT.lN() + " dragViewPosition:" + paramInt);
      localw = paramRecyclerView.ci(paramInt);
      f2 = this.ndz.getTranslationX();
      f1 = this.ndz.getTranslationY();
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
      paramT = this.nfQ.cR(this.ndz);
      paramRecyclerView = paramT;
      if (paramT == null) {
        paramRecyclerView = this.ndz;
      }
      paramRecyclerView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
      this.ndz.animate().translationX(f2).translationY(f1).setDuration(300L).setListener(new l.2(this, localw, paramRunnable)).start();
      AppMethodBeat.o(49844);
      return;
      label240:
      f1 = paramRecyclerView.getHeight() + f1;
      continue;
      label253:
      if (localw != null)
      {
        f2 = f(paramRecyclerView, localw);
        float f3 = this.nfQ.bBi();
        float f4 = Q(localw);
        float f5 = this.nfQ.bBj();
        if (this.ndH == null) {
          f1 = 0.0F;
        }
        for (;;)
        {
          ae.i("MicroMsg.ItemMoveHelper", "alvinluo finishMove computeMoveExtraY %f", new Object[] { Float.valueOf(f1) });
          f1 += f5 + f4;
          f2 = f3 + f2;
          break;
          paramInt = this.ndH.computeVerticalScrollOffset();
          int i = paramRecyclerView.computeVerticalScrollExtent();
          int j = this.ndH.computeVerticalScrollRange();
          int k = j - paramRecyclerView.getMeasuredHeight() - paramInt;
          ae.i("MicroMsg.ItemMoveHelper", "alvinluo computeMoveExtraY scrollOffset: %d, scrollExtent: %d, scrollRange: %d, height: %d, extra: %d, diff: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramRecyclerView.getMeasuredHeight()), Integer.valueOf((int)(paramRecyclerView.getResources().getDimension(2131166753) * 1.0F)), Integer.valueOf(k) });
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
    this.nfG = paramg;
  }
  
  public final boolean a(RecyclerView paramRecyclerView, T paramT1, T paramT2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49843);
    ae.i("MicroMsg.ItemMoveHelper", "[onMoved] position:" + paramT1.lN() + " target:" + paramT2.lN());
    ae.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved mList: %d", new Object[] { Integer.valueOf(this.mMj.hashCode()) });
    if ((paramInt1 < 0) || (paramInt1 >= this.mMj.size()) || (paramInt2 < 0) || (paramInt2 >= this.mMj.size()))
    {
      AppMethodBeat.o(49843);
      return false;
    }
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      while (i < paramInt2)
      {
        Collections.swap(this.mMj, i, i + 1);
        i += 1;
      }
    }
    int i = paramInt1;
    while (i > paramInt2)
    {
      Collections.swap(this.mMj, i, i - 1);
      i -= 1;
    }
    ae.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved end mList: %d", new Object[] { Integer.valueOf(this.mMj.hashCode()) });
    paramRecyclerView.getAdapter().aq(paramInt1, paramInt2);
    if (this.nfQ != null)
    {
      this.endPos = paramInt2;
      this.nfQ.h(this.nfP, paramInt2);
    }
    AppMethodBeat.o(49843);
    return true;
  }
  
  public final View g(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49841);
    FrameLayout localFrameLayout = this.cuN;
    paramT.auu.setVisibility(4);
    paramRecyclerView = this.nfG.e(paramRecyclerView, paramT);
    paramRecyclerView.setAlpha(1.0F);
    paramRecyclerView.setScaleX(1.0F);
    paramRecyclerView.setScaleY(1.0F);
    paramRecyclerView.setVisibility(0);
    this.ndz = paramRecyclerView;
    localFrameLayout.addView(paramRecyclerView);
    ae.i("MicroMsg.ItemMoveHelper", "[onDragBegin] position:" + paramT.lN());
    if ((paramT.lN() < 0) && (this.ndz != null))
    {
      this.cuN.removeView(this.ndz);
      this.ndz = null;
      AppMethodBeat.o(49841);
      return null;
    }
    if ((this.nfQ != null) && (this.mMj.size() > paramT.lN()))
    {
      this.nfP = this.nfQ.cD(this.mMj.get(paramT.lN()));
      this.dgI = paramT.lN();
      this.endPos = this.dgI;
    }
    paramRecyclerView = this.ndz;
    AppMethodBeat.o(49841);
    return paramRecyclerView;
  }
  
  public final void h(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49847);
    ae.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete adapter position: %d", new Object[] { Integer.valueOf(paramT.lN()) });
    if ((paramT instanceof f)) {
      ae.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete holder: %s", new Object[] { ((f)paramT).titleTv.getText() });
    }
    this.mMj.remove(paramT.lN());
    ae.i("MicroMsg.ItemMoveHelper", "alvinluo mList hashCode: %d", new Object[] { Integer.valueOf(this.mMj.hashCode()) });
    paramRecyclerView.getAdapter().cl(paramT.lN());
    if (this.nfG != null) {
      this.nfG.cC(this.nfP);
    }
    AppMethodBeat.o(49847);
  }
  
  public final void m(RecyclerView paramRecyclerView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.l
 * JD-Core Version:    0.7.0.1
 */
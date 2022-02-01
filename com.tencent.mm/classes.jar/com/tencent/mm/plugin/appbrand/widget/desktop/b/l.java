package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collections;
import java.util.List;

public final class l<T extends RecyclerView.v>
  extends i<T>
{
  int cWU = 0;
  int endPos = 0;
  private List lEL;
  FrameLayout lOR;
  View lVI;
  public com.tencent.mm.plugin.appbrand.widget.desktop.g lVQ = null;
  public g lXO;
  Object lXX;
  private m lXY;
  public int paddingLeft = 0;
  public int paddingTop = 0;
  
  public l(FrameLayout paramFrameLayout, List paramList, m paramm)
  {
    this.lOR = paramFrameLayout;
    this.lEL = paramList;
    this.lXY = paramm;
  }
  
  public final boolean O(T paramT)
  {
    AppMethodBeat.i(49840);
    if (this.lXO != null)
    {
      boolean bool = this.lXO.O(paramT);
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
    if (this.lXO != null)
    {
      boolean bool = this.lXO.P(paramT);
      AppMethodBeat.o(49846);
      return bool;
    }
    AppMethodBeat.o(49846);
    return false;
  }
  
  public final boolean R(T paramT)
  {
    AppMethodBeat.i(49842);
    if (this.lXO != null)
    {
      boolean bool = this.lXO.a(paramT, null);
      AppMethodBeat.o(49842);
      return bool;
    }
    AppMethodBeat.o(49842);
    return true;
  }
  
  public final void a(RecyclerView paramRecyclerView, T paramT, int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49844);
    if (this.lXO != null) {
      this.lXO.cL(this.lVI);
    }
    paramRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49838);
        if (l.this.lXO != null) {
          l.this.lXO.b(l.this.cWU, l.this.endPos, l.this.lXX, true);
        }
        paramRunnable.run();
        AppMethodBeat.o(49838);
      }
    };
    RecyclerView.v localv;
    float f2;
    float f1;
    if ((paramT != null) && (this.lVI != null))
    {
      ad.i("ItemMoveHelper", "[finishMove] position" + paramT.ln() + " dragViewPosition:" + paramInt);
      localv = paramRecyclerView.cj(paramInt);
      f2 = this.lVI.getTranslationX();
      f1 = this.lVI.getTranslationY();
      if ((paramInt == paramT.ln()) || (localv != null)) {
        break label253;
      }
      if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).jO() <= paramInt) {
        break label240;
      }
      f1 -= paramRecyclerView.getHeight();
    }
    for (;;)
    {
      paramT = this.lXY.cM(this.lVI);
      paramRecyclerView = paramT;
      if (paramT == null) {
        paramRecyclerView = this.lVI;
      }
      paramRecyclerView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
      this.lVI.animate().translationX(f2).translationY(f1).setDuration(300L).setListener(new l.2(this, localv, paramRunnable)).start();
      AppMethodBeat.o(49844);
      return;
      label240:
      f1 = paramRecyclerView.getHeight() + f1;
      continue;
      label253:
      if (localv != null)
      {
        f2 = f(paramRecyclerView, localv);
        float f3 = this.lXY.bpm();
        float f4 = Q(localv);
        float f5 = this.lXY.bpn();
        if (this.lVQ == null) {
          f1 = 0.0F;
        }
        for (;;)
        {
          ad.i("MicroMsg.ItemMoveHelper", "alvinluo finishMove computeMoveExtraY %f", new Object[] { Float.valueOf(f1) });
          f1 += f5 + f4;
          f2 = f3 + f2;
          break;
          paramInt = this.lVQ.computeVerticalScrollOffset();
          int i = paramRecyclerView.computeVerticalScrollExtent();
          int j = this.lVQ.computeVerticalScrollRange();
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
  
  public final void a(View paramView, float paramFloat1, float paramFloat2, RecyclerView.v paramv, int paramInt)
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
    this.lXO = paramg;
  }
  
  public final boolean a(RecyclerView paramRecyclerView, T paramT1, T paramT2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49843);
    ad.i("MicroMsg.ItemMoveHelper", "[onMoved] position:" + paramT1.ln() + " target:" + paramT2.ln());
    ad.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved mList: %d", new Object[] { Integer.valueOf(this.lEL.hashCode()) });
    if ((paramInt1 < 0) || (paramInt1 >= this.lEL.size()) || (paramInt2 < 0) || (paramInt2 >= this.lEL.size()))
    {
      AppMethodBeat.o(49843);
      return false;
    }
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      while (i < paramInt2)
      {
        Collections.swap(this.lEL, i, i + 1);
        i += 1;
      }
    }
    int i = paramInt1;
    while (i > paramInt2)
    {
      Collections.swap(this.lEL, i, i - 1);
      i -= 1;
    }
    ad.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved end mList: %d", new Object[] { Integer.valueOf(this.lEL.hashCode()) });
    paramRecyclerView.getAdapter().ap(paramInt1, paramInt2);
    if (this.lXY != null)
    {
      this.endPos = paramInt2;
      this.lXY.g(this.lXX, paramInt2);
    }
    AppMethodBeat.o(49843);
    return true;
  }
  
  public final View g(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49841);
    FrameLayout localFrameLayout = this.lOR;
    paramT.arI.setVisibility(4);
    paramRecyclerView = this.lXO.e(paramRecyclerView, paramT);
    paramRecyclerView.setAlpha(1.0F);
    paramRecyclerView.setScaleX(1.0F);
    paramRecyclerView.setScaleY(1.0F);
    paramRecyclerView.setVisibility(0);
    this.lVI = paramRecyclerView;
    localFrameLayout.addView(paramRecyclerView);
    ad.i("MicroMsg.ItemMoveHelper", "[onDragBegin] position:" + paramT.ln());
    if ((paramT.ln() < 0) && (this.lVI != null))
    {
      this.lOR.removeView(this.lVI);
      this.lVI = null;
      AppMethodBeat.o(49841);
      return null;
    }
    if ((this.lXY != null) && (this.lEL.size() > paramT.ln()))
    {
      this.lXX = this.lXY.cB(this.lEL.get(paramT.ln()));
      this.cWU = paramT.ln();
      this.endPos = this.cWU;
    }
    paramRecyclerView = this.lVI;
    AppMethodBeat.o(49841);
    return paramRecyclerView;
  }
  
  public final void h(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49847);
    ad.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete adapter position: %d", new Object[] { Integer.valueOf(paramT.ln()) });
    if ((paramT instanceof e)) {
      ad.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete holder: %s", new Object[] { ((e)paramT).titleTv.getText() });
    }
    this.lEL.remove(paramT.ln());
    ad.i("MicroMsg.ItemMoveHelper", "alvinluo mList hashCode: %d", new Object[] { Integer.valueOf(this.lEL.hashCode()) });
    paramRecyclerView.getAdapter().cm(paramT.ln());
    if (this.lXO != null) {
      this.lXO.cA(this.lXX);
    }
    AppMethodBeat.o(49847);
  }
  
  public final void m(RecyclerView paramRecyclerView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.l
 * JD-Core Version:    0.7.0.1
 */
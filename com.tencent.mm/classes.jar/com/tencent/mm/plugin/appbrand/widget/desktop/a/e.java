package com.tencent.mm.plugin.appbrand.widget.desktop.a;

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
import com.tencent.mm.plugin.appbrand.widget.desktop.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collections;
import java.util.List;

public final class e<T extends RecyclerView.v>
  extends b<T>
{
  int chT = 0;
  int endPos = 0;
  private List iQp;
  View jfC;
  public g jfK = null;
  Object jiG;
  private f jiH;
  FrameLayout jis;
  public a jix;
  public int paddingLeft = 0;
  public int paddingTop = 0;
  
  public e(FrameLayout paramFrameLayout, List paramList, f paramf)
  {
    this.jis = paramFrameLayout;
    this.iQp = paramList;
    this.jiH = paramf;
  }
  
  public final boolean O(T paramT)
  {
    AppMethodBeat.i(134228);
    if (this.jix != null)
    {
      boolean bool = this.jix.O(paramT);
      AppMethodBeat.o(134228);
      return bool;
    }
    if (paramT == null)
    {
      AppMethodBeat.o(134228);
      return false;
    }
    AppMethodBeat.o(134228);
    return true;
  }
  
  public final boolean P(T paramT)
  {
    AppMethodBeat.i(134234);
    if (this.jix != null)
    {
      boolean bool = this.jix.P(paramT);
      AppMethodBeat.o(134234);
      return bool;
    }
    AppMethodBeat.o(134234);
    return false;
  }
  
  public final boolean R(T paramT)
  {
    AppMethodBeat.i(134230);
    if (this.jix != null)
    {
      boolean bool = this.jix.a(paramT, null);
      AppMethodBeat.o(134230);
      return bool;
    }
    AppMethodBeat.o(134230);
    return true;
  }
  
  public final void a(RecyclerView paramRecyclerView, T paramT, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(134232);
    if (this.jix != null) {
      this.jix.cz(this.jfC);
    }
    paramRunnable = new e.1(this, paramRunnable);
    RecyclerView.v localv;
    float f2;
    float f1;
    if ((paramT != null) && (this.jfC != null))
    {
      ab.i("ItemMoveHelper", "[finishMove] position" + paramT.jN() + " dragViewPosition:" + paramInt);
      localv = paramRecyclerView.bQ(paramInt);
      f2 = this.jfC.getTranslationX();
      f1 = this.jfC.getTranslationY();
      if ((paramInt == paramT.jN()) || (localv != null)) {
        break label253;
      }
      if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).it() <= paramInt) {
        break label240;
      }
      f1 -= paramRecyclerView.getHeight();
    }
    for (;;)
    {
      paramT = this.jiH.cA(this.jfC);
      paramRecyclerView = paramT;
      if (paramT == null) {
        paramRecyclerView = this.jfC;
      }
      paramRecyclerView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
      this.jfC.animate().translationX(f2).translationY(f1).setDuration(300L).setListener(new e.2(this, localv, paramRunnable)).start();
      AppMethodBeat.o(134232);
      return;
      label240:
      f1 = paramRecyclerView.getHeight() + f1;
      continue;
      label253:
      if (localv != null)
      {
        f2 = c(paramRecyclerView, localv);
        float f3 = this.jiH.aMW();
        float f4 = Q(localv);
        float f5 = this.jiH.aMX();
        if (this.jfK == null) {
          f1 = 0.0F;
        }
        for (;;)
        {
          ab.i("MicroMsg.ItemMoveHelper", "alvinluo finishMove computeMoveExtraY %f", new Object[] { Float.valueOf(f1) });
          f1 += f5 + f4;
          f2 = f3 + f2;
          break;
          paramInt = this.jfK.computeVerticalScrollOffset();
          int i = paramRecyclerView.computeVerticalScrollExtent();
          int j = this.jfK.computeVerticalScrollRange();
          int k = j - paramRecyclerView.getMeasuredHeight() - paramInt;
          ab.i("MicroMsg.ItemMoveHelper", "alvinluo computeMoveExtraY scrollOffset: %d, scrollExtent: %d, scrollRange: %d, height: %d, extra: %d, diff: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramRecyclerView.getMeasuredHeight()), Integer.valueOf((int)(paramRecyclerView.getResources().getDimension(2131428643) * 1.0F)), Integer.valueOf(k) });
          if (k > paramRecyclerView.getResources().getDimension(2131428643) * 1.0F) {
            f1 = 0.0F;
          } else {
            f1 = paramRecyclerView.getResources().getDimension(2131428643) * 1.0F - k;
          }
        }
      }
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2, RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(134233);
    if (paramView == null)
    {
      AppMethodBeat.o(134233);
      return;
    }
    paramView.setTranslationX(paramView.getTranslationX() - paramFloat1);
    paramView.setTranslationY(paramView.getTranslationY() - paramFloat2);
    AppMethodBeat.o(134233);
  }
  
  public final void a(a parama)
  {
    this.jix = parama;
  }
  
  public final boolean a(RecyclerView paramRecyclerView, T paramT1, T paramT2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134231);
    ab.i("MicroMsg.ItemMoveHelper", "[onMoved] position:" + paramT1.jN() + " target:" + paramT2.jN());
    ab.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved mList: %d", new Object[] { Integer.valueOf(this.iQp.hashCode()) });
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      while (i < paramInt2)
      {
        Collections.swap(this.iQp, i, i + 1);
        i += 1;
      }
    }
    int i = paramInt1;
    while (i > paramInt2)
    {
      Collections.swap(this.iQp, i, i - 1);
      i -= 1;
    }
    ab.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved end mList: %d", new Object[] { Integer.valueOf(this.iQp.hashCode()) });
    paramRecyclerView.getAdapter().ao(paramInt1, paramInt2);
    if (this.jiH != null)
    {
      this.endPos = paramInt2;
      this.jiH.e(this.jiG, paramInt2);
    }
    AppMethodBeat.o(134231);
    return true;
  }
  
  public final View d(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(134229);
    FrameLayout localFrameLayout = this.jis;
    paramT.aku.setVisibility(4);
    paramRecyclerView = this.jix.b(paramRecyclerView, paramT);
    paramRecyclerView.setAlpha(1.0F);
    paramRecyclerView.setScaleX(1.0F);
    paramRecyclerView.setScaleY(1.0F);
    paramRecyclerView.setVisibility(0);
    this.jfC = paramRecyclerView;
    localFrameLayout.addView(paramRecyclerView);
    ab.i("MicroMsg.ItemMoveHelper", "[onDragBegin] position:" + paramT.jN());
    if ((paramT.jN() < 0) && (this.jfC != null))
    {
      this.jis.removeView(this.jfC);
      this.jfC = null;
      AppMethodBeat.o(134229);
      return null;
    }
    if ((this.jiH != null) && (this.iQp.size() > paramT.jN()))
    {
      this.jiG = this.jiH.bo(this.iQp.get(paramT.jN()));
      this.chT = paramT.jN();
      this.endPos = this.chT;
    }
    paramRecyclerView = this.jfC;
    AppMethodBeat.o(134229);
    return paramRecyclerView;
  }
  
  public final void e(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(134235);
    ab.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete adapter position: %d", new Object[] { Integer.valueOf(paramT.jN()) });
    if ((paramT instanceof com.tencent.mm.plugin.appbrand.widget.desktop.e)) {
      ab.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete holder: %s", new Object[] { ((com.tencent.mm.plugin.appbrand.widget.desktop.e)paramT).titleTv.getText() });
    }
    this.iQp.remove(paramT.jN());
    ab.i("MicroMsg.ItemMoveHelper", "alvinluo mList hashCode: %d", new Object[] { Integer.valueOf(this.iQp.hashCode()) });
    paramRecyclerView.getAdapter().bT(paramT.jN());
    if (this.jix != null) {
      this.jix.bn(this.jiG);
    }
    AppMethodBeat.o(134235);
  }
  
  public final void m(RecyclerView paramRecyclerView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.e
 * JD-Core Version:    0.7.0.1
 */
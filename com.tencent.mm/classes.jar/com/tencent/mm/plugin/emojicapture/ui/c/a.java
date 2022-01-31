package com.tencent.mm.plugin.emojicapture.ui.c;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "TAG", "", "forceUpdateOnNextLayout", "", "onItemSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function2;)V", "scrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "findSelectedChildIndex", "onItemsAdded", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "positionStart", "itemCount", "onItemsChanged", "onItemsRemoved", "onItemsUpdated", "onLayoutChildren", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onLayoutCompleted", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "updateChild", "updateSelectedChild", "force", "plugin-emojicapture_release"})
public final class a
  extends LinearLayoutManager
{
  private final String TAG;
  private int lCk;
  private boolean lCl;
  public m<? super Integer, ? super View, y> lCm;
  private int lxQ;
  
  public a(Context paramContext)
  {
    super(0);
    AppMethodBeat.i(3192);
    this.TAG = "MicroMsg.StickerLayoutManager";
    this.lxQ = -1;
    AppMethodBeat.o(3192);
  }
  
  private final void bpo()
  {
    AppMethodBeat.i(3185);
    Rect localRect = new Rect();
    int i = 0;
    int j = getChildCount();
    if (i < j)
    {
      View localView = getChildAt(i);
      d(localView, localRect);
      int k = (localRect.left + localRect.right) / 2;
      int m = getWidth() / 2;
      int n = localRect.right;
      int i1 = localRect.left;
      if (Math.abs(k - m) < (n - i1) / 2)
      {
        j.p(localView, "child");
        localView.setAlpha(1.0F);
      }
      for (;;)
      {
        i += 1;
        break;
        j.p(localView, "child");
        localView.setAlpha(0.3F);
      }
    }
    AppMethodBeat.o(3185);
  }
  
  private final int bpp()
  {
    int i = 0;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(3187);
    if (getChildCount() == 1) {
      i = k;
    }
    for (;;)
    {
      AppMethodBeat.o(3187);
      return i;
      View localView;
      int m;
      if (ij())
      {
        j = getWidth() / 2;
        k = getChildCount();
        if (i < k)
        {
          localView = getChildAt(i);
          j.p(localView, "getChildAt(i)");
          m = localView.getLeft();
          localView = getChildAt(i);
          j.p(localView, "getChildAt(i)");
          m = (m + localView.getRight()) / 2;
          if (j - 1 > m) {}
          while (j + 1 < m)
          {
            i += 1;
            break;
          }
        }
      }
      else
      {
        k = getHeight() / 2;
        m = getChildCount();
        for (;;)
        {
          if (j >= m) {
            break label204;
          }
          localView = getChildAt(j);
          j.p(localView, "getChildAt(i)");
          int n = localView.getTop();
          localView = getChildAt(j);
          j.p(localView, "getChildAt(i)");
          i = j;
          if ((n + localView.getBottom()) / 2 == k) {
            break;
          }
          j += 1;
        }
      }
      label204:
      i = -1;
    }
  }
  
  private void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(3186);
    int i = bpp();
    if (i >= 0)
    {
      View localView = getChildAt(i);
      i = bv(localView);
      if ((i != this.lxQ) || (paramBoolean))
      {
        this.lxQ = i;
        m localm = this.lCm;
        if (localm != null)
        {
          i = this.lxQ;
          j.p(localView, "child");
          localm.h(Integer.valueOf(i), localView);
          AppMethodBeat.o(3186);
          return;
        }
      }
    }
    AppMethodBeat.o(3186);
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(3184);
    j.q(paramo, "recycler");
    j.q(params, "state");
    int i = super.a(paramInt, paramo, params);
    if (paramInt + 1 > i) {}
    while ((-1 < i) || (this.lCk != 1))
    {
      bpo();
      AppMethodBeat.o(3184);
      return i;
    }
    paramo = getChildAt(0);
    if (paramo != null) {}
    for (paramo = paramo.getParent();; paramo = null)
    {
      params = paramo;
      if (!(paramo instanceof RecyclerView)) {
        params = null;
      }
      paramo = (RecyclerView)params;
      ab.i(this.TAG, "horizontal Drag to end, " + paramInt + ' ' + i + ", " + paramo);
      if (paramo == null) {
        break;
      }
      paramo.iQ();
      break;
    }
  }
  
  public final void a(RecyclerView.s params)
  {
    AppMethodBeat.i(3181);
    ab.i(this.TAG, "onLayoutCompleted");
    super.a(params);
    hb(this.lCl);
    this.lCl = false;
    AppMethodBeat.o(3181);
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(3188);
    j.q(paramRecyclerView, "recyclerView");
    ab.i(this.TAG, "onItemsChanged");
    this.lCl = true;
    AppMethodBeat.o(3188);
  }
  
  public final void bX(int paramInt)
  {
    AppMethodBeat.i(3182);
    ab.i(this.TAG, "onScrollStateChanged ".concat(String.valueOf(paramInt)));
    super.bX(paramInt);
    this.lCk = paramInt;
    if (this.lCk == 0) {
      hb(false);
    }
    AppMethodBeat.o(3182);
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(3183);
    super.c(paramo, params);
    bpo();
    AppMethodBeat.o(3183);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3189);
    super.c(paramRecyclerView, paramInt1, paramInt2);
    if ((this.lxQ >= paramInt1) && (this.lxQ < paramInt1 + paramInt2)) {
      this.lCl = true;
    }
    AppMethodBeat.o(3189);
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3190);
    j.q(paramRecyclerView, "recyclerView");
    ab.i(this.TAG, "onItemsRemoved " + paramInt1 + ", " + paramInt2);
    super.d(paramRecyclerView, paramInt1, paramInt2);
    if ((this.lxQ >= paramInt1) && (this.lxQ < paramInt1 + paramInt2)) {
      this.lCl = true;
    }
    AppMethodBeat.o(3190);
  }
  
  public final void g(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3191);
    j.q(paramRecyclerView, "recyclerView");
    ab.i(this.TAG, "onItemsUpdated " + paramInt1 + ", " + paramInt2);
    super.g(paramRecyclerView, paramInt1, paramInt2);
    if ((this.lxQ >= paramInt1) && (this.lxQ < paramInt1 + paramInt2)) {
      this.lCl = true;
    }
    AppMethodBeat.o(3191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.c.a
 * JD-Core Version:    0.7.0.1
 */
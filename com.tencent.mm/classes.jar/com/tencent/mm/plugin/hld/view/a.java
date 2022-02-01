package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/GridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mHorizonSpan", "", "mVerticalSpan", "color", "mShowLastLine", "", "(IIIZ)V", "mDivider", "Landroid/graphics/drawable/Drawable;", "drawHorizontal", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getResult", "pos", "spanCount", "childCount", "getSpanCount", "isLastRaw", "onDrawOver", "Builder", "Companion", "plugin-hld_release"})
public final class a
  extends RecyclerView.h
{
  public static final b DHP;
  private final boolean CbQ;
  private final int CbR;
  private final int CbS;
  private final Drawable sQ;
  
  static
  {
    AppMethodBeat.i(217177);
    DHP = new b((byte)0);
    AppMethodBeat.o(217177);
  }
  
  private a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(217176);
    this.CbR = paramInt1;
    this.CbS = paramInt2;
    this.CbQ = paramBoolean;
    this.sQ = ((Drawable)new ColorDrawable(paramInt3));
    AppMethodBeat.o(217176);
  }
  
  private static boolean am(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 % paramInt2 == 0)
    {
      if (paramInt1 < paramInt3 - paramInt2) {}
    }
    else {
      while (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
        return true;
      }
    }
    return false;
  }
  
  private static int z(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(217174);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      i = ((GridLayoutManager)paramRecyclerView).ku();
    }
    for (;;)
    {
      AppMethodBeat.o(217174);
      return i;
      if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
        i = ((StaggeredGridLayoutManager)paramRecyclerView).ku();
      } else {
        i = -1;
      }
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(217172);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    int i = z(paramRecyclerView);
    params = paramRecyclerView.getAdapter();
    if (params == null) {
      p.iCn();
    }
    p.j(params, "parent.adapter!!");
    int n = params.getItemCount();
    paramView = paramView.getLayoutParams();
    if (paramView == null)
    {
      paramRect = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
      AppMethodBeat.o(217172);
      throw paramRect;
    }
    int i1 = ((RecyclerView.LayoutParams)paramView).lR();
    if (i1 < 0)
    {
      AppMethodBeat.o(217172);
      return;
    }
    int m = i1 % i;
    int j = this.CbS * m / i;
    int k = this.CbS;
    m = (m + 1) * this.CbS / i;
    paramView = paramRecyclerView.getLayoutManager();
    boolean bool;
    if ((paramView instanceof GridLayoutManager))
    {
      bool = am(i1, i, n);
      if ((!bool) || (this.CbQ)) {
        break label261;
      }
    }
    label261:
    for (i = 0;; i = this.CbR)
    {
      paramRect.set(j, 0, k - m, i);
      AppMethodBeat.o(217172);
      return;
      if ((paramView instanceof StaggeredGridLayoutManager))
      {
        if (((StaggeredGridLayoutManager)paramView).getOrientation() == 1)
        {
          bool = am(i1, i, n);
          break;
        }
        if ((i1 + 1) % i == 0)
        {
          bool = true;
          break;
        }
      }
      bool = false;
      break;
    }
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(217171);
    p.k(paramCanvas, "c");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    Object localObject;
    int k;
    int n;
    int i1;
    int i2;
    int i3;
    while (i < j)
    {
      params = paramRecyclerView.getChildAt(i);
      if ((i != j - 1) || (this.CbQ))
      {
        p.j(params, "child");
        localObject = params.getLayoutParams();
        if (localObject == null)
        {
          paramCanvas = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
          AppMethodBeat.o(217171);
          throw paramCanvas;
        }
        localObject = (RecyclerView.LayoutParams)localObject;
        k = params.getLeft();
        m = ((RecyclerView.LayoutParams)localObject).leftMargin;
        n = params.getRight();
        i1 = ((RecyclerView.LayoutParams)localObject).rightMargin;
        i2 = params.getBottom();
        i2 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i2;
        i3 = this.CbR;
        this.sQ.setBounds(k - m, i2, n + i1, i3 + i2);
        this.sQ.draw(paramCanvas);
      }
      i += 1;
    }
    int m = paramRecyclerView.getChildCount();
    i = 0;
    while (i < m)
    {
      if ((i != m - 1) || (this.CbQ))
      {
        localObject = paramRecyclerView.getChildAt(i);
        n = z(paramRecyclerView);
        params = (GridLayoutManager)paramRecyclerView.getLayoutManager();
        if (params != null)
        {
          params = params.getSpanSizeLookup();
          if (params == null) {
            break label447;
          }
          RecyclerView.v localv = paramRecyclerView.aQ((View)localObject);
          p.j(localv, "parent.getChildViewHolder(child)");
          j = params.am(localv.md(), z(paramRecyclerView));
          label289:
          if (params == null) {
            break label453;
          }
          localv = paramRecyclerView.aQ((View)localObject);
          p.j(localv, "parent.getChildViewHolder(child)");
          k = params.cx(localv.md());
          label319:
          params = new StringBuilder("drawVertical ").append(i).append(' ').append(n).append(' ').append(j).append(' ').append(k).append(' ');
          if ((j + k) % n != 0) {
            break label459;
          }
        }
        label447:
        label453:
        label459:
        for (boolean bool = true;; bool = false)
        {
          Log.d("WxIme.GridItemDecoration", bool);
          if ((k + j) % n == 0) {
            break label559;
          }
          p.j(localObject, "child");
          params = ((View)localObject).getLayoutParams();
          if (params != null) {
            break label465;
          }
          paramCanvas = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
          AppMethodBeat.o(217171);
          throw paramCanvas;
          params = null;
          break;
          j = 0;
          break label289;
          k = 0;
          break label319;
        }
        label465:
        params = (RecyclerView.LayoutParams)params;
        j = ((View)localObject).getTop();
        k = params.topMargin;
        n = ((View)localObject).getBottom();
        i1 = params.bottomMargin;
        i2 = this.CbR;
        i3 = ((View)localObject).getRight();
        i3 = params.rightMargin + i3;
        int i4 = this.CbS;
        this.sQ.setBounds(i3 - i4, j - k, i3, n + i1 + i2);
        this.sQ.draw(paramCanvas);
      }
      label559:
      i += 1;
    }
    AppMethodBeat.o(217171);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/GridItemDecoration$Builder;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mColor", "", "mHorizonSpan", "mResources", "Landroid/content/res/Resources;", "mShowLastLine", "", "mVerticalSpan", "build", "Lcom/tencent/mm/plugin/hld/view/GridItemDecoration;", "setColor", "color", "setColorResource", "resource", "setHorizontalSpan", "horizontal", "", "setShowLastLine", "show", "setVerticalSpan", "mVertical", "vertical", "plugin-hld_release"})
  public static final class a
  {
    public boolean CbQ;
    private int CbR;
    private int CbS;
    private int mColor;
    private final Context mContext;
    private final Resources mResources;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(210074);
      this.mContext = paramContext;
      paramContext = this.mContext.getResources();
      p.j(paramContext, "mContext.resources");
      this.mResources = paramContext;
      this.CbQ = true;
      this.CbR = 0;
      this.CbS = 0;
      this.mColor = -1;
      AppMethodBeat.o(210074);
    }
    
    public final a UL(@androidx.annotation.a int paramInt)
    {
      AppMethodBeat.i(210068);
      this.mColor = androidx.core.content.a.w(this.mContext, paramInt);
      AppMethodBeat.o(210068);
      return this;
    }
    
    public final a UM(int paramInt)
    {
      AppMethodBeat.i(210070);
      this.CbS = this.mResources.getDimensionPixelSize(paramInt);
      AppMethodBeat.o(210070);
      return this;
    }
    
    public final a UN(int paramInt)
    {
      AppMethodBeat.i(210072);
      this.CbR = this.mResources.getDimensionPixelSize(paramInt);
      AppMethodBeat.o(210072);
      return this;
    }
    
    public final a eHD()
    {
      AppMethodBeat.i(210073);
      a locala = new a(this.CbR, this.CbS, this.mColor, this.CbQ, (byte)0);
      AppMethodBeat.o(210073);
      return locala;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/GridItemDecoration$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.a
 * JD-Core Version:    0.7.0.1
 */
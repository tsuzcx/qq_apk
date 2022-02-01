package com.tencent.mm.plugin.gallery.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$createItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "greenColor", "", "getGreenColor", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "plugin-gallery_release"})
public final class GalleryPickerFragment$c
  extends RecyclerView.h
{
  private final Paint paint;
  private final int tTd;
  
  GalleryPickerFragment$c()
  {
    AppMethodBeat.i(164813);
    Context localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    this.tTd = localContext.getResources().getColor(2131101171);
    this.paint = new Paint();
    this.paint.setColor(this.tTd);
    this.paint.setStrokeWidth(6.4F);
    this.paint.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(164813);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(164811);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(paramt, "state");
    super.a(paramRect, paramView, paramRecyclerView, paramt);
    int i = RecyclerView.bx(paramView);
    if (i % 4 == 0) {
      paramRect.left = 4;
    }
    paramRect.right = 4;
    paramRect.bottom = 4;
    if (i < 0)
    {
      AppMethodBeat.o(164811);
      return;
    }
    if (4 > i) {
      paramRect.top = 4;
    }
    AppMethodBeat.o(164811);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(164812);
    p.h(paramCanvas, "c");
    p.h(paramRecyclerView, "parent");
    p.h(paramt, "state");
    Object localObject = paramRecyclerView.ci(GalleryPickerFragment.g(this.tTe));
    if (localObject != null) {}
    for (localObject = ((RecyclerView.w)localObject).auu;; localObject = null)
    {
      if (localObject != null) {
        paramCanvas.drawRect(new Rect(((View)localObject).getLeft() + 2, ((View)localObject).getTop() + 2, ((View)localObject).getRight() - 2, ((View)localObject).getBottom() - 2), this.paint);
      }
      super.a(paramCanvas, paramRecyclerView, paramt);
      AppMethodBeat.o(164812);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment.c
 * JD-Core Version:    0.7.0.1
 */
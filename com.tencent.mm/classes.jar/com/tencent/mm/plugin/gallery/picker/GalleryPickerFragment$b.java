package com.tencent.mm.plugin.gallery.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$createItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "greenColor", "", "getGreenColor", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GalleryPickerFragment$b
  extends RecyclerView.h
{
  private final int HJg;
  private final Paint paint;
  
  GalleryPickerFragment$b(GalleryPickerFragment paramGalleryPickerFragment)
  {
    AppMethodBeat.i(164813);
    this.HJg = MMApplicationContext.getContext().getResources().getColor(b.b.wechat_green);
    this.paint = new Paint();
    this.paint.setColor(this.HJg);
    this.paint.setStrokeWidth(6.4F);
    this.paint.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(164813);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int j = 0;
    AppMethodBeat.i(289303);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    int k = RecyclerView.bB(paramView);
    if (k % 4 == 0) {
      paramRect.left = 4;
    }
    paramRect.right = 4;
    paramRect.bottom = 4;
    int i = j;
    if (k >= 0)
    {
      i = j;
      if (k < 4) {
        i = 1;
      }
    }
    if (i != 0) {
      paramRect.top = 4;
    }
    AppMethodBeat.o(289303);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(289310);
    s.u(paramCanvas, "c");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    Object localObject = paramRecyclerView.fU(GalleryPickerFragment.e(this.HJh));
    if (localObject == null) {}
    for (localObject = null;; localObject = ((RecyclerView.v)localObject).caK)
    {
      if (localObject != null) {
        paramCanvas.drawRect(new Rect(((View)localObject).getLeft() + 2, ((View)localObject).getTop() + 2, ((View)localObject).getRight() - 2, ((View)localObject).getBottom() - 2), this.paint);
      }
      super.a(paramCanvas, paramRecyclerView, params);
      AppMethodBeat.o(289310);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment.b
 * JD-Core Version:    0.7.0.1
 */
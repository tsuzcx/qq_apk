package com.tencent.mm.plugin.gallery.picker.manager;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/manager/SpeedGirdLayoutManager;", "Landroid/support/v7/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "spanCount", "(Landroid/content/Context;I)V", "orientation", "reverseLayout", "", "(Landroid/content/Context;IIZ)V", "speedRadio", "", "getSpeedRadio", "()F", "setSpeedRadio", "(F)V", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollVerticallyBy", "dy", "plugin-gallery_release"})
public final class SpeedGirdLayoutManager
  extends GridLayoutManager
{
  private float xlB = 1.0F;
  
  public SpeedGirdLayoutManager(Context paramContext)
  {
    super(4);
  }
  
  public SpeedGirdLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(164913);
    super.onLayoutChildren(paramn, params);
    AppMethodBeat.o(164913);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(164914);
    paramInt = (int)(super.scrollVerticallyBy(paramInt, paramn, params) * this.xlB);
    AppMethodBeat.o(164914);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.manager.SpeedGirdLayoutManager
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.gallery.picker.manager;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/manager/SpeedGirdLayoutManager;", "Landroid/support/v7/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "spanCount", "(Landroid/content/Context;I)V", "orientation", "reverseLayout", "", "(Landroid/content/Context;IIZ)V", "speedRadio", "", "getSpeedRadio", "()F", "setSpeedRadio", "(F)V", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollVerticallyBy", "dy", "plugin-gallery_release"})
public final class SpeedGirdLayoutManager
  extends GridLayoutManager
{
  private float sMQ = 1.0F;
  
  public SpeedGirdLayoutManager()
  {
    super(4);
  }
  
  public SpeedGirdLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(164914);
    paramInt = (int)(super.b(paramInt, paramo, paramt) * this.sMQ);
    AppMethodBeat.o(164914);
    return paramInt;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(164913);
    super.c(paramo, paramt);
    AppMethodBeat.o(164913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.manager.SpeedGirdLayoutManager
 * JD-Core Version:    0.7.0.1
 */
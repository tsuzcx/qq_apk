package com.tencent.mm.plugin.gallery.picker.manager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/manager/SpeedGirdLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "spanCount", "(Landroid/content/Context;I)V", "orientation", "reverseLayout", "", "(Landroid/content/Context;IIZ)V", "speedRadio", "", "getSpeedRadio", "()F", "setSpeedRadio", "(F)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollVerticallyBy", "dy", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SpeedGirdLayoutManager
  extends GridLayoutManager
{
  private float HKi = 1.0F;
  
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
    AppMethodBeat.i(289357);
    super.onLayoutChildren(paramn, params);
    AppMethodBeat.o(289357);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(289364);
    paramInt = (int)(super.scrollVerticallyBy(paramInt, paramn, params) * this.HKi);
    AppMethodBeat.o(289364);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.manager.SpeedGirdLayoutManager
 * JD-Core Version:    0.7.0.1
 */
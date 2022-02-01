package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderMaxSizeLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "maxHeight", "maxWidth", "getMaxHeight", "getMaxWidth", "initAttribute", "", "onMeasure", "widthSpec", "heightSpec", "setMaxHeight", "setMaxWidth", "plugin-finder_release"})
public final class FinderMaxSizeLayout
  extends FrameLayout
{
  private final String TAG;
  private int maxHeight;
  private int maxWidth;
  
  public FinderMaxSizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(282407);
    this.TAG = "Finder.FinderMaxSizeLayout";
    b(paramAttributeSet, 0);
    AppMethodBeat.o(282407);
  }
  
  public FinderMaxSizeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(282408);
    this.TAG = "Finder.FinderMaxSizeLayout";
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(282408);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(282406);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.l.FinderMaxSizeLayout, paramInt, 0);
      this.maxHeight = ((int)paramAttributeSet.getDimension(b.l.FinderMaxSizeLayout_max_height, 0.0F));
      this.maxWidth = ((int)paramAttributeSet.getDimension(b.l.FinderMaxSizeLayout_max_width, 0.0F));
      paramAttributeSet.recycle();
      Log.i(this.TAG, "[initAttribute],maxHeight:" + this.maxHeight + ", maxWidth:" + this.maxWidth);
    }
    AppMethodBeat.o(282406);
  }
  
  public final int getMaxHeight()
  {
    return this.maxHeight;
  }
  
  public final int getMaxWidth()
  {
    return this.maxWidth;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(282405);
    if (this.maxHeight > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, -2147483648);
    }
    if (this.maxWidth > 0) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(282405);
  }
  
  public final void setMaxHeight(int paramInt)
  {
    this.maxHeight = paramInt;
  }
  
  public final void setMaxWidth(int paramInt)
  {
    this.maxWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderMaxSizeLayout
 * JD-Core Version:    0.7.0.1
 */
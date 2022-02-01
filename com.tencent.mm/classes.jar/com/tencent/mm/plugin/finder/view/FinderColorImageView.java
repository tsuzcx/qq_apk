package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderColorImageView;", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setColorFilter", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderColorImageView
  extends WeImageView
{
  public FinderColorImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FinderColorImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(345399);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(345399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderColorImageView
 * JD-Core Version:    0.7.0.1
 */
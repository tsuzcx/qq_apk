package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.l;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/StrokeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "strokeColor", "strokeWidth", "", "initAttribute", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "plugin-finder_release"})
public final class StrokeTextView
  extends AppCompatTextView
{
  private int strokeColor;
  private float strokeWidth;
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(249479);
    b(paramAttributeSet, 0);
    AppMethodBeat.o(249479);
  }
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(249480);
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(249480);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(249476);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.l.StrokeTextView, paramInt, 0);
      this.strokeWidth = paramAttributeSet.getFloat(b.l.StrokeTextView_finderStrokeWidth, 4.0F);
      this.strokeColor = paramAttributeSet.getColor(b.l.StrokeTextView_finderStrokeColor, getResources().getColor(b.c.finder_btn_fullscreen_disable_color));
      AppMethodBeat.o(249476);
      return;
    }
    this.strokeWidth = 4.0F;
    this.strokeColor = getResources().getColor(b.c.finder_btn_fullscreen_disable_color);
    AppMethodBeat.o(249476);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(249478);
    Object localObject = getTextColors();
    p.j(localObject, "textColors");
    setTextColor(this.strokeColor);
    TextPaint localTextPaint = getPaint();
    p.j(localTextPaint, "this.paint");
    localTextPaint.setStrokeWidth(this.strokeWidth);
    localTextPaint = getPaint();
    p.j(localTextPaint, "this.paint");
    localTextPaint.setStyle(Paint.Style.STROKE);
    super.onDraw(paramCanvas);
    setTextColor((ColorStateList)localObject);
    localObject = getPaint();
    p.j(localObject, "this.paint");
    ((TextPaint)localObject).setStrokeWidth(this.strokeWidth);
    localObject = getPaint();
    p.j(localObject, "this.paint");
    ((TextPaint)localObject).setStyle(Paint.Style.FILL);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(249478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.StrokeTextView
 * JD-Core Version:    0.7.0.1
 */
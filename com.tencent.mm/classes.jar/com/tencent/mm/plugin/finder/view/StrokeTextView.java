package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/StrokeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "strokeColor", "strokeTextView", "Landroid/widget/TextView;", "strokeWidth", "", "drawStrokeText", "", "canvas", "Landroid/graphics/Canvas;", "initAttribute", "onDraw", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setLayoutParams", "params", "Landroid/view/ViewGroup$LayoutParams;", "setText", "text", "", "type", "Landroid/widget/TextView$BufferType;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StrokeTextView
  extends AppCompatTextView
{
  private TextView GFz;
  private int strokeColor;
  private float strokeWidth;
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345155);
    this.GFz = new TextView(paramContext, paramAttributeSet);
    b(paramAttributeSet, 0);
    AppMethodBeat.o(345155);
  }
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345163);
    this.GFz = new TextView(paramContext, paramAttributeSet, paramInt);
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(345163);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(345173);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, e.j.StrokeTextView, paramInt, 0);
    s.s(paramAttributeSet, "context.obtainStyledAttr…okeTextView, defStyle, 0)");
    this.strokeWidth = paramAttributeSet.getFloat(e.j.StrokeTextView_finderStrokeWidth, 4.0F);
    this.strokeColor = paramAttributeSet.getColor(e.j.StrokeTextView_finderStrokeColor, getResources().getColor(e.b.finder_btn_fullscreen_disable_color));
    AppMethodBeat.o(345173);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(345235);
    TextView localTextView = this.GFz;
    if (localTextView != null)
    {
      localTextView.getPaint().setStrokeWidth(this.strokeWidth);
      localTextView.getPaint().setStyle(Paint.Style.STROKE);
      localTextView.setTextColor(this.strokeColor);
      localTextView.setGravity(getGravity());
      localTextView.setTextSize(0, getTextSize());
      localTextView.draw(paramCanvas);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(345235);
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(345226);
    TextView localTextView = this.GFz;
    if (localTextView != null) {
      localTextView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(345226);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(345221);
    TextView localTextView = this.GFz;
    if (localTextView != null) {
      localTextView.measure(paramInt1, paramInt2);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(345221);
  }
  
  public final void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(345182);
    TextView localTextView = this.GFz;
    if (localTextView != null) {
      localTextView.setLayoutParams(paramLayoutParams);
    }
    super.setLayoutParams(paramLayoutParams);
    AppMethodBeat.o(345182);
  }
  
  public final void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(345191);
    TextView localTextView = this.GFz;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
    super.setText(paramCharSequence, paramBufferType);
    AppMethodBeat.o(345191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.StrokeTextView
 * JD-Core Version:    0.7.0.1
 */
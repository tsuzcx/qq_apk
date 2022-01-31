package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.d.a.c;
import a.d.b.g;
import a.e.d;
import a.n;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.emojicapture.a.b;

public final class TextColorSelector
  extends View
{
  private static final int[] jqj = { -1, -16777216, -1686720, -210175, -14296905, -7940353, -17734 };
  private static final int[] jqk = { -16777216, -1, -6349311, -1406464, -15036037, -14848102, -2203295 };
  public static final TextColorSelector.a jql = new TextColorSelector.a((byte)0);
  private final String TAG = "TextColorSelector";
  private int aJH = -1;
  private Paint gaZ = new Paint(1);
  private final int jqb = -1;
  private float jqc;
  private int jqd = -1;
  private float jqe = getResources().getDimension(a.b.editor_color_dot_inner_radius);
  private float jqf = getResources().getDimension(a.b.editor_color_dot_outer_radius);
  private float jqg = getResources().getDimension(a.b.editor_color_dot_select_inner_radius);
  private float jqh = getResources().getDimension(a.b.editor_color_dot_select_outer_radius);
  private c<? super Integer, ? super Integer, n> jqi;
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.gaZ.setStyle(Paint.Style.FILL);
  }
  
  private final int P(float paramFloat1, float paramFloat2)
  {
    a.e.a locala = (a.e.a)new d(0, getMeasuredHeight());
    g.k(locala, "$receiver");
    Integer localInteger;
    if ((paramFloat2 >= -2.147484E+009F) && (paramFloat2 <= 2.147484E+009F))
    {
      localInteger = Integer.valueOf((int)paramFloat2);
      if (localInteger == null) {
        break label110;
      }
    }
    label110:
    for (boolean bool = locala.contains((Comparable)localInteger);; bool = false)
    {
      if (!bool) {
        break label116;
      }
      int i = Math.round((paramFloat1 - getPaddingLeft() - this.jqf) / this.jqc);
      if ((i < 0) || (i >= jqj.length)) {
        break label116;
      }
      return i;
      localInteger = null;
      break;
    }
    label116:
    return -1;
  }
  
  public final c<Integer, Integer, n> getColorSelectCallback()
  {
    return this.jqi;
  }
  
  public final int getStrokeColor()
  {
    int i = jqk.length;
    int j = this.aJH;
    if (j < 0) {}
    while (i < j) {
      return -16777216;
    }
    return jqk[this.aJH];
  }
  
  public final int getTextColor()
  {
    int i = jqj.length;
    int j = this.aJH;
    if (j < 0) {}
    while (i < j) {
      return -1;
    }
    return jqj[this.aJH];
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    g.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.jqc = ((paramCanvas.getWidth() - getPaddingLeft() - getPaddingRight() - this.jqf * 2.0F) / (jqj.length - 1));
    float f1 = paramCanvas.getHeight() / 2.0F;
    int i = 0;
    int j = jqj.length;
    if (i < j)
    {
      float f2 = this.jqc * i + this.jqf + getPaddingLeft();
      this.gaZ.setColor(this.jqb);
      if (i == this.aJH)
      {
        paramCanvas.drawCircle(f2, f1, this.jqh, this.gaZ);
        label123:
        this.gaZ.setColor(jqj[i]);
        if (i != this.aJH) {
          break label185;
        }
        paramCanvas.drawCircle(f2, f1, this.jqg, this.gaZ);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(f2, f1, this.jqf, this.gaZ);
        break label123;
        label185:
        paramCanvas.drawCircle(f2, f1, this.jqe, this.gaZ);
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    g.k(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return true;
      this.jqd = P(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      this.jqd = -1;
      continue;
      int i = P(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i >= 0) && (i == this.jqd))
      {
        this.aJH = i;
        if (this.jqi != null)
        {
          paramMotionEvent = this.jqi;
          if (paramMotionEvent == null) {
            g.cUk();
          }
          paramMotionEvent.l(Integer.valueOf(jqj[this.aJH]), Integer.valueOf(jqk[this.aJH]));
        }
      }
      this.jqd = -1;
      postInvalidate();
    }
  }
  
  public final void setColor(int paramInt)
  {
    int i = a.a.a.i(jqj, paramInt);
    paramInt = i;
    if (i == -1) {
      paramInt = 0;
    }
    this.aJH = paramInt;
  }
  
  public final void setColorSelectCallback(c<? super Integer, ? super Integer, n> paramc)
  {
    this.jqi = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextColorSelector
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.media.editor.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.k.a;
import d.k.d;
import d.k.h;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/view/TextColorSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "colorArray", "", "colorSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getColorSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "setColorSelectedCallback", "(Lkotlin/jvm/functions/Function1;)V", "dotInterval", "", "outerColor", "paint", "Landroid/graphics/Paint;", "radiusNormalInner", "radiusNormalOuter", "radiusSelectInner", "radiusSelectOuter", "selectedIndex", "touchDownIndex", "getNearestIndex", "x", "y", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setColorList", "setSelected", "select", "plugin-mediaeditor_release"})
public final class TextColorSelector
  extends View
{
  private final String TAG;
  private int boX;
  private final int gqa;
  private float gqb;
  private int[] gqc;
  private int gqd;
  private float gqe;
  private float gqf;
  private float gqg;
  private float gqh;
  private b<? super Integer, y> gqi;
  private Paint paint;
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(93621);
    this.TAG = "TextColorSelector";
    this.gqa = -1;
    this.paint = new Paint(1);
    this.gqc = new int[0];
    this.gqd = -1;
    this.boX = -1;
    this.gqe = getResources().getDimension(2131166174);
    this.gqf = getResources().getDimension(2131166175);
    this.gqg = getResources().getDimension(2131166176);
    this.gqh = getResources().getDimension(2131166177);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(93621);
  }
  
  private final int w(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(93620);
    if (h.a((a)new d(0, getMeasuredHeight()), paramFloat2))
    {
      int i = Math.round((paramFloat1 - getPaddingLeft() - this.gqf) / this.gqb);
      if ((i >= 0) && (i < this.gqc.length))
      {
        AppMethodBeat.o(93620);
        return i;
      }
    }
    AppMethodBeat.o(93620);
    return -1;
  }
  
  public final b<Integer, y> getColorSelectedCallback()
  {
    return this.gqi;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(93618);
    k.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.gqb = ((getWidth() - getPaddingLeft() - getPaddingRight() - this.gqf * 2.0F) / (this.gqc.length - 1));
    float f1 = getHeight() / 2.0F;
    int i = 0;
    int j = this.gqc.length;
    if (i < j)
    {
      float f2 = this.gqb * i + this.gqf + getPaddingLeft();
      this.paint.setColor(this.gqa);
      if (i == this.boX)
      {
        paramCanvas.drawCircle(f2, f1, this.gqh, this.paint);
        label130:
        this.paint.setColor(this.gqc[i]);
        if (i != this.boX) {
          break label193;
        }
        paramCanvas.drawCircle(f2, f1, this.gqg, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(f2, f1, this.gqf, this.paint);
        break label130;
        label193:
        paramCanvas.drawCircle(f2, f1, this.gqe, this.paint);
      }
    }
    AppMethodBeat.o(93618);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(93619);
    k.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(93619);
      return true;
      this.gqd = w(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      this.gqd = -1;
      continue;
      int i = w(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i >= 0) && (i == this.gqd))
      {
        this.boX = i;
        paramMotionEvent = this.gqi;
        if (paramMotionEvent != null) {
          paramMotionEvent.aA(Integer.valueOf(this.boX));
        }
      }
      this.gqd = -1;
      postInvalidate();
    }
  }
  
  public final void setColorList(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(93617);
    k.h(paramArrayOfInt, "colorArray");
    this.gqc = paramArrayOfInt;
    AppMethodBeat.o(93617);
  }
  
  public final void setColorSelectedCallback(b<? super Integer, y> paramb)
  {
    this.gqi = paramb;
  }
  
  public final void setSelected(int paramInt)
  {
    this.boX = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.view.TextColorSelector
 * JD-Core Version:    0.7.0.1
 */
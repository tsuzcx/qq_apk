package com.tencent.mm.media.editor.view;

import a.f.a.b;
import a.f.b.j;
import a.i.a;
import a.i.d;
import a.i.e;
import a.l;
import a.y;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/view/TextColorSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "colorArray", "", "colorSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getColorSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "setColorSelectedCallback", "(Lkotlin/jvm/functions/Function1;)V", "dotInterval", "", "outerColor", "paint", "Landroid/graphics/Paint;", "radiusNormalInner", "radiusNormalOuter", "radiusSelectInner", "radiusSelectOuter", "selectedIndex", "touchDownIndex", "getNearestIndex", "x", "y", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setColorList", "setSelected", "select", "plugin-mediaeditor_release"})
public final class TextColorSelector
  extends View
{
  private final String TAG;
  private int aRn;
  private final int eTX;
  private float eTY;
  private int[] eTZ;
  private int eUa;
  private float eUb;
  private float eUc;
  private float eUd;
  private float eUe;
  private b<? super Integer, y> eUf;
  private Paint paint;
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(12930);
    this.TAG = "TextColorSelector";
    this.eTX = -1;
    this.paint = new Paint(1);
    this.eTZ = new int[0];
    this.eUa = -1;
    this.aRn = -1;
    this.eUb = getResources().getDimension(2131428322);
    this.eUc = getResources().getDimension(2131428323);
    this.eUd = getResources().getDimension(2131428324);
    this.eUe = getResources().getDimension(2131428325);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(12930);
  }
  
  private final int F(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(12929);
    if (e.a((a)new d(0, getMeasuredHeight()), paramFloat2))
    {
      int i = Math.round((paramFloat1 - getPaddingLeft() - this.eUc) / this.eTY);
      if ((i >= 0) && (i < this.eTZ.length))
      {
        AppMethodBeat.o(12929);
        return i;
      }
    }
    AppMethodBeat.o(12929);
    return -1;
  }
  
  public final b<Integer, y> getColorSelectedCallback()
  {
    return this.eUf;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12927);
    j.q(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.eTY = ((getWidth() - getPaddingLeft() - getPaddingRight() - this.eUc * 2.0F) / (this.eTZ.length - 1));
    float f1 = getHeight() / 2.0F;
    int i = 0;
    int j = this.eTZ.length;
    if (i < j)
    {
      float f2 = this.eTY * i + this.eUc + getPaddingLeft();
      this.paint.setColor(this.eTX);
      if (i == this.aRn)
      {
        paramCanvas.drawCircle(f2, f1, this.eUe, this.paint);
        label131:
        this.paint.setColor(this.eTZ[i]);
        if (i != this.aRn) {
          break label194;
        }
        paramCanvas.drawCircle(f2, f1, this.eUd, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(f2, f1, this.eUc, this.paint);
        break label131;
        label194:
        paramCanvas.drawCircle(f2, f1, this.eUb, this.paint);
      }
    }
    AppMethodBeat.o(12927);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(12928);
    j.q(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(12928);
      return true;
      this.eUa = F(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      this.eUa = -1;
      continue;
      int i = F(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i >= 0) && (i == this.eUa))
      {
        this.aRn = i;
        paramMotionEvent = this.eUf;
        if (paramMotionEvent != null) {
          paramMotionEvent.S(Integer.valueOf(this.aRn));
        }
      }
      this.eUa = -1;
      postInvalidate();
    }
  }
  
  public final void setColorList(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(12926);
    j.q(paramArrayOfInt, "colorArray");
    this.eTZ = paramArrayOfInt;
    AppMethodBeat.o(12926);
  }
  
  public final void setColorSelectedCallback(b<? super Integer, y> paramb)
  {
    this.eUf = paramb;
  }
  
  public final void setSelected(int paramInt)
  {
    this.aRn = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.view.TextColorSelector
 * JD-Core Version:    0.7.0.1
 */
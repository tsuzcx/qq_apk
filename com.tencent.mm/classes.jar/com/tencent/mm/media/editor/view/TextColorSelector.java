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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/view/TextColorSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "colorArray", "", "colorSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getColorSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "setColorSelectedCallback", "(Lkotlin/jvm/functions/Function1;)V", "dotInterval", "", "outerColor", "paint", "Landroid/graphics/Paint;", "radiusNormalInner", "radiusNormalOuter", "radiusSelectInner", "radiusSelectOuter", "selectedIndex", "touchDownIndex", "getNearestIndex", "x", "y", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setColorList", "setSelected", "select", "plugin-mediaeditor_release"})
public final class TextColorSelector
  extends View
{
  private final String TAG;
  private int bns;
  private final int gQI;
  private float gQJ;
  private int[] gQK;
  private int gQL;
  private float gQM;
  private float gQN;
  private float gQO;
  private float gQP;
  private b<? super Integer, y> gQQ;
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
    this.gQI = -1;
    this.paint = new Paint(1);
    this.gQK = new int[0];
    this.gQL = -1;
    this.bns = -1;
    this.gQM = getResources().getDimension(2131166174);
    this.gQN = getResources().getDimension(2131166175);
    this.gQO = getResources().getDimension(2131166176);
    this.gQP = getResources().getDimension(2131166177);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(93621);
  }
  
  private final int z(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(93620);
    if (h.a((a)new d(0, getMeasuredHeight()), paramFloat2))
    {
      int i = Math.round((paramFloat1 - getPaddingLeft() - this.gQN) / this.gQJ);
      if ((i >= 0) && (i < this.gQK.length))
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
    return this.gQQ;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(93618);
    k.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.gQJ = ((getWidth() - getPaddingLeft() - getPaddingRight() - this.gQN * 2.0F) / (this.gQK.length - 1));
    float f1 = getHeight() / 2.0F;
    int i = 0;
    int j = this.gQK.length;
    if (i < j)
    {
      float f2 = this.gQJ * i + this.gQN + getPaddingLeft();
      this.paint.setColor(this.gQI);
      if (i == this.bns)
      {
        paramCanvas.drawCircle(f2, f1, this.gQP, this.paint);
        label130:
        this.paint.setColor(this.gQK[i]);
        if (i != this.bns) {
          break label193;
        }
        paramCanvas.drawCircle(f2, f1, this.gQO, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(f2, f1, this.gQN, this.paint);
        break label130;
        label193:
        paramCanvas.drawCircle(f2, f1, this.gQM, this.paint);
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
      this.gQL = z(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      this.gQL = -1;
      continue;
      int i = z(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i >= 0) && (i == this.gQL))
      {
        this.bns = i;
        paramMotionEvent = this.gQQ;
        if (paramMotionEvent != null) {
          paramMotionEvent.ay(Integer.valueOf(this.bns));
        }
      }
      this.gQL = -1;
      postInvalidate();
    }
  }
  
  public final void setColorList(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(93617);
    k.h(paramArrayOfInt, "colorArray");
    this.gQK = paramArrayOfInt;
    AppMethodBeat.o(93617);
  }
  
  public final void setColorSelectedCallback(b<? super Integer, y> paramb)
  {
    this.gQQ = paramb;
  }
  
  public final void setSelected(int paramInt)
  {
    this.bns = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.editor.view.TextColorSelector
 * JD-Core Version:    0.7.0.1
 */
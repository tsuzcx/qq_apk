package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backColor", "", "getBackColor", "()I", "setBackColor", "(I)V", "foreColor", "getForeColor", "setForeColor", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "progress", "getProgress", "setProgress", "draw", "", "canvas", "Landroid/graphics/Canvas;", "init", "plugin-finder_release"})
public final class FinderPostProgressView
  extends View
{
  public Paint paint;
  private int progress;
  private int tgE;
  private int tgF;
  
  public FinderPostProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168400);
    this.paint = new Paint();
    paramContext = this.paint;
    if (paramContext == null) {
      p.bdF("paint");
    }
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext = this.paint;
    if (paramContext == null) {
      p.bdF("paint");
    }
    paramContext.setStrokeWidth(getResources().getDimension(2131166296));
    paramContext = this.paint;
    if (paramContext == null) {
      p.bdF("paint");
    }
    paramContext.setAntiAlias(true);
    this.tgE = getResources().getColor(2131099656);
    this.tgF = getResources().getColor(2131099778);
    AppMethodBeat.o(168400);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(168399);
    super.draw(paramCanvas);
    int i = getWidth() / 2;
    Object localObject = this.paint;
    if (localObject == null) {
      p.bdF("paint");
    }
    float f1 = ((Paint)localObject).getStrokeWidth();
    int j = (int)(i - f1 / 2.0F);
    localObject = this.paint;
    if (localObject == null) {
      p.bdF("paint");
    }
    ((Paint)localObject).setColor(this.tgE);
    localObject = this.paint;
    if (localObject == null) {
      p.bdF("paint");
    }
    ((Paint)localObject).setAntiAlias(true);
    localObject = this.paint;
    if (localObject == null) {
      p.bdF("paint");
    }
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    if (paramCanvas != null)
    {
      f1 = i;
      float f2 = i;
      float f3 = j;
      localObject = this.paint;
      if (localObject == null) {
        p.bdF("paint");
      }
      paramCanvas.drawCircle(f1, f2, f3, (Paint)localObject);
    }
    localObject = this.paint;
    if (localObject == null) {
      p.bdF("paint");
    }
    ((Paint)localObject).setColor(this.tgF);
    localObject = new RectF(i - j, i - j, i + j, i + j);
    f1 = this.progress * 360 / 100.0F;
    if (paramCanvas != null)
    {
      Paint localPaint = this.paint;
      if (localPaint == null) {
        p.bdF("paint");
      }
      paramCanvas.drawArc((RectF)localObject, -90.0F, f1, false, localPaint);
      AppMethodBeat.o(168399);
      return;
    }
    AppMethodBeat.o(168399);
  }
  
  public final int getBackColor()
  {
    return this.tgE;
  }
  
  public final int getForeColor()
  {
    return this.tgF;
  }
  
  public final Paint getPaint()
  {
    AppMethodBeat.i(168397);
    Paint localPaint = this.paint;
    if (localPaint == null) {
      p.bdF("paint");
    }
    AppMethodBeat.o(168397);
    return localPaint;
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public final void setBackColor(int paramInt)
  {
    this.tgE = paramInt;
  }
  
  public final void setForeColor(int paramInt)
  {
    this.tgF = paramInt;
  }
  
  public final void setPaint(Paint paramPaint)
  {
    AppMethodBeat.i(168398);
    p.h(paramPaint, "<set-?>");
    this.paint = paramPaint;
    AppMethodBeat.o(168398);
  }
  
  public final void setProgress(int paramInt)
  {
    this.progress = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostProgressView
 * JD-Core Version:    0.7.0.1
 */
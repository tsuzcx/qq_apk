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
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backColor", "", "getBackColor", "()I", "setBackColor", "(I)V", "foreColor", "getForeColor", "setForeColor", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "progress", "getProgress", "setProgress", "draw", "", "canvas", "Landroid/graphics/Canvas;", "init", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPostProgressView
  extends View
{
  private int GBJ;
  private int GBK;
  public Paint paint;
  private int progress;
  
  public FinderPostProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168400);
    setPaint(new Paint());
    getPaint().setStyle(Paint.Style.STROKE);
    getPaint().setStrokeWidth(getResources().getDimension(e.c.finder_0_25_A));
    getPaint().setAntiAlias(true);
    this.GBJ = getResources().getColor(e.b.BW_0_Alpha_0_1);
    this.GBK = getResources().getColor(e.b.Orange_100);
    AppMethodBeat.o(168400);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(168399);
    super.draw(paramCanvas);
    int i = getWidth() / 2;
    float f = getPaint().getStrokeWidth();
    int j = (int)(i - f / 2.0F);
    getPaint().setColor(this.GBJ);
    getPaint().setAntiAlias(true);
    getPaint().setStyle(Paint.Style.STROKE);
    if (paramCanvas != null) {
      paramCanvas.drawCircle(i, i, j, getPaint());
    }
    getPaint().setColor(this.GBK);
    RectF localRectF = new RectF(i - j, i - j, i + j, i + j);
    f = this.progress * 360 / 100.0F;
    if (paramCanvas != null) {
      paramCanvas.drawArc(localRectF, -90.0F, f, false, getPaint());
    }
    AppMethodBeat.o(168399);
  }
  
  public final int getBackColor()
  {
    return this.GBJ;
  }
  
  public final int getForeColor()
  {
    return this.GBK;
  }
  
  public final Paint getPaint()
  {
    AppMethodBeat.i(168397);
    Paint localPaint = this.paint;
    if (localPaint != null)
    {
      AppMethodBeat.o(168397);
      return localPaint;
    }
    s.bIx("paint");
    AppMethodBeat.o(168397);
    return null;
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public final void setBackColor(int paramInt)
  {
    this.GBJ = paramInt;
  }
  
  public final void setForeColor(int paramInt)
  {
    this.GBK = paramInt;
  }
  
  public final void setPaint(Paint paramPaint)
  {
    AppMethodBeat.i(168398);
    s.u(paramPaint, "<set-?>");
    this.paint = paramPaint;
    AppMethodBeat.o(168398);
  }
  
  public final void setProgress(int paramInt)
  {
    this.progress = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostProgressView
 * JD-Core Version:    0.7.0.1
 */
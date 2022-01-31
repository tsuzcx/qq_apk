package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CycleProgressView
  extends View
{
  private float nkS;
  private Paint paint;
  private int progress;
  
  public CycleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(151794);
    this.progress = 0;
    init();
    AppMethodBeat.o(151794);
  }
  
  public CycleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(151795);
    this.progress = 0;
    init();
    AppMethodBeat.o(151795);
  }
  
  private void init()
  {
    AppMethodBeat.i(151796);
    this.paint = new Paint();
    AppMethodBeat.o(151796);
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(151797);
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    if (this.nkS == 0.0F) {
      this.nkS = ((int)(getWidth() / 2 * 0.167D));
    }
    int j = (int)(i - this.nkS / 2.0F);
    this.paint.setStrokeWidth(this.nkS);
    this.paint.setColor(b.m(getContext(), 2131689482));
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, j, this.paint);
    this.paint.setStrokeWidth(this.nkS);
    this.paint.setColor(b.m(getContext(), 2131690709));
    paramCanvas.drawArc(new RectF(i - j, i - j, i + j, i + j), -90.0F, this.progress * 360 / 100, false, this.paint);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(151797);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(151798);
    this.progress = Math.max(0, paramInt);
    this.progress = Math.min(paramInt, 100);
    invalidate();
    AppMethodBeat.o(151798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.CycleProgressView
 * JD-Core Version:    0.7.0.1
 */
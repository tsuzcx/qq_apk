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
  private Paint paint;
  private int progress;
  private float rQO;
  
  public CycleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40885);
    this.progress = 0;
    init();
    AppMethodBeat.o(40885);
  }
  
  public CycleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40886);
    this.progress = 0;
    init();
    AppMethodBeat.o(40886);
  }
  
  private void init()
  {
    AppMethodBeat.i(40887);
    this.paint = new Paint();
    AppMethodBeat.o(40887);
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(40888);
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    if (this.rQO == 0.0F) {
      this.rQO = ((int)(getWidth() / 2 * 0.167D));
    }
    int j = (int)(i - this.rQO / 2.0F);
    this.paint.setStrokeWidth(this.rQO);
    this.paint.setColor(b.n(getContext(), 2131099656));
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, j, this.paint);
    this.paint.setStrokeWidth(this.rQO);
    this.paint.setColor(b.n(getContext(), 2131101179));
    paramCanvas.drawArc(new RectF(i - j, i - j, i + j, i + j), -90.0F, this.progress * 360 / 100, false, this.paint);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(40888);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(40889);
    this.progress = Math.max(0, paramInt);
    this.progress = Math.min(paramInt, 100);
    invalidate();
    AppMethodBeat.o(40889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.CycleProgressView
 * JD-Core Version:    0.7.0.1
 */
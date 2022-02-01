package com.tencent.mm.plugin.game.commlib.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.a.a.a;

public class CycleProgressView
  extends View
{
  private float Itq;
  private Paint paint;
  private int progress;
  
  public CycleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(275356);
    this.progress = 0;
    init();
    AppMethodBeat.o(275356);
  }
  
  public CycleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(275362);
    this.progress = 0;
    init();
    AppMethodBeat.o(275362);
  }
  
  private void init()
  {
    AppMethodBeat.i(275367);
    this.paint = new Paint();
    AppMethodBeat.o(275367);
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(275376);
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    if (this.Itq == 0.0F) {
      this.Itq = ((int)(getWidth() / 2 * 0.167D));
    }
    int j = (int)(i - this.Itq / 2.0F);
    this.paint.setStrokeWidth(this.Itq);
    this.paint.setColor(a.w(getContext(), a.a.BW_0_Alpha_0_1));
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, j, this.paint);
    this.paint.setStrokeWidth(this.Itq);
    this.paint.setColor(a.w(getContext(), a.a.white));
    paramCanvas.drawArc(new RectF(i - j, i - j, i + j, i + j), -90.0F, this.progress * 360 / 100, false, this.paint);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(275376);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(275382);
    this.progress = Math.max(0, paramInt);
    this.progress = Math.min(paramInt, 100);
    invalidate();
    AppMethodBeat.o(275382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.view.CycleProgressView
 * JD-Core Version:    0.7.0.1
 */
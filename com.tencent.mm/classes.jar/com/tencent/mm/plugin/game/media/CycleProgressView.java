package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.b;

public class CycleProgressView
  extends View
{
  private float CDP;
  private Paint paint;
  private int progress;
  
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
    if (this.CDP == 0.0F) {
      this.CDP = ((int)(getWidth() / 2 * 0.167D));
    }
    int j = (int)(i - this.CDP / 2.0F);
    this.paint.setStrokeWidth(this.CDP);
    this.paint.setColor(a.w(getContext(), g.b.BW_0_Alpha_0_1));
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, j, this.paint);
    this.paint.setStrokeWidth(this.CDP);
    this.paint.setColor(a.w(getContext(), g.b.white));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.CycleProgressView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class FaceDetectDecorView
  extends View
{
  public boolean moE;
  public boolean moF;
  public boolean moG;
  public RectF moH;
  private Paint moI;
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(615);
    this.moE = false;
    this.moF = false;
    this.moG = false;
    this.moH = null;
    this.moI = null;
    this.moI = new Paint();
    this.moI.setColor(getResources().getColor(2131689763));
    this.moI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    setLayerType(1, null);
    AppMethodBeat.o(615);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(616);
    super.onDraw(paramCanvas);
    ab.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", new Object[] { Boolean.valueOf(this.moF), Boolean.valueOf(this.moE), this.moH });
    if ((this.moF != this.moE) || (this.moG))
    {
      if (!this.moF) {
        break label114;
      }
      paramCanvas.drawColor(getResources().getColor(2131690015));
      paramCanvas.drawRect(this.moH, this.moI);
    }
    for (;;)
    {
      this.moE = this.moF;
      AppMethodBeat.o(616);
      return;
      label114:
      paramCanvas.drawColor(getResources().getColor(2131690605));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView
 * JD-Core Version:    0.7.0.1
 */
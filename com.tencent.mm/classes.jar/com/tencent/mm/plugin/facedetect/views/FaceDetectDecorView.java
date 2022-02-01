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
import com.tencent.mm.sdk.platformtools.ac;

public class FaceDetectDecorView
  extends View
{
  public boolean qDS;
  public boolean qDT;
  public boolean qDU;
  public RectF qDV;
  private Paint qDW;
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104134);
    this.qDS = false;
    this.qDT = false;
    this.qDU = false;
    this.qDV = null;
    this.qDW = null;
    this.qDW = new Paint();
    this.qDW.setColor(getResources().getColor(2131100017));
    this.qDW.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    setLayerType(1, null);
    AppMethodBeat.o(104134);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104135);
    super.onDraw(paramCanvas);
    ac.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", new Object[] { Boolean.valueOf(this.qDT), Boolean.valueOf(this.qDS), this.qDV });
    if ((this.qDT != this.qDS) || (this.qDU))
    {
      if (!this.qDT) {
        break label112;
      }
      paramCanvas.drawColor(getResources().getColor(2131100314));
      paramCanvas.drawRect(this.qDV, this.qDW);
    }
    for (;;)
    {
      this.qDS = this.qDT;
      AppMethodBeat.o(104135);
      return;
      label112:
      paramCanvas.drawColor(getResources().getColor(2131101053));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView
 * JD-Core Version:    0.7.0.1
 */
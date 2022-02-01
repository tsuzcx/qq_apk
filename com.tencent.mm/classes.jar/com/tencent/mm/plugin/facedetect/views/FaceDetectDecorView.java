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
import com.tencent.mm.sdk.platformtools.ae;

public class FaceDetectDecorView
  extends View
{
  public boolean rvN;
  public boolean rvO;
  public boolean rvP;
  public RectF rvQ;
  private Paint rvR;
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104134);
    this.rvN = false;
    this.rvO = false;
    this.rvP = false;
    this.rvQ = null;
    this.rvR = null;
    this.rvR = new Paint();
    this.rvR.setColor(getResources().getColor(2131100017));
    this.rvR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    setLayerType(1, null);
    AppMethodBeat.o(104134);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104135);
    super.onDraw(paramCanvas);
    ae.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", new Object[] { Boolean.valueOf(this.rvO), Boolean.valueOf(this.rvN), this.rvQ });
    if ((this.rvO != this.rvN) || (this.rvP))
    {
      if (!this.rvO) {
        break label112;
      }
      paramCanvas.drawColor(getResources().getColor(2131100314));
      paramCanvas.drawRect(this.rvQ, this.rvR);
    }
    for (;;)
    {
      this.rvN = this.rvO;
      AppMethodBeat.o(104135);
      return;
      label112:
      paramCanvas.drawColor(getResources().getColor(2131101053));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView
 * JD-Core Version:    0.7.0.1
 */
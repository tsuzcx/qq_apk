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
import com.tencent.mm.sdk.platformtools.ad;

public class FaceDetectDecorView
  extends View
{
  public boolean pVn;
  public boolean pVo;
  public boolean pVp;
  public RectF pVq;
  private Paint pVr;
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104134);
    this.pVn = false;
    this.pVo = false;
    this.pVp = false;
    this.pVq = null;
    this.pVr = null;
    this.pVr = new Paint();
    this.pVr.setColor(getResources().getColor(2131100017));
    this.pVr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    setLayerType(1, null);
    AppMethodBeat.o(104134);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104135);
    super.onDraw(paramCanvas);
    ad.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", new Object[] { Boolean.valueOf(this.pVo), Boolean.valueOf(this.pVn), this.pVq });
    if ((this.pVo != this.pVn) || (this.pVp))
    {
      if (!this.pVo) {
        break label112;
      }
      paramCanvas.drawColor(getResources().getColor(2131100314));
      paramCanvas.drawRect(this.pVq, this.pVr);
    }
    for (;;)
    {
      this.pVn = this.pVo;
      AppMethodBeat.o(104135);
      return;
      label112:
      paramCanvas.drawColor(getResources().getColor(2131101053));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView
 * JD-Core Version:    0.7.0.1
 */
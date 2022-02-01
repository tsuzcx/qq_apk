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
  public boolean rnI;
  public boolean rnJ;
  public boolean rnK;
  public RectF rnL;
  private Paint rnM;
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104134);
    this.rnI = false;
    this.rnJ = false;
    this.rnK = false;
    this.rnL = null;
    this.rnM = null;
    this.rnM = new Paint();
    this.rnM.setColor(getResources().getColor(2131100017));
    this.rnM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    setLayerType(1, null);
    AppMethodBeat.o(104134);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104135);
    super.onDraw(paramCanvas);
    ad.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", new Object[] { Boolean.valueOf(this.rnJ), Boolean.valueOf(this.rnI), this.rnL });
    if ((this.rnJ != this.rnI) || (this.rnK))
    {
      if (!this.rnJ) {
        break label112;
      }
      paramCanvas.drawColor(getResources().getColor(2131100314));
      paramCanvas.drawRect(this.rnL, this.rnM);
    }
    for (;;)
    {
      this.rnI = this.rnJ;
      AppMethodBeat.o(104135);
      return;
      label112:
      paramCanvas.drawColor(getResources().getColor(2131101053));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView
 * JD-Core Version:    0.7.0.1
 */
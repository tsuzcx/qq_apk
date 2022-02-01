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
import com.tencent.mm.sdk.platformtools.Log;

public class FaceDetectDecorView
  extends View
{
  public boolean sVK;
  public boolean sVL;
  public boolean sVM;
  public RectF sVN;
  private Paint sVO;
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104134);
    this.sVK = false;
    this.sVL = false;
    this.sVM = false;
    this.sVN = null;
    this.sVO = null;
    this.sVO = new Paint();
    this.sVO.setColor(getResources().getColor(2131100042));
    this.sVO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    setLayerType(1, null);
    AppMethodBeat.o(104134);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104135);
    super.onDraw(paramCanvas);
    Log.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", new Object[] { Boolean.valueOf(this.sVL), Boolean.valueOf(this.sVK), this.sVN });
    if ((this.sVL != this.sVK) || (this.sVM))
    {
      if (!this.sVL) {
        break label112;
      }
      paramCanvas.drawColor(getResources().getColor(2131100349));
      paramCanvas.drawRect(this.sVN, this.sVO);
    }
    for (;;)
    {
      this.sVK = this.sVL;
      AppMethodBeat.o(104135);
      return;
      label112:
      paramCanvas.drawColor(getResources().getColor(2131101287));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView
 * JD-Core Version:    0.7.0.1
 */
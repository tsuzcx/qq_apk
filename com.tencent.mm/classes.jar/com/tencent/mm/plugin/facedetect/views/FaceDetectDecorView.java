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
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceDetectDecorView
  extends View
{
  public boolean wBI;
  public boolean wBJ;
  public boolean wBK;
  public RectF wBL;
  private Paint wBM;
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104134);
    this.wBI = false;
    this.wBJ = false;
    this.wBK = false;
    this.wBL = null;
    this.wBM = null;
    this.wBM = new Paint();
    this.wBM.setColor(getResources().getColor(a.b.black));
    this.wBM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    setLayerType(1, null);
    AppMethodBeat.o(104134);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104135);
    super.onDraw(paramCanvas);
    Log.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", new Object[] { Boolean.valueOf(this.wBJ), Boolean.valueOf(this.wBI), this.wBL });
    if ((this.wBJ != this.wBI) || (this.wBK))
    {
      if (!this.wBJ) {
        break label113;
      }
      paramCanvas.drawColor(getResources().getColor(a.b.face_cover));
      paramCanvas.drawRect(this.wBL, this.wBM);
    }
    for (;;)
    {
      this.wBI = this.wBJ;
      AppMethodBeat.o(104135);
      return;
      label113:
      paramCanvas.drawColor(getResources().getColor(a.b.transparent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView
 * JD-Core Version:    0.7.0.1
 */
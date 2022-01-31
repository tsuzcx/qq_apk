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
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.sdk.platformtools.y;

public class FaceDetectDecorView
  extends View
{
  public boolean jUl = false;
  public boolean jUm = false;
  public boolean jUn = false;
  public RectF jUo = null;
  private Paint jUp = null;
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectDecorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jUp.setColor(getResources().getColor(a.b.black));
    this.jUp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    setLayerType(1, null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    y.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", new Object[] { Boolean.valueOf(this.jUm), Boolean.valueOf(this.jUl), this.jUo });
    if ((this.jUm != this.jUl) || (this.jUn))
    {
      if (!this.jUm) {
        break label103;
      }
      paramCanvas.drawColor(getResources().getColor(a.b.face_cover));
      paramCanvas.drawRect(this.jUo, this.jUp);
    }
    for (;;)
    {
      this.jUl = this.jUm;
      return;
      label103:
      paramCanvas.drawColor(getResources().getColor(a.b.transparent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView
 * JD-Core Version:    0.7.0.1
 */
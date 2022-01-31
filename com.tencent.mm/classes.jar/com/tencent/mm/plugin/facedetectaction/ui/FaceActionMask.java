package com.tencent.mm.plugin.facedetectaction.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class FaceActionMask
  extends RelativeLayout
{
  private Paint jWA;
  private PorterDuffXfermode jWB;
  private boolean jWC = false;
  private Paint jWz = new Paint(1);
  private Rect rect = new Rect();
  
  public FaceActionMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jWz.setStyle(Paint.Style.FILL);
    this.jWA = new Paint(1);
    setWillNotDraw(false);
    this.jWB = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    setLayerType(1, null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    float f1 = (float)(getWidth() * 0.35D);
    float f2 = (float)(getWidth() * 0.5D);
    float f3 = (float)(getHeight() * 0.4D);
    this.rect.left = 0;
    this.rect.right = getWidth();
    this.rect.top = 0;
    this.rect.bottom = getHeight();
    this.jWz.setColor(-1);
    paramCanvas.drawARGB(255, 0, 0, 0);
    paramCanvas.drawRect(this.rect, this.jWz);
    if (!this.jWC)
    {
      this.jWA.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jWA.setXfermode(this.jWB);
      paramCanvas.drawCircle(f2, f3, f1, this.jWA);
    }
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask
 * JD-Core Version:    0.7.0.1
 */
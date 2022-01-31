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
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FaceActionMask
  extends RelativeLayout
{
  private Paint mqQ;
  private Paint mqR;
  private PorterDuffXfermode mqS;
  private boolean mqT;
  private Rect rect;
  
  public FaceActionMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(707);
    this.rect = new Rect();
    this.mqT = false;
    this.mqQ = new Paint(1);
    this.mqQ.setStyle(Paint.Style.FILL);
    this.mqR = new Paint(1);
    setWillNotDraw(false);
    this.mqS = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    setLayerType(1, null);
    AppMethodBeat.o(707);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(708);
    paramCanvas.save();
    float f1 = (float)(getWidth() * 0.35D);
    float f2 = (float)(getWidth() * 0.5D);
    float f3 = (float)(getHeight() * 0.4D);
    this.rect.left = 0;
    this.rect.right = getWidth();
    this.rect.top = 0;
    this.rect.bottom = getHeight();
    this.mqQ.setColor(-1);
    paramCanvas.drawARGB(255, 0, 0, 0);
    paramCanvas.drawRect(this.rect, this.mqQ);
    if (!this.mqT)
    {
      this.mqR.setStyle(Paint.Style.FILL_AND_STROKE);
      this.mqR.setXfermode(this.mqS);
      paramCanvas.drawCircle(f2, f3, f1, this.mqR);
    }
    paramCanvas.restore();
    AppMethodBeat.o(708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask
 * JD-Core Version:    0.7.0.1
 */
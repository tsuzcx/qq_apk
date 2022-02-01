package com.tencent.mm.plugin.facedetectaction.ui;

import android.content.Context;
import android.content.res.Resources;
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
  private Rect rect;
  private Paint sXU;
  private Paint sXV;
  private PorterDuffXfermode sXW;
  private boolean sXX;
  
  public FaceActionMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(104229);
    this.rect = new Rect();
    this.sXX = false;
    this.sXU = new Paint(1);
    this.sXU.setStyle(Paint.Style.FILL);
    this.sXV = new Paint(1);
    setWillNotDraw(false);
    this.sXW = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    setLayerType(1, null);
    AppMethodBeat.o(104229);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104230);
    paramCanvas.save();
    float f1 = (float)(getWidth() * 0.35D);
    float f2 = (float)(getWidth() * 0.5D);
    float f3 = (float)(getHeight() * 0.4D);
    this.rect.left = 0;
    this.rect.right = getWidth();
    this.rect.top = 0;
    this.rect.bottom = getHeight();
    this.sXU.setColor(getContext().getResources().getColor(2131101424));
    paramCanvas.drawARGB(255, 0, 0, 0);
    paramCanvas.drawRect(this.rect, this.sXU);
    if (!this.sXX)
    {
      this.sXV.setStyle(Paint.Style.FILL_AND_STROKE);
      this.sXV.setXfermode(this.sXW);
      paramCanvas.drawCircle(f2, f3, f1, this.sXV);
    }
    paramCanvas.restore();
    AppMethodBeat.o(104230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.plugin.facedetect.a.b;

public class FaceActionMask
  extends RelativeLayout
{
  private Rect byG;
  private Paint wDT;
  private Paint wDU;
  private PorterDuffXfermode wDV;
  private boolean wDW;
  
  public FaceActionMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(104229);
    this.byG = new Rect();
    this.wDW = false;
    this.wDT = new Paint(1);
    this.wDT.setStyle(Paint.Style.FILL);
    this.wDU = new Paint(1);
    setWillNotDraw(false);
    this.wDV = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
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
    this.byG.left = 0;
    this.byG.right = getWidth();
    this.byG.top = 0;
    this.byG.bottom = getHeight();
    this.wDT.setColor(getContext().getResources().getColor(a.b.white));
    paramCanvas.drawARGB(255, 0, 0, 0);
    paramCanvas.drawRect(this.byG, this.wDT);
    if (!this.wDW)
    {
      this.wDU.setStyle(Paint.Style.FILL_AND_STROKE);
      this.wDU.setXfermode(this.wDV);
      paramCanvas.drawCircle(f2, f3, f1, this.wDU);
    }
    paramCanvas.restore();
    AppMethodBeat.o(104230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask
 * JD-Core Version:    0.7.0.1
 */
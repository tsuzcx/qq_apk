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
  private Paint qFZ;
  private Paint qGa;
  private PorterDuffXfermode qGb;
  private boolean qGc;
  private Rect rect;
  
  public FaceActionMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(104229);
    this.rect = new Rect();
    this.qGc = false;
    this.qFZ = new Paint(1);
    this.qFZ.setStyle(Paint.Style.FILL);
    this.qGa = new Paint(1);
    setWillNotDraw(false);
    this.qGb = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
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
    this.qFZ.setColor(getContext().getResources().getColor(2131101179));
    paramCanvas.drawARGB(255, 0, 0, 0);
    paramCanvas.drawRect(this.rect, this.qFZ);
    if (!this.qGc)
    {
      this.qGa.setStyle(Paint.Style.FILL_AND_STROKE);
      this.qGa.setXfermode(this.qGb);
      paramCanvas.drawCircle(f2, f3, f1, this.qGa);
    }
    paramCanvas.restore();
    AppMethodBeat.o(104230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask
 * JD-Core Version:    0.7.0.1
 */
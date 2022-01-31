package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Timer;

public class FaceNumberItemView
  extends View
{
  static final long jUN = 29L;
  Timer jUM = null;
  private boolean jUO = false;
  private Paint jUP = null;
  private RectF jUQ = null;
  private Bitmap jUR = null;
  private int jUS = 17;
  int jUT = 0;
  Runnable jUU = new FaceNumberItemView.1(this);
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayerType(1, null);
    this.jUP = new Paint();
    this.jUP.setColor(paramContext.getResources().getColor(a.b.face_number_shader_color));
    this.jUP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    this.jUQ = new RectF();
  }
  
  public final void aPv()
  {
    if (this.jUM != null)
    {
      this.jUM.cancel();
      this.jUM = null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f2;
    float f1;
    if (this.jUS == 17)
    {
      f2 = getWidth() - this.jUR.getWidth() >> 1;
      f1 = getHeight() - this.jUR.getHeight() >> 1;
    }
    for (;;)
    {
      if (!this.jUO) {
        paramCanvas.drawBitmap(this.jUR, f2, f1, null);
      }
      this.jUQ.set(f2, 0.0F, this.jUR.getWidth() * this.jUT / 30.0F + f2, getHeight());
      paramCanvas.drawRect(this.jUQ, this.jUP);
      return;
      if (this.jUS == 3)
      {
        f1 = getHeight() - this.jUR.getHeight() >> 1;
        f2 = 0.0F;
      }
      else if (this.jUS == 5)
      {
        f2 = getWidth() - this.jUR.getWidth();
        f1 = getHeight() - this.jUR.getHeight() >> 1;
      }
      else
      {
        y.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
        f2 = getWidth() - this.jUR.getWidth() >> 1;
        f1 = getHeight() - this.jUR.getHeight() >> 1;
      }
    }
  }
  
  public void setGravity(int paramInt)
  {
    y.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
    this.jUS = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    Bitmap localBitmap1 = BitmapFactory.decodeResource(getResources(), paramInt);
    if (paramInt == a.d.face_point)
    {
      paramInt = (getResources().getDimensionPixelSize(a.c.face_number_width) - a.fromDPToPix(getContext(), 8)) / 2;
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth() + paramInt * 2, localBitmap1.getHeight() + 0, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      localCanvas.drawARGB(0, 255, 255, 255);
      localCanvas.drawBitmap(localBitmap1, paramInt, 0.0F, null);
      this.jUR = localBitmap2;
      return;
    }
    this.jUR = Bitmap.createScaledBitmap(localBitmap1, a.fromDPToPix(getContext(), 48), localBitmap1.getHeight(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView
 * JD-Core Version:    0.7.0.1
 */
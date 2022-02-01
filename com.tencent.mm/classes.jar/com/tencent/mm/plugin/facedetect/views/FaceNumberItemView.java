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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public class FaceNumberItemView
  extends View
{
  static final long zYv = 29L;
  private int zYA;
  int zYB;
  Runnable zYC;
  MTimerHandler zYu;
  private boolean zYw;
  private Paint zYx;
  private RectF zYy;
  private Bitmap zYz;
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104166);
    this.zYu = null;
    this.zYw = false;
    this.zYx = null;
    this.zYy = null;
    this.zYz = null;
    this.zYA = 17;
    this.zYB = 0;
    this.zYC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104163);
        if (FaceNumberItemView.a(FaceNumberItemView.this) <= 30)
        {
          FaceNumberItemView.b(FaceNumberItemView.this);
          FaceNumberItemView.this.invalidate();
          AppMethodBeat.o(104163);
          return;
        }
        FaceNumberItemView.this.dPK();
        AppMethodBeat.o(104163);
      }
    };
    setLayerType(1, null);
    this.zYx = new Paint();
    this.zYx.setColor(paramContext.getResources().getColor(a.b.face_number_shader_color));
    this.zYx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    this.zYy = new RectF();
    AppMethodBeat.o(104166);
  }
  
  public final void dPK()
  {
    AppMethodBeat.i(104169);
    this.zYu.stopped();
    AppMethodBeat.o(104169);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104170);
    super.onDraw(paramCanvas);
    float f2;
    float f1;
    if (this.zYA == 17)
    {
      f2 = getWidth() - this.zYz.getWidth() >> 1;
      f1 = getHeight() - this.zYz.getHeight() >> 1;
    }
    for (;;)
    {
      if (!this.zYw) {
        paramCanvas.drawBitmap(this.zYz, f2, f1, null);
      }
      this.zYy.set(f2, 0.0F, this.zYz.getWidth() * this.zYB / 30.0F + f2, getHeight());
      paramCanvas.drawRect(this.zYy, this.zYx);
      AppMethodBeat.o(104170);
      return;
      if (this.zYA == 3)
      {
        f1 = getHeight() - this.zYz.getHeight() >> 1;
        f2 = 0.0F;
      }
      else if (this.zYA == 5)
      {
        f2 = getWidth() - this.zYz.getWidth();
        f1 = getHeight() - this.zYz.getHeight() >> 1;
      }
      else
      {
        Log.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
        f2 = getWidth() - this.zYz.getWidth() >> 1;
        f1 = getHeight() - this.zYz.getHeight() >> 1;
      }
    }
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(104168);
    Log.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
    this.zYA = paramInt;
    AppMethodBeat.o(104168);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(104167);
    Bitmap localBitmap1 = BitmapFactory.decodeResource(getResources(), paramInt);
    if (paramInt == a.d.face_point)
    {
      paramInt = (getResources().getDimensionPixelSize(a.c.face_number_width) - a.fromDPToPix(getContext(), 8)) / 2;
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth() + paramInt * 2, localBitmap1.getHeight() + 0, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      localCanvas.drawARGB(0, 255, 255, 255);
      localCanvas.drawBitmap(localBitmap1, paramInt, 0.0F, null);
      this.zYz = localBitmap2;
      AppMethodBeat.o(104167);
      return;
    }
    this.zYz = Bitmap.createScaledBitmap(localBitmap1, a.fromDPToPix(getContext(), 48), localBitmap1.getHeight(), false);
    AppMethodBeat.o(104167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView
 * JD-Core Version:    0.7.0.1
 */
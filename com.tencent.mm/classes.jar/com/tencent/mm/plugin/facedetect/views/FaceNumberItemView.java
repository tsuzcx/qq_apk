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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public class FaceNumberItemView
  extends View
{
  static final long wCk = 29L;
  MTimerHandler wCj;
  private boolean wCl;
  private Paint wCm;
  private RectF wCn;
  private Bitmap wCo;
  private int wCp;
  int wCq;
  Runnable wCr;
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104166);
    this.wCj = null;
    this.wCl = false;
    this.wCm = null;
    this.wCn = null;
    this.wCo = null;
    this.wCp = 17;
    this.wCq = 0;
    this.wCr = new Runnable()
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
        FaceNumberItemView.this.diZ();
        AppMethodBeat.o(104163);
      }
    };
    setLayerType(1, null);
    this.wCm = new Paint();
    this.wCm.setColor(paramContext.getResources().getColor(a.b.face_number_shader_color));
    this.wCm.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    this.wCn = new RectF();
    AppMethodBeat.o(104166);
  }
  
  public final void diZ()
  {
    AppMethodBeat.i(104169);
    this.wCj.stopped();
    AppMethodBeat.o(104169);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104170);
    super.onDraw(paramCanvas);
    float f2;
    float f1;
    if (this.wCp == 17)
    {
      f2 = getWidth() - this.wCo.getWidth() >> 1;
      f1 = getHeight() - this.wCo.getHeight() >> 1;
    }
    for (;;)
    {
      if (!this.wCl) {
        paramCanvas.drawBitmap(this.wCo, f2, f1, null);
      }
      this.wCn.set(f2, 0.0F, this.wCo.getWidth() * this.wCq / 30.0F + f2, getHeight());
      paramCanvas.drawRect(this.wCn, this.wCm);
      AppMethodBeat.o(104170);
      return;
      if (this.wCp == 3)
      {
        f1 = getHeight() - this.wCo.getHeight() >> 1;
        f2 = 0.0F;
      }
      else if (this.wCp == 5)
      {
        f2 = getWidth() - this.wCo.getWidth();
        f1 = getHeight() - this.wCo.getHeight() >> 1;
      }
      else
      {
        Log.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
        f2 = getWidth() - this.wCo.getWidth() >> 1;
        f1 = getHeight() - this.wCo.getHeight() >> 1;
      }
    }
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(104168);
    Log.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
    this.wCp = paramInt;
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
      this.wCo = localBitmap2;
      AppMethodBeat.o(104167);
      return;
    }
    this.wCo = Bitmap.createScaledBitmap(localBitmap1, a.fromDPToPix(getContext(), 48), localBitmap1.getHeight(), false);
    AppMethodBeat.o(104167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView
 * JD-Core Version:    0.7.0.1
 */
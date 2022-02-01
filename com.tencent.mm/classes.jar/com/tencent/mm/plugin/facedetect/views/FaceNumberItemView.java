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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Timer;

public class FaceNumberItemView
  extends View
{
  static final long qEu = 29L;
  int qEA;
  Runnable qEB;
  Timer qEt;
  private boolean qEv;
  private Paint qEw;
  private RectF qEx;
  private Bitmap qEy;
  private int qEz;
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104166);
    this.qEt = null;
    this.qEv = false;
    this.qEw = null;
    this.qEx = null;
    this.qEy = null;
    this.qEz = 17;
    this.qEA = 0;
    this.qEB = new Runnable()
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
        FaceNumberItemView.this.coD();
        AppMethodBeat.o(104163);
      }
    };
    setLayerType(1, null);
    this.qEw = new Paint();
    this.qEw.setColor(paramContext.getResources().getColor(2131100331));
    this.qEw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    this.qEx = new RectF();
    AppMethodBeat.o(104166);
  }
  
  public final void coD()
  {
    AppMethodBeat.i(104169);
    if (this.qEt != null)
    {
      this.qEt.cancel();
      this.qEt = null;
    }
    AppMethodBeat.o(104169);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104170);
    super.onDraw(paramCanvas);
    float f2;
    float f1;
    if (this.qEz == 17)
    {
      f2 = getWidth() - this.qEy.getWidth() >> 1;
      f1 = getHeight() - this.qEy.getHeight() >> 1;
    }
    for (;;)
    {
      if (!this.qEv) {
        paramCanvas.drawBitmap(this.qEy, f2, f1, null);
      }
      this.qEx.set(f2, 0.0F, this.qEy.getWidth() * this.qEA / 30.0F + f2, getHeight());
      paramCanvas.drawRect(this.qEx, this.qEw);
      AppMethodBeat.o(104170);
      return;
      if (this.qEz == 3)
      {
        f1 = getHeight() - this.qEy.getHeight() >> 1;
        f2 = 0.0F;
      }
      else if (this.qEz == 5)
      {
        f2 = getWidth() - this.qEy.getWidth();
        f1 = getHeight() - this.qEy.getHeight() >> 1;
      }
      else
      {
        ac.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
        f2 = getWidth() - this.qEy.getWidth() >> 1;
        f1 = getHeight() - this.qEy.getHeight() >> 1;
      }
    }
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(104168);
    ac.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
    this.qEz = paramInt;
    AppMethodBeat.o(104168);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(104167);
    Bitmap localBitmap1 = BitmapFactory.decodeResource(getResources(), paramInt);
    if (paramInt == 2131232151)
    {
      paramInt = (getResources().getDimensionPixelSize(2131166279) - a.fromDPToPix(getContext(), 8)) / 2;
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth() + paramInt * 2, localBitmap1.getHeight() + 0, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      localCanvas.drawARGB(0, 255, 255, 255);
      localCanvas.drawBitmap(localBitmap1, paramInt, 0.0F, null);
      this.qEy = localBitmap2;
      AppMethodBeat.o(104167);
      return;
    }
    this.qEy = Bitmap.createScaledBitmap(localBitmap1, a.fromDPToPix(getContext(), 48), localBitmap1.getHeight(), false);
    AppMethodBeat.o(104167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView
 * JD-Core Version:    0.7.0.1
 */
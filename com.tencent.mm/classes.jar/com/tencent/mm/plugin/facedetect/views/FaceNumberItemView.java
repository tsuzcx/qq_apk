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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Timer;

public class FaceNumberItemView
  extends View
{
  static final long pVP = 29L;
  Timer pVO;
  private boolean pVQ;
  private Paint pVR;
  private RectF pVS;
  private Bitmap pVT;
  private int pVU;
  int pVV;
  Runnable pVW;
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104166);
    this.pVO = null;
    this.pVQ = false;
    this.pVR = null;
    this.pVS = null;
    this.pVT = null;
    this.pVU = 17;
    this.pVV = 0;
    this.pVW = new Runnable()
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
        FaceNumberItemView.this.cgW();
        AppMethodBeat.o(104163);
      }
    };
    setLayerType(1, null);
    this.pVR = new Paint();
    this.pVR.setColor(paramContext.getResources().getColor(2131100331));
    this.pVR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    this.pVS = new RectF();
    AppMethodBeat.o(104166);
  }
  
  public final void cgW()
  {
    AppMethodBeat.i(104169);
    if (this.pVO != null)
    {
      this.pVO.cancel();
      this.pVO = null;
    }
    AppMethodBeat.o(104169);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104170);
    super.onDraw(paramCanvas);
    float f2;
    float f1;
    if (this.pVU == 17)
    {
      f2 = getWidth() - this.pVT.getWidth() >> 1;
      f1 = getHeight() - this.pVT.getHeight() >> 1;
    }
    for (;;)
    {
      if (!this.pVQ) {
        paramCanvas.drawBitmap(this.pVT, f2, f1, null);
      }
      this.pVS.set(f2, 0.0F, this.pVT.getWidth() * this.pVV / 30.0F + f2, getHeight());
      paramCanvas.drawRect(this.pVS, this.pVR);
      AppMethodBeat.o(104170);
      return;
      if (this.pVU == 3)
      {
        f1 = getHeight() - this.pVT.getHeight() >> 1;
        f2 = 0.0F;
      }
      else if (this.pVU == 5)
      {
        f2 = getWidth() - this.pVT.getWidth();
        f1 = getHeight() - this.pVT.getHeight() >> 1;
      }
      else
      {
        ad.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
        f2 = getWidth() - this.pVT.getWidth() >> 1;
        f1 = getHeight() - this.pVT.getHeight() >> 1;
      }
    }
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(104168);
    ad.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
    this.pVU = paramInt;
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
      this.pVT = localBitmap2;
      AppMethodBeat.o(104167);
      return;
    }
    this.pVT = Bitmap.createScaledBitmap(localBitmap1, a.fromDPToPix(getContext(), 48), localBitmap1.getHeight(), false);
    AppMethodBeat.o(104167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView
 * JD-Core Version:    0.7.0.1
 */
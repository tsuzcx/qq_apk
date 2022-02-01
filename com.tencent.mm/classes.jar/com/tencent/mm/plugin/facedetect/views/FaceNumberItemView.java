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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Timer;

public class FaceNumberItemView
  extends View
{
  static final long sWm = 29L;
  Timer sWl;
  private boolean sWn;
  private Paint sWo;
  private RectF sWp;
  private Bitmap sWq;
  private int sWr;
  int sWs;
  Runnable sWt;
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104166);
    this.sWl = null;
    this.sWn = false;
    this.sWo = null;
    this.sWp = null;
    this.sWq = null;
    this.sWr = 17;
    this.sWs = 0;
    this.sWt = new Runnable()
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
        FaceNumberItemView.this.cTT();
        AppMethodBeat.o(104163);
      }
    };
    setLayerType(1, null);
    this.sWo = new Paint();
    this.sWo.setColor(paramContext.getResources().getColor(2131100366));
    this.sWo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    this.sWp = new RectF();
    AppMethodBeat.o(104166);
  }
  
  public final void cTT()
  {
    AppMethodBeat.i(104169);
    if (this.sWl != null)
    {
      this.sWl.cancel();
      this.sWl = null;
    }
    AppMethodBeat.o(104169);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104170);
    super.onDraw(paramCanvas);
    float f2;
    float f1;
    if (this.sWr == 17)
    {
      f2 = getWidth() - this.sWq.getWidth() >> 1;
      f1 = getHeight() - this.sWq.getHeight() >> 1;
    }
    for (;;)
    {
      if (!this.sWn) {
        paramCanvas.drawBitmap(this.sWq, f2, f1, null);
      }
      this.sWp.set(f2, 0.0F, this.sWq.getWidth() * this.sWs / 30.0F + f2, getHeight());
      paramCanvas.drawRect(this.sWp, this.sWo);
      AppMethodBeat.o(104170);
      return;
      if (this.sWr == 3)
      {
        f1 = getHeight() - this.sWq.getHeight() >> 1;
        f2 = 0.0F;
      }
      else if (this.sWr == 5)
      {
        f2 = getWidth() - this.sWq.getWidth();
        f1 = getHeight() - this.sWq.getHeight() >> 1;
      }
      else
      {
        Log.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
        f2 = getWidth() - this.sWq.getWidth() >> 1;
        f1 = getHeight() - this.sWq.getHeight() >> 1;
      }
    }
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(104168);
    Log.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
    this.sWr = paramInt;
    AppMethodBeat.o(104168);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(104167);
    Bitmap localBitmap1 = BitmapFactory.decodeResource(getResources(), paramInt);
    if (paramInt == 2131232262)
    {
      paramInt = (getResources().getDimensionPixelSize(2131166326) - a.fromDPToPix(getContext(), 8)) / 2;
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth() + paramInt * 2, localBitmap1.getHeight() + 0, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      localCanvas.drawARGB(0, 255, 255, 255);
      localCanvas.drawBitmap(localBitmap1, paramInt, 0.0F, null);
      this.sWq = localBitmap2;
      AppMethodBeat.o(104167);
      return;
    }
    this.sWq = Bitmap.createScaledBitmap(localBitmap1, a.fromDPToPix(getContext(), 48), localBitmap1.getHeight(), false);
    AppMethodBeat.o(104167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView
 * JD-Core Version:    0.7.0.1
 */
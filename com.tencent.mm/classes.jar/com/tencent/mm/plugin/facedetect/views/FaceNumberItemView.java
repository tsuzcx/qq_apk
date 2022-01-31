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
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Timer;

public class FaceNumberItemView
  extends View
{
  static final long mpg = 29L;
  Timer mpf;
  private boolean mph;
  private Paint mpi;
  private RectF mpj;
  private Bitmap mpk;
  private int mpl;
  int mpm;
  Runnable mpn;
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(645);
    this.mpf = null;
    this.mph = false;
    this.mpi = null;
    this.mpj = null;
    this.mpk = null;
    this.mpl = 17;
    this.mpm = 0;
    this.mpn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(642);
        if (FaceNumberItemView.a(FaceNumberItemView.this) <= 30)
        {
          FaceNumberItemView.b(FaceNumberItemView.this);
          FaceNumberItemView.this.invalidate();
          AppMethodBeat.o(642);
          return;
        }
        FaceNumberItemView.this.bvB();
        AppMethodBeat.o(642);
      }
    };
    setLayerType(1, null);
    this.mpi = new Paint();
    this.mpi.setColor(paramContext.getResources().getColor(2131690032));
    this.mpi.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    this.mpj = new RectF();
    AppMethodBeat.o(645);
  }
  
  public final void bvB()
  {
    AppMethodBeat.i(648);
    if (this.mpf != null)
    {
      this.mpf.cancel();
      this.mpf = null;
    }
    AppMethodBeat.o(648);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(649);
    super.onDraw(paramCanvas);
    float f2;
    float f1;
    if (this.mpl == 17)
    {
      f2 = getWidth() - this.mpk.getWidth() >> 1;
      f1 = getHeight() - this.mpk.getHeight() >> 1;
    }
    for (;;)
    {
      if (!this.mph) {
        paramCanvas.drawBitmap(this.mpk, f2, f1, null);
      }
      this.mpj.set(f2, 0.0F, this.mpk.getWidth() * this.mpm / 30.0F + f2, getHeight());
      paramCanvas.drawRect(this.mpj, this.mpi);
      AppMethodBeat.o(649);
      return;
      if (this.mpl == 3)
      {
        f1 = getHeight() - this.mpk.getHeight() >> 1;
        f2 = 0.0F;
      }
      else if (this.mpl == 5)
      {
        f2 = getWidth() - this.mpk.getWidth();
        f1 = getHeight() - this.mpk.getHeight() >> 1;
      }
      else
      {
        ab.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
        f2 = getWidth() - this.mpk.getWidth() >> 1;
        f1 = getHeight() - this.mpk.getHeight() >> 1;
      }
    }
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(647);
    ab.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
    this.mpl = paramInt;
    AppMethodBeat.o(647);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(646);
    Bitmap localBitmap1 = BitmapFactory.decodeResource(getResources(), paramInt);
    if (paramInt == 2130838710)
    {
      paramInt = (getResources().getDimensionPixelSize(2131428413) - a.fromDPToPix(getContext(), 8)) / 2;
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth() + paramInt * 2, localBitmap1.getHeight() + 0, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      localCanvas.drawARGB(0, 255, 255, 255);
      localCanvas.drawBitmap(localBitmap1, paramInt, 0.0F, null);
      this.mpk = localBitmap2;
      AppMethodBeat.o(646);
      return;
    }
    this.mpk = Bitmap.createScaledBitmap(localBitmap1, a.fromDPToPix(getContext(), 48), localBitmap1.getHeight(), false);
    AppMethodBeat.o(646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView
 * JD-Core Version:    0.7.0.1
 */
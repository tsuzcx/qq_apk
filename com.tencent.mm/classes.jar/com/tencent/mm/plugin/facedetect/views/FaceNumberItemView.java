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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Timer;

public class FaceNumberItemView
  extends View
{
  static final long rwp = 29L;
  Timer rwo;
  private boolean rwq;
  private Paint rwr;
  private RectF rws;
  private Bitmap rwt;
  private int rwu;
  int rwv;
  Runnable rww;
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104166);
    this.rwo = null;
    this.rwq = false;
    this.rwr = null;
    this.rws = null;
    this.rwt = null;
    this.rwu = 17;
    this.rwv = 0;
    this.rww = new Runnable()
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
        FaceNumberItemView.this.cvJ();
        AppMethodBeat.o(104163);
      }
    };
    setLayerType(1, null);
    this.rwr = new Paint();
    this.rwr.setColor(paramContext.getResources().getColor(2131100331));
    this.rwr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    this.rws = new RectF();
    AppMethodBeat.o(104166);
  }
  
  public final void cvJ()
  {
    AppMethodBeat.i(104169);
    if (this.rwo != null)
    {
      this.rwo.cancel();
      this.rwo = null;
    }
    AppMethodBeat.o(104169);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104170);
    super.onDraw(paramCanvas);
    float f2;
    float f1;
    if (this.rwu == 17)
    {
      f2 = getWidth() - this.rwt.getWidth() >> 1;
      f1 = getHeight() - this.rwt.getHeight() >> 1;
    }
    for (;;)
    {
      if (!this.rwq) {
        paramCanvas.drawBitmap(this.rwt, f2, f1, null);
      }
      this.rws.set(f2, 0.0F, this.rwt.getWidth() * this.rwv / 30.0F + f2, getHeight());
      paramCanvas.drawRect(this.rws, this.rwr);
      AppMethodBeat.o(104170);
      return;
      if (this.rwu == 3)
      {
        f1 = getHeight() - this.rwt.getHeight() >> 1;
        f2 = 0.0F;
      }
      else if (this.rwu == 5)
      {
        f2 = getWidth() - this.rwt.getWidth();
        f1 = getHeight() - this.rwt.getHeight() >> 1;
      }
      else
      {
        ae.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
        f2 = getWidth() - this.rwt.getWidth() >> 1;
        f1 = getHeight() - this.rwt.getHeight() >> 1;
      }
    }
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(104168);
    ae.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
    this.rwu = paramInt;
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
      this.rwt = localBitmap2;
      AppMethodBeat.o(104167);
      return;
    }
    this.rwt = Bitmap.createScaledBitmap(localBitmap1, a.fromDPToPix(getContext(), 48), localBitmap1.getHeight(), false);
    AppMethodBeat.o(104167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView
 * JD-Core Version:    0.7.0.1
 */
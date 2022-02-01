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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Timer;

public class FaceNumberItemView
  extends View
{
  static final long rok = 29L;
  Timer roj;
  private boolean rol;
  private Paint rom;
  private RectF ron;
  private Bitmap roo;
  private int rop;
  int roq;
  Runnable ror;
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceNumberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104166);
    this.roj = null;
    this.rol = false;
    this.rom = null;
    this.ron = null;
    this.roo = null;
    this.rop = 17;
    this.roq = 0;
    this.ror = new Runnable()
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
        FaceNumberItemView.this.cui();
        AppMethodBeat.o(104163);
      }
    };
    setLayerType(1, null);
    this.rom = new Paint();
    this.rom.setColor(paramContext.getResources().getColor(2131100331));
    this.rom.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    this.ron = new RectF();
    AppMethodBeat.o(104166);
  }
  
  public final void cui()
  {
    AppMethodBeat.i(104169);
    if (this.roj != null)
    {
      this.roj.cancel();
      this.roj = null;
    }
    AppMethodBeat.o(104169);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104170);
    super.onDraw(paramCanvas);
    float f2;
    float f1;
    if (this.rop == 17)
    {
      f2 = getWidth() - this.roo.getWidth() >> 1;
      f1 = getHeight() - this.roo.getHeight() >> 1;
    }
    for (;;)
    {
      if (!this.rol) {
        paramCanvas.drawBitmap(this.roo, f2, f1, null);
      }
      this.ron.set(f2, 0.0F, this.roo.getWidth() * this.roq / 30.0F + f2, getHeight());
      paramCanvas.drawRect(this.ron, this.rom);
      AppMethodBeat.o(104170);
      return;
      if (this.rop == 3)
      {
        f1 = getHeight() - this.roo.getHeight() >> 1;
        f2 = 0.0F;
      }
      else if (this.rop == 5)
      {
        f2 = getWidth() - this.roo.getWidth();
        f1 = getHeight() - this.roo.getHeight() >> 1;
      }
      else
      {
        ad.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
        f2 = getWidth() - this.roo.getWidth() >> 1;
        f1 = getHeight() - this.roo.getHeight() >> 1;
      }
    }
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(104168);
    ad.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
    this.rop = paramInt;
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
      this.roo = localBitmap2;
      AppMethodBeat.o(104167);
      return;
    }
    this.roo = Bitmap.createScaledBitmap(localBitmap1, a.fromDPToPix(getContext(), 48), localBitmap1.getHeight(), false);
    AppMethodBeat.o(104167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView
 * JD-Core Version:    0.7.0.1
 */
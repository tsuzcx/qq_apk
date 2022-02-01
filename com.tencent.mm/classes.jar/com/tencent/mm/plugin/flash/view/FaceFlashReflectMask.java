package com.tencent.mm.plugin.flash.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;

public class FaceFlashReflectMask
  extends YTReflectLayout
{
  public static float HjJ;
  private static final int progressWidth;
  private Paint Aae;
  private Paint Aaf;
  private PorterDuffXfermode Aag;
  private boolean Aah;
  private boolean HjK;
  private a HjL;
  private float HjM;
  private ColorMatrixColorFilter mColorMatrixColorFilter;
  private float progress;
  private Rect rect;
  private Paint rsU;
  private float y;
  
  static
  {
    AppMethodBeat.i(264626);
    HjJ = 0.386F;
    progressWidth = a.br(MMApplicationContext.getContext(), a.c.Edge_0_5_A);
    AppMethodBeat.o(264626);
  }
  
  public FaceFlashReflectMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(264620);
    this.rect = new Rect();
    this.Aah = false;
    this.y = 0.0F;
    this.progress = 0.0F;
    this.HjM = 0.0F;
    setLayerType(1, null);
    float f = ((c)h.ax(c.class)).a(c.a.zbw, 0.386F);
    if (f > 0.1D)
    {
      HjJ = f;
      Log.i("MicroMsg.FaceReflectMask", "FACE_FLASH_CIRCLE_RADIUS set value:%f", new Object[] { Float.valueOf(f) });
    }
    this.Aae = new Paint(1);
    this.Aae.setStyle(Paint.Style.FILL);
    this.Aaf = new Paint(1);
    this.Aaf.setColor(a.w(getContext(), a.b.transparent));
    this.rsU = new Paint(1);
    this.rsU.setStyle(Paint.Style.STROKE);
    this.rsU.setStrokeWidth(progressWidth);
    this.rsU.setColor(a.w(getContext(), a.b.BW_100_Alpha_0_8));
    setWillNotDraw(false);
    this.Aag = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.HjK = true;
    AppMethodBeat.o(264620);
  }
  
  public final void fuU()
  {
    AppMethodBeat.i(264643);
    setColorMatrixColorFilter(new ColorMatrixColorFilter(new float[] { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
    AppMethodBeat.o(264643);
  }
  
  public float getCircleMarginY()
  {
    return this.HjM;
  }
  
  public float getCircleY()
  {
    return this.y;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(264659);
    paramCanvas.save();
    float f1 = Math.min(getWidth(), getHeight()) * HjJ;
    float f2 = (float)(getWidth() * 0.5D);
    if (this.HjM != 0.0F) {}
    for (this.y = (this.HjM + f1);; this.y = (a.br(getContext(), a.c.face_flash_circle_margin_top) + f1))
    {
      this.rect.left = 0;
      this.rect.right = getWidth();
      this.rect.top = 0;
      this.rect.bottom = getHeight();
      this.Aae.setColor(-1);
      if (this.mColorMatrixColorFilter != null) {
        this.Aae.setColorFilter(this.mColorMatrixColorFilter);
      }
      paramCanvas.drawARGB(255, 0, 0, 0);
      paramCanvas.drawRect(this.rect, this.Aae);
      if (!this.Aah)
      {
        setAlpha(0.998F);
        this.Aaf.setStyle(Paint.Style.FILL_AND_STROKE);
        this.Aaf.setXfermode(this.Aag);
        paramCanvas.drawCircle(f2, this.y, f1, this.Aaf);
      }
      float f3 = this.progress;
      paramCanvas.drawArc(f2 - f1 + (progressWidth >> 1), this.y - f1 + (progressWidth >> 1), f2 + f1 - (progressWidth >> 1), f1 + this.y - (progressWidth >> 1), -90.0F, f3 * 360.0F, false, this.rsU);
      paramCanvas.restore();
      if (this.HjL != null)
      {
        this.HjL.fur();
        this.HjL = null;
      }
      AppMethodBeat.o(264659);
      return;
    }
  }
  
  public void setCallback(a parama)
  {
    this.HjL = parama;
  }
  
  public void setCircleMarginY(float paramFloat)
  {
    this.HjM = paramFloat;
  }
  
  public void setColorMatrixColorFilter(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    AppMethodBeat.i(264632);
    Log.i("MicroMsg.FaceReflectMask", "setColorMatrixColorFilter");
    this.mColorMatrixColorFilter = paramColorMatrixColorFilter;
    postInvalidate();
    AppMethodBeat.o(264632);
  }
  
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(264649);
    Log.d("MicroMsg.FaceReflectMask", "setProgress :%s", new Object[] { Float.valueOf(paramFloat) });
    if (paramFloat <= 0.0F) {
      this.progress = 0.0F;
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(264649);
      return;
      if (paramFloat <= 1.0F)
      {
        this.progress = paramFloat;
      }
      else
      {
        if (paramFloat > 1.05D) {
          break;
        }
        this.progress = 1.0F;
      }
    }
    AppMethodBeat.o(264649);
  }
  
  public static abstract interface a
  {
    public abstract void fur();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.view.FaceFlashReflectMask
 * JD-Core Version:    0.7.0.1
 */
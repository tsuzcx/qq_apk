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
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;

public class FaceReflectMask
  extends YTReflectLayout
{
  private static final int progressWidth;
  private Paint Aae;
  private Paint Aaf;
  private PorterDuffXfermode Aag;
  private boolean Aah;
  private boolean HjK;
  private float HjM;
  private a HjV;
  private ColorMatrixColorFilter mColorMatrixColorFilter;
  private float progress;
  private Rect rect;
  private Paint rsU;
  private float y;
  
  static
  {
    AppMethodBeat.i(264636);
    progressWidth = a.br(MMApplicationContext.getContext(), a.c.Edge_0_5_A);
    AppMethodBeat.o(264636);
  }
  
  public FaceReflectMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(264630);
    this.rect = new Rect();
    this.Aah = false;
    this.y = 0.0F;
    this.progress = 0.0F;
    this.HjM = 0.0F;
    setLayerType(1, null);
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
    AppMethodBeat.o(264630);
  }
  
  public final void fuU()
  {
    AppMethodBeat.i(264647);
    setColorMatrixColorFilter(new ColorMatrixColorFilter(new float[] { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
    AppMethodBeat.o(264647);
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
    AppMethodBeat.i(264662);
    paramCanvas.save();
    float f1 = Math.min(getWidth(), getHeight()) * 0.27F;
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
      if (this.HjV != null)
      {
        this.HjV.fur();
        this.HjV = null;
      }
      AppMethodBeat.o(264662);
      return;
    }
  }
  
  public void setCallback(a parama)
  {
    this.HjV = parama;
  }
  
  public void setCircleMarginY(float paramFloat)
  {
    this.HjM = paramFloat;
  }
  
  public void setColorMatrixColorFilter(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    AppMethodBeat.i(264641);
    Log.i("MicroMsg.FaceReflectMask", "setColorMatrixColorFilter");
    this.mColorMatrixColorFilter = paramColorMatrixColorFilter;
    postInvalidate();
    AppMethodBeat.o(264641);
  }
  
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(264653);
    Log.d("MicroMsg.FaceReflectMask", "setProgress :%s", new Object[] { Float.valueOf(paramFloat) });
    if (paramFloat <= 0.0F) {
      this.progress = 0.0F;
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(264653);
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
    AppMethodBeat.o(264653);
  }
  
  public static abstract interface a
  {
    public abstract void fur();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.view.FaceReflectMask
 * JD-Core Version:    0.7.0.1
 */
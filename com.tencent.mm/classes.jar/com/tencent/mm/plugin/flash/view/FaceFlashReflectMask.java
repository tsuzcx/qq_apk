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
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;

public class FaceFlashReflectMask
  extends YTReflectLayout
{
  public static float BCc;
  private static final int progressWidth;
  private boolean BCd;
  private a BCe;
  private float BCf;
  private Rect byG;
  private ColorMatrixColorFilter mColorMatrixColorFilter;
  private Paint opm;
  private float progress;
  private Paint wDT;
  private Paint wDU;
  private PorterDuffXfermode wDV;
  private boolean wDW;
  private float y;
  
  static
  {
    AppMethodBeat.i(193450);
    BCc = 0.386F;
    progressWidth = a.aY(MMApplicationContext.getContext(), a.c.Edge_0_5_A);
    AppMethodBeat.o(193450);
  }
  
  public FaceFlashReflectMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(193424);
    this.byG = new Rect();
    this.wDW = false;
    this.y = 0.0F;
    this.progress = 0.0F;
    this.BCf = 0.0F;
    setLayerType(1, null);
    float f = ((b)h.ae(b.class)).a(b.a.vKW, 0.386F);
    if (f > 0.1D)
    {
      BCc = f;
      Log.i("MicroMsg.FaceReflectMask", "FACE_FLASH_CIRCLE_RADIUS set value:%f", new Object[] { Float.valueOf(f) });
    }
    this.wDT = new Paint(1);
    this.wDT.setStyle(Paint.Style.FILL);
    this.wDU = new Paint(1);
    this.wDU.setColor(a.w(getContext(), a.b.transparent));
    this.opm = new Paint(1);
    this.opm.setStyle(Paint.Style.STROKE);
    this.opm.setStrokeWidth(progressWidth);
    this.opm.setColor(a.w(getContext(), a.b.BW_100_Alpha_0_8));
    setWillNotDraw(false);
    this.wDV = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.BCd = true;
    AppMethodBeat.o(193424);
  }
  
  public final void epS()
  {
    AppMethodBeat.i(193441);
    setColorMatrixColorFilter(new ColorMatrixColorFilter(new float[] { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
    AppMethodBeat.o(193441);
  }
  
  public float getCircleMarginY()
  {
    return this.BCf;
  }
  
  public float getCircleY()
  {
    return this.y;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(193448);
    paramCanvas.save();
    float f1 = Math.min(getWidth(), getHeight()) * BCc;
    float f2 = (float)(getWidth() * 0.5D);
    if (this.BCf != 0.0F) {}
    for (this.y = (this.BCf + f1);; this.y = (a.aY(getContext(), a.c.face_flash_circle_margin_top) + f1))
    {
      this.byG.left = 0;
      this.byG.right = getWidth();
      this.byG.top = 0;
      this.byG.bottom = getHeight();
      this.wDT.setColor(-1);
      if (this.mColorMatrixColorFilter != null) {
        this.wDT.setColorFilter(this.mColorMatrixColorFilter);
      }
      paramCanvas.drawARGB(255, 0, 0, 0);
      paramCanvas.drawRect(this.byG, this.wDT);
      if (!this.wDW)
      {
        setAlpha(0.998F);
        this.wDU.setStyle(Paint.Style.FILL_AND_STROKE);
        this.wDU.setXfermode(this.wDV);
        paramCanvas.drawCircle(f2, this.y, f1, this.wDU);
      }
      float f3 = this.progress;
      paramCanvas.drawArc(f2 - f1 + (progressWidth >> 1), this.y - f1 + (progressWidth >> 1), f2 + f1 - (progressWidth >> 1), f1 + this.y - (progressWidth >> 1), -90.0F, f3 * 360.0F, false, this.opm);
      paramCanvas.restore();
      if (this.BCe != null)
      {
        this.BCe.epp();
        this.BCe = null;
      }
      AppMethodBeat.o(193448);
      return;
    }
  }
  
  public void setCallback(a parama)
  {
    this.BCe = parama;
  }
  
  public void setCircleMarginY(float paramFloat)
  {
    this.BCf = paramFloat;
  }
  
  public void setColorMatrixColorFilter(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    AppMethodBeat.i(193428);
    Log.i("MicroMsg.FaceReflectMask", "setColorMatrixColorFilter");
    this.mColorMatrixColorFilter = paramColorMatrixColorFilter;
    postInvalidate();
    AppMethodBeat.o(193428);
  }
  
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(193444);
    Log.d("MicroMsg.FaceReflectMask", "setProgress :%s", new Object[] { Float.valueOf(paramFloat) });
    if (paramFloat <= 0.0F) {
      this.progress = 0.0F;
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(193444);
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
    AppMethodBeat.o(193444);
  }
  
  public static abstract interface a
  {
    public abstract void epp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.view.FaceFlashReflectMask
 * JD-Core Version:    0.7.0.1
 */
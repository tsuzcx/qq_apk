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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;

public class FaceReflectMask
  extends YTReflectLayout
{
  private static final int wIW;
  private Paint lun;
  private ColorMatrixColorFilter mColorMatrixColorFilter;
  private float progress;
  private Rect rect;
  private Paint sXU;
  private Paint sXV;
  private PorterDuffXfermode sXW;
  private boolean sXX;
  private boolean wIX;
  private a wIY;
  private float y;
  
  static
  {
    AppMethodBeat.i(186723);
    wIW = a.aG(MMApplicationContext.getContext(), 2131165277);
    AppMethodBeat.o(186723);
  }
  
  public FaceReflectMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(186718);
    this.rect = new Rect();
    this.sXX = false;
    this.y = 0.0F;
    this.progress = 0.0F;
    setLayerType(1, null);
    this.sXU = new Paint(1);
    this.sXU.setStyle(Paint.Style.FILL);
    this.sXV = new Paint(1);
    this.sXV.setColor(a.n(getContext(), 2131101287));
    this.lun = new Paint(1);
    this.lun.setStyle(Paint.Style.STROKE);
    this.lun.setStrokeWidth(wIW);
    this.lun.setColor(a.n(getContext(), 2131099679));
    setWillNotDraw(false);
    this.sXW = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.wIX = true;
    AppMethodBeat.o(186718);
  }
  
  public final void dLo()
  {
    AppMethodBeat.i(186720);
    setColorMatrixColorFilter(new ColorMatrixColorFilter(new float[] { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
    AppMethodBeat.o(186720);
  }
  
  public float getCircleY()
  {
    return this.y;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(186722);
    paramCanvas.save();
    float f1 = Math.min(getWidth(), getHeight()) * 0.27F;
    float f2 = (float)(getWidth() * 0.5D);
    this.y = (a.aG(getContext(), 2131166316) + f1);
    this.rect.left = 0;
    this.rect.right = getWidth();
    this.rect.top = 0;
    this.rect.bottom = getHeight();
    this.sXU.setColor(-1);
    if (this.mColorMatrixColorFilter != null) {
      this.sXU.setColorFilter(this.mColorMatrixColorFilter);
    }
    paramCanvas.drawARGB(255, 0, 0, 0);
    paramCanvas.drawRect(this.rect, this.sXU);
    if (!this.sXX)
    {
      setAlpha(0.998F);
      this.sXV.setStyle(Paint.Style.FILL_AND_STROKE);
      this.sXV.setXfermode(this.sXW);
      paramCanvas.drawCircle(f2, this.y, f1, this.sXV);
    }
    float f3 = this.progress;
    paramCanvas.drawArc(f2 - f1 + (wIW >> 1), this.y - f1 + (wIW >> 1), f2 + f1 - (wIW >> 1), f1 + this.y - (wIW >> 1), -90.0F, f3 * 360.0F, false, this.lun);
    paramCanvas.restore();
    if (this.wIY != null)
    {
      this.wIY.dKQ();
      this.wIY = null;
    }
    AppMethodBeat.o(186722);
  }
  
  public void setCallback(a parama)
  {
    this.wIY = parama;
  }
  
  public void setColorMatrixColorFilter(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    AppMethodBeat.i(186719);
    Log.i("MicroMsg.FaceReflectMask", "setColorMatrixColorFilter");
    this.mColorMatrixColorFilter = paramColorMatrixColorFilter;
    postInvalidate();
    AppMethodBeat.o(186719);
  }
  
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(186721);
    Log.d("MicroMsg.FaceReflectMask", "setProgress :%s", new Object[] { Float.valueOf(paramFloat) });
    if (paramFloat <= 0.0F) {
      this.progress = 0.0F;
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(186721);
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
    AppMethodBeat.o(186721);
  }
  
  public static abstract interface a
  {
    public abstract void dKQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.view.FaceReflectMask
 * JD-Core Version:    0.7.0.1
 */
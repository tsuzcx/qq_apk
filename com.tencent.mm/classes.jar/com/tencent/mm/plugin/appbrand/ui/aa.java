package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa
  extends Drawable
{
  private int PH;
  private Paint PJ;
  private Paint lEk;
  private int lEl;
  private int lEm;
  private int[] lEn;
  private RectF lEo;
  private int mOffsetX;
  private int mOffsetY;
  
  private aa(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(176778);
    this.lEl = paramInt1;
    this.lEn = paramArrayOfInt;
    this.lEm = paramInt2;
    this.PH = paramInt4;
    this.mOffsetX = paramInt5;
    this.mOffsetY = paramInt6;
    this.PJ = new Paint();
    this.PJ.setColor(0);
    this.PJ.setAntiAlias(true);
    this.PJ.setShadowLayer(paramInt4, paramInt5, paramInt6, paramInt3);
    this.PJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    this.lEk = new Paint();
    this.lEk.setAntiAlias(true);
    AppMethodBeat.o(176778);
  }
  
  public static void b(View paramView, Drawable paramDrawable)
  {
    AppMethodBeat.i(176783);
    paramView.setLayerType(1, null);
    t.a(paramView, paramDrawable);
    AppMethodBeat.o(176783);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(176780);
    if (this.lEn != null)
    {
      if (this.lEn.length != 1) {
        break label92;
      }
      this.lEk.setColor(this.lEn[0]);
    }
    while (this.lEl == 1)
    {
      paramCanvas.drawRoundRect(this.lEo, this.lEm, this.lEm, this.PJ);
      paramCanvas.drawRoundRect(this.lEo, this.lEm, this.lEm, this.lEk);
      AppMethodBeat.o(176780);
      return;
      label92:
      this.lEk.setShader(new LinearGradient(this.lEo.left, this.lEo.height() / 2.0F, this.lEo.right, this.lEo.height() / 2.0F, this.lEn, null, Shader.TileMode.CLAMP));
    }
    paramCanvas.drawCircle(this.lEo.centerX(), this.lEo.centerY(), Math.min(this.lEo.width(), this.lEo.height()) / 2.0F, this.PJ);
    paramCanvas.drawCircle(this.lEo.centerX(), this.lEo.centerY(), Math.min(this.lEo.width(), this.lEo.height()) / 2.0F, this.lEk);
    AppMethodBeat.o(176780);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(176781);
    this.PJ.setAlpha(paramInt);
    AppMethodBeat.o(176781);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(176779);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.lEo = new RectF(this.PH + paramInt1 - this.mOffsetX, this.PH + paramInt2 - this.mOffsetY, paramInt3 - this.PH - this.mOffsetX, paramInt4 - this.PH - this.mOffsetY);
    AppMethodBeat.o(176779);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(176782);
    this.PJ.setColorFilter(paramColorFilter);
    AppMethodBeat.o(176782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.aa
 * JD-Core Version:    0.7.0.1
 */
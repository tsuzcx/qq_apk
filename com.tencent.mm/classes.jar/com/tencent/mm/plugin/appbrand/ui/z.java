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

public final class z
  extends Drawable
{
  private int QC;
  private Paint QE;
  private int mOffsetX;
  private int mOffsetY;
  private Paint mge;
  private int mgf;
  private int mgg;
  private int[] mgh;
  private RectF mgi;
  
  private z(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(176778);
    this.mgf = paramInt1;
    this.mgh = paramArrayOfInt;
    this.mgg = paramInt2;
    this.QC = paramInt4;
    this.mOffsetX = paramInt5;
    this.mOffsetY = paramInt6;
    this.QE = new Paint();
    this.QE.setColor(0);
    this.QE.setAntiAlias(true);
    this.QE.setShadowLayer(paramInt4, paramInt5, paramInt6, paramInt3);
    this.QE.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    this.mge = new Paint();
    this.mge.setAntiAlias(true);
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
    if (this.mgh != null)
    {
      if (this.mgh.length != 1) {
        break label92;
      }
      this.mge.setColor(this.mgh[0]);
    }
    while (this.mgf == 1)
    {
      paramCanvas.drawRoundRect(this.mgi, this.mgg, this.mgg, this.QE);
      paramCanvas.drawRoundRect(this.mgi, this.mgg, this.mgg, this.mge);
      AppMethodBeat.o(176780);
      return;
      label92:
      this.mge.setShader(new LinearGradient(this.mgi.left, this.mgi.height() / 2.0F, this.mgi.right, this.mgi.height() / 2.0F, this.mgh, null, Shader.TileMode.CLAMP));
    }
    paramCanvas.drawCircle(this.mgi.centerX(), this.mgi.centerY(), Math.min(this.mgi.width(), this.mgi.height()) / 2.0F, this.QE);
    paramCanvas.drawCircle(this.mgi.centerX(), this.mgi.centerY(), Math.min(this.mgi.width(), this.mgi.height()) / 2.0F, this.mge);
    AppMethodBeat.o(176780);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(176781);
    this.QE.setAlpha(paramInt);
    AppMethodBeat.o(176781);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(176779);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mgi = new RectF(this.QC + paramInt1 - this.mOffsetX, this.QC + paramInt2 - this.mOffsetY, paramInt3 - this.QC - this.mOffsetX, paramInt4 - this.QC - this.mOffsetY);
    AppMethodBeat.o(176779);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(176782);
    this.QE.setColorFilter(paramColorFilter);
    AppMethodBeat.o(176782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.z
 * JD-Core Version:    0.7.0.1
 */
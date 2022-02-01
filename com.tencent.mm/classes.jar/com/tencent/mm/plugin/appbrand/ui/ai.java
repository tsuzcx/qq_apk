package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai
  extends Drawable
{
  private int SE;
  private Paint SG;
  private int mOffsetX;
  private int mOffsetY;
  private Paint nYR;
  private int nYS;
  private int nYT;
  private int[] nYU;
  private RectF nYV;
  
  private ai(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(176778);
    this.nYS = paramInt1;
    this.nYU = paramArrayOfInt;
    this.nYT = paramInt2;
    this.SE = paramInt4;
    this.mOffsetX = paramInt5;
    this.mOffsetY = paramInt6;
    this.SG = new Paint();
    this.SG.setColor(0);
    this.SG.setAntiAlias(true);
    this.SG.setShadowLayer(paramInt4, paramInt5, paramInt6, paramInt3);
    this.SG.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    this.nYR = new Paint();
    this.nYR.setAntiAlias(true);
    AppMethodBeat.o(176778);
  }
  
  public static void b(View paramView, Drawable paramDrawable)
  {
    AppMethodBeat.i(176783);
    paramView.setLayerType(1, null);
    u.a(paramView, paramDrawable);
    AppMethodBeat.o(176783);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(176780);
    if (this.nYU != null)
    {
      if (this.nYU.length != 1) {
        break label92;
      }
      this.nYR.setColor(this.nYU[0]);
    }
    while (this.nYS == 1)
    {
      paramCanvas.drawRoundRect(this.nYV, this.nYT, this.nYT, this.SG);
      paramCanvas.drawRoundRect(this.nYV, this.nYT, this.nYT, this.nYR);
      AppMethodBeat.o(176780);
      return;
      label92:
      this.nYR.setShader(new LinearGradient(this.nYV.left, this.nYV.height() / 2.0F, this.nYV.right, this.nYV.height() / 2.0F, this.nYU, null, Shader.TileMode.CLAMP));
    }
    paramCanvas.drawCircle(this.nYV.centerX(), this.nYV.centerY(), Math.min(this.nYV.width(), this.nYV.height()) / 2.0F, this.SG);
    paramCanvas.drawCircle(this.nYV.centerX(), this.nYV.centerY(), Math.min(this.nYV.width(), this.nYV.height()) / 2.0F, this.nYR);
    AppMethodBeat.o(176780);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(176781);
    this.SG.setAlpha(paramInt);
    AppMethodBeat.o(176781);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(176779);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.nYV = new RectF(this.SE + paramInt1 - this.mOffsetX, this.SE + paramInt2 - this.mOffsetY, paramInt3 - this.SE - this.mOffsetX, paramInt4 - this.SE - this.mOffsetY);
    AppMethodBeat.o(176779);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(176782);
    this.SG.setColorFilter(paramColorFilter);
    AppMethodBeat.o(176782);
  }
  
  public static final class a
  {
    public int SE;
    public int mOffsetX;
    public int mOffsetY;
    private int nYS;
    public int nYT;
    private int[] nYU;
    public int nYW;
    
    public a()
    {
      AppMethodBeat.i(176776);
      this.mOffsetX = 0;
      this.mOffsetY = 0;
      this.nYS = 1;
      this.nYT = 12;
      this.nYW = Color.parseColor("#4d000000");
      this.SE = 18;
      this.mOffsetX = 0;
      this.mOffsetY = 0;
      this.nYU = new int[1];
      this.nYU[0] = 0;
      AppMethodBeat.o(176776);
    }
    
    public final ai bXO()
    {
      AppMethodBeat.i(176777);
      ai localai = new ai(this.nYS, this.nYU, this.nYT, this.nYW, this.SE, this.mOffsetX, this.mOffsetY, (byte)0);
      AppMethodBeat.o(176777);
      return localai;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ai
 * JD-Core Version:    0.7.0.1
 */
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
import android.support.v4.view.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ab
  extends Drawable
{
  private int Sr;
  private Paint St;
  private Paint mGF;
  private int mGG;
  private int mGH;
  private int[] mGI;
  private RectF mGJ;
  private int mOffsetX;
  private int mOffsetY;
  
  private ab(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(176778);
    this.mGG = paramInt1;
    this.mGI = paramArrayOfInt;
    this.mGH = paramInt2;
    this.Sr = paramInt4;
    this.mOffsetX = paramInt5;
    this.mOffsetY = paramInt6;
    this.St = new Paint();
    this.St.setColor(0);
    this.St.setAntiAlias(true);
    this.St.setShadowLayer(paramInt4, paramInt5, paramInt6, paramInt3);
    this.St.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    this.mGF = new Paint();
    this.mGF.setAntiAlias(true);
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
    if (this.mGI != null)
    {
      if (this.mGI.length != 1) {
        break label92;
      }
      this.mGF.setColor(this.mGI[0]);
    }
    while (this.mGG == 1)
    {
      paramCanvas.drawRoundRect(this.mGJ, this.mGH, this.mGH, this.St);
      paramCanvas.drawRoundRect(this.mGJ, this.mGH, this.mGH, this.mGF);
      AppMethodBeat.o(176780);
      return;
      label92:
      this.mGF.setShader(new LinearGradient(this.mGJ.left, this.mGJ.height() / 2.0F, this.mGJ.right, this.mGJ.height() / 2.0F, this.mGI, null, Shader.TileMode.CLAMP));
    }
    paramCanvas.drawCircle(this.mGJ.centerX(), this.mGJ.centerY(), Math.min(this.mGJ.width(), this.mGJ.height()) / 2.0F, this.St);
    paramCanvas.drawCircle(this.mGJ.centerX(), this.mGJ.centerY(), Math.min(this.mGJ.width(), this.mGJ.height()) / 2.0F, this.mGF);
    AppMethodBeat.o(176780);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(176781);
    this.St.setAlpha(paramInt);
    AppMethodBeat.o(176781);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(176779);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mGJ = new RectF(this.Sr + paramInt1 - this.mOffsetX, this.Sr + paramInt2 - this.mOffsetY, paramInt3 - this.Sr - this.mOffsetX, paramInt4 - this.Sr - this.mOffsetY);
    AppMethodBeat.o(176779);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(176782);
    this.St.setColorFilter(paramColorFilter);
    AppMethodBeat.o(176782);
  }
  
  public static final class a
  {
    public int Sr;
    private int mGG;
    public int mGH;
    private int[] mGI;
    public int mGK;
    public int mOffsetX;
    public int mOffsetY;
    
    public a()
    {
      AppMethodBeat.i(176776);
      this.mOffsetX = 0;
      this.mOffsetY = 0;
      this.mGG = 1;
      this.mGH = 12;
      this.mGK = Color.parseColor("#4d000000");
      this.Sr = 18;
      this.mOffsetX = 0;
      this.mOffsetY = 0;
      this.mGI = new int[1];
      this.mGI[0] = 0;
      AppMethodBeat.o(176776);
    }
    
    public final ab bzO()
    {
      AppMethodBeat.i(176777);
      ab localab = new ab(this.mGG, this.mGI, this.mGH, this.mGK, this.Sr, this.mOffsetX, this.mOffsetY, (byte)0);
      AppMethodBeat.o(176777);
      return localab;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ab
 * JD-Core Version:    0.7.0.1
 */
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

public final class ac
  extends Drawable
{
  private int Sr;
  private Paint St;
  private Paint mLJ;
  private int mLK;
  private int mLL;
  private int[] mLM;
  private RectF mLN;
  private int mOffsetX;
  private int mOffsetY;
  
  private ac(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(176778);
    this.mLK = paramInt1;
    this.mLM = paramArrayOfInt;
    this.mLL = paramInt2;
    this.Sr = paramInt4;
    this.mOffsetX = paramInt5;
    this.mOffsetY = paramInt6;
    this.St = new Paint();
    this.St.setColor(0);
    this.St.setAntiAlias(true);
    this.St.setShadowLayer(paramInt4, paramInt5, paramInt6, paramInt3);
    this.St.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    this.mLJ = new Paint();
    this.mLJ.setAntiAlias(true);
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
    if (this.mLM != null)
    {
      if (this.mLM.length != 1) {
        break label92;
      }
      this.mLJ.setColor(this.mLM[0]);
    }
    while (this.mLK == 1)
    {
      paramCanvas.drawRoundRect(this.mLN, this.mLL, this.mLL, this.St);
      paramCanvas.drawRoundRect(this.mLN, this.mLL, this.mLL, this.mLJ);
      AppMethodBeat.o(176780);
      return;
      label92:
      this.mLJ.setShader(new LinearGradient(this.mLN.left, this.mLN.height() / 2.0F, this.mLN.right, this.mLN.height() / 2.0F, this.mLM, null, Shader.TileMode.CLAMP));
    }
    paramCanvas.drawCircle(this.mLN.centerX(), this.mLN.centerY(), Math.min(this.mLN.width(), this.mLN.height()) / 2.0F, this.St);
    paramCanvas.drawCircle(this.mLN.centerX(), this.mLN.centerY(), Math.min(this.mLN.width(), this.mLN.height()) / 2.0F, this.mLJ);
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
    this.mLN = new RectF(this.Sr + paramInt1 - this.mOffsetX, this.Sr + paramInt2 - this.mOffsetY, paramInt3 - this.Sr - this.mOffsetX, paramInt4 - this.Sr - this.mOffsetY);
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
    private int mLK;
    public int mLL;
    private int[] mLM;
    public int mLO;
    public int mOffsetX;
    public int mOffsetY;
    
    public a()
    {
      AppMethodBeat.i(176776);
      this.mOffsetX = 0;
      this.mOffsetY = 0;
      this.mLK = 1;
      this.mLL = 12;
      this.mLO = Color.parseColor("#4d000000");
      this.Sr = 18;
      this.mOffsetX = 0;
      this.mOffsetY = 0;
      this.mLM = new int[1];
      this.mLM[0] = 0;
      AppMethodBeat.o(176776);
    }
    
    public final ac bAJ()
    {
      AppMethodBeat.i(176777);
      ac localac = new ac(this.mLK, this.mLM, this.mLL, this.mLO, this.Sr, this.mOffsetX, this.mOffsetY, (byte)0);
      AppMethodBeat.o(176777);
      return localac;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ac
 * JD-Core Version:    0.7.0.1
 */
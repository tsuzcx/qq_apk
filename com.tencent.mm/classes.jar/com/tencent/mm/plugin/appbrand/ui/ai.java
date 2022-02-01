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
import android.view.View;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai
  extends Drawable
{
  private int CL;
  private int CM;
  private int aob;
  private Paint aod;
  private Paint raC;
  private int raD;
  private int raE;
  private int[] raF;
  private RectF raG;
  
  private ai(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(176778);
    this.raD = paramInt1;
    this.raF = paramArrayOfInt;
    this.raE = paramInt2;
    this.aob = paramInt4;
    this.CL = paramInt5;
    this.CM = paramInt6;
    this.aod = new Paint();
    this.aod.setColor(0);
    this.aod.setAntiAlias(true);
    this.aod.setShadowLayer(paramInt4, paramInt5, paramInt6, paramInt3);
    this.aod.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    this.raC = new Paint();
    this.raC.setAntiAlias(true);
    AppMethodBeat.o(176778);
  }
  
  public static void b(View paramView, Drawable paramDrawable)
  {
    AppMethodBeat.i(176783);
    paramView.setLayerType(1, null);
    w.a(paramView, paramDrawable);
    AppMethodBeat.o(176783);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(176780);
    if (this.raF != null)
    {
      if (this.raF.length != 1) {
        break label92;
      }
      this.raC.setColor(this.raF[0]);
    }
    while (this.raD == 1)
    {
      paramCanvas.drawRoundRect(this.raG, this.raE, this.raE, this.aod);
      paramCanvas.drawRoundRect(this.raG, this.raE, this.raE, this.raC);
      AppMethodBeat.o(176780);
      return;
      label92:
      this.raC.setShader(new LinearGradient(this.raG.left, this.raG.height() / 2.0F, this.raG.right, this.raG.height() / 2.0F, this.raF, null, Shader.TileMode.CLAMP));
    }
    paramCanvas.drawCircle(this.raG.centerX(), this.raG.centerY(), Math.min(this.raG.width(), this.raG.height()) / 2.0F, this.aod);
    paramCanvas.drawCircle(this.raG.centerX(), this.raG.centerY(), Math.min(this.raG.width(), this.raG.height()) / 2.0F, this.raC);
    AppMethodBeat.o(176780);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(176781);
    this.aod.setAlpha(paramInt);
    AppMethodBeat.o(176781);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(176779);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.raG = new RectF(this.aob + paramInt1 - this.CL, this.aob + paramInt2 - this.CM, paramInt3 - this.aob - this.CL, paramInt4 - this.aob - this.CM);
    AppMethodBeat.o(176779);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(176782);
    this.aod.setColorFilter(paramColorFilter);
    AppMethodBeat.o(176782);
  }
  
  public static final class a
  {
    public int CL;
    public int CM;
    public int aob;
    private int raD;
    public int raE;
    private int[] raF;
    public int raH;
    
    public a()
    {
      AppMethodBeat.i(176776);
      this.CL = 0;
      this.CM = 0;
      this.raD = 1;
      this.raE = 12;
      this.raH = Color.parseColor("#4d000000");
      this.aob = 18;
      this.CL = 0;
      this.CM = 0;
      this.raF = new int[1];
      this.raF[0] = 0;
      AppMethodBeat.o(176776);
    }
    
    public final ai cky()
    {
      AppMethodBeat.i(176777);
      ai localai = new ai(this.raD, this.raF, this.raE, this.raH, this.aob, this.CL, this.CM, (byte)0);
      AppMethodBeat.o(176777);
      return localai;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ai
 * JD-Core Version:    0.7.0.1
 */
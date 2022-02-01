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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq
  extends Drawable
{
  private int biT;
  private int biU;
  private int ccL;
  private Paint ccN;
  private Paint ugs;
  private int ugt;
  private int ugu;
  private int[] ugv;
  private RectF ugw;
  
  private aq(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(176778);
    this.ugt = paramInt1;
    this.ugv = paramArrayOfInt;
    this.ugu = paramInt2;
    this.ccL = paramInt4;
    this.biT = paramInt5;
    this.biU = paramInt6;
    this.ccN = new Paint();
    this.ccN.setColor(0);
    this.ccN.setAntiAlias(true);
    this.ccN.setShadowLayer(paramInt4, paramInt5, paramInt6, paramInt3);
    this.ccN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    this.ugs = new Paint();
    this.ugs.setAntiAlias(true);
    AppMethodBeat.o(176778);
  }
  
  public static void b(View paramView, Drawable paramDrawable)
  {
    AppMethodBeat.i(176783);
    paramView.setLayerType(1, null);
    z.a(paramView, paramDrawable);
    AppMethodBeat.o(176783);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(176780);
    if (this.ugv != null)
    {
      if (this.ugv.length != 1) {
        break label92;
      }
      this.ugs.setColor(this.ugv[0]);
    }
    while (this.ugt == 1)
    {
      paramCanvas.drawRoundRect(this.ugw, this.ugu, this.ugu, this.ccN);
      paramCanvas.drawRoundRect(this.ugw, this.ugu, this.ugu, this.ugs);
      AppMethodBeat.o(176780);
      return;
      label92:
      this.ugs.setShader(new LinearGradient(this.ugw.left, this.ugw.height() / 2.0F, this.ugw.right, this.ugw.height() / 2.0F, this.ugv, null, Shader.TileMode.CLAMP));
    }
    paramCanvas.drawCircle(this.ugw.centerX(), this.ugw.centerY(), Math.min(this.ugw.width(), this.ugw.height()) / 2.0F, this.ccN);
    paramCanvas.drawCircle(this.ugw.centerX(), this.ugw.centerY(), Math.min(this.ugw.width(), this.ugw.height()) / 2.0F, this.ugs);
    AppMethodBeat.o(176780);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(176781);
    this.ccN.setAlpha(paramInt);
    AppMethodBeat.o(176781);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(176779);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.ugw = new RectF(this.ccL + paramInt1 - this.biT, this.ccL + paramInt2 - this.biU, paramInt3 - this.ccL - this.biT, paramInt4 - this.ccL - this.biU);
    AppMethodBeat.o(176779);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(176782);
    this.ccN.setColorFilter(paramColorFilter);
    AppMethodBeat.o(176782);
  }
  
  public static final class a
  {
    public int biT;
    public int biU;
    public int ccL;
    private int ugt;
    public int ugu;
    private int[] ugv;
    public int ugx;
    
    public a()
    {
      AppMethodBeat.i(176776);
      this.biT = 0;
      this.biU = 0;
      this.ugt = 1;
      this.ugu = 12;
      this.ugx = Color.parseColor("#4d000000");
      this.ccL = 18;
      this.biT = 0;
      this.biU = 0;
      this.ugv = new int[1];
      this.ugv[0] = 0;
      AppMethodBeat.o(176776);
    }
    
    public final aq cLM()
    {
      AppMethodBeat.i(176777);
      aq localaq = new aq(this.ugt, this.ugv, this.ugu, this.ugx, this.ccL, this.biT, this.biU, (byte)0);
      AppMethodBeat.o(176777);
      return localaq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.aq
 * JD-Core Version:    0.7.0.1
 */
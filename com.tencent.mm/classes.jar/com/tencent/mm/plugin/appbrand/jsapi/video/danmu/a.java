package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements d
{
  private static int lpg;
  private static int lph;
  private int agZ;
  private int ahh;
  private StaticLayout gFm;
  private SpannableString lpi;
  private int lpj;
  private int lpk;
  private int lpl;
  private int lpm;
  private float lpn;
  private Context mContext;
  private int mTextColor;
  private int mTextSize;
  
  public a(Context paramContext, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137851);
    this.lpl = -1;
    this.mTextColor = -1;
    this.mContext = paramContext;
    this.lpi = paramSpannableString;
    this.mTextSize = b.J(this.mContext, b.lpo);
    this.mTextColor = paramInt1;
    this.lpn = 3.0F;
    this.lpm = paramInt2;
    paramContext = new TextPaint();
    paramContext.setAntiAlias(true);
    paramContext.setColor(this.mTextColor);
    paramContext.setTextSize(this.mTextSize);
    paramSpannableString = paramContext.getFontMetrics();
    this.ahh = ((int)Math.ceil(paramSpannableString.descent - paramSpannableString.top) + 2);
    this.gFm = new StaticLayout(this.lpi, paramContext, (int)Layout.getDesiredWidth(this.lpi, 0, this.lpi.length(), paramContext) + 1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.agZ = this.gFm.getWidth();
    AppMethodBeat.o(137851);
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(137854);
    if (paramd.getWidth() + paramd.getCurrX() > lpg)
    {
      AppMethodBeat.o(137854);
      return true;
    }
    if (this.lpl < 0) {
      this.lpl = b.J(this.mContext, 20);
    }
    if (paramd.bnV() >= this.lpn)
    {
      if ((paramd.bnV() == this.lpn) && (lpg - (paramd.getCurrX() + paramd.getWidth()) < this.lpl))
      {
        AppMethodBeat.o(137854);
        return true;
      }
      AppMethodBeat.o(137854);
      return false;
    }
    if ((paramd.getCurrX() + paramd.getWidth()) / (paramd.bnV() * b.bnY()) * this.lpn * b.bnY() > lpg - this.lpl * 1.5D)
    {
      AppMethodBeat.o(137854);
      return true;
    }
    AppMethodBeat.o(137854);
    return false;
  }
  
  public final void b(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(137852);
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    if ((i != lpg) || (j != lph))
    {
      lpg = i;
      lph = j;
    }
    paramCanvas.save();
    paramCanvas.translate(this.lpj, this.lpk);
    this.gFm.draw(paramCanvas);
    paramCanvas.restore();
    if (!paramBoolean) {
      this.lpj = ((int)(this.lpj - b.bnY() * this.lpn));
    }
    AppMethodBeat.o(137852);
  }
  
  public final float bnV()
  {
    return this.lpn;
  }
  
  public final boolean bnW()
  {
    AppMethodBeat.i(137853);
    if ((this.lpj < 0) && (Math.abs(this.lpj) > this.agZ))
    {
      AppMethodBeat.o(137853);
      return true;
    }
    AppMethodBeat.o(137853);
    return false;
  }
  
  public final int bnX()
  {
    return this.lpm;
  }
  
  public final void dV(int paramInt1, int paramInt2)
  {
    this.lpj = paramInt1;
    this.lpk = paramInt2;
  }
  
  public final int getCurrX()
  {
    return this.lpj;
  }
  
  public final int getWidth()
  {
    return this.agZ;
  }
  
  public final boolean tA(int paramInt)
  {
    if (paramInt < this.lpm) {}
    while (paramInt - this.lpm > b.lpp) {
      return false;
    }
    return true;
  }
  
  public final boolean tB(int paramInt)
  {
    return paramInt - this.lpm > b.lpp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a
 * JD-Core Version:    0.7.0.1
 */
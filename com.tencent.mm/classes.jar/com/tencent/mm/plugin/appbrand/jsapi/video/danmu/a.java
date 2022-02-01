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
  private static int sDE;
  private static int sDF;
  private int ckf;
  private Context mContext;
  private StaticLayout mGW;
  private int oG;
  private int oy;
  private SpannableString sDG;
  private int sDH;
  private int sDI;
  private int sDJ;
  private int sDK;
  private int sDL;
  private float sDM;
  
  public a(Context paramContext, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137851);
    this.sDJ = -1;
    this.ckf = -1;
    this.mContext = paramContext;
    this.sDG = paramSpannableString;
    this.sDK = b.W(this.mContext, b.sDN);
    this.ckf = paramInt1;
    this.sDM = 3.0F;
    this.sDL = paramInt2;
    paramContext = new TextPaint();
    paramContext.setAntiAlias(true);
    paramContext.setColor(this.ckf);
    paramContext.setTextSize(this.sDK);
    paramSpannableString = paramContext.getFontMetrics();
    this.oG = ((int)Math.ceil(paramSpannableString.descent - paramSpannableString.top) + 2);
    this.mGW = new StaticLayout(this.sDG, paramContext, (int)Layout.getDesiredWidth(this.sDG, 0, this.sDG.length(), paramContext) + 1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.oy = this.mGW.getWidth();
    AppMethodBeat.o(137851);
  }
  
  public final boolean Bo(int paramInt)
  {
    if (paramInt < this.sDL) {}
    while (paramInt - this.sDL > b.sDO) {
      return false;
    }
    return true;
  }
  
  public final boolean Bp(int paramInt)
  {
    return paramInt - this.sDL > b.sDO;
  }
  
  public final int Fo()
  {
    return this.sDH;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(137854);
    if (paramd.getWidth() + paramd.Fo() > sDE)
    {
      AppMethodBeat.o(137854);
      return true;
    }
    if (this.sDJ < 0) {
      this.sDJ = b.W(this.mContext, 20);
    }
    if (paramd.cwf() >= this.sDM)
    {
      if ((paramd.cwf() == this.sDM) && (sDE - (paramd.Fo() + paramd.getWidth()) < this.sDJ))
      {
        AppMethodBeat.o(137854);
        return true;
      }
      AppMethodBeat.o(137854);
      return false;
    }
    if ((paramd.Fo() + paramd.getWidth()) / (paramd.cwf() * b.cwi()) * this.sDM * b.cwi() > sDE - this.sDJ * 1.5D)
    {
      AppMethodBeat.o(137854);
      return true;
    }
    AppMethodBeat.o(137854);
    return false;
  }
  
  public final void c(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(137852);
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    if ((i != sDE) || (j != sDF))
    {
      sDE = i;
      sDF = j;
    }
    paramCanvas.save();
    paramCanvas.translate(this.sDH, this.sDI);
    this.mGW.draw(paramCanvas);
    paramCanvas.restore();
    if (!paramBoolean) {
      this.sDH = ((int)(this.sDH - b.cwi() * this.sDM));
    }
    AppMethodBeat.o(137852);
  }
  
  public final float cwf()
  {
    return this.sDM;
  }
  
  public final boolean cwg()
  {
    AppMethodBeat.i(137853);
    if ((this.sDH < 0) && (Math.abs(this.sDH) > this.oy))
    {
      AppMethodBeat.o(137853);
      return true;
    }
    AppMethodBeat.o(137853);
    return false;
  }
  
  public final int cwh()
  {
    return this.sDL;
  }
  
  public final void fz(int paramInt1, int paramInt2)
  {
    this.sDH = paramInt1;
    this.sDI = paramInt2;
  }
  
  public final int getWidth()
  {
    return this.oy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a
 * JD-Core Version:    0.7.0.1
 */
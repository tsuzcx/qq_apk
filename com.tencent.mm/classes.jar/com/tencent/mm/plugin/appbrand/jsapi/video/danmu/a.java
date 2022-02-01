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
  private static int kSD;
  private static int kSE;
  private int afi;
  private int afq;
  private StaticLayout glC;
  private SpannableString kSF;
  private int kSG;
  private int kSH;
  private int kSI;
  private int kSJ;
  private float kSK;
  private Context mContext;
  private int mTextColor;
  private int mTextSize;
  
  public a(Context paramContext, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137851);
    this.kSI = -1;
    this.mTextColor = -1;
    this.mContext = paramContext;
    this.kSF = paramSpannableString;
    this.mTextSize = b.I(this.mContext, b.kSL);
    this.mTextColor = paramInt1;
    this.kSK = 3.0F;
    this.kSJ = paramInt2;
    paramContext = new TextPaint();
    paramContext.setAntiAlias(true);
    paramContext.setColor(this.mTextColor);
    paramContext.setTextSize(this.mTextSize);
    paramSpannableString = paramContext.getFontMetrics();
    this.afq = ((int)Math.ceil(paramSpannableString.descent - paramSpannableString.top) + 2);
    this.glC = new StaticLayout(this.kSF, paramContext, (int)Layout.getDesiredWidth(this.kSF, 0, this.kSF.length(), paramContext) + 1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.afi = this.glC.getWidth();
    AppMethodBeat.o(137851);
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(137854);
    if (paramd.getWidth() + paramd.getCurrX() > kSD)
    {
      AppMethodBeat.o(137854);
      return true;
    }
    if (this.kSI < 0) {
      this.kSI = b.I(this.mContext, 20);
    }
    if (paramd.bkk() >= this.kSK)
    {
      if ((paramd.bkk() == this.kSK) && (kSD - (paramd.getCurrX() + paramd.getWidth()) < this.kSI))
      {
        AppMethodBeat.o(137854);
        return true;
      }
      AppMethodBeat.o(137854);
      return false;
    }
    if ((paramd.getCurrX() + paramd.getWidth()) / (paramd.bkk() * b.bkn()) * this.kSK * b.bkn() > kSD - this.kSI * 1.5D)
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
    if ((i != kSD) || (j != kSE))
    {
      kSD = i;
      kSE = j;
    }
    paramCanvas.save();
    paramCanvas.translate(this.kSG, this.kSH);
    this.glC.draw(paramCanvas);
    paramCanvas.restore();
    if (!paramBoolean) {
      this.kSG = ((int)(this.kSG - b.bkn() * this.kSK));
    }
    AppMethodBeat.o(137852);
  }
  
  public final float bkk()
  {
    return this.kSK;
  }
  
  public final boolean bkl()
  {
    AppMethodBeat.i(137853);
    if ((this.kSG < 0) && (Math.abs(this.kSG) > this.afi))
    {
      AppMethodBeat.o(137853);
      return true;
    }
    AppMethodBeat.o(137853);
    return false;
  }
  
  public final int bkm()
  {
    return this.kSJ;
  }
  
  public final void dT(int paramInt1, int paramInt2)
  {
    this.kSG = paramInt1;
    this.kSH = paramInt2;
  }
  
  public final int getCurrX()
  {
    return this.kSG;
  }
  
  public final int getWidth()
  {
    return this.afi;
  }
  
  public final boolean sX(int paramInt)
  {
    if (paramInt < this.kSJ) {}
    while (paramInt - this.kSJ > b.kSM) {
      return false;
    }
    return true;
  }
  
  public final boolean sY(int paramInt)
  {
    return paramInt - this.kSJ > b.kSM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a
 * JD-Core Version:    0.7.0.1
 */
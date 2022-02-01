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
  private static int pyA;
  private static int pyz;
  private int avJ;
  private StaticLayout kgD;
  private Context mContext;
  private int nH;
  private int nz;
  private SpannableString pyB;
  private int pyC;
  private int pyD;
  private int pyE;
  private int pyF;
  private int pyG;
  private float pyH;
  
  public a(Context paramContext, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137851);
    this.pyE = -1;
    this.avJ = -1;
    this.mContext = paramContext;
    this.pyB = paramSpannableString;
    this.pyF = b.R(this.mContext, b.pyI);
    this.avJ = paramInt1;
    this.pyH = 3.0F;
    this.pyG = paramInt2;
    paramContext = new TextPaint();
    paramContext.setAntiAlias(true);
    paramContext.setColor(this.avJ);
    paramContext.setTextSize(this.pyF);
    paramSpannableString = paramContext.getFontMetrics();
    this.nH = ((int)Math.ceil(paramSpannableString.descent - paramSpannableString.top) + 2);
    this.kgD = new StaticLayout(this.pyB, paramContext, (int)Layout.getDesiredWidth(this.pyB, 0, this.pyB.length(), paramContext) + 1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.nz = this.kgD.getWidth();
    AppMethodBeat.o(137851);
  }
  
  public final boolean AZ(int paramInt)
  {
    if (paramInt < this.pyG) {}
    while (paramInt - this.pyG > b.pyJ) {
      return false;
    }
    return true;
  }
  
  public final boolean Ba(int paramInt)
  {
    return paramInt - this.pyG > b.pyJ;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(137854);
    if (paramd.getWidth() + paramd.bVU() > pyz)
    {
      AppMethodBeat.o(137854);
      return true;
    }
    if (this.pyE < 0) {
      this.pyE = b.R(this.mContext, 20);
    }
    if (paramd.bVS() >= this.pyH)
    {
      if ((paramd.bVS() == this.pyH) && (pyz - (paramd.bVU() + paramd.getWidth()) < this.pyE))
      {
        AppMethodBeat.o(137854);
        return true;
      }
      AppMethodBeat.o(137854);
      return false;
    }
    if ((paramd.bVU() + paramd.getWidth()) / (paramd.bVS() * b.bVW()) * this.pyH * b.bVW() > pyz - this.pyE * 1.5D)
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
    if ((i != pyz) || (j != pyA))
    {
      pyz = i;
      pyA = j;
    }
    paramCanvas.save();
    paramCanvas.translate(this.pyC, this.pyD);
    this.kgD.draw(paramCanvas);
    paramCanvas.restore();
    if (!paramBoolean) {
      this.pyC = ((int)(this.pyC - b.bVW() * this.pyH));
    }
    AppMethodBeat.o(137852);
  }
  
  public final float bVS()
  {
    return this.pyH;
  }
  
  public final boolean bVT()
  {
    AppMethodBeat.i(137853);
    if ((this.pyC < 0) && (Math.abs(this.pyC) > this.nz))
    {
      AppMethodBeat.o(137853);
      return true;
    }
    AppMethodBeat.o(137853);
    return false;
  }
  
  public final int bVU()
  {
    return this.pyC;
  }
  
  public final int bVV()
  {
    return this.pyG;
  }
  
  public final void eF(int paramInt1, int paramInt2)
  {
    this.pyC = paramInt1;
    this.pyD = paramInt2;
  }
  
  public final int getWidth()
  {
    return this.nz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a
 * JD-Core Version:    0.7.0.1
 */
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
  private static int ltD;
  private static int ltE;
  private int agZ;
  private int ahh;
  private StaticLayout gHT;
  private SpannableString ltF;
  private int ltG;
  private int ltH;
  private int ltI;
  private int ltJ;
  private float ltK;
  private Context mContext;
  private int mTextColor;
  private int mTextSize;
  
  public a(Context paramContext, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137851);
    this.ltI = -1;
    this.mTextColor = -1;
    this.mContext = paramContext;
    this.ltF = paramSpannableString;
    this.mTextSize = b.J(this.mContext, b.ltL);
    this.mTextColor = paramInt1;
    this.ltK = 3.0F;
    this.ltJ = paramInt2;
    paramContext = new TextPaint();
    paramContext.setAntiAlias(true);
    paramContext.setColor(this.mTextColor);
    paramContext.setTextSize(this.mTextSize);
    paramSpannableString = paramContext.getFontMetrics();
    this.ahh = ((int)Math.ceil(paramSpannableString.descent - paramSpannableString.top) + 2);
    this.gHT = new StaticLayout(this.ltF, paramContext, (int)Layout.getDesiredWidth(this.ltF, 0, this.ltF.length(), paramContext) + 1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.agZ = this.gHT.getWidth();
    AppMethodBeat.o(137851);
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(137854);
    if (paramd.getWidth() + paramd.getCurrX() > ltD)
    {
      AppMethodBeat.o(137854);
      return true;
    }
    if (this.ltI < 0) {
      this.ltI = b.J(this.mContext, 20);
    }
    if (paramd.boF() >= this.ltK)
    {
      if ((paramd.boF() == this.ltK) && (ltD - (paramd.getCurrX() + paramd.getWidth()) < this.ltI))
      {
        AppMethodBeat.o(137854);
        return true;
      }
      AppMethodBeat.o(137854);
      return false;
    }
    if ((paramd.getCurrX() + paramd.getWidth()) / (paramd.boF() * b.boI()) * this.ltK * b.boI() > ltD - this.ltI * 1.5D)
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
    if ((i != ltD) || (j != ltE))
    {
      ltD = i;
      ltE = j;
    }
    paramCanvas.save();
    paramCanvas.translate(this.ltG, this.ltH);
    this.gHT.draw(paramCanvas);
    paramCanvas.restore();
    if (!paramBoolean) {
      this.ltG = ((int)(this.ltG - b.boI() * this.ltK));
    }
    AppMethodBeat.o(137852);
  }
  
  public final float boF()
  {
    return this.ltK;
  }
  
  public final boolean boG()
  {
    AppMethodBeat.i(137853);
    if ((this.ltG < 0) && (Math.abs(this.ltG) > this.agZ))
    {
      AppMethodBeat.o(137853);
      return true;
    }
    AppMethodBeat.o(137853);
    return false;
  }
  
  public final int boH()
  {
    return this.ltJ;
  }
  
  public final void dV(int paramInt1, int paramInt2)
  {
    this.ltG = paramInt1;
    this.ltH = paramInt2;
  }
  
  public final int getCurrX()
  {
    return this.ltG;
  }
  
  public final int getWidth()
  {
    return this.agZ;
  }
  
  public final boolean tE(int paramInt)
  {
    if (paramInt < this.ltJ) {}
    while (paramInt - this.ltJ > b.ltM) {
      return false;
    }
    return true;
  }
  
  public final boolean tF(int paramInt)
  {
    return paramInt - this.ltJ > b.ltM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a
 * JD-Core Version:    0.7.0.1
 */
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
  private static int krk;
  private static int krl;
  private int aeo;
  private int aew;
  private StaticLayout ggW;
  private SpannableString krm;
  private int krn;
  private int kro;
  private int krp;
  private int krq;
  private float krr;
  private Context mContext;
  private int mTextColor;
  private int mTextSize;
  
  public a(Context paramContext, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137851);
    this.krp = -1;
    this.mTextColor = -1;
    this.mContext = paramContext;
    this.krm = paramSpannableString;
    this.mTextSize = b.F(this.mContext, b.krs);
    this.mTextColor = paramInt1;
    this.krr = 3.0F;
    this.krq = paramInt2;
    paramContext = new TextPaint();
    paramContext.setAntiAlias(true);
    paramContext.setColor(this.mTextColor);
    paramContext.setTextSize(this.mTextSize);
    paramSpannableString = paramContext.getFontMetrics();
    this.aew = ((int)Math.ceil(paramSpannableString.descent - paramSpannableString.top) + 2);
    this.ggW = new StaticLayout(this.krm, paramContext, (int)Layout.getDesiredWidth(this.krm, 0, this.krm.length(), paramContext) + 1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.aeo = this.ggW.getWidth();
    AppMethodBeat.o(137851);
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(137854);
    if (paramd.getWidth() + paramd.getCurrX() > krk)
    {
      AppMethodBeat.o(137854);
      return true;
    }
    if (this.krp < 0) {
      this.krp = b.F(this.mContext, 20);
    }
    if (paramd.bdp() >= this.krr)
    {
      if ((paramd.bdp() == this.krr) && (krk - (paramd.getCurrX() + paramd.getWidth()) < this.krp))
      {
        AppMethodBeat.o(137854);
        return true;
      }
      AppMethodBeat.o(137854);
      return false;
    }
    if ((paramd.getCurrX() + paramd.getWidth()) / (paramd.bdp() * b.bds()) * this.krr * b.bds() > krk - this.krp * 1.5D)
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
    if ((i != krk) || (j != krl))
    {
      krk = i;
      krl = j;
    }
    paramCanvas.save();
    paramCanvas.translate(this.krn, this.kro);
    this.ggW.draw(paramCanvas);
    paramCanvas.restore();
    if (!paramBoolean) {
      this.krn = ((int)(this.krn - b.bds() * this.krr));
    }
    AppMethodBeat.o(137852);
  }
  
  public final float bdp()
  {
    return this.krr;
  }
  
  public final boolean bdq()
  {
    AppMethodBeat.i(137853);
    if ((this.krn < 0) && (Math.abs(this.krn) > this.aeo))
    {
      AppMethodBeat.o(137853);
      return true;
    }
    AppMethodBeat.o(137853);
    return false;
  }
  
  public final int bdr()
  {
    return this.krq;
  }
  
  public final void dS(int paramInt1, int paramInt2)
  {
    this.krn = paramInt1;
    this.kro = paramInt2;
  }
  
  public final int getCurrX()
  {
    return this.krn;
  }
  
  public final int getWidth()
  {
    return this.aeo;
  }
  
  public final boolean sh(int paramInt)
  {
    if (paramInt < this.krq) {}
    while (paramInt - this.krq > b.krt) {
      return false;
    }
    return true;
  }
  
  public final boolean si(int paramInt)
  {
    return paramInt - this.krq > b.krt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a
 * JD-Core Version:    0.7.0.1
 */
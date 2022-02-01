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
  private static int mAe;
  private static int mAf;
  private int QD;
  private int ahm;
  private int ahu;
  private StaticLayout huH;
  private SpannableString mAg;
  private int mAh;
  private int mAi;
  private int mAj;
  private int mAk;
  private int mAl;
  private float mAm;
  private Context mContext;
  
  public a(Context paramContext, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137851);
    this.mAj = -1;
    this.QD = -1;
    this.mContext = paramContext;
    this.mAg = paramSpannableString;
    this.mAk = b.N(this.mContext, b.mAn);
    this.QD = paramInt1;
    this.mAm = 3.0F;
    this.mAl = paramInt2;
    paramContext = new TextPaint();
    paramContext.setAntiAlias(true);
    paramContext.setColor(this.QD);
    paramContext.setTextSize(this.mAk);
    paramSpannableString = paramContext.getFontMetrics();
    this.ahu = ((int)Math.ceil(paramSpannableString.descent - paramSpannableString.top) + 2);
    this.huH = new StaticLayout(this.mAg, paramContext, (int)Layout.getDesiredWidth(this.mAg, 0, this.mAg.length(), paramContext) + 1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.ahm = this.huH.getWidth();
    AppMethodBeat.o(137851);
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(137854);
    if (paramd.getWidth() + paramd.getCurrX() > mAe)
    {
      AppMethodBeat.o(137854);
      return true;
    }
    if (this.mAj < 0) {
      this.mAj = b.N(this.mContext, 20);
    }
    if (paramd.bKi() >= this.mAm)
    {
      if ((paramd.bKi() == this.mAm) && (mAe - (paramd.getCurrX() + paramd.getWidth()) < this.mAj))
      {
        AppMethodBeat.o(137854);
        return true;
      }
      AppMethodBeat.o(137854);
      return false;
    }
    if ((paramd.getCurrX() + paramd.getWidth()) / (paramd.bKi() * b.bKl()) * this.mAm * b.bKl() > mAe - this.mAj * 1.5D)
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
    if ((i != mAe) || (j != mAf))
    {
      mAe = i;
      mAf = j;
    }
    paramCanvas.save();
    paramCanvas.translate(this.mAh, this.mAi);
    this.huH.draw(paramCanvas);
    paramCanvas.restore();
    if (!paramBoolean) {
      this.mAh = ((int)(this.mAh - b.bKl() * this.mAm));
    }
    AppMethodBeat.o(137852);
  }
  
  public final float bKi()
  {
    return this.mAm;
  }
  
  public final boolean bKj()
  {
    AppMethodBeat.i(137853);
    if ((this.mAh < 0) && (Math.abs(this.mAh) > this.ahm))
    {
      AppMethodBeat.o(137853);
      return true;
    }
    AppMethodBeat.o(137853);
    return false;
  }
  
  public final int bKk()
  {
    return this.mAl;
  }
  
  public final void eh(int paramInt1, int paramInt2)
  {
    this.mAh = paramInt1;
    this.mAi = paramInt2;
  }
  
  public final int getCurrX()
  {
    return this.mAh;
  }
  
  public final int getWidth()
  {
    return this.ahm;
  }
  
  public final boolean xC(int paramInt)
  {
    if (paramInt < this.mAl) {}
    while (paramInt - this.mAl > b.mAo) {
      return false;
    }
    return true;
  }
  
  public final boolean xD(int paramInt)
  {
    return paramInt - this.mAl > b.mAo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a
 * JD-Core Version:    0.7.0.1
 */
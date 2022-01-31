package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;

public final class a
  implements d
{
  private static int gFg;
  private static int gFh;
  private int FY = -1;
  private int WE;
  private int Ww;
  private StaticLayout dOj;
  private SpannableString gFi;
  private int gFj;
  private int gFk;
  private int gFl = -1;
  private int gFm;
  private int gFn;
  private float gFo;
  private Context mContext;
  
  public a(Context paramContext, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.gFi = paramSpannableString;
    this.gFm = b.y(this.mContext, b.gFp);
    this.FY = paramInt1;
    this.gFo = 3.0F;
    this.gFn = paramInt2;
    paramContext = new TextPaint();
    paramContext.setAntiAlias(true);
    paramContext.setColor(this.FY);
    paramContext.setTextSize(this.gFm);
    paramSpannableString = paramContext.getFontMetrics();
    this.WE = ((int)Math.ceil(paramSpannableString.descent - paramSpannableString.top) + 2);
    this.dOj = new StaticLayout(this.gFi, paramContext, (int)Layout.getDesiredWidth(this.gFi, 0, this.gFi.length(), paramContext) + 1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.Ww = this.dOj.getWidth();
  }
  
  public final boolean a(d paramd)
  {
    if (paramd.getWidth() + paramd.getCurrX() > gFg) {}
    do
    {
      do
      {
        return true;
        if (this.gFl < 0) {
          this.gFl = b.y(this.mContext, 20);
        }
        if (paramd.akX() < this.gFo) {
          break;
        }
      } while ((paramd.akX() == this.gFo) && (gFg - (paramd.getCurrX() + paramd.getWidth()) < this.gFl));
      return false;
    } while ((paramd.getCurrX() + paramd.getWidth()) / (paramd.akX() * b.ala()) * this.gFo * b.ala() > gFg - this.gFl * 1.5D);
    return false;
  }
  
  public final float akX()
  {
    return this.gFo;
  }
  
  public final boolean akY()
  {
    return (this.gFj < 0) && (Math.abs(this.gFj) > this.Ww);
  }
  
  public final int akZ()
  {
    return this.gFn;
  }
  
  public final void b(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    if ((i != gFg) || (j != gFh))
    {
      gFg = i;
      gFh = j;
    }
    paramCanvas.save();
    paramCanvas.translate(this.gFj, this.gFk);
    this.dOj.draw(paramCanvas);
    paramCanvas.restore();
    if (!paramBoolean) {
      this.gFj = ((int)(this.gFj - b.ala() * this.gFo));
    }
  }
  
  public final void ca(int paramInt1, int paramInt2)
  {
    this.gFj = paramInt1;
    this.gFk = paramInt2;
  }
  
  public final int getCurrX()
  {
    return this.gFj;
  }
  
  public final int getWidth()
  {
    return this.Ww;
  }
  
  public final boolean lG(int paramInt)
  {
    if (paramInt < this.gFn) {}
    while (paramInt - this.gFn > b.gFq) {
      return false;
    }
    return true;
  }
  
  public final boolean lH(int paramInt)
  {
    return paramInt - this.gFn > b.gFq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a
 * JD-Core Version:    0.7.0.1
 */
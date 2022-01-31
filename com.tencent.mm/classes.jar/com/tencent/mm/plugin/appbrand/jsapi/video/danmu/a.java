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
  private static int iek;
  private static int iel;
  private int GF;
  private int Xj;
  private int Xr;
  private StaticLayout eLR;
  private SpannableString iem;
  private int ien;
  private int ieo;
  private int iep;
  private int ieq;
  private int ier;
  private float ies;
  private Context mContext;
  
  public a(Context paramContext, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126593);
    this.iep = -1;
    this.GF = -1;
    this.mContext = paramContext;
    this.iem = paramSpannableString;
    this.ieq = b.F(this.mContext, b.iet);
    this.GF = paramInt1;
    this.ies = 3.0F;
    this.ier = paramInt2;
    paramContext = new TextPaint();
    paramContext.setAntiAlias(true);
    paramContext.setColor(this.GF);
    paramContext.setTextSize(this.ieq);
    paramSpannableString = paramContext.getFontMetrics();
    this.Xr = ((int)Math.ceil(paramSpannableString.descent - paramSpannableString.top) + 2);
    this.eLR = new StaticLayout(this.iem, paramContext, (int)Layout.getDesiredWidth(this.iem, 0, this.iem.length(), paramContext) + 1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.Xj = this.eLR.getWidth();
    AppMethodBeat.o(126593);
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(126596);
    if (paramd.getWidth() + paramd.getCurrX() > iek)
    {
      AppMethodBeat.o(126596);
      return true;
    }
    if (this.iep < 0) {
      this.iep = b.F(this.mContext, 20);
    }
    if (paramd.aFI() >= this.ies)
    {
      if ((paramd.aFI() == this.ies) && (iek - (paramd.getCurrX() + paramd.getWidth()) < this.iep))
      {
        AppMethodBeat.o(126596);
        return true;
      }
      AppMethodBeat.o(126596);
      return false;
    }
    if ((paramd.getCurrX() + paramd.getWidth()) / (paramd.aFI() * b.aFL()) * this.ies * b.aFL() > iek - this.iep * 1.5D)
    {
      AppMethodBeat.o(126596);
      return true;
    }
    AppMethodBeat.o(126596);
    return false;
  }
  
  public final float aFI()
  {
    return this.ies;
  }
  
  public final boolean aFJ()
  {
    AppMethodBeat.i(126595);
    if ((this.ien < 0) && (Math.abs(this.ien) > this.Xj))
    {
      AppMethodBeat.o(126595);
      return true;
    }
    AppMethodBeat.o(126595);
    return false;
  }
  
  public final int aFK()
  {
    return this.ier;
  }
  
  public final void b(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(126594);
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    if ((i != iek) || (j != iel))
    {
      iek = i;
      iel = j;
    }
    paramCanvas.save();
    paramCanvas.translate(this.ien, this.ieo);
    this.eLR.draw(paramCanvas);
    paramCanvas.restore();
    if (!paramBoolean) {
      this.ien = ((int)(this.ien - b.aFL() * this.ies));
    }
    AppMethodBeat.o(126594);
  }
  
  public final void dl(int paramInt1, int paramInt2)
  {
    this.ien = paramInt1;
    this.ieo = paramInt2;
  }
  
  public final int getCurrX()
  {
    return this.ien;
  }
  
  public final int getWidth()
  {
    return this.Xj;
  }
  
  public final boolean oo(int paramInt)
  {
    if (paramInt < this.ier) {}
    while (paramInt - this.ier > b.ieu) {
      return false;
    }
    return true;
  }
  
  public final boolean op(int paramInt)
  {
    return paramInt - this.ier > b.ieu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a
 * JD-Core Version:    0.7.0.1
 */
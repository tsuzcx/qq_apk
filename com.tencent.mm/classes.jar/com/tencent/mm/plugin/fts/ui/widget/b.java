package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends Drawable
{
  private Context context;
  int currentState;
  private int nbA;
  private int nbB;
  private int nbC;
  private int nbD;
  private int nbE;
  private int nbF;
  private int nbG;
  boolean nbH;
  private int nbI;
  int nbJ;
  private int nbK;
  private Drawable nby;
  private Drawable nbz;
  private Paint paint;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(62159);
    this.nbA = 0;
    this.nbB = 0;
    this.paint = new Paint(1);
    this.nbG = 0;
    this.nbH = false;
    this.currentState = 2;
    this.nbJ = 0;
    this.nbK = 0;
    this.context = paramContext;
    this.nbA = a.m(paramContext, 2131690701);
    this.nbB = a.m(paramContext, 2131690709);
    this.nby = paramContext.getResources().getDrawable(2130838924);
    this.nbz = paramContext.getResources().getDrawable(2130838925);
    this.nbG = a.fromDPToPix(paramContext, 24);
    this.nbC = a.m(paramContext, 2131690626);
    this.nbF = a.m(paramContext, 2131690627);
    this.nbI = a.fromDPToPix(paramContext, 47);
    this.nbD = a.fromDPToPix(paramContext, 47);
    this.nbE = a.fromDPToPix(paramContext, 60);
    this.nbK = 4;
    ab.d("MicroMsg.FTSVoiceInputDrawable", "waveStep %s", new Object[] { Integer.valueOf(this.nbK) });
    AppMethodBeat.o(62159);
  }
  
  private void d(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(62162);
    if ((this.nby == null) || (j(paramCanvas)))
    {
      AppMethodBeat.o(62162);
      return;
    }
    Drawable localDrawable;
    if (paramBoolean) {
      localDrawable = this.nbz;
    }
    for (int i = this.nbA;; i = this.nbB)
    {
      int j = paramCanvas.getWidth() / 2;
      int k = paramCanvas.getHeight() / 2;
      int m = localDrawable.getIntrinsicWidth() / 2;
      int n = localDrawable.getIntrinsicHeight() / 2;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(i);
      paramCanvas.drawCircle(j, k, this.nbG, this.paint);
      localDrawable.setBounds(j - m, k - n, j + m, k + n);
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(62162);
      return;
      localDrawable = this.nby;
    }
  }
  
  private static boolean j(Canvas paramCanvas)
  {
    AppMethodBeat.i(62164);
    if ((paramCanvas == null) || (paramCanvas.getWidth() == 0) || (paramCanvas.getHeight() == 0))
    {
      AppMethodBeat.o(62164);
      return true;
    }
    AppMethodBeat.o(62164);
    return false;
  }
  
  public static boolean wD(int paramInt)
  {
    return paramInt < 10;
  }
  
  public final void bDo()
  {
    AppMethodBeat.i(62160);
    ab.d("MicroMsg.FTSVoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.nbJ = 0;
    invalidateSelf();
    AppMethodBeat.o(62160);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(62161);
    int i;
    int j;
    if (((this.currentState == 6) || (this.currentState == 7)) && (!j(paramCanvas)))
    {
      i = paramCanvas.getWidth() >> 1;
      j = paramCanvas.getHeight() >> 1;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(this.nbC);
      if (this.currentState != 7) {
        break label261;
      }
      if (this.nbH)
      {
        this.nbI -= this.nbK;
        this.nbI = Math.min(Math.max(this.nbD, this.nbI), this.nbE);
        paramCanvas.drawCircle(i, j, this.nbI, this.paint);
      }
    }
    else
    {
      label142:
      if ((this.currentState != 6) && (this.currentState != 7)) {
        break label281;
      }
      d(paramCanvas, true);
    }
    for (;;)
    {
      if (((this.currentState == 6) || (this.currentState == 7)) && (!j(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.nbF);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.nbG, this.paint);
      }
      AppMethodBeat.o(62161);
      return;
      this.nbI += this.nbK;
      break;
      label261:
      paramCanvas.drawCircle(i, j, this.nbD, this.paint);
      break label142;
      label281:
      d(paramCanvas, false);
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return this.nbG * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(62163);
    if (this.context == null)
    {
      AppMethodBeat.o(62163);
      return 0;
    }
    int i = a.gw(this.context);
    AppMethodBeat.o(62163);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */
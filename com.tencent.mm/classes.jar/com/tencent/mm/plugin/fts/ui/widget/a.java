package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends Drawable
{
  private Context context;
  int currentState;
  private Paint paint;
  private Drawable rxA;
  private int rxB;
  private int rxC;
  private int rxD;
  private int rxE;
  private int rxF;
  private int rxG;
  private int rxH;
  boolean rxI;
  private int rxJ;
  int rxK;
  private int rxL;
  private Drawable rxz;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(112284);
    this.rxB = 0;
    this.rxC = 0;
    this.paint = new Paint(1);
    this.rxH = 0;
    this.rxI = false;
    this.currentState = 2;
    this.rxK = 0;
    this.rxL = 0;
    this.context = paramContext;
    this.rxB = com.tencent.mm.cd.a.n(paramContext, 2131101171);
    this.rxC = com.tencent.mm.cd.a.n(paramContext, 2131101179);
    this.rxz = paramContext.getResources().getDrawable(2131232462);
    this.rxA = paramContext.getResources().getDrawable(2131232463);
    this.rxH = com.tencent.mm.cd.a.fromDPToPix(paramContext, 24);
    this.rxD = com.tencent.mm.cd.a.n(paramContext, 2131101078);
    this.rxG = com.tencent.mm.cd.a.n(paramContext, 2131101079);
    this.rxJ = com.tencent.mm.cd.a.fromDPToPix(paramContext, 47);
    this.rxE = com.tencent.mm.cd.a.fromDPToPix(paramContext, 47);
    this.rxF = com.tencent.mm.cd.a.fromDPToPix(paramContext, 60);
    this.rxL = 4;
    ad.d("MicroMsg.FTSVoiceInputDrawable", "waveStep %s", new Object[] { Integer.valueOf(this.rxL) });
    AppMethodBeat.o(112284);
  }
  
  public static boolean DO(int paramInt)
  {
    return paramInt < 10;
  }
  
  private void d(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(112287);
    if ((this.rxz == null) || (l(paramCanvas)))
    {
      AppMethodBeat.o(112287);
      return;
    }
    Drawable localDrawable;
    if (paramBoolean) {
      localDrawable = this.rxA;
    }
    for (int i = this.rxB;; i = this.rxC)
    {
      int j = paramCanvas.getWidth() / 2;
      int k = paramCanvas.getHeight() / 2;
      int m = localDrawable.getIntrinsicWidth() / 2;
      int n = localDrawable.getIntrinsicHeight() / 2;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(i);
      paramCanvas.drawCircle(j, k, this.rxH, this.paint);
      localDrawable.setBounds(j - m, k - n, j + m, k + n);
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(112287);
      return;
      localDrawable = this.rxz;
    }
  }
  
  private static boolean l(Canvas paramCanvas)
  {
    AppMethodBeat.i(112289);
    if ((paramCanvas == null) || (paramCanvas.getWidth() == 0) || (paramCanvas.getHeight() == 0))
    {
      AppMethodBeat.o(112289);
      return true;
    }
    AppMethodBeat.o(112289);
    return false;
  }
  
  public final void cyr()
  {
    AppMethodBeat.i(112285);
    ad.d("MicroMsg.FTSVoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.rxK = 0;
    invalidateSelf();
    AppMethodBeat.o(112285);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(112286);
    int i;
    int j;
    if (((this.currentState == 6) || (this.currentState == 7)) && (!l(paramCanvas)))
    {
      i = paramCanvas.getWidth() >> 1;
      j = paramCanvas.getHeight() >> 1;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(this.rxD);
      if (this.currentState != 7) {
        break label261;
      }
      if (this.rxI)
      {
        this.rxJ -= this.rxL;
        this.rxJ = Math.min(Math.max(this.rxE, this.rxJ), this.rxF);
        paramCanvas.drawCircle(i, j, this.rxJ, this.paint);
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
      if (((this.currentState == 6) || (this.currentState == 7)) && (!l(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.rxG);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.rxH, this.paint);
      }
      AppMethodBeat.o(112286);
      return;
      this.rxJ += this.rxL;
      break;
      label261:
      paramCanvas.drawCircle(i, j, this.rxE, this.paint);
      break label142;
      label281:
      d(paramCanvas, false);
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return this.rxH * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(112288);
    if (this.context == null)
    {
      AppMethodBeat.o(112288);
      return 0;
    }
    int i = com.tencent.mm.cd.a.hV(this.context);
    AppMethodBeat.o(112288);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */
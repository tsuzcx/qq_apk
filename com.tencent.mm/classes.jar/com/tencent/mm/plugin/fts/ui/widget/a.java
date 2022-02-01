package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends Drawable
{
  private Context context;
  int currentState;
  private Paint paint;
  boolean sGA;
  private int sGB;
  int sGC;
  private int sGD;
  private Drawable sGr;
  private Drawable sGs;
  private int sGt;
  private int sGu;
  private int sGv;
  private int sGw;
  private int sGx;
  private int sGy;
  private int sGz;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(112284);
    this.sGt = 0;
    this.sGu = 0;
    this.paint = new Paint(1);
    this.sGz = 0;
    this.sGA = false;
    this.currentState = 2;
    this.sGC = 0;
    this.sGD = 0;
    this.context = paramContext;
    this.sGt = com.tencent.mm.cc.a.n(paramContext, 2131101171);
    this.sGu = com.tencent.mm.cc.a.n(paramContext, 2131101179);
    this.sGr = paramContext.getResources().getDrawable(2131232462);
    this.sGs = paramContext.getResources().getDrawable(2131232463);
    this.sGz = com.tencent.mm.cc.a.fromDPToPix(paramContext, 24);
    this.sGv = com.tencent.mm.cc.a.n(paramContext, 2131101078);
    this.sGy = com.tencent.mm.cc.a.n(paramContext, 2131101079);
    this.sGB = com.tencent.mm.cc.a.fromDPToPix(paramContext, 47);
    this.sGw = com.tencent.mm.cc.a.fromDPToPix(paramContext, 47);
    this.sGx = com.tencent.mm.cc.a.fromDPToPix(paramContext, 60);
    this.sGD = 4;
    ac.d("MicroMsg.FTSVoiceInputDrawable", "waveStep %s", new Object[] { Integer.valueOf(this.sGD) });
    AppMethodBeat.o(112284);
  }
  
  public static boolean FK(int paramInt)
  {
    return paramInt < 10;
  }
  
  private void d(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(112287);
    if ((this.sGr == null) || (l(paramCanvas)))
    {
      AppMethodBeat.o(112287);
      return;
    }
    Drawable localDrawable;
    if (paramBoolean) {
      localDrawable = this.sGs;
    }
    for (int i = this.sGt;; i = this.sGu)
    {
      int j = paramCanvas.getWidth() / 2;
      int k = paramCanvas.getHeight() / 2;
      int m = localDrawable.getIntrinsicWidth() / 2;
      int n = localDrawable.getIntrinsicHeight() / 2;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(i);
      paramCanvas.drawCircle(j, k, this.sGz, this.paint);
      localDrawable.setBounds(j - m, k - n, j + m, k + n);
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(112287);
      return;
      localDrawable = this.sGr;
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
  
  public final void cLD()
  {
    AppMethodBeat.i(112285);
    ac.d("MicroMsg.FTSVoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.sGC = 0;
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
      this.paint.setColor(this.sGv);
      if (this.currentState != 7) {
        break label261;
      }
      if (this.sGA)
      {
        this.sGB -= this.sGD;
        this.sGB = Math.min(Math.max(this.sGw, this.sGB), this.sGx);
        paramCanvas.drawCircle(i, j, this.sGB, this.paint);
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
        this.paint.setColor(this.sGy);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.sGz, this.paint);
      }
      AppMethodBeat.o(112286);
      return;
      this.sGB += this.sGD;
      break;
      label261:
      paramCanvas.drawCircle(i, j, this.sGw, this.paint);
      break label142;
      label281:
      d(paramCanvas, false);
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return this.sGz * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(112288);
    if (this.context == null)
    {
      AppMethodBeat.o(112288);
      return 0;
    }
    int i = com.tencent.mm.cc.a.ig(this.context);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends Drawable
{
  private Context context;
  int currentState;
  private Paint paint;
  private Drawable tOb;
  private Drawable tOc;
  private int tOd;
  private int tOe;
  private int tOf;
  private int tOg;
  private int tOh;
  private int tOi;
  private int tOj;
  boolean tOk;
  private int tOl;
  int tOm;
  private int tOn;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(112284);
    this.tOd = 0;
    this.tOe = 0;
    this.paint = new Paint(1);
    this.tOj = 0;
    this.tOk = false;
    this.currentState = 2;
    this.tOm = 0;
    this.tOn = 0;
    this.context = paramContext;
    this.tOd = com.tencent.mm.cb.a.n(paramContext, 2131101171);
    this.tOe = com.tencent.mm.cb.a.n(paramContext, 2131101179);
    this.tOb = paramContext.getResources().getDrawable(2131232462);
    this.tOc = paramContext.getResources().getDrawable(2131232463);
    this.tOj = com.tencent.mm.cb.a.fromDPToPix(paramContext, 24);
    this.tOf = com.tencent.mm.cb.a.n(paramContext, 2131101078);
    this.tOi = com.tencent.mm.cb.a.n(paramContext, 2131101079);
    this.tOl = com.tencent.mm.cb.a.fromDPToPix(paramContext, 47);
    this.tOg = com.tencent.mm.cb.a.fromDPToPix(paramContext, 47);
    this.tOh = com.tencent.mm.cb.a.fromDPToPix(paramContext, 60);
    this.tOn = 4;
    ae.d("MicroMsg.FTSVoiceInputDrawable", "waveStep %s", new Object[] { Integer.valueOf(this.tOn) });
    AppMethodBeat.o(112284);
  }
  
  public static boolean Hw(int paramInt)
  {
    return paramInt < 10;
  }
  
  private void d(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(112287);
    if ((this.tOb == null) || (l(paramCanvas)))
    {
      AppMethodBeat.o(112287);
      return;
    }
    Drawable localDrawable;
    if (paramBoolean) {
      localDrawable = this.tOc;
    }
    for (int i = this.tOd;; i = this.tOe)
    {
      int j = paramCanvas.getWidth() / 2;
      int k = paramCanvas.getHeight() / 2;
      int m = localDrawable.getIntrinsicWidth() / 2;
      int n = localDrawable.getIntrinsicHeight() / 2;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(i);
      paramCanvas.drawCircle(j, k, this.tOj, this.paint);
      localDrawable.setBounds(j - m, k - n, j + m, k + n);
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(112287);
      return;
      localDrawable = this.tOb;
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
  
  public final void cWB()
  {
    AppMethodBeat.i(112285);
    ae.d("MicroMsg.FTSVoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.tOm = 0;
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
      this.paint.setColor(this.tOf);
      if (this.currentState != 7) {
        break label261;
      }
      if (this.tOk)
      {
        this.tOl -= this.tOn;
        this.tOl = Math.min(Math.max(this.tOg, this.tOl), this.tOh);
        paramCanvas.drawCircle(i, j, this.tOl, this.paint);
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
        this.paint.setColor(this.tOi);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.tOj, this.paint);
      }
      AppMethodBeat.o(112286);
      return;
      this.tOl += this.tOn;
      break;
      label261:
      paramCanvas.drawCircle(i, j, this.tOg, this.paint);
      break label142;
      label281:
      d(paramCanvas, false);
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return this.tOj * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(112288);
    if (this.context == null)
    {
      AppMethodBeat.o(112288);
      return 0;
    }
    int i = com.tencent.mm.cb.a.iu(this.context);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */
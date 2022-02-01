package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends Drawable
{
  private Context context;
  int currentState;
  private Paint paint;
  private Drawable xfa;
  private Drawable xfb;
  private int xfc;
  private int xfd;
  private int xfe;
  private int xff;
  private int xfg;
  private int xfh;
  private int xfi;
  boolean xfj;
  private int xfk;
  int xfl;
  private int xfm;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(112284);
    this.xfc = 0;
    this.xfd = 0;
    this.paint = new Paint(1);
    this.xfi = 0;
    this.xfj = false;
    this.currentState = 2;
    this.xfl = 0;
    this.xfm = 0;
    this.context = paramContext;
    this.xfc = com.tencent.mm.cb.a.n(paramContext, 2131101414);
    this.xfd = com.tencent.mm.cb.a.n(paramContext, 2131101424);
    this.xfa = paramContext.getResources().getDrawable(2131232844);
    this.xfb = paramContext.getResources().getDrawable(2131232845);
    this.xfi = com.tencent.mm.cb.a.fromDPToPix(paramContext, 24);
    this.xfe = com.tencent.mm.cb.a.n(paramContext, 2131101321);
    this.xfh = com.tencent.mm.cb.a.n(paramContext, 2131101322);
    this.xfk = com.tencent.mm.cb.a.fromDPToPix(paramContext, 47);
    this.xff = com.tencent.mm.cb.a.fromDPToPix(paramContext, 47);
    this.xfg = com.tencent.mm.cb.a.fromDPToPix(paramContext, 60);
    this.xfm = 4;
    Log.d("MicroMsg.FTSVoiceInputDrawable", "waveStep %s", new Object[] { Integer.valueOf(this.xfm) });
    AppMethodBeat.o(112284);
  }
  
  public static boolean Nw(int paramInt)
  {
    return paramInt < 10;
  }
  
  private void d(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(112287);
    if ((this.xfa == null) || (s(paramCanvas)))
    {
      AppMethodBeat.o(112287);
      return;
    }
    Drawable localDrawable;
    if (paramBoolean) {
      localDrawable = this.xfb;
    }
    for (int i = this.xfc;; i = this.xfd)
    {
      int j = paramCanvas.getWidth() / 2;
      int k = paramCanvas.getHeight() / 2;
      int m = localDrawable.getIntrinsicWidth() / 2;
      int n = localDrawable.getIntrinsicHeight() / 2;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(i);
      paramCanvas.drawCircle(j, k, this.xfi, this.paint);
      localDrawable.setBounds(j - m, k - n, j + m, k + n);
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(112287);
      return;
      localDrawable = this.xfa;
    }
  }
  
  private static boolean s(Canvas paramCanvas)
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
  
  public final void dPL()
  {
    AppMethodBeat.i(112285);
    Log.d("MicroMsg.FTSVoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.xfl = 0;
    invalidateSelf();
    AppMethodBeat.o(112285);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(112286);
    int i;
    int j;
    if (((this.currentState == 6) || (this.currentState == 7)) && (!s(paramCanvas)))
    {
      i = paramCanvas.getWidth() >> 1;
      j = paramCanvas.getHeight() >> 1;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(this.xfe);
      if (this.currentState != 7) {
        break label261;
      }
      if (this.xfj)
      {
        this.xfk -= this.xfm;
        this.xfk = Math.min(Math.max(this.xff, this.xfk), this.xfg);
        paramCanvas.drawCircle(i, j, this.xfk, this.paint);
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
      if (((this.currentState == 6) || (this.currentState == 7)) && (!s(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.xfh);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.xfi, this.paint);
      }
      AppMethodBeat.o(112286);
      return;
      this.xfk += this.xfm;
      break;
      label261:
      paramCanvas.drawCircle(i, j, this.xff, this.paint);
      break label142;
      label281:
      d(paramCanvas, false);
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return this.xfi * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(112288);
    if (this.context == null)
    {
      AppMethodBeat.o(112288);
      return 0;
    }
    int i = com.tencent.mm.cb.a.jn(this.context);
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
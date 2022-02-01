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
  private Drawable tDk;
  private Drawable tDl;
  private int tDm;
  private int tDn;
  private int tDo;
  private int tDp;
  private int tDq;
  private int tDr;
  private int tDs;
  boolean tDt;
  private int tDu;
  int tDv;
  private int tDw;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(112284);
    this.tDm = 0;
    this.tDn = 0;
    this.paint = new Paint(1);
    this.tDs = 0;
    this.tDt = false;
    this.currentState = 2;
    this.tDv = 0;
    this.tDw = 0;
    this.context = paramContext;
    this.tDm = com.tencent.mm.cc.a.n(paramContext, 2131101171);
    this.tDn = com.tencent.mm.cc.a.n(paramContext, 2131101179);
    this.tDk = paramContext.getResources().getDrawable(2131232462);
    this.tDl = paramContext.getResources().getDrawable(2131232463);
    this.tDs = com.tencent.mm.cc.a.fromDPToPix(paramContext, 24);
    this.tDo = com.tencent.mm.cc.a.n(paramContext, 2131101078);
    this.tDr = com.tencent.mm.cc.a.n(paramContext, 2131101079);
    this.tDu = com.tencent.mm.cc.a.fromDPToPix(paramContext, 47);
    this.tDp = com.tencent.mm.cc.a.fromDPToPix(paramContext, 47);
    this.tDq = com.tencent.mm.cc.a.fromDPToPix(paramContext, 60);
    this.tDw = 4;
    ad.d("MicroMsg.FTSVoiceInputDrawable", "waveStep %s", new Object[] { Integer.valueOf(this.tDw) });
    AppMethodBeat.o(112284);
  }
  
  public static boolean GZ(int paramInt)
  {
    return paramInt < 10;
  }
  
  private void d(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(112287);
    if ((this.tDk == null) || (l(paramCanvas)))
    {
      AppMethodBeat.o(112287);
      return;
    }
    Drawable localDrawable;
    if (paramBoolean) {
      localDrawable = this.tDl;
    }
    for (int i = this.tDm;; i = this.tDn)
    {
      int j = paramCanvas.getWidth() / 2;
      int k = paramCanvas.getHeight() / 2;
      int m = localDrawable.getIntrinsicWidth() / 2;
      int n = localDrawable.getIntrinsicHeight() / 2;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(i);
      paramCanvas.drawCircle(j, k, this.tDs, this.paint);
      localDrawable.setBounds(j - m, k - n, j + m, k + n);
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(112287);
      return;
      localDrawable = this.tDk;
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
  
  public final void cTW()
  {
    AppMethodBeat.i(112285);
    ad.d("MicroMsg.FTSVoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.tDv = 0;
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
      this.paint.setColor(this.tDo);
      if (this.currentState != 7) {
        break label261;
      }
      if (this.tDt)
      {
        this.tDu -= this.tDw;
        this.tDu = Math.min(Math.max(this.tDp, this.tDu), this.tDq);
        paramCanvas.drawCircle(i, j, this.tDu, this.paint);
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
        this.paint.setColor(this.tDr);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.tDs, this.paint);
      }
      AppMethodBeat.o(112286);
      return;
      this.tDu += this.tDw;
      break;
      label261:
      paramCanvas.drawCircle(i, j, this.tDp, this.paint);
      break label142;
      label281:
      d(paramCanvas, false);
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return this.tDs * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(112288);
    if (this.context == null)
    {
      AppMethodBeat.o(112288);
      return 0;
    }
    int i = com.tencent.mm.cc.a.ip(this.context);
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
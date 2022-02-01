package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.o.a;
import com.tencent.mm.plugin.fts.ui.o.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends Drawable
{
  private Drawable BRl;
  private Drawable BRm;
  private int BRn;
  private int BRo;
  private int BRp;
  private int BRq;
  private int BRr;
  private int BRs;
  private int BRt;
  boolean BRu;
  private int BRv;
  int BRw;
  private int BRx;
  private Context context;
  int currentState;
  private Paint paint;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(112284);
    this.BRn = 0;
    this.BRo = 0;
    this.paint = new Paint(1);
    this.BRt = 0;
    this.BRu = false;
    this.currentState = 2;
    this.BRw = 0;
    this.BRx = 0;
    this.context = paramContext;
    this.BRn = com.tencent.mm.ci.a.w(paramContext, o.a.wechat_green);
    this.BRo = com.tencent.mm.ci.a.w(paramContext, o.a.white);
    this.BRl = paramContext.getResources().getDrawable(o.c.fts_microphone_normal);
    this.BRm = paramContext.getResources().getDrawable(o.c.fts_microphone_press);
    this.BRt = com.tencent.mm.ci.a.fromDPToPix(paramContext, 24);
    this.BRp = com.tencent.mm.ci.a.w(paramContext, o.a.voice_input_btn_outer_color);
    this.BRs = com.tencent.mm.ci.a.w(paramContext, o.a.voice_input_btn_pressed_mask);
    this.BRv = com.tencent.mm.ci.a.fromDPToPix(paramContext, 47);
    this.BRq = com.tencent.mm.ci.a.fromDPToPix(paramContext, 47);
    this.BRr = com.tencent.mm.ci.a.fromDPToPix(paramContext, 60);
    this.BRx = 4;
    Log.d("MicroMsg.FTSVoiceInputDrawable", "waveStep %s", new Object[] { Integer.valueOf(this.BRx) });
    AppMethodBeat.o(112284);
  }
  
  public static boolean SK(int paramInt)
  {
    return paramInt < 10;
  }
  
  private void d(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(112287);
    if ((this.BRl == null) || (u(paramCanvas)))
    {
      AppMethodBeat.o(112287);
      return;
    }
    Drawable localDrawable;
    if (paramBoolean) {
      localDrawable = this.BRm;
    }
    for (int i = this.BRn;; i = this.BRo)
    {
      int j = paramCanvas.getWidth() / 2;
      int k = paramCanvas.getHeight() / 2;
      int m = localDrawable.getIntrinsicWidth() / 2;
      int n = localDrawable.getIntrinsicHeight() / 2;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(i);
      paramCanvas.drawCircle(j, k, this.BRt, this.paint);
      localDrawable.setBounds(j - m, k - n, j + m, k + n);
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(112287);
      return;
      localDrawable = this.BRl;
    }
  }
  
  private static boolean u(Canvas paramCanvas)
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
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(112286);
    int i;
    int j;
    if (((this.currentState == 6) || (this.currentState == 7)) && (!u(paramCanvas)))
    {
      i = paramCanvas.getWidth() >> 1;
      j = paramCanvas.getHeight() >> 1;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(this.BRp);
      if (this.currentState != 7) {
        break label261;
      }
      if (this.BRu)
      {
        this.BRv -= this.BRx;
        this.BRv = Math.min(Math.max(this.BRq, this.BRv), this.BRr);
        paramCanvas.drawCircle(i, j, this.BRv, this.paint);
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
      if (((this.currentState == 6) || (this.currentState == 7)) && (!u(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.BRs);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.BRt, this.paint);
      }
      AppMethodBeat.o(112286);
      return;
      this.BRv += this.BRx;
      break;
      label261:
      paramCanvas.drawCircle(i, j, this.BRq, this.paint);
      break label142;
      label281:
      d(paramCanvas, false);
    }
  }
  
  public final void esk()
  {
    AppMethodBeat.i(112285);
    Log.d("MicroMsg.FTSVoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.BRw = 0;
    invalidateSelf();
    AppMethodBeat.o(112285);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.BRt * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(112288);
    if (this.context == null)
    {
      AppMethodBeat.o(112288);
      return 0;
    }
    int i = com.tencent.mm.ci.a.kr(this.context);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */
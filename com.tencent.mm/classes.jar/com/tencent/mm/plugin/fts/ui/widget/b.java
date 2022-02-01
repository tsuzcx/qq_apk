package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.fts.ui.p.a;
import com.tencent.mm.plugin.fts.ui.p.c;
import com.tencent.mm.sdk.platformtools.Log;

public class b
  extends Drawable
{
  int Giy;
  Drawable HCU;
  private Drawable HCV;
  private int HCW;
  private int HCX;
  private int HCY;
  private int HCZ;
  private int HDa;
  private int HDb;
  boolean HDc;
  private int HDd;
  int HDe;
  private int HDf;
  private Context context;
  int currentState;
  private Paint paint;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(112284);
    this.HCW = 0;
    this.Giy = 0;
    this.paint = new Paint(1);
    this.HDb = 0;
    this.HDc = false;
    this.currentState = 2;
    this.HDe = 0;
    this.HDf = 0;
    this.context = paramContext;
    this.HCW = a.w(paramContext, p.a.wechat_green);
    this.Giy = a.w(paramContext, p.a.white);
    this.HCU = paramContext.getResources().getDrawable(p.c.fts_microphone_normal);
    this.HCV = paramContext.getResources().getDrawable(p.c.fts_microphone_press);
    this.HDb = a.fromDPToPix(paramContext, 24);
    this.HCX = a.w(paramContext, p.a.voice_input_btn_outer_color);
    this.HDa = a.w(paramContext, p.a.voice_input_btn_pressed_mask);
    this.HDd = a.fromDPToPix(paramContext, 47);
    this.HCY = a.fromDPToPix(paramContext, 47);
    this.HCZ = a.fromDPToPix(paramContext, 60);
    this.HDf = 4;
    Log.d("MicroMsg.FTSVoiceInputDrawable", "waveStep %s", new Object[] { Integer.valueOf(this.HDf) });
    AppMethodBeat.o(112284);
  }
  
  public static boolean Wr(int paramInt)
  {
    return paramInt < 10;
  }
  
  private void e(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(112287);
    if ((this.HCU == null) || (p(paramCanvas)))
    {
      AppMethodBeat.o(112287);
      return;
    }
    Drawable localDrawable;
    if (paramBoolean) {
      localDrawable = this.HCV;
    }
    for (int i = this.HCW;; i = this.Giy)
    {
      int j = paramCanvas.getWidth() / 2;
      int k = paramCanvas.getHeight() / 2;
      int m = localDrawable.getIntrinsicWidth() / 2;
      int n = localDrawable.getIntrinsicHeight() / 2;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(i);
      paramCanvas.drawCircle(j, k, this.HDb, this.paint);
      localDrawable.setBounds(j - m, k - n, j + m, k + n);
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(112287);
      return;
      localDrawable = this.HCU;
    }
  }
  
  private static boolean p(Canvas paramCanvas)
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
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(112286);
    int i;
    int j;
    if (((this.currentState == 6) || (this.currentState == 7)) && (!p(paramCanvas)))
    {
      i = paramCanvas.getWidth() >> 1;
      j = paramCanvas.getHeight() >> 1;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(this.HCX);
      if (this.currentState != 7) {
        break label261;
      }
      if (this.HDc)
      {
        this.HDd -= this.HDf;
        this.HDd = Math.min(Math.max(this.HCY, this.HDd), this.HCZ);
        paramCanvas.drawCircle(i, j, this.HDd, this.paint);
      }
    }
    else
    {
      label142:
      if ((this.currentState != 6) && (this.currentState != 7)) {
        break label281;
      }
      e(paramCanvas, true);
    }
    for (;;)
    {
      if (((this.currentState == 6) || (this.currentState == 7)) && (!p(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.HDa);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.HDb, this.paint);
      }
      AppMethodBeat.o(112286);
      return;
      this.HDd += this.HDf;
      break;
      label261:
      paramCanvas.drawCircle(i, j, this.HCY, this.paint);
      break label142;
      label281:
      e(paramCanvas, false);
    }
  }
  
  public final void fzj()
  {
    AppMethodBeat.i(112285);
    Log.d("MicroMsg.FTSVoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.HDe = 0;
    invalidateSelf();
    AppMethodBeat.o(112285);
  }
  
  public int getIntrinsicHeight()
  {
    return this.HDb * 2;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(112288);
    if (this.context == null)
    {
      AppMethodBeat.o(112288);
      return 0;
    }
    int i = a.ms(this.context);
    AppMethodBeat.o(112288);
    return i;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.danmaku.e;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.m;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  private static final Rect gQM;
  private static final TextPaint gQN;
  private static final Map<Float, Float> gQO;
  private static final Map<Float, Float> gQP;
  private static final Map<Float, Float> gQQ;
  public static Paint gQR;
  public static Paint gQS;
  private static int gQT;
  
  static
  {
    AppMethodBeat.i(241766);
    gQM = new Rect();
    gQN = new TextPaint();
    gQO = new HashMap();
    gQP = new HashMap();
    gQQ = new HashMap();
    Paint localPaint = new Paint();
    gQR = localPaint;
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    AppMethodBeat.o(241766);
  }
  
  public static float a(float paramFloat, String paramString)
  {
    AppMethodBeat.i(241765);
    gQN.setTextSize(paramFloat);
    paramFloat = gQN.measureText(paramString);
    AppMethodBeat.o(241765);
    return paramFloat;
  }
  
  public static float a(m paramm)
  {
    AppMethodBeat.i(241763);
    float f1 = ap(paramm.gPN);
    float f2 = com.tencent.mm.danmaku.c.a.asO().gPI * 2;
    float f3 = paramm.gPO;
    float f4 = paramm.gPP;
    AppMethodBeat.o(241763);
    return f1 + f2 + f3 * 2.0F + f4 * 2.0F;
  }
  
  public static void a(Canvas paramCanvas, String paramString)
  {
    AppMethodBeat.i(241761);
    if (gQS == null)
    {
      Object localObject = new Paint();
      gQS = (Paint)localObject;
      ((Paint)localObject).setColor(-256);
      localObject = com.tencent.mm.danmaku.f.a.atr().getResources().getDisplayMetrics();
      gQS.setTextSize(((DisplayMetrics)localObject).density * 12.5F);
      localObject = gQS.getFontMetrics();
      gQT = (int)Math.ceil(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent);
    }
    paramCanvas.drawText(paramString, 10.0F, paramCanvas.getHeight() - gQT, gQS);
    AppMethodBeat.o(241761);
  }
  
  public static float ap(float paramFloat)
  {
    AppMethodBeat.i(241764);
    gQN.setTextSize(paramFloat);
    Float localFloat = (Float)gQO.get(Float.valueOf(paramFloat));
    Object localObject = localFloat;
    if (localFloat == null)
    {
      localObject = gQN.getFontMetrics();
      float f1 = ((Paint.FontMetrics)localObject).descent;
      float f2 = ((Paint.FontMetrics)localObject).ascent;
      localObject = Float.valueOf(((Paint.FontMetrics)localObject).leading + (f1 - f2));
      gQO.put(Float.valueOf(paramFloat), localObject);
    }
    paramFloat = ((Float)localObject).floatValue();
    AppMethodBeat.o(241764);
    return paramFloat;
  }
  
  public static void n(Canvas paramCanvas)
  {
    AppMethodBeat.i(241762);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    AppMethodBeat.o(241762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.danmaku.e.d
 * JD-Core Version:    0.7.0.1
 */
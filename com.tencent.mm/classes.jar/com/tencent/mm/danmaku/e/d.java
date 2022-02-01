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
  private static final Rect jBf;
  private static final TextPaint jBg;
  private static final Map<Float, Float> jBh;
  private static final Map<Float, Float> jBi;
  private static final Map<Float, Float> jBj;
  public static Paint jBk;
  public static Paint jBl;
  private static int jBm;
  
  static
  {
    AppMethodBeat.i(278125);
    jBf = new Rect();
    jBg = new TextPaint();
    jBh = new HashMap();
    jBi = new HashMap();
    jBj = new HashMap();
    Paint localPaint = new Paint();
    jBk = localPaint;
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    AppMethodBeat.o(278125);
  }
  
  public static float a(float paramFloat, String paramString)
  {
    AppMethodBeat.i(278124);
    jBg.setTextSize(paramFloat);
    paramFloat = jBg.measureText(paramString);
    AppMethodBeat.o(278124);
    return paramFloat;
  }
  
  public static float a(m paramm)
  {
    AppMethodBeat.i(278122);
    float f1 = ao(paramm.jAg);
    float f2 = com.tencent.mm.danmaku.c.a.azC().jAb * 2;
    float f3 = paramm.jAh;
    float f4 = paramm.jAi;
    AppMethodBeat.o(278122);
    return f1 + f2 + f3 * 2.0F + f4 * 2.0F;
  }
  
  public static void a(Canvas paramCanvas, String paramString)
  {
    AppMethodBeat.i(278120);
    if (jBl == null)
    {
      Object localObject = new Paint();
      jBl = (Paint)localObject;
      ((Paint)localObject).setColor(-256);
      localObject = com.tencent.mm.danmaku.f.a.aAh().getResources().getDisplayMetrics();
      jBl.setTextSize(((DisplayMetrics)localObject).density * 12.5F);
      localObject = jBl.getFontMetrics();
      jBm = (int)Math.ceil(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent);
    }
    paramCanvas.drawText(paramString, 10.0F, paramCanvas.getHeight() - jBm, jBl);
    AppMethodBeat.o(278120);
  }
  
  public static float ao(float paramFloat)
  {
    AppMethodBeat.i(278123);
    jBg.setTextSize(paramFloat);
    Float localFloat = (Float)jBh.get(Float.valueOf(paramFloat));
    Object localObject = localFloat;
    if (localFloat == null)
    {
      localObject = jBg.getFontMetrics();
      float f1 = ((Paint.FontMetrics)localObject).descent;
      float f2 = ((Paint.FontMetrics)localObject).ascent;
      localObject = Float.valueOf(((Paint.FontMetrics)localObject).leading + (f1 - f2));
      jBh.put(Float.valueOf(paramFloat), localObject);
    }
    paramFloat = ((Float)localObject).floatValue();
    AppMethodBeat.o(278123);
    return paramFloat;
  }
  
  public static void p(Canvas paramCanvas)
  {
    AppMethodBeat.i(278121);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    AppMethodBeat.o(278121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.e.d
 * JD-Core Version:    0.7.0.1
 */
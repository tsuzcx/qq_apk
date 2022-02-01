package com.robinhood.ticker;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class f
{
  float cgK;
  private final Paint cgU;
  private final Map<Character, Float> cgV;
  float cgW;
  TickerView.a cgX;
  
  f(Paint paramPaint)
  {
    AppMethodBeat.i(39856);
    this.cgV = new HashMap(256);
    this.cgX = TickerView.a.chj;
    this.cgU = paramPaint;
    invalidate();
    AppMethodBeat.o(39856);
  }
  
  final void invalidate()
  {
    AppMethodBeat.i(39857);
    this.cgV.clear();
    Paint.FontMetrics localFontMetrics = this.cgU.getFontMetrics();
    this.cgK = (localFontMetrics.bottom - localFontMetrics.top);
    this.cgW = (-localFontMetrics.top);
    AppMethodBeat.o(39857);
  }
  
  final float r(char paramChar)
  {
    AppMethodBeat.i(39858);
    if (paramChar == 0)
    {
      AppMethodBeat.o(39858);
      return 0.0F;
    }
    Float localFloat = (Float)this.cgV.get(Character.valueOf(paramChar));
    if (localFloat != null)
    {
      f = localFloat.floatValue();
      AppMethodBeat.o(39858);
      return f;
    }
    float f = this.cgU.measureText(Character.toString(paramChar));
    this.cgV.put(Character.valueOf(paramChar), Float.valueOf(f));
    AppMethodBeat.o(39858);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.robinhood.ticker.f
 * JD-Core Version:    0.7.0.1
 */
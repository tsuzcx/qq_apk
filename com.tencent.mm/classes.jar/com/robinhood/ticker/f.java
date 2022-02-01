package com.robinhood.ticker;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class f
{
  float ciL;
  private final Paint ciV;
  private final Map<Character, Float> ciW;
  float ciX;
  TickerView.a ciY;
  
  f(Paint paramPaint)
  {
    AppMethodBeat.i(39856);
    this.ciW = new HashMap(256);
    this.ciY = TickerView.a.cjk;
    this.ciV = paramPaint;
    invalidate();
    AppMethodBeat.o(39856);
  }
  
  final void invalidate()
  {
    AppMethodBeat.i(39857);
    this.ciW.clear();
    Paint.FontMetrics localFontMetrics = this.ciV.getFontMetrics();
    this.ciL = (localFontMetrics.bottom - localFontMetrics.top);
    this.ciX = (-localFontMetrics.top);
    AppMethodBeat.o(39857);
  }
  
  final float w(char paramChar)
  {
    AppMethodBeat.i(39858);
    if (paramChar == 0)
    {
      AppMethodBeat.o(39858);
      return 0.0F;
    }
    Float localFloat = (Float)this.ciW.get(Character.valueOf(paramChar));
    if (localFloat != null)
    {
      f = localFloat.floatValue();
      AppMethodBeat.o(39858);
      return f;
    }
    float f = this.ciV.measureText(Character.toString(paramChar));
    this.ciW.put(Character.valueOf(paramChar), Float.valueOf(f));
    AppMethodBeat.o(39858);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.robinhood.ticker.f
 * JD-Core Version:    0.7.0.1
 */
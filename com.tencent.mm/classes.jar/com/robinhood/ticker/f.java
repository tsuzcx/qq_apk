package com.robinhood.ticker;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class f
{
  float bOh;
  private final Paint bOr;
  private final Map<Character, Float> bOs;
  float bOt;
  TickerView.a bOu;
  
  f(Paint paramPaint)
  {
    AppMethodBeat.i(39856);
    this.bOs = new HashMap(256);
    this.bOu = TickerView.a.bOG;
    this.bOr = paramPaint;
    invalidate();
    AppMethodBeat.o(39856);
  }
  
  final void invalidate()
  {
    AppMethodBeat.i(39857);
    this.bOs.clear();
    Paint.FontMetrics localFontMetrics = this.bOr.getFontMetrics();
    this.bOh = (localFontMetrics.bottom - localFontMetrics.top);
    this.bOt = (-localFontMetrics.top);
    AppMethodBeat.o(39857);
  }
  
  final float p(char paramChar)
  {
    AppMethodBeat.i(39858);
    if (paramChar == 0)
    {
      AppMethodBeat.o(39858);
      return 0.0F;
    }
    Float localFloat = (Float)this.bOs.get(Character.valueOf(paramChar));
    if (localFloat != null)
    {
      f = localFloat.floatValue();
      AppMethodBeat.o(39858);
      return f;
    }
    float f = this.bOr.measureText(Character.toString(paramChar));
    this.bOs.put(Character.valueOf(paramChar), Float.valueOf(f));
    AppMethodBeat.o(39858);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.robinhood.ticker.f
 * JD-Core Version:    0.7.0.1
 */
package com.robinhood.ticker;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class f
{
  float dZk;
  private final Paint dZu;
  private final Map<Character, Float> dZv;
  float dZw;
  TickerView.a dZx;
  
  f(Paint paramPaint)
  {
    AppMethodBeat.i(39856);
    this.dZv = new HashMap(256);
    this.dZx = TickerView.a.dZI;
    this.dZu = paramPaint;
    invalidate();
    AppMethodBeat.o(39856);
  }
  
  final void invalidate()
  {
    AppMethodBeat.i(39857);
    this.dZv.clear();
    Paint.FontMetrics localFontMetrics = this.dZu.getFontMetrics();
    this.dZk = (localFontMetrics.bottom - localFontMetrics.top);
    this.dZw = (-localFontMetrics.top);
    AppMethodBeat.o(39857);
  }
  
  final float n(char paramChar)
  {
    AppMethodBeat.i(39858);
    if (paramChar == 0)
    {
      AppMethodBeat.o(39858);
      return 0.0F;
    }
    Float localFloat = (Float)this.dZv.get(Character.valueOf(paramChar));
    if (localFloat != null)
    {
      f = localFloat.floatValue();
      AppMethodBeat.o(39858);
      return f;
    }
    float f = this.dZu.measureText(Character.toString(paramChar));
    this.dZv.put(Character.valueOf(paramChar), Float.valueOf(f));
    AppMethodBeat.o(39858);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.robinhood.ticker.f
 * JD-Core Version:    0.7.0.1
 */
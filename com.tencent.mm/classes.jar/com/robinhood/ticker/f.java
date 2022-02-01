package com.robinhood.ticker;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class f
{
  float bWc;
  private final Paint bWm;
  private final Map<Character, Float> bWn;
  float bWo;
  TickerView.a bWp;
  
  f(Paint paramPaint)
  {
    AppMethodBeat.i(39856);
    this.bWn = new HashMap(256);
    this.bWp = TickerView.a.bWB;
    this.bWm = paramPaint;
    invalidate();
    AppMethodBeat.o(39856);
  }
  
  final void invalidate()
  {
    AppMethodBeat.i(39857);
    this.bWn.clear();
    Paint.FontMetrics localFontMetrics = this.bWm.getFontMetrics();
    this.bWc = (localFontMetrics.bottom - localFontMetrics.top);
    this.bWo = (-localFontMetrics.top);
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
    Float localFloat = (Float)this.bWn.get(Character.valueOf(paramChar));
    if (localFloat != null)
    {
      f = localFloat.floatValue();
      AppMethodBeat.o(39858);
      return f;
    }
    float f = this.bWm.measureText(Character.toString(paramChar));
    this.bWn.put(Character.valueOf(paramChar), Float.valueOf(f));
    AppMethodBeat.o(39858);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.robinhood.ticker.f
 * JD-Core Version:    0.7.0.1
 */
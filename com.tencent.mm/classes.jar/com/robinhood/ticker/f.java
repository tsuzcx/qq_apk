package com.robinhood.ticker;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class f
{
  float bLP;
  private final Paint bLZ;
  private final Map<Character, Float> bMa;
  float bMb;
  TickerView.a bMc;
  
  f(Paint paramPaint)
  {
    AppMethodBeat.i(39856);
    this.bMa = new HashMap(256);
    this.bMc = TickerView.a.bMo;
    this.bLZ = paramPaint;
    invalidate();
    AppMethodBeat.o(39856);
  }
  
  final void invalidate()
  {
    AppMethodBeat.i(39857);
    this.bMa.clear();
    Paint.FontMetrics localFontMetrics = this.bLZ.getFontMetrics();
    this.bLP = (localFontMetrics.bottom - localFontMetrics.top);
    this.bMb = (-localFontMetrics.top);
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
    Float localFloat = (Float)this.bMa.get(Character.valueOf(paramChar));
    if (localFloat != null)
    {
      f = localFloat.floatValue();
      AppMethodBeat.o(39858);
      return f;
    }
    float f = this.bLZ.measureText(Character.toString(paramChar));
    this.bMa.put(Character.valueOf(paramChar), Float.valueOf(f));
    AppMethodBeat.o(39858);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.robinhood.ticker.f
 * JD-Core Version:    0.7.0.1
 */
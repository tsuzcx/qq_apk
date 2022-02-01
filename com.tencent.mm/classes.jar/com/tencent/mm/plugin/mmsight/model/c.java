package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  long EZe;
  long count;
  long tVg;
  private String tag;
  long value;
  
  public c(String paramString)
  {
    AppMethodBeat.i(89352);
    this.tag = "default";
    this.tVg = Util.currentTicks();
    this.EZe = Util.currentTicks();
    this.value = 0L;
    this.count = 0L;
    this.tag = paramString;
    AppMethodBeat.o(89352);
  }
  
  public final void Ox(long paramLong)
  {
    AppMethodBeat.i(89353);
    if (this.count == 0L) {
      this.tVg = Util.currentTicks();
    }
    this.value += paramLong;
    this.count += 1L;
    this.EZe = Util.currentTicks();
    AppMethodBeat.o(89353);
  }
  
  public final String eTc()
  {
    AppMethodBeat.i(89355);
    if (this.count == 0L)
    {
      AppMethodBeat.o(89355);
      return "";
    }
    double d2 = (this.EZe - this.tVg) / 1000.0D;
    double d1 = d2;
    if (d2 == 0.0D) {
      d1 = 1.0D;
    }
    String str = 1.0D * this.count / d1;
    AppMethodBeat.o(89355);
    return str;
  }
  
  public final String getValue()
  {
    AppMethodBeat.i(89354);
    if (this.count == 0L)
    {
      AppMethodBeat.o(89354);
      return "";
    }
    double d2 = (this.EZe - this.tVg) / 1000.0D;
    double d1 = d2;
    if (d2 == 0.0D) {
      d1 = 1.0D;
    }
    String str = String.format("CounterUtil %s tag %s count %s passed %.3f perValue %.3f/count counttime %.3f/s valuetime %.3f/s st:%s ed:%s diff%s", new Object[] { "", this.tag, Long.valueOf(this.count), Double.valueOf(d1), Double.valueOf(this.value * 1.0D / this.count), Double.valueOf(this.count * 1.0D / d1), Double.valueOf(1.0D * this.value / d1), Long.valueOf(this.tVg), Long.valueOf(this.EZe), Long.valueOf(this.EZe - this.tVg) });
    AppMethodBeat.o(89354);
    return str;
  }
  
  public final void reset()
  {
    this.value = 0L;
    this.count = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.c
 * JD-Core Version:    0.7.0.1
 */
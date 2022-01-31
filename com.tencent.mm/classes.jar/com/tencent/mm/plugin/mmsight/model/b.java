package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  long gfi;
  long kNr;
  long oGN;
  private String tag;
  long value;
  
  public b(String paramString)
  {
    AppMethodBeat.i(76460);
    this.tag = "default";
    this.kNr = bo.yB();
    this.oGN = bo.yB();
    this.value = 0L;
    this.gfi = 0L;
    this.tag = paramString;
    AppMethodBeat.o(76460);
  }
  
  public final String bQI()
  {
    AppMethodBeat.i(76463);
    if (this.gfi == 0L)
    {
      AppMethodBeat.o(76463);
      return "";
    }
    double d2 = (this.oGN - this.kNr) / 1000.0D;
    double d1 = d2;
    if (d2 == 0.0D) {
      d1 = 1.0D;
    }
    String str = 1.0D * this.gfi / d1;
    AppMethodBeat.o(76463);
    return str;
  }
  
  public final String getValue()
  {
    AppMethodBeat.i(76462);
    if (this.gfi == 0L)
    {
      AppMethodBeat.o(76462);
      return "";
    }
    double d2 = (this.oGN - this.kNr) / 1000.0D;
    double d1 = d2;
    if (d2 == 0.0D) {
      d1 = 1.0D;
    }
    String str = String.format("CounterUtil %s tag %s count %s passed %.3f perValue %.3f/count counttime %.3f/s valuetime %.3f/s st:%s ed:%s diff%s", new Object[] { "", this.tag, Long.valueOf(this.gfi), Double.valueOf(d1), Double.valueOf(this.value * 1.0D / this.gfi), Double.valueOf(this.gfi * 1.0D / d1), Double.valueOf(1.0D * this.value / d1), Long.valueOf(this.kNr), Long.valueOf(this.oGN), Long.valueOf(this.oGN - this.kNr) });
    AppMethodBeat.o(76462);
    return str;
  }
  
  public final void kH(long paramLong)
  {
    AppMethodBeat.i(76461);
    if (this.gfi == 0L) {
      this.kNr = bo.yB();
    }
    this.value += paramLong;
    this.gfi += 1L;
    this.oGN = bo.yB();
    AppMethodBeat.o(76461);
  }
  
  public final void reset()
  {
    this.value = 0L;
    this.gfi = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b
 * JD-Core Version:    0.7.0.1
 */
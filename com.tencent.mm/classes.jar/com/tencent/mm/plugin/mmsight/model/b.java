package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.sdk.platformtools.bk;

public final class b
{
  long ePv = 0L;
  long iHm = bk.UZ();
  long mgo = bk.UZ();
  private String tag = "default";
  long value = 0L;
  
  public b(String paramString)
  {
    this.tag = paramString;
  }
  
  public final String biG()
  {
    if (this.ePv == 0L) {
      return "";
    }
    double d2 = (this.mgo - this.iHm) / 1000.0D;
    double d1 = d2;
    if (d2 == 0.0D) {
      d1 = 1.0D;
    }
    return 1.0D * this.ePv / d1;
  }
  
  public final void fj(long paramLong)
  {
    if (this.ePv == 0L) {
      this.iHm = bk.UZ();
    }
    this.value += paramLong;
    this.ePv += 1L;
    this.mgo = bk.UZ();
  }
  
  public final String getValue()
  {
    if (this.ePv == 0L) {
      return "";
    }
    double d2 = (this.mgo - this.iHm) / 1000.0D;
    double d1 = d2;
    if (d2 == 0.0D) {
      d1 = 1.0D;
    }
    return String.format("CounterUtil %s tag %s count %s passed %.3f perValue %.3f/count counttime %.3f/s valuetime %.3f/s st:%s ed:%s diff%s", new Object[] { "", this.tag, Long.valueOf(this.ePv), Double.valueOf(d1), Double.valueOf(this.value * 1.0D / this.ePv), Double.valueOf(this.ePv * 1.0D / d1), Double.valueOf(1.0D * this.value / d1), Long.valueOf(this.iHm), Long.valueOf(this.mgo), Long.valueOf(this.mgo - this.iHm) });
  }
  
  public final void reset()
  {
    this.value = 0L;
    this.ePv = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b
 * JD-Core Version:    0.7.0.1
 */
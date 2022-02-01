package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lv
  extends a
{
  private long gSa = 0L;
  private long gSb = 0L;
  private long gSc = 0L;
  private long gSd = 0L;
  private int gSe = 0;
  
  public final String agH()
  {
    AppMethodBeat.i(118500);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gSa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSe);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118500);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118501);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StartZipTime:").append(this.gSa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Enable:").append(this.gSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Exceed:").append(this.gSc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Cost:").append(this.gSd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.gSe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118501);
    return localObject;
  }
  
  public final lv amQ()
  {
    this.gSc = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 17654;
  }
  
  public final lv nM(int paramInt)
  {
    this.gSe = paramInt;
    return this;
  }
  
  public final lv wi(long paramLong)
  {
    this.gSa = paramLong;
    return this;
  }
  
  public final lv wj(long paramLong)
  {
    this.gSb = paramLong;
    return this;
  }
  
  public final lv wk(long paramLong)
  {
    this.gSd = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lv
 * JD-Core Version:    0.7.0.1
 */
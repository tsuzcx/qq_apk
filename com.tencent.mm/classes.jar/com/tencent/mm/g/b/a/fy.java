package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fy
  extends a
{
  private long enY = 0L;
  private long enZ = 0L;
  private long eoa = 0L;
  private long eob = 0L;
  private int eoc = 0;
  
  public final String RC()
  {
    AppMethodBeat.i(118500);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eob);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoc);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118500);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118501);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StartZipTime:").append(this.enY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Enable:").append(this.enZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Exceed:").append(this.eoa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Cost:").append(this.eob);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.eoc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118501);
    return localObject;
  }
  
  public final fy TF()
  {
    this.eoa = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 17654;
  }
  
  public final fy iM(int paramInt)
  {
    this.eoc = paramInt;
    return this;
  }
  
  public final fy le(long paramLong)
  {
    this.enY = paramLong;
    return this;
  }
  
  public final fy lf(long paramLong)
  {
    this.enZ = paramLong;
    return this;
  }
  
  public final fy lg(long paramLong)
  {
    this.eob = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fy
 * JD-Core Version:    0.7.0.1
 */
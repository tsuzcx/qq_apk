package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fw
  extends a
{
  private long emq = 0L;
  private long emr = 0L;
  private long ems = 0L;
  private long emt = 0L;
  private int emu = 0;
  
  public final String RD()
  {
    AppMethodBeat.i(118500);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ems);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emu);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118500);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118501);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StartZipTime:").append(this.emq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Enable:").append(this.emr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Exceed:").append(this.ems);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Cost:").append(this.emt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.emu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118501);
    return localObject;
  }
  
  public final fw Tz()
  {
    this.ems = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 17654;
  }
  
  public final fw iK(int paramInt)
  {
    this.emu = paramInt;
    return this;
  }
  
  public final fw kT(long paramLong)
  {
    this.emq = paramLong;
    return this;
  }
  
  public final fw kU(long paramLong)
  {
    this.emr = paramLong;
    return this;
  }
  
  public final fw kV(long paramLong)
  {
    this.emt = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fw
 * JD-Core Version:    0.7.0.1
 */
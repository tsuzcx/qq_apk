package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ov
  extends a
{
  public int jkA = 0;
  public long jkw = 0L;
  public long jkx = 0L;
  public long jky = 0L;
  public long jkz = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(118500);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jkw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jky);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkA);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118500);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118501);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StartZipTime:").append(this.jkw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Enable:").append(this.jkx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Exceed:").append(this.jky);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Cost:").append(this.jkz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.jkA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118501);
    return localObject;
  }
  
  public final int getId()
  {
    return 17654;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ov
 * JD-Core Version:    0.7.0.1
 */
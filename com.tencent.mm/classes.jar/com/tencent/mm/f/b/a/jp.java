package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jp
  extends a
{
  public long gLA = 0L;
  public long gLB = 0L;
  public String gLC = "";
  public long gLD = 0L;
  public long gLE = 0L;
  public long gLz = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(199605);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gLz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLE);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(199605);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(199608);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResType:").append(this.gLz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResSubType:").append(this.gLA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResVersion:").append(this.gLB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Network:").append(this.gLC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.gLD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportKey:").append(this.gLE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(199608);
    return localObject;
  }
  
  public final int getId()
  {
    return 15166;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jp
 * JD-Core Version:    0.7.0.1
 */
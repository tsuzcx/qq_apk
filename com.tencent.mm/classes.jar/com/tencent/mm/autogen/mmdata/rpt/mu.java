package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mu
  extends a
{
  public String ipx = "";
  private long jcA = 0L;
  public String jcy = "";
  public String jcz = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(116484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcA);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(116484);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(116485);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.ipx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("api:").append(this.jcy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("arg:").append(this.jcz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampMs:").append(this.jcA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116485);
    return localObject;
  }
  
  public final mu fn(long paramLong)
  {
    AppMethodBeat.i(116483);
    this.jcA = paramLong;
    super.by("timestampMs", this.jcA);
    AppMethodBeat.o(116483);
    return this;
  }
  
  public final int getId()
  {
    return 15961;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mu
 * JD-Core Version:    0.7.0.1
 */
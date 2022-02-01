package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cc
  extends a
{
  public String dHL = "";
  public String dQH = "";
  public String dQI = "";
  private long dQJ = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(116484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQJ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(116484);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(116485);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dHL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("api:").append(this.dQH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("arg:").append(this.dQI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampMs:").append(this.dQJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116485);
    return localObject;
  }
  
  public final cc eZ(long paramLong)
  {
    AppMethodBeat.i(116483);
    this.dQJ = paramLong;
    super.bb("timestampMs", this.dQJ);
    AppMethodBeat.o(116483);
    return this;
  }
  
  public final int getId()
  {
    return 15961;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cc
 * JD-Core Version:    0.7.0.1
 */
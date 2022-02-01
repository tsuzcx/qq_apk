package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class el
  extends a
{
  public String dSD = "";
  public String eic = "";
  public String eid = "";
  private long eie = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(116484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eic);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eid);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eie);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(116484);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(116485);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("api:").append(this.eic);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("arg:").append(this.eid);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampMs:").append(this.eie);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116485);
    return localObject;
  }
  
  public final int getId()
  {
    return 15961;
  }
  
  public final el jY(long paramLong)
  {
    AppMethodBeat.i(116483);
    this.eie = paramLong;
    super.bg("timestampMs", this.eie);
    AppMethodBeat.o(116483);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.el
 * JD-Core Version:    0.7.0.1
 */
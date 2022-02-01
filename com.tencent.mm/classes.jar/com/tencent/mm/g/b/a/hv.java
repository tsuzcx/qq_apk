package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hv
  extends a
{
  public String eMA = "";
  private long eMB = 0L;
  public String eMz = "";
  public String enR = "";
  
  public final String abV()
  {
    AppMethodBeat.i(116484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMB);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(116484);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(116485);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.enR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("api:").append(this.eMz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("arg:").append(this.eMA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampMs:").append(this.eMB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116485);
    return localObject;
  }
  
  public final int getId()
  {
    return 15961;
  }
  
  public final hv qW(long paramLong)
  {
    AppMethodBeat.i(116483);
    this.eMB = paramLong;
    super.bj("timestampMs", this.eMB);
    AppMethodBeat.o(116483);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hv
 * JD-Core Version:    0.7.0.1
 */
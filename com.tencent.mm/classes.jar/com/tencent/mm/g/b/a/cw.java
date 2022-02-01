package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cw
  extends a
{
  private long dUW;
  private String ecZ;
  private long edB = 0L;
  private long edb;
  
  public final String RD()
  {
    AppMethodBeat.i(211898);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edb);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(211898);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(211899);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reddot:").append(this.edB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.edb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211899);
    return localObject;
  }
  
  public final cw ST()
  {
    this.dUW = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19887;
  }
  
  public final cw iL(long paramLong)
  {
    this.edb = paramLong;
    return this;
  }
  
  public final cw mb(String paramString)
  {
    AppMethodBeat.i(211897);
    this.ecZ = t("roomid", paramString, true);
    AppMethodBeat.o(211897);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cw
 * JD-Core Version:    0.7.0.1
 */
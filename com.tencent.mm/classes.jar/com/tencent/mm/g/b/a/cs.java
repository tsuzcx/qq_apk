package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cs
  extends a
{
  private String ecZ;
  private long eda;
  private long edl = 0L;
  private long edm;
  private String edn;
  private long edo;
  private long edp;
  
  public final String RD()
  {
    AppMethodBeat.i(211881);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eda);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edp);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(211881);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(211882);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eda);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("waitCount:").append(this.edl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowConnect:").append(this.edm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.edn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.edo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkCount:").append(this.edp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211882);
    return localObject;
  }
  
  public final int getId()
  {
    return 19894;
  }
  
  public final cs ip(long paramLong)
  {
    this.eda = paramLong;
    return this;
  }
  
  public final cs iq(long paramLong)
  {
    this.edl = paramLong;
    return this;
  }
  
  public final cs ir(long paramLong)
  {
    this.edm = paramLong;
    return this;
  }
  
  public final cs is(long paramLong)
  {
    this.edp = paramLong;
    return this;
  }
  
  public final cs lS(String paramString)
  {
    AppMethodBeat.i(211880);
    this.ecZ = t("roomid", paramString, true);
    AppMethodBeat.o(211880);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cs
 * JD-Core Version:    0.7.0.1
 */
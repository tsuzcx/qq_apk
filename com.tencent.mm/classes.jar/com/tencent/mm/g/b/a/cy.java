package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cy
  extends a
{
  private String ecZ;
  private long edJ = 0L;
  private long edK;
  private long edL;
  private String edM;
  private long eda;
  private long edc;
  private String edw;
  private String edx;
  
  public final String RD()
  {
    AppMethodBeat.i(211906);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eda);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edM);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(211906);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(211907);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eda);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micid:").append(this.edJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.edw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.edc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("closeRole:").append(this.edK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasVideo:").append(this.edL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.edx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("livemicid:").append(this.edM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211907);
    return localObject;
  }
  
  public final int getId()
  {
    return 19895;
  }
  
  public final cy iR(long paramLong)
  {
    this.eda = paramLong;
    return this;
  }
  
  public final cy iS(long paramLong)
  {
    this.edc = paramLong;
    return this;
  }
  
  public final cy iT(long paramLong)
  {
    this.edK = paramLong;
    return this;
  }
  
  public final cy iU(long paramLong)
  {
    this.edL = paramLong;
    return this;
  }
  
  public final cy md(String paramString)
  {
    AppMethodBeat.i(211903);
    this.ecZ = t("roomid", paramString, true);
    AppMethodBeat.o(211903);
    return this;
  }
  
  public final cy me(String paramString)
  {
    AppMethodBeat.i(211904);
    this.edx = t("liveusername", paramString, true);
    AppMethodBeat.o(211904);
    return this;
  }
  
  public final cy mf(String paramString)
  {
    AppMethodBeat.i(211905);
    this.edM = t("livemicid", paramString, true);
    AppMethodBeat.o(211905);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cy
 * JD-Core Version:    0.7.0.1
 */
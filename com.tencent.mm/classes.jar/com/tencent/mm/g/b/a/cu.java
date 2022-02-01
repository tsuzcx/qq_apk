package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cu
  extends a
{
  private long dUW;
  private String dYk;
  private String ecZ;
  private long eda;
  private long edb;
  private long edd;
  private String edw;
  private String edx;
  
  public final String RD()
  {
    AppMethodBeat.i(211890);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eda);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edx);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(211890);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(211891);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eda);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dYk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.edw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.edb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.edx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211891);
    return localObject;
  }
  
  public final cu SS()
  {
    this.dUW = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19896;
  }
  
  public final cu iC(long paramLong)
  {
    this.eda = paramLong;
    return this;
  }
  
  public final cu iD(long paramLong)
  {
    this.edb = paramLong;
    return this;
  }
  
  public final cu iE(long paramLong)
  {
    this.edd = paramLong;
    return this;
  }
  
  public final cu lV(String paramString)
  {
    AppMethodBeat.i(211887);
    this.ecZ = t("roomid", paramString, true);
    AppMethodBeat.o(211887);
    return this;
  }
  
  public final cu lW(String paramString)
  {
    AppMethodBeat.i(211888);
    this.dYk = t("topic", paramString, true);
    AppMethodBeat.o(211888);
    return this;
  }
  
  public final cu lX(String paramString)
  {
    AppMethodBeat.i(211889);
    this.edx = t("liveusername", paramString, true);
    AppMethodBeat.o(211889);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cu
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cv
  extends a
{
  private long dUW;
  private String dYk;
  private String ecZ;
  private long edA;
  private long eda;
  private long edb;
  private String edx;
  private long edy;
  private long edz;
  
  public final String RD()
  {
    AppMethodBeat.i(211895);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eda);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edA);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(211895);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(211896);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eda);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dYk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.edx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.edy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.edb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusEnd:").append(this.edz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusBegin:").append(this.edA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211896);
    return localObject;
  }
  
  public final int getId()
  {
    return 19897;
  }
  
  public final cv iF(long paramLong)
  {
    this.eda = paramLong;
    return this;
  }
  
  public final cv iG(long paramLong)
  {
    this.dUW = paramLong;
    return this;
  }
  
  public final cv iH(long paramLong)
  {
    this.edy = paramLong;
    return this;
  }
  
  public final cv iI(long paramLong)
  {
    this.edb = paramLong;
    return this;
  }
  
  public final cv iJ(long paramLong)
  {
    this.edz = paramLong;
    return this;
  }
  
  public final cv iK(long paramLong)
  {
    this.edA = paramLong;
    return this;
  }
  
  public final cv lY(String paramString)
  {
    AppMethodBeat.i(211892);
    this.ecZ = t("roomid", paramString, true);
    AppMethodBeat.o(211892);
    return this;
  }
  
  public final cv lZ(String paramString)
  {
    AppMethodBeat.i(211893);
    this.dYk = t("topic", paramString, true);
    AppMethodBeat.o(211893);
    return this;
  }
  
  public final cv ma(String paramString)
  {
    AppMethodBeat.i(211894);
    this.edx = t("liveusername", paramString, true);
    AppMethodBeat.o(211894);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cv
 * JD-Core Version:    0.7.0.1
 */
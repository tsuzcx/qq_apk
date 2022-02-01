package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class da
  extends a
{
  private String dYk;
  private String ecZ;
  private long edR;
  private long edS;
  private long eda;
  private long edb;
  private String edx;
  private long edy;
  
  public final String RD()
  {
    AppMethodBeat.i(211915);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eda);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edS);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(211915);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(211916);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eda);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dYk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.edx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.edy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.edb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("wholeTime:").append(this.edR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("viewTime:").append(this.edS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211916);
    return localObject;
  }
  
  public final int getId()
  {
    return 19898;
  }
  
  public final da jb(long paramLong)
  {
    this.eda = paramLong;
    return this;
  }
  
  public final da jc(long paramLong)
  {
    this.edy = paramLong;
    return this;
  }
  
  public final da jd(long paramLong)
  {
    this.edb = paramLong;
    return this;
  }
  
  public final da je(long paramLong)
  {
    this.edR = paramLong;
    return this;
  }
  
  public final da jf(long paramLong)
  {
    this.edS = paramLong;
    return this;
  }
  
  public final da mi(String paramString)
  {
    AppMethodBeat.i(211912);
    this.ecZ = t("roomid", paramString, true);
    AppMethodBeat.o(211912);
    return this;
  }
  
  public final da mj(String paramString)
  {
    AppMethodBeat.i(211913);
    this.dYk = t("topic", paramString, true);
    AppMethodBeat.o(211913);
    return this;
  }
  
  public final da mk(String paramString)
  {
    AppMethodBeat.i(211914);
    this.edx = t("liveusername", paramString, true);
    AppMethodBeat.o(211914);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.da
 * JD-Core Version:    0.7.0.1
 */
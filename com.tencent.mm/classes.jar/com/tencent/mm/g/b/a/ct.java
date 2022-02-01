package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ct
  extends a
{
  private long dSx;
  private long dUW;
  private String dYk = "";
  private String ecZ;
  private long edb;
  private long edj;
  private long edq;
  private long edr;
  private long eds;
  private long edt;
  private long edu;
  private long edv;
  
  public final String RD()
  {
    AppMethodBeat.i(211885);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eds);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edj);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(211885);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(211886);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("rulePop:").append(this.edq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ruleCheck:").append(this.edr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dYk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("customTopic:").append(this.eds);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cameraStatus:").append(this.edt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("horizontalStatus:").append(this.edu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.dSx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.edb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.edj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211886);
    return localObject;
  }
  
  public final ct SR()
  {
    this.dUW = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19890;
  }
  
  public final ct iA(long paramLong)
  {
    this.edb = paramLong;
    return this;
  }
  
  public final ct iB(long paramLong)
  {
    this.edj = paramLong;
    return this;
  }
  
  public final ct it(long paramLong)
  {
    this.edq = paramLong;
    return this;
  }
  
  public final ct iu(long paramLong)
  {
    this.edr = paramLong;
    return this;
  }
  
  public final ct iv(long paramLong)
  {
    this.eds = paramLong;
    return this;
  }
  
  public final ct iw(long paramLong)
  {
    this.edt = paramLong;
    return this;
  }
  
  public final ct ix(long paramLong)
  {
    this.edu = paramLong;
    return this;
  }
  
  public final ct iy(long paramLong)
  {
    this.dSx = paramLong;
    return this;
  }
  
  public final ct iz(long paramLong)
  {
    this.edv = paramLong;
    return this;
  }
  
  public final ct lT(String paramString)
  {
    AppMethodBeat.i(211883);
    this.ecZ = t("roomid", paramString, true);
    AppMethodBeat.o(211883);
    return this;
  }
  
  public final ct lU(String paramString)
  {
    AppMethodBeat.i(211884);
    this.dYk = t("topic", paramString, true);
    AppMethodBeat.o(211884);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ct
 * JD-Core Version:    0.7.0.1
 */
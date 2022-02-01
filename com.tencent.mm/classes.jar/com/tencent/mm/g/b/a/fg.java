package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fg
  extends a
{
  private String eFc = "";
  private long eFd;
  private long eFl;
  private long eFr;
  private long eFs;
  private long eFt;
  private long eFu;
  private long eFv;
  private long eFw;
  private long enL;
  private long erw;
  private String evz = "";
  
  public final String abV()
  {
    AppMethodBeat.i(207419);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFl);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(207419);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(207420);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.eFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("rulePop:").append(this.eFr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ruleCheck:").append(this.eFs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.evz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("customTopic:").append(this.eFt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cameraStatus:").append(this.eFu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("horizontalStatus:").append(this.eFv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.enL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.eFw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.eFl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207420);
    return localObject;
  }
  
  public final fg afY()
  {
    this.erw = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19890;
  }
  
  public final fg nA(long paramLong)
  {
    this.eFw = paramLong;
    return this;
  }
  
  public final fg nB(long paramLong)
  {
    this.eFd = paramLong;
    return this;
  }
  
  public final fg nC(long paramLong)
  {
    this.eFl = paramLong;
    return this;
  }
  
  public final fg nu(long paramLong)
  {
    this.eFr = paramLong;
    return this;
  }
  
  public final fg nv(long paramLong)
  {
    this.eFs = paramLong;
    return this;
  }
  
  public final fg nw(long paramLong)
  {
    this.eFt = paramLong;
    return this;
  }
  
  public final fg nx(long paramLong)
  {
    this.eFu = paramLong;
    return this;
  }
  
  public final fg ny(long paramLong)
  {
    this.eFv = paramLong;
    return this;
  }
  
  public final fg nz(long paramLong)
  {
    this.enL = paramLong;
    return this;
  }
  
  public final fg se(String paramString)
  {
    AppMethodBeat.i(207417);
    this.eFc = x("roomid", paramString, true);
    AppMethodBeat.o(207417);
    return this;
  }
  
  public final fg sf(String paramString)
  {
    AppMethodBeat.i(207418);
    this.evz = x("topic", paramString, true);
    AppMethodBeat.o(207418);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fg
 * JD-Core Version:    0.7.0.1
 */
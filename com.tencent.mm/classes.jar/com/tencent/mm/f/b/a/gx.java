package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gx
  extends a
{
  private long gDF;
  private long gDL;
  private long gDM;
  private long gDN;
  private long gDO;
  private long gDP;
  private long gDQ;
  private String gDw = "";
  private long gDy;
  private long giN;
  private long gmT;
  private String grG = "";
  
  public final String agH()
  {
    AppMethodBeat.i(198034);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDF);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(198034);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(198051);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.gDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("rulePop:").append(this.gDL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ruleCheck:").append(this.gDM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.grG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("customTopic:").append(this.gDN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cameraStatus:").append(this.gDO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("horizontalStatus:").append(this.gDP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.giN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.gDQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.gDy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.gDF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(198051);
    return localObject;
  }
  
  public final gx alb()
  {
    this.gmT = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19890;
  }
  
  public final gx pF(long paramLong)
  {
    this.gDL = paramLong;
    return this;
  }
  
  public final gx pG(long paramLong)
  {
    this.gDM = paramLong;
    return this;
  }
  
  public final gx pH(long paramLong)
  {
    this.gDN = paramLong;
    return this;
  }
  
  public final gx pI(long paramLong)
  {
    this.gDO = paramLong;
    return this;
  }
  
  public final gx pJ(long paramLong)
  {
    this.gDP = paramLong;
    return this;
  }
  
  public final gx pK(long paramLong)
  {
    this.giN = paramLong;
    return this;
  }
  
  public final gx pL(long paramLong)
  {
    this.gDQ = paramLong;
    return this;
  }
  
  public final gx pM(long paramLong)
  {
    this.gDy = paramLong;
    return this;
  }
  
  public final gx pN(long paramLong)
  {
    this.gDF = paramLong;
    return this;
  }
  
  public final gx vP(String paramString)
  {
    AppMethodBeat.i(198008);
    this.gDw = z("roomid", paramString, true);
    AppMethodBeat.o(198008);
    return this;
  }
  
  public final gx vQ(String paramString)
  {
    AppMethodBeat.i(198014);
    this.grG = z("topic", paramString, true);
    AppMethodBeat.o(198014);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gx
 * JD-Core Version:    0.7.0.1
 */
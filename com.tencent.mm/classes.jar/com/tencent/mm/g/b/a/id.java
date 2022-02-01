package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class id
  extends a
{
  private long dHF;
  private String dKR = "";
  private long dKc;
  private String dQr;
  private long maV;
  private long mat;
  private long mbb;
  private long mbc;
  private long mbd;
  private long mbe;
  private long mbf;
  private long mbg;
  
  public final id Aa(long paramLong)
  {
    this.mbg = paramLong;
    return this;
  }
  
  public final id Ab(long paramLong)
  {
    this.mat = paramLong;
    return this;
  }
  
  public final id Ac(long paramLong)
  {
    this.maV = paramLong;
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(202442);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mat);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maV);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(202442);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(202443);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.dQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("rulePop:").append(this.mbb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ruleCheck:").append(this.mbc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dKR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("customTopic:").append(this.mbd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cameraStatus:").append(this.mbe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("horizontalStatus:").append(this.mbf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.dHF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.mbg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.mat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.maV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(202443);
    return localObject;
  }
  
  public final id aSW(String paramString)
  {
    AppMethodBeat.i(202440);
    this.dQr = t("roomid", paramString, true);
    AppMethodBeat.o(202440);
    return this;
  }
  
  public final id aSX(String paramString)
  {
    AppMethodBeat.i(202441);
    this.dKR = t("topic", paramString, true);
    AppMethodBeat.o(202441);
    return this;
  }
  
  public final id bsZ()
  {
    this.dKc = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19887;
  }
  
  public final id zU(long paramLong)
  {
    this.mbb = paramLong;
    return this;
  }
  
  public final id zV(long paramLong)
  {
    this.mbc = paramLong;
    return this;
  }
  
  public final id zW(long paramLong)
  {
    this.mbd = paramLong;
    return this;
  }
  
  public final id zX(long paramLong)
  {
    this.mbe = paramLong;
    return this;
  }
  
  public final id zY(long paramLong)
  {
    this.mbf = paramLong;
    return this;
  }
  
  public final id zZ(long paramLong)
  {
    this.dHF = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.id
 * JD-Core Version:    0.7.0.1
 */
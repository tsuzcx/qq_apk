package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cj
  extends a
{
  private long dHR;
  private String dNK;
  private long dNL;
  private long dNQ;
  private long dNR;
  private long dNS;
  private long dOE;
  private long dOF;
  private long dOG;
  private long dOg;
  private String dOh;
  private String dOi;
  
  public final String PR()
  {
    AppMethodBeat.i(190842);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOi);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(190842);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(190843);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.dNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.dNL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.dOh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.dOg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterRoomCount:").append(this.dOE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitRoomCount:").append(this.dOF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.dNQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.dNR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectReqCount:").append(this.dOG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.dNS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.dOi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190843);
    return localObject;
  }
  
  public final int getId()
  {
    return 19892;
  }
  
  public final cj hA(long paramLong)
  {
    this.dOg = paramLong;
    return this;
  }
  
  public final cj hB(long paramLong)
  {
    this.dOE = paramLong;
    return this;
  }
  
  public final cj hC(long paramLong)
  {
    this.dOF = paramLong;
    return this;
  }
  
  public final cj hD(long paramLong)
  {
    this.dNQ = paramLong;
    return this;
  }
  
  public final cj hE(long paramLong)
  {
    this.dNR = paramLong;
    return this;
  }
  
  public final cj hF(long paramLong)
  {
    this.dOG = paramLong;
    return this;
  }
  
  public final cj hG(long paramLong)
  {
    this.dNS = paramLong;
    return this;
  }
  
  public final cj hy(long paramLong)
  {
    this.dHR = paramLong;
    return this;
  }
  
  public final cj hz(long paramLong)
  {
    this.dNL = paramLong;
    return this;
  }
  
  public final cj kp(String paramString)
  {
    AppMethodBeat.i(190840);
    this.dNK = t("roomid", paramString, true);
    AppMethodBeat.o(190840);
    return this;
  }
  
  public final cj kq(String paramString)
  {
    AppMethodBeat.i(190841);
    this.dOi = t("liveusername", paramString, true);
    AppMethodBeat.o(190841);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cj
 * JD-Core Version:    0.7.0.1
 */
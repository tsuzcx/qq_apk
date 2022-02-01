package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bz
  extends a
{
  private long dHR;
  private String dKl = "";
  private String dNK;
  private long dNL;
  private long dNM;
  private long dNN = 0L;
  private long dNO;
  private long dNP;
  private long dNQ;
  private long dNR;
  private long dNS;
  private long dNT;
  private long dNU;
  private long dNV;
  
  public final String PR()
  {
    AppMethodBeat.i(190801);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNV);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(190801);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(190802);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.dNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.dNL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dKl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.dNM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.dNN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.dNO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCountMax:").append(this.dNP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.dNQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.dNR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.dNS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowReplay:").append(this.dNT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.dNU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("costTime:").append(this.dNV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190802);
    return localObject;
  }
  
  public final bz QJ()
  {
    this.dHR = 1L;
    return this;
  }
  
  public final bz gA(long paramLong)
  {
    this.dNP = paramLong;
    return this;
  }
  
  public final bz gB(long paramLong)
  {
    this.dNQ = paramLong;
    return this;
  }
  
  public final bz gC(long paramLong)
  {
    this.dNR = paramLong;
    return this;
  }
  
  public final bz gD(long paramLong)
  {
    this.dNS = paramLong;
    return this;
  }
  
  public final bz gE(long paramLong)
  {
    this.dNT = paramLong;
    return this;
  }
  
  public final bz gF(long paramLong)
  {
    this.dNU = paramLong;
    return this;
  }
  
  public final bz gG(long paramLong)
  {
    this.dNV = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19891;
  }
  
  public final bz gx(long paramLong)
  {
    this.dNL = paramLong;
    return this;
  }
  
  public final bz gy(long paramLong)
  {
    this.dNM = paramLong;
    return this;
  }
  
  public final bz gz(long paramLong)
  {
    this.dNO = paramLong;
    return this;
  }
  
  public final bz jU(String paramString)
  {
    AppMethodBeat.i(190799);
    this.dNK = t("roomid", paramString, true);
    AppMethodBeat.o(190799);
    return this;
  }
  
  public final bz jV(String paramString)
  {
    AppMethodBeat.i(190800);
    this.dKl = t("topic", paramString, true);
    AppMethodBeat.o(190800);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bz
 * JD-Core Version:    0.7.0.1
 */
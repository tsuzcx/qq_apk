package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class db
  extends a
{
  private long dUW;
  private String ecZ;
  private long edT;
  private long edU;
  private long edV;
  private long eda;
  private long edf;
  private long edg;
  private long edh;
  private long edv;
  private String edw;
  private String edx;
  
  public final String RD()
  {
    AppMethodBeat.i(211919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eda);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edx);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(211919);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(211920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eda);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.edw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterRoomCount:").append(this.edT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitRoomCount:").append(this.edU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.edf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.edg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectReqCount:").append(this.edV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.edh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.edx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211920);
    return localObject;
  }
  
  public final int getId()
  {
    return 19892;
  }
  
  public final db jg(long paramLong)
  {
    this.dUW = paramLong;
    return this;
  }
  
  public final db jh(long paramLong)
  {
    this.eda = paramLong;
    return this;
  }
  
  public final db ji(long paramLong)
  {
    this.edv = paramLong;
    return this;
  }
  
  public final db jj(long paramLong)
  {
    this.edT = paramLong;
    return this;
  }
  
  public final db jk(long paramLong)
  {
    this.edU = paramLong;
    return this;
  }
  
  public final db jl(long paramLong)
  {
    this.edf = paramLong;
    return this;
  }
  
  public final db jm(long paramLong)
  {
    this.edg = paramLong;
    return this;
  }
  
  public final db jn(long paramLong)
  {
    this.edV = paramLong;
    return this;
  }
  
  public final db jo(long paramLong)
  {
    this.edh = paramLong;
    return this;
  }
  
  public final db ml(String paramString)
  {
    AppMethodBeat.i(211917);
    this.ecZ = t("roomid", paramString, true);
    AppMethodBeat.o(211917);
    return this;
  }
  
  public final db mm(String paramString)
  {
    AppMethodBeat.i(211918);
    this.edx = t("liveusername", paramString, true);
    AppMethodBeat.o(211918);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.db
 * JD-Core Version:    0.7.0.1
 */
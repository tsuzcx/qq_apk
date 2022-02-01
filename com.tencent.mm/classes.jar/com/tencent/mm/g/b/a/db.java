package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class db
  extends a
{
  private long dWm;
  private long eeA;
  private long eeB;
  private long eeC;
  private long eeQ;
  private String eeR = "";
  private String eeS = "";
  private String eeu = "";
  private long eev;
  private long eex;
  private long efq;
  private long efr;
  private long efs;
  private long eft;
  private long efu;
  private long efv;
  
  public final String RC()
  {
    AppMethodBeat.i(215536);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eev);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eex);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eft);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efv);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(215536);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(215537);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eev);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.eeR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.eeQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterRoomCount:").append(this.efq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitRoomCount:").append(this.efr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.eeA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.eeB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectReqCount:").append(this.efs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.eeC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.eeS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.eex);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterTimestamp:").append(this.eft);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitTimestamp:").append(this.efu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitChatroomUV:").append(this.efv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215537);
    return localObject;
  }
  
  public final long SY()
  {
    return this.eft;
  }
  
  public final long SZ()
  {
    return this.efu;
  }
  
  public final int getId()
  {
    return 19892;
  }
  
  public final db jm(long paramLong)
  {
    this.dWm = paramLong;
    return this;
  }
  
  public final db jn(long paramLong)
  {
    this.eev = paramLong;
    return this;
  }
  
  public final db jo(long paramLong)
  {
    this.eeQ = paramLong;
    return this;
  }
  
  public final db jp(long paramLong)
  {
    this.efq = paramLong;
    return this;
  }
  
  public final db jq(long paramLong)
  {
    this.efr = paramLong;
    return this;
  }
  
  public final db jr(long paramLong)
  {
    this.eeA = paramLong;
    return this;
  }
  
  public final db js(long paramLong)
  {
    this.eeB = paramLong;
    return this;
  }
  
  public final db jt(long paramLong)
  {
    this.efs = paramLong;
    return this;
  }
  
  public final db ju(long paramLong)
  {
    this.eeC = paramLong;
    return this;
  }
  
  public final db jv(long paramLong)
  {
    this.eex = paramLong;
    return this;
  }
  
  public final db jw(long paramLong)
  {
    this.eft = paramLong;
    return this;
  }
  
  public final db jx(long paramLong)
  {
    this.efu = paramLong;
    return this;
  }
  
  public final db jy(long paramLong)
  {
    this.efv = paramLong;
    return this;
  }
  
  public final db mD(String paramString)
  {
    AppMethodBeat.i(215534);
    this.eeu = t("roomid", paramString, true);
    AppMethodBeat.o(215534);
    return this;
  }
  
  public final db mE(String paramString)
  {
    AppMethodBeat.i(215535);
    this.eeS = t("liveusername", paramString, true);
    AppMethodBeat.o(215535);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.db
 * JD-Core Version:    0.7.0.1
 */
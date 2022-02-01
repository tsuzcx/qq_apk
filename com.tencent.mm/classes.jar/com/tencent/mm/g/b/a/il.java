package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class il
  extends a
{
  private long dKc;
  private String dQr;
  private long maR;
  private long maS;
  private long maT;
  private long mas;
  private long mbg;
  private String mbh;
  private String mbi;
  private long oRg;
  private long prI;
  private long prR;
  
  public final il AH(long paramLong)
  {
    this.dKc = paramLong;
    return this;
  }
  
  public final il AI(long paramLong)
  {
    this.mas = paramLong;
    return this;
  }
  
  public final il AJ(long paramLong)
  {
    this.mbg = paramLong;
    return this;
  }
  
  public final il AK(long paramLong)
  {
    this.oRg = paramLong;
    return this;
  }
  
  public final il AL(long paramLong)
  {
    this.prI = paramLong;
    return this;
  }
  
  public final il AM(long paramLong)
  {
    this.maR = paramLong;
    return this;
  }
  
  public final il AN(long paramLong)
  {
    this.maS = paramLong;
    return this;
  }
  
  public final il AO(long paramLong)
  {
    this.prR = paramLong;
    return this;
  }
  
  public final il AP(long paramLong)
  {
    this.maT = paramLong;
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(202476);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mas);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oRg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.prI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.prR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbi);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(202476);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(202477);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.dQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.mas);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.mbh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.mbg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterRoomCount:").append(this.oRg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitRoomCount:").append(this.prI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.maR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.maS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectReqCount:").append(this.prR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.maT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.mbi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(202477);
    return localObject;
  }
  
  public final il aTo(String paramString)
  {
    AppMethodBeat.i(202474);
    this.dQr = t("roomid", paramString, true);
    AppMethodBeat.o(202474);
    return this;
  }
  
  public final il aTp(String paramString)
  {
    AppMethodBeat.i(202475);
    this.mbi = t("liveusername", paramString, true);
    AppMethodBeat.o(202475);
    return this;
  }
  
  public final int getId()
  {
    return 19892;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.il
 * JD-Core Version:    0.7.0.1
 */
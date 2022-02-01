package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hh
  extends a
{
  private long gDB;
  private long gDC;
  private long gDD;
  private long gDQ;
  private String gDR = "";
  private String gDS = "";
  private String gDw = "";
  private long gDx;
  private long gFh;
  private long gFi;
  private long gFj;
  private long gFk;
  private long gFl;
  private long gFm;
  private long gea;
  private long gmT;
  
  public final String agH()
  {
    AppMethodBeat.i(189644);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gea);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFm);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(189644);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(189659);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.gDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.gDx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.gDR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.gDQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterRoomCount:").append(this.gFh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitRoomCount:").append(this.gFi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.gDB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.gDC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectReqCount:").append(this.gFj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.gDD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.gDS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.gea);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterTimestamp:").append(this.gFk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitTimestamp:").append(this.gFl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitChatroomUV:").append(this.gFm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189659);
    return localObject;
  }
  
  public final long alD()
  {
    return this.gFk;
  }
  
  public final long alE()
  {
    return this.gFl;
  }
  
  public final int getId()
  {
    return 19892;
  }
  
  public final hh rg(long paramLong)
  {
    this.gmT = paramLong;
    return this;
  }
  
  public final hh rh(long paramLong)
  {
    this.gDx = paramLong;
    return this;
  }
  
  public final hh ri(long paramLong)
  {
    this.gDQ = paramLong;
    return this;
  }
  
  public final hh rj(long paramLong)
  {
    this.gFh = paramLong;
    return this;
  }
  
  public final hh rk(long paramLong)
  {
    this.gFi = paramLong;
    return this;
  }
  
  public final hh rl(long paramLong)
  {
    this.gDB = paramLong;
    return this;
  }
  
  public final hh rm(long paramLong)
  {
    this.gDC = paramLong;
    return this;
  }
  
  public final hh rn(long paramLong)
  {
    this.gFj = paramLong;
    return this;
  }
  
  public final hh ro(long paramLong)
  {
    this.gDD = paramLong;
    return this;
  }
  
  public final hh rp(long paramLong)
  {
    this.gea = paramLong;
    return this;
  }
  
  public final hh rq(long paramLong)
  {
    this.gFk = paramLong;
    return this;
  }
  
  public final hh rr(long paramLong)
  {
    this.gFl = paramLong;
    return this;
  }
  
  public final hh rs(long paramLong)
  {
    this.gFm = paramLong;
    return this;
  }
  
  public final hh wo(String paramString)
  {
    AppMethodBeat.i(189616);
    this.gDw = z("roomid", paramString, true);
    AppMethodBeat.o(189616);
    return this;
  }
  
  public final hh wp(String paramString)
  {
    AppMethodBeat.i(189630);
    this.gDS = z("liveusername", paramString, true);
    AppMethodBeat.o(189630);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hh
 * JD-Core Version:    0.7.0.1
 */
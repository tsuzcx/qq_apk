package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fp
  extends a
{
  private String eFc = "";
  private long eFe;
  private long eFh;
  private long eFi;
  private long eFj;
  private long eFw;
  private String eFx = "";
  private String eFy = "";
  private long eGJ;
  private long eGK;
  private long eGL;
  private long eGM;
  private long eGN;
  private long eGO;
  private long erw;
  private long eyI;
  
  public final String abV()
  {
    AppMethodBeat.i(207454);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGO);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(207454);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(207455);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.eFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.eFx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.eFw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterRoomCount:").append(this.eGJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitRoomCount:").append(this.eGK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.eFh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.eFi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectReqCount:").append(this.eGL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.eFj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.eFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.eFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterTimestamp:").append(this.eGM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitTimestamp:").append(this.eGN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitChatroomUV:").append(this.eGO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207455);
    return localObject;
  }
  
  public final long agA()
  {
    return this.eGM;
  }
  
  public final long agB()
  {
    return this.eGN;
  }
  
  public final int getId()
  {
    return 19892;
  }
  
  public final fp oT(long paramLong)
  {
    this.erw = paramLong;
    return this;
  }
  
  public final fp oU(long paramLong)
  {
    this.eyI = paramLong;
    return this;
  }
  
  public final fp oV(long paramLong)
  {
    this.eFw = paramLong;
    return this;
  }
  
  public final fp oW(long paramLong)
  {
    this.eGJ = paramLong;
    return this;
  }
  
  public final fp oX(long paramLong)
  {
    this.eGK = paramLong;
    return this;
  }
  
  public final fp oY(long paramLong)
  {
    this.eFh = paramLong;
    return this;
  }
  
  public final fp oZ(long paramLong)
  {
    this.eFi = paramLong;
    return this;
  }
  
  public final fp pa(long paramLong)
  {
    this.eGL = paramLong;
    return this;
  }
  
  public final fp pb(long paramLong)
  {
    this.eFj = paramLong;
    return this;
  }
  
  public final fp pc(long paramLong)
  {
    this.eFe = paramLong;
    return this;
  }
  
  public final fp pd(long paramLong)
  {
    this.eGM = paramLong;
    return this;
  }
  
  public final fp pe(long paramLong)
  {
    this.eGN = paramLong;
    return this;
  }
  
  public final fp pf(long paramLong)
  {
    this.eGO = paramLong;
    return this;
  }
  
  public final fp sB(String paramString)
  {
    AppMethodBeat.i(207452);
    this.eFc = x("roomid", paramString, true);
    AppMethodBeat.o(207452);
    return this;
  }
  
  public final fp sC(String paramString)
  {
    AppMethodBeat.i(207453);
    this.eFy = x("liveusername", paramString, true);
    AppMethodBeat.o(207453);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fp
 * JD-Core Version:    0.7.0.1
 */
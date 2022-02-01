package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ih
  extends a
{
  private String dQn;
  private long mbj;
  private long mpC;
  private String mpD;
  private long oKr;
  private long oKs;
  private long oKv;
  private int oKw;
  
  public final ih An(long paramLong)
  {
    this.mpC = paramLong;
    return this;
  }
  
  public final ih Ao(long paramLong)
  {
    this.mbj = paramLong;
    return this;
  }
  
  public final ih Ap(long paramLong)
  {
    this.oKr = paramLong;
    return this;
  }
  
  public final ih Aq(long paramLong)
  {
    this.oKs = paramLong;
    return this;
  }
  
  public final ih Ar(long paramLong)
  {
    this.oKv = paramLong;
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(202458);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mpC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mpD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oKr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oKs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oKv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oKw);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(202458);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(202459);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.dQn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.mpC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micId:").append(this.mpD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.mbj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("groupRole:").append(this.oKr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkStatus:").append(this.oKs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceMode:").append(this.oKv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorCode:").append(this.oKw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(202459);
    return localObject;
  }
  
  public final ih aTf(String paramString)
  {
    AppMethodBeat.i(202457);
    this.mpD = t("micId", paramString, true);
    AppMethodBeat.o(202457);
    return this;
  }
  
  public final int getId()
  {
    return 19968;
  }
  
  public final ih pg(int paramInt)
  {
    this.oKw = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ih
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oe
  extends a
{
  private long giq = 0L;
  private long gqh = 0L;
  private long haV = 0L;
  private String haW = "";
  private long haX = 0L;
  private String haY = "";
  private String hbc = "";
  private String hbd = "";
  private String hbe = "";
  private String hbf = "";
  private long hbg;
  private long hbh;
  
  public final oe AB(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final oe AC(long paramLong)
  {
    this.gqh = paramLong;
    return this;
  }
  
  public final oe AD(long paramLong)
  {
    this.haX = paramLong;
    return this;
  }
  
  public final oe AE(long paramLong)
  {
    this.hbg = paramLong;
    return this;
  }
  
  public final oe AF(long paramLong)
  {
    this.hbh = paramLong;
    return this;
  }
  
  public final oe EV(String paramString)
  {
    AppMethodBeat.i(212310);
    this.haW = z("ResultQuery", paramString, true);
    AppMethodBeat.o(212310);
    return this;
  }
  
  public final oe EW(String paramString)
  {
    AppMethodBeat.i(212313);
    this.haY = z("ShareSceneId", paramString, true);
    AppMethodBeat.o(212313);
    return this;
  }
  
  public final oe EX(String paramString)
  {
    AppMethodBeat.i(212314);
    this.hbc = z("ShareSessionId", paramString, true);
    AppMethodBeat.o(212314);
    return this;
  }
  
  public final oe EY(String paramString)
  {
    AppMethodBeat.i(212317);
    this.hbd = z("ShareSearchId", paramString, true);
    AppMethodBeat.o(212317);
    return this;
  }
  
  public final oe EZ(String paramString)
  {
    AppMethodBeat.i(212319);
    this.hbe = z("ShareRequestId", paramString, true);
    AppMethodBeat.o(212319);
    return this;
  }
  
  public final oe Fa(String paramString)
  {
    AppMethodBeat.i(212321);
    this.hbf = z("ShareDocId", paramString, true);
    AppMethodBeat.o(212321);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(212325);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.haV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.haW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.haX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.haY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbh);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(212325);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(212328);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.gqh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResultType:").append(this.haV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResultQuery:").append(this.haW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareScene:").append(this.haX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSceneId:").append(this.haY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSessionId:").append(this.hbc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSearchId:").append(this.hbd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareRequestId:").append(this.hbe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareDocId:").append(this.hbf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareBizType:").append(this.hbg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSubType:").append(this.hbh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(212328);
    return localObject;
  }
  
  public final oe aod()
  {
    this.haV = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 20997;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.oe
 * JD-Core Version:    0.7.0.1
 */
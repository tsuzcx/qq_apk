package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bc
  extends a
{
  private String eiB = "";
  private String eiC = "";
  private String eiD = "";
  private long eiE;
  private long eiH;
  private String eiI = "";
  private long erA;
  private String erB = "";
  
  public final String abV()
  {
    AppMethodBeat.i(208852);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiI);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208852);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208853);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("IfSelf:").append(this.erA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.erB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.eiC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContexId:").append(this.eiD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.eiE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTarget:").append(this.eiH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActivityId:").append(this.eiI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208853);
    return localObject;
  }
  
  public final bc dd(long paramLong)
  {
    this.erA = paramLong;
    return this;
  }
  
  public final bc de(long paramLong)
  {
    this.eiE = paramLong;
    return this;
  }
  
  public final bc df(long paramLong)
  {
    this.eiH = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21206;
  }
  
  public final bc iL(String paramString)
  {
    AppMethodBeat.i(208847);
    this.erB = x("Action", paramString, true);
    AppMethodBeat.o(208847);
    return this;
  }
  
  public final bc iM(String paramString)
  {
    AppMethodBeat.i(208848);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(208848);
    return this;
  }
  
  public final bc iN(String paramString)
  {
    AppMethodBeat.i(208849);
    this.eiC = x("ClickTabContextid", paramString, true);
    AppMethodBeat.o(208849);
    return this;
  }
  
  public final bc iO(String paramString)
  {
    AppMethodBeat.i(208850);
    this.eiD = x("FinderContexId", paramString, true);
    AppMethodBeat.o(208850);
    return this;
  }
  
  public final bc iP(String paramString)
  {
    AppMethodBeat.i(208851);
    this.eiI = x("ActivityId", paramString, true);
    AppMethodBeat.o(208851);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bc
 * JD-Core Version:    0.7.0.1
 */
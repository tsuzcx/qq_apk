package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.report.a
{
  private String eiB = "";
  private String eiC = "";
  private String eiD = "";
  private long eiE;
  private long eiF;
  private String eiG = "";
  private long eiH;
  private String eiI = "";
  
  public final a abU()
  {
    this.eiH = 1L;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(208819);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiI);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208819);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208820);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.eiC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContexId:").append(this.eiD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.eiE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventCode:").append(this.eiF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTime:").append(this.eiG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTarget:").append(this.eiH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActivityId:").append(this.eiI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208820);
    return localObject;
  }
  
  public final a bD(long paramLong)
  {
    this.eiE = paramLong;
    return this;
  }
  
  public final a bE(long paramLong)
  {
    this.eiF = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21851;
  }
  
  public final a hA(String paramString)
  {
    AppMethodBeat.i(208814);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(208814);
    return this;
  }
  
  public final a hB(String paramString)
  {
    AppMethodBeat.i(208815);
    this.eiC = x("ClickTabContextid", paramString, true);
    AppMethodBeat.o(208815);
    return this;
  }
  
  public final a hC(String paramString)
  {
    AppMethodBeat.i(208816);
    this.eiD = x("FinderContexId", paramString, true);
    AppMethodBeat.o(208816);
    return this;
  }
  
  public final a hD(String paramString)
  {
    AppMethodBeat.i(208817);
    this.eiG = x("EventTime", paramString, true);
    AppMethodBeat.o(208817);
    return this;
  }
  
  public final a hE(String paramString)
  {
    AppMethodBeat.i(208818);
    this.eiI = x("ActivityId", paramString, true);
    AppMethodBeat.o(208818);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.a
 * JD-Core Version:    0.7.0.1
 */
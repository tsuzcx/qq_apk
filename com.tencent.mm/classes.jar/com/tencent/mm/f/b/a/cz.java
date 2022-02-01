package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cz
  extends a
{
  private String gcV = "";
  private long geB;
  private String gnO = "";
  private long gnP;
  private String gnp = "";
  private long grA;
  private long grB;
  private long grC;
  private long gry;
  private long grz;
  
  public final String agH()
  {
    AppMethodBeat.i(208537);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gry);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grC);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208537);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208538);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.gnO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.gnp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.gcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTimeStamp:").append(this.gry);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("messageType:").append(this.grz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedIndex:").append(this.grA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isfloat:").append(this.grB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("innerVersion:").append(this.grC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208538);
    return localObject;
  }
  
  public final cz ahU()
  {
    this.grC = 1L;
    return this;
  }
  
  public final cz gL(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final cz gM(long paramLong)
  {
    this.geB = paramLong;
    return this;
  }
  
  public final cz gN(long paramLong)
  {
    this.gry = paramLong;
    return this;
  }
  
  public final cz gO(long paramLong)
  {
    this.grz = paramLong;
    return this;
  }
  
  public final cz gP(long paramLong)
  {
    this.grA = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19998;
  }
  
  public final cz oe(String paramString)
  {
    AppMethodBeat.i(208527);
    this.gnO = z("Sessionid", paramString, true);
    AppMethodBeat.o(208527);
    return this;
  }
  
  public final cz of(String paramString)
  {
    AppMethodBeat.i(208529);
    this.gnp = z("Contextid", paramString, true);
    AppMethodBeat.o(208529);
    return this;
  }
  
  public final cz og(String paramString)
  {
    AppMethodBeat.i(208530);
    this.gcV = z("ClickTabContextid", paramString, true);
    AppMethodBeat.o(208530);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cz
 * JD-Core Version:    0.7.0.1
 */
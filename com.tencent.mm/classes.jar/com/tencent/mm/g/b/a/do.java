package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class do
  extends a
{
  private String eiB = "";
  private String eiC = "";
  private String eiD = "";
  private long eiF;
  private String eiG = "";
  private long eiH;
  private long ery;
  
  public final String abV()
  {
    AppMethodBeat.i(209142);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ery);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiH);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209142);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209143);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.eiC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContexId:").append(this.eiD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ery);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventCode:").append(this.eiF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTime:").append(this.eiG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTarget:").append(this.eiH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209143);
    return localObject;
  }
  
  public final int getId()
  {
    return 21923;
  }
  
  public final do km(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final do kn(long paramLong)
  {
    this.eiF = paramLong;
    return this;
  }
  
  public final do ko(long paramLong)
  {
    this.eiH = paramLong;
    return this;
  }
  
  public final do pk(String paramString)
  {
    AppMethodBeat.i(209138);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(209138);
    return this;
  }
  
  public final do pl(String paramString)
  {
    AppMethodBeat.i(209139);
    this.eiC = x("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209139);
    return this;
  }
  
  public final do pm(String paramString)
  {
    AppMethodBeat.i(209140);
    this.eiD = x("FinderContexId", paramString, true);
    AppMethodBeat.o(209140);
    return this;
  }
  
  public final do pn(String paramString)
  {
    AppMethodBeat.i(209141);
    this.eiG = x("EventTime", paramString, true);
    AppMethodBeat.o(209141);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.do
 * JD-Core Version:    0.7.0.1
 */
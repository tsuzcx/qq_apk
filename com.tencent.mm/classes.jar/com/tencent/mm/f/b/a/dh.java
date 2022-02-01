package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dh
  extends a
{
  private long gef;
  private String gjP = "";
  private String gjk = "";
  private long gnD;
  private long gnG;
  private long gtn;
  private long gto;
  private String gtp = "";
  
  public final String agH()
  {
    AppMethodBeat.i(252349);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gto);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtp);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(252349);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(252350);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PageType:").append(this.gnG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTS:").append(this.gnD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Clickid:").append(this.gtn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gto);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.gjP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session_Id:").append(this.gtp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(252350);
    return localObject;
  }
  
  public final String agY()
  {
    return this.gjk;
  }
  
  public final long ahg()
  {
    return this.gnD;
  }
  
  public final long ahh()
  {
    return this.gef;
  }
  
  public final long ahk()
  {
    return this.gnG;
  }
  
  public final long aiT()
  {
    return this.gtn;
  }
  
  public final String aiU()
  {
    return this.gjP;
  }
  
  public final String aiV()
  {
    return this.gtp;
  }
  
  public final int getId()
  {
    return 21631;
  }
  
  public final dh iA(long paramLong)
  {
    this.gnG = paramLong;
    return this;
  }
  
  public final dh iB(long paramLong)
  {
    this.gnD = paramLong;
    return this;
  }
  
  public final dh iC(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final dh pA(String paramString)
  {
    AppMethodBeat.i(252348);
    this.gtp = z("Session_Id", paramString, true);
    AppMethodBeat.o(252348);
    return this;
  }
  
  public final dh py(String paramString)
  {
    AppMethodBeat.i(252346);
    this.gjP = z("ContextID", paramString, true);
    AppMethodBeat.o(252346);
    return this;
  }
  
  public final dh pz(String paramString)
  {
    AppMethodBeat.i(252347);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(252347);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dh
 * JD-Core Version:    0.7.0.1
 */
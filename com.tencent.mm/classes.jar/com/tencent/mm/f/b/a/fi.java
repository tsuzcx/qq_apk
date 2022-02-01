package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fi
  extends a
{
  private String gcU = "";
  private String gjj = "";
  private long gmV;
  private String gnt = "";
  private long gpM;
  
  public final String agH()
  {
    AppMethodBeat.i(184190);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184190);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184191);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.gnt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTime:").append(this.gpM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.gmV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184191);
    return localObject;
  }
  
  public final int getId()
  {
    return 19433;
  }
  
  public final fi nl(long paramLong)
  {
    this.gpM = paramLong;
    return this;
  }
  
  public final fi nm(long paramLong)
  {
    this.gmV = paramLong;
    return this;
  }
  
  public final fi uf(String paramString)
  {
    AppMethodBeat.i(184188);
    this.gnt = z("Action", paramString, true);
    AppMethodBeat.o(184188);
    return this;
  }
  
  public final fi ug(String paramString)
  {
    AppMethodBeat.i(184189);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(184189);
    return this;
  }
  
  public final fi uh(String paramString)
  {
    AppMethodBeat.i(210075);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(210075);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fi
 * JD-Core Version:    0.7.0.1
 */
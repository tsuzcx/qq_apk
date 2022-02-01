package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ak
  extends a
{
  private long ejW;
  private long eoB;
  private String eoC = "";
  private String eoD = "";
  
  public final String abV()
  {
    AppMethodBeat.i(231473);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoD);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(231473);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(231474);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionTimestamp:").append(this.eoB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.eoC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.eoD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(231474);
    return localObject;
  }
  
  public final ak cb(long paramLong)
  {
    this.eoB = paramLong;
    return this;
  }
  
  public final ak cc(long paramLong)
  {
    this.ejW = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21831;
  }
  
  public final ak iq(String paramString)
  {
    AppMethodBeat.i(231471);
    this.eoC = x("SessionID", paramString, true);
    AppMethodBeat.o(231471);
    return this;
  }
  
  public final ak ir(String paramString)
  {
    AppMethodBeat.i(231472);
    this.eoD = x("ContextID", paramString, true);
    AppMethodBeat.o(231472);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ak
 * JD-Core Version:    0.7.0.1
 */
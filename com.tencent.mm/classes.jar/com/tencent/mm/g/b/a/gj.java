package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gj
  extends a
{
  private long eHS;
  private long eJs;
  private long eJt;
  private long ejA;
  private String eoz = "";
  private long erW;
  private long ewu;
  
  public final String abV()
  {
    AppMethodBeat.i(200260);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewu);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(200260);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(200261);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserAction:").append(this.eJs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FullScreen:").append(this.eHS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TaskCount:").append(this.eJt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Duration:").append(this.ewu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(200261);
    return localObject;
  }
  
  public final int getId()
  {
    return 21920;
  }
  
  public final gj qh(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
  
  public final gj qi(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final gj qj(long paramLong)
  {
    this.eJs = paramLong;
    return this;
  }
  
  public final gj qk(long paramLong)
  {
    this.eHS = paramLong;
    return this;
  }
  
  public final gj ql(long paramLong)
  {
    this.eJt = paramLong;
    return this;
  }
  
  public final gj qm(long paramLong)
  {
    this.ewu = paramLong;
    return this;
  }
  
  public final gj tV(String paramString)
  {
    AppMethodBeat.i(200259);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(200259);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gj
 * JD-Core Version:    0.7.0.1
 */
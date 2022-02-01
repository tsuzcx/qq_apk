package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ka
  extends a
{
  private String gMk = "";
  private String gMl = "";
  private long gMm;
  private long gef;
  private long ggS;
  private String ggg = "";
  
  public final ka AW(String paramString)
  {
    AppMethodBeat.i(211455);
    this.gMk = z("FileExt", paramString, true);
    AppMethodBeat.o(211455);
    return this;
  }
  
  public final ka AX(String paramString)
  {
    AppMethodBeat.i(211457);
    this.ggg = z("ChatName", paramString, true);
    AppMethodBeat.o(211457);
    return this;
  }
  
  public final ka AY(String paramString)
  {
    AppMethodBeat.i(211458);
    this.gMl = z("MsgSvrId", paramString, true);
    AppMethodBeat.o(211458);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(211460);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMm);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(211460);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(211462);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileSize:").append(this.ggS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileExt:").append(this.gMk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.gMl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LogVersionlog:").append(this.gMm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211462);
    return localObject;
  }
  
  public final ka amh()
  {
    this.gMm = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 22579;
  }
  
  public final ka uC(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final ka uD(long paramLong)
  {
    this.ggS = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ka
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kq
  extends a
{
  private long gOK;
  private String ggA = "";
  private long gsg;
  
  public final kq BG(String paramString)
  {
    AppMethodBeat.i(217317);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(217317);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(217324);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsg);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(217324);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(217326);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("opType:").append(this.gOK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickType:").append(this.gsg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(217326);
    return localObject;
  }
  
  public final int getId()
  {
    return 21182;
  }
  
  public final kq vi(long paramLong)
  {
    this.gOK = paramLong;
    return this;
  }
  
  public final kq vj(long paramLong)
  {
    this.gsg = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kq
 * JD-Core Version:    0.7.0.1
 */
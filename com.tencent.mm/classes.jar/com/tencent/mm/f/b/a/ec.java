package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ec
  extends a
{
  private long giq;
  private long gqh;
  private String gvN = "";
  private String gvV = "";
  private long gvW;
  
  public final String agH()
  {
    AppMethodBeat.i(209321);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gvV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvW);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209321);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209322);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickId:").append(this.gvV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PostId:").append(this.gvN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.gqh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTab:").append(this.gvW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209322);
    return localObject;
  }
  
  public final int getId()
  {
    return 21149;
  }
  
  public final ec kE(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final ec kF(long paramLong)
  {
    this.gqh = paramLong;
    return this;
  }
  
  public final ec kG(long paramLong)
  {
    this.gvW = paramLong;
    return this;
  }
  
  public final ec rr(String paramString)
  {
    AppMethodBeat.i(209318);
    this.gvV = z("ClickId", paramString, true);
    AppMethodBeat.o(209318);
    return this;
  }
  
  public final ec rs(String paramString)
  {
    AppMethodBeat.i(209319);
    this.gvN = z("PostId", paramString, true);
    AppMethodBeat.o(209319);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ec
 * JD-Core Version:    0.7.0.1
 */
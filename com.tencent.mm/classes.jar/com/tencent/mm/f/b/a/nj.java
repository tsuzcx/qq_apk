package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nj
  extends a
{
  private long gGe;
  private long gYR;
  private String gYS = "";
  private String gYT = "";
  private long gYU;
  private long gYV;
  private String gfm = "";
  private String gfn = "";
  
  public final nj Ek(String paramString)
  {
    AppMethodBeat.i(268437);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(268437);
    return this;
  }
  
  public final nj El(String paramString)
  {
    AppMethodBeat.i(268438);
    this.gfm = z("Appid", paramString, true);
    AppMethodBeat.o(268438);
    return this;
  }
  
  public final nj Em(String paramString)
  {
    AppMethodBeat.i(268439);
    this.gYS = z("EventName", paramString, true);
    AppMethodBeat.o(268439);
    return this;
  }
  
  public final nj En(String paramString)
  {
    AppMethodBeat.i(268440);
    this.gYT = z("Parent", paramString, true);
    AppMethodBeat.o(268440);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(268441);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(268441);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(268442);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.gfm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampInMs:").append(this.gYR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventName:").append(this.gYS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventType:").append(this.gGe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Parent:").append(this.gYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Category:").append(this.gYU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Option:").append(this.gYV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(268442);
    return localObject;
  }
  
  public final int getId()
  {
    return 19175;
  }
  
  public final nj zA(long paramLong)
  {
    this.gGe = paramLong;
    return this;
  }
  
  public final nj zB(long paramLong)
  {
    this.gYU = paramLong;
    return this;
  }
  
  public final nj zC(long paramLong)
  {
    this.gYV = paramLong;
    return this;
  }
  
  public final nj zz(long paramLong)
  {
    this.gYR = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.nj
 * JD-Core Version:    0.7.0.1
 */
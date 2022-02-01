package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nz
  extends a
{
  private String fgl = "";
  private String fgp = "";
  private String fgq = "";
  private long fiN;
  
  public final nz Bh(String paramString)
  {
    AppMethodBeat.i(226125);
    this.fgl = x("session", paramString, true);
    AppMethodBeat.o(226125);
    return this;
  }
  
  public final nz Bi(String paramString)
  {
    AppMethodBeat.i(226126);
    this.fgp = x("weapp_id", paramString, true);
    AppMethodBeat.o(226126);
    return this;
  }
  
  public final nz Bj(String paramString)
  {
    AppMethodBeat.i(226127);
    this.fgq = x("weapp_name", paramString, true);
    AppMethodBeat.o(226127);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(226128);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fgl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgq);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(226128);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(226129);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session:").append(this.fgl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_id:").append(this.fiN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_id:").append(this.fgp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_name:").append(this.fgq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226129);
    return localObject;
  }
  
  public final int getId()
  {
    return 21777;
  }
  
  public final nz yv(long paramLong)
  {
    this.fiN = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nz
 * JD-Core Version:    0.7.0.1
 */
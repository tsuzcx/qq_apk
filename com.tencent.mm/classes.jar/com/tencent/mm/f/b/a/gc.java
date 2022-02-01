package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gc
  extends a
{
  private String gCg = "";
  private String gCh = "";
  private long gCi = 0L;
  private long gCj = 0L;
  private long gCk = 0L;
  private String gCl = "";
  
  public final String agH()
  {
    AppMethodBeat.i(210211);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gCg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCl);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210211);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210212);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppName:").append(this.gCg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PermissionList:").append(this.gCh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemorySize:").append(this.gCi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RamSize:").append(this.gCj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RomSize:").append(this.gCk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpuInfo:").append(this.gCl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210212);
    return localObject;
  }
  
  public final int getId()
  {
    return 21976;
  }
  
  public final gc oP(long paramLong)
  {
    this.gCi = paramLong;
    return this;
  }
  
  public final gc oQ(long paramLong)
  {
    this.gCj = paramLong;
    return this;
  }
  
  public final gc oR(long paramLong)
  {
    this.gCk = paramLong;
    return this;
  }
  
  public final gc vp(String paramString)
  {
    AppMethodBeat.i(210199);
    this.gCg = z("AppName", paramString, true);
    AppMethodBeat.o(210199);
    return this;
  }
  
  public final gc vq(String paramString)
  {
    AppMethodBeat.i(210202);
    this.gCh = z("PermissionList", paramString, true);
    AppMethodBeat.o(210202);
    return this;
  }
  
  public final gc vr(String paramString)
  {
    AppMethodBeat.i(210208);
    this.gCl = z("CpuInfo", paramString, true);
    AppMethodBeat.o(210208);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gc
 * JD-Core Version:    0.7.0.1
 */
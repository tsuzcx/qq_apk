package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class p
  extends a
{
  private int gfb = 0;
  private int gfc = 0;
  private int gfd = 0;
  private int gfe = 0;
  private int gff = 0;
  
  public final String agH()
  {
    AppMethodBeat.i(275846);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gff);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(275846);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(275847);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("memory:").append(this.gfb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSingleProcessStrategy:").append(this.gfc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasAppBrandRunning:").append(this.gfd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningAppBrandCount:").append(this.gfe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maxProcessMemory:").append(this.gff);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(275847);
    return localObject;
  }
  
  public final int getId()
  {
    return 21711;
  }
  
  public final p kZ(int paramInt)
  {
    this.gfb = paramInt;
    return this;
  }
  
  public final p la(int paramInt)
  {
    this.gfc = paramInt;
    return this;
  }
  
  public final p lb(int paramInt)
  {
    this.gfd = paramInt;
    return this;
  }
  
  public final p lc(int paramInt)
  {
    this.gfe = paramInt;
    return this;
  }
  
  public final p ld(int paramInt)
  {
    this.gff = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.p
 * JD-Core Version:    0.7.0.1
 */
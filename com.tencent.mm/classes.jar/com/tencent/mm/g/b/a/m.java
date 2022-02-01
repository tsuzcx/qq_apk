package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class m
  extends a
{
  private int ekA = 0;
  private int ekw = 0;
  private int ekx = 0;
  private int eky = 0;
  private int ekz = 0;
  
  public final String abV()
  {
    AppMethodBeat.i(226035);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eky);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekA);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(226035);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(226036);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("memory:").append(this.ekw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSingleProcessStrategy:").append(this.ekx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasAppBrandRunning:").append(this.eky);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningAppBrandCount:").append(this.ekz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maxProcessMemory:").append(this.ekA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226036);
    return localObject;
  }
  
  public final int getId()
  {
    return 21711;
  }
  
  public final m jF(int paramInt)
  {
    this.ekw = paramInt;
    return this;
  }
  
  public final m jG(int paramInt)
  {
    this.ekx = paramInt;
    return this;
  }
  
  public final m jH(int paramInt)
  {
    this.eky = paramInt;
    return this;
  }
  
  public final m jI(int paramInt)
  {
    this.ekz = paramInt;
    return this;
  }
  
  public final m jJ(int paramInt)
  {
    this.ekA = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.m
 * JD-Core Version:    0.7.0.1
 */
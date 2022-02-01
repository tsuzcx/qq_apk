package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gf
  extends a
{
  private int gCp;
  private int gCq;
  
  public final String agH()
  {
    AppMethodBeat.i(217026);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gCp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCq);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(217026);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(217027);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Status:").append(this.gCp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfGuide:").append(this.gCq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(217027);
    return localObject;
  }
  
  public final int getId()
  {
    return 21765;
  }
  
  public final gf mH(int paramInt)
  {
    this.gCp = paramInt;
    return this;
  }
  
  public final gf mI(int paramInt)
  {
    this.gCq = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gf
 * JD-Core Version:    0.7.0.1
 */
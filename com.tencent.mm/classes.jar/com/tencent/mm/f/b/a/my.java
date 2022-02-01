package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class my
  extends a
{
  private int gWz = 0;
  private int gzf = -1;
  
  public final String agH()
  {
    AppMethodBeat.i(253794);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gWz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzf);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(253794);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(253795);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("configId:").append(this.gWz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.gzf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(253795);
    return localObject;
  }
  
  public final int getId()
  {
    return 20151;
  }
  
  public final my nW(int paramInt)
  {
    this.gWz = paramInt;
    return this;
  }
  
  public final my nX(int paramInt)
  {
    this.gzf = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.my
 * JD-Core Version:    0.7.0.1
 */
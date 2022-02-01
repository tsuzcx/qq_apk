package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gq
  extends a
{
  private int eoV = 0;
  private int eoW = -1;
  
  public final String RD()
  {
    AppMethodBeat.i(210161);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoW);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(210161);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(210162);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("configId:").append(this.eoV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.eoW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210162);
    return localObject;
  }
  
  public final int getId()
  {
    return 20151;
  }
  
  public final gq iL(int paramInt)
  {
    this.eoV = paramInt;
    return this;
  }
  
  public final gq iM(int paramInt)
  {
    this.eoW = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gq
 * JD-Core Version:    0.7.0.1
 */
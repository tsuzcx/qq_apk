package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gs
  extends a
{
  private int eqC = 0;
  private int eqD = -1;
  
  public final String RC()
  {
    AppMethodBeat.i(195801);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqD);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(195801);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(195802);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("configId:").append(this.eqC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.eqD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195802);
    return localObject;
  }
  
  public final int getId()
  {
    return 20151;
  }
  
  public final gs iN(int paramInt)
  {
    this.eqC = paramInt;
    return this;
  }
  
  public final gs iO(int paramInt)
  {
    this.eqD = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gs
 * JD-Core Version:    0.7.0.1
 */
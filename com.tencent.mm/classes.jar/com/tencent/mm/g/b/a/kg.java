package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kg
  extends a
{
  private int eCw = -1;
  private int eUf = 0;
  
  public final String abV()
  {
    AppMethodBeat.i(220221);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eUf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCw);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(220221);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(220222);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("configId:").append(this.eUf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.eCw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220222);
    return localObject;
  }
  
  public final int getId()
  {
    return 20151;
  }
  
  public final kg lN(int paramInt)
  {
    this.eUf = paramInt;
    return this;
  }
  
  public final kg lO(int paramInt)
  {
    this.eCw = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kg
 * JD-Core Version:    0.7.0.1
 */
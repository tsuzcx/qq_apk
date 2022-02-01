package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class et
  extends a
{
  private long gef;
  private long goe;
  
  public final String agH()
  {
    AppMethodBeat.i(209539);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.goe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209539);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209542);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.goe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209542);
    return localObject;
  }
  
  public final int getId()
  {
    return 19952;
  }
  
  public final et mn(long paramLong)
  {
    this.goe = paramLong;
    return this;
  }
  
  public final et mo(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.et
 * JD-Core Version:    0.7.0.1
 */
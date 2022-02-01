package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class br
  extends a
{
  private long etA;
  private String etB = "";
  private String etz = "";
  
  public final String abV()
  {
    AppMethodBeat.i(241579);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etB);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(241579);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(241580);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InnerVersion:").append(this.etz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exceptionType:").append(this.etA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exceptionValue:").append(this.etB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(241580);
    return localObject;
  }
  
  public final br ew(long paramLong)
  {
    this.etA = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20889;
  }
  
  public final br jX(String paramString)
  {
    AppMethodBeat.i(241577);
    this.etz = x("InnerVersion", paramString, true);
    AppMethodBeat.o(241577);
    return this;
  }
  
  public final br jY(String paramString)
  {
    AppMethodBeat.i(241578);
    this.etB = x("exceptionValue", paramString, true);
    AppMethodBeat.o(241578);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.br
 * JD-Core Version:    0.7.0.1
 */
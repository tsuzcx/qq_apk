package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class da
  extends a
{
  private String eiB = "";
  private long ejA;
  private String etW = "";
  
  public final String abV()
  {
    AppMethodBeat.i(184163);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184163);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184164);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.etW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184164);
    return localObject;
  }
  
  public final int getId()
  {
    return 19431;
  }
  
  public final da iG(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
  
  public final da og(String paramString)
  {
    AppMethodBeat.i(184161);
    this.etW = x("Username", paramString, true);
    AppMethodBeat.o(184161);
    return this;
  }
  
  public final da oh(String paramString)
  {
    AppMethodBeat.i(184162);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(184162);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.da
 * JD-Core Version:    0.7.0.1
 */
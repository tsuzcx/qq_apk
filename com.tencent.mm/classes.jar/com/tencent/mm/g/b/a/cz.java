package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cz
  extends a
{
  private String eiB = "";
  private long ejA;
  
  public final String abV()
  {
    AppMethodBeat.i(209082);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209082);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209083);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209083);
    return localObject;
  }
  
  public final int getId()
  {
    return 19954;
  }
  
  public final cz iF(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
  
  public final cz of(String paramString)
  {
    AppMethodBeat.i(209081);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(209081);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cz
 * JD-Core Version:    0.7.0.1
 */
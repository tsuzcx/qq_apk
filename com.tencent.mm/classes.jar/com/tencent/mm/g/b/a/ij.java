package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ij
  extends a
{
  private long eOE;
  private String els = "";
  private long evZ;
  
  public final String abV()
  {
    AppMethodBeat.i(237193);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evZ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(237193);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(237194);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("opType:").append(this.eOE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickType:").append(this.evZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(237194);
    return localObject;
  }
  
  public final int getId()
  {
    return 21182;
  }
  
  public final ij ro(long paramLong)
  {
    this.eOE = paramLong;
    return this;
  }
  
  public final ij rp(long paramLong)
  {
    this.evZ = paramLong;
    return this;
  }
  
  public final ij wh(String paramString)
  {
    AppMethodBeat.i(237192);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(237192);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ij
 * JD-Core Version:    0.7.0.1
 */
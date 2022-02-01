package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oo
  extends a
{
  private long ejA;
  private String eoC = "";
  private String erP = "";
  private long oqH;
  
  public final oo Rh(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
  
  public final oo Ri(long paramLong)
  {
    this.oqH = paramLong;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(258404);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqH);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(258404);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(258405);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.eoC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.erP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.oqH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(258405);
    return localObject;
  }
  
  public final oo bwT(String paramString)
  {
    AppMethodBeat.i(258403);
    this.erP = x("ActionResult", paramString, true);
    AppMethodBeat.o(258403);
    return this;
  }
  
  public final int getId()
  {
    return 22208;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.oo
 * JD-Core Version:    0.7.0.1
 */
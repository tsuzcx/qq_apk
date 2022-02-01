package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class db
  extends a
{
  private String eiB = "";
  private long erY;
  private String euI = "";
  private long eyM;
  private long eyN;
  private long eyO;
  
  public final String abV()
  {
    AppMethodBeat.i(209086);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyO);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209086);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209087);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.erY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOverlap:").append(this.eyM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OverlapCount:").append(this.eyN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.euI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.eyO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209087);
    return localObject;
  }
  
  public final int getId()
  {
    return 19946;
  }
  
  public final db iH(long paramLong)
  {
    this.erY = paramLong;
    return this;
  }
  
  public final db iI(long paramLong)
  {
    this.eyM = paramLong;
    return this;
  }
  
  public final db iJ(long paramLong)
  {
    this.eyN = paramLong;
    return this;
  }
  
  public final db iK(long paramLong)
  {
    this.eyO = paramLong;
    return this;
  }
  
  public final db oi(String paramString)
  {
    AppMethodBeat.i(209084);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(209084);
    return this;
  }
  
  public final db oj(String paramString)
  {
    AppMethodBeat.i(209085);
    this.euI = x("feedid", paramString, true);
    AppMethodBeat.o(209085);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.db
 * JD-Core Version:    0.7.0.1
 */
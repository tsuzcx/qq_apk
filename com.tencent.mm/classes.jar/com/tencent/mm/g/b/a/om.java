package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class om
  extends a
{
  private String eJm = "";
  private long erW;
  private long oqH;
  private long oqI;
  private long oqJ;
  private String oqO = "";
  
  public final om QE(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final om QF(long paramLong)
  {
    this.oqI = paramLong;
    return this;
  }
  
  public final om QG(long paramLong)
  {
    this.oqJ = paramLong;
    return this;
  }
  
  public final om QH(long paramLong)
  {
    this.oqH = paramLong;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(258390);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eJm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqO);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(258390);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(258391);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUsername:").append(this.eJm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasTextStatusIcon:").append(this.oqI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.oqJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.oqH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneExtInfo:").append(this.oqO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(258391);
    return localObject;
  }
  
  public final om bwI(String paramString)
  {
    AppMethodBeat.i(258388);
    this.eJm = x("ToUsername", paramString, true);
    AppMethodBeat.o(258388);
    return this;
  }
  
  public final om bwJ(String paramString)
  {
    AppMethodBeat.i(258389);
    this.oqO = x("SceneExtInfo", paramString, true);
    AppMethodBeat.o(258389);
    return this;
  }
  
  public final int getId()
  {
    return 22210;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.om
 * JD-Core Version:    0.7.0.1
 */
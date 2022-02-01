package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nk
  extends a
{
  private long eCQ = 0L;
  private long eDV = 0L;
  private long fgB;
  public long fgC = 0L;
  public long fgD = 0L;
  private String fgE = "";
  
  public final nk Az(String paramString)
  {
    AppMethodBeat.i(94858);
    this.fgE = x("OpenimUsername", paramString, true);
    AppMethodBeat.o(94858);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(94859);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fgB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgE);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(94859);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(94860);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenimUin:").append(this.fgB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionType:").append(this.fgC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionResult:").append(this.fgD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.eDV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAction:").append(this.eCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenimUsername:").append(this.fgE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94860);
    return localObject;
  }
  
  public final int getId()
  {
    return 18337;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nk
 * JD-Core Version:    0.7.0.1
 */
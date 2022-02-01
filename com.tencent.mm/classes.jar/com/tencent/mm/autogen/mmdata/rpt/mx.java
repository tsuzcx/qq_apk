package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mx
  extends a
{
  private String iAp = "";
  public long iZX = 0L;
  public int jcB = 0;
  public long jcC = 0L;
  public long jcD = 0L;
  private String jcE = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(121781);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jcB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(121781);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(121782);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.jcB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.iAp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.iZX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.jcC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.jcD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.jcE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121782);
    return localObject;
  }
  
  public final int getId()
  {
    return 17193;
  }
  
  public final mx vn(String paramString)
  {
    AppMethodBeat.i(121779);
    this.iAp = F("PName", paramString, true);
    AppMethodBeat.o(121779);
    return this;
  }
  
  public final mx vo(String paramString)
  {
    AppMethodBeat.i(121780);
    this.jcE = F("DataContent", paramString, true);
    AppMethodBeat.o(121780);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mx
 * JD-Core Version:    0.7.0.1
 */
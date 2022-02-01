package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mv
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
    AppMethodBeat.i(121773);
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
    AppMethodBeat.o(121773);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(121774);
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
    AppMethodBeat.o(121774);
    return localObject;
  }
  
  public final int getId()
  {
    return 16976;
  }
  
  public final mv vl(String paramString)
  {
    AppMethodBeat.i(121771);
    this.iAp = F("PName", paramString, true);
    AppMethodBeat.o(121771);
    return this;
  }
  
  public final mv vm(String paramString)
  {
    AppMethodBeat.i(121772);
    this.jcE = F("DataContent", paramString, false);
    AppMethodBeat.o(121772);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mv
 * JD-Core Version:    0.7.0.1
 */
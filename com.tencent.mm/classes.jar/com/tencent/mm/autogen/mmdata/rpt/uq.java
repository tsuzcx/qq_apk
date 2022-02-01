package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class uq
  extends a
{
  public String iKB = "";
  public String inx = "";
  public long iqZ = 0L;
  public long iuA = 0L;
  public String jHI = "";
  public String jHJ = "";
  public long jHK = 0L;
  public String jHL = "";
  public long jHM = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(116496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHM);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(116496);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(116497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.jHI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businesstype:").append(this.iqZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("docid:").append(this.jHJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampInMs:").append(this.jHK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("expand2:").append(this.jHL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.iKB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtype:").append(this.jHM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116497);
    return localObject;
  }
  
  public final int getId()
  {
    return 16033;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.uq
 * JD-Core Version:    0.7.0.1
 */
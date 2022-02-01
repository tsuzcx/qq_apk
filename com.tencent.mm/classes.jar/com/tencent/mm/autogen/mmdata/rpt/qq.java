package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qq
  extends a
{
  public int iYK = -1;
  public int imW = -1;
  public String jsI = "";
  public String jsq = "";
  public int jtp = -1;
  public String jtq = "";
  public int jtr = -1;
  public int jts = -1;
  public int jtt = -1;
  
  public final String aIE()
  {
    AppMethodBeat.i(369254);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jsI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jsq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jts);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtt);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369254);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369260);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.iYK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncodeInfo:").append(this.jtp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginMediaInfo:").append(this.jsI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RemuxInfo:").append(this.jtq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OutputMediaInfo:").append(this.jsq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResultCode:").append(this.jtr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RemuxDuration:").append(this.jts);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ParallelSize:").append(this.jtt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369260);
    return localObject;
  }
  
  public final int getId()
  {
    return 24620;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qq
 * JD-Core Version:    0.7.0.1
 */
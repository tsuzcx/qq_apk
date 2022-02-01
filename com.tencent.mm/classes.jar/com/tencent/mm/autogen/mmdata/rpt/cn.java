package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cn
  extends a
{
  public long ila;
  public String iny = "";
  public String ipW = "";
  public String iqx = "";
  private long ixj;
  public String ixk = "";
  public long ixl;
  
  public final String aIE()
  {
    AppMethodBeat.i(368211);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixl);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368211);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368221);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionts:").append(this.ixj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.iny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.ixk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.iqx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionts_new:").append(this.ixl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368221);
    return localObject;
  }
  
  public final int getId()
  {
    return 23432;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cn
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ls
  extends a
{
  public long iFe;
  public String ipW = "";
  public long jao;
  public String jap = "";
  public String jaq = "";
  public String jar = "";
  public long jas;
  public String jat = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368098);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jao);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jap);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jas);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jat);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368098);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368103);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("reddotCtrlType:").append(this.jao);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("redDotTipsId:").append(this.jap);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportText:").append(this.jaq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("title:").append(this.jar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.iFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("dropReason:").append(this.jas);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showInfoPath:").append(this.jat);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368103);
    return localObject;
  }
  
  public final int getId()
  {
    return 23363;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ls
 * JD-Core Version:    0.7.0.1
 */
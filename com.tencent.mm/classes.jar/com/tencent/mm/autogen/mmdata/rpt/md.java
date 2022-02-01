package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class md
  extends a
{
  public long iLB;
  public long ila;
  public String ipW = "";
  public String jbg = "";
  private int jbh = -1;
  public long jbi;
  public long jbj;
  
  public final String aIE()
  {
    AppMethodBeat.i(368428);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbj);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368428);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368432);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedtype:").append(this.iLB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tousername:").append(this.jbg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is_individual:").append(this.jbh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is_valid:").append(this.jbi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is_vibrate:").append(this.jbj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368432);
    return localObject;
  }
  
  public final int getId()
  {
    return 23612;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.md
 * JD-Core Version:    0.7.0.1
 */
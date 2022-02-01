package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ay
  extends a
{
  public long ila;
  public long ipZ;
  public long iqa;
  public long iqb;
  public long iqc;
  
  public final String aIE()
  {
    AppMethodBeat.i(368979);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqc);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368979);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368984);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("source:").append(this.ipZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("operate_label_cnt:").append(this.iqa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("add_member_cnt:").append(this.iqb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("remove_member_cnt:").append(this.iqc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368984);
    return localObject;
  }
  
  public final int getId()
  {
    return 24176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ay
 * JD-Core Version:    0.7.0.1
 */
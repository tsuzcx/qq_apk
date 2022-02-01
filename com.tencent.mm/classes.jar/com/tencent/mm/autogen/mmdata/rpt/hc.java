package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hc
  extends a
{
  public String iLS = "";
  public long iNf;
  public String iNg = "";
  public long iNh;
  public String inx = "";
  public String iny = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369055);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNh);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369055);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369059);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.iny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_id:").append(this.iLS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_time:").append(this.iNf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("vst_type:").append(this.iNg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("duration:").append(this.iNh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369059);
    return localObject;
  }
  
  public final int getId()
  {
    return 23898;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hc
 * JD-Core Version:    0.7.0.1
 */
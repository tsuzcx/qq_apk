package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ju
  extends a
{
  public String iAN = "";
  public String iGJ = "";
  public int iGK;
  public String iGL = "";
  public String inx = "";
  public String ixw = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368997);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAN);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368997);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369000);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("findercontextid:").append(this.iGJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_code:").append(this.iGK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_time:").append(this.iGL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eid:").append(this.ixw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("udf_kv:").append(this.iAN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369000);
    return localObject;
  }
  
  public final int getId()
  {
    return 22657;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ju
 * JD-Core Version:    0.7.0.1
 */
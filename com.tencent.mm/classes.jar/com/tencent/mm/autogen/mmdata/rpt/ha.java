package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ha
  extends a
{
  public String iAN = "";
  public String iGL = "";
  public String iLQ = "";
  public String iLR = "";
  public String iLS = "";
  public String iLT = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369051);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iLQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAN);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369051);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369056);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("biz_id:").append(this.iLQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("flow_id:").append(this.iLR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_id:").append(this.iLS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_time:").append(this.iGL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderuin:").append(this.iLT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("udf_kv:").append(this.iAN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369056);
    return localObject;
  }
  
  public final int getId()
  {
    return 23462;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ha
 * JD-Core Version:    0.7.0.1
 */
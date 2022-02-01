package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class w
  extends a
{
  public String imd = "";
  public long ime;
  public long imq;
  public long imr;
  public long imv;
  
  public final String aIE()
  {
    AppMethodBeat.i(368506);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ime);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imq);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368506);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.imd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.ime);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("live_duration:").append(this.imv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page_type:").append(this.imr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page:").append(this.imq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368510);
    return localObject;
  }
  
  public final int getId()
  {
    return 21929;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.w
 * JD-Core Version:    0.7.0.1
 */
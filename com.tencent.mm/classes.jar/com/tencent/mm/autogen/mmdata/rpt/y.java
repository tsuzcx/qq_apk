package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class y
  extends a
{
  public long imB;
  public String imC = "";
  public long imD;
  public String imd = "";
  private long imq;
  public long imr;
  public String imu = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imu);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368491);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368499);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.imd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exp_type:").append(this.imB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page_type:").append(this.imr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("conent_list:").append(this.imC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content_status:").append(this.imD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page:").append(this.imq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("icon_appid:").append(this.imu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368499);
    return localObject;
  }
  
  public final int getId()
  {
    return 21930;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.y
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class v
  extends a
{
  public String imd = "";
  public long imq;
  public long imr;
  public long ims;
  public String imt = "";
  public String imu = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368597);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ims);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imu);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368597);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368606);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.imd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page_type:").append(this.imr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page_feed_index:").append(this.ims);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content_id:").append(this.imt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page:").append(this.imq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("icon_appid:").append(this.imu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368606);
    return localObject;
  }
  
  public final int getId()
  {
    return 21931;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.v
 * JD-Core Version:    0.7.0.1
 */
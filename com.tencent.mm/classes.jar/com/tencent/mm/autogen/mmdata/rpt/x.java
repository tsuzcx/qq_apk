package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class x
  extends a
{
  public long imA;
  public String imd = "";
  public long imq;
  public String imt = "";
  public long imv;
  public String imw = "";
  public long imx;
  public long imy;
  public long imz;
  
  public final String aIE()
  {
    AppMethodBeat.i(368488);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imA);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368488);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.imd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.imw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_channel:").append(this.imx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content_type:").append(this.imy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content_id:").append(this.imt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("live_duration:").append(this.imv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page:").append(this.imq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index_from:").append(this.imz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index_to:").append(this.imA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368496);
    return localObject;
  }
  
  public final int getId()
  {
    return 21926;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.x
 * JD-Core Version:    0.7.0.1
 */
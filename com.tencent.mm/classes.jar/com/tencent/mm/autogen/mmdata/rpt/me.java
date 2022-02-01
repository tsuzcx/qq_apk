package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class me
  extends a
{
  public long iLB;
  public long iWQ;
  private long iWR;
  public String ipW = "";
  public long ixD;
  public String jbg = "";
  public long jbj;
  public long jbk;
  private long jbl;
  private long jbm;
  public long jbn;
  public long jbo;
  public int jbp;
  
  public final String aIE()
  {
    AppMethodBeat.i(368429);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iWQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbj);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368429);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368434);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.iWQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomkey:").append(this.iWR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedtype:").append(this.iLB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is_individual:").append(this.jbk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tousername:").append(this.jbg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.ixD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("playScene:").append(this.jbl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is_callkit:").append(this.jbm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("playDuration:").append(this.jbn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("room_key:").append(this.jbo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is_mute:").append(this.jbp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is_vibrate:").append(this.jbj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368434);
    return localObject;
  }
  
  public final int getId()
  {
    return 23613;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.me
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mg
  extends a
{
  public long ixD;
  public long jbn;
  public int jbq;
  public long jbr;
  public String jbs = "";
  public long jbt;
  public long jbu;
  public String jbv = "";
  public long jbw;
  
  public final String aIE()
  {
    AppMethodBeat.i(368388);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbn);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368388);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368392);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("type:").append(this.ixD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomId:").append(this.jbq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomKey:").append(this.jbr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedId:").append(this.jbs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedType:").append(this.jbt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isIndividual:").append(this.jbu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toUserName:").append(this.jbv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("logoClick:").append(this.jbw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("playDuration:").append(this.jbn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368392);
    return localObject;
  }
  
  public final int getId()
  {
    return 23653;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mg
 * JD-Core Version:    0.7.0.1
 */
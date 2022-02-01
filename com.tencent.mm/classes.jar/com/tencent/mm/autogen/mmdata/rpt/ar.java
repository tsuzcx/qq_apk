package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ar
  extends a
{
  public String ikb = "";
  public String iph = "";
  public int ipk = 0;
  public long ipl = 0L;
  public long ipm = 0L;
  public long ipn = 0L;
  private long ipo = 0L;
  public long ipp = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(121747);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iph);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikb);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(121747);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(121748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.iph);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomMute:").append(this.ipk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCount:").append(this.ipl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisRedDotCount:").append(this.ipm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterCount:").append(this.ipn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.ipo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendCount:").append(this.ipp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Score:").append(this.ikb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121748);
    return localObject;
  }
  
  public final ar eu(long paramLong)
  {
    AppMethodBeat.i(121746);
    this.ipo = paramLong;
    super.bw("StayTimeMs", this.ipo);
    AppMethodBeat.o(121746);
    return this;
  }
  
  public final int getId()
  {
    return 15460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ar
 * JD-Core Version:    0.7.0.1
 */
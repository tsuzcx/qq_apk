package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class tz
  extends a
{
  private long jFo = 0L;
  public int jFp = -1;
  private long jFq = 0L;
  private String jFr = "";
  private int jFs = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(368234);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFs);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368234);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368243);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("host_id:").append(this.jFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("steam_type:").append(this.jFp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("room_id:").append(this.jFq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stream_id:").append(this.jFr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stream_duration:").append(this.jFs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368243);
    return localObject;
  }
  
  public final int getId()
  {
    return 22049;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tz
 * JD-Core Version:    0.7.0.1
 */
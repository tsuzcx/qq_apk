package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class r
  extends a
{
  public String ekH = "";
  public String ekT = "";
  public long ekU;
  public String ekV = "";
  public long ekW;
  public long ekX;
  
  public final String abV()
  {
    AppMethodBeat.i(238095);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekU);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(238095);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(238096);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.ekH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.ekV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_channel:").append(this.ekW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content_type:").append(this.ekX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content_id:").append(this.ekT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("live_duration:").append(this.ekU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(238096);
    return localObject;
  }
  
  public final int getId()
  {
    return 21926;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.r
 * JD-Core Version:    0.7.0.1
 */
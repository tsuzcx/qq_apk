package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class v
  extends a
{
  public long gfL;
  public String gfO = "";
  public long gfP;
  public String gfQ = "";
  public long gfR;
  public long gfS;
  public long gfT;
  public long gfU;
  public String gfz = "";
  
  public final String agH()
  {
    AppMethodBeat.i(214768);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfU);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(214768);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(214769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.gfz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.gfQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_channel:").append(this.gfR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content_type:").append(this.gfS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content_id:").append(this.gfO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("live_duration:").append(this.gfP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page:").append(this.gfL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index_from:").append(this.gfT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index_to:").append(this.gfU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(214769);
    return localObject;
  }
  
  public final int getId()
  {
    return 21926;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.v
 * JD-Core Version:    0.7.0.1
 */
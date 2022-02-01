package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class u
  extends a
{
  public long gfA;
  public long gfL;
  public long gfM;
  public long gfP;
  public String gfz = "";
  
  public final String agH()
  {
    AppMethodBeat.i(214163);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfL);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(214163);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(214164);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.gfz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.gfA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("live_duration:").append(this.gfP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page_type:").append(this.gfM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page:").append(this.gfL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(214164);
    return localObject;
  }
  
  public final int getId()
  {
    return 21929;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.u
 * JD-Core Version:    0.7.0.1
 */
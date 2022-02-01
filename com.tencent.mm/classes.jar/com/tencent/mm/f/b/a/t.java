package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class t
  extends a
{
  public long gfL;
  public long gfM;
  public long gfN;
  public String gfO = "";
  public String gfz = "";
  
  public final String agH()
  {
    AppMethodBeat.i(214737);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfL);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(214737);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(214739);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.gfz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page_type:").append(this.gfM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page_feed_index:").append(this.gfN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content_id:").append(this.gfO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page:").append(this.gfL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(214739);
    return localObject;
  }
  
  public final int getId()
  {
    return 21931;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.t
 * JD-Core Version:    0.7.0.1
 */
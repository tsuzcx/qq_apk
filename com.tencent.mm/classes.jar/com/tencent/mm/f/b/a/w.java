package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class w
  extends a
{
  private long gfL;
  public long gfM;
  public long gfV;
  public String gfW = "";
  public long gfX;
  public String gfz = "";
  
  public final String agH()
  {
    AppMethodBeat.i(215589);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfL);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(215589);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(215590);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.gfz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exp_type:").append(this.gfV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page_type:").append(this.gfM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("conent_list:").append(this.gfW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content_status:").append(this.gfX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page:").append(this.gfL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215590);
    return localObject;
  }
  
  public final int getId()
  {
    return 21930;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.w
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class p
  extends a
{
  public String ekH = "";
  public long ekR;
  public long ekS;
  public String ekT = "";
  
  public final String abV()
  {
    AppMethodBeat.i(238091);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekT);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(238091);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(238092);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.ekH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page_type:").append(this.ekR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page_feed_index:").append(this.ekS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content_id:").append(this.ekT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(238092);
    return localObject;
  }
  
  public final int getId()
  {
    return 21931;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.p
 * JD-Core Version:    0.7.0.1
 */
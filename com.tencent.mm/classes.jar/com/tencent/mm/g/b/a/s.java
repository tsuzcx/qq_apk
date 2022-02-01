package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class s
  extends a
{
  public String ekH = "";
  public long ekR;
  public long ekY;
  public String ekZ = "";
  
  public final String abV()
  {
    AppMethodBeat.i(238097);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekZ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(238097);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(238098);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.ekH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exp_type:").append(this.ekY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page_type:").append(this.ekR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("conent_list:").append(this.ekZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(238098);
    return localObject;
  }
  
  public final int getId()
  {
    return 21930;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.s
 * JD-Core Version:    0.7.0.1
 */
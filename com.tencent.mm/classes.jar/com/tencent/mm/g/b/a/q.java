package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class q
  extends a
{
  public String ekH = "";
  public long ekI;
  public long ekU;
  
  public final String abV()
  {
    AppMethodBeat.i(238093);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekU);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(238093);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(238094);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.ekH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.ekI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("live_duration:").append(this.ekU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(238094);
    return localObject;
  }
  
  public final int getId()
  {
    return 21929;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.q
 * JD-Core Version:    0.7.0.1
 */
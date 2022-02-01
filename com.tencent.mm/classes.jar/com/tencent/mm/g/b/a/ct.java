package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ct
  extends a
{
  public long dHR = 0L;
  private String dRi = "";
  
  public final String PR()
  {
    AppMethodBeat.i(149913);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHR);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149913);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("chatRoomUserName:").append(this.dRi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149914);
    return localObject;
  }
  
  public final int getId()
  {
    return 15848;
  }
  
  public final ct kP(String paramString)
  {
    AppMethodBeat.i(149912);
    this.dRi = t("chatRoomUserName", paramString, true);
    AppMethodBeat.o(149912);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ct
 * JD-Core Version:    0.7.0.1
 */
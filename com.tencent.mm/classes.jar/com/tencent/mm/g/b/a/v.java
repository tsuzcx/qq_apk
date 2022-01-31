package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class v
  extends a
{
  private String cTD = "";
  public long cTE = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(77588);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cTD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTE);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(77588);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(77589);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("chatRoomUserName:").append(this.cTD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.cTE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(77589);
    return localObject;
  }
  
  public final v fq(String paramString)
  {
    AppMethodBeat.i(77587);
    this.cTD = t("chatRoomUserName", paramString, true);
    AppMethodBeat.o(77587);
    return this;
  }
  
  public final int getId()
  {
    return 15848;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.v
 * JD-Core Version:    0.7.0.1
 */
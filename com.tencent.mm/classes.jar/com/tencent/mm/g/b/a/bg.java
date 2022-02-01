package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bg
  extends a
{
  public long dKc = 0L;
  private String dPr = "";
  
  public final String PV()
  {
    AppMethodBeat.i(149913);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKc);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149913);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("chatRoomUserName:").append(this.dPr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149914);
    return localObject;
  }
  
  public final int getId()
  {
    return 15848;
  }
  
  public final bg hZ(String paramString)
  {
    AppMethodBeat.i(149912);
    this.dPr = t("chatRoomUserName", paramString, true);
    AppMethodBeat.o(149912);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bg
 * JD-Core Version:    0.7.0.1
 */
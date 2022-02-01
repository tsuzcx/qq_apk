package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class do
  extends a
{
  public long dWm = 0L;
  private String eip = "";
  
  public final String RC()
  {
    AppMethodBeat.i(149913);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eip);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWm);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149913);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("chatRoomUserName:").append(this.eip);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149914);
    return localObject;
  }
  
  public final int getId()
  {
    return 15848;
  }
  
  public final do nl(String paramString)
  {
    AppMethodBeat.i(149912);
    this.eip = t("chatRoomUserName", paramString, true);
    AppMethodBeat.o(149912);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.do
 * JD-Core Version:    0.7.0.1
 */
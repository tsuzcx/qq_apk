package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gq
  extends a
{
  private String eKK = "";
  public long erw = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(149913);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eKK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erw);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149913);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("chatRoomUserName:").append(this.eKK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149914);
    return localObject;
  }
  
  public final int getId()
  {
    return 15848;
  }
  
  public final gq us(String paramString)
  {
    AppMethodBeat.i(149912);
    this.eKK = x("chatRoomUserName", paramString, true);
    AppMethodBeat.o(149912);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gq
 * JD-Core Version:    0.7.0.1
 */
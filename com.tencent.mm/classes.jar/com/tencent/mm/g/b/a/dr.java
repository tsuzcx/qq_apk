package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dr
  extends a
{
  public long dQX;
  private String eiA = "";
  private String eiz = "";
  
  public final String RC()
  {
    AppMethodBeat.i(217085);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(217085);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(217086);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomID:").append(this.eiz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldRoomID:").append(this.eiA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(217086);
    return localObject;
  }
  
  public final int getId()
  {
    return 20246;
  }
  
  public final dr np(String paramString)
  {
    AppMethodBeat.i(217083);
    this.eiz = t("roomID", paramString, true);
    AppMethodBeat.o(217083);
    return this;
  }
  
  public final dr nq(String paramString)
  {
    AppMethodBeat.i(217084);
    this.eiA = t("oldRoomID", paramString, true);
    AppMethodBeat.o(217084);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dr
 * JD-Core Version:    0.7.0.1
 */
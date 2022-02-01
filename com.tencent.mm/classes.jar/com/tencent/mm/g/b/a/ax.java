package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ax
  extends a
{
  public int eqL = -1;
  public int eqM = -1;
  public int eqN = -1;
  private String eqO = "";
  
  public final String abV()
  {
    AppMethodBeat.i(186348);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqO);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(186348);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(186349);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EventType:").append(this.eqL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FaceType:").append(this.eqM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.eqN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorMsg:").append(this.eqO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186349);
    return localObject;
  }
  
  public final int getId()
  {
    return 21597;
  }
  
  public final ax iC(String paramString)
  {
    AppMethodBeat.i(186347);
    this.eqO = x("ErrorMsg", paramString, true);
    AppMethodBeat.o(186347);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ax
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gn
  extends a
{
  public int eJR;
  private String eJS = "";
  
  public final String abV()
  {
    AppMethodBeat.i(231488);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eJR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJS);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(231488);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(231489);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.eJR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VoiceID:").append(this.eJS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(231489);
    return localObject;
  }
  
  public final int getId()
  {
    return 20551;
  }
  
  public final gn up(String paramString)
  {
    AppMethodBeat.i(231487);
    this.eJS = x("VoiceID", paramString, true);
    AppMethodBeat.o(231487);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gn
 * JD-Core Version:    0.7.0.1
 */
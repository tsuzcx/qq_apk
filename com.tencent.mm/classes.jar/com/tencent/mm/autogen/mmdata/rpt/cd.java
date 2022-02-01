package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cd
  extends a
{
  public int inj = -1;
  public int ivj = -1;
  public int ivk = -1;
  private String ivl = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368270);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ivj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivl);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368270);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368274);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EventType:").append(this.ivj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FaceType:").append(this.ivk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.inj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorMsg:").append(this.ivl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368274);
    return localObject;
  }
  
  public final int getId()
  {
    return 21597;
  }
  
  public final cd lr(String paramString)
  {
    AppMethodBeat.i(368263);
    this.ivl = F("ErrorMsg", paramString, true);
    AppMethodBeat.o(368263);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cd
 * JD-Core Version:    0.7.0.1
 */
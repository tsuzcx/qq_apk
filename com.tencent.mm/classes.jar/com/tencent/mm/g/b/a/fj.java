package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fj
  extends a
{
  private String dRB;
  private String ekP;
  public long ekQ = 0L;
  private String ekU;
  public long eld = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(110289);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eld);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekU);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(110289);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(110290);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.ekP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.ekQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reason:").append(this.eld);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.ekU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110290);
    return localObject;
  }
  
  public final int getId()
  {
    return 18252;
  }
  
  public final fj ot(String paramString)
  {
    AppMethodBeat.i(110286);
    this.dRB = t("ChatName", paramString, true);
    AppMethodBeat.o(110286);
    return this;
  }
  
  public final fj ou(String paramString)
  {
    AppMethodBeat.i(110287);
    this.ekP = t("LaunchUserName", paramString, true);
    AppMethodBeat.o(110287);
    return this;
  }
  
  public final fj ov(String paramString)
  {
    AppMethodBeat.i(110288);
    this.ekU = t("Identifier", paramString, true);
    AppMethodBeat.o(110288);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fj
 * JD-Core Version:    0.7.0.1
 */
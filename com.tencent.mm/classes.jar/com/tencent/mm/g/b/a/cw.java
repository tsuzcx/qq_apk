package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cw
  extends a
{
  private String dGR;
  private String dSJ;
  public long dSK = 0L;
  private String dSO;
  public long dSX = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(110289);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dGR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSO);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(110289);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(110290);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dGR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.dSJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.dSK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reason:").append(this.dSX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.dSO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110290);
    return localObject;
  }
  
  public final int getId()
  {
    return 18252;
  }
  
  public final cw jq(String paramString)
  {
    AppMethodBeat.i(110286);
    this.dGR = t("ChatName", paramString, true);
    AppMethodBeat.o(110286);
    return this;
  }
  
  public final cw jr(String paramString)
  {
    AppMethodBeat.i(110287);
    this.dSJ = t("LaunchUserName", paramString, true);
    AppMethodBeat.o(110287);
    return this;
  }
  
  public final cw js(String paramString)
  {
    AppMethodBeat.i(110288);
    this.dSO = t("Identifier", paramString, true);
    AppMethodBeat.o(110288);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cw
 * JD-Core Version:    0.7.0.1
 */
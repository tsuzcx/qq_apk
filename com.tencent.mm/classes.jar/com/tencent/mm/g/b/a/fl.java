package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fl
  extends a
{
  private String dSR = "";
  private String emB = "";
  public long emK = 0L;
  private String emw = "";
  public long emx = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(110289);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emB);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(110289);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(110290);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.emw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.emx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reason:").append(this.emK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.emB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110290);
    return localObject;
  }
  
  public final int getId()
  {
    return 18252;
  }
  
  public final fl oO(String paramString)
  {
    AppMethodBeat.i(110286);
    this.dSR = t("ChatName", paramString, true);
    AppMethodBeat.o(110286);
    return this;
  }
  
  public final fl oP(String paramString)
  {
    AppMethodBeat.i(110287);
    this.emw = t("LaunchUserName", paramString, true);
    AppMethodBeat.o(110287);
    return this;
  }
  
  public final fl oQ(String paramString)
  {
    AppMethodBeat.i(110288);
    this.emB = t("Identifier", paramString, true);
    AppMethodBeat.o(110288);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fl
 * JD-Core Version:    0.7.0.1
 */
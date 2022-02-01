package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class os
  extends a
{
  private String ijk = "";
  public int jjY = 0;
  public int jjZ = 0;
  public int jka = 0;
  public int jkb = 0;
  private String jkc = "";
  public int jkd = 0;
  public int jke = 0;
  public String jkf = "";
  public long jkg = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(118493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jka);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jke);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkg);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118493);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.jjY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeOrder:").append(this.jjZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinCount:").append(this.jka);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewFavorUinCount:").append(this.jkb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinList:").append(this.jkc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinCount:").append(this.jkd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeFavorUinCount:").append(this.jke);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinList:").append(this.jkf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.jkg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118494);
    return localObject;
  }
  
  public final int getId()
  {
    return 16887;
  }
  
  public final os ww(String paramString)
  {
    AppMethodBeat.i(118490);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(118490);
    return this;
  }
  
  public final os wx(String paramString)
  {
    AppMethodBeat.i(118491);
    this.jkc = F("ExposeNewUinList", paramString, true);
    AppMethodBeat.o(118491);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.os
 * JD-Core Version:    0.7.0.1
 */
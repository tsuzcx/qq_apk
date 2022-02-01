package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class q
  extends a
{
  public long dFP;
  public long dFQ;
  public long dFR;
  public long dFS;
  public long dFT;
  public long dFU;
  public long dFV;
  public long dFW;
  private String dFX;
  public String dFY;
  public long dFZ;
  public String dFe;
  
  public final String PR()
  {
    AppMethodBeat.i(194877);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFZ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194877);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194878);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReddotFlag:").append(this.dFP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.dFQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocationPermission:").append(this.dFR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FollowInitPosition:").append(this.dFS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendInitPosition:").append(this.dFT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LBSInitPosition:").append(this.dFU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HotInitPosition:").append(this.dFV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTab:").append(this.dFW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterRedDotId:").append(this.dFX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dFY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoRefresh:").append(this.dFZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194878);
    return localObject;
  }
  
  public final q fM(String paramString)
  {
    AppMethodBeat.i(194876);
    this.dFX = t("EnterRedDotId", paramString, true);
    AppMethodBeat.o(194876);
    return this;
  }
  
  public final int getId()
  {
    return 19025;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.q
 * JD-Core Version:    0.7.0.1
 */
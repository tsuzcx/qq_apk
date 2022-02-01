package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hd
  extends a
{
  public long bYv;
  public long bqc;
  public long cCZ;
  public long cHV;
  public long cMW;
  public long cUC;
  public long cgU;
  public String dHr;
  public long dKV;
  public String dLe;
  private String deD;
  public long deN;
  
  public final String PV()
  {
    AppMethodBeat.i(203661);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.bqc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.bYv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cCZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cHV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cMW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deN);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203661);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203662);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReddotFlag:").append(this.bqc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.dKV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocationPermission:").append(this.bYv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FollowInitPosition:").append(this.cgU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendInitPosition:").append(this.cCZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LBSInitPosition:").append(this.cHV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HotInitPosition:").append(this.cMW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTab:").append(this.cUC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterRedDotId:").append(this.deD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoRefresh:").append(this.deN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203662);
    return localObject;
  }
  
  public final int getId()
  {
    return 19025;
  }
  
  public final hd xR(String paramString)
  {
    AppMethodBeat.i(203660);
    this.deD = t("EnterRedDotId", paramString, true);
    AppMethodBeat.o(203660);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hd
 * JD-Core Version:    0.7.0.1
 */
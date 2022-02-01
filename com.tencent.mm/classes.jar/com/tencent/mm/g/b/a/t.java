package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class t
  extends a
{
  public long dSU;
  public long dSV;
  public long dSW;
  public long dSX;
  public long dSY;
  public long dSZ;
  public String dSb;
  public long dTa;
  public long dTb;
  private String dTc;
  public String dTd;
  public long dTe;
  
  public final String RD()
  {
    AppMethodBeat.i(209031);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTe);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209031);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209032);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReddotFlag:").append(this.dSU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.dSV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocationPermission:").append(this.dSW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FollowInitPosition:").append(this.dSX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendInitPosition:").append(this.dSY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LBSInitPosition:").append(this.dSZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HotInitPosition:").append(this.dTa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTab:").append(this.dTb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterRedDotId:").append(this.dTc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoRefresh:").append(this.dTe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209032);
    return localObject;
  }
  
  public final t gO(String paramString)
  {
    AppMethodBeat.i(209030);
    this.dTc = t("EnterRedDotId", paramString, true);
    AppMethodBeat.o(209030);
    return this;
  }
  
  public final int getId()
  {
    return 19025;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.t
 * JD-Core Version:    0.7.0.1
 */
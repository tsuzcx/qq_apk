package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bd
  extends a
{
  public String ijk = "";
  public String ipT = "";
  public long iqD;
  public long iqE;
  public long iqF;
  public long iqG;
  public long iqH;
  public long iqI;
  public long iqJ;
  public long iqK;
  private String iqL = "";
  public long iqM;
  
  public final String aIE()
  {
    AppMethodBeat.i(368918);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqM);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368918);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368929);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReddotFlag:").append(this.iqD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.iqE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocationPermission:").append(this.iqF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FollowInitPosition:").append(this.iqG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendInitPosition:").append(this.iqH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LBSInitPosition:").append(this.iqI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HotInitPosition:").append(this.iqJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTab:").append(this.iqK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterRedDotId:").append(this.iqL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoRefresh:").append(this.iqM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368929);
    return localObject;
  }
  
  public final int getId()
  {
    return 19025;
  }
  
  public final bd kW(String paramString)
  {
    AppMethodBeat.i(368912);
    this.iqL = F("EnterRedDotId", paramString, true);
    AppMethodBeat.o(368912);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bd
 * JD-Core Version:    0.7.0.1
 */
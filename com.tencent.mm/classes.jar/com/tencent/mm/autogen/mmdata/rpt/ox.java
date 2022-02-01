package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ox
  extends a
{
  public String ijk = "";
  public String itP = "";
  public long itb = 0L;
  public long iuE = 0L;
  private String jjQ = "";
  public long jjR = 0L;
  public long jjn = 0L;
  public long jjo = 0L;
  public long jkC = 0L;
  public long jkD = 0L;
  public long jkE = 0L;
  public long jkF = 0L;
  public long jkG = 0L;
  public long jkH = 0L;
  public long jkI = 0L;
  public long jkJ = 0L;
  public long jkK = 0L;
  public long jkL = 0L;
  public long jkM = 0L;
  private long jkN = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(118508);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.itb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.itP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkN);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118508);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.itb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.jjn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.jkC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUserName:").append(this.jjQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceContactType:").append(this.jjR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.jjo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.iuE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTime:").append(this.jkD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalUserNameCount:").append(this.jkE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendUserNameCount:").append(this.jkF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalStoryCount:").append(this.jkG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendStoryCount:").append(this.jkH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalBrowserCount:").append(this.jkI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendBrowserCount:").append(this.jkJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTrace:").append(this.itP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllVideoBrowserCountWithRepeat:").append(this.jkK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayFriendCount:").append(this.jkL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsShowComment:").append(this.jkM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsInformComment:").append(this.jkN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118509);
    return localObject;
  }
  
  public final int getId()
  {
    return 16658;
  }
  
  public final ox wA(String paramString)
  {
    AppMethodBeat.i(118507);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(118507);
    return this;
  }
  
  public final ox wz(String paramString)
  {
    AppMethodBeat.i(118505);
    this.jjQ = F("SourceUserName", paramString, false);
    AppMethodBeat.o(118505);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ox
 * JD-Core Version:    0.7.0.1
 */
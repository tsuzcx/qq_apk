package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dl
  extends a
{
  private long dFO = 0L;
  private String dHr = "";
  private String dJk = "";
  private long dJw = 0L;
  private String dTG = "";
  public long dTH = 0L;
  public long dTd = 0L;
  public long dTe = 0L;
  private long dUA = 0L;
  private long dUB = 0L;
  private long dUC = 0L;
  private long dUD = 0L;
  public long dUE = 0L;
  private long dUF = 0L;
  private long dUG = 0L;
  public long dUv = 0L;
  private long dUw = 0L;
  private long dUx = 0L;
  private long dUy = 0L;
  private long dUz = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(118508);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUG);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118508);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.dFO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.dUv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUserName:").append(this.dTG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceContactType:").append(this.dTH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.dTe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.dJw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTime:").append(this.dUw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalUserNameCount:").append(this.dUx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendUserNameCount:").append(this.dUy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalStoryCount:").append(this.dUz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendStoryCount:").append(this.dUA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalBrowserCount:").append(this.dUB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendBrowserCount:").append(this.dUC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTrace:").append(this.dJk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllVideoBrowserCountWithRepeat:").append(this.dUD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayFriendCount:").append(this.dUE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsShowComment:").append(this.dUF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsInformComment:").append(this.dUG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118509);
    return localObject;
  }
  
  public final long QR()
  {
    return this.dFO;
  }
  
  public final long QS()
  {
    return this.dTd;
  }
  
  public final long QT()
  {
    return this.dUv;
  }
  
  public final long QU()
  {
    return this.dJw;
  }
  
  public final long QV()
  {
    return this.dUx;
  }
  
  public final long QW()
  {
    return this.dUy;
  }
  
  public final long QX()
  {
    return this.dUz;
  }
  
  public final long QY()
  {
    return this.dUA;
  }
  
  public final long QZ()
  {
    return this.dUB;
  }
  
  public final long Ra()
  {
    return this.dUC;
  }
  
  public final long Rb()
  {
    return this.dUD;
  }
  
  public final dl fY(long paramLong)
  {
    this.dFO = paramLong;
    return this;
  }
  
  public final dl fZ(long paramLong)
  {
    this.dTd = paramLong;
    return this;
  }
  
  public final dl ga(long paramLong)
  {
    this.dTe = paramLong;
    return this;
  }
  
  public final dl gb(long paramLong)
  {
    this.dJw = paramLong;
    return this;
  }
  
  public final dl gc(long paramLong)
  {
    this.dUw = paramLong;
    return this;
  }
  
  public final dl gd(long paramLong)
  {
    this.dUx = paramLong;
    return this;
  }
  
  public final dl ge(long paramLong)
  {
    this.dUy = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16658;
  }
  
  public final String getSessionId()
  {
    return this.dHr;
  }
  
  public final dl gf(long paramLong)
  {
    this.dUz = paramLong;
    return this;
  }
  
  public final dl gg(long paramLong)
  {
    this.dUA = paramLong;
    return this;
  }
  
  public final dl gh(long paramLong)
  {
    this.dUB = paramLong;
    return this;
  }
  
  public final dl gi(long paramLong)
  {
    this.dUC = paramLong;
    return this;
  }
  
  public final dl gj(long paramLong)
  {
    this.dUD = paramLong;
    return this;
  }
  
  public final dl gk(long paramLong)
  {
    this.dUE = paramLong;
    return this;
  }
  
  public final dl gl(long paramLong)
  {
    this.dUF = paramLong;
    return this;
  }
  
  public final dl jL(String paramString)
  {
    AppMethodBeat.i(118505);
    this.dTG = t("SourceUserName", paramString, false);
    AppMethodBeat.o(118505);
    return this;
  }
  
  public final dl jM(String paramString)
  {
    AppMethodBeat.i(118506);
    this.dJk = t("ActionTrace", paramString, true);
    AppMethodBeat.o(118506);
    return this;
  }
  
  public final dl jN(String paramString)
  {
    AppMethodBeat.i(118507);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(118507);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dl
 * JD-Core Version:    0.7.0.1
 */
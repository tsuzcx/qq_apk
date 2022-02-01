package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ga
  extends a
{
  private long dRO = 0L;
  private String dTr = "";
  private String dVH = "";
  private long dVR = 0L;
  public long emO = 0L;
  public long emP = 0L;
  private String ens = "";
  public long ent = 0L;
  public long eog = 0L;
  private long eoh = 0L;
  private long eoi = 0L;
  private long eoj = 0L;
  private long eok = 0L;
  private long eol = 0L;
  private long eom = 0L;
  private long eon = 0L;
  private long eoo = 0L;
  public long eop = 0L;
  private long eoq = 0L;
  private long eor = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(118508);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eog);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ens);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ent);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eok);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eol);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eom);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eon);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eop);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eor);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118508);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.dRO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.emO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.eog);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUserName:").append(this.ens);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceContactType:").append(this.ent);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.emP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.dVR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTime:").append(this.eoh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalUserNameCount:").append(this.eoi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendUserNameCount:").append(this.eoj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalStoryCount:").append(this.eok);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendStoryCount:").append(this.eol);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalBrowserCount:").append(this.eom);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendBrowserCount:").append(this.eon);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTrace:").append(this.dVH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllVideoBrowserCountWithRepeat:").append(this.eoo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayFriendCount:").append(this.eop);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsShowComment:").append(this.eoq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsInformComment:").append(this.eor);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118509);
    return localObject;
  }
  
  public final long TG()
  {
    return this.dRO;
  }
  
  public final long TH()
  {
    return this.emO;
  }
  
  public final long TI()
  {
    return this.eog;
  }
  
  public final long TJ()
  {
    return this.dVR;
  }
  
  public final long TK()
  {
    return this.eoi;
  }
  
  public final long TL()
  {
    return this.eoj;
  }
  
  public final long TM()
  {
    return this.eok;
  }
  
  public final long TN()
  {
    return this.eol;
  }
  
  public final long TO()
  {
    return this.eom;
  }
  
  public final long TP()
  {
    return this.eon;
  }
  
  public final long TQ()
  {
    return this.eoo;
  }
  
  public final int getId()
  {
    return 16658;
  }
  
  public final String getSessionId()
  {
    return this.dTr;
  }
  
  public final ga li(long paramLong)
  {
    this.dRO = paramLong;
    return this;
  }
  
  public final ga lj(long paramLong)
  {
    this.emO = paramLong;
    return this;
  }
  
  public final ga lk(long paramLong)
  {
    this.emP = paramLong;
    return this;
  }
  
  public final ga ll(long paramLong)
  {
    this.dVR = paramLong;
    return this;
  }
  
  public final ga lm(long paramLong)
  {
    this.eoh = paramLong;
    return this;
  }
  
  public final ga ln(long paramLong)
  {
    this.eoi = paramLong;
    return this;
  }
  
  public final ga lo(long paramLong)
  {
    this.eoj = paramLong;
    return this;
  }
  
  public final ga lp(long paramLong)
  {
    this.eok = paramLong;
    return this;
  }
  
  public final ga lq(long paramLong)
  {
    this.eol = paramLong;
    return this;
  }
  
  public final ga lr(long paramLong)
  {
    this.eom = paramLong;
    return this;
  }
  
  public final ga ls(long paramLong)
  {
    this.eon = paramLong;
    return this;
  }
  
  public final ga lt(long paramLong)
  {
    this.eoo = paramLong;
    return this;
  }
  
  public final ga lu(long paramLong)
  {
    this.eop = paramLong;
    return this;
  }
  
  public final ga lv(long paramLong)
  {
    this.eoq = paramLong;
    return this;
  }
  
  public final ga pj(String paramString)
  {
    AppMethodBeat.i(118505);
    this.ens = t("SourceUserName", paramString, false);
    AppMethodBeat.o(118505);
    return this;
  }
  
  public final ga pk(String paramString)
  {
    AppMethodBeat.i(118506);
    this.dVH = t("ActionTrace", paramString, true);
    AppMethodBeat.o(118506);
    return this;
  }
  
  public final ga pl(String paramString)
  {
    AppMethodBeat.i(118507);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(118507);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ga
 * JD-Core Version:    0.7.0.1
 */
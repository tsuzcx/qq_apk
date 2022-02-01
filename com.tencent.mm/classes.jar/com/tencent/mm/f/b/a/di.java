package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class di
  extends a
{
  private String ggB = "";
  private long giq;
  private String gjk = "";
  private long gnC;
  private String gnH = "";
  private String gnI = "";
  private String gnV = "";
  private String gpT = "";
  private String gpX = "";
  private long gpY;
  private String gpZ = "";
  private String gsx = "";
  private String gtq = "";
  private String gtr = "";
  private String gts = "";
  private long gtt;
  private String gtu = "";
  private String gtv = "";
  
  public final String agH()
  {
    AppMethodBeat.i(253619);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gtq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gts);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsx);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(253619);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(253620);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FinderUsrName:").append(this.gtq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.gpX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.gpY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterLiveId:").append(this.gtr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStatus:").append(this.gnC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.gnV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.ggB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AdData:").append(this.gnH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scenenote:").append(this.gnI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForcePushId:").append(this.gts);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Noticetype:").append(this.gtt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NotificationId:").append(this.gtu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportContent:").append(this.gtv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedID:").append(this.gpZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionBuffer:").append(this.gpT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Description:").append(this.gsx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(253620);
    return localObject;
  }
  
  public final String agY()
  {
    return this.gjk;
  }
  
  public final String ahA()
  {
    return this.gpX;
  }
  
  public final long ahB()
  {
    return this.gpY;
  }
  
  public final long ahC()
  {
    return this.giq;
  }
  
  public final long ahf()
  {
    return this.gnC;
  }
  
  public final String ahl()
  {
    return this.gnH;
  }
  
  public final String ahm()
  {
    return this.gnI;
  }
  
  public final String aiW()
  {
    return this.gtq;
  }
  
  public final String aiX()
  {
    return this.gtr;
  }
  
  public final String aiY()
  {
    return this.gnV;
  }
  
  public final String aiZ()
  {
    return this.ggB;
  }
  
  public final String aja()
  {
    return this.gts;
  }
  
  public final long ajb()
  {
    return this.gtt;
  }
  
  public final String ajc()
  {
    return this.gtu;
  }
  
  public final String getDescription()
  {
    return this.gsx;
  }
  
  public final int getId()
  {
    return 21158;
  }
  
  public final String getReportContent()
  {
    return this.gtv;
  }
  
  public final di iD(long paramLong)
  {
    AppMethodBeat.i(253579);
    this.gpY = paramLong;
    super.bk("ActionTimeMs", this.gpY);
    AppMethodBeat.o(253579);
    return this;
  }
  
  public final di iE(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final di iF(long paramLong)
  {
    this.gnC = 0L;
    return this;
  }
  
  public final di iG(long paramLong)
  {
    this.gtt = paramLong;
    return this;
  }
  
  public final di pB(String paramString)
  {
    AppMethodBeat.i(253577);
    this.gtq = z("FinderUsrName", paramString, true);
    AppMethodBeat.o(253577);
    return this;
  }
  
  public final di pC(String paramString)
  {
    AppMethodBeat.i(253578);
    this.gpX = z("FinderSessionId", paramString, true);
    AppMethodBeat.o(253578);
    return this;
  }
  
  public final di pD(String paramString)
  {
    AppMethodBeat.i(253582);
    this.gtr = z("EnterLiveId", paramString, true);
    AppMethodBeat.o(253582);
    return this;
  }
  
  public final di pE(String paramString)
  {
    AppMethodBeat.i(253585);
    this.gnV = z("commentscene", paramString, true);
    AppMethodBeat.o(253585);
    return this;
  }
  
  public final di pF(String paramString)
  {
    AppMethodBeat.i(253587);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(253587);
    return this;
  }
  
  public final di pG(String paramString)
  {
    AppMethodBeat.i(253590);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(253590);
    return this;
  }
  
  public final di pH(String paramString)
  {
    AppMethodBeat.i(253594);
    this.gnH = z("AdData", paramString, true);
    AppMethodBeat.o(253594);
    return this;
  }
  
  public final di pI(String paramString)
  {
    AppMethodBeat.i(253597);
    this.gnI = z("Scenenote", paramString, true);
    AppMethodBeat.o(253597);
    return this;
  }
  
  public final di pJ(String paramString)
  {
    AppMethodBeat.i(253601);
    this.gts = z("ForcePushId", paramString, true);
    AppMethodBeat.o(253601);
    return this;
  }
  
  public final di pK(String paramString)
  {
    AppMethodBeat.i(253610);
    this.gtu = z("NotificationId", paramString, true);
    AppMethodBeat.o(253610);
    return this;
  }
  
  public final di pL(String paramString)
  {
    AppMethodBeat.i(253613);
    this.gtv = z("ReportContent", paramString, true);
    AppMethodBeat.o(253613);
    return this;
  }
  
  public final di pM(String paramString)
  {
    AppMethodBeat.i(253617);
    this.gsx = z("Description", paramString, true);
    AppMethodBeat.o(253617);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.di
 * JD-Core Version:    0.7.0.1
 */
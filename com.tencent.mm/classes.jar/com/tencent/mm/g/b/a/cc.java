package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cc
  extends a
{
  private String eiB = "";
  private String eoo = "";
  private String eoz = "";
  private String erH = "";
  private long erW;
  private String etv = "";
  private long etw;
  private String ety = "";
  private String euL = "";
  private String euM = "";
  private long euN;
  private long euO;
  private String euP = "";
  private long euQ;
  private String euR = "";
  private long euS;
  private String euT = "";
  private long euU;
  
  public final String abV()
  {
    AppMethodBeat.i(208964);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ety);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euU);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208964);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208965);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedid:").append(this.euL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFeedInfo:").append(this.euM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefreshTime:").append(this.euN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStamp:").append(this.euO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageTag:").append(this.euP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.eoo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.euQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenInfo:").append(this.euR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommendType:").append(this.euS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommendWording:").append(this.euT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupID:").append(this.etv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TrackType:").append(this.etw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActivityID:").append(this.ety);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActivitySortType:").append(this.euU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208965);
    return localObject;
  }
  
  public final cc acY()
  {
    this.euU = 1L;
    return this;
  }
  
  public final cc fp(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final cc fq(long paramLong)
  {
    this.euN = paramLong;
    return this;
  }
  
  public final cc fr(long paramLong)
  {
    this.euO = paramLong;
    return this;
  }
  
  public final cc fs(long paramLong)
  {
    this.euQ = paramLong;
    return this;
  }
  
  public final cc ft(long paramLong)
  {
    this.euS = paramLong;
    return this;
  }
  
  public final cc fu(long paramLong)
  {
    this.etw = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19993;
  }
  
  public final cc kQ(String paramString)
  {
    AppMethodBeat.i(208953);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(208953);
    return this;
  }
  
  public final cc kR(String paramString)
  {
    AppMethodBeat.i(208954);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(208954);
    return this;
  }
  
  public final cc kS(String paramString)
  {
    AppMethodBeat.i(208955);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(208955);
    return this;
  }
  
  public final cc kT(String paramString)
  {
    AppMethodBeat.i(208956);
    this.euL = x("ClickFeedid", paramString, true);
    AppMethodBeat.o(208956);
    return this;
  }
  
  public final cc kU(String paramString)
  {
    AppMethodBeat.i(208957);
    this.euM = x("AllFeedInfo", paramString, true);
    AppMethodBeat.o(208957);
    return this;
  }
  
  public final cc kV(String paramString)
  {
    AppMethodBeat.i(208958);
    this.euP = x("PageTag", paramString, true);
    AppMethodBeat.o(208958);
    return this;
  }
  
  public final cc kW(String paramString)
  {
    AppMethodBeat.i(208959);
    this.eoo = x("SessionBuffer", paramString, true);
    AppMethodBeat.o(208959);
    return this;
  }
  
  public final cc kX(String paramString)
  {
    AppMethodBeat.i(208960);
    this.euR = x("ScreenInfo", paramString, true);
    AppMethodBeat.o(208960);
    return this;
  }
  
  public final cc kY(String paramString)
  {
    AppMethodBeat.i(208961);
    this.euT = x("RecommendWording", paramString, true);
    AppMethodBeat.o(208961);
    return this;
  }
  
  public final cc kZ(String paramString)
  {
    AppMethodBeat.i(208962);
    this.etv = x("GroupID", paramString, true);
    AppMethodBeat.o(208962);
    return this;
  }
  
  public final cc la(String paramString)
  {
    AppMethodBeat.i(208963);
    this.ety = x("ActivityID", paramString, true);
    AppMethodBeat.o(208963);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cc
 * JD-Core Version:    0.7.0.1
 */
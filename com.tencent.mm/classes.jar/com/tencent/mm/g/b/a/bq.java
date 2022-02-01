package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bq
  extends a
{
  private String eiB = "";
  private String err = "";
  private String esL = "";
  private String esS = "";
  private String esT = "";
  private long esU;
  private long esV;
  private long etp;
  private long etq;
  private String etr = "";
  private long ets;
  private long ett;
  private long etu;
  private String etv = "";
  private long etw;
  private String etx = "";
  private String ety = "";
  
  public final String abV()
  {
    AppMethodBeat.i(208911);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ets);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ett);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ety);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208911);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208912);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.etp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CardType:").append(this.etq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUsr:").append(this.etr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.esL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.esS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.esU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.esV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveCover:").append(this.ets);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.ett);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIType:").append(this.etu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupID:").append(this.etv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TrackType:").append(this.etw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ColumnId:").append(this.etx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActivityID:").append(this.ety);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208912);
    return localObject;
  }
  
  public final bq eq(long paramLong)
  {
    this.etp = paramLong;
    return this;
  }
  
  public final bq er(long paramLong)
  {
    this.etq = paramLong;
    return this;
  }
  
  public final bq es(long paramLong)
  {
    this.ets = paramLong;
    return this;
  }
  
  public final bq et(long paramLong)
  {
    this.ett = paramLong;
    return this;
  }
  
  public final bq eu(long paramLong)
  {
    this.etu = paramLong;
    return this;
  }
  
  public final bq ev(long paramLong)
  {
    this.etw = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18944;
  }
  
  public final bq jP(String paramString)
  {
    AppMethodBeat.i(208903);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(208903);
    return this;
  }
  
  public final bq jQ(String paramString)
  {
    AppMethodBeat.i(208904);
    this.etr = x("SourceUsr", paramString, true);
    AppMethodBeat.o(208904);
    return this;
  }
  
  public final bq jR(String paramString)
  {
    AppMethodBeat.i(208905);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(208905);
    return this;
  }
  
  public final bq jS(String paramString)
  {
    AppMethodBeat.i(208906);
    this.esL = x("FeedUsr", paramString, true);
    AppMethodBeat.o(208906);
    return this;
  }
  
  public final bq jT(String paramString)
  {
    AppMethodBeat.i(208907);
    this.esS = x("Tag", paramString, true);
    AppMethodBeat.o(208907);
    return this;
  }
  
  public final bq jU(String paramString)
  {
    AppMethodBeat.i(208908);
    this.etv = x("GroupID", paramString, true);
    AppMethodBeat.o(208908);
    return this;
  }
  
  public final bq jV(String paramString)
  {
    AppMethodBeat.i(208909);
    this.etx = x("ColumnId", paramString, true);
    AppMethodBeat.o(208909);
    return this;
  }
  
  public final bq jW(String paramString)
  {
    AppMethodBeat.i(208910);
    this.ety = x("ActivityID", paramString, true);
    AppMethodBeat.o(208910);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bq
 * JD-Core Version:    0.7.0.1
 */
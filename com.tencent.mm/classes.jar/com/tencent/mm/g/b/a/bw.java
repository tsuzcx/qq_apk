package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bw
  extends a
{
  private int enW;
  private int enq;
  private String eoz = "";
  private String erD = "";
  private String erH = "";
  private long ery;
  private String esZ = "";
  private String etY = "";
  private int etZ;
  private String eta = "";
  private long eua;
  private long eub;
  private String euc = "";
  private int eud;
  private String eue = "";
  private long euf;
  private String eug = "";
  private String euh = "";
  private String eui = "";
  private long euj;
  
  public final String abV()
  {
    AppMethodBeat.i(208930);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eua);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eub);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eud);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eue);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ery);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eug);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eta);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eui);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euj);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208930);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208931);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedID:").append(this.erD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.enq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionValue:").append(this.etY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionCurrentVersion:").append(this.etZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.eua);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.eub);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionID:").append(this.euc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.eud);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionBuffer:").append(this.eue);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("videoDurationTime:").append(this.euf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ery);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.eug);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedContextId:").append(this.euh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.esZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterSourceInfo:").append(this.eta);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.eui);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedDisplayType:").append(this.euj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208931);
    return localObject;
  }
  
  public final bw eP(long paramLong)
  {
    AppMethodBeat.i(208920);
    this.eub = paramLong;
    super.bj("ActionTimeStampMs", this.eub);
    AppMethodBeat.o(208920);
    return this;
  }
  
  public final bw eQ(long paramLong)
  {
    this.euf = paramLong;
    return this;
  }
  
  public final bw eR(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final bw eS(long paramLong)
  {
    this.euj = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18054;
  }
  
  public final bw jY(int paramInt)
  {
    this.enW = paramInt;
    return this;
  }
  
  public final bw jZ(int paramInt)
  {
    this.etZ = paramInt;
    return this;
  }
  
  public final bw ka(int paramInt)
  {
    this.eud = paramInt;
    return this;
  }
  
  public final bw ko(String paramString)
  {
    AppMethodBeat.i(208918);
    this.erD = x("FeedID", paramString, true);
    AppMethodBeat.o(208918);
    return this;
  }
  
  public final bw kp(String paramString)
  {
    AppMethodBeat.i(208919);
    this.etY = x("ActionValue", paramString, true);
    AppMethodBeat.o(208919);
    return this;
  }
  
  public final bw kq(String paramString)
  {
    AppMethodBeat.i(208921);
    this.euc = x("sessionID", paramString, true);
    AppMethodBeat.o(208921);
    return this;
  }
  
  public final bw kr(String paramString)
  {
    AppMethodBeat.i(208922);
    this.eue = x("sessionBuffer", paramString, true);
    AppMethodBeat.o(208922);
    return this;
  }
  
  public final bw ks(String paramString)
  {
    AppMethodBeat.i(208923);
    this.eug = x("ClickFeedId", paramString, true);
    AppMethodBeat.o(208923);
    return this;
  }
  
  public final bw kt(String paramString)
  {
    AppMethodBeat.i(208924);
    this.euh = x("ClickFeedContextId", paramString, true);
    AppMethodBeat.o(208924);
    return this;
  }
  
  public final bw ku(String paramString)
  {
    AppMethodBeat.i(208925);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(208925);
    return this;
  }
  
  public final bw kv(String paramString)
  {
    AppMethodBeat.i(208926);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(208926);
    return this;
  }
  
  public final bw kw(String paramString)
  {
    AppMethodBeat.i(208927);
    this.esZ = x("ExtraInfo", paramString, true);
    AppMethodBeat.o(208927);
    return this;
  }
  
  public final bw kx(String paramString)
  {
    AppMethodBeat.i(208928);
    this.eta = x("enterSourceInfo", paramString, true);
    AppMethodBeat.o(208928);
    return this;
  }
  
  public final bw ky(String paramString)
  {
    AppMethodBeat.i(208929);
    this.eui = x("LongVideoId", paramString, true);
    AppMethodBeat.o(208929);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bw
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dy
  extends a
{
  public String dHr;
  public long dPH;
  public long dQP;
  public long dQQ;
  public long dWA;
  public long dWB;
  public long dWh;
  public long dWi;
  public String dWl;
  public String dWq;
  public long dWr;
  public String dWs;
  public long dWt;
  public long dWu;
  public long dWv;
  public long dWw;
  public long dWx;
  public long dWy;
  public long dWz;
  
  public final String PV()
  {
    AppMethodBeat.i(179061);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWi);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(179061);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(179062);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewFeeds:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewFeedsCount:").append(this.dWr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposureNewFeeds:").append(this.dWs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposureNewFeedsCount:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadBreakLayersCount:").append(this.dWu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpableMissReadBreakLayersCount:").append(this.dWv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBtnExposureCount:").append(this.dWw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBtnClickCount:").append(this.dWx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.dQP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.dQQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBtnId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBtnClickType:").append(this.dWy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBtnFirstExposureTime:").append(this.dWz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeedCount:").append(this.dWA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerWeishangFeedCount:").append(this.dWB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeeds:").append(this.dWl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBreakLayerId:").append(this.dWi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(179062);
    return localObject;
  }
  
  public final int getId()
  {
    return 19055;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dy
 * JD-Core Version:    0.7.0.1
 */
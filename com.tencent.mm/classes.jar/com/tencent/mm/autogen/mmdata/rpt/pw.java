package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pw
  extends a
{
  public long iZX;
  public String ijk = "";
  public long jcC;
  public long jcD;
  public long jpn;
  public long jpo;
  public long jpp;
  public long jpq;
  public String jpr = "";
  public long jps;
  public String jpt = "";
  public long jpu;
  public long jpv;
  
  public final String aIE()
  {
    AppMethodBeat.i(179059);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jps);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcD);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(179059);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(179060);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBtnId:").append(this.jpn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBreakLayerId:").append(this.jpo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsJumpToNearestBreakLayer:").append(this.jpp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpSkipFeedsCount:").append(this.jpq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeeds:").append(this.jpr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeedsCount:").append(this.jps);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerExposureFeeds:").append(this.jpt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerExposureFeedsCount:").append(this.jpu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BreakLayerFirstFeedFromNow:").append(this.jpv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.iZX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.jcC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.jcD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(179060);
    return localObject;
  }
  
  public final int getId()
  {
    return 19056;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pw
 * JD-Core Version:    0.7.0.1
 */
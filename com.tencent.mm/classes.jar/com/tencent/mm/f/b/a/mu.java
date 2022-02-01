package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mu
  extends a
{
  public long gKH;
  public long gMK;
  public long gML;
  public long gVR;
  public long gVS;
  public long gVT;
  public long gVU;
  public String gVV = "";
  public long gVW;
  public String gVX = "";
  public long gVY;
  public long gVZ;
  public String gcU = "";
  
  public final String agH()
  {
    AppMethodBeat.i(179059);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gML);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(179059);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(179060);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBtnId:").append(this.gVR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBreakLayerId:").append(this.gVS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsJumpToNearestBreakLayer:").append(this.gVT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpSkipFeedsCount:").append(this.gVU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeeds:").append(this.gVV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeedsCount:").append(this.gVW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerExposureFeeds:").append(this.gVX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerExposureFeedsCount:").append(this.gVY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BreakLayerFirstFeedFromNow:").append(this.gVZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.gKH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.gMK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.gML);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(179060);
    return localObject;
  }
  
  public final int getId()
  {
    return 19056;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mu
 * JD-Core Version:    0.7.0.1
 */
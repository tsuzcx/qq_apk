package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fn
  extends a
{
  public String dFe;
  public long dRy;
  public long dSE;
  public long dSF;
  public long dYc;
  public long dYd;
  public long dYe;
  public long dYf;
  public String dYg;
  public long dYh;
  public String dYi;
  public long dYj;
  public long dYk;
  
  public final String PR()
  {
    AppMethodBeat.i(179059);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSF);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(179059);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(179060);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBtnId:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBreakLayerId:").append(this.dYd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsJumpToNearestBreakLayer:").append(this.dYe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpSkipFeedsCount:").append(this.dYf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeeds:").append(this.dYg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeedsCount:").append(this.dYh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerExposureFeeds:").append(this.dYi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerExposureFeedsCount:").append(this.dYj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BreakLayerFirstFeedFromNow:").append(this.dYk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.dRy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.dSE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.dSF);
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
 * Qualified Name:     com.tencent.mm.g.b.a.fn
 * JD-Core Version:    0.7.0.1
 */
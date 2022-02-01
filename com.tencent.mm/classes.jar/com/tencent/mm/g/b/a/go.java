package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class go
  extends a
{
  public String dTr = "";
  public long eiF;
  public long ejU;
  public long ejV;
  public long eqa;
  public long eqb;
  public long eqc;
  public long eqd;
  public String eqe = "";
  public long eqf;
  public String eqg = "";
  public long eqh;
  public long eqi;
  
  public final String RC()
  {
    AppMethodBeat.i(179059);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejV);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(179059);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(179060);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBtnId:").append(this.eqa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBreakLayerId:").append(this.eqb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsJumpToNearestBreakLayer:").append(this.eqc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpSkipFeedsCount:").append(this.eqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeeds:").append(this.eqe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeedsCount:").append(this.eqf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerExposureFeeds:").append(this.eqg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerExposureFeedsCount:").append(this.eqh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BreakLayerFirstFeedFromNow:").append(this.eqi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.eiF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.ejU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.ejV);
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
 * Qualified Name:     com.tencent.mm.g.b.a.go
 * JD-Core Version:    0.7.0.1
 */
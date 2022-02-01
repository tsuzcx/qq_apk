package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gm
  extends a
{
  public String dSb;
  public long egV;
  public long eik;
  public long eil;
  public long eoA;
  public long eoB;
  public long eot;
  public long eou;
  public long eov;
  public long eow;
  public String eox;
  public long eoy;
  public String eoz;
  
  public final String RD()
  {
    AppMethodBeat.i(179059);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eot);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eou);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eov);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eow);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eox);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eik);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eil);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(179059);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(179060);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBtnId:").append(this.eot);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBreakLayerId:").append(this.eou);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsJumpToNearestBreakLayer:").append(this.eov);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpSkipFeedsCount:").append(this.eow);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeeds:").append(this.eox);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeedsCount:").append(this.eoy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerExposureFeeds:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerExposureFeedsCount:").append(this.eoA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BreakLayerFirstFeedFromNow:").append(this.eoB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.egV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.eik);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.eil);
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
 * Qualified Name:     com.tencent.mm.g.b.a.gm
 * JD-Core Version:    0.7.0.1
 */
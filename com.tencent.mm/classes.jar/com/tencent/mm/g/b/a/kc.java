package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kc
  extends a
{
  public long eLd;
  public long eMG;
  public long eMH;
  public long eTD;
  public long eTE;
  public long eTF;
  public long eTG;
  public String eTH = "";
  public long eTI;
  public String eTJ = "";
  public long eTK;
  public long eTL;
  public String eiB = "";
  
  public final String abV()
  {
    AppMethodBeat.i(179059);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMH);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(179059);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(179060);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBtnId:").append(this.eTD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MissReadJumpBreakLayerId:").append(this.eTE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsJumpToNearestBreakLayer:").append(this.eTF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpSkipFeedsCount:").append(this.eTG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeeds:").append(this.eTH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerFeedsCount:").append(this.eTI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerExposureFeeds:").append(this.eTJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpBreakLayerExposureFeedsCount:").append(this.eTK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BreakLayerFirstFeedFromNow:").append(this.eTL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.eLd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.eMG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.eMH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(179060);
    return localObject;
  }
  
  public final int getId()
  {
    return 19056;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kc
 * JD-Core Version:    0.7.0.1
 */
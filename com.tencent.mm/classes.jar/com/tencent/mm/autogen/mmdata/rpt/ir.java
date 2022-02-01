package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ir
  extends a
{
  public String iCb = "";
  public long iFo;
  public String iNB = "";
  public long iQA;
  public long iQB;
  public long iQC;
  public long iQD;
  public long iQE;
  public long iQF;
  public long iQx;
  public long iQy;
  public long iQz;
  private long iku = 0L;
  public long iuA;
  
  public final String aIE()
  {
    AppMethodBeat.i(368739);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iku);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQF);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368739);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368744);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.iFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.iCb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.iQx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.iku);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.iQy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCountMax:").append(this.iQz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.iQA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.iQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.iQC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowReplay:").append(this.iQD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.iQE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("costTime:").append(this.iQF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368744);
    return localObject;
  }
  
  public final int getId()
  {
    return 19891;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ir
 * JD-Core Version:    0.7.0.1
 */
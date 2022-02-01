package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class sc
  extends a
{
  public String ijk = "";
  public int imW;
  public String ipT = "";
  public String ivZ = "";
  public long jxg;
  public String jxi = "";
  public String jxj = "";
  public String jxn = "";
  public int jxo;
  public long jxp;
  public long jxq;
  public int jxr = -1;
  public long jxs;
  public int jxt;
  
  public final String aIE()
  {
    AppMethodBeat.i(368573);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxo);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368573);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368575);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.ivZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartExposureMs:").append(this.jxp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndExposureMs:").append(this.jxq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisAppearType:").append(this.jxr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.jxi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.jxj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.jxg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureTimeMs:").append(this.jxs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemPos:").append(this.jxt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.jxn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.jxo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368575);
    return localObject;
  }
  
  public final sc ft(long paramLong)
  {
    AppMethodBeat.i(368561);
    this.jxg = paramLong;
    super.bw("UpdataTimeMs", this.jxg);
    AppMethodBeat.o(368561);
    return this;
  }
  
  public final sc fu(long paramLong)
  {
    AppMethodBeat.i(368567);
    this.jxs = paramLong;
    super.bw("ItemExposureTimeMs", this.jxs);
    AppMethodBeat.o(368567);
    return this;
  }
  
  public final int getId()
  {
    return 19944;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sc
 * JD-Core Version:    0.7.0.1
 */
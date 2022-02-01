package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class sb
  extends a
{
  public String ijk = "";
  public int imW;
  public String ipT = "";
  public String izW = "";
  public long jxg;
  public long jxh;
  public String jxi = "";
  public String jxj = "";
  public int jxk;
  public int jxl;
  public String jxm = "";
  public String jxn = "";
  public int jxo;
  
  public final String aIE()
  {
    AppMethodBeat.i(368568);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxo);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368568);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368572);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.izW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.jxg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeMs:").append(this.jxh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.jxi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.jxj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemDirection:").append(this.jxk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemIndex:").append(this.jxl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShotScreenJson:").append(this.jxm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.jxn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.jxo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368572);
    return localObject;
  }
  
  public final sb fr(long paramLong)
  {
    AppMethodBeat.i(368554);
    this.jxg = paramLong;
    super.bw("UpdataTimeMs", this.jxg);
    AppMethodBeat.o(368554);
    return this;
  }
  
  public final sb fs(long paramLong)
  {
    AppMethodBeat.i(368560);
    this.jxh = paramLong;
    super.bw("ClickTimeMs", this.jxh);
    AppMethodBeat.o(368560);
    return this;
  }
  
  public final int getId()
  {
    return 19945;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sb
 * JD-Core Version:    0.7.0.1
 */
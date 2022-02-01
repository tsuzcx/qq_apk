package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class df
  extends a
{
  public String ijk = "";
  public String ikf = "";
  private long ipo;
  public int iyT;
  public int iyX;
  public int iyY;
  public String iyZ = "";
  public long iza;
  public long izb;
  private long izc;
  public int izd;
  
  public final String aIE()
  {
    AppMethodBeat.i(368467);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iza);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izd);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368467);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368476);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OldTime:").append(this.iza);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewTime:").append(this.izb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfigJson:").append(this.iyZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.ipo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeMs:").append(this.izc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TipsId:").append(this.ikf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CtrlType:").append(this.iyT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DropRedDotCount:").append(this.iyX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeepReadCount:").append(this.iyY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsReset:").append(this.izd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368476);
    return localObject;
  }
  
  public final df eF(long paramLong)
  {
    AppMethodBeat.i(368450);
    this.ipo = paramLong;
    super.bw("StayTimeMs", this.ipo);
    AppMethodBeat.o(368450);
    return this;
  }
  
  public final df eG(long paramLong)
  {
    AppMethodBeat.i(368457);
    this.izc = paramLong;
    super.bw("ExitTimeMs", this.izc);
    AppMethodBeat.o(368457);
    return this;
  }
  
  public final int getId()
  {
    return 23584;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.df
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class de
  extends a
{
  public long ijY;
  public String ikf = "";
  public int ilm;
  public int iyT;
  private long iyU;
  public long iyV;
  public long iyW;
  public int iyX;
  public int iyY;
  public String iyZ = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368451);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyZ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368451);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368461);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("TipsId:").append(this.ikf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CtrlType:").append(this.iyT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastExitFinderTimeMs:").append(this.iyU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NowMs:").append(this.ijY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ilm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DynamicTime:").append(this.iyV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DiffTime:").append(this.iyW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DropRedDotCount:").append(this.iyX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeepReadCount:").append(this.iyY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfigJson:").append(this.iyZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368461);
    return localObject;
  }
  
  public final de eE(long paramLong)
  {
    AppMethodBeat.i(368444);
    this.iyU = paramLong;
    super.bw("LastExitFinderTimeMs", this.iyU);
    AppMethodBeat.o(368444);
    return this;
  }
  
  public final int getId()
  {
    return 23585;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.de
 * JD-Core Version:    0.7.0.1
 */
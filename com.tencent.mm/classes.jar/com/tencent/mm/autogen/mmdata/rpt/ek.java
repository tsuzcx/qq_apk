package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ek
  extends a
{
  public long iDP;
  public long iDQ;
  public String iDR = "";
  public long iDS = 0L;
  public long iDT = 0L;
  public long iDU = 0L;
  public long iDV = 0L;
  public long iDW = 0L;
  public long iDX = 0L;
  public long iDY = 0L;
  public long iDZ = 0L;
  public long imY = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(367927);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iDP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDZ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367927);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367936);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("LiveId:").append(this.iDP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SdkLiveId:").append(this.iDQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderName:").append(this.iDR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveScene:").append(this.iDS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.imY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Wave3AEnable:").append(this.iDT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Wave3AAllEnable:").append(this.iDU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Wave3AMode:").append(this.iDV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Trtc3AEnable:").append(this.iDW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LivePushMode:").append(this.iDX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoCustomRenderEnable:").append(this.iDY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoCustomRenderMode:").append(this.iDZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367936);
    return localObject;
  }
  
  public final int getId()
  {
    return 24524;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ek
 * JD-Core Version:    0.7.0.1
 */
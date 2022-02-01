package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ex
  extends a
{
  public String iCR = "";
  private long iGg;
  private long iGh;
  public long iGi;
  public String iGj = "";
  public int iGk;
  public int iGl;
  public int iGm;
  
  public final String aIE()
  {
    AppMethodBeat.i(367825);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iGg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGm);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367825);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367837);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ThermalState:").append(this.iGg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLowPowerModeEnabled:").append(this.iGh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveId:").append(this.iCR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentLiveScene:").append(this.iGi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderNickname:").append(this.iGj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BatteryState:").append(this.iGk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BatteryLevelPercentage:").append(this.iGl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceTemperature:").append(this.iGm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367837);
    return localObject;
  }
  
  public final int getId()
  {
    return 23558;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ex
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class se
  extends a
{
  public String imT = "";
  public long ind = 0L;
  public long iqr = 0L;
  public long jax = 0L;
  public long jxA = 0L;
  public long jxB = 0L;
  public long jxC = 0L;
  public long jxD = 0L;
  public se.a jxw;
  public long jxx = 0L;
  public String jxy = "";
  public long jxz = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(43470);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jxw != null) {}
    for (int i = this.jxw.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jax);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jxx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jxy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iqr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jxz);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jxA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jxB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jxC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jxD);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43470);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43471);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jxw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileOccupation:").append(this.jxx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DirPrefix:").append(this.jxy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalFileOccupation:").append(this.jxz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TriggerSingleAppClean:").append(this.jxA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TriggerAllAppClean:").append(this.jxB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RuntimeFileOccupation:").append(this.jxC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RuntimeSpaceStaticsEnable:").append(this.jxD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43471);
    return localObject;
  }
  
  public final int getId()
  {
    return 17687;
  }
  
  public final se yQ(String paramString)
  {
    AppMethodBeat.i(43469);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(43469);
    return this;
  }
  
  public final se yR(String paramString)
  {
    AppMethodBeat.i(180149);
    this.jxy = F("DirPrefix", paramString, true);
    AppMethodBeat.o(180149);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.se
 * JD-Core Version:    0.7.0.1
 */
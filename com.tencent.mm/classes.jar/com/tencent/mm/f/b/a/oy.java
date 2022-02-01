package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oy
  extends a
{
  public long gYL = 0L;
  public long gYN = 0L;
  public String gfn = "";
  public String gmF = "";
  public long gnP = 0L;
  public long grp = 0L;
  public long hcB = 0L;
  private long hcT = 0L;
  private long hcU = 0L;
  private long hcV = 0L;
  public oy.a hdF;
  
  public final String agH()
  {
    AppMethodBeat.i(43548);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hdF != null) {}
    for (int i = this.hdF.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gYN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gnP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.grp);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43548);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43549);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hdF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.hcT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.hcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.hcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.hcB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.grp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43549);
    return localObject;
  }
  
  public final int getId()
  {
    return 16369;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.oy
 * JD-Core Version:    0.7.0.1
 */
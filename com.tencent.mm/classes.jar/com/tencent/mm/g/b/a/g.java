package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends a
{
  public String dGR = "";
  public long dGS = 0L;
  public long dGT = 0L;
  public long dGU = 0L;
  public boolean dGV;
  public long dGW = 0L;
  public long dGX = 0L;
  public long dGY = 0L;
  private long dGZ = 0L;
  private long dHa = 0L;
  public g.a dHb;
  
  public final String PV()
  {
    AppMethodBeat.i(19862);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dGR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGU);
    ((StringBuffer)localObject).append(",");
    if (this.dGV)
    {
      i = 1;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dGW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dGX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dGY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dGZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dHa);
      ((StringBuffer)localObject).append(",");
      if (this.dHb == null) {
        break label225;
      }
    }
    label225:
    for (int i = this.dHb.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(19862);
      return localObject;
      i = 0;
      break;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(19863);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dGR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.dGS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.dGT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCreateTime:").append(this.dGU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHdImgBool:").append(this.dGV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgSize:").append(this.dGW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgWidth:").append(this.dGX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgHeight:").append(this.dGY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTimeStampMs:").append(this.dGZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishDownloadTimeStampMs:").append(this.dHa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishCode:").append(this.dHb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19863);
    return localObject;
  }
  
  public final g PZ()
  {
    AppMethodBeat.i(19860);
    this.dGZ = bt.eGO();
    super.bb("StartDownloadTimeStampMs", this.dGZ);
    AppMethodBeat.o(19860);
    return this;
  }
  
  public final g Qa()
  {
    AppMethodBeat.i(19861);
    this.dHa = bt.eGO();
    super.bb("FinishDownloadTimeStampMs", this.dHa);
    AppMethodBeat.o(19861);
    return this;
  }
  
  public final int getId()
  {
    return 15749;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.g
 * JD-Core Version:    0.7.0.1
 */
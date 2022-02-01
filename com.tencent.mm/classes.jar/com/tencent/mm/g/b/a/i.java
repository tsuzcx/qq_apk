package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
  extends a
{
  public String dRB = "";
  public long dRC = 0L;
  public long dRD = 0L;
  public long dRE = 0L;
  public boolean dRF;
  public long dRG = 0L;
  public long dRH = 0L;
  public long dRI = 0L;
  private long dRJ = 0L;
  private long dRK = 0L;
  public a dRL;
  
  public final String RD()
  {
    AppMethodBeat.i(19862);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRE);
    ((StringBuffer)localObject).append(",");
    if (this.dRF)
    {
      i = 1;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dRG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dRH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dRI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dRJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dRK);
      ((StringBuffer)localObject).append(",");
      if (this.dRL == null) {
        break label225;
      }
    }
    label225:
    for (int i = this.dRL.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(19862);
      return localObject;
      i = 0;
      break;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(19863);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.dRC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.dRD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCreateTime:").append(this.dRE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHdImgBool:").append(this.dRF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgSize:").append(this.dRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgWidth:").append(this.dRH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgHeight:").append(this.dRI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTimeStampMs:").append(this.dRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishDownloadTimeStampMs:").append(this.dRK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishCode:").append(this.dRL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19863);
    return localObject;
  }
  
  public final i RH()
  {
    AppMethodBeat.i(19860);
    this.dRJ = bt.flT();
    super.bg("StartDownloadTimeStampMs", this.dRJ);
    AppMethodBeat.o(19860);
    return this;
  }
  
  public final i RI()
  {
    AppMethodBeat.i(19861);
    this.dRK = bt.flT();
    super.bg("FinishDownloadTimeStampMs", this.dRK);
    AppMethodBeat.o(19861);
    return this;
  }
  
  public final int getId()
  {
    return 15749;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(19859);
      dRM = new a("ok", 0, 0);
      dRN = new a("cancel", 1, 1);
      dRO = new a("error", 2, 2);
      dRP = new a[] { dRM, dRN, dRO };
      AppMethodBeat.o(19859);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.i
 * JD-Core Version:    0.7.0.1
 */
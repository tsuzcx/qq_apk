package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class i
  extends a
{
  public String dSR = "";
  public long dSS = 0L;
  public long dST = 0L;
  public long dSU = 0L;
  public boolean dSV;
  public long dSW = 0L;
  public long dSX = 0L;
  public long dSY = 0L;
  private long dSZ = 0L;
  private long dTa = 0L;
  public a dTb;
  
  public final String RC()
  {
    AppMethodBeat.i(19862);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dST);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSU);
    ((StringBuffer)localObject).append(",");
    if (this.dSV)
    {
      i = 1;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dSW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dSX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dSY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dSZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dTa);
      ((StringBuffer)localObject).append(",");
      if (this.dTb == null) {
        break label225;
      }
    }
    label225:
    for (int i = this.dTb.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(19862);
      return localObject;
      i = 0;
      break;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(19863);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.dSS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.dST);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCreateTime:").append(this.dSU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHdImgBool:").append(this.dSV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgSize:").append(this.dSW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgWidth:").append(this.dSX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgHeight:").append(this.dSY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTimeStampMs:").append(this.dSZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishDownloadTimeStampMs:").append(this.dTa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishCode:").append(this.dTb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19863);
    return localObject;
  }
  
  public final i RG()
  {
    AppMethodBeat.i(19860);
    this.dSZ = bu.fpO();
    super.bh("StartDownloadTimeStampMs", this.dSZ);
    AppMethodBeat.o(19860);
    return this;
  }
  
  public final i RH()
  {
    AppMethodBeat.i(19861);
    this.dTa = bu.fpO();
    super.bh("FinishDownloadTimeStampMs", this.dTa);
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
      dTc = new a("ok", 0, 0);
      dTd = new a("cancel", 1, 1);
      dTe = new a("error", 2, 2);
      dTf = new a[] { dTc, dTd, dTe };
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
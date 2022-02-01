package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class ag
  extends a
{
  public String imN = "";
  public long imZ = 0L;
  public long inO = 0L;
  public long inP = 0L;
  public boolean inQ;
  public long inR = 0L;
  public long inS = 0L;
  public long inT = 0L;
  private long inU = 0L;
  private long inV = 0L;
  public a inW;
  
  public final String aIE()
  {
    AppMethodBeat.i(19862);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inP);
    ((StringBuffer)localObject).append(",");
    if (this.inQ)
    {
      i = 1;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.inR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.inS);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.inT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.inU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.inV);
      ((StringBuffer)localObject).append(",");
      if (this.inW == null) {
        break label225;
      }
    }
    label225:
    for (int i = this.inW.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(19862);
      return localObject;
      i = 0;
      break;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(19863);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.imZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.inO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCreateTime:").append(this.inP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHdImgBool:").append(this.inQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgSize:").append(this.inR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgWidth:").append(this.inS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgHeight:").append(this.inT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTimeStampMs:").append(this.inU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishDownloadTimeStampMs:").append(this.inV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishCode:").append(this.inW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19863);
    return localObject;
  }
  
  public final ag aII()
  {
    AppMethodBeat.i(19860);
    this.inU = Util.nowMilliSecond();
    super.by("StartDownloadTimeStampMs", this.inU);
    AppMethodBeat.o(19860);
    return this;
  }
  
  public final ag aIJ()
  {
    AppMethodBeat.i(19861);
    this.inV = Util.nowMilliSecond();
    super.by("FinishDownloadTimeStampMs", this.inV);
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
      inX = new a("ok", 0, 0);
      inY = new a("cancel", 1, 1);
      inZ = new a("error", 2, 2);
      ioa = new a[] { inX, inY, inZ };
      AppMethodBeat.o(19859);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ag
 * JD-Core Version:    0.7.0.1
 */
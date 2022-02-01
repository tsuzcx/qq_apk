package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
  extends a
{
  public String dEE = "";
  public long dEF = 0L;
  public long dEG = 0L;
  public long dEH = 0L;
  public boolean dEI;
  public long dEJ = 0L;
  public long dEK = 0L;
  public long dEL = 0L;
  private long dEM = 0L;
  private long dEN = 0L;
  public a dEO;
  
  public final String PR()
  {
    AppMethodBeat.i(19862);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dEE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dEF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dEG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dEH);
    ((StringBuffer)localObject).append(",");
    if (this.dEI)
    {
      i = 1;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dEJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dEK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dEL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dEM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dEN);
      ((StringBuffer)localObject).append(",");
      if (this.dEO == null) {
        break label225;
      }
    }
    label225:
    for (int i = this.dEO.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(19862);
      return localObject;
      i = 0;
      break;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(19863);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dEE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.dEF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.dEG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCreateTime:").append(this.dEH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHdImgBool:").append(this.dEI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgSize:").append(this.dEJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgWidth:").append(this.dEK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgHeight:").append(this.dEL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTimeStampMs:").append(this.dEM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishDownloadTimeStampMs:").append(this.dEN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishCode:").append(this.dEO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19863);
    return localObject;
  }
  
  public final g PV()
  {
    AppMethodBeat.i(19860);
    this.dEM = bs.eWj();
    super.bd("StartDownloadTimeStampMs", this.dEM);
    AppMethodBeat.o(19860);
    return this;
  }
  
  public final g PW()
  {
    AppMethodBeat.i(19861);
    this.dEN = bs.eWj();
    super.bd("FinishDownloadTimeStampMs", this.dEN);
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
      dEP = new a("ok", 0, 0);
      dEQ = new a("cancel", 1, 1);
      dER = new a("error", 2, 2);
      dES = new a[] { dEP, dEQ, dER };
      AppMethodBeat.o(19859);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.g
 * JD-Core Version:    0.7.0.1
 */
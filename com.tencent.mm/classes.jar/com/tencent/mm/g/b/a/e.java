package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
  extends a
{
  private String cPD = "";
  public long cPE = 0L;
  public long cPF = 0L;
  public long cPG = 0L;
  public boolean cPH;
  public long cPI = 0L;
  public long cPJ = 0L;
  public long cPK = 0L;
  private long cPL = 0L;
  private long cPM = 0L;
  public e.a cPN;
  
  public final String Ff()
  {
    AppMethodBeat.i(15829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cPD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cPE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cPF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cPG);
    ((StringBuffer)localObject).append(",");
    if (this.cPH)
    {
      i = 1;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cPI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cPJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cPK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cPL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cPM);
      ((StringBuffer)localObject).append(",");
      if (this.cPN == null) {
        break label225;
      }
    }
    label225:
    for (int i = this.cPN.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(15829);
      return localObject;
      i = 0;
      break;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(15830);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.cPD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.cPE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.cPF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCreateTime:").append(this.cPG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHdImgBool:").append(this.cPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgSize:").append(this.cPI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgWidth:").append(this.cPJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgHeight:").append(this.cPK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTimeStampMs:").append(this.cPL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishDownloadTimeStampMs:").append(this.cPM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishCode:").append(this.cPN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(15830);
    return localObject;
  }
  
  public final e Fj()
  {
    AppMethodBeat.i(15827);
    this.cPL = bo.aoy();
    super.az("StartDownloadTimeStampMs", this.cPL);
    AppMethodBeat.o(15827);
    return this;
  }
  
  public final e Fk()
  {
    AppMethodBeat.i(15828);
    this.cPM = bo.aoy();
    super.az("FinishDownloadTimeStampMs", this.cPM);
    AppMethodBeat.o(15828);
    return this;
  }
  
  public final e eQ(String paramString)
  {
    AppMethodBeat.i(15826);
    this.cPD = t("ChatName", paramString, true);
    AppMethodBeat.o(15826);
    return this;
  }
  
  public final int getId()
  {
    return 15749;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.e
 * JD-Core Version:    0.7.0.1
 */
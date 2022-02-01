package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ge
  extends a
{
  private String dTr = "";
  public long enI = 0L;
  private String eoH = "";
  public long eoI = 0L;
  private String eoJ = "";
  public long eoK = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(94854);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enI);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(94854);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(94855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterObjectId:").append(this.eoH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinCount:").append(this.eoI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinList:").append(this.eoJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewVideoCount:").append(this.eoK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.enI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94855);
    return localObject;
  }
  
  public final int getId()
  {
    return 16843;
  }
  
  public final ge pq(String paramString)
  {
    AppMethodBeat.i(94851);
    this.eoH = t("EnterObjectId", paramString, true);
    AppMethodBeat.o(94851);
    return this;
  }
  
  public final ge pr(String paramString)
  {
    AppMethodBeat.i(94852);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(94852);
    return this;
  }
  
  public final ge pt(String paramString)
  {
    AppMethodBeat.i(94853);
    this.eoJ = t("ExposeUinList", paramString, true);
    AppMethodBeat.o(94853);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ge
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bq
  extends a
{
  public long cYJ = 0L;
  public long cYK = 0L;
  private String cYL = "";
  private String cYM = "";
  private String cYN = "";
  private String cYO = "";
  private String cYP = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(56600);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cYJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYP);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(56600);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(56601);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PayType:").append(this.cYJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CallbackType:").append(this.cYK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceH5Url:").append(this.cYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppUsername:").append(this.cYM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppPath:").append(this.cYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppUsername:").append(this.cYO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppPath:").append(this.cYP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(56601);
    return localObject;
  }
  
  public final bq gL(String paramString)
  {
    AppMethodBeat.i(56595);
    this.cYL = t("SourceH5Url", paramString, false);
    AppMethodBeat.o(56595);
    return this;
  }
  
  public final bq gM(String paramString)
  {
    AppMethodBeat.i(56596);
    this.cYM = t("SourceAppUsername", paramString, true);
    AppMethodBeat.o(56596);
    return this;
  }
  
  public final bq gN(String paramString)
  {
    AppMethodBeat.i(56597);
    this.cYN = t("SourceAppPath", paramString, true);
    AppMethodBeat.o(56597);
    return this;
  }
  
  public final bq gO(String paramString)
  {
    AppMethodBeat.i(56598);
    this.cYO = t("TargetAppUsername", paramString, true);
    AppMethodBeat.o(56598);
    return this;
  }
  
  public final bq gP(String paramString)
  {
    AppMethodBeat.i(56599);
    this.cYP = t("TargetAppPath", paramString, true);
    AppMethodBeat.o(56599);
    return this;
  }
  
  public final int getId()
  {
    return 16310;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bq
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class af
  extends a
{
  private String cUg = "";
  public long cUh = 0L;
  public long cUi = 0L;
  public long cUj = 0L;
  private String cUk = "";
  public long cUl = 0L;
  public long cUm = 0L;
  private String cUn = "";
  private String cUo = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(70617);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cUg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUo);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(70617);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(70618);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("statId:").append(this.cUg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statEvent:").append(this.cUh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statTimeStamp:").append(this.cUi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("success:").append(this.cUj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.cUk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.cUl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.cUm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("netType:").append(this.cUn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("jsError:").append(this.cUo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(70618);
    return localObject;
  }
  
  public final af fA(String paramString)
  {
    AppMethodBeat.i(70613);
    this.cUg = t("statId", paramString, true);
    AppMethodBeat.o(70613);
    return this;
  }
  
  public final af fB(String paramString)
  {
    AppMethodBeat.i(70614);
    this.cUk = t("appid", paramString, true);
    AppMethodBeat.o(70614);
    return this;
  }
  
  public final af fC(String paramString)
  {
    AppMethodBeat.i(70615);
    this.cUn = t("netType", paramString, true);
    AppMethodBeat.o(70615);
    return this;
  }
  
  public final af fD(String paramString)
  {
    AppMethodBeat.i(70616);
    this.cUo = t("jsError", paramString, true);
    AppMethodBeat.o(70616);
    return this;
  }
  
  public final int getId()
  {
    return 14452;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.af
 * JD-Core Version:    0.7.0.1
 */
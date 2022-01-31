package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class di
  extends a
{
  public long cTE = 0L;
  private String cTJ = "";
  private String cUs = "";
  private String cYE = "";
  private String dfc = "";
  private String dfi = "";
  private String dfj = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(91290);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cTE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfj);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(91290);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(91291);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.cTE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.cYE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.dfc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.cTJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.cUs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resulttype:").append(this.dfi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtypelist:").append(this.dfj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91291);
    return localObject;
  }
  
  public final int getId()
  {
    return 16032;
  }
  
  public final di iH(String paramString)
  {
    AppMethodBeat.i(91284);
    this.cYE = t("content", paramString, true);
    AppMethodBeat.o(91284);
    return this;
  }
  
  public final di iI(String paramString)
  {
    AppMethodBeat.i(91285);
    this.dfc = t("searchid", paramString, true);
    AppMethodBeat.o(91285);
    return this;
  }
  
  public final di iJ(String paramString)
  {
    AppMethodBeat.i(91286);
    this.cTJ = t("sessionid", paramString, true);
    AppMethodBeat.o(91286);
    return this;
  }
  
  public final di iK(String paramString)
  {
    AppMethodBeat.i(91287);
    this.cUs = t("query", paramString, true);
    AppMethodBeat.o(91287);
    return this;
  }
  
  public final di iL(String paramString)
  {
    AppMethodBeat.i(91288);
    this.dfi = t("resulttype", paramString, true);
    AppMethodBeat.o(91288);
    return this;
  }
  
  public final di iM(String paramString)
  {
    AppMethodBeat.i(91289);
    this.dfj = t("resultsubtypelist", paramString, true);
    AppMethodBeat.o(91289);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.di
 * JD-Core Version:    0.7.0.1
 */
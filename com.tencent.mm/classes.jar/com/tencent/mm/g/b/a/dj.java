package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dj
  extends a
{
  private String dfk = "";
  private String dfl = "";
  private String dfm = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(70625);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dfk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfm);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(70625);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(70626);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("WidgetAppid:").append(this.dfk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SrcAppid:").append(this.dfl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DrawData:").append(this.dfm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(70626);
    return localObject;
  }
  
  public final int getId()
  {
    return 16358;
  }
  
  public final dj iN(String paramString)
  {
    AppMethodBeat.i(70622);
    this.dfk = t("WidgetAppid", paramString, true);
    AppMethodBeat.o(70622);
    return this;
  }
  
  public final dj iO(String paramString)
  {
    AppMethodBeat.i(70623);
    this.dfl = t("SrcAppid", paramString, true);
    AppMethodBeat.o(70623);
    return this;
  }
  
  public final dj iP(String paramString)
  {
    AppMethodBeat.i(70624);
    this.dfm = t("DrawData", paramString, true);
    AppMethodBeat.o(70624);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dj
 * JD-Core Version:    0.7.0.1
 */
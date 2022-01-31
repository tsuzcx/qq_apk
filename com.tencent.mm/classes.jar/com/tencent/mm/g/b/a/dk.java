package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dk
  extends a
{
  public long dfn = 0L;
  private String dfo = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(91293);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfo);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(91293);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(91294);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("canPreload:").append(this.dfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("existPkgInfo:").append(this.dfo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91294);
    return localObject;
  }
  
  public final int getId()
  {
    return 15779;
  }
  
  public final dk iQ(String paramString)
  {
    AppMethodBeat.i(91292);
    this.dfo = t("existPkgInfo", paramString, true);
    AppMethodBeat.o(91292);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dk
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dg
  extends a
{
  public long cOc = 0L;
  private String cUs = "";
  public long dfb = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(61715);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dfb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cOc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUs);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(61715);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(61716);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionScene:").append(this.dfb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.cOc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.cUs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(61716);
    return localObject;
  }
  
  public final int getId()
  {
    return 15776;
  }
  
  public final dg iB(String paramString)
  {
    AppMethodBeat.i(61714);
    this.cUs = t("query", paramString, true);
    AppMethodBeat.o(61714);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dg
 * JD-Core Version:    0.7.0.1
 */
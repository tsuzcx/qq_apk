package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ad
  extends a
{
  public long cTZ = 0L;
  private String cUa = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(77605);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cTZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUa);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(77605);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(77606);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.cTZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.cUa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(77606);
    return localObject;
  }
  
  public final ad fy(String paramString)
  {
    AppMethodBeat.i(77604);
    this.cUa = t("emoticonMd5", paramString, true);
    AppMethodBeat.o(77604);
    return this;
  }
  
  public final int getId()
  {
    return 16868;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ad
 * JD-Core Version:    0.7.0.1
 */
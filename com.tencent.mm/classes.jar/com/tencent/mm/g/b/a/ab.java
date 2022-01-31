package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ab
  extends a
{
  public long cTZ = 0L;
  private String cUa = "";
  public long cUb = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(77600);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cTZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUb);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(77600);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(77601);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.cTZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.cUa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasTxt:").append(this.cUb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(77601);
    return localObject;
  }
  
  public final ab fx(String paramString)
  {
    AppMethodBeat.i(77599);
    this.cUa = t("emoticonMd5", paramString, true);
    AppMethodBeat.o(77599);
    return this;
  }
  
  public final int getId()
  {
    return 16872;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ab
 * JD-Core Version:    0.7.0.1
 */
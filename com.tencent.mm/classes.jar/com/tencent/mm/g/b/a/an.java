package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class an
  extends a
{
  private String cSd = "";
  private long cUG = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(35566);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cSd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUG);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(35566);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(35567);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.cSd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.cUG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(35567);
    return localObject;
  }
  
  public final an Fo()
  {
    AppMethodBeat.i(35565);
    this.cUG = bo.aoy();
    super.az("ClickTimeStampMs", this.cUG);
    AppMethodBeat.o(35565);
    return this;
  }
  
  public final an fS(String paramString)
  {
    AppMethodBeat.i(35564);
    this.cSd = t("SessionId", paramString, true);
    AppMethodBeat.o(35564);
    return this;
  }
  
  public final int getId()
  {
    return 15988;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.an
 * JD-Core Version:    0.7.0.1
 */
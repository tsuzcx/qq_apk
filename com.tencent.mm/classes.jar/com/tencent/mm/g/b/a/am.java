package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class am
  extends a
{
  private String cSd = "";
  public long cUF = 0L;
  private long cUG = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(35562);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cUF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUG);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(35562);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(35563);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Entrance:").append(this.cUF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.cSd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.cUG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(35563);
    return localObject;
  }
  
  public final am Fn()
  {
    AppMethodBeat.i(35561);
    this.cUG = bo.aoy();
    super.az("ClickTimeStampMs", this.cUG);
    AppMethodBeat.o(35561);
    return this;
  }
  
  public final am fR(String paramString)
  {
    AppMethodBeat.i(35560);
    this.cSd = t("SessionId", paramString, true);
    AppMethodBeat.o(35560);
    return this;
  }
  
  public final int getId()
  {
    return 15987;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.am
 * JD-Core Version:    0.7.0.1
 */
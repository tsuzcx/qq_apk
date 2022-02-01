package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ez
  extends a
{
  private String dYb = "";
  public long eaB = 0L;
  public long eaD = 0L;
  public long eaE = 0L;
  public long eaF = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eaD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaB);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(43481);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DeleteReason:").append(this.eaD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.dYb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DebugType:").append(this.eaE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteCount:").append(this.eaF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.eaB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43482);
    return localObject;
  }
  
  public final int getId()
  {
    return 15402;
  }
  
  public final ez kX(String paramString)
  {
    AppMethodBeat.i(43480);
    this.dYb = t("Appid", paramString, true);
    AppMethodBeat.o(43480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ez
 * JD-Core Version:    0.7.0.1
 */
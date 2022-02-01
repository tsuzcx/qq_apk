package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gr
  extends a
{
  private String dZU = "";
  public long ecH = 0L;
  public long ecJ = 0L;
  public long ecK = 0L;
  public long ecL = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecH);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(43481);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DeleteReason:").append(this.ecJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.dZU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DebugType:").append(this.ecK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteCount:").append(this.ecL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.ecH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43482);
    return localObject;
  }
  
  public final int getId()
  {
    return 15402;
  }
  
  public final gr oc(String paramString)
  {
    AppMethodBeat.i(43480);
    this.dZU = t("Appid", paramString, true);
    AppMethodBeat.o(43480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gr
 * JD-Core Version:    0.7.0.1
 */
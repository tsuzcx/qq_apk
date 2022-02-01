package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hu
  extends a
{
  private String eqs = "";
  public long etm = 0L;
  public long eto = 0L;
  public long etp = 0L;
  public long etq = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eto);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etm);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(43481);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DeleteReason:").append(this.eto);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.eqs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DebugType:").append(this.etp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteCount:").append(this.etq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.etm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43482);
    return localObject;
  }
  
  public final int getId()
  {
    return 15402;
  }
  
  public final hu qB(String paramString)
  {
    AppMethodBeat.i(43480);
    this.eqs = t("Appid", paramString, true);
    AppMethodBeat.o(43480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hu
 * JD-Core Version:    0.7.0.1
 */
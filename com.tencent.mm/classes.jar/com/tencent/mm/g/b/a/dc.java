package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dc
  extends a
{
  public long cOc = 0L;
  private String cUk = "";
  public long cUm = 0L;
  public long dea = 0L;
  public long del = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(70620);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cOc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dea);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.del);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUm);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(70620);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(70621);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.cOc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.cUk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.dea);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("drawStrategy:").append(this.del);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.cUm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(70621);
    return localObject;
  }
  
  public final int getId()
  {
    return 15841;
  }
  
  public final dc it(String paramString)
  {
    AppMethodBeat.i(70619);
    this.cUk = t("appid", paramString, true);
    AppMethodBeat.o(70619);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dc
 * JD-Core Version:    0.7.0.1
 */
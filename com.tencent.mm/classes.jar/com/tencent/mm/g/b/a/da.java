package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class da
  extends a
{
  private String cUk = "";
  public long cUm = 0L;
  private String cUs = "";
  public long dea = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(91275);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cUk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dea);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUm);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(91275);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(91276);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.cUk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.cUs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.dea);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.cUm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91276);
    return localObject;
  }
  
  public final int getId()
  {
    return 15831;
  }
  
  public final da im(String paramString)
  {
    AppMethodBeat.i(91274);
    this.cUk = t("appid", paramString, true);
    AppMethodBeat.o(91274);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.da
 * JD-Core Version:    0.7.0.1
 */
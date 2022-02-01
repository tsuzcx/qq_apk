package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gp
  extends a
{
  public long dFf = 0L;
  private String dHL = "";
  public long dQz = 0L;
  public long eha = 0L;
  public long ehq = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(76371);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eha);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQz);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(76371);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(76372);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dHL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.eha);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("drawStrategy:").append(this.ehq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.dQz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76372);
    return localObject;
  }
  
  public final int getId()
  {
    return 15841;
  }
  
  public final gp mi(String paramString)
  {
    AppMethodBeat.i(76370);
    this.dHL = t("appid", paramString, true);
    AppMethodBeat.o(76370);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gp
 * JD-Core Version:    0.7.0.1
 */
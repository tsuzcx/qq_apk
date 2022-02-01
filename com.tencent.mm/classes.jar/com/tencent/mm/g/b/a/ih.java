package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ih
  extends a
{
  public long dCS = 0L;
  private String dFy = "";
  public long dSo = 0L;
  public long ejg = 0L;
  public long ejw = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(76371);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSo);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(76371);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(76372);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.ejg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("drawStrategy:").append(this.ejw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.dSo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76372);
    return localObject;
  }
  
  public final int getId()
  {
    return 15841;
  }
  
  public final ih pn(String paramString)
  {
    AppMethodBeat.i(76370);
    this.dFy = t("appid", paramString, true);
    AppMethodBeat.o(76370);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ih
 * JD-Core Version:    0.7.0.1
 */
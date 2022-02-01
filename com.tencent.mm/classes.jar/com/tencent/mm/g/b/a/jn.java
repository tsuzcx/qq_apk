package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jn
  extends a
{
  public long dQX = 0L;
  private String dTT = "";
  public long eBP = 0L;
  public long eCf = 0L;
  public long ejD = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(76371);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejD);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(76371);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(76372);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dTT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.eBP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("drawStrategy:").append(this.eCf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.ejD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76372);
    return localObject;
  }
  
  public final int getId()
  {
    return 15841;
  }
  
  public final jn sp(String paramString)
  {
    AppMethodBeat.i(76370);
    this.dTT = t("appid", paramString, true);
    AppMethodBeat.o(76370);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jn
 * JD-Core Version:    0.7.0.1
 */
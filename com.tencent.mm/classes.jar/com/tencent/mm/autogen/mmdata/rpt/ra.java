package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ra
  extends a
{
  public String imT = "";
  public long ind = 0L;
  public long ine = 0L;
  public long jax = 0L;
  public long juA = 0L;
  public long juB = 0L;
  public long juz = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(369183);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ine);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jax);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juB);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369183);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369192);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ine);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CallPageType:").append(this.juz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HalfPageOperation:").append(this.juA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LicensePlateOperation:").append(this.juB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369192);
    return localObject;
  }
  
  public final int getId()
  {
    return 23342;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ra
 * JD-Core Version:    0.7.0.1
 */
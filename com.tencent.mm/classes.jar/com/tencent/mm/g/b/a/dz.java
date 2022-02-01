package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class dz
  extends a
{
  private String dFe = "";
  public long dTk = 0L;
  private long dTl = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(94832);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTl);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(94832);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(94833);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Entrance:").append(this.dTk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.dTl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94833);
    return localObject;
  }
  
  public final dz Rf()
  {
    AppMethodBeat.i(94831);
    this.dTl = bs.eWj();
    super.bd("ClickTimeStampMs", this.dTl);
    AppMethodBeat.o(94831);
    return this;
  }
  
  public final int getId()
  {
    return 15987;
  }
  
  public final dz lV(String paramString)
  {
    AppMethodBeat.i(94830);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(94830);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dz
 * JD-Core Version:    0.7.0.1
 */
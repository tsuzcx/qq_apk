package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class c
  extends a
{
  public long dPH = 0L;
  public int dPI = 0;
  public long dPJ = 0L;
  private int dPK = 0;
  private String dPL = "";
  private String dPM = "";
  
  public final String RD()
  {
    AppMethodBeat.i(91239);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPM);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(91239);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(91240);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_result:").append(this.dPI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_code:").append(this.dPJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session:").append(this.dPK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_ext:").append(this.dPL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session2:").append(this.dPM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91240);
    return localObject;
  }
  
  public final c gD(String paramString)
  {
    AppMethodBeat.i(91238);
    this.dPM = t("session2", paramString, true);
    AppMethodBeat.o(91238);
    return this;
  }
  
  public final int getId()
  {
    return 15894;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.c
 * JD-Core Version:    0.7.0.1
 */
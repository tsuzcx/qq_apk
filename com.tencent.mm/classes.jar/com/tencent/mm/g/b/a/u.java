package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class u
  extends a
{
  private int dHr;
  public int dHs;
  private String dHt;
  public int dHu;
  private String dHv;
  
  public final String PR()
  {
    AppMethodBeat.i(183914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHv);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(183914);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(183915);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRed:").append(this.dHs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterPid:").append(this.dHt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dHu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.dHv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183915);
    return localObject;
  }
  
  public final u fO(String paramString)
  {
    AppMethodBeat.i(183912);
    this.dHt = t("EnterPid", paramString, true);
    AppMethodBeat.o(183912);
    return this;
  }
  
  public final u fP(String paramString)
  {
    AppMethodBeat.i(183913);
    this.dHv = t("Pid", paramString, true);
    AppMethodBeat.o(183913);
    return this;
  }
  
  public final int getId()
  {
    return 19435;
  }
  
  public final int getIndex()
  {
    return this.dHu;
  }
  
  public final u hY(int paramInt)
  {
    this.dHr = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.u
 * JD-Core Version:    0.7.0.1
 */
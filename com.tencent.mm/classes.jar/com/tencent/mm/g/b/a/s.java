package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class s
  extends a
{
  private int dJp;
  public int dJq;
  private String dJr;
  public int dJs;
  private String dJt;
  
  public final String PV()
  {
    AppMethodBeat.i(183914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJt);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(183914);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(183915);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dJp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRed:").append(this.dJq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterPid:").append(this.dJr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dJs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.dJt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183915);
    return localObject;
  }
  
  public final s fX(String paramString)
  {
    AppMethodBeat.i(183912);
    this.dJr = t("EnterPid", paramString, true);
    AppMethodBeat.o(183912);
    return this;
  }
  
  public final s fY(String paramString)
  {
    AppMethodBeat.i(183913);
    this.dJt = t("Pid", paramString, true);
    AppMethodBeat.o(183913);
    return this;
  }
  
  public final int getId()
  {
    return 19435;
  }
  
  public final int getIndex()
  {
    return this.dJs;
  }
  
  public final s io(int paramInt)
  {
    this.dJp = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.s
 * JD-Core Version:    0.7.0.1
 */
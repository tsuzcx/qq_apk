package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class x
  extends a
{
  private int dPT;
  public int dUw;
  private String dUx;
  public int dUy;
  private String dUz;
  
  public final String RD()
  {
    AppMethodBeat.i(183914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUz);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(183914);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(183915);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dPT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRed:").append(this.dUw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterPid:").append(this.dUx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dUy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.dUz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183915);
    return localObject;
  }
  
  public final x gQ(String paramString)
  {
    AppMethodBeat.i(183912);
    this.dUx = t("EnterPid", paramString, true);
    AppMethodBeat.o(183912);
    return this;
  }
  
  public final x gR(String paramString)
  {
    AppMethodBeat.i(183913);
    this.dUz = t("Pid", paramString, true);
    AppMethodBeat.o(183913);
    return this;
  }
  
  public final int getId()
  {
    return 19435;
  }
  
  public final int getIndex()
  {
    return this.dUy;
  }
  
  public final x ij(int paramInt)
  {
    this.dPT = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.x
 * JD-Core Version:    0.7.0.1
 */
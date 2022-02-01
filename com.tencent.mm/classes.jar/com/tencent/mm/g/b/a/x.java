package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class x
  extends a
{
  private int dRj;
  public int dVM;
  private String dVN = "";
  public int dVO;
  private String dVP = "";
  
  public final String RC()
  {
    AppMethodBeat.i(183914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVP);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(183914);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(183915);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dRj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRed:").append(this.dVM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterPid:").append(this.dVN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dVO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.dVP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183915);
    return localObject;
  }
  
  public final x gW(String paramString)
  {
    AppMethodBeat.i(183912);
    this.dVN = t("EnterPid", paramString, true);
    AppMethodBeat.o(183912);
    return this;
  }
  
  public final x gX(String paramString)
  {
    AppMethodBeat.i(183913);
    this.dVP = t("Pid", paramString, true);
    AppMethodBeat.o(183913);
    return this;
  }
  
  public final int getId()
  {
    return 19435;
  }
  
  public final int getIndex()
  {
    return this.dVO;
  }
  
  public final x il(int paramInt)
  {
    this.dRj = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.x
 * JD-Core Version:    0.7.0.1
 */
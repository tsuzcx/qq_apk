package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aq
  extends a
{
  private int eki;
  public int eqf;
  private String eqg = "";
  public int eqh;
  private String eqi = "";
  
  public final String abV()
  {
    AppMethodBeat.i(183914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqi);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(183914);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(183915);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.eki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRed:").append(this.eqf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterPid:").append(this.eqg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.eqh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.eqi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183915);
    return localObject;
  }
  
  public final int getId()
  {
    return 19435;
  }
  
  public final int getIndex()
  {
    return this.eqh;
  }
  
  public final aq it(String paramString)
  {
    AppMethodBeat.i(183912);
    this.eqg = x("EnterPid", paramString, true);
    AppMethodBeat.o(183912);
    return this;
  }
  
  public final aq iu(String paramString)
  {
    AppMethodBeat.i(183913);
    this.eqi = x("Pid", paramString, true);
    AppMethodBeat.o(183913);
    return this;
  }
  
  public final aq jS(int paramInt)
  {
    this.eki = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aq
 * JD-Core Version:    0.7.0.1
 */
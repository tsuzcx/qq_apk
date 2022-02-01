package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ay
  extends a
{
  private int geN;
  public int glr;
  private String gls = "";
  public int glt;
  private String glu = "";
  
  public final String agH()
  {
    AppMethodBeat.i(183914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.geN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gls);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glu);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(183914);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(183915);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.geN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRed:").append(this.glr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterPid:").append(this.gls);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.glt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.glu);
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
    return this.glt;
  }
  
  public final ay ju(String paramString)
  {
    AppMethodBeat.i(183912);
    this.gls = z("EnterPid", paramString, true);
    AppMethodBeat.o(183912);
    return this;
  }
  
  public final ay jv(String paramString)
  {
    AppMethodBeat.i(183913);
    this.glu = z("Pid", paramString, true);
    AppMethodBeat.o(183913);
    return this;
  }
  
  public final ay lm(int paramInt)
  {
    this.geN = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ay
 * JD-Core Version:    0.7.0.1
 */
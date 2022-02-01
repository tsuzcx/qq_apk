package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class b
  extends a
{
  public long dFf = 0L;
  public int dFg = 0;
  public long dFh = 0L;
  private int dFi = 0;
  private String dFj = "";
  private String dFk = "";
  
  public final String PV()
  {
    AppMethodBeat.i(91239);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFk);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(91239);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(91240);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_result:").append(this.dFg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_code:").append(this.dFh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session:").append(this.dFi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_ext:").append(this.dFj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session2:").append(this.dFk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91240);
    return localObject;
  }
  
  public final b fS(String paramString)
  {
    AppMethodBeat.i(91238);
    this.dFk = t("session2", paramString, true);
    AppMethodBeat.o(91238);
    return this;
  }
  
  public final int getId()
  {
    return 15894;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.b
 * JD-Core Version:    0.7.0.1
 */
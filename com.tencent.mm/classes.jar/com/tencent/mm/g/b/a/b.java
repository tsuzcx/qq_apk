package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class b
  extends a
{
  public long dCS = 0L;
  public int dCT = 0;
  public long dCU = 0L;
  private int dCV = 0;
  private String dCW = "";
  private String dCX = "";
  
  public final String PR()
  {
    AppMethodBeat.i(91239);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCX);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(91239);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(91240);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_result:").append(this.dCT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_code:").append(this.dCU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session:").append(this.dCV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_ext:").append(this.dCW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session2:").append(this.dCX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91240);
    return localObject;
  }
  
  public final b fI(String paramString)
  {
    AppMethodBeat.i(91238);
    this.dCX = t("session2", paramString, true);
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
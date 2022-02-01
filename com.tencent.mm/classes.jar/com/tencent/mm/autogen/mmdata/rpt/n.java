package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class n
  extends a
{
  public long ila = 0L;
  public int ilb = 0;
  public long ilc = 0L;
  private int ild = 0;
  private String ile = "";
  private String ilf = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(91239);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ild);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ile);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(91239);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(91240);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_result:").append(this.ilb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_code:").append(this.ilc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session:").append(this.ild);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_ext:").append(this.ile);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session2:").append(this.ilf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91240);
    return localObject;
  }
  
  public final int getId()
  {
    return 15894;
  }
  
  public final n kf(String paramString)
  {
    AppMethodBeat.i(91238);
    this.ilf = F("session2", paramString, true);
    AppMethodBeat.o(91238);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.n
 * JD-Core Version:    0.7.0.1
 */
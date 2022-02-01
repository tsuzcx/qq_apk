package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class l
  extends a
{
  public long geB = 0L;
  public int geC = 0;
  public long geD = 0L;
  private int geE = 0;
  private String geF = "";
  private String geG = "";
  
  public final String agH()
  {
    AppMethodBeat.i(91239);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geG);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(91239);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(91240);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_result:").append(this.geC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_code:").append(this.geD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session:").append(this.geE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_ext:").append(this.geF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session2:").append(this.geG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91240);
    return localObject;
  }
  
  public final int getId()
  {
    return 15894;
  }
  
  public final l iE(String paramString)
  {
    AppMethodBeat.i(91238);
    this.geG = z("session2", paramString, true);
    AppMethodBeat.o(91238);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.l
 * JD-Core Version:    0.7.0.1
 */
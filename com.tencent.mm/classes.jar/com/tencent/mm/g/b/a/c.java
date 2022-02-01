package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class c
  extends a
{
  public long dQX = 0L;
  public int dQY = 0;
  public long dQZ = 0L;
  private int dRa = 0;
  private String dRb = "";
  private String dRc = "";
  
  public final String RC()
  {
    AppMethodBeat.i(91239);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRc);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(91239);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(91240);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_result:").append(this.dQY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_code:").append(this.dQZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session:").append(this.dRa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_ext:").append(this.dRb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session2:").append(this.dRc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91240);
    return localObject;
  }
  
  public final c gJ(String paramString)
  {
    AppMethodBeat.i(91238);
    this.dRc = t("session2", paramString, true);
    AppMethodBeat.o(91238);
    return this;
  }
  
  public final int getId()
  {
    return 15894;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.c
 * JD-Core Version:    0.7.0.1
 */
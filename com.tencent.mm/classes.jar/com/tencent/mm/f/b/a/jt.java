package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jt
  extends a
{
  private String gDY = "";
  public long gLR;
  private String gLS = "";
  private String gLT = "";
  public long geB;
  public long giO;
  public long gzn;
  
  public final jt AL(String paramString)
  {
    AppMethodBeat.i(184771);
    this.gDY = z("roomId", paramString, true);
    AppMethodBeat.o(184771);
    return this;
  }
  
  public final jt AM(String paramString)
  {
    AppMethodBeat.i(184772);
    this.gLS = z("todoid", paramString, true);
    AppMethodBeat.o(184772);
    return this;
  }
  
  public final jt AN(String paramString)
  {
    AppMethodBeat.i(193621);
    this.gLT = z("appusername", paramString, true);
    AppMethodBeat.o(193621);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(184773);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gDY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLT);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184773);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184774);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.gDY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.giO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.gzn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.gLR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.gLS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.gLT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184774);
    return localObject;
  }
  
  public final int getId()
  {
    return 19444;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jt
 * JD-Core Version:    0.7.0.1
 */
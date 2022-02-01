package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class js
  extends a
{
  private String gDY = "";
  private long gLR;
  private String gLS = "";
  private String gLT = "";
  public long giO;
  public long gmT;
  public long gzn;
  
  public final js AI(String paramString)
  {
    AppMethodBeat.i(184767);
    this.gDY = z("roomId", paramString, true);
    AppMethodBeat.o(184767);
    return this;
  }
  
  public final js AJ(String paramString)
  {
    AppMethodBeat.i(184768);
    this.gLS = z("todoid", paramString, true);
    AppMethodBeat.o(184768);
    return this;
  }
  
  public final js AK(String paramString)
  {
    AppMethodBeat.i(193680);
    this.gLT = z("appusername", paramString, true);
    AppMethodBeat.o(193680);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(184769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gDY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLT);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184769);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.gDY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.giO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.gzn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.gLR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.gLS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.gLT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184770);
    return localObject;
  }
  
  public final js amg()
  {
    this.gLR = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 19443;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.f.b.a.js
 * JD-Core Version:    0.7.0.1
 */
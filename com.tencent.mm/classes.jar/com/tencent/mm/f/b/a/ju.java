package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ju
  extends a
{
  private String gDw = "";
  public long gLR;
  private String gLS = "";
  private String gLT = "";
  public long gLU;
  public long geB;
  public long giO;
  public long gzn;
  
  public final ju AO(String paramString)
  {
    AppMethodBeat.i(184775);
    this.gDw = z("roomid", paramString, true);
    AppMethodBeat.o(184775);
    return this;
  }
  
  public final ju AP(String paramString)
  {
    AppMethodBeat.i(194611);
    this.gLS = z("todoid", paramString, true);
    AppMethodBeat.o(194611);
    return this;
  }
  
  public final ju AQ(String paramString)
  {
    AppMethodBeat.i(194612);
    this.gLT = z("appusername", paramString, true);
    AppMethodBeat.o(194612);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(184776);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLT);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184776);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184777);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.gDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.giO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.gLR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.gzn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openHelp:").append(this.gLU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.gLS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.gLT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184777);
    return localObject;
  }
  
  public final int getId()
  {
    return 19442;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ju
 * JD-Core Version:    0.7.0.1
 */
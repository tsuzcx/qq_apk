package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dm
  extends a
{
  public long dCS;
  public long dFt;
  private String dNK = "";
  public long dRP;
  public long dSe;
  private String dSf = "";
  private String dSg = "";
  public long dSh;
  
  public final String PR()
  {
    AppMethodBeat.i(184776);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSg);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184776);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184777);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dFt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.dSe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.dRP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openHelp:").append(this.dSh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.dSf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.dSg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184777);
    return localObject;
  }
  
  public final int getId()
  {
    return 19442;
  }
  
  public final dm lu(String paramString)
  {
    AppMethodBeat.i(184775);
    this.dNK = t("roomid", paramString, true);
    AppMethodBeat.o(184775);
    return this;
  }
  
  public final dm lv(String paramString)
  {
    AppMethodBeat.i(197014);
    this.dSf = t("todoid", paramString, true);
    AppMethodBeat.o(197014);
    return this;
  }
  
  public final dm lw(String paramString)
  {
    AppMethodBeat.i(197015);
    this.dSg = t("appusername", paramString, true);
    AppMethodBeat.o(197015);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dm
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ei
  extends a
{
  public long dQX;
  public long dTO;
  private String eeu = "";
  public long eiW;
  public long ejt;
  private String eju = "";
  private String ejv = "";
  public long ejw;
  
  public final String RC()
  {
    AppMethodBeat.i(184776);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eju);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejv);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184776);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184777);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dTO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.ejt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.eiW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openHelp:").append(this.ejw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.eju);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.ejv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184777);
    return localObject;
  }
  
  public final int getId()
  {
    return 19442;
  }
  
  public final ei nW(String paramString)
  {
    AppMethodBeat.i(184775);
    this.eeu = t("roomid", paramString, true);
    AppMethodBeat.o(184775);
    return this;
  }
  
  public final ei nX(String paramString)
  {
    AppMethodBeat.i(217089);
    this.eju = t("todoid", paramString, true);
    AppMethodBeat.o(217089);
    return this;
  }
  
  public final ei nY(String paramString)
  {
    AppMethodBeat.i(217090);
    this.ejv = t("appusername", paramString, true);
    AppMethodBeat.o(217090);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ei
 * JD-Core Version:    0.7.0.1
 */
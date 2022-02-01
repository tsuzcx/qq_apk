package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eh
  extends a
{
  public long dQX;
  public long dTO;
  private String eeX = "";
  public long eiW;
  public long ejt;
  private String eju = "";
  private String ejv = "";
  
  public final String RC()
  {
    AppMethodBeat.i(184773);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eju);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejv);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184773);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184774);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.eeX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dTO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.eiW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.ejt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.eju);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.ejv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184774);
    return localObject;
  }
  
  public final int getId()
  {
    return 19444;
  }
  
  public final eh nT(String paramString)
  {
    AppMethodBeat.i(184771);
    this.eeX = t("roomId", paramString, true);
    AppMethodBeat.o(184771);
    return this;
  }
  
  public final eh nU(String paramString)
  {
    AppMethodBeat.i(184772);
    this.eju = t("todoid", paramString, true);
    AppMethodBeat.o(184772);
    return this;
  }
  
  public final eh nV(String paramString)
  {
    AppMethodBeat.i(217088);
    this.ejv = t("appusername", paramString, true);
    AppMethodBeat.o(217088);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eh
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hn
  extends a
{
  private String eFE = "";
  public long eLz;
  public long eMc;
  private String eMd = "";
  private String eMe = "";
  public long ejW;
  public long enM;
  
  public final String abV()
  {
    AppMethodBeat.i(184773);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eFE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMe);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184773);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184774);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.eFE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.enM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.eLz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.eMc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.eMd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.eMe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184774);
    return localObject;
  }
  
  public final int getId()
  {
    return 19444;
  }
  
  public final hn vm(String paramString)
  {
    AppMethodBeat.i(184771);
    this.eFE = x("roomId", paramString, true);
    AppMethodBeat.o(184771);
    return this;
  }
  
  public final hn vn(String paramString)
  {
    AppMethodBeat.i(184772);
    this.eMd = x("todoid", paramString, true);
    AppMethodBeat.o(184772);
    return this;
  }
  
  public final hn vo(String paramString)
  {
    AppMethodBeat.i(194002);
    this.eMe = x("appusername", paramString, true);
    AppMethodBeat.o(194002);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hn
 * JD-Core Version:    0.7.0.1
 */
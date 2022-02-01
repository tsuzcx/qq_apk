package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ae
  extends a
{
  private long dPl;
  private String dVa;
  private String dVb;
  private String dVc;
  private long dVd;
  private long dVe;
  
  public final String RD()
  {
    AppMethodBeat.i(209041);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVe);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209041);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209042);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.dVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dVb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dVc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWording:").append(this.dVe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209042);
    return localObject;
  }
  
  public final ae cr(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final ae cs(long paramLong)
  {
    this.dPl = paramLong;
    return this;
  }
  
  public final ae ct(long paramLong)
  {
    this.dVe = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19995;
  }
  
  public final ae hc(String paramString)
  {
    AppMethodBeat.i(209038);
    this.dVa = t("Sessionid", paramString, true);
    AppMethodBeat.o(209038);
    return this;
  }
  
  public final ae hd(String paramString)
  {
    AppMethodBeat.i(209039);
    this.dVb = t("Contextid", paramString, true);
    AppMethodBeat.o(209039);
    return this;
  }
  
  public final ae he(String paramString)
  {
    AppMethodBeat.i(209040);
    this.dVc = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209040);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ae
 * JD-Core Version:    0.7.0.1
 */
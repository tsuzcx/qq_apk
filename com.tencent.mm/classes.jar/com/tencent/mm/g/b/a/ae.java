package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ae
  extends a
{
  private long dQB;
  private String dWq = "";
  private String dWr = "";
  private String dWs = "";
  private long dWt;
  private long dWu;
  
  public final String RC()
  {
    AppMethodBeat.i(189069);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWu);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189069);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189070);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dWr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dWs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWording:").append(this.dWu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189070);
    return localObject;
  }
  
  public final ae cr(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final ae cs(long paramLong)
  {
    this.dQB = paramLong;
    return this;
  }
  
  public final ae ct(long paramLong)
  {
    this.dWu = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19995;
  }
  
  public final ae hi(String paramString)
  {
    AppMethodBeat.i(189066);
    this.dWq = t("Sessionid", paramString, true);
    AppMethodBeat.o(189066);
    return this;
  }
  
  public final ae hj(String paramString)
  {
    AppMethodBeat.i(189067);
    this.dWr = t("Contextid", paramString, true);
    AppMethodBeat.o(189067);
    return this;
  }
  
  public final ae hk(String paramString)
  {
    AppMethodBeat.i(189068);
    this.dWs = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(189068);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ae
 * JD-Core Version:    0.7.0.1
 */
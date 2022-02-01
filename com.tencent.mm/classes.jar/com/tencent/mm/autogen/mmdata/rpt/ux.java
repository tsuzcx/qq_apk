package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ux
  extends a
{
  private String jFi = "";
  private String jFm = "";
  private String jFn = "";
  public long jIh;
  
  public final ux AA(String paramString)
  {
    AppMethodBeat.i(368448);
    this.jFm = F("weapp_id", paramString, true);
    AppMethodBeat.o(368448);
    return this;
  }
  
  public final ux AB(String paramString)
  {
    AppMethodBeat.i(368453);
    this.jFn = F("weapp_name", paramString, true);
    AppMethodBeat.o(368453);
    return this;
  }
  
  public final ux Az(String paramString)
  {
    AppMethodBeat.i(368443);
    this.jFi = F("session", paramString, true);
    AppMethodBeat.o(368443);
    return this;
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368460);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jFi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jIh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFn);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368460);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368466);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session:").append(this.jFi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_id:").append(this.jIh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_id:").append(this.jFm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_name:").append(this.jFn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368466);
    return localObject;
  }
  
  public final int getId()
  {
    return 21777;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ux
 * JD-Core Version:    0.7.0.1
 */
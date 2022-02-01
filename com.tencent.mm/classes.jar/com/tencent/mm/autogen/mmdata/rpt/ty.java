package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ty
  extends a
{
  public long ime;
  private String jFi = "";
  public long jFj;
  public long jFk;
  public long jFl;
  public String jFm = "";
  public String jFn = "";
  
  public final ty Aa(String paramString)
  {
    AppMethodBeat.i(368219);
    this.jFi = F("session", paramString, true);
    AppMethodBeat.o(368219);
    return this;
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368229);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jFi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ime);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFn);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368229);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368239);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session:").append(this.jFi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.ime);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_type:").append(this.jFj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_sum:").append(this.jFk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_index:").append(this.jFl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_id:").append(this.jFm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_name:").append(this.jFn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368239);
    return localObject;
  }
  
  public final int getId()
  {
    return 21775;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ty
 * JD-Core Version:    0.7.0.1
 */
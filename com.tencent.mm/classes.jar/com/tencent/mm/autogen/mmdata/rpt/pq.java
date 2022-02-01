package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pq
  extends a
{
  public long iOI;
  public String iWh = "";
  public long iqr;
  public String jcv = "";
  public long jnt;
  public long jnu;
  public String jnv = "";
  public String jnw = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369072);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jnt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jnu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jnv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jnw);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369072);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369074);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUsername:").append(this.iWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasTextStatusIcon:").append(this.jnt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.jnu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.iOI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneExtInfo:").append(this.jnv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToStatusID:").append(this.jcv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToStatusIconID:").append(this.jnw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369074);
    return localObject;
  }
  
  public final int getId()
  {
    return 22210;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pq
 * JD-Core Version:    0.7.0.1
 */
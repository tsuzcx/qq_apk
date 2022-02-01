package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jh
  extends a
{
  public long iSv = 0L;
  public String iSw = "";
  public long iSx = 0L;
  private String ijk = "";
  private String ikk = "";
  private long iqr = 0L;
  private String iuQ = "";
  private String iuU = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(116481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSx);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(116481);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(116482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.iuU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Query:").append(this.iuQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpType:").append(this.iSv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Path:").append(this.ikk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappUsrname:").append(this.iSw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ServiceType:").append(this.iSx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116482);
    return localObject;
  }
  
  public final jh aIN()
  {
    this.iqr = 47L;
    return this;
  }
  
  public final int getId()
  {
    return 16019;
  }
  
  public final jh sc(String paramString)
  {
    AppMethodBeat.i(116477);
    this.iuU = F("SearchId", paramString, true);
    AppMethodBeat.o(116477);
    return this;
  }
  
  public final jh sd(String paramString)
  {
    AppMethodBeat.i(116478);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(116478);
    return this;
  }
  
  public final jh se(String paramString)
  {
    AppMethodBeat.i(116479);
    this.iuQ = F("Query", paramString, true);
    AppMethodBeat.o(116479);
    return this;
  }
  
  public final jh sf(String paramString)
  {
    AppMethodBeat.i(116480);
    this.ikk = F("Path", paramString, true);
    AppMethodBeat.o(116480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jh
 * JD-Core Version:    0.7.0.1
 */
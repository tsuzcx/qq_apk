package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dc
  extends a
{
  private String dTr = "";
  private long dWt = 0L;
  private String edN = "";
  public long efA = 0L;
  private String efw = "";
  public long efx = 0L;
  private String efy = "";
  public String efz = "";
  
  public final String RC()
  {
    AppMethodBeat.i(116481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efA);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(116481);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(116482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.efw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Query:").append(this.edN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpType:").append(this.efx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Path:").append(this.efy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappUsrname:").append(this.efz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ServiceType:").append(this.efA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116482);
    return localObject;
  }
  
  public final dc Ta()
  {
    this.dWt = 47L;
    return this;
  }
  
  public final int getId()
  {
    return 16019;
  }
  
  public final dc mF(String paramString)
  {
    AppMethodBeat.i(116477);
    this.efw = t("SearchId", paramString, true);
    AppMethodBeat.o(116477);
    return this;
  }
  
  public final dc mG(String paramString)
  {
    AppMethodBeat.i(116478);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(116478);
    return this;
  }
  
  public final dc mH(String paramString)
  {
    AppMethodBeat.i(116479);
    this.edN = t("Query", paramString, true);
    AppMethodBeat.o(116479);
    return this;
  }
  
  public final dc mI(String paramString)
  {
    AppMethodBeat.i(116480);
    this.efy = t("Path", paramString, true);
    AppMethodBeat.o(116480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dc
 * JD-Core Version:    0.7.0.1
 */
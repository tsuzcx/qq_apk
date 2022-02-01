package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ck
  extends a
{
  private String dFe = "";
  private long dHY = 0L;
  private String dNd = "";
  private String dOH = "";
  public long dOI = 0L;
  private String dOJ = "";
  public String dOK = "";
  public long dOL = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(116481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOL);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(116481);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(116482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.dOH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Query:").append(this.dNd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpType:").append(this.dOI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Path:").append(this.dOJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappUsrname:").append(this.dOK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ServiceType:").append(this.dOL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116482);
    return localObject;
  }
  
  public final ck QN()
  {
    this.dHY = 47L;
    return this;
  }
  
  public final int getId()
  {
    return 16019;
  }
  
  public final ck kr(String paramString)
  {
    AppMethodBeat.i(116477);
    this.dOH = t("SearchId", paramString, true);
    AppMethodBeat.o(116477);
    return this;
  }
  
  public final ck ks(String paramString)
  {
    AppMethodBeat.i(116478);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(116478);
    return this;
  }
  
  public final ck kt(String paramString)
  {
    AppMethodBeat.i(116479);
    this.dNd = t("Query", paramString, true);
    AppMethodBeat.o(116479);
    return this;
  }
  
  public final ck ku(String paramString)
  {
    AppMethodBeat.i(116480);
    this.dOJ = t("Path", paramString, true);
    AppMethodBeat.o(116480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ck
 * JD-Core Version:    0.7.0.1
 */
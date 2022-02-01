package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dc
  extends a
{
  private String dSb = "";
  private long dVd = 0L;
  private String ecs = "";
  private String edW = "";
  public long edX = 0L;
  private String edY = "";
  public String edZ = "";
  public long eea = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(116481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eea);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(116481);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(116482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.edW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Query:").append(this.ecs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpType:").append(this.edX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Path:").append(this.edY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappUsrname:").append(this.edZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ServiceType:").append(this.eea);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116482);
    return localObject;
  }
  
  public final dc SU()
  {
    this.dVd = 47L;
    return this;
  }
  
  public final int getId()
  {
    return 16019;
  }
  
  public final dc mn(String paramString)
  {
    AppMethodBeat.i(116477);
    this.edW = t("SearchId", paramString, true);
    AppMethodBeat.o(116477);
    return this;
  }
  
  public final dc mo(String paramString)
  {
    AppMethodBeat.i(116478);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(116478);
    return this;
  }
  
  public final dc mp(String paramString)
  {
    AppMethodBeat.i(116479);
    this.ecs = t("Query", paramString, true);
    AppMethodBeat.o(116479);
    return this;
  }
  
  public final dc mq(String paramString)
  {
    AppMethodBeat.i(116480);
    this.edY = t("Path", paramString, true);
    AppMethodBeat.o(116480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dc
 * JD-Core Version:    0.7.0.1
 */
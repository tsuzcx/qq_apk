package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ay
  extends a
{
  private String dHr = "";
  private long dKe = 0L;
  private String dMC = "";
  private String dNe = "";
  public long dNf = 0L;
  private String dNg = "";
  public String dNh = "";
  public long dNi = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(116481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNi);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(116481);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(116482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.dNe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Query:").append(this.dMC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpType:").append(this.dNf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Path:").append(this.dNg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappUsrname:").append(this.dNh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ServiceType:").append(this.dNi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116482);
    return localObject;
  }
  
  public final ay Ql()
  {
    this.dKe = 47L;
    return this;
  }
  
  public final int getId()
  {
    return 16019;
  }
  
  public final ay hP(String paramString)
  {
    AppMethodBeat.i(116477);
    this.dNe = t("SearchId", paramString, true);
    AppMethodBeat.o(116477);
    return this;
  }
  
  public final ay hQ(String paramString)
  {
    AppMethodBeat.i(116478);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(116478);
    return this;
  }
  
  public final ay hR(String paramString)
  {
    AppMethodBeat.i(116479);
    this.dMC = t("Query", paramString, true);
    AppMethodBeat.o(116479);
    return this;
  }
  
  public final ay hS(String paramString)
  {
    AppMethodBeat.i(116480);
    this.dNg = t("Path", paramString, true);
    AppMethodBeat.o(116480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ay
 * JD-Core Version:    0.7.0.1
 */
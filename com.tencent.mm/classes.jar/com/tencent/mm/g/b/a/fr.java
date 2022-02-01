package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fr
  extends a
{
  private String eGT = "";
  public long eGU = 0L;
  private String eGV = "";
  public String eGW = "";
  public long eGX = 0L;
  private String eiB = "";
  private String eqv = "";
  private long erW = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(116481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGX);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(116481);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(116482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.eGT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Query:").append(this.eqv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpType:").append(this.eGU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Path:").append(this.eGV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappUsrname:").append(this.eGW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ServiceType:").append(this.eGX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116482);
    return localObject;
  }
  
  public final fr agD()
  {
    this.erW = 47L;
    return this;
  }
  
  public final int getId()
  {
    return 16019;
  }
  
  public final fr sF(String paramString)
  {
    AppMethodBeat.i(116477);
    this.eGT = x("SearchId", paramString, true);
    AppMethodBeat.o(116477);
    return this;
  }
  
  public final fr sG(String paramString)
  {
    AppMethodBeat.i(116478);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(116478);
    return this;
  }
  
  public final fr sH(String paramString)
  {
    AppMethodBeat.i(116479);
    this.eqv = x("Query", paramString, true);
    AppMethodBeat.o(116479);
    return this;
  }
  
  public final fr sI(String paramString)
  {
    AppMethodBeat.i(116480);
    this.eGV = x("Path", paramString, true);
    AppMethodBeat.o(116480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fr
 * JD-Core Version:    0.7.0.1
 */
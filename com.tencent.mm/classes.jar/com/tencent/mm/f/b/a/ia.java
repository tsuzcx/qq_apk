package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ia
  extends a
{
  public String gHJ = "";
  public long gHK = 0L;
  public long gHL = 2L;
  public long gHM = 0L;
  public String gHN = "";
  public long gHO;
  public String gHP = "";
  
  public final String agH()
  {
    AppMethodBeat.i(255195);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gHJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHP);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(255195);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(255197);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("HasConfirmed:").append(this.gHJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Oper:").append(this.gHK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSideNote:").append(this.gHL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalShareCount:").append(this.gHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalShareCountByType:").append(this.gHN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardScene:").append(this.gHO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsername:").append(this.gHP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(255197);
    return localObject;
  }
  
  public final int getId()
  {
    return 20559;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ia
 * JD-Core Version:    0.7.0.1
 */
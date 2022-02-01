package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nb
  extends a
{
  public long gBe = 0L;
  public String gTZ = "";
  public long gWB = 0L;
  public long gXL = 0L;
  public String gXM = "";
  private int gXN = -1;
  
  public final String agH()
  {
    AppMethodBeat.i(283580);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gBe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gWB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTZ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(283580);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(283581);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.gBe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickedType:").append(this.gWB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpResult:").append(this.gXL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.gXM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.gXN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextStatusID:").append(this.gTZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(283581);
    return localObject;
  }
  
  public final int getId()
  {
    return 16055;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.nb
 * JD-Core Version:    0.7.0.1
 */
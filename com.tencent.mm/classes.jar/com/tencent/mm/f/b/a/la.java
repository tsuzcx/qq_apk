package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class la
  extends a
{
  private String gOX = "";
  public int gPU = -1;
  public int gPV = -1;
  public int geN = -1;
  public int ggl = -1;
  private String gqd = "";
  
  public final la BR(String paramString)
  {
    AppMethodBeat.i(94845);
    this.gqd = z("Username", paramString, true);
    AppMethodBeat.o(94845);
    return this;
  }
  
  public final la BS(String paramString)
  {
    AppMethodBeat.i(94846);
    this.gOX = z("PublishId", paramString, true);
    AppMethodBeat.o(94846);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(94847);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(94847);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(94848);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.gqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishId:").append(this.gOX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.geN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OnDestroyAction:").append(this.gPU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.gPV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94848);
    return localObject;
  }
  
  public final int getId()
  {
    return 18197;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.la
 * JD-Core Version:    0.7.0.1
 */
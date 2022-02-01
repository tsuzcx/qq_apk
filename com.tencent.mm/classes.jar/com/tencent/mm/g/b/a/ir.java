package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ir
  extends a
{
  private String eOG = "";
  public int ePy = -1;
  public int ePz = -1;
  public int eki = -1;
  public int enq = -1;
  private String etW = "";
  
  public final String abV()
  {
    AppMethodBeat.i(94847);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePz);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(94847);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(94848);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.etW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishId:").append(this.eOG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.eki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OnDestroyAction:").append(this.ePy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.enq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.ePz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94848);
    return localObject;
  }
  
  public final int getId()
  {
    return 18197;
  }
  
  public final ir wq(String paramString)
  {
    AppMethodBeat.i(94845);
    this.etW = x("Username", paramString, true);
    AppMethodBeat.o(94845);
    return this;
  }
  
  public final ir wr(String paramString)
  {
    AppMethodBeat.i(94846);
    this.eOG = x("PublishId", paramString, true);
    AppMethodBeat.o(94846);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ir
 * JD-Core Version:    0.7.0.1
 */
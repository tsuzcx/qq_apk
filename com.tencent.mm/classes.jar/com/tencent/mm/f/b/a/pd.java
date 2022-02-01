package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pd
  extends a
{
  private String gfk = "";
  private String hdK = "";
  
  public final pd FZ(String paramString)
  {
    AppMethodBeat.i(282380);
    this.hdK = z("instanceId", paramString, true);
    AppMethodBeat.o(282380);
    return this;
  }
  
  public final pd Ga(String paramString)
  {
    AppMethodBeat.i(282382);
    this.gfk = z("flags", paramString, true);
    AppMethodBeat.o(282382);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(282386);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hdK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfk);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(282386);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(282387);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("instanceId:").append(this.hdK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("flags:").append(this.gfk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(282387);
    return localObject;
  }
  
  public final String getFlags()
  {
    return this.gfk;
  }
  
  public final int getId()
  {
    return 21750;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pd
 * JD-Core Version:    0.7.0.1
 */
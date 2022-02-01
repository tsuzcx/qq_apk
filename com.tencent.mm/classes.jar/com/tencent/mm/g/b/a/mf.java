package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mf
  extends a
{
  private String ekF = "";
  private String faS = "";
  
  public final String abV()
  {
    AppMethodBeat.i(226080);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.faS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekF);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(226080);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(226081);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("instanceId:").append(this.faS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("flags:").append(this.ekF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226081);
    return localObject;
  }
  
  public final String getFlags()
  {
    return this.ekF;
  }
  
  public final int getId()
  {
    return 21750;
  }
  
  public final mf zt(String paramString)
  {
    AppMethodBeat.i(226078);
    this.faS = x("instanceId", paramString, true);
    AppMethodBeat.o(226078);
    return this;
  }
  
  public final mf zu(String paramString)
  {
    AppMethodBeat.i(226079);
    this.ekF = x("flags", paramString, true);
    AppMethodBeat.o(226079);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mf
 * JD-Core Version:    0.7.0.1
 */
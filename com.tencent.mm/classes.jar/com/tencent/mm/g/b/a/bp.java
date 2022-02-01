package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bp
  extends a
{
  private String eiB = "";
  private long etn;
  private String eto = "";
  
  public final String abV()
  {
    AppMethodBeat.i(208901);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eto);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208901);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208902);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTimeStampMs:").append(this.etn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinerUsername:").append(this.eto);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208902);
    return localObject;
  }
  
  public final bp ep(long paramLong)
  {
    AppMethodBeat.i(208898);
    this.etn = paramLong;
    super.bj("EnterTimeStampMs", this.etn);
    AppMethodBeat.o(208898);
    return this;
  }
  
  public final int getId()
  {
    return 19760;
  }
  
  public final bp jN(String paramString)
  {
    AppMethodBeat.i(208899);
    this.eto = x("FinerUsername", paramString, true);
    AppMethodBeat.o(208899);
    return this;
  }
  
  public final bp jO(String paramString)
  {
    AppMethodBeat.i(208900);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(208900);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bp
 * JD-Core Version:    0.7.0.1
 */
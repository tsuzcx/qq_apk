package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dz
  extends a
{
  public String eBX = "";
  private String eoj = "";
  public String epf = "";
  public long esJ;
  public long evg;
  
  public final String abV()
  {
    AppMethodBeat.i(201826);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.evg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBX);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(201826);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(201827);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ForwardType:").append(this.evg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.eoj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.epf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.esJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MonmentSessionId:").append(this.eBX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(201827);
    return localObject;
  }
  
  public final int getId()
  {
    return 21181;
  }
  
  public final dz ql(String paramString)
  {
    AppMethodBeat.i(201825);
    this.eoj = x("Feedid", paramString, true);
    AppMethodBeat.o(201825);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dz
 * JD-Core Version:    0.7.0.1
 */
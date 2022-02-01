package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cx
  extends a
{
  private long gmV;
  private long grp;
  private String grq = "";
  private String grr = "";
  private String grs = "";
  
  public final String agH()
  {
    AppMethodBeat.i(208947);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grs);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208947);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208948);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InnerVersion:").append(this.gmV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.grp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("data:").append(this.grq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tag:").append(this.grr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("majorData:").append(this.grs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208948);
    return localObject;
  }
  
  public final cx ahR()
  {
    this.gmV = 5L;
    return this;
  }
  
  public final cx gK(long paramLong)
  {
    this.grp = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21680;
  }
  
  public final cx nX(String paramString)
  {
    AppMethodBeat.i(208944);
    this.grq = z("data", paramString, true);
    AppMethodBeat.o(208944);
    return this;
  }
  
  public final cx nY(String paramString)
  {
    AppMethodBeat.i(208945);
    this.grr = z("tag", paramString, true);
    AppMethodBeat.o(208945);
    return this;
  }
  
  public final cx nZ(String paramString)
  {
    AppMethodBeat.i(208946);
    this.grs = z("majorData", paramString, true);
    AppMethodBeat.o(208946);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cx
 * JD-Core Version:    0.7.0.1
 */
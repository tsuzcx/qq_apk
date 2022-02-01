package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dx
  extends a
{
  private String iBf = "";
  private String iBg = "";
  private String iBh = "";
  private long iwf;
  public long ixD;
  
  public final String aIE()
  {
    AppMethodBeat.i(368376);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iwf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBh);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368376);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368383);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InnerVersion:").append(this.iwf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.ixD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("data:").append(this.iBf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tag:").append(this.iBg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("majorData:").append(this.iBh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368383);
    return localObject;
  }
  
  public final dx aIM()
  {
    this.iwf = 9L;
    return this;
  }
  
  public final int getId()
  {
    return 21680;
  }
  
  public final dx nZ(String paramString)
  {
    AppMethodBeat.i(368359);
    this.iBf = F("data", paramString, true);
    AppMethodBeat.o(368359);
    return this;
  }
  
  public final dx oa(String paramString)
  {
    AppMethodBeat.i(368364);
    this.iBg = F("tag", paramString, true);
    AppMethodBeat.o(368364);
    return this;
  }
  
  public final dx ob(String paramString)
  {
    AppMethodBeat.i(368368);
    this.iBh = F("majorData", paramString, true);
    AppMethodBeat.o(368368);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dx
 * JD-Core Version:    0.7.0.1
 */
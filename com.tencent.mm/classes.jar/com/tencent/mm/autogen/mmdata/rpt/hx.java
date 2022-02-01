package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hx
  extends a
{
  public String iPh = "";
  public String iPi = "";
  public long iPj = 0L;
  public long iPk = 0L;
  public long iPl = 0L;
  public String iPm = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369252);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iPh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPm);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369252);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369259);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppName:").append(this.iPh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PermissionList:").append(this.iPi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemorySize:").append(this.iPj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RamSize:").append(this.iPk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RomSize:").append(this.iPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpuInfo:").append(this.iPm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369259);
    return localObject;
  }
  
  public final int getId()
  {
    return 21976;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hx
 * JD-Core Version:    0.7.0.1
 */
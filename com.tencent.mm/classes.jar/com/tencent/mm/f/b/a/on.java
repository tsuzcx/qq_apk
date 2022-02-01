package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class on
  extends a
{
  private String gRy = "";
  private String gmF = "";
  private String hca = "";
  public long hcb;
  public long hcc;
  
  public final on FC(String paramString)
  {
    AppMethodBeat.i(174642);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(174642);
    return this;
  }
  
  public final on FD(String paramString)
  {
    AppMethodBeat.i(174643);
    this.hca = z("PagePath", paramString, true);
    AppMethodBeat.o(174643);
    return this;
  }
  
  public final on FE(String paramString)
  {
    AppMethodBeat.i(174644);
    this.gRy = z("VideoUrl", paramString, true);
    AppMethodBeat.o(174644);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(174645);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hca);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcc);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(174645);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(174646);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.hca);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.gRy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.hcb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventNote:").append(this.hcc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(174646);
    return localObject;
  }
  
  public final int getId()
  {
    return 18837;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.on
 * JD-Core Version:    0.7.0.1
 */
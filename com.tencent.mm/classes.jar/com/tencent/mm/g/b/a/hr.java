package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hr
  extends a
{
  public long eBS = 0L;
  private String eMh = "";
  public long eMi = 0L;
  public long eMj = 0L;
  public long eMk = 0L;
  public long eMl = 0L;
  private String eMm = "";
  private String eMn = "";
  private String enR = "";
  
  public final String abV()
  {
    AppMethodBeat.i(76368);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eMh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMn);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(76368);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(76369);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("statId:").append(this.eMh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statEvent:").append(this.eMi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statTimeStamp:").append(this.eMj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("success:").append(this.eMk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.enR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.eBS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.eMl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("netType:").append(this.eMm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("jsError:").append(this.eMn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76369);
    return localObject;
  }
  
  public final int getId()
  {
    return 14452;
  }
  
  public final hr vs(String paramString)
  {
    AppMethodBeat.i(76364);
    this.eMh = x("statId", paramString, true);
    AppMethodBeat.o(76364);
    return this;
  }
  
  public final hr vt(String paramString)
  {
    AppMethodBeat.i(76365);
    this.enR = x("appid", paramString, true);
    AppMethodBeat.o(76365);
    return this;
  }
  
  public final hr vu(String paramString)
  {
    AppMethodBeat.i(76366);
    this.eMm = x("netType", paramString, true);
    AppMethodBeat.o(76366);
    return this;
  }
  
  public final hr vv(String paramString)
  {
    AppMethodBeat.i(76367);
    this.eMn = x("jsError", paramString, true);
    AppMethodBeat.o(76367);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hr
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class do
  extends a
{
  private String dFy = "";
  private String dSj = "";
  public long dSk = 0L;
  public long dSl = 0L;
  public long dSm = 0L;
  public long dSn = 0L;
  public long dSo = 0L;
  private String dSp = "";
  private String dSq = "";
  
  public final String PR()
  {
    AppMethodBeat.i(76368);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSq);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(76368);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(76369);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("statId:").append(this.dSj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statEvent:").append(this.dSk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statTimeStamp:").append(this.dSl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("success:").append(this.dSm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.dSn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.dSo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("netType:").append(this.dSp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("jsError:").append(this.dSq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76369);
    return localObject;
  }
  
  public final int getId()
  {
    return 14452;
  }
  
  public final do lA(String paramString)
  {
    AppMethodBeat.i(76367);
    this.dSq = t("jsError", paramString, true);
    AppMethodBeat.o(76367);
    return this;
  }
  
  public final do lx(String paramString)
  {
    AppMethodBeat.i(76364);
    this.dSj = t("statId", paramString, true);
    AppMethodBeat.o(76364);
    return this;
  }
  
  public final do ly(String paramString)
  {
    AppMethodBeat.i(76365);
    this.dFy = t("appid", paramString, true);
    AppMethodBeat.o(76365);
    return this;
  }
  
  public final do lz(String paramString)
  {
    AppMethodBeat.i(76366);
    this.dSp = t("netType", paramString, true);
    AppMethodBeat.o(76366);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.do
 * JD-Core Version:    0.7.0.1
 */
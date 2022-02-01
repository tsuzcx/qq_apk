package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ca
  extends a
{
  private String dHL = "";
  private String dQA = "";
  private String dQB = "";
  private String dQu = "";
  public long dQv = 0L;
  public long dQw = 0L;
  public long dQx = 0L;
  public long dQy = 0L;
  public long dQz = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(76368);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(76368);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(76369);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("statId:").append(this.dQu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statEvent:").append(this.dQv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statTimeStamp:").append(this.dQw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("success:").append(this.dQx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dHL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.dQy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.dQz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("netType:").append(this.dQA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("jsError:").append(this.dQB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76369);
    return localObject;
  }
  
  public final int getId()
  {
    return 14452;
  }
  
  public final ca iH(String paramString)
  {
    AppMethodBeat.i(76364);
    this.dQu = t("statId", paramString, true);
    AppMethodBeat.o(76364);
    return this;
  }
  
  public final ca iI(String paramString)
  {
    AppMethodBeat.i(76365);
    this.dHL = t("appid", paramString, true);
    AppMethodBeat.o(76365);
    return this;
  }
  
  public final ca iJ(String paramString)
  {
    AppMethodBeat.i(76366);
    this.dQA = t("netType", paramString, true);
    AppMethodBeat.o(76366);
    return this;
  }
  
  public final ca iK(String paramString)
  {
    AppMethodBeat.i(76367);
    this.dQB = t("jsError", paramString, true);
    AppMethodBeat.o(76367);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ca
 * JD-Core Version:    0.7.0.1
 */
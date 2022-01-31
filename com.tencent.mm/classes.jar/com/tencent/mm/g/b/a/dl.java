package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dl
  extends a
{
  private String cUk = "";
  public long dfp = 0L;
  private String dfq = "";
  private String dfr = "";
  public long dfs = 0L;
  public long dft = 0L;
  public long dfu = 0L;
  public long dfv = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(91298);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cUk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dft);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfv);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(91298);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(91299);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.cUk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appVersion:").append(this.dfp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pkgMd5:").append(this.dfq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("downloadUrl:").append(this.dfr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSuccess:").append(this.dfs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeCostInMs:").append(this.dft);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeStampInMs:").append(this.dfu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.dfv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91299);
    return localObject;
  }
  
  public final int getId()
  {
    return 15778;
  }
  
  public final dl iR(String paramString)
  {
    AppMethodBeat.i(91295);
    this.cUk = t("appid", paramString, true);
    AppMethodBeat.o(91295);
    return this;
  }
  
  public final dl iS(String paramString)
  {
    AppMethodBeat.i(91296);
    this.dfq = t("pkgMd5", paramString, true);
    AppMethodBeat.o(91296);
    return this;
  }
  
  public final dl iT(String paramString)
  {
    AppMethodBeat.i(91297);
    this.dfr = t("downloadUrl", paramString, true);
    AppMethodBeat.o(91297);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dl
 * JD-Core Version:    0.7.0.1
 */
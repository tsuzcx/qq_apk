package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class or
  extends a
{
  public long gYL = 0L;
  private String gcU = "";
  private String gmF = "";
  public long gnP = 0L;
  public or.b hcA;
  public long hcB = 0L;
  public long hcC = 0L;
  public long hcD = 0L;
  public long hcE = 0L;
  public long hcF = 0L;
  public or.a hcz;
  
  public final or FK(String paramString)
  {
    AppMethodBeat.i(43489);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(43489);
    return this;
  }
  
  public final or FL(String paramString)
  {
    AppMethodBeat.i(43490);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43490);
    return this;
  }
  
  public final String agH()
  {
    int j = -1;
    AppMethodBeat.i(43491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hcz != null) {}
    for (int i = this.hcz.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.hcA != null) {
        i = this.hcA.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gnP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcF);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43491);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hcz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.hcA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.hcB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadKey:").append(this.hcC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadValue:").append(this.hcD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.hcE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasSplashScreen:").append(this.hcF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43492);
    return localObject;
  }
  
  public final int getId()
  {
    return 16602;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.or
 * JD-Core Version:    0.7.0.1
 */
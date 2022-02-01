package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class el
  extends a
{
  private String dTT = "";
  public long ejA = 0L;
  public long ejB = 0L;
  public long ejC = 0L;
  public long ejD = 0L;
  private String ejE = "";
  private String ejF = "";
  private String ejy = "";
  public long ejz = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(76368);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejF);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(76368);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(76369);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("statId:").append(this.ejy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statEvent:").append(this.ejz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statTimeStamp:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("success:").append(this.ejB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dTT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.ejC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.ejD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("netType:").append(this.ejE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("jsError:").append(this.ejF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76369);
    return localObject;
  }
  
  public final int getId()
  {
    return 14452;
  }
  
  public final el nZ(String paramString)
  {
    AppMethodBeat.i(76364);
    this.ejy = t("statId", paramString, true);
    AppMethodBeat.o(76364);
    return this;
  }
  
  public final el oa(String paramString)
  {
    AppMethodBeat.i(76365);
    this.dTT = t("appid", paramString, true);
    AppMethodBeat.o(76365);
    return this;
  }
  
  public final el ob(String paramString)
  {
    AppMethodBeat.i(76366);
    this.ejE = t("netType", paramString, true);
    AppMethodBeat.o(76366);
    return this;
  }
  
  public final el oc(String paramString)
  {
    AppMethodBeat.i(76367);
    this.ejF = t("jsError", paramString, true);
    AppMethodBeat.o(76367);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.el
 * JD-Core Version:    0.7.0.1
 */
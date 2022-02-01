package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ep
  extends a
{
  private String gdM = "";
  public int geN;
  private String gyg = "";
  public int gyh;
  public int gyi;
  public int gyj;
  
  public final String agH()
  {
    AppMethodBeat.i(242094);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gdM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geN);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(242094);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(242095);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("TipsId:").append(this.gdM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Path:").append(this.gyg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeCountLimit:").append(this.gyh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeLimitStrategy:").append(this.gyi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeCount:").append(this.gyj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.geN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(242095);
    return localObject;
  }
  
  public final int getId()
  {
    return 23303;
  }
  
  public final ep sN(String paramString)
  {
    AppMethodBeat.i(242092);
    this.gdM = z("TipsId", paramString, true);
    AppMethodBeat.o(242092);
    return this;
  }
  
  public final ep sO(String paramString)
  {
    AppMethodBeat.i(242093);
    this.gyg = z("Path", paramString, true);
    AppMethodBeat.o(242093);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ep
 * JD-Core Version:    0.7.0.1
 */
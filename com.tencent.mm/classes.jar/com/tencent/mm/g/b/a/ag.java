package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ag
  extends a
{
  private String cUk = "";
  private String cUp = "";
  private String cUq = "";
  private long cUr = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(91261);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cUk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUr);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(91261);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(91262);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.cUk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("api:").append(this.cUp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("arg:").append(this.cUq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampMs:").append(this.cUr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91262);
    return localObject;
  }
  
  public final ag bA(long paramLong)
  {
    AppMethodBeat.i(91260);
    this.cUr = paramLong;
    super.az("timestampMs", this.cUr);
    AppMethodBeat.o(91260);
    return this;
  }
  
  public final ag fE(String paramString)
  {
    AppMethodBeat.i(91257);
    this.cUk = t("appid", paramString, true);
    AppMethodBeat.o(91257);
    return this;
  }
  
  public final ag fF(String paramString)
  {
    AppMethodBeat.i(91258);
    this.cUp = t("api", paramString, true);
    AppMethodBeat.o(91258);
    return this;
  }
  
  public final ag fG(String paramString)
  {
    AppMethodBeat.i(91259);
    this.cUq = t("arg", paramString, true);
    AppMethodBeat.o(91259);
    return this;
  }
  
  public final int getId()
  {
    return 15961;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ag
 * JD-Core Version:    0.7.0.1
 */
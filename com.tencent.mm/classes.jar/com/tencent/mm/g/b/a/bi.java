package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bi
  extends a
{
  public long cXt = 0L;
  private String cXu = "";
  private String cXv = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(15833);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cXt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXv);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(15833);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(15834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("LogType:").append(this.cXt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatLanguage:").append(this.cXu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InputLanguage:").append(this.cXv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(15834);
    return localObject;
  }
  
  public final bi gE(String paramString)
  {
    AppMethodBeat.i(15831);
    this.cXu = t("WechatLanguage", paramString, true);
    AppMethodBeat.o(15831);
    return this;
  }
  
  public final bi gF(String paramString)
  {
    AppMethodBeat.i(15832);
    this.cXv = t("InputLanguage", paramString, true);
    AppMethodBeat.o(15832);
    return this;
  }
  
  public final int getId()
  {
    return 15493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bi
 * JD-Core Version:    0.7.0.1
 */
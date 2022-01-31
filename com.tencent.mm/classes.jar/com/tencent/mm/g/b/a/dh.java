package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dh
  extends a
{
  public long cTE = 0L;
  private String cTJ = "";
  private String cUs = "";
  private String dfc = "";
  public long dfd = 0L;
  private String dfe = "";
  public long dff = 0L;
  private String dfg = "";
  public long dfh = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(91282);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cTE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dff);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfh);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(91282);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(91283);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.cTE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.dfc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businesstype:").append(this.dfd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("docid:").append(this.dfe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampInMs:").append(this.dff);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("expand2:").append(this.dfg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.cUs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.cTJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtype:").append(this.dfh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91283);
    return localObject;
  }
  
  public final int getId()
  {
    return 16033;
  }
  
  public final dh iC(String paramString)
  {
    AppMethodBeat.i(91277);
    this.dfc = t("searchid", paramString, true);
    AppMethodBeat.o(91277);
    return this;
  }
  
  public final dh iD(String paramString)
  {
    AppMethodBeat.i(91278);
    this.dfe = t("docid", paramString, true);
    AppMethodBeat.o(91278);
    return this;
  }
  
  public final dh iE(String paramString)
  {
    AppMethodBeat.i(91279);
    this.dfg = t("expand2", paramString, true);
    AppMethodBeat.o(91279);
    return this;
  }
  
  public final dh iF(String paramString)
  {
    AppMethodBeat.i(91280);
    this.cUs = t("query", paramString, true);
    AppMethodBeat.o(91280);
    return this;
  }
  
  public final dh iG(String paramString)
  {
    AppMethodBeat.i(91281);
    this.cTJ = t("sessionid", paramString, true);
    AppMethodBeat.o(91281);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dh
 * JD-Core Version:    0.7.0.1
 */
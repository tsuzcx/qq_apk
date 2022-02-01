package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aw
  extends a
{
  private String dFe = "";
  private String dHM;
  private String dKQ;
  private String dKR = "";
  
  public final String PR()
  {
    AppMethodBeat.i(194987);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKR);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194987);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194988);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PostUsername:").append(this.dKQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mentionedDetailInfo:").append(this.dKR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194988);
    return localObject;
  }
  
  public final int getId()
  {
    return 19792;
  }
  
  public final aw ie(String paramString)
  {
    AppMethodBeat.i(194983);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(194983);
    return this;
  }
  
  public final aw jdMethod_if(String paramString)
  {
    AppMethodBeat.i(194984);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(194984);
    return this;
  }
  
  public final aw ig(String paramString)
  {
    AppMethodBeat.i(194985);
    this.dKQ = t("PostUsername", paramString, true);
    AppMethodBeat.o(194985);
    return this;
  }
  
  public final aw ih(String paramString)
  {
    AppMethodBeat.i(194986);
    this.dKR = t("mentionedDetailInfo", paramString, true);
    AppMethodBeat.o(194986);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aw
 * JD-Core Version:    0.7.0.1
 */
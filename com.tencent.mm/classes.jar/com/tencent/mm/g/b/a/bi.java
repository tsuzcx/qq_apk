package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bi
  extends a
{
  private String dTr = "";
  private String dWh = "";
  private String eat = "";
  private String eau = "";
  
  public final String RC()
  {
    AppMethodBeat.i(189214);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eat);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eau);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189214);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189215);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PostUsername:").append(this.eat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mentionedDetailInfo:").append(this.eau);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189215);
    return localObject;
  }
  
  public final int getId()
  {
    return 19792;
  }
  
  public final bi jO(String paramString)
  {
    AppMethodBeat.i(189210);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(189210);
    return this;
  }
  
  public final bi jP(String paramString)
  {
    AppMethodBeat.i(189211);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189211);
    return this;
  }
  
  public final bi jQ(String paramString)
  {
    AppMethodBeat.i(189212);
    this.eat = t("PostUsername", paramString, true);
    AppMethodBeat.o(189212);
    return this;
  }
  
  public final bi jR(String paramString)
  {
    AppMethodBeat.i(189213);
    this.eau = t("mentionedDetailInfo", paramString, true);
    AppMethodBeat.o(189213);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bi
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bi
  extends a
{
  private String dSb = "";
  private String dUR;
  private String dZa;
  private String dZb = "";
  
  public final String RD()
  {
    AppMethodBeat.i(209180);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZb);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209180);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209181);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PostUsername:").append(this.dZa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mentionedDetailInfo:").append(this.dZb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209181);
    return localObject;
  }
  
  public final int getId()
  {
    return 19792;
  }
  
  public final bi jC(String paramString)
  {
    AppMethodBeat.i(209176);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(209176);
    return this;
  }
  
  public final bi jD(String paramString)
  {
    AppMethodBeat.i(209177);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209177);
    return this;
  }
  
  public final bi jE(String paramString)
  {
    AppMethodBeat.i(209178);
    this.dZa = t("PostUsername", paramString, true);
    AppMethodBeat.o(209178);
    return this;
  }
  
  public final bi jF(String paramString)
  {
    AppMethodBeat.i(209179);
    this.dZb = t("mentionedDetailInfo", paramString, true);
    AppMethodBeat.o(209179);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bi
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gq
  extends a
{
  public long dTq;
  public String dWq = "";
  private String elg = "";
  public String eqA = "";
  public long eqv;
  public long eqw;
  private String eqx = "";
  public long eqy;
  public long eqz;
  
  public final String RC()
  {
    AppMethodBeat.i(218980);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqA);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(218980);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(218981);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dTq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishId:").append(this.elg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeCnt:").append(this.eqv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommCnt:").append(this.eqw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.eqx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextAction:").append(this.eqy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeCnt:").append(this.eqz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextPublishId:").append(this.eqA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(218981);
    return localObject;
  }
  
  public final int getId()
  {
    return 19750;
  }
  
  public final gq pD(String paramString)
  {
    AppMethodBeat.i(218977);
    this.elg = t("PublishId", paramString, true);
    AppMethodBeat.o(218977);
    return this;
  }
  
  public final gq pE(String paramString)
  {
    AppMethodBeat.i(218978);
    this.dWq = t("Sessionid", paramString, true);
    AppMethodBeat.o(218978);
    return this;
  }
  
  public final gq pF(String paramString)
  {
    AppMethodBeat.i(218979);
    this.eqx = t("ActionTimeStamp", paramString, true);
    AppMethodBeat.o(218979);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gq
 * JD-Core Version:    0.7.0.1
 */
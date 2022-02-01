package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bk
  extends a
{
  private String dTr = "";
  private long dWi;
  private long dWm;
  private String dXm = "";
  private String dXn = "";
  private long dXo;
  private long dXp;
  private String dYQ = "";
  
  public final String RC()
  {
    AppMethodBeat.i(168912);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWi);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(168912);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(168913);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dXm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dXn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dXo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dXp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dYQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dWi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168913);
    return localObject;
  }
  
  public final bk fU(long paramLong)
  {
    this.dWm = paramLong;
    return this;
  }
  
  public final bk fV(long paramLong)
  {
    this.dWi = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19188;
  }
  
  public final bk kg(String paramString)
  {
    AppMethodBeat.i(168908);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(168908);
    return this;
  }
  
  public final bk kh(String paramString)
  {
    AppMethodBeat.i(168909);
    this.dXm = t("Tag", paramString, true);
    AppMethodBeat.o(168909);
    return this;
  }
  
  public final bk ki(String paramString)
  {
    AppMethodBeat.i(168910);
    this.dXn = t("TagId", paramString, true);
    AppMethodBeat.o(168910);
    return this;
  }
  
  public final bk kj(String paramString)
  {
    AppMethodBeat.i(168911);
    this.dYQ = t("feedid", paramString, true);
    AppMethodBeat.o(168911);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bk
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bx
  extends a
{
  private String dTr = "";
  private String dXm = "";
  private String dXn = "";
  private long dXo;
  private long dXp;
  private long dZo;
  private long dZp;
  private String dZr = "";
  
  public final String RC()
  {
    AppMethodBeat.i(168925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZr);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(168925);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(168926);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardType:").append(this.dZo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardResult:").append(this.dZp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dXm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dXn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dXo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dXp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardToUsr:").append(this.dZr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168926);
    return localObject;
  }
  
  public final bx gY(long paramLong)
  {
    this.dZo = paramLong;
    return this;
  }
  
  public final bx gZ(long paramLong)
  {
    this.dZp = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19187;
  }
  
  public final bx ha(long paramLong)
  {
    this.dXp = paramLong;
    return this;
  }
  
  public final bx lh(String paramString)
  {
    AppMethodBeat.i(168921);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(168921);
    return this;
  }
  
  public final bx li(String paramString)
  {
    AppMethodBeat.i(168922);
    this.dXm = t("Tag", paramString, true);
    AppMethodBeat.o(168922);
    return this;
  }
  
  public final bx lj(String paramString)
  {
    AppMethodBeat.i(168923);
    this.dXn = t("TagId", paramString, true);
    AppMethodBeat.o(168923);
    return this;
  }
  
  public final bx lk(String paramString)
  {
    AppMethodBeat.i(168924);
    this.dZr = t("ForwardToUsr", paramString, true);
    AppMethodBeat.o(168924);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bx
 * JD-Core Version:    0.7.0.1
 */
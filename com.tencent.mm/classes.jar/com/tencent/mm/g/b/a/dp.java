package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dp
  extends a
{
  private String eiB = "";
  private long ejA;
  private String eoj = "";
  private String eoz = "";
  private String erH = "";
  private long ery;
  private String etW = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209149);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ery);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209149);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209150);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.etW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.eoj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ery);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209150);
    return localObject;
  }
  
  public final int getId()
  {
    return 19956;
  }
  
  public final dp kp(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
  
  public final dp kq(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final dp po(String paramString)
  {
    AppMethodBeat.i(209144);
    this.etW = x("Username", paramString, true);
    AppMethodBeat.o(209144);
    return this;
  }
  
  public final dp pp(String paramString)
  {
    AppMethodBeat.i(209145);
    this.eoj = x("Feedid", paramString, true);
    AppMethodBeat.o(209145);
    return this;
  }
  
  public final dp pq(String paramString)
  {
    AppMethodBeat.i(209146);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(209146);
    return this;
  }
  
  public final dp pr(String paramString)
  {
    AppMethodBeat.i(209147);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(209147);
    return this;
  }
  
  public final dp pt(String paramString)
  {
    AppMethodBeat.i(209148);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209148);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dp
 * JD-Core Version:    0.7.0.1
 */
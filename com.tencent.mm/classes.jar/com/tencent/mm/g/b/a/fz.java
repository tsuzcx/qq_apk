package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fz
  extends a
{
  private String eIl = "";
  private long eIm;
  private String eIn = "";
  private long eIo;
  private long eIp;
  private String els = "";
  private String elt = "";
  private String eoj = "";
  private String erH = "";
  private String eui = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209280);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eIn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eui);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoj);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209280);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209281);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickTimeStamp:").append(this.eIn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GenerateType:").append(this.eIo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GenerateScene:").append(this.eIp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MiniSessionId:").append(this.eIl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TaskOrder:").append(this.eIm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.eui);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.elt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.eoj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209281);
    return localObject;
  }
  
  public final fz agK()
  {
    this.eIp = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 21154;
  }
  
  public final fz pJ(long paramLong)
  {
    this.eIo = paramLong;
    return this;
  }
  
  public final fz pK(long paramLong)
  {
    this.eIm = paramLong;
    return this;
  }
  
  public final fz tf(String paramString)
  {
    AppMethodBeat.i(209273);
    this.eIn = x("ClickTimeStamp", paramString, true);
    AppMethodBeat.o(209273);
    return this;
  }
  
  public final fz tg(String paramString)
  {
    AppMethodBeat.i(209274);
    this.eIl = x("MiniSessionId", paramString, true);
    AppMethodBeat.o(209274);
    return this;
  }
  
  public final fz th(String paramString)
  {
    AppMethodBeat.i(209275);
    this.eui = x("LongVideoId", paramString, true);
    AppMethodBeat.o(209275);
    return this;
  }
  
  public final fz ti(String paramString)
  {
    AppMethodBeat.i(209276);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(209276);
    return this;
  }
  
  public final fz tj(String paramString)
  {
    AppMethodBeat.i(209277);
    this.elt = x("contextid", paramString, true);
    AppMethodBeat.o(209277);
    return this;
  }
  
  public final fz tk(String paramString)
  {
    AppMethodBeat.i(209278);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209278);
    return this;
  }
  
  public final fz tl(String paramString)
  {
    AppMethodBeat.i(209279);
    this.eoj = x("Feedid", paramString, true);
    AppMethodBeat.o(209279);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fz
 * JD-Core Version:    0.7.0.1
 */
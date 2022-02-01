package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ig
  extends a
{
  private String eGT = "";
  private String eOk = "";
  private String eOl = "";
  private long eOm = 0L;
  private long eOn = 0L;
  private long eOo;
  private long eOp = 0L;
  private String eiB = "";
  private long enl;
  private String eno = "";
  private long erW = 0L;
  private long esW = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(210803);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eno);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esW);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(210803);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(210804);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.eGT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMD5:").append(this.eOk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryMD5:").append(this.eOl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Offset:").append(this.eOm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pos:").append(this.eOn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientTimestamp:").append(this.eOo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.eno);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tab:").append(this.eOp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSelf:").append(this.esW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210804);
    return localObject;
  }
  
  public final int getId()
  {
    return 19651;
  }
  
  public final ig ri(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final ig rj(long paramLong)
  {
    this.eOm = paramLong;
    return this;
  }
  
  public final ig rk(long paramLong)
  {
    this.eOn = paramLong;
    return this;
  }
  
  public final ig rl(long paramLong)
  {
    this.eOo = paramLong;
    return this;
  }
  
  public final ig rm(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final ig rn(long paramLong)
  {
    this.esW = paramLong;
    return this;
  }
  
  public final ig vZ(String paramString)
  {
    AppMethodBeat.i(210798);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(210798);
    return this;
  }
  
  public final ig wa(String paramString)
  {
    AppMethodBeat.i(210799);
    this.eGT = x("SearchId", paramString, true);
    AppMethodBeat.o(210799);
    return this;
  }
  
  public final ig wb(String paramString)
  {
    AppMethodBeat.i(210800);
    this.eOk = x("ClickMD5", paramString, true);
    AppMethodBeat.o(210800);
    return this;
  }
  
  public final ig wc(String paramString)
  {
    AppMethodBeat.i(210801);
    this.eOl = x("QueryMD5", paramString, true);
    AppMethodBeat.o(210801);
    return this;
  }
  
  public final ig wd(String paramString)
  {
    AppMethodBeat.i(210802);
    this.eno = x("RequestId", paramString, true);
    AppMethodBeat.o(210802);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ig
 * JD-Core Version:    0.7.0.1
 */
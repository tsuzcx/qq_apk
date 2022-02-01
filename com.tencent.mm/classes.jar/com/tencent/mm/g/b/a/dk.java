package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dk
  extends a
{
  private long enl;
  private long eua;
  private String ezQ = "";
  private String ezY = "";
  private long ezZ;
  
  public final String abV()
  {
    AppMethodBeat.i(209123);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ezY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eua);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezZ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209123);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209124);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickId:").append(this.ezY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PostId:").append(this.ezQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.eua);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTab:").append(this.ezZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209124);
    return localObject;
  }
  
  public final int getId()
  {
    return 21149;
  }
  
  public final dk jG(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final dk jH(long paramLong)
  {
    this.eua = paramLong;
    return this;
  }
  
  public final dk jI(long paramLong)
  {
    this.ezZ = paramLong;
    return this;
  }
  
  public final dk oK(String paramString)
  {
    AppMethodBeat.i(209121);
    this.ezY = x("ClickId", paramString, true);
    AppMethodBeat.o(209121);
    return this;
  }
  
  public final dk oL(String paramString)
  {
    AppMethodBeat.i(209122);
    this.ezQ = x("PostId", paramString, true);
    AppMethodBeat.o(209122);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dk
 * JD-Core Version:    0.7.0.1
 */
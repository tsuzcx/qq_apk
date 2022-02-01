package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qz
  extends a
{
  private String hjp = "";
  private long hjr;
  private long hjs;
  private String hju = "";
  private String hlW = "";
  
  public final qz Eu(long paramLong)
  {
    this.hjr = paramLong;
    return this;
  }
  
  public final qz Ev(long paramLong)
  {
    this.hjs = paramLong;
    return this;
  }
  
  public final qz HR(String paramString)
  {
    AppMethodBeat.i(273178);
    this.hjp = z("session", paramString, true);
    AppMethodBeat.o(273178);
    return this;
  }
  
  public final qz HS(String paramString)
  {
    AppMethodBeat.i(273180);
    this.hlW = z("weapp_ID", paramString, true);
    AppMethodBeat.o(273180);
    return this;
  }
  
  public final qz HT(String paramString)
  {
    AppMethodBeat.i(273182);
    this.hju = z("weapp_name", paramString, true);
    AppMethodBeat.o(273182);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(273183);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hjp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hju);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(273183);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(273184);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session:").append(this.hjp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_sum:").append(this.hjr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_index:").append(this.hjs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_ID:").append(this.hlW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_name:").append(this.hju);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(273184);
    return localObject;
  }
  
  public final int getId()
  {
    return 21776;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qz
 * JD-Core Version:    0.7.0.1
 */
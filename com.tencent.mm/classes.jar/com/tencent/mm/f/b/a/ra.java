package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ra
  extends a
{
  private String hjp = "";
  private String hjt = "";
  private String hju = "";
  private long hlX;
  
  public final ra Ew(long paramLong)
  {
    this.hlX = paramLong;
    return this;
  }
  
  public final ra HU(String paramString)
  {
    AppMethodBeat.i(244923);
    this.hjp = z("session", paramString, true);
    AppMethodBeat.o(244923);
    return this;
  }
  
  public final ra HV(String paramString)
  {
    AppMethodBeat.i(244928);
    this.hjt = z("weapp_id", paramString, true);
    AppMethodBeat.o(244928);
    return this;
  }
  
  public final ra HW(String paramString)
  {
    AppMethodBeat.i(244929);
    this.hju = z("weapp_name", paramString, true);
    AppMethodBeat.o(244929);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(244934);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hjp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hju);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(244934);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(244935);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session:").append(this.hjp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_id:").append(this.hlX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_id:").append(this.hjt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_name:").append(this.hju);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(244935);
    return localObject;
  }
  
  public final int getId()
  {
    return 21777;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ra
 * JD-Core Version:    0.7.0.1
 */
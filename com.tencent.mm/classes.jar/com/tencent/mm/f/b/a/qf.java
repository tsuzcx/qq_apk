package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qf
  extends a
{
  private long gfA;
  private String hjp = "";
  private long hjq;
  private long hjr;
  private long hjs;
  private String hjt = "";
  private String hju = "";
  
  public final qf DE(long paramLong)
  {
    this.gfA = paramLong;
    return this;
  }
  
  public final qf DF(long paramLong)
  {
    this.hjq = paramLong;
    return this;
  }
  
  public final qf DG(long paramLong)
  {
    this.hjr = paramLong;
    return this;
  }
  
  public final qf DH(long paramLong)
  {
    this.hjs = paramLong;
    return this;
  }
  
  public final qf Hb(String paramString)
  {
    AppMethodBeat.i(277504);
    this.hjp = z("session", paramString, true);
    AppMethodBeat.o(277504);
    return this;
  }
  
  public final qf Hc(String paramString)
  {
    AppMethodBeat.i(277505);
    this.hjt = z("weapp_id", paramString, true);
    AppMethodBeat.o(277505);
    return this;
  }
  
  public final qf Hd(String paramString)
  {
    AppMethodBeat.i(277506);
    this.hju = z("weapp_name", paramString, true);
    AppMethodBeat.o(277506);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(277509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hjp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hju);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(277509);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(277510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session:").append(this.hjp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.gfA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_type:").append(this.hjq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_sum:").append(this.hjr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_index:").append(this.hjs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_id:").append(this.hjt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_name:").append(this.hju);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(277510);
    return localObject;
  }
  
  public final int getId()
  {
    return 21775;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qf
 * JD-Core Version:    0.7.0.1
 */
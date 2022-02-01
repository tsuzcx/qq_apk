package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kn
  extends a
{
  private String gOq = "";
  private String gOr = "";
  private long gOs = 0L;
  private long gOt = 0L;
  private long gOu;
  private long gOv = 0L;
  private String gcU = "";
  private long giq;
  private String git = "";
  private String glQ = "";
  private long gnP = 0L;
  private long gpd = 0L;
  
  public final kn BA(String paramString)
  {
    AppMethodBeat.i(225317);
    this.gOq = z("ClickMD5", paramString, true);
    AppMethodBeat.o(225317);
    return this;
  }
  
  public final kn BB(String paramString)
  {
    AppMethodBeat.i(225321);
    this.gOr = z("QueryMD5", paramString, true);
    AppMethodBeat.o(225321);
    return this;
  }
  
  public final kn BC(String paramString)
  {
    AppMethodBeat.i(225326);
    this.git = z("RequestId", paramString, true);
    AppMethodBeat.o(225326);
    return this;
  }
  
  public final kn By(String paramString)
  {
    AppMethodBeat.i(225312);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(225312);
    return this;
  }
  
  public final kn Bz(String paramString)
  {
    AppMethodBeat.i(225315);
    this.glQ = z("SearchId", paramString, true);
    AppMethodBeat.o(225315);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(225336);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.git);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpd);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(225336);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(225340);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.glQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMD5:").append(this.gOq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryMD5:").append(this.gOr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Offset:").append(this.gOs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pos:").append(this.gOt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientTimestamp:").append(this.gOu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.git);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tab:").append(this.gOv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSelf:").append(this.gpd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(225340);
    return localObject;
  }
  
  public final int getId()
  {
    return 19651;
  }
  
  public final kn vc(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final kn vd(long paramLong)
  {
    this.gOs = paramLong;
    return this;
  }
  
  public final kn ve(long paramLong)
  {
    this.gOt = paramLong;
    return this;
  }
  
  public final kn vf(long paramLong)
  {
    this.gOu = paramLong;
    return this;
  }
  
  public final kn vg(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final kn vh(long paramLong)
  {
    this.gpd = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kn
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iz
  extends a
{
  private String gKA = "";
  private String gKB = "";
  private String gKC = "";
  private long geB;
  private String gfz = "";
  private long ggH;
  private String giT = "";
  private long gmT;
  private String gtO = "";
  
  public final iz Aa(String paramString)
  {
    AppMethodBeat.i(210245);
    this.gKC = z("requestID", paramString, true);
    AppMethodBeat.o(210245);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(210250);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKC);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210250);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210252);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionTS:").append(this.ggH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("setting:").append(this.gKA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.giT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session_id:").append(this.gfz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderid:").append(this.gtO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickid:").append(this.gKB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestID:").append(this.gKC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210252);
    return localObject;
  }
  
  public final int getId()
  {
    return 21837;
  }
  
  public final iz ul(long paramLong)
  {
    this.ggH = paramLong;
    return this;
  }
  
  public final iz um(long paramLong)
  {
    this.geB = paramLong;
    return this;
  }
  
  public final iz un(long paramLong)
  {
    this.gmT = paramLong;
    return this;
  }
  
  public final iz zV(String paramString)
  {
    AppMethodBeat.i(210229);
    this.gKA = z("setting", paramString, true);
    AppMethodBeat.o(210229);
    return this;
  }
  
  public final iz zW(String paramString)
  {
    AppMethodBeat.i(210233);
    this.giT = z("appid", paramString, true);
    AppMethodBeat.o(210233);
    return this;
  }
  
  public final iz zX(String paramString)
  {
    AppMethodBeat.i(210236);
    this.gfz = z("session_id", paramString, true);
    AppMethodBeat.o(210236);
    return this;
  }
  
  public final iz zY(String paramString)
  {
    AppMethodBeat.i(210239);
    this.gtO = z("finderid", paramString, true);
    AppMethodBeat.o(210239);
    return this;
  }
  
  public final iz zZ(String paramString)
  {
    AppMethodBeat.i(210241);
    this.gKB = z("clickid", paramString, true);
    AppMethodBeat.o(210241);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.iz
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pj
  extends a
{
  private String gFT = "";
  private String gFn = "";
  private long gYL = 0L;
  private long gYM = 0L;
  private String gfn = "";
  private String gmF = "";
  private long gnP = 0L;
  private long hfg;
  private long hfh;
  private String hfi = "";
  
  public final pj Ci(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final pj Cj(long paramLong)
  {
    this.gYM = paramLong;
    return this;
  }
  
  public final pj Ck(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final pj Cl(long paramLong)
  {
    this.hfg = paramLong;
    return this;
  }
  
  public final pj Cm(long paramLong)
  {
    this.hfh = paramLong;
    return this;
  }
  
  public final pj Gq(String paramString)
  {
    AppMethodBeat.i(274691);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(274691);
    return this;
  }
  
  public final pj Gr(String paramString)
  {
    AppMethodBeat.i(274692);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(274692);
    return this;
  }
  
  public final pj Gs(String paramString)
  {
    AppMethodBeat.i(274694);
    this.gFT = z("md5", paramString, true);
    AppMethodBeat.o(274694);
    return this;
  }
  
  public final pj Gt(String paramString)
  {
    AppMethodBeat.i(274695);
    this.gFn = z("moduleName", paramString, true);
    AppMethodBeat.o(274695);
    return this;
  }
  
  public final pj Gu(String paramString)
  {
    AppMethodBeat.i(274697);
    this.hfi = z("resue_reason", paramString, true);
    AppMethodBeat.o(274697);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(274698);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hfg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hfh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hfi);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(274698);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(274699);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.gYM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.gFT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("moduleName:").append(this.gFn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packageType:").append(this.hfg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reuse_type:").append(this.hfh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resue_reason:").append(this.hfi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(274699);
    return localObject;
  }
  
  public final int getId()
  {
    return 22832;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pj
 * JD-Core Version:    0.7.0.1
 */
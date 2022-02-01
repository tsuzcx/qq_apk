package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hj
  extends a
{
  public long gFv = 0L;
  public String gFw = "";
  public long gFx = 0L;
  private String gcU = "";
  private String glM = "";
  private String glQ = "";
  private long gnP = 0L;
  private String gyg = "";
  
  public final String agH()
  {
    AppMethodBeat.i(116481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFx);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(116481);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(116482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.glQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Query:").append(this.glM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpType:").append(this.gFv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Path:").append(this.gyg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappUsrname:").append(this.gFw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ServiceType:").append(this.gFx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116482);
    return localObject;
  }
  
  public final hj alG()
  {
    this.gnP = 47L;
    return this;
  }
  
  public final int getId()
  {
    return 16019;
  }
  
  public final hj wt(String paramString)
  {
    AppMethodBeat.i(116477);
    this.glQ = z("SearchId", paramString, true);
    AppMethodBeat.o(116477);
    return this;
  }
  
  public final hj wu(String paramString)
  {
    AppMethodBeat.i(116478);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(116478);
    return this;
  }
  
  public final hj wv(String paramString)
  {
    AppMethodBeat.i(116479);
    this.glM = z("Query", paramString, true);
    AppMethodBeat.o(116479);
    return this;
  }
  
  public final hj ww(String paramString)
  {
    AppMethodBeat.i(116480);
    this.gyg = z("Path", paramString, true);
    AppMethodBeat.o(116480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hj
 * JD-Core Version:    0.7.0.1
 */
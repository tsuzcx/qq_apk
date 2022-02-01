package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nq
  extends a
{
  private String gZV = "";
  public long gZW = 0L;
  private long gZX = 0L;
  private long gZY = 0L;
  private String gZZ = "";
  public long gnP = 0L;
  public long grp = 0L;
  public long haa = 0L;
  private String hab = "";
  
  public final nq EE(String paramString)
  {
    AppMethodBeat.i(149932);
    this.gZV = z("BiilNo", paramString, true);
    AppMethodBeat.o(149932);
    return this;
  }
  
  public final nq EF(String paramString)
  {
    AppMethodBeat.i(149933);
    this.gZZ = z("content", paramString, true);
    AppMethodBeat.o(149933);
    return this;
  }
  
  public final nq EG(String paramString)
  {
    AppMethodBeat.i(149934);
    this.hab = z("packId", paramString, true);
    AppMethodBeat.o(149934);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(149935);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.haa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hab);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(149935);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(149936);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BiilNo:").append(this.gZV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("failReason:").append(this.gZW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("playerErrCode:").append(this.gZX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.grp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("retCode:").append(this.gZY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.gZZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("amount:").append(this.haa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packId:").append(this.hab);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149936);
    return localObject;
  }
  
  public final int getId()
  {
    return 14404;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.nq
 * JD-Core Version:    0.7.0.1
 */
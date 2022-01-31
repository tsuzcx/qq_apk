package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ak
  extends a
{
  private String cRS = "";
  public long cTR = 0L;
  public int cUw = 0;
  public long cUx = 0L;
  public long cUy = 0L;
  private String cUz = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(152224);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cUw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUz);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(152224);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(152225);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.cUw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.cRS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.cTR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.cUx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.cUy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.cUz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(152225);
    return localObject;
  }
  
  public final ak fP(String paramString)
  {
    AppMethodBeat.i(152222);
    this.cRS = t("PName", paramString, true);
    AppMethodBeat.o(152222);
    return this;
  }
  
  public final ak fQ(String paramString)
  {
    AppMethodBeat.i(152223);
    this.cUz = t("DataContent", paramString, true);
    AppMethodBeat.o(152223);
    return this;
  }
  
  public final int getId()
  {
    return 17193;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ak
 * JD-Core Version:    0.7.0.1
 */
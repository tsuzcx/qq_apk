package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class du
  extends a
{
  private String dJv = "";
  public long dRy = 0L;
  public int dSD = 0;
  public long dSE = 0L;
  public long dSF = 0L;
  private String dSG = "";
  
  public final String PR()
  {
    AppMethodBeat.i(121781);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSG);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(121781);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(121782);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.dSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dJv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.dRy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.dSE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.dSF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.dSG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121782);
    return localObject;
  }
  
  public final int getId()
  {
    return 17193;
  }
  
  public final du lM(String paramString)
  {
    AppMethodBeat.i(121779);
    this.dJv = t("PName", paramString, true);
    AppMethodBeat.o(121779);
    return this;
  }
  
  public final du lN(String paramString)
  {
    AppMethodBeat.i(121780);
    this.dSG = t("DataContent", paramString, true);
    AppMethodBeat.o(121780);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.du
 * JD-Core Version:    0.7.0.1
 */
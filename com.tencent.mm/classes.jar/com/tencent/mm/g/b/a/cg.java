package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cg
  extends a
{
  private String dKv = "";
  public long dPH = 0L;
  public int dQO = 0;
  public long dQP = 0L;
  public long dQQ = 0L;
  private String dQR = "";
  
  public final String PV()
  {
    AppMethodBeat.i(121781);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQR);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(121781);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(121782);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.dQO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dKv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.dQP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.dQQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.dQR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121782);
    return localObject;
  }
  
  public final int getId()
  {
    return 17193;
  }
  
  public final cg iW(String paramString)
  {
    AppMethodBeat.i(121779);
    this.dKv = t("PName", paramString, true);
    AppMethodBeat.o(121779);
    return this;
  }
  
  public final cg iX(String paramString)
  {
    AppMethodBeat.i(121780);
    this.dQR = t("DataContent", paramString, true);
    AppMethodBeat.o(121780);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cg
 * JD-Core Version:    0.7.0.1
 */
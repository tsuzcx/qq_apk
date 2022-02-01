package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class er
  extends a
{
  private String dYD = "";
  public long eiF = 0L;
  public int ejT = 0;
  public long ejU = 0L;
  public long ejV = 0L;
  private String ejW = "";
  
  public final String RC()
  {
    AppMethodBeat.i(121781);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(121781);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121782);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.ejT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.eiF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.ejU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.ejV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.ejW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121782);
    return localObject;
  }
  
  public final int getId()
  {
    return 17193;
  }
  
  public final er op(String paramString)
  {
    AppMethodBeat.i(121779);
    this.dYD = t("PName", paramString, true);
    AppMethodBeat.o(121779);
    return this;
  }
  
  public final er oq(String paramString)
  {
    AppMethodBeat.i(121780);
    this.ejW = t("DataContent", paramString, true);
    AppMethodBeat.o(121780);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.er
 * JD-Core Version:    0.7.0.1
 */
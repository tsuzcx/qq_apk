package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eq
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
    AppMethodBeat.i(121777);
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
    AppMethodBeat.o(121777);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121778);
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
    AppMethodBeat.o(121778);
    return localObject;
  }
  
  public final int getId()
  {
    return 16974;
  }
  
  public final eq on(String paramString)
  {
    AppMethodBeat.i(121775);
    this.dYD = t("PName", paramString, true);
    AppMethodBeat.o(121775);
    return this;
  }
  
  public final eq oo(String paramString)
  {
    AppMethodBeat.i(121776);
    this.ejW = t("DataContent", paramString, false);
    AppMethodBeat.o(121776);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eq
 * JD-Core Version:    0.7.0.1
 */
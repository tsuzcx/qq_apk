package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hz
  extends a
{
  public long eLd = 0L;
  public int eMF = 0;
  public long eMG = 0L;
  public long eMH = 0L;
  private String eMI = "";
  private String euw = "";
  
  public final String abV()
  {
    AppMethodBeat.i(121781);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eMF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMI);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(121781);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(121782);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.eMF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.euw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.eLd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.eMG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.eMH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.eMI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121782);
    return localObject;
  }
  
  public final int getId()
  {
    return 17193;
  }
  
  public final hz vJ(String paramString)
  {
    AppMethodBeat.i(121779);
    this.euw = x("PName", paramString, true);
    AppMethodBeat.o(121779);
    return this;
  }
  
  public final hz vK(String paramString)
  {
    AppMethodBeat.i(121780);
    this.eMI = x("DataContent", paramString, true);
    AppMethodBeat.o(121780);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hz
 * JD-Core Version:    0.7.0.1
 */
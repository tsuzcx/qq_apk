package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kf
  extends a
{
  public long gKH = 0L;
  public int gMJ = 0;
  public long gMK = 0L;
  public long gML = 0L;
  private String gMM = "";
  private String gqC = "";
  
  public final kf Bg(String paramString)
  {
    AppMethodBeat.i(121775);
    this.gqC = z("PName", paramString, true);
    AppMethodBeat.o(121775);
    return this;
  }
  
  public final kf Bh(String paramString)
  {
    AppMethodBeat.i(121776);
    this.gMM = z("DataContent", paramString, false);
    AppMethodBeat.o(121776);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(121777);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gMJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gML);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMM);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(121777);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(121778);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.gMJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.gqC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.gKH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.gMK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.gML);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.gMM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121778);
    return localObject;
  }
  
  public final int getId()
  {
    return 16974;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kf
 * JD-Core Version:    0.7.0.1
 */
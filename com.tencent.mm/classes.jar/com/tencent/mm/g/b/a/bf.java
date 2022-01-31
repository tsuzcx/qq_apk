package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bf
  extends a
{
  private long cVa = 0L;
  private long cVj = 0L;
  private String cWU = "";
  private String cWV = "";
  private long cWW = 0L;
  private String cWX = "";
  private String cWY = "";
  
  public final String FZ()
  {
    return this.cWU;
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(108880);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cVj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWY);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(108880);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(108881);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.cVj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.cVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList:").append(this.cWU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayUinList:").append(this.cWV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.cWW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList1:").append(this.cWX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList2:").append(this.cWY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108881);
    return localObject;
  }
  
  public final String Ga()
  {
    return this.cWX;
  }
  
  public final String Gb()
  {
    return this.cWY;
  }
  
  public final bf di(long paramLong)
  {
    this.cVj = paramLong;
    return this;
  }
  
  public final bf dj(long paramLong)
  {
    this.cVa = paramLong;
    return this;
  }
  
  public final bf dk(long paramLong)
  {
    this.cWW = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16842;
  }
  
  public final bf gx(String paramString)
  {
    AppMethodBeat.i(108877);
    this.cWU = t("WaitPlayVideoList", paramString, true);
    AppMethodBeat.o(108877);
    return this;
  }
  
  public final bf gy(String paramString)
  {
    AppMethodBeat.i(108878);
    this.cWX = t("WaitPlayVideoList1", paramString, true);
    AppMethodBeat.o(108878);
    return this;
  }
  
  public final bf gz(String paramString)
  {
    AppMethodBeat.i(108879);
    this.cWY = t("WaitPlayVideoList2", paramString, true);
    AppMethodBeat.o(108879);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bf
 * JD-Core Version:    0.7.0.1
 */
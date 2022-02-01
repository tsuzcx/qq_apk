package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ep
  extends a
{
  public long eDV = 0L;
  private String eDW = "";
  private String eDX = "";
  public long ejA = 0L;
  public long erW = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(120834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDX);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(120834);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(120835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.eDV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileID:").append(this.eDW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AesKey:").append(this.eDX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(120835);
    return localObject;
  }
  
  public final int getId()
  {
    return 17055;
  }
  
  public final ep rK(String paramString)
  {
    AppMethodBeat.i(200108);
    this.eDW = x("FileID", paramString, true);
    AppMethodBeat.o(200108);
    return this;
  }
  
  public final ep rL(String paramString)
  {
    AppMethodBeat.i(200109);
    this.eDX = x("AesKey", paramString, true);
    AppMethodBeat.o(200109);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ep
 * JD-Core Version:    0.7.0.1
 */
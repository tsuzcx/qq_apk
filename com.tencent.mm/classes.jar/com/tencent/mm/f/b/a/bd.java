package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bd
  extends a
{
  public int giX;
  private String glJ = "";
  private String glK = "";
  public int glL = 0;
  
  public final String agH()
  {
    AppMethodBeat.i(163530);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glL);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(163530);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(163531);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("F2FId:").append(this.glJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QrCodeId:").append(this.glK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalAmount:").append(this.glL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163531);
    return localObject;
  }
  
  public final int getId()
  {
    return 18885;
  }
  
  public final bd jH(String paramString)
  {
    AppMethodBeat.i(163528);
    this.glJ = z("F2FId", paramString, true);
    AppMethodBeat.o(163528);
    return this;
  }
  
  public final bd jI(String paramString)
  {
    AppMethodBeat.i(163529);
    this.glK = z("QrCodeId", paramString, true);
    AppMethodBeat.o(163529);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bd
 * JD-Core Version:    0.7.0.1
 */
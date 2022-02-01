package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class by
  extends a
{
  private String dFe;
  public long dNF = 0L;
  public long dNG = 0L;
  public long dNH = 0L;
  public long dNI = 0L;
  public long dNJ = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(195927);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNJ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195927);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195928);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenPictureTime:").append(this.dNF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenPictureType:").append(this.dNG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeIconTime:").append(this.dNH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PictureConcluding:").append(this.dNI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IconType:").append(this.dNJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195928);
    return localObject;
  }
  
  public final int getId()
  {
    return 19776;
  }
  
  public final by jT(String paramString)
  {
    AppMethodBeat.i(195926);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(195926);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.by
 * JD-Core Version:    0.7.0.1
 */
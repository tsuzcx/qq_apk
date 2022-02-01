package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ht
  extends a
{
  private String eBX = "";
  public long eMr;
  public long eMs = -1L;
  public long eMt = -1L;
  public String epf = "";
  public long erY;
  public long esJ;
  
  public final String abV()
  {
    AppMethodBeat.i(201829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMt);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(201829);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(201830);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.erY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.epf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.esJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MonmentSessionId:").append(this.eBX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("templateType:").append(this.eMr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsThumbExit:").append(this.eMs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsThumbBlack:").append(this.eMt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(201830);
    return localObject;
  }
  
  public final int getId()
  {
    return 21746;
  }
  
  public final ht vw(String paramString)
  {
    AppMethodBeat.i(201828);
    this.eBX = x("MonmentSessionId", paramString, true);
    AppMethodBeat.o(201828);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ht
 * JD-Core Version:    0.7.0.1
 */
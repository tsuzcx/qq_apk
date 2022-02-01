package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hf
  extends a
{
  private long dFd;
  private String dKI;
  private long dKe;
  private long dLu;
  private String dMw;
  private String dkR;
  
  public final hf EG(String paramString)
  {
    AppMethodBeat.i(203668);
    this.dKI = t("Sessionid", paramString, true);
    AppMethodBeat.o(203668);
    return this;
  }
  
  public final hf EH(String paramString)
  {
    AppMethodBeat.i(203669);
    this.dkR = t("Contextid", paramString, true);
    AppMethodBeat.o(203669);
    return this;
  }
  
  public final hf EI(String paramString)
  {
    AppMethodBeat.i(203670);
    this.dMw = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(203670);
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(203671);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dkR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLu);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203671);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203672);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.dKI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dkR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dMw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWording:").append(this.dLu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203672);
    return localObject;
  }
  
  public final int getId()
  {
    return 19995;
  }
  
  public final hf nc(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final hf nd(long paramLong)
  {
    this.dFd = paramLong;
    return this;
  }
  
  public final hf qc(long paramLong)
  {
    this.dLu = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hf
 * JD-Core Version:    0.7.0.1
 */
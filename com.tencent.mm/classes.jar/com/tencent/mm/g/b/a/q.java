package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class q
  extends a
{
  private long cRG = 0L;
  private String cSc = "";
  private String cSd = "";
  private String cSe = "";
  public long cSf = 0L;
  private String cSg = "";
  private String cSh = "";
  public long cSi = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(91255);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cRG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSi);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(91255);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(91256);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.cSc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.cSd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Query:").append(this.cSe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpType:").append(this.cSf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Path:").append(this.cSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeappUsrname:").append(this.cSh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ServiceType:").append(this.cSi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91256);
    return localObject;
  }
  
  public final q Fl()
  {
    this.cRG = 47L;
    return this;
  }
  
  public final q fj(String paramString)
  {
    AppMethodBeat.i(91250);
    this.cSc = t("SearchId", paramString, true);
    AppMethodBeat.o(91250);
    return this;
  }
  
  public final q fk(String paramString)
  {
    AppMethodBeat.i(91251);
    this.cSd = t("SessionId", paramString, true);
    AppMethodBeat.o(91251);
    return this;
  }
  
  public final q fl(String paramString)
  {
    AppMethodBeat.i(91252);
    this.cSe = t("Query", paramString, true);
    AppMethodBeat.o(91252);
    return this;
  }
  
  public final q fm(String paramString)
  {
    AppMethodBeat.i(91253);
    this.cSg = t("Path", paramString, true);
    AppMethodBeat.o(91253);
    return this;
  }
  
  public final q fn(String paramString)
  {
    AppMethodBeat.i(91254);
    this.cSh = t("WeappUsrname", paramString, true);
    AppMethodBeat.o(91254);
    return this;
  }
  
  public final int getId()
  {
    return 16019;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.q
 * JD-Core Version:    0.7.0.1
 */
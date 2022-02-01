package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class af
  extends a
{
  public long ejW;
  private String enK = "";
  public long enM = 0L;
  public long enP;
  public long enQ = 0L;
  public String enR = "";
  public String enS = "";
  public long enT = 0L;
  public String enU = "";
  public String enV = "";
  
  public final String abV()
  {
    AppMethodBeat.i(184765);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enV);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184765);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184766);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.enK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topCount:").append(this.enP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedCount:").append(this.enQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.enM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.enR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appname:").append(this.enS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isTop:").append(this.enT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAppList:").append(this.enU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedAppList:").append(this.enV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184766);
    return localObject;
  }
  
  public final int getId()
  {
    return 19436;
  }
  
  public final af ik(String paramString)
  {
    AppMethodBeat.i(184764);
    this.enK = x("roomusrname", paramString, true);
    AppMethodBeat.o(184764);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.af
 * JD-Core Version:    0.7.0.1
 */
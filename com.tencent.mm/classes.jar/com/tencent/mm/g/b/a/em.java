package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class em
  extends a
{
  private long eCQ;
  private long eCR;
  private long eCS;
  private String eiC = "";
  private long ejW;
  private String erU = "";
  private String erV = "";
  private long erW;
  private long erX;
  private String euI = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209233);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCS);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209233);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209234);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.erV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.eiC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.euI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWording:").append(this.erX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAction:").append(this.eCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionStatus:").append(this.eCR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("wordingtype:").append(this.eCS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209234);
    return localObject;
  }
  
  public final int getId()
  {
    return 20044;
  }
  
  public final em me(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final em mf(long paramLong)
  {
    this.ejW = paramLong;
    return this;
  }
  
  public final em mg(long paramLong)
  {
    this.eCQ = paramLong;
    return this;
  }
  
  public final em mh(long paramLong)
  {
    this.eCR = paramLong;
    return this;
  }
  
  public final em mi(long paramLong)
  {
    this.eCS = paramLong;
    return this;
  }
  
  public final em rl(String paramString)
  {
    AppMethodBeat.i(209229);
    this.erU = x("Sessionid", paramString, true);
    AppMethodBeat.o(209229);
    return this;
  }
  
  public final em rm(String paramString)
  {
    AppMethodBeat.i(209230);
    this.erV = x("Contextid", paramString, true);
    AppMethodBeat.o(209230);
    return this;
  }
  
  public final em rn(String paramString)
  {
    AppMethodBeat.i(209231);
    this.eiC = x("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209231);
    return this;
  }
  
  public final em ro(String paramString)
  {
    AppMethodBeat.i(209232);
    this.euI = x("feedid", paramString, true);
    AppMethodBeat.o(209232);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.em
 * JD-Core Version:    0.7.0.1
 */
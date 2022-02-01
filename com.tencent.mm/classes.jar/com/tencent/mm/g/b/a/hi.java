package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hi
  extends a
{
  private String eLB = "";
  private String eLC = "";
  private long eLD = 0L;
  private long eLE = 0L;
  private long eLF = 0L;
  private String eLG = "";
  private String eLH = "";
  private String eLI = "";
  private String eLJ = "";
  private long ejA = 0L;
  private String eqi = "";
  private String eqj = "";
  private long erY = 0L;
  private long euV = 0L;
  private long exh = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(104431);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.exh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLJ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(104431);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(104432);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.exh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourcePid:").append(this.eLB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceMd5:").append(this.eLC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.eqi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.eqj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.euV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxRowCount:").append(this.eLD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree:").append(this.eLE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.erY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.eLF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree2:").append(this.eLG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type2:").append(this.eLH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal2:").append(this.eLI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatID:").append(this.eLJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(104432);
    return localObject;
  }
  
  public final String agU()
  {
    return this.eqi;
  }
  
  public final hi agV()
  {
    this.eLD = 4L;
    return this;
  }
  
  public final String agW()
  {
    return this.eLG;
  }
  
  public final String agX()
  {
    return this.eLH;
  }
  
  public final String agY()
  {
    return this.eLI;
  }
  
  public final int getId()
  {
    return 18739;
  }
  
  public final String getMd5()
  {
    return this.eqj;
  }
  
  public final hi qN(long paramLong)
  {
    this.exh = paramLong;
    return this;
  }
  
  public final hi qO(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
  
  public final hi qP(long paramLong)
  {
    this.euV = paramLong;
    return this;
  }
  
  public final hi uW(String paramString)
  {
    AppMethodBeat.i(104424);
    this.eLB = x("SourcePid", paramString, true);
    AppMethodBeat.o(104424);
    return this;
  }
  
  public final hi uX(String paramString)
  {
    AppMethodBeat.i(104425);
    this.eLC = x("SourceMd5", paramString, true);
    AppMethodBeat.o(104425);
    return this;
  }
  
  public final hi uY(String paramString)
  {
    AppMethodBeat.i(104426);
    this.eqi = x("Pid", paramString, true);
    AppMethodBeat.o(104426);
    return this;
  }
  
  public final hi uZ(String paramString)
  {
    AppMethodBeat.i(104427);
    this.eqj = x("Md5", paramString, true);
    AppMethodBeat.o(104427);
    return this;
  }
  
  public final hi va(String paramString)
  {
    AppMethodBeat.i(104428);
    this.eLG = x("IsFree2", paramString, true);
    AppMethodBeat.o(104428);
    return this;
  }
  
  public final hi vb(String paramString)
  {
    AppMethodBeat.i(104429);
    this.eLH = x("Type2", paramString, true);
    AppMethodBeat.o(104429);
    return this;
  }
  
  public final hi vc(String paramString)
  {
    AppMethodBeat.i(104430);
    this.eLI = x("IsLocal2", paramString, true);
    AppMethodBeat.o(104430);
    return this;
  }
  
  public final hi vd(String paramString)
  {
    AppMethodBeat.i(199743);
    this.eLJ = x("ChatID", paramString, true);
    AppMethodBeat.o(199743);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hi
 * JD-Core Version:    0.7.0.1
 */
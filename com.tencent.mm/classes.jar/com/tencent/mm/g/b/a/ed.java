package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ed
  extends a
{
  private long dQB = 0L;
  private String dVP = "";
  private String dVQ = "";
  private long dZW = 0L;
  private long dZd = 0L;
  private long ege = 0L;
  private String eiY = "";
  private String eiZ = "";
  private long eja = 0L;
  private long ejb = 0L;
  private long ejc = 0L;
  private String ejd = "";
  private String eje = "";
  private String ejf = "";
  private String ejg = "";
  
  public final String Lj()
  {
    return this.dVQ;
  }
  
  public final String RC()
  {
    AppMethodBeat.i(104431);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ege);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eja);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eje);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejg);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(104431);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(104432);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ege);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourcePid:").append(this.eiY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceMd5:").append(this.eiZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.dVP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.dVQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dZd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxRowCount:").append(this.eja);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree:").append(this.ejb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dZW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.ejc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree2:").append(this.ejd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type2:").append(this.eje);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal2:").append(this.ejf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatID:").append(this.ejg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(104432);
    return localObject;
  }
  
  public final String Tj()
  {
    return this.dVP;
  }
  
  public final ed Tk()
  {
    this.eja = 4L;
    return this;
  }
  
  public final String Tl()
  {
    return this.ejd;
  }
  
  public final String Tm()
  {
    return this.eje;
  }
  
  public final String Tn()
  {
    return this.ejf;
  }
  
  public final int getId()
  {
    return 18739;
  }
  
  public final ed ke(long paramLong)
  {
    this.ege = paramLong;
    return this;
  }
  
  public final ed kf(long paramLong)
  {
    this.dQB = paramLong;
    return this;
  }
  
  public final ed kg(long paramLong)
  {
    this.dZd = paramLong;
    return this;
  }
  
  public final ed nD(String paramString)
  {
    AppMethodBeat.i(104424);
    this.eiY = t("SourcePid", paramString, true);
    AppMethodBeat.o(104424);
    return this;
  }
  
  public final ed nE(String paramString)
  {
    AppMethodBeat.i(104425);
    this.eiZ = t("SourceMd5", paramString, true);
    AppMethodBeat.o(104425);
    return this;
  }
  
  public final ed nF(String paramString)
  {
    AppMethodBeat.i(104426);
    this.dVP = t("Pid", paramString, true);
    AppMethodBeat.o(104426);
    return this;
  }
  
  public final ed nG(String paramString)
  {
    AppMethodBeat.i(104427);
    this.dVQ = t("Md5", paramString, true);
    AppMethodBeat.o(104427);
    return this;
  }
  
  public final ed nH(String paramString)
  {
    AppMethodBeat.i(104428);
    this.ejd = t("IsFree2", paramString, true);
    AppMethodBeat.o(104428);
    return this;
  }
  
  public final ed nI(String paramString)
  {
    AppMethodBeat.i(104429);
    this.eje = t("Type2", paramString, true);
    AppMethodBeat.o(104429);
    return this;
  }
  
  public final ed nJ(String paramString)
  {
    AppMethodBeat.i(104430);
    this.ejf = t("IsLocal2", paramString, true);
    AppMethodBeat.o(104430);
    return this;
  }
  
  public final ed nK(String paramString)
  {
    AppMethodBeat.i(188489);
    this.ejg = t("ChatID", paramString, true);
    AppMethodBeat.o(188489);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ed
 * JD-Core Version:    0.7.0.1
 */
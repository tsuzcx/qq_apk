package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eb
  extends a
{
  private long dPl = 0L;
  private String dUA;
  private String dUz;
  private long dXM = 0L;
  private long dYD = 0L;
  private long eeE = 0L;
  private String eho;
  private String ehp;
  private long ehq = 0L;
  private long ehr = 0L;
  private long ehs = 0L;
  private String eht;
  private String ehu;
  private String ehv;
  private String ehw;
  
  public final String Lb()
  {
    return this.dUA;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(104431);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eho);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eht);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehw);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(104431);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(104432);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eeE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourcePid:").append(this.eho);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceMd5:").append(this.ehp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.dUz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.dUA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dXM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxRowCount:").append(this.ehq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree:").append(this.ehr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.ehs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree2:").append(this.eht);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type2:").append(this.ehu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal2:").append(this.ehv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatID:").append(this.ehw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(104432);
    return localObject;
  }
  
  public final String Td()
  {
    return this.dUz;
  }
  
  public final eb Te()
  {
    this.ehq = 4L;
    return this;
  }
  
  public final String Tf()
  {
    return this.eht;
  }
  
  public final String Tg()
  {
    return this.ehu;
  }
  
  public final String Th()
  {
    return this.ehv;
  }
  
  public final int getId()
  {
    return 18739;
  }
  
  public final eb jT(long paramLong)
  {
    this.eeE = paramLong;
    return this;
  }
  
  public final eb jU(long paramLong)
  {
    this.dPl = paramLong;
    return this;
  }
  
  public final eb jV(long paramLong)
  {
    this.dXM = paramLong;
    return this;
  }
  
  public final eb ni(String paramString)
  {
    AppMethodBeat.i(104424);
    this.eho = t("SourcePid", paramString, true);
    AppMethodBeat.o(104424);
    return this;
  }
  
  public final eb nj(String paramString)
  {
    AppMethodBeat.i(104425);
    this.ehp = t("SourceMd5", paramString, true);
    AppMethodBeat.o(104425);
    return this;
  }
  
  public final eb nk(String paramString)
  {
    AppMethodBeat.i(104426);
    this.dUz = t("Pid", paramString, true);
    AppMethodBeat.o(104426);
    return this;
  }
  
  public final eb nl(String paramString)
  {
    AppMethodBeat.i(104427);
    this.dUA = t("Md5", paramString, true);
    AppMethodBeat.o(104427);
    return this;
  }
  
  public final eb nm(String paramString)
  {
    AppMethodBeat.i(104428);
    this.eht = t("IsFree2", paramString, true);
    AppMethodBeat.o(104428);
    return this;
  }
  
  public final eb nn(String paramString)
  {
    AppMethodBeat.i(104429);
    this.ehu = t("Type2", paramString, true);
    AppMethodBeat.o(104429);
    return this;
  }
  
  public final eb no(String paramString)
  {
    AppMethodBeat.i(104430);
    this.ehv = t("IsLocal2", paramString, true);
    AppMethodBeat.o(104430);
    return this;
  }
  
  public final eb np(String paramString)
  {
    AppMethodBeat.i(219011);
    this.ehw = t("ChatID", paramString, true);
    AppMethodBeat.o(219011);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eb
 * JD-Core Version:    0.7.0.1
 */
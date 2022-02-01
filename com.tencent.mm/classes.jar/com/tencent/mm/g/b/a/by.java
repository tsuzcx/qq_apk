package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class by
  extends a
{
  private String eiC = "";
  private String erU = "";
  private long ery;
  private long erz;
  private String esZ = "";
  private long euk;
  private long eul;
  private long eum;
  private long eun;
  private long euo;
  private long eup;
  
  public final String abV()
  {
    AppMethodBeat.i(208940);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ery);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eul);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eum);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eun);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eup);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208940);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208941);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.eiC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ery);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CgiType:").append(this.euk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingTime:").append(this.eul);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartCgiTimestamp:").append(this.eum);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("status:").append(this.eun);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.esZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.erz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pullType:").append(this.euo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndCgiTimestamp:").append(this.eup);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208941);
    return localObject;
  }
  
  public final String acA()
  {
    return this.erU;
  }
  
  public final String acM()
  {
    return this.eiC;
  }
  
  public final long acN()
  {
    return this.ery;
  }
  
  public final long acO()
  {
    return this.euk;
  }
  
  public final long acP()
  {
    return this.eul;
  }
  
  public final long acQ()
  {
    return this.eum;
  }
  
  public final long acR()
  {
    return this.eun;
  }
  
  public final by acS()
  {
    this.erz = 10L;
    return this;
  }
  
  public final long acT()
  {
    return this.erz;
  }
  
  public final long acU()
  {
    return this.euo;
  }
  
  public final long acV()
  {
    return this.eup;
  }
  
  public final by fb(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final by fc(long paramLong)
  {
    this.euk = paramLong;
    return this;
  }
  
  public final by fd(long paramLong)
  {
    this.eul = paramLong;
    return this;
  }
  
  public final by fe(long paramLong)
  {
    this.eum = paramLong;
    return this;
  }
  
  public final by ff(long paramLong)
  {
    this.eun = paramLong;
    return this;
  }
  
  public final by fg(long paramLong)
  {
    this.euo = paramLong;
    return this;
  }
  
  public final by fh(long paramLong)
  {
    this.eup = paramLong;
    return this;
  }
  
  public final String getExtraInfo()
  {
    return this.esZ;
  }
  
  public final int getId()
  {
    return 20672;
  }
  
  public final by kC(String paramString)
  {
    AppMethodBeat.i(208937);
    this.erU = x("Sessionid", paramString, true);
    AppMethodBeat.o(208937);
    return this;
  }
  
  public final by kD(String paramString)
  {
    AppMethodBeat.i(208938);
    this.eiC = x("ClickTabContextid", paramString, true);
    AppMethodBeat.o(208938);
    return this;
  }
  
  public final by kE(String paramString)
  {
    AppMethodBeat.i(208939);
    this.esZ = x("ExtraInfo", paramString, true);
    AppMethodBeat.o(208939);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.by
 * JD-Core Version:    0.7.0.1
 */
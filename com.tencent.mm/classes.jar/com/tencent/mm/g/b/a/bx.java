package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bx
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
    AppMethodBeat.i(208935);
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
    AppMethodBeat.o(208935);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208936);
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
    AppMethodBeat.o(208936);
    return localObject;
  }
  
  public final bx eT(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final bx eU(long paramLong)
  {
    this.euk = paramLong;
    return this;
  }
  
  public final bx eV(long paramLong)
  {
    this.eul = paramLong;
    return this;
  }
  
  public final bx eW(long paramLong)
  {
    this.eum = paramLong;
    return this;
  }
  
  public final bx eX(long paramLong)
  {
    this.eun = paramLong;
    return this;
  }
  
  public final bx eY(long paramLong)
  {
    this.erz = paramLong;
    return this;
  }
  
  public final bx eZ(long paramLong)
  {
    this.euo = paramLong;
    return this;
  }
  
  public final bx fa(long paramLong)
  {
    this.eup = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20713;
  }
  
  public final bx kA(String paramString)
  {
    AppMethodBeat.i(208933);
    this.eiC = x("ClickTabContextid", paramString, true);
    AppMethodBeat.o(208933);
    return this;
  }
  
  public final bx kB(String paramString)
  {
    AppMethodBeat.i(208934);
    this.esZ = x("ExtraInfo", paramString, true);
    AppMethodBeat.o(208934);
    return this;
  }
  
  public final bx kz(String paramString)
  {
    AppMethodBeat.i(208932);
    this.erU = x("Sessionid", paramString, true);
    AppMethodBeat.o(208932);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bx
 * JD-Core Version:    0.7.0.1
 */
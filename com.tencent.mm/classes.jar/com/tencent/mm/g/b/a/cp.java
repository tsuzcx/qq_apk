package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cp
  extends a
{
  private String dSb;
  private long ecU = 0L;
  private long ecV = 0L;
  private long ecW = 0L;
  private long ecX = 0L;
  private long ecY = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(193091);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecY);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(193091);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(193092);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenPictureTime:").append(this.ecU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenPictureType:").append(this.ecV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeIconTime:").append(this.ecW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PictureConcluding:").append(this.ecX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IconType:").append(this.ecY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(193092);
    return localObject;
  }
  
  public final long SN()
  {
    return this.ecU;
  }
  
  public final long SO()
  {
    return this.ecW;
  }
  
  public final long SP()
  {
    return this.ecY;
  }
  
  public final int getId()
  {
    return 19776;
  }
  
  public final String getSessionId()
  {
    return this.dSb;
  }
  
  public final cp hZ(long paramLong)
  {
    this.ecU = paramLong;
    return this;
  }
  
  public final cp ia(long paramLong)
  {
    this.ecV = paramLong;
    return this;
  }
  
  public final cp ib(long paramLong)
  {
    this.ecW = paramLong;
    return this;
  }
  
  public final cp ic(long paramLong)
  {
    this.ecX = paramLong;
    return this;
  }
  
  public final cp id(long paramLong)
  {
    this.ecY = paramLong;
    return this;
  }
  
  public final cp lP(String paramString)
  {
    AppMethodBeat.i(193090);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(193090);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cp
 * JD-Core Version:    0.7.0.1
 */
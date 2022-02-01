package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gs
  extends a
{
  private String gBf = "";
  private String gBg = "";
  private long gDq = 0L;
  private long gDr = 0L;
  private long gDs = 0L;
  private long gDt = 0L;
  private String gcU = "";
  private long gnk = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(275290);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gDq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBg);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(275290);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(275291);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenPictureTime:").append(this.gDq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenPictureType:").append(this.gDr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeIconTime:").append(this.gDs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PictureConcluding:").append(this.gDt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IconType:").append(this.gnk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileID:").append(this.gBf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AesKey:").append(this.gBg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(275291);
    return localObject;
  }
  
  public final long akW()
  {
    return this.gDq;
  }
  
  public final long akX()
  {
    return this.gDs;
  }
  
  public final long akY()
  {
    return this.gnk;
  }
  
  public final String akZ()
  {
    return this.gBf;
  }
  
  public final String getAesKey()
  {
    return this.gBg;
  }
  
  public final int getId()
  {
    return 19776;
  }
  
  public final String getSessionId()
  {
    return this.gcU;
  }
  
  public final gs pl(long paramLong)
  {
    this.gDq = paramLong;
    return this;
  }
  
  public final gs pm(long paramLong)
  {
    this.gDr = paramLong;
    return this;
  }
  
  public final gs pn(long paramLong)
  {
    this.gDs = paramLong;
    return this;
  }
  
  public final gs po(long paramLong)
  {
    this.gDt = paramLong;
    return this;
  }
  
  public final gs pp(long paramLong)
  {
    this.gnk = paramLong;
    return this;
  }
  
  public final gs vI(String paramString)
  {
    AppMethodBeat.i(275287);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(275287);
    return this;
  }
  
  public final gs vJ(String paramString)
  {
    AppMethodBeat.i(275288);
    this.gBf = z("FileID", paramString, true);
    AppMethodBeat.o(275288);
    return this;
  }
  
  public final gs vK(String paramString)
  {
    AppMethodBeat.i(275289);
    this.gBg = z("AesKey", paramString, true);
    AppMethodBeat.o(275289);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gs
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fb
  extends a
{
  private String eDW = "";
  private String eDX = "";
  private long eEU = 0L;
  private long eEV = 0L;
  private long eEW = 0L;
  private long eEX = 0L;
  private long eEY = 0L;
  private String eiB = "";
  
  public final String abV()
  {
    AppMethodBeat.i(231480);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eEU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDX);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(231480);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(231481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenPictureTime:").append(this.eEU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenPictureType:").append(this.eEV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeIconTime:").append(this.eEW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PictureConcluding:").append(this.eEX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IconType:").append(this.eEY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileID:").append(this.eDW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AesKey:").append(this.eDX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(231481);
    return localObject;
  }
  
  public final long afT()
  {
    return this.eEU;
  }
  
  public final long afU()
  {
    return this.eEW;
  }
  
  public final long afV()
  {
    return this.eEY;
  }
  
  public final String afW()
  {
    return this.eDW;
  }
  
  public final String getAesKey()
  {
    return this.eDX;
  }
  
  public final int getId()
  {
    return 19776;
  }
  
  public final String getSessionId()
  {
    return this.eiB;
  }
  
  public final fb na(long paramLong)
  {
    this.eEU = paramLong;
    return this;
  }
  
  public final fb nb(long paramLong)
  {
    this.eEV = paramLong;
    return this;
  }
  
  public final fb nc(long paramLong)
  {
    this.eEW = paramLong;
    return this;
  }
  
  public final fb nd(long paramLong)
  {
    this.eEX = paramLong;
    return this;
  }
  
  public final fb ne(long paramLong)
  {
    this.eEY = paramLong;
    return this;
  }
  
  public final fb rX(String paramString)
  {
    AppMethodBeat.i(231477);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(231477);
    return this;
  }
  
  public final fb rY(String paramString)
  {
    AppMethodBeat.i(231478);
    this.eDW = x("FileID", paramString, true);
    AppMethodBeat.o(231478);
    return this;
  }
  
  public final fb rZ(String paramString)
  {
    AppMethodBeat.i(231479);
    this.eDX = x("AesKey", paramString, true);
    AppMethodBeat.o(231479);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fb
 * JD-Core Version:    0.7.0.1
 */
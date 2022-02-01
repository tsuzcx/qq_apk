package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class di
  extends a
{
  private long euQ;
  private String ezQ = "";
  private String ezR = "";
  private long ezS;
  private long ezT;
  private long ezU;
  private long ezV;
  
  public final String abV()
  {
    AppMethodBeat.i(209119);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ezQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezV);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209119);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209120);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PostId:").append(this.ezQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditId:").append(this.ezR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSource:").append(this.ezS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.euQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PicCnt:").append(this.ezT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoLen:").append(this.ezU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteFlag:").append(this.ezV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209120);
    return localObject;
  }
  
  public final int getId()
  {
    return 21638;
  }
  
  public final di jA(long paramLong)
  {
    this.ezU = paramLong;
    return this;
  }
  
  public final di jx(long paramLong)
  {
    this.ezS = paramLong;
    return this;
  }
  
  public final di jy(long paramLong)
  {
    this.euQ = paramLong;
    return this;
  }
  
  public final di jz(long paramLong)
  {
    this.ezT = paramLong;
    return this;
  }
  
  public final di oG(String paramString)
  {
    AppMethodBeat.i(209117);
    this.ezQ = x("PostId", paramString, true);
    AppMethodBeat.o(209117);
    return this;
  }
  
  public final di oH(String paramString)
  {
    AppMethodBeat.i(209118);
    this.ezR = x("EditId", paramString, true);
    AppMethodBeat.o(209118);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.di
 * JD-Core Version:    0.7.0.1
 */
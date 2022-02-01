package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dj
  extends a
{
  private long euQ;
  private String ezQ = "";
  private String ezR = "";
  private long ezS;
  private long ezT;
  private long ezU;
  private long ezW;
  private long ezX;
  
  public final String abV()
  {
    AppMethodBeat.i(237154);
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
    ((StringBuffer)localObject).append(this.ezW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezX);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(237154);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(237155);
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
    ((StringBuffer)localObject).append("mediaViewType:").append(this.ezW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("previewViewScene:").append(this.ezX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(237155);
    return localObject;
  }
  
  public final int getId()
  {
    return 21640;
  }
  
  public final dj jB(long paramLong)
  {
    this.ezS = paramLong;
    return this;
  }
  
  public final dj jC(long paramLong)
  {
    this.ezT = paramLong;
    return this;
  }
  
  public final dj jD(long paramLong)
  {
    this.ezU = paramLong;
    return this;
  }
  
  public final dj jE(long paramLong)
  {
    this.ezW = paramLong;
    return this;
  }
  
  public final dj jF(long paramLong)
  {
    this.ezX = paramLong;
    return this;
  }
  
  public final dj oI(String paramString)
  {
    AppMethodBeat.i(237152);
    this.ezQ = x("PostId", paramString, true);
    AppMethodBeat.o(237152);
    return this;
  }
  
  public final dj oJ(String paramString)
  {
    AppMethodBeat.i(237153);
    this.ezR = x("EditId", paramString, true);
    AppMethodBeat.o(237153);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dj
 * JD-Core Version:    0.7.0.1
 */
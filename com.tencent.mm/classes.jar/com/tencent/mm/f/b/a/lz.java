package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lz
  extends a
{
  private String gQY = "";
  private long gRb = 0L;
  private long gRc = 0L;
  private long gRi = 0L;
  private long gRj = 0L;
  private long gRk = 0L;
  private long gRl = 2L;
  private long gRm = 0L;
  private long gRo = 0L;
  private long gRp = 0L;
  private long gSA = 0L;
  private long gSB = 0L;
  private long gSC = 0L;
  private long gSD = 0L;
  private String gSE = "";
  private long gSy = 0L;
  private long gSz = 0L;
  private long ggQ = 0L;
  private long glw = 0L;
  private long gpu = 0L;
  
  public final lz Cw(String paramString)
  {
    AppMethodBeat.i(74984);
    this.gQY = z("PublishObjectId", paramString, true);
    AppMethodBeat.o(74984);
    return this;
  }
  
  public final lz Cx(String paramString)
  {
    AppMethodBeat.i(74985);
    this.gSE = z("NewActionTrace", paramString, true);
    AppMethodBeat.o(74985);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(74986);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRp);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(74986);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(74987);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.ggQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishObjectId:").append(this.gQY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.gpu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.glw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QuitTime:").append(this.gSy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasRecordVideo:").append(this.gSz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterAllbum:").append(this.gSA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiWidgetCount:").append(this.gRb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextWidgetCount:").append(this.gRc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddMusic:").append(this.gSB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddPosition:").append(this.gSC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTrace:").append(this.gSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewActionTrace:").append(this.gSE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.gRi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickSearchMusic:").append(this.gRj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPublicTimeLine:").append(this.gRk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishVideoType:").append(this.gRl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PhotoCount:").append(this.gRm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAddTextIntro:").append(this.gRo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddTextIntroWordCount:").append(this.gRp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74987);
    return localObject;
  }
  
  public final lz anh()
  {
    this.gSz = 1L;
    return this;
  }
  
  public final lz ani()
  {
    this.gSA = 1L;
    return this;
  }
  
  public final lz anj()
  {
    this.gSB = 0L;
    return this;
  }
  
  public final lz ank()
  {
    this.gSC = 1L;
    return this;
  }
  
  public final lz anl()
  {
    this.gRj = 1L;
    return this;
  }
  
  public final lz anm()
  {
    this.gRo = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 16639;
  }
  
  public final lz wD(long paramLong)
  {
    this.ggQ = paramLong;
    return this;
  }
  
  public final lz wE(long paramLong)
  {
    this.gpu = paramLong;
    return this;
  }
  
  public final lz wF(long paramLong)
  {
    this.glw = paramLong;
    return this;
  }
  
  public final lz wG(long paramLong)
  {
    this.gSy = paramLong;
    return this;
  }
  
  public final lz wH(long paramLong)
  {
    this.gRb = paramLong;
    return this;
  }
  
  public final lz wI(long paramLong)
  {
    this.gRc = paramLong;
    return this;
  }
  
  public final lz wJ(long paramLong)
  {
    this.gRi = paramLong;
    return this;
  }
  
  public final lz wK(long paramLong)
  {
    this.gRk = paramLong;
    return this;
  }
  
  public final lz wL(long paramLong)
  {
    this.gRl = paramLong;
    return this;
  }
  
  public final lz wM(long paramLong)
  {
    this.gRm = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lz
 * JD-Core Version:    0.7.0.1
 */
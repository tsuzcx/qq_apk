package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lo
  extends a
{
  private String gQY = "";
  private long gQZ = 0L;
  private long gRa = 0L;
  private long gRb = 0L;
  private long gRc = 0L;
  private String gRd = "";
  private long gRe = 0L;
  private String gRf = "";
  private String gRg = "";
  private String gRh = "";
  private long gRi = 0L;
  private long gRj = 0L;
  private long gRk = 1L;
  private long gRl = 2L;
  private long gRm = 0L;
  private long gRn = 0L;
  private long gRo = 0L;
  private long gRp = 0L;
  private long gRq = 0L;
  private String gRr = "";
  private long gRs = 0L;
  private long gRt = 0L;
  private long ggQ = 0L;
  private long gki = 0L;
  private long gla = 0L;
  private long glb = 0L;
  private String glg = "";
  private long glw = 0L;
  private long gpu = 0L;
  private long gvP = 0L;
  
  public final lo Cd(String paramString)
  {
    AppMethodBeat.i(74975);
    this.gQY = z("PublishObjectId", paramString, true);
    AppMethodBeat.o(74975);
    return this;
  }
  
  public final lo Ce(String paramString)
  {
    AppMethodBeat.i(74976);
    this.gRd = z("MusicId", paramString, true);
    AppMethodBeat.o(74976);
    return this;
  }
  
  public final lo Cf(String paramString)
  {
    AppMethodBeat.i(74977);
    this.gRf = z("PositionInfo", paramString, true);
    AppMethodBeat.o(74977);
    return this;
  }
  
  public final lo Cg(String paramString)
  {
    AppMethodBeat.i(74978);
    this.gRg = z("PositionLatitude", paramString, true);
    AppMethodBeat.o(74978);
    return this;
  }
  
  public final lo Ch(String paramString)
  {
    AppMethodBeat.i(74979);
    this.gRh = z("PositionLongitude", paramString, true);
    AppMethodBeat.o(74979);
    return this;
  }
  
  public final lo Ci(String paramString)
  {
    AppMethodBeat.i(74980);
    this.glg = z("ActionTrace", paramString, true);
    AppMethodBeat.o(74980);
    return this;
  }
  
  public final lo Cj(String paramString)
  {
    AppMethodBeat.i(74981);
    this.gRr = z("PhotoWidthHeightScales", paramString, true);
    AppMethodBeat.o(74981);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(74982);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gla);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRt);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(74982);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(74983);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.ggQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishObjectId:").append(this.gQY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.gpu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.glw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartEditTime:").append(this.gQZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendTime:").append(this.gRa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.gki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSource:").append(this.gvP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiWidgetCount:").append(this.gRb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextWidgetCount:").append(this.gRc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MusicId:").append(this.gRd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MusicOrder:").append(this.gRe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PositionInfo:").append(this.gRf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MusicRequestId:").append(this.gla);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PositionLatitude:").append(this.gRg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PositionLongitude:").append(this.gRh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTrace:").append(this.glg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.gRi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickSearchMusic:").append(this.gRj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSearchMusic:").append(this.glb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPublicTimeLine:").append(this.gRk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishVideoType:").append(this.gRl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PhotoCount:").append(this.gRm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsShowLyric:").append(this.gRn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAddTextIntro:").append(this.gRo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddTextIntroWordCount:").append(this.gRp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddEmojToTextIntroCount:").append(this.gRq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PhotoWidthHeightScales:").append(this.gRr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoCompoundTime:").append(this.gRs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPortraitVideo:").append(this.gRt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74983);
    return localObject;
  }
  
  public final String amF()
  {
    return this.gQY;
  }
  
  public final lo amG()
  {
    this.gRj = 1L;
    return this;
  }
  
  public final lo amH()
  {
    this.gRn = 1L;
    return this;
  }
  
  public final lo amI()
  {
    this.gRo = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 16638;
  }
  
  public final lo vA(long paramLong)
  {
    this.gRa = paramLong;
    return this;
  }
  
  public final lo vB(long paramLong)
  {
    this.gki = paramLong;
    return this;
  }
  
  public final lo vC(long paramLong)
  {
    this.gvP = paramLong;
    return this;
  }
  
  public final lo vD(long paramLong)
  {
    this.gRb = paramLong;
    return this;
  }
  
  public final lo vE(long paramLong)
  {
    this.gRc = paramLong;
    return this;
  }
  
  public final lo vF(long paramLong)
  {
    this.gRe = paramLong;
    return this;
  }
  
  public final lo vG(long paramLong)
  {
    this.gla = paramLong;
    return this;
  }
  
  public final lo vH(long paramLong)
  {
    this.gRi = paramLong;
    return this;
  }
  
  public final lo vI(long paramLong)
  {
    this.glb = paramLong;
    return this;
  }
  
  public final lo vJ(long paramLong)
  {
    this.gRk = paramLong;
    return this;
  }
  
  public final lo vK(long paramLong)
  {
    this.gRl = paramLong;
    return this;
  }
  
  public final lo vL(long paramLong)
  {
    this.gRm = paramLong;
    return this;
  }
  
  public final lo vM(long paramLong)
  {
    this.gRt = paramLong;
    return this;
  }
  
  public final lo vw(long paramLong)
  {
    this.ggQ = paramLong;
    return this;
  }
  
  public final lo vx(long paramLong)
  {
    this.gpu = paramLong;
    return this;
  }
  
  public final lo vy(long paramLong)
  {
    this.glw = paramLong;
    return this;
  }
  
  public final lo vz(long paramLong)
  {
    this.gQZ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lo
 * JD-Core Version:    0.7.0.1
 */
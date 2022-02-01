package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hz
  extends a
{
  private long gHA;
  private long gHB;
  private long gHC;
  private String gHD = "";
  private String gHE = "";
  private String gHF = "";
  private int gHG = -1;
  private int gHH = 0;
  private long gHI;
  private String gHs = "";
  private long gHt;
  private long gHu;
  private long gHv;
  private long gHw;
  private long gHx;
  private String gHy = "";
  private long gHz;
  private long gef;
  private String gvO = "";
  private long gwJ;
  private String gwV = "";
  
  public final String agH()
  {
    AppMethodBeat.i(233223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gvO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gwV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gwJ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(233223);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(233225);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EditId:").append(this.gvO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JsonInfo:").append(this.gHs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoCount:").append(this.gHt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageCount:").append(this.gHu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditItemCount:").append(this.gHv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioCount:").append(this.gHw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceType:").append(this.gHx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TemplateId:").append(this.gHy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TemplateResourceReady:").append(this.gHz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadTemplateTimeMs:").append(this.gHA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEnableImageEnhancement:").append(this.gHB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.gHC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SeekTimeStr:").append(this.gHD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateCompositionTimeStr:").append(this.gHE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoGOPStr:").append(this.gHF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendType:").append(this.gHG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditType:").append(this.gHH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioId:").append(this.gHI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MusicFeedid:").append(this.gwV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SoundTrackType:").append(this.gwJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(233225);
    return localObject;
  }
  
  public final String alO()
  {
    return this.gHD;
  }
  
  public final int getId()
  {
    return 20741;
  }
  
  public final hz ng(int paramInt)
  {
    this.gHG = paramInt;
    return this;
  }
  
  public final hz se(long paramLong)
  {
    this.gHt = paramLong;
    return this;
  }
  
  public final hz sf(long paramLong)
  {
    this.gHu = paramLong;
    return this;
  }
  
  public final hz sg(long paramLong)
  {
    this.gHv = paramLong;
    return this;
  }
  
  public final hz sh(long paramLong)
  {
    this.gHw = paramLong;
    return this;
  }
  
  public final hz si(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final hz sj(long paramLong)
  {
    this.gHx = paramLong;
    return this;
  }
  
  public final hz sk(long paramLong)
  {
    this.gHB = paramLong;
    return this;
  }
  
  public final hz sl(long paramLong)
  {
    this.gHC = paramLong;
    return this;
  }
  
  public final hz sm(long paramLong)
  {
    this.gHI = paramLong;
    return this;
  }
  
  public final hz sn(long paramLong)
  {
    this.gwJ = paramLong;
    return this;
  }
  
  public final hz xA(String paramString)
  {
    AppMethodBeat.i(233205);
    this.gHs = z("JsonInfo", paramString, true);
    AppMethodBeat.o(233205);
    return this;
  }
  
  public final hz xB(String paramString)
  {
    AppMethodBeat.i(233215);
    this.gHD = z("SeekTimeStr", paramString, true);
    AppMethodBeat.o(233215);
    return this;
  }
  
  public final hz xC(String paramString)
  {
    AppMethodBeat.i(233216);
    this.gHE = z("UpdateCompositionTimeStr", paramString, true);
    AppMethodBeat.o(233216);
    return this;
  }
  
  public final hz xD(String paramString)
  {
    AppMethodBeat.i(233218);
    this.gHF = z("VideoGOPStr", paramString, true);
    AppMethodBeat.o(233218);
    return this;
  }
  
  public final hz xE(String paramString)
  {
    AppMethodBeat.i(233222);
    this.gwV = z("MusicFeedid", paramString, true);
    AppMethodBeat.o(233222);
    return this;
  }
  
  public final hz xz(String paramString)
  {
    AppMethodBeat.i(233204);
    this.gvO = z("EditId", paramString, true);
    AppMethodBeat.o(233204);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hz
 * JD-Core Version:    0.7.0.1
 */
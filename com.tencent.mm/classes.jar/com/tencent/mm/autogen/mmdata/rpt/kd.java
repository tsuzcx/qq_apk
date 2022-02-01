package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kd
  extends a
{
  private String iHL = "";
  public long iIH;
  private String iIT = "";
  public String iVK = "";
  public long iVL;
  public long iVM;
  public long iVN;
  public long iVO;
  public long iVP;
  private String iVQ = "";
  private long iVR;
  private long iVS;
  public long iVT;
  public long iVU;
  public String iVV = "";
  private String iVW = "";
  private String iVX = "";
  public int iVY = -1;
  private int iVZ = 0;
  public long iWa;
  public long ikE;
  
  public final String aIE()
  {
    AppMethodBeat.i(368934);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iHL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iIT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iIH);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368934);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368942);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EditId:").append(this.iHL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JsonInfo:").append(this.iVK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoCount:").append(this.iVL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageCount:").append(this.iVM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditItemCount:").append(this.iVN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioCount:").append(this.iVO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceType:").append(this.iVP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TemplateId:").append(this.iVQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TemplateResourceReady:").append(this.iVR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadTemplateTimeMs:").append(this.iVS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEnableImageEnhancement:").append(this.iVT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.iVU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SeekTimeStr:").append(this.iVV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateCompositionTimeStr:").append(this.iVW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoGOPStr:").append(this.iVX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendType:").append(this.iVY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditType:").append(this.iVZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioId:").append(this.iWa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MusicFeedid:").append(this.iIT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SoundTrackType:").append(this.iIH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368942);
    return localObject;
  }
  
  public final int getId()
  {
    return 20741;
  }
  
  public final kd sN(String paramString)
  {
    AppMethodBeat.i(368894);
    this.iHL = F("EditId", paramString, true);
    AppMethodBeat.o(368894);
    return this;
  }
  
  public final kd sO(String paramString)
  {
    AppMethodBeat.i(368902);
    this.iVV = F("SeekTimeStr", paramString, true);
    AppMethodBeat.o(368902);
    return this;
  }
  
  public final kd sP(String paramString)
  {
    AppMethodBeat.i(368908);
    this.iVW = F("UpdateCompositionTimeStr", paramString, true);
    AppMethodBeat.o(368908);
    return this;
  }
  
  public final kd sQ(String paramString)
  {
    AppMethodBeat.i(368916);
    this.iVX = F("VideoGOPStr", paramString, true);
    AppMethodBeat.o(368916);
    return this;
  }
  
  public final kd sR(String paramString)
  {
    AppMethodBeat.i(368920);
    this.iIT = F("MusicFeedid", paramString, true);
    AppMethodBeat.o(368920);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kd
 * JD-Core Version:    0.7.0.1
 */
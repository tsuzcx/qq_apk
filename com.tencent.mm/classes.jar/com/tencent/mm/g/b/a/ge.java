package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ge
  extends a
{
  private String eIR = "";
  private long eIS;
  private long eIT;
  private long eIU;
  private long eIV;
  private long eIW;
  private String eIX = "";
  private long eIY;
  private long eIZ;
  private long eJa;
  private long eJb;
  private String eJc = "";
  private String eJd = "";
  private String eJe = "";
  private int eJf = -1;
  private long ejA;
  private String ezR = "";
  
  public final String abV()
  {
    AppMethodBeat.i(190439);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ezR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJf);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(190439);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(190440);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EditId:").append(this.ezR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JsonInfo:").append(this.eIR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoCount:").append(this.eIS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageCount:").append(this.eIT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditItemCount:").append(this.eIU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioCount:").append(this.eIV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceType:").append(this.eIW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TemplateId:").append(this.eIX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TemplateResourceReady:").append(this.eIY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadTemplateTimeMs:").append(this.eIZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEnableImageEnhancement:").append(this.eJa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.eJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SeekTimeStr:").append(this.eJc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateCompositionTimeStr:").append(this.eJd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoGOPStr:").append(this.eJe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendType:").append(this.eJf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190440);
    return localObject;
  }
  
  public final String agM()
  {
    return this.eJc;
  }
  
  public final int getId()
  {
    return 20741;
  }
  
  public final ge ln(int paramInt)
  {
    this.eJf = paramInt;
    return this;
  }
  
  public final ge pP(long paramLong)
  {
    this.eIS = paramLong;
    return this;
  }
  
  public final ge pQ(long paramLong)
  {
    this.eIT = paramLong;
    return this;
  }
  
  public final ge pR(long paramLong)
  {
    this.eIU = paramLong;
    return this;
  }
  
  public final ge pS(long paramLong)
  {
    this.eIV = paramLong;
    return this;
  }
  
  public final ge pT(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
  
  public final ge pU(long paramLong)
  {
    this.eIW = paramLong;
    return this;
  }
  
  public final ge pV(long paramLong)
  {
    this.eJa = paramLong;
    return this;
  }
  
  public final ge pW(long paramLong)
  {
    this.eJb = paramLong;
    return this;
  }
  
  public final ge tH(String paramString)
  {
    AppMethodBeat.i(190434);
    this.ezR = x("EditId", paramString, true);
    AppMethodBeat.o(190434);
    return this;
  }
  
  public final ge tI(String paramString)
  {
    AppMethodBeat.i(190435);
    this.eIR = x("JsonInfo", paramString, true);
    AppMethodBeat.o(190435);
    return this;
  }
  
  public final ge tJ(String paramString)
  {
    AppMethodBeat.i(190436);
    this.eJc = x("SeekTimeStr", paramString, true);
    AppMethodBeat.o(190436);
    return this;
  }
  
  public final ge tK(String paramString)
  {
    AppMethodBeat.i(190437);
    this.eJd = x("UpdateCompositionTimeStr", paramString, true);
    AppMethodBeat.o(190437);
    return this;
  }
  
  public final ge tL(String paramString)
  {
    AppMethodBeat.i(190438);
    this.eJe = x("VideoGOPStr", paramString, true);
    AppMethodBeat.o(190438);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ge
 * JD-Core Version:    0.7.0.1
 */
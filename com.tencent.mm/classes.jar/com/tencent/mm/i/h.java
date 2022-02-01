package com.tencent.mm.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class h
  extends g
{
  public String cSu = "";
  public int concurrentCount = 1;
  public long dAY = 0L;
  public String dyU;
  public int dyW;
  public String dzb = "";
  public long fJC;
  public String fJD;
  public int fJE;
  public int fJF;
  public String fJG;
  public int fJH;
  public int fJI = 0;
  public long fJJ = 0L;
  public int fJK = 0;
  public long fJL = 0L;
  public int fJM = 1;
  public h.a fJN;
  public String[] fJa;
  public String filename;
  public String host;
  public boolean isColdSnsData = false;
  public String referer;
  public String signalQuality = "";
  public String snsCipherKey;
  public String snsScene = "";
  public String url;
  public String videoFlag;
  
  public String toString()
  {
    AppMethodBeat.i(120678);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("{");
    ((StringBuffer)localObject).append("isPlayMode: ").append(this.fJF);
    ((StringBuffer)localObject).append(" videoFormat: ").append(this.field_requestVideoFormat);
    ((StringBuffer)localObject).append(" initialDownloadLength : ").append(this.fJk);
    ((StringBuffer)localObject).append(" initialDownloadOffset : ").append(this.fJl);
    ((StringBuffer)localObject).append(" videoXmlTotalLen : ").append(this.fJE);
    ((StringBuffer)localObject).append(" videoTaskType : ").append(this.fJA);
    ((StringBuffer)localObject).append(" filename : ").append(this.filename);
    int i;
    if (XR())
    {
      ((StringBuffer)localObject).append(" url : ").append(this.url);
      ((StringBuffer)localObject).append(" host : ").append(this.host);
      ((StringBuffer)localObject).append(" referer : ").append(this.referer);
      StringBuffer localStringBuffer = ((StringBuffer)localObject).append(" ip size : ");
      if (this.fJa != null)
      {
        i = this.fJa.length;
        localStringBuffer.append(i);
        ((StringBuffer)localObject).append(" isColdSnsData : ").append(this.isColdSnsData);
        ((StringBuffer)localObject).append(" signalQuality : ").append(this.signalQuality);
        ((StringBuffer)localObject).append(" snsScene : ").append(this.snsScene);
        ((StringBuffer)localObject).append(" snsId : ").append(this.dzb);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject).append(" fileid : ").append(this.field_fileId);
      ((StringBuffer)localObject).append(" fileaeskey: ").append(this.field_aesKey);
      ((StringBuffer)localObject).append(" field_preloadRatio:").append(this.field_preloadRatio);
      ((StringBuffer)localObject).append(" newmd5: ").append(this.cSu);
      ((StringBuffer)localObject).append(" snsCipherKey: ").append(this.snsCipherKey);
      ((StringBuffer)localObject).append("}");
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(120678);
      return localObject;
      i = 0;
      break;
      ((StringBuffer)localObject).append(" field_mediaId : ").append(this.field_mediaId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.i.h
 * JD-Core Version:    0.7.0.1
 */
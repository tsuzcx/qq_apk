package com.tencent.mm.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends g
{
  public String bWM = "";
  public long cFn = 0L;
  public int concurrentCount = 1;
  public String czp;
  public int czr;
  public String czw = "";
  public long edG;
  public String edH;
  public int edI;
  public int edJ;
  public String edK;
  public int edL;
  public int edM = 0;
  public long edN = 0L;
  public int edO = 0;
  public long edP = 0L;
  public h.a edQ;
  public String[] edh;
  public String filename;
  public String host;
  public boolean isColdSnsData = false;
  public String referer;
  public String signalQuality = "";
  public String snsScene = "";
  public String url;
  
  public final String toString()
  {
    AppMethodBeat.i(128597);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("{");
    ((StringBuffer)localObject).append("isPlayMode: ").append(this.edJ);
    ((StringBuffer)localObject).append(" videoFormat: ").append(this.field_requestVideoFormat);
    ((StringBuffer)localObject).append(" initialDownloadLength : ").append(this.edq);
    ((StringBuffer)localObject).append(" initialDownloadOffset : ").append(this.edr);
    ((StringBuffer)localObject).append(" videoXmlTotalLen : ").append(this.edI);
    ((StringBuffer)localObject).append(" videoTaskType : ").append(this.edE);
    ((StringBuffer)localObject).append(" filename : ").append(this.filename);
    int i;
    if (Jp())
    {
      ((StringBuffer)localObject).append(" url : ").append(this.url);
      ((StringBuffer)localObject).append(" host : ").append(this.host);
      ((StringBuffer)localObject).append(" referer : ").append(this.referer);
      StringBuffer localStringBuffer = ((StringBuffer)localObject).append(" ip size : ");
      if (this.edh != null)
      {
        i = this.edh.length;
        localStringBuffer.append(i);
        ((StringBuffer)localObject).append(" isColdSnsData : ").append(this.isColdSnsData);
        ((StringBuffer)localObject).append(" signalQuality : ").append(this.signalQuality);
        ((StringBuffer)localObject).append(" snsScene : ").append(this.snsScene);
        ((StringBuffer)localObject).append(" snsId : ").append(this.czw);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject).append(" fileid : ").append(this.field_fileId);
      ((StringBuffer)localObject).append(" fileaeskey: ").append(this.field_aesKey);
      ((StringBuffer)localObject).append(" field_preloadRatio:").append(this.field_preloadRatio);
      ((StringBuffer)localObject).append(" newmd5: ").append(this.bWM);
      ((StringBuffer)localObject).append("}");
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(128597);
      return localObject;
      i = 0;
      break;
      ((StringBuffer)localObject).append(" field_mediaId : ").append(this.field_mediaId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.i.h
 * JD-Core Version:    0.7.0.1
 */
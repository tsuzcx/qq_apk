package com.tencent.mm.j;

public final class g
  extends f
{
  public String bRO;
  public int bRQ;
  public String bRV = "";
  public long bXr = 0L;
  public String bvB = "";
  public int concurrentCount = 1;
  public String[] dlK;
  public long dmd;
  public String dme;
  public int dmf;
  public int dmg;
  public String dmh;
  public int dmi;
  public int dmj = 0;
  public long dmk = 0L;
  public int dml = 0;
  public long dmm = 0L;
  public g.a dmn;
  public String filename;
  public String host;
  public boolean isColdSnsData = false;
  public String referer;
  public String signalQuality = "";
  public String snsScene = "";
  public String url;
  
  public final String toString()
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("{");
    localStringBuffer1.append("isPlayMode: ").append(this.dmg);
    localStringBuffer1.append(" videoFormat: ").append(this.field_requestVideoFormat);
    localStringBuffer1.append(" initialDownloadLength : ").append(this.initialDownloadLength);
    localStringBuffer1.append(" initialDownloadOffset : ").append(this.initialDownloadOffset);
    localStringBuffer1.append(" videoXmlTotalLen : ").append(this.dmf);
    localStringBuffer1.append(" videoTaskType : ").append(this.dmb);
    localStringBuffer1.append(" filename : ").append(this.filename);
    int i;
    if (wX())
    {
      localStringBuffer1.append(" url : ").append(this.url);
      localStringBuffer1.append(" host : ").append(this.host);
      localStringBuffer1.append(" referer : ").append(this.referer);
      StringBuffer localStringBuffer2 = localStringBuffer1.append(" ip size : ");
      if (this.dlK != null)
      {
        i = this.dlK.length;
        localStringBuffer2.append(i);
        localStringBuffer1.append(" isColdSnsData : ").append(this.isColdSnsData);
        localStringBuffer1.append(" signalQuality : ").append(this.signalQuality);
        localStringBuffer1.append(" snsScene : ").append(this.snsScene);
        localStringBuffer1.append(" snsId : ").append(this.bRV);
      }
    }
    for (;;)
    {
      localStringBuffer1.append(" fileid : ").append(this.field_fileId);
      localStringBuffer1.append(" fileaeskey: ").append(this.field_aesKey);
      localStringBuffer1.append(" field_preloadRatio:").append(this.field_preloadRatio);
      localStringBuffer1.append(" newmd5: ").append(this.bvB);
      localStringBuffer1.append("}");
      return localStringBuffer1.toString();
      i = 0;
      break;
      localStringBuffer1.append(" field_mediaId : ").append(this.field_mediaId);
    }
  }
  
  public final boolean xa()
  {
    return this.dmb == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.j.g
 * JD-Core Version:    0.7.0.1
 */
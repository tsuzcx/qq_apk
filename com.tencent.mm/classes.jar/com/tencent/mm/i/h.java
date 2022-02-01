package com.tencent.mm.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class h
  extends g
{
  public String cHq = "";
  public int concurrentCount = 1;
  public String dng;
  public int dni;
  public String dnn = "";
  public long dpl = 0L;
  public String filename;
  public String[] fqT;
  public long frA = 0L;
  public int frB = 0;
  public long frC = 0L;
  public int frD = 1;
  public a frE;
  public long frt;
  public String fru;
  public int frv;
  public int frw;
  public String frx;
  public int fry;
  public int frz = 0;
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
    ((StringBuffer)localObject).append("isPlayMode: ").append(this.frw);
    ((StringBuffer)localObject).append(" videoFormat: ").append(this.field_requestVideoFormat);
    ((StringBuffer)localObject).append(" initialDownloadLength : ").append(this.frc);
    ((StringBuffer)localObject).append(" initialDownloadOffset : ").append(this.frd);
    ((StringBuffer)localObject).append(" videoXmlTotalLen : ").append(this.frv);
    ((StringBuffer)localObject).append(" videoTaskType : ").append(this.frr);
    ((StringBuffer)localObject).append(" filename : ").append(this.filename);
    int i;
    if (VA())
    {
      ((StringBuffer)localObject).append(" url : ").append(this.url);
      ((StringBuffer)localObject).append(" host : ").append(this.host);
      ((StringBuffer)localObject).append(" referer : ").append(this.referer);
      StringBuffer localStringBuffer = ((StringBuffer)localObject).append(" ip size : ");
      if (this.fqT != null)
      {
        i = this.fqT.length;
        localStringBuffer.append(i);
        ((StringBuffer)localObject).append(" isColdSnsData : ").append(this.isColdSnsData);
        ((StringBuffer)localObject).append(" signalQuality : ").append(this.signalQuality);
        ((StringBuffer)localObject).append(" snsScene : ").append(this.snsScene);
        ((StringBuffer)localObject).append(" snsId : ").append(this.dnn);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject).append(" fileid : ").append(this.field_fileId);
      ((StringBuffer)localObject).append(" fileaeskey: ").append(this.field_aesKey);
      ((StringBuffer)localObject).append(" field_preloadRatio:").append(this.field_preloadRatio);
      ((StringBuffer)localObject).append(" newmd5: ").append(this.cHq);
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
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt, d paramd);
    
    public abstract void a(String paramString1, long paramLong1, long paramLong2, String paramString2);
    
    public abstract void i(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onDataAvailable(String paramString, long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.i.h
 * JD-Core Version:    0.7.0.1
 */
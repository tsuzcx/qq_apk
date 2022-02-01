package com.tencent.mm.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class h
  extends g
{
  public String cKi = "";
  public int concurrentCount = 1;
  public String dpC = "";
  public String dpv;
  public int dpx;
  public long drA = 0L;
  public String filename;
  public long fnZ;
  public String[] fnz;
  public String foa;
  public int fob;
  public int foc;
  public String fod;
  public int foe;
  public int fof = 0;
  public long fog = 0L;
  public int foh = 0;
  public long foi = 0L;
  public a foj;
  public String host;
  public boolean isColdSnsData = false;
  public int qpa = 1;
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
    ((StringBuffer)localObject).append("isPlayMode: ").append(this.foc);
    ((StringBuffer)localObject).append(" videoFormat: ").append(this.field_requestVideoFormat);
    ((StringBuffer)localObject).append(" initialDownloadLength : ").append(this.fnI);
    ((StringBuffer)localObject).append(" initialDownloadOffset : ").append(this.fnJ);
    ((StringBuffer)localObject).append(" videoXmlTotalLen : ").append(this.fob);
    ((StringBuffer)localObject).append(" videoTaskType : ").append(this.fnX);
    ((StringBuffer)localObject).append(" filename : ").append(this.filename);
    int i;
    if (UF())
    {
      ((StringBuffer)localObject).append(" url : ").append(this.url);
      ((StringBuffer)localObject).append(" host : ").append(this.host);
      ((StringBuffer)localObject).append(" referer : ").append(this.referer);
      StringBuffer localStringBuffer = ((StringBuffer)localObject).append(" ip size : ");
      if (this.fnz != null)
      {
        i = this.fnz.length;
        localStringBuffer.append(i);
        ((StringBuffer)localObject).append(" isColdSnsData : ").append(this.isColdSnsData);
        ((StringBuffer)localObject).append(" signalQuality : ").append(this.signalQuality);
        ((StringBuffer)localObject).append(" snsScene : ").append(this.snsScene);
        ((StringBuffer)localObject).append(" snsId : ").append(this.dpC);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject).append(" fileid : ").append(this.field_fileId);
      ((StringBuffer)localObject).append(" fileaeskey: ").append(this.field_aesKey);
      ((StringBuffer)localObject).append(" field_preloadRatio:").append(this.field_preloadRatio);
      ((StringBuffer)localObject).append(" newmd5: ").append(this.cKi);
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
    
    public abstract void k(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onDataAvailable(String paramString, long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.i.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class h
  extends g
{
  public int concurrentCount = 1;
  public String filename;
  public String hQQ;
  public int hQS;
  public String hQX = "";
  public long hTh = 0L;
  public String heD = "";
  public String host;
  public boolean isColdSnsData = false;
  public String[] lwE;
  public long lxf;
  public String lxg;
  public int lxh;
  public int lxi;
  public String lxj;
  public int lxk;
  public int lxl = 0;
  public long lxm = 0L;
  public int lxn = 0;
  public long lxo = 0L;
  public int lxp = 1;
  public boolean lxq;
  public boolean lxr;
  public a lxs;
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
    ((StringBuffer)localObject).append("isPlayMode: ").append(this.lxi);
    ((StringBuffer)localObject).append(" videoFormat: ").append(this.field_requestVideoFormat);
    ((StringBuffer)localObject).append(" initialDownloadLength : ").append(this.lwM);
    ((StringBuffer)localObject).append(" initialDownloadOffset : ").append(this.lwN);
    ((StringBuffer)localObject).append(" videoXmlTotalLen : ").append(this.lxh);
    ((StringBuffer)localObject).append(" videoTaskType : ").append(this.lxc);
    ((StringBuffer)localObject).append(" filename : ").append(this.filename);
    int i;
    if (aLJ())
    {
      ((StringBuffer)localObject).append(" url : ").append(this.url);
      ((StringBuffer)localObject).append(" host : ").append(this.host);
      ((StringBuffer)localObject).append(" referer : ").append(this.referer);
      StringBuffer localStringBuffer = ((StringBuffer)localObject).append(" ip size : ");
      if (this.lwE != null)
      {
        i = this.lwE.length;
        localStringBuffer.append(i);
        ((StringBuffer)localObject).append(" isColdSnsData : ").append(this.isColdSnsData);
        ((StringBuffer)localObject).append(" signalQuality : ").append(this.signalQuality);
        ((StringBuffer)localObject).append(" snsScene : ").append(this.snsScene);
        ((StringBuffer)localObject).append(" snsId : ").append(this.hQX);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject).append(" fileid : ").append(this.field_fileId);
      ((StringBuffer)localObject).append(" fileaeskey: ").append(this.field_aesKey);
      ((StringBuffer)localObject).append(" field_preloadRatio:").append(this.field_preloadRatio);
      ((StringBuffer)localObject).append(" newmd5: ").append(this.heD);
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
    
    public abstract void h(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onDataAvailable(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onM3U8Ready(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.h
 * JD-Core Version:    0.7.0.1
 */
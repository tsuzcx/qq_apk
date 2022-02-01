package com.tencent.mm.plugin.downloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;

public final class b
{
  public String appId;
  public long cYu;
  public String channelId;
  public int dCE;
  public int diX;
  public String downloadUrl;
  public int errCode;
  public String extInfo;
  public long lTa;
  public long mSs;
  public long oJK;
  public int oJL;
  public int oJM;
  public int oJN;
  public int oJO;
  public int oJP;
  public int oJQ;
  public long oJm;
  public int scene;
  
  public b()
  {
    this.dCE = 1;
  }
  
  public b(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    this.dCE = 1;
    this.appId = paramString1;
    this.scene = paramInt;
    this.cYu = paramLong;
    this.channelId = paramString2;
    this.extInfo = null;
    this.oJM = 0;
  }
  
  public b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(89085);
    this.dCE = 1;
    this.appId = paramString1;
    this.scene = paramInt1;
    this.oJN = paramInt1;
    this.extInfo = paramString2;
    this.oJM = this.oJM;
    this.oJO = paramInt2;
    this.oJP = paramInt4;
    this.oJQ = paramInt3;
    this.dCE = paramInt5;
    AppMethodBeat.o(89085);
  }
  
  public b(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt)
  {
    this.dCE = 1;
    this.appId = paramString1;
    this.cYu = paramLong1;
    this.channelId = paramString2;
    this.lTa = paramLong2;
    this.oJM = paramInt;
  }
  
  public final void k(a parama)
  {
    AppMethodBeat.i(89086);
    this.appId = parama.field_appId;
    this.scene = parama.field_scene;
    this.oJK = parama.field_startSize;
    this.oJm = (parama.field_downloadedSize - parama.field_startSize);
    long l;
    if (this.oJm < 0L)
    {
      l = 0L;
      this.oJm = l;
      this.mSs = parama.field_totalSize;
      this.downloadUrl = parama.field_downloadUrl;
      this.errCode = parama.field_errCode;
      this.diX = parama.field_downloaderType;
      this.channelId = parama.field_channelId;
      if (parama.field_finishTime <= 0L) {
        break label232;
      }
      l = parama.field_finishTime;
      label112:
      if (parama.field_startTime != 0L) {
        break label239;
      }
      this.lTa = 0L;
      label126:
      if (this.lTa < 0L) {
        this.lTa = 0L;
      }
      this.oJL = parama.field_startState;
      this.cYu = parama.field_downloadId;
      this.extInfo = parama.field_extInfo;
      if (!parama.field_reserveInWifi) {
        break label256;
      }
    }
    label256:
    for (int i = 1;; i = 0)
    {
      this.oJM = i;
      this.oJN = parama.field_startScene;
      this.oJO = parama.field_uiarea;
      this.oJP = parama.field_noticeId;
      this.oJQ = parama.field_ssid;
      this.dCE = parama.field_downloadType;
      AppMethodBeat.o(89086);
      return;
      l = this.oJm;
      break;
      label232:
      l = System.currentTimeMillis();
      break label112;
      label239:
      this.lTa = ((l - parama.field_startTime) / 1000L);
      break label126;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.b
 * JD-Core Version:    0.7.0.1
 */
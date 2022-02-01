package com.tencent.mm.plugin.downloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;

public final class b
{
  public String appId;
  public String channelId;
  public long costTime;
  public long dCa;
  public int dNv;
  public String downloadUrl;
  public int eik;
  public int errCode;
  public String extInfo;
  public long oJj;
  public long qJD;
  public int qJE;
  public int qJF;
  public int qJG;
  public int qJH;
  public int qJI;
  public int qJJ;
  public long qJe;
  public int scene;
  
  public b()
  {
    this.eik = 1;
  }
  
  public b(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    this.eik = 1;
    this.appId = paramString1;
    this.scene = paramInt;
    this.dCa = paramLong;
    this.channelId = paramString2;
    this.extInfo = null;
    this.qJF = 0;
  }
  
  public b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(89085);
    this.eik = 1;
    this.appId = paramString1;
    this.scene = paramInt1;
    this.qJG = paramInt1;
    this.extInfo = paramString2;
    this.qJF = this.qJF;
    this.qJH = paramInt2;
    this.qJI = paramInt4;
    this.qJJ = paramInt3;
    this.eik = paramInt5;
    AppMethodBeat.o(89085);
  }
  
  public b(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt)
  {
    this.eik = 1;
    this.appId = paramString1;
    this.dCa = paramLong1;
    this.channelId = paramString2;
    this.costTime = paramLong2;
    this.qJF = paramInt;
  }
  
  public final void k(a parama)
  {
    AppMethodBeat.i(89086);
    this.appId = parama.field_appId;
    this.scene = parama.field_scene;
    this.qJD = parama.field_startSize;
    this.qJe = (parama.field_downloadedSize - parama.field_startSize);
    long l;
    if (this.qJe < 0L)
    {
      l = 0L;
      this.qJe = l;
      this.oJj = parama.field_totalSize;
      this.downloadUrl = parama.field_downloadUrl;
      this.errCode = parama.field_errCode;
      this.dNv = parama.field_downloaderType;
      this.channelId = parama.field_channelId;
      if (parama.field_finishTime <= 0L) {
        break label232;
      }
      l = parama.field_finishTime;
      label112:
      if (parama.field_startTime != 0L) {
        break label239;
      }
      this.costTime = 0L;
      label126:
      if (this.costTime < 0L) {
        this.costTime = 0L;
      }
      this.qJE = parama.field_startState;
      this.dCa = parama.field_downloadId;
      this.extInfo = parama.field_extInfo;
      if (!parama.field_reserveInWifi) {
        break label256;
      }
    }
    label256:
    for (int i = 1;; i = 0)
    {
      this.qJF = i;
      this.qJG = parama.field_startScene;
      this.qJH = parama.field_uiarea;
      this.qJI = parama.field_noticeId;
      this.qJJ = parama.field_ssid;
      this.eik = parama.field_downloadType;
      AppMethodBeat.o(89086);
      return;
      l = this.qJe;
      break;
      label232:
      l = System.currentTimeMillis();
      break label112;
      label239:
      this.costTime = ((l - parama.field_startTime) / 1000L);
      break label126;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.b
 * JD-Core Version:    0.7.0.1
 */
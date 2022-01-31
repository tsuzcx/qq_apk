package com.tencent.mm.plugin.downloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;

public final class b
{
  public String appId;
  public String channelId;
  public long cmm;
  public int cvQ;
  public String downloadUrl;
  public int errCode;
  public String extInfo;
  public long iHc;
  public long jyU;
  public long kYX;
  public int kZA;
  public int kZB;
  public long kZu;
  public int kZv;
  public int kZw;
  public int kZx;
  public int kZy;
  public int kZz;
  public int scene;
  
  public b()
  {
    this.kZB = 1;
  }
  
  public b(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    this.kZB = 1;
    this.appId = paramString1;
    this.scene = paramInt;
    this.cmm = paramLong;
    this.channelId = paramString2;
    this.extInfo = null;
    this.kZw = 0;
  }
  
  public b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(141102);
    this.kZB = 1;
    this.appId = paramString1;
    this.scene = paramInt1;
    this.kZx = paramInt1;
    this.extInfo = paramString2;
    this.kZw = this.kZw;
    this.kZy = paramInt2;
    this.kZz = paramInt4;
    this.kZA = paramInt3;
    this.kZB = paramInt5;
    AppMethodBeat.o(141102);
  }
  
  public b(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt)
  {
    this.kZB = 1;
    this.appId = paramString1;
    this.cmm = paramLong1;
    this.channelId = paramString2;
    this.iHc = paramLong2;
    this.kZw = paramInt;
  }
  
  public final void i(a parama)
  {
    AppMethodBeat.i(141103);
    this.appId = parama.field_appId;
    this.scene = parama.field_scene;
    this.kZu = parama.field_startSize;
    this.kYX = (parama.field_downloadedSize - parama.field_startSize);
    long l;
    if (this.kYX < 0L)
    {
      l = 0L;
      this.kYX = l;
      this.jyU = parama.field_totalSize;
      this.downloadUrl = parama.field_downloadUrl;
      this.errCode = parama.field_errCode;
      this.cvQ = parama.field_downloaderType;
      this.channelId = parama.field_channelId;
      if (parama.field_finishTime <= 0L) {
        break label232;
      }
      l = parama.field_finishTime;
      label112:
      if (parama.field_startTime != 0L) {
        break label239;
      }
      this.iHc = 0L;
      label126:
      if (this.iHc < 0L) {
        this.iHc = 0L;
      }
      this.kZv = parama.field_startState;
      this.cmm = parama.field_downloadId;
      this.extInfo = parama.field_extInfo;
      if (!parama.field_reserveInWifi) {
        break label256;
      }
    }
    label256:
    for (int i = 1;; i = 0)
    {
      this.kZw = i;
      this.kZx = parama.field_startScene;
      this.kZy = parama.field_uiarea;
      this.kZz = parama.field_noticeId;
      this.kZA = parama.field_ssid;
      this.kZB = parama.field_downloadType;
      AppMethodBeat.o(141103);
      return;
      l = this.kYX;
      break;
      label232:
      l = System.currentTimeMillis();
      break label112;
      label239:
      this.iHc = ((l - parama.field_startTime) / 1000L);
      break label126;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.b
 * JD-Core Version:    0.7.0.1
 */
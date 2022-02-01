package com.tencent.mm.plugin.downloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;

public final class b
{
  public String appId;
  public String channelId;
  public int dES;
  public long daY;
  public int dlp;
  public String downloadUrl;
  public int errCode;
  public String extInfo;
  public long lrf;
  public long mqq;
  public long ofL;
  public long ogk;
  public int ogl;
  public int ogm;
  public int ogn;
  public int ogo;
  public int ogp;
  public int ogq;
  public int scene;
  
  public b()
  {
    this.dES = 1;
  }
  
  public b(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    this.dES = 1;
    this.appId = paramString1;
    this.scene = paramInt;
    this.daY = paramLong;
    this.channelId = paramString2;
    this.extInfo = null;
    this.ogm = 0;
  }
  
  public b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(89085);
    this.dES = 1;
    this.appId = paramString1;
    this.scene = paramInt1;
    this.ogn = paramInt1;
    this.extInfo = paramString2;
    this.ogm = this.ogm;
    this.ogo = paramInt2;
    this.ogp = paramInt4;
    this.ogq = paramInt3;
    this.dES = paramInt5;
    AppMethodBeat.o(89085);
  }
  
  public b(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt)
  {
    this.dES = 1;
    this.appId = paramString1;
    this.daY = paramLong1;
    this.channelId = paramString2;
    this.lrf = paramLong2;
    this.ogm = paramInt;
  }
  
  public final void k(a parama)
  {
    AppMethodBeat.i(89086);
    this.appId = parama.field_appId;
    this.scene = parama.field_scene;
    this.ogk = parama.field_startSize;
    this.ofL = (parama.field_downloadedSize - parama.field_startSize);
    long l;
    if (this.ofL < 0L)
    {
      l = 0L;
      this.ofL = l;
      this.mqq = parama.field_totalSize;
      this.downloadUrl = parama.field_downloadUrl;
      this.errCode = parama.field_errCode;
      this.dlp = parama.field_downloaderType;
      this.channelId = parama.field_channelId;
      if (parama.field_finishTime <= 0L) {
        break label232;
      }
      l = parama.field_finishTime;
      label112:
      if (parama.field_startTime != 0L) {
        break label239;
      }
      this.lrf = 0L;
      label126:
      if (this.lrf < 0L) {
        this.lrf = 0L;
      }
      this.ogl = parama.field_startState;
      this.daY = parama.field_downloadId;
      this.extInfo = parama.field_extInfo;
      if (!parama.field_reserveInWifi) {
        break label256;
      }
    }
    label256:
    for (int i = 1;; i = 0)
    {
      this.ogm = i;
      this.ogn = parama.field_startScene;
      this.ogo = parama.field_uiarea;
      this.ogp = parama.field_noticeId;
      this.ogq = parama.field_ssid;
      this.dES = parama.field_downloadType;
      AppMethodBeat.o(89086);
      return;
      l = this.ofL;
      break;
      label232:
      l = System.currentTimeMillis();
      break label112;
      label239:
      this.lrf = ((l - parama.field_startTime) / 1000L);
      break label126;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.b
 * JD-Core Version:    0.7.0.1
 */
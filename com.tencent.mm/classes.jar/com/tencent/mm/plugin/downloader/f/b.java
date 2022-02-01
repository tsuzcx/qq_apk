package com.tencent.mm.plugin.downloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;

public final class b
{
  public String appId;
  public String channelId;
  public long costTime;
  public String downloadUrl;
  public int errCode;
  public String extInfo;
  public int fGH;
  public long fuD;
  public int gcB;
  public long rKZ;
  public int scene;
  public long uiI;
  public int uiJ;
  public int uiK;
  public int uiL;
  public int uiM;
  public int uiN;
  public int uiO;
  public long uih;
  
  public b()
  {
    this.gcB = 1;
  }
  
  public b(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    this.gcB = 1;
    this.appId = paramString1;
    this.scene = paramInt;
    this.fuD = paramLong;
    this.channelId = paramString2;
    this.extInfo = null;
    this.uiK = 0;
  }
  
  public b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(89085);
    this.gcB = 1;
    this.appId = paramString1;
    this.scene = paramInt1;
    this.uiL = paramInt1;
    this.extInfo = paramString2;
    this.uiK = this.uiK;
    this.uiM = paramInt2;
    this.uiN = paramInt4;
    this.uiO = paramInt3;
    this.gcB = paramInt5;
    AppMethodBeat.o(89085);
  }
  
  public b(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt)
  {
    this.gcB = 1;
    this.appId = paramString1;
    this.fuD = paramLong1;
    this.channelId = paramString2;
    this.costTime = paramLong2;
    this.uiK = paramInt;
  }
  
  public final void k(a parama)
  {
    AppMethodBeat.i(89086);
    this.appId = parama.field_appId;
    this.scene = parama.field_scene;
    this.uiI = parama.field_startSize;
    this.uih = (parama.field_downloadedSize - parama.field_startSize);
    long l;
    if (this.uih < 0L)
    {
      l = 0L;
      this.uih = l;
      this.rKZ = parama.field_totalSize;
      this.downloadUrl = parama.field_downloadUrl;
      this.errCode = parama.field_errCode;
      this.fGH = parama.field_downloaderType;
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
      this.uiJ = parama.field_startState;
      this.fuD = parama.field_downloadId;
      this.extInfo = parama.field_extInfo;
      if (!parama.field_reserveInWifi) {
        break label256;
      }
    }
    label256:
    for (int i = 1;; i = 0)
    {
      this.uiK = i;
      this.uiL = parama.field_startScene;
      this.uiM = parama.field_uiarea;
      this.uiN = parama.field_noticeId;
      this.uiO = parama.field_ssid;
      this.gcB = parama.field_downloadType;
      AppMethodBeat.o(89086);
      return;
      l = this.uih;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.b
 * JD-Core Version:    0.7.0.1
 */
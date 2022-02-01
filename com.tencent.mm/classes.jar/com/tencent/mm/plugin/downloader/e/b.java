package com.tencent.mm.plugin.downloader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.a;

public final class b
{
  public String appId;
  public String channelId;
  public long costTime;
  public String downloadUrl;
  public int errCode;
  public String extInfo;
  public int hMd;
  public long hyV;
  public int iiN;
  public int scene;
  public long uWn;
  public long xoL;
  public int xoM;
  public int xoN;
  public int xoO;
  public int xoP;
  public int xoQ;
  public int xoR;
  public long xom;
  
  public b()
  {
    this.iiN = 1;
  }
  
  public b(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    this.iiN = 1;
    this.appId = paramString1;
    this.scene = paramInt;
    this.hyV = paramLong;
    this.channelId = paramString2;
    this.extInfo = null;
    this.xoN = 0;
  }
  
  public b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(89085);
    this.iiN = 1;
    this.appId = paramString1;
    this.scene = paramInt1;
    this.xoO = paramInt1;
    this.extInfo = paramString2;
    this.xoN = this.xoN;
    this.xoP = paramInt2;
    this.xoQ = paramInt4;
    this.xoR = paramInt3;
    this.iiN = paramInt5;
    AppMethodBeat.o(89085);
  }
  
  public b(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt)
  {
    this.iiN = 1;
    this.appId = paramString1;
    this.hyV = paramLong1;
    this.channelId = paramString2;
    this.costTime = paramLong2;
    this.xoN = paramInt;
  }
  
  public final void k(a parama)
  {
    AppMethodBeat.i(89086);
    this.appId = parama.field_appId;
    this.scene = parama.field_scene;
    this.xoL = parama.field_startSize;
    this.xom = (parama.field_downloadedSize - parama.field_startSize);
    long l;
    if (this.xom < 0L)
    {
      l = 0L;
      this.xom = l;
      this.uWn = parama.field_totalSize;
      this.downloadUrl = parama.field_downloadUrl;
      this.errCode = parama.field_errCode;
      this.hMd = parama.field_downloaderType;
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
      this.xoM = parama.field_startState;
      this.hyV = parama.field_downloadId;
      this.extInfo = parama.field_extInfo;
      if (!parama.field_reserveInWifi) {
        break label256;
      }
    }
    label256:
    for (int i = 1;; i = 0)
    {
      this.xoN = i;
      this.xoO = parama.field_startScene;
      this.xoP = parama.field_uiarea;
      this.xoQ = parama.field_noticeId;
      this.xoR = parama.field_ssid;
      this.iiN = parama.field_downloadType;
      AppMethodBeat.o(89086);
      return;
      l = this.xom;
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
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.downloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;

public final class b
{
  public String appId;
  public String channelId;
  public int dQh;
  public long dkO;
  public String downloadUrl;
  public int dvO;
  public int errCode;
  public String extInfo;
  public long mxN;
  public long nyl;
  public long ptA;
  public long ptY;
  public int ptZ;
  public int pua;
  public int pub;
  public int puc;
  public int pud;
  public int pue;
  public int scene;
  
  public b()
  {
    this.dQh = 1;
  }
  
  public b(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    this.dQh = 1;
    this.appId = paramString1;
    this.scene = paramInt;
    this.dkO = paramLong;
    this.channelId = paramString2;
    this.extInfo = null;
    this.pua = 0;
  }
  
  public b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(89085);
    this.dQh = 1;
    this.appId = paramString1;
    this.scene = paramInt1;
    this.pub = paramInt1;
    this.extInfo = paramString2;
    this.pua = this.pua;
    this.puc = paramInt2;
    this.pud = paramInt4;
    this.pue = paramInt3;
    this.dQh = paramInt5;
    AppMethodBeat.o(89085);
  }
  
  public b(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt)
  {
    this.dQh = 1;
    this.appId = paramString1;
    this.dkO = paramLong1;
    this.channelId = paramString2;
    this.mxN = paramLong2;
    this.pua = paramInt;
  }
  
  public final void k(a parama)
  {
    AppMethodBeat.i(89086);
    this.appId = parama.field_appId;
    this.scene = parama.field_scene;
    this.ptY = parama.field_startSize;
    this.ptA = (parama.field_downloadedSize - parama.field_startSize);
    long l;
    if (this.ptA < 0L)
    {
      l = 0L;
      this.ptA = l;
      this.nyl = parama.field_totalSize;
      this.downloadUrl = parama.field_downloadUrl;
      this.errCode = parama.field_errCode;
      this.dvO = parama.field_downloaderType;
      this.channelId = parama.field_channelId;
      if (parama.field_finishTime <= 0L) {
        break label232;
      }
      l = parama.field_finishTime;
      label112:
      if (parama.field_startTime != 0L) {
        break label239;
      }
      this.mxN = 0L;
      label126:
      if (this.mxN < 0L) {
        this.mxN = 0L;
      }
      this.ptZ = parama.field_startState;
      this.dkO = parama.field_downloadId;
      this.extInfo = parama.field_extInfo;
      if (!parama.field_reserveInWifi) {
        break label256;
      }
    }
    label256:
    for (int i = 1;; i = 0)
    {
      this.pua = i;
      this.pub = parama.field_startScene;
      this.puc = parama.field_uiarea;
      this.pud = parama.field_noticeId;
      this.pue = parama.field_ssid;
      this.dQh = parama.field_downloadType;
      AppMethodBeat.o(89086);
      return;
      l = this.ptA;
      break;
      label232:
      l = System.currentTimeMillis();
      break label112;
      label239:
      this.mxN = ((l - parama.field_startTime) / 1000L);
      break label126;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.b
 * JD-Core Version:    0.7.0.1
 */
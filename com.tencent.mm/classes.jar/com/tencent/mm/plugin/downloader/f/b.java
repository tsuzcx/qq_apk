package com.tencent.mm.plugin.downloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;

public final class b
{
  public String appId;
  public String channelId;
  public int dOR;
  public long djM;
  public String downloadUrl;
  public int duJ;
  public int errCode;
  public String extInfo;
  public long msQ;
  public long nsQ;
  public long pmT;
  public long pnr;
  public int pns;
  public int pnt;
  public int pnu;
  public int pnv;
  public int pnw;
  public int pnx;
  public int scene;
  
  public b()
  {
    this.dOR = 1;
  }
  
  public b(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    this.dOR = 1;
    this.appId = paramString1;
    this.scene = paramInt;
    this.djM = paramLong;
    this.channelId = paramString2;
    this.extInfo = null;
    this.pnt = 0;
  }
  
  public b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(89085);
    this.dOR = 1;
    this.appId = paramString1;
    this.scene = paramInt1;
    this.pnu = paramInt1;
    this.extInfo = paramString2;
    this.pnt = this.pnt;
    this.pnv = paramInt2;
    this.pnw = paramInt4;
    this.pnx = paramInt3;
    this.dOR = paramInt5;
    AppMethodBeat.o(89085);
  }
  
  public b(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt)
  {
    this.dOR = 1;
    this.appId = paramString1;
    this.djM = paramLong1;
    this.channelId = paramString2;
    this.msQ = paramLong2;
    this.pnt = paramInt;
  }
  
  public final void k(a parama)
  {
    AppMethodBeat.i(89086);
    this.appId = parama.field_appId;
    this.scene = parama.field_scene;
    this.pnr = parama.field_startSize;
    this.pmT = (parama.field_downloadedSize - parama.field_startSize);
    long l;
    if (this.pmT < 0L)
    {
      l = 0L;
      this.pmT = l;
      this.nsQ = parama.field_totalSize;
      this.downloadUrl = parama.field_downloadUrl;
      this.errCode = parama.field_errCode;
      this.duJ = parama.field_downloaderType;
      this.channelId = parama.field_channelId;
      if (parama.field_finishTime <= 0L) {
        break label232;
      }
      l = parama.field_finishTime;
      label112:
      if (parama.field_startTime != 0L) {
        break label239;
      }
      this.msQ = 0L;
      label126:
      if (this.msQ < 0L) {
        this.msQ = 0L;
      }
      this.pns = parama.field_startState;
      this.djM = parama.field_downloadId;
      this.extInfo = parama.field_extInfo;
      if (!parama.field_reserveInWifi) {
        break label256;
      }
    }
    label256:
    for (int i = 1;; i = 0)
    {
      this.pnt = i;
      this.pnu = parama.field_startScene;
      this.pnv = parama.field_uiarea;
      this.pnw = parama.field_noticeId;
      this.pnx = parama.field_ssid;
      this.dOR = parama.field_downloadType;
      AppMethodBeat.o(89086);
      return;
      l = this.pmT;
      break;
      label232:
      l = System.currentTimeMillis();
      break label112;
      label239:
      this.msQ = ((l - parama.field_startTime) / 1000L);
      break label126;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.emoji.b.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.u;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1;", "cdnMediaType", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "startRet", "startTime", "", "fetch", "reportResult", "reportStart", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements d
{
  private final String TAG;
  private kotlin.g.a.b<? super Boolean, ah> callback;
  private e mgu;
  private int mgx;
  private int mgy;
  private final a mgz;
  private long startTime;
  
  public b()
  {
    AppMethodBeat.i(242746);
    this.TAG = "MicroMsg.EmojiCdnHttpsFetcher";
    this.mgz = new a(this);
    AppMethodBeat.o(242746);
  }
  
  private final void fb(boolean paramBoolean)
  {
    AppMethodBeat.i(242747);
    e locale = this.mgu;
    if (locale != null)
    {
      if (paramBoolean)
      {
        com.tencent.mm.plugin.emoji.d.lo(21L);
        com.tencent.mm.plugin.emoji.d.lo(2L);
        AppMethodBeat.o(242747);
        return;
      }
      com.tencent.mm.plugin.emoji.d.lo(22L);
      com.tencent.mm.plugin.emoji.d.lo(3L);
      switch (locale.mgL)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(242747);
      return;
      com.tencent.mm.plugin.emoji.d.a(locale.mgK.getMd5(), 4, 1, 1, locale.mgK.field_groupId, 1, locale.mgK.field_designerID);
      AppMethodBeat.o(242747);
      return;
      com.tencent.mm.plugin.emoji.d.a(locale.mgK.getMd5(), 2, 1, 1, locale.mgK.field_groupId, 1, locale.mgK.field_designerID);
      AppMethodBeat.o(242747);
      return;
      com.tencent.mm.plugin.emoji.d.a(locale.mgK.getMd5(), 4, 1, 1, locale.mgK.field_groupId, 1, locale.mgK.field_designerID);
    }
  }
  
  public final void a(e parame, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(242751);
    s.u(parame, "fetcherConfig");
    this.mgu = parame;
    this.callback = paramb;
    paramb = new u(parame.path).jKP();
    if (paramb != null) {
      paramb.jKY();
    }
    int i;
    if (parame.mgL == 2)
    {
      i = 20403;
      this.mgx = i;
      this.startTime = Util.nowMilliSecond();
      paramb = new CdnLogic.C2CDownloadRequest();
      paramb.queueTimeoutSeconds = 60;
      paramb.transforTimeoutSeconds = 60;
      paramb.taskStartTime = this.startTime;
      paramb.fileType = this.mgx;
      paramb.fileKey = s.X(d.a.aUx(), parame.mgK.getMd5());
      paramb.url = parame.url;
      paramb.setSavePath(parame.path);
      this.mgy = CdnLogic.startHttpsDownload(paramb, (CdnLogic.DownloadCallback)this.mgz);
      Log.i(this.TAG, "fetch: start " + parame.mgK.getMd5() + ' ' + this.mgy);
      com.tencent.mm.plugin.emoji.d.lo(20L);
      parame = this.mgu;
      if (parame != null) {
        switch (parame.mgL)
        {
        }
      }
    }
    for (;;)
    {
      if (this.mgy != 0)
      {
        parame = this.callback;
        if (parame != null) {
          parame.invoke(Boolean.FALSE);
        }
        fb(false);
      }
      AppMethodBeat.o(242751);
      return;
      i = 20401;
      break;
      com.tencent.mm.plugin.emoji.d.lo(1L);
      continue;
      com.tencent.mm.plugin.emoji.d.lo(6L);
      continue;
      com.tencent.mm.plugin.emoji.d.lo(10L);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "", "total", "tryshow", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements CdnLogic.DownloadCallback
  {
    a(b paramb) {}
    
    public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
    {
      AppMethodBeat.i(242744);
      s.u(paramString, "filekey");
      s.u(paramC2CDownloadResult, "result");
      Log.i(b.a(this.mgA), "onC2CDownloadCompleted: " + paramString + ", " + paramC2CDownloadResult.errorCode);
      if (paramC2CDownloadResult.errorCode != 0)
      {
        paramString = b.b(this.mgA);
        if (paramString != null) {
          paramString.invoke(Boolean.FALSE);
        }
        b.a(this.mgA, false);
        AppMethodBeat.o(242744);
        return;
      }
      paramString = b.b(this.mgA);
      if (paramString != null) {
        paramString.invoke(Boolean.TRUE);
      }
      b.a(this.mgA, true);
      AppMethodBeat.o(242744);
    }
    
    public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(242745);
      s.u(paramString, "filekey");
      AppMethodBeat.o(242745);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.b
 * JD-Core Version:    0.7.0.1
 */
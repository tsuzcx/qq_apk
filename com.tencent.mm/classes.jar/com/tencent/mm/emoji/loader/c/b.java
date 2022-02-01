package com.tencent.mm.emoji.loader.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.c;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1;", "cdnMediaType", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "startRet", "startTime", "", "fetch", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class b
  implements d
{
  private final String TAG;
  private kotlin.g.a.b<? super Boolean, x> callback;
  private e jGR;
  private int jGU;
  private int jGV;
  private final a jGW;
  private long startTime;
  
  public b()
  {
    AppMethodBeat.i(229182);
    this.TAG = "MicroMsg.EmojiCdnHttpsFetcher";
    this.jGW = new a(this);
    AppMethodBeat.o(229182);
  }
  
  private final void eo(boolean paramBoolean)
  {
    AppMethodBeat.i(229178);
    e locale = this.jGR;
    if (locale != null)
    {
      if (paramBoolean)
      {
        com.tencent.mm.plugin.emoji.d.IT(21L);
        com.tencent.mm.plugin.emoji.d.IT(2L);
        AppMethodBeat.o(229178);
        return;
      }
      com.tencent.mm.plugin.emoji.d.IT(22L);
      com.tencent.mm.plugin.emoji.d.IT(3L);
      switch (locale.jHi)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(229178);
        return;
        com.tencent.mm.plugin.emoji.d.a(locale.jHh.getMd5(), 4, 1, 1, locale.jHh.aCt(), 1, locale.jHh.field_designerID);
        AppMethodBeat.o(229178);
        return;
        com.tencent.mm.plugin.emoji.d.a(locale.jHh.getMd5(), 2, 1, 1, locale.jHh.aCt(), 1, locale.jHh.field_designerID);
        AppMethodBeat.o(229178);
        return;
        com.tencent.mm.plugin.emoji.d.a(locale.jHh.getMd5(), 4, 1, 1, locale.jHh.aCt(), 1, locale.jHh.field_designerID);
      }
    }
    AppMethodBeat.o(229178);
  }
  
  public final void a(e parame, kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(229168);
    p.k(parame, "fetcherConfig");
    this.jGR = parame;
    this.callback = paramb;
    paramb = new q(parame.path).ifB();
    if (paramb != null) {
      paramb.ifL();
    }
    int i;
    if (parame.jHi == 2)
    {
      i = 20403;
      this.jGU = i;
      this.startTime = Util.nowMilliSecond();
      paramb = new CdnLogic.C2CDownloadRequest();
      paramb.queueTimeoutSeconds = 60;
      paramb.transforTimeoutSeconds = 60;
      paramb.taskStartTime = this.startTime;
      paramb.fileType = this.jGU;
      paramb.fileKey = (d.a.aBz() + parame.jHh.getMd5());
      paramb.url = parame.url;
      paramb.setSavePath(parame.path);
      this.jGV = CdnLogic.startHttpsDownload(paramb, (CdnLogic.DownloadCallback)this.jGW);
      Log.i(this.TAG, "fetch: start " + parame.jHh.getMd5() + ' ' + this.jGV);
      com.tencent.mm.plugin.emoji.d.IT(20L);
      parame = this.jGR;
      if (parame != null) {
        switch (parame.jHi)
        {
        }
      }
    }
    for (;;)
    {
      if (this.jGV != 0)
      {
        new ae(a.t(new Object[] { Integer.valueOf(this.jGV), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cV(MMApplicationContext.getContext())), Integer.valueOf(this.jGU) })).bpa();
        parame = this.callback;
        if (parame != null) {
          parame.invoke(Boolean.FALSE);
        }
        eo(false);
      }
      AppMethodBeat.o(229168);
      return;
      i = 20401;
      break;
      com.tencent.mm.plugin.emoji.d.IT(1L);
      continue;
      com.tencent.mm.plugin.emoji.d.IT(6L);
      continue;
      com.tencent.mm.plugin.emoji.d.IT(10L);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "", "total", "tryshow", "", "plugin-emojisdk_release"})
  public static final class a
    implements CdnLogic.DownloadCallback
  {
    public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
    {
      AppMethodBeat.i(223110);
      p.k(paramString, "filekey");
      p.k(paramC2CDownloadResult, "result");
      Log.i(b.a(this.jGX), "onC2CDownloadCompleted: " + paramString + ", " + paramC2CDownloadResult.errorCode);
      String str = "";
      paramString = "";
      if (!Util.isNullOrNil(paramC2CDownloadResult.transforMsg))
      {
        paramString = paramC2CDownloadResult.transforMsg;
        p.j(paramString, "result.transforMsg");
        int i = n.a((CharSequence)paramString, "@,", 0, false, 6);
        if (i <= 0) {
          break label391;
        }
        paramString = paramC2CDownloadResult.transforMsg;
        p.j(paramString, "result.transforMsg");
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(223110);
          throw paramString;
        }
        paramString = paramString.substring(i + 2);
        p.j(paramString, "(this as java.lang.String).substring(startIndex)");
        str = paramC2CDownloadResult.transforMsg;
        p.j(str, "result.transforMsg");
        if (str == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(223110);
          throw paramString;
        }
        str = str.substring(0, i);
        p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        new ae(a.t(new Object[] { Integer.valueOf(b.b(this.jGX)), Integer.valueOf(2), Long.valueOf(b.c(this.jGX)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cV(MMApplicationContext.getContext())), Integer.valueOf(b.d(this.jGX)), Long.valueOf(paramC2CDownloadResult.fileSize), str, "", "", "", "", "", "", "", paramString })).bpa();
        if (paramC2CDownloadResult.errorCode == 0) {
          break;
        }
        paramString = b.e(this.jGX);
        if (paramString != null) {
          paramString.invoke(Boolean.FALSE);
        }
        b.a(this.jGX, false);
        AppMethodBeat.o(223110);
        return;
        label391:
        str = paramC2CDownloadResult.transforMsg;
        p.j(str, "result.transforMsg");
        paramString = "";
      }
      paramString = b.e(this.jGX);
      if (paramString != null) {
        paramString.invoke(Boolean.TRUE);
      }
      b.a(this.jGX, true);
      AppMethodBeat.o(223110);
    }
    
    public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(223113);
      p.k(paramString, "filekey");
      AppMethodBeat.o(223113);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.b
 * JD-Core Version:    0.7.0.1
 */
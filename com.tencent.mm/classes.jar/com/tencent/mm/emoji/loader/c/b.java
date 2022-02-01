package com.tencent.mm.emoji.loader.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1;", "cdnMediaType", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "startRet", "startTime", "", "fetch", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class b
  implements d
{
  private final String TAG;
  private kotlin.g.a.b<? super Boolean, x> callback;
  private e gVV;
  private int gVY;
  private int gVZ;
  private final a gWa;
  private long startTime;
  
  public b()
  {
    AppMethodBeat.i(199903);
    this.TAG = "MicroMsg.EmojiCdnHttpsFetcher";
    this.gWa = new a(this);
    AppMethodBeat.o(199903);
  }
  
  private final void dP(boolean paramBoolean)
  {
    AppMethodBeat.i(199902);
    e locale = this.gVV;
    if (locale != null)
    {
      if (paramBoolean)
      {
        com.tencent.mm.plugin.emoji.d.CK(21L);
        com.tencent.mm.plugin.emoji.d.CK(2L);
        AppMethodBeat.o(199902);
        return;
      }
      com.tencent.mm.plugin.emoji.d.CK(22L);
      com.tencent.mm.plugin.emoji.d.CK(3L);
      switch (locale.gWn)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(199902);
        return;
        com.tencent.mm.plugin.emoji.d.a(locale.gWm.getMd5(), 4, 1, 1, locale.gWm.avy(), 1, locale.gWm.field_designerID);
        AppMethodBeat.o(199902);
        return;
        com.tencent.mm.plugin.emoji.d.a(locale.gWm.getMd5(), 2, 1, 1, locale.gWm.avy(), 1, locale.gWm.field_designerID);
        AppMethodBeat.o(199902);
        return;
        com.tencent.mm.plugin.emoji.d.a(locale.gWm.getMd5(), 4, 1, 1, locale.gWm.avy(), 1, locale.gWm.field_designerID);
      }
    }
    AppMethodBeat.o(199902);
  }
  
  public final void a(e parame, kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(199901);
    p.h(parame, "fetcherConfig");
    this.gVV = parame;
    this.callback = paramb;
    paramb = new o(parame.path).heq();
    if (paramb != null) {
      paramb.mkdirs();
    }
    int i;
    if (parame.gWn == 2)
    {
      i = 20403;
      this.gVY = i;
      this.startTime = Util.nowMilliSecond();
      paramb = new CdnLogic.C2CDownloadRequest();
      paramb.queueTimeoutSeconds = 60;
      paramb.transforTimeoutSeconds = 60;
      paramb.taskStartTime = this.startTime;
      paramb.fileType = this.gVY;
      paramb.fileKey = (d.a.auE() + parame.gWm.getMd5());
      paramb.url = parame.url;
      paramb.setSavePath(parame.path);
      this.gVZ = CdnLogic.startHttpsDownload(paramb, (CdnLogic.DownloadCallback)this.gWa);
      Log.i(this.TAG, "fetch: start " + parame.gWm.getMd5() + ' ' + this.gVZ);
      com.tencent.mm.plugin.emoji.d.CK(20L);
      parame = this.gVV;
      if (parame != null) {
        switch (parame.gWn)
        {
        }
      }
    }
    for (;;)
    {
      if (this.gVZ != 0)
      {
        new y(a.t(new Object[] { Integer.valueOf(this.gVZ), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY) })).bfK();
        parame = this.callback;
        if (parame != null) {
          parame.invoke(Boolean.FALSE);
        }
        dP(false);
      }
      AppMethodBeat.o(199901);
      return;
      i = 20401;
      break;
      com.tencent.mm.plugin.emoji.d.CK(1L);
      continue;
      com.tencent.mm.plugin.emoji.d.CK(6L);
      continue;
      com.tencent.mm.plugin.emoji.d.CK(10L);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "", "total", "tryshow", "", "plugin-emojisdk_release"})
  public static final class a
    implements CdnLogic.DownloadCallback
  {
    public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
    {
      AppMethodBeat.i(199899);
      p.h(paramString, "filekey");
      p.h(paramC2CDownloadResult, "result");
      Log.i(b.a(this.gWb), "onC2CDownloadCompleted: " + paramString + ", " + paramC2CDownloadResult.errorCode);
      String str = "";
      paramString = "";
      if (!Util.isNullOrNil(paramC2CDownloadResult.transforMsg))
      {
        paramString = paramC2CDownloadResult.transforMsg;
        p.g(paramString, "result.transforMsg");
        int i = n.a((CharSequence)paramString, "@,", 0, false, 6);
        if (i <= 0) {
          break label391;
        }
        paramString = paramC2CDownloadResult.transforMsg;
        p.g(paramString, "result.transforMsg");
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(199899);
          throw paramString;
        }
        paramString = paramString.substring(i + 2);
        p.g(paramString, "(this as java.lang.String).substring(startIndex)");
        str = paramC2CDownloadResult.transforMsg;
        p.g(str, "result.transforMsg");
        if (str == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(199899);
          throw paramString;
        }
        str = str.substring(0, i);
        p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        new y(a.t(new Object[] { Integer.valueOf(b.b(this.gWb)), Integer.valueOf(2), Long.valueOf(b.c(this.gWb)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(b.d(this.gWb)), Long.valueOf(paramC2CDownloadResult.fileSize), str, "", "", "", "", "", "", "", paramString })).bfK();
        if (paramC2CDownloadResult.errorCode == 0) {
          break;
        }
        paramString = b.e(this.gWb);
        if (paramString != null) {
          paramString.invoke(Boolean.FALSE);
        }
        b.a(this.gWb, false);
        AppMethodBeat.o(199899);
        return;
        label391:
        str = paramC2CDownloadResult.transforMsg;
        p.g(str, "result.transforMsg");
        paramString = "";
      }
      paramString = b.e(this.gWb);
      if (paramString != null) {
        paramString.invoke(Boolean.TRUE);
      }
      b.a(this.gWb, true);
      AppMethodBeat.o(199899);
    }
    
    public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(199900);
      p.h(paramString, "filekey");
      AppMethodBeat.o(199900);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.b
 * JD-Core Version:    0.7.0.1
 */
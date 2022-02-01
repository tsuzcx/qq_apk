package com.tencent.mm.emoji.loader.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1;", "cdnMediaType", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "startRet", "startTime", "", "fetch", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class b
  implements d
{
  private final String TAG;
  private e fPj;
  private d.g.a.b<? super Boolean, y> fPk;
  private int fPn;
  private int fPo;
  private final a fPp;
  private long startTime;
  
  public b()
  {
    AppMethodBeat.i(209822);
    this.TAG = "MicroMsg.EmojiCdnHttpsFetcher";
    this.fPp = new a(this);
    AppMethodBeat.o(209822);
  }
  
  private final void dd(boolean paramBoolean)
  {
    AppMethodBeat.i(209821);
    e locale = this.fPj;
    if (locale != null)
    {
      if (paramBoolean)
      {
        com.tencent.mm.plugin.emoji.c.sr(21L);
        com.tencent.mm.plugin.emoji.c.sr(2L);
        AppMethodBeat.o(209821);
        return;
      }
      com.tencent.mm.plugin.emoji.c.sr(22L);
      com.tencent.mm.plugin.emoji.c.sr(3L);
      switch (locale.fPD)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(209821);
        return;
        com.tencent.mm.plugin.emoji.c.a(locale.fPB.JC(), 4, 1, 1, locale.fPB.azp(), 1, locale.fPB.field_designerID);
        AppMethodBeat.o(209821);
        return;
        com.tencent.mm.plugin.emoji.c.a(locale.fPB.JC(), 2, 1, 1, locale.fPB.azp(), 1, locale.fPB.field_designerID);
        AppMethodBeat.o(209821);
        return;
        com.tencent.mm.plugin.emoji.c.a(locale.fPB.JC(), 4, 1, 1, locale.fPB.azp(), 1, locale.fPB.field_designerID);
      }
    }
    AppMethodBeat.o(209821);
  }
  
  public final void a(e parame, d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(209820);
    k.h(parame, "fetcherConfig");
    this.fPj = parame;
    this.fPk = paramb;
    new com.tencent.mm.vfs.e(parame.path).fxU().mkdirs();
    int i;
    if (parame.fPD == 2)
    {
      i = 20403;
      this.fPn = i;
      this.startTime = bs.eWj();
      paramb = new CdnLogic.C2CDownloadRequest();
      paramb.queueTimeoutSeconds = 60;
      paramb.transforTimeoutSeconds = 60;
      paramb.taskStartTime = this.startTime;
      paramb.fileType = this.fPn;
      paramb.fileKey = (d.a.aca() + parame.fPB.JC());
      paramb.url = parame.url;
      paramb.setSavePath(parame.path);
      this.fPo = CdnLogic.startHttpsDownload(paramb, (CdnLogic.DownloadCallback)this.fPp);
      ac.i(this.TAG, "fetch: start " + parame.fPB.JC() + ' ' + this.fPo);
      com.tencent.mm.plugin.emoji.c.sr(20L);
      parame = this.fPj;
      if (parame != null) {
        switch (parame.fPD)
        {
        }
      }
    }
    for (;;)
    {
      if (this.fPo != 0)
      {
        new h(a.u(new Object[] { Integer.valueOf(this.fPo), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(this.fPn) })).aHZ();
        parame = this.fPk;
        if (parame != null) {
          parame.ay(Boolean.FALSE);
        }
        dd(false);
      }
      AppMethodBeat.o(209820);
      return;
      i = 20401;
      break;
      com.tencent.mm.plugin.emoji.c.sr(1L);
      continue;
      com.tencent.mm.plugin.emoji.c.sr(6L);
      continue;
      com.tencent.mm.plugin.emoji.c.sr(10L);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "", "total", "tryshow", "", "plugin-emojisdk_release"})
  public static final class a
    implements CdnLogic.DownloadCallback
  {
    public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
    {
      AppMethodBeat.i(209818);
      k.h(paramString, "filekey");
      k.h(paramC2CDownloadResult, "result");
      ac.i(b.a(this.fPq), "onC2CDownloadCompleted: " + paramString + ", " + paramC2CDownloadResult.errorCode);
      String str = "";
      paramString = "";
      if (!bs.isNullOrNil(paramC2CDownloadResult.transforMsg))
      {
        paramString = paramC2CDownloadResult.transforMsg;
        k.g(paramString, "result.transforMsg");
        int i = n.a((CharSequence)paramString, "@,", 0, false, 6);
        if (i <= 0) {
          break label391;
        }
        paramString = paramC2CDownloadResult.transforMsg;
        k.g(paramString, "result.transforMsg");
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(209818);
          throw paramString;
        }
        paramString = paramString.substring(i + 2);
        k.g(paramString, "(this as java.lang.String).substring(startIndex)");
        str = paramC2CDownloadResult.transforMsg;
        k.g(str, "result.transforMsg");
        if (str == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(209818);
          throw paramString;
        }
        str = str.substring(0, i);
        k.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        new h(a.u(new Object[] { Integer.valueOf(b.b(this.fPq)), Integer.valueOf(2), Long.valueOf(b.c(this.fPq)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(b.d(this.fPq)), Long.valueOf(paramC2CDownloadResult.fileSize), str, "", "", "", "", "", "", "", paramString })).aHZ();
        if (paramC2CDownloadResult.errorCode == 0) {
          break;
        }
        paramString = b.e(this.fPq);
        if (paramString != null) {
          paramString.ay(Boolean.FALSE);
        }
        b.a(this.fPq, false);
        AppMethodBeat.o(209818);
        return;
        label391:
        str = paramC2CDownloadResult.transforMsg;
        k.g(str, "result.transforMsg");
        paramString = "";
      }
      paramString = b.e(this.fPq);
      if (paramString != null) {
        paramString.ay(Boolean.TRUE);
      }
      b.a(this.fPq, true);
      AppMethodBeat.o(209818);
    }
    
    public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(209819);
      k.h(paramString, "filekey");
      AppMethodBeat.o(209819);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.b
 * JD-Core Version:    0.7.0.1
 */
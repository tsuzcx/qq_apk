package com.tencent.mm.emoji.loader.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1;", "cdnMediaType", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "startRet", "startTime", "", "fetch", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class b
  implements d
{
  private final String TAG;
  private e giJ;
  private d.g.a.b<? super Boolean, z> giK;
  private int giN;
  private int giO;
  private final a giP;
  private long startTime;
  
  public b()
  {
    AppMethodBeat.i(218941);
    this.TAG = "MicroMsg.EmojiCdnHttpsFetcher";
    this.giP = new a(this);
    AppMethodBeat.o(218941);
  }
  
  private final void df(boolean paramBoolean)
  {
    AppMethodBeat.i(218940);
    e locale = this.giJ;
    if (locale != null)
    {
      if (paramBoolean)
      {
        com.tencent.mm.plugin.emoji.c.up(21L);
        com.tencent.mm.plugin.emoji.c.up(2L);
        AppMethodBeat.o(218940);
        return;
      }
      com.tencent.mm.plugin.emoji.c.up(22L);
      com.tencent.mm.plugin.emoji.c.up(3L);
      switch (locale.gjd)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(218940);
        return;
        com.tencent.mm.plugin.emoji.c.a(locale.gjb.Lb(), 4, 1, 1, locale.gjb.afw(), 1, locale.gjb.field_designerID);
        AppMethodBeat.o(218940);
        return;
        com.tencent.mm.plugin.emoji.c.a(locale.gjb.Lb(), 2, 1, 1, locale.gjb.afw(), 1, locale.gjb.field_designerID);
        AppMethodBeat.o(218940);
        return;
        com.tencent.mm.plugin.emoji.c.a(locale.gjb.Lb(), 4, 1, 1, locale.gjb.afw(), 1, locale.gjb.field_designerID);
      }
    }
    AppMethodBeat.o(218940);
  }
  
  public final void a(e parame, d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(218939);
    p.h(parame, "fetcherConfig");
    this.giJ = parame;
    this.giK = paramb;
    new com.tencent.mm.vfs.e(parame.path).fOJ().mkdirs();
    int i;
    if (parame.gjd == 2)
    {
      i = 20403;
      this.giN = i;
      this.startTime = bt.flT();
      paramb = new CdnLogic.C2CDownloadRequest();
      paramb.queueTimeoutSeconds = 60;
      paramb.transforTimeoutSeconds = 60;
      paramb.taskStartTime = this.startTime;
      paramb.fileType = this.giN;
      paramb.fileKey = (d.a.aeE() + parame.gjb.Lb());
      paramb.url = parame.url;
      paramb.setSavePath(parame.path);
      this.giO = CdnLogic.startHttpsDownload(paramb, (CdnLogic.DownloadCallback)this.giP);
      ad.i(this.TAG, "fetch: start " + parame.gjb.Lb() + ' ' + this.giO);
      com.tencent.mm.plugin.emoji.c.up(20L);
      parame = this.giJ;
      if (parame != null) {
        switch (parame.gjd)
        {
        }
      }
    }
    for (;;)
    {
      if (this.giO != 0)
      {
        new j(a.u(new Object[] { Integer.valueOf(this.giO), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(this.giN) })).aLk();
        parame = this.giK;
        if (parame != null) {
          parame.invoke(Boolean.FALSE);
        }
        df(false);
      }
      AppMethodBeat.o(218939);
      return;
      i = 20401;
      break;
      com.tencent.mm.plugin.emoji.c.up(1L);
      continue;
      com.tencent.mm.plugin.emoji.c.up(6L);
      continue;
      com.tencent.mm.plugin.emoji.c.up(10L);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "", "total", "tryshow", "", "plugin-emojisdk_release"})
  public static final class a
    implements CdnLogic.DownloadCallback
  {
    public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
    {
      AppMethodBeat.i(218937);
      p.h(paramString, "filekey");
      p.h(paramC2CDownloadResult, "result");
      ad.i(b.a(this.giQ), "onC2CDownloadCompleted: " + paramString + ", " + paramC2CDownloadResult.errorCode);
      String str = "";
      paramString = "";
      if (!bt.isNullOrNil(paramC2CDownloadResult.transforMsg))
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
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(218937);
          throw paramString;
        }
        paramString = paramString.substring(i + 2);
        p.g(paramString, "(this as java.lang.String).substring(startIndex)");
        str = paramC2CDownloadResult.transforMsg;
        p.g(str, "result.transforMsg");
        if (str == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(218937);
          throw paramString;
        }
        str = str.substring(0, i);
        p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        new j(a.u(new Object[] { Integer.valueOf(b.b(this.giQ)), Integer.valueOf(2), Long.valueOf(b.c(this.giQ)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(b.d(this.giQ)), Long.valueOf(paramC2CDownloadResult.fileSize), str, "", "", "", "", "", "", "", paramString })).aLk();
        if (paramC2CDownloadResult.errorCode == 0) {
          break;
        }
        paramString = b.e(this.giQ);
        if (paramString != null) {
          paramString.invoke(Boolean.FALSE);
        }
        b.a(this.giQ, false);
        AppMethodBeat.o(218937);
        return;
        label391:
        str = paramC2CDownloadResult.transforMsg;
        p.g(str, "result.transforMsg");
        paramString = "";
      }
      paramString = b.e(this.giQ);
      if (paramString != null) {
        paramString.invoke(Boolean.TRUE);
      }
      b.a(this.giQ, true);
      AppMethodBeat.o(218937);
    }
    
    public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(218938);
      p.h(paramString, "filekey");
      AppMethodBeat.o(218938);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.emoji.loader.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1;", "cdnMediaType", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "startRet", "startTime", "", "fetch", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class b
  implements d
{
  private final String TAG;
  private int fLB;
  private int fLC;
  private final a fLD;
  private e fLx;
  private d.g.a.b<? super Boolean, y> fLy;
  private long startTime;
  
  public b()
  {
    AppMethodBeat.i(193389);
    this.TAG = "MicroMsg.EmojiCdnHttpsFetcher";
    this.fLD = new a(this);
    AppMethodBeat.o(193389);
  }
  
  private final void de(boolean paramBoolean)
  {
    AppMethodBeat.i(193388);
    e locale = this.fLx;
    if (locale != null)
    {
      if (paramBoolean)
      {
        com.tencent.mm.plugin.emoji.c.oF(21L);
        com.tencent.mm.plugin.emoji.c.oF(2L);
        AppMethodBeat.o(193388);
        return;
      }
      com.tencent.mm.plugin.emoji.c.oF(22L);
      com.tencent.mm.plugin.emoji.c.oF(3L);
      switch (locale.fLR)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(193388);
        return;
        com.tencent.mm.plugin.emoji.c.a(locale.fLP.JS(), 4, 1, 1, locale.fLP.asy(), 1, locale.fLP.field_designerID);
        AppMethodBeat.o(193388);
        return;
        com.tencent.mm.plugin.emoji.c.a(locale.fLP.JS(), 2, 1, 1, locale.fLP.asy(), 1, locale.fLP.field_designerID);
        AppMethodBeat.o(193388);
        return;
        com.tencent.mm.plugin.emoji.c.a(locale.fLP.JS(), 4, 1, 1, locale.fLP.asy(), 1, locale.fLP.field_designerID);
      }
    }
    AppMethodBeat.o(193388);
  }
  
  public final void a(e parame, d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(193387);
    k.h(parame, "fetcherConfig");
    this.fLx = parame;
    this.fLy = paramb;
    new com.tencent.mm.vfs.e(parame.path).fhT().mkdirs();
    int i;
    if (parame.fLR == 2)
    {
      i = 20403;
      this.fLB = i;
      this.startTime = bt.eGO();
      paramb = new CdnLogic.C2CDownloadRequest();
      paramb.queueTimeoutSeconds = 60;
      paramb.transforTimeoutSeconds = 60;
      paramb.taskStartTime = this.startTime;
      paramb.fileType = this.fLB;
      paramb.fileKey = (d.a.abc() + parame.fLP.JS());
      paramb.url = parame.url;
      paramb.setSavePath(parame.path);
      this.fLC = CdnLogic.startHttpsDownload(paramb, (CdnLogic.DownloadCallback)this.fLD);
      ad.i(this.TAG, "fetch: start " + parame.fLP.JS() + ' ' + this.fLC);
      com.tencent.mm.plugin.emoji.c.oF(20L);
      parame = this.fLx;
      if (parame != null) {
        switch (parame.fLR)
        {
        }
      }
    }
    for (;;)
    {
      if (this.fLC != 0)
      {
        new h(a.s(new Object[] { Integer.valueOf(this.fLC), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.fLB) })).aBj();
        parame = this.fLy;
        if (parame != null) {
          parame.aA(Boolean.FALSE);
        }
        de(false);
      }
      AppMethodBeat.o(193387);
      return;
      i = 20401;
      break;
      com.tencent.mm.plugin.emoji.c.oF(1L);
      continue;
      com.tencent.mm.plugin.emoji.c.oF(6L);
      continue;
      com.tencent.mm.plugin.emoji.c.oF(10L);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "", "total", "tryshow", "", "plugin-emojisdk_release"})
  public static final class a
    implements CdnLogic.DownloadCallback
  {
    public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
    {
      AppMethodBeat.i(193385);
      k.h(paramString, "filekey");
      k.h(paramC2CDownloadResult, "result");
      ad.i(b.a(this.fLE), "onC2CDownloadCompleted: " + paramString + ", " + paramC2CDownloadResult.errorCode);
      String str = "";
      paramString = "";
      if (!bt.isNullOrNil(paramC2CDownloadResult.transforMsg))
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
          AppMethodBeat.o(193385);
          throw paramString;
        }
        paramString = paramString.substring(i + 2);
        k.g(paramString, "(this as java.lang.String).substring(startIndex)");
        str = paramC2CDownloadResult.transforMsg;
        k.g(str, "result.transforMsg");
        if (str == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(193385);
          throw paramString;
        }
        str = str.substring(0, i);
        k.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        new h(a.s(new Object[] { Integer.valueOf(b.b(this.fLE)), Integer.valueOf(2), Long.valueOf(b.c(this.fLE)), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(b.d(this.fLE)), Long.valueOf(paramC2CDownloadResult.fileSize), str, "", "", "", "", "", "", "", paramString })).aBj();
        if (paramC2CDownloadResult.errorCode == 0) {
          break;
        }
        paramString = b.e(this.fLE);
        if (paramString != null) {
          paramString.aA(Boolean.FALSE);
        }
        b.a(this.fLE, false);
        AppMethodBeat.o(193385);
        return;
        label391:
        str = paramC2CDownloadResult.transforMsg;
        k.g(str, "result.transforMsg");
        paramString = "";
      }
      paramString = b.e(this.fLE);
      if (paramString != null) {
        paramString.aA(Boolean.TRUE);
      }
      b.a(this.fLE, true);
      AppMethodBeat.o(193385);
    }
    
    public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(193386);
      k.h(paramString, "filekey");
      AppMethodBeat.o(193386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.b
 * JD-Core Version:    0.7.0.1
 */
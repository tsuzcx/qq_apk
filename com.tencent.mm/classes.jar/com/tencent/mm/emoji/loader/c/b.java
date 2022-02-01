package com.tencent.mm.emoji.loader.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.k;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1;", "cdnMediaType", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "startRet", "startTime", "", "fetch", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class b
  implements d
{
  private final String TAG;
  private e glb;
  private d.g.a.b<? super Boolean, z> glc;
  private int glf;
  private int glg;
  private final a glh;
  private long startTime;
  
  public b()
  {
    AppMethodBeat.i(188550);
    this.TAG = "MicroMsg.EmojiCdnHttpsFetcher";
    this.glh = new a(this);
    AppMethodBeat.o(188550);
  }
  
  private final void df(boolean paramBoolean)
  {
    AppMethodBeat.i(188549);
    e locale = this.glb;
    if (locale != null)
    {
      if (paramBoolean)
      {
        com.tencent.mm.plugin.emoji.c.uG(21L);
        com.tencent.mm.plugin.emoji.c.uG(2L);
        AppMethodBeat.o(188549);
        return;
      }
      com.tencent.mm.plugin.emoji.c.uG(22L);
      com.tencent.mm.plugin.emoji.c.uG(3L);
      switch (locale.glv)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(188549);
        return;
        com.tencent.mm.plugin.emoji.c.a(locale.glt.Lj(), 4, 1, 1, locale.glt.afK(), 1, locale.glt.field_designerID);
        AppMethodBeat.o(188549);
        return;
        com.tencent.mm.plugin.emoji.c.a(locale.glt.Lj(), 2, 1, 1, locale.glt.afK(), 1, locale.glt.field_designerID);
        AppMethodBeat.o(188549);
        return;
        com.tencent.mm.plugin.emoji.c.a(locale.glt.Lj(), 4, 1, 1, locale.glt.afK(), 1, locale.glt.field_designerID);
      }
    }
    AppMethodBeat.o(188549);
  }
  
  public final void a(e parame, d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(188548);
    p.h(parame, "fetcherConfig");
    this.glb = parame;
    this.glc = paramb;
    new k(parame.path).fTg().mkdirs();
    int i;
    if (parame.glv == 2)
    {
      i = 20403;
      this.glf = i;
      this.startTime = bu.fpO();
      paramb = new CdnLogic.C2CDownloadRequest();
      paramb.queueTimeoutSeconds = 60;
      paramb.transforTimeoutSeconds = 60;
      paramb.taskStartTime = this.startTime;
      paramb.fileType = this.glf;
      paramb.fileKey = (d.a.aeQ() + parame.glt.Lj());
      paramb.url = parame.url;
      paramb.setSavePath(parame.path);
      this.glg = CdnLogic.startHttpsDownload(paramb, (CdnLogic.DownloadCallback)this.glh);
      ae.i(this.TAG, "fetch: start " + parame.glt.Lj() + ' ' + this.glg);
      com.tencent.mm.plugin.emoji.c.uG(20L);
      parame = this.glb;
      if (parame != null) {
        switch (parame.glv)
        {
        }
      }
    }
    for (;;)
    {
      if (this.glg != 0)
      {
        new j(a.t(new Object[] { Integer.valueOf(this.glg), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(this.glf) })).aLH();
        parame = this.glc;
        if (parame != null) {
          parame.invoke(Boolean.FALSE);
        }
        df(false);
      }
      AppMethodBeat.o(188548);
      return;
      i = 20401;
      break;
      com.tencent.mm.plugin.emoji.c.uG(1L);
      continue;
      com.tencent.mm.plugin.emoji.c.uG(6L);
      continue;
      com.tencent.mm.plugin.emoji.c.uG(10L);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "", "total", "tryshow", "", "plugin-emojisdk_release"})
  public static final class a
    implements CdnLogic.DownloadCallback
  {
    public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
    {
      AppMethodBeat.i(188546);
      p.h(paramString, "filekey");
      p.h(paramC2CDownloadResult, "result");
      ae.i(b.a(this.gli), "onC2CDownloadCompleted: " + paramString + ", " + paramC2CDownloadResult.errorCode);
      String str = "";
      paramString = "";
      if (!bu.isNullOrNil(paramC2CDownloadResult.transforMsg))
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
          AppMethodBeat.o(188546);
          throw paramString;
        }
        paramString = paramString.substring(i + 2);
        p.g(paramString, "(this as java.lang.String).substring(startIndex)");
        str = paramC2CDownloadResult.transforMsg;
        p.g(str, "result.transforMsg");
        if (str == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(188546);
          throw paramString;
        }
        str = str.substring(0, i);
        p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        new j(a.t(new Object[] { Integer.valueOf(b.b(this.gli)), Integer.valueOf(2), Long.valueOf(b.c(this.gli)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(b.d(this.gli)), Long.valueOf(paramC2CDownloadResult.fileSize), str, "", "", "", "", "", "", "", paramString })).aLH();
        if (paramC2CDownloadResult.errorCode == 0) {
          break;
        }
        paramString = b.e(this.gli);
        if (paramString != null) {
          paramString.invoke(Boolean.FALSE);
        }
        b.a(this.gli, false);
        AppMethodBeat.o(188546);
        return;
        label391:
        str = paramC2CDownloadResult.transforMsg;
        p.g(str, "result.transforMsg");
        paramString = "";
      }
      paramString = b.e(this.gli);
      if (paramString != null) {
        paramString.invoke(Boolean.TRUE);
      }
      b.a(this.gli, true);
      AppMethodBeat.o(188546);
    }
    
    public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(188547);
      p.h(paramString, "filekey");
      AppMethodBeat.o(188547);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.b
 * JD-Core Version:    0.7.0.1
 */
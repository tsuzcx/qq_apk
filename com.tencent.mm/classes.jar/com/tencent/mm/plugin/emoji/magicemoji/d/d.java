package com.tencent.mm.plugin.emoji.magicemoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.w.a;
import com.tencent.mm.plugin.appbrand.service.w.b;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.plugin.emoji.magicemoji.bean.WxaPkgRecordForME;
import com.tencent.mm.plugin.emoji.magicemoji.bean.WxaPkgRecordForME.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/util/MagicEmojiRecordMgr;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadSuccessListener;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadErrorListener;", "appIdBundle", "Lcom/tencent/mm/plugin/emoji/magicemoji/util/ConstantsMagicEmoji$AppIdBundle;", "(Lcom/tencent/mm/plugin/emoji/magicemoji/util/ConstantsMagicEmoji$AppIdBundle;)V", "getAppIdBundle", "()Lcom/tencent/mm/plugin/emoji/magicemoji/util/ConstantsMagicEmoji$AppIdBundle;", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/WxaPkgRecordForME;", "", "Lcom/tencent/mm/plugin/emoji/magicemoji/util/RecordCallback;", "downloadCounts", "", "lastDownloadTime", "", "shouldForceUpdateFromCommand", "", "getShouldForceUpdateFromCommand", "()Z", "shouldForceUpdateFromCommand$delegate", "Lkotlin/Lazy;", "shouldWaitPkgFromEmoji", "configEnvSync", "version", "ensureNewestPackage", "findRecord", "getAndUpdateRecordFromCache", "getLocalRecord", "getPkgCachePath", "", "getRecordFromWxaPkg", "getServerVersionFromContact", "getVersionFromResUpdateMgr", "onError", "errCode", "errMsg", "onRecordReady", "record", "isLocal", "onSuccess", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "filePath", "shouldWaitUtilPkgReady", "tryDownloadRecord", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements w.a, w.b
{
  public static final d.a xKq;
  private kotlin.g.a.b<? super WxaPkgRecordForME, ah> callback;
  public final a.a xIh;
  private int xKr;
  private long xKs;
  private final j xKt;
  public boolean xKu;
  
  static
  {
    AppMethodBeat.i(270043);
    xKq = new d.a((byte)0);
    AppMethodBeat.o(270043);
  }
  
  public d(a.a parama)
  {
    AppMethodBeat.i(269974);
    this.xIh = parama;
    this.xKt = k.cm((kotlin.g.a.a)b.xKv);
    AppMethodBeat.o(269974);
  }
  
  private static void Kl(int paramInt)
  {
    AppMethodBeat.i(269999);
    ((com.tencent.mm.plugin.emoji.magicemoji.a.b)h.ax(com.tencent.mm.plugin.emoji.magicemoji.a.b.class)).Kl(paramInt);
    AppMethodBeat.o(269999);
  }
  
  private final void a(WxaPkgRecordForME paramWxaPkgRecordForME, boolean paramBoolean)
  {
    AppMethodBeat.i(270028);
    Object localObject = e.xKw;
    e.aoa(s.X("record ready: ", paramWxaPkgRecordForME));
    localObject = this.callback;
    if (localObject == null)
    {
      AppMethodBeat.o(270028);
      return;
    }
    ((kotlin.g.a.b)localObject).invoke(paramWxaPkgRecordForME);
    this.callback = null;
    if (paramBoolean) {}
    for (int i = 0;; i = 7)
    {
      paramWxaPkgRecordForME = e.xKw;
      e.AQ(i);
      AppMethodBeat.o(270028);
      return;
    }
  }
  
  private final boolean dzi()
  {
    AppMethodBeat.i(269983);
    boolean bool = ((Boolean)this.xKt.getValue()).booleanValue();
    AppMethodBeat.o(269983);
    return bool;
  }
  
  private static boolean dzj()
  {
    AppMethodBeat.i(269994);
    int i = ((c)h.ax(c.class)).a(c.a.yRO, 1);
    if (a.xJU)
    {
      AppMethodBeat.o(269994);
      return true;
    }
    if (i == 1)
    {
      AppMethodBeat.o(269994);
      return true;
    }
    AppMethodBeat.o(269994);
    return false;
  }
  
  public static String dzl()
  {
    AppMethodBeat.i(270005);
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    String str = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(37, 9);
    AppMethodBeat.o(270005);
    return str;
  }
  
  private final int dzm()
  {
    AppMethodBeat.i(270014);
    int i = ((x)h.ax(x.class)).VL(this.xIh.appId);
    AppMethodBeat.o(270014);
    return i;
  }
  
  private final WxaPkgRecordForME dzn()
  {
    AppMethodBeat.i(270021);
    Object localObject = dzk();
    if (localObject == null)
    {
      localObject = dzl();
      if (y.ZC((String)localObject))
      {
        b localb = b.xKn;
        int i = b.anW((String)localObject);
        Kl(i);
        Log.i("MicroMsg.MagicEmojiRecordMgr", s.X("stevecai: update magic emoji record from cache to version ", Integer.valueOf(i)));
      }
      localObject = dzk();
      AppMethodBeat.o(270021);
      return localObject;
    }
    AppMethodBeat.o(270021);
    return localObject;
  }
  
  public final void af(kotlin.g.a.b<? super WxaPkgRecordForME, ah> paramb)
  {
    int i = 0;
    AppMethodBeat.i(270060);
    s.u(paramb, "callback");
    if (this.callback != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MagicEmojiRecordMgr", s.X("stevecai: findRecord duplicate: ", Boolean.valueOf(bool)));
      if (this.callback == null) {
        break;
      }
      AppMethodBeat.o(270060);
      return;
    }
    this.callback = paramb;
    paramb = dzn();
    if (paramb == null)
    {
      dzo();
      paramb = e.xKw;
      e.AQ(1);
      AppMethodBeat.o(270060);
      return;
    }
    if (dzm() > paramb.version) {
      i = 1;
    }
    if ((dzi()) && (i != 0))
    {
      dzo();
      if (dzj())
      {
        AppMethodBeat.o(270060);
        return;
      }
    }
    if (this.xKu)
    {
      AppMethodBeat.o(270060);
      return;
    }
    a(paramb, true);
    AppMethodBeat.o(270060);
  }
  
  public final WxaPkgRecordForME dzk()
  {
    AppMethodBeat.i(270051);
    Object localObject = ((x)h.ax(x.class)).L(this.xIh.appId, this.xIh.euz, 0);
    if (localObject == null)
    {
      AppMethodBeat.o(270051);
      return null;
    }
    WxaPkgRecordForME.a locala = WxaPkgRecordForME.xIe;
    localObject = WxaPkgRecordForME.a.i((bh)localObject);
    AppMethodBeat.o(270051);
    return localObject;
  }
  
  public final void dzo()
  {
    AppMethodBeat.i(270053);
    if (Util.ticksToNow(this.xKs) > 60000L) {
      this.xKr = 0;
    }
    if (this.xKr >= 3)
    {
      e locale = e.xKw;
      e.AQ(8);
      AppMethodBeat.o(270053);
      return;
    }
    this.xKr += 1;
    this.xKs = Util.currentTicks();
    Log.i("MicroMsg.MagicEmojiRecordMgr", "stevecai: tryDownloadRecord: start downloading...");
    ((w)h.ax(w.class)).a(this.xIh.appId, this.xIh.euz, (w.b)this, (w.a)this);
    AppMethodBeat.o(270053);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(270067);
    Log.w("MicroMsg.MagicEmojiRecordMgr", "stevecai: onError: record download failed with " + paramInt + ' ' + paramString);
    this.xKu = false;
    if (!dzi())
    {
      paramString = dzn();
      if (paramString != null) {
        a(paramString, false);
      }
    }
    paramString = e.xKw;
    e.AQ(2);
    AppMethodBeat.o(270067);
  }
  
  public final void onSuccess(bh parambh, String paramString)
  {
    AppMethodBeat.i(270061);
    s.u(parambh, "record");
    s.u(paramString, "filePath");
    paramString = WxaPkgRecordForME.xIe;
    parambh = WxaPkgRecordForME.a.i(parambh);
    Log.i("MicroMsg.MagicEmojiRecordMgr", s.X("stevecai: record download success: ", parambh));
    this.xKr = 0;
    this.xKu = false;
    Kl(parambh.version);
    a(parambh, false);
    AppMethodBeat.o(270061);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final b xKv;
    
    static
    {
      AppMethodBeat.i(269984);
      xKv = new b();
      AppMethodBeat.o(269984);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.d.d
 * JD-Core Version:    0.7.0.1
 */
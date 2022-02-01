package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.w;
import com.tencent.mm.vfs.s;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final String TAG = "MicroMsg.BizProcessorCommand";
  private static final String plZ = "//biz";
  public static final a pma;
  private final f iBW;
  
  static
  {
    AppMethodBeat.i(6447);
    pma = new a((byte)0);
    plZ = "//biz";
    TAG = "MicroMsg.BizProcessorCommand";
    AppMethodBeat.o(6447);
  }
  
  public a()
  {
    AppMethodBeat.i(195080);
    this.iBW = kotlin.g.ah((kotlin.g.a.a)b.pmc);
    AppMethodBeat.o(195080);
  }
  
  private MultiProcessMMKV aTI()
  {
    AppMethodBeat.i(195079);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.iBW.getValue();
    AppMethodBeat.o(195079);
    return localMultiProcessMMKV;
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(6446);
    if ((paramArrayOfString != null) && (p.j(plZ, paramArrayOfString[0])))
    {
      if ((p.j("openrectimeline", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizTimeLineOpenStatus", Util.getInt(paramArrayOfString[2], -1));
        aTI().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("recFeed", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizTimeLineRecFeedStatus", Util.getInt(paramArrayOfString[2], -1));
        aTI().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("biztlbold", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizTimeLineTitleBold", Util.getInt(paramArrayOfString[2], -1));
        aTI().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("showbottomnav", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        MultiProcessMMKV.getMMKV("WebViewUIShowBottom").encode("WebViewUIShowBottomNav", Util.getInt(paramArrayOfString[2], -1));
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("checkWebviewId", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getMMKV("MicroMsg.BizVideoDetailUI");
        paramContext.encode("CheckWebviewId", Util.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("deleteolddata", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizTimeLineDeleteOldData", Util.getInt(paramArrayOfString[2], -1));
        aTI().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("addRecCard", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        p.g(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramContext = new String(paramContext, kotlin.n.d.UTF_8);
        paramArrayOfString = MultiProcessMMKV.getSingleMMKV("brandService");
        paramString = new StringBuilder("BizLatestRecommendCardInfo");
        p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        paramString = com.tencent.mm.kernel.a.ayV();
        if (paramArrayOfString == null) {
          p.hyc();
        }
        paramArrayOfString.encode(paramString, paramContext);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("addPayAlbum", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        p.g(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramString = new String(paramContext, kotlin.n.d.UTF_8);
        int i = n.a((CharSequence)paramString, "<sysmsg", 0, false, 6);
        if (i != -1)
        {
          paramContext = paramString.substring(i);
          p.g(paramContext, "(this as java.lang.String).substring(startIndex)");
          paramArrayOfString = XmlParser.parseXml(paramContext, "sysmsg", null);
          paramContext = paramArrayOfString;
          if (paramArrayOfString == null)
          {
            Log.e(plZ, "XmlParser values is null, msgContent %s", new Object[] { paramString });
            AppMethodBeat.o(6446);
            return true;
          }
        }
        else
        {
          paramContext = null;
        }
        paramArrayOfString = com.tencent.mm.plugin.biz.b.b.pfn;
        com.tencent.mm.plugin.biz.b.b.g(paramContext, paramString);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("paySuccess", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        p.g(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramContext = XmlParser.parseXml(new String(paramContext, kotlin.n.d.UTF_8), "sysmsg", null);
        paramArrayOfString = com.tencent.mm.plugin.brandservice.b.a.pmT;
        p.g(paramContext, "values");
        paramArrayOfString.ab(paramContext);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("profileCrash", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getSingleMMKV("ProfileCrashCheck");
        paramContext.encode("testCrash", Util.getInt(paramArrayOfString[2], 1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("updateAppInfo", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = paramArrayOfString[2];
        if (Util.isNullOrNil(paramContext))
        {
          AppMethodBeat.o(6446);
          return true;
        }
        com.tencent.f.h.RTc.b((Runnable)new c(paramContext), "GetAppInfoASyncThread");
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("resortbizmsgcheck", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizTimeLineReSortMsgCheck", Util.getInt(paramArrayOfString[2], 1));
        aTI().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("recycleCardCheck", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizTimeLineRecycleCardCheck", Util.getInt(paramArrayOfString[2], 1));
        aTI().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("updateCard", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizTimeLineUpdateCard", Util.getInt(paramArrayOfString[2], 1));
        aTI().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("showdigest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizTimeLineShowDigest", Util.getInt(paramArrayOfString[2], -1));
        aTI().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("oftenread", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        if (Util.getInt(paramArrayOfString[2], -1) == 0) {}
        for (bool = true;; bool = false)
        {
          com.tencent.mm.plugin.biz.b.c.kc(bool);
          AppMethodBeat.o(6446);
          return true;
        }
      }
      if ((p.j("videochannel", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        if (Util.getInt(paramArrayOfString[2], -1) == 0) {
          bool = true;
        }
        com.tencent.mm.plugin.biz.b.c.kd(bool);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("sl", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getMMKV("bizCommand");
        paramContext.encode("sameLayerOpen", Util.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("resortbizmsgtest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = w.NPK;
        w.ajS(Util.getInt(paramArrayOfString[2], -1));
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("adtest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizTimeLineAdTestMode", Util.getInt(paramArrayOfString[2], 0));
        aTI().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("adtestext", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getSingleMMKV("brandService");
        paramContext.encode("BizTimeLineAdTestExtInfo", paramArrayOfString[2]);
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("adtestaction", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).P("wxa06c02b5c00ff39b", "adTestExtAction", "data:" + paramArrayOfString[2]);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("ad", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizTimeLineAdOpen", Util.getInt(paramArrayOfString[2], 0));
        aTI().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("adprefetch", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizTimeLineAdPrefetcherOpen", Util.getInt(paramArrayOfString[2], 0));
        aTI().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("adInsertPos", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizAdInsertPos", Util.getInt(paramArrayOfString[2], 3));
        aTI().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.j("clearpkg", paramArrayOfString[1]))
      {
        paramContext = m.IAG;
        m.yK(true);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("adpreview", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getMMKV("WebCanvasStorage");
        paramContext.encode("BizTimeLineAdPreviewMode", Util.getInt(paramArrayOfString[2], 0));
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.j("test", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aTI().encode("BizTimeLineTestMode", Util.getInt(paramArrayOfString[2], 0));
        aTI().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.j("videofetchdebug", paramArrayOfString[1]))
      {
        com.tencent.mm.plugin.biz.b.c.ckx();
        Log.i(TAG, "mpManifestPath=" + com.tencent.mm.plugin.biz.b.c.ckv());
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.j("clearsubscribemsg", paramArrayOfString[1]))
      {
        com.tencent.mm.msgsubscription.d.c.jAF.biY();
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.j("clearimg", paramArrayOfString[1]))
      {
        com.tencent.f.h.RTc.aX((Runnable)d.pmf);
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.j("timel", paramArrayOfString[1]))
      {
        af.akc(Integer.parseInt(paramArrayOfString[2]));
        AppMethodBeat.o(6446);
        return true;
      }
    }
    AppMethodBeat.o(6446);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand$Companion;", "", "()V", "COMMAND_BIZ", "", "TAG", "getAdTestInfo", "init", "", "onSuccess", "plugin-brandservice_release"})
  public static final class a
  {
    public static void onSuccess()
    {
      AppMethodBeat.i(195076);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"Success! WeChat will kill self in 1 second...", 1).show();
      com.tencent.f.h.RTc.n((Runnable)a.pmb, 1000L);
      AppMethodBeat.o(195076);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a pmb;
      
      static
      {
        AppMethodBeat.i(195075);
        pmb = new a();
        AppMethodBeat.o(195075);
      }
      
      public final void run()
      {
        AppMethodBeat.i(195074);
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.a.class)).bCm();
        AppMethodBeat.o(195074);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final b pmc;
    
    static
    {
      AppMethodBeat.i(195078);
      pmc = new b();
      AppMethodBeat.o(195078);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(6443);
      if (com.tencent.mm.pluginsdk.model.app.h.cX(this.pmd, true) != null) {
        MMHandlerThread.postToMainThread((Runnable)1.pme);
      }
      AppMethodBeat.o(6443);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d pmf;
    
    static
    {
      AppMethodBeat.i(6445);
      pmf = new d();
      AppMethodBeat.o(6445);
    }
    
    public final void run()
    {
      AppMethodBeat.i(6444);
      s.deleteDir(com.tencent.mm.plugin.image.d.dZF());
      AppMethodBeat.o(6444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.protocal.protobuf.err;
import com.tencent.mm.protocal.protobuf.eru;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.w;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final String TAG = "MicroMsg.BizProcessorCommand";
  private static final String sor = "//biz";
  public static final a sos;
  private final f lrB;
  
  static
  {
    AppMethodBeat.i(6447);
    sos = new a((byte)0);
    sor = "//biz";
    TAG = "MicroMsg.BizProcessorCommand";
    AppMethodBeat.o(6447);
  }
  
  public a()
  {
    AppMethodBeat.i(257314);
    this.lrB = kotlin.g.ar((kotlin.g.a.a)b.sou);
    AppMethodBeat.o(257314);
  }
  
  private MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(257310);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.lrB.getValue();
    AppMethodBeat.o(257310);
    return localMultiProcessMMKV;
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(6446);
    if ((paramArrayOfString != null) && (p.h(sor, paramArrayOfString[0])))
    {
      if ((p.h("openrectimeline", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineOpenStatus", Util.getInt(paramArrayOfString[2], -1));
        bcJ().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("recFeed", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineRecFeedStatus", Util.getInt(paramArrayOfString[2], -1));
        bcJ().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("finderLive", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineFinderLiveStatus", Util.getInt(paramArrayOfString[2], -1));
        bcJ().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("biztlbold", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineTitleBold", Util.getInt(paramArrayOfString[2], -1));
        bcJ().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("showbottomnav", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        MultiProcessMMKV.getMMKV("WebViewUIShowBottom").encode("WebViewUIShowBottomNav", Util.getInt(paramArrayOfString[2], -1));
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("adautotest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineAdOpen", Util.getInt(paramArrayOfString[2], -1));
        bcJ().encode("BizTimeLineAdTestMode", Util.getInt(paramArrayOfString[3], -1));
        bcJ().encode("BizAdInsertPos", Util.getInt(paramArrayOfString[4], -1));
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("deleteolddata", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineDeleteOldData", Util.getInt(paramArrayOfString[2], -1));
        bcJ().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("addRecCard", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        p.j(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramContext = new String(paramContext, kotlin.n.d.UTF_8);
        paramArrayOfString = MultiProcessMMKV.getSingleMMKV("brandService");
        paramString = new StringBuilder("BizLatestRecommendCardInfo");
        p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
        paramString = com.tencent.mm.kernel.b.aGq();
        if (paramArrayOfString == null) {
          p.iCn();
        }
        paramArrayOfString.encode(paramString, paramContext);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("addPayAlbum", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        p.j(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramString = new String(paramContext, kotlin.n.d.UTF_8);
        int i = n.a((CharSequence)paramString, "<sysmsg", 0, false, 6);
        if (i != -1)
        {
          paramContext = paramString.substring(i);
          p.j(paramContext, "(this as java.lang.String).substring(startIndex)");
          paramArrayOfString = XmlParser.parseXml(paramContext, "sysmsg", null);
          paramContext = paramArrayOfString;
          if (paramArrayOfString == null)
          {
            Log.e(sor, "XmlParser values is null, msgContent %s", new Object[] { paramString });
            AppMethodBeat.o(6446);
            return true;
          }
        }
        else
        {
          paramContext = null;
        }
        paramArrayOfString = com.tencent.mm.plugin.biz.b.b.shr;
        com.tencent.mm.plugin.biz.b.b.g(paramContext, paramString);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("paySuccess", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        p.j(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramContext = XmlParser.parseXml(new String(paramContext, kotlin.n.d.UTF_8), "sysmsg", null);
        paramArrayOfString = com.tencent.mm.plugin.brandservice.b.b.svR;
        p.j(paramContext, "values");
        paramArrayOfString.U(paramContext);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("profileCrash", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getSingleMMKV("ProfileCrashCheck");
        paramContext.encode("testCrash", Util.getInt(paramArrayOfString[2], 1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("updateAppInfo", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = paramArrayOfString[2];
        if (Util.isNullOrNil(paramContext))
        {
          AppMethodBeat.o(6446);
          return true;
        }
        com.tencent.e.h.ZvG.d((Runnable)new c(paramContext), "GetAppInfoASyncThread");
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("resortbizmsgcheck", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineReSortMsgCheck", Util.getInt(paramArrayOfString[2], 1));
        bcJ().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("recycleCardCheck", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineRecycleCardCheck", Util.getInt(paramArrayOfString[2], 1));
        bcJ().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("updateCard", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineUpdateCard", Util.getInt(paramArrayOfString[2], 1));
        bcJ().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("showdigest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineShowDigest", Util.getInt(paramArrayOfString[2], -1));
        bcJ().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("oftenread", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        if (Util.getInt(paramArrayOfString[2], -1) == 0) {}
        for (bool = true;; bool = false)
        {
          com.tencent.mm.plugin.biz.b.c.ln(bool);
          AppMethodBeat.o(6446);
          return true;
        }
      }
      if ((p.h("videochannel", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        if (Util.getInt(paramArrayOfString[2], -1) == 0) {
          bool = true;
        }
        com.tencent.mm.plugin.biz.b.c.lo(bool);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("sl", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getMMKV("bizCommand");
        paramContext.encode("sameLayerOpen", Util.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("resortbizmsgtest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = w.VdC;
        w.asn(Util.getInt(paramArrayOfString[2], -1));
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("adtest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineAdTestMode", Util.getInt(paramArrayOfString[2], 0));
        bcJ().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("adtestext", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getSingleMMKV("brandService");
        paramContext.encode("BizTimeLineAdTestExtInfo", paramArrayOfString[2]);
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("adtestaction", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).n("wxa06c02b5c00ff39b", null, "adTestExtAction", "data:" + paramArrayOfString[2]);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("ad", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineAdOpen", Util.getInt(paramArrayOfString[2], 0));
        bcJ().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("adprefetch", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineAdPrefetcherOpen", Util.getInt(paramArrayOfString[2], 0));
        bcJ().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("adInsertPos", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizAdInsertPos", Util.getInt(paramArrayOfString[2], 3));
        bcJ().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.h("clearpkg", paramArrayOfString[1]))
      {
        paramContext = m.PuL;
        m.CF(true);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("adpreview", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getMMKV("WebCanvasStorage");
        paramContext.encode("BizTimeLineAdPkgPreviewMode", Util.getInt(paramArrayOfString[2], 0));
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.h("test", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bcJ().encode("BizTimeLineTestMode", Util.getInt(paramArrayOfString[2], 0));
        bcJ().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.h("checkfinderreddot", paramArrayOfString[1]))
      {
        a.cyz();
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.h("addfinderreddot", paramArrayOfString[1]))
      {
        a.cyy();
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.h("videofetchdebug", paramArrayOfString[1]))
      {
        com.tencent.mm.plugin.biz.b.c.cxP();
        Log.i(TAG, "mpManifestPath=" + com.tencent.mm.plugin.biz.b.c.cxN());
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.h("clearsubscribemsg", paramArrayOfString[1]))
      {
        com.tencent.mm.msgsubscription.d.c.mqn.bsx();
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.h("clearimg", paramArrayOfString[1]))
      {
        com.tencent.e.h.ZvG.be((Runnable)d.sox);
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.h("timel", paramArrayOfString[1]))
      {
        af.asz(Integer.parseInt(paramArrayOfString[2]));
        AppMethodBeat.o(6446);
        return true;
      }
    }
    AppMethodBeat.o(6446);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand$Companion;", "", "()V", "COMMAND_BIZ", "", "TAG", "addFinderRedDot", "", "checkFinderRedDot", "getAdTestInfo", "init", "onSuccess", "plugin-brandservice_release"})
  public static final class a
  {
    public static void cyy()
    {
      AppMethodBeat.i(265035);
      Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g.cBq().UtH;
      if (localObject1 != null)
      {
        localObject1 = (eru)((LinkedList)localObject1).getFirst();
        if (localObject1 != null) {}
      }
      else
      {
        AppMethodBeat.o(265035);
        return;
      }
      String str = "export/xxx" + System.currentTimeMillis();
      Object localObject2 = com.tencent.mm.pluginsdk.model.b.QTJ;
      localObject2 = new oc();
      ((oc)localObject2).RKL = ((eru)localObject1).RKL;
      ((oc)localObject2).RVp = str;
      ((oc)localObject2).tmL = 20;
      com.tencent.mm.pluginsdk.model.b.a((oc)localObject2);
      localObject2 = com.tencent.mm.pluginsdk.model.b.QTJ;
      com.tencent.mm.pluginsdk.model.b.nk(((eru)localObject1).RKL, str);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"Success!", 1).show();
      ab.hxj();
      AppMethodBeat.o(265035);
    }
    
    public static void cyz()
    {
      AppMethodBeat.i(265038);
      Object localObject = com.tencent.mm.pluginsdk.model.b.QTJ;
      com.tencent.mm.pluginsdk.model.b.hgh();
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g.cBq();
      if (localObject != null)
      {
        localObject = ((err)localObject).UtH;
        if (localObject != null)
        {
          com.tencent.mm.pluginsdk.model.b localb = com.tencent.mm.pluginsdk.model.b.QTJ;
          com.tencent.mm.pluginsdk.model.b.cd((LinkedList)localObject);
        }
      }
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"Success!", 1).show();
      AppMethodBeat.o(265038);
    }
    
    public static void onSuccess()
    {
      AppMethodBeat.i(265032);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"Success! WeChat will kill self in 1 second...", 1).show();
      com.tencent.e.h.ZvG.n((Runnable)a.sot, 1000L);
      AppMethodBeat.o(265032);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a sot;
      
      static
      {
        AppMethodBeat.i(266446);
        sot = new a();
        AppMethodBeat.o(266446);
      }
      
      public final void run()
      {
        AppMethodBeat.i(266444);
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).RP();
        AppMethodBeat.o(266444);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final b sou;
    
    static
    {
      AppMethodBeat.i(264056);
      sou = new b();
      AppMethodBeat.o(264056);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(6443);
      if (com.tencent.mm.pluginsdk.model.app.h.dl(this.sov, true) != null) {
        MMHandlerThread.postToMainThread((Runnable)1.sow);
      }
      AppMethodBeat.o(6443);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d sox;
    
    static
    {
      AppMethodBeat.i(6445);
      sox = new d();
      AppMethodBeat.o(6445);
    }
    
    public final void run()
    {
      AppMethodBeat.i(6444);
      u.deleteDir(com.tencent.mm.plugin.image.d.eIC());
      AppMethodBeat.o(6444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a
 * JD-Core Version:    0.7.0.1
 */
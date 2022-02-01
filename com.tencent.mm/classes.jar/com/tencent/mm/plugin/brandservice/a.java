package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g;
import com.tencent.mm.protocal.protobuf.fmz;
import com.tencent.mm.protocal.protobuf.fnc;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ac.b;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.w;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final String TAG;
  public static final a vAp;
  private static final String vAq;
  private static boolean vAr;
  private final j exj;
  
  static
  {
    AppMethodBeat.i(6447);
    vAp = new a((byte)0);
    vAq = "//biz";
    TAG = "MicroMsg.BizProcessorCommand";
    vAr = true;
    AppMethodBeat.o(6447);
  }
  
  public a()
  {
    AppMethodBeat.i(301499);
    this.exj = kotlin.k.cm((kotlin.g.a.a)b.vAs);
    AppMethodBeat.o(301499);
  }
  
  private static final void aix(String paramString)
  {
    AppMethodBeat.i(301514);
    s.u(paramString, "$appid");
    if (com.tencent.mm.pluginsdk.model.app.h.dV(paramString, true) != null) {
      MMHandlerThread.postToMainThread(a..ExternalSyntheticLambda1.INSTANCE);
    }
    AppMethodBeat.o(301514);
  }
  
  private MultiProcessMMKV atj()
  {
    AppMethodBeat.i(301503);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.exj.getValue();
    AppMethodBeat.o(301503);
    return localMultiProcessMMKV;
  }
  
  private static final void dbo()
  {
    AppMethodBeat.i(301507);
    com.tencent.mm.ui.base.k.cZ(MMApplicationContext.getContext(), "Get appInfo success!");
    AppMethodBeat.o(301507);
  }
  
  private static final void dbp()
  {
    AppMethodBeat.i(301517);
    y.ew(com.tencent.mm.plugin.image.d.fQD(), true);
    AppMethodBeat.o(301517);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(6446);
    if ((paramArrayOfString != null) && (s.p(vAq, paramArrayOfString[0])))
    {
      if ((s.p("openrectimeline", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineOpenStatus", Util.getInt(paramArrayOfString[2], -1));
        atj().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("recFeed", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineRecFeedStatus", Util.getInt(paramArrayOfString[2], -1));
        atj().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("finderLive", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineFinderLiveStatus", Util.getInt(paramArrayOfString[2], -1));
        atj().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("biztlbold", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineTitleBold", Util.getInt(paramArrayOfString[2], -1));
        atj().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("showbottomnav", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        MultiProcessMMKV.getMMKV("WebViewUIShowBottom").encode("WebViewUIShowBottomNav", Util.getInt(paramArrayOfString[2], -1));
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("adautotest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineAdOpen", Util.getInt(paramArrayOfString[2], -1));
        atj().encode("BizTimeLineAdTestMode", Util.getInt(paramArrayOfString[3], -1));
        atj().encode("BizAdInsertPos", Util.getInt(paramArrayOfString[4], -1));
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("autoreboot", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        if (Util.getInt(paramArrayOfString[2], -1) == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          vAr = bool1;
          AppMethodBeat.o(6446);
          return true;
        }
      }
      if ((s.p("deleteolddata", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineDeleteOldData", Util.getInt(paramArrayOfString[2], -1));
        atj().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("addRecCard", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        s.s(paramContext, "decode(args[2], Base64.NO_WRAP)");
        ad.bvD(new String(paramContext, kotlin.n.d.UTF_8));
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("addPayAlbum", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        s.s(paramContext, "decode(args[2], Base64.NO_WRAP)");
        paramString = new String(paramContext, kotlin.n.d.UTF_8);
        int i = n.a((CharSequence)paramString, "<sysmsg", 0, false, 6);
        if (i != -1)
        {
          paramContext = paramString.substring(i);
          s.s(paramContext, "(this as java.lang.String).substring(startIndex)");
          paramArrayOfString = XmlParser.parseXml(paramContext, "sysmsg", null);
          paramContext = paramArrayOfString;
          if (paramArrayOfString == null)
          {
            Log.e(vAq, "XmlParser values is null, msgContent %s", new Object[] { paramString });
            AppMethodBeat.o(6446);
            return true;
          }
        }
        else
        {
          paramContext = null;
        }
        paramArrayOfString = com.tencent.mm.plugin.biz.b.b.vto;
        com.tencent.mm.plugin.biz.b.b.i(paramContext, paramString);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("paySuccess", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        s.s(paramContext, "decode(args[2], Base64.NO_WRAP)");
        paramContext = XmlParser.parseXml(new String(paramContext, kotlin.n.d.UTF_8), "sysmsg", null);
        paramArrayOfString = com.tencent.mm.plugin.brandservice.model.b.vBC;
        s.s(paramContext, "values");
        paramArrayOfString.ab(paramContext);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("profileCrash", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getSingleMMKV("ProfileCrashCheck");
        paramContext.encode("testCrash", Util.getInt(paramArrayOfString[2], 1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("updateAppInfo", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = paramArrayOfString[2];
        if (Util.isNullOrNil(paramContext))
        {
          AppMethodBeat.o(6446);
          return true;
        }
        com.tencent.threadpool.h.ahAA.g(new a..ExternalSyntheticLambda0(paramContext), "GetAppInfoASyncThread");
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("resortbizmsgcheck", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineReSortMsgCheck", Util.getInt(paramArrayOfString[2], 1));
        atj().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("recycleCardCheck", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineRecycleCardCheck", Util.getInt(paramArrayOfString[2], 1));
        atj().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("updateCard", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineUpdateCard", Util.getInt(paramArrayOfString[2], 1));
        atj().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("showdigest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineShowDigest", Util.getInt(paramArrayOfString[2], -1));
        atj().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("oftenread", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        if (Util.getInt(paramArrayOfString[2], -1) == 0) {
          bool1 = true;
        }
        com.tencent.mm.plugin.biz.b.c.mF(bool1);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("videochannel", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bool1 = bool2;
        if (Util.getInt(paramArrayOfString[2], -1) == 0) {
          bool1 = true;
        }
        com.tencent.mm.plugin.biz.b.c.mG(bool1);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("sl", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getMMKV("bizCommand");
        paramContext.encode("sameLayerOpen", Util.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("resortbizmsgtest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = w.acEV;
        w.ayy(Util.getInt(paramArrayOfString[2], -1));
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("adtest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineAdTestMode", Util.getInt(paramArrayOfString[2], 0));
        atj().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("forbidDeleteCanvasFromJS", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = atj();
        bool1 = bool3;
        if (Util.getInt(paramArrayOfString[2], 0) == 1) {
          bool1 = true;
        }
        paramContext.encode("forbidDeleteCanvasFromJS", bool1);
        atj().apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("adtestext", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getSingleMMKV("brandService");
        paramContext.encode("BizTimeLineAdTestExtInfo", paramArrayOfString[2]);
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("adtestaction", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).m("wxa06c02b5c00ff39b", null, "adTestExtAction", s.X("data:", paramArrayOfString[2]));
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("ad", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineAdOpen", Util.getInt(paramArrayOfString[2], 0));
        atj().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("adprefetch", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineAdPrefetcherOpen", Util.getInt(paramArrayOfString[2], 0));
        atj().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("adInsertPos", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizAdInsertPos", Util.getInt(paramArrayOfString[2], 3));
        atj().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if (s.p("clearad", paramArrayOfString[1]))
      {
        paramContext = r.acDM;
        r.iXi().encode(r.bvh("biz_ad_card_data"), "");
        paramContext = af.bHl();
        paramArrayOfString = String.format("DELETE FROM %s WHERE type = %d", new Object[] { "BizTimeLineInfo", Integer.valueOf(637534257) });
        Log.d("MicroMsg.BizTimeLineInfoStorage", "deleteExposedAdMsgByType ret:%b, sql=%s", new Object[] { Boolean.valueOf(paramContext.omV.execSQL("BizTimeLineInfo", paramArrayOfString)), paramArrayOfString });
        paramArrayOfString = new ac.a();
        paramArrayOfString.acFX = ac.b.acGa;
        paramContext.a(paramArrayOfString);
        r.acDS = null;
        r.acEi = true;
        AppMethodBeat.o(6446);
        return true;
      }
      if (s.p("setAdInsertType", paramArrayOfString[1]))
      {
        paramContext = r.acDM;
        r.setAdInsertType(Util.getInt(paramArrayOfString[2], 0));
        AppMethodBeat.o(6446);
        return true;
      }
      if (s.p("clearadexposetime", paramArrayOfString[1]))
      {
        MultiProcessMMKV.getSingleMMKV("biz_timeline_ad").encode("BizLastExposeAdTime", 0L);
        AppMethodBeat.o(6446);
        return true;
      }
      if (s.p("clearadexposecount", paramArrayOfString[1]))
      {
        af.bHm().bSr();
        AppMethodBeat.o(6446);
        return true;
      }
      if (s.p("clearpkg", paramArrayOfString[1]))
      {
        paramContext = com.tencent.mm.plugin.webcanvas.k.WkZ;
        com.tencent.mm.plugin.webcanvas.k.Ik(true);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("adpreview", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = MultiProcessMMKV.getMMKV("WebCanvasStorage");
        paramContext.encode("BizTimeLineAdPkgPreviewMode", Util.getInt(paramArrayOfString[2], 0));
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("test", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        atj().encode("BizTimeLineTestMode", Util.getInt(paramArrayOfString[2], 0));
        atj().apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if (s.p("checkfinderreddot", paramArrayOfString[1]))
      {
        a.dbt();
        AppMethodBeat.o(6446);
        return true;
      }
      if (s.p("addfinderreddot", paramArrayOfString[1]))
      {
        a.dbs();
        AppMethodBeat.o(6446);
        return true;
      }
      if (s.p("videofetchdebug", paramArrayOfString[1]))
      {
        com.tencent.mm.plugin.biz.b.c.daG();
        Log.i(TAG, s.X("mpManifestPath=", com.tencent.mm.plugin.biz.b.c.daE()));
        AppMethodBeat.o(6446);
        return true;
      }
      if (s.p("clearsubscribemsg", paramArrayOfString[1]))
      {
        com.tencent.mm.msgsubscription.d.c.pjX.bQd();
        AppMethodBeat.o(6446);
        return true;
      }
      if (s.p("clearimg", paramArrayOfString[1]))
      {
        com.tencent.threadpool.h.ahAA.bm(a..ExternalSyntheticLambda2.INSTANCE);
        AppMethodBeat.o(6446);
        return true;
      }
      if (s.p("timel", paramArrayOfString[1]))
      {
        com.tencent.mm.storage.ah.ayO(Integer.parseInt(paramArrayOfString[2]));
        AppMethodBeat.o(6446);
        return true;
      }
      if ((s.p("gamejs", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        if (s.p(paramArrayOfString[2], "null")) {
          atj().remove("GameCenterJsPath").apply();
        }
        for (;;)
        {
          AppMethodBeat.o(6446);
          return true;
          atj().encode("GameCenterJsPath", paramArrayOfString[2]);
          atj().apply();
        }
      }
    }
    AppMethodBeat.o(6446);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand$Companion;", "", "()V", "COMMAND_BIZ", "", "TAG", "autoReboot", "", "addFinderRedDot", "", "checkFinderRedDot", "getAdTestInfo", "getDebugGameCenterJsPath", "init", "onSuccess", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void dbs()
    {
      AppMethodBeat.i(301466);
      Object localObject1 = g.deD().abNc;
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = (fnc)((LinkedList)localObject1).getFirst())
      {
        AppMethodBeat.o(301466);
        return;
      }
      String str = s.X("export/xxx", Long.valueOf(System.currentTimeMillis()));
      Object localObject2 = com.tencent.mm.pluginsdk.model.c.XPt;
      localObject2 = new pi();
      ((pi)localObject2).YIf = ((fnc)localObject1).YIf;
      ((pi)localObject2).YSM = str;
      ((pi)localObject2).wrl = 20;
      kotlin.ah localah = kotlin.ah.aiuX;
      com.tencent.mm.pluginsdk.model.c.a((pi)localObject2);
      localObject2 = com.tencent.mm.pluginsdk.model.c.XPt;
      com.tencent.mm.pluginsdk.model.c.pf(((fnc)localObject1).YIf, str);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"Success!", 1).show();
      ad.iYO();
      AppMethodBeat.o(301466);
    }
    
    public static void dbt()
    {
      AppMethodBeat.i(301472);
      Object localObject = com.tencent.mm.pluginsdk.model.c.XPt;
      com.tencent.mm.pluginsdk.model.c.iHf();
      localObject = g.deD();
      if (localObject != null)
      {
        localObject = ((fmz)localObject).abNc;
        if (localObject != null)
        {
          com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
          com.tencent.mm.pluginsdk.model.c.cp((LinkedList)localObject);
        }
      }
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"Success!", 1).show();
      AppMethodBeat.o(301472);
    }
    
    private static final void dbu()
    {
      AppMethodBeat.i(301475);
      ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).ase();
      AppMethodBeat.o(301475);
    }
    
    public static void onSuccess()
    {
      AppMethodBeat.i(301461);
      if (!a.dbr())
      {
        Log.w(a.access$getTAG$cp(), "should not autoReboot now.");
        AppMethodBeat.o(301461);
        return;
      }
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"Success! WeChat will kill self in 1 second...", 1).show();
      com.tencent.threadpool.h.ahAA.o(a.a..ExternalSyntheticLambda0.INSTANCE, 1000L);
      AppMethodBeat.o(301461);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final b vAs;
    
    static
    {
      AppMethodBeat.i(301462);
      vAs = new b();
      AppMethodBeat.o(301462);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a
 * JD-Core Version:    0.7.0.1
 */
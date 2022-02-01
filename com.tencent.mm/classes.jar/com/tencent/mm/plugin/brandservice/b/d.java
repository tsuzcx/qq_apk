package com.tencent.mm.plugin.brandservice.b;

import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.f.a.as;
import com.tencent.mm.plugin.brandservice.a.c.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.y;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.y.a;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.protocal.protobuf.fba;
import com.tencent.mm.protocal.protobuf.fbb;
import com.tencent.mm.protocal.protobuf.fbe;
import com.tencent.mm.protocal.protobuf.fbf;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/model/BizVideoChannelStrategy;", "", "()V", "BIZ_PROFILE_VIDEO_CHANNEL_ENTRY_OPEN", "", "KEY_BIZ_VIDEO_CHANNEL_SHOW_DEFAULT_ICON", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_LAST_TIME", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_LAST_TIME", "TAG", "TOP_BAR_INFO", "TOP_BAR_VIDEO_CHANNEL_SWITCH_OPTION", "VIDEO_CHANNEL_FEEDS_DATA", "bizVideoChannelCanvasId", "isBizProfileEntryOpen", "", "Ljava/lang/Boolean;", "isTimelineTopBarEntryOpen", "localOpen", "", "getLocalOpen", "()I", "localOpen$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "showCanvas", "getShowCanvas", "()Z", "showCanvas$delegate", "showingLogoUrl", "getShowingLogoUrl", "()Ljava/lang/String;", "setShowingLogoUrl", "(Ljava/lang/String;)V", "timelineTopBarInfo", "Lcom/tencent/mm/protocal/protobuf/VideoChannelTopBarInfo;", "clearTopBarInfo", "", "fetchBizVideoChannelStrategy", "fromScene", "talker", "url", "getLogoUrl", "force", "getNotifyAndChannelFeeds", "updateCallback", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "getProtoData", "getSyncBuffer", "getTopBarInfo", "getTopBarPath", "init", "isPreloadOpen", "scene", "isShowDefaultIcon", "isShowingDefaultIcon", "isShowingIconCached", "isTimeLineTopBarEntryOpen", "isTopBarInfoChanged", "topBarInfo", "loadChannelIcon", "iconIV", "Landroid/widget/ImageView;", "loadChannelSmallIcon", "onLogoClick", "onTopBarVideoChannelEntryChanged", "switchOption", "preloadChannelStrategy", "preloadIcon", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "release", "report", "key", "", "saveTopBarInfo", "top_bar_info", "shouldChaneDefaultLogoAfterClick", "showRightTopGreedDot", "update", "updateBizProfileEntryStatus", "isEntryOpen", "needSave", "updateInterval", "updateTimelineTopBarEntryStatus", "updateUnReadView", "holder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView$HotListViewHolder;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;", "context", "Landroid/content/Context;", "VideoChannelSwitchOption", "VideoChannelTopBarControlBit", "plugin-brandservice_release"})
public final class d
{
  private static final f lrB;
  public static String svW;
  private static Boolean svX;
  private static fbe svY;
  private static Boolean svZ;
  private static final f swa;
  private static final f swb;
  public static final d swc;
  
  static
  {
    AppMethodBeat.i(175467);
    swc = new d();
    svW = "";
    lrB = g.ar((kotlin.g.a.a)d.swh);
    swa = g.ar((kotlin.g.a.a)c.swg);
    swb = g.ar((kotlin.g.a.a)f.swk);
    AppMethodBeat.o(175467);
  }
  
  private static void GB(int paramInt)
  {
    AppMethodBeat.i(175473);
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      svX = Boolean.valueOf(bool);
      AppMethodBeat.o(175473);
      return;
    }
  }
  
  public static final void I(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(175474);
    svZ = Boolean.valueOf(paramBoolean1);
    if (paramBoolean2) {
      bcJ().putInt("biz_profile_video_channel_entry_open", 1);
    }
    Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo updateBizProfileEntryStatus server isEntryOpen: %b,needSave: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(175474);
  }
  
  public static void a(fbe paramfbe)
  {
    AppMethodBeat.i(266717);
    try
    {
      MultiProcessMMKV localMultiProcessMMKV = bcJ();
      if (paramfbe != null)
      {
        byte[] arrayOfByte = paramfbe.toByteArray();
        paramfbe = arrayOfByte;
        if (arrayOfByte != null) {}
      }
      else
      {
        paramfbe = new byte[0];
      }
      localMultiProcessMMKV.encode("biz_video_channel_top_bar_info", paramfbe);
      AppMethodBeat.o(266717);
      return;
    }
    catch (Exception paramfbe)
    {
      AppMethodBeat.o(266717);
    }
  }
  
  public static final void a(pz parampz)
  {
    Integer localInteger = null;
    AppMethodBeat.i(175470);
    p.k(parampz, "resp");
    int i = bcJ().getInt("top_bar_video_channel_switch_option", 0);
    fba localfba = parampz.RYn;
    Object localObject1;
    label104:
    label234:
    label253:
    Object localObject2;
    label136:
    label173:
    label202:
    Object localObject3;
    label272:
    label294:
    boolean bool2;
    label413:
    boolean bool1;
    if (localfba != null)
    {
      bcJ().encode("biz_video_channel_show_default_icon", 0);
      localObject1 = new StringBuilder("alvinluo onUpdateBizVideoChannelStrategy localSwitchOption: %d, switch_option: %d, appId: %s, title: %s, logo: %s, version: %d, funcVersion: %d, default_logo_url: ");
      parampz = localfba.UAU;
      if (parampz != null)
      {
        parampz = parampz.UAY;
        localObject1 = ((StringBuilder)localObject1).append(parampz).append(", control_bits: ");
        parampz = localfba.UAU;
        if (parampz == null) {
          break label661;
        }
        parampz = Integer.valueOf(parampz.UBd);
        localObject1 = ((StringBuilder)localObject1).append(parampz).append(", display_type=");
        parampz = localfba.UAU;
        if (parampz == null) {
          break label666;
        }
        parampz = Integer.valueOf(parampz.UBj);
        localObject1 = ((StringBuilder)localObject1).append(parampz).append(' ').append("showSmallIcon=");
        parampz = localfba.UAU;
        if (parampz == null) {
          break label671;
        }
        parampz = Integer.valueOf(parampz.UBh);
        localObject1 = ((StringBuilder)localObject1).append(parampz).append(" smallIconUrl=");
        parampz = localfba.UAU;
        if (parampz == null) {
          break label676;
        }
        parampz = parampz.UBi;
        String str = parampz;
        int j = localfba.UaP;
        parampz = localfba.UAU;
        if (parampz == null) {
          break label681;
        }
        parampz = parampz.appid;
        localObject1 = localfba.UAU;
        if (localObject1 == null) {
          break label686;
        }
        localObject1 = ((fbe)localObject1).title;
        localObject2 = localfba.UAU;
        if (localObject2 == null) {
          break label692;
        }
        localObject2 = ((fbe)localObject2).llI;
        localObject3 = localfba.UAU;
        if (localObject3 == null) {
          break label698;
        }
        localObject3 = Integer.valueOf(((fbe)localObject3).version);
        fbe localfbe = localfba.UAU;
        if (localfbe != null) {
          localInteger = Integer.valueOf(localfbe.UAX);
        }
        Log.i("MicroMsg.BizVideoChannelStrategy", str, new Object[] { Integer.valueOf(i), Integer.valueOf(j), parampz, localObject1, localObject2, localObject3, localInteger });
        bcJ().putInt("top_bar_video_channel_switch_option", localfba.UaP);
        if (localfba.UaP != 2) {
          break label726;
        }
        if (com.tencent.mm.plugin.brandservice.ui.b.c.b((com.tencent.mm.cd.a)localfba.UAU, (com.tencent.mm.cd.a)cza())) {
          break label704;
        }
        bool2 = true;
        svY = localfba.UAU;
        a(localfba.UAU);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (czj())
          {
            parampz = y.sFw.cAO();
            localObject1 = czk();
            p.k("vc", "type");
            p.k("__biz_video_channel_canvas_id__", "canvasId");
            p.k(localObject1, "data");
            Log.i(parampz.TAG, "update #".concat(String.valueOf("__biz_video_channel_canvas_id__")));
            if (parampz.PtI.containsKey("__biz_video_channel_canvas_id__")) {
              break label710;
            }
            com.tencent.mm.plugin.webcanvas.c.a(parampz, "vc", "__biz_video_channel_canvas_id__", (String)localObject1);
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      parampz = svX;
      GB(localfba.UaP);
      Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onUpdateBizVideoChannelStrategy oldEntry: %b, new: %b, isTopBarInfoChanged: %b", new Object[] { parampz, svX, Boolean.valueOf(bool1) });
      if (((p.h(parampz, svX) ^ true)) || (bool1))
      {
        i = localfba.UaP;
        parampz = svY;
        Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onTopBarVideoChannelEntryChanged");
        localObject1 = new as();
        ((as)localObject1).fwj.fwk = i;
        if (parampz != null) {
          ((as)localObject1).fwj.fwl = parampz;
        }
        EventCenter.instance.publish((IEvent)localObject1);
      }
      AppMethodBeat.o(175470);
      return;
      parampz = null;
      break;
      label661:
      parampz = null;
      break label104;
      label666:
      parampz = null;
      break label136;
      label671:
      parampz = null;
      break label173;
      label676:
      parampz = null;
      break label202;
      label681:
      parampz = null;
      break label234;
      label686:
      localObject1 = null;
      break label253;
      label692:
      localObject2 = null;
      break label272;
      label698:
      localObject3 = null;
      break label294;
      label704:
      bool2 = false;
      break label413;
      label710:
      com.tencent.mm.plugin.webcanvas.c.a(parampz, "update", "__biz_video_channel_canvas_id__");
      bool1 = bool2;
      continue;
      label726:
      if ((localfba.UaP == 0) || (localfba.UaP == 1))
      {
        czb();
        bool1 = false;
      }
      else if (localfba.UaP == 3)
      {
        bool1 = false;
        czb();
        continue;
        AppMethodBeat.o(175470);
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public static void b(c.b paramb)
  {
    AppMethodBeat.i(175477);
    com.tencent.mm.an.d.a locala = new com.tencent.mm.an.d.a();
    locala.c((com.tencent.mm.cd.a)new byv());
    locala.d((com.tencent.mm.cd.a)new byw());
    locala.TW("/cgi-bin/mmbiz-bin/videochannel/getnotifyandchannelfeeds");
    locala.vD(1814);
    aa.a(locala.bgN(), (aa.a)new b(paramb));
    AppMethodBeat.o(175477);
  }
  
  public static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(175468);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)lrB.getValue();
    AppMethodBeat.o(175468);
    return localMultiProcessMMKV;
  }
  
  public static final boolean cyY()
  {
    AppMethodBeat.i(175471);
    if (com.tencent.mm.plugin.biz.b.c.cxM())
    {
      AppMethodBeat.o(175471);
      return false;
    }
    Boolean localBoolean = svX;
    if (localBoolean == null) {
      p.iCn();
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175471);
    return bool;
  }
  
  public static final boolean cyZ()
  {
    AppMethodBeat.i(175472);
    Boolean localBoolean = svZ;
    if (localBoolean == null) {
      p.iCn();
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175472);
    return bool;
  }
  
  public static final fbe cza()
  {
    int j = 1;
    AppMethodBeat.i(175475);
    Object localObject1;
    int i;
    if (svY == null)
    {
      localObject1 = bcJ();
      p.j(localObject1, "mmkv");
      if (!((MultiProcessMMKV)localObject1).containsKey("biz_video_channel_top_bar_info")) {
        break label129;
      }
      localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes("biz_video_channel_top_bar_info");
      if (localObject1 == null) {
        break label129;
      }
      if (localObject1.length != 0) {
        break label101;
      }
      i = 1;
      if (i != 0) {
        break label106;
      }
      i = j;
      label58:
      if (i == 0) {
        break label129;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject3 = fbe.class.newInstance();
        ((com.tencent.mm.cd.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.cd.a)localObject3;
        svY = (fbe)localObject1;
        localObject1 = svY;
        AppMethodBeat.o(175475);
        return localObject1;
      }
      catch (Exception localException)
      {
        label101:
        label106:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label58;
      label129:
      Object localObject2 = null;
    }
  }
  
  private static void czb()
  {
    AppMethodBeat.i(175476);
    try
    {
      bcJ().encode("biz_video_channel_top_bar_info", new byte[0]);
      svY = null;
      AppMethodBeat.o(175476);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(175476);
    }
  }
  
  public static boolean czd()
  {
    AppMethodBeat.i(266719);
    fbe localfbe = cza();
    if (localfbe == null)
    {
      AppMethodBeat.o(266719);
      return false;
    }
    if ((localfbe.UBd & 0x10) != 0)
    {
      AppMethodBeat.o(266719);
      return true;
    }
    AppMethodBeat.o(266719);
    return false;
  }
  
  public static boolean cze()
  {
    AppMethodBeat.i(266720);
    fbe localfbe = cza();
    if (localfbe == null)
    {
      AppMethodBeat.o(266720);
      return false;
    }
    if ((!Util.isNullOrNil(localfbe.UAY)) && (bcJ().decodeInt("biz_video_channel_show_default_icon", 0) == 1))
    {
      AppMethodBeat.o(266720);
      return true;
    }
    AppMethodBeat.o(266720);
    return false;
  }
  
  public static String czh()
  {
    AppMethodBeat.i(266724);
    Object localObject = cza();
    if (localObject == null)
    {
      AppMethodBeat.o(266724);
      return "";
    }
    localObject = ((fbe)localObject).UAZ;
    AppMethodBeat.o(266724);
    return localObject;
  }
  
  public static boolean czi()
  {
    AppMethodBeat.i(266725);
    fbe localfbe = cza();
    if ((localfbe != null) && (localfbe.UBf == 1))
    {
      AppMethodBeat.o(266725);
      return true;
    }
    AppMethodBeat.o(266725);
    return false;
  }
  
  public static boolean czj()
  {
    AppMethodBeat.i(266726);
    boolean bool = ((Boolean)swb.getValue()).booleanValue();
    AppMethodBeat.o(266726);
    return bool;
  }
  
  public static String czk()
  {
    AppMethodBeat.i(266727);
    Object localObject = cza();
    if (localObject == null)
    {
      Log.w("MicroMsg.BizVideoChannelStrategy", "getProtoData topBarInfo is null");
      AppMethodBeat.o(266727);
      return "";
    }
    localObject = Base64.encode(((fbe)localObject).toByteArray(), 2);
    p.j(localObject, "Base64.encode(topBarInfo…eArray(), Base64.NO_WRAP)");
    Charset localCharset = StandardCharsets.UTF_8;
    p.j(localCharset, "StandardCharsets.UTF_8");
    localObject = new String((byte[])localObject, localCharset);
    AppMethodBeat.o(266727);
    return localObject;
  }
  
  public static final void init()
  {
    boolean bool = true;
    AppMethodBeat.i(175469);
    int i = bcJ().getInt("top_bar_video_channel_switch_option", 0);
    if (bcJ().getInt("top_bar_video_channel_switch_option", 0) == 1) {}
    for (;;)
    {
      GB(i);
      I(bool, false);
      AppMethodBeat.o(175469);
      return;
      bool = false;
    }
  }
  
  public static final void release() {}
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(266728);
    com.tencent.mm.plugin.report.service.h.IzE.p(1416L, paramLong, 1L);
    AppMethodBeat.o(266728);
  }
  
  public static void t(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(266718);
    Object localObject = cza();
    int i;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label141;
      }
      AppMethodBeat.o(266718);
      return;
      if ((paramInt == 2) && ((((fbe)localObject).UBd & 0x2) != 0))
      {
        i = 1;
      }
      else if (paramInt == 1)
      {
        if ((((fbe)localObject).UBd & 0x1) != 0) {
          i = 1;
        } else if ((((fbe)localObject).UBd == 0) && (bcJ().decodeInt("biz_video_channel_show_default_icon", -1) == -1)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else if ((paramInt == 3) && ((((fbe)localObject).UBd & 0x4) != 0))
      {
        i = 1;
      }
      else
      {
        if ((paramInt != 4) || ((((fbe)localObject).UBd & 0x8) == 0)) {
          break;
        }
        i = 1;
      }
    }
    label141:
    long l2;
    if ((paramInt == 2) || (paramInt == 1)) {
      l2 = bcJ().getLong("biz_video_channel_strategy_fetch_last_time", 0L);
    }
    for (long l1 = Math.max(bcJ().getLong("biz_video_channel_strategy_fetch_interval", 1800000L), 300000L);; l1 = bcJ().getLong("biz_video_channel_strategy_tl_fetch_interval", 1800000L))
    {
      l2 = Math.abs(System.currentTimeMillis() - l2);
      if (l2 >= l1) {
        break;
      }
      Log.i("MicroMsg.BizVideoChannelStrategy", "fetchBizStrategy delta < interval, return");
      AppMethodBeat.o(266718);
      return;
      l2 = bcJ().getLong("biz_video_channel_strategy_tl_fetch_last_time", 0L);
    }
    localObject = new com.tencent.mm.an.d.a();
    ((com.tencent.mm.an.d.a)localObject).c((com.tencent.mm.cd.a)new py());
    ((com.tencent.mm.an.d.a)localObject).d((com.tencent.mm.cd.a)new pz());
    ((com.tencent.mm.an.d.a)localObject).TW("/cgi-bin/mmbiz-bin/timeline/bizstrategy");
    ((com.tencent.mm.an.d.a)localObject).vD(1806);
    com.tencent.mm.an.d locald = ((com.tencent.mm.an.d.a)localObject).bgN();
    p.j(locald, "rr");
    localObject = locald.bhX();
    if (localObject == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
      AppMethodBeat.o(266718);
      throw paramString1;
    }
    final py localpy = (py)localObject;
    localpy.lpw = 8;
    fbb localfbb = new fbb();
    localfbb.UAW = new fbf();
    fbf localfbf = localfbb.UAW;
    localObject = cza();
    if (localObject != null) {}
    for (localObject = ((fbe)localObject).UAZ;; localObject = null)
    {
      localfbf.UAZ = ((String)localObject);
      localfbb.UAW.RVH = paramString1;
      localfbb.UAW.UBl = paramString2;
      localfbb.UAW.scene = paramInt;
      localpy.RYi = localfbb;
      report(0L);
      aa.a(locald, (aa.a)new a(paramInt, localpy));
      Log.i("MicroMsg.BizVideoChannelStrategy", "preloadChannelStrategy %d", new Object[] { Long.valueOf(l2) });
      AppMethodBeat.o(266718);
      return;
    }
  }
  
  public final boolean czf()
  {
    AppMethodBeat.i(266721);
    fbe localfbe = cza();
    if (localfbe == null)
    {
      AppMethodBeat.o(266721);
      return false;
    }
    if ((cze()) || (Util.isEqual(localfbe.llI, localfbe.UAY)))
    {
      AppMethodBeat.o(266721);
      return true;
    }
    AppMethodBeat.o(266721);
    return false;
  }
  
  public final boolean czg()
  {
    AppMethodBeat.i(266722);
    boolean bool = u.agG(w.bpO(lv(false)));
    AppMethodBeat.o(266722);
    return bool;
  }
  
  public final String lv(boolean paramBoolean)
  {
    AppMethodBeat.i(266723);
    if ((Util.isNullOrNil(svW)) || (paramBoolean))
    {
      localObject = cza();
      if (localObject == null)
      {
        AppMethodBeat.o(266723);
        return "";
      }
      if (!cze()) {
        break label75;
      }
    }
    label75:
    for (Object localObject = ((fbe)localObject).UAY;; localObject = ((fbe)localObject).llI)
    {
      localObject = Util.nullAsNil((String)localObject);
      p.j(localObject, "Util.nullAsNil(if (isSho…else topBarInfo.logo_url)");
      svW = (String)localObject;
      localObject = svW;
      AppMethodBeat.o(266723);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements aa.a
  {
    a(int paramInt, py parampy) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(265981);
      Log.i("MicroMsg.BizVideoChannelStrategy", "fetchBizVideoChannelStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((this.swd == 2) || (this.swd == 1))
      {
        paramString = d.swc;
        d.czl().putLong("biz_video_channel_strategy_fetch_last_time", System.currentTimeMillis());
      }
      while ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = d.swc;
        d.report(2L);
        AppMethodBeat.o(265981);
        return 0;
        paramString = d.swc;
        d.czl().putLong("biz_video_channel_strategy_tl_fetch_last_time", System.currentTimeMillis());
      }
      p.j(paramd, "comReqResp");
      paramd = paramd.bhY();
      paramString = paramd;
      if (!(paramd instanceof pz)) {
        paramString = null;
      }
      paramString = (pz)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(265981);
        return 0;
      }
      paramd = paramString.RYn;
      if (paramd != null)
      {
        paramd = paramd.UAU;
        if ((paramd != null) && (paramd.UBa == 0))
        {
          Log.i("MicroMsg.BizVideoChannelStrategy", "sync_flag is 0, just return!");
          AppMethodBeat.o(265981);
          return 0;
        }
      }
      paramd = d.swc;
      d.report(1L);
      if ((localpy.lpw & 0x8) != 0)
      {
        d.a(paramString);
        paramd = d.swc;
        d.b(this.swd, paramString);
        paramd = d.swc;
        d.b(paramString);
      }
      AppMethodBeat.o(265981);
      return 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class b
    implements aa.a
  {
    b(c.b paramb) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(175464);
      Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo getNotifyAndChannelFeeds callback errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        p.j(paramd, "comReqResp");
        paramString = paramd.bhY();
        if (paramString != null)
        {
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetNotifyAndChannelFeedsResp");
            AppMethodBeat.o(175464);
            throw paramString;
          }
          paramString = ((byw)paramString).ThU;
          if (paramString != null) {
            break label174;
          }
          paramString = "";
        }
      }
      label174:
      for (;;)
      {
        Log.d("MicroMsg.BizVideoChannelStrategy", "alvinuo getNotifyAndChannelFeeds channelFeeds: %s", new Object[] { paramString });
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apj(paramString);
        paramd = this.swf;
        if (paramd != null) {
          paramd.onSuccess(paramString);
        }
        for (;;)
        {
          AppMethodBeat.o(175464);
          return 0;
          paramd = this.swf;
          if (paramd != null) {
            paramd.p(paramInt1, paramInt2, paramString);
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final c swg;
    
    static
    {
      AppMethodBeat.i(257494);
      swg = new c();
      AppMethodBeat.o(257494);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final d swh;
    
    static
    {
      AppMethodBeat.i(175466);
      swh = new d();
      AppMethodBeat.o(175466);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(265079);
      Log.i("MicroMsg.BizVideoChannelStrategy", "preloadIcon start = %s", new Object[] { this.piM });
      com.tencent.mm.ay.a.a.c localc = new c.a().bmJ().wy(com.tencent.mm.plugin.brandservice.d.d.brand_default_head).bmF().Wq(this.swi).bmL();
      com.tencent.mm.ay.q.bml().a(this.piM, null, localc, (k)1.swj);
      AppMethodBeat.o(265079);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final f swk;
    
    static
    {
      AppMethodBeat.i(266194);
      swk = new f();
      AppMethodBeat.o(266194);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.d
 * JD-Core Version:    0.7.0.1
 */
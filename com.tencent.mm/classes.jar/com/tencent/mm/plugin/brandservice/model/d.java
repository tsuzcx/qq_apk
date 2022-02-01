package com.tencent.mm.plugin.brandservice.model;

import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z;
import com.tencent.mm.autogen.a.aw;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardJsEngine;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardJsEngine.Companion;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.fxh;
import com.tencent.mm.protocal.protobuf.fxi;
import com.tencent.mm.protocal.protobuf.fxl;
import com.tencent.mm.protocal.protobuf.fxm;
import com.tencent.mm.protocal.protobuf.ri;
import com.tencent.mm.protocal.protobuf.rj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/model/BizVideoChannelStrategy;", "", "()V", "BIZ_PROFILE_VIDEO_CHANNEL_ENTRY_OPEN", "", "KEY_BIZ_VIDEO_CHANNEL_SHOW_DEFAULT_ICON", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_LAST_TIME", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_LAST_TIME", "TAG", "TOP_BAR_INFO", "TOP_BAR_VIDEO_CHANNEL_SWITCH_OPTION", "VIDEO_CHANNEL_FEEDS_DATA", "bizVideoChannelCanvasId", "isBizProfileEntryOpen", "", "Ljava/lang/Boolean;", "isTimelineTopBarEntryOpen", "localOpen", "", "getLocalOpen", "()I", "localOpen$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "showCanvas", "getShowCanvas", "()Z", "showCanvas$delegate", "showingLogoUrl", "getShowingLogoUrl", "()Ljava/lang/String;", "setShowingLogoUrl", "(Ljava/lang/String;)V", "timelineTopBarInfo", "Lcom/tencent/mm/protocal/protobuf/VideoChannelTopBarInfo;", "clearTopBarInfo", "", "fetchBizVideoChannelStrategy", "fromScene", "talker", "url", "getLogoUrl", "force", "getNotifyAndChannelFeeds", "updateCallback", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "getProtoData", "getSyncBuffer", "getTopBarInfo", "getTopBarPath", "init", "isPreloadOpen", "scene", "isShowDefaultIcon", "isShowingDefaultIcon", "isShowingIconCached", "isTimeLineTopBarEntryOpen", "isTopBarInfoChanged", "topBarInfo", "loadChannelIcon", "iconIV", "Landroid/widget/ImageView;", "loadChannelSmallIcon", "onLogoClick", "onTopBarVideoChannelEntryChanged", "switchOption", "preloadChannelStrategy", "preloadIcon", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "release", "report", "key", "", "saveTopBarInfo", "top_bar_info", "shouldChaneDefaultLogoAfterClick", "showRightTopGreedDot", "update", "updateBizProfileEntryStatus", "isEntryOpen", "needSave", "updateInterval", "updateTimelineTopBarEntryStatus", "updateUnReadView", "holder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView$HotListViewHolder;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;", "context", "Landroid/content/Context;", "VideoChannelSwitchOption", "VideoChannelTopBarControlBit", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final j exj;
  public static final d vBI;
  public static String vBJ;
  private static Boolean vBK;
  private static fxl vBL;
  private static Boolean vBM;
  private static final j vBN;
  private static final j vBO;
  
  static
  {
    AppMethodBeat.i(175467);
    vBI = new d();
    vBJ = "";
    exj = kotlin.k.cm((kotlin.g.a.a)d.b.vBQ);
    vBN = kotlin.k.cm((kotlin.g.a.a)a.vBP);
    vBO = kotlin.k.cm((kotlin.g.a.a)c.vBR);
    AppMethodBeat.o(175467);
  }
  
  private static void Ha(int paramInt)
  {
    AppMethodBeat.i(175473);
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      vBK = Boolean.valueOf(bool);
      AppMethodBeat.o(175473);
      return;
    }
  }
  
  private static final int a(int paramInt1, ri paramri, int paramInt2, int paramInt3, String paramString, com.tencent.mm.am.c paramc, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(303529);
    s.u(paramri, "$req");
    Log.i("MicroMsg.BizVideoChannelStrategy", "fetchBizVideoChannelStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    switch (paramInt1)
    {
    default: 
      atj().putLong("biz_video_channel_strategy_tl_fetch_last_time", System.currentTimeMillis());
    }
    while ((paramInt2 != 0) || (paramInt3 != 0))
    {
      report(2L);
      AppMethodBeat.o(303529);
      return 0;
      atj().putLong("biz_video_channel_strategy_fetch_last_time", System.currentTimeMillis());
    }
    paramString = c.c.b(paramc.otC);
    if ((paramString instanceof rj)) {}
    for (paramString = (rj)paramString; paramString == null; paramString = null)
    {
      AppMethodBeat.o(303529);
      return 0;
    }
    paramc = paramString.YWm;
    if (paramc != null)
    {
      paramc = paramc.abUX;
      if ((paramc != null) && (paramc.abVd == 0))
      {
        Log.i("MicroMsg.BizVideoChannelStrategy", "sync_flag is 0, just return!");
        AppMethodBeat.o(303529);
        return 0;
      }
    }
    report(1L);
    if ((paramri.nUz & 0x8) != 0)
    {
      a(paramString);
      paramri = paramString.YWm;
      if (paramri != null)
      {
        paramri = paramri.abUX;
        if (paramri == null) {}
      }
      switch (paramInt1)
      {
      default: 
        if (paramri.interval > 0)
        {
          Log.i("MicroMsg.BizVideoChannelStrategy", "fetchBizVideoChannelStrategy tl interval = %d", new Object[] { Integer.valueOf(paramri.interval) });
          atj().putLong("biz_video_channel_strategy_tl_fetch_interval", paramri.interval);
        }
        paramri = paramString.YWm;
        if (paramri == null) {
          break label552;
        }
        paramri = paramri.abUX;
        if (paramri == null) {
          break label552;
        }
        paramString = new String[3];
        paramString[0] = paramri.nQG;
        paramString[1] = paramri.abVb;
        paramString[2] = paramri.abVl;
        s.u(paramString, "$this$distinct");
        s.u(paramString, "$this$toMutableSet");
        paramri = ((Iterable)kotlin.a.p.p((Iterable)kotlin.a.k.b(paramString, (Collection)new LinkedHashSet(ak.aKi(3))))).iterator();
        label410:
        if (!paramri.hasNext()) {
          break label552;
        }
        paramString = (String)paramri.next();
        paramc = (CharSequence)paramString;
        if ((paramc != null) && (!n.bp(paramc))) {
          break;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label410;
        }
        paramc = com.tencent.mm.pluginsdk.model.y.bpF(paramString);
        if (com.tencent.mm.vfs.y.ZC(paramc)) {
          break label410;
        }
        report(10L);
        com.tencent.threadpool.h.ahAA.bk(new d..ExternalSyntheticLambda3(paramString, paramc));
        break label410;
        if (paramri.interval <= 0) {
          break;
        }
        Log.i("MicroMsg.BizVideoChannelStrategy", "fetchBizVideoChannelStrategy expose interval = %d", new Object[] { Integer.valueOf(paramri.interval) });
        atj().putLong("biz_video_channel_strategy_fetch_interval", paramri.interval);
        break;
      }
    }
    label552:
    AppMethodBeat.o(303529);
    return 0;
  }
  
  private static final int a(com.tencent.mm.plugin.brandservice.api.c.b paramb, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(303524);
    Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo getNotifyAndChannelFeeds callback errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = c.c.b(paramc.otC);
      if (paramString != null)
      {
        paramString = ((cnz)paramString).aavk;
        if (paramString != null) {
          break label122;
        }
        paramString = "";
        Log.d("MicroMsg.BizVideoChannelStrategy", "alvinuo getNotifyAndChannelFeeds channelFeeds: %s", new Object[] { paramString });
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiG(paramString);
        if (paramb != null) {
          paramb.onSuccess(paramString);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(303524);
      return 0;
      label122:
      break;
      if (paramb != null) {
        paramb.s(paramInt1, paramInt2, paramString);
      }
    }
  }
  
  public static void a(fxl paramfxl)
  {
    AppMethodBeat.i(303475);
    try
    {
      MultiProcessMMKV localMultiProcessMMKV = atj();
      if (paramfxl == null) {}
      for (paramfxl = null;; paramfxl = paramfxl.toByteArray())
      {
        Object localObject = paramfxl;
        if (paramfxl == null) {
          localObject = new byte[0];
        }
        localMultiProcessMMKV.encode("biz_video_channel_top_bar_info", (byte[])localObject);
        AppMethodBeat.o(303475);
        return;
      }
      return;
    }
    catch (Exception paramfxl)
    {
      AppMethodBeat.o(303475);
    }
  }
  
  public static final void a(rj paramrj)
  {
    Integer localInteger = null;
    AppMethodBeat.i(175470);
    s.u(paramrj, "resp");
    int i = atj().getInt("top_bar_video_channel_switch_option", 0);
    fxh localfxh = paramrj.YWm;
    Object localObject1;
    label99:
    label125:
    Object localObject2;
    label151:
    label177:
    label206:
    label221:
    label236:
    Object localObject3;
    label251:
    fxl localfxl;
    label263:
    boolean bool2;
    label361:
    boolean bool1;
    if (localfxh != null)
    {
      atj().encode("biz_video_channel_show_default_icon", 0);
      localObject1 = new StringBuilder("alvinluo onUpdateBizVideoChannelStrategy localSwitchOption: %d, switch_option: %d, appId: %s, title: %s, logo: %s, version: %d, funcVersion: %d, default_logo_url: ");
      paramrj = localfxh.abUX;
      if (paramrj != null) {
        break label532;
      }
      paramrj = null;
      localObject1 = ((StringBuilder)localObject1).append(paramrj).append(", control_bits: ");
      paramrj = localfxh.abUX;
      if (paramrj != null) {
        break label540;
      }
      paramrj = null;
      localObject1 = ((StringBuilder)localObject1).append(paramrj).append(", display_type=");
      paramrj = localfxh.abUX;
      if (paramrj != null) {
        break label551;
      }
      paramrj = null;
      localObject1 = ((StringBuilder)localObject1).append(paramrj).append(" showSmallIcon=");
      paramrj = localfxh.abUX;
      if (paramrj != null) {
        break label562;
      }
      paramrj = null;
      localObject1 = ((StringBuilder)localObject1).append(paramrj).append(" smallIconUrl=");
      paramrj = localfxh.abUX;
      if (paramrj != null) {
        break label573;
      }
      paramrj = null;
      String str = paramrj;
      int j = localfxh.abrV;
      paramrj = localfxh.abUX;
      if (paramrj != null) {
        break label581;
      }
      paramrj = null;
      localObject1 = localfxh.abUX;
      if (localObject1 != null) {
        break label589;
      }
      localObject1 = null;
      localObject2 = localfxh.abUX;
      if (localObject2 != null) {
        break label599;
      }
      localObject2 = null;
      localObject3 = localfxh.abUX;
      if (localObject3 != null) {
        break label609;
      }
      localObject3 = null;
      localfxl = localfxh.abUX;
      if (localfxl != null) {
        break label622;
      }
      Log.i("MicroMsg.BizVideoChannelStrategy", str, new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramrj, localObject1, localObject2, localObject3, localInteger });
      atj().putInt("top_bar_video_channel_switch_option", localfxh.abrV);
      if (localfxh.abrV != 2) {
        break label641;
      }
      if (com.tencent.mm.plugin.brandservice.ui.b.d.b((com.tencent.mm.bx.a)localfxh.abUX, (com.tencent.mm.bx.a)dbU())) {
        break label635;
      }
      bool2 = true;
      vBL = localfxh.abUX;
      a(localfxh.abUX);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (dcd())
        {
          BizTLRecCardJsEngine.vKS.ddS().bm("vc", "__biz_video_channel_canvas_id__", dce());
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      paramrj = vBK;
      Ha(localfxh.abrV);
      Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onUpdateBizVideoChannelStrategy oldEntry: %b, new: %b, isTopBarInfoChanged: %b", new Object[] { paramrj, vBK, Boolean.valueOf(bool1) });
      if ((!s.p(paramrj, vBK)) || (bool1))
      {
        i = localfxh.abrV;
        paramrj = vBL;
        Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onTopBarVideoChannelEntryChanged");
        localObject1 = new aw();
        ((aw)localObject1).hAF.hAG = i;
        if (paramrj != null) {
          ((aw)localObject1).hAF.hAH = paramrj;
        }
        ((aw)localObject1).publish();
      }
      AppMethodBeat.o(175470);
      return;
      label532:
      paramrj = paramrj.abVb;
      break;
      label540:
      paramrj = Integer.valueOf(paramrj.abVg);
      break label99;
      label551:
      paramrj = Integer.valueOf(paramrj.abVm);
      break label125;
      label562:
      paramrj = Integer.valueOf(paramrj.abVk);
      break label151;
      label573:
      paramrj = paramrj.abVl;
      break label177;
      label581:
      paramrj = paramrj.appid;
      break label206;
      label589:
      localObject1 = ((fxl)localObject1).title;
      break label221;
      label599:
      localObject2 = ((fxl)localObject2).nQG;
      break label236;
      label609:
      localObject3 = Integer.valueOf(((fxl)localObject3).version);
      break label251;
      label622:
      localInteger = Integer.valueOf(localfxl.abVa);
      break label263;
      label635:
      bool2 = false;
      break label361;
      label641:
      if ((localfxh.abrV == 0) || (localfxh.abrV == 1))
      {
        dbV();
        bool1 = false;
      }
      else if (localfxh.abrV == 3)
      {
        bool1 = false;
        dbV();
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  private static final void a(String paramString, View paramView, Bitmap paramBitmap, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(303533);
    Log.i("MicroMsg.BizVideoChannelStrategy", "preloadIcon finish: url = %s", new Object[] { paramString });
    report(11L);
    AppMethodBeat.o(303533);
  }
  
  public static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(175468);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(175468);
    return localMultiProcessMMKV;
  }
  
  public static void b(com.tencent.mm.plugin.brandservice.api.c.b paramb)
  {
    AppMethodBeat.i(175477);
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    locala.otE = ((com.tencent.mm.bx.a)new cny());
    locala.otF = ((com.tencent.mm.bx.a)new cnz());
    locala.uri = "/cgi-bin/mmbiz-bin/videochannel/getnotifyandchannelfeeds";
    locala.funcId = 1814;
    z.a(locala.bEF(), new d..ExternalSyntheticLambda1(paramb));
    AppMethodBeat.o(175477);
  }
  
  public static final boolean dbT()
  {
    AppMethodBeat.i(175471);
    if (com.tencent.mm.plugin.biz.b.c.daC())
    {
      AppMethodBeat.o(175471);
      return false;
    }
    Boolean localBoolean = vBK;
    s.checkNotNull(localBoolean);
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175471);
    return bool;
  }
  
  public static final fxl dbU()
  {
    int j = 1;
    AppMethodBeat.i(175475);
    Object localObject1;
    int i;
    if (vBL == null)
    {
      localObject1 = atj();
      s.s(localObject1, "mmkv");
      if (!((MultiProcessMMKV)localObject1).containsKey("biz_video_channel_top_bar_info")) {
        break label132;
      }
      localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes("biz_video_channel_top_bar_info");
      if (localObject1 == null) {
        break label132;
      }
      if (localObject1.length != 0) {
        break label104;
      }
      i = 1;
      if (i != 0) {
        break label109;
      }
      i = j;
      label60:
      if (i == 0) {
        break label132;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject3 = fxl.class.newInstance();
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bx.a)localObject3;
        vBL = (fxl)localObject1;
        localObject1 = vBL;
        AppMethodBeat.o(175475);
        return localObject1;
      }
      catch (Exception localException)
      {
        label104:
        label109:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label60;
      label132:
      Object localObject2 = null;
    }
  }
  
  private static void dbV()
  {
    AppMethodBeat.i(175476);
    try
    {
      atj().encode("biz_video_channel_top_bar_info", new byte[0]);
      vBL = null;
      AppMethodBeat.o(175476);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(175476);
    }
  }
  
  public static boolean dbX()
  {
    AppMethodBeat.i(303496);
    fxl localfxl = dbU();
    if (localfxl == null)
    {
      AppMethodBeat.o(303496);
      return false;
    }
    if ((localfxl.abVg & 0x10) != 0)
    {
      AppMethodBeat.o(303496);
      return true;
    }
    AppMethodBeat.o(303496);
    return false;
  }
  
  public static boolean dbY()
  {
    AppMethodBeat.i(303498);
    fxl localfxl = dbU();
    if (localfxl == null)
    {
      AppMethodBeat.o(303498);
      return false;
    }
    if ((!Util.isNullOrNil(localfxl.abVb)) && (atj().decodeInt("biz_video_channel_show_default_icon", 0) == 1))
    {
      AppMethodBeat.o(303498);
      return true;
    }
    AppMethodBeat.o(303498);
    return false;
  }
  
  public static boolean dbZ()
  {
    AppMethodBeat.i(303501);
    fxl localfxl = dbU();
    if (localfxl == null)
    {
      AppMethodBeat.o(303501);
      return false;
    }
    if ((dbY()) || (Util.isEqual(localfxl.nQG, localfxl.abVb)))
    {
      AppMethodBeat.o(303501);
      return true;
    }
    AppMethodBeat.o(303501);
    return false;
  }
  
  public static String dcb()
  {
    AppMethodBeat.i(303509);
    Object localObject = dbU();
    if (localObject == null)
    {
      AppMethodBeat.o(303509);
      return "";
    }
    localObject = ((fxl)localObject).abVc;
    AppMethodBeat.o(303509);
    return localObject;
  }
  
  public static boolean dcc()
  {
    AppMethodBeat.i(303512);
    fxl localfxl = dbU();
    if ((localfxl != null) && (localfxl.abVi == 1))
    {
      AppMethodBeat.o(303512);
      return true;
    }
    AppMethodBeat.o(303512);
    return false;
  }
  
  public static boolean dcd()
  {
    AppMethodBeat.i(303513);
    boolean bool = ((Boolean)vBO.getValue()).booleanValue();
    AppMethodBeat.o(303513);
    return bool;
  }
  
  public static String dce()
  {
    AppMethodBeat.i(303516);
    Object localObject = dbU();
    if (localObject == null)
    {
      Log.w("MicroMsg.BizVideoChannelStrategy", "getProtoData topBarInfo is null");
      AppMethodBeat.o(303516);
      return "";
    }
    localObject = Base64.encode(((fxl)localObject).toByteArray(), 2);
    s.s(localObject, "encode(topBarInfo.toByteArray(), Base64.NO_WRAP)");
    Charset localCharset = StandardCharsets.UTF_8;
    s.s(localCharset, "UTF_8");
    localObject = new String((byte[])localObject, localCharset);
    AppMethodBeat.o(303516);
    return localObject;
  }
  
  private static final void fL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(303537);
    Log.i("MicroMsg.BizVideoChannelStrategy", "preloadIcon start = %s", new Object[] { paramString1 });
    com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
    locala.nrc = true;
    locala.oKB = d.d.brand_default_head;
    locala.oKp = true;
    locala.fullPath = paramString2;
    paramString2 = locala.bKx();
    r.bKe().a(paramString1, null, paramString2, d..ExternalSyntheticLambda2.INSTANCE);
    AppMethodBeat.o(303537);
  }
  
  public static final void init()
  {
    AppMethodBeat.i(175469);
    int i = atj().getInt("top_bar_video_channel_switch_option", 0);
    if (atj().getInt("top_bar_video_channel_switch_option", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Ha(i);
      vBM = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo updateBizProfileEntryStatus server isEntryOpen: %b,needSave: %b", new Object[] { Boolean.valueOf(bool), Boolean.FALSE });
      AppMethodBeat.o(175469);
      return;
    }
  }
  
  public static String mN(boolean paramBoolean)
  {
    AppMethodBeat.i(303506);
    if ((Util.isNullOrNil(vBJ)) || (paramBoolean))
    {
      localObject = dbU();
      if (localObject == null)
      {
        AppMethodBeat.o(303506);
        return "";
      }
      if (!dbY()) {
        break label75;
      }
    }
    label75:
    for (Object localObject = ((fxl)localObject).abVb;; localObject = ((fxl)localObject).nQG)
    {
      localObject = Util.nullAsNil((String)localObject);
      s.s(localObject, "nullAsNil(if (isShowDefa…else topBarInfo.logo_url)");
      vBJ = (String)localObject;
      localObject = vBJ;
      AppMethodBeat.o(303506);
      return localObject;
    }
  }
  
  public static final void release() {}
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(303519);
    com.tencent.mm.plugin.report.service.h.OAn.p(1416L, paramLong, 1L);
    AppMethodBeat.o(303519);
  }
  
  public static void w(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(303491);
    Object localObject = dbU();
    int i;
    if (localObject != null) {
      if ((paramInt == 2) && ((((fxl)localObject).abVg & 0x2) != 0)) {
        i = 1;
      }
    }
    while (i == 0)
    {
      AppMethodBeat.o(303491);
      return;
      if (paramInt == 1)
      {
        if ((((fxl)localObject).abVg & 0x1) != 0) {
          i = 1;
        } else if ((((fxl)localObject).abVg == 0) && (atj().decodeInt("biz_video_channel_show_default_icon", -1) == -1)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else if ((paramInt == 3) && ((((fxl)localObject).abVg & 0x4) != 0)) {
        i = 1;
      } else if ((paramInt == 4) && ((((fxl)localObject).abVg & 0x8) != 0)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    long l2;
    switch (paramInt)
    {
    default: 
      l2 = atj().getLong("biz_video_channel_strategy_tl_fetch_last_time", 0L);
    }
    for (long l1 = atj().getLong("biz_video_channel_strategy_tl_fetch_interval", 1800000L);; l1 = Math.max(atj().getLong("biz_video_channel_strategy_fetch_interval", 1800000L), 300000L))
    {
      l2 = Math.abs(System.currentTimeMillis() - l2);
      if (l2 >= l1) {
        break;
      }
      Log.i("MicroMsg.BizVideoChannelStrategy", "fetchBizStrategy delta < interval, return");
      AppMethodBeat.o(303491);
      return;
      l2 = atj().getLong("biz_video_channel_strategy_fetch_last_time", 0L);
    }
    localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).otE = ((com.tencent.mm.bx.a)new ri());
    ((com.tencent.mm.am.c.a)localObject).otF = ((com.tencent.mm.bx.a)new rj());
    ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/mmbiz-bin/timeline/bizstrategy";
    ((com.tencent.mm.am.c.a)localObject).funcId = 1806;
    com.tencent.mm.am.c localc = ((com.tencent.mm.am.c.a)localObject).bEF();
    localObject = com.tencent.mm.am.c.b.b(localc.otB);
    if (localObject == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
      AppMethodBeat.o(303491);
      throw paramString1;
    }
    ri localri = (ri)localObject;
    localri.nUz = 8;
    fxi localfxi = new fxi();
    localfxi.abUZ = new fxm();
    fxm localfxm = localfxi.abUZ;
    localObject = dbU();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((fxl)localObject).abVc)
    {
      localfxm.abVc = ((String)localObject);
      localfxi.abUZ.ADE = paramString1;
      localfxi.abUZ.ZQp = paramString2;
      localfxi.abUZ.scene = paramInt;
      paramString1 = ah.aiuX;
      localri.YWh = localfxi;
      report(0L);
      z.a(localc, new d..ExternalSyntheticLambda0(paramInt, localri));
      Log.i("MicroMsg.BizVideoChannelStrategy", "preloadChannelStrategy %d", new Object[] { Long.valueOf(l2) });
      AppMethodBeat.o(303491);
      return;
    }
  }
  
  public final boolean dca()
  {
    AppMethodBeat.i(303554);
    boolean bool = com.tencent.mm.vfs.y.ZC(com.tencent.mm.pluginsdk.model.y.bpF(mN(false)));
    AppMethodBeat.o(303554);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final a vBP;
    
    static
    {
      AppMethodBeat.i(303455);
      vBP = new a();
      AppMethodBeat.o(303455);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final c vBR;
    
    static
    {
      AppMethodBeat.i(303452);
      vBR = new c();
      AppMethodBeat.o(303452);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.d
 * JD-Core Version:    0.7.0.1
 */
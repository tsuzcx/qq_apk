package com.tencent.mm.plugin.brandservice.b;

import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.a.b.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.r.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.eqo;
import com.tencent.mm.protocal.protobuf.eqp;
import com.tencent.mm.protocal.protobuf.eqs;
import com.tencent.mm.protocal.protobuf.eqt;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/model/BizVideoChannelStrategy;", "", "()V", "BIZ_PROFILE_VIDEO_CHANNEL_ENTRY_OPEN", "", "KEY_BIZ_VIDEO_CHANNEL_SHOW_DEFAULT_ICON", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_LAST_TIME", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_LAST_TIME", "TAG", "TOP_BAR_INFO", "TOP_BAR_VIDEO_CHANNEL_SWITCH_OPTION", "VIDEO_CHANNEL_FEEDS_DATA", "bizVideoChannelCanvasId", "isBizProfileEntryOpen", "", "Ljava/lang/Boolean;", "isTimelineTopBarEntryOpen", "localOpen", "", "getLocalOpen", "()I", "localOpen$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "showCanvas", "getShowCanvas", "()Z", "showCanvas$delegate", "showingLogoUrl", "getShowingLogoUrl", "()Ljava/lang/String;", "setShowingLogoUrl", "(Ljava/lang/String;)V", "timelineTopBarInfo", "Lcom/tencent/mm/protocal/protobuf/VideoChannelTopBarInfo;", "clearTopBarInfo", "", "fetchBizVideoChannelStrategy", "fromScene", "talker", "url", "getLogoUrl", "force", "getNotifyAndChannelFeeds", "updateCallback", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "getProtoData", "getSyncBuffer", "getTopBarInfo", "getTopBarPath", "init", "isPreloadOpen", "scene", "isShowDefaultIcon", "isShowingDefaultIcon", "isShowingIconCached", "isTimeLineTopBarEntryOpen", "isTopBarInfoChanged", "topBarInfo", "loadChannelIcon", "iconIV", "Landroid/widget/ImageView;", "loadChannelSmallIcon", "onLogoClick", "onTopBarVideoChannelEntryChanged", "switchOption", "preloadChannelStrategy", "preloadIcon", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "release", "report", "key", "", "saveTopBarInfo", "top_bar_info", "shouldChaneDefaultLogoAfterClick", "showRightTopGreedDot", "update", "updateBizProfileEntryStatus", "isEntryOpen", "needSave", "updateInterval", "updateTimelineTopBarEntryStatus", "updateUnReadView", "holder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView$HotListViewHolder;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;", "context", "Landroid/content/Context;", "VideoChannelSwitchOption", "VideoChannelTopBarControlBit", "plugin-brandservice_release"})
public final class c
{
  private static final f iBW;
  public static String pmY;
  private static Boolean pmZ;
  private static eqs pna;
  private static Boolean pnb;
  private static final f pnc;
  private static final f pnd;
  public static final c pne;
  
  static
  {
    AppMethodBeat.i(175467);
    pne = new c();
    pmY = "";
    iBW = kotlin.g.ah((kotlin.g.a.a)c.d.pnj);
    pnc = kotlin.g.ah((kotlin.g.a.a)c.pni);
    pnd = kotlin.g.ah((kotlin.g.a.a)f.pnm);
    AppMethodBeat.o(175467);
  }
  
  private static void CU(int paramInt)
  {
    AppMethodBeat.i(175473);
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      pmZ = Boolean.valueOf(bool);
      AppMethodBeat.o(175473);
      return;
    }
  }
  
  public static final void E(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(175474);
    pnb = Boolean.valueOf(paramBoolean1);
    if (paramBoolean2) {
      aTI().putInt("biz_profile_video_channel_entry_open", 1);
    }
    Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo updateBizProfileEntryStatus server isEntryOpen: %b,needSave: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(175474);
  }
  
  public static void a(eqs parameqs)
  {
    AppMethodBeat.i(195133);
    try
    {
      MultiProcessMMKV localMultiProcessMMKV = aTI();
      if (parameqs != null)
      {
        byte[] arrayOfByte = parameqs.toByteArray();
        parameqs = arrayOfByte;
        if (arrayOfByte != null) {}
      }
      else
      {
        parameqs = new byte[0];
      }
      localMultiProcessMMKV.encode("biz_video_channel_top_bar_info", parameqs);
      AppMethodBeat.o(195133);
      return;
    }
    catch (Exception parameqs)
    {
      AppMethodBeat.o(195133);
    }
  }
  
  public static final void a(qd paramqd)
  {
    Integer localInteger = null;
    AppMethodBeat.i(175470);
    p.h(paramqd, "resp");
    int i = aTI().getInt("top_bar_video_channel_switch_option", 0);
    eqo localeqo = paramqd.KXa;
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
    if (localeqo != null)
    {
      aTI().encode("biz_video_channel_show_default_icon", 0);
      localObject1 = new StringBuilder("alvinluo onUpdateBizVideoChannelStrategy localSwitchOption: %d, switch_option: %d, appId: %s, title: %s, logo: %s, version: %d, funcVersion: %d, default_logo_url: ");
      paramqd = localeqo.NnX;
      if (paramqd != null)
      {
        paramqd = paramqd.Nob;
        localObject1 = ((StringBuilder)localObject1).append(paramqd).append(", control_bits: ");
        paramqd = localeqo.NnX;
        if (paramqd == null) {
          break label662;
        }
        paramqd = Integer.valueOf(paramqd.Nog);
        localObject1 = ((StringBuilder)localObject1).append(paramqd).append(", display_type=");
        paramqd = localeqo.NnX;
        if (paramqd == null) {
          break label667;
        }
        paramqd = Integer.valueOf(paramqd.Nom);
        localObject1 = ((StringBuilder)localObject1).append(paramqd).append(' ').append("showSmallIcon=");
        paramqd = localeqo.NnX;
        if (paramqd == null) {
          break label672;
        }
        paramqd = Integer.valueOf(paramqd.Nok);
        localObject1 = ((StringBuilder)localObject1).append(paramqd).append(" smallIconUrl=");
        paramqd = localeqo.NnX;
        if (paramqd == null) {
          break label677;
        }
        paramqd = paramqd.Nol;
        String str = paramqd;
        int j = localeqo.MOQ;
        paramqd = localeqo.NnX;
        if (paramqd == null) {
          break label682;
        }
        paramqd = paramqd.dNI;
        localObject1 = localeqo.NnX;
        if (localObject1 == null) {
          break label687;
        }
        localObject1 = ((eqs)localObject1).title;
        localObject2 = localeqo.NnX;
        if (localObject2 == null) {
          break label693;
        }
        localObject2 = ((eqs)localObject2).iwv;
        localObject3 = localeqo.NnX;
        if (localObject3 == null) {
          break label699;
        }
        localObject3 = Integer.valueOf(((eqs)localObject3).version);
        eqs localeqs = localeqo.NnX;
        if (localeqs != null) {
          localInteger = Integer.valueOf(localeqs.Noa);
        }
        Log.i("MicroMsg.BizVideoChannelStrategy", str, new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramqd, localObject1, localObject2, localObject3, localInteger });
        aTI().putInt("top_bar_video_channel_switch_option", localeqo.MOQ);
        if (localeqo.MOQ != 2) {
          break label727;
        }
        if (com.tencent.mm.plugin.brandservice.ui.b.c.b((com.tencent.mm.bw.a)localeqo.NnX, (com.tencent.mm.bw.a)clw())) {
          break label705;
        }
        bool2 = true;
        pna = localeqo.NnX;
        a(localeqo.NnX);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (clF())
          {
            paramqd = r.puL;
            paramqd = r.a.cmU();
            localObject1 = clG();
            p.h("vc", "type");
            p.h("__biz_video_channel_canvas_id__", "canvasId");
            p.h(localObject1, "data");
            Log.i(paramqd.TAG, "update #".concat(String.valueOf("__biz_video_channel_canvas_id__")));
            if (paramqd.IzF.containsKey("__biz_video_channel_canvas_id__")) {
              break label711;
            }
            com.tencent.mm.plugin.webcanvas.c.a(paramqd, "vc", "__biz_video_channel_canvas_id__", (String)localObject1);
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      paramqd = pmZ;
      CU(localeqo.MOQ);
      Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onUpdateBizVideoChannelStrategy oldEntry: %b, new: %b, isTopBarInfoChanged: %b", new Object[] { paramqd, pmZ, Boolean.valueOf(bool1) });
      if (((p.j(paramqd, pmZ) ^ true)) || (bool1))
      {
        i = localeqo.MOQ;
        paramqd = pna;
        Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onTopBarVideoChannelEntryChanged");
        localObject1 = new aq();
        ((aq)localObject1).dDA.dDB = i;
        if (paramqd != null) {
          ((aq)localObject1).dDA.dDC = paramqd;
        }
        EventCenter.instance.publish((IEvent)localObject1);
      }
      AppMethodBeat.o(175470);
      return;
      paramqd = null;
      break;
      label662:
      paramqd = null;
      break label104;
      label667:
      paramqd = null;
      break label136;
      label672:
      paramqd = null;
      break label173;
      label677:
      paramqd = null;
      break label202;
      label682:
      paramqd = null;
      break label234;
      label687:
      localObject1 = null;
      break label253;
      label693:
      localObject2 = null;
      break label272;
      label699:
      localObject3 = null;
      break label294;
      label705:
      bool2 = false;
      break label413;
      label711:
      com.tencent.mm.plugin.webcanvas.c.a(paramqd, "update", "__biz_video_channel_canvas_id__");
      bool1 = bool2;
      continue;
      label727:
      if ((localeqo.MOQ == 0) || (localeqo.MOQ == 1))
      {
        clx();
        bool1 = false;
      }
      else if (localeqo.MOQ == 3)
      {
        bool1 = false;
        clx();
        continue;
        AppMethodBeat.o(175470);
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public static MultiProcessMMKV aTI()
  {
    AppMethodBeat.i(175468);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)iBW.getValue();
    AppMethodBeat.o(175468);
    return localMultiProcessMMKV;
  }
  
  public static void b(b.b paramb)
  {
    AppMethodBeat.i(175477);
    d.a locala = new d.a();
    locala.c((com.tencent.mm.bw.a)new bqz());
    locala.d((com.tencent.mm.bw.a)new bra());
    locala.MB("/cgi-bin/mmbiz-bin/videochannel/getnotifyandchannelfeeds");
    locala.sG(1814);
    aa.a(locala.aXF(), (aa.a)new b(paramb));
    AppMethodBeat.o(175477);
  }
  
  public static boolean clA()
  {
    AppMethodBeat.i(195136);
    eqs localeqs = clw();
    if (localeqs == null)
    {
      AppMethodBeat.o(195136);
      return false;
    }
    if ((!Util.isNullOrNil(localeqs.Nob)) && (aTI().decodeInt("biz_video_channel_show_default_icon", 0) == 1))
    {
      AppMethodBeat.o(195136);
      return true;
    }
    AppMethodBeat.o(195136);
    return false;
  }
  
  public static String clD()
  {
    AppMethodBeat.i(195140);
    Object localObject = clw();
    if (localObject == null)
    {
      AppMethodBeat.o(195140);
      return "";
    }
    localObject = ((eqs)localObject).Noc;
    AppMethodBeat.o(195140);
    return localObject;
  }
  
  public static boolean clE()
  {
    AppMethodBeat.i(195141);
    eqs localeqs = clw();
    if ((localeqs != null) && (localeqs.Noi == 1))
    {
      AppMethodBeat.o(195141);
      return true;
    }
    AppMethodBeat.o(195141);
    return false;
  }
  
  public static boolean clF()
  {
    AppMethodBeat.i(195142);
    boolean bool = ((Boolean)pnd.getValue()).booleanValue();
    AppMethodBeat.o(195142);
    return bool;
  }
  
  public static String clG()
  {
    AppMethodBeat.i(195143);
    Object localObject = clw();
    if (localObject == null)
    {
      Log.w("MicroMsg.BizVideoChannelStrategy", "getProtoData topBarInfo is null");
      AppMethodBeat.o(195143);
      return "";
    }
    localObject = Base64.encode(((eqs)localObject).toByteArray(), 2);
    p.g(localObject, "Base64.encode(topBarInfo…eArray(), Base64.NO_WRAP)");
    Charset localCharset = StandardCharsets.UTF_8;
    p.g(localCharset, "StandardCharsets.UTF_8");
    localObject = new String((byte[])localObject, localCharset);
    AppMethodBeat.o(195143);
    return localObject;
  }
  
  public static final boolean clu()
  {
    AppMethodBeat.i(175471);
    if (com.tencent.mm.plugin.biz.b.c.cku())
    {
      AppMethodBeat.o(175471);
      return false;
    }
    Boolean localBoolean = pmZ;
    if (localBoolean == null) {
      p.hyc();
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175471);
    return bool;
  }
  
  public static final boolean clv()
  {
    AppMethodBeat.i(175472);
    Boolean localBoolean = pnb;
    if (localBoolean == null) {
      p.hyc();
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175472);
    return bool;
  }
  
  public static final eqs clw()
  {
    int j = 1;
    AppMethodBeat.i(175475);
    Object localObject1;
    int i;
    if (pna == null)
    {
      localObject1 = aTI();
      p.g(localObject1, "mmkv");
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
        Object localObject3 = eqs.class.newInstance();
        ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bw.a)localObject3;
        pna = (eqs)localObject1;
        localObject1 = pna;
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
  
  private static void clx()
  {
    AppMethodBeat.i(175476);
    try
    {
      aTI().encode("biz_video_channel_top_bar_info", new byte[0]);
      pna = null;
      AppMethodBeat.o(175476);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(175476);
    }
  }
  
  public static boolean clz()
  {
    AppMethodBeat.i(195135);
    eqs localeqs = clw();
    if (localeqs == null)
    {
      AppMethodBeat.o(195135);
      return false;
    }
    if ((localeqs.Nog & 0x10) != 0)
    {
      AppMethodBeat.o(195135);
      return true;
    }
    AppMethodBeat.o(195135);
    return false;
  }
  
  public static final void init()
  {
    boolean bool = true;
    AppMethodBeat.i(175469);
    int i = aTI().getInt("top_bar_video_channel_switch_option", 0);
    if (aTI().getInt("top_bar_video_channel_switch_option", 0) == 1) {}
    for (;;)
    {
      CU(i);
      E(bool, false);
      AppMethodBeat.o(175469);
      return;
      bool = false;
    }
  }
  
  public static final void release() {}
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(195144);
    h.CyF.n(1416L, paramLong, 1L);
    AppMethodBeat.o(195144);
  }
  
  public static void t(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(195134);
    Object localObject = clw();
    int i;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label141;
      }
      AppMethodBeat.o(195134);
      return;
      if ((paramInt == 2) && ((((eqs)localObject).Nog & 0x2) != 0))
      {
        i = 1;
      }
      else if (paramInt == 1)
      {
        if ((((eqs)localObject).Nog & 0x1) != 0) {
          i = 1;
        } else if ((((eqs)localObject).Nog == 0) && (aTI().decodeInt("biz_video_channel_show_default_icon", -1) == -1)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else if ((paramInt == 3) && ((((eqs)localObject).Nog & 0x4) != 0))
      {
        i = 1;
      }
      else
      {
        if ((paramInt != 4) || ((((eqs)localObject).Nog & 0x8) == 0)) {
          break;
        }
        i = 1;
      }
    }
    label141:
    long l2;
    if ((paramInt == 2) || (paramInt == 1)) {
      l2 = aTI().getLong("biz_video_channel_strategy_fetch_last_time", 0L);
    }
    for (long l1 = Math.max(aTI().getLong("biz_video_channel_strategy_fetch_interval", 1800000L), 300000L);; l1 = aTI().getLong("biz_video_channel_strategy_tl_fetch_interval", 1800000L))
    {
      l2 = Math.abs(System.currentTimeMillis() - l2);
      if (l2 >= l1) {
        break;
      }
      Log.i("MicroMsg.BizVideoChannelStrategy", "fetchBizStrategy delta < interval, return");
      AppMethodBeat.o(195134);
      return;
      l2 = aTI().getLong("biz_video_channel_strategy_tl_fetch_last_time", 0L);
    }
    localObject = new d.a();
    ((d.a)localObject).c((com.tencent.mm.bw.a)new qc());
    ((d.a)localObject).d((com.tencent.mm.bw.a)new qd());
    ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/timeline/bizstrategy");
    ((d.a)localObject).sG(1806);
    d locald = ((d.a)localObject).aXF();
    p.g(locald, "rr");
    localObject = locald.aYJ();
    if (localObject == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
      AppMethodBeat.o(195134);
      throw paramString1;
    }
    final qc localqc = (qc)localObject;
    localqc.ReqType = 8;
    eqp localeqp = new eqp();
    localeqp.NnZ = new eqt();
    eqt localeqt = localeqp.NnZ;
    localObject = clw();
    if (localObject != null) {}
    for (localObject = ((eqs)localObject).Noc;; localObject = null)
    {
      localeqt.Noc = ((String)localObject);
      localeqp.NnZ.KUC = paramString1;
      localeqp.NnZ.Noo = paramString2;
      localeqp.NnZ.scene = paramInt;
      localqc.KWV = localeqp;
      report(0L);
      aa.a(locald, (aa.a)new a(paramInt, localqc));
      Log.i("MicroMsg.BizVideoChannelStrategy", "preloadChannelStrategy %d", new Object[] { Long.valueOf(l2) });
      AppMethodBeat.o(195134);
      return;
    }
  }
  
  public final boolean clB()
  {
    AppMethodBeat.i(195137);
    eqs localeqs = clw();
    if (localeqs == null)
    {
      AppMethodBeat.o(195137);
      return false;
    }
    if ((clA()) || (Util.isEqual(localeqs.iwv, localeqs.Nob)))
    {
      AppMethodBeat.o(195137);
      return true;
    }
    AppMethodBeat.o(195137);
    return false;
  }
  
  public final boolean clC()
  {
    AppMethodBeat.i(195138);
    boolean bool = com.tencent.mm.vfs.s.YS(com.tencent.mm.pluginsdk.model.s.bdu(kj(false)));
    AppMethodBeat.o(195138);
    return bool;
  }
  
  public final String kj(boolean paramBoolean)
  {
    AppMethodBeat.i(195139);
    if ((Util.isNullOrNil(pmY)) || (paramBoolean))
    {
      localObject = clw();
      if (localObject == null)
      {
        AppMethodBeat.o(195139);
        return "";
      }
      if (!clA()) {
        break label75;
      }
    }
    label75:
    for (Object localObject = ((eqs)localObject).Nob;; localObject = ((eqs)localObject).iwv)
    {
      localObject = Util.nullAsNil((String)localObject);
      p.g(localObject, "Util.nullAsNil(if (isSho…else topBarInfo.logo_url)");
      pmY = (String)localObject;
      localObject = pmY;
      AppMethodBeat.o(195139);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements aa.a
  {
    a(int paramInt, qc paramqc) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(195125);
      Log.i("MicroMsg.BizVideoChannelStrategy", "fetchBizVideoChannelStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((this.pnf == 2) || (this.pnf == 1))
      {
        paramString = c.pne;
        c.clH().putLong("biz_video_channel_strategy_fetch_last_time", System.currentTimeMillis());
      }
      while ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = c.pne;
        c.report(2L);
        AppMethodBeat.o(195125);
        return 0;
        paramString = c.pne;
        c.clH().putLong("biz_video_channel_strategy_tl_fetch_last_time", System.currentTimeMillis());
      }
      p.g(paramd, "comReqResp");
      paramd = paramd.aYK();
      paramString = paramd;
      if (!(paramd instanceof qd)) {
        paramString = null;
      }
      paramString = (qd)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(195125);
        return 0;
      }
      paramd = paramString.KXa;
      if (paramd != null)
      {
        paramd = paramd.NnX;
        if ((paramd != null) && (paramd.Nod == 0))
        {
          Log.i("MicroMsg.BizVideoChannelStrategy", "sync_flag is 0, just return!");
          AppMethodBeat.o(195125);
          return 0;
        }
      }
      paramd = c.pne;
      c.report(1L);
      if ((localqc.ReqType & 0x8) != 0)
      {
        c.a(paramString);
        paramd = c.pne;
        c.b(this.pnf, paramString);
        paramd = c.pne;
        c.b(paramString);
      }
      AppMethodBeat.o(195125);
      return 0;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class b
    implements aa.a
  {
    b(b.b paramb) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(175464);
      Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo getNotifyAndChannelFeeds callback errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        p.g(paramd, "comReqResp");
        paramString = paramd.aYK();
        if (paramString != null)
        {
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetNotifyAndChannelFeedsResp");
            AppMethodBeat.o(175464);
            throw paramString;
          }
          paramString = ((bra)paramString).LYz;
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
        ((b)com.tencent.mm.kernel.g.af(b.class)).ahA(paramString);
        paramd = this.pnh;
        if (paramd != null) {
          paramd.onSuccess(paramString);
        }
        for (;;)
        {
          AppMethodBeat.o(175464);
          return 0;
          paramd = this.pnh;
          if (paramd != null) {
            paramd.p(paramInt1, paramInt2, paramString);
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final c pni;
    
    static
    {
      AppMethodBeat.i(195127);
      pni = new c();
      AppMethodBeat.o(195127);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(195130);
      Log.i("MicroMsg.BizVideoChannelStrategy", "preloadIcon start = %s", new Object[] { this.mkH });
      com.tencent.mm.av.a.a.c localc = new com.tencent.mm.av.a.a.c.a().bdt().ty(2131231405).bdp().OS(this.pnk).bdv();
      com.tencent.mm.av.q.bcV().a(this.mkH, null, localc, (k)1.pnl);
      AppMethodBeat.o(195130);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final f pnm;
    
    static
    {
      AppMethodBeat.i(195132);
      pnm = new f();
      AppMethodBeat.o(195132);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.c
 * JD-Core Version:    0.7.0.1
 */
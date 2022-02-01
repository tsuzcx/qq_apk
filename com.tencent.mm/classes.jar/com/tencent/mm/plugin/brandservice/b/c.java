package com.tencent.mm.plugin.brandservice.b;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.aw.a.c.k;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.plugin.brandservice.a.b.b;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.protocal.protobuf.dvq;
import com.tencent.mm.protocal.protobuf.dvr;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.f;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/model/BizVideoChannelStrategy;", "", "()V", "BIZ_PROFILE_VIDEO_CHANNEL_ENTRY_OPEN", "", "KEY_BIZ_VIDEO_CHANNEL_SHOW_DEFAULT_ICON", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_LAST_TIME", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_LAST_TIME", "TAG", "TOP_BAR_INFO", "TOP_BAR_VIDEO_CHANNEL_SWITCH_OPTION", "VIDEO_CHANNEL_FEEDS_DATA", "bizProfileEntryClientConfig", "", "isBizProfileEntryOpen", "", "Ljava/lang/Boolean;", "isTimelineTopBarEntryOpen", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "showingLogoUrl", "getShowingLogoUrl", "()Ljava/lang/String;", "setShowingLogoUrl", "(Ljava/lang/String;)V", "timelineTopBarEntryClientConfig", "timelineTopBarInfo", "Lcom/tencent/mm/protocal/protobuf/VideoChannelTopBarInfo;", "clearTopBarInfo", "", "fetchBizVideoChannelStrategy", "fromScene", "talker", "url", "getLogoUrl", "force", "getNotifyAndChannelFeeds", "updateCallback", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "getSyncBuffer", "getTopBarInfo", "init", "isPreloadOpen", "scene", "isShowDefaultIcon", "isShowingDefaultIcon", "isShowingIconCached", "isTimeLineTopBarEntryOpen", "isTopBarInfoChanged", "topBarInfo", "loadChannelIcon", "iconIV", "Landroid/widget/ImageView;", "onLogoClick", "onTopBarVideoChannelEntryChanged", "switchOption", "preloadChannelStrategy", "preloadIcon", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "release", "report", "key", "", "saveTopBarInfo", "top_bar_info", "shouldChaneDefaultLogoAfterClick", "update", "updateBizProfileEntryStatus", "isEntryOpen", "needSave", "updateInterval", "updateTimelineTopBarEntryStatus", "VideoChannelSwitchOption", "VideoChannelTopBarControlBit", "plugin-brandservice_release"})
public final class c
{
  private static final f nOP;
  private static String nWs;
  private static Boolean nWt;
  private static int nWu;
  private static dvq nWv;
  private static Boolean nWw;
  private static int nWx;
  public static final c nWy;
  
  static
  {
    AppMethodBeat.i(175467);
    nWy = new c();
    nWs = "";
    nOP = d.g.O((d.g.a.a)c.c.nWC);
    AppMethodBeat.o(175467);
  }
  
  public static final void F(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(175474);
    if ((paramBoolean1) && (nWx == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      nWw = Boolean.valueOf(bool);
      if (paramBoolean2) {
        bNe().putInt("biz_profile_video_channel_entry_open", 1);
      }
      ad.i("MicroMsg.BizVideoChannelStrategy", "alvinluo updateBizProfileEntryStatus bizProfileEntryClientConfig: %d, server isEntryOpen: %b, isBizProfileEntryOpen: %b, needSave: %b", new Object[] { Integer.valueOf(nWx), Boolean.valueOf(paramBoolean1), nWw, Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(175474);
      return;
    }
  }
  
  public static void a(dvq paramdvq)
  {
    AppMethodBeat.i(209659);
    try
    {
      ax localax = bNe();
      if (paramdvq != null)
      {
        byte[] arrayOfByte = paramdvq.toByteArray();
        paramdvq = arrayOfByte;
        if (arrayOfByte != null) {}
      }
      else
      {
        paramdvq = new byte[0];
      }
      localax.encode("biz_video_channel_top_bar_info", paramdvq);
      AppMethodBeat.o(209659);
      return;
    }
    catch (Exception paramdvq)
    {
      AppMethodBeat.o(209659);
    }
  }
  
  public static final void a(pe parampe)
  {
    Integer localInteger = null;
    AppMethodBeat.i(175470);
    p.h(parampe, "resp");
    int i = bNe().getInt("top_bar_video_channel_switch_option", 0);
    dvm localdvm = parampe.FKv;
    Object localObject2;
    Object localObject1;
    label101:
    Object localObject3;
    label142:
    label163:
    label184:
    Object localObject4;
    label208:
    boolean bool;
    if (localdvm != null)
    {
      localObject2 = new StringBuilder("alvinluo onUpdateBizVideoChannelStrategy localSwitchOption: %d, switch_option: %d, appId: %s, title: %s, logo: %s, version: %d, funcVersion: %d, default_logo_url: ");
      localObject1 = localdvm.HHS;
      if (localObject1 != null)
      {
        localObject1 = ((dvq)localObject1).HHW;
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(", control_bits: ");
        localObject1 = localdvm.HHS;
        if (localObject1 == null) {
          break label477;
        }
        localObject1 = Integer.valueOf(((dvq)localObject1).HIb);
        String str = localObject1;
        int j = parampe.FKv.HHR;
        localObject1 = parampe.FKv.HHS;
        if (localObject1 == null) {
          break label483;
        }
        localObject1 = ((dvq)localObject1).duW;
        localObject2 = parampe.FKv.HHS;
        if (localObject2 == null) {
          break label489;
        }
        localObject2 = ((dvq)localObject2).title;
        localObject3 = parampe.FKv.HHS;
        if (localObject3 == null) {
          break label495;
        }
        localObject3 = ((dvq)localObject3).hzB;
        localObject4 = parampe.FKv.HHS;
        if (localObject4 == null) {
          break label501;
        }
        localObject4 = Integer.valueOf(((dvq)localObject4).version);
        dvq localdvq = parampe.FKv.HHS;
        if (localdvq != null) {
          localInteger = Integer.valueOf(localdvq.HHV);
        }
        ad.i("MicroMsg.BizVideoChannelStrategy", str, new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject1, localObject2, localObject3, localObject4, localInteger });
        bNe().putInt("top_bar_video_channel_switch_option", localdvm.HHR);
        if (localdvm.HHR != 2) {
          break label512;
        }
        if (com.tencent.mm.plugin.brandservice.ui.b.c.b((com.tencent.mm.bx.a)localdvm.HHS, (com.tencent.mm.bx.a)bNx())) {
          break label507;
        }
        bool = true;
        label329:
        a(localdvm.HHS);
        nWv = parampe.FKv.HHS;
      }
    }
    for (;;)
    {
      parampe = nWt;
      zg(localdvm.HHR);
      ad.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onUpdateBizVideoChannelStrategy oldEntry: %b, new: %b, isTopBarInfoChanged: %b", new Object[] { parampe, nWt, Boolean.valueOf(bool) });
      if (((p.i(parampe, nWt) ^ true)) || (bool))
      {
        i = localdvm.HHR;
        parampe = nWv;
        ad.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onTopBarVideoChannelEntryChanged");
        localObject1 = new ao();
        ((ao)localObject1).dli.dlj = i;
        if (parampe != null) {
          ((ao)localObject1).dli.dlk = parampe;
        }
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      AppMethodBeat.o(175470);
      return;
      localObject1 = null;
      break;
      label477:
      localObject1 = null;
      break label101;
      label483:
      localObject1 = null;
      break label142;
      label489:
      localObject2 = null;
      break label163;
      label495:
      localObject3 = null;
      break label184;
      label501:
      localObject4 = null;
      break label208;
      label507:
      bool = false;
      break label329;
      label512:
      if ((localdvm.HHR == 0) || (localdvm.HHR == 1))
      {
        bNy();
        bool = false;
      }
      else if (localdvm.HHR == 3)
      {
        bool = false;
        bNy();
        continue;
        AppMethodBeat.o(175470);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public static void b(b.b paramb)
  {
    AppMethodBeat.i(175477);
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.c((com.tencent.mm.bx.a)new ben());
    locala.d((com.tencent.mm.bx.a)new beo());
    locala.Dl("/cgi-bin/mmbiz-bin/videochannel/getnotifyandchannelfeeds");
    locala.oP(1814);
    x.a(locala.aDC(), (x.a)new c.b(paramb));
    AppMethodBeat.o(175477);
  }
  
  public static boolean bNA()
  {
    AppMethodBeat.i(209661);
    dvq localdvq = bNx();
    if (localdvq == null)
    {
      AppMethodBeat.o(209661);
      return false;
    }
    if ((localdvq.HIb & 0x10) != 0)
    {
      AppMethodBeat.o(209661);
      return true;
    }
    AppMethodBeat.o(209661);
    return false;
  }
  
  public static boolean bNB()
  {
    AppMethodBeat.i(209662);
    dvq localdvq = bNx();
    if (localdvq == null)
    {
      AppMethodBeat.o(209662);
      return false;
    }
    if ((!bt.isNullOrNil(localdvq.HHW)) && (bNe().decodeInt("biz_video_channel_show_default_icon", 0) == 1))
    {
      AppMethodBeat.o(209662);
      return true;
    }
    AppMethodBeat.o(209662);
    return false;
  }
  
  public static boolean bNC()
  {
    AppMethodBeat.i(209663);
    dvq localdvq = bNx();
    if (localdvq == null)
    {
      AppMethodBeat.o(209663);
      return false;
    }
    if ((bNB()) || (bt.lQ(localdvq.hzB, localdvq.HHW)))
    {
      AppMethodBeat.o(209663);
      return true;
    }
    AppMethodBeat.o(209663);
    return false;
  }
  
  public static boolean bND()
  {
    AppMethodBeat.i(209664);
    boolean bool = i.fv(r.aLC(jl(false)));
    AppMethodBeat.o(209664);
    return bool;
  }
  
  public static String bNE()
  {
    AppMethodBeat.i(209666);
    Object localObject = bNx();
    if (localObject == null)
    {
      AppMethodBeat.o(209666);
      return "";
    }
    localObject = ((dvq)localObject).HHX;
    AppMethodBeat.o(209666);
    return localObject;
  }
  
  public static ax bNe()
  {
    AppMethodBeat.i(175468);
    ax localax = (ax)nOP.getValue();
    AppMethodBeat.o(175468);
    return localax;
  }
  
  public static final boolean bNv()
  {
    AppMethodBeat.i(175471);
    if (com.tencent.mm.plugin.biz.b.b.bMA())
    {
      AppMethodBeat.o(175471);
      return false;
    }
    Boolean localBoolean = nWt;
    if (localBoolean == null) {
      p.gfZ();
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175471);
    return bool;
  }
  
  public static final boolean bNw()
  {
    AppMethodBeat.i(175472);
    Boolean localBoolean = nWw;
    if (localBoolean == null) {
      p.gfZ();
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175472);
    return bool;
  }
  
  public static final dvq bNx()
  {
    int j = 1;
    AppMethodBeat.i(175475);
    Object localObject1;
    int i;
    if (nWv == null)
    {
      localObject1 = bNe();
      p.g(localObject1, "mmkv");
      if (!((ax)localObject1).containsKey("biz_video_channel_top_bar_info")) {
        break label129;
      }
      localObject1 = ((ax)localObject1).decodeBytes("biz_video_channel_top_bar_info");
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
        Object localObject3 = dvq.class.newInstance();
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bx.a)localObject3;
        nWv = (dvq)localObject1;
        localObject1 = nWv;
        AppMethodBeat.o(175475);
        return localObject1;
      }
      catch (Exception localException)
      {
        label101:
        label106:
        ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label58;
      label129:
      Object localObject2 = null;
    }
  }
  
  private static void bNy()
  {
    AppMethodBeat.i(175476);
    try
    {
      bNe().encode("biz_video_channel_top_bar_info", new byte[0]);
      nWv = null;
      AppMethodBeat.o(175476);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(175476);
    }
  }
  
  public static boolean e(ImageView paramImageView)
  {
    AppMethodBeat.i(209667);
    p.h(paramImageView, "iconIV");
    if (bt.isNullOrNil(jl(true)))
    {
      AppMethodBeat.o(209667);
      return false;
    }
    String str = r.aLC(nWs);
    if (bNB()) {
      if (!i.fv(str)) {
        report(15L);
      }
    }
    for (;;)
    {
      q.aIJ().a(nWs, paramImageView, new com.tencent.mm.aw.a.a.c.a().aJa().pH(2131231342).aIY().FE(str).aJc());
      AppMethodBeat.o(209667);
      return true;
      report(16L);
      continue;
      if (!i.fv(str)) {
        report(17L);
      } else {
        report(18L);
      }
    }
  }
  
  public static final void init()
  {
    AppMethodBeat.i(175469);
    nWu = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBu, 0);
    nWx = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBv, 0);
    int i = bNe().getInt("top_bar_video_channel_switch_option", 0);
    if (bNe().getInt("top_bar_video_channel_switch_option", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      zg(i);
      F(bool, false);
      AppMethodBeat.o(175469);
      return;
    }
  }
  
  public static String jl(boolean paramBoolean)
  {
    AppMethodBeat.i(209665);
    if ((bt.isNullOrNil(nWs)) || (paramBoolean))
    {
      localObject = bNx();
      if (localObject == null)
      {
        AppMethodBeat.o(209665);
        return "";
      }
      if (!bNB()) {
        break label75;
      }
    }
    label75:
    for (Object localObject = ((dvq)localObject).HHW;; localObject = ((dvq)localObject).hzB)
    {
      localObject = bt.nullAsNil((String)localObject);
      p.g(localObject, "Util.nullAsNil(if (isSho…else topBarInfo.logo_url)");
      nWs = (String)localObject;
      localObject = nWs;
      AppMethodBeat.o(209665);
      return localObject;
    }
  }
  
  public static final void release() {}
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(209668);
    com.tencent.mm.plugin.report.service.g.yhR.n(1416L, paramLong, 1L);
    AppMethodBeat.o(209668);
  }
  
  public static void s(final int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(209660);
    Object localObject = bNx();
    int i;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label142;
      }
      AppMethodBeat.o(209660);
      return;
      if ((paramInt == 2) && ((((dvq)localObject).HIb & 0x2) != 0))
      {
        i = 1;
      }
      else if (paramInt == 1)
      {
        if ((((dvq)localObject).HIb & 0x1) != 0) {
          i = 1;
        } else if ((((dvq)localObject).HIb == 0) && (bNe().decodeInt("biz_video_channel_show_default_icon", -1) == -1)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else if ((paramInt == 3) && ((((dvq)localObject).HIb & 0x4) != 0))
      {
        i = 1;
      }
      else
      {
        if ((paramInt != 4) || ((((dvq)localObject).HIb & 0x8) == 0)) {
          break;
        }
        i = 1;
      }
    }
    label142:
    long l2;
    if ((paramInt == 2) || (paramInt == 1)) {
      l2 = bNe().getLong("biz_video_channel_strategy_fetch_last_time", 0L);
    }
    for (long l1 = Math.max(bNe().getLong("biz_video_channel_strategy_fetch_interval", 1800000L), 300000L);; l1 = bNe().getLong("biz_video_channel_strategy_tl_fetch_interval", 1800000L))
    {
      l2 = Math.abs(System.currentTimeMillis() - l2);
      if (l2 >= l1) {
        break;
      }
      ad.i("MicroMsg.BizVideoChannelStrategy", "fetchBizStrategy delta < interval, return");
      AppMethodBeat.o(209660);
      return;
      l2 = bNe().getLong("biz_video_channel_strategy_tl_fetch_last_time", 0L);
    }
    localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).c((com.tencent.mm.bx.a)new pd());
    ((com.tencent.mm.al.b.a)localObject).d((com.tencent.mm.bx.a)new pe());
    ((com.tencent.mm.al.b.a)localObject).Dl("/cgi-bin/mmbiz-bin/timeline/bizstrategy");
    ((com.tencent.mm.al.b.a)localObject).oP(1806);
    com.tencent.mm.al.b localb = ((com.tencent.mm.al.b.a)localObject).aDC();
    p.g(localb, "rr");
    localObject = localb.aEE();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
      AppMethodBeat.o(209660);
      throw paramString1;
    }
    pd localpd = (pd)localObject;
    localpd.ReqType = 8;
    dvn localdvn = new dvn();
    localdvn.HHU = new dvr();
    dvr localdvr = localdvn.HHU;
    localObject = bNx();
    if (localObject != null) {}
    for (localObject = ((dvq)localObject).HHX;; localObject = null)
    {
      localdvr.HHX = ((String)localObject);
      localdvn.HHU.FIk = paramString1;
      localdvn.HHU.HId = paramString2;
      localdvn.HHU.scene = paramInt;
      localpd.FKq = localdvn;
      report(0L);
      x.a(localb, (x.a)new a(localpd, paramInt));
      ad.i("MicroMsg.BizVideoChannelStrategy", "preloadChannelStrategy %d", new Object[] { Long.valueOf(l2) });
      AppMethodBeat.o(209660);
      return;
    }
  }
  
  private static void zg(int paramInt)
  {
    AppMethodBeat.i(175473);
    if ((paramInt == 2) && (nWu == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      nWt = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizVideoChannelStrategy", "alvinluo updateTimelineTopBarEntryStatus timelineTopBarEntryClientConfig: %d, server switchOption: %d, isTimelineTopBarEntryOpen: %b", new Object[] { Integer.valueOf(nWu), Integer.valueOf(paramInt), nWt });
      AppMethodBeat.o(175473);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements x.a
  {
    a(pd parampd, int paramInt) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb, n paramn)
    {
      AppMethodBeat.i(209655);
      ad.i("MicroMsg.BizVideoChannelStrategy", "fetchBizVideoChannelStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = c.nWy;
        c.report(2L);
        AppMethodBeat.o(209655);
        return 0;
      }
      p.g(paramb, "comReqResp");
      paramb = paramb.aEF();
      paramString = paramb;
      if (!(paramb instanceof pe)) {
        paramString = null;
      }
      paramString = (pe)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(209655);
        return 0;
      }
      paramb = paramString.FKv;
      if (paramb != null)
      {
        paramb = paramb.HHS;
        if ((paramb != null) && (paramb.HHY == 0))
        {
          ad.i("MicroMsg.BizVideoChannelStrategy", "sync_flag is 0, just return!");
          AppMethodBeat.o(209655);
          return 0;
        }
      }
      paramb = c.nWy;
      c.report(1L);
      if ((this.nWz.ReqType & 0x8) != 0)
      {
        c.a(paramString);
        paramb = c.nWy;
        c.b(paramInt, paramString);
        paramb = c.nWy;
        c.b(paramString);
        paramString = c.nWy;
        c.bNF().encode("biz_video_channel_show_default_icon", 0);
      }
      AppMethodBeat.o(209655);
      return 0;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(209658);
      ad.i("MicroMsg.BizVideoChannelStrategy", "preloadIcon start = %s", new Object[] { this.lby });
      com.tencent.mm.aw.a.a.c localc = new com.tencent.mm.aw.a.a.c.a().aJa().pH(2131231342).aIY().FE(this.nWD).aJc();
      q.aIJ().a(this.lby, null, localc, (k)1.nWE);
      AppMethodBeat.o(209658);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.c
 * JD-Core Version:    0.7.0.1
 */
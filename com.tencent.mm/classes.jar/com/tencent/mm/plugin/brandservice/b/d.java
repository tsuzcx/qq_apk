package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.g.a.an;
import com.tencent.mm.plugin.brandservice.a.b.b;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/model/BizVideoChannelStrategy;", "", "()V", "BIZ_PROFILE_VIDEO_CHANNEL_ENTRY_OPEN", "", "TAG", "TOP_BAR_APP_ID", "TOP_BAR_APP_VERSION", "TOP_BAR_FUNC_VERSION", "TOP_BAR_LOGO_URL", "TOP_BAR_TITLE", "TOP_BAR_VIDEO_CHANNEL_SWITCH_OPTION", "VIDEO_CHANNEL_FEEDS_DATA", "bizProfileEntryClientConfig", "", "isBizProfileEntryOpen", "", "Ljava/lang/Boolean;", "isTimelineTopBarEntryOpen", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "timelineTopBarEntryClientConfig", "timelineTopBarInfo", "Lcom/tencent/mm/protocal/protobuf/VideoChannelTopBarInfo;", "clearTopBarInfo", "", "getNotifyAndChannelFeeds", "updateCallback", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "getTopBarInfo", "init", "isTimeLineTopBarEntryOpen", "isTopBarInfoChanged", "topBarInfo", "onTopBarVideoChannelEntryChanged", "switchOption", "release", "update", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "updateBizProfileEntryStatus", "isEntryOpen", "needSave", "updateTimelineTopBarEntryStatus", "VideoChannelSwitchOption", "plugin-brandservice_release"})
public final class d
{
  private static final f mSD;
  private static Boolean mSH;
  private static int mSI;
  private static dkj mSJ;
  private static Boolean mSK;
  private static int mSL;
  public static final d mSM;
  
  static
  {
    AppMethodBeat.i(175467);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(d.class), "mmkv", "getMmkv()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    mSM = new d();
    mSD = d.g.E((d.g.a.a)d.b.mSO);
    AppMethodBeat.o(175467);
  }
  
  public static final void D(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(175474);
    if ((paramBoolean1) && (mSL == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      mSK = Boolean.valueOf(bool);
      if (paramBoolean2) {
        bCc().putInt("biz_profile_video_channel_entry_open", 1);
      }
      ad.i("MicroMsg.BizVideoChannelStrategy", "alvinluo updateBizProfileEntryStatus bizProfileEntryClientConfig: %d, server isEntryOpen: %b, isBizProfileEntryOpen: %b, needSave: %b", new Object[] { Integer.valueOf(mSL), Boolean.valueOf(paramBoolean1), mSK, Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(175474);
      return;
    }
  }
  
  public static final void a(ns paramns)
  {
    Integer localInteger = null;
    AppMethodBeat.i(175470);
    d.g.b.k.h(paramns, "resp");
    int i = bCc().getInt("top_bar_video_channel_switch_option", 0);
    dkg localdkg = paramns.CLt;
    Object localObject1;
    Object localObject2;
    label85:
    Object localObject3;
    label106:
    Object localObject4;
    label130:
    boolean bool;
    if (localdkg != null)
    {
      int j = paramns.CLt.EzX;
      localObject1 = paramns.CLt.EzY;
      if (localObject1 != null)
      {
        localObject1 = ((dkj)localObject1).dlB;
        localObject2 = paramns.CLt.EzY;
        if (localObject2 == null) {
          break label734;
        }
        localObject2 = ((dkj)localObject2).title;
        localObject3 = paramns.CLt.EzY;
        if (localObject3 == null) {
          break label740;
        }
        localObject3 = ((dkj)localObject3).gGR;
        localObject4 = paramns.CLt.EzY;
        if (localObject4 == null) {
          break label746;
        }
        localObject4 = Integer.valueOf(((dkj)localObject4).version);
        dkj localdkj = paramns.CLt.EzY;
        if (localdkj != null) {
          localInteger = Integer.valueOf(localdkj.EAa);
        }
        ad.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onUpdateBizVideoChannelStrategy localSwitchOption: %d, switch_option: %d, appId: %s, title: %s, logo: %s, version: %d, funcVersion: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject1, localObject2, localObject3, localObject4, localInteger });
        bCc().putInt("top_bar_video_channel_switch_option", localdkg.EzX);
        if (localdkg.EzX != 2) {
          break label767;
        }
        localObject1 = localdkg.EzY;
        if ((localObject1 == null) || ((bt.kU(((dkj)localObject1).title, bCc().getString("top_bar_title", ""))) && (bt.kU(((dkj)localObject1).dlB, bCc().getString("top_bar_app_id", ""))) && (bt.kU(((dkj)localObject1).gGR, bCc().getString("top_bar_logo_url", ""))) && (((dkj)localObject1).version == bCc().getInt("top_bar_app_version", 0)) && (((dkj)localObject1).EAa == bCc().getInt("top_bar_func_version", 0)))) {
          break label752;
        }
        bool = true;
        label340:
        localObject3 = bCc();
        localObject1 = localdkg.EzY;
        if (localObject1 != null)
        {
          localObject2 = ((dkj)localObject1).title;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        ((ax)localObject3).putString("top_bar_title", (String)localObject1);
        localObject3 = bCc();
        localObject1 = localdkg.EzY;
        if (localObject1 != null)
        {
          localObject2 = ((dkj)localObject1).dlB;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        ((ax)localObject3).putString("top_bar_app_id", (String)localObject1);
        localObject3 = bCc();
        localObject1 = localdkg.EzY;
        if (localObject1 != null)
        {
          localObject2 = ((dkj)localObject1).gGR;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        ((ax)localObject3).putString("top_bar_logo_url", (String)localObject1);
        localObject1 = bCc();
        localObject2 = localdkg.EzY;
        if (localObject2 == null) {
          break label757;
        }
        i = ((dkj)localObject2).version;
        label504:
        ((ax)localObject1).putInt("top_bar_app_version", i);
        localObject1 = bCc();
        localObject2 = localdkg.EzY;
        if (localObject2 == null) {
          break label762;
        }
        i = ((dkj)localObject2).EAa;
        label536:
        ((ax)localObject1).putInt("top_bar_func_version", i);
        mSJ = paramns.CLt.EzY;
      }
    }
    for (;;)
    {
      paramns = mSH;
      xE(localdkg.EzX);
      ad.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onUpdateBizVideoChannelStrategy oldEntry: %b, new: %b, isTopBarInfoChanged: %b", new Object[] { paramns, mSH, Boolean.valueOf(bool) });
      if (((d.g.b.k.g(paramns, mSH) ^ true)) || (bool))
      {
        i = localdkg.EzX;
        paramns = mSJ;
        ad.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onTopBarVideoChannelEntryChanged");
        localObject1 = new an();
        ((an)localObject1).dcr.dcs = i;
        if (paramns != null)
        {
          ((an)localObject1).dcr.appId = paramns.dlB;
          ((an)localObject1).dcr.title = paramns.title;
          ((an)localObject1).dcr.dct = paramns.gGR;
          ((an)localObject1).dcr.version = paramns.version;
          ((an)localObject1).dcr.dcu = paramns.EAa;
        }
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      AppMethodBeat.o(175470);
      return;
      localObject1 = null;
      break;
      label734:
      localObject2 = null;
      break label85;
      label740:
      localObject3 = null;
      break label106;
      label746:
      localObject4 = null;
      break label130;
      label752:
      bool = false;
      break label340;
      label757:
      i = 0;
      break label504;
      label762:
      i = 0;
      break label536;
      label767:
      if ((localdkg.EzX == 0) || (localdkg.EzX == 1))
      {
        bCi();
        bool = false;
      }
      else if (localdkg.EzX == 3)
      {
        bool = false;
        bCi();
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
    locala.c((com.tencent.mm.bx.a)new awr());
    locala.d((com.tencent.mm.bx.a)new aws());
    locala.wg("/cgi-bin/mmbiz-bin/videochannel/getnotifyandchannelfeeds");
    locala.nB(1814);
    x.a(locala.atI(), (x.a)new d.a(paramb));
    AppMethodBeat.o(175477);
  }
  
  private static ax bCc()
  {
    AppMethodBeat.i(175468);
    ax localax = (ax)mSD.getValue();
    AppMethodBeat.o(175468);
    return localax;
  }
  
  public static final boolean bCf()
  {
    AppMethodBeat.i(175471);
    Boolean localBoolean = mSH;
    if (localBoolean == null) {
      d.g.b.k.fvU();
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175471);
    return bool;
  }
  
  public static final boolean bCg()
  {
    AppMethodBeat.i(175472);
    Boolean localBoolean = mSK;
    if (localBoolean == null) {
      d.g.b.k.fvU();
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175472);
    return bool;
  }
  
  public static final dkj bCh()
  {
    AppMethodBeat.i(175475);
    if (mSJ == null)
    {
      localdkj = new dkj();
      mSJ = localdkj;
      localdkj.title = bCc().getString("top_bar_title", "");
      localdkj = mSJ;
      if (localdkj == null) {
        d.g.b.k.fvU();
      }
      localdkj.dlB = bCc().getString("top_bar_app_id", "");
      localdkj = mSJ;
      if (localdkj == null) {
        d.g.b.k.fvU();
      }
      localdkj.gGR = bCc().getString("top_bar_logo_url", "");
      localdkj = mSJ;
      if (localdkj == null) {
        d.g.b.k.fvU();
      }
      localdkj.version = bCc().getInt("top_bar_app_version", 0);
      localdkj = mSJ;
      if (localdkj == null) {
        d.g.b.k.fvU();
      }
      localdkj.EAa = bCc().getInt("top_bar_func_version", 0);
    }
    dkj localdkj = mSJ;
    AppMethodBeat.o(175475);
    return localdkj;
  }
  
  private static void bCi()
  {
    AppMethodBeat.i(175476);
    bCc().putString("top_bar_title", "");
    bCc().putString("top_bar_app_id", "");
    bCc().putString("top_bar_logo_url", "");
    bCc().putInt("top_bar_app_version", 0);
    bCc().putInt("top_bar_func_version", 0);
    mSJ = null;
    AppMethodBeat.o(175476);
  }
  
  public static final void init()
  {
    AppMethodBeat.i(175469);
    mSI = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.psn, 0);
    mSL = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pso, 0);
    int i = bCc().getInt("top_bar_video_channel_switch_option", 0);
    if (bCc().getInt("top_bar_video_channel_switch_option", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      xE(i);
      D(bool, false);
      AppMethodBeat.o(175469);
      return;
    }
  }
  
  public static final void release() {}
  
  private static void xE(int paramInt)
  {
    AppMethodBeat.i(175473);
    if ((paramInt == 2) && (mSI == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      mSH = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizVideoChannelStrategy", "alvinluo updateTimelineTopBarEntryStatus timelineTopBarEntryClientConfig: %d, server switchOption: %d, isTimelineTopBarEntryOpen: %b", new Object[] { Integer.valueOf(mSI), Integer.valueOf(paramInt), mSH });
      AppMethodBeat.o(175473);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.brandservice.b;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.plugin.brandservice.a.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.dpv;
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.protocal.protobuf.dpz;
import com.tencent.mm.protocal.protobuf.dqa;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/model/BizVideoChannelStrategy;", "", "()V", "BIZ_PROFILE_VIDEO_CHANNEL_ENTRY_OPEN", "", "KEY_BIZ_VIDEO_CHANNEL_SHOW_DEFAULT_ICON", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_LAST_TIME", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_LAST_TIME", "TAG", "TOP_BAR_INFO", "TOP_BAR_VIDEO_CHANNEL_SWITCH_OPTION", "VIDEO_CHANNEL_FEEDS_DATA", "bizProfileEntryClientConfig", "", "isBizProfileEntryOpen", "", "Ljava/lang/Boolean;", "isTimelineTopBarEntryOpen", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "showingLogoUrl", "getShowingLogoUrl", "()Ljava/lang/String;", "setShowingLogoUrl", "(Ljava/lang/String;)V", "timelineTopBarEntryClientConfig", "timelineTopBarInfo", "Lcom/tencent/mm/protocal/protobuf/VideoChannelTopBarInfo;", "clearTopBarInfo", "", "fetchBizVideoChannelStrategy", "fromScene", "talker", "url", "getLogoUrl", "force", "getNotifyAndChannelFeeds", "updateCallback", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "getSyncBuffer", "getTopBarInfo", "init", "isPreloadOpen", "scene", "isShowDefaultIcon", "isShowingIconCached", "isTimeLineTopBarEntryOpen", "isTopBarInfoChanged", "topBarInfo", "loadChannelIcon", "iconIV", "Landroid/widget/ImageView;", "onLogoClick", "onTopBarVideoChannelEntryChanged", "switchOption", "preloadChannelStrategy", "preloadIcon", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "release", "report", "key", "", "saveTopBarInfo", "top_bar_info", "shouldChaneDefaultLogoAfterClick", "update", "updateBizProfileEntryStatus", "isEntryOpen", "needSave", "updateInterval", "updateTimelineTopBarEntryStatus", "VideoChannelSwitchOption", "VideoChannelTopBarControlBit", "plugin-brandservice_release"})
public final class c
{
  private static final f nuQ;
  private static String nuU;
  private static Boolean nuV;
  private static int nuW;
  private static dpz nuX;
  private static Boolean nuY;
  private static int nuZ;
  public static final c nva;
  
  static
  {
    AppMethodBeat.i(175467);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(c.class), "mmkv", "getMmkv()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    nva = new c();
    nuU = "";
    nuQ = d.g.K((d.g.a.a)c.c.nve);
    AppMethodBeat.o(175467);
  }
  
  public static final void E(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(175474);
    if ((paramBoolean1) && (nuZ == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      nuY = Boolean.valueOf(bool);
      if (paramBoolean2) {
        bJa().putInt("biz_profile_video_channel_entry_open", 1);
      }
      ac.i("MicroMsg.BizVideoChannelStrategy", "alvinluo updateBizProfileEntryStatus bizProfileEntryClientConfig: %d, server isEntryOpen: %b, isBizProfileEntryOpen: %b, needSave: %b", new Object[] { Integer.valueOf(nuZ), Boolean.valueOf(paramBoolean1), nuY, Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(175474);
      return;
    }
  }
  
  public static void a(dpz paramdpz)
  {
    AppMethodBeat.i(198820);
    try
    {
      aw localaw = bJa();
      if (paramdpz != null)
      {
        byte[] arrayOfByte = paramdpz.toByteArray();
        paramdpz = arrayOfByte;
        if (arrayOfByte != null) {}
      }
      else
      {
        paramdpz = new byte[0];
      }
      localaw.encode("biz_video_channel_top_bar_info", paramdpz);
      AppMethodBeat.o(198820);
      return;
    }
    catch (Exception paramdpz)
    {
      AppMethodBeat.o(198820);
    }
  }
  
  public static final void a(nz paramnz)
  {
    Integer localInteger = null;
    AppMethodBeat.i(175470);
    d.g.b.k.h(paramnz, "resp");
    int i = bJa().getInt("top_bar_video_channel_switch_option", 0);
    dpv localdpv = paramnz.EdW;
    Object localObject2;
    Object localObject1;
    label102:
    Object localObject3;
    label143:
    label164:
    label185:
    Object localObject4;
    label209:
    boolean bool;
    if (localdpv != null)
    {
      localObject2 = new StringBuilder("alvinluo onUpdateBizVideoChannelStrategy localSwitchOption: %d, switch_option: %d, appId: %s, title: %s, logo: %s, version: %d, funcVersion: %d, default_logo_url: ");
      localObject1 = localdpv.FXc;
      if (localObject1 != null)
      {
        localObject1 = ((dpz)localObject1).FXg;
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(", control_bits: ");
        localObject1 = localdpv.FXc;
        if (localObject1 == null) {
          break label478;
        }
        localObject1 = Integer.valueOf(((dpz)localObject1).FXl);
        String str = localObject1;
        int j = paramnz.EdW.FXb;
        localObject1 = paramnz.EdW.FXc;
        if (localObject1 == null) {
          break label484;
        }
        localObject1 = ((dpz)localObject1).djj;
        localObject2 = paramnz.EdW.FXc;
        if (localObject2 == null) {
          break label490;
        }
        localObject2 = ((dpz)localObject2).title;
        localObject3 = paramnz.EdW.FXc;
        if (localObject3 == null) {
          break label496;
        }
        localObject3 = ((dpz)localObject3).hhs;
        localObject4 = paramnz.EdW.FXc;
        if (localObject4 == null) {
          break label502;
        }
        localObject4 = Integer.valueOf(((dpz)localObject4).version);
        dpz localdpz = paramnz.EdW.FXc;
        if (localdpz != null) {
          localInteger = Integer.valueOf(localdpz.FXf);
        }
        ac.i("MicroMsg.BizVideoChannelStrategy", str, new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject1, localObject2, localObject3, localObject4, localInteger });
        bJa().putInt("top_bar_video_channel_switch_option", localdpv.FXb);
        if (localdpv.FXb != 2) {
          break label513;
        }
        if (com.tencent.mm.plugin.brandservice.ui.b.c.b((com.tencent.mm.bw.a)localdpv.FXc, (com.tencent.mm.bw.a)bJf())) {
          break label508;
        }
        bool = true;
        label330:
        a(localdpv.FXc);
        nuX = paramnz.EdW.FXc;
      }
    }
    for (;;)
    {
      paramnz = nuV;
      yw(localdpv.FXb);
      ac.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onUpdateBizVideoChannelStrategy oldEntry: %b, new: %b, isTopBarInfoChanged: %b", new Object[] { paramnz, nuV, Boolean.valueOf(bool) });
      if (((d.g.b.k.g(paramnz, nuV) ^ true)) || (bool))
      {
        i = localdpv.FXb;
        paramnz = nuX;
        ac.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onTopBarVideoChannelEntryChanged");
        localObject1 = new ao();
        ((ao)localObject1).cZQ.cZR = i;
        if (paramnz != null) {
          ((ao)localObject1).cZQ.cZS = paramnz;
        }
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      AppMethodBeat.o(175470);
      return;
      localObject1 = null;
      break;
      label478:
      localObject1 = null;
      break label102;
      label484:
      localObject1 = null;
      break label143;
      label490:
      localObject2 = null;
      break label164;
      label496:
      localObject3 = null;
      break label185;
      label502:
      localObject4 = null;
      break label209;
      label508:
      bool = false;
      break label330;
      label513:
      if ((localdpv.FXb == 0) || (localdpv.FXb == 1))
      {
        bJg();
        bool = false;
      }
      else if (localdpv.FXb == 3)
      {
        bool = false;
        bJg();
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
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.c((com.tencent.mm.bw.a)new baj());
    locala.d((com.tencent.mm.bw.a)new bak());
    locala.Am("/cgi-bin/mmbiz-bin/videochannel/getnotifyandchannelfeeds");
    locala.op(1814);
    x.a(locala.aAz(), (x.a)new c.b(paramb));
    AppMethodBeat.o(175477);
  }
  
  public static aw bJa()
  {
    AppMethodBeat.i(175468);
    aw localaw = (aw)nuQ.getValue();
    AppMethodBeat.o(175468);
    return localaw;
  }
  
  public static final boolean bJd()
  {
    AppMethodBeat.i(175471);
    if (com.tencent.mm.plugin.biz.b.a.bIo())
    {
      AppMethodBeat.o(175471);
      return false;
    }
    Boolean localBoolean = nuV;
    if (localBoolean == null) {
      d.g.b.k.fOy();
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175471);
    return bool;
  }
  
  public static final boolean bJe()
  {
    AppMethodBeat.i(175472);
    Boolean localBoolean = nuY;
    if (localBoolean == null) {
      d.g.b.k.fOy();
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175472);
    return bool;
  }
  
  public static final dpz bJf()
  {
    int j = 1;
    AppMethodBeat.i(175475);
    Object localObject1;
    int i;
    if (nuX == null)
    {
      localObject1 = bJa();
      d.g.b.k.g(localObject1, "mmkv");
      if (!((aw)localObject1).containsKey("biz_video_channel_top_bar_info")) {
        break label128;
      }
      localObject1 = ((aw)localObject1).decodeBytes("biz_video_channel_top_bar_info");
      if (localObject1 == null) {
        break label128;
      }
      if (localObject1.length != 0) {
        break label100;
      }
      i = 1;
      if (i != 0) {
        break label105;
      }
      i = j;
      label57:
      if (i == 0) {
        break label128;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject3 = dpz.class.newInstance();
        ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bw.a)localObject3;
        nuX = (dpz)localObject1;
        localObject1 = nuX;
        AppMethodBeat.o(175475);
        return localObject1;
      }
      catch (Exception localException)
      {
        label100:
        label105:
        ac.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label57;
      label128:
      Object localObject2 = null;
    }
  }
  
  private static void bJg()
  {
    AppMethodBeat.i(175476);
    try
    {
      bJa().encode("biz_video_channel_top_bar_info", new byte[0]);
      nuX = null;
      AppMethodBeat.o(175476);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(175476);
    }
  }
  
  public static boolean bJi()
  {
    AppMethodBeat.i(198822);
    dpz localdpz = bJf();
    if (localdpz == null)
    {
      AppMethodBeat.o(198822);
      return false;
    }
    if ((localdpz.FXl & 0x10) != 0)
    {
      AppMethodBeat.o(198822);
      return true;
    }
    AppMethodBeat.o(198822);
    return false;
  }
  
  public static boolean bJj()
  {
    AppMethodBeat.i(198823);
    dpz localdpz = bJf();
    if (localdpz == null)
    {
      AppMethodBeat.o(198823);
      return false;
    }
    if ((!bs.isNullOrNil(localdpz.FXg)) && (bJa().decodeInt("biz_video_channel_show_default_icon", 0) == 1))
    {
      AppMethodBeat.o(198823);
      return true;
    }
    AppMethodBeat.o(198823);
    return false;
  }
  
  public static boolean bJk()
  {
    AppMethodBeat.i(198824);
    boolean bool = i.eA(r.aGc(ja(false)));
    AppMethodBeat.o(198824);
    return bool;
  }
  
  public static String bJl()
  {
    AppMethodBeat.i(198826);
    Object localObject = bJf();
    if (localObject == null)
    {
      AppMethodBeat.o(198826);
      return "";
    }
    localObject = ((dpz)localObject).FXh;
    AppMethodBeat.o(198826);
    return localObject;
  }
  
  public static boolean e(ImageView paramImageView)
  {
    AppMethodBeat.i(198827);
    d.g.b.k.h(paramImageView, "iconIV");
    if (bs.isNullOrNil(ja(true)))
    {
      AppMethodBeat.o(198827);
      return false;
    }
    String str = r.aGc(nuU);
    if (bJj()) {
      if (!i.eA(str)) {
        report(15L);
      }
    }
    for (;;)
    {
      o.aFB().a(nuU, paramImageView, new com.tencent.mm.av.a.a.c.a().aFR().pe(2131231342).aFP().CA(str).aFT());
      AppMethodBeat.o(198827);
      return true;
      report(16L);
      continue;
      if (!i.eA(str)) {
        report(17L);
      } else {
        report(18L);
      }
    }
  }
  
  public static final void init()
  {
    AppMethodBeat.i(175469);
    nuW = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWw, 0);
    nuZ = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWx, 0);
    int i = bJa().getInt("top_bar_video_channel_switch_option", 0);
    if (bJa().getInt("top_bar_video_channel_switch_option", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      yw(i);
      E(bool, false);
      AppMethodBeat.o(175469);
      return;
    }
  }
  
  public static String ja(boolean paramBoolean)
  {
    AppMethodBeat.i(198825);
    if ((bs.isNullOrNil(nuU)) || (paramBoolean))
    {
      localObject = bJf();
      if (localObject == null)
      {
        AppMethodBeat.o(198825);
        return "";
      }
      if (!bJj()) {
        break label75;
      }
    }
    label75:
    for (Object localObject = ((dpz)localObject).FXg;; localObject = ((dpz)localObject).hhs)
    {
      localObject = bs.nullAsNil((String)localObject);
      d.g.b.k.g(localObject, "Util.nullAsNil(if (isSho…else topBarInfo.logo_url)");
      nuU = (String)localObject;
      localObject = nuU;
      AppMethodBeat.o(198825);
      return localObject;
    }
  }
  
  public static final void release() {}
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(198828);
    h.wUl.n(1416L, paramLong, 1L);
    AppMethodBeat.o(198828);
  }
  
  public static void s(final int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(198821);
    Object localObject = bJf();
    int i;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label142;
      }
      AppMethodBeat.o(198821);
      return;
      if ((paramInt == 2) && ((((dpz)localObject).FXl & 0x2) != 0))
      {
        i = 1;
      }
      else if (paramInt == 1)
      {
        if ((((dpz)localObject).FXl & 0x1) != 0) {
          i = 1;
        } else if ((((dpz)localObject).FXl == 0) && (bJa().decodeInt("biz_video_channel_show_default_icon", -1) == -1)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else if ((paramInt == 3) && ((((dpz)localObject).FXl & 0x4) != 0))
      {
        i = 1;
      }
      else
      {
        if ((paramInt != 4) || ((((dpz)localObject).FXl & 0x8) == 0)) {
          break;
        }
        i = 1;
      }
    }
    label142:
    long l2;
    if ((paramInt == 2) || (paramInt == 1)) {
      l2 = bJa().getLong("biz_video_channel_strategy_fetch_last_time", 0L);
    }
    for (long l1 = Math.max(bJa().getLong("biz_video_channel_strategy_fetch_interval", 1800000L), 300000L);; l1 = bJa().getLong("biz_video_channel_strategy_tl_fetch_interval", 1800000L))
    {
      l2 = Math.abs(System.currentTimeMillis() - l2);
      if (l2 >= l1) {
        break;
      }
      ac.i("MicroMsg.BizVideoChannelStrategy", "fetchBizStrategy delta < interval, return");
      AppMethodBeat.o(198821);
      return;
      l2 = bJa().getLong("biz_video_channel_strategy_tl_fetch_last_time", 0L);
    }
    localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)new ny());
    ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new nz());
    ((com.tencent.mm.ak.b.a)localObject).Am("/cgi-bin/mmbiz-bin/timeline/bizstrategy");
    ((com.tencent.mm.ak.b.a)localObject).op(1806);
    com.tencent.mm.ak.b localb = ((com.tencent.mm.ak.b.a)localObject).aAz();
    d.g.b.k.g(localb, "rr");
    localObject = localb.aBC();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
      AppMethodBeat.o(198821);
      throw paramString1;
    }
    ny localny = (ny)localObject;
    localny.ReqType = 8;
    dpw localdpw = new dpw();
    localdpw.FXe = new dqa();
    dqa localdqa = localdpw.FXe;
    localObject = bJf();
    if (localObject != null) {}
    for (localObject = ((dpz)localObject).FXh;; localObject = null)
    {
      localdqa.FXh = ((String)localObject);
      localdpw.FXe.Ecn = paramString1;
      localdpw.FXe.FXo = paramString2;
      localdpw.FXe.scene = paramInt;
      localny.EdR = localdpw;
      report(0L);
      x.a(localb, (x.a)new a(localny, paramInt));
      ac.i("MicroMsg.BizVideoChannelStrategy", "preloadChannelStrategy %d", new Object[] { Long.valueOf(l2) });
      AppMethodBeat.o(198821);
      return;
    }
  }
  
  private static void yw(int paramInt)
  {
    AppMethodBeat.i(175473);
    if ((paramInt == 2) && (nuW == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      nuV = Boolean.valueOf(bool);
      ac.i("MicroMsg.BizVideoChannelStrategy", "alvinluo updateTimelineTopBarEntryStatus timelineTopBarEntryClientConfig: %d, server switchOption: %d, isTimelineTopBarEntryOpen: %b", new Object[] { Integer.valueOf(nuW), Integer.valueOf(paramInt), nuV });
      AppMethodBeat.o(175473);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements x.a
  {
    a(ny paramny, int paramInt) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, n paramn)
    {
      AppMethodBeat.i(198816);
      ac.i("MicroMsg.BizVideoChannelStrategy", "fetchBizVideoChannelStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = c.nva;
        c.report(2L);
        AppMethodBeat.o(198816);
        return 0;
      }
      d.g.b.k.g(paramb, "comReqResp");
      paramb = paramb.aBD();
      paramString = paramb;
      if (!(paramb instanceof nz)) {
        paramString = null;
      }
      paramString = (nz)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(198816);
        return 0;
      }
      paramb = paramString.EdW;
      if (paramb != null)
      {
        paramb = paramb.FXc;
        if ((paramb != null) && (paramb.FXi == 0))
        {
          ac.i("MicroMsg.BizVideoChannelStrategy", "sync_flag is 0, just return!");
          AppMethodBeat.o(198816);
          return 0;
        }
      }
      paramb = c.nva;
      c.report(1L);
      if ((this.nvb.ReqType & 0x8) != 0)
      {
        c.a(paramString);
        paramb = c.nva;
        c.b(paramInt, paramString);
        paramb = c.nva;
        c.b(paramString);
        paramString = c.nva;
        c.bJm().encode("biz_video_channel_show_default_icon", 0);
      }
      AppMethodBeat.o(198816);
      return 0;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(198819);
      ac.i("MicroMsg.BizVideoChannelStrategy", "preloadIcon start = %s", new Object[] { this.kFm });
      com.tencent.mm.av.a.a.c localc = new com.tencent.mm.av.a.a.c.a().aFR().pe(2131231342).aFP().CA(this.nvf).aFT();
      o.aFB().a(this.kFm, null, localc, (com.tencent.mm.av.a.c.k)1.nvg);
      AppMethodBeat.o(198819);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.c
 * JD-Core Version:    0.7.0.1
 */
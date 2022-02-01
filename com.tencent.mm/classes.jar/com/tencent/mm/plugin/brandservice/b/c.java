package com.tencent.mm.plugin.brandservice.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.d;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.plugin.brandservice.a.b.b;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.bfd;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.protocal.protobuf.dwj;
import com.tencent.mm.protocal.protobuf.dwk;
import com.tencent.mm.protocal.protobuf.dwn;
import com.tencent.mm.protocal.protobuf.dwo;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
import d.f;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/model/BizVideoChannelStrategy;", "", "()V", "BIZ_PROFILE_VIDEO_CHANNEL_ENTRY_OPEN", "", "KEY_BIZ_VIDEO_CHANNEL_SHOW_DEFAULT_ICON", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_LAST_TIME", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_LAST_TIME", "TAG", "TOP_BAR_INFO", "TOP_BAR_VIDEO_CHANNEL_SWITCH_OPTION", "VIDEO_CHANNEL_FEEDS_DATA", "bizProfileEntryClientConfig", "", "isBizProfileEntryOpen", "", "Ljava/lang/Boolean;", "isTimelineTopBarEntryOpen", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "showingLogoUrl", "getShowingLogoUrl", "()Ljava/lang/String;", "setShowingLogoUrl", "(Ljava/lang/String;)V", "timelineTopBarEntryClientConfig", "timelineTopBarInfo", "Lcom/tencent/mm/protocal/protobuf/VideoChannelTopBarInfo;", "clearTopBarInfo", "", "fetchBizVideoChannelStrategy", "fromScene", "talker", "url", "getLogoUrl", "force", "getNotifyAndChannelFeeds", "updateCallback", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "getSyncBuffer", "getTopBarInfo", "init", "isPreloadOpen", "scene", "isShowDefaultIcon", "isShowingDefaultIcon", "isShowingIconCached", "isTimeLineTopBarEntryOpen", "isTopBarInfoChanged", "topBarInfo", "loadChannelIcon", "iconIV", "Landroid/widget/ImageView;", "onLogoClick", "onTopBarVideoChannelEntryChanged", "switchOption", "preloadChannelStrategy", "preloadIcon", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "release", "report", "key", "", "saveTopBarInfo", "top_bar_info", "shouldChaneDefaultLogoAfterClick", "update", "updateBizProfileEntryStatus", "isEntryOpen", "needSave", "updateInterval", "updateTimelineTopBarEntryStatus", "VideoChannelSwitchOption", "VideoChannelTopBarControlBit", "plugin-brandservice_release"})
public final class c
{
  private static final f nUv;
  private static String ocb;
  private static Boolean occ;
  private static int ocd;
  private static dwn oce;
  private static Boolean ocf;
  private static int ocg;
  public static final c och;
  
  static
  {
    AppMethodBeat.i(175467);
    och = new c();
    ocb = "";
    nUv = d.g.O((d.g.a.a)c.c.ocl);
    AppMethodBeat.o(175467);
  }
  
  public static final void F(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(175474);
    if ((paramBoolean1) && (ocg == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      ocf = Boolean.valueOf(bool);
      if (paramBoolean2) {
        bOc().putInt("biz_profile_video_channel_entry_open", 1);
      }
      ae.i("MicroMsg.BizVideoChannelStrategy", "alvinluo updateBizProfileEntryStatus bizProfileEntryClientConfig: %d, server isEntryOpen: %b, isBizProfileEntryOpen: %b, needSave: %b", new Object[] { Integer.valueOf(ocg), Boolean.valueOf(paramBoolean1), ocf, Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(175474);
      return;
    }
  }
  
  public static void a(dwn paramdwn)
  {
    AppMethodBeat.i(208616);
    try
    {
      ay localay = bOc();
      if (paramdwn != null)
      {
        byte[] arrayOfByte = paramdwn.toByteArray();
        paramdwn = arrayOfByte;
        if (arrayOfByte != null) {}
      }
      else
      {
        paramdwn = new byte[0];
      }
      localay.encode("biz_video_channel_top_bar_info", paramdwn);
      AppMethodBeat.o(208616);
      return;
    }
    catch (Exception paramdwn)
    {
      AppMethodBeat.o(208616);
    }
  }
  
  public static final void a(pg parampg)
  {
    Integer localInteger = null;
    AppMethodBeat.i(175470);
    p.h(parampg, "resp");
    int i = bOc().getInt("top_bar_video_channel_switch_option", 0);
    dwj localdwj = parampg.GcU;
    Object localObject2;
    Object localObject1;
    label111:
    Object localObject3;
    label152:
    label173:
    label194:
    Object localObject4;
    label218:
    boolean bool;
    if (localdwj != null)
    {
      bOc().encode("biz_video_channel_show_default_icon", 0);
      localObject2 = new StringBuilder("alvinluo onUpdateBizVideoChannelStrategy localSwitchOption: %d, switch_option: %d, appId: %s, title: %s, logo: %s, version: %d, funcVersion: %d, default_logo_url: ");
      localObject1 = localdwj.IbF;
      if (localObject1 != null)
      {
        localObject1 = ((dwn)localObject1).IbJ;
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(", control_bits: ");
        localObject1 = localdwj.IbF;
        if (localObject1 == null) {
          break label487;
        }
        localObject1 = Integer.valueOf(((dwn)localObject1).IbO);
        String str = localObject1;
        int j = parampg.GcU.IbE;
        localObject1 = parampg.GcU.IbF;
        if (localObject1 == null) {
          break label493;
        }
        localObject1 = ((dwn)localObject1).dwb;
        localObject2 = parampg.GcU.IbF;
        if (localObject2 == null) {
          break label499;
        }
        localObject2 = ((dwn)localObject2).title;
        localObject3 = parampg.GcU.IbF;
        if (localObject3 == null) {
          break label505;
        }
        localObject3 = ((dwn)localObject3).hCp;
        localObject4 = parampg.GcU.IbF;
        if (localObject4 == null) {
          break label511;
        }
        localObject4 = Integer.valueOf(((dwn)localObject4).version);
        dwn localdwn = parampg.GcU.IbF;
        if (localdwn != null) {
          localInteger = Integer.valueOf(localdwn.IbI);
        }
        ae.i("MicroMsg.BizVideoChannelStrategy", str, new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject1, localObject2, localObject3, localObject4, localInteger });
        bOc().putInt("top_bar_video_channel_switch_option", localdwj.IbE);
        if (localdwj.IbE != 2) {
          break label522;
        }
        if (com.tencent.mm.plugin.brandservice.ui.b.c.b((com.tencent.mm.bw.a)localdwj.IbF, (com.tencent.mm.bw.a)bOv())) {
          break label517;
        }
        bool = true;
        label339:
        a(localdwj.IbF);
        oce = parampg.GcU.IbF;
      }
    }
    for (;;)
    {
      parampg = occ;
      zp(localdwj.IbE);
      ae.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onUpdateBizVideoChannelStrategy oldEntry: %b, new: %b, isTopBarInfoChanged: %b", new Object[] { parampg, occ, Boolean.valueOf(bool) });
      if (((p.i(parampg, occ) ^ true)) || (bool))
      {
        i = localdwj.IbE;
        parampg = oce;
        ae.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onTopBarVideoChannelEntryChanged");
        localObject1 = new ao();
        ((ao)localObject1).dmk.dml = i;
        if (parampg != null) {
          ((ao)localObject1).dmk.dmm = parampg;
        }
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      AppMethodBeat.o(175470);
      return;
      localObject1 = null;
      break;
      label487:
      localObject1 = null;
      break label111;
      label493:
      localObject1 = null;
      break label152;
      label499:
      localObject2 = null;
      break label173;
      label505:
      localObject3 = null;
      break label194;
      label511:
      localObject4 = null;
      break label218;
      label517:
      bool = false;
      break label339;
      label522:
      if ((localdwj.IbE == 0) || (localdwj.IbE == 1))
      {
        bOw();
        bool = false;
      }
      else if (localdwj.IbE == 3)
      {
        bool = false;
        bOw();
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
    locala.c((com.tencent.mm.bw.a)new bfd());
    locala.d((com.tencent.mm.bw.a)new bfe());
    locala.DN("/cgi-bin/mmbiz-bin/videochannel/getnotifyandchannelfeeds");
    locala.oS(1814);
    x.a(locala.aDS(), (x.a)new c.b(paramb));
    AppMethodBeat.o(175477);
  }
  
  public static boolean bOA()
  {
    AppMethodBeat.i(208620);
    dwn localdwn = bOv();
    if (localdwn == null)
    {
      AppMethodBeat.o(208620);
      return false;
    }
    if ((bOz()) || (bu.lX(localdwn.hCp, localdwn.IbJ)))
    {
      AppMethodBeat.o(208620);
      return true;
    }
    AppMethodBeat.o(208620);
    return false;
  }
  
  public static boolean bOB()
  {
    AppMethodBeat.i(208621);
    boolean bool = o.fB(r.aMY(jk(false)));
    AppMethodBeat.o(208621);
    return bool;
  }
  
  public static String bOC()
  {
    AppMethodBeat.i(208623);
    Object localObject = bOv();
    if (localObject == null)
    {
      AppMethodBeat.o(208623);
      return "";
    }
    localObject = ((dwn)localObject).IbK;
    AppMethodBeat.o(208623);
    return localObject;
  }
  
  public static ay bOc()
  {
    AppMethodBeat.i(175468);
    ay localay = (ay)nUv.getValue();
    AppMethodBeat.o(175468);
    return localay;
  }
  
  public static final boolean bOt()
  {
    AppMethodBeat.i(175471);
    if (com.tencent.mm.plugin.biz.b.b.bNy())
    {
      AppMethodBeat.o(175471);
      return false;
    }
    Boolean localBoolean = occ;
    if (localBoolean == null) {
      p.gkB();
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175471);
    return bool;
  }
  
  public static final boolean bOu()
  {
    AppMethodBeat.i(175472);
    Boolean localBoolean = ocf;
    if (localBoolean == null) {
      p.gkB();
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(175472);
    return bool;
  }
  
  public static final dwn bOv()
  {
    int j = 1;
    AppMethodBeat.i(175475);
    Object localObject1;
    int i;
    if (oce == null)
    {
      localObject1 = bOc();
      p.g(localObject1, "mmkv");
      if (!((ay)localObject1).containsKey("biz_video_channel_top_bar_info")) {
        break label129;
      }
      localObject1 = ((ay)localObject1).decodeBytes("biz_video_channel_top_bar_info");
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
        Object localObject3 = dwn.class.newInstance();
        ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bw.a)localObject3;
        oce = (dwn)localObject1;
        localObject1 = oce;
        AppMethodBeat.o(175475);
        return localObject1;
      }
      catch (Exception localException)
      {
        label101:
        label106:
        ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label58;
      label129:
      Object localObject2 = null;
    }
  }
  
  private static void bOw()
  {
    AppMethodBeat.i(175476);
    try
    {
      bOc().encode("biz_video_channel_top_bar_info", new byte[0]);
      oce = null;
      AppMethodBeat.o(175476);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(175476);
    }
  }
  
  public static boolean bOy()
  {
    AppMethodBeat.i(208618);
    dwn localdwn = bOv();
    if (localdwn == null)
    {
      AppMethodBeat.o(208618);
      return false;
    }
    if ((localdwn.IbO & 0x10) != 0)
    {
      AppMethodBeat.o(208618);
      return true;
    }
    AppMethodBeat.o(208618);
    return false;
  }
  
  public static boolean bOz()
  {
    AppMethodBeat.i(208619);
    dwn localdwn = bOv();
    if (localdwn == null)
    {
      AppMethodBeat.o(208619);
      return false;
    }
    if ((!bu.isNullOrNil(localdwn.IbJ)) && (bOc().decodeInt("biz_video_channel_show_default_icon", 0) == 1))
    {
      AppMethodBeat.o(208619);
      return true;
    }
    AppMethodBeat.o(208619);
    return false;
  }
  
  public static boolean e(ImageView paramImageView)
  {
    int k = 0;
    AppMethodBeat.i(208624);
    p.h(paramImageView, "iconIV");
    if (bu.isNullOrNil(jk(true)))
    {
      AppMethodBeat.o(208624);
      return false;
    }
    String str1 = r.aMY(ocb);
    int i;
    com.tencent.mm.av.a.a locala;
    String str2;
    com.tencent.mm.av.a.a.c.a locala1;
    int j;
    if (bOz()) {
      if (!o.fB(str1))
      {
        report(15L);
        i = 0;
        locala = q.aJb();
        str2 = ocb;
        locala1 = new com.tencent.mm.av.a.a.c.a().aJs();
        j = k;
        if (i != 0)
        {
          localObject = bOv();
          if (localObject == null) {
            break label301;
          }
        }
      }
    }
    label301:
    for (Object localObject = ((dwn)localObject).IbJ;; localObject = null)
    {
      j = k;
      if (!bu.isNullOrNil((String)localObject))
      {
        localObject = r.aMY((String)localObject);
        j = k;
        if (o.fB((String)localObject))
        {
          i = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 48);
          localObject = h.aP((String)localObject, i, i);
          j = k;
          if (localObject != null)
          {
            android.support.v4.graphics.drawable.b localb = d.a(ak.getResources(), (Bitmap)localObject);
            localb.setCornerRadius(Math.max(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()) / 2.0F);
            p.g(localb, "RoundedBitmapDrawableFac…                        }");
            locala1.x((Drawable)localb);
            report(19L);
            j = 1;
          }
        }
      }
      if (j == 0) {
        locala1.pK(2131231342);
      }
      locala.a(str2, paramImageView, locala1.aJq().Gg(str1).aJu());
      AppMethodBeat.o(208624);
      return true;
      report(16L);
      i = 0;
      break;
      if (!o.fB(str1))
      {
        report(17L);
        i = 1;
        break;
      }
      report(18L);
      i = 0;
      break;
    }
  }
  
  public static final void init()
  {
    AppMethodBeat.i(175469);
    ocd = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIN, 0);
    ocg = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIO, 0);
    int i = bOc().getInt("top_bar_video_channel_switch_option", 0);
    if (bOc().getInt("top_bar_video_channel_switch_option", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      zp(i);
      F(bool, false);
      AppMethodBeat.o(175469);
      return;
    }
  }
  
  public static String jk(boolean paramBoolean)
  {
    AppMethodBeat.i(208622);
    if ((bu.isNullOrNil(ocb)) || (paramBoolean))
    {
      localObject = bOv();
      if (localObject == null)
      {
        AppMethodBeat.o(208622);
        return "";
      }
      if (!bOz()) {
        break label75;
      }
    }
    label75:
    for (Object localObject = ((dwn)localObject).IbJ;; localObject = ((dwn)localObject).hCp)
    {
      localObject = bu.nullAsNil((String)localObject);
      p.g(localObject, "Util.nullAsNil(if (isSho…else topBarInfo.logo_url)");
      ocb = (String)localObject;
      localObject = ocb;
      AppMethodBeat.o(208622);
      return localObject;
    }
  }
  
  public static final void release() {}
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(208625);
    com.tencent.mm.plugin.report.service.g.yxI.n(1416L, paramLong, 1L);
    AppMethodBeat.o(208625);
  }
  
  public static void s(final int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(208617);
    Object localObject = bOv();
    int i;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label141;
      }
      AppMethodBeat.o(208617);
      return;
      if ((paramInt == 2) && ((((dwn)localObject).IbO & 0x2) != 0))
      {
        i = 1;
      }
      else if (paramInt == 1)
      {
        if ((((dwn)localObject).IbO & 0x1) != 0) {
          i = 1;
        } else if ((((dwn)localObject).IbO == 0) && (bOc().decodeInt("biz_video_channel_show_default_icon", -1) == -1)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else if ((paramInt == 3) && ((((dwn)localObject).IbO & 0x4) != 0))
      {
        i = 1;
      }
      else
      {
        if ((paramInt != 4) || ((((dwn)localObject).IbO & 0x8) == 0)) {
          break;
        }
        i = 1;
      }
    }
    label141:
    long l2;
    if ((paramInt == 2) || (paramInt == 1)) {
      l2 = bOc().getLong("biz_video_channel_strategy_fetch_last_time", 0L);
    }
    for (long l1 = Math.max(bOc().getLong("biz_video_channel_strategy_fetch_interval", 1800000L), 300000L);; l1 = bOc().getLong("biz_video_channel_strategy_tl_fetch_interval", 1800000L))
    {
      l2 = Math.abs(System.currentTimeMillis() - l2);
      if (l2 >= l1) {
        break;
      }
      ae.i("MicroMsg.BizVideoChannelStrategy", "fetchBizStrategy delta < interval, return");
      AppMethodBeat.o(208617);
      return;
      l2 = bOc().getLong("biz_video_channel_strategy_tl_fetch_last_time", 0L);
    }
    localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)new pf());
    ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new pg());
    ((com.tencent.mm.ak.b.a)localObject).DN("/cgi-bin/mmbiz-bin/timeline/bizstrategy");
    ((com.tencent.mm.ak.b.a)localObject).oS(1806);
    com.tencent.mm.ak.b localb = ((com.tencent.mm.ak.b.a)localObject).aDS();
    p.g(localb, "rr");
    localObject = localb.aEU();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
      AppMethodBeat.o(208617);
      throw paramString1;
    }
    pf localpf = (pf)localObject;
    localpf.ReqType = 8;
    dwk localdwk = new dwk();
    localdwk.IbH = new dwo();
    dwo localdwo = localdwk.IbH;
    localObject = bOv();
    if (localObject != null) {}
    for (localObject = ((dwn)localObject).IbK;; localObject = null)
    {
      localdwo.IbK = ((String)localObject);
      localdwk.IbH.GaH = paramString1;
      localdwk.IbH.IbQ = paramString2;
      localdwk.IbH.scene = paramInt;
      localpf.GcP = localdwk;
      report(0L);
      x.a(localb, (x.a)new a(localpf, paramInt));
      ae.i("MicroMsg.BizVideoChannelStrategy", "preloadChannelStrategy %d", new Object[] { Long.valueOf(l2) });
      AppMethodBeat.o(208617);
      return;
    }
  }
  
  private static void zp(int paramInt)
  {
    AppMethodBeat.i(175473);
    if ((paramInt == 2) && (ocd == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      occ = Boolean.valueOf(bool);
      ae.i("MicroMsg.BizVideoChannelStrategy", "alvinluo updateTimelineTopBarEntryStatus timelineTopBarEntryClientConfig: %d, server switchOption: %d, isTimelineTopBarEntryOpen: %b", new Object[] { Integer.valueOf(ocd), Integer.valueOf(paramInt), occ });
      AppMethodBeat.o(175473);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements x.a
  {
    a(pf parampf, int paramInt) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, n paramn)
    {
      AppMethodBeat.i(208612);
      ae.i("MicroMsg.BizVideoChannelStrategy", "fetchBizVideoChannelStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = c.och;
        c.report(2L);
        AppMethodBeat.o(208612);
        return 0;
      }
      p.g(paramb, "comReqResp");
      paramb = paramb.aEV();
      paramString = paramb;
      if (!(paramb instanceof pg)) {
        paramString = null;
      }
      paramString = (pg)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(208612);
        return 0;
      }
      paramb = paramString.GcU;
      if (paramb != null)
      {
        paramb = paramb.IbF;
        if ((paramb != null) && (paramb.IbL == 0))
        {
          ae.i("MicroMsg.BizVideoChannelStrategy", "sync_flag is 0, just return!");
          AppMethodBeat.o(208612);
          return 0;
        }
      }
      paramb = c.och;
      c.report(1L);
      if ((this.oci.ReqType & 0x8) != 0)
      {
        c.a(paramString);
        paramb = c.och;
        c.b(paramInt, paramString);
        paramb = c.och;
        c.b(paramString);
      }
      AppMethodBeat.o(208612);
      return 0;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(208615);
      ae.i("MicroMsg.BizVideoChannelStrategy", "preloadIcon start = %s", new Object[] { this.lfj });
      com.tencent.mm.av.a.a.c localc = new com.tencent.mm.av.a.a.c.a().aJs().pK(2131231342).aJq().Gg(this.ocm).aJu();
      q.aJb().a(this.lfj, null, localc, (k)1.ocn);
      AppMethodBeat.o(208615);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.c
 * JD-Core Version:    0.7.0.1
 */
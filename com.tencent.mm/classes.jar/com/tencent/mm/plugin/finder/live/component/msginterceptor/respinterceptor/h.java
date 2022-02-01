package com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.model.g;
import com.tencent.mm.live.model.p;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.am;
import com.tencent.mm.plugin.finder.live.util.u;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.l;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.w.a.a.a.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgRespLiveExtInfoInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "checkAnchorStatus", "", "curLiveData", "remoteAnchorStatus", "", "intercept", "", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class h
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.e
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final String TAG;
  
  public h(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(353186);
    this.CBK = parama;
    this.TAG = "LiveMsgRespLiveExtInfoInterceptor";
    AppMethodBeat.o(353186);
  }
  
  public boolean a(a.a parama)
  {
    AppMethodBeat.i(353245);
    s.u(parama, "respWrapper");
    parama = parama.CBm;
    Object localObject1;
    if (parama != null)
    {
      parama = parama.liveInfo;
      if (parama != null)
      {
        parama = parama.ZRO;
        if (parama != null)
        {
          localObject1 = parama.ZQg;
          if (localObject1 != null)
          {
            parama = (com.tencent.mm.bx.a)new dih();
            localObject1 = ((b)localObject1).Op;
          }
        }
      }
    }
    try
    {
      parama.parseFrom((byte[])localObject1);
      localObject1 = (dih)parama;
      localObject2 = new StringBuilder("anchorStatusFlag:");
      if (localObject1 == null)
      {
        parama = null;
        localObject2 = ((StringBuilder)localObject2).append(parama).append(" micSetting:");
        if (localObject1 != null) {
          break label1966;
        }
        parama = null;
        localObject2 = ((StringBuilder)localObject2).append(parama).append(" micSettingSwitch:");
        if (localObject1 != null) {
          break label1992;
        }
        parama = null;
        Log.i("Finder.FinderLiveService", parama);
        if (localObject1 != null)
        {
          localObject2 = this.CBK;
          l1 = ((dih)localObject1).aaNh;
          localObject3 = this.TAG;
          parama = new StringBuilder("[heartbeat] checkAnchorStatus isAnchor:");
          localObject4 = aj.CGT;
          localObject4 = parama.append(aj.bUB()).append(" remoteAnchorStatus:").append(l1).append(" localAnchorStatus:");
          if (localObject2 != null) {
            break label2018;
          }
          parama = null;
          parama = ((StringBuilder)localObject4).append(parama).append(", filterAnchorExtFlag:");
          localObject4 = aj.CGT;
          Log.i((String)localObject3, aj.elx());
          if (localObject2 != null)
          {
            parama = aj.CGT;
            if (!aj.elx())
            {
              parama = aj.CGT;
              if ((!aj.bUB()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp != l1))
              {
                if ((d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp, 2)) || (!d.ee((int)l1, 2))) {
                  break label2049;
                }
                Log.i(this.TAG, "[heartbeat] checkAnchorStatus anchor CALL_INTERRUPTION:true");
                parama = p.mZf;
                parama = p.bhS();
                if (parama != null) {
                  parama.onAnchorCallInterruption(true);
                }
              }
            }
          }
          locale = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          s.u(localObject1, "anchorStatus");
          long l2 = ((dih)localObject1).aaNh;
          Log.i(locale.TAG, s.X("updateAnchorStatus anchorStatusFlag:", Integer.valueOf((int)l2)));
          localObject2 = (j)locale.business(j.class);
          s.u(localObject1, "anchorStatus");
          parama = ((dih)localObject1).ZFK;
          if ((!((j)((j)localObject2).business(j.class)).EfD) || (!((j)((j)localObject2).business(j.class)).EfE)) {
            break label2121;
          }
          bool2 = d.ee((int)l2, 64);
          if (((j)((j)localObject2).business(j.class)).EfB != 1) {
            break label2110;
          }
          bool1 = true;
          if ((bool2 != bool1) && (((j)((j)localObject2).business(j.class)).EfB != -1)) {
            j.v(((c)localObject2).CBK);
          }
          localObject3 = (j)((j)localObject2).business(j.class);
          if (!bool2) {
            break label2116;
          }
          i = 1;
          ((j)localObject3).EfB = i;
          if (parama != null) {
            break label2138;
          }
          l1 = 0L;
          if (l1 != ((j)localObject2).Cvf.CJK)
          {
            ((j)localObject2).Cvf.CJK = l1;
            if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((j)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).bUB()) {
              j.f(((c)localObject2).CBK);
            }
          }
          localObject2 = new StringBuilder("updateLiveMsg anchorStatusFlag:").append(l2).append(" micSetting:");
          if (parama != null) {
            break label2146;
          }
          parama = null;
          Log.i("MMFinder.LiveLinkMicSlice", parama);
          if (d.ee((int)l2, 8)) {
            break label2157;
          }
          bool1 = true;
          locale.Ect = bool1;
          if (d.ee((int)l2, 512)) {
            break label2163;
          }
          bool2 = true;
          if (bool2 != locale.Ecx)
          {
            localObject2 = (l)locale.business(l.class);
            if (!bool2) {
              break label2169;
            }
            parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_like_anchor_enable);
            s.s(parama, "if (liveRoomLike) MMAppl…live_like_anchor_disable)");
            localObject3 = new bke();
            ((bke)localObject3).content = parama;
            ((bke)localObject3).type = 10001;
            parama = ah.aiuX;
            parama = new am((bke)localObject3);
            ((l)((l)localObject2).business(l.class)).EgE.add(parama);
          }
          locale.Ecx = bool2;
          bool2 = d.ee((int)l2, 8192);
          if (bool2 != locale.Ecv)
          {
            localObject2 = (l)locale.business(l.class);
            if (!bool2) {
              break label2185;
            }
            parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_anonymous_anchor_enable);
            s.s(parama, "if (isAnonymous)\n       …disable\n                )");
            localObject3 = new bke();
            ((bke)localObject3).content = parama;
            ((bke)localObject3).type = 10001;
            parama = ah.aiuX;
            parama = new am((bke)localObject3);
            ((l)((l)localObject2).business(l.class)).EgE.add(parama);
          }
          locale.Ecv = bool2;
          locale.EdB = Boolean.valueOf(bool1);
          locale.EcG = d.ee((int)l2, 32);
          if (bool1 != locale.Ect)
          {
            localObject2 = (l)locale.business(l.class);
            if (!bool1) {
              break label2201;
            }
            parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_comment_anchor_enable);
            s.s(parama, "if (liveRoomComment) MMA…e_comment_anchor_disable)");
            localObject3 = new bke();
            localObject4 = new bgh();
            Object localObject5 = new FinderContact();
            ((FinderContact)localObject5).username = "";
            ((FinderContact)localObject5).nickname = "";
            ((FinderContact)localObject5).headUrl = "";
            ah localah = ah.aiuX;
            ((bgh)localObject4).contact = ((FinderContact)localObject5);
            localObject5 = ah.aiuX;
            ((bke)localObject3).EbJ = ((bgh)localObject4);
            ((bke)localObject3).content = parama;
            ((bke)localObject3).type = 10006;
            parama = ah.aiuX;
            parama = new am((bke)localObject3);
            ((l)((l)localObject2).business(l.class)).EgE.add(parama);
          }
          bool1 = d.ee((int)l2, 16);
          ((q)locale.business(q.class)).EhZ |= bool1;
          if ((!locale.Edv) || (!locale.Edx)) {
            break label2238;
          }
          bool2 = d.ee((int)l2, 128);
          if ((bool2 != locale.eyr()) && (locale.Edu != -1))
          {
            localObject2 = locale.CBK;
            if (localObject2 != null)
            {
              localObject3 = new bke();
              ((bke)localObject3).type = 10001;
              if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyr()) {
                break label2217;
              }
              parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_gift_enable_msg_tip);
              ((bke)localObject3).content = parama;
              parama = ah.aiuX;
              parama = new am((bke)localObject3);
              ((l)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(l.class)).EgE.add(parama);
              Log.i(locale.TAG, s.X("appendGiftTip:", parama.CIc.content));
            }
          }
          if (!bool2) {
            break label2233;
          }
          i = 1;
          locale.Edu = i;
          bool2 = d.ee((int)l2, 256);
          if ((bool2 != locale.eyt()) && (locale.Eeh != -1))
          {
            localObject2 = locale.CBK;
            if (localObject2 != null)
            {
              localObject3 = new bke();
              ((bke)localObject3).type = 10001;
              if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyt()) {
                break label2247;
              }
              parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_camera_disable_msg_tip);
              ((bke)localObject3).content = parama;
              parama = ah.aiuX;
              parama = new am((bke)localObject3);
              ((l)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(l.class)).EgE.add(parama);
              Log.i(locale.TAG, s.X("appendAudioModeTip:", parama.CIc.content));
            }
          }
          if (!bool2) {
            break label2263;
          }
          i = 1;
          locale.Eeh = i;
          if ((((dih)localObject1).aaNi != null) && (locale.CFy != null))
          {
            parama = ((dih)localObject1).aaNi;
            if (parama != null) {
              break label2268;
            }
            localObject2 = null;
            parama = locale.CFy;
            if (parama != null) {
              break label2280;
            }
            localObject3 = null;
            parama = ((dih)localObject1).aaNi;
            if (parama != null) {
              break label2292;
            }
            parama = null;
            localObject1 = locale.Edg;
            if (localObject1 != null) {
              break label2317;
            }
            localObject1 = null;
            if (parama != null)
            {
              i = ((Number)parama).intValue();
              localObject4 = locale.eyp();
              if (localObject4 != null) {
                ((cca)localObject4).aalq = i;
              }
              localObject4 = locale.Edg;
              if (localObject4 != null) {
                break label2348;
              }
              localObject4 = null;
              if (localObject4 != null) {
                ((cbo)localObject4).aakX = i;
              }
            }
            Log.i(locale.TAG, "change gameteam mode,from:" + localObject3 + ", to:" + localObject2 + " oldPayment:" + localObject1 + " newPayment:" + parama);
            if (s.p(localObject3, localObject2)) {
              break label2744;
            }
            parama = locale.CFy;
            if (parama != null) {
              parama.ZQz = ((Integer)localObject2).intValue();
            }
            locale.Edh = true;
            if (!locale.bUB())
            {
              if (localObject3 != null) {
                break label2358;
              }
              if (localObject3 != null) {
                break label2572;
              }
              if (localObject2 != null) {
                break label2583;
              }
              label1731:
              if (localObject2 != null) {
                break label2595;
              }
            }
          }
          label1736:
          locale.Ecp = ((int)l2);
          Log.i(locale.TAG, "updateLiveMsg anchorStatusFlag:" + l2 + ",enableLiveRoomComment:" + locale.Ect + ",liveBreakRule:" + locale.EcG + ",shoppingAvailableStatus:" + bool1 + ", shoppingAvailable:" + ((q)locale.business(q.class)).EhZ + ", enableLinkMic:" + ((j)locale.business(j.class)).eyW() + ", enableGift:" + locale.eyr() + ", audioModeSwitch:" + locale.Eek + ", enableAudioMode:" + locale.Eeh + '}');
          parama = u.DJC;
          u.ey("updateAnchorStatus", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locale.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
        }
        AppMethodBeat.o(353245);
        return true;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Object localObject2;
        long l1;
        Object localObject3;
        Object localObject4;
        com.tencent.mm.plugin.finder.live.viewmodel.data.business.e locale;
        boolean bool2;
        boolean bool1;
        int i;
        Log.printDebugStack("safeParser", "", new Object[] { parama });
        parama = null;
        continue;
        parama = Long.valueOf(((dih)localObject1).aaNh);
        continue;
        label1966:
        parama = ((dih)localObject1).ZFK;
        if (parama == null)
        {
          parama = null;
        }
        else
        {
          parama = Long.valueOf(parama.CJK);
          continue;
          label1992:
          parama = ((dih)localObject1).ZFK;
          if (parama == null)
          {
            parama = null;
          }
          else
          {
            parama = Long.valueOf(parama.aaVw);
            continue;
            label2018:
            parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
            if (parama == null)
            {
              parama = null;
            }
            else
            {
              parama = Integer.valueOf(parama.Ecp);
              continue;
              label2049:
              if ((d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp, 2)) && (!d.ee((int)l1, 2)))
              {
                Log.i(this.TAG, "[heartbeat] checkAnchorStatus anchor CALL_INTERRUPTION:false");
                parama = p.mZf;
                parama = p.bhS();
                if (parama != null)
                {
                  parama.onAnchorCallInterruption(false);
                  continue;
                  label2110:
                  bool1 = false;
                  continue;
                  label2116:
                  i = 0;
                  continue;
                  label2121:
                  ((j)((j)localObject2).business(j.class)).EfB = 0;
                  continue;
                  label2138:
                  l1 = parama.CJK;
                  continue;
                  label2146:
                  parama = Long.valueOf(parama.CJK);
                  continue;
                  label2157:
                  bool1 = false;
                  continue;
                  label2163:
                  bool2 = false;
                  continue;
                  label2169:
                  parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_like_anchor_disable);
                  continue;
                  label2185:
                  parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_anonymous_anchor_disable);
                  continue;
                  label2201:
                  parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_comment_anchor_disable);
                  continue;
                  label2217:
                  parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_gift_disable_msg_tip);
                  continue;
                  label2233:
                  i = 0;
                  continue;
                  label2238:
                  locale.Edu = 0;
                  continue;
                  label2247:
                  parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_camera_enable_msg_tip);
                  continue;
                  label2263:
                  i = 0;
                  continue;
                  label2268:
                  localObject2 = Integer.valueOf(parama.aakL);
                  continue;
                  label2280:
                  localObject3 = Integer.valueOf(parama.ZQz);
                  continue;
                  label2292:
                  parama = parama.ZGd;
                  if (parama == null)
                  {
                    parama = null;
                  }
                  else
                  {
                    parama = Integer.valueOf(parama.aalq);
                    continue;
                    label2317:
                    localObject1 = ((bhf)localObject1).ZQG;
                    label2438:
                    label2572:
                    label2583:
                    label2595:
                    label2728:
                    if (localObject1 == null)
                    {
                      localObject1 = null;
                    }
                    else
                    {
                      localObject1 = Integer.valueOf(((cbo)localObject1).aakX);
                      continue;
                      label2348:
                      localObject4 = ((bhf)localObject4).ZQG;
                      continue;
                      label2358:
                      if (((Integer)localObject3).intValue() == 1)
                      {
                        label2367:
                        localObject1 = locale.CBK;
                        localObject2 = locale.TAG;
                        if (localObject1 == null)
                        {
                          parama = null;
                          label2388:
                          Log.i((String)localObject2, s.X("appendGameTeamModeTip:", parama));
                          if (localObject1 == null) {
                            break label2651;
                          }
                          parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
                          if (parama == null) {
                            break label2651;
                          }
                          parama = parama.CFy;
                          if ((parama == null) || (parama.ZQz != 0)) {
                            break label2651;
                          }
                          i = 1;
                          if ((i != 0) || (localObject1 == null)) {
                            continue;
                          }
                          localObject2 = new bke();
                          ((bke)localObject2).type = 10001;
                          parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFy;
                          if ((parama == null) || (parama.ZQz != 1)) {
                            break label2656;
                          }
                          i = 1;
                          label2492:
                          if (i == 0) {
                            break label2685;
                          }
                          parama = locale.CFy;
                          if (parama != null) {
                            break label2661;
                          }
                          parama = null;
                          label2508:
                          if (!Util.isNullOrNil(parama)) {
                            break label2669;
                          }
                          parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_game_live_team_join_off_for_appbrand);
                        }
                        for (;;)
                        {
                          ((bke)localObject2).content = parama;
                          parama = ah.aiuX;
                          parama = new am((bke)localObject2);
                          ((l)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(l.class)).EgE.add(parama);
                          break label1736;
                          if (((Integer)localObject3).intValue() == 0) {
                            break label2367;
                          }
                          break;
                          if (((Integer)localObject2).intValue() == 1) {
                            break label2367;
                          }
                          break label1731;
                          if (((Integer)localObject2).intValue() != 0) {
                            break label1736;
                          }
                          break label2367;
                          parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
                          if (parama == null)
                          {
                            parama = null;
                            break label2388;
                          }
                          parama = parama.CFy;
                          if (parama == null)
                          {
                            parama = null;
                            break label2388;
                          }
                          parama = Integer.valueOf(parama.ZQz);
                          break label2388;
                          label2651:
                          i = 0;
                          break label2438;
                          label2656:
                          i = 0;
                          break label2492;
                          label2661:
                          parama = parama.Idh;
                          break label2508;
                          label2669:
                          parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_game_live_team_join_off);
                          continue;
                          label2685:
                          parama = locale.CFy;
                          if (parama == null) {}
                          for (parama = null;; parama = parama.Idh)
                          {
                            if (!Util.isNullOrNil(parama)) {
                              break label2728;
                            }
                            parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_game_live_team_join_on_for_appbrand);
                            break;
                          }
                          parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_game_live_team_join_on);
                        }
                        label2744:
                        if ((localObject2 != null) && (((Integer)localObject2).intValue() == 7)) {
                          locale.Edh = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a eji()
  {
    return this.CBK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.h
 * JD-Core Version:    0.7.0.1
 */
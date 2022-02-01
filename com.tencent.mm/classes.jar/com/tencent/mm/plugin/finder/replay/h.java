package com.tencent.mm.plugin.finder.replay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.i;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.g;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.k;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.l;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.m;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayMsgRespChain;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveMsgRespChain;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "respChain", "", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveMsgRespInterceptor;", "getRespChain", "()Ljava/util/List;", "dealWithResp", "", "cgiResp", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp;", "Companion", "ReplayLiveExtInfoInterceptor", "ReplayMsgRespLegalInterceptor", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.d
{
  public static final h.a Fkk;
  private final List<com.tencent.mm.plugin.finder.live.component.msginterceptor.h> CBI;
  
  static
  {
    AppMethodBeat.i(332621);
    Fkk = new h.a((byte)0);
    AppMethodBeat.o(332621);
  }
  
  public h(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(332616);
    this.CBI = p.listOf(new com.tencent.mm.plugin.finder.live.component.msginterceptor.h[] { (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)new c(parama), (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)new k(parama), (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)new g(parama), (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)new b(parama), (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)new m(parama), (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)new l(parama), (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.j(parama), (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.e(parama), (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.f(parama), (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.c(), (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.d(parama), (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.b(parama) });
    AppMethodBeat.o(332616);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.live.component.msginterceptor.a parama)
  {
    AppMethodBeat.i(332633);
    s.u(parama, "cgiResp");
    boolean bool = false;
    Iterator localIterator = this.CBI.iterator();
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.finder.live.component.msginterceptor.h localh = (com.tencent.mm.plugin.finder.live.component.msginterceptor.h)localIterator.next();
      bool = localh.b(parama);
      if (!bool) {
        Log.i("FinderLiveReplayMsgRespChain", "dealWithResp interceptor:" + localh.getClass().getSimpleName() + " break!");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(332633);
      return bool;
      break;
    }
  }
  
  public final List<com.tencent.mm.plugin.finder.live.component.msginterceptor.h> ejh()
  {
    return this.CBI;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayMsgRespChain$ReplayLiveExtInfoInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgRespLiveExtInfoInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayMsgRespChain;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "intercept", "", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.h
  {
    public b()
    {
      super();
      AppMethodBeat.i(332580);
      AppMethodBeat.o(332580);
    }
    
    public final boolean a(a.a parama)
    {
      AppMethodBeat.i(332602);
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
              localObject1 = ((com.tencent.mm.bx.b)localObject1).Op;
            }
          }
        }
      }
      try
      {
        parama.parseFrom((byte[])localObject1);
        localObject1 = (dih)parama;
        if (localObject1 != null)
        {
          locale = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)eji().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          s.u(localObject1, "anchorStatus");
          long l2 = ((dih)localObject1).aaNh;
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)locale.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
          s.u(localObject1, "anchorStatus");
          bool1 = false;
          parama = ((dih)localObject1).ZFK;
          if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfD) || (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfE)) {
            break label1059;
          }
          bool3 = com.tencent.mm.ae.d.ee((int)l2, 64);
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfB == 1)
          {
            bool2 = true;
            if (bool3 != bool2) {
              bool1 = true;
            }
            localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
            if (!bool3) {
              break label1054;
            }
            i = 1;
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject3).EfB = i;
            if (parama != null) {
              break label1079;
            }
            l1 = 0L;
            if (l1 == ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).Cvf.CJK) {
              break label1334;
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).Cvf.CJK = l1;
            bool2 = true;
            localObject2 = new StringBuilder("updateLiveMsg anchorStatusFlag:").append(l2).append(" micSetting:");
            if (parama != null) {
              break label1087;
            }
            parama = null;
            Log.i("MMFinder.LiveLinkMicSlice", parama + ",enableLinkMicStatusChange:" + bool1 + ",enableMicSettingChange:" + bool2);
            r localr = new r(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
            if (com.tencent.mm.ae.d.ee((int)l2, 512)) {
              break label1098;
            }
            bool1 = true;
            if (bool1 == locale.Ecx) {
              break label1328;
            }
            bool2 = true;
            locale.Ecx = bool1;
            bool1 = com.tencent.mm.ae.d.ee((int)l2, 8192);
            if (bool1 == locale.Ecv) {
              break label1322;
            }
            bool3 = true;
            locale.Ecv = bool1;
            if (com.tencent.mm.ae.d.ee((int)l2, 8)) {
              break label1104;
            }
            bool1 = true;
            if (bool1 == locale.Ect) {
              break label1316;
            }
            bool4 = true;
            locale.Ect = bool1;
            locale.EdB = Boolean.valueOf(bool1);
            locale.EcG = com.tencent.mm.ae.d.ee((int)l2, 32);
            boolean bool7 = com.tencent.mm.ae.d.ee((int)l2, 16);
            ((q)locale.business(q.class)).EhZ |= bool7;
            if ((!locale.Edv) || (!locale.Edx)) {
              break label1115;
            }
            bool5 = com.tencent.mm.ae.d.ee((int)l2, 128);
            if (bool5 == locale.eyr()) {
              break label1310;
            }
            bool1 = true;
            if (!bool5) {
              break label1110;
            }
            i = 1;
            locale.Edu = i;
            bool5 = bool1;
            bool1 = com.tencent.mm.ae.d.ee((int)l2, 256);
            if (bool1 == locale.eyt()) {
              break label1304;
            }
            bool6 = true;
            if (!bool1) {
              break label1127;
            }
            i = 1;
            locale.Eeh = i;
            if ((((dih)localObject1).aaNi == null) || (locale.CFy == null)) {
              break label1268;
            }
            parama = ((dih)localObject1).aaNi;
            if (parama != null) {
              break label1132;
            }
            localObject2 = null;
            parama = locale.CFy;
            if (parama != null) {
              break label1144;
            }
            localObject3 = null;
            parama = ((dih)localObject1).aaNi;
            if (parama != null) {
              break label1156;
            }
            parama = null;
            localObject1 = locale.Edg;
            if (localObject1 != null) {
              break label1181;
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
                break label1212;
              }
              localObject4 = null;
              if (localObject4 != null) {
                ((cbo)localObject4).aakX = i;
              }
            }
            Log.i(locale.TAG, "change gameteam mode,from:" + localObject3 + ", to:" + localObject2 + " oldPayment:" + localObject1 + " newPayment:" + parama);
            if (s.p(localObject3, localObject2)) {
              break label1274;
            }
            parama = locale.CFy;
            if (parama != null) {
              parama.ZQz = ((Integer)localObject2).intValue();
            }
            locale.Edh = true;
            if (locale.bUB()) {
              break label1268;
            }
            if (localObject3 != null) {
              break label1222;
            }
            if (localObject3 != null) {
              break label1237;
            }
            if (localObject2 != null) {
              break label1248;
            }
            label846:
            if (localObject2 != null) {
              break label1260;
            }
            bool1 = false;
            locale.Ecp = ((int)l2);
            Log.i(locale.TAG, "updateAnchorStatus2 anchorStatusFlag:" + (int)l2 + ",enableLinkMicStatusChange:" + ((Boolean)localr.bsC).booleanValue() + ",enableMicSettingChange:" + ((Boolean)localr.bsD).booleanValue() + ",enableLiveRoomLikeChange:" + bool2 + ",isVisitorAnonymousChange:" + bool3 + ",enableLiveRoomCommentChange:" + bool4 + ",liveBreakRule:" + locale.EcG + ",shoppingAvailableStatus:" + bool7 + ",enableGiftChange:" + bool5 + ",enableAudioModeFlagChange:" + bool6 + ",gameSettingChange:" + bool1);
          }
        }
        else
        {
          AppMethodBeat.o(332602);
          return true;
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          com.tencent.mm.plugin.finder.live.viewmodel.data.business.e locale;
          boolean bool3;
          boolean bool4;
          boolean bool6;
          Object localObject4;
          Log.printDebugStack("safeParser", "", new Object[] { parama });
          parama = null;
          continue;
          boolean bool2 = false;
          continue;
          label1054:
          int i = 0;
          continue;
          label1059:
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfB = 0;
          boolean bool1 = false;
          continue;
          label1079:
          long l1 = parama.CJK;
          continue;
          label1087:
          parama = Long.valueOf(parama.CJK);
          continue;
          label1098:
          bool1 = false;
          continue;
          label1104:
          bool1 = false;
          continue;
          label1110:
          i = 0;
          continue;
          label1115:
          locale.Edu = 0;
          boolean bool5 = false;
          continue;
          label1127:
          i = 0;
          continue;
          label1132:
          Object localObject2 = Integer.valueOf(parama.aakL);
          continue;
          label1144:
          Object localObject3 = Integer.valueOf(parama.ZQz);
          continue;
          label1156:
          parama = parama.ZGd;
          if (parama == null)
          {
            parama = null;
          }
          else
          {
            parama = Integer.valueOf(parama.aalq);
            continue;
            label1181:
            localObject1 = ((bhf)localObject1).ZQG;
            label1304:
            label1310:
            label1316:
            label1322:
            label1328:
            label1334:
            if (localObject1 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = Integer.valueOf(((cbo)localObject1).aakX);
              continue;
              label1212:
              localObject4 = ((bhf)localObject4).ZQG;
              continue;
              label1222:
              if (((Integer)localObject3).intValue() == 1)
              {
                label1237:
                label1248:
                label1260:
                do
                {
                  do
                  {
                    do
                    {
                      bool1 = true;
                      break;
                    } while (((Integer)localObject3).intValue() == 0);
                    break;
                  } while (((Integer)localObject2).intValue() == 1);
                  break label846;
                } while (((Integer)localObject2).intValue() == 0);
                for (;;)
                {
                  label1268:
                  bool1 = false;
                  break;
                  label1274:
                  if (localObject2 == null)
                  {
                    bool1 = false;
                    break;
                  }
                  if (((Integer)localObject2).intValue() == 7) {
                    locale.Edh = true;
                  }
                }
                bool6 = false;
                continue;
                bool1 = false;
                continue;
                bool4 = false;
                continue;
                bool3 = false;
                continue;
                bool2 = false;
                continue;
                bool2 = false;
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayMsgRespChain$ReplayMsgRespLegalInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IPreCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayMsgRespChain;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "intercept", "", "cgiResp", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    implements i
  {
    private final String TAG;
    
    public c()
    {
      AppMethodBeat.i(332595);
      this.TAG = "ReplayMsgRespLegalInterceptor";
      AppMethodBeat.o(332595);
    }
    
    public final boolean b(com.tencent.mm.plugin.finder.live.component.msginterceptor.a parama)
    {
      Object localObject2 = null;
      AppMethodBeat.i(332611);
      s.u(parama, "cgiResp");
      int j = parama.errCode;
      int k = parama.errType;
      Object localObject1 = parama.CBl;
      int i;
      label81:
      String str;
      StringBuilder localStringBuilder;
      if (localObject1 == null)
      {
        localObject1 = null;
        parama = parama.hTs;
        if ((localObject1 == null) || (((bip)localObject1).liveId != ((com.tencent.mm.plugin.finder.replay.viewmodel.c)h.this.CBK.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).getLiveInfo().liveId)) {
          break label248;
        }
        i = 1;
        if ((i != 0) && (Util.isEqual(parama, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)h.this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hTs))) {
          break label265;
        }
        str = this.TAG;
        localStringBuilder = new StringBuilder("handleReplayLiveMsgResp localUniqId:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)h.this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hTs).append(", respUniqId:").append(parama).append(", local liveId:").append(((com.tencent.mm.plugin.finder.replay.viewmodel.c)h.this.CBK.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).getLiveInfo().liveId).append(", resp.liveId:");
        if (localObject1 != null) {
          break label253;
        }
      }
      label248:
      label253:
      for (parama = localObject2;; parama = Long.valueOf(((bip)localObject1).liveId))
      {
        Log.e(str, parama);
        AppMethodBeat.o(332611);
        return false;
        localObject1 = ((a.a)localObject1).CBm;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((azp)localObject1).liveInfo;
        break;
        i = 0;
        break label81;
      }
      label265:
      if ((k != 0) || (j != 0))
      {
        Log.e(this.TAG, "handleReplayLiveMsgResp errCode:" + j + ",errType:" + k);
        AppMethodBeat.o(332611);
        return false;
      }
      AppMethodBeat.o(332611);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.h
 * JD-Core Version:    0.7.0.1
 */
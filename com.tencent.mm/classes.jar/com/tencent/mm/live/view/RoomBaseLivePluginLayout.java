package com.tencent.mm.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.nl;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.b.a.c;
import com.tencent.mm.live.b.b.a.d;
import com.tencent.mm.live.b.b.a.g;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.b.k;
import com.tencent.mm.live.b.l.i;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.s;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.core.core.c.c.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/RoomBaseLivePluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mVoipCallEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "multiTalkActionListener", "mount", "", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAnchorCallInterruption", "callInterruption", "", "onAnchorConnectionChange", "onApplyLiveMic", "Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "onBanLiveComment", "Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "onBattleApply", "onBattleClose", "onBattleDismiss", "onBattleEnd", "onBattleStart", "onCloseApplyLiveMic", "Lcom/tencent/mm/live/model/CloseApplyLiveMicInfo;", "onCloseLive", "Lcom/tencent/mm/live/model/CloseLiveInfo;", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onLiveMicSucc", "Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "onOnlineLiveList", "Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "unMount", "plugin-logic_release"})
public abstract class RoomBaseLivePluginLayout
  extends BaseLivePluginLayout
{
  private final IListener<aaq> kLR = (IListener)new a(this);
  private final IListener<?> kLS = (IListener)new b(this);
  
  public RoomBaseLivePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void mount()
  {
    super.mount();
    com.tencent.mm.live.b.p localp = com.tencent.mm.live.b.p.kvF;
    com.tencent.mm.live.b.p.a((com.tencent.mm.live.b.g)this);
    this.kLR.alive();
    this.kLS.alive();
  }
  
  public void onAcceptLiveMic(com.tencent.mm.live.b.a parama)
  {
    kotlin.g.b.p.k(parama, "info");
    long l1 = parama.liveId;
    Object localObject1 = parama.ktE;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      int i = parama.sdkAppId;
      Object localObject3 = parama.userId;
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      int j = parama.ktG;
      int k = parama.ktF;
      Object localObject4 = parama.userSig;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
      Object localObject5 = parama.privateMapKey;
      localObject4 = localObject5;
      if (localObject5 == null) {
        localObject4 = "";
      }
      long l2 = parama.ktH;
      parama = parama.ktI;
      if (parama == null) {
        parama = null;
      }
      for (;;)
      {
        localObject4 = Base64.decode((String)localObject4, 0);
        kotlin.g.b.p.j(localObject4, "Base64.decode(privateMapKey, 0)");
        localObject5 = Charset.forName("UTF-8");
        kotlin.g.b.p.j(localObject5, "Charset.forName(\"UTF-8\")");
        localObject4 = new String((byte[])localObject4, (Charset)localObject5);
        localObject3 = new TRTCCloudDef.TRTCParams(i, (String)localObject2, (String)localObject3, j, (String)localObject4, "");
        localObject5 = l.i.kuO;
        if (k != l.i.aNR())
        {
          localObject5 = l.i.kuO;
          if (k != l.i.aNS()) {}
        }
        for (i = 21;; i = 20)
        {
          ((TRTCCloudDef.TRTCParams)localObject3).role = i;
          localObject3 = new crx();
          if (!Util.isNullOrNil(parama)) {
            ((crx)localObject3).parseFrom(Base64.decode(parama, 0));
          }
          parama = k.kuf;
          k.a((crx)localObject3, null, new com.tencent.mm.live.core.core.model.f(null, 0L, 0, null, 0L, 0L, null, null, 0L, null, 8191));
          parama = com.tencent.mm.live.core.core.c.c.kqq;
          c.a.aMm().Nv((String)localObject4);
          parama = new a.a(l1, (String)localObject1, "", "", (String)localObject2);
          localObject1 = u.kwz;
          localObject1 = u.aOv();
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.live.core.core.model.g)localObject1).kmq;
            if (localObject1 != null) {
              ((TRTCCloudDef.TRTCParams)localObject1).privateMapKey = ((String)localObject4);
            }
          }
          localObject1 = u.kwz;
          u.aPa().a(parama);
          parama = u.kwz;
          u.FI(l2);
          parama = o.kvA;
          localObject1 = u.kwz;
          parama.FH(kotlin.k.i.be((u.aOw() - 60L) * 1000L, 60000L));
          return;
        }
      }
    }
  }
  
  public void onAnchorCallInterruption(boolean paramBoolean) {}
  
  public void onAnchorConnectionChange(boolean paramBoolean) {}
  
  public void onApplyLiveMic(com.tencent.mm.live.b.b paramb)
  {
    kotlin.g.b.p.k(paramb, "info");
    long l = paramb.liveId;
    Object localObject2 = paramb.ktE;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = paramb.ktM;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject4 = paramb.roomId;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    localObject4 = paramb.ktN;
    paramb = (com.tencent.mm.live.b.b)localObject4;
    if (localObject4 == null) {
      paramb = "";
    }
    localObject4 = u.kwz;
    localObject4 = u.aPa();
    paramb = new a.a(l, (String)localObject1, (String)localObject2, (String)localObject3, paramb);
    kotlin.g.b.p.k(paramb, "liveMicUser");
    localObject1 = com.tencent.mm.live.core.debug.a.kqB;
    com.tencent.mm.live.core.debug.a.ay("MicroMsg.LiveCoreMic", "[sysmsg]anchor receive mic ".concat(String.valueOf(paramb)));
    localObject1 = u.kwz;
    if (u.aOr().klE == paramb.liveId)
    {
      localObject2 = ((Iterable)((com.tencent.mm.live.b.b.a)localObject4).kyn).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (a.a)((Iterator)localObject2).next();
        if (kotlin.g.b.p.h(((a.a)localObject1).ktN, paramb.ktN))
        {
          localObject2 = paramb.ktE;
          kotlin.g.b.p.k(localObject2, "<set-?>");
          ((a.a)localObject1).ktE = ((String)localObject2);
          paramb = paramb.roomId;
          kotlin.g.b.p.k(paramb, "<set-?>");
          ((a.a)localObject1).roomId = paramb;
          return;
        }
      }
      ((com.tencent.mm.live.b.b.a)localObject4).kyn.add(0, paramb);
      MMHandlerThread.postToMainThread((Runnable)new a.g((com.tencent.mm.live.b.b.a)localObject4));
      return;
    }
    paramb = new StringBuilder("anchor receive mic ,but error live_id for ");
    localObject1 = u.kwz;
    Log.e("MicroMsg.LiveCoreMic", u.aOr().klE);
  }
  
  public void onBanLiveComment(com.tencent.mm.live.b.c paramc)
  {
    boolean bool = true;
    int i = 0;
    kotlin.g.b.p.k(paramc, "info");
    long l = paramc.ktO;
    int j = paramc.ktP;
    Object localObject = paramc.wording;
    paramc = (com.tencent.mm.live.b.c)localObject;
    if (localObject == null) {
      paramc = "";
    }
    localObject = u.kwz;
    if (u.aOr().klE == l)
    {
      localObject = u.kwz;
      localObject = u.aOr();
      if (j != 1) {
        break label111;
      }
      ((crq)localObject).ROp = bool;
      localObject = u.kwz;
      localObject = u.kwz;
      if (!u.aOr().ROp) {
        break label117;
      }
    }
    for (;;)
    {
      u.tI(i);
      localObject = j.kue;
      j.NW(paramc);
      return;
      label111:
      bool = false;
      break;
      label117:
      i = cm.bfF();
    }
  }
  
  public void onBattleApply() {}
  
  public void onBattleClose() {}
  
  public void onBattleDismiss() {}
  
  public void onBattleEnd() {}
  
  public void onBattleStart() {}
  
  public void onCloseApplyLiveMic(com.tencent.mm.live.b.d paramd)
  {
    kotlin.g.b.p.k(paramd, "info");
    long l = paramd.liveId;
    boolean bool = paramd.enable;
    paramd = u.kwz;
    paramd = u.aPa();
    Object localObject = com.tencent.mm.live.core.debug.a.kqB;
    com.tencent.mm.live.core.debug.a.ay("MicroMsg.LiveCoreMic", "[sysmsg]anchor set mic permission:" + bool + " liveId:" + l);
    localObject = u.kwz;
    if (l == u.aOr().klE) {
      MMHandlerThread.postToMainThread((Runnable)new a.d(paramd, bool));
    }
  }
  
  public void onCloseLive(e parame)
  {
    kotlin.g.b.p.k(parame, "info");
    long l = parame.liveId;
    parame = u.kwz;
    parame = u.aPa();
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.kqB;
    com.tencent.mm.live.core.debug.a.NN("[sysmsg]anchor close live ".concat(String.valueOf(l)));
    MMHandlerThread.postToMainThread((Runnable)new a.c(parame, l));
    parame = u.kwz;
    u.FI(0L);
  }
  
  public void onCloseLiveMic(com.tencent.mm.live.b.f paramf)
  {
    kotlin.g.b.p.k(paramf, "info");
    long l = paramf.liveId;
    Object localObject2 = paramf.ktQ;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = paramf.ktE;
    paramf = (com.tencent.mm.live.b.f)localObject2;
    if (localObject2 == null) {
      paramf = "";
    }
    localObject2 = u.kwz;
    u.aPa().a(l, (String)localObject1, paramf);
    paramf = o.kvA;
    com.tencent.mm.ae.d.C(o.kvz);
    localObject1 = h.aHF();
    kotlin.g.b.p.j(localObject1, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject1).aGY().b(760, (com.tencent.mm.an.i)paramf);
  }
  
  public void onLiveMicSucc(com.tencent.mm.live.b.n paramn)
  {
    kotlin.g.b.p.k(paramn, "info");
    long l = paramn.liveId;
    Object localObject2 = paramn.ktQ;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = paramn.kvw;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject4 = paramn.nickName;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    Object localObject5 = paramn.ktN;
    localObject4 = localObject5;
    if (localObject5 == null) {
      localObject4 = "";
    }
    localObject5 = paramn.ktE;
    paramn = (com.tencent.mm.live.b.n)localObject5;
    if (localObject5 == null) {
      paramn = "";
    }
    localObject5 = u.kwz;
    u.aPa().a(l, paramn, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4);
  }
  
  public void onOnlineLiveList(s params)
  {
    kotlin.g.b.p.k(params, "info");
    Object localObject2 = params.kvI;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = params.content;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    params = params.fcD;
    if (params == null) {
      params = "";
    }
    for (;;)
    {
      localObject1 = new crr().parseFrom(Base64.decode((String)localObject1, 0));
      if (localObject1 == null) {
        throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveInfoList");
      }
      localObject3 = (crr)localObject1;
      if ((localObject3 != null) && (((crr)localObject3).jmy != null) && (((crr)localObject3).jmy.size() > 0))
      {
        int i = kotlin.n.n.a((CharSequence)localObject2, ":", 0, false, 6);
        if (i == -1) {
          break label304;
        }
        if (localObject2 == null) {
          throw new kotlin.t("null cannot be cast to non-null type java.lang.String");
        }
        localObject1 = ((String)localObject2).substring(0, i);
        kotlin.g.b.p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        localObject2 = new LinkedList();
        localObject3 = ((crr)localObject3).jmy.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          crq localcrq = (crq)((Iterator)localObject3).next();
          if (!params.equals(localcrq.TyH))
          {
            com.tencent.mm.live.b.c.b localb = new com.tencent.mm.live.b.c.b();
            localb.field_liveId = localcrq.klE;
            localb.field_hostRoomId = ((String)localObject1);
            localb.field_liveName = localcrq.TyI;
            localb.field_anchorUsername = localcrq.TyH;
            localb.field_isSender = false;
            localb.field_timeStamp = localcrq.ChC;
            ((LinkedList)localObject2).add(localb);
          }
        }
        com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().a((LinkedList)localObject2, (String)localObject1);
        return;
        label304:
        localObject1 = "";
      }
    }
  }
  
  public void unMount()
  {
    super.unMount();
    com.tencent.mm.live.b.p localp = com.tencent.mm.live.b.p.kvF;
    com.tencent.mm.live.b.p.release();
    this.kLR.dead();
    this.kLS.dead();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/view/RoomBaseLivePluginLayout$mVoipCallEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class a
    extends IListener<aaq>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/view/RoomBaseLivePluginLayout$multiTalkActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MultiTalkActionEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class b
    extends IListener<nl>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.RoomBaseLivePluginLayout
 * JD-Core Version:    0.7.0.1
 */
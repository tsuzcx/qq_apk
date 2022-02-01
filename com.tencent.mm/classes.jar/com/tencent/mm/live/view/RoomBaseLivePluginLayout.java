package com.tencent.mm.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.b.a.c;
import com.tencent.mm.live.b.b.a.d;
import com.tencent.mm.live.b.b.a.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.m;
import com.tencent.mm.live.b.o.j;
import com.tencent.mm.live.b.q;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.s;
import com.tencent.mm.live.b.v;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.core.core.d.b.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.ciw;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/RoomBaseLivePluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mVoipCallEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "multiTalkActionListener", "mount", "", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAnchorConnectionChange", "", "onApplyLiveMic", "Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "onBanLiveComment", "Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "onCloseApplyLiveMic", "Lcom/tencent/mm/live/model/CloseApplyLiveMicInfo;", "onCloseLive", "Lcom/tencent/mm/live/model/CloseLiveInfo;", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onFinderLiveAcceptLiveMic", "Lcom/tencent/mm/live/model/FinderLiveAcceptLiveMicInfo;", "onFinderLiveApplyLiveMic", "Lcom/tencent/mm/live/model/FinderLiveApplyLiveMicInfo;", "onFinderLiveCloseLiveMic", "Lcom/tencent/mm/live/model/FinderLiveCloseLiveMicInfo;", "onLiveMicSucc", "Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "onOnlineLiveList", "Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "unMount", "plugin-logic_release"})
public abstract class RoomBaseLivePluginLayout
  extends BaseLivePluginLayout
{
  private final IListener<zj> hXm = (IListener)new a(this);
  private final IListener<?> hXn = (IListener)new b(this);
  
  public RoomBaseLivePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void mount()
  {
    super.mount();
    s locals = s.hIl;
    s.a((com.tencent.mm.live.b.j)this);
    this.hXm.alive();
    this.hXn.alive();
  }
  
  public void onAcceptLiveMic(com.tencent.mm.live.b.a parama)
  {
    p.h(parama, "info");
    long l1 = parama.liveId;
    Object localObject1 = parama.hFz;
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
      int j = parama.hFB;
      int k = parama.hFA;
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
      long l2 = parama.hFC;
      parama = parama.hFD;
      if (parama == null) {
        parama = "";
      }
      for (;;)
      {
        localObject4 = Base64.decode((String)localObject4, 0);
        p.g(localObject4, "Base64.decode(privateMapKey, 0)");
        localObject5 = Charset.forName("UTF-8");
        p.g(localObject5, "Charset.forName(\"UTF-8\")");
        localObject4 = new String((byte[])localObject4, (Charset)localObject5);
        localObject3 = new TRTCCloudDef.TRTCParams(i, (String)localObject2, (String)localObject3, j, (String)localObject4, "");
        localObject5 = o.j.hHj;
        if (k != o.j.aFK())
        {
          localObject5 = o.j.hHj;
          if (k != o.j.aFL()) {}
        }
        for (i = 21;; i = 20)
        {
          ((TRTCCloudDef.TRTCParams)localObject3).role = i;
          localObject3 = new cjc();
          if (!Util.isNullOrNil(parama)) {
            ((cjc)localObject3).parseFrom(Base64.decode(parama, 0));
          }
          parama = com.tencent.mm.live.b.n.hGh;
          com.tencent.mm.live.b.n.a((cjc)localObject3, null, new com.tencent.mm.live.core.core.b.e(null, 0L, 0, null, 0L, 0L, 0, null, null, 0L, 4095));
          parama = com.tencent.mm.live.core.core.d.b.hCo;
          MMApplicationContext.getContext();
          b.a.aEf().Go((String)localObject4);
          parama = new a.a(l1, (String)localObject1, "", "", (String)localObject2);
          localObject1 = x.hJf;
          localObject1 = x.aGv();
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.live.core.core.b.f)localObject1).hzu;
            if (localObject1 != null) {
              ((TRTCCloudDef.TRTCParams)localObject1).privateMapKey = ((String)localObject4);
            }
          }
          localObject1 = x.hJf;
          x.aHa().a(parama);
          parama = x.hJf;
          x.zB(l2);
          parama = r.hIg;
          localObject1 = x.hJf;
          parama.zA(kotlin.k.j.aM((x.aGw() - 60L) * 1000L, 60000L));
          return;
        }
      }
    }
  }
  
  public void onAnchorConnectionChange(boolean paramBoolean) {}
  
  public void onApplyLiveMic(com.tencent.mm.live.b.b paramb)
  {
    p.h(paramb, "info");
    long l = paramb.liveId;
    Object localObject2 = paramb.hFz;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = paramb.hFF;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject4 = paramb.roomId;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    localObject4 = paramb.hFG;
    paramb = (com.tencent.mm.live.b.b)localObject4;
    if (localObject4 == null) {
      paramb = "";
    }
    localObject4 = x.hJf;
    localObject4 = x.aHa();
    paramb = new a.a(l, (String)localObject1, (String)localObject2, (String)localObject3, paramb);
    p.h(paramb, "liveMicUser");
    localObject1 = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sysmsg]anchor receive mic ".concat(String.valueOf(paramb)));
    localObject1 = x.hJf;
    if (x.aGr().hyH == paramb.liveId)
    {
      localObject2 = ((Iterable)((com.tencent.mm.live.b.b.a)localObject4).hKT).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (a.a)((Iterator)localObject2).next();
        if (p.j(((a.a)localObject1).hFG, paramb.hFG))
        {
          localObject2 = paramb.hFz;
          p.h(localObject2, "<set-?>");
          ((a.a)localObject1).hFz = ((String)localObject2);
          paramb = paramb.roomId;
          p.h(paramb, "<set-?>");
          ((a.a)localObject1).roomId = paramb;
          return;
        }
      }
      ((com.tencent.mm.live.b.b.a)localObject4).hKT.add(0, paramb);
      MMHandlerThread.postToMainThread((Runnable)new a.g((com.tencent.mm.live.b.b.a)localObject4));
      return;
    }
    paramb = new StringBuilder("anchor receive mic ,but error live_id for ");
    localObject1 = x.hJf;
    Log.e("MicroMsg.LiveCoreMic", x.aGr().hyH);
  }
  
  public void onBanLiveComment(com.tencent.mm.live.b.c paramc)
  {
    boolean bool = true;
    int i = 0;
    p.h(paramc, "info");
    long l = paramc.hFH;
    int j = paramc.hFI;
    Object localObject = paramc.dQx;
    paramc = (com.tencent.mm.live.b.c)localObject;
    if (localObject == null) {
      paramc = "";
    }
    localObject = x.hJf;
    if (x.aGr().hyH == l)
    {
      localObject = x.hJf;
      localObject = x.aGr();
      if (j != 1) {
        break label111;
      }
      ((civ)localObject).KNv = bool;
      localObject = x.hJf;
      localObject = x.hJf;
      if (!x.aGr().KNv) {
        break label117;
      }
    }
    for (;;)
    {
      x.qT(i);
      localObject = m.hGg;
      m.GL(paramc);
      return;
      label111:
      bool = false;
      break;
      label117:
      i = cl.aWB();
    }
  }
  
  public void onCloseApplyLiveMic(com.tencent.mm.live.b.d paramd)
  {
    p.h(paramd, "info");
    long l = paramd.liveId;
    boolean bool = paramd.enable;
    paramd = x.hJf;
    paramd = x.aHa();
    Object localObject = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sysmsg]anchor set mic permission:" + bool + " liveId:" + l);
    localObject = x.hJf;
    if (l == x.aGr().hyH) {
      MMHandlerThread.postToMainThread((Runnable)new a.d(paramd, bool));
    }
  }
  
  public void onCloseLive(com.tencent.mm.live.b.e parame)
  {
    p.h(parame, "info");
    long l = parame.liveId;
    parame = x.hJf;
    parame = x.aHa();
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.GA("[sysmsg]anchor close live ".concat(String.valueOf(l)));
    MMHandlerThread.postToMainThread((Runnable)new a.c(parame, l));
    parame = x.hJf;
    x.zB(0L);
  }
  
  public void onCloseLiveMic(com.tencent.mm.live.b.f paramf)
  {
    p.h(paramf, "info");
    long l = paramf.liveId;
    Object localObject2 = paramf.hFJ;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = paramf.hFz;
    paramf = (com.tencent.mm.live.b.f)localObject2;
    if (localObject2 == null) {
      paramf = "";
    }
    localObject2 = x.hJf;
    x.aHa().a(l, (String)localObject1, paramf);
    paramf = r.hIg;
    com.tencent.mm.ac.d.C(r.hIf);
    localObject1 = com.tencent.mm.kernel.g.aAg();
    p.g(localObject1, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject1).azz().b(760, (com.tencent.mm.ak.i)paramf);
  }
  
  public void onFinderLiveAcceptLiveMic(com.tencent.mm.live.b.g paramg)
  {
    p.h(paramg, "info");
  }
  
  public void onFinderLiveApplyLiveMic(h paramh)
  {
    p.h(paramh, "info");
  }
  
  public void onFinderLiveCloseLiveMic(com.tencent.mm.live.b.i parami)
  {
    p.h(parami, "info");
  }
  
  public void onLiveMicSucc(q paramq)
  {
    p.h(paramq, "info");
    long l = paramq.liveId;
    Object localObject2 = paramq.hFJ;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = paramq.hIc;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject4 = paramq.nickName;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    Object localObject5 = paramq.hFG;
    localObject4 = localObject5;
    if (localObject5 == null) {
      localObject4 = "";
    }
    localObject5 = paramq.hFz;
    paramq = (q)localObject5;
    if (localObject5 == null) {
      paramq = "";
    }
    localObject5 = x.hJf;
    x.aHa().a(l, paramq, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4);
  }
  
  public void onOnlineLiveList(v paramv)
  {
    p.h(paramv, "info");
    Object localObject2 = paramv.hIo;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = paramv.content;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    paramv = paramv.dkV;
    if (paramv == null) {
      paramv = "";
    }
    for (;;)
    {
      localObject1 = new ciw().parseFrom(Base64.decode((String)localObject1, 0));
      if (localObject1 == null) {
        throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveInfoList");
      }
      localObject3 = (ciw)localObject1;
      if ((localObject3 != null) && (((ciw)localObject3).gCs != null) && (((ciw)localObject3).gCs.size() > 0))
      {
        int i = kotlin.n.n.a((CharSequence)localObject2, ":", 0, false, 6);
        if (i == -1) {
          break label304;
        }
        if (localObject2 == null) {
          throw new kotlin.t("null cannot be cast to non-null type java.lang.String");
        }
        localObject1 = ((String)localObject2).substring(0, i);
        p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        localObject2 = new LinkedList();
        localObject3 = ((ciw)localObject3).gCs.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          civ localciv = (civ)((Iterator)localObject3).next();
          if (!paramv.equals(localciv.MnN))
          {
            com.tencent.mm.live.b.c.b localb = new com.tencent.mm.live.b.c.b();
            localb.field_liveId = localciv.hyH;
            localb.field_hostRoomId = ((String)localObject1);
            localb.field_liveName = localciv.MnO;
            localb.field_anchorUsername = localciv.MnN;
            localb.field_isSender = false;
            localb.field_timeStamp = localciv.Gaz;
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
    s locals = s.hIl;
    s.release();
    this.hXm.dead();
    this.hXn.dead();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/view/RoomBaseLivePluginLayout$mVoipCallEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class a
    extends IListener<zj>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/view/RoomBaseLivePluginLayout$multiTalkActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MultiTalkActionEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class b
    extends IListener<mu>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.RoomBaseLivePluginLayout
 * JD-Core Version:    0.7.0.1
 */
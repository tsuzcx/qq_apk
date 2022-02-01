package com.tencent.mm.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.os;
import com.tencent.mm.live.core.core.f.d.a;
import com.tencent.mm.live.model.b.a.a;
import com.tencent.mm.live.model.e;
import com.tencent.mm.live.model.j;
import com.tencent.mm.live.model.l.i;
import com.tencent.mm.live.model.o;
import com.tencent.mm.live.model.p;
import com.tencent.mm.live.model.u;
import com.tencent.mm.model.cn;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dip;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/RoomBaseLivePluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mVoipCallEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "multiTalkActionListener", "mount", "", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAnchorCallInterruption", "callInterruption", "", "onAnchorConnectionChange", "onApplyLiveMic", "Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "onBanLiveComment", "Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "onBattleApply", "onBattleClose", "onBattleDismiss", "onBattleEnd", "onBattleStart", "onCloseApplyLiveMic", "Lcom/tencent/mm/live/model/CloseApplyLiveMicInfo;", "onCloseLive", "Lcom/tencent/mm/live/model/CloseLiveInfo;", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onLiveMicSucc", "Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "onOnlineLiveList", "Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "onRandomMicAccept", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgApplyPkInfo;", "onRandomMicApply", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgNotifyApplyRandomMicInfo;", "unMount", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class RoomBaseLivePluginLayout
  extends BaseLivePluginLayout
{
  private final IListener<acn> nnO = (IListener)new IListener(com.tencent.mm.app.f.hfK) {};
  private final IListener<?> nnP = (IListener)new IListener(com.tencent.mm.app.f.hfK) {};
  
  public RoomBaseLivePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void mount()
  {
    super.mount();
    p localp = p.mZf;
    p.a((com.tencent.mm.live.model.g)this);
    this.nnO.alive();
    this.nnP.alive();
  }
  
  public void onAcceptLiveMic(com.tencent.mm.live.model.a parama)
  {
    kotlin.g.b.s.u(parama, "info");
    long l1 = parama.liveId;
    Object localObject1 = parama.mXx;
    int i;
    Object localObject4;
    long l2;
    if (localObject1 == null)
    {
      localObject1 = "";
      i = parama.sdkAppId;
      Object localObject3 = parama.userId;
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      int j = parama.mXz;
      int k = parama.mXy;
      localObject4 = parama.userSig;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
      Object localObject5 = parama.privateMapKey;
      localObject4 = localObject5;
      if (localObject5 == null) {
        localObject4 = "";
      }
      l2 = parama.mXA;
      parama = parama.mXB;
      if (parama != null) {
        break label381;
      }
      parama = null;
      label117:
      localObject4 = Base64.decode((String)localObject4, 0);
      kotlin.g.b.s.s(localObject4, "decode(privateMapKey, 0)");
      localObject5 = Charset.forName("UTF-8");
      kotlin.g.b.s.s(localObject5, "forName(\"UTF-8\")");
      localObject4 = new String((byte[])localObject4, (Charset)localObject5);
      localObject3 = new TRTCCloudDef.TRTCParams(i, (String)localObject2, (String)localObject3, j, (String)localObject4, "");
      localObject5 = l.i.mYH;
      if (k == l.i.bhC()) {
        break label384;
      }
      localObject5 = l.i.mYH;
      if (k != l.i.bhD()) {
        break label384;
      }
      i = 21;
      label207:
      ((TRTCCloudDef.TRTCParams)localObject3).role = i;
      localObject3 = new diy();
      if (!Util.isNullOrNil(parama)) {
        ((diy)localObject3).parseFrom(Base64.decode(parama, 0));
      }
      parama = com.tencent.mm.live.model.k.mYa;
      com.tencent.mm.live.model.k.a((diy)localObject3, null, new com.tencent.mm.live.core.core.model.g(null, 0L, 0, null, 0L, 0L, null, 0, null, 0L, null, null, 131071));
      parama = com.tencent.mm.live.core.core.f.d.mUj;
      d.a.bfM().FO((String)localObject4);
      localObject1 = new a.a(l1, (String)localObject1, "", "", (String)localObject2);
      parama = u.mZl;
      parama = u.bii();
      if (parama != null) {
        break label390;
      }
    }
    label384:
    label390:
    for (parama = null;; parama = parama.mNz)
    {
      if (parama != null) {
        parama.privateMapKey = ((String)localObject4);
      }
      parama = u.mZl;
      u.biN().b((a.a)localObject1);
      parama = u.mZl;
      u.hO(l2);
      parama = o.mZb;
      localObject1 = u.mZl;
      parama.hN(kotlin.k.k.bR((u.bij() - 60L) * 1000L, 60000L));
      return;
      break;
      label381:
      break label117;
      i = 20;
      break label207;
    }
  }
  
  public void onAnchorCallInterruption(boolean paramBoolean) {}
  
  public void onAnchorConnectionChange(boolean paramBoolean) {}
  
  public void onApplyLiveMic(com.tencent.mm.live.model.b paramb)
  {
    kotlin.g.b.s.u(paramb, "info");
    long l = paramb.liveId;
    Object localObject2 = paramb.mXx;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = paramb.mXG;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject4 = paramb.roomId;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    localObject4 = paramb.mXH;
    paramb = (com.tencent.mm.live.model.b)localObject4;
    if (localObject4 == null) {
      paramb = "";
    }
    localObject4 = u.mZl;
    u.biN().a(new a.a(l, (String)localObject1, (String)localObject2, (String)localObject3, paramb));
  }
  
  public void onBanLiveComment(com.tencent.mm.live.model.c paramc)
  {
    boolean bool = true;
    int i = 0;
    kotlin.g.b.s.u(paramc, "info");
    long l = paramc.mXI;
    int j = paramc.mXJ;
    Object localObject = paramc.wording;
    paramc = (com.tencent.mm.live.model.c)localObject;
    if (localObject == null) {
      paramc = "";
    }
    localObject = u.mZl;
    if (u.bie().mMJ == l)
    {
      localObject = u.mZl;
      localObject = u.bie();
      if (j != 1) {
        break label111;
      }
      ((dio)localObject).YLD = bool;
      localObject = u.mZl;
      localObject = u.mZl;
      if (!u.bie().YLD) {
        break label117;
      }
    }
    for (;;)
    {
      u.tC(i);
      localObject = j.mXT;
      j.Gj(paramc);
      return;
      label111:
      bool = false;
      break;
      label117:
      i = cn.getSyncServerTimeSecond();
    }
  }
  
  public void onBattleApply() {}
  
  public void onBattleClose() {}
  
  public void onBattleDismiss() {}
  
  public void onBattleEnd() {}
  
  public void onBattleStart() {}
  
  public void onCloseApplyLiveMic(com.tencent.mm.live.model.d paramd)
  {
    kotlin.g.b.s.u(paramd, "info");
    long l = paramd.liveId;
    boolean bool = paramd.enable;
    paramd = u.mZl;
    u.biN().o(l, bool);
  }
  
  public void onCloseLive(e parame)
  {
    kotlin.g.b.s.u(parame, "info");
    long l = parame.liveId;
    parame = u.mZl;
    u.biN().hR(l);
    parame = u.mZl;
    u.hO(0L);
  }
  
  public void onCloseLiveMic(com.tencent.mm.live.model.f paramf)
  {
    kotlin.g.b.s.u(paramf, "info");
    long l = paramf.liveId;
    Object localObject2 = paramf.mXK;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = paramf.mXx;
    paramf = (com.tencent.mm.live.model.f)localObject2;
    if (localObject2 == null) {
      paramf = "";
    }
    localObject2 = u.mZl;
    u.biN().a(l, (String)localObject1, paramf);
    paramf = o.mZb;
    com.tencent.mm.ae.d.H(o.mZe);
    com.tencent.mm.kernel.h.baD().mCm.b(760, (com.tencent.mm.am.h)paramf);
  }
  
  public void onLiveMicSucc(com.tencent.mm.live.model.n paramn)
  {
    kotlin.g.b.s.u(paramn, "info");
    long l = paramn.liveId;
    Object localObject2 = paramn.mXK;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = paramn.mZa;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject4 = paramn.nickName;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    Object localObject5 = paramn.mXH;
    localObject4 = localObject5;
    if (localObject5 == null) {
      localObject4 = "";
    }
    localObject5 = paramn.mXx;
    paramn = (com.tencent.mm.live.model.n)localObject5;
    if (localObject5 == null) {
      paramn = "";
    }
    localObject5 = u.mZl;
    u.biN().a(l, paramn, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4);
  }
  
  public void onOnlineLiveList(com.tencent.mm.live.model.s params)
  {
    kotlin.g.b.s.u(params, "info");
    Object localObject2 = params.mZj;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = params.content;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    params = params.hgl;
    if (params == null) {
      params = "";
    }
    for (;;)
    {
      localObject1 = new dip().parseFrom(Base64.decode((String)localObject1, 0));
      if (localObject1 != null) {
        break;
      }
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveInfoList");
    }
    localObject3 = (dip)localObject1;
    if ((((dip)localObject3).lPK != null) && (((dip)localObject3).lPK.size() > 0))
    {
      int i = kotlin.n.n.a((CharSequence)localObject2, ":", 0, false, 6);
      if (i == -1) {
        break label286;
      }
      localObject1 = ((String)localObject2).substring(0, i);
      kotlin.g.b.s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      localObject2 = new LinkedList();
      localObject3 = ((dip)localObject3).lPK.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        dio localdio = (dio)((Iterator)localObject3).next();
        if (!params.equals(localdio.aaNp))
        {
          com.tencent.mm.live.model.c.b localb = new com.tencent.mm.live.model.c.b();
          localb.field_liveId = localdio.mMJ;
          localb.field_hostRoomId = ((String)localObject1);
          localb.field_liveName = localdio.aaNq;
          localb.field_anchorUsername = localdio.aaNp;
          localb.field_isSender = false;
          localb.field_timeStamp = localdio.HTK;
          ((LinkedList)localObject2).add(localb);
        }
      }
      com.tencent.mm.live.model.c.c.getLiveTipsBarStorage().a((LinkedList)localObject2, (String)localObject1);
      return;
      label286:
      localObject1 = "";
    }
  }
  
  public void onRandomMicAccept(bdm parambdm, bdt parambdt)
  {
    kotlin.g.b.s.u(parambdm, "appMsg");
    kotlin.g.b.s.u(parambdt, "info");
  }
  
  public void onRandomMicApply(bem parambem)
  {
    kotlin.g.b.s.u(parambem, "info");
  }
  
  public void unMount()
  {
    super.unMount();
    p localp = p.mZf;
    p.release();
    this.nnO.dead();
    this.nnP.dead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.RoomBaseLivePluginLayout
 * JD-Core Version:    0.7.0.1
 */
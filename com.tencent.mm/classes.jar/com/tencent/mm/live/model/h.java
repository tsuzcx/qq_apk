package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/JoinLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "liveId", "", "wechatRoomId", "", "liveName", "isAnchor", "", "(JLjava/lang/String;Ljava/lang/String;Z)V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "ret", "errMsg", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "", "join", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements com.tencent.mm.am.h
{
  public static final h.a mXN;
  private final boolean hKC;
  private final long liveId;
  private final String mIA;
  private final String mXO;
  private r<? super Integer, ? super String, ? super g, ? super TRTCCloudDef.TRTCParams, ah> mXP;
  
  static
  {
    AppMethodBeat.i(246570);
    mXN = new h.a((byte)0);
    AppMethodBeat.o(246570);
  }
  
  private h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(246557);
    this.liveId = paramLong;
    this.mXO = paramString1;
    this.mIA = paramString2;
    this.hKC = false;
    AppMethodBeat.o(246557);
  }
  
  public final void a(r<? super Integer, ? super String, ? super g, ? super TRTCCloudDef.TRTCParams, ah> paramr)
  {
    AppMethodBeat.i(246578);
    com.tencent.mm.kernel.h.baD().mCm.a(3797, (com.tencent.mm.am.h)this);
    long l = this.liveId;
    Object localObject = this.mXO;
    u localu = u.mZl;
    localObject = new com.tencent.mm.live.model.a.o(l, (String)localObject, u.bid());
    com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
    this.mXP = paramr;
    AppMethodBeat.o(246578);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(246599);
    Object localObject1;
    Object localObject2;
    if ((paramp instanceof com.tencent.mm.live.model.a.o))
    {
      Log.i("MicroMsg.JoinLiveRoom", "JoinLiveRoom on SceneEnd");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i("MicroMsg.JoinLiveRoom", "join live room failed " + paramInt1 + ' ' + paramInt2);
        localObject1 = this.mXP;
        if (localObject1 != null)
        {
          paramp = paramString;
          if (paramString == null) {
            paramp = "";
          }
          paramString = com.tencent.mm.live.core.core.model.h.mNy;
          paramString = com.tencent.mm.live.core.core.model.h.beo();
          localObject2 = com.tencent.mm.live.core.core.model.h.mNy;
          ((r)localObject1).a(Integer.valueOf(paramInt2), paramp, paramString, com.tencent.mm.live.core.core.model.h.ben());
        }
        com.tencent.mm.kernel.h.baD().mCm.b(3797, (com.tencent.mm.am.h)this);
      }
    }
    else
    {
      AppMethodBeat.o(246599);
      return;
    }
    paramString = ((com.tencent.mm.live.model.a.o)paramp).nbi;
    paramp = u.mZl;
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.ZOg)
    {
      u.a(paramString);
      paramString = u.mZl;
      dix localdix = u.bif();
      if (localdix == null) {
        break;
      }
      localObject1 = new TRTCCloudDef.TRTCParams();
      localObject2 = new g(null, 0L, 0, null, 0L, 0L, null, 0, null, 0L, null, null, 131071);
      paramString = k.mYa;
      paramString = u.mZl;
      paramp = u.bie().Zqd;
      paramString = paramp;
      if (paramp == null) {
        paramString = "";
      }
      paramp = u.mZl;
      k.a(paramString, localdix, u.bie(), (TRTCCloudDef.TRTCParams)localObject1, (g)localObject2);
      if (this.hKC)
      {
        paramString = e.b.mKf;
        ((g)localObject2).mNn = e.b.bct();
      }
      long l = kotlin.k.k.bR((localdix.aaOy - 60L) * 1000L, 60000L);
      o.mZb.hM(l);
      paramString = this.mXP;
      if (paramString == null) {
        break;
      }
      paramString.a(Integer.valueOf(0), "", localObject2, localObject1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.model.h
 * JD-Core Version:    0.7.0.1
 */
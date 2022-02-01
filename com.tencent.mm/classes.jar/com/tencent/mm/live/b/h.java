package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.model.f;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/JoinLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "liveId", "", "wechatRoomId", "", "liveName", "isAnchor", "", "(JLjava/lang/String;Ljava/lang/String;Z)V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "ret", "errMsg", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "", "join", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-logic_release"})
public final class h
  implements com.tencent.mm.an.i
{
  public static final a ktV;
  private final boolean fFE;
  private final String kie;
  private r<? super Integer, ? super String, ? super f, ? super TRTCCloudDef.TRTCParams, x> ktT;
  private final String ktU;
  private final long liveId;
  
  static
  {
    AppMethodBeat.i(196165);
    ktV = new a((byte)0);
    AppMethodBeat.o(196165);
  }
  
  private h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(196160);
    this.liveId = paramLong;
    this.ktU = paramString1;
    this.kie = paramString2;
    this.fFE = false;
    AppMethodBeat.o(196160);
  }
  
  public final void a(r<? super Integer, ? super String, ? super f, ? super TRTCCloudDef.TRTCParams, x> paramr)
  {
    AppMethodBeat.i(196139);
    Object localObject1 = com.tencent.mm.kernel.h.aHF();
    p.j(localObject1, "MMKernel.network()");
    ((c)localObject1).aGY().a(3797, (com.tencent.mm.an.i)this);
    long l = this.liveId;
    localObject1 = this.ktU;
    Object localObject2 = u.kwz;
    localObject1 = new com.tencent.mm.live.b.a.o(l, (String)localObject1, u.aOq());
    localObject2 = com.tencent.mm.kernel.h.aHF();
    p.j(localObject2, "MMKernel.network()");
    ((c)localObject2).aGY().b((q)localObject1);
    this.ktT = paramr;
    AppMethodBeat.o(196139);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(196156);
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof com.tencent.mm.live.b.a.o))
    {
      Log.i("MicroMsg.JoinLiveRoom", "JoinLiveRoom on SceneEnd");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i("MicroMsg.JoinLiveRoom", "join live room failed " + paramInt1 + ' ' + paramInt2);
        localObject1 = this.ktT;
        if (localObject1 != null)
        {
          paramq = paramString;
          if (paramString == null) {
            paramq = "";
          }
          paramString = g.kmu;
          paramString = g.aLk();
          localObject2 = g.kmu;
          ((r)localObject1).a(Integer.valueOf(paramInt2), paramq, paramString, g.aLj());
        }
        paramString = com.tencent.mm.kernel.h.aHF();
        p.j(paramString, "MMKernel.network()");
        paramString.aGY().b(3797, (com.tencent.mm.an.i)this);
      }
    }
    else
    {
      AppMethodBeat.o(196156);
      return;
    }
    paramString = ((com.tencent.mm.live.b.a.o)paramq).kxI;
    paramq = u.kwz;
    if (paramString != null) {}
    for (paramString = paramString.SJL;; paramString = null)
    {
      u.a(paramString);
      paramString = u.kwz;
      crw localcrw = u.aOs();
      if (localcrw == null) {
        break;
      }
      localObject1 = new TRTCCloudDef.TRTCParams();
      localObject2 = new f(null, 0L, 0, null, 0L, 0L, null, null, 0L, null, 8191);
      paramString = k.kuf;
      paramString = u.kwz;
      paramq = u.aOr().Srb;
      paramString = paramq;
      if (paramq == null) {
        paramString = "";
      }
      paramq = u.kwz;
      k.a(paramString, localcrw, u.aOr(), (TRTCCloudDef.TRTCParams)localObject1, (f)localObject2);
      if (this.fFE)
      {
        paramString = e.b.kjz;
        ((f)localObject2).kmi = e.b.aJJ();
      }
      long l = kotlin.k.i.be((localcrw.Tzr - 60L) * 1000L, 60000L);
      o.kvA.FG(l);
      paramString = this.ktT;
      if (paramString == null) {
        break;
      }
      paramString.a(Integer.valueOf(0), "", localObject2, localObject1);
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/JoinLiveRoom$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.h
 * JD-Core Version:    0.7.0.1
 */
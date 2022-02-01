package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.a.r;
import d.g.b.p;
import d.k.j;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/JoinLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "liveId", "", "wechatRoomId", "", "liveName", "isAnchor", "", "(JLjava/lang/String;Ljava/lang/String;Z)V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "ret", "errMsg", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "", "join", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-logic_release"})
public final class a
  implements f
{
  public static final a gPo;
  private final boolean dzz;
  private final long gJh;
  private final String gJj;
  private r<? super Integer, ? super String, ? super c, ? super TRTCCloudDef.TRTCParams, z> gPm;
  private final String gPn;
  
  static
  {
    AppMethodBeat.i(215639);
    gPo = new a((byte)0);
    AppMethodBeat.o(215639);
  }
  
  private a(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(215638);
    this.gJh = paramLong;
    this.gPn = paramString1;
    this.gJj = paramString2;
    this.dzz = false;
    AppMethodBeat.o(215638);
  }
  
  public final void a(r<? super Integer, ? super String, ? super c, ? super TRTCCloudDef.TRTCParams, z> paramr)
  {
    AppMethodBeat.i(215636);
    Object localObject1 = com.tencent.mm.kernel.g.ajQ();
    p.g(localObject1, "MMKernel.network()");
    ((b)localObject1).ajj().a(3797, (f)this);
    long l = this.gJh;
    localObject1 = this.gPn;
    Object localObject2 = g.gQZ;
    localObject1 = new o(l, (String)localObject1, g.anG());
    localObject2 = com.tencent.mm.kernel.g.ajQ();
    p.g(localObject2, "MMKernel.network()");
    ((b)localObject2).ajj().b((n)localObject1);
    this.gPm = paramr;
    AppMethodBeat.o(215636);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(215637);
    Object localObject1;
    Object localObject2;
    if ((paramn instanceof o))
    {
      ae.i("MicroMsg.JoinLiveRoom", "JoinLiveRoom on SceneEnd");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.i("MicroMsg.JoinLiveRoom", "join live room failed " + paramInt1 + ' ' + paramInt2);
        localObject1 = this.gPm;
        if (localObject1 != null)
        {
          paramn = paramString;
          if (paramString == null) {
            paramn = "";
          }
          paramString = d.gKq;
          paramString = d.alQ();
          localObject2 = d.gKq;
          ((r)localObject1).a(Integer.valueOf(paramInt2), paramn, paramString, d.alP());
        }
        paramString = com.tencent.mm.kernel.g.ajQ();
        p.g(paramString, "MMKernel.network()");
        paramString.ajj().b(3797, (f)this);
      }
    }
    else
    {
      AppMethodBeat.o(215637);
      return;
    }
    paramString = ((o)paramn).gSR;
    paramn = g.gQZ;
    if (paramString != null) {}
    for (paramString = paramString.Hgi;; paramString = null)
    {
      g.a(paramString);
      paramString = g.gQZ;
      bvq localbvq = g.anI();
      if (localbvq == null) {
        break;
      }
      localObject1 = new TRTCCloudDef.TRTCParams();
      localObject2 = new c(null, 0L, null, 0, null, 0L, 0L, 127);
      paramString = e.gPA;
      paramString = g.gQZ;
      paramn = g.anH().Gud;
      paramString = paramn;
      if (paramn == null) {
        paramString = "";
      }
      paramn = g.gQZ;
      e.a(paramString, localbvq, g.anH(), (TRTCCloudDef.TRTCParams)localObject1, (c)localObject2);
      if (this.dzz)
      {
        paramString = c.a.gJD;
        ((c)localObject2).gKh = c.a.alz();
      }
      long l = j.aG((localbvq.HiE - 60L) * 1000L, 60000L);
      i.gRP.rx(l);
      paramString = this.gPm;
      if (paramString == null) {
        break;
      }
      paramString.a(Integer.valueOf(0), "", localObject2, localObject1);
      break;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/JoinLiveRoom$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a
 * JD-Core Version:    0.7.0.1
 */
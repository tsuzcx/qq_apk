package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.a.r;
import d.g.b.p;
import d.k.h;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/JoinLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "liveId", "", "wechatRoomId", "", "liveName", "isAnchor", "", "(JLjava/lang/String;Ljava/lang/String;Z)V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "ret", "errMsg", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "", "join", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-logic_release"})
public final class a
  implements f
{
  public static final a gMF;
  private final boolean dyu;
  private final String gGA;
  private final long gGy;
  private r<? super Integer, ? super String, ? super c, ? super TRTCCloudDef.TRTCParams, z> gMD;
  private final String gME;
  
  static
  {
    AppMethodBeat.i(212020);
    gMF = new a((byte)0);
    AppMethodBeat.o(212020);
  }
  
  private a(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(212019);
    this.gGy = paramLong;
    this.gME = paramString1;
    this.gGA = paramString2;
    this.dyu = false;
    AppMethodBeat.o(212019);
  }
  
  public final void a(r<? super Integer, ? super String, ? super c, ? super TRTCCloudDef.TRTCParams, z> paramr)
  {
    AppMethodBeat.i(212017);
    Object localObject1 = com.tencent.mm.kernel.g.ajB();
    p.g(localObject1, "MMKernel.network()");
    ((b)localObject1).aiU().a(3797, (f)this);
    long l = this.gGy;
    localObject1 = this.gME;
    Object localObject2 = g.gOr;
    localObject1 = new o(l, (String)localObject1, g.anq());
    localObject2 = com.tencent.mm.kernel.g.ajB();
    p.g(localObject2, "MMKernel.network()");
    ((b)localObject2).aiU().b((n)localObject1);
    this.gMD = paramr;
    AppMethodBeat.o(212017);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(212018);
    Object localObject1;
    Object localObject2;
    if ((paramn instanceof o))
    {
      ad.i("MicroMsg.JoinLiveRoom", "JoinLiveRoom on SceneEnd");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.i("MicroMsg.JoinLiveRoom", "join live room failed " + paramInt1 + ' ' + paramInt2);
        localObject1 = this.gMD;
        if (localObject1 != null)
        {
          paramn = paramString;
          if (paramString == null) {
            paramn = "";
          }
          paramString = d.gHH;
          paramString = d.alB();
          localObject2 = d.gHH;
          ((r)localObject1).a(Integer.valueOf(paramInt2), paramn, paramString, d.alA());
        }
        paramString = com.tencent.mm.kernel.g.ajB();
        p.g(paramString, "MMKernel.network()");
        paramString.aiU().b(3797, (f)this);
      }
    }
    else
    {
      AppMethodBeat.o(212018);
      return;
    }
    paramString = ((o)paramn).gQj;
    paramn = g.gOr;
    if (paramString != null) {}
    for (paramString = paramString.GMH;; paramString = null)
    {
      g.a(paramString);
      paramString = g.gOr;
      buw localbuw = g.ant();
      if (localbuw == null) {
        break;
      }
      localObject1 = new TRTCCloudDef.TRTCParams();
      localObject2 = new c(null, 0L, null, 0, null, 0L, 0L, 127);
      paramString = e.gMR;
      paramString = g.gOr;
      paramn = g.ans().Gbw;
      paramString = paramn;
      if (paramn == null) {
        paramString = "";
      }
      paramn = g.gOr;
      e.a(paramString, localbuw, g.ans(), (TRTCCloudDef.TRTCParams)localObject1, (c)localObject2);
      if (this.dyu)
      {
        paramString = c.a.gGU;
        ((c)localObject2).gHy = c.a.alk();
      }
      long l = h.aH((localbuw.GPc - 60L) * 1000L, 60000L);
      i.gPh.rk(l);
      paramString = this.gMD;
      if (paramString == null) {
        break;
      }
      paramString.a(Integer.valueOf(0), "", localObject2, localObject1);
      break;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/JoinLiveRoom$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a
 * JD-Core Version:    0.7.0.1
 */
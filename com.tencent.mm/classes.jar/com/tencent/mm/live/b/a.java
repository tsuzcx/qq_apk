package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.a.r;
import d.g.b.k;
import d.k.h;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/JoinLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "liveId", "", "wechatRoomId", "", "liveName", "isAnchor", "", "(JLjava/lang/String;Ljava/lang/String;Z)V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "ret", "errMsg", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "", "join", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-logic_release"})
public final class a
  implements com.tencent.mm.ak.g
{
  public static final a.a gsU;
  private final boolean dmG;
  private final long gmP;
  private final String gmR;
  private r<? super Integer, ? super String, ? super c, ? super TRTCCloudDef.TRTCParams, y> gsS;
  private final String gsT;
  
  static
  {
    AppMethodBeat.i(189734);
    gsU = new a.a((byte)0);
    AppMethodBeat.o(189734);
  }
  
  private a(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(189733);
    this.gmP = paramLong;
    this.gsT = paramString1;
    this.gmR = paramString2;
    this.dmG = false;
    AppMethodBeat.o(189733);
  }
  
  public final void a(r<? super Integer, ? super String, ? super c, ? super TRTCCloudDef.TRTCParams, y> paramr)
  {
    AppMethodBeat.i(189731);
    Object localObject1 = com.tencent.mm.kernel.g.agQ();
    k.g(localObject1, "MMKernel.network()");
    ((b)localObject1).agi().a(3797, (com.tencent.mm.ak.g)this);
    long l = this.gmP;
    localObject1 = this.gsT;
    Object localObject2 = g.guG;
    localObject1 = new o(l, (String)localObject1, g.akE());
    localObject2 = com.tencent.mm.kernel.g.agQ();
    k.g(localObject2, "MMKernel.network()");
    ((b)localObject2).agi().b((n)localObject1);
    this.gsS = paramr;
    AppMethodBeat.o(189731);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(189732);
    Object localObject1;
    Object localObject2;
    if ((paramn instanceof o))
    {
      ac.i("MicroMsg.JoinLiveRoom", "JoinLiveRoom on SceneEnd");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.i("MicroMsg.JoinLiveRoom", "join live room failed " + paramInt1 + ' ' + paramInt2);
        localObject1 = this.gsS;
        if (localObject1 != null)
        {
          paramn = paramString;
          if (paramString == null) {
            paramn = "";
          }
          paramString = d.gnY;
          paramString = d.aiP();
          localObject2 = d.gnY;
          ((r)localObject1).a(Integer.valueOf(paramInt2), paramn, paramString, d.aiO());
        }
        paramString = com.tencent.mm.kernel.g.agQ();
        k.g(paramString, "MMKernel.network()");
        paramString.agi().b(3797, (com.tencent.mm.ak.g)this);
      }
    }
    else
    {
      AppMethodBeat.o(189732);
      return;
    }
    paramString = ((o)paramn).gwy;
    paramn = g.guG;
    if (paramString != null) {}
    for (paramString = paramString.Fdh;; paramString = null)
    {
      g.a(paramString);
      paramString = g.guG;
      bqj localbqj = g.akG();
      if (localbqj == null) {
        break;
      }
      localObject1 = new TRTCCloudDef.TRTCParams();
      localObject2 = new c(null, 0L, null, 0, null, 0L, 0L, 127);
      paramString = e.gtg;
      paramString = g.guG;
      paramn = g.akF().Eud;
      paramString = paramn;
      if (paramn == null) {
        paramString = "";
      }
      paramn = g.guG;
      e.a(paramString, localbqj, g.akF(), (TRTCCloudDef.TRTCParams)localObject1, (c)localObject2);
      if (this.dmG)
      {
        paramString = c.a.gnl;
        ((c)localObject2).gnP = c.a.aiy();
      }
      long l = h.aC((localbqj.Ffy - 60L) * 1000L, 60000L);
      i.gvw.pj(l);
      paramString = this.gsS;
      if (paramString == null) {
        break;
      }
      paramString.a(Integer.valueOf(0), "", localObject2, localObject1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.a
 * JD-Core Version:    0.7.0.1
 */
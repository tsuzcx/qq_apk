package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/JoinLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "liveId", "", "wechatRoomId", "", "liveName", "isAnchor", "", "(JLjava/lang/String;Ljava/lang/String;Z)V", "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "ret", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "", "join", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-logic_release"})
public final class a
  implements com.tencent.mm.al.g
{
  public static final a qWn;
  private final long DlB;
  private final boolean aWl;
  private final String qVO;
  private final String qud;
  private d.g.a.q<? super Integer, ? super c, ? super TRTCCloudDef.TRTCParams, y> rDO;
  
  static
  {
    AppMethodBeat.i(202562);
    qWn = new a((byte)0);
    AppMethodBeat.o(202562);
  }
  
  private a(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(202561);
    this.DlB = paramLong;
    this.qVO = paramString1;
    this.qud = paramString2;
    this.aWl = false;
    AppMethodBeat.o(202561);
  }
  
  public final void d(d.g.a.q<? super Integer, ? super c, ? super TRTCCloudDef.TRTCParams, y> paramq)
  {
    AppMethodBeat.i(202559);
    Object localObject1 = com.tencent.mm.kernel.g.afA();
    k.g(localObject1, "MMKernel.network()");
    ((b)localObject1).aeS().a(3797, (com.tencent.mm.al.g)this);
    long l = this.DlB;
    localObject1 = this.qVO;
    Object localObject2 = f.rGw;
    localObject1 = new com.tencent.mm.live.b.a.n(l, (String)localObject1, f.eNF());
    localObject2 = com.tencent.mm.kernel.g.afA();
    k.g(localObject2, "MMKernel.network()");
    ((b)localObject2).aeS().b((com.tencent.mm.al.n)localObject1);
    this.rDO = paramq;
    AppMethodBeat.o(202559);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(202560);
    Object localObject;
    if ((paramn instanceof com.tencent.mm.live.b.a.n))
    {
      ad.i("MicroMsg.JoinLiveRoom", "JoinLiveRoom on SceneEnd");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.i("MicroMsg.JoinLiveRoom", "join live room failed " + paramInt1 + ' ' + paramInt2);
        paramString = this.rDO;
        if (paramString != null)
        {
          paramn = com.tencent.mm.live.core.core.b.d.qzw;
          paramn = com.tencent.mm.live.core.core.b.d.cnt();
          localObject = com.tencent.mm.live.core.core.b.d.qzw;
          paramString.d(Integer.valueOf(paramInt2), paramn, com.tencent.mm.live.core.core.b.d.cns());
        }
        paramString = com.tencent.mm.kernel.g.afA();
        k.g(paramString, "MMKernel.network()");
        paramString.aeS().b(3797, (com.tencent.mm.al.g)this);
      }
    }
    else
    {
      AppMethodBeat.o(202560);
      return;
    }
    paramString = ((com.tencent.mm.live.b.a.n)paramn).zcc;
    paramn = f.rGw;
    if (paramString != null) {}
    for (paramString = paramString.LyW;; paramString = null)
    {
      f.a(paramString);
      paramString = f.rGw;
      eaw localeaw = f.eNH();
      if (localeaw == null) {
        break;
      }
      localObject = new TRTCCloudDef.TRTCParams();
      c localc = new c(null, 0L, null, 0, null, 0L, 0L, 127);
      paramString = d.qYj;
      paramString = f.rGw;
      paramn = f.eNG().LwZ;
      paramString = paramn;
      if (paramn == null) {
        paramString = "";
      }
      paramn = f.rGw;
      d.a(paramString, localeaw, f.eNG(), (TRTCCloudDef.TRTCParams)localObject, localc);
      if (this.aWl)
      {
        paramString = c.a.qxl;
        localc.qzb = c.a.clK();
      }
      long l = d.k.h.aH((localeaw.Lzy - 60L) * 1000L, 60000L);
      h.xfu.Bh(l);
      paramString = this.rDO;
      if (paramString == null) {
        break;
      }
      paramString.d(Integer.valueOf(0), localc, localObject);
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/JoinLiveRoom$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a
 * JD-Core Version:    0.7.0.1
 */
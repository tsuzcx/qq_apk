package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.protocal.protobuf.cfd;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/JoinLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "liveId", "", "wechatRoomId", "", "liveName", "isAnchor", "", "(JLjava/lang/String;Ljava/lang/String;Z)V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "ret", "errMsg", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "", "join", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-logic_release"})
public final class k
  implements i
{
  public static final a hFX;
  private final boolean dMz;
  private kotlin.g.a.r<? super Integer, ? super String, ? super e, ? super TRTCCloudDef.TRTCParams, kotlin.x> hFV;
  private final String hFW;
  private final String hwb;
  private final long liveId;
  
  static
  {
    AppMethodBeat.i(207576);
    hFX = new a((byte)0);
    AppMethodBeat.o(207576);
  }
  
  private k(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207575);
    this.liveId = paramLong;
    this.hFW = paramString1;
    this.hwb = paramString2;
    this.dMz = false;
    AppMethodBeat.o(207575);
  }
  
  public final void a(kotlin.g.a.r<? super Integer, ? super String, ? super e, ? super TRTCCloudDef.TRTCParams, kotlin.x> paramr)
  {
    AppMethodBeat.i(207573);
    Object localObject1 = g.aAg();
    p.g(localObject1, "MMKernel.network()");
    ((b)localObject1).azz().a(3797, (i)this);
    long l = this.liveId;
    localObject1 = this.hFW;
    Object localObject2 = x.hJf;
    localObject1 = new o(l, (String)localObject1, x.aGq());
    localObject2 = g.aAg();
    p.g(localObject2, "MMKernel.network()");
    ((b)localObject2).azz().b((q)localObject1);
    this.hFV = paramr;
    AppMethodBeat.o(207573);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(207574);
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof o))
    {
      Log.i("MicroMsg.JoinLiveRoom", "JoinLiveRoom on SceneEnd");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i("MicroMsg.JoinLiveRoom", "join live room failed " + paramInt1 + ' ' + paramInt2);
        localObject1 = this.hFV;
        if (localObject1 != null)
        {
          paramq = paramString;
          if (paramString == null) {
            paramq = "";
          }
          paramString = f.hzy;
          paramString = f.aDr();
          localObject2 = f.hzy;
          ((kotlin.g.a.r)localObject1).invoke(Integer.valueOf(paramInt2), paramq, paramString, f.aDq());
        }
        paramString = g.aAg();
        p.g(paramString, "MMKernel.network()");
        paramString.azz().b(3797, (i)this);
      }
    }
    else
    {
      AppMethodBeat.o(207574);
      return;
    }
    paramString = ((o)paramq).hKo;
    paramq = x.hJf;
    if (paramString != null) {}
    for (paramString = paramString.LFH;; paramString = null)
    {
      x.a(paramString);
      paramString = x.hJf;
      cjb localcjb = x.aGs();
      if (localcjb == null) {
        break;
      }
      localObject1 = new TRTCCloudDef.TRTCParams();
      localObject2 = new e(null, 0L, 0, null, 0L, 0L, 0, null, null, 0L, 4095);
      paramString = n.hGh;
      paramString = x.hJf;
      paramq = x.aGr().LpF;
      paramString = paramq;
      if (paramq == null) {
        paramString = "";
      }
      paramq = x.hJf;
      n.a(paramString, localcjb, x.aGr(), (TRTCCloudDef.TRTCParams)localObject1, (e)localObject2);
      if (this.dMz)
      {
        paramString = e.a.hxc;
        ((e)localObject2).hzl = e.a.aCe();
      }
      long l = j.aM((localcjb.Mor - 60L) * 1000L, 60000L);
      r.hIg.zz(l);
      paramString = this.hFV;
      if (paramString == null) {
        break;
      }
      paramString.invoke(Integer.valueOf(0), "", localObject2, localObject1);
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/JoinLiveRoom$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.k
 * JD-Core Version:    0.7.0.1
 */
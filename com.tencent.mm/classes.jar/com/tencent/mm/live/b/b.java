package com.tencent.mm.live.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.debug.a;
import com.tencent.mm.protocal.protobuf.dxz;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.a.r;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LaunchLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "name", "", "roomId", "context", "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "createCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "success", "needFaceVerify", "verifyUrl", "", "errCode", "", "joinCallback", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "getName", "()Ljava/lang/String;", "getRoomId", "createLive", "callback", "joinLive", "launch", "Lkotlin/Function6;", "onSceneEnd", "errType", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "processCreateLiveResponse", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "processJoinLiveResponse", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "Companion", "plugin-logic_release"})
public final class b
  implements com.tencent.mm.al.g
{
  public static final a qXz;
  private final Context context;
  public final String name;
  public r<? super Boolean, ? super Boolean, ? super String, ? super Integer, y> qWR;
  public r<? super Boolean, ? super Integer, ? super c, ? super TRTCCloudDef.TRTCParams, y> qWS;
  public final String roomId;
  
  static
  {
    AppMethodBeat.i(202565);
    qXz = new a((byte)0);
    AppMethodBeat.o(202565);
  }
  
  public b(String paramString1, String paramString2, Context paramContext)
  {
    AppMethodBeat.i(202564);
    this.name = paramString1;
    this.roomId = paramString2;
    this.context = paramContext;
    AppMethodBeat.o(202564);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(202563);
    Object localObject1;
    label280:
    Object localObject2;
    if ((paramn instanceof com.tencent.mm.live.b.a.k))
    {
      localObject1 = a.qOL;
      a.aUc("anchor create live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
        paramString = this.qWR;
        if (paramString != null)
        {
          paramn = Boolean.FALSE;
          paramString.a(paramn, paramn, "", Integer.valueOf(paramInt2));
        }
      }
      for (;;)
      {
        paramString = com.tencent.mm.kernel.g.afA();
        d.g.b.k.g(paramString, "MMKernel.network()");
        paramString.aeS().b(3501, (com.tencent.mm.al.g)this);
        AppMethodBeat.o(202563);
        return;
        paramString = ((com.tencent.mm.live.b.a.k)paramn).zbO;
        if (paramString != null)
        {
          if (bu.eGT())
          {
            paramn = e.e.rBl;
            paramn = ax.aFD(e.e.equ());
            localObject1 = e.g.rFz;
            if (!paramn.getBoolean(e.g.eNc(), false)) {}
          }
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if ((paramInt1 != 0) || (!paramString.LwD)) {
              break label280;
            }
            paramString = paramString.Lxa;
            if (paramString != null)
            {
              paramn = f.rGw;
              f.a(paramString);
              paramString = new StringBuilder("processCreateLiveResponse live_id:");
              paramn = f.rGw;
              ad.i("MicroMsg.LaunchLiveRoom", f.eNG().LwA);
            }
            paramString = this.qWR;
            if (paramString == null) {
              break;
            }
            paramString.a(Boolean.TRUE, Boolean.FALSE, "", Integer.valueOf(paramInt2));
            break;
          }
          if (bt.isNullOrNil(paramString.LwE))
          {
            paramString = this.qWR;
            if (paramString != null)
            {
              paramn = Boolean.FALSE;
              paramString.a(paramn, paramn, "", Integer.valueOf(paramInt2));
            }
          }
          else
          {
            paramn = this.qWR;
            if (paramn != null)
            {
              localObject1 = Boolean.FALSE;
              localObject2 = Boolean.TRUE;
              paramString = paramString.LwE;
              d.g.b.k.g(paramString, "response.verify_url");
              paramn.a(localObject1, localObject2, paramString, Integer.valueOf(paramInt2));
            }
          }
        }
        else
        {
          paramString = this.qWR;
          if (paramString != null)
          {
            paramn = Boolean.FALSE;
            paramString.a(paramn, paramn, "", Integer.valueOf(paramInt2));
          }
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.live.b.a.n))
    {
      localObject1 = a.qOL;
      a.aUc("visitor join live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label554;
      }
      ad.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
      paramString = this.qWS;
      if (paramString != null)
      {
        paramn = Boolean.FALSE;
        localObject1 = com.tencent.mm.live.core.core.b.d.qzw;
        localObject1 = com.tencent.mm.live.core.core.b.d.cnt();
        localObject2 = com.tencent.mm.live.core.core.b.d.qzw;
        paramString.a(paramn, Integer.valueOf(paramInt2), localObject1, com.tencent.mm.live.core.core.b.d.cns());
      }
    }
    for (;;)
    {
      paramString = com.tencent.mm.kernel.g.afA();
      d.g.b.k.g(paramString, "MMKernel.network()");
      paramString.aeS().b(3797, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(202563);
      return;
      label554:
      paramString = ((com.tencent.mm.live.b.a.n)paramn).zcc;
      if (paramString != null)
      {
        paramString = paramString.LyW;
        if (paramString != null)
        {
          paramn = f.rGw;
          f.a(paramString);
          localObject1 = new TRTCCloudDef.TRTCParams();
          paramString = this.name;
          paramn = f.rGw;
          localObject2 = new c(paramString, f.eNG().LwA, null, 0, null, 0L, 0L, 124);
          paramString = d.qYj;
          String str = this.name;
          paramString = f.rGw;
          eas localeas = f.eNG();
          paramString = f.rGw;
          paramn = f.eNH();
          paramString = paramn;
          if (paramn == null) {
            paramString = new eaw();
          }
          d.a(str, paramString, localeas, (TRTCCloudDef.TRTCParams)localObject1, (c)localObject2);
          paramString = c.a.qxl;
          ((c)localObject2).qzb = c.a.clK();
          paramString = f.rGw;
          paramString = f.eNH();
          if (paramString != null) {}
          for (long l = paramString.Lzy;; l = 0L)
          {
            l = d.k.h.aH((l - 60L) * 1000L, 60000L);
            h.xfu.Bh(l);
            paramString = this.qWS;
            if (paramString == null) {
              break;
            }
            paramString.a(Boolean.TRUE, Integer.valueOf(0), localObject2, localObject1);
            break;
          }
        }
      }
      else
      {
        paramString = this.qWS;
        if (paramString != null)
        {
          paramn = Boolean.FALSE;
          localObject1 = com.tencent.mm.live.core.core.b.d.qzw;
          localObject1 = com.tencent.mm.live.core.core.b.d.cnt();
          localObject2 = com.tencent.mm.live.core.core.b.d.qzw;
          paramString.a(paramn, Integer.valueOf(paramInt2), localObject1, com.tencent.mm.live.core.core.b.d.cns());
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LaunchLiveRoom$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.b
 * JD-Core Version:    0.7.0.1
 */
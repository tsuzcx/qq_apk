package com.tencent.mm.live.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.debug.a;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.a.s;
import d.g.b.k;
import d.k.h;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LaunchLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "name", "", "roomId", "context", "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "createCallback", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "success", "needFaceVerify", "verifyUrl", "", "errCode", "errMsg", "", "joinCallback", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "getName", "()Ljava/lang/String;", "getRoomId", "createLive", "callback", "joinLive", "launch", "Lkotlin/Function6;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "processCreateLiveResponse", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "processJoinLiveResponse", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "Companion", "plugin-logic_release"})
public final class b
  implements com.tencent.mm.ak.g
{
  public static final b.a gsX;
  private final Context context;
  public s<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super String, y> gsV;
  public s<? super Boolean, ? super Integer, ? super String, ? super c, ? super TRTCCloudDef.TRTCParams, y> gsW;
  public final String name;
  public final String roomId;
  
  static
  {
    AppMethodBeat.i(189737);
    gsX = new b.a((byte)0);
    AppMethodBeat.o(189737);
  }
  
  public b(String paramString1, String paramString2, Context paramContext)
  {
    AppMethodBeat.i(189736);
    this.name = paramString1;
    this.roomId = paramString2;
    this.context = paramContext;
    AppMethodBeat.o(189736);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(189735);
    Object localObject1;
    if ((paramn instanceof com.tencent.mm.live.b.a.l))
    {
      localObject1 = a.gqF;
      a.uG("anchor create live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
        paramn = this.gsV;
        if (paramn != null)
        {
          localObject1 = Boolean.FALSE;
          if (paramString != null) {
            break label944;
          }
          paramString = "";
        }
      }
    }
    label929:
    label938:
    label944:
    for (;;)
    {
      paramn.a(localObject1, localObject1, "", Integer.valueOf(paramInt2), paramString);
      Object localObject3;
      label195:
      do
      {
        paramString = com.tencent.mm.kernel.g.agQ();
        k.g(paramString, "MMKernel.network()");
        paramString.agi().b(3501, (com.tencent.mm.ak.g)this);
        AppMethodBeat.o(189735);
        return;
        localObject3 = ((com.tencent.mm.live.b.a.l)paramn).gwp;
        if (localObject3 == null) {
          break label440;
        }
        if (!bt.eWo()) {
          break;
        }
        paramn = f.e.gtA;
        paramn = aw.aKU(f.e.akp());
        localObject1 = f.g.gtG;
        if (!paramn.getBoolean(f.g.akt(), false)) {
          break;
        }
        paramInt1 = 1;
        if ((paramInt1 != 0) || (!((zx)localObject3).DTg)) {
          break label319;
        }
        paramn = ((zx)localObject3).Eue;
        if (paramn != null)
        {
          localObject1 = g.guG;
          g.a(paramn);
          paramn = new StringBuilder("processCreateLiveResponse live_id:");
          localObject1 = g.guG;
          ac.i("MicroMsg.LaunchLiveRoom", g.akF().DMV);
        }
        paramn = this.gsV;
      } while (paramn == null);
      localObject1 = Boolean.TRUE;
      Object localObject2 = Boolean.FALSE;
      if (paramString == null) {
        paramString = "";
      }
      for (;;)
      {
        paramn.a(localObject1, localObject2, "", Integer.valueOf(paramInt2), paramString);
        break;
        paramInt1 = 0;
        break label195;
        label319:
        if (bs.isNullOrNil(((zx)localObject3).DTh))
        {
          paramn = this.gsV;
          if (paramn == null) {
            break;
          }
          localObject1 = Boolean.FALSE;
          if (paramString != null) {
            break label938;
          }
          paramString = "";
        }
        for (;;)
        {
          paramn.a(localObject1, localObject1, "", Integer.valueOf(paramInt2), paramString);
          break;
          paramn = this.gsV;
          if (paramn == null) {
            break;
          }
          localObject1 = Boolean.FALSE;
          localObject2 = Boolean.TRUE;
          localObject3 = ((zx)localObject3).DTh;
          k.g(localObject3, "response.verify_url");
          if (paramString == null) {
            paramString = "";
          }
          for (;;)
          {
            paramn.a(localObject1, localObject2, localObject3, Integer.valueOf(paramInt2), paramString);
            break;
            label440:
            paramn = this.gsV;
            if (paramn == null) {
              break;
            }
            localObject1 = Boolean.FALSE;
            if (paramString == null) {
              paramString = "";
            }
            for (;;)
            {
              paramn.a(localObject1, localObject1, "", Integer.valueOf(paramInt2), paramString);
              break;
              if ((paramn instanceof o))
              {
                localObject1 = a.gqF;
                a.uG("visitor join live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
                if ((paramInt1 == 0) && (paramInt2 == 0)) {
                  break label639;
                }
                ac.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
                paramn = this.gsW;
                if (paramn != null)
                {
                  localObject1 = Boolean.FALSE;
                  if (paramString != null) {
                    break label929;
                  }
                  paramString = "";
                }
              }
              for (;;)
              {
                localObject2 = d.gnY;
                localObject2 = d.aiP();
                localObject3 = d.gnY;
                paramn.a(localObject1, Integer.valueOf(paramInt2), paramString, localObject2, d.aiO());
                label639:
                do
                {
                  do
                  {
                    paramString = com.tencent.mm.kernel.g.agQ();
                    k.g(paramString, "MMKernel.network()");
                    paramString.agi().b(3797, (com.tencent.mm.ak.g)this);
                    AppMethodBeat.o(189735);
                    return;
                    paramn = ((o)paramn).gwy;
                    if (paramn == null) {
                      break;
                    }
                    paramString = paramn.Fdh;
                  } while (paramString == null);
                  paramn = g.guG;
                  g.a(paramString);
                  localObject1 = new TRTCCloudDef.TRTCParams();
                  paramString = this.name;
                  paramn = g.guG;
                  localObject2 = new c(paramString, g.akF().DMV, null, 0, null, 0L, 0L, 124);
                  paramString = e.gtg;
                  localObject3 = this.name;
                  paramString = g.guG;
                  bqd localbqd = g.akF();
                  paramString = g.guG;
                  paramn = g.akG();
                  paramString = paramn;
                  if (paramn == null) {
                    paramString = new bqj();
                  }
                  e.a((String)localObject3, paramString, localbqd, (TRTCCloudDef.TRTCParams)localObject1, (c)localObject2);
                  paramString = c.a.gnl;
                  ((c)localObject2).gnP = c.a.aiy();
                  paramString = g.guG;
                  paramString = g.akG();
                  if (paramString != null) {}
                  for (long l = paramString.Ffy;; l = 0L)
                  {
                    l = h.aC((l - 60L) * 1000L, 60000L);
                    i.gvw.pj(l);
                    paramString = this.gsW;
                    if (paramString == null) {
                      break;
                    }
                    paramString.a(Boolean.TRUE, Integer.valueOf(0), "", localObject2, localObject1);
                    break;
                  }
                  paramn = this.gsW;
                } while (paramn == null);
                localObject1 = Boolean.FALSE;
                if (paramString == null) {
                  paramString = "";
                }
                for (;;)
                {
                  localObject2 = d.gnY;
                  localObject2 = d.aiP();
                  localObject3 = d.gnY;
                  paramn.a(localObject1, Integer.valueOf(paramInt2), paramString, localObject2, d.aiO());
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.b
 * JD-Core Version:    0.7.0.1
 */
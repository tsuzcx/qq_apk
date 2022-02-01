package com.tencent.mm.live.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.debug.a;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.a.s;
import d.g.b.p;
import d.k.j;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LaunchLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "name", "", "roomId", "context", "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "createCallback", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "success", "needFaceVerify", "verifyUrl", "", "errCode", "errMsg", "", "joinCallback", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "getName", "()Ljava/lang/String;", "getRoomId", "createLive", "callback", "joinLive", "launch", "Lkotlin/Function6;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "processCreateLiveResponse", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "processJoinLiveResponse", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "Companion", "plugin-logic_release"})
public final class b
  implements f
{
  public static final a gPr;
  private final Context context;
  public s<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super String, z> gPp;
  public s<? super Boolean, ? super Integer, ? super String, ? super c, ? super TRTCCloudDef.TRTCParams, z> gPq;
  public final String name;
  public final String roomId;
  
  static
  {
    AppMethodBeat.i(215642);
    gPr = new a((byte)0);
    AppMethodBeat.o(215642);
  }
  
  public b(String paramString1, String paramString2, Context paramContext)
  {
    AppMethodBeat.i(215641);
    this.name = paramString1;
    this.roomId = paramString2;
    this.context = paramContext;
    AppMethodBeat.o(215641);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(215640);
    Object localObject1;
    if ((paramn instanceof com.tencent.mm.live.b.a.l))
    {
      localObject1 = a.gMY;
      a.yg("anchor create live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
        paramn = this.gPp;
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
        paramString = com.tencent.mm.kernel.g.ajQ();
        p.g(paramString, "MMKernel.network()");
        paramString.ajj().b(3501, (f)this);
        AppMethodBeat.o(215640);
        return;
        localObject3 = ((com.tencent.mm.live.b.a.l)paramn).gSI;
        if (localObject3 == null) {
          break label440;
        }
        if (!bv.fpT()) {
          break;
        }
        paramn = f.e.gPU;
        paramn = ay.aRX(f.e.anq());
        localObject1 = f.g.gQa;
        if (!paramn.getBoolean(f.g.anv(), false)) {
          break;
        }
        paramInt1 = 1;
        if ((paramInt1 != 0) || (!((acg)localObject3).FQX)) {
          break label319;
        }
        paramn = ((acg)localObject3).Gue;
        if (paramn != null)
        {
          localObject1 = g.gQZ;
          g.a(paramn);
          paramn = new StringBuilder("processCreateLiveResponse live_id:");
          localObject1 = g.gQZ;
          ae.i("MicroMsg.LaunchLiveRoom", g.anH().FKy);
        }
        paramn = this.gPp;
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
        if (bu.isNullOrNil(((acg)localObject3).FQY))
        {
          paramn = this.gPp;
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
          paramn = this.gPp;
          if (paramn == null) {
            break;
          }
          localObject1 = Boolean.FALSE;
          localObject2 = Boolean.TRUE;
          localObject3 = ((acg)localObject3).FQY;
          p.g(localObject3, "response.verify_url");
          if (paramString == null) {
            paramString = "";
          }
          for (;;)
          {
            paramn.a(localObject1, localObject2, localObject3, Integer.valueOf(paramInt2), paramString);
            break;
            label440:
            paramn = this.gPp;
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
                localObject1 = a.gMY;
                a.yg("visitor join live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
                if ((paramInt1 == 0) && (paramInt2 == 0)) {
                  break label639;
                }
                ae.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
                paramn = this.gPq;
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
                localObject2 = d.gKq;
                localObject2 = d.alQ();
                localObject3 = d.gKq;
                paramn.a(localObject1, Integer.valueOf(paramInt2), paramString, localObject2, d.alP());
                label639:
                do
                {
                  do
                  {
                    paramString = com.tencent.mm.kernel.g.ajQ();
                    p.g(paramString, "MMKernel.network()");
                    paramString.ajj().b(3797, (f)this);
                    AppMethodBeat.o(215640);
                    return;
                    paramn = ((o)paramn).gSR;
                    if (paramn == null) {
                      break;
                    }
                    paramString = paramn.Hgi;
                  } while (paramString == null);
                  paramn = g.gQZ;
                  g.a(paramString);
                  localObject1 = new TRTCCloudDef.TRTCParams();
                  paramString = this.name;
                  paramn = g.gQZ;
                  localObject2 = new c(paramString, g.anH().FKy, null, 0, null, 0L, 0L, 124);
                  paramString = e.gPA;
                  localObject3 = this.name;
                  paramString = g.gQZ;
                  bvk localbvk = g.anH();
                  paramString = g.gQZ;
                  paramn = g.anI();
                  paramString = paramn;
                  if (paramn == null) {
                    paramString = new bvq();
                  }
                  e.a((String)localObject3, paramString, localbvk, (TRTCCloudDef.TRTCParams)localObject1, (c)localObject2);
                  paramString = c.a.gJD;
                  ((c)localObject2).gKh = c.a.alz();
                  paramString = g.gQZ;
                  paramString = g.anI();
                  if (paramString != null) {}
                  for (long l = paramString.HiE;; l = 0L)
                  {
                    l = j.aG((l - 60L) * 1000L, 60000L);
                    i.gRP.rx(l);
                    paramString = this.gPq;
                    if (paramString == null) {
                      break;
                    }
                    paramString.a(Boolean.TRUE, Integer.valueOf(0), "", localObject2, localObject1);
                    break;
                  }
                  paramn = this.gPq;
                } while (paramn == null);
                localObject1 = Boolean.FALSE;
                if (paramString == null) {
                  paramString = "";
                }
                for (;;)
                {
                  localObject2 = d.gKq;
                  localObject2 = d.alQ();
                  localObject3 = d.gKq;
                  paramn.a(localObject1, Integer.valueOf(paramInt2), paramString, localObject2, d.alP());
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LaunchLiveRoom$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.b
 * JD-Core Version:    0.7.0.1
 */
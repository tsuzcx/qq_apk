package com.tencent.mm.live.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.debug.a;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.a.s;
import d.g.b.p;
import d.k.h;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LaunchLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "name", "", "roomId", "context", "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "createCallback", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "success", "needFaceVerify", "verifyUrl", "", "errCode", "errMsg", "", "joinCallback", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "getName", "()Ljava/lang/String;", "getRoomId", "createLive", "callback", "joinLive", "launch", "Lkotlin/Function6;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "processCreateLiveResponse", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "processJoinLiveResponse", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "Companion", "plugin-logic_release"})
public final class b
  implements f
{
  public static final a gMI;
  private final Context context;
  public s<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super String, z> gMG;
  public s<? super Boolean, ? super Integer, ? super String, ? super c, ? super TRTCCloudDef.TRTCParams, z> gMH;
  public final String name;
  public final String roomId;
  
  static
  {
    AppMethodBeat.i(212023);
    gMI = new a((byte)0);
    AppMethodBeat.o(212023);
  }
  
  public b(String paramString1, String paramString2, Context paramContext)
  {
    AppMethodBeat.i(212022);
    this.name = paramString1;
    this.roomId = paramString2;
    this.context = paramContext;
    AppMethodBeat.o(212022);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(212021);
    Object localObject1;
    if ((paramn instanceof com.tencent.mm.live.b.a.l))
    {
      localObject1 = a.gKp;
      a.xx("anchor create live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
        paramn = this.gMG;
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
        paramString = com.tencent.mm.kernel.g.ajB();
        p.g(paramString, "MMKernel.network()");
        paramString.aiU().b(3501, (f)this);
        AppMethodBeat.o(212021);
        return;
        localObject3 = ((com.tencent.mm.live.b.a.l)paramn).gQa;
        if (localObject3 == null) {
          break label440;
        }
        if (!bu.flY()) {
          break;
        }
        paramn = f.e.gNl;
        paramn = ax.aQA(f.e.anb());
        localObject1 = f.g.gNr;
        if (!paramn.getBoolean(f.g.anf(), false)) {
          break;
        }
        paramInt1 = 1;
        if ((paramInt1 != 0) || (!((abx)localObject3).Fyz)) {
          break label319;
        }
        paramn = ((abx)localObject3).Gbx;
        if (paramn != null)
        {
          localObject1 = g.gOr;
          g.a(paramn);
          paramn = new StringBuilder("processCreateLiveResponse live_id:");
          localObject1 = g.gOr;
          ad.i("MicroMsg.LaunchLiveRoom", g.ans().Fsa);
        }
        paramn = this.gMG;
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
        if (bt.isNullOrNil(((abx)localObject3).FyA))
        {
          paramn = this.gMG;
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
          paramn = this.gMG;
          if (paramn == null) {
            break;
          }
          localObject1 = Boolean.FALSE;
          localObject2 = Boolean.TRUE;
          localObject3 = ((abx)localObject3).FyA;
          p.g(localObject3, "response.verify_url");
          if (paramString == null) {
            paramString = "";
          }
          for (;;)
          {
            paramn.a(localObject1, localObject2, localObject3, Integer.valueOf(paramInt2), paramString);
            break;
            label440:
            paramn = this.gMG;
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
                localObject1 = a.gKp;
                a.xx("visitor join live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
                if ((paramInt1 == 0) && (paramInt2 == 0)) {
                  break label639;
                }
                ad.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
                paramn = this.gMH;
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
                localObject2 = d.gHH;
                localObject2 = d.alB();
                localObject3 = d.gHH;
                paramn.a(localObject1, Integer.valueOf(paramInt2), paramString, localObject2, d.alA());
                label639:
                do
                {
                  do
                  {
                    paramString = com.tencent.mm.kernel.g.ajB();
                    p.g(paramString, "MMKernel.network()");
                    paramString.aiU().b(3797, (f)this);
                    AppMethodBeat.o(212021);
                    return;
                    paramn = ((o)paramn).gQj;
                    if (paramn == null) {
                      break;
                    }
                    paramString = paramn.GMH;
                  } while (paramString == null);
                  paramn = g.gOr;
                  g.a(paramString);
                  localObject1 = new TRTCCloudDef.TRTCParams();
                  paramString = this.name;
                  paramn = g.gOr;
                  localObject2 = new c(paramString, g.ans().Fsa, null, 0, null, 0L, 0L, 124);
                  paramString = e.gMR;
                  localObject3 = this.name;
                  paramString = g.gOr;
                  buq localbuq = g.ans();
                  paramString = g.gOr;
                  paramn = g.ant();
                  paramString = paramn;
                  if (paramn == null) {
                    paramString = new buw();
                  }
                  e.a((String)localObject3, paramString, localbuq, (TRTCCloudDef.TRTCParams)localObject1, (c)localObject2);
                  paramString = c.a.gGU;
                  ((c)localObject2).gHy = c.a.alk();
                  paramString = g.gOr;
                  paramString = g.ant();
                  if (paramString != null) {}
                  for (long l = paramString.GPc;; l = 0L)
                  {
                    l = h.aH((l - 60L) * 1000L, 60000L);
                    i.gPh.rk(l);
                    paramString = this.gMH;
                    if (paramString == null) {
                      break;
                    }
                    paramString.a(Boolean.TRUE, Integer.valueOf(0), "", localObject2, localObject1);
                    break;
                  }
                  paramn = this.gMH;
                } while (paramn == null);
                localObject1 = Boolean.FALSE;
                if (paramString == null) {
                  paramString = "";
                }
                for (;;)
                {
                  localObject2 = d.gHH;
                  localObject2 = d.alB();
                  localObject3 = d.gHH;
                  paramn.a(localObject1, Integer.valueOf(paramInt2), paramString, localObject2, d.alA());
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LaunchLiveRoom$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.live.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.model.f;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.debug.a;
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LaunchLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "name", "", "roomId", "context", "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "createCallback", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "success", "needFaceVerify", "verifyUrl", "", "errCode", "errMsg", "", "joinCallback", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "getName", "()Ljava/lang/String;", "getRoomId", "createLive", "callback", "joinLive", "launch", "Lkotlin/Function6;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "processCreateLiveResponse", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "processJoinLiveResponse", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "Companion", "plugin-logic_release"})
public final class i
  implements com.tencent.mm.an.i
{
  public static final a ktY;
  private final Context context;
  public s<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super String, x> ktW;
  public s<? super Boolean, ? super Integer, ? super String, ? super f, ? super TRTCCloudDef.TRTCParams, x> ktX;
  public final String name;
  public final String roomId;
  
  static
  {
    AppMethodBeat.i(189193);
    ktY = new a((byte)0);
    AppMethodBeat.o(189193);
  }
  
  public i(String paramString1, String paramString2, Context paramContext)
  {
    AppMethodBeat.i(189191);
    this.name = paramString1;
    this.roomId = paramString2;
    this.context = paramContext;
    AppMethodBeat.o(189191);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(189185);
    Object localObject1;
    if ((paramq instanceof com.tencent.mm.live.b.a.l))
    {
      localObject1 = a.kqB;
      a.NN("anchor create live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
        paramq = this.ktW;
        if (paramq != null)
        {
          localObject1 = Boolean.FALSE;
          if (paramString != null) {
            break label948;
          }
          paramString = "";
        }
      }
    }
    label933:
    label942:
    label948:
    for (;;)
    {
      paramq.a(localObject1, localObject1, "", Integer.valueOf(paramInt2), paramString);
      Object localObject3;
      label195:
      do
      {
        paramString = h.aHF();
        p.j(paramString, "MMKernel.network()");
        paramString.aGY().b(3501, (com.tencent.mm.an.i)this);
        AppMethodBeat.o(189185);
        return;
        localObject3 = ((com.tencent.mm.live.b.a.l)paramq).kxz;
        if (localObject3 == null) {
          break label440;
        }
        if (!WeChatEnvironment.hasDebugger()) {
          break;
        }
        paramq = l.e.kuB;
        paramq = MultiProcessMMKV.getSingleMMKV(l.e.aNJ());
        localObject1 = l.g.kuI;
        if (!paramq.getBoolean(l.g.aNO(), false)) {
          break;
        }
        paramInt1 = 1;
        if ((paramInt1 != 0) || (!((aep)localObject3).RLw)) {
          break label319;
        }
        paramq = ((aep)localObject3).Src;
        if (paramq != null)
        {
          localObject1 = u.kwz;
          u.a(paramq);
          paramq = new StringBuilder("processCreateLiveResponse live_id:");
          localObject1 = u.kwz;
          Log.i("MicroMsg.LaunchLiveRoom", u.aOr().klE);
        }
        paramq = this.ktW;
      } while (paramq == null);
      localObject1 = Boolean.TRUE;
      Object localObject2 = Boolean.FALSE;
      if (paramString == null) {
        paramString = "";
      }
      for (;;)
      {
        paramq.a(localObject1, localObject2, "", Integer.valueOf(paramInt2), paramString);
        break;
        paramInt1 = 0;
        break label195;
        label319:
        if (Util.isNullOrNil(((aep)localObject3).RLx))
        {
          paramq = this.ktW;
          if (paramq == null) {
            break;
          }
          localObject1 = Boolean.FALSE;
          if (paramString != null) {
            break label942;
          }
          paramString = "";
        }
        for (;;)
        {
          paramq.a(localObject1, localObject1, "", Integer.valueOf(paramInt2), paramString);
          break;
          paramq = this.ktW;
          if (paramq == null) {
            break;
          }
          localObject1 = Boolean.FALSE;
          localObject2 = Boolean.TRUE;
          localObject3 = ((aep)localObject3).RLx;
          p.j(localObject3, "response.verify_url");
          if (paramString == null) {
            paramString = "";
          }
          for (;;)
          {
            paramq.a(localObject1, localObject2, localObject3, Integer.valueOf(paramInt2), paramString);
            break;
            label440:
            paramq = this.ktW;
            if (paramq == null) {
              break;
            }
            localObject1 = Boolean.FALSE;
            if (paramString == null) {
              paramString = "";
            }
            for (;;)
            {
              paramq.a(localObject1, localObject1, "", Integer.valueOf(paramInt2), paramString);
              break;
              if ((paramq instanceof com.tencent.mm.live.b.a.o))
              {
                localObject1 = a.kqB;
                a.NN("visitor join live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
                if ((paramInt1 == 0) && (paramInt2 == 0)) {
                  break label639;
                }
                Log.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
                paramq = this.ktX;
                if (paramq != null)
                {
                  localObject1 = Boolean.FALSE;
                  if (paramString != null) {
                    break label933;
                  }
                  paramString = "";
                }
              }
              for (;;)
              {
                localObject2 = g.kmu;
                localObject2 = g.aLk();
                localObject3 = g.kmu;
                paramq.a(localObject1, Integer.valueOf(paramInt2), paramString, localObject2, g.aLj());
                label639:
                do
                {
                  do
                  {
                    paramString = h.aHF();
                    p.j(paramString, "MMKernel.network()");
                    paramString.aGY().b(3797, (com.tencent.mm.an.i)this);
                    AppMethodBeat.o(189185);
                    return;
                    paramq = ((com.tencent.mm.live.b.a.o)paramq).kxI;
                    if (paramq == null) {
                      break;
                    }
                    paramString = paramq.SJL;
                  } while (paramString == null);
                  paramq = u.kwz;
                  u.a(paramString);
                  localObject1 = new TRTCCloudDef.TRTCParams();
                  paramString = this.name;
                  paramq = u.kwz;
                  localObject2 = new f(paramString, u.aOr().klE, 0, null, 0L, 0L, null, null, 0L, null, 8188);
                  paramString = k.kuf;
                  localObject3 = this.name;
                  paramString = u.kwz;
                  crq localcrq = u.aOr();
                  paramString = u.kwz;
                  paramq = u.aOs();
                  paramString = paramq;
                  if (paramq == null) {
                    paramString = new crw();
                  }
                  k.a((String)localObject3, paramString, localcrq, (TRTCCloudDef.TRTCParams)localObject1, (f)localObject2);
                  paramString = e.b.kjz;
                  ((f)localObject2).kmi = e.b.aJJ();
                  paramString = u.kwz;
                  paramString = u.aOs();
                  if (paramString != null) {}
                  for (long l = paramString.Tzr;; l = 0L)
                  {
                    l = kotlin.k.i.be((l - 60L) * 1000L, 60000L);
                    o.kvA.FG(l);
                    paramString = this.ktX;
                    if (paramString == null) {
                      break;
                    }
                    paramString.a(Boolean.TRUE, Integer.valueOf(0), "", localObject2, localObject1);
                    break;
                  }
                  paramq = this.ktX;
                } while (paramq == null);
                localObject1 = Boolean.FALSE;
                if (paramString == null) {
                  paramString = "";
                }
                for (;;)
                {
                  localObject2 = g.kmu;
                  localObject2 = g.aLk();
                  localObject3 = g.kmu;
                  paramq.a(localObject1, Integer.valueOf(paramInt2), paramString, localObject2, g.aLj());
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LaunchLiveRoom$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.i
 * JD-Core Version:    0.7.0.1
 */
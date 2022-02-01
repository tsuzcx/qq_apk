package com.tencent.mm.live.b;

import android.content.Context;
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
import com.tencent.mm.live.core.debug.a;
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.protocal.protobuf.cfd;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.k.j;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LaunchLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "name", "", "roomId", "context", "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "createCallback", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "success", "needFaceVerify", "verifyUrl", "", "errCode", "errMsg", "", "joinCallback", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "getName", "()Ljava/lang/String;", "getRoomId", "createLive", "callback", "joinLive", "launch", "Lkotlin/Function6;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "processCreateLiveResponse", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "processJoinLiveResponse", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "Companion", "plugin-logic_release"})
public final class l
  implements i
{
  public static final a hGa;
  private final Context context;
  public s<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super String, kotlin.x> hFY;
  public s<? super Boolean, ? super Integer, ? super String, ? super e, ? super TRTCCloudDef.TRTCParams, kotlin.x> hFZ;
  public final String name;
  public final String roomId;
  
  static
  {
    AppMethodBeat.i(207579);
    hGa = new a((byte)0);
    AppMethodBeat.o(207579);
  }
  
  public l(String paramString1, String paramString2, Context paramContext)
  {
    AppMethodBeat.i(207578);
    this.name = paramString1;
    this.roomId = paramString2;
    this.context = paramContext;
    AppMethodBeat.o(207578);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(207577);
    Object localObject1;
    if ((paramq instanceof com.tencent.mm.live.b.a.l))
    {
      localObject1 = a.hCA;
      a.GA("anchor create live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
        paramq = this.hFY;
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
        paramString = g.aAg();
        p.g(paramString, "MMKernel.network()");
        paramString.azz().b(3501, (i)this);
        AppMethodBeat.o(207577);
        return;
        localObject3 = ((com.tencent.mm.live.b.a.l)paramq).hKf;
        if (localObject3 == null) {
          break label440;
        }
        if (!WeChatEnvironment.hasDebugger()) {
          break;
        }
        paramq = o.f.hGW;
        paramq = MultiProcessMMKV.getSingleMMKV(o.f.aFC());
        localObject1 = o.h.hHd;
        if (!paramq.getBoolean(o.h.aFH(), false)) {
          break;
        }
        paramInt1 = 1;
        if ((paramInt1 != 0) || (!((aei)localObject3).KKE)) {
          break label319;
        }
        paramq = ((aei)localObject3).LpG;
        if (paramq != null)
        {
          localObject1 = x.hJf;
          x.a(paramq);
          paramq = new StringBuilder("processCreateLiveResponse live_id:");
          localObject1 = x.hJf;
          Log.i("MicroMsg.LaunchLiveRoom", x.aGr().hyH);
        }
        paramq = this.hFY;
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
        if (Util.isNullOrNil(((aei)localObject3).KKF))
        {
          paramq = this.hFY;
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
          paramq = this.hFY;
          if (paramq == null) {
            break;
          }
          localObject1 = Boolean.FALSE;
          localObject2 = Boolean.TRUE;
          localObject3 = ((aei)localObject3).KKF;
          p.g(localObject3, "response.verify_url");
          if (paramString == null) {
            paramString = "";
          }
          for (;;)
          {
            paramq.a(localObject1, localObject2, localObject3, Integer.valueOf(paramInt2), paramString);
            break;
            label440:
            paramq = this.hFY;
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
              if ((paramq instanceof o))
              {
                localObject1 = a.hCA;
                a.GA("visitor join live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
                if ((paramInt1 == 0) && (paramInt2 == 0)) {
                  break label639;
                }
                Log.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
                paramq = this.hFZ;
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
                localObject2 = f.hzy;
                localObject2 = f.aDr();
                localObject3 = f.hzy;
                paramq.a(localObject1, Integer.valueOf(paramInt2), paramString, localObject2, f.aDq());
                label639:
                do
                {
                  do
                  {
                    paramString = g.aAg();
                    p.g(paramString, "MMKernel.network()");
                    paramString.azz().b(3797, (i)this);
                    AppMethodBeat.o(207577);
                    return;
                    paramq = ((o)paramq).hKo;
                    if (paramq == null) {
                      break;
                    }
                    paramString = paramq.LFH;
                  } while (paramString == null);
                  paramq = x.hJf;
                  x.a(paramString);
                  localObject1 = new TRTCCloudDef.TRTCParams();
                  paramString = this.name;
                  paramq = x.hJf;
                  localObject2 = new e(paramString, x.aGr().hyH, 0, null, 0L, 0L, 0, null, null, 0L, 4092);
                  paramString = n.hGh;
                  localObject3 = this.name;
                  paramString = x.hJf;
                  civ localciv = x.aGr();
                  paramString = x.hJf;
                  paramq = x.aGs();
                  paramString = paramq;
                  if (paramq == null) {
                    paramString = new cjb();
                  }
                  n.a((String)localObject3, paramString, localciv, (TRTCCloudDef.TRTCParams)localObject1, (e)localObject2);
                  paramString = e.a.hxc;
                  ((e)localObject2).hzl = e.a.aCe();
                  paramString = x.hJf;
                  paramString = x.aGs();
                  if (paramString != null) {}
                  for (long l = paramString.Mor;; l = 0L)
                  {
                    l = j.aM((l - 60L) * 1000L, 60000L);
                    r.hIg.zz(l);
                    paramString = this.hFZ;
                    if (paramString == null) {
                      break;
                    }
                    paramString.a(Boolean.TRUE, Integer.valueOf(0), "", localObject2, localObject1);
                    break;
                  }
                  paramq = this.hFZ;
                } while (paramq == null);
                localObject1 = Boolean.FALSE;
                if (paramString == null) {
                  paramString = "";
                }
                for (;;)
                {
                  localObject2 = f.hzy;
                  localObject2 = f.aDr();
                  localObject3 = f.hzy;
                  paramq.a(localObject1, Integer.valueOf(paramInt2), paramString, localObject2, f.aDq());
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LaunchLiveRoom$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.l
 * JD-Core Version:    0.7.0.1
 */
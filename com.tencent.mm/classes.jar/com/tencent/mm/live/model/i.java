package com.tencent.mm.live.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.c;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.debug.a;
import com.tencent.mm.live.model.a.l;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LaunchLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "name", "", "roomId", "context", "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "createCallback", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "success", "needFaceVerify", "verifyUrl", "", "errCode", "errMsg", "", "joinCallback", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "getName", "()Ljava/lang/String;", "getRoomId", "createLive", "callback", "joinLive", "launch", "Lkotlin/Function6;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "processCreateLiveResponse", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "processJoinLiveResponse", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements com.tencent.mm.am.h
{
  public static final i.a mXQ;
  private final Context context;
  public kotlin.g.a.s<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super String, ah> mXR;
  public kotlin.g.a.s<? super Boolean, ? super Integer, ? super String, ? super g, ? super TRTCCloudDef.TRTCParams, ah> mXS;
  public final String name;
  public final String roomId;
  
  static
  {
    AppMethodBeat.i(246572);
    mXQ = new i.a((byte)0);
    AppMethodBeat.o(246572);
  }
  
  public i(String paramString1, String paramString2, Context paramContext)
  {
    AppMethodBeat.i(246564);
    this.name = paramString1;
    this.roomId = paramString2;
    this.context = paramContext;
    AppMethodBeat.o(246564);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(246601);
    label134:
    Object localObject3;
    label190:
    Object localObject2;
    if ((paramp instanceof l))
    {
      localObject1 = a.mUy;
      a.Ga("anchor create live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
        paramp = this.mXR;
        if (paramp != null)
        {
          localObject1 = Boolean.FALSE;
          if (paramString != null) {
            break label134;
          }
          paramString = "";
          paramp.a(localObject1, localObject1, "", Integer.valueOf(paramInt2), paramString);
        }
      }
      label298:
      label306:
      label365:
      do
      {
        do
        {
          do
          {
            do
            {
              com.tencent.mm.kernel.h.baD().mCm.b(3501, (com.tencent.mm.am.h)this);
              AppMethodBeat.o(246601);
              return;
              break;
              localObject3 = ((l)paramp).naZ;
              if (localObject3 == null) {
                break label433;
              }
              if (!WeChatEnvironment.hasDebugger()) {
                break label298;
              }
              paramp = l.e.mYs;
              paramp = MultiProcessMMKV.getSingleMMKV(l.e.bhu());
              localObject1 = l.g.mYB;
              if (!paramp.getBoolean(l.g.bhz(), false)) {
                break label298;
              }
              paramInt1 = 1;
              if ((paramInt1 != 0) || (!((ahb)localObject3).YII)) {
                break label306;
              }
              paramp = ((ahb)localObject3).Zqe;
              if (paramp != null)
              {
                localObject1 = u.mZl;
                u.a(paramp);
                paramp = u.mZl;
                Log.i("MicroMsg.LaunchLiveRoom", kotlin.g.b.s.X("processCreateLiveResponse live_id:", Long.valueOf(u.bie().mMJ)));
              }
              paramp = this.mXR;
            } while (paramp == null);
            localObject1 = Boolean.TRUE;
            localObject2 = Boolean.FALSE;
            if (paramString == null) {
              paramString = "";
            }
            for (;;)
            {
              paramp.a(localObject1, localObject2, "", Integer.valueOf(paramInt2), paramString);
              break;
              paramInt1 = 0;
              break label190;
            }
            if (!Util.isNullOrNil(((ahb)localObject3).YIJ)) {
              break label365;
            }
            paramp = this.mXR;
          } while (paramp == null);
          localObject1 = Boolean.FALSE;
          if (paramString == null) {
            paramString = "";
          }
          for (;;)
          {
            paramp.a(localObject1, localObject1, "", Integer.valueOf(paramInt2), paramString);
            break;
          }
          paramp = this.mXR;
        } while (paramp == null);
        localObject1 = Boolean.FALSE;
        localObject2 = Boolean.TRUE;
        localObject3 = ((ahb)localObject3).YIJ;
        kotlin.g.b.s.s(localObject3, "response.verify_url");
        if (paramString == null) {
          paramString = "";
        }
        for (;;)
        {
          paramp.a(localObject1, localObject2, localObject3, Integer.valueOf(paramInt2), paramString);
          break;
        }
        paramp = this.mXR;
      } while (paramp == null);
      label433:
      localObject1 = Boolean.FALSE;
      if (paramString == null) {
        paramString = "";
      }
      for (;;)
      {
        paramp.a(localObject1, localObject1, "", Integer.valueOf(paramInt2), paramString);
        break;
      }
    }
    if ((paramp instanceof com.tencent.mm.live.model.a.o))
    {
      localObject1 = a.mUy;
      a.Ga("visitor join live error:" + paramInt1 + " code:" + paramInt2 + " msg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label630;
      }
      Log.i("MicroMsg.LaunchLiveRoom", "launch live room failed");
      paramp = this.mXS;
      if (paramp != null)
      {
        localObject1 = Boolean.FALSE;
        if (paramString != null) {
          break label627;
        }
        paramString = "";
        localObject2 = com.tencent.mm.live.core.core.model.h.mNy;
        localObject2 = com.tencent.mm.live.core.core.model.h.beo();
        localObject3 = com.tencent.mm.live.core.core.model.h.mNy;
        paramp.a(localObject1, Integer.valueOf(paramInt2), paramString, localObject2, com.tencent.mm.live.core.core.model.h.ben());
      }
    }
    label627:
    label630:
    do
    {
      do
      {
        com.tencent.mm.kernel.h.baD().mCm.b(3797, (com.tencent.mm.am.h)this);
        AppMethodBeat.o(246601);
        return;
        break;
        paramp = ((com.tencent.mm.live.model.a.o)paramp).nbi;
        if (paramp == null) {
          break label862;
        }
        paramString = paramp.ZOg;
      } while (paramString == null);
      paramp = u.mZl;
      u.a(paramString);
      localObject1 = new TRTCCloudDef.TRTCParams();
      paramString = this.name;
      paramp = u.mZl;
      localObject2 = new g(paramString, u.bie().mMJ, 0, null, 0L, 0L, null, 0, null, 0L, null, null, 131068);
      paramString = k.mYa;
      localObject3 = this.name;
      paramString = u.mZl;
      dio localdio = u.bie();
      paramString = u.mZl;
      paramp = u.bif();
      paramString = paramp;
      if (paramp == null) {
        paramString = new dix();
      }
      k.a((String)localObject3, paramString, localdio, (TRTCCloudDef.TRTCParams)localObject1, (g)localObject2);
      paramString = e.b.mKf;
      ((g)localObject2).mNn = e.b.bct();
      paramString = u.mZl;
      paramString = u.bif();
      if (paramString == null) {}
      for (long l = 0L;; l = paramString.aaOy)
      {
        l = kotlin.k.k.bR((l - 60L) * 1000L, 60000L);
        o.mZb.hM(l);
        paramString = this.mXS;
        if (paramString == null) {
          break;
        }
        paramString.a(Boolean.TRUE, Integer.valueOf(0), "", localObject2, localObject1);
        break;
      }
      paramp = this.mXS;
    } while (paramp == null);
    label862:
    Object localObject1 = Boolean.FALSE;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.live.core.core.model.h.mNy;
      localObject2 = com.tencent.mm.live.core.core.model.h.beo();
      localObject3 = com.tencent.mm.live.core.core.model.h.mNy;
      paramp.a(localObject1, Integer.valueOf(paramInt2), paramString, localObject2, com.tencent.mm.live.core.core.model.h.ben());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.model.i
 * JD-Core Version:    0.7.0.1
 */
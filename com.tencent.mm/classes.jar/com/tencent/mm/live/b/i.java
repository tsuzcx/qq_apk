package com.tencent.mm.live.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.q;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.b.a.c;
import com.tencent.mm.live.b.b.a.d;
import com.tencent.mm.live.b.b.a.g;
import com.tencent.mm.live.core.core.c.b.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.a.r;
import d.g.b.k;
import d.l;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "()V", "onNewXmlReceived", "", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-logic_release"})
public final class i
  implements p
{
  public static final a zaK;
  
  static
  {
    AppMethodBeat.i(202680);
    zaK = new a((byte)0);
    AppMethodBeat.o(202680);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(202679);
    long l1;
    if (k.g(paramString, "ApplyLiveMic"))
    {
      ad.i("MicroMsg.LiveSysMsgReceiver", "receive apply live mic newxml");
      if (paramMap != null)
      {
        paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
        l1 = bt.getLong(paramString, 0L);
        if (paramMap != null)
        {
          paramString = (String)paramMap.get(".sysmsg.mmlive.live_mic_id");
          if (paramString != null) {
            break label2022;
          }
        }
        paramString = "";
      }
    }
    label443:
    label592:
    label1360:
    label2004:
    label2007:
    label2010:
    label2022:
    for (;;)
    {
      if (paramMap != null)
      {
        parama = (String)paramMap.get(".sysmsg.mmlive.identity_id");
        if (parama != null) {}
      }
      else
      {
        parama = "";
      }
      for (;;)
      {
        Object localObject1;
        if (paramMap != null)
        {
          localObject1 = (String)paramMap.get(".sysmsg.mmlive.roomid");
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        for (;;)
        {
          if (paramMap != null)
          {
            paramMap = (String)paramMap.get(".sysmsg.mmlive.mic_sdk_user_id");
            if (paramMap != null) {}
          }
          else
          {
            paramMap = "";
          }
          for (;;)
          {
            Object localObject2 = f.rGw;
            localObject2 = f.fOz();
            paramString = new a.a(l1, paramString, parama, (String)localObject1, paramMap);
            k.h(paramString, "liveMicUser");
            paramMap = com.tencent.mm.live.core.debug.a.qOL;
            com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", "[sysmsg]anchor receive mic ".concat(String.valueOf(paramString)));
            paramMap = f.rGw;
            if (f.eNG().LwA == paramString.DlB)
            {
              parama = ((Iterable)((com.tencent.mm.live.b.b.a)localObject2).ytb).iterator();
              for (;;)
              {
                if (parama.hasNext())
                {
                  paramMap = (a.a)parama.next();
                  if (k.g(paramMap.Csx, paramString.Csx))
                  {
                    parama = paramString.BQP;
                    k.h(parama, "<set-?>");
                    paramMap.BQP = parama;
                    paramString = paramString.roomId;
                    k.h(paramString, "<set-?>");
                    paramMap.roomId = paramString;
                    AppMethodBeat.o(202679);
                    return;
                    paramString = null;
                    break;
                  }
                }
              }
              ((com.tencent.mm.live.b.b.a)localObject2).ytb.add(paramString);
              aq.f((Runnable)new a.g((com.tencent.mm.live.b.b.a)localObject2));
              AppMethodBeat.o(202679);
              return;
            }
            paramString = new StringBuilder("anchor receive mic ,but error live_id for ");
            paramMap = f.rGw;
            ad.e("MicroMsg.LiveCoreMic", f.eNG().LwA);
            AppMethodBeat.o(202679);
            return;
            if (k.g(paramString, "AcceptLiveMic"))
            {
              ad.i("MicroMsg.LiveSysMsgReceiver", "receive accept live mic newxml");
              if (paramMap != null)
              {
                paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                l1 = bt.getLong(paramString, 0L);
                if (paramMap != null)
                {
                  paramString = (String)paramMap.get(".sysmsg.mmlive.live_mic_id");
                  if (paramString != null) {
                    break label2010;
                  }
                }
                paramString = "";
              }
            }
            for (;;)
            {
              int i;
              if (paramMap != null)
              {
                parama = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_appid");
                i = bt.getInt(parama, 0);
                if (paramMap != null)
                {
                  parama = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_user_id");
                  if (parama != null) {
                    break label2007;
                  }
                }
                parama = "";
              }
              for (;;)
              {
                label490:
                int j;
                int k;
                if (paramMap != null)
                {
                  localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_live_id");
                  j = bt.getInt((String)localObject1, 0);
                  if (paramMap == null) {
                    break label906;
                  }
                  localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_role_id");
                  k = bt.getInt((String)localObject1, 0);
                  if (paramMap != null)
                  {
                    localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_user_sig");
                    if (localObject1 != null) {
                      break label2004;
                    }
                  }
                  localObject1 = "";
                }
                for (;;)
                {
                  if (paramMap != null)
                  {
                    localObject2 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_private_map_key");
                    if (localObject2 != null) {}
                  }
                  else
                  {
                    localObject2 = "";
                  }
                  for (;;)
                  {
                    Object localObject3;
                    long l2;
                    if (paramMap != null)
                    {
                      localObject3 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.expire_for_pmk");
                      l2 = bt.getLong((String)localObject3, 300L);
                      localObject2 = Base64.decode((String)localObject2, 0);
                      k.g(localObject2, "Base64.decode(privateMapKey, 0)");
                      localObject3 = Charset.forName("UTF-8");
                      k.g(localObject3, "Charset.forName(\"UTF-8\")");
                      localObject2 = new String((byte[])localObject2, (Charset)localObject3);
                      localObject1 = new TRTCCloudDef.TRTCParams(i, parama, (String)localObject1, j, (String)localObject2, "");
                      localObject3 = e.i.rFG;
                      if (k == e.i.eNx()) {
                        break label918;
                      }
                      localObject3 = e.i.rFG;
                      if (k != e.i.eNy()) {
                        break label918;
                      }
                    }
                    for (i = 21;; i = 20)
                    {
                      ((TRTCCloudDef.TRTCParams)localObject1).role = i;
                      if (paramMap != null)
                      {
                        localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_params");
                        paramMap = (Map<String, String>)localObject1;
                        if (localObject1 != null) {}
                      }
                      else
                      {
                        paramMap = "";
                      }
                      localObject1 = new eax();
                      if (!bt.isNullOrNil(paramMap)) {
                        ((eax)localObject1).parseFrom(Base64.decode(paramMap, 0));
                      }
                      paramMap = d.qYj;
                      d.a((eax)localObject1, null);
                      paramMap = com.tencent.mm.live.core.core.c.b.qOk;
                      paramMap = aj.getContext();
                      k.g(paramMap, "MMApplicationContext.getContext()");
                      b.a.eH(paramMap).aTV((String)localObject2);
                      paramString = new a.a(l1, paramString, "", "", parama);
                      paramMap = f.rGw;
                      paramMap = f.eNK();
                      if (paramMap != null)
                      {
                        paramMap = paramMap.qzq;
                        if (paramMap != null) {
                          paramMap.privateMapKey = ((String)localObject2);
                        }
                      }
                      paramMap = f.rGw;
                      f.fOz().a(paramString);
                      paramString = f.rGw;
                      f.Be(l2);
                      paramString = h.xfu;
                      paramMap = f.rGw;
                      paramString.Bi(d.k.h.aH((f.eNL() - 60L) * 1000L, 60000L));
                      AppMethodBeat.o(202679);
                      return;
                      paramString = null;
                      break;
                      parama = null;
                      break label443;
                      localObject1 = null;
                      break label490;
                      localObject1 = null;
                      break label515;
                      localObject3 = null;
                      break label592;
                    }
                    if (k.g(paramString, "CloseLive"))
                    {
                      ad.i("MicroMsg.LiveSysMsgReceiver", "receive close live newxml");
                      if (paramMap != null) {}
                      for (paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");; paramString = null)
                      {
                        l1 = bt.getLong(paramString, 0L);
                        ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().Bj(l1);
                        paramString = f.rGw;
                        paramString = f.fOz();
                        paramMap = com.tencent.mm.live.core.debug.a.qOL;
                        com.tencent.mm.live.core.debug.a.aUc("[sysmsg]anchor close live ".concat(String.valueOf(l1)));
                        aq.f((Runnable)new a.c(paramString, l1));
                        paramString = f.rGw;
                        f.Be(0L);
                        AppMethodBeat.o(202679);
                        return;
                      }
                    }
                    if (k.g(paramString, "CloseLiveMic"))
                    {
                      ad.i("MicroMsg.LiveSysMsgReceiver", "receive close mic newxml");
                      if (paramMap != null)
                      {
                        paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                        l1 = bt.getLong(paramString, 0L);
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.audience");
                          if (paramString != null) {
                            break label1998;
                          }
                        }
                        paramString = "";
                      }
                    }
                    for (;;)
                    {
                      if (paramMap != null)
                      {
                        parama = (String)paramMap.get(".sysmsg.mmlive.live_mic_id");
                        paramMap = parama;
                        if (parama != null) {}
                      }
                      else
                      {
                        paramMap = "";
                      }
                      parama = f.rGw;
                      f.fOz().g(l1, paramString, paramMap);
                      paramString = h.xfu;
                      com.tencent.mm.ad.c.aW(h.xcd);
                      paramMap = com.tencent.mm.kernel.g.afA();
                      k.g(paramMap, "MMKernel.network()");
                      paramMap.aeS().b(760, (com.tencent.mm.al.g)paramString);
                      AppMethodBeat.o(202679);
                      return;
                      paramString = null;
                      break;
                      label1254:
                      boolean bool;
                      if (k.g(paramString, "CloseApplyLiveMic"))
                      {
                        ad.i("MicroMsg.LiveSysMsgReceiver", "receive CloseApplyLiveMic newxml");
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = bt.getLong(paramString, 0L);
                          if (paramMap == null) {
                            break label1355;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.enable_apply_live_mic");
                          if (bt.getInt(paramString, 0) != 1) {
                            break label1360;
                          }
                        }
                        for (bool = true;; bool = false)
                        {
                          paramString = f.rGw;
                          paramString = f.fOz();
                          paramMap = com.tencent.mm.live.core.debug.a.qOL;
                          com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", "[sysmsg]anchor set mic permission:" + bool + " liveId:" + l1);
                          paramMap = f.rGw;
                          if (l1 == f.eNG().LwA) {
                            aq.f((Runnable)new a.d(paramString, bool));
                          }
                          AppMethodBeat.o(202679);
                          return;
                          paramString = null;
                          break;
                          paramString = null;
                          break label1254;
                        }
                      }
                      if (k.g(paramString, "BanLiveComment"))
                      {
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = bt.getLong(paramString, 0L);
                          if (paramMap == null) {
                            break label1568;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.enable_comment");
                          j = bt.getInt(paramString, 0);
                          if (paramMap == null) {
                            break label1573;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.wording");
                          paramString = bt.nullAsNil(paramString);
                          paramMap = f.rGw;
                          if (f.eNG().LwA == l1)
                          {
                            paramMap = f.rGw;
                            paramMap = f.eNG();
                            if (j != 1) {
                              break label1578;
                            }
                            bool = true;
                            paramMap.LwF = bool;
                            paramMap = f.rGw;
                            paramMap = f.rGw;
                            if (!f.eNG().LwF) {
                              break label1584;
                            }
                          }
                        }
                        for (i = 0;; i = ce.asT())
                        {
                          f.agw(i);
                          paramMap = c.qYi;
                          k.g(paramString, "wording");
                          c.aUj(paramString);
                          ad.i("MicroMsg.LiveSysMsgReceiver", "receive ban comment newxml enableComment:" + j + " wording:" + paramString);
                          AppMethodBeat.o(202679);
                          return;
                          paramString = null;
                          break;
                          paramString = null;
                          break label1416;
                          paramString = null;
                          break label1440;
                          bool = false;
                          break label1478;
                        }
                      }
                      if (k.g(paramString, "LiveMicSucc")) {
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = bt.getLong(paramString, 0L);
                          if (paramMap != null)
                          {
                            paramString = (String)paramMap.get(".sysmsg.mmlive.identity_id");
                            if (paramString != null) {
                              break label1995;
                            }
                          }
                          paramString = "";
                        }
                      }
                      for (;;)
                      {
                        if (paramMap != null)
                        {
                          parama = (String)paramMap.get(".sysmsg.mmlive.headimg");
                          if (parama != null) {}
                        }
                        else
                        {
                          parama = "";
                        }
                        for (;;)
                        {
                          if (paramMap != null)
                          {
                            localObject1 = (String)paramMap.get(".sysmsg.mmlive.nickName");
                            if (localObject1 != null) {}
                          }
                          else
                          {
                            localObject1 = "";
                          }
                          for (;;)
                          {
                            if (paramMap != null)
                            {
                              localObject2 = (String)paramMap.get(".sysmsg.mmlive.mic_sdk_user_id");
                              if (localObject2 != null) {}
                            }
                            else
                            {
                              localObject2 = "";
                            }
                            for (;;)
                            {
                              if (paramMap != null)
                              {
                                paramMap = (String)paramMap.get(".sysmsg.mmlive.live_mic_id");
                                if (paramMap != null) {}
                              }
                              else
                              {
                                paramMap = "";
                              }
                              for (;;)
                              {
                                localObject3 = f.rGw;
                                localObject3 = f.fOz();
                                k.h(paramMap, "micId");
                                k.h(paramString, "audience");
                                k.h(parama, "headImg");
                                k.h(localObject1, "nickName");
                                k.h(localObject2, "sdkUid");
                                Object localObject4 = com.tencent.mm.live.core.debug.a.qOL;
                                com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", "[sysmsg]broadcast mic success.micId:" + paramMap + " audience:" + paramString + " nick:" + (String)localObject1 + " liveId:" + l1 + " sdkUid:" + (String)localObject2);
                                localObject4 = f.rGw;
                                if (l1 == f.eNG().LwA)
                                {
                                  ((com.tencent.mm.live.b.b.a)localObject3).BMx = new a.a(l1, paramMap, paramString, "", (String)localObject2);
                                  paramMap = ((com.tencent.mm.live.b.b.a)localObject3).BMu;
                                  if (paramMap != null) {
                                    paramMap.a(Long.valueOf(l1), paramString, parama, localObject1);
                                  }
                                  if ((k.g(localObject2, ((com.tencent.mm.live.b.b.a)localObject3).BMz)) && (!((com.tencent.mm.live.b.b.a)localObject3).fOK()))
                                  {
                                    paramString = ((com.tencent.mm.live.b.b.a)localObject3).BMv;
                                    if (paramString != null)
                                    {
                                      paramString.invoke();
                                      AppMethodBeat.o(202679);
                                      return;
                                      paramString = null;
                                      break;
                                    }
                                  }
                                }
                                AppMethodBeat.o(202679);
                                return;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveSysMsgReceiver$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.i
 * JD-Core Version:    0.7.0.1
 */
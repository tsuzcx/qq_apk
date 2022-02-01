package com.tencent.mm.live.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.f;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.b.a.c;
import com.tencent.mm.live.b.b.a.d;
import com.tencent.mm.live.b.b.a.g;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.c.b.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.bur;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.p;
import d.k.h;
import d.l;
import d.n.n;
import d.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "()V", "onNewXmlReceived", "", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-logic_release"})
public final class j
  implements com.tencent.mm.plugin.messenger.foundation.a.q
{
  public static final a gPl;
  
  static
  {
    AppMethodBeat.i(212157);
    gPl = new a((byte)0);
    AppMethodBeat.o(212157);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(212156);
    long l1;
    if (p.i(paramString, "ApplyLiveMic"))
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
            break label2209;
          }
        }
        paramString = "";
      }
    }
    label513:
    label910:
    label922:
    label2209:
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
            Object localObject2 = g.gOr;
            localObject2 = g.aod();
            paramString = new a.a(l1, paramString, parama, (String)localObject1, paramMap);
            p.h(paramString, "liveMicUser");
            paramMap = com.tencent.mm.live.core.debug.a.gKp;
            com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", "[sysmsg]anchor receive mic ".concat(String.valueOf(paramString)));
            paramMap = g.gOr;
            if (g.ans().Fsa == paramString.gGy)
            {
              parama = ((Iterable)((com.tencent.mm.live.b.b.a)localObject2).gQO).iterator();
              while (parama.hasNext())
              {
                paramMap = (a.a)parama.next();
                if (p.i(paramMap.gQU, paramString.gQU))
                {
                  parama = paramString.gQS;
                  p.h(parama, "<set-?>");
                  paramMap.gQS = parama;
                  paramString = paramString.roomId;
                  p.h(paramString, "<set-?>");
                  paramMap.roomId = paramString;
                }
              }
            }
            for (;;)
            {
              paramString = d.z.MKo;
              AppMethodBeat.o(212156);
              return;
              paramString = null;
              break;
              ((com.tencent.mm.live.b.b.a)localObject2).gQO.add(0, paramString);
              aq.f((Runnable)new a.g((com.tencent.mm.live.b.b.a)localObject2));
              continue;
              paramString = new StringBuilder("anchor receive mic ,but error live_id for ");
              paramMap = g.gOr;
              ad.e("MicroMsg.LiveCoreMic", g.ans().Fsa);
            }
            if (p.i(paramString, "AcceptLiveMic"))
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
                    break label2197;
                  }
                }
                paramString = "";
              }
            }
            for (;;)
            {
              label441:
              int i;
              if (paramMap != null)
              {
                parama = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_appid");
                i = bt.getInt(parama, 0);
                if (paramMap != null)
                {
                  parama = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_user_id");
                  if (parama != null) {
                    break label2194;
                  }
                }
                parama = "";
              }
              for (;;)
              {
                label488:
                int j;
                int k;
                if (paramMap != null)
                {
                  localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_live_id");
                  j = bt.getInt((String)localObject1, 0);
                  if (paramMap == null) {
                    break label910;
                  }
                  localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_role_id");
                  k = bt.getInt((String)localObject1, 0);
                  if (paramMap != null)
                  {
                    localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_user_sig");
                    if (localObject1 != null) {
                      break label2191;
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
                    label590:
                    long l2;
                    if (paramMap != null)
                    {
                      localObject3 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.expire_for_pmk");
                      l2 = bt.getLong((String)localObject3, 300L);
                      localObject2 = Base64.decode((String)localObject2, 0);
                      p.g(localObject2, "Base64.decode(privateMapKey, 0)");
                      localObject3 = Charset.forName("UTF-8");
                      p.g(localObject3, "Charset.forName(\"UTF-8\")");
                      localObject2 = new String((byte[])localObject2, (Charset)localObject3);
                      localObject1 = new TRTCCloudDef.TRTCParams(i, parama, (String)localObject1, j, (String)localObject2, "");
                      localObject3 = f.i.gNx;
                      if (k == f.i.ani()) {
                        break label922;
                      }
                      localObject3 = f.i.gNx;
                      if (k != f.i.anj()) {
                        break label922;
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
                      localObject1 = new bux();
                      if (!bt.isNullOrNil(paramMap)) {
                        ((bux)localObject1).parseFrom(Base64.decode(paramMap, 0));
                      }
                      paramMap = e.gMR;
                      e.a((bux)localObject1, null);
                      paramMap = com.tencent.mm.live.core.core.c.b.gKd;
                      paramMap = aj.getContext();
                      p.g(paramMap, "MMApplicationContext.getContext()");
                      b.a.cr(paramMap).xm((String)localObject2);
                      paramString = new a.a(l1, paramString, "", "", parama);
                      paramMap = g.gOr;
                      paramMap = g.anw();
                      if (paramMap != null)
                      {
                        paramMap = paramMap.gHC;
                        if (paramMap != null) {
                          paramMap.privateMapKey = ((String)localObject2);
                        }
                      }
                      paramMap = g.gOr;
                      g.aod().a(paramString);
                      paramString = g.gOr;
                      g.rh(l2);
                      paramString = i.gPh;
                      paramMap = g.gOr;
                      paramString.rl(h.aH((g.anx() - 60L) * 1000L, 60000L));
                      paramString = d.z.MKo;
                      AppMethodBeat.o(212156);
                      return;
                      paramString = null;
                      break;
                      parama = null;
                      break label441;
                      localObject1 = null;
                      break label488;
                      localObject1 = null;
                      break label513;
                      localObject3 = null;
                      break label590;
                    }
                    if (p.i(paramString, "CloseLive"))
                    {
                      if (paramMap != null) {}
                      for (paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");; paramString = null)
                      {
                        l1 = bt.getLong(paramString, 0L);
                        ad.i("MicroMsg.LiveSysMsgReceiver", "receive close live newxml liveId:".concat(String.valueOf(l1)));
                        com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().rn(l1);
                        paramString = g.gOr;
                        paramString = g.aod();
                        paramMap = com.tencent.mm.live.core.debug.a.gKp;
                        com.tencent.mm.live.core.debug.a.xx("[sysmsg]anchor close live ".concat(String.valueOf(l1)));
                        aq.f((Runnable)new a.c(paramString, l1));
                        paramString = g.gOr;
                        g.rh(0L);
                        paramString = com.tencent.mm.live.b.c.a.gRa;
                        com.tencent.mm.live.b.c.a.rm(l1);
                        paramString = d.z.MKo;
                        AppMethodBeat.o(212156);
                        return;
                      }
                    }
                    if (p.i(paramString, "CloseLiveMic")) {
                      if (paramMap != null)
                      {
                        paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                        l1 = bt.getLong(paramString, 0L);
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.audience");
                          if (paramString != null) {
                            break label2185;
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
                      parama = g.gOr;
                      g.aod().a(l1, paramString, paramMap);
                      paramString = i.gPh;
                      com.tencent.mm.ad.c.B(i.gPg);
                      paramMap = com.tencent.mm.kernel.g.ajB();
                      p.g(paramMap, "MMKernel.network()");
                      paramMap.aiU().b(760, (f)paramString);
                      ad.i("MicroMsg.LiveSysMsgReceiver", "receive close mic newxml liveid:".concat(String.valueOf(l1)));
                      paramString = d.z.MKo;
                      AppMethodBeat.o(212156);
                      return;
                      paramString = null;
                      break;
                      boolean bool;
                      if (p.i(paramString, "CloseApplyLiveMic"))
                      {
                        ad.i("MicroMsg.LiveSysMsgReceiver", "receive CloseApplyLiveMic newxml");
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = bt.getLong(paramString, 0L);
                          if (paramMap == null) {
                            break label1385;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.enable_apply_live_mic");
                          if (bt.getInt(paramString, 0) != 1) {
                            break label1390;
                          }
                        }
                        label1385:
                        label1390:
                        for (bool = true;; bool = false)
                        {
                          paramString = g.gOr;
                          paramString = g.aod();
                          paramMap = com.tencent.mm.live.core.debug.a.gKp;
                          com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", "[sysmsg]anchor set mic permission:" + bool + " liveId:" + l1);
                          paramMap = g.gOr;
                          if (l1 == g.ans().Fsa) {
                            aq.f((Runnable)new a.d(paramString, bool));
                          }
                          paramString = d.z.MKo;
                          AppMethodBeat.o(212156);
                          return;
                          paramString = null;
                          break;
                          paramString = null;
                          break label1280;
                        }
                      }
                      if (p.i(paramString, "BanLiveComment"))
                      {
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = bt.getLong(paramString, 0L);
                          if (paramMap == null) {
                            break label1602;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.enable_comment");
                          label1446:
                          j = bt.getInt(paramString, 0);
                          if (paramMap == null) {
                            break label1607;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.wording");
                          label1470:
                          paramString = bt.nullAsNil(paramString);
                          paramMap = g.gOr;
                          if (g.ans().Fsa == l1)
                          {
                            paramMap = g.gOr;
                            paramMap = g.ans();
                            if (j != 1) {
                              break label1612;
                            }
                            bool = true;
                            label1508:
                            paramMap.FBr = bool;
                            paramMap = g.gOr;
                            paramMap = g.gOr;
                            if (!g.ans().FBr) {
                              break label1618;
                            }
                          }
                        }
                        label1602:
                        label1607:
                        label1612:
                        label1618:
                        for (i = 0;; i = cf.aCN())
                        {
                          g.nt(i);
                          paramMap = c.gMO;
                          p.g(paramString, "wording");
                          c.xD(paramString);
                          ad.i("MicroMsg.LiveSysMsgReceiver", "receive ban comment newxml enableComment:" + j + " wording:" + paramString);
                          paramString = d.z.MKo;
                          AppMethodBeat.o(212156);
                          return;
                          paramString = null;
                          break;
                          paramString = null;
                          break label1446;
                          paramString = null;
                          break label1470;
                          bool = false;
                          break label1508;
                        }
                      }
                      if (p.i(paramString, "LiveMicSucc")) {
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = bt.getLong(paramString, 0L);
                          if (paramMap != null)
                          {
                            paramString = (String)paramMap.get(".sysmsg.mmlive.identity_id");
                            if (paramString != null) {
                              break label2182;
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
                                localObject3 = g.gOr;
                                g.aod().a(l1, paramMap, paramString, parama, (String)localObject1, (String)localObject2);
                                paramString = d.z.MKo;
                                AppMethodBeat.o(212156);
                                return;
                                paramString = null;
                                break;
                                if (p.i(paramString, "OnlineLiveList"))
                                {
                                  ad.i("MicroMsg.LiveSysMsgReceiver", "receive online livelist mmlive.");
                                  localObject1 = new bur();
                                  if (paramMap != null)
                                  {
                                    paramMap = (String)paramMap.get(".sysmsg.mmlive.live_info_list");
                                    paramString = paramMap;
                                    if (paramMap != null) {}
                                  }
                                  else
                                  {
                                    paramString = "";
                                  }
                                  paramString = ((bur)localObject1).parseFrom(Base64.decode(paramString, 0));
                                  if (paramString == null)
                                  {
                                    paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveInfoList");
                                    AppMethodBeat.o(212156);
                                    throw paramString;
                                  }
                                  paramMap = (bur)paramString;
                                  if ((paramMap != null) && (paramMap.fVg != null) && (paramMap.fVg.size() > 0)) {
                                    if (parama != null)
                                    {
                                      paramString = parama.gqE;
                                      if (paramString != null)
                                      {
                                        paramString = paramString.Fvk;
                                        paramString = com.tencent.mm.platformtools.z.a(paramString);
                                        p.g(paramString, "msgContent");
                                        i = n.a((CharSequence)paramString, ":", 0, false, 6);
                                        if (i == -1) {
                                          break label2164;
                                        }
                                        paramString = paramString.substring(0, i);
                                        p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                      }
                                    }
                                  }
                                }
                                for (;;)
                                {
                                  localObject1 = new LinkedList();
                                  localObject2 = paramMap.fVg.iterator();
                                  label2014:
                                  label2142:
                                  for (;;)
                                  {
                                    if (!((Iterator)localObject2).hasNext()) {
                                      break label2144;
                                    }
                                    localObject3 = (buq)((Iterator)localObject2).next();
                                    if (parama != null)
                                    {
                                      paramMap = parama.gqE;
                                      if (paramMap == null) {}
                                    }
                                    for (paramMap = paramMap.Fvj;; paramMap = null)
                                    {
                                      if (com.tencent.mm.platformtools.z.a(paramMap).equals(((buq)localObject3).GOK)) {
                                        break label2142;
                                      }
                                      paramMap = new com.tencent.mm.live.b.c.b();
                                      paramMap.field_liveId = ((buq)localObject3).Fsa;
                                      paramMap.field_hostRoomId = paramString;
                                      paramMap.field_liveName = ((buq)localObject3).GOL;
                                      paramMap.field_anchorUsername = ((buq)localObject3).GOK;
                                      paramMap.field_isSender = false;
                                      paramMap.field_timeStamp = ((buq)localObject3).FHr;
                                      ((LinkedList)localObject1).add(paramMap);
                                      break label2014;
                                      paramString = null;
                                      break;
                                    }
                                  }
                                  label2144:
                                  com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().a((LinkedList)localObject1, paramString);
                                  paramString = d.z.MKo;
                                  AppMethodBeat.o(212156);
                                  return;
                                  label2164:
                                  paramString = "";
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
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveSysMsgReceiver$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.j
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.live.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.b.a.c;
import com.tencent.mm.live.b.b.a.d;
import com.tencent.mm.live.b.b.a.g;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.c.b.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "()V", "onNewXmlReceived", "", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-logic_release"})
public final class j
  implements com.tencent.mm.plugin.messenger.foundation.a.q
{
  public static final a gRT;
  
  static
  {
    AppMethodBeat.i(215777);
    gRT = new a((byte)0);
    AppMethodBeat.o(215777);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(215776);
    long l1;
    if (p.i(paramString, "ApplyLiveMic"))
    {
      ae.i("MicroMsg.LiveSysMsgReceiver", "receive apply live mic newxml");
      if (paramMap != null)
      {
        paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
        l1 = bu.getLong(paramString, 0L);
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
            Object localObject2 = g.gQZ;
            localObject2 = g.aos();
            paramString = new a.a(l1, paramString, parama, (String)localObject1, paramMap);
            p.h(paramString, "liveMicUser");
            paramMap = com.tencent.mm.live.core.debug.a.gMY;
            com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", "[sysmsg]anchor receive mic ".concat(String.valueOf(paramString)));
            paramMap = g.gQZ;
            if (g.anH().FKy == paramString.gJh)
            {
              parama = ((Iterable)((com.tencent.mm.live.b.b.a)localObject2).gTw).iterator();
              while (parama.hasNext())
              {
                paramMap = (a.a)parama.next();
                if (p.i(paramMap.gTC, paramString.gTC))
                {
                  parama = paramString.gTA;
                  p.h(parama, "<set-?>");
                  paramMap.gTA = parama;
                  paramString = paramString.roomId;
                  p.h(paramString, "<set-?>");
                  paramMap.roomId = paramString;
                }
              }
            }
            for (;;)
            {
              paramString = d.z.Nhr;
              AppMethodBeat.o(215776);
              return;
              paramString = null;
              break;
              ((com.tencent.mm.live.b.b.a)localObject2).gTw.add(0, paramString);
              ar.f((Runnable)new a.g((com.tencent.mm.live.b.b.a)localObject2));
              continue;
              paramString = new StringBuilder("anchor receive mic ,but error live_id for ");
              paramMap = g.gQZ;
              ae.e("MicroMsg.LiveCoreMic", g.anH().FKy);
            }
            if (p.i(paramString, "AcceptLiveMic"))
            {
              ae.i("MicroMsg.LiveSysMsgReceiver", "receive accept live mic newxml");
              if (paramMap != null)
              {
                paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                l1 = bu.getLong(paramString, 0L);
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
                i = bu.getInt(parama, 0);
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
                  j = bu.getInt((String)localObject1, 0);
                  if (paramMap == null) {
                    break label910;
                  }
                  localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_role_id");
                  k = bu.getInt((String)localObject1, 0);
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
                      l2 = bu.getLong((String)localObject3, 300L);
                      localObject2 = Base64.decode((String)localObject2, 0);
                      p.g(localObject2, "Base64.decode(privateMapKey, 0)");
                      localObject3 = Charset.forName("UTF-8");
                      p.g(localObject3, "Charset.forName(\"UTF-8\")");
                      localObject2 = new String((byte[])localObject2, (Charset)localObject3);
                      localObject1 = new TRTCCloudDef.TRTCParams(i, parama, (String)localObject1, j, (String)localObject2, "");
                      localObject3 = f.i.gQg;
                      if (k == f.i.any()) {
                        break label922;
                      }
                      localObject3 = f.i.gQg;
                      if (k != f.i.anz()) {
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
                      localObject1 = new bvr();
                      if (!bu.isNullOrNil(paramMap)) {
                        ((bvr)localObject1).parseFrom(Base64.decode(paramMap, 0));
                      }
                      paramMap = e.gPA;
                      e.a((bvr)localObject1, null);
                      paramMap = com.tencent.mm.live.core.core.c.b.gMM;
                      paramMap = ak.getContext();
                      p.g(paramMap, "MMApplicationContext.getContext()");
                      b.a.ct(paramMap).xV((String)localObject2);
                      paramString = new a.a(l1, paramString, "", "", parama);
                      paramMap = g.gQZ;
                      paramMap = g.anL();
                      if (paramMap != null)
                      {
                        paramMap = paramMap.gKl;
                        if (paramMap != null) {
                          paramMap.privateMapKey = ((String)localObject2);
                        }
                      }
                      paramMap = g.gQZ;
                      g.aos().a(paramString);
                      paramString = g.gQZ;
                      g.ru(l2);
                      paramString = i.gRP;
                      paramMap = g.gQZ;
                      paramString.ry(d.k.j.aG((g.anM() - 60L) * 1000L, 60000L));
                      paramString = d.z.Nhr;
                      AppMethodBeat.o(215776);
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
                        l1 = bu.getLong(paramString, 0L);
                        ae.i("MicroMsg.LiveSysMsgReceiver", "receive close live newxml liveId:".concat(String.valueOf(l1)));
                        com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().rA(l1);
                        paramString = g.gQZ;
                        paramString = g.aos();
                        paramMap = com.tencent.mm.live.core.debug.a.gMY;
                        com.tencent.mm.live.core.debug.a.yg("[sysmsg]anchor close live ".concat(String.valueOf(l1)));
                        ar.f((Runnable)new a.c(paramString, l1));
                        paramString = g.gQZ;
                        g.ru(0L);
                        paramString = com.tencent.mm.live.b.c.a.gTI;
                        com.tencent.mm.live.b.c.a.rz(l1);
                        paramString = d.z.Nhr;
                        AppMethodBeat.o(215776);
                        return;
                      }
                    }
                    if (p.i(paramString, "CloseLiveMic")) {
                      if (paramMap != null)
                      {
                        paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                        l1 = bu.getLong(paramString, 0L);
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
                      parama = g.gQZ;
                      g.aos().a(l1, paramString, paramMap);
                      paramString = i.gRP;
                      com.tencent.mm.ac.c.z(i.gRO);
                      paramMap = com.tencent.mm.kernel.g.ajQ();
                      p.g(paramMap, "MMKernel.network()");
                      paramMap.ajj().b(760, (f)paramString);
                      ae.i("MicroMsg.LiveSysMsgReceiver", "receive close mic newxml liveid:".concat(String.valueOf(l1)));
                      paramString = d.z.Nhr;
                      AppMethodBeat.o(215776);
                      return;
                      paramString = null;
                      break;
                      boolean bool;
                      if (p.i(paramString, "CloseApplyLiveMic"))
                      {
                        ae.i("MicroMsg.LiveSysMsgReceiver", "receive CloseApplyLiveMic newxml");
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = bu.getLong(paramString, 0L);
                          if (paramMap == null) {
                            break label1385;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.enable_apply_live_mic");
                          if (bu.getInt(paramString, 0) != 1) {
                            break label1390;
                          }
                        }
                        label1385:
                        label1390:
                        for (bool = true;; bool = false)
                        {
                          paramString = g.gQZ;
                          paramString = g.aos();
                          paramMap = com.tencent.mm.live.core.debug.a.gMY;
                          com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", "[sysmsg]anchor set mic permission:" + bool + " liveId:" + l1);
                          paramMap = g.gQZ;
                          if (l1 == g.anH().FKy) {
                            ar.f((Runnable)new a.d(paramString, bool));
                          }
                          paramString = d.z.Nhr;
                          AppMethodBeat.o(215776);
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
                          l1 = bu.getLong(paramString, 0L);
                          if (paramMap == null) {
                            break label1602;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.enable_comment");
                          label1446:
                          j = bu.getInt(paramString, 0);
                          if (paramMap == null) {
                            break label1607;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.wording");
                          label1470:
                          paramString = bu.nullAsNil(paramString);
                          paramMap = g.gQZ;
                          if (g.anH().FKy == l1)
                          {
                            paramMap = g.gQZ;
                            paramMap = g.anH();
                            if (j != 1) {
                              break label1612;
                            }
                            bool = true;
                            label1508:
                            paramMap.FTM = bool;
                            paramMap = g.gQZ;
                            paramMap = g.gQZ;
                            if (!g.anH().FTM) {
                              break label1618;
                            }
                          }
                        }
                        label1602:
                        label1607:
                        label1612:
                        label1618:
                        for (i = 0;; i = ch.aDd())
                        {
                          g.nw(i);
                          paramMap = c.gPx;
                          p.g(paramString, "wording");
                          c.ym(paramString);
                          ae.i("MicroMsg.LiveSysMsgReceiver", "receive ban comment newxml enableComment:" + j + " wording:" + paramString);
                          paramString = d.z.Nhr;
                          AppMethodBeat.o(215776);
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
                          l1 = bu.getLong(paramString, 0L);
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
                                localObject3 = g.gQZ;
                                g.aos().a(l1, paramMap, paramString, parama, (String)localObject1, (String)localObject2);
                                paramString = d.z.Nhr;
                                AppMethodBeat.o(215776);
                                return;
                                paramString = null;
                                break;
                                if (p.i(paramString, "OnlineLiveList"))
                                {
                                  ae.i("MicroMsg.LiveSysMsgReceiver", "receive online livelist mmlive.");
                                  localObject1 = new bvl();
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
                                  paramString = ((bvl)localObject1).parseFrom(Base64.decode(paramString, 0));
                                  if (paramString == null)
                                  {
                                    paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveInfoList");
                                    AppMethodBeat.o(215776);
                                    throw paramString;
                                  }
                                  paramMap = (bvl)paramString;
                                  if ((paramMap != null) && (paramMap.fXm != null) && (paramMap.fXm.size() > 0)) {
                                    if (parama != null)
                                    {
                                      paramString = parama.gte;
                                      if (paramString != null)
                                      {
                                        paramString = paramString.FNI;
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
                                  localObject2 = paramMap.fXm.iterator();
                                  label2014:
                                  label2142:
                                  for (;;)
                                  {
                                    if (!((Iterator)localObject2).hasNext()) {
                                      break label2144;
                                    }
                                    localObject3 = (bvk)((Iterator)localObject2).next();
                                    if (parama != null)
                                    {
                                      paramMap = parama.gte;
                                      if (paramMap == null) {}
                                    }
                                    for (paramMap = paramMap.FNH;; paramMap = null)
                                    {
                                      if (com.tencent.mm.platformtools.z.a(paramMap).equals(((bvk)localObject3).Hik)) {
                                        break label2142;
                                      }
                                      paramMap = new com.tencent.mm.live.b.c.b();
                                      paramMap.field_liveId = ((bvk)localObject3).FKy;
                                      paramMap.field_hostRoomId = paramString;
                                      paramMap.field_liveName = ((bvk)localObject3).Hil;
                                      paramMap.field_anchorUsername = ((bvk)localObject3).Hik;
                                      paramMap.field_isSender = false;
                                      paramMap.field_timeStamp = ((bvk)localObject3).FZN;
                                      ((LinkedList)localObject1).add(paramMap);
                                      break label2014;
                                      paramString = null;
                                      break;
                                    }
                                  }
                                  label2144:
                                  com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().a((LinkedList)localObject1, paramString);
                                  paramString = d.z.Nhr;
                                  AppMethodBeat.o(215776);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveSysMsgReceiver$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.j
 * JD-Core Version:    0.7.0.1
 */
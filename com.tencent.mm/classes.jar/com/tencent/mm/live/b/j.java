package com.tencent.mm.live.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.b.a.c;
import com.tencent.mm.live.b.b.a.d;
import com.tencent.mm.live.b.b.a.g;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.c.b.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.k;
import d.k.h;
import d.l;
import d.n.n;
import d.v;
import d.y;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "()V", "onNewXmlReceived", "", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-logic_release"})
public final class j
  implements p
{
  public static final j.a gvA;
  
  static
  {
    AppMethodBeat.i(189871);
    gvA = new j.a((byte)0);
    AppMethodBeat.o(189871);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(189870);
    long l1;
    if (k.g(paramString, "ApplyLiveMic"))
    {
      ac.i("MicroMsg.LiveSysMsgReceiver", "receive apply live mic newxml");
      if (paramMap != null)
      {
        paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
        l1 = bs.getLong(paramString, 0L);
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
            Object localObject2 = g.guG;
            localObject2 = g.alq();
            paramString = new a.a(l1, paramString, parama, (String)localObject1, paramMap);
            k.h(paramString, "liveMicUser");
            paramMap = com.tencent.mm.live.core.debug.a.gqF;
            com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", "[sysmsg]anchor receive mic ".concat(String.valueOf(paramString)));
            paramMap = g.guG;
            if (g.akF().DMV == paramString.gmP)
            {
              parama = ((Iterable)((com.tencent.mm.live.b.b.a)localObject2).gxd).iterator();
              while (parama.hasNext())
              {
                paramMap = (a.a)parama.next();
                if (k.g(paramMap.gxj, paramString.gxj))
                {
                  parama = paramString.gxh;
                  k.h(parama, "<set-?>");
                  paramMap.gxh = parama;
                  paramString = paramString.roomId;
                  k.h(paramString, "<set-?>");
                  paramMap.roomId = paramString;
                }
              }
            }
            for (;;)
            {
              paramString = y.KTp;
              AppMethodBeat.o(189870);
              return;
              paramString = null;
              break;
              ((com.tencent.mm.live.b.b.a)localObject2).gxd.add(0, paramString);
              ap.f((Runnable)new a.g((com.tencent.mm.live.b.b.a)localObject2));
              continue;
              paramString = new StringBuilder("anchor receive mic ,but error live_id for ");
              paramMap = g.guG;
              ac.e("MicroMsg.LiveCoreMic", g.akF().DMV);
            }
            if (k.g(paramString, "AcceptLiveMic"))
            {
              ac.i("MicroMsg.LiveSysMsgReceiver", "receive accept live mic newxml");
              if (paramMap != null)
              {
                paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                l1 = bs.getLong(paramString, 0L);
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
                i = bs.getInt(parama, 0);
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
                  j = bs.getInt((String)localObject1, 0);
                  if (paramMap == null) {
                    break label910;
                  }
                  localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_role_id");
                  k = bs.getInt((String)localObject1, 0);
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
                      l2 = bs.getLong((String)localObject3, 300L);
                      localObject2 = Base64.decode((String)localObject2, 0);
                      k.g(localObject2, "Base64.decode(privateMapKey, 0)");
                      localObject3 = Charset.forName("UTF-8");
                      k.g(localObject3, "Charset.forName(\"UTF-8\")");
                      localObject2 = new String((byte[])localObject2, (Charset)localObject3);
                      localObject1 = new TRTCCloudDef.TRTCParams(i, parama, (String)localObject1, j, (String)localObject2, "");
                      localObject3 = f.i.gtM;
                      if (k == f.i.akw()) {
                        break label922;
                      }
                      localObject3 = f.i.gtM;
                      if (k != f.i.akx()) {
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
                      localObject1 = new bqk();
                      if (!bs.isNullOrNil(paramMap)) {
                        ((bqk)localObject1).parseFrom(Base64.decode(paramMap, 0));
                      }
                      paramMap = e.gtg;
                      e.a((bqk)localObject1, null);
                      paramMap = com.tencent.mm.live.core.core.c.b.gqt;
                      paramMap = ai.getContext();
                      k.g(paramMap, "MMApplicationContext.getContext()");
                      b.a.cu(paramMap).uw((String)localObject2);
                      paramString = new a.a(l1, paramString, "", "", parama);
                      paramMap = g.guG;
                      paramMap = g.akJ();
                      if (paramMap != null)
                      {
                        paramMap = paramMap.gnT;
                        if (paramMap != null) {
                          paramMap.privateMapKey = ((String)localObject2);
                        }
                      }
                      paramMap = g.guG;
                      g.alq().a(paramString);
                      paramString = g.guG;
                      g.pg(l2);
                      paramString = i.gvw;
                      paramMap = g.guG;
                      paramString.pk(h.aC((g.akK() - 60L) * 1000L, 60000L));
                      paramString = y.KTp;
                      AppMethodBeat.o(189870);
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
                    if (k.g(paramString, "CloseLive"))
                    {
                      if (paramMap != null) {}
                      for (paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");; paramString = null)
                      {
                        l1 = bs.getLong(paramString, 0L);
                        ac.i("MicroMsg.LiveSysMsgReceiver", "receive close live newxml liveId:".concat(String.valueOf(l1)));
                        com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().pm(l1);
                        paramString = g.guG;
                        paramString = g.alq();
                        paramMap = com.tencent.mm.live.core.debug.a.gqF;
                        com.tencent.mm.live.core.debug.a.uG("[sysmsg]anchor close live ".concat(String.valueOf(l1)));
                        ap.f((Runnable)new a.c(paramString, l1));
                        paramString = g.guG;
                        g.pg(0L);
                        paramString = com.tencent.mm.live.b.c.a.gxp;
                        com.tencent.mm.live.b.c.a.pl(l1);
                        paramString = y.KTp;
                        AppMethodBeat.o(189870);
                        return;
                      }
                    }
                    if (k.g(paramString, "CloseLiveMic")) {
                      if (paramMap != null)
                      {
                        paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                        l1 = bs.getLong(paramString, 0L);
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
                      parama = g.guG;
                      g.alq().a(l1, paramString, paramMap);
                      paramString = i.gvw;
                      com.tencent.mm.ac.c.C(i.gvv);
                      paramMap = com.tencent.mm.kernel.g.agQ();
                      k.g(paramMap, "MMKernel.network()");
                      paramMap.agi().b(760, (com.tencent.mm.ak.g)paramString);
                      ac.i("MicroMsg.LiveSysMsgReceiver", "receive close mic newxml liveid:".concat(String.valueOf(l1)));
                      paramString = y.KTp;
                      AppMethodBeat.o(189870);
                      return;
                      paramString = null;
                      break;
                      boolean bool;
                      if (k.g(paramString, "CloseApplyLiveMic"))
                      {
                        ac.i("MicroMsg.LiveSysMsgReceiver", "receive CloseApplyLiveMic newxml");
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = bs.getLong(paramString, 0L);
                          if (paramMap == null) {
                            break label1385;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.enable_apply_live_mic");
                          if (bs.getInt(paramString, 0) != 1) {
                            break label1390;
                          }
                        }
                        label1385:
                        label1390:
                        for (bool = true;; bool = false)
                        {
                          paramString = g.guG;
                          paramString = g.alq();
                          paramMap = com.tencent.mm.live.core.debug.a.gqF;
                          com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", "[sysmsg]anchor set mic permission:" + bool + " liveId:" + l1);
                          paramMap = g.guG;
                          if (l1 == g.akF().DMV) {
                            ap.f((Runnable)new a.d(paramString, bool));
                          }
                          paramString = y.KTp;
                          AppMethodBeat.o(189870);
                          return;
                          paramString = null;
                          break;
                          paramString = null;
                          break label1280;
                        }
                      }
                      if (k.g(paramString, "BanLiveComment"))
                      {
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = bs.getLong(paramString, 0L);
                          if (paramMap == null) {
                            break label1602;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.enable_comment");
                          label1446:
                          j = bs.getInt(paramString, 0);
                          if (paramMap == null) {
                            break label1607;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.wording");
                          label1470:
                          paramString = bs.nullAsNil(paramString);
                          paramMap = g.guG;
                          if (g.akF().DMV == l1)
                          {
                            paramMap = g.guG;
                            paramMap = g.akF();
                            if (j != 1) {
                              break label1612;
                            }
                            bool = true;
                            label1508:
                            paramMap.DVV = bool;
                            paramMap = g.guG;
                            paramMap = g.guG;
                            if (!g.akF().DVV) {
                              break label1618;
                            }
                          }
                        }
                        label1602:
                        label1607:
                        label1612:
                        label1618:
                        for (i = 0;; i = ce.azK())
                        {
                          g.mU(i);
                          paramMap = c.gtd;
                          k.g(paramString, "wording");
                          c.uN(paramString);
                          ac.i("MicroMsg.LiveSysMsgReceiver", "receive ban comment newxml enableComment:" + j + " wording:" + paramString);
                          paramString = y.KTp;
                          AppMethodBeat.o(189870);
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
                      if (k.g(paramString, "LiveMicSucc")) {
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = bs.getLong(paramString, 0L);
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
                                localObject3 = g.guG;
                                g.alq().a(l1, paramMap, paramString, parama, (String)localObject1, (String)localObject2);
                                paramString = y.KTp;
                                AppMethodBeat.o(189870);
                                return;
                                paramString = null;
                                break;
                                if (k.g(paramString, "OnlineLiveList"))
                                {
                                  ac.i("MicroMsg.LiveSysMsgReceiver", "receive online livelist mmlive.");
                                  localObject1 = new bqe();
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
                                  paramString = ((bqe)localObject1).parseFrom(Base64.decode(paramString, 0));
                                  if (paramString == null)
                                  {
                                    paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveInfoList");
                                    AppMethodBeat.o(189870);
                                    throw paramString;
                                  }
                                  paramMap = (bqe)paramString;
                                  if ((paramMap != null) && (paramMap.fBS != null) && (paramMap.fBS.size() > 0)) {
                                    if (parama != null)
                                    {
                                      paramString = parama.fXi;
                                      if (paramString != null)
                                      {
                                        paramString = paramString.DPV;
                                        paramString = z.a(paramString);
                                        k.g(paramString, "msgContent");
                                        i = n.a((CharSequence)paramString, ":", 0, false, 6);
                                        if (i == -1) {
                                          break label2164;
                                        }
                                        paramString = paramString.substring(0, i);
                                        k.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                      }
                                    }
                                  }
                                }
                                for (;;)
                                {
                                  localObject1 = new LinkedList();
                                  localObject2 = paramMap.fBS.iterator();
                                  label2014:
                                  label2142:
                                  for (;;)
                                  {
                                    if (!((Iterator)localObject2).hasNext()) {
                                      break label2144;
                                    }
                                    localObject3 = (bqd)((Iterator)localObject2).next();
                                    if (parama != null)
                                    {
                                      paramMap = parama.fXi;
                                      if (paramMap == null) {}
                                    }
                                    for (paramMap = paramMap.DPU;; paramMap = null)
                                    {
                                      if (z.a(paramMap).equals(((bqd)localObject3).Ffg)) {
                                        break label2142;
                                      }
                                      paramMap = new com.tencent.mm.live.b.c.b();
                                      paramMap.field_liveId = ((bqd)localObject3).DMV;
                                      paramMap.field_hostRoomId = paramString;
                                      paramMap.field_liveName = ((bqd)localObject3).Ffh;
                                      paramMap.field_anchorUsername = ((bqd)localObject3).Ffg;
                                      paramMap.field_isSender = false;
                                      paramMap.field_timeStamp = ((bqd)localObject3).EbF;
                                      ((LinkedList)localObject1).add(paramMap);
                                      break label2014;
                                      paramString = null;
                                      break;
                                    }
                                  }
                                  label2144:
                                  com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().a((LinkedList)localObject1, paramString);
                                  paramString = y.KTp;
                                  AppMethodBeat.o(189870);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.j
 * JD-Core Version:    0.7.0.1
 */
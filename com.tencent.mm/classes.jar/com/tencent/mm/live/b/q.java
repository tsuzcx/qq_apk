package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "()V", "onNewXmlReceived", "", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-logic_release"})
public final class q
  implements com.tencent.mm.plugin.messenger.foundation.a.t
{
  public static final a kvG;
  
  static
  {
    AppMethodBeat.i(201153);
    kvG = new a((byte)0);
    AppMethodBeat.o(201153);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(201150);
    long l1;
    if (kotlin.g.b.p.h(paramString, "ApplyLiveMic")) {
      if (paramMap != null)
      {
        paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
        l1 = Util.getLong(paramString, 0L);
        if (paramMap != null)
        {
          paramString = (String)paramMap.get(".sysmsg.mmlive.live_mic_id");
          if (paramString != null) {
            break label1775;
          }
        }
        paramString = "";
      }
    }
    label318:
    label365:
    label1775:
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
            Object localObject2 = p.kvF;
            localObject2 = p.aOe();
            if (localObject2 != null)
            {
              ((g)localObject2).onApplyLiveMic(new b(l1, paramString, parama, (String)localObject1, paramMap));
              localObject2 = x.aazN;
            }
            Log.i("MicroMsg.LiveSysMsgReceiver", "receive apply live mic newxml. liveId:" + l1 + " micId:" + paramString + " uid:" + parama + " roomId:" + (String)localObject1 + " sdkUid:" + paramMap);
            paramString = x.aazN;
            AppMethodBeat.o(201150);
            return;
            paramString = null;
            break;
            if (kotlin.g.b.p.h(paramString, "AcceptLiveMic")) {
              if (paramMap != null)
              {
                paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                l1 = Util.getLong(paramString, 0L);
                if (paramMap != null)
                {
                  paramString = (String)paramMap.get(".sysmsg.mmlive.live_mic_id");
                  if (paramString != null) {
                    break label1763;
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
                i = Util.getInt(parama, 0);
                if (paramMap != null)
                {
                  parama = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_user_id");
                  if (parama != null) {
                    break label1760;
                  }
                }
                parama = "";
              }
              for (;;)
              {
                int j;
                int k;
                if (paramMap != null)
                {
                  localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_live_id");
                  j = Util.getInt((String)localObject1, 0);
                  if (paramMap == null) {
                    break label539;
                  }
                  localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_role_id");
                  k = Util.getInt((String)localObject1, 0);
                  if (paramMap != null)
                  {
                    localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_user_sig");
                    if (localObject1 != null) {
                      break label1757;
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
                    if (paramMap != null) {}
                    long l2;
                    for (Object localObject3 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.expire_for_pmk");; localObject3 = null)
                    {
                      l2 = Util.getLong((String)localObject3, 300L);
                      if (paramMap == null) {
                        break label574;
                      }
                      paramMap = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_params");
                      if (paramMap == null) {
                        break label574;
                      }
                      localObject3 = kotlin.n.d.UTF_8;
                      if (paramMap != null) {
                        break label551;
                      }
                      paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                      AppMethodBeat.o(201150);
                      throw paramString;
                      paramString = null;
                      break;
                      parama = null;
                      break label318;
                      localObject1 = null;
                      break label365;
                      localObject1 = null;
                      break label390;
                    }
                    localObject3 = paramMap.getBytes((Charset)localObject3);
                    kotlin.g.b.p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
                    paramMap = (Map<String, String>)localObject3;
                    if (localObject3 == null) {
                      paramMap = null;
                    }
                    localObject3 = p.kvF;
                    localObject3 = p.aOe();
                    if (localObject3 != null)
                    {
                      ((g)localObject3).onAcceptLiveMic(new a(l1, paramString, parama, i, k, j, (String)localObject1, (String)localObject2, l2, paramMap, null, 0L, 15360));
                      paramMap = x.aazN;
                    }
                    Log.i("MicroMsg.LiveSysMsgReceiver", "receive accept live mic newxml. liveId:" + l1 + " micId:" + paramString);
                    paramString = x.aazN;
                    AppMethodBeat.o(201150);
                    return;
                    if (kotlin.g.b.p.h(paramString, "CloseLive"))
                    {
                      if (paramMap != null) {}
                      for (paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");; paramString = null)
                      {
                        l1 = Util.getLong(paramString, 0L);
                        com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().FM(l1);
                        paramString = com.tencent.mm.live.b.c.a.kyw;
                        com.tencent.mm.live.b.c.a.FL(l1);
                        paramString = p.kvF;
                        paramString = p.aOe();
                        if (paramString != null)
                        {
                          paramString.onCloseLive(new e(l1));
                          paramString = x.aazN;
                        }
                        Log.i("MicroMsg.LiveSysMsgReceiver", "receive close live newxml liveId:".concat(String.valueOf(l1)));
                        paramString = x.aazN;
                        AppMethodBeat.o(201150);
                        return;
                      }
                    }
                    if (kotlin.g.b.p.h(paramString, "CloseLiveMic")) {
                      if (paramMap != null)
                      {
                        paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                        l1 = Util.getLong(paramString, 0L);
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.audience");
                          if (paramString != null) {
                            break label1751;
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
                      parama = p.kvF;
                      parama = p.aOe();
                      if (parama != null)
                      {
                        parama.onCloseLiveMic(new f(l1, paramString, paramMap));
                        parama = x.aazN;
                      }
                      Log.i("MicroMsg.LiveSysMsgReceiver", "receive close mic newxml liveid:" + l1 + " audience:" + paramString + ", micId:" + paramMap);
                      paramString = x.aazN;
                      AppMethodBeat.o(201150);
                      return;
                      paramString = null;
                      break;
                      if (kotlin.g.b.p.h(paramString, "CloseApplyLiveMic"))
                      {
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = Util.getLong(paramString, 0L);
                          if (paramMap == null) {
                            break label1096;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.enable_apply_live_mic");
                          if (Util.getInt(paramString, 0) != 1) {
                            break label1101;
                          }
                        }
                        for (boolean bool = true;; bool = false)
                        {
                          paramString = p.kvF;
                          paramString = p.aOe();
                          if (paramString != null)
                          {
                            paramString.onCloseApplyLiveMic(new d(l1, bool));
                            paramString = x.aazN;
                          }
                          Log.i("MicroMsg.LiveSysMsgReceiver", "receive CloseApplyLiveMic newxml liveId:" + l1 + ", " + bool);
                          paramString = x.aazN;
                          AppMethodBeat.o(201150);
                          return;
                          paramString = null;
                          break;
                          paramString = null;
                          break label1002;
                        }
                      }
                      if (kotlin.g.b.p.h(paramString, "BanLiveComment"))
                      {
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = Util.getLong(paramString, 0L);
                          if (paramMap == null) {
                            break label1279;
                          }
                          paramString = (String)paramMap.get(".sysmsg.mmlive.enable_comment");
                          i = Util.getInt(paramString, 0);
                          if (paramMap == null) {
                            break label1284;
                          }
                        }
                        for (paramString = (String)paramMap.get(".sysmsg.mmlive.wording");; paramString = null)
                        {
                          paramString = Util.nullAsNil(paramString);
                          paramMap = p.kvF;
                          paramMap = p.aOe();
                          if (paramMap != null)
                          {
                            paramMap.onBanLiveComment(new c(l1, i, paramString));
                            paramMap = x.aazN;
                          }
                          Log.i("MicroMsg.LiveSysMsgReceiver", "receive ban comment newxml liveId:" + l1 + " enableComment:" + i + " wording:" + paramString);
                          paramString = x.aazN;
                          AppMethodBeat.o(201150);
                          return;
                          paramString = null;
                          break;
                          label1279:
                          paramString = null;
                          break label1157;
                        }
                      }
                      if (kotlin.g.b.p.h(paramString, "LiveMicSucc")) {
                        if (paramMap != null)
                        {
                          paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
                          l1 = Util.getLong(paramString, 0L);
                          if (paramMap != null)
                          {
                            paramString = (String)paramMap.get(".sysmsg.mmlive.identity_id");
                            if (paramString != null) {
                              break label1748;
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
                                localObject3 = p.kvF;
                                localObject3 = p.aOe();
                                if (localObject3 != null)
                                {
                                  ((g)localObject3).onLiveMicSucc(new n(l1, paramString, parama, (String)localObject1, (String)localObject2, paramMap));
                                  parama = x.aazN;
                                }
                                Log.i("MicroMsg.LiveSysMsgReceiver", "receive live mic success. liveId:" + l1 + " audience:" + paramString + " nickName:" + (String)localObject1 + " sdkUid:" + (String)localObject2 + " micId:" + paramMap);
                                paramString = x.aazN;
                                AppMethodBeat.o(201150);
                                return;
                                paramString = null;
                                break;
                                if (kotlin.g.b.p.h(paramString, "OnlineLiveList"))
                                {
                                  Log.i("MicroMsg.LiveSysMsgReceiver", "receive online livelist mmlive.");
                                  if (paramMap != null)
                                  {
                                    paramString = (String)paramMap.get(".sysmsg.mmlive.live_info_list");
                                    if (paramString != null) {
                                      break label1733;
                                    }
                                  }
                                  paramString = "";
                                }
                                for (;;)
                                {
                                  if (parama != null)
                                  {
                                    paramMap = parama.jQG;
                                    if (paramMap != null)
                                    {
                                      paramMap = paramMap.RIF;
                                      paramMap = z.a(paramMap);
                                      if (paramMap != null) {
                                        break label1730;
                                      }
                                      paramMap = "";
                                    }
                                  }
                                  for (;;)
                                  {
                                    if (parama != null)
                                    {
                                      parama = parama.jQG;
                                      if (parama == null) {}
                                    }
                                    for (parama = parama.RIE;; parama = null)
                                    {
                                      localObject1 = z.a(parama);
                                      parama = (h.a)localObject1;
                                      if (localObject1 == null) {
                                        parama = "";
                                      }
                                      localObject1 = p.kvF;
                                      localObject1 = p.aOe();
                                      if (localObject1 == null) {
                                        break label1724;
                                      }
                                      ((g)localObject1).onOnlineLiveList(new s(paramString, paramMap, parama));
                                      paramString = x.aazN;
                                      AppMethodBeat.o(201150);
                                      return;
                                      paramMap = null;
                                      break;
                                    }
                                    AppMethodBeat.o(201150);
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
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveSysMsgReceiver$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.q
 * JD-Core Version:    0.7.0.1
 */
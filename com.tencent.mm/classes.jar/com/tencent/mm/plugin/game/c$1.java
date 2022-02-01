package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.g.a.zm;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.game.model.a.h.a;
import com.tencent.mm.plugin.game.model.g.1;
import com.tencent.mm.plugin.game.model.g.2;
import com.tencent.mm.plugin.game.model.g.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.e;
import com.tencent.mm.plugin.game.model.o.k;
import com.tencent.mm.plugin.game.model.o.l;
import com.tencent.mm.plugin.game.model.o.m;
import com.tencent.mm.plugin.game.model.o.n;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class c$1
  implements cd.a
{
  c$1(c paramc) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(40823);
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cWG();
    Object localObject1 = parama.gqE;
    parama = z.a(((cv)localObject1).Fvk);
    ad.i("MicroMsg.GameMessageService", "Received a message: %d", new Object[] { Long.valueOf(((cv)localObject1).xbt) });
    ad.i("MicroMsg.GameMessageService", "Message content: %s".concat(String.valueOf(parama)));
    int i;
    if (bt.isNullOrNil(parama))
    {
      ad.e("MicroMsg.GameMessageParser", "msg content is null");
      parama = null;
      if (parama != null)
      {
        ad.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s, gameMsgId:%s, reportMode:%d", new Object[] { Integer.valueOf(parama.field_msgType), parama.field_appId, Long.valueOf(parama.field_msgId), parama.field_gameMsgId, Integer.valueOf(parama.ucv.udo) });
        i = 0;
        switch (parama.field_msgType)
        {
        default: 
          if (parama == null)
          {
            ad.e("MicroMsg.GameMessageService", "msg is null");
            i = -1;
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        r.j(parama);
        ad.i("MicroMsg.GameMessageService", "Insert raw message: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().insert(parama)) });
        if (parama.crL()) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 1L, 1L, false);
        }
      }
      ad.i("MicroMsg.GameMessageService", "process status:%d", new Object[] { Integer.valueOf(i) });
      Object localObject3;
      for (;;)
      {
        if (bt.isNullOrNil(parama.field_gameMsgId)) {
          parama.field_gameMsgId = parama.ucv.hIG;
        }
        if (parama.crL())
        {
          com.tencent.mm.game.report.f.a(aj.getContext(), 0, 0, 0, 18, i, parama.field_appId, 0, parama.ucz, parama.field_gameMsgId, parama.ucA, com.tencent.mm.game.report.f.a("resource", String.valueOf(parama.ubM.ucM), parama.ucB, null));
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 0L, 1L, false);
        }
        AppMethodBeat.o(40823);
        return;
        localObject3 = bw.M(parama, "sysmsg");
        if ((localObject3 == null) || (((Map)localObject3).size() == 0))
        {
          ad.e("MicroMsg.GameMessageParser", "Parse failed");
          parama = null;
          break;
        }
        if (!"gamecenter".equalsIgnoreCase((String)((Map)localObject3).get(".sysmsg.$type")))
        {
          ad.e("MicroMsg.GameMessageParser", "Type not matched");
          parama = null;
          break;
        }
        localObject1 = new o();
        ((o)localObject1).field_showInMsgList = true;
        ((o)localObject1).field_msgId = System.currentTimeMillis();
        ((o)localObject1).field_rawXML = parama;
        ((o)localObject1).field_hasMergedCount = 1;
        ((o)localObject1).field_msgType = bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.$newmsgtype"), 0);
        if ((((o)localObject1).field_msgType == 100) || (((o)localObject1).field_msgType == 30))
        {
          u.cZk();
          ((o)localObject1).field_gameMsgId = bt.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_id"), "");
          ((o)localObject1).field_appId = ((String)((Map)localObject3).get(".sysmsg.gamecenter.appid"));
          ((o)localObject1).field_createTime = bt.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L);
          l1 = bt.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.expire_time"), 0L);
          if (l1 == 0L)
          {
            ((o)localObject1).field_expireTime = 9223372036854775807L;
            label619:
            ((o)localObject1).ubA = bt.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.random_time"), 0L);
            if (bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
              break label1260;
            }
            bool1 = true;
            label664:
            ((o)localObject1).field_isHidden = bool1;
            ((o)localObject1).field_mergerId = bt.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.merge_id"), "");
            ((o)localObject1).field_weight = bt.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.weight"), "");
            ((o)localObject1).field_receiveTime = (System.currentTimeMillis() / 1000L);
            u.s((Map)localObject3, (o)localObject1);
            ((o)localObject1).uca = bt.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.filter_flag"), 0L);
            ((o)localObject1).ucb = bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
            if (bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) <= 0) {
              break label1266;
            }
            bool1 = true;
            label805:
            ((o)localObject1).ubL = bool1;
            ((o)localObject1).ubM.ucK = bt.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
            if ((bt.isNullOrNil((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"))) && (bt.isNullOrNil((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc")))) {
              break label1272;
            }
            ((o)localObject1).ubN = true;
            label883:
            u.u((Map)localObject3, (o)localObject1);
            ((o)localObject1).ucs.ucX = bt.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
            ((o)localObject1).ucs.oCZ = bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.display_with_wepkg"), 0);
            if (!bt.isNullOrNil(((o)localObject1).ucs.ucX)) {
              ((o)localObject1).field_isHidden = true;
            }
            ((o)localObject1).ucs.ucY = bt.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
            u.w((Map)localObject3, (o)localObject1);
            u.x((Map)localObject3, (o)localObject1);
            u.k((Map)localObject3, (o)localObject1);
            u.y((Map)localObject3, (o)localObject1);
            u.z((Map)localObject3, (o)localObject1);
            ((o)localObject1).field_showType = ((o)localObject1).ucw.uda;
            if (((o)localObject1).field_showType == 0) {
              break label1795;
            }
            if (((o)localObject1).ucw.udb == 1) {
              ((o)localObject1).field_showInMsgList = false;
            }
            label1061:
            ((o)localObject1).field_interactiveMergeId = ((o)localObject1).ucw.udi;
            q.a((Map)localObject3, (o)localObject1);
            ((o)localObject1).ucu.udp = bt.getInt((String)((Map)localObject3).get(".sysmsg.support_version.$android"), 0);
            ad.i("MicroMsg.GameMessageParser", "xml support version: %d, current client version: %d", new Object[] { Integer.valueOf(((o)localObject1).ucu.udp), Integer.valueOf(com.tencent.mm.protocal.d.Fnj) });
            if ((((o)localObject1).ucu.udp != 0) && (((o)localObject1).ucu.udp > com.tencent.mm.protocal.d.Fnj)) {
              break label1813;
            }
          }
        }
        label1795:
        label1813:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1818;
          }
          ad.i("MicroMsg.GameMessageParser", "xml is invalid in current client version");
          if (((o)localObject1).crL()) {
            com.tencent.mm.game.report.f.a(aj.getContext(), 0, 0, 0, 401, 0, ((o)localObject1).field_appId, 0, 0, ((o)localObject1).field_gameMsgId, ((o)localObject1).ucA, "");
          }
          parama = null;
          break;
          ((o)localObject1).field_expireTime = (bt.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L) + l1);
          break label619;
          label1260:
          bool1 = false;
          break label664;
          label1266:
          bool1 = false;
          break label805;
          label1272:
          ((o)localObject1).ubN = false;
          break label883;
          ((o)localObject1).field_gameMsgId = bt.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_id"), "");
          ((o)localObject1).field_msgType = bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.$newmsgtype"), 0);
          if (((o)localObject1).field_msgType == 0) {
            ((o)localObject1).field_msgType = bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.$msgtype"), 0);
          }
          ((o)localObject1).field_appId = ((String)((Map)localObject3).get(".sysmsg.gamecenter.appinfo.appid"));
          if (!bt.isNullOrNil(q.ae((Map)localObject3)))
          {
            bool1 = true;
            label1389:
            ((o)localObject1).field_showInMsgList = bool1;
            ((o)localObject1).field_createTime = bt.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L);
            l1 = bt.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.expiredtime"), 0L);
            if (l1 != 0L) {
              break label1732;
            }
            ((o)localObject1).field_expireTime = 9223372036854775807L;
            label1458:
            if (bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
              break label1766;
            }
            bool1 = true;
            label1481:
            ((o)localObject1).field_isHidden = bool1;
            ((o)localObject1).field_mergerId = bt.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.merge_id"), "");
            if (((o)localObject1).field_msgType != 10) {
              break label1772;
            }
            ((o)localObject1).field_weight = "6";
            label1530:
            ((o)localObject1).field_receiveTime = (System.currentTimeMillis() / 1000L);
            ((o)localObject1).uca = bt.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.filter_flag"), 0L);
            ((o)localObject1).ubZ = q.af((Map)localObject3);
            ((o)localObject1).ucb = bt.getInt((String)((Map)localObject3).get(".sysmsg.game_control_info.not_in_msg_center"), 0);
            if (bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) <= 0) {
              break label1783;
            }
            bool1 = true;
            label1619:
            ((o)localObject1).ubN = bool1;
            ((o)localObject1).ucA = bt.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.noticeid"), "");
            ((o)localObject1).ubM.ucM = bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.badge_display_type"), 0);
            if (((o)localObject1).ubM.ucM <= 0) {
              break label1789;
            }
          }
          label1732:
          label1766:
          label1772:
          label1783:
          label1789:
          for (bool1 = true;; bool1 = false)
          {
            ((o)localObject1).ubL = bool1;
            if ((((o)localObject1).ubZ & 0x4) == 0L) {
              ((o)localObject1).ubL = false;
            }
            q.m((Map)localObject3, (o)localObject1);
            break;
            bool1 = false;
            break label1389;
            ((o)localObject1).field_expireTime = (bt.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L) + l1);
            break label1458;
            bool1 = false;
            break label1481;
            ((o)localObject1).field_weight = "2";
            break label1530;
            bool1 = false;
            break label1619;
          }
          if (((o)localObject1).ucb != 1) {
            break label1061;
          }
          ((o)localObject1).field_showInMsgList = false;
          break label1061;
        }
        label1818:
        if (com.tencent.mm.plugin.game.model.g.ubg == null) {
          com.tencent.mm.plugin.game.model.g.ubg = new com.tencent.mm.plugin.game.model.g();
        }
        bool1 = ((o)localObject1).crL();
        parama = bt.bI((String)((Map)localObject3).get(".sysmsg.wepkg.$pkg_id"), "");
        i = bt.getInt((String)((Map)localObject3).get(".sysmsg.wepkg.download_trigger_type"), 0);
        int j = bt.getInt((String)((Map)localObject3).get(".sysmsg.wepkg.download_type"), 0);
        com.tencent.e.h.LTJ.aU(new g.1(parama, i, j, bool1));
        if (((Map)localObject3).get(".sysmsg.control_command") == null) {
          ad.i("MicroMsg.GameControlCmdParser", "dont exist control command");
        }
        label2038:
        long l2;
        label2583:
        for (;;)
        {
          parama = (e.a)localObject1;
          break;
          label2083:
          g.a locala;
          if (((Map)localObject3).get(".sysmsg.control_command.global_setting") != null)
          {
            i = bt.getInt((String)((Map)localObject3).get(".sysmsg.control_command.global_setting.pull_trigger_type"), 0);
            l1 = bt.getLong((String)((Map)localObject3).get(".sysmsg.control_command.global_setting.expect_complete_seconds"), 0L);
            ad.i("MicroMsg.GameControlCmdParser", "pull_trigger_type:%d, expect_complete_seconds:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l1) });
            if (i != 0) {
              break label2523;
            }
            if (l1 <= 0L)
            {
              l1 = 0L;
              l2 = bt.aQJ();
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAm, Long.valueOf(l2 + l1));
              com.tencent.mm.plugin.game.commlib.util.a.cWY().postDelayed(new g.2(), l1 * 1000L);
            }
          }
          else if (((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf") != null)
          {
            locala = new g.a();
            locala.startTime = bt.getLong((String)((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf.$start_time"), 0L);
            locala.endTime = bt.getLong((String)((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf.$end_time"), 0L);
            locala.ubl = bt.getInt((String)((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf.$msg_type"), -10);
            locala.ubm.addAll(com.tencent.mm.plugin.game.model.g.x(".sysmsg.control_command.message_setting.hide_conf", (Map)localObject3));
          }
          for (parama = bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAn, ""));; parama = new JSONArray())
          {
            try
            {
              if (bt.isNullOrNil(parama)) {
                continue;
              }
              localObject2 = new JSONArray(parama);
              parama = (e.a)localObject2;
              if (((JSONArray)localObject2).length() > 20)
              {
                ((JSONArray)localObject2).remove(0);
                parama = (e.a)localObject2;
              }
              parama.put(locala.toJson());
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAn, parama.toString());
              ad.i("MicroMsg.GameControlCmdParser", "hideConf list size:%d, content:%s", new Object[] { Integer.valueOf(parama.length()), parama.toString() });
            }
            catch (JSONException parama)
            {
              for (;;)
              {
                label2523:
                continue;
                try
                {
                  parama = new JSONObject(parama);
                }
                catch (JSONException parama) {}
              }
            }
            if (((Map)localObject3).get(".sysmsg.control_command.message_setting.del_conf") != null)
            {
              parama = new ArrayList();
              parama.addAll(com.tencent.mm.plugin.game.model.g.x(".sysmsg.control_command.message_setting.del_conf", (Map)localObject3));
              com.tencent.mm.plugin.game.model.g.c(parama, bool1);
            }
            com.tencent.mm.plugin.game.model.g.ad((Map)localObject3);
            if (((Map)localObject3).get(".sysmsg.control_command.auto_run_switch") == null) {
              break;
            }
            localObject2 = ax.aQz("game_mmkv");
            if (localObject2 == null) {
              break;
            }
            parama = ((ax)localObject2).decodeString("auto_run_switch", "");
            if (!bt.isNullOrNil(parama)) {
              break label2583;
            }
            parama = new JSONObject();
            com.tencent.mm.plugin.game.model.g.a("md5_check", (Map)localObject3, parama);
            com.tencent.mm.plugin.game.model.g.a("download_resume", (Map)localObject3, parama);
            com.tencent.mm.plugin.game.model.g.a("preload_commlib", (Map)localObject3, parama);
            com.tencent.mm.plugin.game.model.g.a("game_silent_download", (Map)localObject3, parama);
            com.tencent.mm.plugin.game.model.g.a("wepkg_download_retry", (Map)localObject3, parama);
            com.tencent.mm.plugin.game.model.g.a("wepkg_expired_clean", (Map)localObject3, parama);
            com.tencent.mm.plugin.game.model.g.a("game_cache_clean", (Map)localObject3, parama);
            ((ax)localObject2).encode("auto_run_switch", parama.toString());
            break;
            i = bt.jw((int)l1, 0);
            ad.i("MicroMsg.GameControlCmdParser", "random time interval:%d", new Object[] { Integer.valueOf(i) });
            l1 = i;
            break label2038;
            if (i != 1) {
              break label2083;
            }
            if (com.tencent.mm.plugin.wepkg.utils.d.cH(aj.getContext()))
            {
              com.tencent.mm.plugin.game.commlib.b.cWV().mW(true);
              break label2083;
            }
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAm, Long.valueOf(bt.aQJ()));
            break label2083;
          }
        }
        ad.i("MicroMsg.GameMessageService", "control command message");
        continue;
        ad.i("MicroMsg.GameMessageService", "silent download message");
        localObject1 = h.a.cZL();
        if ((parama == null) || (bt.isNullOrNil(parama.field_appId)))
        {
          ad.i("MicroMsg.GameSilentDownloader", "msg is null");
          com.tencent.mm.plugin.downloader.f.a.ab("appid_is_empty", 16L);
        }
        else
        {
          localObject2 = parama.field_appId;
          l1 = parama.field_expireTime;
          l2 = parama.ubA;
          localObject3 = new com.tencent.mm.plugin.game.model.a.d();
          ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_appId = ((String)localObject2);
          if (!((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWJ().get((com.tencent.mm.sdk.e.c)localObject3, new String[0]))
          {
            ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_expireTime = l1;
            ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_randomTime = l2;
            ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_isFirst = true;
            ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_isRunning = false;
            ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_noWifi = true;
            ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_noSdcard = true;
            ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_noEnoughSpace = true;
            ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_lowBattery = true;
            ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_continueDelay = true;
            ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_forceUpdateFlag = 0;
            bool1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWJ().insert((com.tencent.mm.sdk.e.c)localObject3);
            ad.i("MicroMsg.GameSilentDownloader", "insert GameSilentDownloadTask, appid:%s, expireTime:%d, randomTime:%d, ret:%b", new Object[] { ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_appId, Long.valueOf(((com.tencent.mm.plugin.game.model.a.d)localObject3).field_expireTime), Long.valueOf(((com.tencent.mm.plugin.game.model.a.d)localObject3).field_randomTime), Boolean.valueOf(bool1) });
            ((com.tencent.mm.plugin.game.model.a.h)localObject1).ng(false);
          }
          else
          {
            ad.i("MicroMsg.GameSilentDownloader", "GameSilentDownloadTask exist! appid = %s", new Object[] { localObject2 });
            com.tencent.mm.plugin.downloader.f.a.ab((String)localObject2, 17L);
          }
        }
      }
      if (r.c(parama))
      {
        ad.i("MicroMsg.GameMessageService", "filter deleted message");
        i = 5;
        continue;
      }
      if (parama.ubY == 1)
      {
        ad.i("MicroMsg.GameMessageService", "only in ios");
        i = 6;
        continue;
      }
      localObject1 = parama.field_gameMsgId;
      if (!bt.isNullOrNil((String)localObject1))
      {
        localObject2 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH();
        i = 0;
        localObject1 = ((s)localObject2).rawQuery("select count(*) from GameRawMessage where gameMsgId = \"" + (String)localObject1 + "\"", new String[0]);
        if (localObject1 != null)
        {
          if (((Cursor)localObject1).moveToFirst()) {
            i = ((Cursor)localObject1).getInt(0);
          }
          ((Cursor)localObject1).close();
          if (i <= 0) {}
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label3086;
        }
        ad.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[] { parama.field_gameMsgId });
        if (parama.crL()) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 4L, 1L, false);
        }
        i = 2;
        break;
      }
      label3086:
      long l1 = System.currentTimeMillis() / 1000L;
      if (parama.field_expireTime <= l1) {}
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label3216;
        }
        ad.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[] { parama.field_gameMsgId });
        if (parama.crL()) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 5L, 1L, false);
        }
        localObject1 = parama.ucs.ucX;
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject2 = new zm();
          ((zm)localObject2).dOM.dkM = 6;
          ((zm)localObject2).dOM.dON = ((String)localObject1);
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
        }
        i = 1;
        break;
      }
      label3216:
      l1 = parama.uca;
      localObject1 = parama.field_appId;
      if (l1 == 1L)
      {
        if ((!bt.isNullOrNil((String)localObject1)) && (com.tencent.mm.pluginsdk.model.app.h.s(aj.getContext(), (String)localObject1))) {
          break label3364;
        }
        if (parama.crL()) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 6L, 1L, false);
        }
        i = 3;
      }
      for (;;)
      {
        if (i == 0) {
          break label3369;
        }
        ad.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", new Object[] { parama.field_gameMsgId, Integer.valueOf(i) });
        break;
        if ((l1 == 2L) && ((bt.isNullOrNil((String)localObject1)) || (com.tencent.mm.pluginsdk.model.app.h.s(aj.getContext(), (String)localObject1))))
        {
          if (parama.crL()) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 7L, 1L, false);
          }
          i = 4;
        }
        else
        {
          label3364:
          i = 0;
        }
      }
      label3369:
      if (parama.field_msgType == 30)
      {
        if (parama.crL()) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 8L, 1L, false);
        }
        i = 0;
        continue;
      }
      localObject1 = r.cYV();
      boolean bool1 = r.k((o)localObject1);
      boolean bool2 = r.k(parama);
      Object localObject2 = r.cYV();
      if (localObject2 != null)
      {
        ((o)localObject2).cYU();
        localObject3 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject3).put("oldNoticeId", ((o)localObject2).ucA);
        ((JSONObject)localObject3).put("oldMsgId", ((o)localObject2).field_gameMsgId);
        if (parama.field_weight.compareTo(((o)localObject2).field_weight) >= 0) {
          ((JSONObject)localObject3).put("coverType", 1);
        }
        for (;;)
        {
          if (parama.crL()) {
            com.tencent.mm.game.report.f.a(aj.getContext(), 0, 0, 0, 31, 0, parama.field_appId, 0, parama.ucz, parama.field_gameMsgId, parama.ucA, com.tencent.mm.plugin.game.e.a.wk(((JSONObject)localObject3).toString()));
          }
          if (parama.field_weight.compareTo(((o)localObject2).field_weight) < 0) {
            break label3861;
          }
          if (parama.crL()) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 10L, 1L, false);
          }
          localObject2 = ((o)localObject2).ucs.ucX;
          if (!bt.isNullOrNil((String)localObject2))
          {
            localObject3 = new zm();
            ((zm)localObject3).dOM.dkM = 6;
            ((zm)localObject3).dOM.dON = ((String)localObject2);
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
          }
          i = 1;
          if (i == 0) {
            break label3887;
          }
          i = 1;
          if (i == 0) {
            break label3892;
          }
          if ((localObject1 == null) || (!bool2) || (bool1))
          {
            if (!bool2) {
              r.d(parama);
            }
            r.e(parama);
            r.f(parama);
            r.g(parama);
          }
          if ((bool2) && (parama.crL())) {
            com.tencent.mm.game.report.f.a(aj.getContext(), 0, 0, 0, 404, 0, parama.field_appId, 0, parama.ucz, parama.field_gameMsgId, parama.ucA, com.tencent.mm.game.report.f.a("resource", String.valueOf(parama.ubM.ucM), parama.ucB, null));
          }
          if (parama.field_msgType == 4) {
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Itp, Long.valueOf(parama.field_msgId));
          }
          if ((parama != null) && (!bt.isNullOrNil(parama.ubM.ucK)))
          {
            if (!parama.ubM.ucN) {
              break label3921;
            }
            com.tencent.mm.plugin.game.f.c.i(parama.ubM.ucK, 0.08333334F);
          }
          i = 0;
          break;
          ((JSONObject)localObject3).put("coverType", 2);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.GameMessageService", "reportMsgCover: " + localException.getMessage());
          continue;
          label3861:
          if (parama.crL()) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 11L, 1L, false);
          }
          i = 0;
          continue;
          label3887:
          i = 0;
          continue;
          label3892:
          if ((bool1) && (!bool2))
          {
            r.d(parama);
            r.e(parama);
            r.f(parama);
            r.g(parama);
            continue;
            label3921:
            com.tencent.mm.plugin.game.f.c.i(parama.ubM.ucK, 0.0F);
          }
        }
      }
    }
  }
  
  public final void a(e.c paramc)
  {
    AppMethodBeat.i(40824);
    if ((paramc == null) || (bt.isNullOrNil(paramc.hOd)) || (bt.isNullOrNil(paramc.hOe)))
    {
      AppMethodBeat.o(40824);
      return;
    }
    ad.i("MicroMsg.GameEventListener", "delete msgType:%s, msgId:%s", new Object[] { paramc.hOd, paramc.hOe });
    if (!"gamecenter".equalsIgnoreCase(paramc.hOd))
    {
      AppMethodBeat.o(40824);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramc.hOe);
    com.tencent.mm.plugin.game.model.g.c(localArrayList, false);
    AppMethodBeat.o(40824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.1
 * JD-Core Version:    0.7.0.1
 */
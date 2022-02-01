package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.game.model.av;
import com.tencent.mm.plugin.game.model.g.1;
import com.tencent.mm.plugin.game.model.g.2;
import com.tencent.mm.plugin.game.model.g.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.f;
import com.tencent.mm.plugin.game.model.o.l;
import com.tencent.mm.plugin.game.model.o.m;
import com.tencent.mm.plugin.game.model.o.n;
import com.tencent.mm.plugin.game.model.o.o;
import com.tencent.mm.plugin.game.model.o.p;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  static o.a appForegroundListener;
  IListener grk;
  cj.a rBq;
  IListener sKr;
  IListener xtA;
  com.tencent.mm.pluginsdk.c.d xtB;
  com.tencent.mm.pluginsdk.c.d xtC;
  IListener xtD;
  IListener xtE;
  IListener xtF;
  IListener xtG;
  IListener xtH;
  av xtq;
  com.tencent.mm.plugin.game.media.background.b xtr;
  IListener xts;
  IListener xtt;
  IListener xtu;
  IListener xtv;
  IListener xtw;
  IListener xtx;
  IListener xty;
  IListener xtz;
  
  static
  {
    AppMethodBeat.i(204085);
    appForegroundListener = new c.13();
    AppMethodBeat.o(204085);
  }
  
  public c()
  {
    AppMethodBeat.i(40840);
    this.xtq = new av();
    this.xtr = new com.tencent.mm.plugin.game.media.background.b();
    this.rBq = new cj.a()
    {
      public final void a(com.tencent.mm.ak.h.a paramAnonymousa)
      {
        AppMethodBeat.i(40823);
        ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
        Object localObject1 = paramAnonymousa.heO;
        paramAnonymousa = z.a(((de)localObject1).KHn);
        Log.i("MicroMsg.GameMessageService", "Received a message: %d", new Object[] { Long.valueOf(((de)localObject1).Brn) });
        Log.i("MicroMsg.GameMessageService", "Message content: %s".concat(String.valueOf(paramAnonymousa)));
        int i;
        if (Util.isNullOrNil(paramAnonymousa))
        {
          Log.e("MicroMsg.GameMessageParser", "msg content is null");
          paramAnonymousa = null;
          if (paramAnonymousa != null)
          {
            Log.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s, gameMsgId:%s, reportMode:%d, reportSample:%d", new Object[] { Integer.valueOf(paramAnonymousa.field_msgType), paramAnonymousa.field_appId, Long.valueOf(paramAnonymousa.field_msgId), paramAnonymousa.field_gameMsgId, Integer.valueOf(paramAnonymousa.xFP.xGO), Integer.valueOf(paramAnonymousa.xFP.xGP) });
            i = 0;
            switch (paramAnonymousa.field_msgType)
            {
            default: 
              if (paramAnonymousa == null)
              {
                Log.e("MicroMsg.GameMessageService", "msg is null");
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
            r.j(paramAnonymousa);
            Log.i("MicroMsg.GameMessageService", "Insert raw message: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().insert(paramAnonymousa)) });
            if (paramAnonymousa.field_needReport) {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(858L, 1L, 1L, false);
            }
          }
          Log.i("MicroMsg.GameMessageService", "process status:%d", new Object[] { Integer.valueOf(i) });
          Object localObject3;
          for (;;)
          {
            if (Util.isNullOrNil(paramAnonymousa.field_gameMsgId)) {
              paramAnonymousa.field_gameMsgId = paramAnonymousa.xFP.iGB;
            }
            if (paramAnonymousa.field_needReport)
            {
              com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 0, 0, 0, 18, i, paramAnonymousa.field_appId, 0, paramAnonymousa.xFV, paramAnonymousa.field_gameMsgId, paramAnonymousa.xFW, com.tencent.mm.game.report.f.a("resource", String.valueOf(paramAnonymousa.xFg.xGi), paramAnonymousa.xFX, null));
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(858L, 0L, 1L, false);
            }
            AppMethodBeat.o(40823);
            return;
            localObject3 = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
            if ((localObject3 == null) || (((Map)localObject3).size() == 0))
            {
              Log.e("MicroMsg.GameMessageParser", "Parse failed");
              paramAnonymousa = null;
              break;
            }
            if (!"gamecenter".equalsIgnoreCase((String)((Map)localObject3).get(".sysmsg.$type")))
            {
              Log.e("MicroMsg.GameMessageParser", "Type not matched");
              paramAnonymousa = null;
              break;
            }
            localObject1 = new o();
            ((o)localObject1).field_showInMsgList = true;
            ((o)localObject1).field_msgId = System.currentTimeMillis();
            ((o)localObject1).field_rawXML = paramAnonymousa;
            ((o)localObject1).field_hasMergedCount = 1;
            ((o)localObject1).field_msgType = Util.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.$newmsgtype"), 0);
            if ((((o)localObject1).field_msgType == 100) || (((o)localObject1).field_msgType == 30))
            {
              u.dVC();
              ((o)localObject1).field_gameMsgId = Util.nullAs((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_id"), "");
              ((o)localObject1).field_appId = ((String)((Map)localObject3).get(".sysmsg.gamecenter.appid"));
              ((o)localObject1).field_createTime = Util.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L);
              l1 = Util.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.expire_time"), 0L);
              if (l1 == 0L)
              {
                ((o)localObject1).field_expireTime = 9223372036854775807L;
                label637:
                ((o)localObject1).xEU = Util.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.random_time"), 0L);
                if (Util.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
                  break label1305;
                }
                bool1 = true;
                label682:
                ((o)localObject1).field_isHidden = bool1;
                ((o)localObject1).field_mergerId = Util.nullAs((String)((Map)localObject3).get(".sysmsg.gamecenter.merge_id"), "");
                ((o)localObject1).field_weight = Util.nullAs((String)((Map)localObject3).get(".sysmsg.gamecenter.weight"), "");
                ((o)localObject1).field_receiveTime = (System.currentTimeMillis() / 1000L);
                u.s((Map)localObject3, (o)localObject1);
                ((o)localObject1).xFu = Util.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.filter_flag"), 0L);
                ((o)localObject1).xFv = Util.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                if (Util.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) <= 0) {
                  break label1311;
                }
                bool1 = true;
                label823:
                ((o)localObject1).xFf = bool1;
                ((o)localObject1).xFg.xGg = Util.nullAs((String)((Map)localObject3).get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                if ((Util.isNullOrNil((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"))) && (Util.isNullOrNil((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc")))) {
                  break label1317;
                }
                ((o)localObject1).xFh = true;
                label901:
                u.u((Map)localObject3, (o)localObject1);
                ((o)localObject1).xFM.xGt = Util.nullAs((String)((Map)localObject3).get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                ((o)localObject1).xFM.pXp = Util.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                if (!Util.isNullOrNil(((o)localObject1).xFM.xGt)) {
                  ((o)localObject1).field_isHidden = true;
                }
                ((o)localObject1).xFM.xGu = Util.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
                u.w((Map)localObject3, (o)localObject1);
                u.x((Map)localObject3, (o)localObject1);
                u.k((Map)localObject3, (o)localObject1);
                u.y((Map)localObject3, (o)localObject1);
                u.z((Map)localObject3, (o)localObject1);
                u.A((Map)localObject3, (o)localObject1);
                u.B((Map)localObject3, (o)localObject1);
                ((o)localObject1).field_showType = ((o)localObject1).xFQ.xGz;
                if (((o)localObject1).field_showType == 0) {
                  break label1840;
                }
                if (((o)localObject1).xFQ.xGA == 1) {
                  ((o)localObject1).field_showInMsgList = false;
                }
                label1093:
                ((o)localObject1).field_interactiveMergeId = ((o)localObject1).xFQ.xGH;
                ((o)localObject1).field_redDotExpireTime = ((o)localObject1).xFS.xGx;
                q.a((Map)localObject3, (o)localObject1);
                ((o)localObject1).xFO.xGQ = Util.getInt((String)((Map)localObject3).get(".sysmsg.support_version.$android"), 0);
                Log.i("MicroMsg.GameMessageParser", "xml support version: %d, current client version: %d", new Object[] { Integer.valueOf(((o)localObject1).xFO.xGQ), Integer.valueOf(com.tencent.mm.protocal.d.KyO) });
                if ((((o)localObject1).xFO.xGQ != 0) && (((o)localObject1).xFO.xGQ > com.tencent.mm.protocal.d.KyO)) {
                  break label1858;
                }
              }
            }
            label1305:
            label1311:
            label1317:
            label1575:
            label1834:
            label1840:
            label1858:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1863;
              }
              Log.i("MicroMsg.GameMessageParser", "xml is invalid in current client version");
              if (((o)localObject1).field_needReport) {
                com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 0, 0, 0, 401, 0, ((o)localObject1).field_appId, 0, 0, ((o)localObject1).field_gameMsgId, ((o)localObject1).xFW, "");
              }
              paramAnonymousa = null;
              break;
              ((o)localObject1).field_expireTime = (Util.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L) + l1);
              break label637;
              bool1 = false;
              break label682;
              bool1 = false;
              break label823;
              ((o)localObject1).xFh = false;
              break label901;
              ((o)localObject1).field_gameMsgId = Util.nullAs((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_id"), "");
              ((o)localObject1).field_msgType = Util.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.$newmsgtype"), 0);
              if (((o)localObject1).field_msgType == 0) {
                ((o)localObject1).field_msgType = Util.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.$msgtype"), 0);
              }
              ((o)localObject1).field_appId = ((String)((Map)localObject3).get(".sysmsg.gamecenter.appinfo.appid"));
              if (!Util.isNullOrNil(q.al((Map)localObject3)))
              {
                bool1 = true;
                ((o)localObject1).field_showInMsgList = bool1;
                ((o)localObject1).field_createTime = Util.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L);
                l1 = Util.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.expiredtime"), 0L);
                if (l1 != 0L) {
                  break label1777;
                }
                ((o)localObject1).field_expireTime = 9223372036854775807L;
                label1503:
                if (Util.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
                  break label1811;
                }
                bool1 = true;
                label1526:
                ((o)localObject1).field_isHidden = bool1;
                ((o)localObject1).field_mergerId = Util.nullAs((String)((Map)localObject3).get(".sysmsg.gamecenter.merge_id"), "");
                if (((o)localObject1).field_msgType != 10) {
                  break label1817;
                }
                ((o)localObject1).field_weight = "6";
                ((o)localObject1).field_receiveTime = (System.currentTimeMillis() / 1000L);
                ((o)localObject1).xFu = Util.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.filter_flag"), 0L);
                ((o)localObject1).xFt = q.am((Map)localObject3);
                ((o)localObject1).xFv = Util.getInt((String)((Map)localObject3).get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                if (Util.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) <= 0) {
                  break label1828;
                }
                bool1 = true;
                ((o)localObject1).xFh = bool1;
                ((o)localObject1).xFW = Util.nullAs((String)((Map)localObject3).get(".sysmsg.gamecenter.noticeid"), "");
                ((o)localObject1).xFg.xGi = Util.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.badge_display_type"), 0);
                if (((o)localObject1).xFg.xGi <= 0) {
                  break label1834;
                }
              }
              for (bool1 = true;; bool1 = false)
              {
                ((o)localObject1).xFf = bool1;
                if ((((o)localObject1).xFt & 0x4) == 0L) {
                  ((o)localObject1).xFf = false;
                }
                q.m((Map)localObject3, (o)localObject1);
                break;
                bool1 = false;
                break label1434;
                label1777:
                ((o)localObject1).field_expireTime = (Util.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L) + l1);
                break label1503;
                bool1 = false;
                break label1526;
                ((o)localObject1).field_weight = "2";
                break label1575;
                bool1 = false;
                break label1664;
              }
              if (((o)localObject1).xFv != 1) {
                break label1093;
              }
              ((o)localObject1).field_showInMsgList = false;
              break label1093;
            }
            label1434:
            label1828:
            label1863:
            if (com.tencent.mm.plugin.game.model.g.xEA == null) {
              com.tencent.mm.plugin.game.model.g.xEA = new com.tencent.mm.plugin.game.model.g();
            }
            label1664:
            label1811:
            label1817:
            bool1 = ((o)localObject1).field_needReport;
            paramAnonymousa = Util.nullAs((String)((Map)localObject3).get(".sysmsg.wepkg.$pkg_id"), "");
            i = Util.getInt((String)((Map)localObject3).get(".sysmsg.wepkg.download_trigger_type"), 0);
            int j = Util.getInt((String)((Map)localObject3).get(".sysmsg.wepkg.download_type"), 0);
            com.tencent.f.h.RTc.ba(new g.1(paramAnonymousa, i, j, bool1));
            if (((Map)localObject3).get(".sysmsg.control_command") == null) {
              Log.i("MicroMsg.GameControlCmdParser", "dont exist control command");
            }
            label2083:
            long l2;
            label2577:
            label2638:
            for (;;)
            {
              paramAnonymousa = (com.tencent.mm.ak.h.a)localObject1;
              break;
              label2128:
              g.a locala;
              if (((Map)localObject3).get(".sysmsg.control_command.global_setting") != null)
              {
                i = Util.getInt((String)((Map)localObject3).get(".sysmsg.control_command.global_setting.pull_trigger_type"), 0);
                l1 = Util.getLong((String)((Map)localObject3).get(".sysmsg.control_command.global_setting.expect_complete_seconds"), 0L);
                Log.i("MicroMsg.GameControlCmdParser", "pull_trigger_type:%d, expect_complete_seconds:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l1) });
                if (i != 0) {
                  break label2577;
                }
                if (l1 <= 0L)
                {
                  l1 = 0L;
                  l2 = Util.nowSecond();
                  com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OcZ, Long.valueOf(l2 + l1));
                  com.tencent.mm.plugin.game.commlib.util.a.getWorkerHandler().postDelayed(new g.2(), l1 * 1000L);
                }
              }
              else if (((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf") != null)
              {
                locala = new g.a();
                locala.startTime = Util.getLong((String)((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf.$start_time"), 0L);
                locala.endTime = Util.getLong((String)((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf.$end_time"), 0L);
                locala.xEF = Util.getInt((String)((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf.$msg_type"), -10);
                locala.xEG.addAll(com.tencent.mm.plugin.game.model.g.D(".sysmsg.control_command.message_setting.hide_conf", (Map)localObject3));
              }
              for (paramAnonymousa = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oda, ""));; paramAnonymousa = new JSONArray())
              {
                try
                {
                  if (Util.isNullOrNil(paramAnonymousa)) {
                    continue;
                  }
                  localObject2 = new JSONArray(paramAnonymousa);
                  paramAnonymousa = (com.tencent.mm.ak.h.a)localObject2;
                  if (((JSONArray)localObject2).length() > 20)
                  {
                    ((JSONArray)localObject2).remove(0);
                    paramAnonymousa = (com.tencent.mm.ak.h.a)localObject2;
                  }
                  paramAnonymousa.put(locala.toJson());
                  com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oda, paramAnonymousa.toString());
                  Log.i("MicroMsg.GameControlCmdParser", "hideConf list size:%d, content:%s", new Object[] { Integer.valueOf(paramAnonymousa.length()), paramAnonymousa.toString() });
                }
                catch (JSONException paramAnonymousa)
                {
                  for (;;)
                  {
                    continue;
                    try
                    {
                      paramAnonymousa = new JSONObject(paramAnonymousa);
                    }
                    catch (JSONException paramAnonymousa) {}
                  }
                }
                if (((Map)localObject3).get(".sysmsg.control_command.message_setting.del_conf") != null)
                {
                  paramAnonymousa = new ArrayList();
                  paramAnonymousa.addAll(com.tencent.mm.plugin.game.model.g.D(".sysmsg.control_command.message_setting.del_conf", (Map)localObject3));
                  com.tencent.mm.plugin.game.model.g.g(paramAnonymousa, bool1);
                }
                com.tencent.mm.plugin.game.model.g.ak((Map)localObject3);
                if (((Map)localObject3).get(".sysmsg.control_command.auto_run_switch") == null) {
                  break;
                }
                localObject2 = MultiProcessMMKV.getMMKV("game_mmkv");
                if (localObject2 == null) {
                  break;
                }
                paramAnonymousa = ((MultiProcessMMKV)localObject2).decodeString("auto_run_switch", "");
                if (!Util.isNullOrNil(paramAnonymousa)) {
                  break label2638;
                }
                paramAnonymousa = new JSONObject();
                com.tencent.mm.plugin.game.model.g.a("md5_check", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("download_resume", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("preload_commlib", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("game_silent_download", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("wepkg_download_retry", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("wepkg_expired_clean", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("game_cache_clean", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("game_resource_check", (Map)localObject3, paramAnonymousa);
                ((MultiProcessMMKV)localObject2).encode("auto_run_switch", paramAnonymousa.toString());
                break;
                i = Util.getIntRandom((int)l1, 0);
                Log.i("MicroMsg.GameControlCmdParser", "random time interval:%d", new Object[] { Integer.valueOf(i) });
                l1 = i;
                break label2083;
                if (i != 1) {
                  break label2128;
                }
                if (com.tencent.mm.plugin.wepkg.utils.d.isAppOnForeground(MMApplicationContext.getContext()))
                {
                  com.tencent.mm.plugin.game.commlib.b.dTd().I(true, 1);
                  break label2128;
                }
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OcZ, Long.valueOf(Util.nowSecond()));
                break label2128;
              }
            }
            Log.i("MicroMsg.GameMessageService", "control command message");
            continue;
            Log.i("MicroMsg.GameMessageService", "silent download message");
            localObject1 = com.tencent.mm.plugin.game.model.a.h.a.dWd();
            if ((paramAnonymousa == null) || (Util.isNullOrNil(paramAnonymousa.field_appId)))
            {
              Log.i("MicroMsg.GameSilentDownloader", "msg is null");
              com.tencent.mm.plugin.downloader.f.a.aa("appid_is_empty", 16L);
            }
            else
            {
              localObject2 = paramAnonymousa.field_appId;
              l1 = paramAnonymousa.field_expireTime;
              l2 = paramAnonymousa.xEU;
              localObject3 = new com.tencent.mm.plugin.game.model.a.d();
              ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_appId = ((String)localObject2);
              if (!((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSM().get((IAutoDBItem)localObject3, new String[0]))
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
                bool1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSM().insert((IAutoDBItem)localObject3);
                Log.i("MicroMsg.GameSilentDownloader", "insert GameSilentDownloadTask, appid:%s, expireTime:%d, randomTime:%d, ret:%b", new Object[] { ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_appId, Long.valueOf(((com.tencent.mm.plugin.game.model.a.d)localObject3).field_expireTime), Long.valueOf(((com.tencent.mm.plugin.game.model.a.d)localObject3).field_randomTime), Boolean.valueOf(bool1) });
                ((com.tencent.mm.plugin.game.model.a.h)localObject1).pQ(false);
              }
              else
              {
                Log.i("MicroMsg.GameSilentDownloader", "GameSilentDownloadTask exist! appid = %s", new Object[] { localObject2 });
                com.tencent.mm.plugin.downloader.f.a.aa((String)localObject2, 17L);
              }
            }
          }
          if (r.c(paramAnonymousa))
          {
            Log.i("MicroMsg.GameMessageService", "filter deleted message");
            i = 5;
            continue;
          }
          if (paramAnonymousa.xFs == 1)
          {
            Log.i("MicroMsg.GameMessageService", "only in ios");
            i = 6;
            continue;
          }
          localObject1 = paramAnonymousa.field_gameMsgId;
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject2 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK();
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
              break label3141;
            }
            Log.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[] { paramAnonymousa.field_gameMsgId });
            if (paramAnonymousa.field_needReport) {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(858L, 4L, 1L, false);
            }
            i = 2;
            break;
          }
          label3141:
          long l1 = System.currentTimeMillis() / 1000L;
          if (paramAnonymousa.field_expireTime <= l1) {}
          for (i = 0;; i = 1)
          {
            if (i != 0) {
              break label3271;
            }
            Log.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[] { paramAnonymousa.field_gameMsgId });
            if (paramAnonymousa.field_needReport) {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(858L, 5L, 1L, false);
            }
            localObject1 = paramAnonymousa.xFM.xGt;
            if (!Util.isNullOrNil((String)localObject1))
            {
              localObject2 = new aaz();
              ((aaz)localObject2).eif.dDe = 6;
              ((aaz)localObject2).eif.eig = ((String)localObject1);
              EventCenter.instance.publish((IEvent)localObject2);
            }
            i = 1;
            break;
          }
          label3271:
          l1 = paramAnonymousa.xFu;
          localObject1 = paramAnonymousa.field_appId;
          if (l1 == 1L)
          {
            if ((!Util.isNullOrNil((String)localObject1)) && (com.tencent.mm.pluginsdk.model.app.h.s(MMApplicationContext.getContext(), (String)localObject1))) {
              break label3419;
            }
            if (paramAnonymousa.field_needReport) {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(858L, 6L, 1L, false);
            }
            i = 3;
          }
          for (;;)
          {
            if (i == 0) {
              break label3424;
            }
            Log.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", new Object[] { paramAnonymousa.field_gameMsgId, Integer.valueOf(i) });
            break;
            if ((l1 == 2L) && ((Util.isNullOrNil((String)localObject1)) || (com.tencent.mm.pluginsdk.model.app.h.s(MMApplicationContext.getContext(), (String)localObject1))))
            {
              if (paramAnonymousa.field_needReport) {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(858L, 7L, 1L, false);
              }
              i = 4;
            }
            else
            {
              label3419:
              i = 0;
            }
          }
          label3424:
          if (paramAnonymousa.field_msgType == 30)
          {
            if (paramAnonymousa.field_needReport) {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(858L, 8L, 1L, false);
            }
            i = 0;
            continue;
          }
          localObject1 = r.dVm();
          boolean bool1 = r.k((o)localObject1);
          boolean bool2 = r.k(paramAnonymousa);
          Object localObject2 = r.dVm();
          if (localObject2 != null)
          {
            ((o)localObject2).dVl();
            localObject3 = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject3).put("oldNoticeId", ((o)localObject2).xFW);
            ((JSONObject)localObject3).put("oldMsgId", ((o)localObject2).field_gameMsgId);
            if (paramAnonymousa.field_weight.compareTo(((o)localObject2).field_weight) >= 0) {
              ((JSONObject)localObject3).put("coverType", 1);
            }
            for (;;)
            {
              if (paramAnonymousa.field_needReport) {
                com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 0, 0, 0, 31, 0, paramAnonymousa.field_appId, 0, paramAnonymousa.xFV, paramAnonymousa.field_gameMsgId, paramAnonymousa.xFW, com.tencent.mm.plugin.game.d.a.Fh(((JSONObject)localObject3).toString()));
              }
              if (paramAnonymousa.field_weight.compareTo(((o)localObject2).field_weight) < 0) {
                break label3916;
              }
              if (paramAnonymousa.field_needReport) {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(858L, 10L, 1L, false);
              }
              localObject2 = ((o)localObject2).xFM.xGt;
              if (!Util.isNullOrNil((String)localObject2))
              {
                localObject3 = new aaz();
                ((aaz)localObject3).eif.dDe = 6;
                ((aaz)localObject3).eif.eig = ((String)localObject2);
                EventCenter.instance.publish((IEvent)localObject3);
              }
              i = 1;
              if (i == 0) {
                break label3942;
              }
              i = 1;
              if (i == 0) {
                break label3947;
              }
              if ((localObject1 == null) || (!bool2) || (bool1))
              {
                if (!bool2) {
                  r.d(paramAnonymousa);
                }
                r.e(paramAnonymousa);
                r.f(paramAnonymousa);
                r.g(paramAnonymousa);
              }
              if ((bool2) && (paramAnonymousa.field_needReport)) {
                com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 0, 0, 0, 404, 0, paramAnonymousa.field_appId, 0, paramAnonymousa.xFV, paramAnonymousa.field_gameMsgId, paramAnonymousa.xFW, com.tencent.mm.game.report.f.a("resource", String.valueOf(paramAnonymousa.xFg.xGi), paramAnonymousa.xFX, null));
              }
              if (paramAnonymousa.field_msgType == 4) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVO, Long.valueOf(paramAnonymousa.field_msgId));
              }
              if ((paramAnonymousa != null) && (!Util.isNullOrNil(paramAnonymousa.xFg.xGg)))
              {
                if (!paramAnonymousa.xFg.xGj) {
                  break label3976;
                }
                com.tencent.mm.plugin.game.e.c.g(paramAnonymousa.xFg.xGg, 0.08333334F);
              }
              i = 0;
              break;
              ((JSONObject)localObject3).put("coverType", 2);
            }
          }
          catch (Exception localException)
          {
            label3976:
            for (;;)
            {
              Log.e("MicroMsg.GameMessageService", "reportMsgCover: " + localException.getMessage());
              continue;
              label3916:
              if (paramAnonymousa.field_needReport) {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(858L, 11L, 1L, false);
              }
              i = 0;
              continue;
              label3942:
              i = 0;
              continue;
              label3947:
              if ((bool1) && (!bool2))
              {
                r.d(paramAnonymousa);
                r.e(paramAnonymousa);
                r.f(paramAnonymousa);
                r.g(paramAnonymousa);
                continue;
                com.tencent.mm.plugin.game.e.c.g(paramAnonymousa.xFg.xGg, 0.0F);
              }
            }
          }
        }
      }
      
      public final void a(h.c paramAnonymousc)
      {
        AppMethodBeat.i(40824);
        if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.iMe)) || (Util.isNullOrNil(paramAnonymousc.iMf)))
        {
          AppMethodBeat.o(40824);
          return;
        }
        Log.i("MicroMsg.GameEventListener", "delete msgType:%s, msgId:%s", new Object[] { paramAnonymousc.iMe, paramAnonymousc.iMf });
        if (!"gamecenter".equalsIgnoreCase(paramAnonymousc.iMe))
        {
          AppMethodBeat.o(40824);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramAnonymousc.iMf);
        com.tencent.mm.plugin.game.model.g.g(localArrayList, false);
        AppMethodBeat.o(40824);
      }
    };
    this.xts = new c.12(this);
    this.xtt = new IListener() {};
    this.xtu = new IListener() {};
    this.xtv = new IListener() {};
    this.xtw = new IListener() {};
    this.xtx = new c.18(this);
    this.xty = new IListener() {};
    this.xtz = new c.20(this);
    this.xtA = new IListener() {};
    this.xtB = new com.tencent.mm.pluginsdk.c.d()
    {
      public final IEvent azl(String paramAnonymousString)
      {
        AppMethodBeat.i(204073);
        iy localiy = new iy();
        localiy.dNC.event = paramAnonymousString;
        AppMethodBeat.o(204073);
        return localiy;
      }
      
      public final MStorage dSG()
      {
        AppMethodBeat.i(204074);
        s locals = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK();
        AppMethodBeat.o(204074);
        return locals;
      }
    };
    this.xtC = new c.4(this);
    this.grk = new c.5(this);
    this.xtD = new c.6(this);
    this.xtE = new IListener() {};
    this.xtF = new c.8(this);
    this.xtG = new c.9(this);
    this.sKr = new c.10(this);
    this.xtH = new IListener() {};
    AppMethodBeat.o(40840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c
 * JD-Core Version:    0.7.0.1
 */
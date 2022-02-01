package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.game.model.a.h.a;
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
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  static o.a appForegroundListener;
  com.tencent.mm.sdk.b.c fLW;
  cf.a qkv;
  com.tencent.mm.sdk.b.c riP;
  av uca;
  com.tencent.mm.plugin.game.media.background.b ucb;
  com.tencent.mm.sdk.b.c ucc;
  com.tencent.mm.sdk.b.c ucd;
  com.tencent.mm.sdk.b.c uce;
  com.tencent.mm.sdk.b.c ucf;
  com.tencent.mm.sdk.b.c ucg;
  com.tencent.mm.sdk.b.c uch;
  com.tencent.mm.sdk.b.c uci;
  com.tencent.mm.sdk.b.c ucj;
  com.tencent.mm.sdk.b.c uck;
  com.tencent.mm.pluginsdk.c.d ucl;
  com.tencent.mm.pluginsdk.c.d ucm;
  com.tencent.mm.sdk.b.c ucn;
  com.tencent.mm.sdk.b.c uco;
  com.tencent.mm.sdk.b.c ucp;
  com.tencent.mm.sdk.b.c ucq;
  com.tencent.mm.sdk.b.c ucr;
  
  static
  {
    AppMethodBeat.i(195602);
    appForegroundListener = new c.13();
    AppMethodBeat.o(195602);
  }
  
  public c()
  {
    AppMethodBeat.i(40840);
    this.uca = new av();
    this.ucb = new com.tencent.mm.plugin.game.media.background.b();
    this.qkv = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(40823);
        ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZk();
        Object localObject1 = paramAnonymousa.gte;
        paramAnonymousa = z.a(((cv)localObject1).FNI);
        ae.i("MicroMsg.GameMessageService", "Received a message: %d", new Object[] { Long.valueOf(((cv)localObject1).xrk) });
        ae.i("MicroMsg.GameMessageService", "Message content: %s".concat(String.valueOf(paramAnonymousa)));
        int i;
        if (bu.isNullOrNil(paramAnonymousa))
        {
          ae.e("MicroMsg.GameMessageParser", "msg content is null");
          paramAnonymousa = null;
          if (paramAnonymousa != null)
          {
            ae.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s, gameMsgId:%s, reportMode:%d", new Object[] { Integer.valueOf(paramAnonymousa.field_msgType), paramAnonymousa.field_appId, Long.valueOf(paramAnonymousa.field_msgId), paramAnonymousa.field_gameMsgId, Integer.valueOf(paramAnonymousa.unx.uow) });
            i = 0;
            switch (paramAnonymousa.field_msgType)
            {
            default: 
              if (paramAnonymousa == null)
              {
                ae.e("MicroMsg.GameMessageService", "msg is null");
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
            ae.i("MicroMsg.GameMessageService", "Insert raw message: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().insert(paramAnonymousa)) });
            if (paramAnonymousa.ctn()) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 1L, 1L, false);
            }
          }
          ae.i("MicroMsg.GameMessageService", "process status:%d", new Object[] { Integer.valueOf(i) });
          Object localObject3;
          for (;;)
          {
            if (bu.isNullOrNil(paramAnonymousa.field_gameMsgId)) {
              paramAnonymousa.field_gameMsgId = paramAnonymousa.unx.hLz;
            }
            if (paramAnonymousa.ctn())
            {
              com.tencent.mm.game.report.f.a(ak.getContext(), 0, 0, 0, 18, i, paramAnonymousa.field_appId, 0, paramAnonymousa.unD, paramAnonymousa.field_gameMsgId, paramAnonymousa.unE, com.tencent.mm.game.report.f.a("resource", String.valueOf(paramAnonymousa.umO.unR), paramAnonymousa.unF, null));
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 0L, 1L, false);
            }
            AppMethodBeat.o(40823);
            return;
            localObject3 = bx.M(paramAnonymousa, "sysmsg");
            if ((localObject3 == null) || (((Map)localObject3).size() == 0))
            {
              ae.e("MicroMsg.GameMessageParser", "Parse failed");
              paramAnonymousa = null;
              break;
            }
            if (!"gamecenter".equalsIgnoreCase((String)((Map)localObject3).get(".sysmsg.$type")))
            {
              ae.e("MicroMsg.GameMessageParser", "Type not matched");
              paramAnonymousa = null;
              break;
            }
            localObject1 = new o();
            ((o)localObject1).field_showInMsgList = true;
            ((o)localObject1).field_msgId = System.currentTimeMillis();
            ((o)localObject1).field_rawXML = paramAnonymousa;
            ((o)localObject1).field_hasMergedCount = 1;
            ((o)localObject1).field_msgType = bu.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.$newmsgtype"), 0);
            if ((((o)localObject1).field_msgType == 100) || (((o)localObject1).field_msgType == 30))
            {
              u.dbV();
              ((o)localObject1).field_gameMsgId = bu.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_id"), "");
              ((o)localObject1).field_appId = ((String)((Map)localObject3).get(".sysmsg.gamecenter.appid"));
              ((o)localObject1).field_createTime = bu.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L);
              l1 = bu.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.expire_time"), 0L);
              if (l1 == 0L)
              {
                ((o)localObject1).field_expireTime = 9223372036854775807L;
                label619:
                ((o)localObject1).umC = bu.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.random_time"), 0L);
                if (bu.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
                  break label1287;
                }
                bool1 = true;
                label664:
                ((o)localObject1).field_isHidden = bool1;
                ((o)localObject1).field_mergerId = bu.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.merge_id"), "");
                ((o)localObject1).field_weight = bu.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.weight"), "");
                ((o)localObject1).field_receiveTime = (System.currentTimeMillis() / 1000L);
                u.s((Map)localObject3, (o)localObject1);
                ((o)localObject1).unc = bu.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.filter_flag"), 0L);
                ((o)localObject1).und = bu.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                if (bu.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) <= 0) {
                  break label1293;
                }
                bool1 = true;
                label805:
                ((o)localObject1).umN = bool1;
                ((o)localObject1).umO.unP = bu.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                if ((bu.isNullOrNil((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"))) && (bu.isNullOrNil((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc")))) {
                  break label1299;
                }
                ((o)localObject1).umP = true;
                label883:
                u.u((Map)localObject3, (o)localObject1);
                ((o)localObject1).unu.uoc = bu.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                ((o)localObject1).unu.oJB = bu.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                if (!bu.isNullOrNil(((o)localObject1).unu.uoc)) {
                  ((o)localObject1).field_isHidden = true;
                }
                ((o)localObject1).unu.uod = bu.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
                u.w((Map)localObject3, (o)localObject1);
                u.x((Map)localObject3, (o)localObject1);
                u.k((Map)localObject3, (o)localObject1);
                u.y((Map)localObject3, (o)localObject1);
                u.z((Map)localObject3, (o)localObject1);
                u.A((Map)localObject3, (o)localObject1);
                u.B((Map)localObject3, (o)localObject1);
                ((o)localObject1).field_showType = ((o)localObject1).uny.uoi;
                if (((o)localObject1).field_showType == 0) {
                  break label1822;
                }
                if (((o)localObject1).uny.uoj == 1) {
                  ((o)localObject1).field_showInMsgList = false;
                }
                label1075:
                ((o)localObject1).field_interactiveMergeId = ((o)localObject1).uny.uoq;
                ((o)localObject1).field_redDotExpireTime = ((o)localObject1).unA.uog;
                q.a((Map)localObject3, (o)localObject1);
                ((o)localObject1).unw.uox = bu.getInt((String)((Map)localObject3).get(".sysmsg.support_version.$android"), 0);
                ae.i("MicroMsg.GameMessageParser", "xml support version: %d, current client version: %d", new Object[] { Integer.valueOf(((o)localObject1).unw.uox), Integer.valueOf(com.tencent.mm.protocal.d.FFH) });
                if ((((o)localObject1).unw.uox != 0) && (((o)localObject1).unw.uox > com.tencent.mm.protocal.d.FFH)) {
                  break label1840;
                }
              }
            }
            label1287:
            label1293:
            label1299:
            label1557:
            label1816:
            label1822:
            label1840:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1845;
              }
              ae.i("MicroMsg.GameMessageParser", "xml is invalid in current client version");
              if (((o)localObject1).ctn()) {
                com.tencent.mm.game.report.f.a(ak.getContext(), 0, 0, 0, 401, 0, ((o)localObject1).field_appId, 0, 0, ((o)localObject1).field_gameMsgId, ((o)localObject1).unE, "");
              }
              paramAnonymousa = null;
              break;
              ((o)localObject1).field_expireTime = (bu.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L) + l1);
              break label619;
              bool1 = false;
              break label664;
              bool1 = false;
              break label805;
              ((o)localObject1).umP = false;
              break label883;
              ((o)localObject1).field_gameMsgId = bu.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_id"), "");
              ((o)localObject1).field_msgType = bu.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.$newmsgtype"), 0);
              if (((o)localObject1).field_msgType == 0) {
                ((o)localObject1).field_msgType = bu.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.$msgtype"), 0);
              }
              ((o)localObject1).field_appId = ((String)((Map)localObject3).get(".sysmsg.gamecenter.appinfo.appid"));
              if (!bu.isNullOrNil(q.ak((Map)localObject3)))
              {
                bool1 = true;
                ((o)localObject1).field_showInMsgList = bool1;
                ((o)localObject1).field_createTime = bu.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L);
                l1 = bu.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.expiredtime"), 0L);
                if (l1 != 0L) {
                  break label1759;
                }
                ((o)localObject1).field_expireTime = 9223372036854775807L;
                label1485:
                if (bu.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
                  break label1793;
                }
                bool1 = true;
                label1508:
                ((o)localObject1).field_isHidden = bool1;
                ((o)localObject1).field_mergerId = bu.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.merge_id"), "");
                if (((o)localObject1).field_msgType != 10) {
                  break label1799;
                }
                ((o)localObject1).field_weight = "6";
                ((o)localObject1).field_receiveTime = (System.currentTimeMillis() / 1000L);
                ((o)localObject1).unc = bu.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.filter_flag"), 0L);
                ((o)localObject1).unb = q.al((Map)localObject3);
                ((o)localObject1).und = bu.getInt((String)((Map)localObject3).get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                if (bu.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) <= 0) {
                  break label1810;
                }
                bool1 = true;
                label1646:
                ((o)localObject1).umP = bool1;
                ((o)localObject1).unE = bu.bI((String)((Map)localObject3).get(".sysmsg.gamecenter.noticeid"), "");
                ((o)localObject1).umO.unR = bu.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.badge_display_type"), 0);
                if (((o)localObject1).umO.unR <= 0) {
                  break label1816;
                }
              }
              for (bool1 = true;; bool1 = false)
              {
                ((o)localObject1).umN = bool1;
                if ((((o)localObject1).unb & 0x4) == 0L) {
                  ((o)localObject1).umN = false;
                }
                q.m((Map)localObject3, (o)localObject1);
                break;
                bool1 = false;
                break label1416;
                label1759:
                ((o)localObject1).field_expireTime = (bu.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L) + l1);
                break label1485;
                bool1 = false;
                break label1508;
                ((o)localObject1).field_weight = "2";
                break label1557;
                bool1 = false;
                break label1646;
              }
              if (((o)localObject1).und != 1) {
                break label1075;
              }
              ((o)localObject1).field_showInMsgList = false;
              break label1075;
            }
            label1416:
            label1810:
            label1845:
            if (com.tencent.mm.plugin.game.model.g.umi == null) {
              com.tencent.mm.plugin.game.model.g.umi = new com.tencent.mm.plugin.game.model.g();
            }
            label1793:
            label1799:
            bool1 = ((o)localObject1).ctn();
            paramAnonymousa = bu.bI((String)((Map)localObject3).get(".sysmsg.wepkg.$pkg_id"), "");
            i = bu.getInt((String)((Map)localObject3).get(".sysmsg.wepkg.download_trigger_type"), 0);
            int j = bu.getInt((String)((Map)localObject3).get(".sysmsg.wepkg.download_type"), 0);
            com.tencent.e.h.MqF.aR(new g.1(paramAnonymousa, i, j, bool1));
            if (((Map)localObject3).get(".sysmsg.control_command") == null) {
              ae.i("MicroMsg.GameControlCmdParser", "dont exist control command");
            }
            label2065:
            long l2;
            label2610:
            for (;;)
            {
              paramAnonymousa = (e.a)localObject1;
              break;
              label2110:
              g.a locala;
              if (((Map)localObject3).get(".sysmsg.control_command.global_setting") != null)
              {
                i = bu.getInt((String)((Map)localObject3).get(".sysmsg.control_command.global_setting.pull_trigger_type"), 0);
                l1 = bu.getLong((String)((Map)localObject3).get(".sysmsg.control_command.global_setting.expect_complete_seconds"), 0L);
                ae.i("MicroMsg.GameControlCmdParser", "pull_trigger_type:%d, expect_complete_seconds:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l1) });
                if (i != 0) {
                  break label2550;
                }
                if (l1 <= 0L)
                {
                  l1 = 0L;
                  l2 = bu.aRi();
                  com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUL, Long.valueOf(l2 + l1));
                  com.tencent.mm.plugin.game.commlib.util.a.cZF().postDelayed(new g.2(), l1 * 1000L);
                }
              }
              else if (((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf") != null)
              {
                locala = new g.a();
                locala.startTime = bu.getLong((String)((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf.$start_time"), 0L);
                locala.endTime = bu.getLong((String)((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf.$end_time"), 0L);
                locala.umn = bu.getInt((String)((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf.$msg_type"), -10);
                locala.umo.addAll(com.tencent.mm.plugin.game.model.g.y(".sysmsg.control_command.message_setting.hide_conf", (Map)localObject3));
              }
              for (paramAnonymousa = bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUM, ""));; paramAnonymousa = new JSONArray())
              {
                try
                {
                  if (bu.isNullOrNil(paramAnonymousa)) {
                    continue;
                  }
                  localObject2 = new JSONArray(paramAnonymousa);
                  paramAnonymousa = (e.a)localObject2;
                  if (((JSONArray)localObject2).length() > 20)
                  {
                    ((JSONArray)localObject2).remove(0);
                    paramAnonymousa = (e.a)localObject2;
                  }
                  paramAnonymousa.put(locala.toJson());
                  com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUM, paramAnonymousa.toString());
                  ae.i("MicroMsg.GameControlCmdParser", "hideConf list size:%d, content:%s", new Object[] { Integer.valueOf(paramAnonymousa.length()), paramAnonymousa.toString() });
                }
                catch (JSONException paramAnonymousa)
                {
                  for (;;)
                  {
                    label2550:
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
                  paramAnonymousa.addAll(com.tencent.mm.plugin.game.model.g.y(".sysmsg.control_command.message_setting.del_conf", (Map)localObject3));
                  com.tencent.mm.plugin.game.model.g.c(paramAnonymousa, bool1);
                }
                com.tencent.mm.plugin.game.model.g.aj((Map)localObject3);
                if (((Map)localObject3).get(".sysmsg.control_command.auto_run_switch") == null) {
                  break;
                }
                localObject2 = ay.aRW("game_mmkv");
                if (localObject2 == null) {
                  break;
                }
                paramAnonymousa = ((ay)localObject2).decodeString("auto_run_switch", "");
                if (!bu.isNullOrNil(paramAnonymousa)) {
                  break label2610;
                }
                paramAnonymousa = new JSONObject();
                com.tencent.mm.plugin.game.model.g.a("md5_check", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("download_resume", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("preload_commlib", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("game_silent_download", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("wepkg_download_retry", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("wepkg_expired_clean", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("game_cache_clean", (Map)localObject3, paramAnonymousa);
                ((ay)localObject2).encode("auto_run_switch", paramAnonymousa.toString());
                break;
                i = bu.jA((int)l1, 0);
                ae.i("MicroMsg.GameControlCmdParser", "random time interval:%d", new Object[] { Integer.valueOf(i) });
                l1 = i;
                break label2065;
                if (i != 1) {
                  break label2110;
                }
                if (com.tencent.mm.plugin.wepkg.utils.d.cJ(ak.getContext()))
                {
                  com.tencent.mm.plugin.game.commlib.b.cZC().na(true);
                  break label2110;
                }
                com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUL, Long.valueOf(bu.aRi()));
                break label2110;
              }
            }
            ae.i("MicroMsg.GameMessageService", "control command message");
            continue;
            ae.i("MicroMsg.GameMessageService", "silent download message");
            localObject1 = h.a.dcw();
            if ((paramAnonymousa == null) || (bu.isNullOrNil(paramAnonymousa.field_appId)))
            {
              ae.i("MicroMsg.GameSilentDownloader", "msg is null");
              com.tencent.mm.plugin.downloader.f.a.ab("appid_is_empty", 16L);
            }
            else
            {
              localObject2 = paramAnonymousa.field_appId;
              l1 = paramAnonymousa.field_expireTime;
              l2 = paramAnonymousa.umC;
              localObject3 = new com.tencent.mm.plugin.game.model.a.d();
              ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_appId = ((String)localObject2);
              if (!((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().get((com.tencent.mm.sdk.e.c)localObject3, new String[0]))
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
                bool1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().insert((com.tencent.mm.sdk.e.c)localObject3);
                ae.i("MicroMsg.GameSilentDownloader", "insert GameSilentDownloadTask, appid:%s, expireTime:%d, randomTime:%d, ret:%b", new Object[] { ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_appId, Long.valueOf(((com.tencent.mm.plugin.game.model.a.d)localObject3).field_expireTime), Long.valueOf(((com.tencent.mm.plugin.game.model.a.d)localObject3).field_randomTime), Boolean.valueOf(bool1) });
                ((com.tencent.mm.plugin.game.model.a.h)localObject1).nk(false);
              }
              else
              {
                ae.i("MicroMsg.GameSilentDownloader", "GameSilentDownloadTask exist! appid = %s", new Object[] { localObject2 });
                com.tencent.mm.plugin.downloader.f.a.ab((String)localObject2, 17L);
              }
            }
          }
          if (r.c(paramAnonymousa))
          {
            ae.i("MicroMsg.GameMessageService", "filter deleted message");
            i = 5;
            continue;
          }
          if (paramAnonymousa.una == 1)
          {
            ae.i("MicroMsg.GameMessageService", "only in ios");
            i = 6;
            continue;
          }
          localObject1 = paramAnonymousa.field_gameMsgId;
          if (!bu.isNullOrNil((String)localObject1))
          {
            localObject2 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl();
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
              break label3113;
            }
            ae.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[] { paramAnonymousa.field_gameMsgId });
            if (paramAnonymousa.ctn()) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 4L, 1L, false);
            }
            i = 2;
            break;
          }
          label3113:
          long l1 = System.currentTimeMillis() / 1000L;
          if (paramAnonymousa.field_expireTime <= l1) {}
          for (i = 0;; i = 1)
          {
            if (i != 0) {
              break label3243;
            }
            ae.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[] { paramAnonymousa.field_gameMsgId });
            if (paramAnonymousa.ctn()) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 5L, 1L, false);
            }
            localObject1 = paramAnonymousa.unu.uoc;
            if (!bu.isNullOrNil((String)localObject1))
            {
              localObject2 = new zs();
              ((zs)localObject2).dQc.dlO = 6;
              ((zs)localObject2).dQc.dQd = ((String)localObject1);
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
            }
            i = 1;
            break;
          }
          label3243:
          l1 = paramAnonymousa.unc;
          localObject1 = paramAnonymousa.field_appId;
          if (l1 == 1L)
          {
            if ((!bu.isNullOrNil((String)localObject1)) && (com.tencent.mm.pluginsdk.model.app.h.s(ak.getContext(), (String)localObject1))) {
              break label3391;
            }
            if (paramAnonymousa.ctn()) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 6L, 1L, false);
            }
            i = 3;
          }
          for (;;)
          {
            if (i == 0) {
              break label3396;
            }
            ae.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", new Object[] { paramAnonymousa.field_gameMsgId, Integer.valueOf(i) });
            break;
            if ((l1 == 2L) && ((bu.isNullOrNil((String)localObject1)) || (com.tencent.mm.pluginsdk.model.app.h.s(ak.getContext(), (String)localObject1))))
            {
              if (paramAnonymousa.ctn()) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 7L, 1L, false);
              }
              i = 4;
            }
            else
            {
              label3391:
              i = 0;
            }
          }
          label3396:
          if (paramAnonymousa.field_msgType == 30)
          {
            if (paramAnonymousa.ctn()) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 8L, 1L, false);
            }
            i = 0;
            continue;
          }
          localObject1 = r.dbF();
          boolean bool1 = r.k((o)localObject1);
          boolean bool2 = r.k(paramAnonymousa);
          Object localObject2 = r.dbF();
          if (localObject2 != null)
          {
            ((o)localObject2).dbE();
            localObject3 = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject3).put("oldNoticeId", ((o)localObject2).unE);
            ((JSONObject)localObject3).put("oldMsgId", ((o)localObject2).field_gameMsgId);
            if (paramAnonymousa.field_weight.compareTo(((o)localObject2).field_weight) >= 0) {
              ((JSONObject)localObject3).put("coverType", 1);
            }
            for (;;)
            {
              if (paramAnonymousa.ctn()) {
                com.tencent.mm.game.report.f.a(ak.getContext(), 0, 0, 0, 31, 0, paramAnonymousa.field_appId, 0, paramAnonymousa.unD, paramAnonymousa.field_gameMsgId, paramAnonymousa.unE, com.tencent.mm.plugin.game.e.a.wT(((JSONObject)localObject3).toString()));
              }
              if (paramAnonymousa.field_weight.compareTo(((o)localObject2).field_weight) < 0) {
                break label3888;
              }
              if (paramAnonymousa.ctn()) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 10L, 1L, false);
              }
              localObject2 = ((o)localObject2).unu.uoc;
              if (!bu.isNullOrNil((String)localObject2))
              {
                localObject3 = new zs();
                ((zs)localObject3).dQc.dlO = 6;
                ((zs)localObject3).dQc.dQd = ((String)localObject2);
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
              }
              i = 1;
              if (i == 0) {
                break label3914;
              }
              i = 1;
              if (i == 0) {
                break label3919;
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
              if ((bool2) && (paramAnonymousa.ctn())) {
                com.tencent.mm.game.report.f.a(ak.getContext(), 0, 0, 0, 404, 0, paramAnonymousa.field_appId, 0, paramAnonymousa.unD, paramAnonymousa.field_gameMsgId, paramAnonymousa.unE, com.tencent.mm.game.report.f.a("resource", String.valueOf(paramAnonymousa.umO.unR), paramAnonymousa.unF, null));
              }
              if (paramAnonymousa.field_msgType == 4) {
                com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INL, Long.valueOf(paramAnonymousa.field_msgId));
              }
              if ((paramAnonymousa != null) && (!bu.isNullOrNil(paramAnonymousa.umO.unP)))
              {
                if (!paramAnonymousa.umO.unS) {
                  break label3948;
                }
                com.tencent.mm.plugin.game.f.c.i(paramAnonymousa.umO.unP, 0.08333334F);
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
              ae.e("MicroMsg.GameMessageService", "reportMsgCover: " + localException.getMessage());
              continue;
              label3888:
              if (paramAnonymousa.ctn()) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 11L, 1L, false);
              }
              i = 0;
              continue;
              label3914:
              i = 0;
              continue;
              label3919:
              if ((bool1) && (!bool2))
              {
                r.d(paramAnonymousa);
                r.e(paramAnonymousa);
                r.f(paramAnonymousa);
                r.g(paramAnonymousa);
                continue;
                label3948:
                com.tencent.mm.plugin.game.f.c.i(paramAnonymousa.umO.unP, 0.0F);
              }
            }
          }
        }
      }
      
      public final void a(e.c paramAnonymousc)
      {
        AppMethodBeat.i(40824);
        if ((paramAnonymousc == null) || (bu.isNullOrNil(paramAnonymousc.hQW)) || (bu.isNullOrNil(paramAnonymousc.hQX)))
        {
          AppMethodBeat.o(40824);
          return;
        }
        ae.i("MicroMsg.GameEventListener", "delete msgType:%s, msgId:%s", new Object[] { paramAnonymousc.hQW, paramAnonymousc.hQX });
        if (!"gamecenter".equalsIgnoreCase(paramAnonymousc.hQW))
        {
          AppMethodBeat.o(40824);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramAnonymousc.hQX);
        com.tencent.mm.plugin.game.model.g.c(localArrayList, false);
        AppMethodBeat.o(40824);
      }
    };
    this.ucc = new c.12(this);
    this.ucd = new c.14(this);
    this.uce = new com.tencent.mm.sdk.b.c() {};
    this.ucf = new com.tencent.mm.sdk.b.c() {};
    this.ucg = new com.tencent.mm.sdk.b.c() {};
    this.uch = new c.18(this);
    this.uci = new com.tencent.mm.sdk.b.c() {};
    this.ucj = new c.20(this);
    this.uck = new com.tencent.mm.sdk.b.c() {};
    this.ucl = new com.tencent.mm.pluginsdk.c.d()
    {
      public final com.tencent.mm.sdk.b.b amh(String paramAnonymousString)
      {
        AppMethodBeat.i(195590);
        ij localij = new ij();
        localij.dvV.dmp = paramAnonymousString;
        AppMethodBeat.o(195590);
        return localij;
      }
      
      public final k cZh()
      {
        AppMethodBeat.i(195591);
        s locals = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl();
        AppMethodBeat.o(195591);
        return locals;
      }
    };
    this.ucm = new com.tencent.mm.pluginsdk.c.d()
    {
      public final com.tencent.mm.sdk.b.b amh(String paramAnonymousString)
      {
        AppMethodBeat.i(195592);
        ii localii = new ii();
        localii.dvU.dmp = paramAnonymousString;
        AppMethodBeat.o(195592);
        return localii;
      }
      
      public final k cZh()
      {
        AppMethodBeat.i(195593);
        com.tencent.mm.plugin.gamelife.e.d locald = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).dds();
        AppMethodBeat.o(195593);
        return locald;
      }
    };
    this.fLW = new c.5(this);
    this.ucn = new c.6(this);
    this.uco = new c.7(this);
    this.ucp = new c.8(this);
    this.ucq = new c.9(this);
    this.riP = new c.10(this);
    this.ucr = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(40840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c
 * JD-Core Version:    0.7.0.1
 */
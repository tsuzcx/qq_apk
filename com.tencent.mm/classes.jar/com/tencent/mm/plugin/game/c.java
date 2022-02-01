package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.g.a.im;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.game.model.a.h.a;
import com.tencent.mm.plugin.game.model.av;
import com.tencent.mm.plugin.game.model.g.1;
import com.tencent.mm.plugin.game.model.g.2;
import com.tencent.mm.plugin.game.model.g.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.d;
import com.tencent.mm.plugin.game.model.o.j;
import com.tencent.mm.plugin.game.model.o.k;
import com.tencent.mm.plugin.game.model.o.l;
import com.tencent.mm.plugin.game.model.o.m;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  static n.a appForegroundListener;
  com.tencent.mm.sdk.b.c fop;
  cc.a oXa;
  com.tencent.mm.sdk.b.c pIJ;
  av rMV;
  com.tencent.mm.plugin.game.media.background.b rMW;
  com.tencent.mm.sdk.b.c rMX;
  com.tencent.mm.sdk.b.c rMY;
  com.tencent.mm.sdk.b.c rMZ;
  com.tencent.mm.sdk.b.c rNa;
  com.tencent.mm.sdk.b.c rNb;
  com.tencent.mm.sdk.b.c rNc;
  com.tencent.mm.sdk.b.c rNd;
  com.tencent.mm.sdk.b.c rNe;
  com.tencent.mm.pluginsdk.c.d rNf;
  com.tencent.mm.sdk.b.c rNg;
  com.tencent.mm.sdk.b.c rNh;
  com.tencent.mm.sdk.b.c rNi;
  com.tencent.mm.sdk.b.c rNj;
  com.tencent.mm.sdk.b.c rNk;
  
  static
  {
    AppMethodBeat.i(196742);
    appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(196741);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.kernel.a.aeC();
        }
        AppMethodBeat.o(196741);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(196740);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = Long.valueOf(bt.f((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqf, Long.valueOf(0L))));
            if ((paramAnonymousString.longValue() != 0L) && (bt.aGK() > paramAnonymousString.longValue())) {
              com.tencent.mm.plugin.game.commlib.b.cBq().lL(true);
            }
          }
        }
        AppMethodBeat.o(196740);
      }
    };
    AppMethodBeat.o(196742);
  }
  
  public c()
  {
    AppMethodBeat.i(40840);
    this.rMV = new av();
    this.rMW = new com.tencent.mm.plugin.game.media.background.b();
    this.oXa = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(40823);
        ((com.tencent.mm.plugin.game.api.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.d.class)).cBc();
        Object localObject1 = paramAnonymousa.fTo;
        paramAnonymousa = z.a(((cs)localObject1).Cxz);
        ad.i("MicroMsg.GameMessageService", "Received a message: %d", new Object[] { Long.valueOf(((cs)localObject1).uKZ) });
        ad.i("MicroMsg.GameMessageService", "Message content: %s".concat(String.valueOf(paramAnonymousa)));
        int i;
        if (bt.isNullOrNil(paramAnonymousa))
        {
          ad.e("MicroMsg.GameMessageParser", "msg content is null");
          paramAnonymousa = null;
          if (paramAnonymousa != null)
          {
            ad.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s, gameMsgId:%s, reportMode:%d", new Object[] { Integer.valueOf(paramAnonymousa.field_msgType), paramAnonymousa.field_appId, Long.valueOf(paramAnonymousa.field_msgId), paramAnonymousa.field_gameMsgId, Integer.valueOf(paramAnonymousa.rWN.rXG) });
            i = 0;
            switch (paramAnonymousa.field_msgType)
            {
            default: 
              if (paramAnonymousa == null)
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
            r.j(paramAnonymousa);
            ad.i("MicroMsg.GameMessageService", "Insert raw message: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().insert(paramAnonymousa)) });
            if (paramAnonymousa.cey()) {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(858L, 1L, 1L, false);
            }
          }
          ad.i("MicroMsg.GameMessageService", "process status:%d", new Object[] { Integer.valueOf(i) });
          Object localObject3;
          for (;;)
          {
            if (bt.isNullOrNil(paramAnonymousa.field_gameMsgId)) {
              paramAnonymousa.field_gameMsgId = paramAnonymousa.rWN.gPO;
            }
            if (paramAnonymousa.cey())
            {
              com.tencent.mm.game.report.e.a(aj.getContext(), 0, 0, 0, 18, i, paramAnonymousa.field_appId, 0, paramAnonymousa.rWQ, paramAnonymousa.field_gameMsgId, paramAnonymousa.rWR, com.tencent.mm.game.report.e.a("resource", String.valueOf(paramAnonymousa.rWe.rXc), paramAnonymousa.rWS, null));
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(858L, 0L, 1L, false);
            }
            AppMethodBeat.o(40823);
            return;
            localObject3 = bw.K(paramAnonymousa, "sysmsg");
            if ((localObject3 == null) || (((Map)localObject3).size() == 0))
            {
              ad.e("MicroMsg.GameMessageParser", "Parse failed");
              paramAnonymousa = null;
              break;
            }
            if (!"gamecenter".equalsIgnoreCase((String)((Map)localObject3).get(".sysmsg.$type")))
            {
              ad.e("MicroMsg.GameMessageParser", "Type not matched");
              paramAnonymousa = null;
              break;
            }
            localObject1 = new o();
            ((o)localObject1).field_showInMsgList = true;
            ((o)localObject1).field_msgId = System.currentTimeMillis();
            ((o)localObject1).field_rawXML = paramAnonymousa;
            ((o)localObject1).field_hasMergedCount = 1;
            ((o)localObject1).field_msgType = bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.$newmsgtype"), 0);
            if ((((o)localObject1).field_msgType == 100) || (((o)localObject1).field_msgType == 30))
            {
              u.cDu();
              ((o)localObject1).field_gameMsgId = bt.by((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_id"), "");
              ((o)localObject1).field_appId = ((String)((Map)localObject3).get(".sysmsg.gamecenter.appid"));
              ((o)localObject1).field_createTime = bt.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L);
              l1 = bt.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.expire_time"), 0L);
              if (l1 == 0L)
              {
                ((o)localObject1).field_expireTime = 9223372036854775807L;
                label619:
                ((o)localObject1).rVS = bt.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.random_time"), 0L);
                if (bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
                  break label1253;
                }
                bool1 = true;
                label664:
                ((o)localObject1).field_isHidden = bool1;
                ((o)localObject1).field_mergerId = bt.by((String)((Map)localObject3).get(".sysmsg.gamecenter.merge_id"), "");
                ((o)localObject1).field_weight = bt.by((String)((Map)localObject3).get(".sysmsg.gamecenter.weight"), "");
                ((o)localObject1).field_receiveTime = (System.currentTimeMillis() / 1000L);
                u.s((Map)localObject3, (o)localObject1);
                ((o)localObject1).rWs = bt.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.filter_flag"), 0L);
                ((o)localObject1).rWt = bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                if (bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) <= 0) {
                  break label1259;
                }
                bool1 = true;
                label805:
                ((o)localObject1).rWd = bool1;
                ((o)localObject1).rWe.rXa = bt.by((String)((Map)localObject3).get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                if ((bt.isNullOrNil((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"))) && (bt.isNullOrNil((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc")))) {
                  break label1265;
                }
                ((o)localObject1).rWf = true;
                label883:
                u.u((Map)localObject3, (o)localObject1);
                ((o)localObject1).rWK.rXp = bt.by((String)((Map)localObject3).get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                ((o)localObject1).rWK.nwF = bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                if (!bt.isNullOrNil(((o)localObject1).rWK.rXp)) {
                  ((o)localObject1).field_isHidden = true;
                }
                ((o)localObject1).rWK.rXq = bt.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
                u.w((Map)localObject3, (o)localObject1);
                u.x((Map)localObject3, (o)localObject1);
                u.k((Map)localObject3, (o)localObject1);
                u.y((Map)localObject3, (o)localObject1);
                ((o)localObject1).field_showType = ((o)localObject1).rWO.rXs;
                if (((o)localObject1).field_showType == 0) {
                  break label1788;
                }
                if (((o)localObject1).rWO.rXt == 1) {
                  ((o)localObject1).field_showInMsgList = false;
                }
                label1054:
                ((o)localObject1).field_interactiveMergeId = ((o)localObject1).rWO.rXA;
                q.a((Map)localObject3, (o)localObject1);
                ((o)localObject1).rWM.rXH = bt.getInt((String)((Map)localObject3).get(".sysmsg.support_version.$android"), 0);
                ad.i("MicroMsg.GameMessageParser", "xml support version: %d, current client version: %d", new Object[] { Integer.valueOf(((o)localObject1).rWM.rXH), Integer.valueOf(com.tencent.mm.protocal.d.CpK) });
                if ((((o)localObject1).rWM.rXH != 0) && (((o)localObject1).rWM.rXH > com.tencent.mm.protocal.d.CpK)) {
                  break label1806;
                }
              }
            }
            label1806:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1811;
              }
              ad.i("MicroMsg.GameMessageParser", "xml is invalid in current client version");
              if (((o)localObject1).cey()) {
                com.tencent.mm.game.report.e.a(aj.getContext(), 0, 0, 0, 401, 0, ((o)localObject1).field_appId, 0, 0, ((o)localObject1).field_gameMsgId, ((o)localObject1).rWR, "");
              }
              paramAnonymousa = null;
              break;
              ((o)localObject1).field_expireTime = (bt.getLong((String)((Map)localObject3).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L) + l1);
              break label619;
              label1253:
              bool1 = false;
              break label664;
              label1259:
              bool1 = false;
              break label805;
              label1265:
              ((o)localObject1).rWf = false;
              break label883;
              ((o)localObject1).field_gameMsgId = bt.by((String)((Map)localObject3).get(".sysmsg.gamecenter.msg_id"), "");
              ((o)localObject1).field_msgType = bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.$newmsgtype"), 0);
              if (((o)localObject1).field_msgType == 0) {
                ((o)localObject1).field_msgType = bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.$msgtype"), 0);
              }
              ((o)localObject1).field_appId = ((String)((Map)localObject3).get(".sysmsg.gamecenter.appinfo.appid"));
              if (!bt.isNullOrNil(q.Z((Map)localObject3)))
              {
                bool1 = true;
                label1382:
                ((o)localObject1).field_showInMsgList = bool1;
                ((o)localObject1).field_createTime = bt.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L);
                l1 = bt.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.expiredtime"), 0L);
                if (l1 != 0L) {
                  break label1725;
                }
                ((o)localObject1).field_expireTime = 9223372036854775807L;
                label1451:
                if (bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
                  break label1759;
                }
                bool1 = true;
                label1474:
                ((o)localObject1).field_isHidden = bool1;
                ((o)localObject1).field_mergerId = bt.by((String)((Map)localObject3).get(".sysmsg.gamecenter.merge_id"), "");
                if (((o)localObject1).field_msgType != 10) {
                  break label1765;
                }
                ((o)localObject1).field_weight = "6";
                label1523:
                ((o)localObject1).field_receiveTime = (System.currentTimeMillis() / 1000L);
                ((o)localObject1).rWs = bt.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.filter_flag"), 0L);
                ((o)localObject1).rWr = q.aa((Map)localObject3);
                ((o)localObject1).rWt = bt.getInt((String)((Map)localObject3).get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                if (bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) <= 0) {
                  break label1776;
                }
                bool1 = true;
                label1612:
                ((o)localObject1).rWf = bool1;
                ((o)localObject1).rWR = bt.by((String)((Map)localObject3).get(".sysmsg.gamecenter.noticeid"), "");
                ((o)localObject1).rWe.rXc = bt.getInt((String)((Map)localObject3).get(".sysmsg.gamecenter.badge_display_type"), 0);
                if (((o)localObject1).rWe.rXc <= 0) {
                  break label1782;
                }
              }
              label1725:
              label1759:
              label1765:
              label1776:
              label1782:
              for (bool1 = true;; bool1 = false)
              {
                ((o)localObject1).rWd = bool1;
                if ((((o)localObject1).rWr & 0x4) == 0L) {
                  ((o)localObject1).rWd = false;
                }
                q.m((Map)localObject3, (o)localObject1);
                break;
                bool1 = false;
                break label1382;
                ((o)localObject1).field_expireTime = (bt.getLong((String)((Map)localObject3).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L) + l1);
                break label1451;
                bool1 = false;
                break label1474;
                ((o)localObject1).field_weight = "2";
                break label1523;
                bool1 = false;
                break label1612;
              }
              label1788:
              if (((o)localObject1).rWt != 1) {
                break label1054;
              }
              ((o)localObject1).field_showInMsgList = false;
              break label1054;
            }
            label1811:
            if (com.tencent.mm.plugin.game.model.g.rVy == null) {
              com.tencent.mm.plugin.game.model.g.rVy = new com.tencent.mm.plugin.game.model.g();
            }
            bool1 = ((o)localObject1).cey();
            paramAnonymousa = bt.by((String)((Map)localObject3).get(".sysmsg.wepkg.$pkg_id"), "");
            i = bt.getInt((String)((Map)localObject3).get(".sysmsg.wepkg.download_trigger_type"), 0);
            int j = bt.getInt((String)((Map)localObject3).get(".sysmsg.wepkg.download_type"), 0);
            com.tencent.e.h.Iye.aS(new g.1(paramAnonymousa, i, j, bool1));
            if (((Map)localObject3).get(".sysmsg.control_command") == null) {
              ad.i("MicroMsg.GameControlCmdParser", "dont exist control command");
            }
            label2031:
            long l2;
            label2576:
            for (;;)
            {
              paramAnonymousa = (f.a)localObject1;
              break;
              label2076:
              g.a locala;
              if (((Map)localObject3).get(".sysmsg.control_command.global_setting") != null)
              {
                i = bt.getInt((String)((Map)localObject3).get(".sysmsg.control_command.global_setting.pull_trigger_type"), 0);
                l1 = bt.getLong((String)((Map)localObject3).get(".sysmsg.control_command.global_setting.expect_complete_seconds"), 0L);
                ad.i("MicroMsg.GameControlCmdParser", "pull_trigger_type:%d, expect_complete_seconds:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l1) });
                if (i != 0) {
                  break label2516;
                }
                if (l1 <= 0L)
                {
                  l1 = 0L;
                  l2 = bt.aGK();
                  com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqf, Long.valueOf(l2 + l1));
                  com.tencent.mm.plugin.game.commlib.e.a.cBt().postDelayed(new g.2(), l1 * 1000L);
                }
              }
              else if (((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf") != null)
              {
                locala = new g.a();
                locala.startTime = bt.getLong((String)((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf.$start_time"), 0L);
                locala.endTime = bt.getLong((String)((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf.$end_time"), 0L);
                locala.rVD = bt.getInt((String)((Map)localObject3).get(".sysmsg.control_command.message_setting.hide_conf.$msg_type"), -10);
                locala.rVE.addAll(com.tencent.mm.plugin.game.model.g.u(".sysmsg.control_command.message_setting.hide_conf", (Map)localObject3));
              }
              for (paramAnonymousa = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqg, ""));; paramAnonymousa = new JSONArray())
              {
                try
                {
                  if (bt.isNullOrNil(paramAnonymousa)) {
                    continue;
                  }
                  localObject2 = new JSONArray(paramAnonymousa);
                  paramAnonymousa = (f.a)localObject2;
                  if (((JSONArray)localObject2).length() > 20)
                  {
                    ((JSONArray)localObject2).remove(0);
                    paramAnonymousa = (f.a)localObject2;
                  }
                  paramAnonymousa.put(locala.toJson());
                  com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqg, paramAnonymousa.toString());
                  ad.i("MicroMsg.GameControlCmdParser", "hideConf list size:%d, content:%s", new Object[] { Integer.valueOf(paramAnonymousa.length()), paramAnonymousa.toString() });
                }
                catch (JSONException paramAnonymousa)
                {
                  for (;;)
                  {
                    label2516:
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
                  paramAnonymousa.addAll(com.tencent.mm.plugin.game.model.g.u(".sysmsg.control_command.message_setting.del_conf", (Map)localObject3));
                  com.tencent.mm.plugin.game.model.g.c(paramAnonymousa, bool1);
                }
                com.tencent.mm.plugin.game.model.g.Y((Map)localObject3);
                if (((Map)localObject3).get(".sysmsg.control_command.auto_run_switch") == null) {
                  break;
                }
                localObject2 = ax.aFC("game_mmkv");
                if (localObject2 == null) {
                  break;
                }
                paramAnonymousa = ((ax)localObject2).decodeString("auto_run_switch", "");
                if (!bt.isNullOrNil(paramAnonymousa)) {
                  break label2576;
                }
                paramAnonymousa = new JSONObject();
                com.tencent.mm.plugin.game.model.g.a("md5_check", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("download_resume", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("preload_commlib", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("game_silent_download", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("wepkg_download_retry", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("wepkg_expired_clean", (Map)localObject3, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("game_cache_clean", (Map)localObject3, paramAnonymousa);
                ((ax)localObject2).encode("auto_run_switch", paramAnonymousa.toString());
                break;
                i = bt.iX((int)l1, 0);
                ad.i("MicroMsg.GameControlCmdParser", "random time interval:%d", new Object[] { Integer.valueOf(i) });
                l1 = i;
                break label2031;
                if (i != 1) {
                  break label2076;
                }
                if (com.tencent.mm.plugin.wepkg.utils.d.cB(aj.getContext()))
                {
                  com.tencent.mm.plugin.game.commlib.b.cBq().lL(true);
                  break label2076;
                }
                com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqf, Long.valueOf(bt.aGK()));
                break label2076;
              }
            }
            ad.i("MicroMsg.GameMessageService", "control command message");
            continue;
            ad.i("MicroMsg.GameMessageService", "silent download message");
            localObject1 = h.a.cDV();
            if ((paramAnonymousa == null) || (bt.isNullOrNil(paramAnonymousa.field_appId)))
            {
              ad.i("MicroMsg.GameSilentDownloader", "msg is null");
              com.tencent.mm.plugin.downloader.f.a.T("appid_is_empty", 16L);
            }
            else
            {
              localObject2 = paramAnonymousa.field_appId;
              l1 = paramAnonymousa.field_expireTime;
              l2 = paramAnonymousa.rVS;
              localObject3 = new com.tencent.mm.plugin.game.model.a.d();
              ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_appId = ((String)localObject2);
              if (!((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf().get((com.tencent.mm.sdk.e.c)localObject3, new String[0]))
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
                bool1 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf().insert((com.tencent.mm.sdk.e.c)localObject3);
                ad.i("MicroMsg.GameSilentDownloader", "insert GameSilentDownloadTask, appid:%s, expireTime:%d, randomTime:%d, ret:%b", new Object[] { ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_appId, Long.valueOf(((com.tencent.mm.plugin.game.model.a.d)localObject3).field_expireTime), Long.valueOf(((com.tencent.mm.plugin.game.model.a.d)localObject3).field_randomTime), Boolean.valueOf(bool1) });
                ((com.tencent.mm.plugin.game.model.a.h)localObject1).lT(false);
              }
              else
              {
                ad.i("MicroMsg.GameSilentDownloader", "GameSilentDownloadTask exist! appid = %s", new Object[] { localObject2 });
                com.tencent.mm.plugin.downloader.f.a.T((String)localObject2, 17L);
              }
            }
          }
          if (r.c(paramAnonymousa))
          {
            ad.i("MicroMsg.GameMessageService", "filter deleted message");
            i = 5;
            continue;
          }
          if (paramAnonymousa.rWq == 1)
          {
            ad.i("MicroMsg.GameMessageService", "only in ios");
            i = 6;
            continue;
          }
          localObject1 = paramAnonymousa.field_gameMsgId;
          if (!bt.isNullOrNil((String)localObject1))
          {
            localObject2 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd();
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
              break label3079;
            }
            ad.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[] { paramAnonymousa.field_gameMsgId });
            if (paramAnonymousa.cey()) {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(858L, 4L, 1L, false);
            }
            i = 2;
            break;
          }
          label3079:
          long l1 = System.currentTimeMillis() / 1000L;
          if (paramAnonymousa.field_expireTime <= l1) {}
          for (i = 0;; i = 1)
          {
            if (i != 0) {
              break label3209;
            }
            ad.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[] { paramAnonymousa.field_gameMsgId });
            if (paramAnonymousa.cey()) {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(858L, 5L, 1L, false);
            }
            localObject1 = paramAnonymousa.rWK.rXp;
            if (!bt.isNullOrNil((String)localObject1))
            {
              localObject2 = new yh();
              ((yh)localObject2).dEN.dbV = 6;
              ((yh)localObject2).dEN.dEO = ((String)localObject1);
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
            }
            i = 1;
            break;
          }
          label3209:
          l1 = paramAnonymousa.rWs;
          localObject1 = paramAnonymousa.field_appId;
          if (l1 == 1L)
          {
            if ((!bt.isNullOrNil((String)localObject1)) && (com.tencent.mm.pluginsdk.model.app.h.t(aj.getContext(), (String)localObject1))) {
              break label3357;
            }
            if (paramAnonymousa.cey()) {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(858L, 6L, 1L, false);
            }
            i = 3;
          }
          for (;;)
          {
            if (i == 0) {
              break label3362;
            }
            ad.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", new Object[] { paramAnonymousa.field_gameMsgId, Integer.valueOf(i) });
            break;
            if ((l1 == 2L) && ((bt.isNullOrNil((String)localObject1)) || (com.tencent.mm.pluginsdk.model.app.h.t(aj.getContext(), (String)localObject1))))
            {
              if (paramAnonymousa.cey()) {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(858L, 7L, 1L, false);
              }
              i = 4;
            }
            else
            {
              label3357:
              i = 0;
            }
          }
          label3362:
          if (paramAnonymousa.field_msgType == 30)
          {
            if (paramAnonymousa.cey()) {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(858L, 8L, 1L, false);
            }
            i = 0;
            continue;
          }
          localObject1 = r.cDg();
          boolean bool1 = r.k((o)localObject1);
          boolean bool2 = r.k(paramAnonymousa);
          Object localObject2 = r.cDg();
          if (localObject2 != null)
          {
            ((o)localObject2).cDf();
            localObject3 = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject3).put("oldNoticeId", ((o)localObject2).rWR);
            ((JSONObject)localObject3).put("oldMsgId", ((o)localObject2).field_gameMsgId);
            if (paramAnonymousa.field_weight.compareTo(((o)localObject2).field_weight) >= 0) {
              ((JSONObject)localObject3).put("coverType", 1);
            }
            for (;;)
            {
              if (paramAnonymousa.cey()) {
                com.tencent.mm.game.report.e.a(aj.getContext(), 0, 0, 0, 31, 0, paramAnonymousa.field_appId, 0, paramAnonymousa.rWQ, paramAnonymousa.field_gameMsgId, paramAnonymousa.rWR, com.tencent.mm.plugin.game.e.a.qh(((JSONObject)localObject3).toString()));
              }
              if (paramAnonymousa.field_weight.compareTo(((o)localObject2).field_weight) < 0) {
                break label3854;
              }
              if (paramAnonymousa.cey()) {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(858L, 10L, 1L, false);
              }
              localObject2 = ((o)localObject2).rWK.rXp;
              if (!bt.isNullOrNil((String)localObject2))
              {
                localObject3 = new yh();
                ((yh)localObject3).dEN.dbV = 6;
                ((yh)localObject3).dEN.dEO = ((String)localObject2);
                com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
              }
              i = 1;
              if (i == 0) {
                break label3880;
              }
              i = 1;
              if (i == 0) {
                break label3885;
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
              if ((bool2) && (paramAnonymousa.cey())) {
                com.tencent.mm.game.report.e.a(aj.getContext(), 0, 0, 0, 404, 0, paramAnonymousa.field_appId, 0, paramAnonymousa.rWQ, paramAnonymousa.field_gameMsgId, paramAnonymousa.rWR, com.tencent.mm.game.report.e.a("resource", String.valueOf(paramAnonymousa.rWe.rXc), paramAnonymousa.rWS, null));
              }
              if (paramAnonymousa.field_msgType == 4) {
                com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fji, Long.valueOf(paramAnonymousa.field_msgId));
              }
              if ((paramAnonymousa != null) && (!bt.isNullOrNil(paramAnonymousa.rWe.rXa)))
              {
                if (!paramAnonymousa.rWe.rXf) {
                  break label3914;
                }
                com.tencent.mm.plugin.game.f.c.i(paramAnonymousa.rWe.rXa, 0.08333334F);
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
              label3854:
              if (paramAnonymousa.cey()) {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(858L, 11L, 1L, false);
              }
              i = 0;
              continue;
              label3880:
              i = 0;
              continue;
              label3885:
              if ((bool1) && (!bool2))
              {
                r.d(paramAnonymousa);
                r.e(paramAnonymousa);
                r.f(paramAnonymousa);
                r.g(paramAnonymousa);
                continue;
                label3914:
                com.tencent.mm.plugin.game.f.c.i(paramAnonymousa.rWe.rXa, 0.0F);
              }
            }
          }
        }
      }
      
      public final void a(f.c paramAnonymousc)
      {
        AppMethodBeat.i(40824);
        if ((paramAnonymousc == null) || (bt.isNullOrNil(paramAnonymousc.gVp)) || (bt.isNullOrNil(paramAnonymousc.gVq)))
        {
          AppMethodBeat.o(40824);
          return;
        }
        ad.i("MicroMsg.GameEventListener", "delete msgType:%s, msgId:%s", new Object[] { paramAnonymousc.gVp, paramAnonymousc.gVq });
        if (!"gamecenter".equalsIgnoreCase(paramAnonymousc.gVp))
        {
          AppMethodBeat.o(40824);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramAnonymousc.gVq);
        com.tencent.mm.plugin.game.model.g.c(localArrayList, false);
        AppMethodBeat.o(40824);
      }
    };
    this.rMX = new com.tencent.mm.sdk.b.c() {};
    this.rMY = new com.tencent.mm.sdk.b.c() {};
    this.rMZ = new com.tencent.mm.sdk.b.c() {};
    this.rNa = new com.tencent.mm.sdk.b.c() {};
    this.rNb = new com.tencent.mm.sdk.b.c()
    {
      /* Error */
      private static boolean a(nn paramAnonymousnn)
      {
        // Byte code:
        //   0: ldc 52
        //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 54
        //   7: astore_3
        //   8: aload_3
        //   9: astore 4
        //   11: aload_3
        //   12: astore 5
        //   14: new 56	org/json/JSONObject
        //   17: dup
        //   18: aload_0
        //   19: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   22: getfield 66	com/tencent/mm/g/a/nn$a:extraInfo	Ljava/lang/String;
        //   25: invokespecial 69	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   28: astore 6
        //   30: aload_3
        //   31: astore 4
        //   33: aload_3
        //   34: astore 5
        //   36: aload 6
        //   38: ldc 71
        //   40: invokevirtual 75	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   43: astore_3
        //   44: aload_3
        //   45: astore 4
        //   47: aload_3
        //   48: astore 5
        //   50: aload 6
        //   52: ldc 77
        //   54: invokevirtual 75	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   57: iconst_0
        //   58: invokestatic 83	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
        //   61: istore_1
        //   62: aload 6
        //   64: ldc 85
        //   66: invokevirtual 75	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   69: astore 5
        //   71: aload_3
        //   72: astore 4
        //   74: aload 5
        //   76: astore_3
        //   77: new 87	android/content/Intent
        //   80: dup
        //   81: invokespecial 88	android/content/Intent:<init>	()V
        //   84: astore 5
        //   86: aload_0
        //   87: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   90: getfield 91	com/tencent/mm/g/a/nn$a:dsH	I
        //   93: tableswitch	default:+31 -> 124, 0:+100->193, 1:+237->330, 2:+374->467, 3:+529->622
        //   125: caload
        //   126: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   129: iconst_0
        //   130: ireturn
        //   131: astore 5
        //   133: iconst_0
        //   134: istore_1
        //   135: ldc 93
        //   137: ldc 95
        //   139: iconst_1
        //   140: anewarray 97	java/lang/Object
        //   143: dup
        //   144: iconst_0
        //   145: aload 5
        //   147: invokevirtual 100	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   150: aastore
        //   151: invokestatic 106	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   154: ldc 54
        //   156: astore_3
        //   157: goto -80 -> 77
        //   160: astore 4
        //   162: iconst_0
        //   163: istore_1
        //   164: ldc 93
        //   166: ldc 95
        //   168: iconst_1
        //   169: anewarray 97	java/lang/Object
        //   172: dup
        //   173: iconst_0
        //   174: aload 4
        //   176: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   179: aastore
        //   180: invokestatic 106	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   183: ldc 54
        //   185: astore_3
        //   186: aload 5
        //   188: astore 4
        //   190: goto -113 -> 77
        //   193: aload 5
        //   195: aload_0
        //   196: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   199: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   202: ldc 113
        //   204: invokevirtual 117	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
        //   207: pop
        //   208: aload_0
        //   209: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   212: getfield 120	com/tencent/mm/g/a/nn$a:jumpType	I
        //   215: iconst_1
        //   216: if_icmpne +13 -> 229
        //   219: aload 5
        //   221: ldc 122
        //   223: ldc 122
        //   225: invokevirtual 126	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   228: pop
        //   229: aload 5
        //   231: ldc 128
        //   233: iconst_5
        //   234: invokevirtual 131	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   237: pop
        //   238: aload_0
        //   239: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   242: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   245: astore_3
        //   246: new 133	com/tencent/mm/hellhoundlib/b/a
        //   249: dup
        //   250: invokespecial 134	com/tencent/mm/hellhoundlib/b/a:<init>	()V
        //   253: aload 5
        //   255: invokevirtual 138	com/tencent/mm/hellhoundlib/b/a:bd	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
        //   258: astore 4
        //   260: aload_3
        //   261: aload 4
        //   263: invokevirtual 142	com/tencent/mm/hellhoundlib/b/a:adn	()[Ljava/lang/Object;
        //   266: ldc 144
        //   268: ldc 146
        //   270: ldc 148
        //   272: ldc 150
        //   274: ldc 152
        //   276: ldc 154
        //   278: invokestatic 159	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   281: aload_3
        //   282: aload 4
        //   284: iconst_0
        //   285: invokevirtual 163	com/tencent/mm/hellhoundlib/b/a:lS	(I)Ljava/lang/Object;
        //   288: checkcast 87	android/content/Intent
        //   291: invokevirtual 167	android/content/Context:startActivity	(Landroid/content/Intent;)V
        //   294: aload_3
        //   295: ldc 144
        //   297: ldc 146
        //   299: ldc 148
        //   301: ldc 150
        //   303: ldc 152
        //   305: ldc 154
        //   307: invokestatic 170	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   310: aload_0
        //   311: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   314: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   317: iconst_5
        //   318: iconst_5
        //   319: iconst_1
        //   320: bipush 6
        //   322: iload_1
        //   323: aconst_null
        //   324: invokestatic 175	com/tencent/mm/game/report/e:a	(Landroid/content/Context;IIIIILjava/lang/String;)V
        //   327: goto -203 -> 124
        //   330: aload 5
        //   332: aload_0
        //   333: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   336: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   339: ldc 177
        //   341: invokevirtual 117	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
        //   344: pop
        //   345: aload_0
        //   346: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   349: getfield 120	com/tencent/mm/g/a/nn$a:jumpType	I
        //   352: iconst_1
        //   353: if_icmpne +13 -> 366
        //   356: aload 5
        //   358: ldc 179
        //   360: ldc 179
        //   362: invokevirtual 126	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   365: pop
        //   366: aload 5
        //   368: ldc 128
        //   370: iconst_5
        //   371: invokevirtual 131	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   374: pop
        //   375: aload_0
        //   376: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   379: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   382: astore_3
        //   383: new 133	com/tencent/mm/hellhoundlib/b/a
        //   386: dup
        //   387: invokespecial 134	com/tencent/mm/hellhoundlib/b/a:<init>	()V
        //   390: aload 5
        //   392: invokevirtual 138	com/tencent/mm/hellhoundlib/b/a:bd	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
        //   395: astore 4
        //   397: aload_3
        //   398: aload 4
        //   400: invokevirtual 142	com/tencent/mm/hellhoundlib/b/a:adn	()[Ljava/lang/Object;
        //   403: ldc 144
        //   405: ldc 146
        //   407: ldc 148
        //   409: ldc 150
        //   411: ldc 152
        //   413: ldc 154
        //   415: invokestatic 159	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   418: aload_3
        //   419: aload 4
        //   421: iconst_0
        //   422: invokevirtual 163	com/tencent/mm/hellhoundlib/b/a:lS	(I)Ljava/lang/Object;
        //   425: checkcast 87	android/content/Intent
        //   428: invokevirtual 167	android/content/Context:startActivity	(Landroid/content/Intent;)V
        //   431: aload_3
        //   432: ldc 144
        //   434: ldc 146
        //   436: ldc 148
        //   438: ldc 150
        //   440: ldc 152
        //   442: ldc 154
        //   444: invokestatic 170	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   447: aload_0
        //   448: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   451: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   454: iconst_5
        //   455: iconst_5
        //   456: iconst_1
        //   457: bipush 6
        //   459: iload_1
        //   460: aconst_null
        //   461: invokestatic 175	com/tencent/mm/game/report/e:a	(Landroid/content/Context;IIIIILjava/lang/String;)V
        //   464: goto -340 -> 124
        //   467: aload 4
        //   469: invokestatic 183	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
        //   472: ifne -348 -> 124
        //   475: aload 5
        //   477: aload_0
        //   478: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   481: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   484: ldc 185
        //   486: invokevirtual 117	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
        //   489: pop
        //   490: aload 5
        //   492: ldc 187
        //   494: aload 4
        //   496: invokevirtual 126	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   499: pop
        //   500: aload_0
        //   501: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   504: getfield 120	com/tencent/mm/g/a/nn$a:jumpType	I
        //   507: iconst_1
        //   508: if_icmpne +13 -> 521
        //   511: aload 5
        //   513: ldc 179
        //   515: ldc 179
        //   517: invokevirtual 126	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   520: pop
        //   521: aload 5
        //   523: ldc 128
        //   525: iconst_5
        //   526: invokevirtual 131	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   529: pop
        //   530: aload_0
        //   531: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   534: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   537: astore_3
        //   538: new 133	com/tencent/mm/hellhoundlib/b/a
        //   541: dup
        //   542: invokespecial 134	com/tencent/mm/hellhoundlib/b/a:<init>	()V
        //   545: aload 5
        //   547: invokevirtual 138	com/tencent/mm/hellhoundlib/b/a:bd	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
        //   550: astore 4
        //   552: aload_3
        //   553: aload 4
        //   555: invokevirtual 142	com/tencent/mm/hellhoundlib/b/a:adn	()[Ljava/lang/Object;
        //   558: ldc 144
        //   560: ldc 146
        //   562: ldc 148
        //   564: ldc 150
        //   566: ldc 152
        //   568: ldc 154
        //   570: invokestatic 159	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   573: aload_3
        //   574: aload 4
        //   576: iconst_0
        //   577: invokevirtual 163	com/tencent/mm/hellhoundlib/b/a:lS	(I)Ljava/lang/Object;
        //   580: checkcast 87	android/content/Intent
        //   583: invokevirtual 167	android/content/Context:startActivity	(Landroid/content/Intent;)V
        //   586: aload_3
        //   587: ldc 144
        //   589: ldc 146
        //   591: ldc 148
        //   593: ldc 150
        //   595: ldc 152
        //   597: ldc 154
        //   599: invokestatic 170	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   602: aload_0
        //   603: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   606: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   609: iconst_5
        //   610: iconst_5
        //   611: iconst_1
        //   612: bipush 6
        //   614: iload_1
        //   615: aconst_null
        //   616: invokestatic 175	com/tencent/mm/game/report/e:a	(Landroid/content/Context;IIIIILjava/lang/String;)V
        //   619: goto -495 -> 124
        //   622: ldc 189
        //   624: invokestatic 195	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   627: checkcast 189	com/tencent/mm/game/report/a/b
        //   630: getstatic 201	com/tencent/mm/plugin/expt/a/b$a:pjn	Lcom/tencent/mm/plugin/expt/a/b$a;
        //   633: iconst_0
        //   634: invokeinterface 204 3 0
        //   639: iconst_1
        //   640: if_icmpne +134 -> 774
        //   643: iconst_1
        //   644: istore_2
        //   645: iload_2
        //   646: ifeq +133 -> 779
        //   649: aload 5
        //   651: aload_0
        //   652: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   655: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   658: ldc 206
        //   660: invokevirtual 117	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
        //   663: pop
        //   664: aload 5
        //   666: ldc 128
        //   668: iload_1
        //   669: invokevirtual 131	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   672: pop
        //   673: aload 5
        //   675: ldc 208
        //   677: aload_3
        //   678: invokevirtual 126	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   681: pop
        //   682: aload_0
        //   683: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   686: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   689: astore_3
        //   690: new 133	com/tencent/mm/hellhoundlib/b/a
        //   693: dup
        //   694: invokespecial 134	com/tencent/mm/hellhoundlib/b/a:<init>	()V
        //   697: aload 5
        //   699: invokevirtual 138	com/tencent/mm/hellhoundlib/b/a:bd	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
        //   702: astore 4
        //   704: aload_3
        //   705: aload 4
        //   707: invokevirtual 142	com/tencent/mm/hellhoundlib/b/a:adn	()[Ljava/lang/Object;
        //   710: ldc 144
        //   712: ldc 146
        //   714: ldc 148
        //   716: ldc 150
        //   718: ldc 152
        //   720: ldc 154
        //   722: invokestatic 159	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   725: aload_3
        //   726: aload 4
        //   728: iconst_0
        //   729: invokevirtual 163	com/tencent/mm/hellhoundlib/b/a:lS	(I)Ljava/lang/Object;
        //   732: checkcast 87	android/content/Intent
        //   735: invokevirtual 167	android/content/Context:startActivity	(Landroid/content/Intent;)V
        //   738: aload_3
        //   739: ldc 144
        //   741: ldc 146
        //   743: ldc 148
        //   745: ldc 150
        //   747: ldc 152
        //   749: ldc 154
        //   751: invokestatic 170	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   754: aload_0
        //   755: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   758: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   761: iconst_5
        //   762: iconst_5
        //   763: iconst_1
        //   764: bipush 6
        //   766: iload_1
        //   767: aconst_null
        //   768: invokestatic 175	com/tencent/mm/game/report/e:a	(Landroid/content/Context;IIIIILjava/lang/String;)V
        //   771: goto -647 -> 124
        //   774: iconst_0
        //   775: istore_2
        //   776: goto -131 -> 645
        //   779: aload 5
        //   781: aload_0
        //   782: getfield 60	com/tencent/mm/g/a/nn:dsG	Lcom/tencent/mm/g/a/nn$a;
        //   785: getfield 111	com/tencent/mm/g/a/nn$a:context	Landroid/content/Context;
        //   788: ldc 210
        //   790: invokevirtual 117	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
        //   793: pop
        //   794: goto -130 -> 664
        //   797: astore 4
        //   799: aload_3
        //   800: astore 5
        //   802: goto -638 -> 164
        //   805: astore 5
        //   807: aload_3
        //   808: astore 4
        //   810: goto -675 -> 135
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	813	0	paramAnonymousnn	nn
        //   61	706	1	i	int
        //   644	132	2	j	int
        //   7	801	3	localObject1	Object
        //   9	64	4	localObject2	Object
        //   160	15	4	localException1	Exception
        //   188	539	4	localObject3	Object
        //   797	1	4	localException2	Exception
        //   808	1	4	localObject4	Object
        //   12	73	5	localObject5	Object
        //   131	649	5	localJSONException1	JSONException
        //   800	1	5	localObject6	Object
        //   805	1	5	localJSONException2	JSONException
        //   28	35	6	localJSONObject	JSONObject
        // Exception table:
        //   from	to	target	type
        //   14	30	131	org/json/JSONException
        //   36	44	131	org/json/JSONException
        //   50	62	131	org/json/JSONException
        //   14	30	160	java/lang/Exception
        //   36	44	160	java/lang/Exception
        //   50	62	160	java/lang/Exception
        //   62	71	797	java/lang/Exception
        //   62	71	805	org/json/JSONException
      }
    };
    this.rNc = new com.tencent.mm.sdk.b.c() {};
    this.rNd = new c.17(this);
    this.rNe = new com.tencent.mm.sdk.b.c() {};
    this.rNf = new com.tencent.mm.pluginsdk.c.d()
    {
      public final com.tencent.mm.sdk.b.b abU(String paramAnonymousString)
      {
        AppMethodBeat.i(40825);
        ht localht = new ht();
        localht.dlv.dcx = paramAnonymousString;
        AppMethodBeat.o(40825);
        return localht;
      }
      
      public final k cBa()
      {
        AppMethodBeat.i(40826);
        s locals = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd();
        AppMethodBeat.o(40826);
        return locals;
      }
    };
    this.fop = new c.3(this);
    this.rNg = new com.tencent.mm.sdk.b.c() {};
    this.rNh = new com.tencent.mm.sdk.b.c() {};
    this.rNi = new com.tencent.mm.sdk.b.c() {};
    this.rNj = new com.tencent.mm.sdk.b.c() {};
    this.pIJ = new com.tencent.mm.sdk.b.c() {};
    this.rNk = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(40840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c
 * JD-Core Version:    0.7.0.1
 */
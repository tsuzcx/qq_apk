package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.c;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.ach;
import com.tencent.mm.f.a.ji;
import com.tencent.mm.f.a.jj;
import com.tencent.mm.f.a.jk;
import com.tencent.mm.f.a.jl;
import com.tencent.mm.f.a.jm;
import com.tencent.mm.f.a.jn;
import com.tencent.mm.f.a.jo;
import com.tencent.mm.f.a.jp;
import com.tencent.mm.f.a.js;
import com.tencent.mm.f.a.kh;
import com.tencent.mm.f.a.mz;
import com.tencent.mm.f.a.pu;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.f.a.rc;
import com.tencent.mm.f.a.rd;
import com.tencent.mm.f.a.sx;
import com.tencent.mm.f.a.vx;
import com.tencent.mm.f.a.yp;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.game.d.a.a;
import com.tencent.mm.plugin.game.d.a.b;
import com.tencent.mm.plugin.game.model.av;
import com.tencent.mm.plugin.game.model.g.1;
import com.tencent.mm.plugin.game.model.g.2;
import com.tencent.mm.plugin.game.model.g.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.g;
import com.tencent.mm.plugin.game.model.o.m;
import com.tencent.mm.plugin.game.model.o.n;
import com.tencent.mm.plugin.game.model.o.o;
import com.tencent.mm.plugin.game.model.o.p;
import com.tencent.mm.plugin.game.model.o.q;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.protocal.protobuf.db;
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
  av CfO;
  com.tencent.mm.plugin.game.media.background.b CfP;
  IListener CfQ;
  IListener CfR;
  IListener CfS;
  IListener CfT;
  IListener CfU;
  IListener CfV;
  IListener CfW;
  IListener CfX;
  IListener CfY;
  com.tencent.mm.pluginsdk.d.d CfZ;
  com.tencent.mm.pluginsdk.d.d Cga;
  IListener Cgb;
  IListener Cgc;
  IListener Cgd;
  IListener Cge;
  IListener Cgf;
  IListener Cgg;
  IListener iVt;
  ck.a vgX;
  IListener wqp;
  
  static
  {
    AppMethodBeat.i(207055);
    appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(191026);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          if (!com.tencent.mm.kernel.b.aGE())
          {
            Log.i("MicroMsg.GameEventListener", "appForegroundListener, onAppBackground(%s)", new Object[] { paramAnonymousString });
            if ((a.a.ezW().DdD.DdG > 0L) && (a.a.ezW().DdD.DdG < System.currentTimeMillis()))
            {
              long l = System.currentTimeMillis() - a.a.ezW().DdD.DdG;
              paramAnonymousString = a.a.ezW().DdD;
              paramAnonymousString.wmw += l;
              Log.d("MicroMsg.GameEventListener", "spanTime:%d, stayTime:%d", new Object[] { Long.valueOf(l), Long.valueOf(a.a.ezW().DdD.wmw) });
            }
          }
        }
        AppMethodBeat.o(191026);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(191019);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          if (!com.tencent.mm.kernel.b.aGE())
          {
            Log.i("MicroMsg.GameEventListener", "appForegroundListener, onAppForeground(%s)", new Object[] { paramAnonymousString });
            if (a.a.ezW().DdD.startTimeMs > 0L) {
              a.a.ezW().DdD.DdG = System.currentTimeMillis();
            }
            paramAnonymousString = Long.valueOf(Util.nullAsNil((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vrg, Long.valueOf(0L))));
            if ((paramAnonymousString.longValue() != 0L) && (Util.nowSecond() > paramAnonymousString.longValue())) {
              com.tencent.mm.plugin.game.commlib.b.ewm().T(true, 1);
            }
            int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vrm, Integer.valueOf(0))).intValue();
            if (1920 != i)
            {
              Log.i("MicroMsg.GameEventListener", "checkVersionChange lastVersion:%d, currentVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(1920) });
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrm, Integer.valueOf(1920));
              paramAnonymousString = new jj();
              paramAnonymousString.fGE.Vh = 5;
              paramAnonymousString.fGE.param = "5";
              EventCenter.instance.publish(paramAnonymousString);
            }
          }
        }
        AppMethodBeat.o(191019);
      }
    };
    AppMethodBeat.o(207055);
  }
  
  public c()
  {
    AppMethodBeat.i(40840);
    this.CfO = new av();
    this.CfP = new com.tencent.mm.plugin.game.media.background.b();
    this.vgX = new ck.a()
    {
      public final void a(com.tencent.mm.an.h.a paramAnonymousa)
      {
        AppMethodBeat.i(40823);
        Object localObject3 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.e.class)).evn();
        Object localObject1 = paramAnonymousa.jQG;
        paramAnonymousa = z.a(((db)localObject1).RIF);
        Log.i("MicroMsg.GameMessageService", "Received a message: %d", new Object[] { Long.valueOf(((db)localObject1).HlH) });
        Log.i("MicroMsg.GameMessageService", "Message content: %s".concat(String.valueOf(paramAnonymousa)));
        int i;
        if (Util.isNullOrNil(paramAnonymousa))
        {
          Log.e("MicroMsg.GameMessageParser", "msg content is null");
          paramAnonymousa = null;
          if (paramAnonymousa != null)
          {
            Log.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s, gameMsgId:%s, reportMode:%d, reportSample:%d", new Object[] { Integer.valueOf(paramAnonymousa.field_msgType), paramAnonymousa.field_appId, Long.valueOf(paramAnonymousa.field_msgId), paramAnonymousa.field_gameMsgId, Integer.valueOf(paramAnonymousa.CJQ.CKR), Integer.valueOf(paramAnonymousa.CJQ.CKS) });
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
            Log.i("MicroMsg.GameMessageService", "Insert raw message: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().insert(paramAnonymousa)) });
            if (paramAnonymousa.field_needReport) {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 1L, 1L, false);
            }
          }
          Log.i("MicroMsg.GameMessageService", "process status:%d", new Object[] { Integer.valueOf(i) });
          Object localObject4;
          for (;;)
          {
            if (Util.isNullOrNil(paramAnonymousa.field_gameMsgId)) {
              paramAnonymousa.field_gameMsgId = paramAnonymousa.CJQ.lwD;
            }
            if (paramAnonymousa.field_needReport)
            {
              com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 0, 0, 0, 18, i, paramAnonymousa.field_appId, 0, paramAnonymousa.CJW, paramAnonymousa.field_gameMsgId, paramAnonymousa.CJX, com.tencent.mm.game.report.g.a("resource", String.valueOf(paramAnonymousa.CJh.CKl), paramAnonymousa.CJY, null));
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 0L, 1L, false);
            }
            AppMethodBeat.o(40823);
            return;
            localObject4 = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
            if ((localObject4 == null) || (((Map)localObject4).size() == 0))
            {
              Log.e("MicroMsg.GameMessageParser", "Parse failed");
              paramAnonymousa = null;
              break;
            }
            if (!"gamecenter".equalsIgnoreCase((String)((Map)localObject4).get(".sysmsg.$type")))
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
            ((o)localObject1).field_msgType = Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.$newmsgtype"), 0);
            if ((((o)localObject1).field_msgType == 100) || (((o)localObject1).field_msgType == 30))
            {
              u.eyK();
              ((o)localObject1).field_gameMsgId = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.msg_id"), "");
              ((o)localObject1).field_appId = ((String)((Map)localObject4).get(".sysmsg.gamecenter.appid"));
              ((o)localObject1).field_createTime = Util.getLong((String)((Map)localObject4).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L);
              l1 = Util.getLong((String)((Map)localObject4).get(".sysmsg.gamecenter.time_info.expire_time"), 0L);
              if (l1 == 0L)
              {
                ((o)localObject1).field_expireTime = 9223372036854775807L;
                label637:
                ((o)localObject1).CIV = Util.getLong((String)((Map)localObject4).get(".sysmsg.gamecenter.time_info.random_time"), 0L);
                if (Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
                  break label1305;
                }
                bool1 = true;
                label682:
                ((o)localObject1).field_isHidden = bool1;
                ((o)localObject1).field_mergerId = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.merge_id"), "");
                ((o)localObject1).field_weight = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.weight"), "");
                ((o)localObject1).field_receiveTime = (System.currentTimeMillis() / 1000L);
                u.s((Map)localObject4, (o)localObject1);
                ((o)localObject1).CJv = Util.getLong((String)((Map)localObject4).get(".sysmsg.gamecenter.filter_flag"), 0L);
                ((o)localObject1).CJw = Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                if (Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) <= 0) {
                  break label1311;
                }
                bool1 = true;
                label823:
                ((o)localObject1).CJg = bool1;
                ((o)localObject1).CJh.CKj = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                if ((Util.isNullOrNil((String)((Map)localObject4).get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"))) && (Util.isNullOrNil((String)((Map)localObject4).get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc")))) {
                  break label1317;
                }
                ((o)localObject1).CJi = true;
                label901:
                u.u((Map)localObject4, (o)localObject1);
                ((o)localObject1).CJN.CKw = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                ((o)localObject1).CJN.ttm = Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                if (!Util.isNullOrNil(((o)localObject1).CJN.CKw)) {
                  ((o)localObject1).field_isHidden = true;
                }
                ((o)localObject1).CJN.CKx = Util.getLong((String)((Map)localObject4).get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
                u.w((Map)localObject4, (o)localObject1);
                u.x((Map)localObject4, (o)localObject1);
                u.k((Map)localObject4, (o)localObject1);
                u.y((Map)localObject4, (o)localObject1);
                u.z((Map)localObject4, (o)localObject1);
                u.A((Map)localObject4, (o)localObject1);
                u.B((Map)localObject4, (o)localObject1);
                ((o)localObject1).field_showType = ((o)localObject1).CJR.CKC;
                if (((o)localObject1).field_showType == 0) {
                  break label1840;
                }
                if (((o)localObject1).CJR.CKD == 1) {
                  ((o)localObject1).field_showInMsgList = false;
                }
                label1093:
                ((o)localObject1).field_interactiveMergeId = ((o)localObject1).CJR.CKK;
                ((o)localObject1).field_redDotExpireTime = ((o)localObject1).CJT.CKA;
                q.a((Map)localObject4, (o)localObject1);
                ((o)localObject1).CJP.CKT = Util.getInt((String)((Map)localObject4).get(".sysmsg.support_version.$android"), 0);
                Log.i("MicroMsg.GameMessageParser", "xml support version: %d, current client version: %d", new Object[] { Integer.valueOf(((o)localObject1).CJP.CKT), Integer.valueOf(com.tencent.mm.protocal.d.RAD) });
                if ((((o)localObject1).CJP.CKT != 0) && (((o)localObject1).CJP.CKT > com.tencent.mm.protocal.d.RAD)) {
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
                com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 0, 0, 0, 401, 0, ((o)localObject1).field_appId, 0, 0, ((o)localObject1).field_gameMsgId, ((o)localObject1).CJX, "");
              }
              paramAnonymousa = null;
              break;
              ((o)localObject1).field_expireTime = (Util.getLong((String)((Map)localObject4).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L) + l1);
              break label637;
              bool1 = false;
              break label682;
              bool1 = false;
              break label823;
              ((o)localObject1).CJi = false;
              break label901;
              ((o)localObject1).field_gameMsgId = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.msg_id"), "");
              ((o)localObject1).field_msgType = Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.$newmsgtype"), 0);
              if (((o)localObject1).field_msgType == 0) {
                ((o)localObject1).field_msgType = Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.$msgtype"), 0);
              }
              ((o)localObject1).field_appId = ((String)((Map)localObject4).get(".sysmsg.gamecenter.appinfo.appid"));
              if (!Util.isNullOrNil(q.ae((Map)localObject4)))
              {
                bool1 = true;
                ((o)localObject1).field_showInMsgList = bool1;
                ((o)localObject1).field_createTime = Util.getLong((String)((Map)localObject4).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L);
                l1 = Util.getLong((String)((Map)localObject4).get(".sysmsg.game_control_info.expiredtime"), 0L);
                if (l1 != 0L) {
                  break label1777;
                }
                ((o)localObject1).field_expireTime = 9223372036854775807L;
                label1503:
                if (Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
                  break label1811;
                }
                bool1 = true;
                label1526:
                ((o)localObject1).field_isHidden = bool1;
                ((o)localObject1).field_mergerId = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.merge_id"), "");
                if (((o)localObject1).field_msgType != 10) {
                  break label1817;
                }
                ((o)localObject1).field_weight = "6";
                ((o)localObject1).field_receiveTime = (System.currentTimeMillis() / 1000L);
                ((o)localObject1).CJv = Util.getLong((String)((Map)localObject4).get(".sysmsg.game_control_info.filter_flag"), 0L);
                ((o)localObject1).CJu = q.af((Map)localObject4);
                ((o)localObject1).CJw = Util.getInt((String)((Map)localObject4).get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                if (Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) <= 0) {
                  break label1828;
                }
                bool1 = true;
                ((o)localObject1).CJi = bool1;
                ((o)localObject1).CJX = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.noticeid"), "");
                ((o)localObject1).CJh.CKl = Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.badge_display_type"), 0);
                if (((o)localObject1).CJh.CKl <= 0) {
                  break label1834;
                }
              }
              for (bool1 = true;; bool1 = false)
              {
                ((o)localObject1).CJg = bool1;
                if ((((o)localObject1).CJu & 0x4) == 0L) {
                  ((o)localObject1).CJg = false;
                }
                q.m((Map)localObject4, (o)localObject1);
                break;
                bool1 = false;
                break label1434;
                label1777:
                ((o)localObject1).field_expireTime = (Util.getLong((String)((Map)localObject4).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L) + l1);
                break label1503;
                bool1 = false;
                break label1526;
                ((o)localObject1).field_weight = "2";
                break label1575;
                bool1 = false;
                break label1664;
              }
              if (((o)localObject1).CJw != 1) {
                break label1093;
              }
              ((o)localObject1).field_showInMsgList = false;
              break label1093;
            }
            label1434:
            label1828:
            label1863:
            if (com.tencent.mm.plugin.game.model.g.CIB == null) {
              com.tencent.mm.plugin.game.model.g.CIB = new com.tencent.mm.plugin.game.model.g();
            }
            label1664:
            label1811:
            label1817:
            bool1 = ((o)localObject1).field_needReport;
            paramAnonymousa = Util.nullAs((String)((Map)localObject4).get(".sysmsg.wepkg.$pkg_id"), "");
            i = Util.getInt((String)((Map)localObject4).get(".sysmsg.wepkg.download_trigger_type"), 0);
            int j = Util.getInt((String)((Map)localObject4).get(".sysmsg.wepkg.download_type"), 0);
            com.tencent.e.h.ZvG.bh(new g.1(paramAnonymousa, i, j, bool1));
            if (((Map)localObject4).get(".sysmsg.control_command") == null) {
              Log.i("MicroMsg.GameControlCmdParser", "dont exist control command");
            }
            label2083:
            long l2;
            label2577:
            label2638:
            for (;;)
            {
              paramAnonymousa = (com.tencent.mm.an.h.a)localObject1;
              break;
              label2128:
              g.a locala;
              if (((Map)localObject4).get(".sysmsg.control_command.global_setting") != null)
              {
                i = Util.getInt((String)((Map)localObject4).get(".sysmsg.control_command.global_setting.pull_trigger_type"), 0);
                l1 = Util.getLong((String)((Map)localObject4).get(".sysmsg.control_command.global_setting.expect_complete_seconds"), 0L);
                Log.i("MicroMsg.GameControlCmdParser", "pull_trigger_type:%d, expect_complete_seconds:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l1) });
                if (i != 0) {
                  break label2577;
                }
                if (l1 <= 0L)
                {
                  l1 = 0L;
                  l2 = Util.nowSecond();
                  com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrg, Long.valueOf(l2 + l1));
                  com.tencent.mm.plugin.game.commlib.e.b.getWorkerHandler().postDelayed(new g.2(), l1 * 1000L);
                }
              }
              else if (((Map)localObject4).get(".sysmsg.control_command.message_setting.hide_conf") != null)
              {
                locala = new g.a();
                locala.startTime = Util.getLong((String)((Map)localObject4).get(".sysmsg.control_command.message_setting.hide_conf.$start_time"), 0L);
                locala.endTime = Util.getLong((String)((Map)localObject4).get(".sysmsg.control_command.message_setting.hide_conf.$end_time"), 0L);
                locala.CIG = Util.getInt((String)((Map)localObject4).get(".sysmsg.control_command.message_setting.hide_conf.$msg_type"), -10);
                locala.CIH.addAll(com.tencent.mm.plugin.game.model.g.F(".sysmsg.control_command.message_setting.hide_conf", (Map)localObject4));
              }
              for (paramAnonymousa = Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vrh, ""));; paramAnonymousa = new JSONArray())
              {
                try
                {
                  if (Util.isNullOrNil(paramAnonymousa)) {
                    continue;
                  }
                  localObject2 = new JSONArray(paramAnonymousa);
                  paramAnonymousa = (com.tencent.mm.an.h.a)localObject2;
                  if (((JSONArray)localObject2).length() > 20)
                  {
                    ((JSONArray)localObject2).remove(0);
                    paramAnonymousa = (com.tencent.mm.an.h.a)localObject2;
                  }
                  paramAnonymousa.put(locala.toJson());
                  com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrh, paramAnonymousa.toString());
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
                if (((Map)localObject4).get(".sysmsg.control_command.message_setting.del_conf") != null)
                {
                  paramAnonymousa = new ArrayList();
                  paramAnonymousa.addAll(com.tencent.mm.plugin.game.model.g.F(".sysmsg.control_command.message_setting.del_conf", (Map)localObject4));
                  com.tencent.mm.plugin.game.model.g.h(paramAnonymousa, bool1);
                }
                com.tencent.mm.plugin.game.model.g.ad((Map)localObject4);
                if (((Map)localObject4).get(".sysmsg.control_command.auto_run_switch") == null) {
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
                com.tencent.mm.plugin.game.model.g.a("md5_check", (Map)localObject4, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("download_resume", (Map)localObject4, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("preload_commlib", (Map)localObject4, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("game_silent_download", (Map)localObject4, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("wepkg_download_retry", (Map)localObject4, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("wepkg_expired_clean", (Map)localObject4, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("game_cache_clean", (Map)localObject4, paramAnonymousa);
                com.tencent.mm.plugin.game.model.g.a("game_resource_check", (Map)localObject4, paramAnonymousa);
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
                  com.tencent.mm.plugin.game.commlib.b.ewm().T(true, 1);
                  break label2128;
                }
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrg, Long.valueOf(Util.nowSecond()));
                break label2128;
              }
            }
            Log.i("MicroMsg.GameMessageService", "control command message");
            continue;
            Log.i("MicroMsg.GameMessageService", "silent download message");
            localObject1 = com.tencent.mm.plugin.game.model.a.h.a.ezl();
            if ((paramAnonymousa == null) || (Util.isNullOrNil(paramAnonymousa.field_appId)))
            {
              Log.i("MicroMsg.GameSilentDownloader", "msg is null");
              com.tencent.mm.plugin.downloader.f.a.ab("appid_is_empty", 16L);
            }
            else
            {
              localObject2 = paramAnonymousa.field_appId;
              l1 = paramAnonymousa.field_expireTime;
              l2 = paramAnonymousa.CIV;
              localObject3 = new com.tencent.mm.plugin.game.model.a.d();
              ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_appId = ((String)localObject2);
              if (!((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evq().get((IAutoDBItem)localObject3, new String[0]))
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
                bool1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evq().insert((IAutoDBItem)localObject3);
                Log.i("MicroMsg.GameSilentDownloader", "insert GameSilentDownloadTask, appid:%s, expireTime:%d, randomTime:%d, ret:%b", new Object[] { ((com.tencent.mm.plugin.game.model.a.d)localObject3).field_appId, Long.valueOf(((com.tencent.mm.plugin.game.model.a.d)localObject3).field_expireTime), Long.valueOf(((com.tencent.mm.plugin.game.model.a.d)localObject3).field_randomTime), Boolean.valueOf(bool1) });
                ((com.tencent.mm.plugin.game.model.a.h)localObject1).sn(false);
              }
              else
              {
                Log.i("MicroMsg.GameSilentDownloader", "GameSilentDownloadTask exist! appid = %s", new Object[] { localObject2 });
                com.tencent.mm.plugin.downloader.f.a.ab((String)localObject2, 17L);
              }
            }
          }
          if (r.c(paramAnonymousa))
          {
            Log.i("MicroMsg.GameMessageService", "filter deleted message");
            i = 5;
            continue;
          }
          if (paramAnonymousa.CJt == 1)
          {
            Log.i("MicroMsg.GameMessageService", "only in ios");
            i = 6;
            continue;
          }
          localObject1 = paramAnonymousa.field_gameMsgId;
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject2 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evo();
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
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 4L, 1L, false);
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
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 5L, 1L, false);
            }
            localObject1 = paramAnonymousa.CJN.CKw;
            if (!Util.isNullOrNil((String)localObject1))
            {
              localObject2 = new ach();
              ((ach)localObject2).gcw.fvK = 6;
              ((ach)localObject2).gcw.gcx = ((String)localObject1);
              EventCenter.instance.publish((IEvent)localObject2);
            }
            i = 1;
            break;
          }
          label3271:
          l1 = paramAnonymousa.CJv;
          localObject1 = paramAnonymousa.field_appId;
          if (l1 == 1L)
          {
            if ((!Util.isNullOrNil((String)localObject1)) && (com.tencent.mm.pluginsdk.model.app.h.u(MMApplicationContext.getContext(), (String)localObject1))) {
              break label3419;
            }
            if (paramAnonymousa.field_needReport) {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 6L, 1L, false);
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
            if ((l1 == 2L) && ((Util.isNullOrNil((String)localObject1)) || (com.tencent.mm.pluginsdk.model.app.h.u(MMApplicationContext.getContext(), (String)localObject1))))
            {
              if (paramAnonymousa.field_needReport) {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 7L, 1L, false);
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
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 8L, 1L, false);
            }
            i = 0;
            continue;
          }
          localObject1 = r.eyu();
          boolean bool1 = r.k((o)localObject1);
          boolean bool2 = r.k(paramAnonymousa);
          Object localObject2 = r.eyu();
          if (localObject2 != null)
          {
            ((o)localObject2).eyt();
            localObject4 = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject4).put("oldNoticeId", ((o)localObject2).CJX);
            ((JSONObject)localObject4).put("oldMsgId", ((o)localObject2).field_gameMsgId);
            if (paramAnonymousa.field_weight.compareTo(((o)localObject2).field_weight) >= 0) {
              ((JSONObject)localObject4).put("coverType", 1);
            }
            for (;;)
            {
              if (paramAnonymousa.field_needReport) {
                com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 0, 0, 0, 31, 0, paramAnonymousa.field_appId, 0, paramAnonymousa.CJW, paramAnonymousa.field_gameMsgId, paramAnonymousa.CJX, com.tencent.mm.plugin.game.c.a.Md(((JSONObject)localObject4).toString()));
              }
              if (paramAnonymousa.field_weight.compareTo(((o)localObject2).field_weight) < 0) {
                break label3922;
              }
              if (paramAnonymousa.field_needReport) {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 10L, 1L, false);
              }
              localObject2 = ((o)localObject2).CJN.CKw;
              if (!Util.isNullOrNil((String)localObject2))
              {
                localObject4 = new ach();
                ((ach)localObject4).gcw.fvK = 6;
                ((ach)localObject4).gcw.gcx = ((String)localObject2);
                EventCenter.instance.publish((IEvent)localObject4);
              }
              i = 1;
              if (i == 0) {
                break label3948;
              }
              i = 1;
              if (i == 0) {
                break label3953;
              }
              if ((localObject1 == null) || (!bool2) || (bool1))
              {
                if (!bool2) {
                  r.d(paramAnonymousa);
                }
                ((r)localObject3).e(paramAnonymousa);
                ((r)localObject3).f(paramAnonymousa);
                ((r)localObject3).g(paramAnonymousa);
              }
              if ((bool2) && (paramAnonymousa.field_needReport)) {
                com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 0, 0, 0, 404, 0, paramAnonymousa.field_appId, 0, paramAnonymousa.CJW, paramAnonymousa.field_gameMsgId, paramAnonymousa.CJX, com.tencent.mm.game.report.g.a("resource", String.valueOf(paramAnonymousa.CJh.CKl), paramAnonymousa.CJY, null));
              }
              if (paramAnonymousa.field_msgType == 4) {
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VjO, Long.valueOf(paramAnonymousa.field_msgId));
              }
              if ((paramAnonymousa != null) && (!Util.isNullOrNil(paramAnonymousa.CJh.CKj)))
              {
                if (!paramAnonymousa.CJh.CKm) {
                  break label3988;
                }
                com.tencent.mm.plugin.game.d.c.h(paramAnonymousa.CJh.CKj, 0.08333334F);
              }
              i = 0;
              break;
              ((JSONObject)localObject4).put("coverType", 2);
            }
          }
          catch (Exception localException)
          {
            label3988:
            for (;;)
            {
              Log.e("MicroMsg.GameMessageService", "reportMsgCover: " + localException.getMessage());
              continue;
              label3922:
              if (paramAnonymousa.field_needReport) {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 11L, 1L, false);
              }
              i = 0;
              continue;
              label3948:
              i = 0;
              continue;
              label3953:
              if ((bool1) && (!bool2))
              {
                r.d(paramAnonymousa);
                ((r)localObject3).e(paramAnonymousa);
                ((r)localObject3).f(paramAnonymousa);
                ((r)localObject3).g(paramAnonymousa);
                continue;
                com.tencent.mm.plugin.game.d.c.h(paramAnonymousa.CJh.CKj, 0.0F);
              }
            }
          }
        }
      }
      
      public final void a(h.c paramAnonymousc)
      {
        AppMethodBeat.i(40824);
        if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.lCl)) || (Util.isNullOrNil(paramAnonymousc.lCm)))
        {
          AppMethodBeat.o(40824);
          return;
        }
        Log.i("MicroMsg.GameEventListener", "delete msgType:%s, msgId:%s", new Object[] { paramAnonymousc.lCl, paramAnonymousc.lCm });
        if (!"gamecenter".equalsIgnoreCase(paramAnonymousc.lCl))
        {
          AppMethodBeat.o(40824);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramAnonymousc.lCm);
        com.tencent.mm.plugin.game.model.g.h(localArrayList, false);
        AppMethodBeat.o(40824);
      }
    };
    this.CfQ = new IListener() {};
    this.CfR = new IListener() {};
    this.CfS = new IListener() {};
    this.CfT = new IListener() {};
    this.CfU = new IListener() {};
    this.CfV = new IListener() {};
    this.CfW = new IListener() {};
    this.CfX = new c.21(this);
    this.CfY = new IListener() {};
    this.CfZ = new com.tencent.mm.pluginsdk.d.d()
    {
      public final IEvent aIL(String paramAnonymousString)
      {
        AppMethodBeat.i(201586);
        jo localjo = new jo();
        localjo.fGO.event = paramAnonymousString;
        AppMethodBeat.o(201586);
        return localjo;
      }
      
      public final MStorage evj()
      {
        AppMethodBeat.i(201588);
        s locals = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evo();
        AppMethodBeat.o(201588);
        return locals;
      }
    };
    this.Cga = new com.tencent.mm.pluginsdk.d.d()
    {
      public final IEvent aIL(String paramAnonymousString)
      {
        AppMethodBeat.i(193730);
        jn localjn = new jn();
        localjn.fGN.event = paramAnonymousString;
        AppMethodBeat.o(193730);
        return localjn;
      }
      
      public final MStorage evj()
      {
        AppMethodBeat.i(193732);
        com.tencent.mm.plugin.gamelife.e.e locale = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).eAk();
        AppMethodBeat.o(193732);
        return locale;
      }
    };
    this.iVt = new IListener() {};
    this.Cgb = new IListener() {};
    this.Cgc = new IListener() {};
    this.Cgd = new IListener() {};
    this.Cge = new IListener() {};
    this.wqp = new IListener() {};
    this.Cgf = new IListener() {};
    this.Cgg = new IListener()
    {
      /* Error */
      private boolean evk()
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: ldc 48
        //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:ezW	()Lcom/tencent/mm/plugin/game/d/a;
        //   10: getfield 60	com/tencent/mm/plugin/game/d/a:DdD	Lcom/tencent/mm/plugin/game/d/a$b;
        //   13: astore 8
        //   15: aload 8
        //   17: getfield 66	com/tencent/mm/plugin/game/d/a$b:startTimeMs	J
        //   20: lconst_0
        //   21: lcmp
        //   22: ifle +211 -> 233
        //   25: aload 8
        //   27: getfield 69	com/tencent/mm/plugin/game/d/a$b:DdG	J
        //   30: lconst_0
        //   31: lcmp
        //   32: ifle +201 -> 233
        //   35: iconst_1
        //   36: istore_1
        //   37: iload_1
        //   38: ifeq +177 -> 215
        //   41: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:ezW	()Lcom/tencent/mm/plugin/game/d/a;
        //   44: getfield 60	com/tencent/mm/plugin/game/d/a:DdD	Lcom/tencent/mm/plugin/game/d/a$b;
        //   47: invokestatic 75	java/lang/System:currentTimeMillis	()J
        //   50: putfield 78	com/tencent/mm/plugin/game/d/a$b:endTimeMs	J
        //   53: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:ezW	()Lcom/tencent/mm/plugin/game/d/a;
        //   56: getfield 60	com/tencent/mm/plugin/game/d/a:DdD	Lcom/tencent/mm/plugin/game/d/a$b;
        //   59: astore 8
        //   61: aload 8
        //   63: aload 8
        //   65: getfield 81	com/tencent/mm/plugin/game/d/a$b:wmw	J
        //   68: invokestatic 75	java/lang/System:currentTimeMillis	()J
        //   71: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:ezW	()Lcom/tencent/mm/plugin/game/d/a;
        //   74: getfield 60	com/tencent/mm/plugin/game/d/a:DdD	Lcom/tencent/mm/plugin/game/d/a$b;
        //   77: getfield 69	com/tencent/mm/plugin/game/d/a$b:DdG	J
        //   80: lsub
        //   81: ladd
        //   82: putfield 81	com/tencent/mm/plugin/game/d/a$b:wmw	J
        //   85: ldc 83
        //   87: ldc 85
        //   89: iconst_3
        //   90: anewarray 87	java/lang/Object
        //   93: dup
        //   94: iconst_0
        //   95: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:ezW	()Lcom/tencent/mm/plugin/game/d/a;
        //   98: getfield 60	com/tencent/mm/plugin/game/d/a:DdD	Lcom/tencent/mm/plugin/game/d/a$b;
        //   101: getfield 66	com/tencent/mm/plugin/game/d/a$b:startTimeMs	J
        //   104: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   107: aastore
        //   108: dup
        //   109: iconst_1
        //   110: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:ezW	()Lcom/tencent/mm/plugin/game/d/a;
        //   113: getfield 60	com/tencent/mm/plugin/game/d/a:DdD	Lcom/tencent/mm/plugin/game/d/a$b;
        //   116: getfield 78	com/tencent/mm/plugin/game/d/a$b:endTimeMs	J
        //   119: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   122: aastore
        //   123: dup
        //   124: iconst_2
        //   125: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:ezW	()Lcom/tencent/mm/plugin/game/d/a;
        //   128: getfield 60	com/tencent/mm/plugin/game/d/a:DdD	Lcom/tencent/mm/plugin/game/d/a$b;
        //   131: getfield 81	com/tencent/mm/plugin/game/d/a$b:wmw	J
        //   134: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   137: aastore
        //   138: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   141: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:ezW	()Lcom/tencent/mm/plugin/game/d/a;
        //   144: getfield 60	com/tencent/mm/plugin/game/d/a:DdD	Lcom/tencent/mm/plugin/game/d/a$b;
        //   147: getfield 66	com/tencent/mm/plugin/game/d/a$b:startTimeMs	J
        //   150: ldc2_w 99
        //   153: ldiv
        //   154: lstore_2
        //   155: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:ezW	()Lcom/tencent/mm/plugin/game/d/a;
        //   158: getfield 60	com/tencent/mm/plugin/game/d/a:DdD	Lcom/tencent/mm/plugin/game/d/a$b;
        //   161: getfield 78	com/tencent/mm/plugin/game/d/a$b:endTimeMs	J
        //   164: ldc2_w 99
        //   167: ldiv
        //   168: lstore 4
        //   170: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:ezW	()Lcom/tencent/mm/plugin/game/d/a;
        //   173: getfield 60	com/tencent/mm/plugin/game/d/a:DdD	Lcom/tencent/mm/plugin/game/d/a$b;
        //   176: getfield 81	com/tencent/mm/plugin/game/d/a$b:wmw	J
        //   179: ldc2_w 99
        //   182: ldiv
        //   183: lstore 6
        //   185: invokestatic 106	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
        //   188: bipush 35
        //   190: iconst_0
        //   191: iconst_0
        //   192: bipush 91
        //   194: iconst_0
        //   195: ldc 108
        //   197: sipush 901
        //   200: iconst_0
        //   201: ldc 108
        //   203: ldc 108
        //   205: ldc 108
        //   207: lload_2
        //   208: lload 4
        //   210: lload 6
        //   212: invokestatic 114	com/tencent/mm/game/report/g:a	(Landroid/content/Context;IIIIILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)V
        //   215: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:ezW	()Lcom/tencent/mm/plugin/game/d/a;
        //   218: getfield 60	com/tencent/mm/plugin/game/d/a:DdD	Lcom/tencent/mm/plugin/game/d/a$b;
        //   221: invokevirtual 117	com/tencent/mm/plugin/game/d/a$b:ezX	()V
        //   224: ldc 48
        //   226: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   229: aload_0
        //   230: monitorexit
        //   231: iconst_0
        //   232: ireturn
        //   233: iconst_0
        //   234: istore_1
        //   235: goto -198 -> 37
        //   238: astore 8
        //   240: aload_0
        //   241: monitorexit
        //   242: aload 8
        //   244: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	245	0	this	13
        //   36	199	1	i	int
        //   154	54	2	l1	long
        //   168	41	4	l2	long
        //   183	28	6	l3	long
        //   13	51	8	localb	a.b
        //   238	5	8	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	35	238	finally
        //   41	215	238	finally
        //   215	229	238	finally
      }
    };
    AppMethodBeat.o(40840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c
 * JD-Core Version:    0.7.0.1
 */
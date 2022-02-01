package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.c;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.aee;
import com.tencent.mm.autogen.a.kk;
import com.tencent.mm.autogen.a.ko;
import com.tencent.mm.autogen.a.kp;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.game.d.a.a;
import com.tencent.mm.plugin.game.d.a.b;
import com.tencent.mm.plugin.game.model.NotifyGameWebviewOperationListener;
import com.tencent.mm.plugin.game.model.g.1;
import com.tencent.mm.plugin.game.model.g.2;
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
import com.tencent.mm.plugin.game.model.silent_download.h.a;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private static MTimerHandler HSp;
  static q.a appForegroundListener;
  NotifyGameWebviewOperationListener HRV;
  com.tencent.mm.plugin.game.media.background.b HRW;
  IListener HRX;
  IListener HRY;
  IListener HRZ;
  IListener HSa;
  IListener HSb;
  IListener HSc;
  IListener HSd;
  IListener HSe;
  IListener HSf;
  com.tencent.mm.pluginsdk.event.a HSg;
  com.tencent.mm.pluginsdk.event.a HSh;
  IListener HSi;
  IListener HSj;
  IListener HSk;
  IListener HSl;
  IListener HSm;
  IListener HSn;
  IListener HSo;
  IListener lxy;
  cl.a ysZ;
  IListener zMr;
  
  static
  {
    AppMethodBeat.i(275294);
    HSp = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(275295);
        com.tencent.mm.plugin.game.chatroom.j.a locala = com.tencent.mm.plugin.game.chatroom.j.a.Imu;
        com.tencent.mm.plugin.game.chatroom.j.a.dyq();
        AppMethodBeat.o(275295);
        return true;
      }
    }, false);
    appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(275305);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG())
          {
            Log.i("MicroMsg.GameEventListener", "appForegroundListener, onAppBackground(%s)", new Object[] { paramAnonymousString });
            if ((a.a.fHX().IXU.IXX > 0L) && (a.a.fHX().IXU.IXX < System.currentTimeMillis()))
            {
              long l = System.currentTimeMillis() - a.a.fHX().IXU.IXX;
              paramAnonymousString = a.a.fHX().IXU;
              paramAnonymousString.zIy += l;
              Log.d("MicroMsg.GameEventListener", "spanTime:%d, stayTime:%d", new Object[] { Long.valueOf(l), Long.valueOf(a.a.fHX().IXU.zIy) });
            }
            c.fCb().startTimer(600000L, 0L);
          }
        }
        AppMethodBeat.o(275305);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(275303);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG())
          {
            Log.i("MicroMsg.GameEventListener", "appForegroundListener, onAppForeground(%s)", new Object[] { paramAnonymousString });
            if (a.a.fHX().IXU.startTimeMs > 0L) {
              a.a.fHX().IXU.IXX = System.currentTimeMillis();
            }
            paramAnonymousString = Long.valueOf(Util.nullAsNil((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSI, Long.valueOf(0L))));
            if ((paramAnonymousString.longValue() != 0L) && (Util.nowSecond() > paramAnonymousString.longValue())) {
              com.tencent.mm.plugin.game.commlib.b.fEb().V(true, 1);
            }
            int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSO, Integer.valueOf(0))).intValue();
            if (2080 != i)
            {
              Log.i("MicroMsg.GameEventListener", "checkVersionChange lastVersion:%d, currentVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(2080) });
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acSO, Integer.valueOf(2080));
              paramAnonymousString = new kk();
              paramAnonymousString.hMa.bUl = 5;
              paramAnonymousString.hMa.param = "5";
              paramAnonymousString.publish();
            }
            c.fCb().stopTimer();
            paramAnonymousString = com.tencent.mm.plugin.game.chatroom.j.a.Imu;
            com.tencent.mm.plugin.game.chatroom.j.a.fCV();
          }
        }
        AppMethodBeat.o(275303);
      }
    };
    AppMethodBeat.o(275294);
  }
  
  public c()
  {
    AppMethodBeat.i(40840);
    this.HRV = new NotifyGameWebviewOperationListener();
    this.HRW = new com.tencent.mm.plugin.game.media.background.b();
    this.ysZ = new cl.a()
    {
      public final void a(com.tencent.mm.am.g.a paramAnonymousa)
      {
        AppMethodBeat.i(40823);
        Object localObject3 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCg();
        Object localObject1 = paramAnonymousa.mpN;
        paramAnonymousa = w.a(((dl)localObject1).YFG);
        Log.i("MicroMsg.GameMessageService", "Received a message: %d", new Object[] { Long.valueOf(((dl)localObject1).Njv) });
        Log.i("MicroMsg.GameMessageService", "Message content: %s".concat(String.valueOf(paramAnonymousa)));
        int i;
        if (Util.isNullOrNil(paramAnonymousa))
        {
          Log.e("MicroMsg.GameMessageParser", "msg content is null");
          paramAnonymousa = null;
          if (paramAnonymousa != null)
          {
            Log.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s, gameMsgId:%s, reportMode:%d, reportSample:%d", new Object[] { Integer.valueOf(paramAnonymousa.field_msgType), paramAnonymousa.field_appId, Long.valueOf(paramAnonymousa.field_msgId), paramAnonymousa.field_gameMsgId, Integer.valueOf(paramAnonymousa.IEb.IEZ), Integer.valueOf(paramAnonymousa.IEb.IFa) });
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
            Log.i("MicroMsg.GameMessageService", "Insert raw message: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().insert(paramAnonymousa)) });
            if (paramAnonymousa.field_needReport) {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 1L, 1L, false);
            }
          }
          Log.i("MicroMsg.GameMessageService", "process status:%d", new Object[] { Integer.valueOf(i) });
          Object localObject4;
          for (;;)
          {
            if (Util.isNullOrNil(paramAnonymousa.field_gameMsgId)) {
              paramAnonymousa.field_gameMsgId = paramAnonymousa.IEb.ooc;
            }
            if (paramAnonymousa.field_needReport)
            {
              com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 0, 0, 0, 18, i, paramAnonymousa.field_appId, 0, paramAnonymousa.IEh, paramAnonymousa.field_gameMsgId, paramAnonymousa.mNoticeId, com.tencent.mm.game.report.g.a("resource", String.valueOf(paramAnonymousa.IDs.IEw), paramAnonymousa.IEi, null));
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 0L, 1L, false);
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
              u.fGG();
              ((o)localObject1).field_gameMsgId = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.msg_id"), "");
              ((o)localObject1).field_appId = ((String)((Map)localObject4).get(".sysmsg.gamecenter.appid"));
              ((o)localObject1).field_createTime = Util.getLong((String)((Map)localObject4).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L);
              l1 = Util.getLong((String)((Map)localObject4).get(".sysmsg.gamecenter.time_info.expire_time"), 0L);
              if (l1 == 0L)
              {
                ((o)localObject1).field_expireTime = 9223372036854775807L;
                label637:
                ((o)localObject1).IDg = Util.getLong((String)((Map)localObject4).get(".sysmsg.gamecenter.time_info.random_time"), 0L);
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
                ((o)localObject1).IDG = Util.getLong((String)((Map)localObject4).get(".sysmsg.gamecenter.filter_flag"), 0L);
                ((o)localObject1).IDH = Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                if (Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) <= 0) {
                  break label1311;
                }
                bool1 = true;
                label823:
                ((o)localObject1).IDr = bool1;
                ((o)localObject1).IDs.IEu = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                if ((Util.isNullOrNil((String)((Map)localObject4).get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"))) && (Util.isNullOrNil((String)((Map)localObject4).get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc")))) {
                  break label1317;
                }
                ((o)localObject1).IDt = true;
                label901:
                u.u((Map)localObject4, (o)localObject1);
                ((o)localObject1).IDY.IEG = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                ((o)localObject1).IDY.wxJ = Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                if (!Util.isNullOrNil(((o)localObject1).IDY.IEG)) {
                  ((o)localObject1).field_isHidden = true;
                }
                ((o)localObject1).IDY.IEH = Util.getLong((String)((Map)localObject4).get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
                u.w((Map)localObject4, (o)localObject1);
                u.x((Map)localObject4, (o)localObject1);
                u.k((Map)localObject4, (o)localObject1);
                u.y((Map)localObject4, (o)localObject1);
                u.z((Map)localObject4, (o)localObject1);
                u.A((Map)localObject4, (o)localObject1);
                u.B((Map)localObject4, (o)localObject1);
                ((o)localObject1).field_showType = ((o)localObject1).IEc.show_type;
                if (((o)localObject1).field_showType == 0) {
                  break label1840;
                }
                if (((o)localObject1).IEc.IEL == 1) {
                  ((o)localObject1).field_showInMsgList = false;
                }
                label1093:
                ((o)localObject1).field_interactiveMergeId = ((o)localObject1).IEc.IES;
                ((o)localObject1).field_redDotExpireTime = ((o)localObject1).IEe.IEK;
                q.a((Map)localObject4, (o)localObject1);
                ((o)localObject1).IEa.IFb = Util.getInt((String)((Map)localObject4).get(".sysmsg.support_version.$android"), 0);
                Log.i("MicroMsg.GameMessageParser", "xml support version: %d, current client version: %d", new Object[] { Integer.valueOf(((o)localObject1).IEa.IFb), Integer.valueOf(com.tencent.mm.protocal.d.Yxh) });
                if ((((o)localObject1).IEa.IFb != 0) && (((o)localObject1).IEa.IFb > com.tencent.mm.protocal.d.Yxh)) {
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
                com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 0, 0, 0, 401, 0, ((o)localObject1).field_appId, 0, 0, ((o)localObject1).field_gameMsgId, ((o)localObject1).mNoticeId, "");
              }
              paramAnonymousa = null;
              break;
              ((o)localObject1).field_expireTime = (Util.getLong((String)((Map)localObject4).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L) + l1);
              break label637;
              bool1 = false;
              break label682;
              bool1 = false;
              break label823;
              ((o)localObject1).IDt = false;
              break label901;
              ((o)localObject1).field_gameMsgId = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.msg_id"), "");
              ((o)localObject1).field_msgType = Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.$newmsgtype"), 0);
              if (((o)localObject1).field_msgType == 0) {
                ((o)localObject1).field_msgType = Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.$msgtype"), 0);
              }
              ((o)localObject1).field_appId = ((String)((Map)localObject4).get(".sysmsg.gamecenter.appinfo.appid"));
              if (!Util.isNullOrNil(q.as((Map)localObject4)))
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
                ((o)localObject1).IDG = Util.getLong((String)((Map)localObject4).get(".sysmsg.game_control_info.filter_flag"), 0L);
                ((o)localObject1).IDF = q.at((Map)localObject4);
                ((o)localObject1).IDH = Util.getInt((String)((Map)localObject4).get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                if (Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) <= 0) {
                  break label1828;
                }
                bool1 = true;
                ((o)localObject1).IDt = bool1;
                ((o)localObject1).mNoticeId = Util.nullAs((String)((Map)localObject4).get(".sysmsg.gamecenter.noticeid"), "");
                ((o)localObject1).IDs.IEw = Util.getInt((String)((Map)localObject4).get(".sysmsg.gamecenter.badge_display_type"), 0);
                if (((o)localObject1).IDs.IEw <= 0) {
                  break label1834;
                }
              }
              for (bool1 = true;; bool1 = false)
              {
                ((o)localObject1).IDr = bool1;
                if ((((o)localObject1).IDF & 0x4) == 0L) {
                  ((o)localObject1).IDr = false;
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
              if (((o)localObject1).IDH != 1) {
                break label1093;
              }
              ((o)localObject1).field_showInMsgList = false;
              break label1093;
            }
            label1434:
            label1828:
            label1863:
            if (com.tencent.mm.plugin.game.model.g.ICL == null) {
              com.tencent.mm.plugin.game.model.g.ICL = new com.tencent.mm.plugin.game.model.g();
            }
            label1664:
            label1811:
            label1817:
            bool1 = ((o)localObject1).field_needReport;
            paramAnonymousa = Util.nullAs((String)((Map)localObject4).get(".sysmsg.wepkg.$pkg_id"), "");
            i = Util.getInt((String)((Map)localObject4).get(".sysmsg.wepkg.download_trigger_type"), 0);
            int j = Util.getInt((String)((Map)localObject4).get(".sysmsg.wepkg.download_type"), 0);
            com.tencent.threadpool.h.ahAA.bp(new g.1(paramAnonymousa, i, j, bool1));
            if (((Map)localObject4).get(".sysmsg.control_command") == null)
            {
              Log.i("MicroMsg.GameControlCmdParser", "dont exist control command");
              paramAnonymousa = (com.tencent.mm.am.g.a)localObject1;
              break;
            }
            label2083:
            long l2;
            label2128:
            com.tencent.mm.plugin.game.model.g.a locala;
            if (((Map)localObject4).get(".sysmsg.control_command.global_setting") != null)
            {
              i = Util.getInt((String)((Map)localObject4).get(".sysmsg.control_command.global_setting.pull_trigger_type"), 0);
              l1 = Util.getLong((String)((Map)localObject4).get(".sysmsg.control_command.global_setting.expect_complete_seconds"), 0L);
              Log.i("MicroMsg.GameControlCmdParser", "pull_trigger_type:%d, expect_complete_seconds:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l1) });
              if (i != 0) {
                break label2614;
              }
              if (l1 <= 0L)
              {
                l1 = 0L;
                l2 = Util.nowSecond();
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acSI, Long.valueOf(l2 + l1));
                com.tencent.mm.plugin.game.commlib.e.b.getWorkerHandler().postDelayed(new g.2(), l1 * 1000L);
              }
            }
            else if (((Map)localObject4).get(".sysmsg.control_command.message_setting.hide_conf") != null)
            {
              locala = new com.tencent.mm.plugin.game.model.g.a();
              locala.startTime = Util.getLong((String)((Map)localObject4).get(".sysmsg.control_command.message_setting.hide_conf.$start_time"), 0L);
              locala.endTime = Util.getLong((String)((Map)localObject4).get(".sysmsg.control_command.message_setting.hide_conf.$end_time"), 0L);
              locala.ICR = Util.getInt((String)((Map)localObject4).get(".sysmsg.control_command.message_setting.hide_conf.$msg_type"), -10);
              locala.ICS.addAll(com.tencent.mm.plugin.game.model.g.N(".sysmsg.control_command.message_setting.hide_conf", (Map)localObject4));
            }
            for (paramAnonymousa = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSJ, ""));; paramAnonymousa = new JSONArray())
            {
              try
              {
                if (Util.isNullOrNil(paramAnonymousa)) {
                  continue;
                }
                localObject2 = new JSONArray(paramAnonymousa);
                paramAnonymousa = (com.tencent.mm.am.g.a)localObject2;
                if (((JSONArray)localObject2).length() > 20)
                {
                  ((JSONArray)localObject2).remove(0);
                  paramAnonymousa = (com.tencent.mm.am.g.a)localObject2;
                }
                paramAnonymousa.put(locala.toJson());
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acSJ, paramAnonymousa.toString());
                Log.i("MicroMsg.GameControlCmdParser", "hideConf list size:%d, content:%s", new Object[] { Integer.valueOf(paramAnonymousa.length()), paramAnonymousa.toString() });
              }
              catch (JSONException paramAnonymousa)
              {
                for (;;)
                {
                  label2614:
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
                paramAnonymousa.addAll(com.tencent.mm.plugin.game.model.g.N(".sysmsg.control_command.message_setting.del_conf", (Map)localObject4));
                com.tencent.mm.plugin.game.model.g.t(paramAnonymousa, bool1);
              }
              com.tencent.mm.plugin.game.model.g.ar((Map)localObject4);
              if (((Map)localObject4).get(".sysmsg.control_command.auto_run_switch") != null)
              {
                localObject2 = MultiProcessMMKV.getMMKV("game_mmkv");
                if (localObject2 != null)
                {
                  paramAnonymousa = ((MultiProcessMMKV)localObject2).decodeString("auto_run_switch", "");
                  if (!Util.isNullOrNil(paramAnonymousa)) {
                    break label2675;
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
                }
              }
              if ((((Map)localObject4).get(".sysmsg.control_command.cdn_setting") == null) || (((Map)localObject4).get(".sysmsg.control_command.cdn_setting.prefetch_url_list") == null)) {
                break;
              }
              com.tencent.mm.plugin.game.model.g.iq(com.tencent.mm.plugin.game.model.g.M(".sysmsg.control_command.cdn_setting.prefetch_url_list.prefetch_url", (Map)localObject4));
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
                com.tencent.mm.plugin.game.commlib.b.fEb().V(true, 1);
                break label2128;
              }
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acSI, Long.valueOf(Util.nowSecond()));
              break label2128;
            }
            label2675:
            Log.i("MicroMsg.GameMessageService", "control command message");
            continue;
            Log.i("MicroMsg.GameMessageService", "silent download message");
            localObject1 = h.a.fHh();
            if ((paramAnonymousa == null) || (Util.isNullOrNil(paramAnonymousa.field_appId)))
            {
              Log.i("MicroMsg.GameSilentDownloader", "msg is null");
              com.tencent.mm.plugin.downloader.e.a.af("appid_is_empty", 16L);
            }
            else
            {
              localObject2 = paramAnonymousa.field_appId;
              l1 = paramAnonymousa.field_expireTime;
              l2 = paramAnonymousa.IDg;
              localObject3 = new com.tencent.mm.plugin.game.model.silent_download.d();
              ((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_appId = ((String)localObject2);
              if (!((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().get((IAutoDBItem)localObject3, new String[0]))
              {
                ((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_expireTime = l1;
                ((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_randomTime = l2;
                ((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_isFirst = true;
                ((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_isRunning = false;
                ((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_noWifi = true;
                ((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_noSdcard = true;
                ((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_noEnoughSpace = true;
                ((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_lowBattery = true;
                ((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_continueDelay = true;
                ((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_forceUpdateFlag = 0;
                bool1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().insert((IAutoDBItem)localObject3);
                Log.i("MicroMsg.GameSilentDownloader", "insert GameSilentDownloadTask, appid:%s, expireTime:%d, randomTime:%d, ret:%b", new Object[] { ((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_appId, Long.valueOf(((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_expireTime), Long.valueOf(((com.tencent.mm.plugin.game.model.silent_download.d)localObject3).field_randomTime), Boolean.valueOf(bool1) });
                ((com.tencent.mm.plugin.game.model.silent_download.h)localObject1).wt(false);
              }
              else
              {
                Log.i("MicroMsg.GameSilentDownloader", "GameSilentDownloadTask exist! appid = %s", new Object[] { localObject2 });
                com.tencent.mm.plugin.downloader.e.a.af((String)localObject2, 17L);
              }
            }
          }
          if (r.c(paramAnonymousa))
          {
            Log.i("MicroMsg.GameMessageService", "filter deleted message");
            i = 5;
            continue;
          }
          if (paramAnonymousa.IDE == 1)
          {
            Log.i("MicroMsg.GameMessageService", "only in ios");
            i = 6;
            continue;
          }
          localObject1 = paramAnonymousa.field_gameMsgId;
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject2 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh();
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
              break label3178;
            }
            Log.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[] { paramAnonymousa.field_gameMsgId });
            if (paramAnonymousa.field_needReport) {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 4L, 1L, false);
            }
            i = 2;
            break;
          }
          label3178:
          long l1 = System.currentTimeMillis() / 1000L;
          if (paramAnonymousa.field_expireTime <= l1) {}
          for (i = 0;; i = 1)
          {
            if (i != 0) {
              break label3305;
            }
            Log.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[] { paramAnonymousa.field_gameMsgId });
            if (paramAnonymousa.field_needReport) {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 5L, 1L, false);
            }
            localObject1 = paramAnonymousa.IDY.IEG;
            if (!Util.isNullOrNil((String)localObject1))
            {
              localObject2 = new aee();
              ((aee)localObject2).iiI.hAf = 6;
              ((aee)localObject2).iiI.iiJ = ((String)localObject1);
              ((aee)localObject2).publish();
            }
            i = 1;
            break;
          }
          label3305:
          l1 = paramAnonymousa.IDG;
          localObject1 = paramAnonymousa.field_appId;
          if (l1 == 1L)
          {
            if ((!Util.isNullOrNil((String)localObject1)) && (com.tencent.mm.pluginsdk.model.app.h.y(MMApplicationContext.getContext(), (String)localObject1))) {
              break label3453;
            }
            if (paramAnonymousa.field_needReport) {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 6L, 1L, false);
            }
            i = 3;
          }
          for (;;)
          {
            if (i == 0) {
              break label3458;
            }
            Log.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", new Object[] { paramAnonymousa.field_gameMsgId, Integer.valueOf(i) });
            break;
            if ((l1 == 2L) && ((Util.isNullOrNil((String)localObject1)) || (com.tencent.mm.pluginsdk.model.app.h.y(MMApplicationContext.getContext(), (String)localObject1))))
            {
              if (paramAnonymousa.field_needReport) {
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 7L, 1L, false);
              }
              i = 4;
            }
            else
            {
              label3453:
              i = 0;
            }
          }
          label3458:
          if (paramAnonymousa.field_msgType == 30)
          {
            if (paramAnonymousa.field_needReport) {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 8L, 1L, false);
            }
            i = 0;
            continue;
          }
          localObject1 = r.fGq();
          boolean bool1 = r.k((o)localObject1);
          boolean bool2 = r.k(paramAnonymousa);
          Object localObject2 = r.fGq();
          if (localObject2 != null)
          {
            ((o)localObject2).fGp();
            localObject4 = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject4).put("oldNoticeId", ((o)localObject2).mNoticeId);
            ((JSONObject)localObject4).put("oldMsgId", ((o)localObject2).field_gameMsgId);
            if (paramAnonymousa.field_weight.compareTo(((o)localObject2).field_weight) >= 0) {
              ((JSONObject)localObject4).put("coverType", 1);
            }
            for (;;)
            {
              if (paramAnonymousa.field_needReport) {
                com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 0, 0, 0, 31, 0, paramAnonymousa.field_appId, 0, paramAnonymousa.IEh, paramAnonymousa.field_gameMsgId, paramAnonymousa.mNoticeId, com.tencent.mm.plugin.game.c.a.EM(((JSONObject)localObject4).toString()));
              }
              if (paramAnonymousa.field_weight.compareTo(((o)localObject2).field_weight) < 0) {
                break label3953;
              }
              if (paramAnonymousa.field_needReport) {
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 10L, 1L, false);
              }
              localObject2 = ((o)localObject2).IDY.IEG;
              if (!Util.isNullOrNil((String)localObject2))
              {
                localObject4 = new aee();
                ((aee)localObject4).iiI.hAf = 6;
                ((aee)localObject4).iiI.iiJ = ((String)localObject2);
                ((aee)localObject4).publish();
              }
              i = 1;
              if (i == 0) {
                break label3979;
              }
              i = 1;
              if (i == 0) {
                break label3984;
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
                com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 0, 0, 0, 404, 0, paramAnonymousa.field_appId, 0, paramAnonymousa.IEh, paramAnonymousa.field_gameMsgId, paramAnonymousa.mNoticeId, com.tencent.mm.game.report.g.a("resource", String.valueOf(paramAnonymousa.IDs.IEw), paramAnonymousa.IEi, null));
              }
              if (paramAnonymousa.field_msgType == 4) {
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acLi, Long.valueOf(paramAnonymousa.field_msgId));
              }
              if ((paramAnonymousa != null) && (!Util.isNullOrNil(paramAnonymousa.IDs.IEu)))
              {
                if (!paramAnonymousa.IDs.IEx) {
                  break label4019;
                }
                com.tencent.mm.plugin.game.d.c.i(paramAnonymousa.IDs.IEu, 0.08333334F);
              }
              i = 0;
              break;
              ((JSONObject)localObject4).put("coverType", 2);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MicroMsg.GameMessageService", "reportMsgCover: " + localException.getMessage());
              continue;
              label3953:
              if (paramAnonymousa.field_needReport) {
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 11L, 1L, false);
              }
              i = 0;
              continue;
              label3979:
              i = 0;
              continue;
              label3984:
              if ((bool1) && (!bool2))
              {
                r.d(paramAnonymousa);
                ((r)localObject3).e(paramAnonymousa);
                ((r)localObject3).f(paramAnonymousa);
                ((r)localObject3).g(paramAnonymousa);
                continue;
                label4019:
                com.tencent.mm.plugin.game.d.c.i(paramAnonymousa.IDs.IEu, 0.0F);
              }
            }
          }
        }
      }
      
      public final void a(g.c paramAnonymousc)
      {
        AppMethodBeat.i(40824);
        if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.otV)) || (Util.isNullOrNil(paramAnonymousc.otW)))
        {
          AppMethodBeat.o(40824);
          return;
        }
        Log.i("MicroMsg.GameEventListener", "delete msgType:%s, msgId:%s", new Object[] { paramAnonymousc.otV, paramAnonymousc.otW });
        if (!"gamecenter".equalsIgnoreCase(paramAnonymousc.otV))
        {
          AppMethodBeat.o(40824);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramAnonymousc.otW);
        com.tencent.mm.plugin.game.model.g.t(localArrayList, false);
        AppMethodBeat.o(40824);
      }
    };
    this.HRX = new GameEventListener.2(this, com.tencent.mm.app.f.hfK);
    this.HRY = new GameEventListener.3(this, com.tencent.mm.app.f.hfK);
    this.HRZ = new GameEventListener.4(this, com.tencent.mm.app.f.hfK);
    this.HSa = new GameEventListener.5(this, com.tencent.mm.app.f.hfK);
    this.HSb = new GameEventListener.6(this, com.tencent.mm.app.f.hfK);
    this.HSc = new GameEventListener.7(this, com.tencent.mm.app.f.hfK);
    this.HSd = new GameEventListener.8(this, com.tencent.mm.app.f.hfK);
    this.HSe = new GameEventListener.9(this, com.tencent.mm.app.f.hfK);
    this.HSf = new GameEventListener.10(this, com.tencent.mm.app.f.hfK);
    this.HSg = new com.tencent.mm.pluginsdk.event.a()
    {
      public final IEvent aFl(String paramAnonymousString)
      {
        AppMethodBeat.i(275299);
        kp localkp = new kp();
        localkp.hMk.event = paramAnonymousString;
        AppMethodBeat.o(275299);
        return localkp;
      }
      
      public final MStorage fCc()
      {
        AppMethodBeat.i(275302);
        s locals = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh();
        AppMethodBeat.o(275302);
        return locals;
      }
    };
    this.HSh = new com.tencent.mm.pluginsdk.event.a()
    {
      public final IEvent aFl(String paramAnonymousString)
      {
        AppMethodBeat.i(275298);
        ko localko = new ko();
        localko.hMj.event = paramAnonymousString;
        AppMethodBeat.o(275298);
        return localko;
      }
      
      public final MStorage fCc()
      {
        AppMethodBeat.i(275300);
        com.tencent.mm.plugin.gamelife.f.e locale = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).fIk();
        AppMethodBeat.o(275300);
        return locale;
      }
    };
    this.lxy = new GameEventListener.13(this, com.tencent.mm.app.f.hfK);
    this.HSi = new GameEventListener.14(this, com.tencent.mm.app.f.hfK);
    this.HSj = new GameEventListener.15(this, com.tencent.mm.app.f.hfK);
    this.HSk = new GameEventListener.16(this, com.tencent.mm.app.f.hfK);
    this.HSl = new GameEventListener.17(this, com.tencent.mm.app.f.hfK);
    this.zMr = new GameEventListener.18(this, com.tencent.mm.app.f.hfK);
    this.HSm = new GameEventListener.19(this, com.tencent.mm.app.f.hfK);
    this.HSn = new GameEventListener.20(this, com.tencent.mm.app.f.hfK);
    this.HSo = new GameEventListener.21(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(40840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c
 * JD-Core Version:    0.7.0.1
 */
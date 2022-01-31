package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.game.model.a.h.a;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.a;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.plugin.game.model.n.d;
import com.tencent.mm.plugin.game.model.n.j;
import com.tencent.mm.plugin.game.model.n.k;
import com.tencent.mm.plugin.game.model.n.l;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.p.1;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  com.tencent.mm.sdk.b.c edW;
  bz.a lGp;
  com.tencent.mm.sdk.b.c mcm;
  aw nia;
  com.tencent.mm.sdk.b.c nib;
  com.tencent.mm.sdk.b.c nic;
  com.tencent.mm.sdk.b.c nid;
  com.tencent.mm.sdk.b.c nie;
  com.tencent.mm.sdk.b.c nif;
  com.tencent.mm.sdk.b.c nig;
  com.tencent.mm.sdk.b.c nih;
  com.tencent.mm.sdk.b.c nii;
  com.tencent.mm.pluginsdk.c.d nij;
  com.tencent.mm.sdk.b.c nik;
  com.tencent.mm.sdk.b.c nil;
  com.tencent.mm.sdk.b.c nim;
  com.tencent.mm.sdk.b.c nin;
  com.tencent.mm.sdk.b.c nio;
  
  public c()
  {
    AppMethodBeat.i(111166);
    this.nia = new aw();
    this.lGp = new bz.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(111135);
        ((com.tencent.mm.plugin.game.api.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.d.class)).bER();
        paramAnonymousa = paramAnonymousa.eyJ;
        Object localObject1 = aa.a(paramAnonymousa.woR);
        ab.i("MicroMsg.GameMessageService", "Received a message: %d", new Object[] { Long.valueOf(paramAnonymousa.pIG) });
        ab.i("MicroMsg.GameMessageService", "Message content: %s".concat(String.valueOf(localObject1)));
        label86:
        int i;
        if (bo.isNullOrNil((String)localObject1))
        {
          ab.e("MicroMsg.GameMessageParser", "msg content is null");
          paramAnonymousa = null;
          if (paramAnonymousa != null)
          {
            ab.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s", new Object[] { Integer.valueOf(paramAnonymousa.field_msgType), paramAnonymousa.field_appId, Long.valueOf(paramAnonymousa.field_msgId) });
            if (paramAnonymousa != null) {
              break label1667;
            }
            ab.e("MicroMsg.GameMessageService", "msg is null");
            i = -1;
          }
        }
        long l1;
        label532:
        boolean bool;
        for (;;)
        {
          if (i == 0) {
            q.c(paramAnonymousa);
          }
          switch (paramAnonymousa.field_msgType)
          {
          default: 
            ab.i("MicroMsg.GameMessageService", "Insert raw message: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bES().insert(paramAnonymousa)) });
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 1L, 1L, false);
            int j = paramAnonymousa.field_msgType;
            if (paramAnonymousa.field_msgType == 100) {
              j = paramAnonymousa.nnL;
            }
            com.tencent.mm.game.report.c.a(ah.getContext(), 0, 0, 0, 18, i, paramAnonymousa.field_appId, 0, j, paramAnonymousa.field_gameMsgId, paramAnonymousa.nnM, com.tencent.mm.game.report.c.S("resource", String.valueOf(paramAnonymousa.nnb.nnV)));
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 0L, 1L, false);
            AppMethodBeat.o(111135);
            return;
            localObject2 = br.F((String)localObject1, "sysmsg");
            if ((localObject2 == null) || (((Map)localObject2).size() == 0))
            {
              ab.e("MicroMsg.GameMessageParser", "Parse failed");
              paramAnonymousa = null;
              break label86;
            }
            if (!"gamecenter".equalsIgnoreCase((String)((Map)localObject2).get(".sysmsg.$type")))
            {
              ab.e("MicroMsg.GameMessageParser", "Type not matched");
              paramAnonymousa = null;
              break label86;
            }
            paramAnonymousa = new n();
            paramAnonymousa.field_showInMsgList = true;
            paramAnonymousa.field_msgId = System.currentTimeMillis();
            paramAnonymousa.field_rawXML = ((String)localObject1);
            paramAnonymousa.field_msgType = bo.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.$newmsgtype"), 0);
            if ((paramAnonymousa.field_msgType == 100) || (paramAnonymousa.field_msgType == 30))
            {
              u.bGy();
              paramAnonymousa.field_gameMsgId = bo.bf((String)((Map)localObject2).get(".sysmsg.gamecenter.msg_id"), "");
              paramAnonymousa.field_appId = ((String)((Map)localObject2).get(".sysmsg.gamecenter.appid"));
              paramAnonymousa.field_createTime = bo.getLong((String)((Map)localObject2).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L);
              l1 = bo.getLong((String)((Map)localObject2).get(".sysmsg.gamecenter.time_info.expire_time"), 0L);
              if (l1 == 0L)
              {
                paramAnonymousa.field_expireTime = 9223372036854775807L;
                paramAnonymousa.nmP = bo.getLong((String)((Map)localObject2).get(".sysmsg.gamecenter.time_info.random_time"), 0L);
                if (bo.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
                  break label1071;
                }
                bool = true;
                label576:
                paramAnonymousa.field_isHidden = bool;
                paramAnonymousa.field_mergerId = bo.bf((String)((Map)localObject2).get(".sysmsg.gamecenter.merge_id"), "");
                paramAnonymousa.field_weight = bo.bf((String)((Map)localObject2).get(".sysmsg.gamecenter.weight"), "");
                paramAnonymousa.field_receiveTime = (System.currentTimeMillis() / 1000L);
                u.q((Map)localObject2, paramAnonymousa);
                paramAnonymousa.nno = bo.getLong((String)((Map)localObject2).get(".sysmsg.gamecenter.filter_flag"), 0L);
                paramAnonymousa.nnp = bo.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                if (bo.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) <= 0) {
                  break label1077;
                }
                bool = true;
                label710:
                paramAnonymousa.nna = bool;
                paramAnonymousa.nnb.nnT = bo.bf((String)((Map)localObject2).get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                if ((bo.isNullOrNil((String)((Map)localObject2).get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"))) && (bo.isNullOrNil((String)((Map)localObject2).get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc")))) {
                  break label1083;
                }
                paramAnonymousa.nnc = true;
                label785:
                u.s((Map)localObject2, paramAnonymousa);
                paramAnonymousa.nnG.nog = bo.bf((String)((Map)localObject2).get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                paramAnonymousa.nnG.krm = bo.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                if (!bo.isNullOrNil(paramAnonymousa.nnG.nog)) {
                  paramAnonymousa.field_isHidden = true;
                }
                paramAnonymousa.nnG.noh = bo.getLong((String)((Map)localObject2).get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
                u.u((Map)localObject2, paramAnonymousa);
                u.i((Map)localObject2, paramAnonymousa);
                if (paramAnonymousa.nnp == 1) {
                  paramAnonymousa.field_showInMsgList = false;
                }
                paramAnonymousa.nnI.noi = bo.getInt((String)((Map)localObject2).get(".sysmsg.support_version.$android"), 0);
                ab.i("MicroMsg.GameMessageParser", "xml support version: %d, current client version: %d", new Object[] { Integer.valueOf(paramAnonymousa.nnI.noi), Integer.valueOf(com.tencent.mm.protocal.d.whH) });
                if ((paramAnonymousa.nnI.noi != 0) && (paramAnonymousa.nnI.noi > com.tencent.mm.protocal.d.whH)) {
                  break label1578;
                }
              }
            }
            label1193:
            label1578:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1583;
              }
              ab.i("MicroMsg.GameMessageParser", "xml is invalid in current client version");
              com.tencent.mm.game.report.c.a(ah.getContext(), 0, 0, 0, 401, 0, paramAnonymousa.field_appId, 0, 0, paramAnonymousa.field_gameMsgId, paramAnonymousa.nnM, "");
              paramAnonymousa = null;
              break;
              paramAnonymousa.field_expireTime = (bo.getLong((String)((Map)localObject2).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L) + l1);
              break label532;
              label1071:
              bool = false;
              break label576;
              label1077:
              bool = false;
              break label710;
              label1083:
              paramAnonymousa.nnc = false;
              break label785;
              paramAnonymousa.field_gameMsgId = bo.bf((String)((Map)localObject2).get(".sysmsg.gamecenter.msg_id"), "");
              paramAnonymousa.field_msgType = bo.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.$newmsgtype"), 0);
              if (paramAnonymousa.field_msgType == 0) {
                paramAnonymousa.field_msgType = bo.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.$msgtype"), 0);
              }
              paramAnonymousa.field_appId = ((String)((Map)localObject2).get(".sysmsg.gamecenter.appinfo.appid"));
              if (!bo.isNullOrNil(p.K((Map)localObject2)))
              {
                bool = true;
                paramAnonymousa.field_showInMsgList = bool;
                paramAnonymousa.field_createTime = bo.getLong((String)((Map)localObject2).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L);
                l1 = bo.getLong((String)((Map)localObject2).get(".sysmsg.game_control_info.expiredtime"), 0L);
                if (l1 != 0L) {
                  break label1517;
                }
                paramAnonymousa.field_expireTime = 9223372036854775807L;
                label1259:
                if (bo.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
                  break label1550;
                }
                bool = true;
                paramAnonymousa.field_isHidden = bool;
                paramAnonymousa.field_mergerId = bo.bf((String)((Map)localObject2).get(".sysmsg.gamecenter.merge_id"), "");
                if (paramAnonymousa.field_msgType != 10) {
                  break label1556;
                }
                paramAnonymousa.field_weight = "6";
                label1327:
                paramAnonymousa.field_receiveTime = (System.currentTimeMillis() / 1000L);
                paramAnonymousa.nno = bo.getLong((String)((Map)localObject2).get(".sysmsg.game_control_info.filter_flag"), 0L);
                paramAnonymousa.nnn = p.L((Map)localObject2);
                paramAnonymousa.nnp = bo.getInt((String)((Map)localObject2).get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                if (bo.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) <= 0) {
                  break label1566;
                }
                bool = true;
                paramAnonymousa.nnc = bool;
                paramAnonymousa.nnM = bo.bf((String)((Map)localObject2).get(".sysmsg.gamecenter.noticeid"), "");
                paramAnonymousa.nnb.nnV = bo.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.badge_display_type"), 0);
                if (paramAnonymousa.nnb.nnV <= 0) {
                  break label1572;
                }
              }
              for (bool = true;; bool = false)
              {
                paramAnonymousa.nna = bool;
                if ((paramAnonymousa.nnn & 0x4) == 0L) {
                  paramAnonymousa.nna = false;
                }
                p.k((Map)localObject2, paramAnonymousa);
                break;
                bool = false;
                break label1193;
                label1517:
                paramAnonymousa.field_expireTime = (bo.getLong((String)((Map)localObject2).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L) + l1);
                break label1259;
                bool = false;
                break label1282;
                paramAnonymousa.field_weight = "2";
                break label1327;
                bool = false;
                break label1412;
              }
            }
            label1282:
            label1412:
            label1550:
            label1556:
            label1566:
            label1572:
            label1583:
            paramAnonymousa.nnJ.nog = bo.bf((String)((Map)localObject2).get(".sysmsg.wepkg.$pkg_id"), "");
            paramAnonymousa.nnJ.noj = bo.getInt((String)((Map)localObject2).get(".sysmsg.wepkg.download_trigger_type"), 0);
            new Thread(new p.1(paramAnonymousa.nnJ.nog, paramAnonymousa.nnJ.noj)).start();
            break label86;
            label1667:
            localObject1 = paramAnonymousa.field_gameMsgId;
            if (!bo.isNullOrNil((String)localObject1))
            {
              localObject2 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bES();
              i = 0;
              localObject1 = ((r)localObject2).rawQuery("select count(*) from GameRawMessage where gameMsgId = \"" + (String)localObject1 + "\"", new String[0]);
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
                break label1817;
              }
              ab.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[] { paramAnonymousa.field_gameMsgId });
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 4L, 1L, false);
              i = 2;
              break;
            }
            label1817:
            l1 = System.currentTimeMillis() / 1000L;
            if (paramAnonymousa.field_expireTime <= l1) {}
            for (i = 0;; i = 1)
            {
              if (i != 0) {
                break label1940;
              }
              ab.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[] { paramAnonymousa.field_gameMsgId });
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 5L, 1L, false);
              localObject1 = paramAnonymousa.nnG.nog;
              if (!bo.isNullOrNil((String)localObject1))
              {
                localObject2 = new wi();
                ((wi)localObject2).cNO.coO = 6;
                ((wi)localObject2).cNO.cNP = ((String)localObject1);
                com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
              }
              i = 1;
              break;
            }
            label1940:
            l1 = paramAnonymousa.nno;
            localObject1 = paramAnonymousa.field_appId;
            if (l1 == 1L)
            {
              if ((!bo.isNullOrNil((String)localObject1)) && (com.tencent.mm.pluginsdk.model.app.g.u(ah.getContext(), (String)localObject1))) {
                break label2074;
              }
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 6L, 1L, false);
              i = 3;
            }
            for (;;)
            {
              if (i == 0) {
                break label2079;
              }
              ab.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", new Object[] { paramAnonymousa.field_gameMsgId, Integer.valueOf(i) });
              break;
              if ((l1 == 2L) && ((bo.isNullOrNil((String)localObject1)) || (com.tencent.mm.pluginsdk.model.app.g.u(ah.getContext(), (String)localObject1))))
              {
                com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 7L, 1L, false);
                i = 4;
              }
              else
              {
                label2074:
                i = 0;
              }
            }
            label2079:
            if (paramAnonymousa.field_msgType != 30) {
              break label2107;
            }
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 8L, 1L, false);
            i = 0;
          }
        }
        label2107:
        Object localObject2 = q.bGn();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = q.bGp();
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = q.bGr();
        }
        if (localObject2 == null) {}
        for (localObject1 = q.bGt();; localObject1 = localObject2)
        {
          for (;;)
          {
            if (localObject1 != null)
            {
              ((n)localObject1).bGm();
              localObject2 = new JSONObject();
            }
            try
            {
              ((JSONObject)localObject2).put("oldNoticeId", ((n)localObject1).nnM);
              ((JSONObject)localObject2).put("oldMsgId", ((n)localObject1).field_gameMsgId);
              if (paramAnonymousa.field_weight.compareTo(((n)localObject1).field_weight) >= 0) {
                ((JSONObject)localObject2).put("coverType", 1);
              }
              for (;;)
              {
                i = paramAnonymousa.field_msgType;
                if (paramAnonymousa.field_msgType == 100) {
                  i = paramAnonymousa.nnL;
                }
                com.tencent.mm.game.report.c.a(ah.getContext(), 0, 0, 0, 31, 0, paramAnonymousa.field_appId, 0, i, paramAnonymousa.field_gameMsgId, paramAnonymousa.nnM, com.tencent.mm.plugin.game.e.a.lR(((JSONObject)localObject2).toString()));
                if (paramAnonymousa.field_weight.compareTo(((n)localObject1).field_weight) < 0) {
                  break label2589;
                }
                com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 10L, 1L, false);
                localObject1 = ((n)localObject1).nnG.nog;
                if (!bo.isNullOrNil((String)localObject1))
                {
                  localObject2 = new wi();
                  ((wi)localObject2).cNO.coO = 6;
                  ((wi)localObject2).cNO.cNP = ((String)localObject1);
                  com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
                }
                i = 1;
                if (i == 0) {
                  break label2608;
                }
                i = 1;
                if (i != 0)
                {
                  if (!paramAnonymousa.nna) {
                    break label2613;
                  }
                  com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yAJ, Long.valueOf(paramAnonymousa.field_msgId));
                  if (bo.isNullOrNil(paramAnonymousa.nnq.url)) {
                    break label2632;
                  }
                  com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yAN, Long.valueOf(paramAnonymousa.field_msgId));
                  if (!paramAnonymousa.nnc) {
                    break label2638;
                  }
                  com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yAK, Long.valueOf(paramAnonymousa.field_msgId));
                  if (bo.isNullOrNil(paramAnonymousa.nnH.nnS)) {
                    break label2644;
                  }
                  com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yAO, Long.valueOf(paramAnonymousa.field_msgId));
                }
                if (paramAnonymousa.field_msgType == 4) {
                  com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yAM, Long.valueOf(paramAnonymousa.field_msgId));
                }
                if ((paramAnonymousa == null) || (bo.isNullOrNil(paramAnonymousa.nnb.nnT))) {
                  break;
                }
                com.tencent.mm.plugin.game.f.c.QA(paramAnonymousa.nnb.nnT);
                break;
                ((JSONObject)localObject2).put("coverType", 2);
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ab.e("MicroMsg.GameMessageService", "reportMsgCover: " + localException.getMessage());
                continue;
                label2589:
                com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 11L, 1L, false);
                i = 0;
                continue;
                label2608:
                i = 0;
                continue;
                label2613:
                com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yAJ, Long.valueOf(0L));
                continue;
                label2632:
                q.bGq();
                continue;
                label2638:
                q.bGs();
                continue;
                label2644:
                q.bGu();
              }
            }
          }
          localObject1 = h.a.bHb();
          if ((paramAnonymousa == null) || (bo.isNullOrNil(paramAnonymousa.field_appId)))
          {
            ab.i("MicroMsg.GameSilentDownloader", "msg is null");
            com.tencent.mm.plugin.downloader.f.a.I("appid_is_empty", 16L);
            break;
          }
          localObject2 = paramAnonymousa.field_appId;
          l1 = paramAnonymousa.field_expireTime;
          long l2 = paramAnonymousa.nmP;
          com.tencent.mm.plugin.game.model.a.d locald = new com.tencent.mm.plugin.game.model.a.d();
          locald.field_appId = ((String)localObject2);
          if (!((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEU().get(locald, new String[0]))
          {
            locald.field_expireTime = l1;
            locald.field_randomTime = l2;
            locald.field_isFirst = true;
            locald.field_isRunning = false;
            locald.field_noWifi = true;
            locald.field_noSdcard = true;
            locald.field_noEnoughSpace = true;
            locald.field_lowBattery = true;
            locald.field_continueDelay = true;
            bool = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEU().insert(locald);
            ab.i("MicroMsg.GameSilentDownloader", "insert GameSilentDownloadTask, appid:%s, expireTime:%d, randomTime:%d, ret:%b", new Object[] { locald.field_appId, Long.valueOf(locald.field_expireTime), Long.valueOf(locald.field_randomTime), Boolean.valueOf(bool) });
            ((com.tencent.mm.plugin.game.model.a.h)localObject1).ig(false);
            break;
          }
          ab.i("MicroMsg.GameSilentDownloader", "GameSilentDownloadTask exist! appid = %s", new Object[] { localObject2 });
          com.tencent.mm.plugin.downloader.f.a.I((String)localObject2, 17L);
          break;
        }
      }
    };
    this.nib = new c.10(this);
    this.nic = new c.11(this);
    this.nid = new c.12(this);
    this.nie = new com.tencent.mm.sdk.b.c() {};
    this.nif = new c.14(this);
    this.nig = new c.15(this);
    this.nih = new c.16(this);
    this.nii = new c.17(this);
    this.nij = new c.2(this);
    this.edW = new c.3(this);
    this.nik = new c.4(this);
    this.nil = new c.5(this);
    this.nim = new c.6(this);
    this.nin = new c.7(this);
    this.mcm = new c.8(this);
    this.nio = new c.9(this);
    AppMethodBeat.o(111166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c
 * JD-Core Version:    0.7.0.1
 */
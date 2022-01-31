package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.h.a.gv;
import com.tencent.mm.h.a.un;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.game.model.a.f;
import com.tencent.mm.plugin.game.model.a.g.a;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.plugin.game.model.o.c;
import com.tencent.mm.plugin.game.model.o.i;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.r.1;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  com.tencent.mm.sdk.b.c dmt = new c.3(this);
  bx.a jwQ = new bx.a()
  {
    public final void a(e.a paramAnonymousa)
    {
      Object localObject2 = ((com.tencent.mm.plugin.game.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
      paramAnonymousa = paramAnonymousa.dBs;
      Object localObject1 = aa.a(paramAnonymousa.svH);
      y.i("MicroMsg.GameMessageService", "Received a message: %d", new Object[] { Long.valueOf(paramAnonymousa.ndp) });
      y.i("MicroMsg.GameMessageService", "Message content: %s" + (String)localObject1);
      new Thread(new r.1((r)localObject2, (String)localObject1)).start();
      label110:
      int i;
      if (bk.bl((String)localObject1))
      {
        y.e("MicroMsg.GameMessageParser", "msg content is null");
        paramAnonymousa = null;
        if (paramAnonymousa != null)
        {
          y.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s", new Object[] { Integer.valueOf(paramAnonymousa.field_msgType), paramAnonymousa.field_appId, Long.valueOf(paramAnonymousa.field_msgId) });
          if (paramAnonymousa != null) {
            break label1460;
          }
          y.e("MicroMsg.GameMessageService", "msg is null");
          i = -1;
        }
      }
      long l1;
      label552:
      boolean bool;
      for (;;)
      {
        if (i == 0) {
          r.b(paramAnonymousa);
        }
        switch (paramAnonymousa.field_msgType)
        {
        default: 
          y.i("MicroMsg.GameMessageService", "Insert raw message: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().b(paramAnonymousa)) });
          h.nFQ.a(858L, 1L, 1L, false);
          int j = paramAnonymousa.field_msgType;
          if (paramAnonymousa.field_msgType == 100) {
            j = paramAnonymousa.kPM;
          }
          com.tencent.mm.plugin.game.e.b.a(ae.getContext(), 0, 0, 0, 18, i, paramAnonymousa.field_appId, 0, j, paramAnonymousa.field_gameMsgId, paramAnonymousa.kPN, com.tencent.mm.plugin.game.e.b.dq("resource", String.valueOf(paramAnonymousa.kPf.kPU)));
          h.nFQ.a(858L, 0L, 1L, false);
          return;
          localObject2 = bn.s((String)localObject1, "sysmsg");
          if ((localObject2 == null) || (((Map)localObject2).size() == 0))
          {
            y.e("MicroMsg.GameMessageParser", "Parse failed");
            paramAnonymousa = null;
            break label110;
          }
          if (!"gamecenter".equalsIgnoreCase((String)((Map)localObject2).get(".sysmsg.$type")))
          {
            y.e("MicroMsg.GameMessageParser", "Type not matched");
            paramAnonymousa = null;
            break label110;
          }
          paramAnonymousa = new o();
          paramAnonymousa.field_showInMsgList = true;
          paramAnonymousa.field_msgId = System.currentTimeMillis();
          paramAnonymousa.field_rawXML = ((String)localObject1);
          paramAnonymousa.field_msgType = bk.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.$newmsgtype"), 0);
          if ((paramAnonymousa.field_msgType == 100) || (paramAnonymousa.field_msgType == 30))
          {
            v.aZw();
            paramAnonymousa.field_gameMsgId = bk.aM((String)((Map)localObject2).get(".sysmsg.gamecenter.msg_id"), "");
            paramAnonymousa.field_appId = ((String)((Map)localObject2).get(".sysmsg.gamecenter.appid"));
            paramAnonymousa.field_createTime = bk.getLong((String)((Map)localObject2).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L);
            l1 = bk.getLong((String)((Map)localObject2).get(".sysmsg.gamecenter.time_info.expire_time"), 0L);
            if (l1 == 0L)
            {
              paramAnonymousa.field_expireTime = 9223372036854775807L;
              paramAnonymousa.kOT = bk.getLong((String)((Map)localObject2).get(".sysmsg.gamecenter.time_info.random_time"), 0L);
              if (bk.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
                break label952;
              }
              bool = true;
              label596:
              paramAnonymousa.field_isHidden = bool;
              paramAnonymousa.field_mergerId = bk.aM((String)((Map)localObject2).get(".sysmsg.gamecenter.merge_id"), "");
              paramAnonymousa.field_weight = bk.aM((String)((Map)localObject2).get(".sysmsg.gamecenter.weight"), "");
              paramAnonymousa.field_receiveTime = (System.currentTimeMillis() / 1000L);
              v.d((Map)localObject2, paramAnonymousa);
              paramAnonymousa.kPs = bk.getLong((String)((Map)localObject2).get(".sysmsg.gamecenter.filter_flag"), 0L);
              paramAnonymousa.kPt = bk.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
              if (bk.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) <= 0) {
                break label958;
              }
              bool = true;
              label730:
              paramAnonymousa.kPe = bool;
              paramAnonymousa.kPf.kPS = bk.aM((String)((Map)localObject2).get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
              if ((bk.bl((String)((Map)localObject2).get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"))) && (bk.bl((String)((Map)localObject2).get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc")))) {
                break label964;
              }
            }
            label952:
            label958:
            label964:
            for (paramAnonymousa.kPg = true;; paramAnonymousa.kPg = false)
            {
              v.e((Map)localObject2, paramAnonymousa);
              paramAnonymousa.kPK.kQf = bk.aM((String)((Map)localObject2).get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
              paramAnonymousa.kPK.iqe = bk.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.display_with_wepkg"), 0);
              if (!bk.bl(paramAnonymousa.kPK.kQf)) {
                paramAnonymousa.field_isHidden = true;
              }
              paramAnonymousa.kPK.kQg = bk.getLong((String)((Map)localObject2).get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
              if (paramAnonymousa.kPt == 1) {
                paramAnonymousa.field_showInMsgList = false;
              }
              break;
              paramAnonymousa.field_expireTime = (l1 + bk.getLong((String)((Map)localObject2).get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000L));
              break label552;
              bool = false;
              break label596;
              bool = false;
              break label730;
            }
          }
          paramAnonymousa.field_gameMsgId = bk.aM((String)((Map)localObject2).get(".sysmsg.gamecenter.msg_id"), "");
          paramAnonymousa.field_msgType = bk.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.$newmsgtype"), 0);
          if (paramAnonymousa.field_msgType == 0) {
            paramAnonymousa.field_msgType = bk.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.$msgtype"), 0);
          }
          paramAnonymousa.field_appId = ((String)((Map)localObject2).get(".sysmsg.gamecenter.appinfo.appid"));
          if (!bk.bl(q.z((Map)localObject2)))
          {
            bool = true;
            label1075:
            paramAnonymousa.field_showInMsgList = bool;
            paramAnonymousa.field_createTime = bk.getLong((String)((Map)localObject2).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L);
            l1 = bk.getLong((String)((Map)localObject2).get(".sysmsg.game_control_info.expiredtime"), 0L);
            if (l1 != 0L) {
              break label1399;
            }
            paramAnonymousa.field_expireTime = 9223372036854775807L;
            label1141:
            if (bk.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.wifi_flag"), 0) <= 0) {
              break label1432;
            }
            bool = true;
            label1164:
            paramAnonymousa.field_isHidden = bool;
            paramAnonymousa.field_mergerId = bk.aM((String)((Map)localObject2).get(".sysmsg.gamecenter.merge_id"), "");
            if (paramAnonymousa.field_msgType != 10) {
              break label1438;
            }
            paramAnonymousa.field_weight = "6";
            label1209:
            paramAnonymousa.field_receiveTime = (System.currentTimeMillis() / 1000L);
            paramAnonymousa.kPs = bk.getLong((String)((Map)localObject2).get(".sysmsg.game_control_info.filter_flag"), 0L);
            paramAnonymousa.kPr = q.A((Map)localObject2);
            paramAnonymousa.kPt = bk.getInt((String)((Map)localObject2).get(".sysmsg.game_control_info.not_in_msg_center"), 0);
            if (bk.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) <= 0) {
              break label1448;
            }
            bool = true;
            label1294:
            paramAnonymousa.kPg = bool;
            paramAnonymousa.kPN = bk.aM((String)((Map)localObject2).get(".sysmsg.gamecenter.noticeid"), "");
            paramAnonymousa.kPf.kPU = bk.getInt((String)((Map)localObject2).get(".sysmsg.gamecenter.badge_display_type"), 0);
            if (paramAnonymousa.kPf.kPU <= 0) {
              break label1454;
            }
          }
          label1432:
          label1438:
          label1448:
          label1454:
          for (bool = true;; bool = false)
          {
            paramAnonymousa.kPe = bool;
            if ((paramAnonymousa.kPr & 0x4) == 0L) {
              paramAnonymousa.kPe = false;
            }
            q.b((Map)localObject2, paramAnonymousa);
            break;
            bool = false;
            break label1075;
            label1399:
            paramAnonymousa.field_expireTime = (l1 + bk.getLong((String)((Map)localObject2).get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000L));
            break label1141;
            bool = false;
            break label1164;
            paramAnonymousa.field_weight = "2";
            break label1209;
            bool = false;
            break label1294;
          }
          label1460:
          localObject1 = paramAnonymousa.field_gameMsgId;
          if (!bk.bl((String)localObject1))
          {
            localObject2 = ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYf();
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
              break label1610;
            }
            y.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[] { paramAnonymousa.field_gameMsgId });
            h.nFQ.a(858L, 4L, 1L, false);
            i = 2;
            break;
          }
          label1610:
          l1 = System.currentTimeMillis() / 1000L;
          if (paramAnonymousa.field_expireTime <= l1) {}
          for (i = 0;; i = 1)
          {
            if (i != 0) {
              break label1733;
            }
            y.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[] { paramAnonymousa.field_gameMsgId });
            h.nFQ.a(858L, 5L, 1L, false);
            localObject1 = paramAnonymousa.kPK.kQf;
            if (!bk.bl((String)localObject1))
            {
              localObject2 = new un();
              ((un)localObject2).cfh.bHz = 6;
              ((un)localObject2).cfh.cfi = ((String)localObject1);
              com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
            }
            i = 1;
            break;
          }
          label1733:
          l1 = paramAnonymousa.kPs;
          localObject1 = paramAnonymousa.field_appId;
          if (l1 == 1L)
          {
            if ((!bk.bl((String)localObject1)) && (com.tencent.mm.pluginsdk.model.app.g.o(ae.getContext(), (String)localObject1))) {
              break label1867;
            }
            h.nFQ.a(858L, 6L, 1L, false);
            i = 3;
          }
          for (;;)
          {
            if (i == 0) {
              break label1872;
            }
            y.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", new Object[] { paramAnonymousa.field_gameMsgId, Integer.valueOf(i) });
            break;
            if ((l1 == 2L) && ((bk.bl((String)localObject1)) || (com.tencent.mm.pluginsdk.model.app.g.o(ae.getContext(), (String)localObject1))))
            {
              h.nFQ.a(858L, 7L, 1L, false);
              i = 4;
            }
            else
            {
              label1867:
              i = 0;
            }
          }
          label1872:
          if (paramAnonymousa.field_msgType != 30) {
            break label1900;
          }
          h.nFQ.a(858L, 8L, 1L, false);
          i = 0;
        }
      }
      label1900:
      localObject2 = r.aZn();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = r.aZp();
      }
      if (localObject1 == null) {
        localObject1 = r.aZr();
      }
      for (;;)
      {
        for (;;)
        {
          if (localObject1 != null)
          {
            ((o)localObject1).aZm();
            localObject2 = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject2).put("oldNoticeId", ((o)localObject1).kPN);
            ((JSONObject)localObject2).put("oldMsgId", ((o)localObject1).field_gameMsgId);
            if (paramAnonymousa.field_weight.compareTo(((o)localObject1).field_weight) >= 0) {
              ((JSONObject)localObject2).put("coverType", 1);
            }
            for (;;)
            {
              i = paramAnonymousa.field_msgType;
              if (paramAnonymousa.field_msgType == 100) {
                i = paramAnonymousa.kPM;
              }
              com.tencent.mm.plugin.game.e.b.a(ae.getContext(), 0, 0, 0, 31, 0, paramAnonymousa.field_appId, 0, i, paramAnonymousa.field_gameMsgId, paramAnonymousa.kPN, com.tencent.mm.plugin.game.e.a.fy(((JSONObject)localObject2).toString()));
              if (paramAnonymousa.field_weight.compareTo(((o)localObject1).field_weight) < 0) {
                break label2336;
              }
              h.nFQ.a(858L, 10L, 1L, false);
              localObject1 = ((o)localObject1).kPK.kQf;
              if (!bk.bl((String)localObject1))
              {
                localObject2 = new un();
                ((un)localObject2).cfh.bHz = 6;
                ((un)localObject2).cfh.cfi = ((String)localObject1);
                com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
              }
              i = 1;
              if (i == 0) {
                break label2355;
              }
              i = 1;
              if (i != 0)
              {
                if (!paramAnonymousa.kPe) {
                  break label2360;
                }
                com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uqJ, Long.valueOf(paramAnonymousa.field_msgId));
                if (bk.bl(paramAnonymousa.kPu.url)) {
                  break label2379;
                }
                com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uqN, Long.valueOf(paramAnonymousa.field_msgId));
                if (!paramAnonymousa.kPg) {
                  break label2385;
                }
                com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uqK, Long.valueOf(paramAnonymousa.field_msgId));
              }
              if (paramAnonymousa.field_msgType == 4) {
                com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uqM, Long.valueOf(paramAnonymousa.field_msgId));
              }
              if ((paramAnonymousa == null) || (bk.bl(paramAnonymousa.kPf.kPS))) {
                break;
              }
              com.tencent.mm.plugin.game.f.c.Fg(paramAnonymousa.kPf.kPS);
              break;
              ((JSONObject)localObject2).put("coverType", 2);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              y.e("MicroMsg.GameMessageService", "reportMsgCover: " + localException.getMessage());
              continue;
              label2336:
              h.nFQ.a(858L, 11L, 1L, false);
              i = 0;
              continue;
              label2355:
              i = 0;
              continue;
              label2360:
              com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uqJ, Long.valueOf(0L));
              continue;
              label2379:
              r.aZq();
              continue;
              label2385:
              r.aZs();
            }
          }
        }
        localObject1 = g.a.aZT();
        if ((paramAnonymousa == null) || (bk.bl(paramAnonymousa.field_appId)))
        {
          y.i("MicroMsg.GameSilentDownloader", "msg is null");
          com.tencent.mm.game.report.api.b.dCw.i("appid_is_empty", 16L);
          break;
        }
        localObject2 = paramAnonymousa.field_appId;
        l1 = paramAnonymousa.field_expireTime;
        long l2 = paramAnonymousa.kOT;
        com.tencent.mm.plugin.game.model.a.c localc = new com.tencent.mm.plugin.game.model.a.c();
        localc.field_appId = ((String)localObject2);
        if (!((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().b(localc, new String[0]))
        {
          localc.field_expireTime = l1;
          localc.field_randomTime = l2;
          localc.field_isFirst = true;
          localc.field_isRunning = false;
          localc.field_noWifi = true;
          localc.field_noSdcard = true;
          localc.field_noEnoughSpace = true;
          localc.field_lowBattery = true;
          localc.field_continueDelay = true;
          bool = ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().b(localc);
          y.i("MicroMsg.GameSilentDownloader", "insert GameSilentDownloadTask, appid:%s, expireTime:%d, randomTime:%d, ret:%b", new Object[] { localc.field_appId, Long.valueOf(localc.field_expireTime), Long.valueOf(localc.field_randomTime), Boolean.valueOf(bool) });
          ((com.tencent.mm.plugin.game.model.a.g)localObject1).gx(false);
          break;
        }
        y.i("MicroMsg.GameSilentDownloader", "GameSilentDownloadTask exist! appid = %s", new Object[] { localObject2 });
        com.tencent.mm.game.report.api.b.dCw.i((String)localObject2, 17L);
        break;
      }
    }
  };
  com.tencent.mm.sdk.b.c kLA = new c.14(this);
  com.tencent.mm.sdk.b.c kLB = new c.15(this);
  com.tencent.mm.sdk.b.c kLC = new c.16(this);
  com.tencent.mm.sdk.b.c kLD = new c.17(this);
  d kLE = new d()
  {
    public final com.tencent.mm.sdk.b.b Ew(String paramAnonymousString)
    {
      gv localgv = new gv();
      localgv.bOF.bGt = paramAnonymousString;
      return localgv;
    }
    
    public final j aYb()
    {
      return ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYf();
    }
  };
  com.tencent.mm.sdk.b.c kLF = new c.4(this);
  com.tencent.mm.sdk.b.c kLG = new c.5(this);
  com.tencent.mm.sdk.b.c kLH = new c.6(this);
  com.tencent.mm.sdk.b.c kLI = new c.7(this);
  com.tencent.mm.sdk.b.c kLJ = new c.8(this);
  com.tencent.mm.sdk.b.c kLK = new c.9(this);
  ax kLv = new ax();
  com.tencent.mm.sdk.b.c kLw = new c.10(this);
  com.tencent.mm.sdk.b.c kLx = new c.11(this);
  com.tencent.mm.sdk.b.c kLy = new c.12(this);
  com.tencent.mm.sdk.b.c kLz = new c.13(this);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c
 * JD-Core Version:    0.7.0.1
 */
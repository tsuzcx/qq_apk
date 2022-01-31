package com.tencent.mm.plugin.game.model;

import com.tencent.mm.h.c.bw;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class o
  extends bw
{
  protected static c.a buS;
  public String jcc = "";
  public long kOT = 0L;
  private boolean kOU = false;
  public String kOV = "";
  public String kOW = "";
  public String kOX = "";
  public String kOY = "";
  public String kOZ = "";
  public String kPA = "";
  public String kPB = "";
  public String kPC;
  public String kPD;
  public String kPE;
  public String kPF;
  public String kPG;
  public o.f kPH;
  public o.e kPI = new o.e();
  public o.g kPJ = new o.g();
  public o.i kPK = new o.i();
  public int kPL;
  public int kPM;
  public String kPN;
  public int kPO = 0;
  public String kPP = "";
  public boolean kPQ = false;
  public int kPa = 0;
  public String kPb = "";
  public String kPc = "";
  public LinkedList<o.h> kPd = new LinkedList();
  public boolean kPe;
  public o.c kPf = new o.c();
  public boolean kPg;
  public o.b kPh = new o.b();
  public HashMap<String, o.d> kPi = new HashMap();
  public String kPj = "";
  public int kPk = 0;
  public int kPl = 0;
  public int kPm = 0;
  public String kPn = "";
  public String kPo = "";
  public String kPp = "";
  public int kPq = 0;
  public long kPr = 0L;
  public long kPs = 0L;
  public int kPt = 0;
  public o.a kPu = new o.a();
  public String kPv = "";
  public String kPw = "";
  public String kPx = "";
  public String kPy = "";
  public String kPz = "";
  public String mAppName = "";
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.ujN.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "msgId";
    locala.columns[1] = "mergerId";
    locala.ujN.put("mergerId", "TEXT");
    localStringBuilder.append(" mergerId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "gameMsgId";
    locala.ujN.put("gameMsgId", "TEXT");
    localStringBuilder.append(" gameMsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "msgType";
    locala.ujN.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.ujN.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "expireTime";
    locala.ujN.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "showInMsgList";
    locala.ujN.put("showInMsgList", "INTEGER default 'true' ");
    localStringBuilder.append(" showInMsgList INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "isRead";
    locala.ujN.put("isRead", "INTEGER default 'false' ");
    localStringBuilder.append(" isRead INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "label";
    locala.ujN.put("label", "TEXT default '' ");
    localStringBuilder.append(" label TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "isHidden";
    locala.ujN.put("isHidden", "INTEGER default 'false' ");
    localStringBuilder.append(" isHidden INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "weight";
    locala.ujN.put("weight", "TEXT default '' ");
    localStringBuilder.append(" weight TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "rawXML";
    locala.ujN.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "receiveTime";
    locala.ujN.put("receiveTime", "LONG default '0' ");
    localStringBuilder.append(" receiveTime LONG default '0' ");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final void aZm()
  {
    if (this.kOU) {
      return;
    }
    if (this.field_msgType == 100)
    {
      v.aZw();
      if (this == null) {
        y.e("MicroMsg.GameNewMessageParser", "msg is null");
      }
    }
    for (;;)
    {
      label34:
      this.kOU = true;
      return;
      if (bk.bl(this.field_rawXML))
      {
        y.e("MicroMsg.GameNewMessageParser", "msg content is null");
      }
      else
      {
        Map localMap = bn.s(this.field_rawXML, "sysmsg");
        if ((localMap == null) || (localMap.size() == 0))
        {
          y.e("MicroMsg.GameNewMessageParser", "Parse failed");
        }
        else if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
        {
          y.e("MicroMsg.GameNewMessageParser", "Type not matched");
        }
        else
        {
          this.kPC = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
          this.kPD = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
          this.kPE = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
          this.kPI.kPW = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
          this.kPI.kPS = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
          this.kPI.kPT = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
          this.kPF = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
          this.kPG = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
          if (localMap.get(".sysmsg.gamecenter.msg_center.msg_sender") != null)
          {
            this.kPH = new o.f();
            this.kPH.kPX = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
            this.kPH.kPY = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
            this.kPH.kPZ = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
            this.kPH.kPT = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
          }
          this.kPd.clear();
          int i = 0;
          if (i == 0) {}
          for (Object localObject = ".sysmsg.gamecenter.msg_center.userinfo";; localObject = ".sysmsg.gamecenter.msg_center.userinfo" + i)
          {
            if (!localMap.containsKey(localObject)) {
              break label722;
            }
            o.h localh = new o.h();
            localh.userName = bk.aM((String)localMap.get((String)localObject + ".username"), "");
            localh.aVr = bk.aM((String)localMap.get((String)localObject + ".nickname"), "");
            localh.kQb = bk.aM((String)localMap.get((String)localObject + ".usericon"), "");
            localh.kQd = bk.aM((String)localMap.get((String)localObject + ".badge_icon"), "");
            localh.kQe = bk.aM((String)localMap.get((String)localObject + ".$jump_id"), "");
            this.kPd.add(localh);
            i += 1;
            break;
          }
          label722:
          this.kPJ.mName = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
          localObject = this.kPJ;
          if (bk.getInt((String)localMap.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0) {}
          for (boolean bool = true;; bool = false)
          {
            ((o.g)localObject).kQa = bool;
            this.kPJ.kPT = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
            v.c(localMap, this);
            v.d(localMap, this);
            this.kPh.kPS = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
            this.kPh.dkv = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
            this.kPh.kPT = bk.aM((String)localMap.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
            v.e(localMap, this);
            this.kPf.kPU = bk.getInt((String)localMap.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
            this.kPf.kPS = bk.aM((String)localMap.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
            this.kPf.hnV = bk.aM((String)localMap.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
            this.kPK.kQf = bk.aM((String)localMap.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
            this.kPK.iqe = bk.getInt((String)localMap.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
            this.kPK.kQg = bk.getLong((String)localMap.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
            this.kPq = bk.getInt((String)localMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
            break;
          }
          if (this == null)
          {
            y.e("MicroMsg.GameMessageParser", "msg is null");
          }
          else if (bk.bl(this.field_rawXML))
          {
            y.e("MicroMsg.GameMessageParser", "msg content is null");
          }
          else
          {
            localObject = bn.s(this.field_rawXML, "sysmsg");
            if ((localObject == null) || (((Map)localObject).size() == 0))
            {
              y.e("MicroMsg.GameMessageParser", "Parse failed");
            }
            else if (!"gamecenter".equalsIgnoreCase((String)((Map)localObject).get(".sysmsg.$type")))
            {
              y.e("MicroMsg.GameMessageParser", "Type not matched");
            }
            else
            {
              this.kPq = bk.getInt((String)((Map)localObject).get(".sysmsg.gamecenter.wifi_flag"), 0);
              this.jcc = q.z((Map)localObject);
              this.kOV = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.url"), "");
              this.kPj = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.msg_picture_url"), "");
              this.kOW = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
              if (bk.bl(this.kOW)) {
                this.kOW = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.url"), "");
              }
              this.kPL = bk.getInt((String)((Map)localObject).get(".sysmsg.gamecenter.notify_type"), 0);
              this.mAppName = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.appinfo.appname2"), "");
              if (bk.bl(this.mAppName)) {
                this.mAppName = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.appinfo.appname"), "");
              }
              if (this.field_msgType == 6)
              {
                this.kPb = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.appinfo.groupname"), "");
                this.kPc = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.appinfo.groupurl"), "");
              }
              for (;;)
              {
                this.kOX = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.appinfo.iconurl"), "");
                this.kOY = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
                this.kOZ = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
                this.kPa = bk.getInt((String)((Map)localObject).get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
                q.a((Map)localObject, this);
                this.kPN = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.noticeid"), "");
                this.kPr = q.A((Map)localObject);
                this.kPf.kPU = bk.getInt((String)((Map)localObject).get(".sysmsg.gamecenter.badge_display_type"), 0);
                this.kPf.kPS = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.showiconurl"), "");
                this.kPf.hnV = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.entrancetext"), "");
                q.b((Map)localObject, this);
                this.kPk = bk.getInt((String)((Map)localObject).get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
                this.kPh.kPS = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
                this.kPh.dkv = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
                this.kPO = bk.getInt((String)((Map)localObject).get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
                this.kPP = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
                switch (this.field_msgType)
                {
                case 4: 
                case 10: 
                case 11: 
                case 3: 
                case 7: 
                case 8: 
                case 9: 
                default: 
                  y.e("MicroMsg.GameMessageParser", "error gamecenter type: " + this.field_msgType);
                  break label34;
                  this.kPb = this.mAppName;
                }
              }
              this.kPl = bk.getInt((String)((Map)localObject).get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
              this.kPm = bk.getInt((String)((Map)localObject).get(".sysmsg.game_control_info.display_name_type"), 1);
              this.kPn = bk.aM((String)((Map)localObject).get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
              this.kPo = bk.aM((String)((Map)localObject).get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
              this.kPp = bk.aM((String)((Map)localObject).get(".sysmsg.gameshare.share_message_info.media_url"), "");
              this.kPj = bk.aM((String)((Map)localObject).get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
              y.i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", new Object[] { this.field_appId });
              continue;
              this.kPz = bk.aM((String)((Map)localObject).get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
              this.kPA = bk.aM((String)((Map)localObject).get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
              this.kPB = bk.aM((String)((Map)localObject).get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
              continue;
              this.kPv = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.topic.reply_content"), "");
              this.kPw = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.topic.replied_content"), "");
              this.kPy = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.topic.topic_title"), "");
              this.kPx = bk.aM((String)((Map)localObject).get(".sysmsg.gamecenter.topic.topic_url"), "");
            }
          }
        }
      }
    }
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.o
 * JD-Core Version:    0.7.0.1
 */
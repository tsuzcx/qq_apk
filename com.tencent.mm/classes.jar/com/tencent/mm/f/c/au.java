package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class au
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ChatRoomMember");
  private static final int hAY;
  private static final int hAZ;
  public static final Column hAa;
  public static final Column hAb;
  public static final Column hAc;
  public static final Column hAd;
  public static final Column hAe;
  public static final Column hAf;
  public static final Column hAg;
  public static final Column hAh;
  public static final Column hAi;
  public static final Column hAj;
  public static final Column hAk;
  public static final Column hAl;
  public static final Column hAm;
  public static final Column hAn;
  public static final Column hAo;
  public static final Column hAp;
  public static final Column hAq;
  public static final Column hAr;
  public static final Column hAs;
  public static final Column hAt;
  public static final Column hAu;
  public static final Column hAv;
  public static final Column hAw;
  private static final int hBa;
  private static final int hBb;
  private static final int hBc;
  private static final int hBd = "roomowner".hashCode();
  private static final int hBe = "roomdata".hashCode();
  private static final int hBf = "isShowname".hashCode();
  private static final int hBg = "selfDisplayName".hashCode();
  private static final int hBh = "style".hashCode();
  private static final int hBi = "chatroomdataflag".hashCode();
  private static final int hBj = "modifytime".hashCode();
  private static final int hBk = "chatroomnotice".hashCode();
  private static final int hBl = "chatroomVersion".hashCode();
  private static final int hBm = "chatroomnoticeEditor".hashCode();
  private static final int hBn = "chatroomnoticePublishTime".hashCode();
  private static final int hBo = "chatroomNoticeNew".hashCode();
  private static final int hBp = "chatroomLocalVersion".hashCode();
  private static final int hBq = "chatroomStatus".hashCode();
  private static final int hBr = "memberCount".hashCode();
  private static final int hBs = "chatroomfamilystatusmodifytime".hashCode();
  private static final int hBt = "associateOpenIMRoomName".hashCode();
  private static final int hBu = "openIMRoomMigrateStatus".hashCode();
  private static final int hBv = "saveByteVersion".hashCode();
  private static final int hBw = "handleByteVersion".hashCode();
  private static final int hBx = "roomInfoDetailResByte".hashCode();
  private static final int hBy = "oldChatroomVersion".hashCode();
  public static final Column hqt;
  public static final Column htX;
  private static final int hux;
  public static final Column hzX;
  public static final Column hzY;
  public static final Column hzZ;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_addtime;
  public String field_associateOpenIMRoomName;
  public long field_chatroomLocalVersion;
  public int field_chatroomNoticeNew;
  public int field_chatroomStatus;
  public int field_chatroomVersion;
  public int field_chatroomdataflag;
  public long field_chatroomfamilystatusmodifytime;
  public String field_chatroomname;
  public String field_chatroomnick;
  public String field_chatroomnotice;
  public String field_chatroomnoticeEditor;
  public long field_chatroomnoticePublishTime;
  public String field_displayname;
  public String field_handleByteVersion;
  public int field_isShowname;
  public int field_memberCount;
  public String field_memberlist;
  public long field_modifytime;
  public int field_oldChatroomVersion;
  public int field_openIMRoomMigrateStatus;
  public byte[] field_roomInfoDetailResByte;
  public byte[] field_roomdata;
  public int field_roomflag;
  public String field_roomowner;
  public String field_saveByteVersion;
  public String field_selfDisplayName;
  public int field_style;
  private boolean hAA = true;
  private boolean hAB = true;
  private boolean hAC = true;
  private boolean hAD = true;
  private boolean hAE = true;
  private boolean hAF = true;
  private boolean hAG = true;
  private boolean hAH = true;
  private boolean hAI = true;
  private boolean hAJ = true;
  private boolean hAK = true;
  private boolean hAL = true;
  private boolean hAM = true;
  private boolean hAN = true;
  private boolean hAO = true;
  private boolean hAP = true;
  private boolean hAQ = true;
  private boolean hAR = true;
  private boolean hAS = true;
  private boolean hAT = true;
  private boolean hAU = true;
  private boolean hAV = true;
  private boolean hAW = true;
  private boolean hAX = true;
  private boolean hAx = true;
  private boolean hAy = true;
  private boolean hAz = true;
  private boolean huk = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ChatRoomMember", "");
    hzX = new Column("chatroomname", "string", "ChatRoomMember", "");
    hzY = new Column("addtime", "long", "ChatRoomMember", "");
    hzZ = new Column("memberlist", "string", "ChatRoomMember", "");
    hAa = new Column("displayname", "string", "ChatRoomMember", "");
    hAb = new Column("chatroomnick", "string", "ChatRoomMember", "");
    htX = new Column("roomflag", "int", "ChatRoomMember", "");
    hAc = new Column("roomowner", "string", "ChatRoomMember", "");
    hAd = new Column("roomdata", "byte[]", "ChatRoomMember", "");
    hAe = new Column("isshowname", "int", "ChatRoomMember", "");
    hAf = new Column("selfdisplayname", "string", "ChatRoomMember", "");
    hAg = new Column("style", "int", "ChatRoomMember", "");
    hAh = new Column("chatroomdataflag", "int", "ChatRoomMember", "");
    hqt = new Column("modifytime", "long", "ChatRoomMember", "");
    hAi = new Column("chatroomnotice", "string", "ChatRoomMember", "");
    hAj = new Column("chatroomversion", "int", "ChatRoomMember", "");
    hAk = new Column("chatroomnoticeeditor", "string", "ChatRoomMember", "");
    hAl = new Column("chatroomnoticepublishtime", "long", "ChatRoomMember", "");
    hAm = new Column("chatroomnoticenew", "int", "ChatRoomMember", "");
    hAn = new Column("chatroomlocalversion", "long", "ChatRoomMember", "");
    hAo = new Column("chatroomstatus", "int", "ChatRoomMember", "");
    hAp = new Column("membercount", "int", "ChatRoomMember", "");
    hAq = new Column("chatroomfamilystatusmodifytime", "long", "ChatRoomMember", "");
    hAr = new Column("associateopenimroomname", "string", "ChatRoomMember", "");
    hAs = new Column("openimroommigratestatus", "int", "ChatRoomMember", "");
    hAt = new Column("savebyteversion", "string", "ChatRoomMember", "");
    hAu = new Column("handlebyteversion", "string", "ChatRoomMember", "");
    hAv = new Column("roominfodetailresbyte", "byte[]", "ChatRoomMember", "");
    hAw = new Column("oldchatroomversion", "int", "ChatRoomMember", "");
    hAY = "chatroomname".hashCode();
    hAZ = "addtime".hashCode();
    hBa = "memberlist".hashCode();
    hBb = "displayname".hashCode();
    hBc = "chatroomnick".hashCode();
    hux = "roomflag".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (hAY != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.hAx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hAZ == k) {
        this.field_addtime = paramCursor.getLong(i);
      } else if (hBa == k) {
        this.field_memberlist = paramCursor.getString(i);
      } else if (hBb == k) {
        this.field_displayname = paramCursor.getString(i);
      } else if (hBc == k) {
        this.field_chatroomnick = paramCursor.getString(i);
      } else if (hux == k) {
        this.field_roomflag = paramCursor.getInt(i);
      } else if (hBd == k) {
        this.field_roomowner = paramCursor.getString(i);
      } else if (hBe == k) {
        this.field_roomdata = paramCursor.getBlob(i);
      } else if (hBf == k) {
        this.field_isShowname = paramCursor.getInt(i);
      } else if (hBg == k) {
        this.field_selfDisplayName = paramCursor.getString(i);
      } else if (hBh == k) {
        this.field_style = paramCursor.getInt(i);
      } else if (hBi == k) {
        this.field_chatroomdataflag = paramCursor.getInt(i);
      } else if (hBj == k) {
        this.field_modifytime = paramCursor.getLong(i);
      } else if (hBk == k) {
        this.field_chatroomnotice = paramCursor.getString(i);
      } else if (hBl == k) {
        this.field_chatroomVersion = paramCursor.getInt(i);
      } else if (hBm == k) {
        this.field_chatroomnoticeEditor = paramCursor.getString(i);
      } else if (hBn == k) {
        this.field_chatroomnoticePublishTime = paramCursor.getLong(i);
      } else if (hBo == k) {
        this.field_chatroomNoticeNew = paramCursor.getInt(i);
      } else if (hBp == k) {
        this.field_chatroomLocalVersion = paramCursor.getLong(i);
      } else if (hBq == k) {
        this.field_chatroomStatus = paramCursor.getInt(i);
      } else if (hBr == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (hBs == k) {
        this.field_chatroomfamilystatusmodifytime = paramCursor.getLong(i);
      } else if (hBt == k) {
        this.field_associateOpenIMRoomName = paramCursor.getString(i);
      } else if (hBu == k) {
        this.field_openIMRoomMigrateStatus = paramCursor.getInt(i);
      } else if (hBv == k) {
        this.field_saveByteVersion = paramCursor.getString(i);
      } else if (hBw == k) {
        this.field_handleByteVersion = paramCursor.getString(i);
      } else if (hBx == k) {
        this.field_roomInfoDetailResByte = paramCursor.getBlob(i);
      } else if (hBy == k) {
        this.field_oldChatroomVersion = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_chatroomname == null) {
      this.field_chatroomname = "";
    }
    if (this.hAx) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.hAy) {
      localContentValues.put("addtime", Long.valueOf(this.field_addtime));
    }
    if (this.hAz) {
      localContentValues.put("memberlist", this.field_memberlist);
    }
    if (this.hAA) {
      localContentValues.put("displayname", this.field_displayname);
    }
    if (this.hAB) {
      localContentValues.put("chatroomnick", this.field_chatroomnick);
    }
    if (this.huk) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.hAC) {
      localContentValues.put("roomowner", this.field_roomowner);
    }
    if (this.hAD) {
      localContentValues.put("roomdata", this.field_roomdata);
    }
    if (this.hAE) {
      localContentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
    }
    if (this.hAF) {
      localContentValues.put("selfDisplayName", this.field_selfDisplayName);
    }
    if (this.hAG) {
      localContentValues.put("style", Integer.valueOf(this.field_style));
    }
    if (this.hAH) {
      localContentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
    }
    if (this.hAI) {
      localContentValues.put("modifytime", Long.valueOf(this.field_modifytime));
    }
    if (this.hAJ) {
      localContentValues.put("chatroomnotice", this.field_chatroomnotice);
    }
    if (this.hAK) {
      localContentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
    }
    if (this.hAL) {
      localContentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
    }
    if (this.hAM) {
      localContentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
    }
    if (this.hAN) {
      localContentValues.put("chatroomNoticeNew", Integer.valueOf(this.field_chatroomNoticeNew));
    }
    if (this.hAO) {
      localContentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
    }
    if (this.hAP) {
      localContentValues.put("chatroomStatus", Integer.valueOf(this.field_chatroomStatus));
    }
    if (this.hAQ) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.hAR) {
      localContentValues.put("chatroomfamilystatusmodifytime", Long.valueOf(this.field_chatroomfamilystatusmodifytime));
    }
    if (this.hAS) {
      localContentValues.put("associateOpenIMRoomName", this.field_associateOpenIMRoomName);
    }
    if (this.hAT) {
      localContentValues.put("openIMRoomMigrateStatus", Integer.valueOf(this.field_openIMRoomMigrateStatus));
    }
    if (this.hAU) {
      localContentValues.put("saveByteVersion", this.field_saveByteVersion);
    }
    if (this.hAV) {
      localContentValues.put("handleByteVersion", this.field_handleByteVersion);
    }
    if (this.hAW) {
      localContentValues.put("roomInfoDetailResByte", this.field_roomInfoDetailResByte);
    }
    if (this.hAX) {
      localContentValues.put("oldChatroomVersion", Integer.valueOf(this.field_oldChatroomVersion));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "ChatRoomMember";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.au
 * JD-Core Version:    0.7.0.1
 */
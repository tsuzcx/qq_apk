package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class at
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eLb;
  private static final int ePA = "selfDisplayName".hashCode();
  private static final int ePB = "style".hashCode();
  private static final int ePC = "chatroomdataflag".hashCode();
  private static final int ePD = "modifytime".hashCode();
  private static final int ePE = "chatroomnotice".hashCode();
  private static final int ePF = "chatroomVersion".hashCode();
  private static final int ePG = "chatroomnoticeEditor".hashCode();
  private static final int ePH = "chatroomnoticePublishTime".hashCode();
  private static final int ePI = "chatroomLocalVersion".hashCode();
  private static final int ePJ = "chatroomStatus".hashCode();
  private static final int ePK = "memberCount".hashCode();
  private static final int ePL = "chatroomfamilystatusmodifytime".hashCode();
  private static final int ePM = "associateOpenIMRoomName".hashCode();
  private static final int ePN = "openIMRoomMigrateStatus".hashCode();
  private static final int ePO = "saveByteVersion".hashCode();
  private static final int ePP = "handleByteVersion".hashCode();
  private static final int ePQ = "roomInfoDetailResByte".hashCode();
  private static final int ePR = "oldChatroomVersion".hashCode();
  private static final int ePs = "chatroomname".hashCode();
  private static final int ePt = "addtime".hashCode();
  private static final int ePu = "memberlist".hashCode();
  private static final int ePv = "displayname".hashCode();
  private static final int ePw = "chatroomnick".hashCode();
  private static final int ePx;
  private static final int ePy;
  private static final int ePz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eKO = true;
  private boolean eOS = true;
  private boolean eOT = true;
  private boolean eOU = true;
  private boolean eOV = true;
  private boolean eOW = true;
  private boolean eOX = true;
  private boolean eOY = true;
  private boolean eOZ = true;
  private boolean ePa = true;
  private boolean ePb = true;
  private boolean ePc = true;
  private boolean ePd = true;
  private boolean ePe = true;
  private boolean ePf = true;
  private boolean ePg = true;
  private boolean ePh = true;
  private boolean ePi = true;
  private boolean ePj = true;
  private boolean ePk = true;
  private boolean ePl = true;
  private boolean ePm = true;
  private boolean ePn = true;
  private boolean ePo = true;
  private boolean ePp = true;
  private boolean ePq = true;
  private boolean ePr = true;
  public long field_addtime;
  public String field_associateOpenIMRoomName;
  public long field_chatroomLocalVersion;
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
  
  static
  {
    eLb = "roomflag".hashCode();
    ePx = "roomowner".hashCode();
    ePy = "roomdata".hashCode();
    ePz = "isShowname".hashCode();
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
      if (ePs != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.eOS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ePt == k) {
        this.field_addtime = paramCursor.getLong(i);
      } else if (ePu == k) {
        this.field_memberlist = paramCursor.getString(i);
      } else if (ePv == k) {
        this.field_displayname = paramCursor.getString(i);
      } else if (ePw == k) {
        this.field_chatroomnick = paramCursor.getString(i);
      } else if (eLb == k) {
        this.field_roomflag = paramCursor.getInt(i);
      } else if (ePx == k) {
        this.field_roomowner = paramCursor.getString(i);
      } else if (ePy == k) {
        this.field_roomdata = paramCursor.getBlob(i);
      } else if (ePz == k) {
        this.field_isShowname = paramCursor.getInt(i);
      } else if (ePA == k) {
        this.field_selfDisplayName = paramCursor.getString(i);
      } else if (ePB == k) {
        this.field_style = paramCursor.getInt(i);
      } else if (ePC == k) {
        this.field_chatroomdataflag = paramCursor.getInt(i);
      } else if (ePD == k) {
        this.field_modifytime = paramCursor.getLong(i);
      } else if (ePE == k) {
        this.field_chatroomnotice = paramCursor.getString(i);
      } else if (ePF == k) {
        this.field_chatroomVersion = paramCursor.getInt(i);
      } else if (ePG == k) {
        this.field_chatroomnoticeEditor = paramCursor.getString(i);
      } else if (ePH == k) {
        this.field_chatroomnoticePublishTime = paramCursor.getLong(i);
      } else if (ePI == k) {
        this.field_chatroomLocalVersion = paramCursor.getLong(i);
      } else if (ePJ == k) {
        this.field_chatroomStatus = paramCursor.getInt(i);
      } else if (ePK == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (ePL == k) {
        this.field_chatroomfamilystatusmodifytime = paramCursor.getLong(i);
      } else if (ePM == k) {
        this.field_associateOpenIMRoomName = paramCursor.getString(i);
      } else if (ePN == k) {
        this.field_openIMRoomMigrateStatus = paramCursor.getInt(i);
      } else if (ePO == k) {
        this.field_saveByteVersion = paramCursor.getString(i);
      } else if (ePP == k) {
        this.field_handleByteVersion = paramCursor.getString(i);
      } else if (ePQ == k) {
        this.field_roomInfoDetailResByte = paramCursor.getBlob(i);
      } else if (ePR == k) {
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
    if (this.eOS) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.eOT) {
      localContentValues.put("addtime", Long.valueOf(this.field_addtime));
    }
    if (this.eOU) {
      localContentValues.put("memberlist", this.field_memberlist);
    }
    if (this.eOV) {
      localContentValues.put("displayname", this.field_displayname);
    }
    if (this.eOW) {
      localContentValues.put("chatroomnick", this.field_chatroomnick);
    }
    if (this.eKO) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.eOX) {
      localContentValues.put("roomowner", this.field_roomowner);
    }
    if (this.eOY) {
      localContentValues.put("roomdata", this.field_roomdata);
    }
    if (this.eOZ) {
      localContentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
    }
    if (this.ePa) {
      localContentValues.put("selfDisplayName", this.field_selfDisplayName);
    }
    if (this.ePb) {
      localContentValues.put("style", Integer.valueOf(this.field_style));
    }
    if (this.ePc) {
      localContentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
    }
    if (this.ePd) {
      localContentValues.put("modifytime", Long.valueOf(this.field_modifytime));
    }
    if (this.ePe) {
      localContentValues.put("chatroomnotice", this.field_chatroomnotice);
    }
    if (this.ePf) {
      localContentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
    }
    if (this.ePg) {
      localContentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
    }
    if (this.ePh) {
      localContentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
    }
    if (this.ePi) {
      localContentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
    }
    if (this.ePj) {
      localContentValues.put("chatroomStatus", Integer.valueOf(this.field_chatroomStatus));
    }
    if (this.ePk) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.ePl) {
      localContentValues.put("chatroomfamilystatusmodifytime", Long.valueOf(this.field_chatroomfamilystatusmodifytime));
    }
    if (this.ePm) {
      localContentValues.put("associateOpenIMRoomName", this.field_associateOpenIMRoomName);
    }
    if (this.ePn) {
      localContentValues.put("openIMRoomMigrateStatus", Integer.valueOf(this.field_openIMRoomMigrateStatus));
    }
    if (this.ePo) {
      localContentValues.put("saveByteVersion", this.field_saveByteVersion);
    }
    if (this.ePp) {
      localContentValues.put("handleByteVersion", this.field_handleByteVersion);
    }
    if (this.ePq) {
      localContentValues.put("roomInfoDetailResByte", this.field_roomInfoDetailResByte);
    }
    if (this.ePr) {
      localContentValues.put("oldChatroomVersion", Integer.valueOf(this.field_oldChatroomVersion));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.at
 * JD-Core Version:    0.7.0.1
 */
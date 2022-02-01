package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class at
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJs = "roomflag".hashCode();
  private static final int eNH = "chatroomname".hashCode();
  private static final int eNI = "addtime".hashCode();
  private static final int eNJ = "memberlist".hashCode();
  private static final int eNK = "displayname".hashCode();
  private static final int eNL = "chatroomnick".hashCode();
  private static final int eNM = "roomowner".hashCode();
  private static final int eNN = "roomdata".hashCode();
  private static final int eNO = "isShowname".hashCode();
  private static final int eNP = "selfDisplayName".hashCode();
  private static final int eNQ = "style".hashCode();
  private static final int eNR = "chatroomdataflag".hashCode();
  private static final int eNS = "modifytime".hashCode();
  private static final int eNT = "chatroomnotice".hashCode();
  private static final int eNU = "chatroomVersion".hashCode();
  private static final int eNV = "chatroomnoticeEditor".hashCode();
  private static final int eNW = "chatroomnoticePublishTime".hashCode();
  private static final int eNX = "chatroomLocalVersion".hashCode();
  private static final int eNY = "chatroomStatus".hashCode();
  private static final int eNZ = "memberCount".hashCode();
  private static final int eOa = "chatroomfamilystatusmodifytime".hashCode();
  private static final int eOb = "associateOpenIMRoomName".hashCode();
  private static final int eOc = "openIMRoomMigrateStatus".hashCode();
  private static final int eOd = "saveByteVersion".hashCode();
  private static final int eOe = "handleByteVersion".hashCode();
  private static final int eOf = "roomInfoDetailResByte".hashCode();
  private static final int eOg = "oldChatroomVersion".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJf = true;
  private boolean eNA = true;
  private boolean eNB = true;
  private boolean eNC = true;
  private boolean eND = true;
  private boolean eNE = true;
  private boolean eNF = true;
  private boolean eNG = true;
  private boolean eNh = true;
  private boolean eNi = true;
  private boolean eNj = true;
  private boolean eNk = true;
  private boolean eNl = true;
  private boolean eNm = true;
  private boolean eNn = true;
  private boolean eNo = true;
  private boolean eNp = true;
  private boolean eNq = true;
  private boolean eNr = true;
  private boolean eNs = true;
  private boolean eNt = true;
  private boolean eNu = true;
  private boolean eNv = true;
  private boolean eNw = true;
  private boolean eNx = true;
  private boolean eNy = true;
  private boolean eNz = true;
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
      if (eNH != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.eNh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eNI == k) {
        this.field_addtime = paramCursor.getLong(i);
      } else if (eNJ == k) {
        this.field_memberlist = paramCursor.getString(i);
      } else if (eNK == k) {
        this.field_displayname = paramCursor.getString(i);
      } else if (eNL == k) {
        this.field_chatroomnick = paramCursor.getString(i);
      } else if (eJs == k) {
        this.field_roomflag = paramCursor.getInt(i);
      } else if (eNM == k) {
        this.field_roomowner = paramCursor.getString(i);
      } else if (eNN == k) {
        this.field_roomdata = paramCursor.getBlob(i);
      } else if (eNO == k) {
        this.field_isShowname = paramCursor.getInt(i);
      } else if (eNP == k) {
        this.field_selfDisplayName = paramCursor.getString(i);
      } else if (eNQ == k) {
        this.field_style = paramCursor.getInt(i);
      } else if (eNR == k) {
        this.field_chatroomdataflag = paramCursor.getInt(i);
      } else if (eNS == k) {
        this.field_modifytime = paramCursor.getLong(i);
      } else if (eNT == k) {
        this.field_chatroomnotice = paramCursor.getString(i);
      } else if (eNU == k) {
        this.field_chatroomVersion = paramCursor.getInt(i);
      } else if (eNV == k) {
        this.field_chatroomnoticeEditor = paramCursor.getString(i);
      } else if (eNW == k) {
        this.field_chatroomnoticePublishTime = paramCursor.getLong(i);
      } else if (eNX == k) {
        this.field_chatroomLocalVersion = paramCursor.getLong(i);
      } else if (eNY == k) {
        this.field_chatroomStatus = paramCursor.getInt(i);
      } else if (eNZ == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (eOa == k) {
        this.field_chatroomfamilystatusmodifytime = paramCursor.getLong(i);
      } else if (eOb == k) {
        this.field_associateOpenIMRoomName = paramCursor.getString(i);
      } else if (eOc == k) {
        this.field_openIMRoomMigrateStatus = paramCursor.getInt(i);
      } else if (eOd == k) {
        this.field_saveByteVersion = paramCursor.getString(i);
      } else if (eOe == k) {
        this.field_handleByteVersion = paramCursor.getString(i);
      } else if (eOf == k) {
        this.field_roomInfoDetailResByte = paramCursor.getBlob(i);
      } else if (eOg == k) {
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
    if (this.eNh) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.eNi) {
      localContentValues.put("addtime", Long.valueOf(this.field_addtime));
    }
    if (this.eNj) {
      localContentValues.put("memberlist", this.field_memberlist);
    }
    if (this.eNk) {
      localContentValues.put("displayname", this.field_displayname);
    }
    if (this.eNl) {
      localContentValues.put("chatroomnick", this.field_chatroomnick);
    }
    if (this.eJf) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.eNm) {
      localContentValues.put("roomowner", this.field_roomowner);
    }
    if (this.eNn) {
      localContentValues.put("roomdata", this.field_roomdata);
    }
    if (this.eNo) {
      localContentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
    }
    if (this.eNp) {
      localContentValues.put("selfDisplayName", this.field_selfDisplayName);
    }
    if (this.eNq) {
      localContentValues.put("style", Integer.valueOf(this.field_style));
    }
    if (this.eNr) {
      localContentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
    }
    if (this.eNs) {
      localContentValues.put("modifytime", Long.valueOf(this.field_modifytime));
    }
    if (this.eNt) {
      localContentValues.put("chatroomnotice", this.field_chatroomnotice);
    }
    if (this.eNu) {
      localContentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
    }
    if (this.eNv) {
      localContentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
    }
    if (this.eNw) {
      localContentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
    }
    if (this.eNx) {
      localContentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
    }
    if (this.eNy) {
      localContentValues.put("chatroomStatus", Integer.valueOf(this.field_chatroomStatus));
    }
    if (this.eNz) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.eNA) {
      localContentValues.put("chatroomfamilystatusmodifytime", Long.valueOf(this.field_chatroomfamilystatusmodifytime));
    }
    if (this.eNB) {
      localContentValues.put("associateOpenIMRoomName", this.field_associateOpenIMRoomName);
    }
    if (this.eNC) {
      localContentValues.put("openIMRoomMigrateStatus", Integer.valueOf(this.field_openIMRoomMigrateStatus));
    }
    if (this.eND) {
      localContentValues.put("saveByteVersion", this.field_saveByteVersion);
    }
    if (this.eNE) {
      localContentValues.put("handleByteVersion", this.field_handleByteVersion);
    }
    if (this.eNF) {
      localContentValues.put("roomInfoDetailResByte", this.field_roomInfoDetailResByte);
    }
    if (this.eNG) {
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
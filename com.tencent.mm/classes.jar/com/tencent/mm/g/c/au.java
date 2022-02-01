package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class au
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int foH = "roomflag".hashCode();
  private static final int fsZ = "chatroomname".hashCode();
  private static final int fta = "addtime".hashCode();
  private static final int ftb = "memberlist".hashCode();
  private static final int ftc = "displayname".hashCode();
  private static final int ftd = "chatroomnick".hashCode();
  private static final int fte = "roomowner".hashCode();
  private static final int ftf = "roomdata".hashCode();
  private static final int ftg = "isShowname".hashCode();
  private static final int fth = "selfDisplayName".hashCode();
  private static final int fti = "style".hashCode();
  private static final int ftj = "chatroomdataflag".hashCode();
  private static final int ftk = "modifytime".hashCode();
  private static final int ftl = "chatroomnotice".hashCode();
  private static final int ftm = "chatroomVersion".hashCode();
  private static final int ftn = "chatroomnoticeEditor".hashCode();
  private static final int fto = "chatroomnoticePublishTime".hashCode();
  private static final int ftp = "chatroomLocalVersion".hashCode();
  private static final int ftq = "chatroomStatus".hashCode();
  private static final int ftr = "memberCount".hashCode();
  private static final int fts = "chatroomfamilystatusmodifytime".hashCode();
  private static final int ftt = "associateOpenIMRoomName".hashCode();
  private static final int ftu = "openIMRoomMigrateStatus".hashCode();
  private static final int ftv = "saveByteVersion".hashCode();
  private static final int ftw = "handleByteVersion".hashCode();
  private static final int ftx = "roomInfoDetailResByte".hashCode();
  private static final int fty = "oldChatroomVersion".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean fou = true;
  private boolean fsA = true;
  private boolean fsB = true;
  private boolean fsC = true;
  private boolean fsD = true;
  private boolean fsE = true;
  private boolean fsF = true;
  private boolean fsG = true;
  private boolean fsH = true;
  private boolean fsI = true;
  private boolean fsJ = true;
  private boolean fsK = true;
  private boolean fsL = true;
  private boolean fsM = true;
  private boolean fsN = true;
  private boolean fsO = true;
  private boolean fsP = true;
  private boolean fsQ = true;
  private boolean fsR = true;
  private boolean fsS = true;
  private boolean fsT = true;
  private boolean fsU = true;
  private boolean fsV = true;
  private boolean fsW = true;
  private boolean fsX = true;
  private boolean fsY = true;
  private boolean fsz = true;
  
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
      if (fsZ != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.fsz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fta == k) {
        this.field_addtime = paramCursor.getLong(i);
      } else if (ftb == k) {
        this.field_memberlist = paramCursor.getString(i);
      } else if (ftc == k) {
        this.field_displayname = paramCursor.getString(i);
      } else if (ftd == k) {
        this.field_chatroomnick = paramCursor.getString(i);
      } else if (foH == k) {
        this.field_roomflag = paramCursor.getInt(i);
      } else if (fte == k) {
        this.field_roomowner = paramCursor.getString(i);
      } else if (ftf == k) {
        this.field_roomdata = paramCursor.getBlob(i);
      } else if (ftg == k) {
        this.field_isShowname = paramCursor.getInt(i);
      } else if (fth == k) {
        this.field_selfDisplayName = paramCursor.getString(i);
      } else if (fti == k) {
        this.field_style = paramCursor.getInt(i);
      } else if (ftj == k) {
        this.field_chatroomdataflag = paramCursor.getInt(i);
      } else if (ftk == k) {
        this.field_modifytime = paramCursor.getLong(i);
      } else if (ftl == k) {
        this.field_chatroomnotice = paramCursor.getString(i);
      } else if (ftm == k) {
        this.field_chatroomVersion = paramCursor.getInt(i);
      } else if (ftn == k) {
        this.field_chatroomnoticeEditor = paramCursor.getString(i);
      } else if (fto == k) {
        this.field_chatroomnoticePublishTime = paramCursor.getLong(i);
      } else if (ftp == k) {
        this.field_chatroomLocalVersion = paramCursor.getLong(i);
      } else if (ftq == k) {
        this.field_chatroomStatus = paramCursor.getInt(i);
      } else if (ftr == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (fts == k) {
        this.field_chatroomfamilystatusmodifytime = paramCursor.getLong(i);
      } else if (ftt == k) {
        this.field_associateOpenIMRoomName = paramCursor.getString(i);
      } else if (ftu == k) {
        this.field_openIMRoomMigrateStatus = paramCursor.getInt(i);
      } else if (ftv == k) {
        this.field_saveByteVersion = paramCursor.getString(i);
      } else if (ftw == k) {
        this.field_handleByteVersion = paramCursor.getString(i);
      } else if (ftx == k) {
        this.field_roomInfoDetailResByte = paramCursor.getBlob(i);
      } else if (fty == k) {
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
    if (this.fsz) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.fsA) {
      localContentValues.put("addtime", Long.valueOf(this.field_addtime));
    }
    if (this.fsB) {
      localContentValues.put("memberlist", this.field_memberlist);
    }
    if (this.fsC) {
      localContentValues.put("displayname", this.field_displayname);
    }
    if (this.fsD) {
      localContentValues.put("chatroomnick", this.field_chatroomnick);
    }
    if (this.fou) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.fsE) {
      localContentValues.put("roomowner", this.field_roomowner);
    }
    if (this.fsF) {
      localContentValues.put("roomdata", this.field_roomdata);
    }
    if (this.fsG) {
      localContentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
    }
    if (this.fsH) {
      localContentValues.put("selfDisplayName", this.field_selfDisplayName);
    }
    if (this.fsI) {
      localContentValues.put("style", Integer.valueOf(this.field_style));
    }
    if (this.fsJ) {
      localContentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
    }
    if (this.fsK) {
      localContentValues.put("modifytime", Long.valueOf(this.field_modifytime));
    }
    if (this.fsL) {
      localContentValues.put("chatroomnotice", this.field_chatroomnotice);
    }
    if (this.fsM) {
      localContentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
    }
    if (this.fsN) {
      localContentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
    }
    if (this.fsO) {
      localContentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
    }
    if (this.fsP) {
      localContentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
    }
    if (this.fsQ) {
      localContentValues.put("chatroomStatus", Integer.valueOf(this.field_chatroomStatus));
    }
    if (this.fsR) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.fsS) {
      localContentValues.put("chatroomfamilystatusmodifytime", Long.valueOf(this.field_chatroomfamilystatusmodifytime));
    }
    if (this.fsT) {
      localContentValues.put("associateOpenIMRoomName", this.field_associateOpenIMRoomName);
    }
    if (this.fsU) {
      localContentValues.put("openIMRoomMigrateStatus", Integer.valueOf(this.field_openIMRoomMigrateStatus));
    }
    if (this.fsV) {
      localContentValues.put("saveByteVersion", this.field_saveByteVersion);
    }
    if (this.fsW) {
      localContentValues.put("handleByteVersion", this.field_handleByteVersion);
    }
    if (this.fsX) {
      localContentValues.put("roomInfoDetailResByte", this.field_roomInfoDetailResByte);
    }
    if (this.fsY) {
      localContentValues.put("oldChatroomVersion", Integer.valueOf(this.field_oldChatroomVersion));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.au
 * JD-Core Version:    0.7.0.1
 */
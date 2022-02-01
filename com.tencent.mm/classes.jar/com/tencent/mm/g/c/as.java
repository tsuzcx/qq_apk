package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class as
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int esj;
  private static final int ewA = "chatroomStatus".hashCode();
  private static final int ewB = "memberCount".hashCode();
  private static final int ewC = "chatroomfamilystatusmodifytime".hashCode();
  private static final int ewD = "associateOpenIMRoomName".hashCode();
  private static final int ewE = "openIMRoomMigrateStatus".hashCode();
  private static final int ewF = "saveByteVersion".hashCode();
  private static final int ewG = "handleByteVersion".hashCode();
  private static final int ewH = "roomInfoDetailResByte".hashCode();
  private static final int ewj = "chatroomname".hashCode();
  private static final int ewk = "addtime".hashCode();
  private static final int ewl = "memberlist".hashCode();
  private static final int ewm = "displayname".hashCode();
  private static final int ewn = "chatroomnick".hashCode();
  private static final int ewo;
  private static final int ewp;
  private static final int ewq;
  private static final int ewr;
  private static final int ews;
  private static final int ewt;
  private static final int ewu;
  private static final int ewv;
  private static final int eww;
  private static final int ewx;
  private static final int ewy;
  private static final int ewz;
  private static final int hFQ = "oldChatroomVersion".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean cJY = true;
  private boolean erW = true;
  private boolean evK = true;
  private boolean evL = true;
  private boolean evM = true;
  private boolean evN = true;
  private boolean evO = true;
  private boolean evP = true;
  private boolean evQ = true;
  private boolean evR = true;
  private boolean evS = true;
  private boolean evT = true;
  private boolean evU = true;
  private boolean evV = true;
  private boolean evW = true;
  private boolean evX = true;
  private boolean evY = true;
  private boolean evZ = true;
  private boolean ewa = true;
  private boolean ewb = true;
  private boolean ewc = true;
  private boolean ewd = true;
  private boolean ewe = true;
  private boolean ewf = true;
  private boolean ewg = true;
  private boolean ewh = true;
  private boolean ewi = true;
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
    esj = "roomflag".hashCode();
    ewo = "roomowner".hashCode();
    ewp = "roomdata".hashCode();
    ewq = "isShowname".hashCode();
    ewr = "selfDisplayName".hashCode();
    ews = "style".hashCode();
    ewt = "chatroomdataflag".hashCode();
    ewu = "modifytime".hashCode();
    ewv = "chatroomnotice".hashCode();
    eww = "chatroomVersion".hashCode();
    ewx = "chatroomnoticeEditor".hashCode();
    ewy = "chatroomnoticePublishTime".hashCode();
    ewz = "chatroomLocalVersion".hashCode();
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
      if (ewj != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.evK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ewk == k) {
        this.field_addtime = paramCursor.getLong(i);
      } else if (ewl == k) {
        this.field_memberlist = paramCursor.getString(i);
      } else if (ewm == k) {
        this.field_displayname = paramCursor.getString(i);
      } else if (ewn == k) {
        this.field_chatroomnick = paramCursor.getString(i);
      } else if (esj == k) {
        this.field_roomflag = paramCursor.getInt(i);
      } else if (ewo == k) {
        this.field_roomowner = paramCursor.getString(i);
      } else if (ewp == k) {
        this.field_roomdata = paramCursor.getBlob(i);
      } else if (ewq == k) {
        this.field_isShowname = paramCursor.getInt(i);
      } else if (ewr == k) {
        this.field_selfDisplayName = paramCursor.getString(i);
      } else if (ews == k) {
        this.field_style = paramCursor.getInt(i);
      } else if (ewt == k) {
        this.field_chatroomdataflag = paramCursor.getInt(i);
      } else if (ewu == k) {
        this.field_modifytime = paramCursor.getLong(i);
      } else if (ewv == k) {
        this.field_chatroomnotice = paramCursor.getString(i);
      } else if (eww == k) {
        this.field_chatroomVersion = paramCursor.getInt(i);
      } else if (ewx == k) {
        this.field_chatroomnoticeEditor = paramCursor.getString(i);
      } else if (ewy == k) {
        this.field_chatroomnoticePublishTime = paramCursor.getLong(i);
      } else if (ewz == k) {
        this.field_chatroomLocalVersion = paramCursor.getLong(i);
      } else if (ewA == k) {
        this.field_chatroomStatus = paramCursor.getInt(i);
      } else if (ewB == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (ewC == k) {
        this.field_chatroomfamilystatusmodifytime = paramCursor.getLong(i);
      } else if (ewD == k) {
        this.field_associateOpenIMRoomName = paramCursor.getString(i);
      } else if (ewE == k) {
        this.field_openIMRoomMigrateStatus = paramCursor.getInt(i);
      } else if (ewF == k) {
        this.field_saveByteVersion = paramCursor.getString(i);
      } else if (ewG == k) {
        this.field_handleByteVersion = paramCursor.getString(i);
      } else if (ewH == k) {
        this.field_roomInfoDetailResByte = paramCursor.getBlob(i);
      } else if (hFQ == k) {
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
    if (this.evK) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.evL) {
      localContentValues.put("addtime", Long.valueOf(this.field_addtime));
    }
    if (this.evM) {
      localContentValues.put("memberlist", this.field_memberlist);
    }
    if (this.evN) {
      localContentValues.put("displayname", this.field_displayname);
    }
    if (this.evO) {
      localContentValues.put("chatroomnick", this.field_chatroomnick);
    }
    if (this.erW) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.evP) {
      localContentValues.put("roomowner", this.field_roomowner);
    }
    if (this.evQ) {
      localContentValues.put("roomdata", this.field_roomdata);
    }
    if (this.evR) {
      localContentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
    }
    if (this.evS) {
      localContentValues.put("selfDisplayName", this.field_selfDisplayName);
    }
    if (this.evT) {
      localContentValues.put("style", Integer.valueOf(this.field_style));
    }
    if (this.evU) {
      localContentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
    }
    if (this.evV) {
      localContentValues.put("modifytime", Long.valueOf(this.field_modifytime));
    }
    if (this.evW) {
      localContentValues.put("chatroomnotice", this.field_chatroomnotice);
    }
    if (this.evX) {
      localContentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
    }
    if (this.evY) {
      localContentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
    }
    if (this.evZ) {
      localContentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
    }
    if (this.ewa) {
      localContentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
    }
    if (this.ewb) {
      localContentValues.put("chatroomStatus", Integer.valueOf(this.field_chatroomStatus));
    }
    if (this.ewc) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.ewd) {
      localContentValues.put("chatroomfamilystatusmodifytime", Long.valueOf(this.field_chatroomfamilystatusmodifytime));
    }
    if (this.ewe) {
      localContentValues.put("associateOpenIMRoomName", this.field_associateOpenIMRoomName);
    }
    if (this.ewf) {
      localContentValues.put("openIMRoomMigrateStatus", Integer.valueOf(this.field_openIMRoomMigrateStatus));
    }
    if (this.ewg) {
      localContentValues.put("saveByteVersion", this.field_saveByteVersion);
    }
    if (this.ewh) {
      localContentValues.put("handleByteVersion", this.field_handleByteVersion);
    }
    if (this.ewi) {
      localContentValues.put("roomInfoDetailResByte", this.field_roomInfoDetailResByte);
    }
    if (this.cJY) {
      localContentValues.put("oldChatroomVersion", Integer.valueOf(this.field_oldChatroomVersion));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.as
 * JD-Core Version:    0.7.0.1
 */
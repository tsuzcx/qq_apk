package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class as
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eqf = "roomflag".hashCode();
  private static final int eua = "chatroomname".hashCode();
  private static final int eub = "addtime".hashCode();
  private static final int euc = "memberlist".hashCode();
  private static final int eud = "displayname".hashCode();
  private static final int eue = "chatroomnick".hashCode();
  private static final int euf = "roomowner".hashCode();
  private static final int eug = "roomdata".hashCode();
  private static final int euh = "isShowname".hashCode();
  private static final int eui = "selfDisplayName".hashCode();
  private static final int euj = "style".hashCode();
  private static final int euk = "chatroomdataflag".hashCode();
  private static final int eul = "modifytime".hashCode();
  private static final int eum = "chatroomnotice".hashCode();
  private static final int eun = "chatroomVersion".hashCode();
  private static final int euo = "chatroomnoticeEditor".hashCode();
  private static final int eup = "chatroomnoticePublishTime".hashCode();
  private static final int euq = "chatroomLocalVersion".hashCode();
  private static final int eur = "chatroomStatus".hashCode();
  private static final int eus = "memberCount".hashCode();
  private static final int eut = "chatroomfamilystatusmodifytime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean epS = true;
  private boolean etG = true;
  private boolean etH = true;
  private boolean etI = true;
  private boolean etJ = true;
  private boolean etK = true;
  private boolean etL = true;
  private boolean etM = true;
  private boolean etN = true;
  private boolean etO = true;
  private boolean etP = true;
  private boolean etQ = true;
  private boolean etR = true;
  private boolean etS = true;
  private boolean etT = true;
  private boolean etU = true;
  private boolean etV = true;
  private boolean etW = true;
  private boolean etX = true;
  private boolean etY = true;
  private boolean etZ = true;
  public long field_addtime;
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
  public int field_isShowname;
  public int field_memberCount;
  public String field_memberlist;
  public long field_modifytime;
  public byte[] field_roomdata;
  public int field_roomflag;
  public String field_roomowner;
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
      if (eua != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.etG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eub == k) {
        this.field_addtime = paramCursor.getLong(i);
      } else if (euc == k) {
        this.field_memberlist = paramCursor.getString(i);
      } else if (eud == k) {
        this.field_displayname = paramCursor.getString(i);
      } else if (eue == k) {
        this.field_chatroomnick = paramCursor.getString(i);
      } else if (eqf == k) {
        this.field_roomflag = paramCursor.getInt(i);
      } else if (euf == k) {
        this.field_roomowner = paramCursor.getString(i);
      } else if (eug == k) {
        this.field_roomdata = paramCursor.getBlob(i);
      } else if (euh == k) {
        this.field_isShowname = paramCursor.getInt(i);
      } else if (eui == k) {
        this.field_selfDisplayName = paramCursor.getString(i);
      } else if (euj == k) {
        this.field_style = paramCursor.getInt(i);
      } else if (euk == k) {
        this.field_chatroomdataflag = paramCursor.getInt(i);
      } else if (eul == k) {
        this.field_modifytime = paramCursor.getLong(i);
      } else if (eum == k) {
        this.field_chatroomnotice = paramCursor.getString(i);
      } else if (eun == k) {
        this.field_chatroomVersion = paramCursor.getInt(i);
      } else if (euo == k) {
        this.field_chatroomnoticeEditor = paramCursor.getString(i);
      } else if (eup == k) {
        this.field_chatroomnoticePublishTime = paramCursor.getLong(i);
      } else if (euq == k) {
        this.field_chatroomLocalVersion = paramCursor.getLong(i);
      } else if (eur == k) {
        this.field_chatroomStatus = paramCursor.getInt(i);
      } else if (eus == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (eut == k) {
        this.field_chatroomfamilystatusmodifytime = paramCursor.getLong(i);
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
    if (this.etG) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.etH) {
      localContentValues.put("addtime", Long.valueOf(this.field_addtime));
    }
    if (this.etI) {
      localContentValues.put("memberlist", this.field_memberlist);
    }
    if (this.etJ) {
      localContentValues.put("displayname", this.field_displayname);
    }
    if (this.etK) {
      localContentValues.put("chatroomnick", this.field_chatroomnick);
    }
    if (this.epS) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.etL) {
      localContentValues.put("roomowner", this.field_roomowner);
    }
    if (this.etM) {
      localContentValues.put("roomdata", this.field_roomdata);
    }
    if (this.etN) {
      localContentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
    }
    if (this.etO) {
      localContentValues.put("selfDisplayName", this.field_selfDisplayName);
    }
    if (this.etP) {
      localContentValues.put("style", Integer.valueOf(this.field_style));
    }
    if (this.etQ) {
      localContentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
    }
    if (this.etR) {
      localContentValues.put("modifytime", Long.valueOf(this.field_modifytime));
    }
    if (this.etS) {
      localContentValues.put("chatroomnotice", this.field_chatroomnotice);
    }
    if (this.etT) {
      localContentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
    }
    if (this.etU) {
      localContentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
    }
    if (this.etV) {
      localContentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
    }
    if (this.etW) {
      localContentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
    }
    if (this.etX) {
      localContentValues.put("chatroomStatus", Integer.valueOf(this.field_chatroomStatus));
    }
    if (this.etY) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.etZ) {
      localContentValues.put("chatroomfamilystatusmodifytime", Long.valueOf(this.field_chatroomfamilystatusmodifytime));
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
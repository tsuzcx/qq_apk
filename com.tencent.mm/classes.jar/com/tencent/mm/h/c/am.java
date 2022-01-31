package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class am
  extends c
{
  private static final int cBf = "chatroomname".hashCode();
  private static final int cBg = "addtime".hashCode();
  private static final int cBh = "memberlist".hashCode();
  private static final int cBi = "displayname".hashCode();
  private static final int cBj = "chatroomnick".hashCode();
  private static final int cBk = "roomflag".hashCode();
  private static final int cBl = "roomowner".hashCode();
  private static final int cBm = "roomdata".hashCode();
  private static final int cBn = "isShowname".hashCode();
  private static final int cBo = "selfDisplayName".hashCode();
  private static final int cBp = "style".hashCode();
  private static final int cBq = "chatroomdataflag".hashCode();
  private static final int cBr = "modifytime".hashCode();
  private static final int cBs = "chatroomnotice".hashCode();
  private static final int cBt = "chatroomVersion".hashCode();
  private static final int cBu = "chatroomnoticeEditor".hashCode();
  private static final int cBv = "chatroomnoticePublishTime".hashCode();
  private static final int cBw = "chatroomLocalVersion".hashCode();
  private static final int cBx = "chatroomStatus".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cAM = true;
  private boolean cAN = true;
  private boolean cAO = true;
  private boolean cAP = true;
  private boolean cAQ = true;
  private boolean cAR = true;
  private boolean cAS = true;
  private boolean cAT = true;
  private boolean cAU = true;
  private boolean cAV = true;
  private boolean cAW = true;
  private boolean cAX = true;
  private boolean cAY = true;
  private boolean cAZ = true;
  private boolean cBa = true;
  private boolean cBb = true;
  private boolean cBc = true;
  private boolean cBd = true;
  private boolean cBe = true;
  public long field_addtime;
  public long field_chatroomLocalVersion;
  public int field_chatroomStatus;
  public int field_chatroomVersion;
  public int field_chatroomdataflag;
  public String field_chatroomname;
  public String field_chatroomnick;
  public String field_chatroomnotice;
  public String field_chatroomnoticeEditor;
  public long field_chatroomnoticePublishTime;
  public String field_displayname;
  public int field_isShowname;
  public String field_memberlist;
  public long field_modifytime;
  public byte[] field_roomdata;
  public int field_roomflag;
  public String field_roomowner;
  public String field_selfDisplayName;
  public int field_style;
  
  public final void d(Cursor paramCursor)
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
      if (cBf != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.cAM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cBg == k) {
        this.field_addtime = paramCursor.getLong(i);
      } else if (cBh == k) {
        this.field_memberlist = paramCursor.getString(i);
      } else if (cBi == k) {
        this.field_displayname = paramCursor.getString(i);
      } else if (cBj == k) {
        this.field_chatroomnick = paramCursor.getString(i);
      } else if (cBk == k) {
        this.field_roomflag = paramCursor.getInt(i);
      } else if (cBl == k) {
        this.field_roomowner = paramCursor.getString(i);
      } else if (cBm == k) {
        this.field_roomdata = paramCursor.getBlob(i);
      } else if (cBn == k) {
        this.field_isShowname = paramCursor.getInt(i);
      } else if (cBo == k) {
        this.field_selfDisplayName = paramCursor.getString(i);
      } else if (cBp == k) {
        this.field_style = paramCursor.getInt(i);
      } else if (cBq == k) {
        this.field_chatroomdataflag = paramCursor.getInt(i);
      } else if (cBr == k) {
        this.field_modifytime = paramCursor.getLong(i);
      } else if (cBs == k) {
        this.field_chatroomnotice = paramCursor.getString(i);
      } else if (cBt == k) {
        this.field_chatroomVersion = paramCursor.getInt(i);
      } else if (cBu == k) {
        this.field_chatroomnoticeEditor = paramCursor.getString(i);
      } else if (cBv == k) {
        this.field_chatroomnoticePublishTime = paramCursor.getLong(i);
      } else if (cBw == k) {
        this.field_chatroomLocalVersion = paramCursor.getLong(i);
      } else if (cBx == k) {
        this.field_chatroomStatus = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_chatroomname == null) {
      this.field_chatroomname = "";
    }
    if (this.cAM) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.cAN) {
      localContentValues.put("addtime", Long.valueOf(this.field_addtime));
    }
    if (this.cAO) {
      localContentValues.put("memberlist", this.field_memberlist);
    }
    if (this.cAP) {
      localContentValues.put("displayname", this.field_displayname);
    }
    if (this.cAQ) {
      localContentValues.put("chatroomnick", this.field_chatroomnick);
    }
    if (this.cAR) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.cAS) {
      localContentValues.put("roomowner", this.field_roomowner);
    }
    if (this.cAT) {
      localContentValues.put("roomdata", this.field_roomdata);
    }
    if (this.cAU) {
      localContentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
    }
    if (this.cAV) {
      localContentValues.put("selfDisplayName", this.field_selfDisplayName);
    }
    if (this.cAW) {
      localContentValues.put("style", Integer.valueOf(this.field_style));
    }
    if (this.cAX) {
      localContentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
    }
    if (this.cAY) {
      localContentValues.put("modifytime", Long.valueOf(this.field_modifytime));
    }
    if (this.cAZ) {
      localContentValues.put("chatroomnotice", this.field_chatroomnotice);
    }
    if (this.cBa) {
      localContentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
    }
    if (this.cBb) {
      localContentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
    }
    if (this.cBc) {
      localContentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
    }
    if (this.cBd) {
      localContentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
    }
    if (this.cBe) {
      localContentValues.put("chatroomStatus", Integer.valueOf(this.field_chatroomStatus));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.am
 * JD-Core Version:    0.7.0.1
 */
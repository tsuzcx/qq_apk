package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class an
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dpA = "chatroomLocalVersion".hashCode();
  private static final int dpB = "chatroomStatus".hashCode();
  private static final int dpC = "memberCount".hashCode();
  private static final int dpj = "chatroomname".hashCode();
  private static final int dpk = "addtime".hashCode();
  private static final int dpl = "memberlist".hashCode();
  private static final int dpm = "displayname".hashCode();
  private static final int dpn = "chatroomnick".hashCode();
  private static final int dpo = "roomflag".hashCode();
  private static final int dpp = "roomowner".hashCode();
  private static final int dpq = "roomdata".hashCode();
  private static final int dpr = "isShowname".hashCode();
  private static final int dps = "selfDisplayName".hashCode();
  private static final int dpt = "style".hashCode();
  private static final int dpu = "chatroomdataflag".hashCode();
  private static final int dpv = "modifytime".hashCode();
  private static final int dpw = "chatroomnotice".hashCode();
  private static final int dpx = "chatroomVersion".hashCode();
  private static final int dpy = "chatroomnoticeEditor".hashCode();
  private static final int dpz = "chatroomnoticePublishTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean doP = true;
  private boolean doQ = true;
  private boolean doR = true;
  private boolean doS = true;
  private boolean doT = true;
  private boolean doU = true;
  private boolean doV = true;
  private boolean doW = true;
  private boolean doX = true;
  private boolean doY = true;
  private boolean doZ = true;
  private boolean dpa = true;
  private boolean dpb = true;
  private boolean dpc = true;
  private boolean dpd = true;
  private boolean dpe = true;
  private boolean dpf = true;
  private boolean dpg = true;
  private boolean dph = true;
  private boolean dpi = true;
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
      if (dpj != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.doP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dpk == k) {
        this.field_addtime = paramCursor.getLong(i);
      } else if (dpl == k) {
        this.field_memberlist = paramCursor.getString(i);
      } else if (dpm == k) {
        this.field_displayname = paramCursor.getString(i);
      } else if (dpn == k) {
        this.field_chatroomnick = paramCursor.getString(i);
      } else if (dpo == k) {
        this.field_roomflag = paramCursor.getInt(i);
      } else if (dpp == k) {
        this.field_roomowner = paramCursor.getString(i);
      } else if (dpq == k) {
        this.field_roomdata = paramCursor.getBlob(i);
      } else if (dpr == k) {
        this.field_isShowname = paramCursor.getInt(i);
      } else if (dps == k) {
        this.field_selfDisplayName = paramCursor.getString(i);
      } else if (dpt == k) {
        this.field_style = paramCursor.getInt(i);
      } else if (dpu == k) {
        this.field_chatroomdataflag = paramCursor.getInt(i);
      } else if (dpv == k) {
        this.field_modifytime = paramCursor.getLong(i);
      } else if (dpw == k) {
        this.field_chatroomnotice = paramCursor.getString(i);
      } else if (dpx == k) {
        this.field_chatroomVersion = paramCursor.getInt(i);
      } else if (dpy == k) {
        this.field_chatroomnoticeEditor = paramCursor.getString(i);
      } else if (dpz == k) {
        this.field_chatroomnoticePublishTime = paramCursor.getLong(i);
      } else if (dpA == k) {
        this.field_chatroomLocalVersion = paramCursor.getLong(i);
      } else if (dpB == k) {
        this.field_chatroomStatus = paramCursor.getInt(i);
      } else if (dpC == k) {
        this.field_memberCount = paramCursor.getInt(i);
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
    if (this.doP) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.doQ) {
      localContentValues.put("addtime", Long.valueOf(this.field_addtime));
    }
    if (this.doR) {
      localContentValues.put("memberlist", this.field_memberlist);
    }
    if (this.doS) {
      localContentValues.put("displayname", this.field_displayname);
    }
    if (this.doT) {
      localContentValues.put("chatroomnick", this.field_chatroomnick);
    }
    if (this.doU) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.doV) {
      localContentValues.put("roomowner", this.field_roomowner);
    }
    if (this.doW) {
      localContentValues.put("roomdata", this.field_roomdata);
    }
    if (this.doX) {
      localContentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
    }
    if (this.doY) {
      localContentValues.put("selfDisplayName", this.field_selfDisplayName);
    }
    if (this.doZ) {
      localContentValues.put("style", Integer.valueOf(this.field_style));
    }
    if (this.dpa) {
      localContentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
    }
    if (this.dpb) {
      localContentValues.put("modifytime", Long.valueOf(this.field_modifytime));
    }
    if (this.dpc) {
      localContentValues.put("chatroomnotice", this.field_chatroomnotice);
    }
    if (this.dpd) {
      localContentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
    }
    if (this.dpe) {
      localContentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
    }
    if (this.dpf) {
      localContentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
    }
    if (this.dpg) {
      localContentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
    }
    if (this.dph) {
      localContentValues.put("chatroomStatus", Integer.valueOf(this.field_chatroomStatus));
    }
    if (this.dpi) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.an
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class de
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dHi = "wxGroupId".hashCode();
  private static final int dHj;
  private static final int dHk;
  private static final int dHl;
  private static final int dHm;
  private static final int dgM = "createTime".hashCode();
  private static final int dpC;
  private static final int dub = "state".hashCode();
  private static final int dui = "groupId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dHd = true;
  private boolean dHe = true;
  private boolean dHf = true;
  private boolean dHg = true;
  private boolean dHh = true;
  private boolean dgp = true;
  private boolean dpi = true;
  private boolean dto = true;
  private boolean dtw = true;
  public long field_createTime;
  public String field_groupId;
  public String field_inviteUserName;
  public int field_memberCount;
  public int field_roomId;
  public long field_roomKey;
  public int field_routeId;
  public int field_state;
  public String field_wxGroupId;
  
  static
  {
    dHj = "roomId".hashCode();
    dHk = "roomKey".hashCode();
    dHl = "routeId".hashCode();
    dHm = "inviteUserName".hashCode();
    dpC = "memberCount".hashCode();
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
      if (dHi != k) {
        break label65;
      }
      this.field_wxGroupId = paramCursor.getString(i);
      this.dHd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dui == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (dHj == k) {
        this.field_roomId = paramCursor.getInt(i);
      } else if (dHk == k) {
        this.field_roomKey = paramCursor.getLong(i);
      } else if (dHl == k) {
        this.field_routeId = paramCursor.getInt(i);
      } else if (dHm == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (dpC == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (dgM == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (dub == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dHd) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.dtw) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.dHe) {
      localContentValues.put("roomId", Integer.valueOf(this.field_roomId));
    }
    if (this.dHf) {
      localContentValues.put("roomKey", Long.valueOf(this.field_roomKey));
    }
    if (this.dHg) {
      localContentValues.put("routeId", Integer.valueOf(this.field_routeId));
    }
    if (this.dHh) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.dpi) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.dto) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.de
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ePr = "wxGroupId".hashCode();
  private static final int ePs;
  private static final int ePt;
  private static final int ePu;
  private static final int ePv;
  private static final int ekU = "createTime".hashCode();
  private static final int eus;
  private static final int ezb = "state".hashCode();
  private static final int ezi = "groupId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ePm = true;
  private boolean ePn = true;
  private boolean ePo = true;
  private boolean ePp = true;
  private boolean ePq = true;
  private boolean ekx = true;
  private boolean etY = true;
  private boolean eyp = true;
  private boolean eyw = true;
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
    ePs = "roomId".hashCode();
    ePt = "roomKey".hashCode();
    ePu = "routeId".hashCode();
    ePv = "inviteUserName".hashCode();
    eus = "memberCount".hashCode();
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
      if (ePr != k) {
        break label65;
      }
      this.field_wxGroupId = paramCursor.getString(i);
      this.ePm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ezi == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (ePs == k) {
        this.field_roomId = paramCursor.getInt(i);
      } else if (ePt == k) {
        this.field_roomKey = paramCursor.getLong(i);
      } else if (ePu == k) {
        this.field_routeId = paramCursor.getInt(i);
      } else if (ePv == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (eus == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (ekU == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (ezb == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ePm) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.eyw) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.ePn) {
      localContentValues.put("roomId", Integer.valueOf(this.field_roomId));
    }
    if (this.ePo) {
      localContentValues.put("roomKey", Long.valueOf(this.field_roomKey));
    }
    if (this.ePp) {
      localContentValues.put("routeId", Integer.valueOf(this.field_routeId));
    }
    if (this.ePq) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.etY) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eyp) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dw
 * JD-Core Version:    0.7.0.1
 */
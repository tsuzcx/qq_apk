package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ea
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBC;
  private static final int eBv = "state".hashCode();
  private static final int eSA;
  private static final int eSB;
  private static final int eSC;
  private static final int eSD;
  private static final int eSz = "wxGroupId".hashCode();
  private static final int emY;
  private static final int ewB;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAJ = true;
  private boolean eAQ = true;
  private boolean eSu = true;
  private boolean eSv = true;
  private boolean eSw = true;
  private boolean eSx = true;
  private boolean eSy = true;
  private boolean emB = true;
  private boolean ewc = true;
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
    eBC = "groupId".hashCode();
    eSA = "roomId".hashCode();
    eSB = "roomKey".hashCode();
    eSC = "routeId".hashCode();
    eSD = "inviteUserName".hashCode();
    ewB = "memberCount".hashCode();
    emY = "createTime".hashCode();
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
      if (eSz != k) {
        break label65;
      }
      this.field_wxGroupId = paramCursor.getString(i);
      this.eSu = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eBC == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (eSA == k) {
        this.field_roomId = paramCursor.getInt(i);
      } else if (eSB == k) {
        this.field_roomKey = paramCursor.getLong(i);
      } else if (eSC == k) {
        this.field_routeId = paramCursor.getInt(i);
      } else if (eSD == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (ewB == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (emY == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eBv == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eSu) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.eAQ) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.eSv) {
      localContentValues.put("roomId", Integer.valueOf(this.field_roomId));
    }
    if (this.eSw) {
      localContentValues.put("roomKey", Long.valueOf(this.field_roomKey));
    }
    if (this.eSx) {
      localContentValues.put("routeId", Integer.valueOf(this.field_routeId));
    }
    if (this.eSy) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.ewc) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eAJ) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ea
 * JD-Core Version:    0.7.0.1
 */
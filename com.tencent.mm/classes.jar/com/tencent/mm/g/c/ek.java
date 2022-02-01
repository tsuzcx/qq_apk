package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ek
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFO = "createTime".hashCode();
  private static final int ePK;
  private static final int eUE = "state".hashCode();
  private static final int eUL;
  private static final int fmN = "wxGroupId".hashCode();
  private static final int fmO;
  private static final int fmP;
  private static final int fmQ;
  private static final int fmR;
  private static final int fmS = "ilinkRoomId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFr = true;
  private boolean ePk = true;
  private boolean eTS = true;
  private boolean eTZ = true;
  public long field_createTime;
  public String field_groupId;
  public long field_ilinkRoomId;
  public String field_inviteUserName;
  public int field_memberCount;
  public int field_roomId;
  public long field_roomKey;
  public int field_routeId;
  public int field_state;
  public String field_wxGroupId;
  private boolean fmH = true;
  private boolean fmI = true;
  private boolean fmJ = true;
  private boolean fmK = true;
  private boolean fmL = true;
  private boolean fmM = true;
  
  static
  {
    eUL = "groupId".hashCode();
    fmO = "roomId".hashCode();
    fmP = "roomKey".hashCode();
    fmQ = "routeId".hashCode();
    fmR = "inviteUserName".hashCode();
    ePK = "memberCount".hashCode();
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
      if (fmN != k) {
        break label65;
      }
      this.field_wxGroupId = paramCursor.getString(i);
      this.fmH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eUL == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (fmO == k) {
        this.field_roomId = paramCursor.getInt(i);
      } else if (fmP == k) {
        this.field_roomKey = paramCursor.getLong(i);
      } else if (fmQ == k) {
        this.field_routeId = paramCursor.getInt(i);
      } else if (fmR == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (ePK == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (eFO == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eUE == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (fmS == k) {
        this.field_ilinkRoomId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fmH) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.eTZ) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.fmI) {
      localContentValues.put("roomId", Integer.valueOf(this.field_roomId));
    }
    if (this.fmJ) {
      localContentValues.put("roomKey", Long.valueOf(this.field_roomKey));
    }
    if (this.fmK) {
      localContentValues.put("routeId", Integer.valueOf(this.field_routeId));
    }
    if (this.fmL) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.ePk) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eTS) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.fmM) {
      localContentValues.put("ilinkRoomId", Long.valueOf(this.field_ilinkRoomId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ek
 * JD-Core Version:    0.7.0.1
 */
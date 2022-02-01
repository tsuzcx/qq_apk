package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class eq
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE;
  private static final int fRr = "wxGroupId".hashCode();
  private static final int fRs;
  private static final int fRt;
  private static final int fRu;
  private static final int fRv;
  private static final int fRw = "ilinkRoomId".hashCode();
  private static final int ftr;
  private static final int fyj;
  private static final int fyq = "groupId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean fRl = true;
  private boolean fRm = true;
  private boolean fRn = true;
  private boolean fRo = true;
  private boolean fRp = true;
  private boolean fRq = true;
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
  private boolean fsR = true;
  private boolean fxE = true;
  private boolean fxx = true;
  
  static
  {
    fRs = "roomId".hashCode();
    fRt = "roomKey".hashCode();
    fRu = "routeId".hashCode();
    fRv = "inviteUserName".hashCode();
    ftr = "memberCount".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    fyj = "state".hashCode();
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
      if (fRr != k) {
        break label65;
      }
      this.field_wxGroupId = paramCursor.getString(i);
      this.fRl = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fyq == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (fRs == k) {
        this.field_roomId = paramCursor.getInt(i);
      } else if (fRt == k) {
        this.field_roomKey = paramCursor.getLong(i);
      } else if (fRu == k) {
        this.field_routeId = paramCursor.getInt(i);
      } else if (fRv == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (ftr == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (fyj == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (fRw == k) {
        this.field_ilinkRoomId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fRl) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.fxE) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.fRm) {
      localContentValues.put("roomId", Integer.valueOf(this.field_roomId));
    }
    if (this.fRn) {
      localContentValues.put("roomKey", Long.valueOf(this.field_roomKey));
    }
    if (this.fRo) {
      localContentValues.put("routeId", Integer.valueOf(this.field_routeId));
    }
    if (this.fRp) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.fsR) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fxx) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.fRq) {
      localContentValues.put("ilinkRoomId", Long.valueOf(this.field_ilinkRoomId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.eq
 * JD-Core Version:    0.7.0.1
 */
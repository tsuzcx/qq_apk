package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ek
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEf = "createTime".hashCode();
  private static final int eNZ;
  private static final int eST = "state".hashCode();
  private static final int eTa;
  private static final int fkO = "wxGroupId".hashCode();
  private static final int fkP;
  private static final int fkQ;
  private static final int fkR;
  private static final int fkS;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDI = true;
  private boolean eNz = true;
  private boolean eSh = true;
  private boolean eSo = true;
  public long field_createTime;
  public String field_groupId;
  public String field_inviteUserName;
  public int field_memberCount;
  public int field_roomId;
  public long field_roomKey;
  public int field_routeId;
  public int field_state;
  public String field_wxGroupId;
  private boolean fkJ = true;
  private boolean fkK = true;
  private boolean fkL = true;
  private boolean fkM = true;
  private boolean fkN = true;
  
  static
  {
    eTa = "groupId".hashCode();
    fkP = "roomId".hashCode();
    fkQ = "roomKey".hashCode();
    fkR = "routeId".hashCode();
    fkS = "inviteUserName".hashCode();
    eNZ = "memberCount".hashCode();
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
      if (fkO != k) {
        break label65;
      }
      this.field_wxGroupId = paramCursor.getString(i);
      this.fkJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eTa == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (fkP == k) {
        this.field_roomId = paramCursor.getInt(i);
      } else if (fkQ == k) {
        this.field_roomKey = paramCursor.getLong(i);
      } else if (fkR == k) {
        this.field_routeId = paramCursor.getInt(i);
      } else if (fkS == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (eNZ == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (eEf == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eST == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkJ) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.eSo) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.fkK) {
      localContentValues.put("roomId", Integer.valueOf(this.field_roomId));
    }
    if (this.fkL) {
      localContentValues.put("roomKey", Long.valueOf(this.field_roomKey));
    }
    if (this.fkM) {
      localContentValues.put("routeId", Integer.valueOf(this.field_routeId));
    }
    if (this.fkN) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.eNz) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eSh) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
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
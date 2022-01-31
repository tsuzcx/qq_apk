package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ct
  extends c
{
  private static final int cFG = "state".hashCode();
  private static final int cFN;
  private static final int cQX;
  private static final int cQY;
  private static final int cQZ;
  private static final int cRa;
  private static final int cRb;
  private static final int cRc;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private boolean cFd = true;
  private boolean cFk = true;
  private boolean cQR = true;
  private boolean cQS = true;
  private boolean cQT = true;
  private boolean cQU = true;
  private boolean cQV = true;
  private boolean cQW = true;
  private boolean crX = true;
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
    cQX = "wxGroupId".hashCode();
    cFN = "groupId".hashCode();
    cQY = "roomId".hashCode();
    cQZ = "roomKey".hashCode();
    cRa = "routeId".hashCode();
    cRb = "inviteUserName".hashCode();
    cRc = "memberCount".hashCode();
    csv = "createTime".hashCode();
  }
  
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
      if (cQX != k) {
        break label65;
      }
      this.field_wxGroupId = paramCursor.getString(i);
      this.cQR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cFN == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (cQY == k) {
        this.field_roomId = paramCursor.getInt(i);
      } else if (cQZ == k) {
        this.field_roomKey = paramCursor.getLong(i);
      } else if (cRa == k) {
        this.field_routeId = paramCursor.getInt(i);
      } else if (cRb == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (cRc == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (csv == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (cFG == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cQR) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.cFk) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.cQS) {
      localContentValues.put("roomId", Integer.valueOf(this.field_roomId));
    }
    if (this.cQT) {
      localContentValues.put("roomKey", Long.valueOf(this.field_roomKey));
    }
    if (this.cQU) {
      localContentValues.put("routeId", Integer.valueOf(this.field_routeId));
    }
    if (this.cQV) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.cQW) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.cFd) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.ct
 * JD-Core Version:    0.7.0.1
 */
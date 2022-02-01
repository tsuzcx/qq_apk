package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ev
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("MultiTalkInfo");
  private static final int createTime_HASHCODE = "createTime".hashCode();
  public static final Column hAp;
  private static final int hBr;
  public static final Column hHa;
  public static final Column hHh;
  private static final int hIC = "state".hashCode();
  private static final int hIJ;
  public static final Column ilG;
  public static final Column ilH;
  public static final Column ilI;
  public static final Column ilJ;
  public static final Column ilK;
  public static final Column ilL;
  private static final int ilS;
  private static final int ilT;
  private static final int ilU;
  private static final int ilV;
  private static final int ilW;
  private static final int ilX = "ilinkRoomId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
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
  private boolean hAQ = true;
  private boolean hHO = true;
  private boolean hHV = true;
  private boolean ilM = true;
  private boolean ilN = true;
  private boolean ilO = true;
  private boolean ilP = true;
  private boolean ilQ = true;
  private boolean ilR = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "MultiTalkInfo", "");
    ilG = new Column("wxgroupid", "string", "MultiTalkInfo", "");
    hHh = new Column("groupid", "string", "MultiTalkInfo", "");
    ilH = new Column("roomid", "int", "MultiTalkInfo", "");
    ilI = new Column("roomkey", "long", "MultiTalkInfo", "");
    ilJ = new Column("routeid", "int", "MultiTalkInfo", "");
    ilK = new Column("inviteusername", "string", "MultiTalkInfo", "");
    hAp = new Column("membercount", "int", "MultiTalkInfo", "");
    C_CREATETIME = new Column("createtime", "long", "MultiTalkInfo", "");
    hHa = new Column("state", "int", "MultiTalkInfo", "");
    ilL = new Column("ilinkroomid", "long", "MultiTalkInfo", "");
    ilS = "wxGroupId".hashCode();
    hIJ = "groupId".hashCode();
    ilT = "roomId".hashCode();
    ilU = "roomKey".hashCode();
    ilV = "routeId".hashCode();
    ilW = "inviteUserName".hashCode();
    hBr = "memberCount".hashCode();
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
      if (ilS != k) {
        break label65;
      }
      this.field_wxGroupId = paramCursor.getString(i);
      this.ilM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hIJ == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (ilT == k) {
        this.field_roomId = paramCursor.getInt(i);
      } else if (ilU == k) {
        this.field_roomKey = paramCursor.getLong(i);
      } else if (ilV == k) {
        this.field_routeId = paramCursor.getInt(i);
      } else if (ilW == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (hBr == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (hIC == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (ilX == k) {
        this.field_ilinkRoomId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ilM) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.hHV) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.ilN) {
      localContentValues.put("roomId", Integer.valueOf(this.field_roomId));
    }
    if (this.ilO) {
      localContentValues.put("roomKey", Long.valueOf(this.field_roomKey));
    }
    if (this.ilP) {
      localContentValues.put("routeId", Integer.valueOf(this.field_routeId));
    }
    if (this.ilQ) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.hAQ) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.hHO) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.ilR) {
      localContentValues.put("ilinkRoomId", Long.valueOf(this.field_ilinkRoomId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "MultiTalkInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.ev
 * JD-Core Version:    0.7.0.1
 */
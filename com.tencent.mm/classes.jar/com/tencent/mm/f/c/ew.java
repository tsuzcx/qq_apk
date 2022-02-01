package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ew
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("MultiTalkMember");
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int hmC;
  public static final Column hmw;
  public static final Column ilG;
  public static final Column ilK;
  private static final int ilS;
  private static final int ilW;
  public static final Column ilY;
  public static final Column ilZ;
  private static final int imc;
  private static final int imd;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int userName_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetuserName = true;
  public long field_createTime;
  public String field_inviteUserName;
  public long field_memberId;
  public long field_memberUuid;
  public int field_status;
  public String field_userName;
  public String field_wxGroupId;
  private boolean hmz = true;
  private boolean ilM = true;
  private boolean ilQ = true;
  private boolean ima = true;
  private boolean imb = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "MultiTalkMember", "");
    ilY = new Column("memberuuid", "long", "MultiTalkMember", "");
    ilG = new Column("wxgroupid", "string", "MultiTalkMember", "");
    C_USERNAME = new Column("username", "string", "MultiTalkMember", "");
    ilK = new Column("inviteusername", "string", "MultiTalkMember", "");
    ilZ = new Column("memberid", "long", "MultiTalkMember", "");
    hmw = new Column("status", "int", "MultiTalkMember", "");
    C_CREATETIME = new Column("createtime", "long", "MultiTalkMember", "");
    imc = "memberUuid".hashCode();
    ilS = "wxGroupId".hashCode();
    userName_HASHCODE = "userName".hashCode();
    ilW = "inviteUserName".hashCode();
    imd = "memberId".hashCode();
    hmC = "status".hashCode();
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
      if (imc != k) {
        break label60;
      }
      this.field_memberUuid = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ilS == k) {
        this.field_wxGroupId = paramCursor.getString(i);
      } else if (userName_HASHCODE == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (ilW == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (imd == k) {
        this.field_memberId = paramCursor.getLong(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ima) {
      localContentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
    }
    if (this.ilM) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.ilQ) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.imb) {
      localContentValues.put("memberId", Long.valueOf(this.field_memberId));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
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
    return "MultiTalkMember";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.ew
 * JD-Core Version:    0.7.0.1
 */
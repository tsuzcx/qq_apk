package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class cw
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_TYPE = new Column("type", "int", "ForceNotifyData", "");
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ForceNotifyData");
  public static final Column hSZ;
  public static final Column hVE;
  private static final int hVO = "ForcePushId".hashCode();
  private static final int hVP = "CreateTime".hashCode();
  private static final int hVQ = "ExpiredTime".hashCode();
  private static final int hVR = "Description".hashCode();
  private static final int hVS = "UserIcon".hashCode();
  private static final int hVT = "UserName".hashCode();
  private static final int hVU = "ExtInfo".hashCode();
  private static final int hVV = "Status".hashCode();
  private static final int hVW = "Type".hashCode();
  public static final Column hVm;
  public static final Column hmw;
  public static final Column hsb;
  public static final Column hvK;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_CreateTime;
  public String field_Description;
  public long field_ExpiredTime;
  public String field_ExtInfo;
  public String field_ForcePushId;
  public int field_Status;
  public int field_Type;
  public String field_UserIcon;
  public String field_UserName;
  private boolean hVF = true;
  private boolean hVG = true;
  private boolean hVH = true;
  private boolean hVI = true;
  private boolean hVJ = true;
  private boolean hVK = true;
  private boolean hVL = true;
  private boolean hVM = true;
  private boolean hVN = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ForceNotifyData", "");
    hSZ = new Column("forcepushid", "string", "ForceNotifyData", "");
    C_CREATETIME = new Column("createtime", "long", "ForceNotifyData", "");
    hVm = new Column("expiredtime", "long", "ForceNotifyData", "");
    hsb = new Column("description", "string", "ForceNotifyData", "");
    hVE = new Column("usericon", "string", "ForceNotifyData", "");
    C_USERNAME = new Column("username", "string", "ForceNotifyData", "");
    hvK = new Column("extinfo", "string", "ForceNotifyData", "");
    hmw = new Column("status", "int", "ForceNotifyData", "");
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
      if (hVO != k) {
        break label65;
      }
      this.field_ForcePushId = paramCursor.getString(i);
      this.hVF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hVP == k) {
        this.field_CreateTime = paramCursor.getLong(i);
      } else if (hVQ == k) {
        this.field_ExpiredTime = paramCursor.getLong(i);
      } else if (hVR == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (hVS == k) {
        this.field_UserIcon = paramCursor.getString(i);
      } else if (hVT == k) {
        this.field_UserName = paramCursor.getString(i);
      } else if (hVU == k) {
        this.field_ExtInfo = paramCursor.getString(i);
      } else if (hVV == k) {
        this.field_Status = paramCursor.getInt(i);
      } else if (hVW == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hVF) {
      localContentValues.put("ForcePushId", this.field_ForcePushId);
    }
    if (this.hVG) {
      localContentValues.put("CreateTime", Long.valueOf(this.field_CreateTime));
    }
    if (this.hVH) {
      localContentValues.put("ExpiredTime", Long.valueOf(this.field_ExpiredTime));
    }
    if (this.hVI) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.hVJ) {
      localContentValues.put("UserIcon", this.field_UserIcon);
    }
    if (this.hVK) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.hVL) {
      localContentValues.put("ExtInfo", this.field_ExtInfo);
    }
    if (this.hVM) {
      localContentValues.put("Status", Integer.valueOf(this.field_Status));
    }
    if (this.hVN) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
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
    return "ForceNotifyData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.cw
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class id
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fUh = "appid".hashCode();
  private static final int fkL = "token".hashCode();
  private static final int ggz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetusername = true;
  private boolean fUf = true;
  public String field_appid;
  public String field_token;
  public int field_uin;
  public String field_username;
  private boolean fkK = true;
  private boolean gfU = true;
  
  static
  {
    ggz = "uin".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "token";
    localMAutoDBInfo.colsMap.put("token", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" token TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "token";
    localMAutoDBInfo.columns[1] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "uin";
    localMAutoDBInfo.colsMap.put("uin", "INTEGER");
    localStringBuilder.append(" uin INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "appid";
    localMAutoDBInfo.colsMap.put("appid", "TEXT");
    localStringBuilder.append(" appid TEXT");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (fkL != k) {
        break label65;
      }
      this.field_token = paramCursor.getString(i);
      this.fkK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (ggz == k) {
        this.field_uin = paramCursor.getInt(i);
      } else if (fUh == k) {
        this.field_appid = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkK) {
      localContentValues.put("token", this.field_token);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.gfU) {
      localContentValues.put("uin", Integer.valueOf(this.field_uin));
    }
    if (this.fUf) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.id
 * JD-Core Version:    0.7.0.1
 */
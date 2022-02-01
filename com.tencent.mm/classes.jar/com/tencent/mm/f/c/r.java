package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class r
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandPrefetchWxaAttrsMarkTableAppIdIndex ON AppBrandPrefetchWxaAttrsMarkTable(appId)" };
  public static final SingleTable TABLE = new SingleTable("AppBrandPrefetchWxaAttrsMarkTable");
  public static final Column hnz;
  private static final int hoh = "appId".hashCode();
  public static final Column hpu;
  private static final int hpw = "prefetchUpdateTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appId;
  public long field_prefetchUpdateTime;
  public String field_username;
  private boolean hnQ = true;
  private boolean hpv = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "AppBrandPrefetchWxaAttrsMarkTable", "");
    C_USERNAME = new Column("username", "string", "AppBrandPrefetchWxaAttrsMarkTable", "");
    hnz = new Column("appid", "string", "AppBrandPrefetchWxaAttrsMarkTable", "");
    hpu = new Column("prefetchupdatetime", "long", "AppBrandPrefetchWxaAttrsMarkTable", "");
    username_HASHCODE = "username".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "prefetchUpdateTime";
    localMAutoDBInfo.colsMap.put("prefetchUpdateTime", "LONG");
    localStringBuilder.append(" prefetchUpdateTime LONG");
    localMAutoDBInfo.columns[3] = "rowid";
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
      if (username_HASHCODE != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hoh == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (hpw == k) {
        this.field_prefetchUpdateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hpv) {
      localContentValues.put("prefetchUpdateTime", Long.valueOf(this.field_prefetchUpdateTime));
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
    return "AppBrandPrefetchWxaAttrsMarkTable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.r
 * JD-Core Version:    0.7.0.1
 */
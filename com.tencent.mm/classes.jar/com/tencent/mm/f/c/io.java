package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class io
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WxaVersionTemplateIdMapping");
  public static final Column hnz;
  public static final Column hoR;
  private static final int hoZ = "appVersion".hashCode();
  private static final int hoh;
  public static final Column iNU;
  private static final int iNW = "templateId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public int field_appVersion;
  public long field_templateId;
  private boolean hnQ = true;
  private boolean hoV = true;
  private boolean iNV = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WxaVersionTemplateIdMapping", "");
    hnz = new Column("appid", "string", "WxaVersionTemplateIdMapping", "");
    hoR = new Column("appversion", "int", "WxaVersionTemplateIdMapping", "");
    iNU = new Column("templateid", "long", "WxaVersionTemplateIdMapping", "");
    hoh = "appId".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "appVersion";
    localMAutoDBInfo.colsMap.put("appVersion", "INTEGER");
    localStringBuilder.append(" appVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "templateId";
    localMAutoDBInfo.colsMap.put("templateId", "LONG");
    localStringBuilder.append(" templateId LONG");
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
      if (hoh != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hoZ == k) {
        this.field_appVersion = paramCursor.getInt(i);
      } else if (iNW == k) {
        this.field_templateId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hoV) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.iNV) {
      localContentValues.put("templateId", Long.valueOf(this.field_templateId));
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
    return "WxaVersionTemplateIdMapping";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.io
 * JD-Core Version:    0.7.0.1
 */